package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.DeniedByServerException;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.HashMap;
import java.util.UUID;
@TargetApi(18)
/* loaded from: classes.dex */
public class StreamingDrmSessionManager<T extends ExoMediaCrypto> implements DrmSession<T>, DrmSessionManager<T> {
    private static final int MSG_KEYS = 1;
    private static final int MSG_PROVISION = 0;
    public static final String PLAYREADY_CUSTOM_DATA_KEY = "PRCustomData";
    final MediaDrmCallback callback;
    private final Handler eventHandler;
    private final EventListener eventListener;
    private Exception lastException;
    private T mediaCrypto;
    private final ExoMediaDrm<T> mediaDrm;
    StreamingDrmSessionManager<T>.MediaDrmHandler mediaDrmHandler;
    private int openCount;
    private final HashMap<String, String> optionalKeyRequestParameters;
    private Looper playbackLooper;
    private Handler postRequestHandler;
    StreamingDrmSessionManager<T>.PostResponseHandler postResponseHandler;
    private boolean provisioningInProgress;
    private HandlerThread requestHandlerThread;
    private DrmInitData.SchemeData schemeData;
    private byte[] sessionId;
    private int state;
    final UUID uuid;

    /* loaded from: classes.dex */
    public interface EventListener {
        void onDrmKeysLoaded();

        void onDrmSessionManagerError(Exception exc);
    }

    public static StreamingDrmSessionManager<FrameworkMediaCrypto> newWidevineInstance(MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, Handler handler, EventListener eventListener) throws UnsupportedDrmException {
        return newFrameworkInstance(C.WIDEVINE_UUID, mediaDrmCallback, hashMap, handler, eventListener);
    }

    public static StreamingDrmSessionManager<FrameworkMediaCrypto> newPlayReadyInstance(MediaDrmCallback mediaDrmCallback, String str, Handler handler, EventListener eventListener) throws UnsupportedDrmException {
        HashMap hashMap;
        if (!TextUtils.isEmpty(str)) {
            hashMap = new HashMap();
            hashMap.put(PLAYREADY_CUSTOM_DATA_KEY, str);
        } else {
            hashMap = null;
        }
        return newFrameworkInstance(C.PLAYREADY_UUID, mediaDrmCallback, hashMap, handler, eventListener);
    }

    public static StreamingDrmSessionManager<FrameworkMediaCrypto> newFrameworkInstance(UUID uuid, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, Handler handler, EventListener eventListener) throws UnsupportedDrmException {
        return new StreamingDrmSessionManager<>(uuid, FrameworkMediaDrm.newInstance(uuid), mediaDrmCallback, hashMap, handler, eventListener);
    }

    public StreamingDrmSessionManager(UUID uuid, ExoMediaDrm<T> exoMediaDrm, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, Handler handler, EventListener eventListener) {
        this.uuid = uuid;
        this.mediaDrm = exoMediaDrm;
        this.callback = mediaDrmCallback;
        this.optionalKeyRequestParameters = hashMap;
        this.eventHandler = handler;
        this.eventListener = eventListener;
        exoMediaDrm.setOnEventListener(new MediaDrmEventListener());
        this.state = 1;
    }

    public final String getPropertyString(String str) {
        return this.mediaDrm.getPropertyString(str);
    }

    public final void setPropertyString(String str, String str2) {
        this.mediaDrm.setPropertyString(str, str2);
    }

    public final byte[] getPropertyByteArray(String str) {
        return this.mediaDrm.getPropertyByteArray(str);
    }

    public final void setPropertyByteArray(String str, byte[] bArr) {
        this.mediaDrm.setPropertyByteArray(str, bArr);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public DrmSession<T> acquireSession(Looper looper, DrmInitData drmInitData) {
        byte[] parseSchemeSpecificData;
        Assertions.checkState(this.playbackLooper == null || this.playbackLooper == looper);
        int i = this.openCount + 1;
        this.openCount = i;
        if (i == 1) {
            if (this.playbackLooper == null) {
                this.playbackLooper = looper;
                this.mediaDrmHandler = new MediaDrmHandler(looper);
                this.postResponseHandler = new PostResponseHandler(looper);
            }
            this.requestHandlerThread = new HandlerThread("DrmRequestHandler");
            this.requestHandlerThread.start();
            this.postRequestHandler = new PostRequestHandler(this.requestHandlerThread.getLooper());
            this.schemeData = drmInitData.get(this.uuid);
            if (this.schemeData == null) {
                onError(new IllegalStateException("Media does not support uuid: " + this.uuid));
            } else {
                if (Util.SDK_INT < 21 && (parseSchemeSpecificData = PsshAtomUtil.parseSchemeSpecificData(this.schemeData.data, C.WIDEVINE_UUID)) != null) {
                    this.schemeData = new DrmInitData.SchemeData(C.WIDEVINE_UUID, this.schemeData.mimeType, parseSchemeSpecificData);
                }
                this.state = 2;
                openInternal(true);
            }
        }
        return this;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public void releaseSession(DrmSession<T> drmSession) {
        int i = this.openCount - 1;
        this.openCount = i;
        if (i == 0) {
            this.state = 1;
            this.provisioningInProgress = false;
            this.mediaDrmHandler.removeCallbacksAndMessages(null);
            this.postResponseHandler.removeCallbacksAndMessages(null);
            this.postRequestHandler.removeCallbacksAndMessages(null);
            this.postRequestHandler = null;
            this.requestHandlerThread.quit();
            this.requestHandlerThread = null;
            this.schemeData = null;
            this.mediaCrypto = null;
            this.lastException = null;
            if (this.sessionId != null) {
                this.mediaDrm.closeSession(this.sessionId);
                this.sessionId = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final T getMediaCrypto() {
        if (this.state != 3 && this.state != 4) {
            throw new IllegalStateException();
        }
        return this.mediaCrypto;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean requiresSecureDecoderComponent(String str) {
        if (this.state != 3 && this.state != 4) {
            throw new IllegalStateException();
        }
        return this.mediaCrypto.requiresSecureDecoderComponent(str);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final Exception getError() {
        if (this.state == 0) {
            return this.lastException;
        }
        return null;
    }

    private void openInternal(boolean z) {
        try {
            this.sessionId = this.mediaDrm.openSession();
            this.mediaCrypto = this.mediaDrm.createMediaCrypto(this.uuid, this.sessionId);
            this.state = 3;
            postKeyRequest();
        } catch (NotProvisionedException e) {
            if (z) {
                postProvisionRequest();
            } else {
                onError(e);
            }
        } catch (Exception e2) {
            onError(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postProvisionRequest() {
        if (!this.provisioningInProgress) {
            this.provisioningInProgress = true;
            this.postRequestHandler.obtainMessage(0, this.mediaDrm.getProvisionRequest()).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProvisionResponse(Object obj) {
        this.provisioningInProgress = false;
        if (this.state == 2 || this.state == 3 || this.state == 4) {
            if (obj instanceof Exception) {
                onError((Exception) obj);
                return;
            }
            try {
                this.mediaDrm.provideProvisionResponse((byte[]) obj);
                if (this.state == 2) {
                    openInternal(false);
                } else {
                    postKeyRequest();
                }
            } catch (DeniedByServerException e) {
                onError(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postKeyRequest() {
        try {
            this.postRequestHandler.obtainMessage(1, this.mediaDrm.getKeyRequest(this.sessionId, this.schemeData.data, this.schemeData.mimeType, 1, this.optionalKeyRequestParameters)).sendToTarget();
        } catch (NotProvisionedException e) {
            onKeysError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyResponse(Object obj) {
        if (this.state == 3 || this.state == 4) {
            if (obj instanceof Exception) {
                onKeysError((Exception) obj);
                return;
            }
            try {
                this.mediaDrm.provideKeyResponse(this.sessionId, (byte[]) obj);
                this.state = 4;
                if (this.eventHandler != null && this.eventListener != null) {
                    this.eventHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.drm.StreamingDrmSessionManager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            StreamingDrmSessionManager.this.eventListener.onDrmKeysLoaded();
                        }
                    });
                }
            } catch (Exception e) {
                onKeysError(e);
            }
        }
    }

    private void onKeysError(Exception exc) {
        if (exc instanceof NotProvisionedException) {
            postProvisionRequest();
        } else {
            onError(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(final Exception exc) {
        this.lastException = exc;
        if (this.eventHandler != null && this.eventListener != null) {
            this.eventHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.drm.StreamingDrmSessionManager.2
                @Override // java.lang.Runnable
                public void run() {
                    StreamingDrmSessionManager.this.eventListener.onDrmSessionManagerError(exc);
                }
            });
        }
        if (this.state != 4) {
            this.state = 0;
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    private class MediaDrmHandler extends Handler {
        public MediaDrmHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (StreamingDrmSessionManager.this.openCount != 0) {
                if (StreamingDrmSessionManager.this.state == 3 || StreamingDrmSessionManager.this.state == 4) {
                    switch (message.what) {
                        case 1:
                            StreamingDrmSessionManager.this.state = 3;
                            StreamingDrmSessionManager.this.postProvisionRequest();
                            return;
                        case 2:
                            StreamingDrmSessionManager.this.postKeyRequest();
                            return;
                        case 3:
                            StreamingDrmSessionManager.this.state = 3;
                            StreamingDrmSessionManager.this.onError(new KeysExpiredException());
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private class MediaDrmEventListener implements ExoMediaDrm.OnEventListener<T> {
        private MediaDrmEventListener() {
        }

        @Override // com.google.android.exoplayer2.drm.ExoMediaDrm.OnEventListener
        public void onEvent(ExoMediaDrm<? extends T> exoMediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
            StreamingDrmSessionManager.this.mediaDrmHandler.sendEmptyMessage(i);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    private class PostResponseHandler extends Handler {
        public PostResponseHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    StreamingDrmSessionManager.this.onProvisionResponse(message.obj);
                    return;
                case 1:
                    StreamingDrmSessionManager.this.onKeyResponse(message.obj);
                    return;
                default:
                    return;
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    private class PostRequestHandler extends Handler {
        public PostRequestHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        e = StreamingDrmSessionManager.this.callback.executeProvisionRequest(StreamingDrmSessionManager.this.uuid, (ExoMediaDrm.ProvisionRequest) message.obj);
                        break;
                    case 1:
                        e = StreamingDrmSessionManager.this.callback.executeKeyRequest(StreamingDrmSessionManager.this.uuid, (ExoMediaDrm.KeyRequest) message.obj);
                        break;
                    default:
                        throw new RuntimeException();
                }
            } catch (Exception e) {
                e = e;
            }
            StreamingDrmSessionManager.this.postResponseHandler.obtainMessage(message.what, e).sendToTarget();
        }
    }
}

package com.pili.pldroid.player;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.facebook.appevents.AppEventsConstants;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.pili.pldroid.player.qos.c;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkLibLoader;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.MediaInfo;
/* loaded from: classes2.dex */
public class PLMediaPlayer {
    public static final int ERROR_CODE_404_NOT_FOUND = -875574520;
    public static final int ERROR_CODE_CONNECTION_REFUSED = -111;
    public static final int ERROR_CODE_CONNECTION_TIMEOUT = -110;
    public static final int ERROR_CODE_EMPTY_PLAYLIST = -541478725;
    public static final int ERROR_CODE_HW_DECODE_FAILURE = -2003;
    public static final int ERROR_CODE_INVALID_URI = -2;
    public static final int ERROR_CODE_IO_ERROR = -5;
    public static final int ERROR_CODE_PREPARE_TIMEOUT = -2001;
    public static final int ERROR_CODE_READ_FRAME_TIMEOUT = -2002;
    public static final int ERROR_CODE_STREAM_DISCONNECTED = -11;
    public static final int ERROR_CODE_UNAUTHORIZED = -825242872;
    public static final int MEDIA_ERROR_UNKNOWN = -1;
    public static final int MEDIA_INFO_AUDIO_FRAME_RENDERING = 10005;
    public static final int MEDIA_INFO_AUDIO_RENDERING_START = 10002;
    public static final int MEDIA_INFO_BUFFERING_BYTES_UPDATE = 503;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    public static final int MEDIA_INFO_SWITCHING_SW_DECODE = 802;
    public static final int MEDIA_INFO_UNKNOWN = 1;
    public static final int MEDIA_INFO_VIDEO_FRAME_RENDERING = 10004;
    public static final int MEDIA_INFO_VIDEO_GOP_TIME = 10003;
    public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
    public static final int MEDIA_INFO_VIDEO_ROTATION_CHANGED = 10001;
    private static volatile boolean d = false;
    private IMediaPlayer.OnInfoListener A;
    private IMediaPlayer.OnBufferingUpdateListener B;
    private IMediaPlayer.OnCompletionListener C;
    private IMediaPlayer.OnErrorListener D;
    private IjkMediaPlayer.OnNativeInvokeListener E;
    private OnInfoListener F;
    private OnPreparedListener G;
    private OnCompletionListener H;
    private OnBufferingUpdateListener I;
    private OnSeekCompleteListener J;
    private OnVideoSizeChangedListener K;
    private OnErrorListener L;
    private a M;

    /* renamed from: a  reason: collision with root package name */
    private Context f5001a;

    /* renamed from: b  reason: collision with root package name */
    private IjkMediaPlayer f5002b;

    /* renamed from: c  reason: collision with root package name */
    private long f5003c;
    private com.pili.pldroid.player.qos.a e;
    private b f;
    private long g;
    private long h;
    private long i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private PlayerState o;
    private String p;
    private Map<String, String> q;
    private SurfaceHolder r;
    private Surface s;
    private AVOptions t;
    private boolean u;
    private long v;
    private long w;
    private IMediaPlayer.OnVideoSizeChangedListener x;
    private IMediaPlayer.OnPreparedListener y;
    private IMediaPlayer.OnSeekCompleteListener z;

    /* loaded from: classes2.dex */
    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(PLMediaPlayer pLMediaPlayer, int i);
    }

    /* loaded from: classes2.dex */
    public interface OnCompletionListener {
        void onCompletion(PLMediaPlayer pLMediaPlayer);
    }

    /* loaded from: classes2.dex */
    public interface OnErrorListener {
        boolean onError(PLMediaPlayer pLMediaPlayer, int i);
    }

    /* loaded from: classes2.dex */
    public interface OnInfoListener {
        boolean onInfo(PLMediaPlayer pLMediaPlayer, int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface OnPreparedListener {
        void onPrepared(PLMediaPlayer pLMediaPlayer, int i);
    }

    /* loaded from: classes2.dex */
    public interface OnSeekCompleteListener {
        void onSeekComplete(PLMediaPlayer pLMediaPlayer);
    }

    /* loaded from: classes2.dex */
    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(PLMediaPlayer pLMediaPlayer, int i, int i2, int i3, int i4);
    }

    /* loaded from: classes2.dex */
    public interface a {
        void a(byte[] bArr, int i, double d, int i2, int i3, int i4, int i5);

        void a(byte[] bArr, int i, double d, int i2, int i3, int i4, int i5, int i6, int i7);
    }

    static /* synthetic */ long m(PLMediaPlayer pLMediaPlayer) {
        long j = pLMediaPlayer.g;
        pLMediaPlayer.g = 1 + j;
        return j;
    }

    public PLMediaPlayer(Context context) {
        this(context, null);
    }

    public PLMediaPlayer(Context context, AVOptions aVOptions) {
        this.f5003c = 0L;
        this.e = new com.pili.pldroid.player.qos.a();
        this.j = 0;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = true;
        this.o = PlayerState.IDLE;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = false;
        this.v = 0L;
        this.w = 0L;
        this.x = new IMediaPlayer.OnVideoSizeChangedListener() { // from class: com.pili.pldroid.player.PLMediaPlayer.4
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
                if (PLMediaPlayer.this.K != null) {
                    PLMediaPlayer.this.K.onVideoSizeChanged(PLMediaPlayer.this, i, i2, i3, i4);
                }
            }
        };
        this.y = new IMediaPlayer.OnPreparedListener() { // from class: com.pili.pldroid.player.PLMediaPlayer.5
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                int currentTimeMillis = (int) (System.currentTimeMillis() - PLMediaPlayer.this.f5003c);
                if (PLMediaPlayer.this.G != null) {
                    PLMediaPlayer.this.G.onPrepared(PLMediaPlayer.this, currentTimeMillis);
                }
                Log.d("PLMediaPlayer", "on prepared: " + currentTimeMillis + " ms");
                PLMediaPlayer.this.o = PlayerState.PREPARED;
            }
        };
        this.z = new IMediaPlayer.OnSeekCompleteListener() { // from class: com.pili.pldroid.player.PLMediaPlayer.6
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(IMediaPlayer iMediaPlayer) {
                if (PLMediaPlayer.this.J != null) {
                    PLMediaPlayer.this.J.onSeekComplete(PLMediaPlayer.this);
                }
            }
        };
        this.A = new IMediaPlayer.OnInfoListener() { // from class: com.pili.pldroid.player.PLMediaPlayer.7
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
                switch (i) {
                    case 3:
                        long currentTimeMillis = (System.currentTimeMillis() - PLMediaPlayer.this.f5003c) - PLMediaPlayer.this.w;
                        PLMediaPlayer.this.e.n = currentTimeMillis;
                        Log.d("PLMediaPlayer", "first video rendered: " + currentTimeMillis + " ms");
                        PLMediaPlayer.this.o = PlayerState.PLAYING;
                        i2 = (int) currentTimeMillis;
                        if (PLMediaPlayer.this.f != null) {
                            PLMediaPlayer.this.f.sendMessage(PLMediaPlayer.this.f.obtainMessage(0));
                            break;
                        }
                        break;
                    case 701:
                        Log.d("PLMediaPlayer", "MEDIA_INFO_BUFFERING_START");
                        PLMediaPlayer.this.o = PlayerState.BUFFERING;
                        PLMediaPlayer.this.e.f5033c = 1L;
                        PLMediaPlayer.this.i = System.currentTimeMillis();
                        break;
                    case 702:
                        Log.d("PLMediaPlayer", "MEDIA_INFO_BUFFERING_END");
                        PLMediaPlayer.this.o = PlayerState.PLAYING;
                        PLMediaPlayer.this.e.f5033c = 1L;
                        PLMediaPlayer.m(PLMediaPlayer.this);
                        PLMediaPlayer.this.h += System.currentTimeMillis() - PLMediaPlayer.this.i;
                        PLMediaPlayer.this.i = 0L;
                        break;
                    case 10002:
                        long currentTimeMillis2 = (System.currentTimeMillis() - PLMediaPlayer.this.f5003c) - PLMediaPlayer.this.w;
                        PLMediaPlayer.this.e.o = currentTimeMillis2;
                        Log.d("PLMediaPlayer", "first audio rendered: " + currentTimeMillis2 + " ms");
                        PLMediaPlayer.this.o = PlayerState.PLAYING;
                        i2 = (int) currentTimeMillis2;
                        break;
                    case 10003:
                        PLMediaPlayer.this.m = true;
                        PLMediaPlayer.this.e.p = i2;
                        break;
                }
                if (!PLMediaPlayer.this.k && PLMediaPlayer.this.m && PLMediaPlayer.this.e.n > 0 && PLMediaPlayer.this.e.o > 0) {
                    PLMediaPlayer.this.c();
                    PLMediaPlayer.this.d();
                }
                if (PLMediaPlayer.this.F != null) {
                    PLMediaPlayer.this.F.onInfo(PLMediaPlayer.this, i, i2);
                }
                return true;
            }
        };
        this.B = new IMediaPlayer.OnBufferingUpdateListener() { // from class: com.pili.pldroid.player.PLMediaPlayer.8
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
                if (PLMediaPlayer.this.I != null) {
                    PLMediaPlayer.this.I.onBufferingUpdate(PLMediaPlayer.this, i);
                }
            }
        };
        this.C = new IMediaPlayer.OnCompletionListener() { // from class: com.pili.pldroid.player.PLMediaPlayer.9
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public void onCompletion(IMediaPlayer iMediaPlayer) {
                if (PLMediaPlayer.this.H != null) {
                    PLMediaPlayer.this.H.onCompletion(PLMediaPlayer.this);
                }
                PLMediaPlayer.this.o = PlayerState.COMPLETED;
                if (!PLMediaPlayer.this.l) {
                    PLMediaPlayer.this.a(0, 0);
                }
            }
        };
        this.D = new IMediaPlayer.OnErrorListener() { // from class: com.pili.pldroid.player.PLMediaPlayer.10
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
                Log.e("PLMediaPlayer", "Error happened, what = " + i + ", errorCode = " + i2);
                if (i2 == 0) {
                    i2 = -1;
                } else if (i2 == -2003 && PLMediaPlayer.this.j == 2) {
                    PLMediaPlayer.this.j = 0;
                    PLMediaPlayer.this.t.setInteger(AVOptions.KEY_MEDIACODEC, PLMediaPlayer.this.j);
                    PLMediaPlayer.this.t.setInteger(AVOptions.KEY_START_ON_PREPARED, 1);
                    if (PLMediaPlayer.this.F != null) {
                        PLMediaPlayer.this.F.onInfo(PLMediaPlayer.this, 802, 0);
                    }
                    PLMediaPlayer.this.e();
                    return true;
                }
                PLMediaPlayer.this.o = PlayerState.ERROR;
                if (!PLMediaPlayer.this.l) {
                    PLMediaPlayer.this.a(i2, i2);
                }
                if (PLMediaPlayer.this.L != null) {
                    return PLMediaPlayer.this.L.onError(PLMediaPlayer.this, i2);
                }
                return false;
            }
        };
        this.E = new IjkMediaPlayer.OnNativeInvokeListener() { // from class: com.pili.pldroid.player.PLMediaPlayer.2

            /* renamed from: b  reason: collision with root package name */
            private final int f5007b = 196609;

            /* renamed from: c  reason: collision with root package name */
            private final int f5008c = 196610;

            @Override // tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener
            public boolean onNativeInvoke(int i, Bundle bundle) {
                if (PLMediaPlayer.this.M != null) {
                    switch (i) {
                        case 196609:
                            PLMediaPlayer.this.M.a(PLMediaPlayer.this.f5002b.getAudioData(), PLMediaPlayer.this.f5002b.getAudioSize(), PLMediaPlayer.this.f5002b.getAudioPts(), PLMediaPlayer.this.f5002b.getAudioChannel(), PLMediaPlayer.this.f5002b.getAudioChannelLayout(), PLMediaPlayer.this.f5002b.getAudioSampleRate(), PLMediaPlayer.this.f5002b.getAudioSampleFormat());
                            return true;
                        case 196610:
                            PLMediaPlayer.this.M.a(PLMediaPlayer.this.f5002b.getVideoData(), PLMediaPlayer.this.f5002b.getVideoLinesize(), PLMediaPlayer.this.f5002b.getVideoPts(), PLMediaPlayer.this.f5002b.getVideoFormat(), PLMediaPlayer.this.f5002b.getVideoPlane(), PLMediaPlayer.this.f5002b.getVideoWidth(), PLMediaPlayer.this.f5002b.getVideoHeight(), PLMediaPlayer.this.f5002b.getVideoSarNum(), PLMediaPlayer.this.f5002b.getVideoSarDen());
                            return true;
                    }
                }
                return false;
            }
        };
        this.f5001a = context.getApplicationContext();
        this.t = aVOptions;
        com.pili.pldroid.player.qos.b.a(this.f5001a);
        a(aVOptions);
        this.e.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AVOptions aVOptions) {
        this.o = PlayerState.IDLE;
        this.l = false;
        this.f5002b = new IjkMediaPlayer(new IjkLibLoader() { // from class: com.pili.pldroid.player.PLMediaPlayer.1
            @Override // tv.danmaku.ijk.media.player.IjkLibLoader
            public void loadLibrary(String str) throws UnsatisfiedLinkError, SecurityException {
                if (!PLMediaPlayer.d) {
                    Log.i("PLMediaPlayer", "load shared lib:" + SharedLibraryNameHelper.getInstance().getSharedLibraryName());
                    boolean unused = PLMediaPlayer.d = true;
                    SharedLibraryNameHelper.getInstance().a();
                    IjkMediaPlayer.native_setLogLevel(6);
                }
            }
        });
        this.f5002b.setOnPreparedListener(this.y);
        this.f5002b.setOnInfoListener(this.A);
        this.f5002b.setOnErrorListener(this.D);
        this.f5002b.setOnCompletionListener(this.C);
        this.f5002b.setOnBufferingUpdateListener(this.B);
        this.f5002b.setOnSeekCompleteListener(this.z);
        this.f5002b.setOnVideoSizeChangedListener(this.x);
        this.f5002b.setOnNativeInvokeListener(this.E);
        setAVOptions(aVOptions);
    }

    public void release() {
        if (!this.n) {
            stop();
        }
        this.f5002b.release();
        this.o = PlayerState.IDLE;
    }

    public void setDebugLoggingEnabled(boolean z) {
        if (z) {
            IjkMediaPlayer.native_setLogLevel(3);
        } else {
            IjkMediaPlayer.native_setLogLevel(6);
        }
    }

    public PlayerState getPlayerState() {
        return this.o;
    }

    public HashMap<String, String> getMetadata() {
        HashMap<String, String> hashMap = new HashMap<>();
        MediaInfo mediaInfo = this.f5002b.getMediaInfo();
        for (String str : mediaInfo.mMeta.mMediaMeta.keySet()) {
            IjkMediaMeta ijkMediaMeta = mediaInfo.mMeta;
            if (str.compareTo(IjkMediaMeta.IJKM_KEY_STREAMS) != 0) {
                try {
                    String string = mediaInfo.mMeta.mMediaMeta.getString(str);
                    if (string != null) {
                        hashMap.put(str, string);
                    }
                } catch (ClassCastException e) {
                }
            }
        }
        return hashMap;
    }

    private void a(String str, String str2) {
        if (this.u) {
            try {
                this.k = false;
                this.m = false;
                this.l = false;
                URI uri = new URI(str);
                URI uri2 = new URI(str2);
                Intent intent = new Intent("pldroid-player-qos-filter");
                intent.putExtra("pldroid-qos-msg-type", 4);
                intent.putExtra("scheme", uri.getScheme());
                intent.putExtra("domain", uri.getHost());
                intent.putExtra("remoteIp", uri2.getHost());
                intent.putExtra("path", uri.getPath());
                c.a().a(intent);
            } catch (URISyntaxException e) {
                ThrowableExtension.printStackTrace(e);
            } catch (Exception e2) {
                ThrowableExtension.printStackTrace(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            HashMap<String, String> metadata = getMetadata();
            if (metadata.containsKey("remote_ip")) {
                String str = metadata.get("remote_ip");
                if (str.length() > 0) {
                    URI uri = new URI(this.p);
                    Intent intent = new Intent("pldroid-player-qos-filter");
                    intent.putExtra("pldroid-qos-msg-type", 4);
                    intent.putExtra("scheme", uri.getScheme());
                    intent.putExtra("domain", uri.getHost());
                    intent.putExtra("remoteIp", str);
                    intent.putExtra("path", uri.getPath());
                    c.a().a(intent);
                }
            }
        } catch (URISyntaxException e) {
            ThrowableExtension.printStackTrace(e);
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.u) {
            this.k = true;
            Intent intent = new Intent("pldroid-player-qos-filter");
            intent.putExtra("pldroid-qos-msg-type", 195);
            intent.putExtra("firstVideoTime", this.e.n);
            intent.putExtra("firstAudioTime", this.e.o);
            intent.putExtra("gopTime", this.e.p);
            if (this.j == 0) {
                this.e.r = "ffmpeg";
                this.e.s = "ffmpeg";
            } else {
                this.e.r = "droid264";
                this.e.s = "droidaac";
            }
            intent.putExtra("videoDecoderType", this.e.r);
            intent.putExtra("audioDecoderType", this.e.s);
            HashMap<String, String> metadata = getMetadata();
            if (metadata.containsKey("tcp_connect_time")) {
                intent.putExtra("tcpConnectTime", Integer.parseInt(metadata.get("tcp_connect_time")));
            }
            if (metadata.containsKey("first_byte_time")) {
                intent.putExtra("firstByteTime", (int) (Long.parseLong(metadata.get("first_byte_time")) - this.f5003c));
            }
            c.a().a(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        if (this.u) {
            if (this.s != null || this.r != null) {
                this.l = true;
                Intent intent = new Intent("pldroid-player-qos-filter");
                intent.putExtra("pldroid-qos-msg-type", 196);
                intent.putExtra("beginAt", this.f5003c);
                intent.putExtra("endAt", System.currentTimeMillis());
                intent.putExtra("bufferingTotalCount", this.g);
                intent.putExtra("bufferingTotalTimes", this.h);
                intent.putExtra("totalRecvBytes", this.e.q);
                intent.putExtra("endBufferingTime", (int) (this.i > 0 ? System.currentTimeMillis() - this.i : this.i));
                intent.putExtra("gopTime", this.e.p);
                intent.putExtra("errorCode", i);
                intent.putExtra("errorOSCode", i2);
                HashMap<String, String> metadata = getMetadata();
                if (metadata.containsKey("tcp_connect_time")) {
                    intent.putExtra("tcpConnectTime", Integer.parseInt(metadata.get("tcp_connect_time")));
                }
                if (metadata.containsKey("rtmp_connect_time")) {
                    intent.putExtra("rtmpConnectTime", Integer.parseInt(metadata.get("rtmp_connect_time")));
                }
                if (metadata.containsKey("first_byte_time")) {
                    intent.putExtra("firstByteTime", (int) (Long.parseLong(metadata.get("first_byte_time")) - this.f5003c));
                }
                c.a().a(intent);
            }
        }
    }

    private void setAVOptions(AVOptions aVOptions) {
        if (aVOptions != null) {
            this.f5002b.setOption(4, "framedrop", 12L);
            this.f5002b.setOption(4, AVOptions.KEY_START_ON_PREPARED, 1L);
            this.f5002b.setOption(1, "http-detect-range-support", 0L);
            this.f5002b.setOption(2, "skip_loop_filter", 0L);
            this.f5002b.setOption(4, "overlay-format", 842225234L);
            this.f5002b.setOption(4, AVOptions.KEY_START_ON_PREPARED, aVOptions.getInteger(AVOptions.KEY_START_ON_PREPARED, 1));
            this.u = false;
            if (aVOptions.containsKey(AVOptions.KEY_LIVE_STREAMING) && aVOptions.getInteger(AVOptions.KEY_LIVE_STREAMING) != 0) {
                this.u = true;
                if (!aVOptions.containsKey(AVOptions.KEY_RTMP_LIVE) || aVOptions.getInteger(AVOptions.KEY_RTMP_LIVE) == 1) {
                    this.f5002b.setOption(1, AVOptions.KEY_RTMP_LIVE, 1L);
                }
                this.f5002b.setOption(1, AVOptions.KEY_BUFFER_TIME, aVOptions.containsKey(AVOptions.KEY_BUFFER_TIME) ? aVOptions.getInteger(AVOptions.KEY_BUFFER_TIME) : 1000L);
                if (aVOptions.containsKey(AVOptions.KEY_PREPARE_TIMEOUT)) {
                    this.f5002b.setOption(1, AVOptions.KEY_PREPARE_TIMEOUT, aVOptions.getInteger(AVOptions.KEY_PREPARE_TIMEOUT) * 1000);
                }
                this.f5002b.setOption(2, "threads", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            }
            this.f5002b.setOption(1, "analyzeduration", aVOptions.containsKey("analyzeduration") ? aVOptions.getInteger("analyzeduration") : 0L);
            this.f5002b.setOption(1, AVOptions.KEY_PROBESIZE, aVOptions.containsKey(AVOptions.KEY_PROBESIZE) ? aVOptions.getInteger(AVOptions.KEY_PROBESIZE) : 131072L);
            this.f5002b.setOption(4, AVOptions.KEY_LIVE_STREAMING, this.u ? 1 : 0);
            this.f5002b.setOption(4, AVOptions.KEY_GET_AV_FRAME_TIMEOUT, aVOptions.containsKey(AVOptions.KEY_GET_AV_FRAME_TIMEOUT) ? aVOptions.getInteger(AVOptions.KEY_GET_AV_FRAME_TIMEOUT) * 1000 : 10000000L);
            this.j = aVOptions.containsKey(AVOptions.KEY_MEDIACODEC) ? aVOptions.getInteger(AVOptions.KEY_MEDIACODEC) : 0;
            this.f5002b.setOption(4, AVOptions.KEY_MEDIACODEC, this.j == 0 ? 0L : 1L);
            this.f5002b.setOption(4, "mediacodec-handle-resolution-change", aVOptions.containsKey("mediacodec-handle-resolution-change") ? aVOptions.getInteger("mediacodec-handle-resolution-change") : 1L);
            this.f5002b.setOption(4, AVOptions.KEY_DELAY_OPTIMIZATION, aVOptions.containsKey(AVOptions.KEY_DELAY_OPTIMIZATION) ? aVOptions.getInteger(AVOptions.KEY_DELAY_OPTIMIZATION) : 0L);
            this.f5002b.setOption(4, AVOptions.KEY_CACHE_BUFFER_DURATION, aVOptions.containsKey(AVOptions.KEY_CACHE_BUFFER_DURATION) ? aVOptions.getInteger(AVOptions.KEY_CACHE_BUFFER_DURATION) : 2000L);
            this.f5002b.setOption(4, AVOptions.KEY_MAX_CACHE_BUFFER_DURATION, aVOptions.containsKey(AVOptions.KEY_MAX_CACHE_BUFFER_DURATION) ? aVOptions.getInteger(AVOptions.KEY_MAX_CACHE_BUFFER_DURATION) : 4000L);
            this.f5002b.setOption(1, AVOptions.KEY_RECONNECT, aVOptions.containsKey(AVOptions.KEY_RECONNECT) ? aVOptions.getInteger(AVOptions.KEY_RECONNECT) : 1L);
            this.f5002b.setOption(4, AVOptions.KEY_AUDIO_RENDER_MSG, aVOptions.containsKey(AVOptions.KEY_AUDIO_RENDER_MSG) ? aVOptions.getInteger(AVOptions.KEY_AUDIO_RENDER_MSG) : 0L);
            this.f5002b.setOption(4, AVOptions.KEY_VIDEO_RENDER_MSG, aVOptions.containsKey(AVOptions.KEY_VIDEO_RENDER_MSG) ? aVOptions.getInteger(AVOptions.KEY_VIDEO_RENDER_MSG) : 0L);
            this.f5002b.setOption(4, AVOptions.KEY_VIDEO_DISPLAY_DISABLE, aVOptions.containsKey(AVOptions.KEY_VIDEO_DISPLAY_DISABLE) ? aVOptions.getInteger(AVOptions.KEY_VIDEO_DISPLAY_DISABLE) : 0L);
        }
    }

    public boolean a() {
        return this.u;
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.f5002b.setDisplay(surfaceHolder);
        this.r = surfaceHolder;
    }

    public void setSurface(Surface surface) {
        this.f5002b.setSurface(surface);
        this.s = surface;
    }

    public void setWakeMode(Context context, int i) {
        this.f5002b.setWakeMode(context, i);
    }

    public void setScreenOnWhilePlaying(boolean z) {
        this.f5002b.setScreenOnWhilePlaying(z);
    }

    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(context, uri, null);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        Uri a2 = PLNetworkManager.getInstance().a(uri);
        a(uri.toString(), a2.toString());
        if (Build.VERSION.SDK_INT > 14) {
            this.f5002b.setDataSource(context, a2, map);
            this.q = map;
        } else {
            this.f5002b.setDataSource(a2.toString());
        }
        this.p = uri.toString();
    }

    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        String a2 = PLNetworkManager.getInstance().a(str);
        a(str, a2);
        this.f5002b.setDataSource(a2);
        this.p = str;
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        this.f5002b.setDataSource(fileDescriptor);
    }

    public String getDataSource() {
        return this.f5002b.getDataSource();
    }

    public void prepareAsync() throws IllegalStateException {
        String dataSource = getDataSource();
        if (dataSource != null && dataSource.contains(".m3u8")) {
            this.f5002b.setOption(4, AVOptions.KEY_DELAY_OPTIMIZATION, 0L);
        }
        this.o = PlayerState.PREPARING;
        this.f5002b.prepareAsync();
        this.f5003c = System.currentTimeMillis();
        this.v = 0L;
        this.w = 0L;
        this.h = 0L;
        this.g = 0L;
        this.n = true;
        this.k = false;
        this.l = false;
        this.m = false;
        HandlerThread handlerThread = new HandlerThread("PlayerHt");
        handlerThread.start();
        this.f = new b(handlerThread.getLooper(), this);
    }

    public void setVolume(float f, float f2) {
        this.f5002b.setVolume(f, f2);
    }

    public void start() throws IllegalStateException {
        this.f5002b.start();
        if (this.v > this.f5003c) {
            this.w += System.currentTimeMillis() - this.v;
        }
    }

    public void pause() throws IllegalStateException {
        this.f5002b.pause();
        this.o = PlayerState.PAUSED;
        this.v = System.currentTimeMillis();
    }

    public void stop() throws IllegalStateException {
        if (!this.l) {
            this.e.q = this.f5002b.getPktTotalSize();
            a(0, 0);
        }
        this.f5002b.stop();
        com.pili.pldroid.player.qos.b.b(this.f5001a);
        if (this.f != null) {
            this.f.removeCallbacksAndMessages(null);
            this.f.a();
        }
        this.n = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.pili.pldroid.player.PLMediaPlayer.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    PLMediaPlayer.this.f5002b.stop();
                    PLMediaPlayer.this.f5002b.release();
                    PLMediaPlayer.this.a(PLMediaPlayer.this.t);
                    if (PLMediaPlayer.this.q == null) {
                        PLMediaPlayer.this.f5002b.setDataSource(PLMediaPlayer.this.p);
                    } else {
                        PLMediaPlayer.this.f5002b.setDataSource(PLMediaPlayer.this.p, PLMediaPlayer.this.q);
                    }
                    if (PLMediaPlayer.this.r != null) {
                        PLMediaPlayer.this.f5002b.setDisplay(PLMediaPlayer.this.r);
                    } else if (PLMediaPlayer.this.s != null) {
                        PLMediaPlayer.this.f5002b.setSurface(PLMediaPlayer.this.s);
                    }
                    PLMediaPlayer.this.f5002b.prepareAsync();
                } catch (IOException e) {
                    ThrowableExtension.printStackTrace(e);
                    PLMediaPlayer.this.f();
                } catch (Exception e2) {
                    ThrowableExtension.printStackTrace(e2);
                    PLMediaPlayer.this.f();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.L != null) {
            this.L.onError(this, -1);
        }
    }

    public void seekTo(long j) throws IllegalStateException {
        this.f5002b.seekTo(j);
    }

    public void reset() {
        this.f5002b.reset();
    }

    public int getVideoWidth() {
        return this.f5002b.getVideoWidth();
    }

    public String getResolutionInline() {
        if (this.f5002b == null) {
            return null;
        }
        try {
            return this.f5002b.getMediaInfo().mMeta.mVideoStream.getResolutionInline();
        } catch (Exception e) {
            return null;
        }
    }

    public int getVideoHeight() {
        return this.f5002b.getVideoHeight();
    }

    public long getVideoBitrate() {
        return this.f5002b.getBitrateVideo();
    }

    public int getVideoFps() {
        return (int) this.f5002b.getVideoOutputFramesPerSecond();
    }

    public boolean isPlaying() {
        return this.f5002b.isPlaying();
    }

    public long getCurrentPosition() {
        return this.f5002b.getCurrentPosition();
    }

    public long getDuration() {
        return this.f5002b.getDuration();
    }

    public void setLooping(boolean z) {
        this.f5002b.setLooping(z);
    }

    public boolean isLooping() {
        return this.f5002b.isLooping();
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.F = onInfoListener;
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.G = onPreparedListener;
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.H = onCompletionListener;
    }

    public void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener) {
        this.I = onBufferingUpdateListener;
    }

    public void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener) {
        this.J = onSeekCompleteListener;
    }

    public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.K = onVideoSizeChangedListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.L = onErrorListener;
    }

    public void setOnMediaDataListener(a aVar) {
        this.M = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.e != null && this.f5002b != null) {
            this.e.d = (int) this.f5002b.getSourcFpsVideo();
            this.e.e = (int) this.f5002b.getFramesDroppedVideo();
            this.e.f = (int) this.f5002b.getSourcFpsAudio();
            this.e.g = (int) this.f5002b.getFramesDroppedAudio();
            this.e.h = (int) this.f5002b.getVideoOutputFramesPerSecond();
            this.e.i = (int) this.f5002b.getRenderFpsAudio();
            this.e.j = (int) this.f5002b.getBufferTimeVideo();
            this.e.k = (int) this.f5002b.getBufferTimeAudio();
            this.e.l = this.f5002b.getBitrateVideo();
            this.e.m = this.f5002b.getBitrateAudio();
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<PLMediaPlayer> f5016a;

        public b(Looper looper, PLMediaPlayer pLMediaPlayer) {
            super(looper);
            this.f5016a = new WeakReference<>(pLMediaPlayer);
        }

        public void a() {
            getLooper().quit();
            this.f5016a.clear();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            PLMediaPlayer pLMediaPlayer = this.f5016a.get();
            if (pLMediaPlayer != null && pLMediaPlayer.e != null) {
                switch (message.what) {
                    case 0:
                        pLMediaPlayer.g();
                        com.pili.pldroid.player.qos.a aVar = pLMediaPlayer.e;
                        aVar.f5032b = System.currentTimeMillis();
                        Intent intent = new Intent("pldroid-player-qos-filter");
                        intent.putExtra("pldroid-qos-msg-type", 193);
                        intent.putExtra("beginAt", aVar.f5031a);
                        intent.putExtra("endAt", aVar.f5032b);
                        intent.putExtra("bufferingTimes", aVar.f5033c);
                        intent.putExtra("videoSourceFps", aVar.d);
                        intent.putExtra("dropVideoFrames", aVar.e);
                        intent.putExtra("audioSourceFps", aVar.f);
                        intent.putExtra("audioDropFrames", aVar.g);
                        intent.putExtra("videoRenderFps", aVar.h);
                        intent.putExtra("audioRenderFps", aVar.i);
                        intent.putExtra("videoBufferTime", aVar.j);
                        intent.putExtra("audioBufferTime", aVar.k);
                        intent.putExtra("videoBitrate", aVar.l);
                        intent.putExtra("audioBitrate", aVar.m);
                        if (aVar.p > 0 && aVar.f5031a > 0) {
                            c.a().a(intent);
                        }
                        aVar.f5031a = System.currentTimeMillis();
                        pLMediaPlayer.e.a();
                        sendMessageDelayed(obtainMessage(0), c.a().b());
                        return;
                    default:
                        return;
                }
            }
            Log.w("PLMediaPlayer", "MuxerHandler.handleMessage: muxer is null");
        }
    }
}

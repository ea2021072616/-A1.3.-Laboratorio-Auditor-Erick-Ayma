package com.fotoable.youtube.music.ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.RawRes;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import com.fotoable.youtube.music.util.b;
import java.io.IOException;
@TargetApi(14)
/* loaded from: classes.dex */
public class TextureVideoView extends ScalableTextureView implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, Handler.Callback, TextureView.SurfaceTextureListener {
    private static final int MSG_PAUSE = 4;
    private static final int MSG_RESUME = 2;
    private static final int MSG_START = 1;
    private static final int MSG_STOP = 6;
    private static final int STATE_ERROR = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PAUSED = 4;
    private static final int STATE_PLAYBACK_COMPLETED = 5;
    private static final int STATE_PLAYING = 3;
    private static final int STATE_PREPARED = 2;
    private static final int STATE_PREPARING = 1;
    private static final String TAG = "MyTextureVideoView";
    private static final HandlerThread sThread = new HandlerThread("VideoPlayThread");
    private AudioManager mAudioManager;
    private Context mContext;
    private volatile int mCurrentState;
    private Handler mHandler;
    private boolean mHasAudio;
    private MediaPlayer mMediaPlayer;
    private MediaPlayerCallback mMediaPlayerCallback;
    private boolean mSoundMute;
    private Surface mSurface;
    private volatile int mTargetState;
    private Handler mVideoHandler;
    @RawRes
    private int rawID;

    /* loaded from: classes.dex */
    public interface MediaPlayerCallback {
        void onBufferingUpdate(MediaPlayer mediaPlayer, int i);

        void onCompletion(MediaPlayer mediaPlayer);

        boolean onError(MediaPlayer mediaPlayer, int i, int i2);

        boolean onInfo(MediaPlayer mediaPlayer, int i, int i2);

        void onPrepared(MediaPlayer mediaPlayer);

        void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2);
    }

    static {
        sThread.start();
    }

    /* loaded from: classes.dex */
    public static class MediaPlayerCallbackAdapter implements MediaPlayerCallback {
        @Override // com.fotoable.youtube.music.ui.view.TextureVideoView.MediaPlayerCallback
        public void onPrepared(MediaPlayer mediaPlayer) {
        }

        @Override // com.fotoable.youtube.music.ui.view.TextureVideoView.MediaPlayerCallback
        public void onCompletion(MediaPlayer mediaPlayer) {
        }

        @Override // com.fotoable.youtube.music.ui.view.TextureVideoView.MediaPlayerCallback
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        }

        @Override // com.fotoable.youtube.music.ui.view.TextureVideoView.MediaPlayerCallback
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        }

        @Override // com.fotoable.youtube.music.ui.view.TextureVideoView.MediaPlayerCallback
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            return false;
        }

        @Override // com.fotoable.youtube.music.ui.view.TextureVideoView.MediaPlayerCallback
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            return false;
        }
    }

    public TextureVideoView(Context context) {
        super(context);
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.rawID = -1;
        init();
    }

    public TextureVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.rawID = -1;
        init();
    }

    public TextureVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.rawID = -1;
        init();
    }

    public void setMediaPlayerCallback(MediaPlayerCallback mediaPlayerCallback) {
        this.mMediaPlayerCallback = mediaPlayerCallback;
        if (mediaPlayerCallback == null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        synchronized (TextureVideoView.class) {
            switch (message.what) {
                case 1:
                    openVideo();
                    break;
                case 2:
                    if (this.mCurrentState == 4) {
                        this.mMediaPlayer.start();
                        this.mCurrentState = 3;
                        break;
                    }
                    break;
                case 4:
                    if (this.mMediaPlayer != null) {
                        this.mMediaPlayer.pause();
                    }
                    this.mCurrentState = 4;
                    break;
                case 6:
                    release(true);
                    break;
            }
        }
        return true;
    }

    private void init() {
        this.mContext = getContext();
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mVideoHandler = new Handler(sThread.getLooper(), this);
        setSurfaceTextureListener(this);
    }

    private void release(boolean z) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.release();
            this.mMediaPlayer.setOnPreparedListener(null);
            this.mMediaPlayer.setOnVideoSizeChangedListener(null);
            this.mMediaPlayer.setOnCompletionListener(null);
            this.mMediaPlayer.setOnErrorListener(null);
            this.mMediaPlayer.setOnInfoListener(null);
            this.mMediaPlayer.setOnBufferingUpdateListener(null);
            this.mMediaPlayer = null;
            this.mCurrentState = 0;
            if (z) {
                this.mTargetState = 0;
            }
        }
    }

    public void setRawData(@RawRes int i) throws IOException {
        this.rawID = i;
    }

    private void openVideo() {
        if (this.rawID != -1 && this.mSurface != null) {
            this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
            release(false);
            try {
                this.mMediaPlayer = new MediaPlayer();
                this.mMediaPlayer.setOnPreparedListener(this);
                this.mMediaPlayer.setOnVideoSizeChangedListener(this);
                this.mMediaPlayer.setOnCompletionListener(this);
                this.mMediaPlayer.setOnErrorListener(this);
                this.mMediaPlayer.setOnInfoListener(this);
                this.mMediaPlayer.setOnBufferingUpdateListener(this);
                AssetFileDescriptor openRawResourceFd = getResources().openRawResourceFd(this.rawID);
                this.mMediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                this.mMediaPlayer.setSurface(this.mSurface);
                this.mMediaPlayer.setAudioStreamType(5);
                this.mMediaPlayer.setLooping(true);
                this.mMediaPlayer.prepareAsync();
                this.mCurrentState = 1;
                this.mTargetState = 1;
            } catch (Exception e) {
                this.mCurrentState = -1;
                this.mTargetState = -1;
                b.b("Dev_特效播放异常", "原因", e.getMessage());
                if (this.mMediaPlayerCallback != null) {
                    this.mHandler.post(new Runnable(this) { // from class: com.fotoable.youtube.music.ui.view.TextureVideoView$$Lambda$0
                        private final TextureVideoView arg$1;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.arg$1 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            this.arg$1.lambda$openVideo$0$TextureVideoView();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$openVideo$0$TextureVideoView() {
        if (this.mMediaPlayerCallback != null) {
            this.mMediaPlayerCallback.onError(this.mMediaPlayer, 1, 0);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.mSurface = new Surface(surfaceTexture);
        if (this.mTargetState == 3) {
            start();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.mSurface = null;
        stop();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void start() {
        this.mTargetState = 3;
        if (isInPlaybackState()) {
            this.mVideoHandler.obtainMessage(6).sendToTarget();
        }
        if (this.rawID != -1 && this.mSurface != null) {
            this.mVideoHandler.obtainMessage(1).sendToTarget();
        }
    }

    public void pause() {
        this.mTargetState = 4;
        if (isPlaying()) {
            this.mVideoHandler.obtainMessage(4).sendToTarget();
        }
    }

    public void resume() {
        this.mTargetState = 3;
        if (!isPlaying()) {
            this.mVideoHandler.obtainMessage(2).sendToTarget();
        }
    }

    public void stop() {
        this.mTargetState = 5;
        if (isInPlaybackState()) {
            this.mVideoHandler.obtainMessage(6).sendToTarget();
        }
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.mMediaPlayer.isPlaying();
    }

    public void mute() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setVolume(0.0f, 0.0f);
            this.mSoundMute = true;
        }
    }

    public void unMute() {
        if (this.mAudioManager != null && this.mMediaPlayer != null) {
            float log = (float) (1.0d - (0.0d / Math.log(100)));
            this.mMediaPlayer.setVolume(log, log);
            this.mSoundMute = false;
        }
    }

    public boolean isMute() {
        return this.mSoundMute;
    }

    public boolean isHasAudio() {
        return this.mHasAudio;
    }

    private boolean isInPlaybackState() {
        return (this.mMediaPlayer == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(final MediaPlayer mediaPlayer) {
        this.mCurrentState = 5;
        this.mTargetState = 5;
        if (this.mMediaPlayerCallback != null) {
            this.mHandler.post(new Runnable(this, mediaPlayer) { // from class: com.fotoable.youtube.music.ui.view.TextureVideoView$$Lambda$1
                private final TextureVideoView arg$1;
                private final MediaPlayer arg$2;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.arg$1 = this;
                    this.arg$2 = mediaPlayer;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.arg$1.lambda$onCompletion$1$TextureVideoView(this.arg$2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$onCompletion$1$TextureVideoView(MediaPlayer mediaPlayer) {
        if (this.mMediaPlayerCallback != null) {
            this.mMediaPlayerCallback.onCompletion(mediaPlayer);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(final MediaPlayer mediaPlayer, final int i, final int i2) {
        this.mCurrentState = -1;
        this.mTargetState = -1;
        if (this.mMediaPlayerCallback != null) {
            this.mHandler.post(new Runnable(this, mediaPlayer, i, i2) { // from class: com.fotoable.youtube.music.ui.view.TextureVideoView$$Lambda$2
                private final TextureVideoView arg$1;
                private final MediaPlayer arg$2;
                private final int arg$3;
                private final int arg$4;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.arg$1 = this;
                    this.arg$2 = mediaPlayer;
                    this.arg$3 = i;
                    this.arg$4 = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.arg$1.lambda$onError$2$TextureVideoView(this.arg$2, this.arg$3, this.arg$4);
                }
            });
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$onError$2$TextureVideoView(MediaPlayer mediaPlayer, int i, int i2) {
        if (this.mMediaPlayerCallback != null) {
            this.mMediaPlayerCallback.onError(mediaPlayer, i, i2);
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(final MediaPlayer mediaPlayer) {
        if (this.mTargetState == 1 && this.mCurrentState == 1) {
            this.mCurrentState = 2;
            if (isInPlaybackState()) {
                mute();
                this.mMediaPlayer.start();
                this.mCurrentState = 3;
                this.mTargetState = 3;
            }
            if (this.mMediaPlayerCallback != null) {
                this.mHandler.post(new Runnable(this, mediaPlayer) { // from class: com.fotoable.youtube.music.ui.view.TextureVideoView$$Lambda$3
                    private final TextureVideoView arg$1;
                    private final MediaPlayer arg$2;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.arg$1 = this;
                        this.arg$2 = mediaPlayer;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.arg$1.lambda$onPrepared$3$TextureVideoView(this.arg$2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$onPrepared$3$TextureVideoView(MediaPlayer mediaPlayer) {
        if (this.mMediaPlayerCallback != null) {
            this.mMediaPlayerCallback.onPrepared(mediaPlayer);
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(final MediaPlayer mediaPlayer, final int i, final int i2) {
        if (this.mMediaPlayerCallback != null) {
            this.mHandler.post(new Runnable(this, mediaPlayer, i, i2) { // from class: com.fotoable.youtube.music.ui.view.TextureVideoView$$Lambda$4
                private final TextureVideoView arg$1;
                private final MediaPlayer arg$2;
                private final int arg$3;
                private final int arg$4;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.arg$1 = this;
                    this.arg$2 = mediaPlayer;
                    this.arg$3 = i;
                    this.arg$4 = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.arg$1.lambda$onVideoSizeChanged$4$TextureVideoView(this.arg$2, this.arg$3, this.arg$4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$onVideoSizeChanged$4$TextureVideoView(MediaPlayer mediaPlayer, int i, int i2) {
        if (this.mMediaPlayerCallback != null) {
            this.mMediaPlayerCallback.onVideoSizeChanged(mediaPlayer, i, i2);
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(final MediaPlayer mediaPlayer, final int i) {
        if (this.mMediaPlayerCallback != null) {
            this.mHandler.post(new Runnable(this, mediaPlayer, i) { // from class: com.fotoable.youtube.music.ui.view.TextureVideoView$$Lambda$5
                private final TextureVideoView arg$1;
                private final MediaPlayer arg$2;
                private final int arg$3;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.arg$1 = this;
                    this.arg$2 = mediaPlayer;
                    this.arg$3 = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.arg$1.lambda$onBufferingUpdate$5$TextureVideoView(this.arg$2, this.arg$3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$onBufferingUpdate$5$TextureVideoView(MediaPlayer mediaPlayer, int i) {
        if (this.mMediaPlayerCallback != null) {
            this.mMediaPlayerCallback.onBufferingUpdate(mediaPlayer, i);
        }
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(final MediaPlayer mediaPlayer, final int i, final int i2) {
        if (this.mMediaPlayerCallback != null) {
            this.mHandler.post(new Runnable(this, mediaPlayer, i, i2) { // from class: com.fotoable.youtube.music.ui.view.TextureVideoView$$Lambda$6
                private final TextureVideoView arg$1;
                private final MediaPlayer arg$2;
                private final int arg$3;
                private final int arg$4;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.arg$1 = this;
                    this.arg$2 = mediaPlayer;
                    this.arg$3 = i;
                    this.arg$4 = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.arg$1.lambda$onInfo$6$TextureVideoView(this.arg$2, this.arg$3, this.arg$4);
                }
            });
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$onInfo$6$TextureVideoView(MediaPlayer mediaPlayer, int i, int i2) {
        if (this.mMediaPlayerCallback != null) {
            this.mMediaPlayerCallback.onInfo(mediaPlayer, i, i2);
        }
    }
}

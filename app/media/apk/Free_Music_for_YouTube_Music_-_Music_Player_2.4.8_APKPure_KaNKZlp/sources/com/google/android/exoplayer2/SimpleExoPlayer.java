package com.google.android.exoplayer2;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.PlaybackParams;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.MediaCodecAudioRenderer;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.trackselection.TrackSelections;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.util.ArrayList;
import java.util.List;
@TargetApi(16)
/* loaded from: classes.dex */
public final class SimpleExoPlayer implements ExoPlayer {
    private static final int MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY = 50;
    private static final String TAG = "SimpleExoPlayer";
    private AudioRendererEventListener audioDebugListener;
    private DecoderCounters audioDecoderCounters;
    private Format audioFormat;
    private final int audioRendererCount;
    private int audioSessionId;
    private MetadataRenderer.Output<List<Id3Frame>> id3Output;
    private boolean ownsSurface;
    private PlaybackParamsHolder playbackParamsHolder;
    private final ExoPlayer player;
    private final Renderer[] renderers;
    private Surface surface;
    private SurfaceHolder surfaceHolder;
    private TextRenderer.Output textOutput;
    private TextureView textureView;
    private VideoRendererEventListener videoDebugListener;
    private DecoderCounters videoDecoderCounters;
    private Format videoFormat;
    private VideoListener videoListener;
    private final int videoRendererCount;
    private boolean videoTracksEnabled;
    private float volume;
    private final Handler mainHandler = new Handler();
    private final ComponentListener componentListener = new ComponentListener();

    /* loaded from: classes.dex */
    public interface VideoListener {
        void onRenderedFirstFrame();

        void onVideoSizeChanged(int i, int i2, int i3, float f);

        void onVideoTracksDisabled();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleExoPlayer(Context context, TrackSelector<?> trackSelector, LoadControl loadControl, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, long j) {
        trackSelector.addListener(this.componentListener);
        ArrayList<Renderer> arrayList = new ArrayList<>();
        if (z) {
            buildExtensionRenderers(arrayList, j);
            buildRenderers(context, drmSessionManager, arrayList, j);
        } else {
            buildRenderers(context, drmSessionManager, arrayList, j);
            buildExtensionRenderers(arrayList, j);
        }
        this.renderers = (Renderer[]) arrayList.toArray(new Renderer[arrayList.size()]);
        int i = 0;
        int i2 = 0;
        for (Renderer renderer : this.renderers) {
            switch (renderer.getTrackType()) {
                case 1:
                    i++;
                    break;
                case 2:
                    i2++;
                    break;
            }
        }
        this.videoRendererCount = i2;
        this.audioRendererCount = i;
        this.audioSessionId = 0;
        this.volume = 1.0f;
        this.player = new ExoPlayerImpl(this.renderers, trackSelector, loadControl);
    }

    public int getRendererCount() {
        return this.renderers.length;
    }

    public int getRendererType(int i) {
        return this.renderers[i].getTrackType();
    }

    public void clearVideoSurface() {
        setVideoSurface(null);
    }

    public void setVideoSurface(Surface surface) {
        removeSurfaceCallbacks();
        setVideoSurfaceInternal(surface, false);
    }

    public void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        removeSurfaceCallbacks();
        this.surfaceHolder = surfaceHolder;
        if (surfaceHolder == null) {
            setVideoSurfaceInternal(null, false);
            return;
        }
        setVideoSurfaceInternal(surfaceHolder.getSurface(), false);
        surfaceHolder.addCallback(this.componentListener);
    }

    public void setVideoSurfaceView(SurfaceView surfaceView) {
        setVideoSurfaceHolder(surfaceView.getHolder());
    }

    public void setVideoTextureView(TextureView textureView) {
        removeSurfaceCallbacks();
        this.textureView = textureView;
        if (textureView == null) {
            setVideoSurfaceInternal(null, true);
            return;
        }
        if (textureView.getSurfaceTextureListener() != null) {
            Log.w(TAG, "Replacing existing SurfaceTextureListener.");
        }
        SurfaceTexture surfaceTexture = textureView.getSurfaceTexture();
        setVideoSurfaceInternal(surfaceTexture != null ? new Surface(surfaceTexture) : null, true);
        textureView.setSurfaceTextureListener(this.componentListener);
    }

    public void setVolume(float f) {
        int i;
        this.volume = f;
        ExoPlayer.ExoPlayerMessage[] exoPlayerMessageArr = new ExoPlayer.ExoPlayerMessage[this.audioRendererCount];
        Renderer[] rendererArr = this.renderers;
        int length = rendererArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            Renderer renderer = rendererArr[i2];
            if (renderer.getTrackType() == 1) {
                i = i3 + 1;
                exoPlayerMessageArr[i3] = new ExoPlayer.ExoPlayerMessage(renderer, 2, Float.valueOf(f));
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        this.player.sendMessages(exoPlayerMessageArr);
    }

    public float getVolume() {
        return this.volume;
    }

    @TargetApi(23)
    public void setPlaybackParams(PlaybackParams playbackParams) {
        int i;
        if (playbackParams != null) {
            playbackParams.allowDefaults();
            this.playbackParamsHolder = new PlaybackParamsHolder(playbackParams);
        } else {
            this.playbackParamsHolder = null;
        }
        ExoPlayer.ExoPlayerMessage[] exoPlayerMessageArr = new ExoPlayer.ExoPlayerMessage[this.audioRendererCount];
        Renderer[] rendererArr = this.renderers;
        int length = rendererArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            Renderer renderer = rendererArr[i2];
            if (renderer.getTrackType() == 1) {
                i = i3 + 1;
                exoPlayerMessageArr[i3] = new ExoPlayer.ExoPlayerMessage(renderer, 3, playbackParams);
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        this.player.sendMessages(exoPlayerMessageArr);
    }

    @TargetApi(23)
    public PlaybackParams getPlaybackParams() {
        if (this.playbackParamsHolder == null) {
            return null;
        }
        return this.playbackParamsHolder.params;
    }

    public Format getVideoFormat() {
        return this.videoFormat;
    }

    public Format getAudioFormat() {
        return this.audioFormat;
    }

    public int getAudioSessionId() {
        return this.audioSessionId;
    }

    public DecoderCounters getVideoDecoderCounters() {
        return this.videoDecoderCounters;
    }

    public DecoderCounters getAudioDecoderCounters() {
        return this.audioDecoderCounters;
    }

    public void setVideoListener(VideoListener videoListener) {
        this.videoListener = videoListener;
    }

    public void setVideoDebugListener(VideoRendererEventListener videoRendererEventListener) {
        this.videoDebugListener = videoRendererEventListener;
    }

    public void setAudioDebugListener(AudioRendererEventListener audioRendererEventListener) {
        this.audioDebugListener = audioRendererEventListener;
    }

    public void setTextOutput(TextRenderer.Output output) {
        this.textOutput = output;
    }

    public void setId3Output(MetadataRenderer.Output<List<Id3Frame>> output) {
        this.id3Output = output;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addListener(ExoPlayer.EventListener eventListener) {
        this.player.addListener(eventListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void removeListener(ExoPlayer.EventListener eventListener) {
        this.player.removeListener(eventListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public int getPlaybackState() {
        return this.player.getPlaybackState();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void prepare(MediaSource mediaSource) {
        this.player.prepare(mediaSource);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void prepare(MediaSource mediaSource, boolean z, boolean z2) {
        this.player.prepare(mediaSource, z, z2);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setPlayWhenReady(boolean z) {
        this.player.setPlayWhenReady(z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public boolean getPlayWhenReady() {
        return this.player.getPlayWhenReady();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public boolean isLoading() {
        return this.player.isLoading();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void seekToDefaultPosition() {
        this.player.seekToDefaultPosition();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void seekToDefaultPosition(int i) {
        this.player.seekToDefaultPosition(i);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void seekTo(long j) {
        this.player.seekTo(j);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void seekTo(int i, long j) {
        this.player.seekTo(i, j);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void stop() {
        this.player.stop();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void release() {
        this.player.release();
        removeSurfaceCallbacks();
        if (this.surface != null) {
            if (this.ownsSurface) {
                this.surface.release();
            }
            this.surface = null;
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void sendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        this.player.sendMessages(exoPlayerMessageArr);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void blockingSendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        this.player.blockingSendMessages(exoPlayerMessageArr);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public int getCurrentPeriodIndex() {
        return this.player.getCurrentPeriodIndex();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public int getCurrentWindowIndex() {
        return this.player.getCurrentWindowIndex();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public long getDuration() {
        return this.player.getDuration();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public long getCurrentPosition() {
        return this.player.getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public long getBufferedPosition() {
        return this.player.getBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public int getBufferedPercentage() {
        return this.player.getBufferedPercentage();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public Timeline getCurrentTimeline() {
        return this.player.getCurrentTimeline();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public Object getCurrentManifest() {
        return this.player.getCurrentManifest();
    }

    private void buildRenderers(Context context, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, ArrayList<Renderer> arrayList, long j) {
        arrayList.add(new MediaCodecVideoRenderer(context, MediaCodecSelector.DEFAULT, 1, j, drmSessionManager, false, this.mainHandler, this.componentListener, 50));
        arrayList.add(new MediaCodecAudioRenderer(MediaCodecSelector.DEFAULT, drmSessionManager, true, this.mainHandler, this.componentListener, AudioCapabilities.getCapabilities(context), 3));
        arrayList.add(new TextRenderer(this.componentListener, this.mainHandler.getLooper()));
        arrayList.add(new MetadataRenderer(this.componentListener, this.mainHandler.getLooper(), new Id3Decoder()));
    }

    private void buildExtensionRenderers(ArrayList<Renderer> arrayList, long j) {
        try {
            arrayList.add((Renderer) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Boolean.TYPE, Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(true, Long.valueOf(j), this.mainHandler, this.componentListener, 50));
            Log.i(TAG, "Loaded LibvpxVideoRenderer.");
        } catch (ClassNotFoundException e) {
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
        try {
            arrayList.add((Renderer) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class).newInstance(this.mainHandler, this.componentListener));
            Log.i(TAG, "Loaded LibopusAudioRenderer.");
        } catch (ClassNotFoundException e3) {
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
        try {
            arrayList.add((Renderer) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class).newInstance(this.mainHandler, this.componentListener));
            Log.i(TAG, "Loaded LibflacAudioRenderer.");
        } catch (ClassNotFoundException e5) {
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
        try {
            arrayList.add((Renderer) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class).newInstance(this.mainHandler, this.componentListener));
            Log.i(TAG, "Loaded FfmpegAudioRenderer.");
        } catch (ClassNotFoundException e7) {
        } catch (Exception e8) {
            throw new RuntimeException(e8);
        }
    }

    private void removeSurfaceCallbacks() {
        if (this.textureView != null) {
            if (this.textureView.getSurfaceTextureListener() != this.componentListener) {
                Log.w(TAG, "SurfaceTextureListener already unset or replaced.");
            } else {
                this.textureView.setSurfaceTextureListener(null);
            }
            this.textureView = null;
        }
        if (this.surfaceHolder != null) {
            this.surfaceHolder.removeCallback(this.componentListener);
            this.surfaceHolder = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoSurfaceInternal(Surface surface, boolean z) {
        int i;
        ExoPlayer.ExoPlayerMessage[] exoPlayerMessageArr = new ExoPlayer.ExoPlayerMessage[this.videoRendererCount];
        Renderer[] rendererArr = this.renderers;
        int length = rendererArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            Renderer renderer = rendererArr[i2];
            if (renderer.getTrackType() == 2) {
                i = i3 + 1;
                exoPlayerMessageArr[i3] = new ExoPlayer.ExoPlayerMessage(renderer, 1, surface);
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        if (this.surface != null && this.surface != surface) {
            if (this.ownsSurface) {
                this.surface.release();
            }
            this.player.blockingSendMessages(exoPlayerMessageArr);
        } else {
            this.player.sendMessages(exoPlayerMessageArr);
        }
        this.surface = surface;
        this.ownsSurface = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class ComponentListener implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, AudioRendererEventListener, MetadataRenderer.Output<List<Id3Frame>>, TextRenderer.Output, TrackSelector.EventListener<Object>, VideoRendererEventListener {
        private ComponentListener() {
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoEnabled(DecoderCounters decoderCounters) {
            SimpleExoPlayer.this.videoDecoderCounters = decoderCounters;
            if (SimpleExoPlayer.this.videoDebugListener != null) {
                SimpleExoPlayer.this.videoDebugListener.onVideoEnabled(decoderCounters);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDecoderInitialized(String str, long j, long j2) {
            if (SimpleExoPlayer.this.videoDebugListener != null) {
                SimpleExoPlayer.this.videoDebugListener.onVideoDecoderInitialized(str, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoInputFormatChanged(Format format) {
            SimpleExoPlayer.this.videoFormat = format;
            if (SimpleExoPlayer.this.videoDebugListener != null) {
                SimpleExoPlayer.this.videoDebugListener.onVideoInputFormatChanged(format);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onDroppedFrames(int i, long j) {
            if (SimpleExoPlayer.this.videoDebugListener != null) {
                SimpleExoPlayer.this.videoDebugListener.onDroppedFrames(i, j);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            if (SimpleExoPlayer.this.videoListener != null) {
                SimpleExoPlayer.this.videoListener.onVideoSizeChanged(i, i2, i3, f);
            }
            if (SimpleExoPlayer.this.videoDebugListener != null) {
                SimpleExoPlayer.this.videoDebugListener.onVideoSizeChanged(i, i2, i3, f);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onRenderedFirstFrame(Surface surface) {
            if (SimpleExoPlayer.this.videoListener != null && SimpleExoPlayer.this.surface == surface) {
                SimpleExoPlayer.this.videoListener.onRenderedFirstFrame();
            }
            if (SimpleExoPlayer.this.videoDebugListener != null) {
                SimpleExoPlayer.this.videoDebugListener.onRenderedFirstFrame(surface);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDisabled(DecoderCounters decoderCounters) {
            if (SimpleExoPlayer.this.videoDebugListener != null) {
                SimpleExoPlayer.this.videoDebugListener.onVideoDisabled(decoderCounters);
            }
            SimpleExoPlayer.this.videoFormat = null;
            SimpleExoPlayer.this.videoDecoderCounters = null;
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioEnabled(DecoderCounters decoderCounters) {
            SimpleExoPlayer.this.audioDecoderCounters = decoderCounters;
            if (SimpleExoPlayer.this.audioDebugListener != null) {
                SimpleExoPlayer.this.audioDebugListener.onAudioEnabled(decoderCounters);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioSessionId(int i) {
            SimpleExoPlayer.this.audioSessionId = i;
            if (SimpleExoPlayer.this.audioDebugListener != null) {
                SimpleExoPlayer.this.audioDebugListener.onAudioSessionId(i);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDecoderInitialized(String str, long j, long j2) {
            if (SimpleExoPlayer.this.audioDebugListener != null) {
                SimpleExoPlayer.this.audioDebugListener.onAudioDecoderInitialized(str, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioInputFormatChanged(Format format) {
            SimpleExoPlayer.this.audioFormat = format;
            if (SimpleExoPlayer.this.audioDebugListener != null) {
                SimpleExoPlayer.this.audioDebugListener.onAudioInputFormatChanged(format);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioTrackUnderrun(int i, long j, long j2) {
            if (SimpleExoPlayer.this.audioDebugListener != null) {
                SimpleExoPlayer.this.audioDebugListener.onAudioTrackUnderrun(i, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDisabled(DecoderCounters decoderCounters) {
            if (SimpleExoPlayer.this.audioDebugListener != null) {
                SimpleExoPlayer.this.audioDebugListener.onAudioDisabled(decoderCounters);
            }
            SimpleExoPlayer.this.audioFormat = null;
            SimpleExoPlayer.this.audioDecoderCounters = null;
            SimpleExoPlayer.this.audioSessionId = 0;
        }

        @Override // com.google.android.exoplayer2.text.TextRenderer.Output
        public void onCues(List<Cue> list) {
            if (SimpleExoPlayer.this.textOutput != null) {
                SimpleExoPlayer.this.textOutput.onCues(list);
            }
        }

        @Override // com.google.android.exoplayer2.metadata.MetadataRenderer.Output
        public void onMetadata(List<Id3Frame> list) {
            if (SimpleExoPlayer.this.id3Output != null) {
                SimpleExoPlayer.this.id3Output.onMetadata(list);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(surfaceHolder.getSurface(), false);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(null, false);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(new Surface(surfaceTexture), true);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(null, true);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelector.EventListener
        public void onTrackSelectionsChanged(TrackSelections<? extends Object> trackSelections) {
            boolean z = false;
            int i = 0;
            while (true) {
                if (i < SimpleExoPlayer.this.renderers.length) {
                    if (SimpleExoPlayer.this.renderers[i].getTrackType() != 2 || trackSelections.get(i) == null) {
                        i++;
                    } else {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (SimpleExoPlayer.this.videoListener != null && SimpleExoPlayer.this.videoTracksEnabled && !z) {
                SimpleExoPlayer.this.videoListener.onVideoTracksDisabled();
            }
            SimpleExoPlayer.this.videoTracksEnabled = z;
        }
    }

    @TargetApi(23)
    /* loaded from: classes.dex */
    private static final class PlaybackParamsHolder {
        public final PlaybackParams params;

        public PlaybackParamsHolder(PlaybackParams playbackParams) {
            this.params = playbackParams;
        }
    }
}

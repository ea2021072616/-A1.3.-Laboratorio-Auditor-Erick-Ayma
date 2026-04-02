package com.pili.pldroid.player;

import android.view.View;
/* loaded from: classes2.dex */
public interface IMediaController {

    /* loaded from: classes2.dex */
    public interface MediaPlayerControl {
        boolean canPause();

        boolean canSeekBackward();

        boolean canSeekForward();

        int getBufferPercentage();

        long getCurrentPosition();

        long getDuration();

        boolean isPlaying();

        void pause();

        void seekTo(long j);

        void start();
    }

    void hide();

    boolean isShowing();

    void setAnchorView(View view);

    void setEnabled(boolean z);

    void setMediaPlayer(MediaPlayerControl mediaPlayerControl);

    void show();

    void show(int i);
}

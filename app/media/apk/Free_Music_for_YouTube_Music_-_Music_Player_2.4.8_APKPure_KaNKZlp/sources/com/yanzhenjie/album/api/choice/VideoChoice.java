package com.yanzhenjie.album.api.choice;

import android.content.Context;
import com.yanzhenjie.album.api.VideoMultipleWrapper;
import com.yanzhenjie.album.api.VideoSingleWrapper;
/* loaded from: classes.dex */
public final class VideoChoice implements Choice<VideoMultipleWrapper, VideoSingleWrapper> {
    private Context mContext;

    public VideoChoice(Context context) {
        this.mContext = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yanzhenjie.album.api.choice.Choice
    public VideoMultipleWrapper multipleChoice() {
        return new VideoMultipleWrapper(this.mContext);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yanzhenjie.album.api.choice.Choice
    public VideoSingleWrapper singleChoice() {
        return new VideoSingleWrapper(this.mContext);
    }
}

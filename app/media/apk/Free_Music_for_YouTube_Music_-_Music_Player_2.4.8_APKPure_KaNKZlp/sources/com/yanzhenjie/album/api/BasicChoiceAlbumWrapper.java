package com.yanzhenjie.album.api;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.media.MediaDescriptionCompat;
import com.yanzhenjie.album.api.BasicChoiceAlbumWrapper;
/* loaded from: classes2.dex */
public abstract class BasicChoiceAlbumWrapper<Returner extends BasicChoiceAlbumWrapper, Result, Cancel, Checked> extends BasicChoiceWrapper<Returner, Result, Cancel, Checked> {
    @IntRange(from = 1, to = Long.MAX_VALUE)
    long mLimitBytes;
    @IntRange(from = 1, to = Long.MAX_VALUE)
    long mLimitDuration;
    @IntRange(from = MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED, to = 1)
    int mQuality;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BasicChoiceAlbumWrapper(@NonNull Context context) {
        super(context);
        this.mQuality = 1;
        this.mLimitDuration = Long.MAX_VALUE;
        this.mLimitBytes = Long.MAX_VALUE;
    }

    public Returner cameraVideoQuality(@IntRange(from = 0, to = 1) int i) {
        this.mQuality = i;
        return this;
    }

    public Returner cameraVideoLimitDuration(@IntRange(from = 1, to = Long.MAX_VALUE) long j) {
        this.mLimitDuration = j;
        return this;
    }

    public Returner cameraVideoLimitBytes(@IntRange(from = 1, to = Long.MAX_VALUE) long j) {
        this.mLimitBytes = j;
        return this;
    }
}

package com.yanzhenjie.album.api;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.media.MediaDescriptionCompat;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.ui.CameraActivity;
/* loaded from: classes2.dex */
public class VideoCameraWrapper extends BasicCameraWrapper<VideoCameraWrapper> {
    @IntRange(from = 1, to = Long.MAX_VALUE)
    private long mLimitBytes;
    @IntRange(from = 1, to = Long.MAX_VALUE)
    private long mLimitDuration;
    @IntRange(from = MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED, to = 1)
    private int mQuality;

    public VideoCameraWrapper(@NonNull Context context) {
        super(context);
        this.mQuality = 1;
        this.mLimitDuration = Long.MAX_VALUE;
        this.mLimitBytes = Long.MAX_VALUE;
    }

    public VideoCameraWrapper quality(@IntRange(from = 0, to = 1) int i) {
        this.mQuality = i;
        return this;
    }

    public VideoCameraWrapper limitDuration(@IntRange(from = 1, to = Long.MAX_VALUE) long j) {
        this.mLimitDuration = j;
        return this;
    }

    public VideoCameraWrapper limitBytes(@IntRange(from = 1, to = Long.MAX_VALUE) long j) {
        this.mLimitBytes = j;
        return this;
    }

    @Override // com.yanzhenjie.album.api.BasicCameraWrapper
    public void start() {
        CameraActivity.sResult = this.mResult;
        CameraActivity.sCancel = this.mCancel;
        Intent intent = new Intent(this.mContext, CameraActivity.class);
        intent.putExtra(Album.KEY_INPUT_REQUEST_CODE, this.mRequestCode);
        intent.putExtra(Album.KEY_INPUT_FUNCTION, 1);
        intent.putExtra(Album.KEY_INPUT_FILE_PATH, this.mFilePath);
        intent.putExtra(Album.KEY_INPUT_CAMERA_QUALITY, this.mQuality);
        intent.putExtra(Album.KEY_INPUT_CAMERA_DURATION, this.mLimitDuration);
        intent.putExtra(Album.KEY_INPUT_CAMERA_BYTES, this.mLimitBytes);
        this.mContext.startActivity(intent);
    }
}

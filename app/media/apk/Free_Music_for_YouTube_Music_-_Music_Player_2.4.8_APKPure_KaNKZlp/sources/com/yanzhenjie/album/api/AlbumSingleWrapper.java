package com.yanzhenjie.album.api;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.Filter;
import com.yanzhenjie.album.ui.AlbumActivity;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AlbumSingleWrapper extends BasicChoiceVideoWrapper<AlbumSingleWrapper, ArrayList<AlbumFile>, String, AlbumFile> {
    private Filter<Long> mDurationFilter;

    public AlbumSingleWrapper(@NonNull Context context) {
        super(context);
    }

    public AlbumSingleWrapper filterDuration(Filter<Long> filter) {
        this.mDurationFilter = filter;
        return this;
    }

    @Override // com.yanzhenjie.album.api.BasicAlbumWrapper
    public void start() {
        AlbumActivity.mSizeFilter = this.mSizeFilter;
        AlbumActivity.mMimeFilter = this.mMimeTypeFilter;
        AlbumActivity.mDurationFilter = this.mDurationFilter;
        AlbumActivity.sResult = this.mResult;
        AlbumActivity.sCancel = this.mCancel;
        Intent intent = new Intent(this.mContext, AlbumActivity.class);
        intent.putExtra(Album.KEY_INPUT_REQUEST_CODE, this.mRequestCode);
        intent.putExtra(Album.KEY_INPUT_WIDGET, this.mWidget);
        intent.putExtra(Album.KEY_INPUT_FUNCTION, 2);
        intent.putExtra(Album.KEY_INPUT_CHOICE_MODE, 2);
        intent.putExtra(Album.KEY_INPUT_COLUMN_COUNT, this.mColumnCount);
        intent.putExtra(Album.KEY_INPUT_ALLOW_CAMERA, this.mHasCamera);
        intent.putExtra(Album.KEY_INPUT_LIMIT_COUNT, 1);
        intent.putExtra(Album.KEY_INPUT_FILTER_VISIBILITY, this.mFilterVisibility);
        intent.putExtra(Album.KEY_INPUT_CAMERA_QUALITY, this.mQuality);
        intent.putExtra(Album.KEY_INPUT_CAMERA_DURATION, this.mLimitDuration);
        intent.putExtra(Album.KEY_INPUT_CAMERA_BYTES, this.mLimitBytes);
        this.mContext.startActivity(intent);
    }
}

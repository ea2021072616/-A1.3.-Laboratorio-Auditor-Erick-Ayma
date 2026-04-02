package com.yanzhenjie.album.api;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v7.widget.ActivityChooserView;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.ui.AlbumActivity;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class ImageMultipleWrapper extends BasicChoiceWrapper<ImageMultipleWrapper, ArrayList<AlbumFile>, String, ArrayList<AlbumFile>> {
    @IntRange(from = 1, to = 2147483647L)
    private int mLimitCount;

    public ImageMultipleWrapper(@NonNull Context context) {
        super(context);
        this.mLimitCount = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ImageMultipleWrapper checkedList(ArrayList<AlbumFile> arrayList) {
        this.mChecked = arrayList;
        return this;
    }

    public ImageMultipleWrapper selectCount(@IntRange(from = 1, to = 2147483647L) int i) {
        this.mLimitCount = i;
        return this;
    }

    @Override // com.yanzhenjie.album.api.BasicAlbumWrapper
    public void start() {
        AlbumActivity.mSizeFilter = this.mSizeFilter;
        AlbumActivity.mMimeFilter = this.mMimeTypeFilter;
        AlbumActivity.sResult = this.mResult;
        AlbumActivity.sCancel = this.mCancel;
        Intent intent = new Intent(this.mContext, AlbumActivity.class);
        intent.putExtra(Album.KEY_INPUT_REQUEST_CODE, this.mRequestCode);
        intent.putExtra(Album.KEY_INPUT_WIDGET, this.mWidget);
        intent.putParcelableArrayListExtra(Album.KEY_INPUT_CHECKED_LIST, (ArrayList) this.mChecked);
        intent.putExtra(Album.KEY_INPUT_FUNCTION, 0);
        intent.putExtra(Album.KEY_INPUT_CHOICE_MODE, 1);
        intent.putExtra(Album.KEY_INPUT_COLUMN_COUNT, this.mColumnCount);
        intent.putExtra(Album.KEY_INPUT_ALLOW_CAMERA, this.mHasCamera);
        intent.putExtra(Album.KEY_INPUT_LIMIT_COUNT, this.mLimitCount);
        intent.putExtra(Album.KEY_INPUT_FILTER_VISIBILITY, this.mFilterVisibility);
        this.mContext.startActivity(intent);
    }
}

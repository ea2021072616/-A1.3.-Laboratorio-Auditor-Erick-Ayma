package com.yanzhenjie.album.api;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.ui.AlbumActivity;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class ImageSingleWrapper extends BasicChoiceWrapper<ImageSingleWrapper, ArrayList<AlbumFile>, String, AlbumFile> {
    public ImageSingleWrapper(@NonNull Context context) {
        super(context);
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
        intent.putExtra(Album.KEY_INPUT_FUNCTION, 0);
        intent.putExtra(Album.KEY_INPUT_CHOICE_MODE, 2);
        intent.putExtra(Album.KEY_INPUT_COLUMN_COUNT, this.mColumnCount);
        intent.putExtra(Album.KEY_INPUT_ALLOW_CAMERA, this.mHasCamera);
        intent.putExtra(Album.KEY_INPUT_LIMIT_COUNT, 1);
        intent.putExtra(Album.KEY_INPUT_FILTER_VISIBILITY, this.mFilterVisibility);
        this.mContext.startActivity(intent);
    }
}

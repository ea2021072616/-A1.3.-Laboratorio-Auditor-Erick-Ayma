package com.yanzhenjie.album.api;

import android.content.Context;
import android.content.Intent;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.ui.GalleryAlbumActivity;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GalleryAlbumWrapper extends BasicGalleryWrapper<GalleryAlbumWrapper, AlbumFile, String, AlbumFile> {
    public GalleryAlbumWrapper(Context context) {
        super(context);
    }

    @Override // com.yanzhenjie.album.api.BasicAlbumWrapper
    public void start() {
        GalleryAlbumActivity.sResult = this.mResult;
        GalleryAlbumActivity.sCancel = this.mCancel;
        Intent intent = new Intent(this.mContext, GalleryAlbumActivity.class);
        intent.putExtra(Album.KEY_INPUT_REQUEST_CODE, this.mRequestCode);
        intent.putExtra(Album.KEY_INPUT_WIDGET, this.mWidget);
        intent.putParcelableArrayListExtra(Album.KEY_INPUT_CHECKED_LIST, (ArrayList) this.mChecked);
        intent.putExtra(Album.KEY_INPUT_CURRENT_POSITION, this.mCurrentPosition);
        intent.putExtra(Album.KEY_INPUT_GALLERY_CHECKABLE, this.mCheckable);
        intent.putExtra(Album.KEY_INPUT_NAVIGATION_ALPHA, this.mNavigationAlpha);
        this.mContext.startActivity(intent);
    }
}

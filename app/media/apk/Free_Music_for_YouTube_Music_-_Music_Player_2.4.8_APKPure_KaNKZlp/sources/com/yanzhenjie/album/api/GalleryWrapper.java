package com.yanzhenjie.album.api;

import android.content.Context;
import android.content.Intent;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.ui.GalleryActivity;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GalleryWrapper extends BasicGalleryWrapper<GalleryWrapper, String, String, String> {
    public GalleryWrapper(Context context) {
        super(context);
    }

    @Override // com.yanzhenjie.album.api.BasicAlbumWrapper
    public void start() {
        GalleryActivity.sResult = this.mResult;
        GalleryActivity.sCancel = this.mCancel;
        Intent intent = new Intent(this.mContext, GalleryActivity.class);
        intent.putExtra(Album.KEY_INPUT_REQUEST_CODE, this.mRequestCode);
        intent.putExtra(Album.KEY_INPUT_WIDGET, this.mWidget);
        intent.putStringArrayListExtra(Album.KEY_INPUT_CHECKED_LIST, (ArrayList) this.mChecked);
        intent.putExtra(Album.KEY_INPUT_CURRENT_POSITION, this.mCurrentPosition);
        intent.putExtra(Album.KEY_INPUT_GALLERY_CHECKABLE, this.mCheckable);
        intent.putExtra(Album.KEY_INPUT_NAVIGATION_ALPHA, this.mNavigationAlpha);
        this.mContext.startActivity(intent);
    }
}

package com.yanzhenjie.album.api;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.ui.CameraActivity;
/* loaded from: classes2.dex */
public class ImageCameraWrapper extends BasicCameraWrapper<ImageCameraWrapper> {
    public ImageCameraWrapper(@NonNull Context context) {
        super(context);
    }

    @Override // com.yanzhenjie.album.api.BasicCameraWrapper
    public void start() {
        CameraActivity.sResult = this.mResult;
        CameraActivity.sCancel = this.mCancel;
        Intent intent = new Intent(this.mContext, CameraActivity.class);
        intent.putExtra(Album.KEY_INPUT_REQUEST_CODE, this.mRequestCode);
        intent.putExtra(Album.KEY_INPUT_FUNCTION, 0);
        intent.putExtra(Album.KEY_INPUT_FILE_PATH, this.mFilePath);
        this.mContext.startActivity(intent);
    }
}

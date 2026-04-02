package com.yanzhenjie.album.api.camera;

import android.content.Context;
import com.yanzhenjie.album.api.ImageCameraWrapper;
import com.yanzhenjie.album.api.VideoCameraWrapper;
/* loaded from: classes.dex */
public class AlbumCamera implements Camera<ImageCameraWrapper, VideoCameraWrapper> {
    private Context mContext;

    public AlbumCamera(Context context) {
        this.mContext = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yanzhenjie.album.api.camera.Camera
    public ImageCameraWrapper image() {
        return new ImageCameraWrapper(this.mContext);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yanzhenjie.album.api.camera.Camera
    public VideoCameraWrapper video() {
        return new VideoCameraWrapper(this.mContext);
    }
}

package com.yanzhenjie.album.provider;

import android.content.Context;
import android.support.v4.content.FileProvider;
/* loaded from: classes2.dex */
public class CameraFileProvider extends FileProvider {
    public static String getFileProviderName(Context context) {
        return context.getPackageName() + ".album.camera.provider";
    }
}

package com.yanzhenjie.album.api;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.api.BasicCameraWrapper;
/* loaded from: classes2.dex */
public abstract class BasicCameraWrapper<Returner extends BasicCameraWrapper> {
    Action<String> mCancel;
    @NonNull
    final Context mContext;
    @Nullable
    String mFilePath;
    int mRequestCode;
    Action<String> mResult;

    public abstract void start();

    public BasicCameraWrapper(@NonNull Context context) {
        this.mContext = context;
    }

    public final Returner onResult(Action<String> action) {
        this.mResult = action;
        return this;
    }

    public final Returner onCancel(Action<String> action) {
        this.mCancel = action;
        return this;
    }

    public Returner requestCode(int i) {
        this.mRequestCode = i;
        return this;
    }

    public Returner filePath(@Nullable String str) {
        this.mFilePath = str;
        return this;
    }
}

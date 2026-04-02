package com.yanzhenjie.album.api;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.api.BasicAlbumWrapper;
import com.yanzhenjie.album.api.widget.Widget;
/* loaded from: classes.dex */
public abstract class BasicAlbumWrapper<Returner extends BasicAlbumWrapper, Result, Cancel, Checked> {
    Action<Cancel> mCancel;
    @Nullable
    Checked mChecked;
    @NonNull
    final Context mContext;
    int mRequestCode;
    Action<Result> mResult;
    @Nullable
    Widget mWidget;

    public abstract void start();

    /* JADX INFO: Access modifiers changed from: package-private */
    public BasicAlbumWrapper(@NonNull Context context) {
        this.mContext = context;
        this.mWidget = Widget.getDefaultWidget(context);
    }

    public final Returner onResult(Action<Result> action) {
        this.mResult = action;
        return this;
    }

    public final Returner onCancel(Action<Cancel> action) {
        this.mCancel = action;
        return this;
    }

    public final Returner requestCode(int i) {
        this.mRequestCode = i;
        return this;
    }

    public final Returner widget(@Nullable Widget widget) {
        this.mWidget = widget;
        return this;
    }
}

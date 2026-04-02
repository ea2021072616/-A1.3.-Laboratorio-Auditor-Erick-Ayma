package com.google.android.gms.common.api;

import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Result;
/* loaded from: classes.dex */
public class Response<T extends Result> {
    private T zzfhl;

    public Response() {
    }

    protected Response(@NonNull T t) {
        this.zzfhl = t;
    }

    @NonNull
    protected T getResult() {
        return this.zzfhl;
    }

    public void setResult(@NonNull T t) {
        this.zzfhl = t;
    }
}

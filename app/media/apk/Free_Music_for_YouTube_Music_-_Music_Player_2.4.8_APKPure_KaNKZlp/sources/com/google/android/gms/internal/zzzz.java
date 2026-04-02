package com.google.android.gms.internal;
@zzzt
/* loaded from: classes.dex */
final class zzzz extends Exception {
    private final int mErrorCode;

    public zzzz(String str, int i) {
        super(str);
        this.mErrorCode = i;
    }

    public final int getErrorCode() {
        return this.mErrorCode;
    }
}

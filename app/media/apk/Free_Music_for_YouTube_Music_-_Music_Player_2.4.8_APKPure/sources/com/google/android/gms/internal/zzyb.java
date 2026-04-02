package com.google.android.gms.internal;
/* loaded from: classes2.dex */
public final class zzyb extends Exception {
    private final int mErrorCode;

    public zzyb(String str, int i) {
        super(str);
        this.mErrorCode = i;
    }

    public final int getErrorCode() {
        return this.mErrorCode;
    }
}

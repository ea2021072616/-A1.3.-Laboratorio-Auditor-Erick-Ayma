package com.google.android.gms.common.api;

import android.support.annotation.Nullable;
/* loaded from: classes.dex */
public class ApiException extends Exception {
    protected final Status mStatus;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ApiException(@android.support.annotation.NonNull com.google.android.gms.common.api.Status r5) {
        /*
            r4 = this;
            int r1 = r5.getStatusCode()
            java.lang.String r0 = r5.getStatusMessage()
            if (r0 == 0) goto L35
            java.lang.String r0 = r5.getStatusMessage()
        Le:
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r2 = r2 + 13
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r2 = ": "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            r4.<init>(r0)
            r4.mStatus = r5
            return
        L35:
            java.lang.String r0 = ""
            goto Le
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.ApiException.<init>(com.google.android.gms.common.api.Status):void");
    }

    public int getStatusCode() {
        return this.mStatus.getStatusCode();
    }

    @Nullable
    public String getStatusMessage() {
        return this.mStatus.getStatusMessage();
    }
}

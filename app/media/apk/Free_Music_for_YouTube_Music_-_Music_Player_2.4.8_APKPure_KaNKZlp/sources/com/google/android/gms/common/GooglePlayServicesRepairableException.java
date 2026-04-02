package com.google.android.gms.common;

import android.content.Intent;
/* loaded from: classes.dex */
public class GooglePlayServicesRepairableException extends UserRecoverableException {
    private final int zzdxs;

    public GooglePlayServicesRepairableException(int i, String str, Intent intent) {
        super(str, intent);
        this.zzdxs = i;
    }

    public int getConnectionStatusCode() {
        return this.zzdxs;
    }
}

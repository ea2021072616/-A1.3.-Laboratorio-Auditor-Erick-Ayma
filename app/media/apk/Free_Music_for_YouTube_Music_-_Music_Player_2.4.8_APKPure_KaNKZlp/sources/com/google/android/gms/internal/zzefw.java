package com.google.android.gms.internal;
/* loaded from: classes2.dex */
final class zzefw extends IllegalArgumentException {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzefw(int i, int i2) {
        super(new StringBuilder(54).append("Unpaired surrogate at index ").append(i).append(" of ").append(i2).toString());
    }
}

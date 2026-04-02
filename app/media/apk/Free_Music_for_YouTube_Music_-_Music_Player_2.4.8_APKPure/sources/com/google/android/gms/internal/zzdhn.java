package com.google.android.gms.internal;
/* loaded from: classes2.dex */
final /* synthetic */ class zzdhn {
    static final /* synthetic */ int[] zzlbz = new int[zzdfy.values().length];

    static {
        try {
            zzlbz[zzdfy.SHA1.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            zzlbz[zzdfy.SHA256.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            zzlbz[zzdfy.SHA512.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}

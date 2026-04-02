package com.google.android.gms.internal;
/* loaded from: classes2.dex */
final /* synthetic */ class zzdgy {
    static final /* synthetic */ int[] zzlby;
    static final /* synthetic */ int[] zzlbz;
    static final /* synthetic */ int[] zzlca = new int[zzdfu.values().length];

    static {
        try {
            zzlca[zzdfu.COMPRESSED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            zzlca[zzdfu.UNCOMPRESSED.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        zzlbz = new int[zzdfy.values().length];
        try {
            zzlbz[zzdfy.SHA1.ordinal()] = 1;
        } catch (NoSuchFieldError e3) {
        }
        try {
            zzlbz[zzdfy.SHA256.ordinal()] = 2;
        } catch (NoSuchFieldError e4) {
        }
        try {
            zzlbz[zzdfy.SHA512.ordinal()] = 3;
        } catch (NoSuchFieldError e5) {
        }
        zzlby = new int[zzdfw.values().length];
        try {
            zzlby[zzdfw.NIST_P256.ordinal()] = 1;
        } catch (NoSuchFieldError e6) {
        }
        try {
            zzlby[zzdfw.NIST_P384.ordinal()] = 2;
        } catch (NoSuchFieldError e7) {
        }
        try {
            zzlby[zzdfw.NIST_P521.ordinal()] = 3;
        } catch (NoSuchFieldError e8) {
        }
    }
}

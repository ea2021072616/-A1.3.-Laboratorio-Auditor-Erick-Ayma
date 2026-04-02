package com.google.android.gms.internal;
/* loaded from: classes2.dex */
public enum zzdfw implements zzeeo {
    UNKNOWN_CURVE(0),
    NIST_P224(1),
    NIST_P256(2),
    NIST_P384(3),
    NIST_P521(4),
    UNRECOGNIZED(-1);
    
    private static final zzeep<zzdfw> zzkyn = new zzeep<zzdfw>() { // from class: com.google.android.gms.internal.zzdfx
    };
    private final int value;

    zzdfw(int i) {
        this.value = i;
    }

    public static zzdfw zzfc(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_CURVE;
            case 1:
                return NIST_P224;
            case 2:
                return NIST_P256;
            case 3:
                return NIST_P384;
            case 4:
                return NIST_P521;
            default:
                return null;
        }
    }

    public final int zzbkq() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }
}

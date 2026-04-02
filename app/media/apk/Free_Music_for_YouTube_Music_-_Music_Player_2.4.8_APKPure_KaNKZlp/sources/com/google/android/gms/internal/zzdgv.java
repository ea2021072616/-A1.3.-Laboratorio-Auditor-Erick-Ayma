package com.google.android.gms.internal;
/* loaded from: classes2.dex */
public enum zzdgv implements zzeeo {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    UNRECOGNIZED(-1);
    
    private static final zzeep<zzdgv> zzkyn = new zzeep<zzdgv>() { // from class: com.google.android.gms.internal.zzdgw
    };
    private final int value;

    zzdgv(int i) {
        this.value = i;
    }

    public static zzdgv zzfm(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_PREFIX;
            case 1:
                return TINK;
            case 2:
                return LEGACY;
            case 3:
                return RAW;
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

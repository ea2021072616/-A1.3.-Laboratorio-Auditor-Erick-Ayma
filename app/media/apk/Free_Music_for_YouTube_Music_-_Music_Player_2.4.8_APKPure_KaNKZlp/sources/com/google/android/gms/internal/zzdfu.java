package com.google.android.gms.internal;
/* loaded from: classes2.dex */
public enum zzdfu implements zzeeo {
    UNKNOWN_FORMAT(0),
    UNCOMPRESSED(1),
    COMPRESSED(2),
    UNRECOGNIZED(-1);
    
    private static final zzeep<zzdfu> zzkyn = new zzeep<zzdfu>() { // from class: com.google.android.gms.internal.zzdfv
    };
    private final int value;

    zzdfu(int i) {
        this.value = i;
    }

    public static zzdfu zzfb(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_FORMAT;
            case 1:
                return UNCOMPRESSED;
            case 2:
                return COMPRESSED;
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

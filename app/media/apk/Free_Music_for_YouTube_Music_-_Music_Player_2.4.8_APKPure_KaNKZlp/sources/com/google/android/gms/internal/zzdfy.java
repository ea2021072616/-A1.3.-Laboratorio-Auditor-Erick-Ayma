package com.google.android.gms.internal;
/* loaded from: classes2.dex */
public enum zzdfy implements zzeeo {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA224(2),
    SHA256(3),
    SHA512(4),
    UNRECOGNIZED(-1);
    
    private static final zzeep<zzdfy> zzkyn = new zzeep<zzdfy>() { // from class: com.google.android.gms.internal.zzdfz
    };
    private final int value;

    zzdfy(int i) {
        this.value = i;
    }

    public static zzdfy zzfd(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_HASH;
            case 1:
                return SHA1;
            case 2:
                return SHA224;
            case 3:
                return SHA256;
            case 4:
                return SHA512;
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

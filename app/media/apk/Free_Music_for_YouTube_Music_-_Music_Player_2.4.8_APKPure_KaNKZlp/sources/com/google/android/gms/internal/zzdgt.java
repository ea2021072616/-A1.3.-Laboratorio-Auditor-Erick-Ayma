package com.google.android.gms.internal;
/* loaded from: classes2.dex */
public enum zzdgt implements zzeeo {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);
    
    private static final zzeep<zzdgt> zzkyn = new zzeep<zzdgt>() { // from class: com.google.android.gms.internal.zzdgu
    };
    private final int value;

    zzdgt(int i) {
        this.value = i;
    }

    public static zzdgt zzfh(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_STATUS;
            case 1:
                return ENABLED;
            case 2:
                return DISABLED;
            case 3:
                return DESTROYED;
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

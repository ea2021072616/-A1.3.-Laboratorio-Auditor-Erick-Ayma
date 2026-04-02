package com.google.android.gms.internal;
/* loaded from: classes2.dex */
public class zzeex {
    private static final zzedz zzmxp = zzedz.zzcci();
    private zzedk zzmzq;
    private volatile zzeey zzmzr;
    private volatile zzedk zzmzs;

    private final zzedk zzcbi() {
        if (this.zzmzs != null) {
            return this.zzmzs;
        }
        synchronized (this) {
            if (this.zzmzs != null) {
                return this.zzmzs;
            }
            if (this.zzmzr == null) {
                this.zzmzs = zzedk.zzmxr;
            } else {
                this.zzmzs = this.zzmzr.zzcbi();
            }
            return this.zzmzs;
        }
    }

    private zzeey zzf(zzeey zzeeyVar) {
        if (this.zzmzr == null) {
            synchronized (this) {
                if (this.zzmzr == null) {
                    try {
                        this.zzmzr = zzeeyVar;
                        this.zzmzs = zzedk.zzmxr;
                    } catch (zzeer e) {
                        this.zzmzr = zzeeyVar;
                        this.zzmzs = zzedk.zzmxr;
                    }
                }
            }
        }
        return this.zzmzr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzeex) {
            zzeex zzeexVar = (zzeex) obj;
            zzeey zzeeyVar = this.zzmzr;
            zzeey zzeeyVar2 = zzeexVar.zzmzr;
            return (zzeeyVar == null && zzeeyVar2 == null) ? zzcbi().equals(zzeexVar.zzcbi()) : (zzeeyVar == null || zzeeyVar2 == null) ? zzeeyVar != null ? zzeeyVar.equals(zzeexVar.zzf(zzeeyVar.zzcco())) : zzf(zzeeyVar2.zzcco()).equals(zzeeyVar2) : zzeeyVar.equals(zzeeyVar2);
        }
        return false;
    }

    public int hashCode() {
        return 1;
    }

    public final zzeey zzg(zzeey zzeeyVar) {
        zzeey zzeeyVar2 = this.zzmzr;
        this.zzmzq = null;
        this.zzmzs = null;
        this.zzmzr = zzeeyVar;
        return zzeeyVar2;
    }
}

package com.google.android.gms.internal;

import java.util.concurrent.ExecutionException;
/* loaded from: classes2.dex */
public final class zzdm extends zzed {
    private zzau zzajm;
    private static volatile zzbu zzajl = null;
    private static final Object zzajk = new Object();

    public zzdm(zzdc zzdcVar, String str, String str2, zzax zzaxVar, int i, int i2, zzau zzauVar) {
        super(zzdcVar, str, str2, zzaxVar, i, 27);
        this.zzajm = null;
        this.zzajm = zzauVar;
    }

    private static String zza(zzau zzauVar) {
        if (zzauVar == null || zzauVar.zzcr == null || zzdh.zzo(zzauVar.zzcr.zzct)) {
            return null;
        }
        return zzauVar.zzcr.zzct;
    }

    private final String zzas() {
        try {
            if (this.zzagk.zzal() != null) {
                this.zzagk.zzal().get();
            }
            zzax zzak = this.zzagk.zzak();
            if (zzak != null && zzak.zzct != null) {
                return zzak.zzct;
            }
        } catch (InterruptedException e) {
        } catch (ExecutionException e2) {
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0108, code lost:
        if (r0 != false) goto L17;
     */
    @Override // com.google.android.gms.internal.zzed
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void zzar() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdm.zzar():void");
    }
}

package com.google.android.gms.internal;

import android.view.View;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes2.dex */
public final class zzea extends zzed {
    private final View zzajt;

    public zzea(zzdc zzdcVar, String str, String str2, zzax zzaxVar, int i, int i2, View view) {
        super(zzdcVar, str, str2, zzaxVar, i, 57);
        this.zzajt = view;
    }

    @Override // com.google.android.gms.internal.zzed
    protected final void zzar() throws IllegalAccessException, InvocationTargetException {
        if (this.zzajt != null) {
            zzdi zzdiVar = new zzdi((String) this.zzajw.invoke(null, this.zzajt, this.zzagk.getContext().getResources().getDisplayMetrics(), Boolean.valueOf(((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbly)).booleanValue())));
            zzaz zzazVar = new zzaz();
            zzazVar.zzfu = zzdiVar.zzaji;
            zzazVar.zzfv = zzdiVar.zzfv;
            zzazVar.zzfw = zzdiVar.zzfw;
            this.zzajn.zzer = zzazVar;
        }
    }
}

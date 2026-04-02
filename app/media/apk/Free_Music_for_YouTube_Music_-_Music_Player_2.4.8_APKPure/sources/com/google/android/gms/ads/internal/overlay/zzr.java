package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.internal.zzakk;
import com.google.android.gms.internal.zzzt;
@zzzt
/* loaded from: classes.dex */
public final class zzr {
    public final int index;
    public final ViewGroup parent;
    public final Context zzaie;
    public final ViewGroup.LayoutParams zzcgt;

    public zzr(zzakk zzakkVar) throws zzp {
        this.zzcgt = zzakkVar.getLayoutParams();
        ViewParent parent = zzakkVar.getParent();
        this.zzaie = zzakkVar.zzry();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new zzp("Could not get the parent of the WebView for an overlay.");
        }
        this.parent = (ViewGroup) parent;
        ViewGroup viewGroup = this.parent;
        if (zzakkVar == null) {
            throw null;
        }
        this.index = viewGroup.indexOfChild((View) zzakkVar);
        ViewGroup viewGroup2 = this.parent;
        if (zzakkVar == null) {
            throw null;
        }
        viewGroup2.removeView((View) zzakkVar);
        zzakkVar.zzab(true);
    }
}

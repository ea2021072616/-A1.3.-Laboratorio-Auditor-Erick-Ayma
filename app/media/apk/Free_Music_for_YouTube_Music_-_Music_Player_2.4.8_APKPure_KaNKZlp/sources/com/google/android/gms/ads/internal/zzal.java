package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.zzajk;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzjx;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzkq;
import com.google.android.gms.internal.zzot;
import com.google.android.gms.internal.zzpx;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.internal.zzqd;
import com.google.android.gms.internal.zzqg;
import com.google.android.gms.internal.zzqj;
import com.google.android.gms.internal.zzva;
import com.google.android.gms.internal.zzzt;
@zzzt
/* loaded from: classes.dex */
public final class zzal extends zzkb {
    private final Context mContext;
    private final zzv zzamv;
    private final zzva zzana;
    private zzju zzaoq;
    private zzjb zzaou;
    private PublisherAdViewOptions zzaov;
    private zzot zzaoy;
    private zzkq zzapa;
    private final String zzapb;
    private final zzajk zzapc;
    private zzpx zzaph;
    private zzqa zzapi;
    private zzqj zzapl;
    private SimpleArrayMap<String, zzqg> zzapk = new SimpleArrayMap<>();
    private SimpleArrayMap<String, zzqd> zzapj = new SimpleArrayMap<>();

    public zzal(Context context, String str, zzva zzvaVar, zzajk zzajkVar, zzv zzvVar) {
        this.mContext = context;
        this.zzapb = str;
        this.zzana = zzvaVar;
        this.zzapc = zzajkVar;
        this.zzamv = zzvVar;
    }

    @Override // com.google.android.gms.internal.zzka
    public final void zza(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzaov = publisherAdViewOptions;
    }

    @Override // com.google.android.gms.internal.zzka
    public final void zza(zzot zzotVar) {
        this.zzaoy = zzotVar;
    }

    @Override // com.google.android.gms.internal.zzka
    public final void zza(zzpx zzpxVar) {
        this.zzaph = zzpxVar;
    }

    @Override // com.google.android.gms.internal.zzka
    public final void zza(zzqa zzqaVar) {
        this.zzapi = zzqaVar;
    }

    @Override // com.google.android.gms.internal.zzka
    public final void zza(zzqj zzqjVar, zzjb zzjbVar) {
        this.zzapl = zzqjVar;
        this.zzaou = zzjbVar;
    }

    @Override // com.google.android.gms.internal.zzka
    public final void zza(String str, zzqg zzqgVar, zzqd zzqdVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
        }
        this.zzapk.put(str, zzqgVar);
        this.zzapj.put(str, zzqdVar);
    }

    @Override // com.google.android.gms.internal.zzka
    public final void zzb(zzju zzjuVar) {
        this.zzaoq = zzjuVar;
    }

    @Override // com.google.android.gms.internal.zzka
    public final void zzb(zzkq zzkqVar) {
        this.zzapa = zzkqVar;
    }

    @Override // com.google.android.gms.internal.zzka
    public final zzjx zzcy() {
        return new zzai(this.mContext, this.zzapb, this.zzana, this.zzapc, this.zzaoq, this.zzaph, this.zzapi, this.zzapk, this.zzapj, this.zzaoy, this.zzapa, this.zzamv, this.zzapl, this.zzaou, this.zzaov);
    }
}

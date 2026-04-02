package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.internal.zzaaq;
import com.google.android.gms.internal.zzaev;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzzt;
@zzzt
/* loaded from: classes.dex */
public final class zzw {
    private final Context mContext;
    private boolean zzant;
    private zzaev zzanu;
    private zzaaq zzanv;

    public zzw(Context context, zzaev zzaevVar, zzaaq zzaaqVar) {
        this.mContext = context;
        this.zzanu = zzaevVar;
        this.zzanv = zzaaqVar;
        if (this.zzanv == null) {
            this.zzanv = new zzaaq();
        }
    }

    private final boolean zzcp() {
        return (this.zzanu != null && this.zzanu.zzpb().zzcxn) || this.zzanv.zzcqn;
    }

    public final void recordClick() {
        this.zzant = true;
    }

    public final boolean zzcq() {
        return !zzcp() || this.zzant;
    }

    public final void zzs(@Nullable String str) {
        if (zzcp()) {
            if (str == null) {
                str = "";
            }
            if (this.zzanu != null) {
                this.zzanu.zza(str, null, 3);
            } else if (this.zzanv.zzcqn && this.zzanv.zzcqo != null) {
                for (String str2 : this.zzanv.zzcqo) {
                    if (!TextUtils.isEmpty(str2)) {
                        String replace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                        zzbv.zzea();
                        zzahf.zzd(this.mContext, "", replace);
                    }
                }
            }
        }
    }
}

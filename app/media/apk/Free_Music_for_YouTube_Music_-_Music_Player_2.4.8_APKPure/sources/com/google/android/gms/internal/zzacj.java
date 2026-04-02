package com.google.android.gms.internal;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Future;
@zzzt
/* loaded from: classes.dex */
public final class zzacj {
    private WeakHashMap<Context, zzacl> zzcvd = new WeakHashMap<>();

    public final Future<zzach> zzp(Context context) {
        return zzagz.zza(zzagz.zzdbh, new zzack(this, context));
    }
}

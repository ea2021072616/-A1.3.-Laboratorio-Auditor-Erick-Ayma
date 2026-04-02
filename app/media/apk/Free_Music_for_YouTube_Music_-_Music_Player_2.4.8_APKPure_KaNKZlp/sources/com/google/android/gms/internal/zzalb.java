package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
@zzzt
/* loaded from: classes.dex */
public final class zzalb extends MutableContextWrapper {
    private Context mApplicationContext;
    private Activity zzddz;
    private Context zzdhs;

    public zzalb(Context context) {
        super(context);
        setBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return this.zzdhs.getSystemService(str);
    }

    @Override // android.content.MutableContextWrapper
    public final void setBaseContext(Context context) {
        this.mApplicationContext = context.getApplicationContext();
        this.zzddz = context instanceof Activity ? (Activity) context : null;
        this.zzdhs = context;
        super.setBaseContext(this.mApplicationContext);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent) {
        if (this.zzddz != null) {
            this.zzddz.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.mApplicationContext.startActivity(intent);
    }

    public final Activity zzrx() {
        return this.zzddz;
    }

    public final Context zzry() {
        return this.zzdhs;
    }
}

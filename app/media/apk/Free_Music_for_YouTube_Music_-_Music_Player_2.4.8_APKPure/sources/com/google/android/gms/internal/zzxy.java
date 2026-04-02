package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
@zzzt
/* loaded from: classes.dex */
public abstract class zzxy extends zzafv {
    protected final Context mContext;
    protected final Object mLock;
    protected final zzyd zzcki;
    protected final zzafj zzckj;
    protected zzaao zzckk;
    protected final Object zzckm;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzxy(Context context, zzafj zzafjVar, zzyd zzydVar) {
        super(true);
        this.mLock = new Object();
        this.zzckm = new Object();
        this.mContext = context;
        this.zzckj = zzafjVar;
        this.zzckk = zzafjVar.zzcyp;
        this.zzcki = zzydVar;
    }

    @Override // com.google.android.gms.internal.zzafv
    public void onStop() {
    }

    protected abstract void zzd(long j) throws zzyb;

    @Override // com.google.android.gms.internal.zzafv
    public final void zzdc() {
        synchronized (this.mLock) {
            zzafx.zzcb("AdRendererBackgroundTask started.");
            int i = this.zzckj.errorCode;
            try {
                zzd(SystemClock.elapsedRealtime());
            } catch (zzyb e) {
                int errorCode = e.getErrorCode();
                if (errorCode == 3 || errorCode == -1) {
                    zzafx.zzcr(e.getMessage());
                } else {
                    zzafx.zzcs(e.getMessage());
                }
                if (this.zzckk == null) {
                    this.zzckk = new zzaao(errorCode);
                } else {
                    this.zzckk = new zzaao(errorCode, this.zzckk.zzcba);
                }
                zzahf.zzdbo.post(new zzxz(this));
                i = errorCode;
            }
            zzahf.zzdbo.post(new zzya(this, zzx(i)));
        }
    }

    protected abstract zzafi zzx(int i);
}

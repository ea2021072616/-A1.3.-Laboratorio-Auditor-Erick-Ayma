package com.google.android.gms.internal;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzdei extends ContentObserver {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdei(Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        AtomicBoolean atomicBoolean;
        atomicBoolean = zzdeh.zzkvr;
        atomicBoolean.set(true);
    }
}

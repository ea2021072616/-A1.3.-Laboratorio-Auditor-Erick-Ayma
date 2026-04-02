package com.facebook.ads.internal.util;

import android.database.ContentObserver;
import android.os.Handler;
/* loaded from: classes.dex */
class aa extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private final ah f1474a;

    public aa(Handler handler, ah ahVar) {
        super(handler);
        this.f1474a = ahVar;
    }

    @Override // android.database.ContentObserver
    public boolean deliverSelfNotifications() {
        return false;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f1474a.e();
    }
}

package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import c2.f;
import c2.k;
import d.e;
import g2.a;
import x1.i;
import x1.o;
/* loaded from: classes.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f1806a = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int intValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i5 = intent.getExtras().getInt("attemptNumber");
        o.b(context);
        e a5 = i.a();
        a5.o(queryParameter);
        a5.p(a.b(intValue));
        if (queryParameter2 != null) {
            a5.f2322i = Base64.decode(queryParameter2, 0);
        }
        k kVar = o.a().f5477d;
        i b5 = a5.b();
        c2.a aVar = new c2.a();
        kVar.getClass();
        kVar.f1747e.execute(new f(kVar, b5, i5, aVar));
    }
}

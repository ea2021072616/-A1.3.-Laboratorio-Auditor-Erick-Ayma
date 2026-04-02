package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import c2.f;
import c2.k;
import d.e;
import d.v;
import g2.a;
import x1.i;
import x1.o;
/* loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ int f1807g = 0;

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i5 = jobParameters.getExtras().getInt("priority");
        int i6 = jobParameters.getExtras().getInt("attemptNumber");
        o.b(getApplicationContext());
        e a5 = i.a();
        a5.o(string);
        a5.p(a.b(i5));
        if (string2 != null) {
            a5.f2322i = Base64.decode(string2, 0);
        }
        k kVar = o.a().f5477d;
        i b5 = a5.b();
        v vVar = new v(this, 5, jobParameters);
        kVar.getClass();
        kVar.f1747e.execute(new f(kVar, b5, i6, vVar));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}

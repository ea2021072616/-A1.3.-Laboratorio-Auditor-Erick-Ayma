package com.fotoable.youtube.music.helper.localmusic;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import com.fotoable.youtube.music.MusicApplication;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
@TargetApi(21)
/* loaded from: classes.dex */
public class MusicNotifyResetService extends JobService {

    /* renamed from: a  reason: collision with root package name */
    private static JobScheduler f2739a;

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        c();
        a();
        return true;
    }

    public static void a() {
        f2739a = (JobScheduler) MusicApplication.c().getSystemService("jobscheduler");
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(MusicApplication.c(), MusicNotifyResetService.class));
        builder.setMinimumLatency(l.f2751a);
        builder.setOverrideDeadline(l.f2751a);
        builder.setBackoffCriteria(l.f2751a, 0);
        if (f2739a != null) {
            f2739a.schedule(builder.build());
        }
    }

    private void c() {
        try {
            com.fotoable.youtube.music.newplayer.b.b();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public static void b() {
        if (f2739a != null) {
            try {
                f2739a.cancel(1);
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
                f2739a.cancelAll();
            }
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}

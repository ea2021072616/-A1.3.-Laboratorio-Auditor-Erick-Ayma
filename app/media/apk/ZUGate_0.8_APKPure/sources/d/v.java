package d;

import android.app.job.JobParameters;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.profileinstaller.ProfileInstallerInitializer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import java.util.Random;
/* loaded from: classes.dex */
public final /* synthetic */ class v implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f2464b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f2465c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f2466d;

    public /* synthetic */ v(Object obj, int i5, Object obj2) {
        this.f2464b = i5;
        this.f2465c = obj;
        this.f2466d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = this.f2464b;
        Object obj = this.f2466d;
        Object obj2 = this.f2465c;
        switch (i5) {
            case 0:
                w wVar = (w) obj2;
                Runnable runnable = (Runnable) obj;
                wVar.getClass();
                try {
                    runnable.run();
                    return;
                } finally {
                    wVar.b();
                }
            case 1:
                ((y.n) obj2).onFontRetrieved((Typeface) obj);
                return;
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
            default:
                int i6 = JobInfoSchedulerService.f1807g;
                ((JobInfoSchedulerService) obj2).jobFinished((JobParameters) obj, false);
                return;
            case 3:
                u0.j jVar = (u0.j) obj;
                u0.b bVar = u0.c.f5128a;
                e4.e.f(jVar, "$violation");
                Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + ((String) obj2), jVar);
                throw jVar;
            case 4:
                Context context = (Context) obj;
                ((ProfileInstallerInitializer) obj2).getClass();
                (Build.VERSION.SDK_INT >= 28 ? z0.i.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new z0.f(context, 0), new Random().nextInt(Math.max(1000, 1)) + 5000);
                return;
        }
    }
}

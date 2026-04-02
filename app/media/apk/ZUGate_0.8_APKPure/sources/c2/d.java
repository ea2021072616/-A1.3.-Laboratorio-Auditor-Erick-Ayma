package c2;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.PersistableBundle;
import android.util.Base64;
import android.util.Log;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.Adler32;
/* loaded from: classes.dex */
public final class d implements n {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1719a;

    /* renamed from: b  reason: collision with root package name */
    public final d2.d f1720b;

    /* renamed from: c  reason: collision with root package name */
    public final b f1721c;

    public d(Context context, d2.d dVar, b bVar) {
        this.f1719a = context;
        this.f1720b = dVar;
        this.f1721c = bVar;
    }

    public final void a(x1.i iVar, int i5, boolean z4) {
        boolean z5;
        Context context = this.f1719a;
        ComponentName componentName = new ComponentName(context, JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(iVar.f5461a.getBytes(Charset.forName("UTF-8")));
        ByteBuffer allocate = ByteBuffer.allocate(4);
        u1.c cVar = iVar.f5463c;
        adler32.update(allocate.putInt(g2.a.a(cVar)).array());
        byte[] bArr = iVar.f5462b;
        if (bArr != null) {
            adler32.update(bArr);
        }
        int value = (int) adler32.getValue();
        if (!z4) {
            Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JobInfo next = it.next();
                int i6 = next.getExtras().getInt("attemptNumber");
                if (next.getId() == value) {
                    if (i6 >= i5) {
                        z5 = true;
                    }
                }
            }
            z5 = false;
            if (z5) {
                b4.j.m("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", iVar);
                return;
            }
        }
        SQLiteDatabase j5 = ((d2.k) this.f1720b).j();
        String valueOf = String.valueOf(g2.a.a(cVar));
        String str = iVar.f5461a;
        long longValue = ((Long) d2.k.L(j5.rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{str, valueOf}), new h0.h(11))).longValue();
        JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
        b bVar = this.f1721c;
        builder.setMinimumLatency(bVar.a(cVar, longValue, i5));
        Set set = ((c) bVar.f1715b.get(cVar)).f1718c;
        if (set.contains(e.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(e.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(e.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i5);
        persistableBundle.putString("backendName", str);
        persistableBundle.putInt("priority", g2.a.a(cVar));
        if (bArr != null) {
            persistableBundle.putString("extras", Base64.encodeToString(bArr, 0));
        }
        builder.setExtras(persistableBundle);
        Object[] objArr = {iVar, Integer.valueOf(value), Long.valueOf(bVar.a(cVar, longValue, i5)), Long.valueOf(longValue), Integer.valueOf(i5)};
        String x5 = b4.j.x("JobInfoScheduler");
        if (Log.isLoggable(x5, 3)) {
            Log.d(x5, String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr));
        }
        jobScheduler.schedule(builder.build());
    }
}

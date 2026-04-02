package com.facebook.ads.internal.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.facebook.ads.internal.util.w;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1354a = e.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final String f1355b = com.facebook.ads.internal.server.b.b();

    /* renamed from: c  reason: collision with root package name */
    private final a f1356c;
    private final ConnectivityManager e;
    private final com.facebook.ads.internal.i.a.a f;
    private final long h;
    private final long i;
    private volatile boolean k;
    private int l;
    private long m;
    private final Runnable j = new Runnable() { // from class: com.facebook.ads.internal.g.e.1
        /* JADX WARN: Type inference failed for: r0v5, types: [com.facebook.ads.internal.g.e$1$1] */
        @Override // java.lang.Runnable
        public void run() {
            e.this.k = false;
            if (e.this.d.getQueue().isEmpty()) {
                new AsyncTask<Void, Void, Void>() { // from class: com.facebook.ads.internal.g.e.1.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    /* renamed from: a */
                    public Void doInBackground(Void... voidArr) {
                        e.b(e.this);
                        if (e.this.m > 0) {
                            try {
                                Thread.sleep(e.this.m);
                            } catch (InterruptedException e) {
                            }
                        }
                        e.this.d();
                        return null;
                    }
                }.executeOnExecutor(e.this.d, new Void[0]);
            }
        }
    };
    private final ThreadPoolExecutor d = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    private final Handler g = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        JSONObject a();

        boolean a(JSONArray jSONArray);

        void b();

        boolean c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, a aVar) {
        this.f1356c = aVar;
        this.e = (ConnectivityManager) context.getSystemService("connectivity");
        this.f = w.b(context);
        this.h = com.facebook.ads.internal.h.f(context);
        this.i = com.facebook.ads.internal.h.g(context);
    }

    private void a(long j) {
        this.g.postDelayed(this.j, j);
    }

    static /* synthetic */ int b(e eVar) {
        int i = eVar.l + 1;
        eVar.l = i;
        return i;
    }

    private void c() {
        if (this.l >= 5) {
            e();
            b();
            return;
        }
        if (this.l == 1) {
            this.m = 2000L;
        } else {
            this.m *= 2;
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void d() {
        try {
            NetworkInfo activeNetworkInfo = this.e.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                a(this.i);
                return;
            }
            JSONObject a2 = this.f1356c.a();
            if (a2 == null) {
                e();
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("attempt", String.valueOf(this.l));
            a2.put(ShareConstants.WEB_DIALOG_PARAM_DATA, jSONObject);
            com.facebook.ads.internal.i.a.p pVar = new com.facebook.ads.internal.i.a.p();
            pVar.put(MessengerShareContentUtility.ATTACHMENT_PAYLOAD, a2.toString());
            com.facebook.ads.internal.i.a.n b2 = this.f.b(f1355b, pVar);
            String e = b2 != null ? b2.e() : null;
            if (TextUtils.isEmpty(e)) {
                c();
            } else if (b2.a() != 200) {
                c();
            } else if (!this.f1356c.a(new JSONArray(e))) {
                c();
            } else if (this.f1356c.c()) {
                c();
            } else {
                e();
            }
        } catch (Exception e2) {
            c();
        }
    }

    private void e() {
        this.l = 0;
        this.m = 0L;
        if (this.d.getQueue().size() == 0) {
            this.f1356c.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.k = true;
        this.g.removeCallbacks(this.j);
        a(this.h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.k) {
            return;
        }
        this.k = true;
        this.g.removeCallbacks(this.j);
        a(this.i);
    }
}

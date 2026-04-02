package com.google.android.youtube.player.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.youtube.player.YouTubeApiServiceUtil;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.internal.c;
import com.google.android.youtube.player.internal.i;
import com.google.android.youtube.player.internal.t;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public abstract class r<T extends IInterface> implements t {

    /* renamed from: a  reason: collision with root package name */
    final Handler f4967a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f4968b;

    /* renamed from: c  reason: collision with root package name */
    private T f4969c;
    private ArrayList<t.a> d;
    private ArrayList<t.b> g;
    private ServiceConnection j;
    private final ArrayList<t.a> e = new ArrayList<>();
    private boolean f = false;
    private boolean h = false;
    private final ArrayList<b<?>> i = new ArrayList<>();
    private boolean k = false;

    /* loaded from: classes2.dex */
    final class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what == 3) {
                r.this.a((YouTubeInitializationResult) message.obj);
            } else if (message.what == 4) {
                synchronized (r.this.d) {
                    if (r.this.k && r.this.f() && r.this.d.contains(message.obj)) {
                        ((t.a) message.obj).a();
                    }
                }
            } else if (message.what != 2 || r.this.f()) {
                if (message.what == 2 || message.what == 1) {
                    ((b) message.obj).a();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    protected abstract class b<TListener> {

        /* renamed from: b  reason: collision with root package name */
        private TListener f4973b;

        public b(TListener tlistener) {
            this.f4973b = tlistener;
            synchronized (r.this.i) {
                r.this.i.add(this);
            }
        }

        public final void a() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.f4973b;
            }
            a(tlistener);
        }

        protected abstract void a(TListener tlistener);

        public final void b() {
            synchronized (this) {
                this.f4973b = null;
            }
        }
    }

    /* loaded from: classes2.dex */
    protected final class c extends b<Boolean> {

        /* renamed from: b  reason: collision with root package name */
        public final YouTubeInitializationResult f4974b;

        /* renamed from: c  reason: collision with root package name */
        public final IBinder f4975c;

        public c(String str, IBinder iBinder) {
            super(true);
            this.f4974b = r.b(str);
            this.f4975c = iBinder;
        }

        @Override // com.google.android.youtube.player.internal.r.b
        protected final /* synthetic */ void a(Boolean bool) {
            if (bool != null) {
                switch (this.f4974b) {
                    case SUCCESS:
                        try {
                            if (r.this.b().equals(this.f4975c.getInterfaceDescriptor())) {
                                r.this.f4969c = r.this.a(this.f4975c);
                                if (r.this.f4969c != null) {
                                    r.this.g();
                                    return;
                                }
                            }
                        } catch (RemoteException e) {
                        }
                        r.this.a();
                        r.this.a(YouTubeInitializationResult.INTERNAL_ERROR);
                        return;
                    default:
                        r.this.a(this.f4974b);
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public final class d extends c.a {
        protected d() {
        }

        @Override // com.google.android.youtube.player.internal.c
        public final void a(String str, IBinder iBinder) {
            r.this.f4967a.sendMessage(r.this.f4967a.obtainMessage(1, new c(str, iBinder)));
        }
    }

    /* loaded from: classes2.dex */
    final class e implements ServiceConnection {
        e() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            r.this.b(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            r.this.f4969c = null;
            r.this.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public r(Context context, t.a aVar, t.b bVar) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Clients must be created on the UI thread.");
        }
        this.f4968b = (Context) ab.a(context);
        this.d = new ArrayList<>();
        this.d.add(ab.a(aVar));
        this.g = new ArrayList<>();
        this.g.add(ab.a(bVar));
        this.f4967a = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.j != null) {
            try {
                this.f4968b.unbindService(this.j);
            } catch (IllegalArgumentException e2) {
                Log.w("YouTubeClient", "Unexpected error from unbindService()", e2);
            }
        }
        this.f4969c = null;
        this.j = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static YouTubeInitializationResult b(String str) {
        try {
            return YouTubeInitializationResult.valueOf(str);
        } catch (IllegalArgumentException e2) {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        } catch (NullPointerException e3) {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        }
    }

    protected abstract T a(IBinder iBinder);

    protected final void a(YouTubeInitializationResult youTubeInitializationResult) {
        this.f4967a.removeMessages(4);
        synchronized (this.g) {
            this.h = true;
            ArrayList<t.b> arrayList = this.g;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (!this.k) {
                    return;
                }
                if (this.g.contains(arrayList.get(i))) {
                    arrayList.get(i).a(youTubeInitializationResult);
                }
            }
            this.h = false;
        }
    }

    protected abstract void a(i iVar, d dVar) throws RemoteException;

    protected abstract String b();

    protected final void b(IBinder iBinder) {
        try {
            a(i.a.a(iBinder), new d());
        } catch (RemoteException e2) {
            Log.w("YouTubeClient", "service died");
        }
    }

    protected abstract String c();

    @Override // com.google.android.youtube.player.internal.t
    public void d() {
        h();
        this.k = false;
        synchronized (this.i) {
            int size = this.i.size();
            for (int i = 0; i < size; i++) {
                this.i.get(i).b();
            }
            this.i.clear();
        }
        a();
    }

    @Override // com.google.android.youtube.player.internal.t
    public final void e() {
        this.k = true;
        YouTubeInitializationResult isYouTubeApiServiceAvailable = YouTubeApiServiceUtil.isYouTubeApiServiceAvailable(this.f4968b);
        if (isYouTubeApiServiceAvailable != YouTubeInitializationResult.SUCCESS) {
            this.f4967a.sendMessage(this.f4967a.obtainMessage(3, isYouTubeApiServiceAvailable));
            return;
        }
        Intent intent = new Intent(c()).setPackage(z.a(this.f4968b));
        if (this.j != null) {
            Log.e("YouTubeClient", "Calling connect() while still connected, missing disconnect().");
            a();
        }
        this.j = new e();
        if (this.f4968b.bindService(intent, this.j, TsExtractor.TS_STREAM_TYPE_AC3)) {
            return;
        }
        this.f4967a.sendMessage(this.f4967a.obtainMessage(3, YouTubeInitializationResult.ERROR_CONNECTING_TO_SERVICE));
    }

    public final boolean f() {
        return this.f4969c != null;
    }

    protected final void g() {
        synchronized (this.d) {
            ab.a(!this.f);
            this.f4967a.removeMessages(4);
            this.f = true;
            ab.a(this.e.size() == 0);
            ArrayList<t.a> arrayList = this.d;
            int size = arrayList.size();
            for (int i = 0; i < size && this.k && f(); i++) {
                if (!this.e.contains(arrayList.get(i))) {
                    arrayList.get(i).a();
                }
            }
            this.e.clear();
            this.f = false;
        }
    }

    protected final void h() {
        this.f4967a.removeMessages(4);
        synchronized (this.d) {
            this.f = true;
            ArrayList<t.a> arrayList = this.d;
            int size = arrayList.size();
            for (int i = 0; i < size && this.k; i++) {
                if (this.d.contains(arrayList.get(i))) {
                    arrayList.get(i).b();
                }
            }
            this.f = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i() {
        if (!f()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final T j() {
        i();
        return this.f4969c;
    }
}

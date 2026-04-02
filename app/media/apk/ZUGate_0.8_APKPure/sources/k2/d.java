package k2;

import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.appcompat.widget.d0;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.play_billing.i0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import l2.g0;
/* loaded from: classes.dex */
public final class d implements Handler.Callback {
    public static final Status o = new Status(4, "Sign-out occurred while this API call was in progress.", null, null);

    /* renamed from: p  reason: collision with root package name */
    public static final Status f3574p = new Status(4, "The user must be signed in to make this API call.", null, null);

    /* renamed from: q  reason: collision with root package name */
    public static final Object f3575q = new Object();

    /* renamed from: r  reason: collision with root package name */
    public static d f3576r;

    /* renamed from: a  reason: collision with root package name */
    public long f3577a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3578b;

    /* renamed from: c  reason: collision with root package name */
    public l2.k f3579c;

    /* renamed from: d  reason: collision with root package name */
    public n2.d f3580d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f3581e;

    /* renamed from: f  reason: collision with root package name */
    public final i2.d f3582f;

    /* renamed from: g  reason: collision with root package name */
    public final d0 f3583g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicInteger f3584h;

    /* renamed from: i  reason: collision with root package name */
    public final AtomicInteger f3585i;

    /* renamed from: j  reason: collision with root package name */
    public final ConcurrentHashMap f3586j;

    /* renamed from: k  reason: collision with root package name */
    public final l.c f3587k;

    /* renamed from: l  reason: collision with root package name */
    public final l.c f3588l;

    /* renamed from: m  reason: collision with root package name */
    public final r2.d f3589m;

    /* renamed from: n  reason: collision with root package name */
    public volatile boolean f3590n;

    public d(Context context, Looper looper) {
        i2.d dVar = i2.d.f3391c;
        this.f3577a = 10000L;
        this.f3578b = false;
        this.f3584h = new AtomicInteger(1);
        this.f3585i = new AtomicInteger(0);
        this.f3586j = new ConcurrentHashMap(5, 0.75f, 1);
        this.f3587k = new l.c(0);
        this.f3588l = new l.c(0);
        this.f3590n = true;
        this.f3581e = context;
        r2.d dVar2 = new r2.d(looper, this, 0);
        this.f3589m = dVar2;
        this.f3582f = dVar;
        this.f3583g = new d0((androidx.appcompat.widget.b0) null);
        PackageManager packageManager = context.getPackageManager();
        if (b4.j.f1681u == null) {
            b4.j.f1681u = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (b4.j.f1681u.booleanValue()) {
            this.f3590n = false;
        }
        dVar2.sendMessage(dVar2.obtainMessage(6));
    }

    public static Status c(a aVar, i2.a aVar2) {
        String valueOf = String.valueOf(aVar2);
        return new Status(17, "API: " + ((String) aVar.f3561b.f2323j) + " is not available on this device. Connection failed with: " + valueOf, aVar2.f3382d, aVar2);
    }

    public static d e(Context context) {
        d dVar;
        HandlerThread handlerThread;
        synchronized (f3575q) {
            try {
                if (f3576r == null) {
                    synchronized (g0.f3831h) {
                        handlerThread = g0.f3833j;
                        if (handlerThread == null) {
                            HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                            g0.f3833j = handlerThread2;
                            handlerThread2.start();
                            handlerThread = g0.f3833j;
                        }
                    }
                    Looper looper = handlerThread.getLooper();
                    Context applicationContext = context.getApplicationContext();
                    Object obj = i2.d.f3390b;
                    f3576r = new d(applicationContext, looper);
                }
                dVar = f3576r;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    public final boolean a() {
        if (this.f3578b) {
            return false;
        }
        l2.i.d().getClass();
        int i5 = ((SparseIntArray) this.f3583g.f306h).get(203400000, -1);
        return i5 == -1 || i5 == 0;
    }

    public final boolean b(i2.a aVar, int i5) {
        boolean booleanValue;
        PendingIntent activity;
        Boolean bool;
        i2.d dVar = this.f3582f;
        Context context = this.f3581e;
        dVar.getClass();
        synchronized (p2.a.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = p2.a.f4246a;
            if (context2 != null && (bool = p2.a.f4247b) != null && context2 == applicationContext) {
                booleanValue = bool.booleanValue();
            }
            p2.a.f4247b = null;
            Boolean valueOf = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
            p2.a.f4247b = valueOf;
            p2.a.f4246a = applicationContext;
            booleanValue = valueOf.booleanValue();
        }
        if (booleanValue) {
            return false;
        }
        int i6 = aVar.f3381c;
        if ((i6 == 0 || aVar.f3382d == null) ? false : true) {
            activity = aVar.f3382d;
        } else {
            Intent a5 = dVar.a(i6, context, null);
            activity = a5 != null ? PendingIntent.getActivity(context, 0, a5, 201326592) : null;
        }
        if (activity != null) {
            int i7 = aVar.f3381c;
            int i8 = GoogleApiActivity.f1821h;
            Intent intent = new Intent(context, GoogleApiActivity.class);
            intent.putExtra("pending_intent", activity);
            intent.putExtra("failing_client_id", i5);
            intent.putExtra("notify_manager", true);
            dVar.g(context, i7, PendingIntent.getActivity(context, 0, intent, r2.c.f4490a | 134217728));
            return true;
        }
        return false;
    }

    public final o d(j2.e eVar) {
        ConcurrentHashMap concurrentHashMap = this.f3586j;
        a aVar = eVar.f3446e;
        o oVar = (o) concurrentHashMap.get(aVar);
        if (oVar == null) {
            oVar = new o(this, eVar);
            concurrentHashMap.put(aVar, oVar);
        }
        if (oVar.f3598b.e()) {
            this.f3588l.add(aVar);
        }
        oVar.m();
        return oVar;
    }

    public final void f(i2.a aVar, int i5) {
        if (b(aVar, i5)) {
            return;
        }
        r2.d dVar = this.f3589m;
        dVar.sendMessage(dVar.obtainMessage(5, i5, 0, aVar));
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        o oVar;
        i2.c[] b5;
        boolean z4;
        int i5 = message.what;
        int i6 = 0;
        switch (i5) {
            case 1:
                this.f3577a = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.f3589m.removeMessages(12);
                for (a aVar : this.f3586j.keySet()) {
                    r2.d dVar = this.f3589m;
                    dVar.sendMessageDelayed(dVar.obtainMessage(12, aVar), this.f3577a);
                }
                break;
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                androidx.appcompat.widget.b0.n(message.obj);
                throw null;
            case 3:
                for (o oVar2 : this.f3586j.values()) {
                    i0.g(oVar2.f3608l.f3589m);
                    oVar2.f3607k = null;
                    oVar2.m();
                }
                break;
            case 4:
            case 8:
            case 13:
                v vVar = (v) message.obj;
                o oVar3 = (o) this.f3586j.get(vVar.f3625c.f3446e);
                if (oVar3 == null) {
                    oVar3 = d(vVar.f3625c);
                }
                if (!oVar3.f3598b.e() || this.f3585i.get() == vVar.f3624b) {
                    oVar3.n(vVar.f3623a);
                    break;
                } else {
                    vVar.f3623a.c(o);
                    oVar3.q();
                    break;
                }
            case 5:
                int i7 = message.arg1;
                i2.a aVar2 = (i2.a) message.obj;
                Iterator it = this.f3586j.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        oVar = (o) it.next();
                        if (oVar.f3603g == i7) {
                        }
                    } else {
                        oVar = null;
                    }
                }
                if (oVar != null) {
                    int i8 = aVar2.f3381c;
                    if (i8 == 13) {
                        this.f3582f.getClass();
                        AtomicBoolean atomicBoolean = i2.g.f3394a;
                        oVar.e(new Status(17, "Error resolution was canceled by the user, original error message: " + i2.a.a(i8) + ": " + aVar2.f3383e, null, null));
                        break;
                    } else {
                        oVar.e(c(oVar.f3599c, aVar2));
                        break;
                    }
                } else {
                    Log.wtf("GoogleApiManager", "Could not find API instance " + i7 + " while trying to fail enqueued calls.", new Exception());
                    break;
                }
            case 6:
                if (this.f3581e.getApplicationContext() instanceof Application) {
                    Application application = (Application) this.f3581e.getApplicationContext();
                    b bVar = b.f3566k;
                    synchronized (bVar) {
                        if (!bVar.f3570j) {
                            application.registerActivityLifecycleCallbacks(bVar);
                            application.registerComponentCallbacks(bVar);
                            bVar.f3570j = true;
                        }
                    }
                    l lVar = new l(this);
                    synchronized (bVar) {
                        bVar.f3569i.add(lVar);
                    }
                    AtomicBoolean atomicBoolean2 = bVar.f3568h;
                    boolean z5 = atomicBoolean2.get();
                    AtomicBoolean atomicBoolean3 = bVar.f3567g;
                    if (!z5) {
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                        ActivityManager.getMyMemoryState(runningAppProcessInfo);
                        if (!atomicBoolean2.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                            atomicBoolean3.set(true);
                        }
                    }
                    if (!atomicBoolean3.get()) {
                        this.f3577a = 300000L;
                        break;
                    }
                }
                break;
            case 7:
                d((j2.e) message.obj);
                break;
            case 9:
                if (this.f3586j.containsKey(message.obj)) {
                    o oVar4 = (o) this.f3586j.get(message.obj);
                    i0.g(oVar4.f3608l.f3589m);
                    if (oVar4.f3605i) {
                        oVar4.m();
                        break;
                    }
                }
                break;
            case 10:
                Iterator it2 = this.f3588l.iterator();
                while (it2.hasNext()) {
                    o oVar5 = (o) this.f3586j.remove((a) it2.next());
                    if (oVar5 != null) {
                        oVar5.q();
                    }
                }
                this.f3588l.clear();
                break;
            case 11:
                if (this.f3586j.containsKey(message.obj)) {
                    o oVar6 = (o) this.f3586j.get(message.obj);
                    d dVar2 = oVar6.f3608l;
                    i0.g(dVar2.f3589m);
                    boolean z6 = oVar6.f3605i;
                    if (z6) {
                        if (z6) {
                            d dVar3 = oVar6.f3608l;
                            r2.d dVar4 = dVar3.f3589m;
                            a aVar3 = oVar6.f3599c;
                            dVar4.removeMessages(11, aVar3);
                            dVar3.f3589m.removeMessages(9, aVar3);
                            oVar6.f3605i = false;
                        }
                        oVar6.e(dVar2.f3582f.c(dVar2.f3581e) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.", null, null) : new Status(22, "API failed to connect while resuming due to an unknown error.", null, null));
                        oVar6.f3598b.d("Timing out connection while resuming.");
                        break;
                    }
                }
                break;
            case 12:
                if (this.f3586j.containsKey(message.obj)) {
                    o oVar7 = (o) this.f3586j.get(message.obj);
                    i0.g(oVar7.f3608l.f3589m);
                    l2.f fVar = oVar7.f3598b;
                    if (fVar.p() && oVar7.f3602f.isEmpty()) {
                        d0 d0Var = oVar7.f3600d;
                        if (((((Map) d0Var.f306h).isEmpty() && ((Map) d0Var.f307i).isEmpty()) ? 1 : 1) != 0) {
                            oVar7.j();
                            break;
                        } else {
                            fVar.d("Timing out service connection.");
                            break;
                        }
                    }
                }
                break;
            case 14:
                androidx.appcompat.widget.b0.n(message.obj);
                throw null;
            case 15:
                p pVar = (p) message.obj;
                if (this.f3586j.containsKey(pVar.f3609a)) {
                    o oVar8 = (o) this.f3586j.get(pVar.f3609a);
                    if (oVar8.f3606j.contains(pVar) && !oVar8.f3605i) {
                        if (oVar8.f3598b.p()) {
                            oVar8.g();
                            break;
                        } else {
                            oVar8.m();
                            break;
                        }
                    }
                }
                break;
            case 16:
                p pVar2 = (p) message.obj;
                if (this.f3586j.containsKey(pVar2.f3609a)) {
                    o oVar9 = (o) this.f3586j.get(pVar2.f3609a);
                    if (oVar9.f3606j.remove(pVar2)) {
                        d dVar5 = oVar9.f3608l;
                        dVar5.f3589m.removeMessages(15, pVar2);
                        dVar5.f3589m.removeMessages(16, pVar2);
                        i2.c cVar = pVar2.f3610b;
                        LinkedList<s> linkedList = oVar9.f3597a;
                        ArrayList arrayList = new ArrayList(linkedList.size());
                        for (s sVar : linkedList) {
                            if ((sVar instanceof s) && (b5 = sVar.b(oVar9)) != null) {
                                int length = b5.length;
                                int i9 = 0;
                                while (true) {
                                    if (i9 < length) {
                                        if (!b4.j.p(b5[i9], cVar)) {
                                            i9++;
                                        } else if (i9 >= 0) {
                                            z4 = true;
                                        }
                                    }
                                }
                                z4 = false;
                                if (z4) {
                                    arrayList.add(sVar);
                                }
                            }
                        }
                        int size = arrayList.size();
                        while (i6 < size) {
                            s sVar2 = (s) arrayList.get(i6);
                            linkedList.remove(sVar2);
                            sVar2.d(new j2.i(cVar));
                            i6++;
                        }
                        break;
                    }
                }
                break;
            case 17:
                l2.k kVar = this.f3579c;
                if (kVar != null) {
                    if (kVar.f3866b > 0 || a()) {
                        if (this.f3580d == null) {
                            this.f3580d = new n2.d(this.f3581e);
                        }
                        this.f3580d.b(kVar);
                    }
                    this.f3579c = null;
                    break;
                }
                break;
            case 18:
                u uVar = (u) message.obj;
                if (uVar.f3621c == 0) {
                    l2.k kVar2 = new l2.k(uVar.f3620b, Arrays.asList(uVar.f3619a));
                    if (this.f3580d == null) {
                        this.f3580d = new n2.d(this.f3581e);
                    }
                    this.f3580d.b(kVar2);
                    break;
                } else {
                    l2.k kVar3 = this.f3579c;
                    if (kVar3 != null) {
                        List list = kVar3.f3867c;
                        if (kVar3.f3866b != uVar.f3620b || (list != null && list.size() >= uVar.f3622d)) {
                            this.f3589m.removeMessages(17);
                            l2.k kVar4 = this.f3579c;
                            if (kVar4 != null) {
                                if (kVar4.f3866b > 0 || a()) {
                                    if (this.f3580d == null) {
                                        this.f3580d = new n2.d(this.f3581e);
                                    }
                                    this.f3580d.b(kVar4);
                                }
                                this.f3579c = null;
                            }
                        } else {
                            l2.k kVar5 = this.f3579c;
                            l2.h hVar = uVar.f3619a;
                            if (kVar5.f3867c == null) {
                                kVar5.f3867c = new ArrayList();
                            }
                            kVar5.f3867c.add(hVar);
                        }
                    }
                    if (this.f3579c == null) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(uVar.f3619a);
                        this.f3579c = new l2.k(uVar.f3620b, arrayList2);
                        r2.d dVar6 = this.f3589m;
                        dVar6.sendMessageDelayed(dVar6.obtainMessage(17), uVar.f3621c);
                        break;
                    }
                }
                break;
            case 19:
                this.f3578b = false;
                break;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + i5);
                return false;
        }
        return true;
    }
}

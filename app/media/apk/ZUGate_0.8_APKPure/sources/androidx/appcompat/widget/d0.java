package androidx.appcompat.widget;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Handler;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import com.android.billingclient.api.Purchase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class d0 implements y0.m, h0.x, h1.t, z1.b, v2.b, h1.b {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f305g;

    /* renamed from: h  reason: collision with root package name */
    public Object f306h;

    /* renamed from: i  reason: collision with root package name */
    public Object f307i;

    public d0(int i5) {
        this.f305g = i5;
        if (i5 == 15) {
            this.f306h = "";
            this.f307i = new ArrayList();
        } else if (i5 == 16) {
            this.f307i = new HashMap();
        } else if (i5 != 19) {
        } else {
            this.f306h = Collections.synchronizedMap(new WeakHashMap());
            this.f307i = Collections.synchronizedMap(new WeakHashMap());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0122  */
    @Override // h0.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final h0.h2 a(android.view.View r17, h0.h2 r18) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.d0.a(android.view.View, h0.h2):h0.h2");
    }

    @Override // h1.b
    public final void b(h1.g gVar) {
        if (gVar.f3283b != 0) {
            Activity activity = ((y4.i) this.f307i).f5735b;
            Toast.makeText(activity, "Error on setup (code " + gVar.f3283b + ")", 0).show();
            ((Dialog) this.f306h).dismiss();
            ((y4.i) this.f307i).f5734a.a();
            return;
        }
        ArrayList arrayList = new ArrayList(3);
        h1.l lVar = new h1.l(0);
        lVar.f3297a = "zugate_donate_1";
        lVar.f3298b = "inapp";
        arrayList.add(lVar.a());
        h1.l lVar2 = new h1.l(0);
        lVar2.f3297a = "zugate_donate_5";
        lVar2.f3298b = "inapp";
        arrayList.add(lVar2.a());
        h1.l lVar3 = new h1.l(0);
        lVar3.f3297a = "zugate_donate_10";
        lVar3.f3298b = "inapp";
        arrayList.add(lVar3.a());
        d.u0 u0Var = new d.u0((b0) null);
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("Product list cannot be empty.");
        }
        HashSet hashSet = new HashSet();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            h1.m mVar = (h1.m) it.next();
            if (!"play_pass_subs".equals(mVar.f3300b)) {
                hashSet.add(mVar.f3300b);
            }
        }
        if (hashSet.size() > 1) {
            throw new IllegalArgumentException("All products should be of the same product type.");
        }
        u0Var.f2463h = com.google.android.gms.internal.play_billing.f.l(arrayList);
        h1.n nVar = new h1.n(u0Var);
        h1.a aVar = ((y4.i) this.f307i).f5734a;
        n2.b bVar = new n2.b(this);
        if (!aVar.b()) {
            h1.g gVar2 = h1.u.f3327j;
            aVar.i(h1.s.a(2, 7, gVar2));
            bVar.f(gVar2, new ArrayList());
        } else if (!aVar.f3255p) {
            com.google.android.gms.internal.play_billing.s.e("BillingClient", "Querying product details is not supported.");
            h1.g gVar3 = h1.u.o;
            aVar.i(h1.s.a(20, 7, gVar3));
            bVar.f(gVar3, new ArrayList());
        } else if (aVar.h(new h1.o(aVar, nVar, bVar, 0), 30000L, new k(aVar, bVar, 6), aVar.d()) == null) {
            h1.g f5 = aVar.f();
            aVar.i(h1.s.a(25, 7, f5));
            bVar.f(f5, new ArrayList());
        }
    }

    @Override // y0.m
    public final void c(Preference preference) {
        ((PreferenceGroup) this.f306h).D(Integer.MAX_VALUE);
        y0.v vVar = (y0.v) this.f307i;
        Handler handler = vVar.f5652n;
        androidx.activity.j jVar = vVar.o;
        handler.removeCallbacks(jVar);
        handler.post(jVar);
        ((PreferenceGroup) this.f306h).getClass();
    }

    @Override // v2.b
    public final void d(v2.g gVar) {
        ((Map) ((d0) this.f307i).f307i).remove((v2.c) this.f306h);
    }

    @Override // h1.b
    public final void e() {
        ((Dialog) this.f306h).dismiss();
    }

    public final void f(Object obj, String str) {
        String valueOf = String.valueOf(obj);
        ((List) this.f306h).add(str + "=" + valueOf);
    }

    public final v3.c g() {
        return new v3.c((String) this.f306h, ((Map) this.f307i) == null ? Collections.emptyMap() : Collections.unmodifiableMap(new HashMap((Map) this.f307i)));
    }

    @Override // z3.a
    public final Object get() {
        return new y1.f((Context) ((z3.a) this.f306h).get(), (y1.d) ((z3.a) this.f307i).get());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.datatransport.cct.CctBackendFactory h(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.d0.h(java.lang.String):com.google.android.datatransport.cct.CctBackendFactory");
    }

    public final KeyListener i(KeyListener keyListener) {
        return (keyListener instanceof NumberKeyListener) ^ true ? ((p3.e) ((s0.b) this.f307i).f4806a).i(keyListener) : keyListener;
    }

    public final void j(AttributeSet attributeSet, int i5) {
        TypedArray obtainStyledAttributes = ((EditText) this.f306h).getContext().obtainStyledAttributes(attributeSet, c.a.f1692i, i5, 0);
        try {
            boolean z4 = obtainStyledAttributes.hasValue(14) ? obtainStyledAttributes.getBoolean(14, true) : true;
            obtainStyledAttributes.recycle();
            ((p3.e) ((s0.b) this.f307i).f4806a).w(z4);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void k(h1.g gVar) {
        if (gVar.f3283b == 0) {
            Iterator it = ((Purchase) this.f306h).a().iterator();
            while (it.hasNext()) {
                ((y4.i) this.f307i).f5736c.a((String) it.next(), false);
            }
        }
        ((y4.i) this.f307i).f5734a.a();
    }

    public final InputConnection l(InputConnection inputConnection, EditorInfo editorInfo) {
        s0.b bVar = (s0.b) this.f307i;
        if (inputConnection == null) {
            bVar.getClass();
            return null;
        }
        return ((p3.e) bVar.f4806a).r(inputConnection, editorInfo);
    }

    public final void m(e0.e eVar) {
        int i5 = eVar.f2572b;
        if (i5 == 0) {
            ((Handler) this.f307i).post(new e0.a(this, (d.u0) this.f306h, eVar.f2571a, 0));
        } else {
            ((Handler) this.f307i).post(new androidx.activity.h(i5, 3, this, (d.u0) this.f306h));
        }
    }

    public final void n(y3.a aVar) {
        if (((Map) this.f307i) == null) {
            this.f307i = new HashMap();
        }
        ((Map) this.f307i).put(y3.e.class, aVar);
    }

    public final void o() {
        ((k2.i) ((k) this.f307i).f395d).getClass();
        throw null;
    }

    public final int p(Context context, l2.f fVar) {
        com.google.android.gms.internal.play_billing.i0.j(context);
        com.google.android.gms.internal.play_billing.i0.j(fVar);
        int g5 = fVar.g();
        int i5 = ((SparseIntArray) this.f306h).get(g5, -1);
        if (i5 == -1) {
            i5 = 0;
            int i6 = 0;
            while (true) {
                if (i6 >= ((SparseIntArray) this.f306h).size()) {
                    i5 = -1;
                    break;
                }
                int keyAt = ((SparseIntArray) this.f306h).keyAt(i6);
                if (keyAt > g5 && ((SparseIntArray) this.f306h).get(keyAt) == 0) {
                    break;
                }
                i6++;
            }
            if (i5 == -1) {
                i5 = ((i2.e) this.f307i).b(context, g5);
            }
            ((SparseIntArray) this.f306h).put(g5, i5);
        }
        return i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(boolean r5, com.google.android.gms.common.api.Status r6) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f306h
            java.util.Map r0 = (java.util.Map) r0
            monitor-enter(r0)
            java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Throwable -> L80
            java.lang.Object r2 = r4.f306h     // Catch: java.lang.Throwable -> L80
            java.util.Map r2 = (java.util.Map) r2     // Catch: java.lang.Throwable -> L80
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L80
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L80
            java.lang.Object r0 = r4.f307i
            r2 = r0
            java.util.Map r2 = (java.util.Map) r2
            monitor-enter(r2)
            java.util.HashMap r0 = new java.util.HashMap     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r3 = r4.f307i     // Catch: java.lang.Throwable -> L7d
            java.util.Map r3 = (java.util.Map) r3     // Catch: java.lang.Throwable -> L7d
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L7d
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L7d
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L27:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L4b
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            if (r5 != 0) goto L42
            java.lang.Object r3 = r2.getValue()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 != 0) goto L42
            goto L27
        L42:
            java.lang.Object r5 = r2.getKey()
            androidx.appcompat.widget.b0.n(r5)
            r5 = 0
            throw r5
        L4b:
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L53:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L7c
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            if (r5 != 0) goto L6d
            java.lang.Object r2 = r1.getValue()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L53
        L6d:
            java.lang.Object r1 = r1.getKey()
            v2.c r1 = (v2.c) r1
            j2.c r2 = new j2.c
            r2.<init>(r6)
            r1.a(r2)
            goto L53
        L7c:
            return
        L7d:
            r5 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L7d
            throw r5
        L80:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L80
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.d0.q(boolean, com.google.android.gms.common.api.Status):void");
    }

    public final void r(com.google.android.gms.internal.play_billing.j2 j2Var) {
        if (j2Var == null) {
            return;
        }
        try {
            com.google.android.gms.internal.play_billing.c3 q5 = com.google.android.gms.internal.play_billing.d3.q();
            q5.c();
            com.google.android.gms.internal.play_billing.d3.n((com.google.android.gms.internal.play_billing.d3) q5.f1903c, (com.google.android.gms.internal.play_billing.y2) this.f306h);
            q5.c();
            com.google.android.gms.internal.play_billing.d3.o((com.google.android.gms.internal.play_billing.d3) q5.f1903c, j2Var);
            ((d.w0) this.f307i).a((com.google.android.gms.internal.play_billing.d3) q5.a());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.s.f("BillingLogger", "Unable to log.", th);
        }
    }

    public final void s(com.google.android.gms.internal.play_billing.m2 m2Var) {
        if (m2Var == null) {
            return;
        }
        try {
            com.google.android.gms.internal.play_billing.c3 q5 = com.google.android.gms.internal.play_billing.d3.q();
            q5.c();
            com.google.android.gms.internal.play_billing.d3.n((com.google.android.gms.internal.play_billing.d3) q5.f1903c, (com.google.android.gms.internal.play_billing.y2) this.f306h);
            q5.c();
            com.google.android.gms.internal.play_billing.d3.p((com.google.android.gms.internal.play_billing.d3) q5.f1903c, m2Var);
            ((d.w0) this.f307i).a((com.google.android.gms.internal.play_billing.d3) q5.a());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.s.f("BillingLogger", "Unable to log.", th);
        }
    }

    public final String toString() {
        switch (this.f305g) {
            case 4:
                return "Bounds{lower=" + ((z.c) this.f306h) + " upper=" + ((z.c) this.f307i) + "}";
            case 21:
                StringBuilder sb = new StringBuilder(100);
                sb.append(this.f307i.getClass().getSimpleName());
                sb.append('{');
                int size = ((List) this.f306h).size();
                for (int i5 = 0; i5 < size; i5++) {
                    sb.append((String) ((List) this.f306h).get(i5));
                    if (i5 < size - 1) {
                        sb.append(", ");
                    }
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ d0(int i5, Object obj) {
        this.f305g = i5;
        this.f307i = null;
        this.f306h = obj;
    }

    public d0(k kVar, AlertDialog alertDialog) {
        this.f305g = 20;
        this.f307i = kVar;
        this.f306h = alertDialog;
    }

    public d0(b0 b0Var) {
        i2.d dVar = i2.d.f3391c;
        this.f305g = 22;
        this.f306h = new SparseIntArray();
        this.f307i = dVar;
    }

    public /* synthetic */ d0(c0 c0Var) {
        this.f305g = 7;
    }

    public /* synthetic */ d0(Object obj, int i5, Object obj2) {
        this.f305g = i5;
        this.f306h = obj;
        this.f307i = obj2;
    }

    public /* synthetic */ d0(Object obj, Object obj2, int i5) {
        this.f305g = i5;
        this.f307i = obj;
        this.f306h = obj2;
    }

    public d0(Context context, com.google.android.gms.internal.play_billing.y2 y2Var) {
        this.f305g = 8;
        this.f307i = new d.w0(context);
        this.f306h = y2Var;
    }

    public /* synthetic */ d0(Object obj) {
        this.f305g = 21;
        com.google.android.gms.internal.play_billing.i0.j(obj);
        this.f307i = obj;
        this.f306h = new ArrayList();
    }

    public d0(TextView textView) {
        this.f305g = 1;
        textView.getClass();
        this.f306h = textView;
    }

    public d0(EditText editText) {
        this.f305g = 0;
        this.f306h = editText;
        this.f307i = new s0.b(editText);
    }

    public d0(ArrayList arrayList, ArrayList arrayList2) {
        this.f305g = 2;
        int size = arrayList.size();
        this.f306h = new int[size];
        this.f307i = new float[size];
        for (int i5 = 0; i5 < size; i5++) {
            ((int[]) this.f306h)[i5] = ((Integer) arrayList.get(i5)).intValue();
            ((float[]) this.f307i)[i5] = ((Float) arrayList2.get(i5)).floatValue();
        }
    }

    public d0(int i5, int i6) {
        this.f305g = 2;
        this.f306h = new int[]{i5, i6};
        this.f307i = new float[]{0.0f, 1.0f};
    }

    public d0(int i5, int i6, int i7) {
        this.f305g = 2;
        this.f306h = new int[]{i5, i6, i7};
        this.f307i = new float[]{0.0f, 0.5f, 1.0f};
    }

    public d0(androidx.viewpager.widget.l lVar) {
        this.f305g = 6;
        this.f307i = lVar;
        this.f306h = new Rect();
    }

    public d0(d3.f fVar, d3.f fVar2) {
        this.f305g = 23;
        fVar.getClass();
        fVar2.getClass();
        if (0.0f <= 0.0f) {
            this.f306h = fVar;
            this.f307i = fVar2;
            return;
        }
        throw new IllegalArgumentException();
    }
}

package d;

import android.animation.Animator;
import android.content.ClipDescription;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import android.util.Log;
import androidx.fragment.app.s1;
import java.io.ByteArrayOutputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
/* loaded from: classes.dex */
public final class e implements n0.j, m0.c, d0.b {

    /* renamed from: k  reason: collision with root package name */
    public static e f2319k;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f2320g;

    /* renamed from: h  reason: collision with root package name */
    public Object f2321h;

    /* renamed from: i  reason: collision with root package name */
    public Object f2322i;

    /* renamed from: j  reason: collision with root package name */
    public Object f2323j;

    public e(int i5) {
        this.f2320g = i5;
    }

    public static String h(int i5) {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < i5; i6++) {
            int nextInt = secureRandom.nextInt(68);
            if (nextInt < 10) {
                sb.append(nextInt);
            } else if (nextInt < 16) {
                sb.append(",.!@#$".charAt(nextInt - 10));
            } else if (nextInt < 42) {
                sb.append((char) ((nextInt + 97) - 16));
            } else {
                sb.append((char) ((nextInt + 65) - 42));
            }
        }
        return sb.toString();
    }

    public final c2.c a() {
        String str = ((Long) this.f2321h) == null ? " delta" : "";
        if (((Long) this.f2322i) == null) {
            str = str.concat(" maxAllowedDelay");
        }
        if (((Set) this.f2323j) == null) {
            str = androidx.appcompat.widget.b0.h(str, " flags");
        }
        if (str.isEmpty()) {
            return new c2.c(((Long) this.f2321h).longValue(), ((Long) this.f2322i).longValue(), (Set) this.f2323j);
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    public final x1.i b() {
        String str = ((String) this.f2321h) == null ? " backendName" : "";
        if (((u1.c) this.f2323j) == null) {
            str = str.concat(" priority");
        }
        if (str.isEmpty()) {
            return new x1.i((String) this.f2321h, (byte[]) this.f2322i, (u1.c) this.f2323j);
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    @Override // d0.b
    public final void c() {
        ((Animator) this.f2321h).end();
        if (androidx.fragment.app.w0.I(2)) {
            Log.v("FragmentManager", "Animator from operation " + ((s1) this.f2322i) + " has been canceled.");
        }
    }

    public final String d(String str) {
        if (str == null) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, (SecretKey) ((KeyStore) this.f2323j).getKey((String) this.f2321h, null), new GCMParameterSpec(128, ((String) this.f2322i).getBytes()));
            return new String(cipher.doFinal(Base64.decode(str, 3)), "UTF-8");
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // m0.c
    public final void e() {
    }

    public final void f(a2.a aVar, ByteArrayOutputStream byteArrayOutputStream) {
        Map map = (Map) this.f2321h;
        y3.f fVar = new y3.f(byteArrayOutputStream, map, (Map) this.f2322i, (v3.d) this.f2323j);
        v3.d dVar = (v3.d) map.get(a2.a.class);
        if (dVar != null) {
            dVar.a(aVar, fVar);
            return;
        }
        throw new v3.b("No encoder for " + a2.a.class);
    }

    public final String g(String str) {
        if (str == null) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, (SecretKey) ((KeyStore) this.f2323j).getKey((String) this.f2321h, null), new GCMParameterSpec(128, ((String) this.f2322i).getBytes()));
            return Base64.encodeToString(cipher.doFinal(str.getBytes("UTF-8")), 3);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // m0.c
    public final Uri i() {
        return (Uri) this.f2323j;
    }

    public final androidx.lifecycle.r0 j(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return k(cls, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName));
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public final androidx.lifecycle.r0 k(Class cls, String str) {
        androidx.lifecycle.r0 a5;
        e4.e.f(str, "key");
        androidx.lifecycle.v0 v0Var = (androidx.lifecycle.v0) this.f2321h;
        v0Var.getClass();
        androidx.lifecycle.r0 r0Var = (androidx.lifecycle.r0) v0Var.f1157a.get(str);
        if (!cls.isInstance(r0Var)) {
            w0.e eVar = new w0.e((w0.b) this.f2323j);
            eVar.f5293a.put(l2.i.f3856j, str);
            try {
                a5 = ((androidx.lifecycle.t0) this.f2322i).c(cls, eVar);
            } catch (AbstractMethodError unused) {
                a5 = ((androidx.lifecycle.t0) this.f2322i).a(cls);
            }
            androidx.lifecycle.v0 v0Var2 = (androidx.lifecycle.v0) this.f2321h;
            v0Var2.getClass();
            e4.e.f(a5, "viewModel");
            androidx.lifecycle.r0 r0Var2 = (androidx.lifecycle.r0) v0Var2.f1157a.put(str, a5);
            if (r0Var2 != null) {
                r0Var2.b();
            }
            return a5;
        }
        androidx.lifecycle.t0 t0Var = (androidx.lifecycle.t0) this.f2322i;
        androidx.lifecycle.u0 u0Var = t0Var instanceof androidx.lifecycle.u0 ? (androidx.lifecycle.u0) t0Var : null;
        if (u0Var != null) {
            e4.e.c(r0Var);
            androidx.lifecycle.p0 p0Var = (androidx.lifecycle.p0) u0Var;
            androidx.lifecycle.o oVar = p0Var.f1138j;
            if (oVar != null) {
                b1.d dVar = p0Var.f1139k;
                e4.e.c(dVar);
                p2.a.c(r0Var, dVar, oVar);
            }
        }
        e4.e.d(r0Var, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        return r0Var;
    }

    public final Location l(String str) {
        try {
            if (((LocationManager) this.f2322i).isProviderEnabled(str)) {
                return ((LocationManager) this.f2322i).getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e5) {
            Log.d("TwilightManager", "Failed to get last known location", e5);
            return null;
        }
    }

    public final androidx.fragment.app.g m(u1.b bVar, z0.d dVar) {
        if (((Set) this.f2321h).contains(bVar)) {
            return new androidx.fragment.app.g((x1.i) this.f2322i, bVar, dVar, (x1.n) this.f2323j);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", bVar, (Set) this.f2321h));
    }

    public final boolean n(int i5, p.e eVar, q.m mVar) {
        q.b bVar = (q.b) this.f2322i;
        int[] iArr = eVar.f4188p0;
        bVar.f4365a = iArr[0];
        bVar.f4366b = iArr[1];
        bVar.f4367c = eVar.r();
        ((q.b) this.f2322i).f4368d = eVar.l();
        q.b bVar2 = (q.b) this.f2322i;
        bVar2.f4373i = false;
        bVar2.f4374j = i5;
        boolean z4 = bVar2.f4365a == 3;
        boolean z5 = bVar2.f4366b == 3;
        boolean z6 = z4 && eVar.W > 0.0f;
        boolean z7 = z5 && eVar.W > 0.0f;
        int[] iArr2 = eVar.f4192t;
        if (z6 && iArr2[0] == 4) {
            bVar2.f4365a = 1;
        }
        if (z7 && iArr2[1] == 4) {
            bVar2.f4366b = 1;
        }
        mVar.b(eVar, bVar2);
        eVar.O(((q.b) this.f2322i).f4369e);
        eVar.L(((q.b) this.f2322i).f4370f);
        Object obj = this.f2322i;
        q.b bVar3 = (q.b) obj;
        eVar.E = bVar3.f4372h;
        int i6 = bVar3.f4371g;
        eVar.f4159a0 = i6;
        eVar.E = i6 > 0;
        q.b bVar4 = (q.b) obj;
        bVar4.f4374j = 0;
        return bVar4.f4373i;
    }

    public final void o(String str) {
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f2321h = str;
    }

    public final void p(u1.c cVar) {
        if (cVar == null) {
            throw new NullPointerException("Null priority");
        }
        this.f2323j = cVar;
    }

    public final void q(p.f fVar, int i5, int i6, int i7) {
        int i8 = fVar.f4161b0;
        int i9 = fVar.f4163c0;
        fVar.f4161b0 = 0;
        fVar.f4163c0 = 0;
        fVar.O(i6);
        fVar.L(i7);
        if (i8 < 0) {
            fVar.f4161b0 = 0;
        } else {
            fVar.f4161b0 = i8;
        }
        if (i9 < 0) {
            fVar.f4163c0 = 0;
        } else {
            fVar.f4163c0 = i9;
        }
        p.f fVar2 = (p.f) this.f2323j;
        fVar2.f4201t0 = i5;
        fVar2.R();
    }

    @Override // m0.c
    public final ClipDescription r() {
        return (ClipDescription) this.f2322i;
    }

    public final void s(p.f fVar) {
        ((ArrayList) this.f2321h).clear();
        int size = fVar.f4243q0.size();
        for (int i5 = 0; i5 < size; i5++) {
            p.e eVar = (p.e) fVar.f4243q0.get(i5);
            int[] iArr = eVar.f4188p0;
            if (iArr[0] == 3 || iArr[1] == 3) {
                ((ArrayList) this.f2321h).add(eVar);
            }
        }
        fVar.f4200s0.f4378b = true;
    }

    @Override // m0.c
    public final Object t() {
        return null;
    }

    public final String toString() {
        switch (this.f2320g) {
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                String str = "[ ";
                if (((n.i) this.f2321h) != null) {
                    for (int i5 = 0; i5 < 9; i5++) {
                        str = str + ((n.i) this.f2321h).f4040i[i5] + " ";
                    }
                }
                return str + "] " + ((n.i) this.f2321h);
            default:
                return super.toString();
        }
    }

    @Override // m0.c
    public final Uri u() {
        return (Uri) this.f2321h;
    }

    public e(androidx.lifecycle.v0 v0Var, androidx.lifecycle.t0 t0Var, w0.b bVar) {
        this.f2320g = 6;
        e4.e.f(v0Var, "store");
        e4.e.f(t0Var, "factory");
        e4.e.f(bVar, "defaultCreationExtras");
        this.f2321h = v0Var;
        this.f2322i = t0Var;
        this.f2323j = bVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(androidx.lifecycle.v0 v0Var, p3.e eVar, int i5) {
        this(v0Var, eVar);
        this.f2320g = 6;
        e4.e.f(v0Var, "store");
        e4.e.f(eVar, "factory");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(androidx.lifecycle.w0 w0Var) {
        this(w0Var.getViewModelStore(), w0Var instanceof androidx.lifecycle.i ? ((androidx.lifecycle.i) w0Var).getDefaultViewModelProviderFactory() : p3.e.g(), com.google.android.gms.internal.play_billing.i0.s(w0Var));
        this.f2320g = 6;
        e4.e.f(w0Var, "owner");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(androidx.lifecycle.w0 w0Var, w0.c cVar) {
        this(w0Var.getViewModelStore(), cVar, com.google.android.gms.internal.play_billing.i0.s(w0Var));
        this.f2320g = 6;
        e4.e.f(w0Var, "owner");
    }

    public /* synthetic */ e(Object obj, Animator animator, s1 s1Var) {
        this.f2320g = 5;
        this.f2323j = obj;
        this.f2321h = animator;
        this.f2322i = s1Var;
    }

    public /* synthetic */ e(Object obj, Object obj2, Object obj3, int i5) {
        this.f2320g = i5;
        this.f2321h = obj;
        this.f2322i = obj2;
        this.f2323j = obj3;
    }

    public e(n2.c cVar, z0.d dVar) {
        this.f2320g = 11;
        this.f2323j = "ClientTelemetry.API";
        this.f2321h = cVar;
        this.f2322i = dVar;
    }

    public e(String str, String str2) {
        this.f2320g = 14;
        this.f2321h = str;
        this.f2322i = str2;
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            this.f2323j = keyStore;
            keyStore.load(null);
            if (((KeyStore) this.f2323j).containsAlias(str)) {
                return;
            }
            KeyGenParameterSpec build = new KeyGenParameterSpec.Builder(str, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setRandomizedEncryptionRequired(false).build();
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            keyGenerator.init(build);
            keyGenerator.generateKey();
        } catch (Exception unused) {
        }
    }

    public e(n.g gVar, n.g gVar2) {
        this.f2320g = 2;
        this.f2323j = gVar;
        this.f2322i = gVar2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(androidx.lifecycle.v0 v0Var, p3.e eVar) {
        this(v0Var, eVar, w0.a.f5292b);
        this.f2320g = 6;
    }

    public e(Context context, LocationManager locationManager) {
        this.f2320g = 1;
        this.f2323j = new z0();
        this.f2321h = context;
        this.f2322i = locationManager;
    }

    public e(p.f fVar) {
        this.f2320g = 3;
        this.f2321h = new ArrayList();
        this.f2322i = new q.b();
        this.f2323j = fVar;
    }
}

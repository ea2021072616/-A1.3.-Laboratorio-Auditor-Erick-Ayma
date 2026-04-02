package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.github.appintro.R;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class w0 {
    public androidx.activity.result.e A;
    public androidx.activity.result.e B;
    public ArrayDeque C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public ArrayList I;
    public ArrayList J;
    public ArrayList K;
    public z0 L;
    public final e M;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1026b;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f1028d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f1029e;

    /* renamed from: g  reason: collision with root package name */
    public androidx.activity.z f1031g;

    /* renamed from: l  reason: collision with root package name */
    public final l0 f1036l;

    /* renamed from: m  reason: collision with root package name */
    public final CopyOnWriteArrayList f1037m;

    /* renamed from: n  reason: collision with root package name */
    public final m0 f1038n;
    public final m0 o;

    /* renamed from: p  reason: collision with root package name */
    public final m0 f1039p;

    /* renamed from: q  reason: collision with root package name */
    public final m0 f1040q;

    /* renamed from: r  reason: collision with root package name */
    public final p0 f1041r;

    /* renamed from: s  reason: collision with root package name */
    public int f1042s;

    /* renamed from: t  reason: collision with root package name */
    public i0 f1043t;

    /* renamed from: u  reason: collision with root package name */
    public g0 f1044u;

    /* renamed from: v  reason: collision with root package name */
    public Fragment f1045v;

    /* renamed from: w  reason: collision with root package name */
    public Fragment f1046w;

    /* renamed from: x  reason: collision with root package name */
    public final q0 f1047x;

    /* renamed from: y  reason: collision with root package name */
    public final n0 f1048y;

    /* renamed from: z  reason: collision with root package name */
    public androidx.activity.result.e f1049z;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f1025a = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final e1 f1027c = new e1();

    /* renamed from: f  reason: collision with root package name */
    public final k0 f1030f = new k0(this);

    /* renamed from: h  reason: collision with root package name */
    public final o0 f1032h = new o0(this);

    /* renamed from: i  reason: collision with root package name */
    public final AtomicInteger f1033i = new AtomicInteger();

    /* renamed from: j  reason: collision with root package name */
    public final Map f1034j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k  reason: collision with root package name */
    public final Map f1035k = Collections.synchronizedMap(new HashMap());

    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.fragment.app.m0] */
    /* JADX WARN: Type inference failed for: r0v13, types: [androidx.fragment.app.m0] */
    /* JADX WARN: Type inference failed for: r0v14, types: [androidx.fragment.app.m0] */
    /* JADX WARN: Type inference failed for: r0v15, types: [androidx.fragment.app.m0] */
    public w0() {
        Collections.synchronizedMap(new HashMap());
        this.f1036l = new l0(this);
        this.f1037m = new CopyOnWriteArrayList();
        this.f1038n = new g0.a(this) { // from class: androidx.fragment.app.m0

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ w0 f952b;

            {
                this.f952b = this;
            }

            @Override // g0.a
            public final void a(Object obj) {
                int i5 = r2;
                w0 w0Var = this.f952b;
                switch (i5) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        if (w0Var.K()) {
                            w0Var.h(false, configuration);
                            return;
                        }
                        return;
                    case 1:
                        Integer num = (Integer) obj;
                        if (w0Var.K() && num.intValue() == 80) {
                            w0Var.l(false);
                            return;
                        }
                        return;
                    case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                        w.p pVar = (w.p) obj;
                        if (w0Var.K()) {
                            w0Var.m(pVar.f5267a, false);
                            return;
                        }
                        return;
                    default:
                        w.g0 g0Var = (w.g0) obj;
                        if (w0Var.K()) {
                            w0Var.r(g0Var.f5250a, false);
                            return;
                        }
                        return;
                }
            }
        };
        this.o = new g0.a(this) { // from class: androidx.fragment.app.m0

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ w0 f952b;

            {
                this.f952b = this;
            }

            @Override // g0.a
            public final void a(Object obj) {
                int i5 = r2;
                w0 w0Var = this.f952b;
                switch (i5) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        if (w0Var.K()) {
                            w0Var.h(false, configuration);
                            return;
                        }
                        return;
                    case 1:
                        Integer num = (Integer) obj;
                        if (w0Var.K() && num.intValue() == 80) {
                            w0Var.l(false);
                            return;
                        }
                        return;
                    case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                        w.p pVar = (w.p) obj;
                        if (w0Var.K()) {
                            w0Var.m(pVar.f5267a, false);
                            return;
                        }
                        return;
                    default:
                        w.g0 g0Var = (w.g0) obj;
                        if (w0Var.K()) {
                            w0Var.r(g0Var.f5250a, false);
                            return;
                        }
                        return;
                }
            }
        };
        this.f1039p = new g0.a(this) { // from class: androidx.fragment.app.m0

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ w0 f952b;

            {
                this.f952b = this;
            }

            @Override // g0.a
            public final void a(Object obj) {
                int i5 = r2;
                w0 w0Var = this.f952b;
                switch (i5) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        if (w0Var.K()) {
                            w0Var.h(false, configuration);
                            return;
                        }
                        return;
                    case 1:
                        Integer num = (Integer) obj;
                        if (w0Var.K() && num.intValue() == 80) {
                            w0Var.l(false);
                            return;
                        }
                        return;
                    case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                        w.p pVar = (w.p) obj;
                        if (w0Var.K()) {
                            w0Var.m(pVar.f5267a, false);
                            return;
                        }
                        return;
                    default:
                        w.g0 g0Var = (w.g0) obj;
                        if (w0Var.K()) {
                            w0Var.r(g0Var.f5250a, false);
                            return;
                        }
                        return;
                }
            }
        };
        this.f1040q = new g0.a(this) { // from class: androidx.fragment.app.m0

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ w0 f952b;

            {
                this.f952b = this;
            }

            @Override // g0.a
            public final void a(Object obj) {
                int i5 = r2;
                w0 w0Var = this.f952b;
                switch (i5) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        if (w0Var.K()) {
                            w0Var.h(false, configuration);
                            return;
                        }
                        return;
                    case 1:
                        Integer num = (Integer) obj;
                        if (w0Var.K() && num.intValue() == 80) {
                            w0Var.l(false);
                            return;
                        }
                        return;
                    case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                        w.p pVar = (w.p) obj;
                        if (w0Var.K()) {
                            w0Var.m(pVar.f5267a, false);
                            return;
                        }
                        return;
                    default:
                        w.g0 g0Var = (w.g0) obj;
                        if (w0Var.K()) {
                            w0Var.r(g0Var.f5250a, false);
                            return;
                        }
                        return;
                }
            }
        };
        this.f1041r = new p0(this);
        this.f1042s = -1;
        this.f1047x = new q0(this);
        this.f1048y = new n0(this, 1);
        this.C = new ArrayDeque();
        this.M = new e(2, this);
    }

    public static boolean I(int i5) {
        return Log.isLoggable("FragmentManager", i5);
    }

    public static boolean J(Fragment fragment) {
        boolean z4;
        if (fragment.mHasMenu && fragment.mMenuVisible) {
            return true;
        }
        Iterator it = fragment.mChildFragmentManager.f1027c.e().iterator();
        boolean z5 = false;
        while (true) {
            if (!it.hasNext()) {
                z4 = false;
                break;
            }
            Fragment fragment2 = (Fragment) it.next();
            if (fragment2 != null) {
                z5 = J(fragment2);
                continue;
            }
            if (z5) {
                z4 = true;
                break;
            }
        }
        return z4;
    }

    public static boolean L(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        w0 w0Var = fragment.mFragmentManager;
        return fragment.equals(w0Var.f1046w) && L(w0Var.f1045v);
    }

    public static void b0(Fragment fragment) {
        if (I(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public final Fragment A(String str) {
        return this.f1027c.b(str);
    }

    public final Fragment B(int i5) {
        e1 e1Var = this.f1027c;
        ArrayList arrayList = e1Var.f867a;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                for (d1 d1Var : e1Var.f868b.values()) {
                    if (d1Var != null) {
                        Fragment fragment = d1Var.f860c;
                        if (fragment.mFragmentId == i5) {
                            return fragment;
                        }
                    }
                }
                return null;
            }
            Fragment fragment2 = (Fragment) arrayList.get(size);
            if (fragment2 != null && fragment2.mFragmentId == i5) {
                return fragment2;
            }
        }
    }

    public final Fragment C(String str) {
        e1 e1Var = this.f1027c;
        if (str != null) {
            ArrayList arrayList = e1Var.f867a;
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                Fragment fragment = (Fragment) arrayList.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str != null) {
            for (d1 d1Var : e1Var.f868b.values()) {
                if (d1Var != null) {
                    Fragment fragment2 = d1Var.f860c;
                    if (str.equals(fragment2.mTag)) {
                        return fragment2;
                    }
                }
            }
        } else {
            e1Var.getClass();
        }
        return null;
    }

    public final void D() {
        Iterator it = e().iterator();
        while (it.hasNext()) {
            t1 t1Var = (t1) it.next();
            if (t1Var.f1014e) {
                if (I(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
                }
                t1Var.f1014e = false;
                t1Var.c();
            }
        }
    }

    public final ViewGroup E(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.f1044u.c()) {
            View b5 = this.f1044u.b(fragment.mContainerId);
            if (b5 instanceof ViewGroup) {
                return (ViewGroup) b5;
            }
        }
        return null;
    }

    public final q0 F() {
        Fragment fragment = this.f1045v;
        return fragment != null ? fragment.mFragmentManager.F() : this.f1047x;
    }

    public final n0 G() {
        Fragment fragment = this.f1045v;
        return fragment != null ? fragment.mFragmentManager.G() : this.f1048y;
    }

    public final void H(Fragment fragment) {
        if (I(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        a0(fragment);
    }

    public final boolean K() {
        Fragment fragment = this.f1045v;
        if (fragment == null) {
            return true;
        }
        return fragment.isAdded() && this.f1045v.getParentFragmentManager().K();
    }

    public final boolean M() {
        return this.E || this.F;
    }

    public final void N(int i5, boolean z4) {
        HashMap hashMap;
        i0 i0Var;
        if (this.f1043t == null && i5 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z4 || i5 != this.f1042s) {
            this.f1042s = i5;
            e1 e1Var = this.f1027c;
            Iterator it = e1Var.f867a.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                hashMap = e1Var.f868b;
                if (!hasNext) {
                    break;
                }
                d1 d1Var = (d1) hashMap.get(((Fragment) it.next()).mWho);
                if (d1Var != null) {
                    d1Var.j();
                }
            }
            Iterator it2 = hashMap.values().iterator();
            while (true) {
                boolean z5 = false;
                if (!it2.hasNext()) {
                    break;
                }
                d1 d1Var2 = (d1) it2.next();
                if (d1Var2 != null) {
                    d1Var2.j();
                    Fragment fragment = d1Var2.f860c;
                    if (fragment.mRemoving && !fragment.isInBackStack()) {
                        z5 = true;
                    }
                    if (z5) {
                        if (fragment.mBeingSaved && !e1Var.f869c.containsKey(fragment.mWho)) {
                            d1Var2.m();
                        }
                        e1Var.h(d1Var2);
                    }
                }
            }
            c0();
            if (this.D && (i0Var = this.f1043t) != null && this.f1042s == 7) {
                ((c0) i0Var).f839k.invalidateOptionsMenu();
                this.D = false;
            }
        }
    }

    public final void O() {
        if (this.f1043t == null) {
            return;
        }
        this.E = false;
        this.F = false;
        this.L.f1082i = false;
        for (Fragment fragment : this.f1027c.f()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public final boolean P() {
        return Q(-1, 0);
    }

    public final boolean Q(int i5, int i6) {
        x(false);
        w(true);
        Fragment fragment = this.f1046w;
        if (fragment == null || i5 >= 0 || !fragment.getChildFragmentManager().P()) {
            boolean R = R(this.I, this.J, i5, i6);
            if (R) {
                this.f1026b = true;
                try {
                    T(this.I, this.J);
                } finally {
                    d();
                }
            }
            e0();
            if (this.H) {
                this.H = false;
                c0();
            }
            this.f1027c.f868b.values().removeAll(Collections.singleton(null));
            return R;
        }
        return true;
    }

    public final boolean R(ArrayList arrayList, ArrayList arrayList2, int i5, int i6) {
        boolean z4 = (i6 & 1) != 0;
        ArrayList arrayList3 = this.f1028d;
        int i7 = -1;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            if (i5 < 0) {
                i7 = z4 ? 0 : (-1) + this.f1028d.size();
            } else {
                int size = this.f1028d.size() - 1;
                while (size >= 0) {
                    a aVar = (a) this.f1028d.get(size);
                    if (i5 >= 0 && i5 == aVar.f820s) {
                        break;
                    }
                    size--;
                }
                if (size >= 0) {
                    if (z4) {
                        while (size > 0) {
                            int i8 = size - 1;
                            a aVar2 = (a) this.f1028d.get(i8);
                            if (i5 < 0 || i5 != aVar2.f820s) {
                                break;
                            }
                            size = i8;
                        }
                    } else if (size != this.f1028d.size() - 1) {
                        size++;
                    }
                }
                i7 = size;
            }
        }
        if (i7 < 0) {
            return false;
        }
        for (int size2 = this.f1028d.size() - 1; size2 >= i7; size2--) {
            arrayList.add((a) this.f1028d.remove(size2));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void S(Fragment fragment) {
        if (I(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z4 = !fragment.isInBackStack();
        if (!fragment.mDetached || z4) {
            e1 e1Var = this.f1027c;
            synchronized (e1Var.f867a) {
                e1Var.f867a.remove(fragment);
            }
            fragment.mAdded = false;
            if (J(fragment)) {
                this.D = true;
            }
            fragment.mRemoving = true;
            a0(fragment);
        }
    }

    public final void T(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i5 < size) {
            if (!((a) arrayList.get(i5)).f908p) {
                if (i6 != i5) {
                    z(arrayList, arrayList2, i6, i5);
                }
                i6 = i5 + 1;
                if (((Boolean) arrayList2.get(i5)).booleanValue()) {
                    while (i6 < size && ((Boolean) arrayList2.get(i6)).booleanValue() && !((a) arrayList.get(i6)).f908p) {
                        i6++;
                    }
                }
                z(arrayList, arrayList2, i5, i6);
                i5 = i6 - 1;
            }
            i5++;
        }
        if (i6 != size) {
            z(arrayList, arrayList2, i6, size);
        }
    }

    public final void U(Parcelable parcelable) {
        l0 l0Var;
        int i5;
        d1 d1Var;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f1043t.f919h.getClassLoader());
                this.f1035k.put(str.substring(7), bundle2);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f1043t.f919h.getClassLoader());
                arrayList.add((c1) bundle.getParcelable("state"));
            }
        }
        e1 e1Var = this.f1027c;
        HashMap hashMap = e1Var.f869c;
        hashMap.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c1 c1Var = (c1) it.next();
            hashMap.put(c1Var.f841c, c1Var);
        }
        y0 y0Var = (y0) bundle3.getParcelable("state");
        if (y0Var == null) {
            return;
        }
        HashMap hashMap2 = e1Var.f868b;
        hashMap2.clear();
        Iterator it2 = y0Var.f1068b.iterator();
        while (true) {
            boolean hasNext = it2.hasNext();
            l0Var = this.f1036l;
            if (!hasNext) {
                break;
            }
            c1 i6 = e1Var.i((String) it2.next(), null);
            if (i6 != null) {
                Fragment fragment = (Fragment) this.L.f1077d.get(i6.f841c);
                if (fragment != null) {
                    if (I(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragment);
                    }
                    d1Var = new d1(l0Var, e1Var, fragment, i6);
                } else {
                    d1Var = new d1(this.f1036l, this.f1027c, this.f1043t.f919h.getClassLoader(), F(), i6);
                }
                Fragment fragment2 = d1Var.f860c;
                fragment2.mFragmentManager = this;
                if (I(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragment2.mWho + "): " + fragment2);
                }
                d1Var.k(this.f1043t.f919h.getClassLoader());
                e1Var.g(d1Var);
                d1Var.f862e = this.f1042s;
            }
        }
        z0 z0Var = this.L;
        z0Var.getClass();
        Iterator it3 = new ArrayList(z0Var.f1077d.values()).iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Fragment fragment3 = (Fragment) it3.next();
            if ((hashMap2.get(fragment3.mWho) != null ? 1 : 0) == 0) {
                if (I(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment3 + " that was not found in the set of active Fragments " + y0Var.f1068b);
                }
                this.L.f(fragment3);
                fragment3.mFragmentManager = this;
                d1 d1Var2 = new d1(l0Var, e1Var, fragment3);
                d1Var2.f862e = 1;
                d1Var2.j();
                fragment3.mRemoving = true;
                d1Var2.j();
            }
        }
        ArrayList<String> arrayList2 = y0Var.f1069c;
        e1Var.f867a.clear();
        if (arrayList2 != null) {
            for (String str3 : arrayList2) {
                Fragment b5 = e1Var.b(str3);
                if (b5 == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str3 + ")");
                }
                if (I(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str3 + "): " + b5);
                }
                e1Var.a(b5);
            }
        }
        if (y0Var.f1070d != null) {
            this.f1028d = new ArrayList(y0Var.f1070d.length);
            int i7 = 0;
            while (true) {
                b[] bVarArr = y0Var.f1070d;
                if (i7 >= bVarArr.length) {
                    break;
                }
                b bVar = bVarArr[i7];
                bVar.getClass();
                a aVar = new a(this);
                int i8 = 0;
                int i9 = 0;
                while (true) {
                    int[] iArr = bVar.f822b;
                    if (i8 >= iArr.length) {
                        break;
                    }
                    f1 f1Var = new f1();
                    int i10 = i8 + 1;
                    f1Var.f880a = iArr[i8];
                    if (I(2)) {
                        Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i9 + " base fragment #" + iArr[i10]);
                    }
                    f1Var.f887h = androidx.lifecycle.n.values()[bVar.f824d[i9]];
                    f1Var.f888i = androidx.lifecycle.n.values()[bVar.f825e[i9]];
                    int i11 = i10 + 1;
                    f1Var.f882c = iArr[i10] != 0;
                    int i12 = i11 + 1;
                    int i13 = iArr[i11];
                    f1Var.f883d = i13;
                    int i14 = i12 + 1;
                    int i15 = iArr[i12];
                    f1Var.f884e = i15;
                    int i16 = i14 + 1;
                    int i17 = iArr[i14];
                    f1Var.f885f = i17;
                    int i18 = iArr[i16];
                    f1Var.f886g = i18;
                    aVar.f895b = i13;
                    aVar.f896c = i15;
                    aVar.f897d = i17;
                    aVar.f898e = i18;
                    aVar.b(f1Var);
                    i9++;
                    i8 = i16 + 1;
                }
                aVar.f899f = bVar.f826f;
                aVar.f902i = bVar.f827g;
                aVar.f900g = true;
                aVar.f903j = bVar.f829i;
                aVar.f904k = bVar.f830j;
                aVar.f905l = bVar.f831k;
                aVar.f906m = bVar.f832l;
                aVar.f907n = bVar.f833m;
                aVar.o = bVar.f834n;
                aVar.f908p = bVar.o;
                aVar.f820s = bVar.f828h;
                int i19 = 0;
                while (true) {
                    ArrayList arrayList3 = bVar.f823c;
                    if (i19 >= arrayList3.size()) {
                        break;
                    }
                    String str4 = (String) arrayList3.get(i19);
                    if (str4 != null) {
                        ((f1) aVar.f894a.get(i19)).f881b = A(str4);
                    }
                    i19++;
                }
                aVar.e(1);
                if (I(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i7 + " (index " + aVar.f820s + "): " + aVar);
                    PrintWriter printWriter = new PrintWriter(new q1());
                    aVar.g("  ", printWriter, false);
                    printWriter.close();
                }
                this.f1028d.add(aVar);
                i7++;
            }
        } else {
            this.f1028d = null;
        }
        this.f1033i.set(y0Var.f1071e);
        String str5 = y0Var.f1072f;
        if (str5 != null) {
            Fragment A = A(str5);
            this.f1046w = A;
            q(A);
        }
        ArrayList arrayList4 = y0Var.f1073g;
        if (arrayList4 != null) {
            while (i5 < arrayList4.size()) {
                this.f1034j.put((String) arrayList4.get(i5), (c) y0Var.f1074h.get(i5));
                i5++;
            }
        }
        this.C = new ArrayDeque(y0Var.f1075i);
    }

    public final Bundle V() {
        b[] bVarArr;
        ArrayList arrayList;
        int size;
        Bundle bundle = new Bundle();
        D();
        Iterator it = e().iterator();
        while (it.hasNext()) {
            ((t1) it.next()).e();
        }
        x(true);
        this.E = true;
        this.L.f1082i = true;
        e1 e1Var = this.f1027c;
        e1Var.getClass();
        HashMap hashMap = e1Var.f868b;
        ArrayList arrayList2 = new ArrayList(hashMap.size());
        for (d1 d1Var : hashMap.values()) {
            if (d1Var != null) {
                d1Var.m();
                Fragment fragment = d1Var.f860c;
                arrayList2.add(fragment.mWho);
                if (I(2)) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragment.mSavedFragmentState);
                }
            }
        }
        e1 e1Var2 = this.f1027c;
        e1Var2.getClass();
        ArrayList arrayList3 = new ArrayList(e1Var2.f869c.values());
        if (!arrayList3.isEmpty()) {
            e1 e1Var3 = this.f1027c;
            synchronized (e1Var3.f867a) {
                bVarArr = null;
                if (e1Var3.f867a.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(e1Var3.f867a.size());
                    Iterator it2 = e1Var3.f867a.iterator();
                    while (it2.hasNext()) {
                        Fragment fragment2 = (Fragment) it2.next();
                        arrayList.add(fragment2.mWho);
                        if (I(2)) {
                            Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment2.mWho + "): " + fragment2);
                        }
                    }
                }
            }
            ArrayList arrayList4 = this.f1028d;
            if (arrayList4 != null && (size = arrayList4.size()) > 0) {
                bVarArr = new b[size];
                for (int i5 = 0; i5 < size; i5++) {
                    bVarArr[i5] = new b((a) this.f1028d.get(i5));
                    if (I(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i5 + ": " + this.f1028d.get(i5));
                    }
                }
            }
            y0 y0Var = new y0();
            y0Var.f1068b = arrayList2;
            y0Var.f1069c = arrayList;
            y0Var.f1070d = bVarArr;
            y0Var.f1071e = this.f1033i.get();
            Fragment fragment3 = this.f1046w;
            if (fragment3 != null) {
                y0Var.f1072f = fragment3.mWho;
            }
            y0Var.f1073g.addAll(this.f1034j.keySet());
            y0Var.f1074h.addAll(this.f1034j.values());
            y0Var.f1075i = new ArrayList(this.C);
            bundle.putParcelable("state", y0Var);
            for (String str : this.f1035k.keySet()) {
                bundle.putBundle("result_" + str, (Bundle) this.f1035k.get(str));
            }
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                c1 c1Var = (c1) it3.next();
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("state", c1Var);
                bundle.putBundle("fragment_" + c1Var.f841c, bundle2);
            }
        } else if (I(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
        }
        return bundle;
    }

    public final void W() {
        synchronized (this.f1025a) {
            boolean z4 = true;
            if (this.f1025a.size() != 1) {
                z4 = false;
            }
            if (z4) {
                this.f1043t.f920i.removeCallbacks(this.M);
                this.f1043t.f920i.post(this.M);
                e0();
            }
        }
    }

    public final void X(Fragment fragment, boolean z4) {
        ViewGroup E = E(fragment);
        if (E == null || !(E instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) E).setDrawDisappearingViewsLast(!z4);
    }

    public final void Y(Fragment fragment, androidx.lifecycle.n nVar) {
        if (fragment.equals(A(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = nVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public final void Z(Fragment fragment) {
        if (fragment == null || (fragment.equals(A(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.f1046w;
            this.f1046w = fragment;
            q(fragment2);
            q(this.f1046w);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public final d1 a(Fragment fragment) {
        String str = fragment.mPreviousWho;
        if (str != null) {
            u0.c.d(fragment, str);
        }
        if (I(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        d1 f5 = f(fragment);
        fragment.mFragmentManager = this;
        e1 e1Var = this.f1027c;
        e1Var.g(f5);
        if (!fragment.mDetached) {
            e1Var.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (J(fragment)) {
                this.D = true;
            }
        }
        return f5;
    }

    public final void a0(Fragment fragment) {
        ViewGroup E = E(fragment);
        if (E != null) {
            if (fragment.getPopExitAnim() + fragment.getPopEnterAnim() + fragment.getExitAnim() + fragment.getEnterAnim() > 0) {
                if (E.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                    E.setTag(R.id.visible_removing_fragment_view_tag, fragment);
                }
                ((Fragment) E.getTag(R.id.visible_removing_fragment_view_tag)).setPopDirection(fragment.getPopDirection());
            }
        }
    }

    public final void b(i0 i0Var, g0 g0Var, Fragment fragment) {
        if (this.f1043t != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f1043t = i0Var;
        this.f1044u = g0Var;
        this.f1045v = fragment;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f1037m;
        if (fragment != null) {
            copyOnWriteArrayList.add(new r0(fragment));
        } else if (i0Var instanceof a1) {
            copyOnWriteArrayList.add((a1) i0Var);
        }
        if (this.f1045v != null) {
            e0();
        }
        if (i0Var instanceof androidx.activity.a0) {
            androidx.activity.a0 a0Var = (androidx.activity.a0) i0Var;
            androidx.activity.z onBackPressedDispatcher = a0Var.getOnBackPressedDispatcher();
            this.f1031g = onBackPressedDispatcher;
            androidx.lifecycle.t tVar = a0Var;
            if (fragment != null) {
                tVar = fragment;
            }
            onBackPressedDispatcher.a(tVar, this.f1032h);
        }
        if (fragment != null) {
            z0 z0Var = fragment.mFragmentManager.L;
            HashMap hashMap = z0Var.f1078e;
            z0 z0Var2 = (z0) hashMap.get(fragment.mWho);
            if (z0Var2 == null) {
                z0Var2 = new z0(z0Var.f1080g);
                hashMap.put(fragment.mWho, z0Var2);
            }
            this.L = z0Var2;
        } else if (i0Var instanceof androidx.lifecycle.w0) {
            this.L = (z0) new d.e(((androidx.lifecycle.w0) i0Var).getViewModelStore(), z0.f1076j, 0).j(z0.class);
        } else {
            this.L = new z0(false);
        }
        this.L.f1082i = M();
        this.f1027c.f870d = this.L;
        i0 i0Var2 = this.f1043t;
        if ((i0Var2 instanceof b1.f) && fragment == null) {
            b1.d savedStateRegistry = ((b1.f) i0Var2).getSavedStateRegistry();
            savedStateRegistry.c("android:support:fragments", new androidx.activity.f(2, this));
            Bundle a5 = savedStateRegistry.a("android:support:fragments");
            if (a5 != null) {
                U(a5);
            }
        }
        i0 i0Var3 = this.f1043t;
        if (i0Var3 instanceof androidx.activity.result.i) {
            androidx.activity.result.h activityResultRegistry = ((androidx.activity.result.i) i0Var3).getActivityResultRegistry();
            String str = "FragmentManager:" + (fragment != null ? androidx.appcompat.widget.b0.i(new StringBuilder(), fragment.mWho, ":") : "");
            this.f1049z = activityResultRegistry.d(androidx.appcompat.widget.b0.h(str, "StartActivityForResult"), new b.c(), new n0(this, 2));
            this.A = activityResultRegistry.d(androidx.appcompat.widget.b0.h(str, "StartIntentSenderForResult"), new s0(), new n0(this, 3));
            this.B = activityResultRegistry.d(androidx.appcompat.widget.b0.h(str, "RequestPermissions"), new b.b(), new n0(this, 0));
        }
        i0 i0Var4 = this.f1043t;
        if (i0Var4 instanceof x.c) {
            ((x.c) i0Var4).addOnConfigurationChangedListener(this.f1038n);
        }
        i0 i0Var5 = this.f1043t;
        if (i0Var5 instanceof x.d) {
            ((x.d) i0Var5).addOnTrimMemoryListener(this.o);
        }
        i0 i0Var6 = this.f1043t;
        if (i0Var6 instanceof w.e0) {
            ((w.e0) i0Var6).addOnMultiWindowModeChangedListener(this.f1039p);
        }
        i0 i0Var7 = this.f1043t;
        if (i0Var7 instanceof w.f0) {
            ((w.f0) i0Var7).addOnPictureInPictureModeChangedListener(this.f1040q);
        }
        i0 i0Var8 = this.f1043t;
        if ((i0Var8 instanceof h0.m) && fragment == null) {
            ((h0.m) i0Var8).addMenuProvider(this.f1041r);
        }
    }

    public final void c(Fragment fragment) {
        if (I(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.f1027c.a(fragment);
            if (I(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (J(fragment)) {
                this.D = true;
            }
        }
    }

    public final void c0() {
        Iterator it = this.f1027c.d().iterator();
        while (it.hasNext()) {
            d1 d1Var = (d1) it.next();
            Fragment fragment = d1Var.f860c;
            if (fragment.mDeferStart) {
                if (this.f1026b) {
                    this.H = true;
                } else {
                    fragment.mDeferStart = false;
                    d1Var.j();
                }
            }
        }
    }

    public final void d() {
        this.f1026b = false;
        this.J.clear();
        this.I.clear();
    }

    public final void d0(IllegalStateException illegalStateException) {
        Log.e("FragmentManager", illegalStateException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new q1());
        i0 i0Var = this.f1043t;
        if (i0Var != null) {
            try {
                ((c0) i0Var).f839k.dump("  ", null, printWriter, new String[0]);
            } catch (Exception e5) {
                Log.e("FragmentManager", "Failed dumping state", e5);
            }
        } else {
            try {
                u("  ", null, printWriter, new String[0]);
            } catch (Exception e6) {
                Log.e("FragmentManager", "Failed dumping state", e6);
            }
        }
        throw illegalStateException;
    }

    public final HashSet e() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f1027c.d().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((d1) it.next()).f860c.mContainer;
            if (viewGroup != null) {
                hashSet.add(t1.f(viewGroup, G()));
            }
        }
        return hashSet;
    }

    public final void e0() {
        synchronized (this.f1025a) {
            try {
                boolean z4 = true;
                if (!this.f1025a.isEmpty()) {
                    o0 o0Var = this.f1032h;
                    o0Var.f961a = true;
                    i4.a aVar = o0Var.f963c;
                    if (aVar != null) {
                        aVar.a();
                    }
                    return;
                }
                o0 o0Var2 = this.f1032h;
                ArrayList arrayList = this.f1028d;
                if ((arrayList != null ? arrayList.size() : 0) <= 0 || !L(this.f1045v)) {
                    z4 = false;
                }
                o0Var2.f961a = z4;
                i4.a aVar2 = o0Var2.f963c;
                if (aVar2 != null) {
                    aVar2.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final d1 f(Fragment fragment) {
        String str = fragment.mWho;
        e1 e1Var = this.f1027c;
        d1 d1Var = (d1) e1Var.f868b.get(str);
        if (d1Var != null) {
            return d1Var;
        }
        d1 d1Var2 = new d1(this.f1036l, e1Var, fragment);
        d1Var2.k(this.f1043t.f919h.getClassLoader());
        d1Var2.f862e = this.f1042s;
        return d1Var2;
    }

    public final void g(Fragment fragment) {
        if (I(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (I(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            e1 e1Var = this.f1027c;
            synchronized (e1Var.f867a) {
                e1Var.f867a.remove(fragment);
            }
            fragment.mAdded = false;
            if (J(fragment)) {
                this.D = true;
            }
            a0(fragment);
        }
    }

    public final void h(boolean z4, Configuration configuration) {
        if (z4 && (this.f1043t instanceof x.c)) {
            d0(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.f1027c.f()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
                if (z4) {
                    fragment.mChildFragmentManager.h(true, configuration);
                }
            }
        }
    }

    public final boolean i(MenuItem menuItem) {
        if (this.f1042s < 1) {
            return false;
        }
        for (Fragment fragment : this.f1027c.f()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean j(Menu menu, MenuInflater menuInflater) {
        if (this.f1042s < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z4 = false;
        for (Fragment fragment : this.f1027c.f()) {
            if (fragment != null && fragment.isMenuVisible() && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z4 = true;
            }
        }
        if (this.f1029e != null) {
            for (int i5 = 0; i5 < this.f1029e.size(); i5++) {
                Fragment fragment2 = (Fragment) this.f1029e.get(i5);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f1029e = arrayList;
        return z4;
    }

    public final void k() {
        boolean z4 = true;
        this.G = true;
        x(true);
        Iterator it = e().iterator();
        while (it.hasNext()) {
            ((t1) it.next()).e();
        }
        i0 i0Var = this.f1043t;
        boolean z5 = i0Var instanceof androidx.lifecycle.w0;
        e1 e1Var = this.f1027c;
        if (z5) {
            z4 = e1Var.f870d.f1081h;
        } else {
            Context context = i0Var.f919h;
            if (context instanceof Activity) {
                z4 = true ^ ((Activity) context).isChangingConfigurations();
            }
        }
        if (z4) {
            for (c cVar : this.f1034j.values()) {
                for (String str : cVar.f837b) {
                    z0 z0Var = e1Var.f870d;
                    z0Var.getClass();
                    if (I(3)) {
                        Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
                    }
                    z0Var.e(str);
                }
            }
        }
        t(-1);
        i0 i0Var2 = this.f1043t;
        if (i0Var2 instanceof x.d) {
            ((x.d) i0Var2).removeOnTrimMemoryListener(this.o);
        }
        i0 i0Var3 = this.f1043t;
        if (i0Var3 instanceof x.c) {
            ((x.c) i0Var3).removeOnConfigurationChangedListener(this.f1038n);
        }
        i0 i0Var4 = this.f1043t;
        if (i0Var4 instanceof w.e0) {
            ((w.e0) i0Var4).removeOnMultiWindowModeChangedListener(this.f1039p);
        }
        i0 i0Var5 = this.f1043t;
        if (i0Var5 instanceof w.f0) {
            ((w.f0) i0Var5).removeOnPictureInPictureModeChangedListener(this.f1040q);
        }
        i0 i0Var6 = this.f1043t;
        if (i0Var6 instanceof h0.m) {
            ((h0.m) i0Var6).removeMenuProvider(this.f1041r);
        }
        this.f1043t = null;
        this.f1044u = null;
        this.f1045v = null;
        if (this.f1031g != null) {
            Iterator it2 = this.f1032h.f962b.iterator();
            while (it2.hasNext()) {
                ((androidx.activity.c) it2.next()).cancel();
            }
            this.f1031g = null;
        }
        androidx.activity.result.e eVar = this.f1049z;
        if (eVar != null) {
            eVar.b();
            this.A.b();
            this.B.b();
        }
    }

    public final void l(boolean z4) {
        if (z4 && (this.f1043t instanceof x.d)) {
            d0(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
            throw null;
        }
        for (Fragment fragment : this.f1027c.f()) {
            if (fragment != null) {
                fragment.performLowMemory();
                if (z4) {
                    fragment.mChildFragmentManager.l(true);
                }
            }
        }
    }

    public final void m(boolean z4, boolean z5) {
        if (z5 && (this.f1043t instanceof w.e0)) {
            d0(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.f1027c.f()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z4);
                if (z5) {
                    fragment.mChildFragmentManager.m(z4, true);
                }
            }
        }
    }

    public final void n() {
        Iterator it = this.f1027c.e().iterator();
        while (it.hasNext()) {
            Fragment fragment = (Fragment) it.next();
            if (fragment != null) {
                fragment.onHiddenChanged(fragment.isHidden());
                fragment.mChildFragmentManager.n();
            }
        }
    }

    public final boolean o(MenuItem menuItem) {
        if (this.f1042s < 1) {
            return false;
        }
        for (Fragment fragment : this.f1027c.f()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void p(Menu menu) {
        if (this.f1042s < 1) {
            return;
        }
        for (Fragment fragment : this.f1027c.f()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public final void q(Fragment fragment) {
        if (fragment == null || !fragment.equals(A(fragment.mWho))) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    public final void r(boolean z4, boolean z5) {
        if (z5 && (this.f1043t instanceof w.f0)) {
            d0(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.f1027c.f()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z4);
                if (z5) {
                    fragment.mChildFragmentManager.r(z4, true);
                }
            }
        }
    }

    public final boolean s(Menu menu) {
        boolean z4 = false;
        if (this.f1042s < 1) {
            return false;
        }
        for (Fragment fragment : this.f1027c.f()) {
            if (fragment != null && fragment.isMenuVisible() && fragment.performPrepareOptionsMenu(menu)) {
                z4 = true;
            }
        }
        return z4;
    }

    public final void t(int i5) {
        try {
            this.f1026b = true;
            for (d1 d1Var : this.f1027c.f868b.values()) {
                if (d1Var != null) {
                    d1Var.f862e = i5;
                }
            }
            N(i5, false);
            Iterator it = e().iterator();
            while (it.hasNext()) {
                ((t1) it.next()).e();
            }
            this.f1026b = false;
            x(true);
        } catch (Throwable th) {
            this.f1026b = false;
            throw th;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f1045v;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f1045v)));
            sb.append("}");
        } else {
            i0 i0Var = this.f1043t;
            if (i0Var != null) {
                sb.append(i0Var.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f1043t)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final void u(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String h5 = androidx.appcompat.widget.b0.h(str, "    ");
        e1 e1Var = this.f1027c;
        e1Var.getClass();
        String str2 = str + "    ";
        HashMap hashMap = e1Var.f868b;
        if (!hashMap.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (d1 d1Var : hashMap.values()) {
                printWriter.print(str);
                if (d1Var != null) {
                    Fragment fragment = d1Var.f860c;
                    printWriter.println(fragment);
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        ArrayList arrayList = e1Var.f867a;
        int size3 = arrayList.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i5 = 0; i5 < size3; i5++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(((Fragment) arrayList.get(i5)).toString());
            }
        }
        ArrayList arrayList2 = this.f1029e;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i6 = 0; i6 < size2; i6++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(((Fragment) this.f1029e.get(i6)).toString());
            }
        }
        ArrayList arrayList3 = this.f1028d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i7 = 0; i7 < size; i7++) {
                a aVar = (a) this.f1028d.get(i7);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i7);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.g(h5, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f1033i.get());
        synchronized (this.f1025a) {
            int size4 = this.f1025a.size();
            if (size4 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i8 = 0; i8 < size4; i8++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i8);
                    printWriter.print(": ");
                    printWriter.println((u0) this.f1025a.get(i8));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f1043t);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f1044u);
        if (this.f1045v != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f1045v);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f1042s);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.E);
        printWriter.print(" mStopped=");
        printWriter.print(this.F);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.G);
        if (this.D) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.D);
        }
    }

    public final void v(u0 u0Var, boolean z4) {
        if (!z4) {
            if (this.f1043t == null) {
                if (!this.G) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            } else if (M()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f1025a) {
            if (this.f1043t == null) {
                if (!z4) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
                return;
            }
            this.f1025a.add(u0Var);
            W();
        }
    }

    public final void w(boolean z4) {
        if (this.f1026b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f1043t == null) {
            if (!this.G) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        } else if (Looper.myLooper() != this.f1043t.f920i.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else {
            if (!z4 && M()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
            if (this.I == null) {
                this.I = new ArrayList();
                this.J = new ArrayList();
            }
        }
    }

    public final boolean x(boolean z4) {
        boolean z5;
        w(z4);
        boolean z6 = false;
        while (true) {
            ArrayList arrayList = this.I;
            ArrayList arrayList2 = this.J;
            synchronized (this.f1025a) {
                if (this.f1025a.isEmpty()) {
                    z5 = false;
                } else {
                    int size = this.f1025a.size();
                    z5 = false;
                    for (int i5 = 0; i5 < size; i5++) {
                        z5 |= ((u0) this.f1025a.get(i5)).a(arrayList, arrayList2);
                    }
                    this.f1025a.clear();
                    this.f1043t.f920i.removeCallbacks(this.M);
                }
            }
            if (!z5) {
                break;
            }
            z6 = true;
            this.f1026b = true;
            try {
                T(this.I, this.J);
            } finally {
                d();
            }
        }
        e0();
        if (this.H) {
            this.H = false;
            c0();
        }
        this.f1027c.f868b.values().removeAll(Collections.singleton(null));
        return z6;
    }

    public final void y(u0 u0Var, boolean z4) {
        if (z4 && (this.f1043t == null || this.G)) {
            return;
        }
        w(z4);
        if (u0Var.a(this.I, this.J)) {
            this.f1026b = true;
            try {
                T(this.I, this.J);
            } finally {
                d();
            }
        }
        e0();
        if (this.H) {
            this.H = false;
            c0();
        }
        this.f1027c.f868b.values().removeAll(Collections.singleton(null));
    }

    public final void z(ArrayList arrayList, ArrayList arrayList2, int i5, int i6) {
        ViewGroup viewGroup;
        e1 e1Var;
        e1 e1Var2;
        e1 e1Var3;
        int i7;
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = arrayList2;
        boolean z4 = ((a) arrayList3.get(i5)).f908p;
        ArrayList arrayList5 = this.K;
        if (arrayList5 == null) {
            this.K = new ArrayList();
        } else {
            arrayList5.clear();
        }
        ArrayList arrayList6 = this.K;
        e1 e1Var4 = this.f1027c;
        arrayList6.addAll(e1Var4.f());
        Fragment fragment = this.f1046w;
        int i8 = i5;
        boolean z5 = false;
        while (true) {
            int i9 = 1;
            if (i8 >= i6) {
                e1 e1Var5 = e1Var4;
                this.K.clear();
                if (!z4 && this.f1042s >= 1) {
                    for (int i10 = i5; i10 < i6; i10++) {
                        Iterator it = ((a) arrayList.get(i10)).f894a.iterator();
                        while (it.hasNext()) {
                            Fragment fragment2 = ((f1) it.next()).f881b;
                            if (fragment2 == null || fragment2.mFragmentManager == null) {
                                e1Var = e1Var5;
                            } else {
                                e1Var = e1Var5;
                                e1Var.g(f(fragment2));
                            }
                            e1Var5 = e1Var;
                        }
                    }
                }
                for (int i11 = i5; i11 < i6; i11++) {
                    a aVar = (a) arrayList.get(i11);
                    if (((Boolean) arrayList2.get(i11)).booleanValue()) {
                        aVar.e(-1);
                        ArrayList arrayList7 = aVar.f894a;
                        boolean z6 = true;
                        int size = arrayList7.size() - 1;
                        while (size >= 0) {
                            f1 f1Var = (f1) arrayList7.get(size);
                            Fragment fragment3 = f1Var.f881b;
                            if (fragment3 != null) {
                                fragment3.mBeingSaved = false;
                                fragment3.setPopDirection(z6);
                                int i12 = aVar.f899f;
                                int i13 = 8194;
                                int i14 = 4097;
                                if (i12 != 4097) {
                                    if (i12 != 8194) {
                                        i13 = 8197;
                                        i14 = 4100;
                                        if (i12 != 8197) {
                                            if (i12 == 4099) {
                                                i13 = 4099;
                                            } else if (i12 != 4100) {
                                                i13 = 0;
                                            }
                                        }
                                    }
                                    i13 = i14;
                                }
                                fragment3.setNextTransition(i13);
                                fragment3.setSharedElementNames(aVar.o, aVar.f907n);
                            }
                            int i15 = f1Var.f880a;
                            w0 w0Var = aVar.f818q;
                            switch (i15) {
                                case 1:
                                    fragment3.setAnimations(f1Var.f883d, f1Var.f884e, f1Var.f885f, f1Var.f886g);
                                    w0Var.X(fragment3, true);
                                    w0Var.S(fragment3);
                                    break;
                                case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + f1Var.f880a);
                                case 3:
                                    fragment3.setAnimations(f1Var.f883d, f1Var.f884e, f1Var.f885f, f1Var.f886g);
                                    w0Var.a(fragment3);
                                    break;
                                case 4:
                                    fragment3.setAnimations(f1Var.f883d, f1Var.f884e, f1Var.f885f, f1Var.f886g);
                                    w0Var.getClass();
                                    b0(fragment3);
                                    break;
                                case 5:
                                    fragment3.setAnimations(f1Var.f883d, f1Var.f884e, f1Var.f885f, f1Var.f886g);
                                    w0Var.X(fragment3, true);
                                    w0Var.H(fragment3);
                                    break;
                                case 6:
                                    fragment3.setAnimations(f1Var.f883d, f1Var.f884e, f1Var.f885f, f1Var.f886g);
                                    w0Var.c(fragment3);
                                    break;
                                case 7:
                                    fragment3.setAnimations(f1Var.f883d, f1Var.f884e, f1Var.f885f, f1Var.f886g);
                                    w0Var.X(fragment3, true);
                                    w0Var.g(fragment3);
                                    break;
                                case 8:
                                    w0Var.Z(null);
                                    break;
                                case 9:
                                    w0Var.Z(fragment3);
                                    break;
                                case 10:
                                    w0Var.Y(fragment3, f1Var.f887h);
                                    break;
                            }
                            size--;
                            z6 = true;
                        }
                        continue;
                    } else {
                        aVar.e(1);
                        ArrayList arrayList8 = aVar.f894a;
                        int size2 = arrayList8.size();
                        for (int i16 = 0; i16 < size2; i16++) {
                            f1 f1Var2 = (f1) arrayList8.get(i16);
                            Fragment fragment4 = f1Var2.f881b;
                            if (fragment4 != null) {
                                fragment4.mBeingSaved = false;
                                fragment4.setPopDirection(false);
                                fragment4.setNextTransition(aVar.f899f);
                                fragment4.setSharedElementNames(aVar.f907n, aVar.o);
                            }
                            int i17 = f1Var2.f880a;
                            w0 w0Var2 = aVar.f818q;
                            switch (i17) {
                                case 1:
                                    fragment4.setAnimations(f1Var2.f883d, f1Var2.f884e, f1Var2.f885f, f1Var2.f886g);
                                    w0Var2.X(fragment4, false);
                                    w0Var2.a(fragment4);
                                    break;
                                case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + f1Var2.f880a);
                                case 3:
                                    fragment4.setAnimations(f1Var2.f883d, f1Var2.f884e, f1Var2.f885f, f1Var2.f886g);
                                    w0Var2.S(fragment4);
                                    break;
                                case 4:
                                    fragment4.setAnimations(f1Var2.f883d, f1Var2.f884e, f1Var2.f885f, f1Var2.f886g);
                                    w0Var2.H(fragment4);
                                    break;
                                case 5:
                                    fragment4.setAnimations(f1Var2.f883d, f1Var2.f884e, f1Var2.f885f, f1Var2.f886g);
                                    w0Var2.X(fragment4, false);
                                    b0(fragment4);
                                    break;
                                case 6:
                                    fragment4.setAnimations(f1Var2.f883d, f1Var2.f884e, f1Var2.f885f, f1Var2.f886g);
                                    w0Var2.g(fragment4);
                                    break;
                                case 7:
                                    fragment4.setAnimations(f1Var2.f883d, f1Var2.f884e, f1Var2.f885f, f1Var2.f886g);
                                    w0Var2.X(fragment4, false);
                                    w0Var2.c(fragment4);
                                    break;
                                case 8:
                                    w0Var2.Z(fragment4);
                                    break;
                                case 9:
                                    w0Var2.Z(null);
                                    break;
                                case 10:
                                    w0Var2.Y(fragment4, f1Var2.f888i);
                                    break;
                            }
                        }
                        continue;
                    }
                }
                boolean booleanValue = ((Boolean) arrayList2.get(i6 - 1)).booleanValue();
                for (int i18 = i5; i18 < i6; i18++) {
                    a aVar2 = (a) arrayList.get(i18);
                    if (booleanValue) {
                        for (int size3 = aVar2.f894a.size() - 1; size3 >= 0; size3--) {
                            Fragment fragment5 = ((f1) aVar2.f894a.get(size3)).f881b;
                            if (fragment5 != null) {
                                f(fragment5).j();
                            }
                        }
                    } else {
                        Iterator it2 = aVar2.f894a.iterator();
                        while (it2.hasNext()) {
                            Fragment fragment6 = ((f1) it2.next()).f881b;
                            if (fragment6 != null) {
                                f(fragment6).j();
                            }
                        }
                    }
                }
                N(this.f1042s, true);
                HashSet hashSet = new HashSet();
                for (int i19 = i5; i19 < i6; i19++) {
                    Iterator it3 = ((a) arrayList.get(i19)).f894a.iterator();
                    while (it3.hasNext()) {
                        Fragment fragment7 = ((f1) it3.next()).f881b;
                        if (fragment7 != null && (viewGroup = fragment7.mContainer) != null) {
                            hashSet.add(t1.f(viewGroup, G()));
                        }
                    }
                }
                Iterator it4 = hashSet.iterator();
                while (it4.hasNext()) {
                    t1 t1Var = (t1) it4.next();
                    t1Var.f1013d = booleanValue;
                    t1Var.h();
                    t1Var.c();
                }
                for (int i20 = i5; i20 < i6; i20++) {
                    a aVar3 = (a) arrayList.get(i20);
                    if (((Boolean) arrayList2.get(i20)).booleanValue() && aVar3.f820s >= 0) {
                        aVar3.f820s = -1;
                    }
                    aVar3.getClass();
                }
                return;
            }
            a aVar4 = (a) arrayList3.get(i8);
            if (((Boolean) arrayList4.get(i8)).booleanValue()) {
                e1Var2 = e1Var4;
                int i21 = 1;
                ArrayList arrayList9 = this.K;
                ArrayList arrayList10 = aVar4.f894a;
                int size4 = arrayList10.size() - 1;
                while (size4 >= 0) {
                    f1 f1Var3 = (f1) arrayList10.get(size4);
                    int i22 = f1Var3.f880a;
                    if (i22 != i21) {
                        if (i22 != 3) {
                            switch (i22) {
                                case 8:
                                    fragment = null;
                                    break;
                                case 9:
                                    fragment = f1Var3.f881b;
                                    break;
                                case 10:
                                    f1Var3.f888i = f1Var3.f887h;
                                    break;
                            }
                            size4--;
                            i21 = 1;
                        }
                        arrayList9.add(f1Var3.f881b);
                        size4--;
                        i21 = 1;
                    }
                    arrayList9.remove(f1Var3.f881b);
                    size4--;
                    i21 = 1;
                }
            } else {
                ArrayList arrayList11 = this.K;
                int i23 = 0;
                while (true) {
                    ArrayList arrayList12 = aVar4.f894a;
                    if (i23 < arrayList12.size()) {
                        f1 f1Var4 = (f1) arrayList12.get(i23);
                        int i24 = f1Var4.f880a;
                        if (i24 != i9) {
                            if (i24 != 2) {
                                if (i24 == 3 || i24 == 6) {
                                    arrayList11.remove(f1Var4.f881b);
                                    Fragment fragment8 = f1Var4.f881b;
                                    if (fragment8 == fragment) {
                                        arrayList12.add(i23, new f1(fragment8, 9));
                                        i23++;
                                        e1Var3 = e1Var4;
                                        i7 = 1;
                                        fragment = null;
                                    }
                                } else if (i24 == 7) {
                                    e1Var3 = e1Var4;
                                    i7 = 1;
                                } else if (i24 == 8) {
                                    arrayList12.add(i23, new f1(9, fragment));
                                    f1Var4.f882c = true;
                                    i23++;
                                    fragment = f1Var4.f881b;
                                }
                                e1Var3 = e1Var4;
                                i7 = 1;
                            } else {
                                Fragment fragment9 = f1Var4.f881b;
                                int i25 = fragment9.mContainerId;
                                int size5 = arrayList11.size() - 1;
                                boolean z7 = false;
                                while (size5 >= 0) {
                                    e1 e1Var6 = e1Var4;
                                    Fragment fragment10 = (Fragment) arrayList11.get(size5);
                                    if (fragment10.mContainerId == i25) {
                                        if (fragment10 == fragment9) {
                                            z7 = true;
                                        } else {
                                            if (fragment10 == fragment) {
                                                arrayList12.add(i23, new f1(9, fragment10));
                                                i23++;
                                                fragment = null;
                                            }
                                            f1 f1Var5 = new f1(3, fragment10);
                                            f1Var5.f883d = f1Var4.f883d;
                                            f1Var5.f885f = f1Var4.f885f;
                                            f1Var5.f884e = f1Var4.f884e;
                                            f1Var5.f886g = f1Var4.f886g;
                                            arrayList12.add(i23, f1Var5);
                                            arrayList11.remove(fragment10);
                                            i23++;
                                            fragment = fragment;
                                        }
                                    }
                                    size5--;
                                    e1Var4 = e1Var6;
                                }
                                e1Var3 = e1Var4;
                                i7 = 1;
                                if (z7) {
                                    arrayList12.remove(i23);
                                    i23--;
                                } else {
                                    f1Var4.f880a = 1;
                                    f1Var4.f882c = true;
                                    arrayList11.add(fragment9);
                                }
                            }
                            i23 += i7;
                            i9 = i7;
                            e1Var4 = e1Var3;
                        } else {
                            e1Var3 = e1Var4;
                            i7 = i9;
                        }
                        arrayList11.add(f1Var4.f881b);
                        i23 += i7;
                        i9 = i7;
                        e1Var4 = e1Var3;
                    } else {
                        e1Var2 = e1Var4;
                    }
                }
            }
            z5 = z5 || aVar4.f900g;
            i8++;
            arrayList3 = arrayList;
            arrayList4 = arrayList2;
            e1Var4 = e1Var2;
        }
    }
}

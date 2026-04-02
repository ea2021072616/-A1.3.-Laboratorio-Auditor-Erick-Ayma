package androidx.preference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q0;
import androidx.fragment.app.w0;
import com.github.appintro.R;
import d.d;
import java.util.ArrayList;
import m0.a;
import p3.e;
import y0.a0;
import y0.e0;
import y0.l;
import y0.m;
import y0.n;
import y0.o;
import y0.s;
import y0.v;
import y0.z;
/* loaded from: classes.dex */
public class Preference implements Comparable<Preference> {
    public final boolean A;
    public final boolean B;
    public final boolean C;
    public final boolean D;
    public final boolean E;
    public int F;
    public final int G;
    public v H;
    public ArrayList I;
    public PreferenceGroup J;
    public boolean K;
    public n L;
    public o M;
    public final d N;

    /* renamed from: b  reason: collision with root package name */
    public final Context f1177b;

    /* renamed from: c  reason: collision with root package name */
    public a0 f1178c;

    /* renamed from: d  reason: collision with root package name */
    public long f1179d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1180e;

    /* renamed from: f  reason: collision with root package name */
    public l f1181f;

    /* renamed from: g  reason: collision with root package name */
    public m f1182g;

    /* renamed from: h  reason: collision with root package name */
    public int f1183h;

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f1184i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f1185j;

    /* renamed from: k  reason: collision with root package name */
    public int f1186k;

    /* renamed from: l  reason: collision with root package name */
    public Drawable f1187l;

    /* renamed from: m  reason: collision with root package name */
    public final String f1188m;

    /* renamed from: n  reason: collision with root package name */
    public Intent f1189n;
    public final String o;

    /* renamed from: p  reason: collision with root package name */
    public Bundle f1190p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f1191q;

    /* renamed from: r  reason: collision with root package name */
    public final boolean f1192r;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f1193s;

    /* renamed from: t  reason: collision with root package name */
    public final String f1194t;

    /* renamed from: u  reason: collision with root package name */
    public final Object f1195u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f1196v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f1197w;

    /* renamed from: x  reason: collision with root package name */
    public final boolean f1198x;

    /* renamed from: y  reason: collision with root package name */
    public final boolean f1199y;

    /* renamed from: z  reason: collision with root package name */
    public final boolean f1200z;

    public Preference(Context context, AttributeSet attributeSet, int i5) {
        this.f1183h = Integer.MAX_VALUE;
        this.f1191q = true;
        this.f1192r = true;
        this.f1193s = true;
        this.f1196v = true;
        this.f1197w = true;
        this.f1198x = true;
        this.f1199y = true;
        this.f1200z = true;
        this.B = true;
        this.E = true;
        this.F = R.layout.preference;
        this.N = new d(2, this);
        this.f1177b = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e0.f5611g, i5, 0);
        this.f1186k = obtainStyledAttributes.getResourceId(23, obtainStyledAttributes.getResourceId(0, 0));
        this.f1188m = a.n(obtainStyledAttributes, 26, 6);
        CharSequence text = obtainStyledAttributes.getText(34);
        this.f1184i = text == null ? obtainStyledAttributes.getText(4) : text;
        CharSequence text2 = obtainStyledAttributes.getText(33);
        this.f1185j = text2 == null ? obtainStyledAttributes.getText(7) : text2;
        this.f1183h = obtainStyledAttributes.getInt(28, obtainStyledAttributes.getInt(8, Integer.MAX_VALUE));
        this.o = a.n(obtainStyledAttributes, 22, 13);
        this.F = obtainStyledAttributes.getResourceId(27, obtainStyledAttributes.getResourceId(3, R.layout.preference));
        this.G = obtainStyledAttributes.getResourceId(35, obtainStyledAttributes.getResourceId(9, 0));
        this.f1191q = obtainStyledAttributes.getBoolean(21, obtainStyledAttributes.getBoolean(2, true));
        boolean z4 = obtainStyledAttributes.getBoolean(30, obtainStyledAttributes.getBoolean(5, true));
        this.f1192r = z4;
        this.f1193s = obtainStyledAttributes.getBoolean(29, obtainStyledAttributes.getBoolean(1, true));
        this.f1194t = a.n(obtainStyledAttributes, 19, 10);
        this.f1199y = obtainStyledAttributes.getBoolean(16, obtainStyledAttributes.getBoolean(16, z4));
        this.f1200z = obtainStyledAttributes.getBoolean(17, obtainStyledAttributes.getBoolean(17, z4));
        if (obtainStyledAttributes.hasValue(18)) {
            this.f1195u = p(obtainStyledAttributes, 18);
        } else if (obtainStyledAttributes.hasValue(11)) {
            this.f1195u = p(obtainStyledAttributes, 11);
        }
        this.E = obtainStyledAttributes.getBoolean(31, obtainStyledAttributes.getBoolean(12, true));
        boolean hasValue = obtainStyledAttributes.hasValue(32);
        this.A = hasValue;
        if (hasValue) {
            this.B = obtainStyledAttributes.getBoolean(32, obtainStyledAttributes.getBoolean(14, true));
        }
        this.C = obtainStyledAttributes.getBoolean(24, obtainStyledAttributes.getBoolean(15, false));
        this.f1198x = obtainStyledAttributes.getBoolean(25, obtainStyledAttributes.getBoolean(25, true));
        this.D = obtainStyledAttributes.getBoolean(20, obtainStyledAttributes.getBoolean(20, false));
        obtainStyledAttributes.recycle();
    }

    public static void w(View view, boolean z4) {
        view.setEnabled(z4);
        if (!(view instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                return;
            }
            w(viewGroup.getChildAt(childCount), z4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0072, code lost:
        if (r12 >= 2) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0093, code lost:
        if (x4.h.f5522f >= 2) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0095, code lost:
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0097, code lost:
        r12 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(java.io.Serializable r12) {
        /*
            r11 = this;
            y0.l r0 = r11.f1181f
            r1 = 1
            if (r0 == 0) goto Ld7
            u4.l r0 = (u4.l) r0
            int r2 = r0.f5170a
            r3 = 0
            r4 = 2131886354(0x7f120112, float:1.9407284E38)
            androidx.preference.SwitchPreferenceCompat r5 = r0.f5172c
            r6 = 0
            r7 = 2131886154(0x7f12004a, float:1.9406879E38)
            r8 = 2131886125(0x7f12002d, float:1.940682E38)
            ru.zdevs.zugate.activity.SettingsActivity$a r0 = r0.f5171b
            switch(r2) {
                case 0: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L5c
        L1c:
            int r2 = ru.zdevs.zugate.activity.SettingsActivity.a.f4589p
            r0.getClass()
            boolean r2 = r12 instanceof java.lang.Boolean
            if (r2 == 0) goto Ld2
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto Ld2
            d.m r12 = new d.m
            android.content.Context r2 = r0.getContext()
            r12.<init>(r2)
            r12.e(r8)
            java.lang.Object r2 = r12.f2398h
            d.i r2 = (d.i) r2
            android.content.Context r8 = r2.f2339a
            r9 = 2131886124(0x7f12002c, float:1.9406818E38)
            java.lang.CharSequence r8 = r8.getText(r9)
            r2.f2344f = r8
            r12.b(r7, r6)
            u4.m r2 = new u4.m
            r2.<init>()
            r12.d(r4, r2)
            d.n r12 = r12.a()
            r12.show()
            goto Ld0
        L5c:
            int r2 = ru.zdevs.zugate.activity.SettingsActivity.a.f4589p
            r0.getClass()
            boolean r2 = r12 instanceof java.lang.Boolean
            if (r2 == 0) goto Ld2
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto Ld2
            int r12 = x4.h.f5522f
            r2 = 2
            if (r12 == 0) goto L75
            if (r12 < r2) goto L97
            goto L95
        L75:
            x4.h.f5522f = r1
            x4.h r12 = x4.h.j(r3)
            if (r12 == 0) goto L91
            h0.h r9 = new h0.h
            r10 = 25
            r9.<init>(r10)
            java.lang.String r10 = "su -v"
            int r9 = r12.G(r10, r6, r9)
            if (r9 != 0) goto L8e
            x4.h.f5522f = r2
        L8e:
            r12.close()
        L91:
            int r12 = x4.h.f5522f
            if (r12 < r2) goto L97
        L95:
            r12 = r1
            goto L98
        L97:
            r12 = r3
        L98:
            if (r12 == 0) goto Lc8
            d.m r12 = new d.m
            android.content.Context r2 = r0.getContext()
            r12.<init>(r2)
            r12.e(r8)
            java.lang.Object r2 = r12.f2398h
            d.i r2 = (d.i) r2
            android.content.Context r8 = r2.f2339a
            r9 = 2131886121(0x7f120029, float:1.9406812E38)
            java.lang.CharSequence r8 = r8.getText(r9)
            r2.f2344f = r8
            r12.b(r7, r6)
            u4.m r2 = new u4.m
            r2.<init>()
            r12.d(r4, r2)
            d.n r12 = r12.a()
            r12.show()
            goto Ld0
        Lc8:
            r12 = 2131886122(0x7f12002a, float:1.9406814E38)
            java.lang.Object[] r0 = new java.lang.Object[r3]
            ru.zdevs.zugate.ZApp.c(r12, r0)
        Ld0:
            r12 = r3
            goto Ld3
        Ld2:
            r12 = r1
        Ld3:
            if (r12 == 0) goto Ld6
            goto Ld7
        Ld6:
            r1 = r3
        Ld7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.Preference.a(java.io.Serializable):boolean");
    }

    public void b(Bundle bundle) {
        Parcelable parcelable;
        String str = this.f1188m;
        if (!(!TextUtils.isEmpty(str)) || (parcelable = bundle.getParcelable(str)) == null) {
            return;
        }
        this.K = false;
        q(parcelable);
        if (!this.K) {
            throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
        }
    }

    public void c(Bundle bundle) {
        String str = this.f1188m;
        if (!TextUtils.isEmpty(str)) {
            this.K = false;
            Parcelable r5 = r();
            if (!this.K) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            }
            if (r5 != null) {
                bundle.putParcelable(str, r5);
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Preference preference) {
        Preference preference2 = preference;
        int i5 = this.f1183h;
        int i6 = preference2.f1183h;
        if (i5 != i6) {
            return i5 - i6;
        }
        CharSequence charSequence = this.f1184i;
        CharSequence charSequence2 = preference2.f1184i;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference2.f1184i.toString());
    }

    public long d() {
        return this.f1179d;
    }

    public final int e(int i5) {
        return !z() ? i5 : this.f1178c.c().getInt(this.f1188m, i5);
    }

    public final String f(String str) {
        return !z() ? str : this.f1178c.c().getString(this.f1188m, str);
    }

    public CharSequence g() {
        o oVar = this.M;
        return oVar != null ? ((e) oVar).s(this) : this.f1185j;
    }

    public boolean h() {
        return this.f1191q && this.f1196v && this.f1197w;
    }

    public void i() {
        int indexOf;
        v vVar = this.H;
        if (vVar == null || (indexOf = vVar.f5650l.indexOf(this)) == -1) {
            return;
        }
        vVar.f1372g.c(indexOf, 1, this);
    }

    public void j(boolean z4) {
        ArrayList arrayList = this.I;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            Preference preference = (Preference) arrayList.get(i5);
            if (preference.f1196v == z4) {
                preference.f1196v = !z4;
                preference.j(preference.y());
                preference.i();
            }
        }
    }

    public void k() {
        PreferenceScreen preferenceScreen;
        String str = this.f1194t;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a0 a0Var = this.f1178c;
        Preference preference = null;
        if (a0Var != null && (preferenceScreen = a0Var.f5590g) != null) {
            preference = preferenceScreen.A(str);
        }
        if (preference == null) {
            throw new IllegalStateException("Dependency \"" + str + "\" not found for preference \"" + this.f1188m + "\" (title: \"" + ((Object) this.f1184i) + "\"");
        }
        if (preference.I == null) {
            preference.I = new ArrayList();
        }
        preference.I.add(this);
        boolean y5 = preference.y();
        if (this.f1196v == y5) {
            this.f1196v = !y5;
            j(y());
            i();
        }
    }

    public final void l(a0 a0Var) {
        long j5;
        this.f1178c = a0Var;
        if (!this.f1180e) {
            synchronized (a0Var) {
                j5 = a0Var.f5585b;
                a0Var.f5585b = 1 + j5;
            }
            this.f1179d = j5;
        }
        if (z()) {
            a0 a0Var2 = this.f1178c;
            if ((a0Var2 != null ? a0Var2.c() : null).contains(this.f1188m)) {
                s(null);
                return;
            }
        }
        Object obj = this.f1195u;
        if (obj != null) {
            s(obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m(y0.d0 r11) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.Preference.m(y0.d0):void");
    }

    public void n() {
    }

    public void o() {
        ArrayList arrayList;
        PreferenceScreen preferenceScreen;
        String str = this.f1194t;
        if (str != null) {
            a0 a0Var = this.f1178c;
            Preference preference = null;
            if (a0Var != null && (preferenceScreen = a0Var.f5590g) != null) {
                preference = preferenceScreen.A(str);
            }
            if (preference == null || (arrayList = preference.I) == null) {
                return;
            }
            arrayList.remove(this);
        }
    }

    public Object p(TypedArray typedArray, int i5) {
        return null;
    }

    public void q(Parcelable parcelable) {
        this.K = true;
        if (parcelable != AbsSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    public Parcelable r() {
        this.K = true;
        return AbsSavedState.EMPTY_STATE;
    }

    public void s(Object obj) {
    }

    public void t(View view) {
        z zVar;
        if (h() && this.f1192r) {
            n();
            m mVar = this.f1182g;
            if (mVar != null) {
                mVar.c(this);
                return;
            }
            a0 a0Var = this.f1178c;
            if (a0Var != null && (zVar = a0Var.f5591h) != null) {
                Fragment fragment = (s) zVar;
                boolean z4 = false;
                String str = this.o;
                if (str != null) {
                    for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getParentFragment()) {
                    }
                    fragment.getContext();
                    fragment.a();
                    Log.w("PreferenceFragment", "onPreferenceStartFragment is not implemented in the parent activity - attempting to use a fallback implementation. You should implement this method so that you can configure the new fragment that will be displayed, and set a transition between the fragments.");
                    w0 parentFragmentManager = fragment.getParentFragmentManager();
                    if (this.f1190p == null) {
                        this.f1190p = new Bundle();
                    }
                    Bundle bundle = this.f1190p;
                    q0 F = parentFragmentManager.F();
                    fragment.requireActivity().getClassLoader();
                    Fragment a5 = F.a(str);
                    a5.setArguments(bundle);
                    a5.setTargetFragment(fragment, 0);
                    androidx.fragment.app.a aVar = new androidx.fragment.app.a(parentFragmentManager);
                    int id = ((View) fragment.requireView().getParent()).getId();
                    if (id == 0) {
                        throw new IllegalArgumentException("Must use non-zero containerViewId");
                    }
                    aVar.c(id, a5, null, 2);
                    if (!aVar.f901h) {
                        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
                    }
                    aVar.f900g = true;
                    aVar.f902i = null;
                    aVar.f(false);
                    z4 = true;
                }
                if (z4) {
                    return;
                }
            }
            Intent intent = this.f1189n;
            if (intent != null) {
                this.f1177b.startActivity(intent);
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequence = this.f1184i;
        if (!TextUtils.isEmpty(charSequence)) {
            sb.append(charSequence);
            sb.append(' ');
        }
        CharSequence g5 = g();
        if (!TextUtils.isEmpty(g5)) {
            sb.append(g5);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public final void u(int i5) {
        if (z() && i5 != e(~i5)) {
            SharedPreferences.Editor b5 = this.f1178c.b();
            b5.putInt(this.f1188m, i5);
            if (!this.f1178c.f5588e) {
                b5.apply();
            }
        }
    }

    public final void v(String str) {
        if (z() && !TextUtils.equals(str, f(null))) {
            SharedPreferences.Editor b5 = this.f1178c.b();
            b5.putString(this.f1188m, str);
            if (!this.f1178c.f5588e) {
                b5.apply();
            }
        }
    }

    public void x(CharSequence charSequence) {
        if (this.M != null) {
            throw new IllegalStateException("Preference already has a SummaryProvider set.");
        }
        if (TextUtils.equals(this.f1185j, charSequence)) {
            return;
        }
        this.f1185j = charSequence;
        i();
    }

    public boolean y() {
        return !h();
    }

    public final boolean z() {
        return this.f1178c != null && this.f1193s && (TextUtils.isEmpty(this.f1188m) ^ true);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.f(context, R.attr.preferenceStyle, 16842894));
    }
}

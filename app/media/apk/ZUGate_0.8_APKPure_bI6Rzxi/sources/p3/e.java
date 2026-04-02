package p3;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.KeyListener;
import android.text.method.TransformationMethod;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.fragment.app.z0;
import androidx.lifecycle.j0;
import androidx.lifecycle.k0;
import androidx.lifecycle.m0;
import androidx.lifecycle.r0;
import androidx.lifecycle.t0;
import androidx.lifecycle.v;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import com.github.appintro.R;
import h.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class e implements z, y0.o, z0.e, t0 {

    /* renamed from: h  reason: collision with root package name */
    public static e f4270h;

    /* renamed from: i  reason: collision with root package name */
    public static e f4271i;

    /* renamed from: j  reason: collision with root package name */
    public static e f4272j;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f4273g;

    public /* synthetic */ e() {
        this.f4273g = 15;
    }

    public static m0 d(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            if (bundle2 == null) {
                return new m0();
            }
            HashMap hashMap = new HashMap();
            for (String str : bundle2.keySet()) {
                e4.e.e(str, "key");
                hashMap.put(str, bundle2.get(str));
            }
            return new m0(hashMap);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if ((parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) ? false : true) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                Object obj = parcelableArrayList.get(i5);
                e4.e.d(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i5));
            }
            return new m0(linkedHashMap);
        }
        throw new IllegalStateException("Invalid bundle passed as restored state".toString());
    }

    public static void e(Activity activity, androidx.lifecycle.m mVar) {
        e4.e.f(activity, "activity");
        e4.e.f(mVar, "event");
        if (activity instanceof androidx.lifecycle.t) {
            androidx.lifecycle.o lifecycle = ((androidx.lifecycle.t) activity).getLifecycle();
            if (lifecycle instanceof v) {
                ((v) lifecycle).e(mVar);
            }
        }
    }

    public static l2.i g() {
        if (l2.i.f3857k == null) {
            l2.i.f3857k = new l2.i();
        }
        l2.i iVar = l2.i.f3857k;
        e4.e.c(iVar);
        return iVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0050, code lost:
        if (java.lang.Character.isHighSurrogate(r5) != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0080, code lost:
        if (r11 != false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x008d, code lost:
        if (java.lang.Character.isLowSurrogate(r5) != false) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean l(android.view.inputmethod.InputConnection r7, android.text.Editable r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.e.l(android.view.inputmethod.InputConnection, android.text.Editable, int, int, boolean):boolean");
    }

    public static void m(Activity activity) {
        e4.e.f(activity, "activity");
        if (Build.VERSION.SDK_INT >= 29) {
            j0.Companion.getClass();
            activity.registerActivityLifecycleCallbacks(new j0());
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new k0(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    @Override // androidx.lifecycle.t0
    public r0 a(Class cls) {
        switch (this.f4273g) {
            case 0:
                return new z0(true);
            default:
                return new x0.b();
        }
    }

    @Override // h.z
    public void b(h.o oVar, boolean z4) {
    }

    public InputFilter[] f(InputFilter[] inputFilterArr) {
        return inputFilterArr;
    }

    @Override // h.z
    public boolean h(h.o oVar) {
        return false;
    }

    public KeyListener i(KeyListener keyListener) {
        return keyListener;
    }

    public Signature[] j(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }

    @Override // z0.e
    public void k() {
    }

    @Override // z0.e
    public void n(int i5, Object obj) {
    }

    public boolean o() {
        return false;
    }

    public boolean p() {
        return false;
    }

    public boolean q(Spannable spannable) {
        return false;
    }

    public InputConnection r(InputConnection inputConnection, EditorInfo editorInfo) {
        return inputConnection;
    }

    public CharSequence s(Preference preference) {
        switch (this.f4273g) {
            case 27:
                EditTextPreference editTextPreference = (EditTextPreference) preference;
                return TextUtils.isEmpty(editTextPreference.U) ? editTextPreference.f1177b.getString(R.string.not_set) : editTextPreference.U;
            default:
                ListPreference listPreference = (ListPreference) preference;
                return TextUtils.isEmpty(listPreference.B()) ? listPreference.f1177b.getString(R.string.not_set) : listPreference.B();
        }
    }

    public void t(boolean z4) {
    }

    public void u(boolean z4) {
    }

    public void v(boolean z4) {
    }

    public void w(boolean z4) {
    }

    public void x() {
    }

    public void y() {
    }

    public TransformationMethod z(TransformationMethod transformationMethod) {
        return transformationMethod;
    }

    public /* synthetic */ e(int i5) {
        this.f4273g = i5;
    }
}

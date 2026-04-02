package y0;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i1;
import h0.z0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class v extends androidx.recyclerview.widget.i0 {

    /* renamed from: j  reason: collision with root package name */
    public final PreferenceGroup f5648j;

    /* renamed from: k  reason: collision with root package name */
    public ArrayList f5649k;

    /* renamed from: l  reason: collision with root package name */
    public ArrayList f5650l;

    /* renamed from: m  reason: collision with root package name */
    public final ArrayList f5651m;
    public final androidx.activity.j o = new androidx.activity.j(13, this);

    /* renamed from: n  reason: collision with root package name */
    public final Handler f5652n = new Handler(Looper.getMainLooper());

    public v(PreferenceScreen preferenceScreen) {
        this.f5648j = preferenceScreen;
        preferenceScreen.H = this;
        this.f5649k = new ArrayList();
        this.f5650l = new ArrayList();
        this.f5651m = new ArrayList();
        f(preferenceScreen.U);
        k();
    }

    public static boolean j(PreferenceGroup preferenceGroup) {
        return preferenceGroup.T != Integer.MAX_VALUE;
    }

    @Override // androidx.recyclerview.widget.i0
    public final int a() {
        return this.f5650l.size();
    }

    @Override // androidx.recyclerview.widget.i0
    public final long b(int i5) {
        if (this.f1373h) {
            return i(i5).d();
        }
        return -1L;
    }

    @Override // androidx.recyclerview.widget.i0
    public final int c(int i5) {
        u uVar = new u(i(i5));
        ArrayList arrayList = this.f5651m;
        int indexOf = arrayList.indexOf(uVar);
        if (indexOf != -1) {
            return indexOf;
        }
        int size = arrayList.size();
        arrayList.add(uVar);
        return size;
    }

    @Override // androidx.recyclerview.widget.i0
    public final void d(i1 i1Var, int i5) {
        ColorStateList colorStateList;
        d0 d0Var = (d0) i1Var;
        Preference i6 = i(i5);
        View view = d0Var.f1376a;
        Drawable background = view.getBackground();
        Drawable drawable = d0Var.f5600u;
        if (background != drawable) {
            WeakHashMap weakHashMap = z0.f3233a;
            view.setBackground(drawable);
        }
        TextView textView = (TextView) d0Var.q(16908310);
        if (textView != null && (colorStateList = d0Var.f5601v) != null && !textView.getTextColors().equals(colorStateList)) {
            textView.setTextColor(colorStateList);
        }
        i6.m(d0Var);
    }

    @Override // androidx.recyclerview.widget.i0
    public final i1 e(RecyclerView recyclerView, int i5) {
        u uVar = (u) this.f5651m.get(i5);
        LayoutInflater from = LayoutInflater.from(recyclerView.getContext());
        TypedArray obtainStyledAttributes = recyclerView.getContext().obtainStyledAttributes((AttributeSet) null, e0.f5605a);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (drawable == null) {
            drawable = p2.a.x(recyclerView.getContext(), 17301602);
        }
        obtainStyledAttributes.recycle();
        View inflate = from.inflate(uVar.f5645a, (ViewGroup) recyclerView, false);
        if (inflate.getBackground() == null) {
            WeakHashMap weakHashMap = z0.f3233a;
            inflate.setBackground(drawable);
        }
        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(16908312);
        if (viewGroup != null) {
            int i6 = uVar.f5646b;
            if (i6 != 0) {
                from.inflate(i6, viewGroup);
            } else {
                viewGroup.setVisibility(8);
            }
        }
        return new d0(inflate);
    }

    public final ArrayList g(PreferenceGroup preferenceGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int C = preferenceGroup.C();
        int i5 = 0;
        for (int i6 = 0; i6 < C; i6++) {
            Preference B = preferenceGroup.B(i6);
            if (B.f1198x) {
                if (!j(preferenceGroup) || i5 < preferenceGroup.T) {
                    arrayList.add(B);
                } else {
                    arrayList2.add(B);
                }
                if (B instanceof PreferenceGroup) {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) B;
                    if (!(!(preferenceGroup2 instanceof PreferenceScreen))) {
                        continue;
                    } else if (j(preferenceGroup) && j(preferenceGroup2)) {
                        throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                    } else {
                        Iterator it = g(preferenceGroup2).iterator();
                        while (it.hasNext()) {
                            Preference preference = (Preference) it.next();
                            if (!j(preferenceGroup) || i5 < preferenceGroup.T) {
                                arrayList.add(preference);
                            } else {
                                arrayList2.add(preference);
                            }
                            i5++;
                        }
                    }
                } else {
                    i5++;
                }
            }
        }
        if (j(preferenceGroup) && i5 > preferenceGroup.T) {
            e eVar = new e(preferenceGroup.f1177b, arrayList2, preferenceGroup.f1179d);
            eVar.f1182g = new androidx.appcompat.widget.d0(this, preferenceGroup, 5);
            arrayList.add(eVar);
        }
        return arrayList;
    }

    public final void h(PreferenceGroup preferenceGroup, ArrayList arrayList) {
        synchronized (preferenceGroup) {
            Collections.sort(preferenceGroup.P);
        }
        int C = preferenceGroup.C();
        for (int i5 = 0; i5 < C; i5++) {
            Preference B = preferenceGroup.B(i5);
            arrayList.add(B);
            u uVar = new u(B);
            if (!this.f5651m.contains(uVar)) {
                this.f5651m.add(uVar);
            }
            if (B instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) B;
                if (!(preferenceGroup2 instanceof PreferenceScreen)) {
                    h(preferenceGroup2, arrayList);
                }
            }
            B.H = this;
        }
    }

    public final Preference i(int i5) {
        if (i5 < 0 || i5 >= a()) {
            return null;
        }
        return (Preference) this.f5650l.get(i5);
    }

    public final void k() {
        Iterator it = this.f5649k.iterator();
        while (it.hasNext()) {
            ((Preference) it.next()).H = null;
        }
        ArrayList arrayList = new ArrayList(this.f5649k.size());
        this.f5649k = arrayList;
        PreferenceGroup preferenceGroup = this.f5648j;
        h(preferenceGroup, arrayList);
        this.f5650l = g(preferenceGroup);
        this.f1372g.b();
        Iterator it2 = this.f5649k.iterator();
        while (it2.hasNext()) {
            ((Preference) it2.next()).getClass();
        }
    }
}

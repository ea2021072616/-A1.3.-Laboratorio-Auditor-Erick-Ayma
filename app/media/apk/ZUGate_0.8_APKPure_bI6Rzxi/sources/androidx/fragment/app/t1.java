package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import com.github.appintro.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public abstract class t1 {

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroup f1010a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f1011b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f1012c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public boolean f1013d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1014e = false;

    public t1(ViewGroup viewGroup) {
        this.f1010a = viewGroup;
    }

    public static t1 f(ViewGroup viewGroup, n0 n0Var) {
        Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof t1) {
            return (t1) tag;
        }
        n0Var.getClass();
        n nVar = new n(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, nVar);
        return nVar;
    }

    public static t1 g(ViewGroup viewGroup, w0 w0Var) {
        return f(viewGroup, w0Var.G());
    }

    public final void a(int i5, int i6, d1 d1Var) {
        synchronized (this.f1011b) {
            d0.c cVar = new d0.c();
            s1 d5 = d(d1Var.f860c);
            if (d5 != null) {
                d5.c(i5, i6);
                return;
            }
            s1 s1Var = new s1(i5, i6, d1Var, cVar);
            this.f1011b.add(s1Var);
            s1Var.f1002d.add(new r1(this, s1Var, 0));
            s1Var.f1002d.add(new r1(this, s1Var, 1));
        }
    }

    public abstract void b(ArrayList arrayList, boolean z4);

    public final void c() {
        if (this.f1014e) {
            return;
        }
        ViewGroup viewGroup = this.f1010a;
        WeakHashMap weakHashMap = h0.z0.f3233a;
        if (!viewGroup.isAttachedToWindow()) {
            e();
            this.f1013d = false;
            return;
        }
        synchronized (this.f1011b) {
            if (!this.f1011b.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.f1012c);
                this.f1012c.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    s1 s1Var = (s1) it.next();
                    if (w0.I(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + s1Var);
                    }
                    s1Var.a();
                    if (!s1Var.f1005g) {
                        this.f1012c.add(s1Var);
                    }
                }
                i();
                ArrayList arrayList2 = new ArrayList(this.f1011b);
                this.f1011b.clear();
                this.f1012c.addAll(arrayList2);
                if (w0.I(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                }
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((s1) it2.next()).d();
                }
                b(arrayList2, this.f1013d);
                this.f1013d = false;
                if (w0.I(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                }
            }
        }
    }

    public final s1 d(Fragment fragment) {
        Iterator it = this.f1011b.iterator();
        while (it.hasNext()) {
            s1 s1Var = (s1) it.next();
            if (s1Var.f1001c.equals(fragment) && !s1Var.f1004f) {
                return s1Var;
            }
        }
        return null;
    }

    public final void e() {
        String str;
        String str2;
        if (w0.I(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        ViewGroup viewGroup = this.f1010a;
        WeakHashMap weakHashMap = h0.z0.f3233a;
        boolean isAttachedToWindow = viewGroup.isAttachedToWindow();
        synchronized (this.f1011b) {
            i();
            Iterator it = this.f1011b.iterator();
            while (it.hasNext()) {
                ((s1) it.next()).d();
            }
            Iterator it2 = new ArrayList(this.f1012c).iterator();
            while (it2.hasNext()) {
                s1 s1Var = (s1) it2.next();
                if (w0.I(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (isAttachedToWindow) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.f1010a + " is not attached to window. ";
                    }
                    sb.append(str2);
                    sb.append("Cancelling running operation ");
                    sb.append(s1Var);
                    Log.v("FragmentManager", sb.toString());
                }
                s1Var.a();
            }
            Iterator it3 = new ArrayList(this.f1011b).iterator();
            while (it3.hasNext()) {
                s1 s1Var2 = (s1) it3.next();
                if (w0.I(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (isAttachedToWindow) {
                        str = "";
                    } else {
                        str = "Container " + this.f1010a + " is not attached to window. ";
                    }
                    sb2.append(str);
                    sb2.append("Cancelling pending operation ");
                    sb2.append(s1Var2);
                    Log.v("FragmentManager", sb2.toString());
                }
                s1Var2.a();
            }
        }
    }

    public final void h() {
        synchronized (this.f1011b) {
            i();
            this.f1014e = false;
            int size = this.f1011b.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                s1 s1Var = (s1) this.f1011b.get(size);
                int c5 = androidx.appcompat.widget.b0.c(s1Var.f1001c.mView);
                if (s1Var.f999a == 2 && c5 != 2) {
                    this.f1014e = s1Var.f1001c.isPostponed();
                    break;
                }
            }
        }
    }

    public final void i() {
        Iterator it = this.f1011b.iterator();
        while (it.hasNext()) {
            s1 s1Var = (s1) it.next();
            if (s1Var.f1000b == 2) {
                s1Var.c(androidx.appcompat.widget.b0.b(s1Var.f1001c.requireView().getVisibility()), 1);
            }
        }
    }
}

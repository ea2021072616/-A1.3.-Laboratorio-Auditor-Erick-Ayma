package androidx.fragment.app;

import android.util.Log;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class a extends g1 implements u0 {

    /* renamed from: q  reason: collision with root package name */
    public final w0 f818q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f819r;

    /* renamed from: s  reason: collision with root package name */
    public int f820s;

    public a(w0 w0Var) {
        w0Var.F();
        i0 i0Var = w0Var.f1043t;
        if (i0Var != null) {
            i0Var.f919h.getClassLoader();
        }
        this.f820s = -1;
        this.f818q = w0Var;
    }

    @Override // androidx.fragment.app.u0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (w0.I(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (this.f900g) {
            w0 w0Var = this.f818q;
            if (w0Var.f1028d == null) {
                w0Var.f1028d = new ArrayList();
            }
            w0Var.f1028d.add(this);
            return true;
        }
        return true;
    }

    @Override // androidx.fragment.app.g1
    public final void c(int i5, Fragment fragment, String str, int i6) {
        String str2 = fragment.mPreviousWho;
        if (str2 != null) {
            u0.c.d(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.mTag;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i5 != 0) {
            if (i5 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i7 = fragment.mFragmentId;
            if (i7 != 0 && i7 != i5) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i5);
            }
            fragment.mFragmentId = i5;
            fragment.mContainerId = i5;
        }
        b(new f1(fragment, i6));
        fragment.mFragmentManager = this.f818q;
    }

    @Override // androidx.fragment.app.g1
    public final a d(Fragment fragment, androidx.lifecycle.n nVar) {
        w0 w0Var = fragment.mFragmentManager;
        w0 w0Var2 = this.f818q;
        if (w0Var != w0Var2) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + w0Var2);
        } else if (nVar == androidx.lifecycle.n.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + nVar + " after the Fragment has been created");
        } else if (nVar != androidx.lifecycle.n.DESTROYED) {
            b(new f1(fragment, nVar));
            return this;
        } else {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + nVar + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
    }

    public final void e(int i5) {
        f1 f1Var;
        if (this.f900g) {
            if (w0.I(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i5);
            }
            ArrayList arrayList = this.f894a;
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                Fragment fragment = ((f1) arrayList.get(i6)).f881b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i5;
                    if (w0.I(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + f1Var.f881b + " to " + f1Var.f881b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public final int f(boolean z4) {
        if (this.f819r) {
            throw new IllegalStateException("commit already called");
        }
        if (w0.I(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new q1());
            g("  ", printWriter, true);
            printWriter.close();
        }
        this.f819r = true;
        boolean z5 = this.f900g;
        w0 w0Var = this.f818q;
        if (z5) {
            this.f820s = w0Var.f1033i.getAndIncrement();
        } else {
            this.f820s = -1;
        }
        w0Var.v(this, z4);
        return this.f820s;
    }

    public final void g(String str, PrintWriter printWriter, boolean z4) {
        String str2;
        if (z4) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f902i);
            printWriter.print(" mIndex=");
            printWriter.print(this.f820s);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f819r);
            if (this.f899f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f899f));
            }
            if (this.f895b != 0 || this.f896c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f895b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f896c));
            }
            if (this.f897d != 0 || this.f898e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f897d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f898e));
            }
            if (this.f903j != 0 || this.f904k != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f903j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f904k);
            }
            if (this.f905l != 0 || this.f906m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f905l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f906m);
            }
        }
        ArrayList arrayList = this.f894a;
        if (arrayList.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            f1 f1Var = (f1) arrayList.get(i5);
            switch (f1Var.f880a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + f1Var.f880a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i5);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(f1Var.f881b);
            if (z4) {
                if (f1Var.f883d != 0 || f1Var.f884e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(f1Var.f883d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(f1Var.f884e));
                }
                if (f1Var.f885f != 0 || f1Var.f886g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(f1Var.f885f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(f1Var.f886g));
                }
            }
        }
    }

    public final a h(Fragment fragment) {
        w0 w0Var = fragment.mFragmentManager;
        if (w0Var == null || w0Var == this.f818q) {
            b(new f1(fragment, 3));
            return this;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f820s >= 0) {
            sb.append(" #");
            sb.append(this.f820s);
        }
        if (this.f902i != null) {
            sb.append(" ");
            sb.append(this.f902i);
        }
        sb.append("}");
        return sb.toString();
    }
}

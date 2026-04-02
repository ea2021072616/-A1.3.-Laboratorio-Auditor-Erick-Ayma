package androidx.fragment.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.appintro.R;
/* loaded from: classes.dex */
public class r extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: g  reason: collision with root package name */
    public Handler f978g;

    /* renamed from: p  reason: collision with root package name */
    public boolean f986p;

    /* renamed from: r  reason: collision with root package name */
    public Dialog f988r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f989s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f990t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f991u;

    /* renamed from: h  reason: collision with root package name */
    public final e f979h = new e(1, this);

    /* renamed from: i  reason: collision with root package name */
    public final o f980i = new o(this);

    /* renamed from: j  reason: collision with root package name */
    public final p f981j = new p(this);

    /* renamed from: k  reason: collision with root package name */
    public int f982k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f983l = 0;

    /* renamed from: m  reason: collision with root package name */
    public boolean f984m = true;

    /* renamed from: n  reason: collision with root package name */
    public boolean f985n = true;
    public int o = -1;

    /* renamed from: q  reason: collision with root package name */
    public final v f987q = new v(this);

    /* renamed from: v  reason: collision with root package name */
    public boolean f992v = false;

    @Override // androidx.fragment.app.Fragment
    public final g0 createFragmentContainer() {
        return new q(this, super.createFragmentContainer());
    }

    public final void g(boolean z4, boolean z5) {
        if (this.f990t) {
            return;
        }
        this.f990t = true;
        this.f991u = false;
        Dialog dialog = this.f988r;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f988r.dismiss();
            if (!z5) {
                if (Looper.myLooper() == this.f978g.getLooper()) {
                    onDismiss(this.f988r);
                } else {
                    this.f978g.post(this.f979h);
                }
            }
        }
        this.f989s = true;
        if (this.o >= 0) {
            w0 parentFragmentManager = getParentFragmentManager();
            int i5 = this.o;
            parentFragmentManager.getClass();
            if (i5 < 0) {
                throw new IllegalArgumentException(androidx.appcompat.widget.b0.f("Bad id: ", i5));
            }
            parentFragmentManager.v(new v0(parentFragmentManager, i5), z4);
            this.o = -1;
            return;
        }
        w0 parentFragmentManager2 = getParentFragmentManager();
        parentFragmentManager2.getClass();
        a aVar = new a(parentFragmentManager2);
        aVar.f908p = true;
        aVar.h(this);
        if (z4) {
            aVar.f(true);
        } else {
            aVar.f(false);
        }
    }

    public Dialog h(Bundle bundle) {
        if (w0.I(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new androidx.activity.p(requireContext(), this.f983l);
    }

    public final Dialog i() {
        Dialog dialog = this.f988r;
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void j(w0 w0Var, String str) {
        this.f990t = false;
        this.f991u = true;
        w0Var.getClass();
        a aVar = new a(w0Var);
        aVar.f908p = true;
        aVar.c(0, this, str, 1);
        aVar.f(false);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        super.onAttach(context);
        getViewLifecycleOwnerLiveData().e(this.f987q);
        if (this.f991u) {
            return;
        }
        this.f990t = false;
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f978g = new Handler();
        this.f985n = this.mContainerId == 0;
        if (bundle != null) {
            this.f982k = bundle.getInt("android:style", 0);
            this.f983l = bundle.getInt("android:theme", 0);
            this.f984m = bundle.getBoolean("android:cancelable", true);
            this.f985n = bundle.getBoolean("android:showsDialog", this.f985n);
            this.o = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.f988r;
        if (dialog != null) {
            this.f989s = true;
            dialog.setOnDismissListener(null);
            this.f988r.dismiss();
            if (!this.f990t) {
                onDismiss(this.f988r);
            }
            this.f988r = null;
            this.f992v = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        if (!this.f991u && !this.f990t) {
            this.f990t = true;
        }
        androidx.lifecycle.z viewLifecycleOwnerLiveData = getViewLifecycleOwnerLiveData();
        viewLifecycleOwnerLiveData.getClass();
        androidx.lifecycle.z.a("removeObserver");
        androidx.lifecycle.y yVar = (androidx.lifecycle.y) viewLifecycleOwnerLiveData.f1166b.f(this.f987q);
        if (yVar == null) {
            return;
        }
        yVar.d();
        yVar.c(false);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f989s) {
            return;
        }
        if (w0.I(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        g(true, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0046 A[Catch: all -> 0x006b, TryCatch #0 {all -> 0x006b, blocks: (B:12:0x001a, B:14:0x0026, B:24:0x003e, B:26:0x0046, B:27:0x004d, B:20:0x0030, B:22:0x0036, B:23:0x003b, B:28:0x0065), top: B:47:0x001a }] */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.LayoutInflater onGetLayoutInflater(android.os.Bundle r8) {
        /*
            r7 = this;
            android.view.LayoutInflater r0 = super.onGetLayoutInflater(r8)
            boolean r1 = r7.f985n
            java.lang.String r2 = "FragmentManager"
            r3 = 2
            if (r1 == 0) goto L98
            boolean r4 = r7.f986p
            if (r4 == 0) goto L11
            goto L98
        L11:
            if (r1 != 0) goto L14
            goto L6f
        L14:
            boolean r1 = r7.f992v
            if (r1 != 0) goto L6f
            r1 = 0
            r4 = 1
            r7.f986p = r4     // Catch: java.lang.Throwable -> L6b
            android.app.Dialog r8 = r7.h(r8)     // Catch: java.lang.Throwable -> L6b
            r7.f988r = r8     // Catch: java.lang.Throwable -> L6b
            boolean r5 = r7.f985n     // Catch: java.lang.Throwable -> L6b
            if (r5 == 0) goto L65
            int r5 = r7.f982k     // Catch: java.lang.Throwable -> L6b
            if (r5 == r4) goto L3b
            if (r5 == r3) goto L3b
            r6 = 3
            if (r5 == r6) goto L30
            goto L3e
        L30:
            android.view.Window r5 = r8.getWindow()     // Catch: java.lang.Throwable -> L6b
            if (r5 == 0) goto L3b
            r6 = 24
            r5.addFlags(r6)     // Catch: java.lang.Throwable -> L6b
        L3b:
            r8.requestWindowFeature(r4)     // Catch: java.lang.Throwable -> L6b
        L3e:
            android.content.Context r8 = r7.getContext()     // Catch: java.lang.Throwable -> L6b
            boolean r5 = r8 instanceof android.app.Activity     // Catch: java.lang.Throwable -> L6b
            if (r5 == 0) goto L4d
            android.app.Dialog r5 = r7.f988r     // Catch: java.lang.Throwable -> L6b
            android.app.Activity r8 = (android.app.Activity) r8     // Catch: java.lang.Throwable -> L6b
            r5.setOwnerActivity(r8)     // Catch: java.lang.Throwable -> L6b
        L4d:
            android.app.Dialog r8 = r7.f988r     // Catch: java.lang.Throwable -> L6b
            boolean r5 = r7.f984m     // Catch: java.lang.Throwable -> L6b
            r8.setCancelable(r5)     // Catch: java.lang.Throwable -> L6b
            android.app.Dialog r8 = r7.f988r     // Catch: java.lang.Throwable -> L6b
            androidx.fragment.app.o r5 = r7.f980i     // Catch: java.lang.Throwable -> L6b
            r8.setOnCancelListener(r5)     // Catch: java.lang.Throwable -> L6b
            android.app.Dialog r8 = r7.f988r     // Catch: java.lang.Throwable -> L6b
            androidx.fragment.app.p r5 = r7.f981j     // Catch: java.lang.Throwable -> L6b
            r8.setOnDismissListener(r5)     // Catch: java.lang.Throwable -> L6b
            r7.f992v = r4     // Catch: java.lang.Throwable -> L6b
            goto L68
        L65:
            r8 = 0
            r7.f988r = r8     // Catch: java.lang.Throwable -> L6b
        L68:
            r7.f986p = r1
            goto L6f
        L6b:
            r8 = move-exception
            r7.f986p = r1
            throw r8
        L6f:
            boolean r8 = androidx.fragment.app.w0.I(r3)
            if (r8 == 0) goto L8b
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r1 = "get layout inflater for DialogFragment "
            r8.<init>(r1)
            r8.append(r7)
            java.lang.String r1 = " from dialog context"
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            android.util.Log.d(r2, r8)
        L8b:
            android.app.Dialog r8 = r7.f988r
            if (r8 == 0) goto L97
            android.content.Context r8 = r8.getContext()
            android.view.LayoutInflater r0 = r0.cloneInContext(r8)
        L97:
            return r0
        L98:
            boolean r8 = androidx.fragment.app.w0.I(r3)
            if (r8 == 0) goto Ld3
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r1 = "getting layout inflater for DialogFragment "
            r8.<init>(r1)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            boolean r1 = r7.f985n
            if (r1 != 0) goto Lc2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "mShowsDialog = false: "
            r1.<init>(r3)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            android.util.Log.d(r2, r8)
            goto Ld3
        Lc2:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "mCreatingDialog = true: "
            r1.<init>(r3)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            android.util.Log.d(r2, r8)
        Ld3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.r.onGetLayoutInflater(android.os.Bundle):android.view.LayoutInflater");
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.f988r;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i5 = this.f982k;
        if (i5 != 0) {
            bundle.putInt("android:style", i5);
        }
        int i6 = this.f983l;
        if (i6 != 0) {
            bundle.putInt("android:theme", i6);
        }
        boolean z4 = this.f984m;
        if (!z4) {
            bundle.putBoolean("android:cancelable", z4);
        }
        boolean z5 = this.f985n;
        if (!z5) {
            bundle.putBoolean("android:showsDialog", z5);
        }
        int i7 = this.o;
        if (i7 != -1) {
            bundle.putInt("android:backStackId", i7);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = this.f988r;
        if (dialog != null) {
            this.f989s = false;
            dialog.show();
            View decorView = this.f988r.getWindow().getDecorView();
            b4.j.S(decorView, this);
            decorView.setTag(R.id.view_tree_view_model_store_owner, this);
            b4.j.T(decorView, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Dialog dialog = this.f988r;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewStateRestored(Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.f988r == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f988r.onRestoreInstanceState(bundle2);
    }

    @Override // androidx.fragment.app.Fragment
    public final void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView != null || this.f988r == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f988r.onRestoreInstanceState(bundle2);
    }
}

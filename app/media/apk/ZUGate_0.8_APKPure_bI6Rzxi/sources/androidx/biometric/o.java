package androidx.biometric;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w0;
import com.github.appintro.R;
/* loaded from: classes.dex */
public class o extends Fragment {

    /* renamed from: g  reason: collision with root package name */
    public final Handler f629g = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public x f630h;

    public final void g(int i5) {
        if (i5 == 3 || !this.f630h.f657p) {
            if (k()) {
                this.f630h.f653k = i5;
                if (i5 == 1) {
                    n(10, m0.a.g(getContext(), 10));
                }
            }
            x xVar = this.f630h;
            if (xVar.f650h == null) {
                xVar.f650h = new r();
            }
            r rVar = xVar.f650h;
            Object obj = rVar.f632b;
            if (((CancellationSignal) obj) != null) {
                try {
                    y.a((CancellationSignal) obj);
                } catch (NullPointerException e5) {
                    Log.e("CancelSignalProvider", "Got NPE while canceling biometric authentication.", e5);
                }
                rVar.f632b = null;
            }
            Object obj2 = rVar.f633c;
            if (((d0.c) obj2) != null) {
                try {
                    ((d0.c) obj2).a();
                } catch (NullPointerException e6) {
                    Log.e("CancelSignalProvider", "Got NPE while canceling fingerprint authentication.", e6);
                }
                rVar.f633c = null;
            }
        }
    }

    public final void h() {
        this.f630h.f654l = false;
        i();
        if (!this.f630h.f656n && isAdded()) {
            w0 parentFragmentManager = getParentFragmentManager();
            parentFragmentManager.getClass();
            androidx.fragment.app.a aVar = new androidx.fragment.app.a(parentFragmentManager);
            aVar.h(this);
            aVar.f(true);
        }
        Context context = getContext();
        if (context != null) {
            if (Build.VERSION.SDK_INT == 29 ? p2.a.E(R.array.delay_showing_prompt_models, context, Build.MODEL) : false) {
                x xVar = this.f630h;
                xVar.o = true;
                this.f629g.postDelayed(new n(xVar, 1), 600L);
            }
        }
    }

    public final void i() {
        this.f630h.f654l = false;
        if (isAdded()) {
            w0 parentFragmentManager = getParentFragmentManager();
            e0 e0Var = (e0) parentFragmentManager.C("androidx.biometric.FingerprintDialogFragment");
            if (e0Var != null) {
                if (e0Var.isAdded()) {
                    e0Var.g(true, false);
                    return;
                }
                androidx.fragment.app.a aVar = new androidx.fragment.app.a(parentFragmentManager);
                aVar.h(e0Var);
                aVar.f(true);
            }
        }
    }

    public final boolean j() {
        return Build.VERSION.SDK_INT <= 28 && m0.a.q(this.f630h.c());
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k() {
        /*
            r10 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 1
            r2 = 28
            if (r0 < r2) goto L77
            androidx.fragment.app.d0 r3 = r10.a()
            r4 = 0
            if (r3 == 0) goto L4e
            androidx.biometric.x r5 = r10.f630h
            g.f r5 = r5.f648f
            if (r5 == 0) goto L4e
            java.lang.String r5 = android.os.Build.MANUFACTURER
            java.lang.String r6 = android.os.Build.MODEL
            if (r0 == r2) goto L1b
            goto L47
        L1b:
            if (r5 != 0) goto L1e
            goto L3a
        L1e:
            android.content.res.Resources r0 = r3.getResources()
            r7 = 2130903044(0x7f030004, float:1.7412895E38)
            java.lang.String[] r0 = r0.getStringArray(r7)
            int r7 = r0.length
            r8 = r4
        L2b:
            if (r8 >= r7) goto L3a
            r9 = r0[r8]
            boolean r9 = r5.equalsIgnoreCase(r9)
            if (r9 == 0) goto L37
            r0 = r1
            goto L3b
        L37:
            int r8 = r8 + 1
            goto L2b
        L3a:
            r0 = r4
        L3b:
            if (r0 != 0) goto L49
            r0 = 2130903043(0x7f030003, float:1.7412893E38)
            boolean r0 = p2.a.F(r0, r3, r6)
            if (r0 == 0) goto L47
            goto L49
        L47:
            r0 = r4
            goto L4a
        L49:
            r0 = r1
        L4a:
            if (r0 == 0) goto L4e
            r0 = r1
            goto L4f
        L4e:
            r0 = r4
        L4f:
            if (r0 != 0) goto L77
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 != r2) goto L72
            android.content.Context r0 = r10.getContext()
            if (r0 == 0) goto L6d
            android.content.pm.PackageManager r2 = r0.getPackageManager()
            if (r2 == 0) goto L6d
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            boolean r0 = androidx.biometric.g0.a(r0)
            if (r0 == 0) goto L6d
            r0 = r1
            goto L6e
        L6d:
            r0 = r4
        L6e:
            if (r0 != 0) goto L72
            r0 = r1
            goto L73
        L72:
            r0 = r4
        L73:
            if (r0 == 0) goto L76
            goto L77
        L76:
            r1 = r4
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.biometric.o.k():boolean");
    }

    public final void l() {
        androidx.fragment.app.d0 a5 = a();
        if (a5 == null) {
            Log.e("BiometricFragment", "Failed to check device credential. Client FragmentActivity not found.");
            return;
        }
        KeyguardManager a6 = f0.a(a5);
        if (a6 == null) {
            m(12, getString(R.string.generic_error_no_keyguard));
            return;
        }
        t tVar = this.f630h.f647e;
        CharSequence charSequence = tVar != null ? tVar.f636a : null;
        CharSequence charSequence2 = tVar != null ? tVar.f637b : null;
        CharSequence charSequence3 = tVar != null ? tVar.f638c : null;
        if (charSequence2 == null) {
            charSequence2 = charSequence3;
        }
        Intent a7 = i.a(a6, charSequence, charSequence2);
        if (a7 == null) {
            m(14, getString(R.string.generic_error_no_device_credential));
            return;
        }
        this.f630h.f656n = true;
        if (k()) {
            i();
        }
        a7.setFlags(134742016);
        startActivityForResult(a7, 1);
    }

    public final void m(int i5, CharSequence charSequence) {
        n(i5, charSequence);
        h();
    }

    public final void n(int i5, CharSequence charSequence) {
        x xVar = this.f630h;
        if (xVar.f656n) {
            Log.v("BiometricFragment", "Error not sent to client. User is confirming their device credential.");
        } else if (!xVar.f655m) {
            Log.w("BiometricFragment", "Error not sent to client. Client is not awaiting a result.");
        } else {
            xVar.f655m = false;
            new Handler(Looper.getMainLooper()).post(new f(this, i5, charSequence, 0));
        }
    }

    public final void o(s sVar) {
        x xVar = this.f630h;
        if (xVar.f655m) {
            xVar.f655m = false;
            new Handler(Looper.getMainLooper()).post(new androidx.appcompat.widget.k(this, 1, sVar));
        } else {
            Log.w("BiometricFragment", "Success not sent to client. Client is not awaiting a result.");
        }
        h();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i5, int i6, Intent intent) {
        super.onActivityResult(i5, i6, intent);
        if (i5 == 1) {
            this.f630h.f656n = false;
            if (i6 == -1) {
                o(new s(null, 1));
            } else {
                m(10, getString(R.string.generic_error_user_canceled));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (a() == null) {
            return;
        }
        x xVar = (x) new d.e(a()).j(x.class);
        this.f630h = xVar;
        if (xVar.f658q == null) {
            xVar.f658q = new androidx.lifecycle.a0();
        }
        xVar.f658q.d(this, new h(this, 0));
        x xVar2 = this.f630h;
        if (xVar2.f659r == null) {
            xVar2.f659r = new androidx.lifecycle.a0();
        }
        xVar2.f659r.d(this, new h(this, 1));
        x xVar3 = this.f630h;
        if (xVar3.f660s == null) {
            xVar3.f660s = new androidx.lifecycle.a0();
        }
        xVar3.f660s.d(this, new h(this, 2));
        x xVar4 = this.f630h;
        if (xVar4.f661t == null) {
            xVar4.f661t = new androidx.lifecycle.a0();
        }
        xVar4.f661t.d(this, new h(this, 3));
        x xVar5 = this.f630h;
        if (xVar5.f662u == null) {
            xVar5.f662u = new androidx.lifecycle.a0();
        }
        xVar5.f662u.d(this, new h(this, 4));
        x xVar6 = this.f630h;
        if (xVar6.f664w == null) {
            xVar6.f664w = new androidx.lifecycle.a0();
        }
        xVar6.f664w.d(this, new h(this, 5));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT == 29 && m0.a.q(this.f630h.c())) {
            x xVar = this.f630h;
            xVar.f657p = true;
            this.f629g.postDelayed(new n(xVar, 2), 250L);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        if (Build.VERSION.SDK_INT >= 29 || this.f630h.f656n) {
            return;
        }
        androidx.fragment.app.d0 a5 = a();
        if (a5 != null && a5.isChangingConfigurations()) {
            return;
        }
        g(0);
    }

    public final void p(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = getString(R.string.default_error_msg);
        }
        this.f630h.g(2);
        this.f630h.f(charSequence);
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0148 A[Catch: NullPointerException -> 0x013f, TRY_LEAVE, TryCatch #3 {NullPointerException -> 0x013f, blocks: (B:68:0x0125, B:82:0x0141, B:84:0x0148, B:69:0x0126, B:71:0x012a, B:73:0x0135, B:74:0x0138, B:75:0x013a), top: B:150:0x0125 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q() {
        /*
            Method dump skipped, instructions count: 618
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.biometric.o.q():void");
    }
}

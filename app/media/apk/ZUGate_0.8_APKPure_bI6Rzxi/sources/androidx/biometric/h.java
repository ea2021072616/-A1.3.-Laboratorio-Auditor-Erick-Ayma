package androidx.biometric;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.github.appintro.R;
/* loaded from: classes.dex */
public final class h implements androidx.lifecycle.b0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f623g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ o f624h;

    public /* synthetic */ h(o oVar, int i5) {
        this.f623g = i5;
        this.f624h = oVar;
    }

    public final void a(Boolean bool) {
        int i5 = this.f623g;
        o oVar = this.f624h;
        switch (i5) {
            case 3:
                if (bool.booleanValue()) {
                    if (oVar.k()) {
                        oVar.p(oVar.getString(R.string.fingerprint_not_recognized));
                    }
                    if (oVar.f630h.f655m) {
                        new Handler(Looper.getMainLooper()).post(new g(oVar, 0));
                    } else {
                        Log.w("BiometricFragment", "Failure not sent to client. Client is not awaiting a result.");
                    }
                    x xVar = oVar.f630h;
                    if (xVar.f661t == null) {
                        xVar.f661t = new androidx.lifecycle.a0();
                    }
                    x.i(xVar.f661t, Boolean.FALSE);
                    return;
                }
                return;
            case 4:
                if (bool.booleanValue()) {
                    if (oVar.j()) {
                        oVar.l();
                    } else {
                        CharSequence d5 = oVar.f630h.d();
                        if (d5 == null) {
                            d5 = oVar.getString(R.string.default_error_msg);
                        }
                        oVar.m(13, d5);
                        oVar.g(2);
                    }
                    oVar.f630h.h(false);
                    return;
                }
                return;
            default:
                if (bool.booleanValue()) {
                    oVar.g(1);
                    oVar.h();
                    x xVar2 = oVar.f630h;
                    if (xVar2.f664w == null) {
                        xVar2.f664w = new androidx.lifecycle.a0();
                    }
                    x.i(xVar2.f664w, Boolean.FALSE);
                    return;
                }
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c4, code lost:
        if (r9 != false) goto L65;
     */
    @Override // androidx.lifecycle.b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.biometric.h.b(java.lang.Object):void");
    }
}

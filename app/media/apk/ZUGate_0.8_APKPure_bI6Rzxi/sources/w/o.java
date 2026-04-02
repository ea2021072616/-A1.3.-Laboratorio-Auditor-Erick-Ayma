package w;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.k0;
/* loaded from: classes.dex */
public abstract class o extends Activity implements androidx.lifecycle.t, h0.l {
    private final l.j extraDataMap = new l.j();
    private final androidx.lifecycle.v lifecycleRegistry = new androidx.lifecycle.v(this);

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        e4.e.f(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        e4.e.e(decorView, "window.decorView");
        if (p2.a.s(decorView, keyEvent)) {
            return true;
        }
        return p2.a.t(this, decorView, this, keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        e4.e.f(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        e4.e.e(decorView, "window.decorView");
        if (p2.a.s(decorView, keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    public <T extends n> T getExtraData(Class<T> cls) {
        e4.e.f(cls, "extraDataClass");
        androidx.appcompat.widget.b0.n(this.extraDataMap.getOrDefault(cls, null));
        return null;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i5 = k0.f1113h;
        p3.e.m(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        e4.e.f(bundle, "outState");
        this.lifecycleRegistry.g();
        super.onSaveInstanceState(bundle);
    }

    public void putExtraData(n nVar) {
        e4.e.f(nVar, "extraData");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0022, code lost:
        if (r4.equals("--autofill") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0032, code lost:
        if (android.os.Build.VERSION.SDK_INT < 29) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0034, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003c, code lost:
        if (r4.equals("--list-dumpables") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0045, code lost:
        if (r4.equals("--dump-dumpable") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004c, code lost:
        if (android.os.Build.VERSION.SDK_INT < 33) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x005c, code lost:
        if (android.os.Build.VERSION.SDK_INT < 31) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean shouldDumpInternalState(java.lang.String[] r4) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            if (r4 == 0) goto Lf
            int r2 = r4.length
            if (r2 != 0) goto L9
            r2 = r0
            goto La
        L9:
            r2 = r1
        La:
            if (r2 == 0) goto Ld
            goto Lf
        Ld:
            r2 = r1
            goto L10
        Lf:
            r2 = r0
        L10:
            if (r2 != 0) goto L5f
            r4 = r4[r1]
            int r2 = r4.hashCode()
            switch(r2) {
                case -645125871: goto L4f;
                case 100470631: goto L3f;
                case 472614934: goto L36;
                case 1159329357: goto L25;
                case 1455016274: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L5f
        L1c:
            java.lang.String r2 = "--autofill"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L34
            goto L5f
        L25:
            java.lang.String r2 = "--contentcapture"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L2e
            goto L5f
        L2e:
            int r4 = android.os.Build.VERSION.SDK_INT
            r2 = 29
            if (r4 < r2) goto L5f
        L34:
            r1 = r0
            goto L5f
        L36:
            java.lang.String r2 = "--list-dumpables"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L48
            goto L5f
        L3f:
            java.lang.String r2 = "--dump-dumpable"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L48
            goto L5f
        L48:
            int r4 = android.os.Build.VERSION.SDK_INT
            r2 = 33
            if (r4 < r2) goto L5f
            goto L34
        L4f:
            java.lang.String r2 = "--translation"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L58
            goto L5f
        L58:
            int r4 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r4 < r2) goto L5f
            goto L34
        L5f:
            r4 = r1 ^ 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: w.o.shouldDumpInternalState(java.lang.String[]):boolean");
    }

    @Override // h0.l
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        e4.e.f(keyEvent, "event");
        return super.dispatchKeyEvent(keyEvent);
    }
}

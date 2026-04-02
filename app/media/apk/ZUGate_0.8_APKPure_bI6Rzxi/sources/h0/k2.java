package h0;

import android.view.View;
import android.view.Window;
/* loaded from: classes.dex */
public final class k2 extends j2 {
    @Override // p3.e
    public final void u(boolean z4) {
        if (!z4) {
            A(16);
            return;
        }
        Window window = this.f3156k;
        window.clearFlags(134217728);
        window.addFlags(Integer.MIN_VALUE);
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(16 | decorView.getSystemUiVisibility());
    }
}

package h0;

import android.view.View;
import android.view.Window;
/* loaded from: classes.dex */
public abstract class j2 extends i2 {
    @Override // p3.e
    public final boolean o() {
        return (this.f3156k.getDecorView().getSystemUiVisibility() & 8192) != 0;
    }

    @Override // p3.e
    public final void v(boolean z4) {
        if (!z4) {
            A(8192);
            return;
        }
        Window window = this.f3156k;
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(8192 | decorView.getSystemUiVisibility());
    }
}

package h0;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;
/* loaded from: classes.dex */
public class c2 extends b2 {
    public c2(h2 h2Var, WindowInsets windowInsets) {
        super(h2Var, windowInsets);
    }

    @Override // h0.f2
    public h2 a() {
        WindowInsets consumeDisplayCutout;
        consumeDisplayCutout = this.f3099c.consumeDisplayCutout();
        return h2.i(null, consumeDisplayCutout);
    }

    @Override // h0.f2
    public k e() {
        DisplayCutout displayCutout;
        displayCutout = this.f3099c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new k(displayCutout);
    }

    @Override // h0.a2, h0.f2
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c2) {
            c2 c2Var = (c2) obj;
            return Objects.equals(this.f3099c, c2Var.f3099c) && Objects.equals(this.f3103g, c2Var.f3103g);
        }
        return false;
    }

    @Override // h0.f2
    public int hashCode() {
        return this.f3099c.hashCode();
    }
}

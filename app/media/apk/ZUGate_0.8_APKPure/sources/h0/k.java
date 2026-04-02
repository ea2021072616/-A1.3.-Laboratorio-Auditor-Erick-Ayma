package h0;

import android.view.DisplayCutout;
import java.util.Objects;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final DisplayCutout f3163a;

    public k(DisplayCutout displayCutout) {
        this.f3163a = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f3163a, ((k) obj).f3163a);
    }

    public final int hashCode() {
        int hashCode;
        DisplayCutout displayCutout = this.f3163a;
        if (displayCutout == null) {
            return 0;
        }
        hashCode = displayCutout.hashCode();
        return hashCode;
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f3163a + "}";
    }
}

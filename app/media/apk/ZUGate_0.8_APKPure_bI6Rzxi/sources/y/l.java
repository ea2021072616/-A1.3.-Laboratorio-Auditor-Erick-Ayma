package y;

import android.content.res.Resources;
import java.util.Objects;
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final Resources f5560a;

    /* renamed from: b  reason: collision with root package name */
    public final Resources.Theme f5561b;

    public l(Resources resources, Resources.Theme theme) {
        this.f5560a = resources;
        this.f5561b = theme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.f5560a.equals(lVar.f5560a) && Objects.equals(this.f5561b, lVar.f5561b);
    }

    public final int hashCode() {
        return Objects.hash(this.f5560a, this.f5561b);
    }
}

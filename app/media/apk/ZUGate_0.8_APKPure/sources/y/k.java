package y;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final ColorStateList f5557a;

    /* renamed from: b  reason: collision with root package name */
    public final Configuration f5558b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5559c;

    public k(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
        this.f5557a = colorStateList;
        this.f5558b = configuration;
        this.f5559c = theme == null ? 0 : theme.hashCode();
    }
}

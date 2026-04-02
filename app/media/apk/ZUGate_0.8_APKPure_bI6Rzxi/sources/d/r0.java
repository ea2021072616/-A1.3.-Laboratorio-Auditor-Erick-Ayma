package d;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.i1;
import com.github.appintro.R;
import java.lang.reflect.Constructor;
/* loaded from: classes.dex */
public class r0 {

    /* renamed from: b  reason: collision with root package name */
    public static final Class[] f2452b = {Context.class, AttributeSet.class};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f2453c = {16843375};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f2454d = {16844160};

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f2455e = {16844156};

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f2456f = {16844148};

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f2457g = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: h  reason: collision with root package name */
    public static final l.j f2458h = new l.j();

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f2459a = new Object[2];

    public androidx.appcompat.widget.r a(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.r(context, attributeSet);
    }

    public androidx.appcompat.widget.t b(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.t(context, attributeSet, R.attr.buttonStyle);
    }

    public androidx.appcompat.widget.u c(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.u(context, attributeSet, R.attr.checkboxStyle);
    }

    public androidx.appcompat.widget.l0 d(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.l0(context, attributeSet);
    }

    public i1 e(Context context, AttributeSet attributeSet) {
        return new i1(context, attributeSet);
    }

    public final View f(Context context, String str, String str2) {
        String concat;
        l.j jVar = f2458h;
        Constructor constructor = (Constructor) jVar.getOrDefault(str, null);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    concat = str2.concat(str);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                concat = str;
            }
            constructor = Class.forName(concat, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f2452b);
            jVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f2459a);
    }

    public final void g(TextView textView, String str) {
        if (textView != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }
}

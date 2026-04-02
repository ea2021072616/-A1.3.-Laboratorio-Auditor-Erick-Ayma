package s0;

import android.text.Editable;
import androidx.emoji2.text.c0;
/* loaded from: classes.dex */
public final class c extends Editable.Factory {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f4807a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f4808b;

    /* renamed from: c  reason: collision with root package name */
    public static Class f4809c;

    public c() {
        try {
            f4809c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, c.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = f4809c;
        return cls != null ? new c0(cls, charSequence) : super.newEditable(charSequence);
    }
}

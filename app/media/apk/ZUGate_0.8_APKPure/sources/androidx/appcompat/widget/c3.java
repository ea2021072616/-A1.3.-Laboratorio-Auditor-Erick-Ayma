package androidx.appcompat.widget;

import android.widget.EditText;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class c3 extends androidx.emoji2.text.k {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f301a = 1;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference f302b;

    public c3(EditText editText) {
        this.f302b = new WeakReference(editText);
    }

    @Override // androidx.emoji2.text.k
    public final void a() {
        switch (this.f301a) {
            case 0:
                SwitchCompat switchCompat = (SwitchCompat) this.f302b.get();
                if (switchCompat != null) {
                    switchCompat.d();
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // androidx.emoji2.text.k
    public final void b() {
        WeakReference weakReference = this.f302b;
        switch (this.f301a) {
            case 0:
                SwitchCompat switchCompat = (SwitchCompat) weakReference.get();
                if (switchCompat != null) {
                    switchCompat.d();
                    return;
                }
                return;
            default:
                s0.j.a((EditText) weakReference.get(), 1);
                return;
        }
    }

    public c3(SwitchCompat switchCompat) {
        this.f302b = new WeakReference(switchCompat);
    }
}

package s0;

import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.emoji2.text.m;
import androidx.emoji2.text.w;
/* loaded from: classes.dex */
public final class g implements KeyListener {

    /* renamed from: a  reason: collision with root package name */
    public final KeyListener f4816a;

    /* renamed from: b  reason: collision with root package name */
    public final p3.e f4817b;

    public g(KeyListener keyListener) {
        p3.e eVar = new p3.e(18);
        this.f4816a = keyListener;
        this.f4817b = eVar;
    }

    @Override // android.text.method.KeyListener
    public final void clearMetaKeyState(View view, Editable editable, int i5) {
        this.f4816a.clearMetaKeyState(view, editable, i5);
    }

    @Override // android.text.method.KeyListener
    public final int getInputType() {
        return this.f4816a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyDown(View view, Editable editable, int i5, KeyEvent keyEvent) {
        boolean z4;
        this.f4817b.getClass();
        Object obj = m.f768j;
        if (i5 != 67 ? i5 != 112 ? false : w.a(editable, keyEvent, true) : w.a(editable, keyEvent, false)) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            z4 = true;
        } else {
            z4 = false;
        }
        return z4 || this.f4816a.onKeyDown(view, editable, i5, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f4816a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyUp(View view, Editable editable, int i5, KeyEvent keyEvent) {
        return this.f4816a.onKeyUp(view, editable, i5, keyEvent);
    }
}

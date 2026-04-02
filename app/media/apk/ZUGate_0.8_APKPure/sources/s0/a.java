package s0;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.widget.c3;
import androidx.emoji2.text.m;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes.dex */
public final class a extends p3.e {

    /* renamed from: k  reason: collision with root package name */
    public final EditText f4804k;

    /* renamed from: l  reason: collision with root package name */
    public final j f4805l;

    public a(EditText editText) {
        super(16);
        this.f4804k = editText;
        j jVar = new j(editText);
        this.f4805l = jVar;
        editText.addTextChangedListener(jVar);
        if (c.f4808b == null) {
            synchronized (c.f4807a) {
                if (c.f4808b == null) {
                    c.f4808b = new c();
                }
            }
        }
        editText.setEditableFactory(c.f4808b);
    }

    @Override // p3.e
    public final KeyListener i(KeyListener keyListener) {
        if (keyListener instanceof g) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new g(keyListener);
    }

    @Override // p3.e
    public final InputConnection r(InputConnection inputConnection, EditorInfo editorInfo) {
        return inputConnection instanceof d ? inputConnection : new d(this.f4804k, inputConnection, editorInfo);
    }

    @Override // p3.e
    public final void w(boolean z4) {
        j jVar = this.f4805l;
        if (jVar.f4825j != z4) {
            if (jVar.f4824i != null) {
                m a5 = m.a();
                c3 c3Var = jVar.f4824i;
                a5.getClass();
                p2.a.j(c3Var, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = a5.f770a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    a5.f771b.remove(c3Var);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            jVar.f4825j = z4;
            if (z4) {
                j.a(jVar.f4822g, m.a().b());
            }
        }
    }
}

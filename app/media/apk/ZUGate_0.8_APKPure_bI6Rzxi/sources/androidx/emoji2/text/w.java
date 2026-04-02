package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.util.SparseArray;
import android.view.KeyEvent;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public final p3.e f797a;

    /* renamed from: b  reason: collision with root package name */
    public final g.f f798b;

    /* renamed from: c  reason: collision with root package name */
    public final j f799c;

    public w(g.f fVar, p3.e eVar, f fVar2, Set set) {
        this.f797a = eVar;
        this.f798b = fVar;
        this.f799c = fVar2;
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            c(str, 0, str.length(), 1, true, new u(str, 0));
        }
    }

    public static boolean a(Editable editable, KeyEvent keyEvent, boolean z4) {
        e0[] e0VarArr;
        if (!KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!(selectionStart == -1 || selectionEnd == -1 || selectionStart != selectionEnd) && (e0VarArr = (e0[]) editable.getSpans(selectionStart, selectionEnd, e0.class)) != null && e0VarArr.length > 0) {
            for (e0 e0Var : e0VarArr) {
                int spanStart = editable.getSpanStart(e0Var);
                int spanEnd = editable.getSpanEnd(e0Var);
                if ((z4 && spanStart == selectionStart) || ((!z4 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean b(CharSequence charSequence, int i5, int i6, d0 d0Var) {
        if ((d0Var.f752c & 3) == 0) {
            j jVar = this.f799c;
            r0.a c5 = d0Var.c();
            int a5 = c5.a(8);
            if (a5 != 0) {
                c5.f4467b.getShort(a5 + c5.f4466a);
            }
            f fVar = (f) jVar;
            fVar.getClass();
            ThreadLocal threadLocal = f.f758b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = (StringBuilder) threadLocal.get();
            sb.setLength(0);
            while (i5 < i6) {
                sb.append(charSequence.charAt(i5));
                i5++;
            }
            TextPaint textPaint = fVar.f759a;
            String sb2 = sb.toString();
            int i7 = z.e.f5753a;
            boolean a6 = z.d.a(textPaint, sb2);
            int i8 = d0Var.f752c & 4;
            d0Var.f752c = a6 ? i8 | 2 : i8 | 1;
        }
        return (d0Var.f752c & 3) == 2;
    }

    public final Object c(CharSequence charSequence, int i5, int i6, int i7, boolean z4, t tVar) {
        boolean z5;
        a0 a0Var = null;
        v vVar = new v((a0) this.f798b.f2879c, false, null);
        int i8 = i5;
        int codePointAt = Character.codePointAt(charSequence, i5);
        int i9 = 0;
        boolean z6 = true;
        int i10 = i8;
        while (i10 < i6 && i9 < i7 && z6) {
            SparseArray sparseArray = vVar.f791c.f743a;
            a0 a0Var2 = sparseArray == null ? a0Var : (a0) sparseArray.get(codePointAt);
            if (vVar.f789a == 2) {
                if (a0Var2 != null) {
                    vVar.f791c = a0Var2;
                    vVar.f794f++;
                } else {
                    if (codePointAt == 65038) {
                        vVar.a();
                    } else {
                        if (!(codePointAt == 65039)) {
                            a0 a0Var3 = vVar.f791c;
                            if (a0Var3.f744b != null) {
                                if (vVar.f794f != 1) {
                                    vVar.f792d = a0Var3;
                                    vVar.a();
                                } else if (vVar.b()) {
                                    vVar.f792d = vVar.f791c;
                                    vVar.a();
                                } else {
                                    vVar.a();
                                }
                                z5 = true;
                            } else {
                                vVar.a();
                            }
                        }
                    }
                    z5 = true;
                }
                z5 = true;
            } else if (a0Var2 == null) {
                vVar.a();
                z5 = true;
            } else {
                vVar.f789a = 2;
                vVar.f791c = a0Var2;
                vVar.f794f = 1;
                z5 = true;
            }
            vVar.f793e = codePointAt;
            if (!z5) {
                if (z5) {
                    i10 += Character.charCount(codePointAt);
                    if (i10 < i6) {
                        codePointAt = Character.codePointAt(charSequence, i10);
                    }
                } else if (z5) {
                    if (z4 || !b(charSequence, i8, i10, vVar.f792d.f744b)) {
                        boolean b5 = tVar.b(charSequence, i8, i10, vVar.f792d.f744b);
                        i9++;
                        i8 = i10;
                        z6 = b5;
                    } else {
                        i8 = i10;
                    }
                }
                a0Var = null;
            } else {
                i8 += Character.charCount(Character.codePointAt(charSequence, i8));
                if (i8 < i6) {
                    codePointAt = Character.codePointAt(charSequence, i8);
                }
            }
            i10 = i8;
            a0Var = null;
        }
        if ((vVar.f789a == 2 && vVar.f791c.f744b != null && (vVar.f794f > 1 || vVar.b())) && i9 < i7 && z6 && (z4 || !b(charSequence, i8, i10, vVar.f791c.f744b))) {
            tVar.b(charSequence, i8, i10, vVar.f791c.f744b);
        }
        return tVar.a();
    }
}

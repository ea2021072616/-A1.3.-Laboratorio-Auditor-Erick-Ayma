package h0;

import android.graphics.Insets;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public final class r1 extends WindowInsetsAnimation$Callback {

    /* renamed from: a  reason: collision with root package name */
    public final b3.g f3200a;

    /* renamed from: b  reason: collision with root package name */
    public List f3201b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f3202c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap f3203d;

    public r1(b3.g gVar) {
        super(0);
        this.f3203d = new HashMap();
        this.f3200a = gVar;
    }

    public final u1 a(WindowInsetsAnimation windowInsetsAnimation) {
        u1 u1Var = (u1) this.f3203d.get(windowInsetsAnimation);
        if (u1Var == null) {
            u1 u1Var2 = new u1(windowInsetsAnimation);
            this.f3203d.put(windowInsetsAnimation, u1Var2);
            return u1Var2;
        }
        return u1Var;
    }

    public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
        b3.g gVar = this.f3200a;
        a(windowInsetsAnimation);
        gVar.f1648b.setTranslationY(0.0f);
        this.f3203d.remove(windowInsetsAnimation);
    }

    public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
        b3.g gVar = this.f3200a;
        a(windowInsetsAnimation);
        View view = gVar.f1648b;
        int[] iArr = gVar.f1651e;
        view.getLocationOnScreen(iArr);
        gVar.f1649c = iArr[1];
    }

    public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
        float fraction;
        ArrayList arrayList = this.f3202c;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            this.f3202c = arrayList2;
            this.f3201b = Collections.unmodifiableList(arrayList2);
        } else {
            arrayList.clear();
        }
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                b3.g gVar = this.f3200a;
                h2 i5 = h2.i(null, windowInsets);
                gVar.a(i5, this.f3201b);
                return i5.h();
            }
            WindowInsetsAnimation j5 = c0.j(list.get(size));
            u1 a5 = a(j5);
            fraction = j5.getFraction();
            a5.f3214a.d(fraction);
            this.f3202c.add(a5);
        }
    }

    public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
        Insets lowerBound;
        Insets upperBound;
        b3.g gVar = this.f3200a;
        a(windowInsetsAnimation);
        lowerBound = bounds.getLowerBound();
        z.c c5 = z.c.c(lowerBound);
        upperBound = bounds.getUpperBound();
        z.c c6 = z.c.c(upperBound);
        View view = gVar.f1648b;
        int[] iArr = gVar.f1651e;
        view.getLocationOnScreen(iArr);
        int i5 = gVar.f1649c - iArr[1];
        gVar.f1650d = i5;
        view.setTranslationY(i5);
        c0.m();
        return c0.h(c5.d(), c6.d());
    }
}

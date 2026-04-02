package r1;

import android.view.GestureDetector;
import android.view.View;
/* loaded from: classes.dex */
public abstract class b extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {

    /* renamed from: g  reason: collision with root package name */
    public int f4483g = 0;

    /* renamed from: h  reason: collision with root package name */
    public o1.c f4484h;

    /* renamed from: i  reason: collision with root package name */
    public final GestureDetector f4485i;

    /* renamed from: j  reason: collision with root package name */
    public final k1.c f4486j;

    public b(k1.c cVar) {
        this.f4486j = cVar;
        this.f4485i = new GestureDetector(cVar.getContext(), this);
    }
}

package y0;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i1;
import androidx.recyclerview.widget.o0;
/* loaded from: classes.dex */
public final class r extends o0 {

    /* renamed from: a  reason: collision with root package name */
    public Drawable f5632a;

    /* renamed from: b  reason: collision with root package name */
    public int f5633b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5634c = true;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ s f5635d;

    public r(s sVar) {
        this.f5635d = sVar;
    }

    @Override // androidx.recyclerview.widget.o0
    public final void a(Rect rect, View view, RecyclerView recyclerView) {
        if (d(view, recyclerView)) {
            rect.bottom = this.f5633b;
        }
    }

    @Override // androidx.recyclerview.widget.o0
    public final void c(Canvas canvas, RecyclerView recyclerView) {
        if (this.f5632a == null) {
            return;
        }
        int childCount = recyclerView.getChildCount();
        int width = recyclerView.getWidth();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = recyclerView.getChildAt(i5);
            if (d(childAt, recyclerView)) {
                int height = childAt.getHeight() + ((int) childAt.getY());
                this.f5632a.setBounds(0, height, width, this.f5633b + height);
                this.f5632a.draw(canvas);
            }
        }
    }

    public final boolean d(View view, RecyclerView recyclerView) {
        i1 K = recyclerView.K(view);
        boolean z4 = false;
        if ((K instanceof d0) && ((d0) K).f5604y) {
            boolean z5 = this.f5634c;
            int indexOfChild = recyclerView.indexOfChild(view);
            if (indexOfChild < recyclerView.getChildCount() - 1) {
                i1 K2 = recyclerView.K(recyclerView.getChildAt(indexOfChild + 1));
                if ((K2 instanceof d0) && ((d0) K2).f5603x) {
                    z4 = true;
                }
                return z4;
            }
            return z5;
        }
        return false;
    }
}

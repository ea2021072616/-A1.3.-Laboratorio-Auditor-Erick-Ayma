package v4;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.o0;
/* loaded from: classes.dex */
public final class a extends o0 {

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f5217d = {16843284};

    /* renamed from: a  reason: collision with root package name */
    public final Drawable f5218a;

    /* renamed from: b  reason: collision with root package name */
    public int f5219b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f5220c = new Rect();

    public a(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f5217d);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        this.f5218a = drawable;
        if (drawable == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        obtainStyledAttributes.recycle();
        this.f5219b = 1;
    }

    @Override // androidx.recyclerview.widget.o0
    public final void a(Rect rect, View view, RecyclerView recyclerView) {
        rect.set(0, 0, 0, 0);
    }

    @Override // androidx.recyclerview.widget.o0
    public final void b(Canvas canvas, RecyclerView recyclerView) {
        Drawable drawable;
        int height;
        int i5;
        int width;
        int i6;
        if (recyclerView.getLayoutManager() == null || (drawable = this.f5218a) == null) {
            return;
        }
        int i7 = this.f5219b;
        Rect rect = this.f5220c;
        int i8 = 0;
        if (i7 == 1) {
            canvas.save();
            if (recyclerView.getClipToPadding()) {
                i6 = recyclerView.getPaddingLeft();
                width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                canvas.clipRect(i6, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
            } else {
                width = recyclerView.getWidth();
                i6 = 0;
            }
            int childCount = recyclerView.getChildCount();
            while (i8 < childCount) {
                View childAt = recyclerView.getChildAt(i8);
                RecyclerView.M(rect, childAt);
                int round = Math.round(childAt.getTranslationY()) + rect.bottom;
                drawable.setBounds(i6, round - drawable.getIntrinsicHeight(), width, round);
                drawable.draw(canvas);
                i8++;
            }
            canvas.restore();
            return;
        }
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i5 = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), i5, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            i5 = 0;
        }
        int childCount2 = recyclerView.getChildCount();
        while (i8 < childCount2) {
            View childAt2 = recyclerView.getChildAt(i8);
            recyclerView.getLayoutManager().y(rect, childAt2);
            int round2 = Math.round(childAt2.getTranslationX()) + rect.right;
            drawable.setBounds(round2 - drawable.getIntrinsicWidth(), i5, round2, height);
            drawable.draw(canvas);
            i8++;
        }
        canvas.restore();
    }
}

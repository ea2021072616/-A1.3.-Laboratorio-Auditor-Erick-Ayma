package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.github.appintro.R;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public class b2 extends ListView {

    /* renamed from: g  reason: collision with root package name */
    public final Rect f286g;

    /* renamed from: h  reason: collision with root package name */
    public int f287h;

    /* renamed from: i  reason: collision with root package name */
    public int f288i;

    /* renamed from: j  reason: collision with root package name */
    public int f289j;

    /* renamed from: k  reason: collision with root package name */
    public int f290k;

    /* renamed from: l  reason: collision with root package name */
    public int f291l;

    /* renamed from: m  reason: collision with root package name */
    public z1 f292m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f293n;
    public final boolean o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f294p;

    /* renamed from: q  reason: collision with root package name */
    public n0.g f295q;

    /* renamed from: r  reason: collision with root package name */
    public androidx.activity.j f296r;

    public b2(Context context, boolean z4) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f286g = new Rect();
        this.f287h = 0;
        this.f288i = 0;
        this.f289j = 0;
        this.f290k = 0;
        this.o = z4;
        setCacheColorHint(0);
    }

    public final int a(int i5, int i6) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        int i7 = listPaddingTop + listPaddingBottom;
        if (adapter == null) {
            return i7;
        }
        dividerHeight = (dividerHeight <= 0 || divider == null) ? 0 : 0;
        int count = adapter.getCount();
        int i8 = 0;
        View view = null;
        for (int i9 = 0; i9 < count; i9++) {
            int itemViewType = adapter.getItemViewType(i9);
            if (itemViewType != i8) {
                view = null;
                i8 = itemViewType;
            }
            view = adapter.getView(i9, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i10 = layoutParams.height;
            view.measure(i5, i10 > 0 ? View.MeasureSpec.makeMeasureSpec(i10, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i9 > 0) {
                i7 += dividerHeight;
            }
            i7 += view.getMeasuredHeight();
            if (i7 >= i6) {
                return i6;
            }
        }
        return i7;
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x0145 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0177  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(android.view.MotionEvent r17, int r18) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b2.b(android.view.MotionEvent, int):boolean");
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Drawable selector;
        Rect rect = this.f286g;
        if (!rect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(rect);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        if (this.f296r != null) {
            return;
        }
        super.drawableStateChanged();
        z1 z1Var = this.f292m;
        if (z1Var != null) {
            z1Var.f604h = true;
        }
        Drawable selector = getSelector();
        if (selector != null && this.f294p && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean hasFocus() {
        return this.o || super.hasFocus();
    }

    @Override // android.view.View
    public final boolean hasWindowFocus() {
        return this.o || super.hasWindowFocus();
    }

    @Override // android.view.View
    public final boolean isFocused() {
        return this.o || super.isFocused();
    }

    @Override // android.view.View
    public final boolean isInTouchMode() {
        return (this.o && this.f293n) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f296r = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i5 = Build.VERSION.SDK_INT;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f296r == null) {
            androidx.activity.j jVar = new androidx.activity.j(3, this);
            this.f296r = jVar;
            post(jVar);
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i5 < 30 || !x1.f587d) {
                        setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                    } else {
                        try {
                            x1.f584a.invoke(this, Integer.valueOf(pointToPosition), childAt, Boolean.FALSE, -1, -1);
                            x1.f585b.invoke(this, Integer.valueOf(pointToPosition));
                            x1.f586c.invoke(this, Integer.valueOf(pointToPosition));
                        } catch (IllegalAccessException e5) {
                            e5.printStackTrace();
                        } catch (InvocationTargetException e6) {
                            e6.printStackTrace();
                        }
                    }
                }
                Drawable selector = getSelector();
                if (selector != null && this.f294p && isPressed()) {
                    selector.setState(getDrawableState());
                }
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f291l = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        androidx.activity.j jVar = this.f296r;
        if (jVar != null) {
            b2 b2Var = (b2) jVar.f62c;
            b2Var.f296r = null;
            b2Var.removeCallbacks(jVar);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z4) {
        this.f293n = z4;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        z1 z1Var = drawable != null ? new z1(drawable) : null;
        this.f292m = z1Var;
        super.setSelector(z1Var);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f287h = rect.left;
        this.f288i = rect.top;
        this.f289j = rect.right;
        this.f290k = rect.bottom;
    }
}

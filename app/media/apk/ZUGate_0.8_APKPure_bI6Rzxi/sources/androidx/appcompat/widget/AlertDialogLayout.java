package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.github.appintro.R;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class AlertDialogLayout extends g2 {
    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static int j(View view) {
        WeakHashMap weakHashMap = h0.z0.f3233a;
        int minimumHeight = view.getMinimumHeight();
        if (minimumHeight > 0) {
            return minimumHeight;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return j(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009d  */
    @Override // androidx.appcompat.widget.g2, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        /*
            r9 = this;
            int r10 = r9.getPaddingLeft()
            int r13 = r13 - r11
            int r11 = r9.getPaddingRight()
            int r11 = r13 - r11
            int r13 = r13 - r10
            int r0 = r9.getPaddingRight()
            int r13 = r13 - r0
            int r0 = r9.getMeasuredHeight()
            int r1 = r9.getChildCount()
            int r2 = r9.getGravity()
            r3 = r2 & 112(0x70, float:1.57E-43)
            r4 = 8388615(0x800007, float:1.1754953E-38)
            r2 = r2 & r4
            r4 = 16
            if (r3 == r4) goto L39
            r4 = 80
            if (r3 == r4) goto L30
            int r12 = r9.getPaddingTop()
            goto L43
        L30:
            int r3 = r9.getPaddingTop()
            int r3 = r3 + r14
            int r3 = r3 - r12
            int r12 = r3 - r0
            goto L43
        L39:
            int r3 = r9.getPaddingTop()
            int r14 = r14 - r12
            int r14 = r14 - r0
            int r14 = r14 / 2
            int r12 = r14 + r3
        L43:
            android.graphics.drawable.Drawable r14 = r9.getDividerDrawable()
            r0 = 0
            if (r14 != 0) goto L4c
            r14 = r0
            goto L50
        L4c:
            int r14 = r14.getIntrinsicHeight()
        L50:
            if (r0 >= r1) goto Laf
            android.view.View r3 = r9.getChildAt(r0)
            if (r3 == 0) goto Lac
            int r4 = r3.getVisibility()
            r5 = 8
            if (r4 == r5) goto Lac
            int r4 = r3.getMeasuredWidth()
            int r5 = r3.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r6 = r3.getLayoutParams()
            androidx.appcompat.widget.f2 r6 = (androidx.appcompat.widget.f2) r6
            int r7 = r6.gravity
            if (r7 >= 0) goto L73
            r7 = r2
        L73:
            int r8 = r9.getLayoutDirection()
            int r7 = android.view.Gravity.getAbsoluteGravity(r7, r8)
            r7 = r7 & 7
            r8 = 1
            if (r7 == r8) goto L8c
            r8 = 5
            if (r7 == r8) goto L87
            int r7 = r6.leftMargin
            int r7 = r7 + r10
            goto L97
        L87:
            int r7 = r11 - r4
            int r8 = r6.rightMargin
            goto L96
        L8c:
            int r7 = r13 - r4
            int r7 = r7 / 2
            int r7 = r7 + r10
            int r8 = r6.leftMargin
            int r7 = r7 + r8
            int r8 = r6.rightMargin
        L96:
            int r7 = r7 - r8
        L97:
            boolean r8 = r9.i(r0)
            if (r8 == 0) goto L9e
            int r12 = r12 + r14
        L9e:
            int r8 = r6.topMargin
            int r12 = r12 + r8
            int r4 = r4 + r7
            int r8 = r5 + r12
            r3.layout(r7, r12, r4, r8)
            int r3 = r6.bottomMargin
            int r5 = r5 + r3
            int r5 = r5 + r12
            r12 = r5
        Lac:
            int r0 = r0 + 1
            goto L50
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AlertDialogLayout.onLayout(boolean, int, int, int, int):void");
    }

    @Override // androidx.appcompat.widget.g2, android.view.View
    public final void onMeasure(int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int childCount = getChildCount();
        View view = null;
        boolean z4 = false;
        View view2 = null;
        View view3 = null;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == R.id.topPanel) {
                    view = childAt;
                } else if (id != R.id.buttonPanel) {
                    if ((id != R.id.contentPanel && id != R.id.customPanel) || view3 != null) {
                        break;
                    }
                    view3 = childAt;
                } else {
                    view2 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        int mode2 = View.MeasureSpec.getMode(i5);
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (view != null) {
            view.measure(i5, 0);
            paddingBottom += view.getMeasuredHeight();
            i7 = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            i7 = 0;
        }
        if (view2 != null) {
            view2.measure(i5, 0);
            i8 = j(view2);
            i9 = view2.getMeasuredHeight() - i8;
            paddingBottom += i8;
            i7 = View.combineMeasuredStates(i7, view2.getMeasuredState());
        } else {
            i8 = 0;
            i9 = 0;
        }
        if (view3 != null) {
            view3.measure(i5, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingBottom), mode));
            i10 = view3.getMeasuredHeight();
            paddingBottom += i10;
            i7 = View.combineMeasuredStates(i7, view3.getMeasuredState());
        } else {
            i10 = 0;
        }
        int i12 = size - paddingBottom;
        if (view2 != null) {
            int i13 = paddingBottom - i8;
            int min = Math.min(i12, i9);
            if (min > 0) {
                i12 -= min;
                i8 += min;
            }
            view2.measure(i5, View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
            paddingBottom = i13 + view2.getMeasuredHeight();
            i7 = View.combineMeasuredStates(i7, view2.getMeasuredState());
        }
        if (view3 != null && i12 > 0) {
            view3.measure(i5, View.MeasureSpec.makeMeasureSpec(i10 + i12, mode));
            paddingBottom = (paddingBottom - i10) + view3.getMeasuredHeight();
            i7 = View.combineMeasuredStates(i7, view3.getMeasuredState());
        }
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt2 = getChildAt(i15);
            if (childAt2.getVisibility() != 8) {
                i14 = Math.max(i14, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(getPaddingRight() + getPaddingLeft() + i14, i5, i7), View.resolveSizeAndState(paddingBottom, i6, 0));
        if (mode2 != 1073741824) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt3 = getChildAt(i16);
                if (childAt3.getVisibility() != 8) {
                    f2 f2Var = (f2) childAt3.getLayoutParams();
                    if (((LinearLayout.LayoutParams) f2Var).width == -1) {
                        int i17 = ((LinearLayout.LayoutParams) f2Var).height;
                        ((LinearLayout.LayoutParams) f2Var).height = childAt3.getMeasuredHeight();
                        measureChildWithMargins(childAt3, makeMeasureSpec, 0, i6, 0);
                        ((LinearLayout.LayoutParams) f2Var).height = i17;
                    }
                }
            }
        }
        z4 = true;
        if (z4) {
            return;
        }
        super.onMeasure(i5, i6);
    }
}

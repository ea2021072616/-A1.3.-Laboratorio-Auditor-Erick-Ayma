package f3;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.b0;
import com.github.appintro.R;
import com.google.android.material.chip.Chip;
import h0.z0;
import i0.j;
import java.util.ArrayList;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class d extends h0.b {
    public static final Rect o = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: p  reason: collision with root package name */
    public static final p3.e f2823p = new p3.e(9);

    /* renamed from: q  reason: collision with root package name */
    public static final p3.e f2824q = new p3.e(10);

    /* renamed from: h  reason: collision with root package name */
    public final AccessibilityManager f2829h;

    /* renamed from: i  reason: collision with root package name */
    public final View f2830i;

    /* renamed from: j  reason: collision with root package name */
    public q0.a f2831j;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Chip f2835n;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f2825d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    public final Rect f2826e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    public final Rect f2827f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    public final int[] f2828g = new int[2];

    /* renamed from: k  reason: collision with root package name */
    public int f2832k = Integer.MIN_VALUE;

    /* renamed from: l  reason: collision with root package name */
    public int f2833l = Integer.MIN_VALUE;

    /* renamed from: m  reason: collision with root package name */
    public int f2834m = Integer.MIN_VALUE;

    public d(Chip chip, Chip chip2) {
        this.f2835n = chip;
        if (chip2 == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f2830i = chip2;
        this.f2829h = (AccessibilityManager) chip2.getContext().getSystemService("accessibility");
        chip2.setFocusable(true);
        WeakHashMap weakHashMap = z0.f3233a;
        if (chip2.getImportantForAccessibility() == 0) {
            chip2.setImportantForAccessibility(1);
        }
    }

    @Override // h0.b
    public final b0 b(View view) {
        if (this.f2831j == null) {
            this.f2831j = new q0.a(this);
        }
        return this.f2831j;
    }

    @Override // h0.b
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
    }

    @Override // h0.b
    public final void d(View view, j jVar) {
        View.AccessibilityDelegate accessibilityDelegate = this.f3105a;
        AccessibilityNodeInfo accessibilityNodeInfo = jVar.f3375a;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        Chip chip = this.f2835n;
        f fVar = chip.f2079k;
        accessibilityNodeInfo.setCheckable(fVar != null && fVar.W);
        accessibilityNodeInfo.setClickable(chip.isClickable());
        jVar.h(chip.getAccessibilityClassName());
        accessibilityNodeInfo.setText(chip.getText());
    }

    public final boolean j(int i5) {
        if (this.f2833l != i5) {
            return false;
        }
        this.f2833l = Integer.MIN_VALUE;
        if (i5 == 1) {
            Chip chip = this.f2835n;
            chip.f2086s = false;
            chip.refreshDrawableState();
        }
        q(i5, 8);
        return true;
    }

    public final j k(int i5) {
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
        j jVar = new j(obtain);
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        jVar.h("android.view.View");
        Rect rect = o;
        obtain.setBoundsInParent(rect);
        obtain.setBoundsInScreen(rect);
        jVar.f3376b = -1;
        View view = this.f2830i;
        obtain.setParent(view);
        o(i5, jVar);
        if (jVar.g() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.f2826e;
        jVar.f(rect2);
        if (rect2.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = obtain.getActions();
        if ((actions & 64) == 0) {
            if ((actions & 128) == 0) {
                obtain.setPackageName(view.getContext().getPackageName());
                jVar.f3377c = i5;
                obtain.setSource(view, i5);
                boolean z4 = false;
                if (this.f2832k == i5) {
                    obtain.setAccessibilityFocused(true);
                    jVar.a(128);
                } else {
                    obtain.setAccessibilityFocused(false);
                    jVar.a(64);
                }
                boolean z5 = this.f2833l == i5;
                if (z5) {
                    jVar.a(2);
                } else if (obtain.isFocusable()) {
                    jVar.a(1);
                }
                obtain.setFocused(z5);
                int[] iArr = this.f2828g;
                view.getLocationOnScreen(iArr);
                Rect rect3 = this.f2825d;
                obtain.getBoundsInScreen(rect3);
                if (rect3.equals(rect)) {
                    jVar.f(rect3);
                    if (jVar.f3376b != -1) {
                        j jVar2 = new j(AccessibilityNodeInfo.obtain());
                        for (int i6 = jVar.f3376b; i6 != -1; i6 = jVar2.f3376b) {
                            jVar2.f3376b = -1;
                            AccessibilityNodeInfo accessibilityNodeInfo = jVar2.f3375a;
                            accessibilityNodeInfo.setParent(view, -1);
                            accessibilityNodeInfo.setBoundsInParent(rect);
                            o(i6, jVar2);
                            jVar2.f(rect2);
                            rect3.offset(rect2.left, rect2.top);
                        }
                    }
                    rect3.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
                }
                Rect rect4 = this.f2827f;
                if (view.getLocalVisibleRect(rect4)) {
                    rect4.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
                    if (rect3.intersect(rect4)) {
                        jVar.f3375a.setBoundsInScreen(rect3);
                        if (!rect3.isEmpty() && view.getWindowVisibility() == 0) {
                            ViewParent parent = view.getParent();
                            while (true) {
                                if (parent instanceof View) {
                                    View view2 = (View) parent;
                                    if (view2.getAlpha() <= 0.0f || view2.getVisibility() != 0) {
                                        break;
                                    }
                                    parent = view2.getParent();
                                } else if (parent != null) {
                                    z4 = true;
                                }
                            }
                        }
                        if (z4) {
                            obtain.setVisibleToUser(true);
                        }
                    }
                }
                return jVar;
            }
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }

    public final void l(ArrayList arrayList) {
        boolean z4 = false;
        arrayList.add(0);
        Rect rect = Chip.C;
        Chip chip = this.f2835n;
        if (chip.c()) {
            f fVar = chip.f2079k;
            if (fVar != null && fVar.Q) {
                z4 = true;
            }
            if (!z4 || chip.f2082n == null) {
                return;
            }
            arrayList.add(1);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0145, code lost:
        if (r14 < ((r15 * r15) + ((r13 * 13) * r13))) goto L44;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0151 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m(int r19, android.graphics.Rect r20) {
        /*
            Method dump skipped, instructions count: 485
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.d.m(int, android.graphics.Rect):boolean");
    }

    public final j n(int i5) {
        if (i5 == -1) {
            View view = this.f2830i;
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(view);
            j jVar = new j(obtain);
            WeakHashMap weakHashMap = z0.f3233a;
            view.onInitializeAccessibilityNodeInfo(obtain);
            ArrayList arrayList = new ArrayList();
            l(arrayList);
            if (obtain.getChildCount() <= 0 || arrayList.size() <= 0) {
                int size = arrayList.size();
                for (int i6 = 0; i6 < size; i6++) {
                    jVar.f3375a.addChild(view, ((Integer) arrayList.get(i6)).intValue());
                }
                return jVar;
            }
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        return k(i5);
    }

    public final void o(int i5, j jVar) {
        Rect closeIconTouchBoundsInt;
        AccessibilityNodeInfo accessibilityNodeInfo = jVar.f3375a;
        if (i5 != 1) {
            accessibilityNodeInfo.setContentDescription("");
            accessibilityNodeInfo.setBoundsInParent(Chip.C);
            return;
        }
        Chip chip = this.f2835n;
        CharSequence closeIconContentDescription = chip.getCloseIconContentDescription();
        if (closeIconContentDescription != null) {
            accessibilityNodeInfo.setContentDescription(closeIconContentDescription);
        } else {
            CharSequence text = chip.getText();
            Context context = chip.getContext();
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(text) ? "" : text;
            accessibilityNodeInfo.setContentDescription(context.getString(R.string.mtrl_chip_close_icon_content_description, objArr).trim());
        }
        closeIconTouchBoundsInt = chip.getCloseIconTouchBoundsInt();
        accessibilityNodeInfo.setBoundsInParent(closeIconTouchBoundsInt);
        jVar.b(i0.e.f3362e);
        accessibilityNodeInfo.setEnabled(chip.isEnabled());
    }

    public final boolean p(int i5) {
        int i6;
        View view = this.f2830i;
        if ((view.isFocused() || view.requestFocus()) && (i6 = this.f2833l) != i5) {
            if (i6 != Integer.MIN_VALUE) {
                j(i6);
            }
            if (i5 != Integer.MIN_VALUE) {
                this.f2833l = i5;
                if (i5 == 1) {
                    Chip chip = this.f2835n;
                    chip.f2086s = true;
                    chip.refreshDrawableState();
                }
                q(i5, 8);
                return true;
            }
        }
        return false;
    }

    public final void q(int i5, int i6) {
        View view;
        ViewParent parent;
        AccessibilityEvent obtain;
        if (i5 == Integer.MIN_VALUE || !this.f2829h.isEnabled() || (parent = (view = this.f2830i).getParent()) == null) {
            return;
        }
        if (i5 != -1) {
            obtain = AccessibilityEvent.obtain(i6);
            j n5 = n(i5);
            obtain.getText().add(n5.g());
            AccessibilityNodeInfo accessibilityNodeInfo = n5.f3375a;
            obtain.setContentDescription(accessibilityNodeInfo.getContentDescription());
            obtain.setScrollable(accessibilityNodeInfo.isScrollable());
            obtain.setPassword(accessibilityNodeInfo.isPassword());
            obtain.setEnabled(accessibilityNodeInfo.isEnabled());
            obtain.setChecked(accessibilityNodeInfo.isChecked());
            if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
            obtain.setClassName(accessibilityNodeInfo.getClassName());
            obtain.setSource(view, i5);
            obtain.setPackageName(view.getContext().getPackageName());
        } else {
            obtain = AccessibilityEvent.obtain(i6);
            view.onInitializeAccessibilityEvent(obtain);
        }
        parent.requestSendAccessibilityEvent(view, obtain);
    }
}

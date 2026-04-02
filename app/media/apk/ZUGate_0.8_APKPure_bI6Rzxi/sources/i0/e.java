package i0;

import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: e  reason: collision with root package name */
    public static final e f3362e;

    /* renamed from: f  reason: collision with root package name */
    public static final e f3363f;

    /* renamed from: g  reason: collision with root package name */
    public static final e f3364g;

    /* renamed from: h  reason: collision with root package name */
    public static final e f3365h;

    /* renamed from: i  reason: collision with root package name */
    public static final e f3366i;

    /* renamed from: j  reason: collision with root package name */
    public static final e f3367j;

    /* renamed from: k  reason: collision with root package name */
    public static final e f3368k;

    /* renamed from: l  reason: collision with root package name */
    public static final e f3369l;

    /* renamed from: a  reason: collision with root package name */
    public final Object f3370a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3371b;

    /* renamed from: c  reason: collision with root package name */
    public final Class f3372c;

    /* renamed from: d  reason: collision with root package name */
    public final t f3373d;

    static {
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction8;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction9;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction10;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction11;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction12;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction13;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction14;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction15;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction16;
        new e(1);
        new e(2);
        new e(4);
        new e(8);
        f3362e = new e(16);
        new e(32);
        new e(64);
        new e(128);
        new e(256, m.class);
        new e(512, m.class);
        new e(1024, n.class);
        new e(2048, n.class);
        f3363f = new e(4096);
        f3364g = new e(8192);
        new e(16384);
        new e(32768);
        new e(65536);
        new e(131072, r.class);
        f3365h = new e(262144);
        f3366i = new e(524288);
        f3367j = new e(1048576);
        new e(2097152, s.class);
        int i5 = Build.VERSION.SDK_INT;
        new e(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, 16908342, null, null, null);
        new e(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, 16908343, null, null, p.class);
        f3368k = new e(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, 16908344, null, null, null);
        new e(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, 16908345, null, null, null);
        f3369l = new e(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, 16908346, null, null, null);
        new e(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, 16908347, null, null, null);
        new e(i5 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, 16908358, null, null, null);
        if (i5 >= 29) {
            accessibilityAction16 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
            accessibilityAction = accessibilityAction16;
        } else {
            accessibilityAction = null;
        }
        new e(accessibilityAction, 16908359, null, null, null);
        new e(i5 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, 16908360, null, null, null);
        if (i5 >= 29) {
            accessibilityAction15 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
            accessibilityAction2 = accessibilityAction15;
        } else {
            accessibilityAction2 = null;
        }
        new e(accessibilityAction2, 16908361, null, null, null);
        new e(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, 16908348, null, null, null);
        new e(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, 16908349, null, null, q.class);
        new e(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, 16908354, null, null, o.class);
        if (i5 >= 28) {
            accessibilityAction14 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
            accessibilityAction3 = accessibilityAction14;
        } else {
            accessibilityAction3 = null;
        }
        new e(accessibilityAction3, 16908356, null, null, null);
        if (i5 >= 28) {
            accessibilityAction13 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
            accessibilityAction4 = accessibilityAction13;
        } else {
            accessibilityAction4 = null;
        }
        new e(accessibilityAction4, 16908357, null, null, null);
        new e(i5 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, 16908362, null, null, null);
        if (i5 >= 30) {
            accessibilityAction12 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
            accessibilityAction5 = accessibilityAction12;
        } else {
            accessibilityAction5 = null;
        }
        new e(accessibilityAction5, 16908372, null, null, null);
        new e(i5 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, 16908373, null, null, null);
        if (i5 >= 32) {
            accessibilityAction11 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP;
            accessibilityAction6 = accessibilityAction11;
        } else {
            accessibilityAction6 = null;
        }
        new e(accessibilityAction6, 16908374, null, null, null);
        if (i5 >= 32) {
            accessibilityAction10 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL;
            accessibilityAction7 = accessibilityAction10;
        } else {
            accessibilityAction7 = null;
        }
        new e(accessibilityAction7, 16908375, null, null, null);
        if (i5 >= 33) {
            accessibilityAction9 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
            accessibilityAction8 = accessibilityAction9;
        } else {
            accessibilityAction8 = null;
        }
        new e(accessibilityAction8, 16908376, null, null, null);
        new e(i5 >= 34 ? h.a() : null, 16908382, null, null, null);
    }

    public e(int i5) {
        this(null, i5, null, null, null);
    }

    public final int a() {
        return ((AccessibilityNodeInfo.AccessibilityAction) this.f3370a).getId();
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof e)) {
            Object obj2 = ((e) obj).f3370a;
            Object obj3 = this.f3370a;
            return obj3 == null ? obj2 == null : obj3.equals(obj2);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f3370a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AccessibilityActionCompat: ");
        String d5 = j.d(this.f3371b);
        if (d5.equals("ACTION_UNKNOWN")) {
            Object obj = this.f3370a;
            if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                d5 = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
            }
        }
        sb.append(d5);
        return sb.toString();
    }

    public e(int i5, Class cls) {
        this(null, i5, null, null, cls);
    }

    public e(Object obj, int i5, String str, t tVar, Class cls) {
        this.f3371b = i5;
        this.f3373d = tVar;
        if (obj == null) {
            this.f3370a = new AccessibilityNodeInfo.AccessibilityAction(i5, str);
        } else {
            this.f3370a = obj;
        }
        this.f3372c = cls;
    }
}

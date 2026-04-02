package h0;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.github.appintro.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public abstract class z0 {

    /* renamed from: a  reason: collision with root package name */
    public static WeakHashMap f3233a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Field f3234b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f3235c = false;

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f3236d = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};

    /* renamed from: e  reason: collision with root package name */
    public static final i0 f3237e = new i0();

    /* renamed from: f  reason: collision with root package name */
    public static final k0 f3238f = new k0();

    public static k1 a(View view) {
        if (f3233a == null) {
            f3233a = new WeakHashMap();
        }
        k1 k1Var = (k1) f3233a.get(view);
        if (k1Var == null) {
            k1 k1Var2 = new k1(view);
            f3233a.put(view, k1Var2);
            return k1Var2;
        }
        return k1Var;
    }

    public static h2 b(View view, h2 h2Var) {
        WindowInsets h5 = h2Var.h();
        if (h5 != null) {
            WindowInsets a5 = m0.a(view, h5);
            if (!a5.equals(h5)) {
                return h2.i(view, a5);
            }
        }
        return h2Var;
    }

    public static boolean c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList = y0.f3229d;
        y0 y0Var = (y0) view.getTag(R.id.tag_unhandled_key_event_manager);
        if (y0Var == null) {
            y0Var = new y0();
            view.setTag(R.id.tag_unhandled_key_event_manager, y0Var);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap weakHashMap = y0Var.f3230a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList2 = y0.f3229d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    if (y0Var.f3230a == null) {
                        y0Var.f3230a = new WeakHashMap();
                    }
                    int size = arrayList2.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        ArrayList arrayList3 = y0.f3229d;
                        View view2 = (View) ((WeakReference) arrayList3.get(size)).get();
                        if (view2 == null) {
                            arrayList3.remove(size);
                        } else {
                            y0Var.f3230a.put(view2, Boolean.TRUE);
                            for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                y0Var.f3230a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }
        View a5 = y0Var.a(view);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (a5 != null && !KeyEvent.isModifierKey(keyCode)) {
                if (y0Var.f3231b == null) {
                    y0Var.f3231b = new SparseArray();
                }
                y0Var.f3231b.put(keyCode, new WeakReference(a5));
            }
        }
        return a5 != null;
    }

    public static View.AccessibilityDelegate d(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return t0.a(view);
        }
        if (f3235c) {
            return null;
        }
        if (f3234b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f3234b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f3235c = true;
                return null;
            }
        }
        try {
            Object obj = f3234b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f3235c = true;
            return null;
        }
    }

    public static CharSequence e(View view) {
        return (CharSequence) new j0(R.id.tag_accessibility_pane_title, 8, 28, 1).b(view);
    }

    public static ArrayList f(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            view.setTag(R.id.tag_accessibility_actions, arrayList2);
            return arrayList2;
        }
        return arrayList;
    }

    public static String[] g(View view) {
        return Build.VERSION.SDK_INT >= 31 ? v0.a(view) : (String[]) view.getTag(R.id.tag_on_receive_content_mime_types);
    }

    public static void h(View view, int i5) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z4 = e(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z4) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z4 ? 32 : 2048);
                obtain.setContentChangeTypes(i5);
                if (z4) {
                    obtain.getText().add(e(view));
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i5 != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i5);
                    } catch (AbstractMethodError e5) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e5);
                    }
                }
            } else {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                obtain2.setContentChangeTypes(i5);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(e(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            }
        }
    }

    public static h2 i(View view, h2 h2Var) {
        WindowInsets h5 = h2Var.h();
        if (h5 != null) {
            WindowInsets b5 = m0.b(view, h5);
            if (!b5.equals(h5)) {
                return h2.i(view, b5);
            }
        }
        return h2Var;
    }

    public static g j(View view, g gVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + gVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return v0.b(view, gVar);
        }
        y yVar = (y) view.getTag(R.id.tag_on_receive_content_listener);
        z zVar = f3237e;
        if (yVar == null) {
            if (view instanceof z) {
                zVar = (z) view;
            }
            return zVar.a(gVar);
        }
        g a5 = ((n0.r) yVar).a(view, gVar);
        if (a5 == null) {
            return null;
        }
        if (view instanceof z) {
            zVar = (z) view;
        }
        return zVar.a(a5);
    }

    public static void k(View view, int i5) {
        ArrayList f5 = f(view);
        for (int i6 = 0; i6 < f5.size(); i6++) {
            if (((i0.e) f5.get(i6)).a() == i5) {
                f5.remove(i6);
                return;
            }
        }
    }

    public static void l(View view, i0.e eVar, i0.t tVar) {
        i0.e eVar2 = new i0.e(null, eVar.f3371b, null, tVar, eVar.f3372c);
        View.AccessibilityDelegate d5 = d(view);
        b bVar = d5 == null ? null : d5 instanceof a ? ((a) d5).f3090a : new b(d5);
        if (bVar == null) {
            bVar = new b();
        }
        n(view, bVar);
        k(view, eVar2.a());
        f(view).add(eVar2);
        h(view, 0);
    }

    public static void m(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i5) {
        if (Build.VERSION.SDK_INT >= 29) {
            t0.d(view, context, iArr, attributeSet, typedArray, i5, 0);
        }
    }

    public static void n(View view, b bVar) {
        if (bVar == null && (d(view) instanceof a)) {
            bVar = new b();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        view.setAccessibilityDelegate(bVar == null ? null : bVar.f3106b);
    }

    public static void o(View view, CharSequence charSequence) {
        boolean z4 = true;
        new j0(R.id.tag_accessibility_pane_title, 8, 28, 1).c(view, charSequence);
        k0 k0Var = f3238f;
        if (charSequence == null) {
            k0Var.f3164g.remove(view);
            view.removeOnAttachStateChangeListener(k0Var);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(k0Var);
            return;
        }
        k0Var.f3164g.put(view, Boolean.valueOf((view.isShown() && view.getWindowVisibility() == 0) ? false : false));
        view.addOnAttachStateChangeListener(k0Var);
        if (view.isAttachedToWindow()) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(k0Var);
        }
    }
}

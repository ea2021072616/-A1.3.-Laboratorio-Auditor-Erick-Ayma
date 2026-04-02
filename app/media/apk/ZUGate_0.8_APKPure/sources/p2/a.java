package p2;

import android.animation.TimeInterpolator;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.ImageView;
import androidx.activity.a0;
import androidx.appcompat.widget.v2;
import androidx.appcompat.widget.z2;
import androidx.lifecycle.LegacySavedStateHandleController$tryToAddRecreator$1;
import androidx.lifecycle.SavedStateHandleController;
import androidx.lifecycle.n;
import androidx.lifecycle.o;
import androidx.lifecycle.r0;
import androidx.lifecycle.v;
import com.github.appintro.R;
import com.google.android.gms.internal.play_billing.i0;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import d.e;
import g.d;
import h0.o0;
import h0.y0;
import h0.z0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import l2.c;
import p3.f;
import p3.g;
import p3.i;
import w.l;
import w.m;
import y.j;
import y.k;
import y.q;
/* loaded from: classes.dex */
public abstract class a implements w3.a {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4246a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Boolean f4247b = null;

    /* renamed from: d  reason: collision with root package name */
    public static e f4249d = null;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f4250e = false;

    /* renamed from: f  reason: collision with root package name */
    public static Method f4251f = null;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f4252g = false;

    /* renamed from: h  reason: collision with root package name */
    public static Field f4253h;

    /* renamed from: c  reason: collision with root package name */
    public static final e f4248c = new e(null, null, null, 13);

    /* renamed from: i  reason: collision with root package name */
    public static final Object[] f4254i = new Object[0];

    /* renamed from: j  reason: collision with root package name */
    public static final String[] f4255j = {"standard", "accelerate", "decelerate", "linear"};

    /* renamed from: k  reason: collision with root package name */
    public static final int[] f4256k = {16842752, R.attr.theme};

    /* renamed from: l  reason: collision with root package name */
    public static final int[] f4257l = {R.attr.materialThemeOverlay};

    /* renamed from: m  reason: collision with root package name */
    public static final x3.a f4258m = new x3.a(2);

    /* renamed from: n  reason: collision with root package name */
    public static final byte[] f4259n = {48, 49, 53, 0};
    public static final byte[] o = {48, 49, 48, 0};

    /* renamed from: p  reason: collision with root package name */
    public static final byte[] f4260p = {48, 48, 57, 0};

    /* renamed from: q  reason: collision with root package name */
    public static final byte[] f4261q = {48, 48, 53, 0};

    /* renamed from: r  reason: collision with root package name */
    public static final byte[] f4262r = {48, 48, 49, 0};

    /* renamed from: s  reason: collision with root package name */
    public static final byte[] f4263s = {48, 48, 49, 0};

    /* renamed from: t  reason: collision with root package name */
    public static final byte[] f4264t = {48, 48, 50, 0};

    public static boolean A(int i5, Rect rect, Rect rect2) {
        if (i5 == 17) {
            int i6 = rect.right;
            int i7 = rect2.right;
            return (i6 > i7 || rect.left >= i7) && rect.left > rect2.left;
        } else if (i5 == 33) {
            int i8 = rect.bottom;
            int i9 = rect2.bottom;
            return (i8 > i9 || rect.top >= i9) && rect.top > rect2.top;
        } else if (i5 == 66) {
            int i10 = rect.left;
            int i11 = rect2.left;
            return (i10 < i11 || rect.right <= i11) && rect.right < rect2.right;
        } else if (i5 == 130) {
            int i12 = rect.top;
            int i13 = rect2.top;
            return (i12 < i13 || rect.bottom <= i13) && rect.bottom < rect2.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    public static boolean B(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static boolean C(View view) {
        WeakHashMap weakHashMap = z0.f3233a;
        return view.getLayoutDirection() == 1;
    }

    public static boolean D(String str, String str2) {
        return str.startsWith(str2.concat("(")) && str.endsWith(")");
    }

    public static boolean E(int i5, Context context, String str) {
        if (str == null) {
            return false;
        }
        for (String str2 : context.getResources().getStringArray(i5)) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean F(int i5, Context context, String str) {
        if (str == null) {
            return false;
        }
        for (String str2 : context.getResources().getStringArray(i5)) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static int G(int i5, Rect rect, Rect rect2) {
        int i6;
        int i7;
        if (i5 == 17) {
            i6 = rect.left;
            i7 = rect2.right;
        } else if (i5 == 33) {
            i6 = rect.top;
            i7 = rect2.bottom;
        } else if (i5 == 66) {
            i6 = rect2.left;
            i7 = rect.right;
        } else if (i5 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        } else {
            i6 = rect2.top;
            i7 = rect.bottom;
        }
        return Math.max(0, i6 - i7);
    }

    public static final int H(int i5) {
        if (i5 < 0) {
            return i5;
        }
        if (i5 < 3) {
            return i5 + 1;
        }
        if (i5 < 1073741824) {
            return (int) ((i5 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static int I(int i5, Rect rect, Rect rect2) {
        if (i5 != 17) {
            if (i5 != 33) {
                if (i5 != 66) {
                    if (i5 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }

    public static void L(View view, EditorInfo editorInfo, InputConnection inputConnection) {
        if (inputConnection == null || editorInfo.hintText != null) {
            return;
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
        }
    }

    public static PorterDuff.Mode O(int i5, PorterDuff.Mode mode) {
        if (i5 != 3) {
            if (i5 != 5) {
                if (i5 != 9) {
                    switch (i5) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    public static void P(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(copyOf, colorStateList.getDefaultColor());
        Drawable mutate = drawable.mutate();
        a0.a.h(mutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(mutate);
    }

    public static int Q(Context context, int i5, int i6) {
        TypedValue N = e4.e.N(context, i5);
        return (N == null || N.type != 16) ? i6 : N.data;
    }

    public static TimeInterpolator R(Context context, int i5, Interpolator interpolator) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i5, typedValue, true)) {
            if (typedValue.type == 3) {
                String valueOf = String.valueOf(typedValue.string);
                if (D(valueOf, "cubic-bezier") || D(valueOf, "path")) {
                    if (!D(valueOf, "cubic-bezier")) {
                        if (D(valueOf, "path")) {
                            return j0.a.c(q(valueOf.substring(5, valueOf.length() - 1)));
                        }
                        throw new IllegalArgumentException("Invalid motion easing type: ".concat(valueOf));
                    }
                    String[] split = valueOf.substring(13, valueOf.length() - 1).split(",");
                    if (split.length == 4) {
                        return j0.a.b(z(split, 0), z(split, 1), z(split, 2), z(split, 3));
                    }
                    throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + split.length);
                }
                return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
            }
            throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
        }
        return interpolator;
    }

    public static final void S(View view, a0 a0Var) {
        e4.e.f(view, "<this>");
        e4.e.f(a0Var, "onBackPressedDispatcherOwner");
        view.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, a0Var);
    }

    public static void T(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        WeakHashMap weakHashMap = z0.f3233a;
        boolean hasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z4 = false;
        boolean z5 = onLongClickListener != null;
        if (hasOnClickListeners || z5) {
            z4 = true;
        }
        checkableImageButton.setFocusable(z4);
        checkableImageButton.setClickable(hasOnClickListeners);
        checkableImageButton.setPressable(hasOnClickListeners);
        checkableImageButton.setLongClickable(z5);
        checkableImageButton.setImportantForAccessibility(z4 ? 1 : 2);
    }

    public static void U(View view, g gVar) {
        i3.a aVar = gVar.f4294g.f4275b;
        if (aVar != null && aVar.f3413a) {
            float f5 = 0.0f;
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                WeakHashMap weakHashMap = z0.f3233a;
                f5 += o0.i((View) parent);
            }
            f fVar = gVar.f4294g;
            if (fVar.f4286m != f5) {
                fVar.f4286m = f5;
                gVar.m();
            }
        }
    }

    public static void V(Drawable drawable, int i5) {
        a0.a.g(drawable, i5);
    }

    public static void W(Drawable drawable, ColorStateList colorStateList) {
        a0.a.h(drawable, colorStateList);
    }

    public static void X(Drawable drawable, PorterDuff.Mode mode) {
        a0.a.i(drawable, mode);
    }

    public static final Object[] Y(Collection collection) {
        e4.e.f(collection, "collection");
        int size = collection.size();
        Object[] objArr = f4254i;
        if (size == 0) {
            return objArr;
        }
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            return objArr;
        }
        Object[] objArr2 = new Object[size];
        int i5 = 0;
        while (true) {
            int i6 = i5 + 1;
            objArr2[i5] = it.next();
            if (i6 >= objArr2.length) {
                if (!it.hasNext()) {
                    return objArr2;
                }
                int i7 = ((i6 * 3) + 1) >>> 1;
                if (i7 <= i6) {
                    i7 = 2147483645;
                    if (i6 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                }
                objArr2 = Arrays.copyOf(objArr2, i7);
                e4.e.e(objArr2, "copyOf(result, newSize)");
            } else if (!it.hasNext()) {
                Object[] copyOf = Arrays.copyOf(objArr2, i6);
                e4.e.e(copyOf, "copyOf(result, size)");
                return copyOf;
            }
            i5 = i6;
        }
    }

    public static final Object[] Z(Collection collection, Object[] objArr) {
        Object[] objArr2;
        e4.e.f(collection, "collection");
        objArr.getClass();
        int size = collection.size();
        int i5 = 0;
        if (size == 0) {
            if (objArr.length > 0) {
                objArr[0] = null;
                return objArr;
            }
            return objArr;
        }
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            if (objArr.length > 0) {
                objArr[0] = null;
                return objArr;
            }
            return objArr;
        }
        if (size <= objArr.length) {
            objArr2 = objArr;
        } else {
            Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
            e4.e.d(newInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr2 = (Object[]) newInstance;
        }
        while (true) {
            int i6 = i5 + 1;
            objArr2[i5] = it.next();
            if (i6 >= objArr2.length) {
                if (!it.hasNext()) {
                    return objArr2;
                }
                int i7 = ((i6 * 3) + 1) >>> 1;
                if (i7 <= i6) {
                    i7 = 2147483645;
                    if (i6 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                }
                objArr2 = Arrays.copyOf(objArr2, i7);
                e4.e.e(objArr2, "copyOf(result, newSize)");
            } else if (!it.hasNext()) {
                if (objArr2 == objArr) {
                    objArr[i6] = null;
                    return objArr;
                }
                Object[] copyOf = Arrays.copyOf(objArr2, i6);
                e4.e.e(copyOf, "copyOf(result, size)");
                return copyOf;
            }
            i5 = i6;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:171:0x0271, code lost:
        if (r2.f4152d == r8) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00f1, code lost:
        if (r4.f4152d == r13) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0427 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x048c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x056a  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0577 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:336:0x058a  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x065f  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0692  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x06ac A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:397:0x06b8  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x06ba  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x06c5  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x06c8  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x06ce  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x06d1  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x06d7  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x06e6  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x06e9  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x06ed A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:427:0x0709 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:431:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(p.f r36, n.d r37, java.util.ArrayList r38, int r39) {
        /*
            Method dump skipped, instructions count: 1815
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.a.a(p.f, n.d, java.util.ArrayList, int):void");
    }

    public static final Map a0(LinkedHashMap linkedHashMap) {
        Map.Entry entry = (Map.Entry) linkedHashMap.entrySet().iterator().next();
        Map singletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        e4.e.e(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }

    public static void b(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = drawable.mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                a0.a.h(drawable, colorStateList);
            } else {
                int[] drawableState = textInputLayout.getDrawableState();
                int[] drawableState2 = checkableImageButton.getDrawableState();
                int length = drawableState.length;
                int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
                System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
                a0.a.h(drawable, ColorStateList.valueOf(colorStateList.getColorForState(copyOf, colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                a0.a.i(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public static Context b0(Context context, AttributeSet attributeSet, int i5, int i6) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4257l, i5, i6);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        boolean z4 = (context instanceof d) && ((d) context).f2866a == resourceId;
        if (resourceId == 0 || z4) {
            return context;
        }
        d dVar = new d(context, resourceId);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f4256k);
        int resourceId2 = obtainStyledAttributes2.getResourceId(0, 0);
        int resourceId3 = obtainStyledAttributes2.getResourceId(1, 0);
        obtainStyledAttributes2.recycle();
        if (resourceId2 == 0) {
            resourceId2 = resourceId3;
        }
        if (resourceId2 != 0) {
            dVar.getTheme().applyStyle(resourceId2, true);
        }
        return dVar;
    }

    public static final void c(r0 r0Var, b1.d dVar, o oVar) {
        Object obj;
        e4.e.f(dVar, "registry");
        e4.e.f(oVar, "lifecycle");
        HashMap hashMap = r0Var.f1143a;
        if (hashMap == null) {
            obj = null;
        } else {
            synchronized (hashMap) {
                obj = r0Var.f1143a.get("androidx.lifecycle.savedstate.vm.tag");
            }
        }
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) obj;
        if (savedStateHandleController == null || savedStateHandleController.f1095c) {
            return;
        }
        savedStateHandleController.c(oVar, dVar);
        n nVar = ((v) oVar).f1151c;
        if (nVar != n.INITIALIZED) {
            if (!(nVar.compareTo(n.STARTED) >= 0)) {
                oVar.a(new LegacySavedStateHandleController$tryToAddRecreator$1(oVar, dVar));
                return;
            }
        }
        dVar.d();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
        if (r10.bottom <= r12.top) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
        if (r10.right <= r12.left) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
        if (r10.top >= r12.bottom) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
        if (r10.left >= r12.right) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
        r7 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean d(int r9, android.graphics.Rect r10, android.graphics.Rect r11, android.graphics.Rect r12) {
        /*
            boolean r0 = e(r9, r10, r11)
            boolean r1 = e(r9, r10, r12)
            r2 = 0
            if (r1 != 0) goto L7d
            if (r0 != 0) goto Lf
            goto L7d
        Lf:
            java.lang.String r0 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1 = 130(0x82, float:1.82E-43)
            r3 = 33
            r4 = 66
            r5 = 17
            r6 = 1
            if (r9 == r5) goto L3d
            if (r9 == r3) goto L36
            if (r9 == r4) goto L2f
            if (r9 != r1) goto L29
            int r7 = r10.bottom
            int r8 = r12.top
            if (r7 > r8) goto L45
            goto L43
        L29:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r0)
            throw r9
        L2f:
            int r7 = r10.right
            int r8 = r12.left
            if (r7 > r8) goto L45
            goto L43
        L36:
            int r7 = r10.top
            int r8 = r12.bottom
            if (r7 < r8) goto L45
            goto L43
        L3d:
            int r7 = r10.left
            int r8 = r12.right
            if (r7 < r8) goto L45
        L43:
            r7 = r6
            goto L46
        L45:
            r7 = r2
        L46:
            if (r7 != 0) goto L49
            return r6
        L49:
            if (r9 == r5) goto L7c
            if (r9 != r4) goto L4e
            goto L7c
        L4e:
            int r11 = G(r9, r10, r11)
            if (r9 == r5) goto L6f
            if (r9 == r3) goto L6a
            if (r9 == r4) goto L65
            if (r9 != r1) goto L5f
            int r9 = r12.bottom
            int r10 = r10.bottom
            goto L73
        L5f:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r0)
            throw r9
        L65:
            int r9 = r12.right
            int r10 = r10.right
            goto L73
        L6a:
            int r9 = r10.top
            int r10 = r12.top
            goto L73
        L6f:
            int r9 = r10.left
            int r10 = r12.left
        L73:
            int r9 = r9 - r10
            int r9 = java.lang.Math.max(r6, r9)
            if (r11 >= r9) goto L7b
            r2 = r6
        L7b:
            return r2
        L7c:
            return r6
        L7d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.a.d(int, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):boolean");
    }

    public static boolean e(int i5, Rect rect, Rect rect2) {
        if (i5 != 17) {
            if (i5 != 33) {
                if (i5 != 66) {
                    if (i5 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static boolean g(z.f[] fVarArr, z.f[] fVarArr2) {
        if (fVarArr == null || fVarArr2 == null || fVarArr.length != fVarArr2.length) {
            return false;
        }
        for (int i5 = 0; i5 < fVarArr.length; i5++) {
            z.f fVar = fVarArr[i5];
            char c5 = fVar.f5754a;
            z.f fVar2 = fVarArr2[i5];
            if (c5 != fVar2.f5754a || fVar.f5755b.length != fVar2.f5755b.length) {
                return false;
            }
        }
        return true;
    }

    public static void h(String str, boolean z4) {
        if (!z4) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void i(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void j(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static int k(Context context, String str) {
        int c5;
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, myPid, myUid) == -1) {
            return -1;
        }
        String d5 = l.d(str);
        if (d5 != null) {
            if (packageName == null) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(myUid);
                if (packagesForUid == null || packagesForUid.length <= 0) {
                    return -1;
                }
                packageName = packagesForUid[0];
            }
            if (!(Process.myUid() == myUid && Objects.equals(context.getPackageName(), packageName))) {
                c5 = l.c((AppOpsManager) l.a(context, AppOpsManager.class), d5, packageName);
            } else if (Build.VERSION.SDK_INT >= 29) {
                AppOpsManager c6 = m.c(context);
                c5 = m.a(c6, d5, Binder.getCallingUid(), packageName);
                if (c5 == 0) {
                    c5 = m.a(c6, d5, myUid, m.b(context));
                }
            } else {
                c5 = l.c((AppOpsManager) l.a(context, AppOpsManager.class), d5, packageName);
            }
            if (c5 != 0) {
                return -2;
            }
        }
        return 0;
    }

    public static ImageView.ScaleType l(int i5) {
        return i5 != 0 ? i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 5 ? i5 != 6 ? ImageView.ScaleType.CENTER : ImageView.ScaleType.CENTER_INSIDE : ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_END : ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.FIT_START : ImageView.ScaleType.FIT_XY;
    }

    public static float[] m(float[] fArr, int i5) {
        if (i5 >= 0) {
            int length = fArr.length;
            if (length >= 0) {
                int i6 = i5 - 0;
                int min = Math.min(i6, length - 0);
                float[] fArr2 = new float[i6];
                System.arraycopy(fArr, 0, fArr2, 0, min);
                return fArr2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }

    public static i0 n(int i5) {
        if (i5 != 0 && i5 == 1) {
            return new p3.d();
        }
        return new i();
    }

    public static p3.e o() {
        return new p3.e(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0084, code lost:
        if (r16 == 0) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0091 A[Catch: NumberFormatException -> 0x00b3, LOOP:3: B:25:0x0068->B:43:0x0091, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00b3, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:43:0x0091, B:45:0x0097, B:48:0x00a7, B:50:0x00ac), top: B:66:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0097 A[Catch: NumberFormatException -> 0x00b3, TryCatch #0 {NumberFormatException -> 0x00b3, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:43:0x0091, B:45:0x0097, B:48:0x00a7, B:50:0x00ac), top: B:66:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a7 A[Catch: NumberFormatException -> 0x00b3, TryCatch #0 {NumberFormatException -> 0x00b3, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:43:0x0091, B:45:0x0097, B:48:0x00a7, B:50:0x00ac), top: B:66:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00db A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0090 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static z.f[] p(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.a.p(java.lang.String):z.f[]");
    }

    public static Path q(String str) {
        Path path = new Path();
        try {
            z.f.b(p(str), path);
            return path;
        } catch (RuntimeException e5) {
            throw new RuntimeException("Error in parsing ".concat(str), e5);
        }
    }

    public static z.f[] r(z.f[] fVarArr) {
        z.f[] fVarArr2 = new z.f[fVarArr.length];
        for (int i5 = 0; i5 < fVarArr.length; i5++) {
            fVarArr2[i5] = new z.f(fVarArr[i5]);
        }
        return fVarArr2;
    }

    public static boolean s(View view, KeyEvent keyEvent) {
        WeakReference weakReference;
        int indexOfKey;
        WeakHashMap weakHashMap = z0.f3233a;
        if (Build.VERSION.SDK_INT < 28) {
            ArrayList arrayList = y0.f3229d;
            y0 y0Var = (y0) view.getTag(R.id.tag_unhandled_key_event_manager);
            if (y0Var == null) {
                y0Var = new y0();
                view.setTag(R.id.tag_unhandled_key_event_manager, y0Var);
            }
            WeakReference weakReference2 = y0Var.f3232c;
            if (weakReference2 == null || weakReference2.get() != keyEvent) {
                y0Var.f3232c = new WeakReference(keyEvent);
                if (y0Var.f3231b == null) {
                    y0Var.f3231b = new SparseArray();
                }
                SparseArray sparseArray = y0Var.f3231b;
                if (keyEvent.getAction() != 1 || (indexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) < 0) {
                    weakReference = null;
                } else {
                    weakReference = (WeakReference) sparseArray.valueAt(indexOfKey);
                    sparseArray.removeAt(indexOfKey);
                }
                if (weakReference == null) {
                    weakReference = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
                }
                if (weakReference != null) {
                    View view2 = (View) weakReference.get();
                    if (view2 == null || !view2.isAttachedToWindow()) {
                        return true;
                    }
                    y0.b(view2);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean t(h0.l r7, android.view.View r8, android.view.Window.Callback r9, android.view.KeyEvent r10) {
        /*
            r0 = 0
            if (r7 != 0) goto L4
            return r0
        L4:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto Lf
            boolean r7 = r7.superDispatchKeyEvent(r10)
            return r7
        Lf:
            boolean r1 = r9 instanceof android.app.Activity
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L81
            android.app.Activity r9 = (android.app.Activity) r9
            r9.onUserInteraction()
            android.view.Window r7 = r9.getWindow()
            r8 = 8
            boolean r8 = r7.hasFeature(r8)
            if (r8 == 0) goto L64
            android.app.ActionBar r8 = r9.getActionBar()
            int r1 = r10.getKeyCode()
            r4 = 82
            if (r1 != r4) goto L64
            if (r8 == 0) goto L64
            boolean r1 = p2.a.f4250e
            if (r1 != 0) goto L4c
            java.lang.Class r1 = r8.getClass()     // Catch: java.lang.NoSuchMethodException -> L4a
            java.lang.String r4 = "onMenuKeyEvent"
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch: java.lang.NoSuchMethodException -> L4a
            java.lang.Class<android.view.KeyEvent> r6 = android.view.KeyEvent.class
            r5[r0] = r6     // Catch: java.lang.NoSuchMethodException -> L4a
            java.lang.reflect.Method r1 = r1.getMethod(r4, r5)     // Catch: java.lang.NoSuchMethodException -> L4a
            p2.a.f4251f = r1     // Catch: java.lang.NoSuchMethodException -> L4a
        L4a:
            p2.a.f4250e = r3
        L4c:
            java.lang.reflect.Method r1 = p2.a.f4251f
            if (r1 == 0) goto L61
            java.lang.Object[] r4 = new java.lang.Object[]{r10}     // Catch: java.lang.Throwable -> L61
            java.lang.Object r8 = r1.invoke(r8, r4)     // Catch: java.lang.Throwable -> L61
            if (r8 != 0) goto L5b
            goto L61
        L5b:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L61
            boolean r0 = r8.booleanValue()     // Catch: java.lang.Throwable -> L61
        L61:
            if (r0 == 0) goto L64
            goto L80
        L64:
            boolean r8 = r7.superDispatchKeyEvent(r10)
            if (r8 == 0) goto L6b
            goto L80
        L6b:
            android.view.View r7 = r7.getDecorView()
            boolean r8 = h0.z0.c(r7, r10)
            if (r8 == 0) goto L76
            goto L80
        L76:
            if (r7 == 0) goto L7c
            android.view.KeyEvent$DispatcherState r2 = r7.getKeyDispatcherState()
        L7c:
            boolean r3 = r10.dispatch(r9, r2, r9)
        L80:
            return r3
        L81:
            boolean r1 = r9 instanceof android.app.Dialog
            if (r1 == 0) goto Ld4
            android.app.Dialog r9 = (android.app.Dialog) r9
            boolean r7 = p2.a.f4252g
            if (r7 != 0) goto L9a
            java.lang.Class<android.app.Dialog> r7 = android.app.Dialog.class
            java.lang.String r8 = "mOnKeyListener"
            java.lang.reflect.Field r7 = r7.getDeclaredField(r8)     // Catch: java.lang.NoSuchFieldException -> L98
            p2.a.f4253h = r7     // Catch: java.lang.NoSuchFieldException -> L98
            r7.setAccessible(r3)     // Catch: java.lang.NoSuchFieldException -> L98
        L98:
            p2.a.f4252g = r3
        L9a:
            java.lang.reflect.Field r7 = p2.a.f4253h
            if (r7 == 0) goto La5
            java.lang.Object r7 = r7.get(r9)     // Catch: java.lang.IllegalAccessException -> La5
            android.content.DialogInterface$OnKeyListener r7 = (android.content.DialogInterface.OnKeyListener) r7     // Catch: java.lang.IllegalAccessException -> La5
            goto La6
        La5:
            r7 = r2
        La6:
            if (r7 == 0) goto Lb3
            int r8 = r10.getKeyCode()
            boolean r7 = r7.onKey(r9, r8, r10)
            if (r7 == 0) goto Lb3
            goto Ld3
        Lb3:
            android.view.Window r7 = r9.getWindow()
            boolean r8 = r7.superDispatchKeyEvent(r10)
            if (r8 == 0) goto Lbe
            goto Ld3
        Lbe:
            android.view.View r7 = r7.getDecorView()
            boolean r8 = h0.z0.c(r7, r10)
            if (r8 == 0) goto Lc9
            goto Ld3
        Lc9:
            if (r7 == 0) goto Lcf
            android.view.KeyEvent$DispatcherState r2 = r7.getKeyDispatcherState()
        Lcf:
            boolean r3 = r10.dispatch(r9, r2, r9)
        Ld3:
            return r3
        Ld4:
            if (r8 == 0) goto Ldc
            boolean r8 = h0.z0.c(r8, r10)
            if (r8 != 0) goto Le2
        Ldc:
            boolean r7 = r7.superDispatchKeyEvent(r10)
            if (r7 == 0) goto Le3
        Le2:
            r0 = r3
        Le3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.a.t(h0.l, android.view.View, android.view.Window$Callback, android.view.KeyEvent):boolean");
    }

    public static ColorStateList u(Context context, int i5) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        k kVar;
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        y.l lVar = new y.l(resources, theme);
        synchronized (q.f5570c) {
            SparseArray sparseArray = (SparseArray) q.f5569b.get(lVar);
            colorStateList = null;
            if (sparseArray != null && sparseArray.size() > 0 && (kVar = (k) sparseArray.get(i5)) != null) {
                if (!kVar.f5558b.equals(resources.getConfiguration()) || (!(theme == null && kVar.f5559c == 0) && (theme == null || kVar.f5559c != theme.hashCode()))) {
                    sparseArray.remove(i5);
                } else {
                    colorStateList2 = kVar.f5557a;
                }
            }
            colorStateList2 = null;
        }
        if (colorStateList2 != null) {
            return colorStateList2;
        }
        ThreadLocal threadLocal = q.f5568a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        boolean z4 = true;
        resources.getValue(i5, typedValue, true);
        int i6 = typedValue.type;
        if (!((i6 < 28 || i6 > 31) ? false : false)) {
            try {
                colorStateList = y.b.a(resources, resources.getXml(i5), theme);
            } catch (Exception e5) {
                Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e5);
            }
        }
        if (colorStateList != null) {
            synchronized (q.f5570c) {
                WeakHashMap weakHashMap = q.f5569b;
                SparseArray sparseArray2 = (SparseArray) weakHashMap.get(lVar);
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    weakHashMap.put(lVar, sparseArray2);
                }
                sparseArray2.append(i5, new k(colorStateList, lVar.f5560a.getConfiguration(), theme));
            }
            return colorStateList;
        }
        return j.b(resources, i5, theme);
    }

    public static ColorStateList v(Context context, TypedArray typedArray, int i5) {
        int resourceId;
        ColorStateList u3;
        return (!typedArray.hasValue(i5) || (resourceId = typedArray.getResourceId(i5, 0)) == 0 || (u3 = u(context, resourceId)) == null) ? typedArray.getColorStateList(i5) : u3;
    }

    public static ColorStateList w(Context context, z2 z2Var, int i5) {
        int i6;
        ColorStateList u3;
        return (!z2Var.l(i5) || (i6 = z2Var.i(i5, 0)) == 0 || (u3 = u(context, i6)) == null) ? z2Var.b(i5) : u3;
    }

    public static Drawable x(Context context, int i5) {
        return v2.c().e(context, i5);
    }

    public static Drawable y(Context context, TypedArray typedArray, int i5) {
        int resourceId;
        Drawable x5;
        return (!typedArray.hasValue(i5) || (resourceId = typedArray.getResourceId(i5, 0)) == 0 || (x5 = x(context, resourceId)) == null) ? typedArray.getDrawable(i5) : x5;
    }

    public static float z(String[] strArr, int i5) {
        float parseFloat = Float.parseFloat(strArr[i5]);
        if (parseFloat < 0.0f || parseFloat > 1.0f) {
            throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + parseFloat);
        }
        return parseFloat;
    }

    public void J(int i5) {
    }

    public void K() {
    }

    public abstract void M(int i5);

    public abstract void N(Typeface typeface, boolean z4);

    public abstract l2.f f(Context context, Looper looper, c cVar, j2.a aVar, j2.f fVar, j2.g gVar);
}

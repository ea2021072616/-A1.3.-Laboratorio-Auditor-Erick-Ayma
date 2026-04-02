package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class v2 {

    /* renamed from: g  reason: collision with root package name */
    public static v2 f553g;

    /* renamed from: a  reason: collision with root package name */
    public WeakHashMap f555a;

    /* renamed from: b  reason: collision with root package name */
    public final WeakHashMap f556b = new WeakHashMap(0);

    /* renamed from: c  reason: collision with root package name */
    public TypedValue f557c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f558d;

    /* renamed from: e  reason: collision with root package name */
    public x f559e;

    /* renamed from: f  reason: collision with root package name */
    public static final PorterDuff.Mode f552f = PorterDuff.Mode.SRC_IN;

    /* renamed from: h  reason: collision with root package name */
    public static final u2 f554h = new u2();

    public static synchronized v2 c() {
        v2 v2Var;
        synchronized (v2.class) {
            if (f553g == null) {
                f553g = new v2();
            }
            v2Var = f553g;
        }
        return v2Var;
    }

    public static synchronized PorterDuffColorFilter g(int i5, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (v2.class) {
            u2 u2Var = f554h;
            u2Var.getClass();
            int i6 = (i5 + 31) * 31;
            porterDuffColorFilter = (PorterDuffColorFilter) u2Var.a(Integer.valueOf(mode.hashCode() + i6));
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(i5, mode);
                u2Var.getClass();
                PorterDuffColorFilter porterDuffColorFilter2 = (PorterDuffColorFilter) u2Var.b(Integer.valueOf(mode.hashCode() + i6), porterDuffColorFilter);
            }
        }
        return porterDuffColorFilter;
    }

    public final synchronized void a(Context context, long j5, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            l.d dVar = (l.d) this.f556b.get(context);
            if (dVar == null) {
                dVar = new l.d();
                this.f556b.put(context, dVar);
            }
            dVar.e(j5, new WeakReference(constantState));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable b(android.content.Context r8, int r9) {
        /*
            r7 = this;
            android.util.TypedValue r0 = r7.f557c
            if (r0 != 0) goto Lb
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r7.f557c = r0
        Lb:
            android.util.TypedValue r0 = r7.f557c
            android.content.res.Resources r1 = r8.getResources()
            r2 = 1
            r1.getValue(r9, r0, r2)
            int r1 = r0.assetCookie
            long r3 = (long) r1
            r1 = 32
            long r3 = r3 << r1
            int r1 = r0.data
            long r5 = (long) r1
            long r3 = r3 | r5
            android.graphics.drawable.Drawable r1 = r7.d(r8, r3)
            if (r1 == 0) goto L26
            return r1
        L26:
            androidx.appcompat.widget.x r1 = r7.f559e
            if (r1 != 0) goto L2b
            goto L73
        L2b:
            r1 = 2131230778(0x7f08003a, float:1.8077618E38)
            if (r9 != r1) goto L4c
            android.graphics.drawable.LayerDrawable r9 = new android.graphics.drawable.LayerDrawable
            r1 = 2
            android.graphics.drawable.Drawable[] r1 = new android.graphics.drawable.Drawable[r1]
            r5 = 2131230777(0x7f080039, float:1.8077616E38)
            android.graphics.drawable.Drawable r5 = r7.e(r8, r5)
            r6 = 0
            r1[r6] = r5
            r5 = 2131230779(0x7f08003b, float:1.807762E38)
            android.graphics.drawable.Drawable r5 = r7.e(r8, r5)
            r1[r2] = r5
            r9.<init>(r1)
            goto L74
        L4c:
            r1 = 2131230813(0x7f08005d, float:1.807769E38)
            if (r9 != r1) goto L59
            r9 = 2131165243(0x7f07003b, float:1.7944698E38)
            android.graphics.drawable.LayerDrawable r9 = androidx.appcompat.widget.x.f(r7, r8, r9)
            goto L74
        L59:
            r1 = 2131230812(0x7f08005c, float:1.8077687E38)
            if (r9 != r1) goto L66
            r9 = 2131165244(0x7f07003c, float:1.79447E38)
            android.graphics.drawable.LayerDrawable r9 = androidx.appcompat.widget.x.f(r7, r8, r9)
            goto L74
        L66:
            r1 = 2131230814(0x7f08005e, float:1.8077691E38)
            if (r9 != r1) goto L73
            r9 = 2131165245(0x7f07003d, float:1.7944702E38)
            android.graphics.drawable.LayerDrawable r9 = androidx.appcompat.widget.x.f(r7, r8, r9)
            goto L74
        L73:
            r9 = 0
        L74:
            if (r9 == 0) goto L7e
            int r0 = r0.changingConfigurations
            r9.setChangingConfigurations(r0)
            r7.a(r8, r3, r9)
        L7e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.v2.b(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    public final synchronized Drawable d(Context context, long j5) {
        l.d dVar = (l.d) this.f556b.get(context);
        if (dVar == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) dVar.d(j5, null);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            int c5 = b4.j.c(dVar.f3678c, dVar.f3680e, j5);
            if (c5 >= 0) {
                Object[] objArr = dVar.f3679d;
                Object obj = objArr[c5];
                Object obj2 = l.d.f3676f;
                if (obj != obj2) {
                    objArr[c5] = obj2;
                    dVar.f3677b = true;
                }
            }
        }
        return null;
    }

    public final synchronized Drawable e(Context context, int i5) {
        return f(context, i5, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r0 == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
        a0.a.i(r12, r4);
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized android.graphics.drawable.Drawable f(android.content.Context r12, int r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.v2.f(android.content.Context, int, boolean):android.graphics.drawable.Drawable");
    }

    public final synchronized ColorStateList h(Context context, int i5) {
        ColorStateList colorStateList;
        l.k kVar;
        try {
            WeakHashMap weakHashMap = this.f555a;
            ColorStateList colorStateList2 = null;
            colorStateList = (weakHashMap == null || (kVar = (l.k) weakHashMap.get(context)) == null) ? null : (ColorStateList) kVar.c(i5, null);
            if (colorStateList == null) {
                x xVar = this.f559e;
                if (xVar != null) {
                    colorStateList2 = xVar.g(context, i5);
                }
                if (colorStateList2 != null) {
                    if (this.f555a == null) {
                        this.f555a = new WeakHashMap();
                    }
                    l.k kVar2 = (l.k) this.f555a.get(context);
                    if (kVar2 == null) {
                        kVar2 = new l.k();
                        this.f555a.put(context, kVar2);
                    }
                    kVar2.a(i5, colorStateList2);
                }
                colorStateList = colorStateList2;
            }
        } catch (Throwable th) {
            throw th;
        }
        return colorStateList;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
        /*
            r6 = this;
            androidx.appcompat.widget.x r0 = r6.f559e
            r1 = 0
            if (r0 == 0) goto L79
            android.graphics.PorterDuff$Mode r2 = androidx.appcompat.widget.y.f596b
            java.io.Serializable r3 = r0.f570a
            int[] r3 = (int[]) r3
            boolean r3 = androidx.appcompat.widget.x.b(r3, r8)
            r4 = 1
            r5 = -1
            if (r3 == 0) goto L17
            r8 = 2130968838(0x7f040106, float:1.754634E38)
            goto L4e
        L17:
            java.lang.Object r3 = r0.f572c
            int[] r3 = (int[]) r3
            boolean r3 = androidx.appcompat.widget.x.b(r3, r8)
            if (r3 == 0) goto L25
            r8 = 2130968836(0x7f040104, float:1.7546337E38)
            goto L4e
        L25:
            java.io.Serializable r0 = r0.f573d
            int[] r0 = (int[]) r0
            boolean r0 = androidx.appcompat.widget.x.b(r0, r8)
            if (r0 == 0) goto L32
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L4b
        L32:
            r0 = 2131230799(0x7f08004f, float:1.807766E38)
            if (r8 != r0) goto L46
            r8 = 1109603123(0x42233333, float:40.8)
            int r8 = java.lang.Math.round(r8)
            r0 = 16842800(0x1010030, float:2.3693693E-38)
            r3 = r2
            r2 = r0
            r0 = r8
            r8 = r4
            goto L56
        L46:
            r0 = 2131230781(0x7f08003d, float:1.8077624E38)
            if (r8 != r0) goto L51
        L4b:
            r8 = 16842801(0x1010031, float:2.3693695E-38)
        L4e:
            r0 = r8
            r8 = r4
            goto L53
        L51:
            r8 = r1
            r0 = r8
        L53:
            r3 = r2
            r2 = r0
            r0 = r5
        L56:
            if (r8 == 0) goto L75
            android.graphics.drawable.Drawable r8 = r9.mutate()
            int r7 = androidx.appcompat.widget.d3.c(r7, r2)
            java.lang.Class<androidx.appcompat.widget.y> r9 = androidx.appcompat.widget.y.class
            monitor-enter(r9)
            android.graphics.PorterDuffColorFilter r7 = g(r7, r3)     // Catch: java.lang.Throwable -> L72
            monitor-exit(r9)
            r8.setColorFilter(r7)
            if (r0 == r5) goto L70
            r8.setAlpha(r0)
        L70:
            r7 = r4
            goto L76
        L72:
            r7 = move-exception
            monitor-exit(r9)
            throw r7
        L75:
            r7 = r1
        L76:
            if (r7 == 0) goto L79
            r1 = r4
        L79:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.v2.i(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }
}

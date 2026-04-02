package d;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import android.view.ContentInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputContentInfo;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.f1;
import androidx.appcompat.widget.i3;
import androidx.appcompat.widget.m3;
import androidx.appcompat.widget.p2;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.profileinstaller.ProfileInstallReceiver;
import h0.f2;
import h0.h2;
import h0.w1;
import h0.x1;
import h0.y1;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class u0 implements p2, h.z, h.m, f1, h0.x, h0.f, m0.c, z0.e {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f2462g;

    /* renamed from: h  reason: collision with root package name */
    public Object f2463h;

    public /* synthetic */ u0(int i5, Object obj) {
        this.f2462g = i5;
        this.f2463h = obj;
    }

    public static Object z(Object[] objArr, int i5, p3.e eVar) {
        int i6;
        boolean z4;
        int i7 = (i5 & 1) == 0 ? 400 : 700;
        boolean z5 = (i5 & 2) != 0;
        Object obj = null;
        int i8 = Integer.MAX_VALUE;
        for (Object obj2 : objArr) {
            int i9 = eVar.f4273g;
            switch (i9) {
                case 0:
                    i6 = ((e0.g) obj2).f2579c;
                    break;
                default:
                    i6 = ((y.g) obj2).f5548b;
                    break;
            }
            int abs = Math.abs(i6 - i7) * 2;
            switch (i9) {
                case 0:
                    z4 = ((e0.g) obj2).f2580d;
                    break;
                default:
                    z4 = ((y.g) obj2).f5549c;
                    break;
            }
            int i10 = abs + (z4 == z5 ? 0 : 1);
            if (obj == null || i8 > i10) {
                obj = obj2;
                i8 = i10;
            }
        }
        return obj;
    }

    public e0.g A(int i5, e0.g[] gVarArr) {
        return (e0.g) z(gVarArr, i5, new p3.e(0));
    }

    public final long B() {
        return ((ByteBuffer) this.f2463h).getInt() & 4294967295L;
    }

    public final void C(int i5) {
        Object obj = this.f2463h;
        ((ByteBuffer) obj).position(((ByteBuffer) obj).position() + i5);
    }

    @Override // h0.x
    public final h2 a(View view, h2 h2Var) {
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f2463h;
        if (!Objects.equals(coordinatorLayout.f698t, h2Var)) {
            coordinatorLayout.f698t = h2Var;
            boolean z4 = true;
            boolean z5 = h2Var.e() > 0;
            coordinatorLayout.f699u = z5;
            coordinatorLayout.setWillNotDraw((z5 || coordinatorLayout.getBackground() != null) ? false : false);
            f2 f2Var = h2Var.f3144a;
            if (!f2Var.m()) {
                int childCount = coordinatorLayout.getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = coordinatorLayout.getChildAt(i5);
                    WeakHashMap weakHashMap = h0.z0.f3233a;
                    if (childAt.getFitsSystemWindows() && ((u.d) childAt.getLayoutParams()).f5096a != null && f2Var.m()) {
                        break;
                    }
                }
            }
            coordinatorLayout.requestLayout();
        }
        return h2Var;
    }

    @Override // h.z
    public final void b(h.o oVar, boolean z4) {
        if (oVar instanceof h.g0) {
            oVar.k().c(false);
        }
        h.z zVar = ((androidx.appcompat.widget.n) this.f2463h).f418k;
        if (zVar != null) {
            zVar.b(oVar, z4);
        }
    }

    @Override // h.m
    public final void c(h.o oVar) {
        h.m mVar = ((ActionMenuView) this.f2463h).B;
        if (mVar != null) {
            mVar.c(oVar);
        }
    }

    @Override // h.m
    public final boolean d(h.o oVar, MenuItem menuItem) {
        boolean onMenuItemSelected;
        Object obj = this.f2463h;
        if (((ActionMenuView) obj).G != null) {
            Toolbar toolbar = ((i3) ((ActionMenuView) obj).G).f391g;
            if (toolbar.M.a(menuItem)) {
                onMenuItemSelected = true;
            } else {
                m3 m3Var = toolbar.O;
                onMenuItemSelected = m3Var != null ? ((v0) m3Var).f2467g.f2475b.onMenuItemSelected(0, menuItem) : false;
            }
            return onMenuItemSelected;
        }
        return false;
    }

    @Override // m0.c
    public final void e() {
        switch (this.f2462g) {
            case 18:
                ((InputContentInfo) this.f2463h).requestPermission();
                return;
            default:
                ((m0.c) this.f2463h).e();
                return;
        }
    }

    @Override // h0.f
    public final ClipData f() {
        ClipData clip;
        clip = ((ContentInfo) this.f2463h).getClip();
        return clip;
    }

    @Override // androidx.appcompat.widget.p2
    public final void g(h.o oVar, MenuItem menuItem) {
        ((h.i) this.f2463h).f2998m.removeCallbacksAndMessages(oVar);
    }

    @Override // h.z
    public final boolean h(h.o oVar) {
        Object obj = this.f2463h;
        if (oVar == ((androidx.appcompat.widget.n) obj).f416i) {
            return false;
        }
        ((h.g0) oVar).G.getClass();
        ((androidx.appcompat.widget.n) obj).getClass();
        h.z zVar = ((androidx.appcompat.widget.n) this.f2463h).f418k;
        if (zVar != null) {
            return zVar.h(oVar);
        }
        return false;
    }

    @Override // m0.c
    public final Uri i() {
        switch (this.f2462g) {
            case 18:
                return ((InputContentInfo) this.f2463h).getLinkUri();
            default:
                return ((m0.c) this.f2463h).i();
        }
    }

    @Override // h0.f
    public final int j() {
        int flags;
        flags = ((ContentInfo) this.f2463h).getFlags();
        return flags;
    }

    @Override // z0.e
    public final void k() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // androidx.appcompat.widget.p2
    public final void l(h.o oVar, h.q qVar) {
        ((h.i) this.f2463h).f2998m.removeCallbacksAndMessages(null);
        int size = ((h.i) this.f2463h).o.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                i5 = -1;
                break;
            } else if (oVar == ((h.h) ((h.i) this.f2463h).o.get(i5)).f2991b) {
                break;
            } else {
                i5++;
            }
        }
        if (i5 == -1) {
            return;
        }
        int i6 = i5 + 1;
        ((h.i) this.f2463h).f2998m.postAtTime(new h.g(this, i6 < ((h.i) this.f2463h).o.size() ? (h.h) ((h.i) this.f2463h).o.get(i6) : null, qVar, oVar), oVar, SystemClock.uptimeMillis() + 200);
    }

    @Override // h0.f
    public final ContentInfo m() {
        return (ContentInfo) this.f2463h;
    }

    @Override // z0.e
    public final void n(int i5, Object obj) {
        com.google.android.gms.internal.play_billing.i0.f1894k.n(i5, obj);
        ((ProfileInstallReceiver) this.f2463h).setResultCode(i5);
    }

    public void o(int i5) {
    }

    public void p(int i5) {
    }

    @Override // h0.f
    public final int q() {
        int source;
        source = ((ContentInfo) this.f2463h).getSource();
        return source;
    }

    @Override // m0.c
    public final ClipDescription r() {
        switch (this.f2462g) {
            case 18:
                return ((InputContentInfo) this.f2463h).getDescription();
            default:
                return ((m0.c) this.f2463h).r();
        }
    }

    public void s(int i5, float f5) {
    }

    @Override // m0.c
    public final Object t() {
        return (InputContentInfo) this.f2463h;
    }

    public final String toString() {
        switch (this.f2462g) {
            case 15:
                return "ContentInfoCompat{" + ((ContentInfo) this.f2463h) + "}";
            default:
                return super.toString();
        }
    }

    @Override // m0.c
    public final Uri u() {
        switch (this.f2462g) {
            case 18:
                return ((InputContentInfo) this.f2463h).getContentUri();
            default:
                return ((m0.c) this.f2463h).u();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Typeface v(android.content.Context r10, y.f r11, android.content.res.Resources r12, int r13) {
        /*
            r9 = this;
            p3.e r0 = new p3.e
            r1 = 1
            r0.<init>(r1)
            y.g[] r2 = r11.f5546a
            java.lang.Object r0 = z(r2, r13, r0)
            y.g r0 = (y.g) r0
            if (r0 != 0) goto L12
            r10 = 0
            return r10
        L12:
            int r8 = r0.f5552f
            java.lang.String r0 = r0.f5547a
            d.u0 r2 = z.g.f5756a
            r3 = r10
            r4 = r12
            r5 = r8
            r6 = r0
            r7 = r13
            android.graphics.Typeface r10 = r2.y(r3, r4, r5, r6, r7)
            if (r10 == 0) goto L2d
            r2 = 0
            java.lang.String r12 = z.g.b(r12, r8, r0, r2, r13)
            l.e r13 = z.g.f5757b
            r13.b(r12, r10)
        L2d:
            java.lang.String r12 = "Could not retrieve font from family."
            java.lang.String r13 = "TypefaceCompatBaseImpl"
            r2 = 0
            if (r10 != 0) goto L37
        L35:
            r12 = r2
            goto L57
        L37:
            java.lang.Class<android.graphics.Typeface> r0 = android.graphics.Typeface.class
            java.lang.String r4 = "native_instance"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r4)     // Catch: java.lang.IllegalAccessException -> L4d java.lang.NoSuchFieldException -> L52
            r0.setAccessible(r1)     // Catch: java.lang.IllegalAccessException -> L4d java.lang.NoSuchFieldException -> L52
            java.lang.Object r0 = r0.get(r10)     // Catch: java.lang.IllegalAccessException -> L4d java.lang.NoSuchFieldException -> L52
            java.lang.Number r0 = (java.lang.Number) r0     // Catch: java.lang.IllegalAccessException -> L4d java.lang.NoSuchFieldException -> L52
            long r12 = r0.longValue()     // Catch: java.lang.IllegalAccessException -> L4d java.lang.NoSuchFieldException -> L52
            goto L57
        L4d:
            r0 = move-exception
            android.util.Log.e(r13, r12, r0)
            goto L35
        L52:
            r0 = move-exception
            android.util.Log.e(r13, r12, r0)
            goto L35
        L57:
            int r0 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r0 == 0) goto L66
            java.lang.Object r0 = r9.f2463h
            java.util.concurrent.ConcurrentHashMap r0 = (java.util.concurrent.ConcurrentHashMap) r0
            java.lang.Long r12 = java.lang.Long.valueOf(r12)
            r0.put(r12, r11)
        L66:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: d.u0.v(android.content.Context, y.f, android.content.res.Resources, int):android.graphics.Typeface");
    }

    public Typeface w(Context context, e0.g[] gVarArr, int i5) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (gVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(A(i5, gVarArr).f2577a);
            try {
                Typeface x5 = x(context, inputStream);
                m0.a.b(inputStream);
                return x5;
            } catch (IOException unused) {
                m0.a.b(inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                m0.a.b(inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public Typeface x(Context context, InputStream inputStream) {
        File o = m0.a.o(context);
        if (o == null) {
            return null;
        }
        try {
            if (m0.a.d(o, inputStream)) {
                return Typeface.createFromFile(o.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            o.delete();
        }
    }

    public Typeface y(Context context, Resources resources, int i5, String str, int i6) {
        File o = m0.a.o(context);
        if (o == null) {
            return null;
        }
        try {
            if (m0.a.c(o, resources, i5)) {
                return Typeface.createFromFile(o.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            o.delete();
        }
    }

    public /* synthetic */ u0(androidx.appcompat.widget.b0 b0Var) {
        this.f2462g = 27;
    }

    public u0(y.n nVar) {
        this.f2462g = 11;
        this.f2463h = nVar;
    }

    public u0(int i5) {
        this.f2462g = i5;
        if (i5 == 12) {
            this.f2463h = new ConcurrentHashMap();
        } else if (i5 != 17) {
            if (i5 == 25) {
                this.f2463h = new HashMap();
            } else if (i5 != 29) {
                this.f2463h = new ArrayDeque();
            } else {
                this.f2463h = null;
            }
        } else {
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 30) {
                this.f2463h = new y1();
            } else if (i6 >= 29) {
                this.f2463h = new x1();
            } else {
                this.f2463h = new w1();
            }
        }
    }

    public u0(View view) {
        this.f2462g = 16;
        if (Build.VERSION.SDK_INT >= 30) {
            this.f2463h = new h0.d0(view);
        } else {
            this.f2463h = new h0.b0(view);
        }
    }

    public u0(WindowInsetsController windowInsetsController) {
        this.f2462g = 16;
        this.f2463h = new h0.d0(windowInsetsController);
    }

    public u0(TextView textView) {
        this.f2462g = 24;
        if (textView != null) {
            this.f2463h = new s0.i(textView);
            return;
        }
        throw new NullPointerException("textView cannot be null");
    }

    public u0(Object obj) {
        this.f2462g = 18;
        this.f2463h = (InputContentInfo) obj;
    }

    public u0(androidx.biometric.r rVar) {
        this.f2462g = 7;
        this.f2463h = rVar;
    }

    public u0(ByteBuffer byteBuffer) {
        this.f2462g = 23;
        this.f2463h = byteBuffer;
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
    }

    public u0(ContentInfo contentInfo) {
        this.f2462g = 15;
        contentInfo.getClass();
        this.f2463h = b3.a.h(contentInfo);
    }
}

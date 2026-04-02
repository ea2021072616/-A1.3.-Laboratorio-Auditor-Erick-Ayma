package r3;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.github.appintro.R;
import com.google.android.material.snackbar.SnackbarContentLayout;
/* loaded from: classes.dex */
public final class o extends l {
    public static final int[] C = {R.attr.snackbarButtonStyle, R.attr.snackbarTextViewStyle};
    public final AccessibilityManager A;
    public boolean B;

    public o(Context context, ViewGroup viewGroup, SnackbarContentLayout snackbarContentLayout, SnackbarContentLayout snackbarContentLayout2) {
        super(context, viewGroup, snackbarContentLayout, snackbarContentLayout2);
        this.A = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    public static o f(View view, String str) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2 = null;
        while (true) {
            if (!(view instanceof CoordinatorLayout)) {
                if (view instanceof FrameLayout) {
                    if (view.getId() == 16908290) {
                        viewGroup = (ViewGroup) view;
                        break;
                    }
                    viewGroup2 = (ViewGroup) view;
                }
                if (view != null) {
                    ViewParent parent = view.getParent();
                    if (parent instanceof View) {
                        view = (View) parent;
                        continue;
                    } else {
                        view = null;
                        continue;
                    }
                }
                if (view == null) {
                    viewGroup = viewGroup2;
                    break;
                }
            } else {
                viewGroup = (ViewGroup) view;
                break;
            }
        }
        if (viewGroup != null) {
            Context context = viewGroup.getContext();
            LayoutInflater from = LayoutInflater.from(context);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(C);
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            boolean z4 = true;
            int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
            obtainStyledAttributes.recycle();
            if (resourceId == -1 || resourceId2 == -1) {
                z4 = false;
            }
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) from.inflate(z4 ? R.layout.mtrl_layout_snackbar_include : R.layout.design_layout_snackbar_include, viewGroup, false);
            o oVar = new o(context, viewGroup, snackbarContentLayout, snackbarContentLayout);
            ((SnackbarContentLayout) oVar.f4528i.getChildAt(0)).getMessageView().setText(str);
            oVar.f4530k = 0;
            return oVar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0062 A[Catch: all -> 0x0082, TryCatch #0 {, blocks: (B:20:0x0035, B:22:0x003b, B:23:0x0049, B:25:0x004b, B:28:0x0051, B:36:0x0062, B:38:0x006e, B:40:0x0072, B:42:0x0078, B:44:0x007a, B:45:0x0080, B:37:0x0067), top: B:50:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067 A[Catch: all -> 0x0082, TryCatch #0 {, blocks: (B:20:0x0035, B:22:0x003b, B:23:0x0049, B:25:0x004b, B:28:0x0051, B:36:0x0062, B:38:0x006e, B:40:0x0072, B:42:0x0078, B:44:0x007a, B:45:0x0080, B:37:0x0067), top: B:50:0x0035 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() {
        /*
            r9 = this;
            r3.r r0 = r3.r.b()
            int r1 = r9.f4530k
            r2 = 1
            r3 = 0
            r4 = 4
            r5 = -2
            if (r1 != r5) goto Ld
            goto L30
        Ld:
            int r6 = android.os.Build.VERSION.SDK_INT
            android.view.accessibility.AccessibilityManager r7 = r9.A
            r8 = 29
            if (r6 < r8) goto L24
            boolean r5 = r9.B
            if (r5 == 0) goto L1b
            r5 = r4
            goto L1c
        L1b:
            r5 = r3
        L1c:
            r5 = r5 | r2
            r5 = r5 | 2
            int r5 = i0.c.a(r7, r1, r5)
            goto L30
        L24:
            boolean r6 = r9.B
            if (r6 == 0) goto L2f
            boolean r6 = r7.isTouchExplorationEnabled()
            if (r6 == 0) goto L2f
            r1 = r5
        L2f:
            r5 = r1
        L30:
            r3.i r1 = r9.f4538t
            java.lang.Object r6 = r0.f4547a
            monitor-enter(r6)
            boolean r7 = r0.c(r1)     // Catch: java.lang.Throwable -> L82
            if (r7 == 0) goto L4b
            r3.q r1 = r0.f4549c     // Catch: java.lang.Throwable -> L82
            r1.f4544b = r5     // Catch: java.lang.Throwable -> L82
            android.os.Handler r2 = r0.f4548b     // Catch: java.lang.Throwable -> L82
            r2.removeCallbacksAndMessages(r1)     // Catch: java.lang.Throwable -> L82
            r3.q r1 = r0.f4549c     // Catch: java.lang.Throwable -> L82
            r0.d(r1)     // Catch: java.lang.Throwable -> L82
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L82
            goto L81
        L4b:
            r3.q r7 = r0.f4550d     // Catch: java.lang.Throwable -> L82
            if (r7 == 0) goto L5f
            if (r1 == 0) goto L5b
            java.lang.ref.WeakReference r7 = r7.f4543a     // Catch: java.lang.Throwable -> L82
            java.lang.Object r7 = r7.get()     // Catch: java.lang.Throwable -> L82
            if (r7 != r1) goto L5b
            r7 = r2
            goto L5c
        L5b:
            r7 = r3
        L5c:
            if (r7 == 0) goto L5f
            goto L60
        L5f:
            r2 = r3
        L60:
            if (r2 == 0) goto L67
            r3.q r1 = r0.f4550d     // Catch: java.lang.Throwable -> L82
            r1.f4544b = r5     // Catch: java.lang.Throwable -> L82
            goto L6e
        L67:
            r3.q r2 = new r3.q     // Catch: java.lang.Throwable -> L82
            r2.<init>(r5, r1)     // Catch: java.lang.Throwable -> L82
            r0.f4550d = r2     // Catch: java.lang.Throwable -> L82
        L6e:
            r3.q r1 = r0.f4549c     // Catch: java.lang.Throwable -> L82
            if (r1 == 0) goto L7a
            boolean r1 = r0.a(r1, r4)     // Catch: java.lang.Throwable -> L82
            if (r1 == 0) goto L7a
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L82
            goto L81
        L7a:
            r1 = 0
            r0.f4549c = r1     // Catch: java.lang.Throwable -> L82
            r0.e()     // Catch: java.lang.Throwable -> L82
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L82
        L81:
            return
        L82:
            r0 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L82
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.o.g():void");
    }
}

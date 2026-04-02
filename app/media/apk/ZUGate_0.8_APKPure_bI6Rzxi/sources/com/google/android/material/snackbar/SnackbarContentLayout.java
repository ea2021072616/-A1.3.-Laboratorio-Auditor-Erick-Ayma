package com.google.android.material.snackbar;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.github.appintro.R;
import h0.z0;
import java.util.WeakHashMap;
import p2.a;
import r3.m;
/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout implements m {

    /* renamed from: g  reason: collision with root package name */
    public TextView f2195g;

    /* renamed from: h  reason: collision with root package name */
    public Button f2196h;

    /* renamed from: i  reason: collision with root package name */
    public final TimeInterpolator f2197i;

    /* renamed from: j  reason: collision with root package name */
    public int f2198j;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2197i = a.R(context, R.attr.motionEasingEmphasizedInterpolator, x2.a.f5485b);
    }

    public final boolean a(int i5, int i6, int i7) {
        boolean z4;
        if (i5 != getOrientation()) {
            setOrientation(i5);
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.f2195g.getPaddingTop() == i6 && this.f2195g.getPaddingBottom() == i7) {
            return z4;
        }
        TextView textView = this.f2195g;
        WeakHashMap weakHashMap = z0.f3233a;
        if (textView.isPaddingRelative()) {
            textView.setPaddingRelative(textView.getPaddingStart(), i6, textView.getPaddingEnd(), i7);
            return true;
        }
        textView.setPadding(textView.getPaddingLeft(), i6, textView.getPaddingRight(), i7);
        return true;
    }

    public Button getActionView() {
        return this.f2196h;
    }

    public TextView getMessageView() {
        return this.f2195g;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f2195g = (TextView) findViewById(R.id.snackbar_text);
        this.f2196h = (Button) findViewById(R.id.snackbar_action);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
        if (a(1, r0, r0 - r2) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
        if (a(0, r0, r0) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0057, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:
        if (r1 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005a, code lost:
        super.onMeasure(r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005d, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.getOrientation()
            r1 = 1
            if (r0 != r1) goto Lb
            return
        Lb:
            android.content.res.Resources r0 = r7.getResources()
            r2 = 2131165341(0x7f07009d, float:1.7944896E38)
            int r0 = r0.getDimensionPixelSize(r2)
            android.content.res.Resources r2 = r7.getResources()
            r3 = 2131165340(0x7f07009c, float:1.7944894E38)
            int r2 = r2.getDimensionPixelSize(r3)
            android.widget.TextView r3 = r7.f2195g
            android.text.Layout r3 = r3.getLayout()
            r4 = 0
            if (r3 == 0) goto L32
            int r3 = r3.getLineCount()
            if (r3 <= r1) goto L32
            r3 = r1
            goto L33
        L32:
            r3 = r4
        L33:
            if (r3 == 0) goto L4c
            int r5 = r7.f2198j
            if (r5 <= 0) goto L4c
            android.widget.Button r5 = r7.f2196h
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.f2198j
            if (r5 <= r6) goto L4c
            int r2 = r0 - r2
            boolean r0 = r7.a(r1, r0, r2)
            if (r0 == 0) goto L57
            goto L58
        L4c:
            if (r3 == 0) goto L4f
            goto L50
        L4f:
            r0 = r2
        L50:
            boolean r0 = r7.a(r4, r0, r0)
            if (r0 == 0) goto L57
            goto L58
        L57:
            r1 = r4
        L58:
            if (r1 == 0) goto L5d
            super.onMeasure(r8, r9)
        L5d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarContentLayout.onMeasure(int, int):void");
    }

    public void setMaxInlineActionWidth(int i5) {
        this.f2198j = i5;
    }
}

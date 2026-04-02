package androidx.biometric;
/* loaded from: classes.dex */
public final class b0 implements androidx.lifecycle.b0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f609g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ e0 f610h;

    public /* synthetic */ b0(e0 e0Var, int i5) {
        this.f609g = i5;
        this.f610h = e0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
        if (r0 == 1) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
        if (r0 == 3) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0055  */
    @Override // androidx.lifecycle.b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.Object r12) {
        /*
            r11 = this;
            int r0 = r11.f609g
            r1 = 2000(0x7d0, double:9.88E-321)
            androidx.biometric.e0 r3 = r11.f610h
            switch(r0) {
                case 0: goto Lb;
                default: goto L9;
            }
        L9:
            goto L8f
        Lb:
            java.lang.Integer r12 = (java.lang.Integer) r12
            android.os.Handler r0 = r3.f613w
            androidx.activity.j r4 = r3.f614x
            r0.removeCallbacks(r4)
            int r0 = r12.intValue()
            android.widget.ImageView r5 = r3.B
            r6 = 0
            r7 = 1
            r8 = 2
            if (r5 != 0) goto L20
            goto L74
        L20:
            androidx.biometric.x r5 = r3.f615y
            int r5 = r5.f665x
            android.content.Context r9 = r3.getContext()
            if (r9 != 0) goto L32
            java.lang.String r9 = "FingerprintFragment"
            java.lang.String r10 = "Unable to get asset. Context is null."
            android.util.Log.w(r9, r10)
            goto L51
        L32:
            if (r5 != 0) goto L37
            if (r0 != r7) goto L37
            goto L49
        L37:
            if (r5 != r7) goto L3f
            if (r0 != r8) goto L3f
            r10 = 2131230878(0x7f08009e, float:1.8077821E38)
            goto L4c
        L3f:
            if (r5 != r8) goto L44
            if (r0 != r7) goto L44
            goto L49
        L44:
            if (r5 != r7) goto L51
            r10 = 3
            if (r0 != r10) goto L51
        L49:
            r10 = 2131230879(0x7f08009f, float:1.8077823E38)
        L4c:
            android.graphics.drawable.Drawable r9 = x.a.b(r9, r10)
            goto L52
        L51:
            r9 = 0
        L52:
            if (r9 != 0) goto L55
            goto L74
        L55:
            android.widget.ImageView r10 = r3.B
            r10.setImageDrawable(r9)
            if (r5 != 0) goto L5f
            if (r0 != r7) goto L5f
            goto L6a
        L5f:
            if (r5 != r7) goto L64
            if (r0 != r8) goto L64
            goto L68
        L64:
            if (r5 != r8) goto L6a
            if (r0 != r7) goto L6a
        L68:
            r5 = r7
            goto L6b
        L6a:
            r5 = r6
        L6b:
            if (r5 == 0) goto L70
            androidx.biometric.c0.a(r9)
        L70:
            androidx.biometric.x r5 = r3.f615y
            r5.f665x = r0
        L74:
            int r12 = r12.intValue()
            android.widget.TextView r0 = r3.C
            if (r0 == 0) goto L89
            if (r12 != r8) goto L7f
            r6 = r7
        L7f:
            if (r6 == 0) goto L84
            int r12 = r3.f616z
            goto L86
        L84:
            int r12 = r3.A
        L86:
            r0.setTextColor(r12)
        L89:
            android.os.Handler r12 = r3.f613w
            r12.postDelayed(r4, r1)
            return
        L8f:
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            android.os.Handler r0 = r3.f613w
            androidx.activity.j r4 = r3.f614x
            r0.removeCallbacks(r4)
            android.widget.TextView r0 = r3.C
            if (r0 == 0) goto L9f
            r0.setText(r12)
        L9f:
            android.os.Handler r12 = r3.f613w
            r12.postDelayed(r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.biometric.b0.b(java.lang.Object):void");
    }
}

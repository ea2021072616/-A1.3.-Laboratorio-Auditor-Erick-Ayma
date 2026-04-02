package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.i1;
import androidx.appcompat.widget.l0;
import androidx.appcompat.widget.r;
import androidx.appcompat.widget.t;
import com.google.android.material.button.MaterialButton;
import d.r0;
import e3.c;
import l3.a;
import s3.u;
/* loaded from: classes.dex */
public class MaterialComponentsViewInflater extends r0 {
    @Override // d.r0
    public final r a(Context context, AttributeSet attributeSet) {
        return new u(context, attributeSet);
    }

    @Override // d.r0
    public final t b(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // d.r0
    public final androidx.appcompat.widget.u c(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // d.r0
    public final l0 d(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }

    @Override // d.r0
    public final i1 e(Context context, AttributeSet attributeSet) {
        return new t3.a(context, attributeSet);
    }
}

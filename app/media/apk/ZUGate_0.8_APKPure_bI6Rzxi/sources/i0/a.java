package i0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    public final int f3358a;

    /* renamed from: b  reason: collision with root package name */
    public final j f3359b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3360c;

    public a(int i5, j jVar, int i6) {
        this.f3358a = i5;
        this.f3359b = jVar;
        this.f3360c = i6;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f3358a);
        this.f3359b.f3375a.performAction(this.f3360c, bundle);
    }
}

package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.widget.TextView;
/* loaded from: classes.dex */
public final class a1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextView f281b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Typeface f282c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f283d;

    public a1(TextView textView, Typeface typeface, int i5) {
        this.f281b = textView;
        this.f282c = typeface;
        this.f283d = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f281b.setTypeface(this.f282c, this.f283d);
    }
}

package androidx.activity;

import android.os.Bundle;
import androidx.fragment.app.d0;
import androidx.fragment.app.w0;
/* loaded from: classes.dex */
public final /* synthetic */ class f implements b1.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f52a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f53b;

    public /* synthetic */ f(int i5, Object obj) {
        this.f52a = i5;
        this.f53b = obj;
    }

    @Override // b1.c
    public final Bundle a() {
        int i5 = this.f52a;
        Object obj = this.f53b;
        switch (i5) {
            case 0:
                return ComponentActivity.b((ComponentActivity) obj);
            case 1:
                return d0.e((d0) obj);
            default:
                return ((w0) obj).V();
        }
    }
}

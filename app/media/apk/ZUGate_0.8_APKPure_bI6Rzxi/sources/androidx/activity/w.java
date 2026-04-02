package androidx.activity;

import android.window.OnBackInvokedCallback;
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public static final w f116a = new w();

    public final OnBackInvokedCallback a(i4.l lVar, i4.l lVar2, i4.a aVar, i4.a aVar2) {
        e4.e.f(lVar, "onBackStarted");
        e4.e.f(lVar2, "onBackProgressed");
        e4.e.f(aVar, "onBackInvoked");
        e4.e.f(aVar2, "onBackCancelled");
        return new v(lVar, lVar2, aVar, aVar2);
    }
}

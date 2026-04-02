package e0;

import android.content.Context;
import androidx.appcompat.widget.s;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public final class c implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2564a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2565b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f2566c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ s f2567d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f2568e;

    public /* synthetic */ c(String str, Context context, s sVar, int i5, int i6) {
        this.f2564a = i6;
        this.f2565b = str;
        this.f2566c = context;
        this.f2567d = sVar;
        this.f2568e = i5;
    }

    public final e a() {
        int i5 = this.f2564a;
        Context context = this.f2566c;
        String str = this.f2565b;
        int i6 = this.f2568e;
        s sVar = this.f2567d;
        switch (i5) {
            case 0:
                return f.a(str, context, sVar, i6);
            default:
                try {
                    return f.a(str, context, sVar, i6);
                } catch (Throwable unused) {
                    return new e(-3);
                }
        }
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        switch (this.f2564a) {
            case 0:
                return a();
            default:
                return a();
        }
    }
}

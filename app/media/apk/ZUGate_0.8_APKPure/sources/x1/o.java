package x1;

import android.content.Context;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
/* loaded from: classes.dex */
public final class o implements n {

    /* renamed from: e  reason: collision with root package name */
    public static volatile j f5473e;

    /* renamed from: a  reason: collision with root package name */
    public final f2.a f5474a;

    /* renamed from: b  reason: collision with root package name */
    public final f2.a f5475b;

    /* renamed from: c  reason: collision with root package name */
    public final b2.c f5476c;

    /* renamed from: d  reason: collision with root package name */
    public final c2.k f5477d;

    public o(f2.a aVar, f2.a aVar2, b2.c cVar, c2.k kVar, c2.m mVar) {
        this.f5474a = aVar;
        this.f5475b = aVar2;
        this.f5476c = cVar;
        this.f5477d = kVar;
        mVar.getClass();
        mVar.f1760a.execute(new androidx.activity.d(7, mVar));
    }

    public static o a() {
        j jVar = f5473e;
        if (jVar != null) {
            return (o) jVar.f5469g.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void b(Context context) {
        if (f5473e == null) {
            synchronized (o.class) {
                if (f5473e == null) {
                    context.getClass();
                    f5473e = new j(context);
                }
            }
        }
    }

    public final d.e c(v1.a aVar) {
        Set singleton;
        byte[] bytes;
        if (aVar instanceof k) {
            aVar.getClass();
            singleton = Collections.unmodifiableSet(v1.a.f5187d);
        } else {
            singleton = Collections.singleton(new u1.b("proto"));
        }
        d.e a5 = i.a();
        aVar.getClass();
        a5.o("cct");
        String str = aVar.f5189a;
        String str2 = aVar.f5190b;
        if (str2 == null && str == null) {
            bytes = null;
        } else {
            Object[] objArr = new Object[4];
            objArr[0] = "1$";
            objArr[1] = str;
            objArr[2] = "\\";
            if (str2 == null) {
                str2 = "";
            }
            objArr[3] = str2;
            bytes = String.format("%s%s%s%s", objArr).getBytes(Charset.forName("UTF-8"));
        }
        a5.f2322i = bytes;
        return new d.e(singleton, a5.b(), this, 9);
    }
}

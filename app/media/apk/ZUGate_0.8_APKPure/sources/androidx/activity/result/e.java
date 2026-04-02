package androidx.activity.result;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public final class e extends d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f84a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Serializable f85b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b.a f86c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f87d;

    public /* synthetic */ e(Object obj, Serializable serializable, b.a aVar, int i5) {
        this.f84a = i5;
        this.f87d = obj;
        this.f85b = serializable;
        this.f86c = aVar;
    }

    @Override // androidx.activity.result.d
    public final void a(Object obj) {
        int i5 = this.f84a;
        b.a aVar = this.f86c;
        Object obj2 = this.f87d;
        Serializable serializable = this.f85b;
        switch (i5) {
            case 0:
                h hVar = (h) obj2;
                String str = (String) serializable;
                Integer num = (Integer) hVar.f93b.get(str);
                if (num != null) {
                    hVar.f95d.add(str);
                    try {
                        ((h) obj2).b(num.intValue(), aVar, obj);
                        return;
                    } catch (Exception e5) {
                        hVar.f95d.remove(str);
                        throw e5;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + aVar + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            case 1:
                h hVar2 = (h) obj2;
                String str2 = (String) serializable;
                Integer num2 = (Integer) hVar2.f93b.get(str2);
                if (num2 != null) {
                    hVar2.f95d.add(str2);
                    try {
                        ((h) obj2).b(num2.intValue(), aVar, obj);
                        return;
                    } catch (Exception e6) {
                        hVar2.f95d.remove(str2);
                        throw e6;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + aVar + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            default:
                d dVar = (d) ((AtomicReference) serializable).get();
                if (dVar == null) {
                    throw new IllegalStateException("Operation cannot be started before fragment is in created state");
                }
                dVar.a(obj);
                return;
        }
    }

    @Override // androidx.activity.result.d
    public final void b() {
        int i5 = this.f84a;
        Object obj = this.f87d;
        Serializable serializable = this.f85b;
        switch (i5) {
            case 0:
                ((h) obj).f((String) serializable);
                return;
            case 1:
                ((h) obj).f((String) serializable);
                return;
            default:
                d dVar = (d) ((AtomicReference) serializable).getAndSet(null);
                if (dVar != null) {
                    dVar.b();
                    return;
                }
                return;
        }
    }
}

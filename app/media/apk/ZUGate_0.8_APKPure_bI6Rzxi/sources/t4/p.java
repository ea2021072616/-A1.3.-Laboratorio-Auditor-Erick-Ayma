package t4;

import java.util.ArrayList;
import java.util.List;
import ru.zdevs.zugate.USBGateService;
/* loaded from: classes.dex */
public final class p extends x4.l {

    /* renamed from: f  reason: collision with root package name */
    public final USBGateService f5078f;

    public p(List list, USBGateService uSBGateService) {
        super(list);
        this.f5078f = uSBGateService;
    }

    @Override // x4.l
    public final x4.a a() {
        try {
            a[] e5 = this.f5078f.e();
            ArrayList arrayList = new ArrayList();
            for (a aVar : e5) {
                arrayList.add(new v4.b(aVar));
            }
            return new j(arrayList);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // x4.l
    public final int c() {
        return 0;
    }
}

package x3;

import java.nio.charset.Charset;
import java.util.Map;
import y3.f;
/* loaded from: classes.dex */
public final /* synthetic */ class a implements v3.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5495a;

    public /* synthetic */ a(int i5) {
        this.f5495a = i5;
    }

    @Override // v3.a
    public final void a(Object obj, Object obj2) {
        switch (this.f5495a) {
            case 0:
                v3.e eVar = (v3.e) obj2;
                throw new v3.b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
            case 1:
                Map.Entry entry = (Map.Entry) obj;
                v3.e eVar2 = (v3.e) obj2;
                Charset charset = f.f5696f;
                eVar2.d(f.f5697g, entry.getKey());
                eVar2.d(f.f5698h, entry.getValue());
                return;
            default:
                v3.e eVar3 = (v3.e) obj2;
                throw new v3.b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }
    }
}

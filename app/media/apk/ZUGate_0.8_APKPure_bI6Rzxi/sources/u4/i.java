package u4;

import android.net.Uri;
import java.util.List;
import ru.zdevs.zugate.jni.EncFS;
/* loaded from: classes.dex */
public final class i extends x4.l {

    /* renamed from: f  reason: collision with root package name */
    public final Uri f5161f;

    /* renamed from: g  reason: collision with root package name */
    public final String f5162g;

    /* renamed from: h  reason: collision with root package name */
    public final EncFS.EncFSContext f5163h;

    public i(List list, Uri uri, String str, EncFS.EncFSContext encFSContext) {
        super(list);
        this.f5161f = uri;
        this.f5162g = str;
        this.f5163h = encFSContext;
    }

    @Override // x4.l
    public final x4.a a() {
        try {
            ru.zdevs.zugate.jni.c.a(this.f5161f, this.f5162g, this.f5163h);
        } catch (Exception unused) {
        }
        return new t4.l(0);
    }

    @Override // x4.l
    public final int c() {
        return 2;
    }
}

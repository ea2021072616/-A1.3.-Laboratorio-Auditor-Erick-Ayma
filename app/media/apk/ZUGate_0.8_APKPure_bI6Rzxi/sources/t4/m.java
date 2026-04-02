package t4;

import android.net.Uri;
import com.github.appintro.R;
import com.google.android.gms.internal.play_billing.i0;
import java.util.List;
import ru.zdevs.zugate.USBGateService;
import ru.zdevs.zugate.ZApp;
/* loaded from: classes.dex */
public final class m extends x4.l {

    /* renamed from: f  reason: collision with root package name */
    public final USBGateService f5068f;

    /* renamed from: g  reason: collision with root package name */
    public final Uri f5069g;

    public m(List list, USBGateService uSBGateService, Uri uri) {
        super(list);
        this.f5068f = uSBGateService;
        this.f5069g = uri;
    }

    @Override // x4.l
    public final x4.a a() {
        Uri uri = this.f5069g;
        try {
            int a5 = this.f5068f.a(uri);
            if (a5 == -105) {
                ZApp.c(R.string.unsupported_format, new Object[0]);
                return null;
            } else if (a5 != 0) {
                ZApp.c(R.string.fail_add_the, i0.C(ZApp.f4571h.getContentResolver(), uri));
                return null;
            } else {
                return new l(0);
            }
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // x4.l
    public final int c() {
        return 2;
    }
}

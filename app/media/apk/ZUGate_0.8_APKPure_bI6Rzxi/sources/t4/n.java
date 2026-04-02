package t4;

import android.net.Uri;
import com.github.appintro.R;
import com.google.android.gms.internal.play_billing.i0;
import java.util.List;
import ru.zdevs.zugate.USBGateService;
import ru.zdevs.zugate.ZApp;
/* loaded from: classes.dex */
public final class n extends x4.l {

    /* renamed from: f  reason: collision with root package name */
    public final USBGateService f5070f;

    /* renamed from: g  reason: collision with root package name */
    public final Uri f5071g;

    /* renamed from: h  reason: collision with root package name */
    public final int f5072h;

    public n(List list, USBGateService uSBGateService, Uri uri, int i5) {
        super(list);
        this.f5070f = uSBGateService;
        this.f5071g = uri;
        this.f5072h = i5;
    }

    @Override // x4.l
    public final x4.a a() {
        Uri uri = this.f5071g;
        try {
            USBGateService uSBGateService = this.f5070f;
            int i5 = this.f5072h;
            uSBGateService.getClass();
            int b5 = USBGateService.b(uri, i5);
            if (b5 == -105) {
                ZApp.c(R.string.unsupported_format, new Object[0]);
                return null;
            } else if (b5 != 0) {
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

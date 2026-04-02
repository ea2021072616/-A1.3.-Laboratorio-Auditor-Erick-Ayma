package y;

import android.view.View;
import android.widget.Toast;
import com.google.android.material.sidesheet.SideSheetBehavior;
import ru.zdevs.zugate.ZApp;
/* loaded from: classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5562b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f5563c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f5564d;

    public /* synthetic */ m(int i5, int i6, Object obj) {
        this.f5562b = i6;
        this.f5564d = obj;
        this.f5563c = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = this.f5562b;
        int i6 = this.f5563c;
        Object obj = this.f5564d;
        switch (i5) {
            case 0:
                ((n) obj).onFontRetrievalFailed(i6);
                return;
            case 1:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj;
                View view = (View) sideSheetBehavior.f2186p.get();
                if (view != null) {
                    sideSheetBehavior.y(view, i6, false);
                    return;
                }
                return;
            default:
                String str = (String) obj;
                Toast toast = ZApp.f4572i;
                if (toast != null) {
                    toast.cancel();
                }
                Toast makeText = Toast.makeText(ZApp.f4571h, str, i6);
                ZApp.f4572i = makeText;
                makeText.show();
                return;
        }
    }
}

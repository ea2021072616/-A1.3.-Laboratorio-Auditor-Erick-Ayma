package t4;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.IBinder;
import java.util.List;
import ru.zdevs.zugate.MainActivity;
import ru.zdevs.zugate.USBGateService;
/* loaded from: classes.dex */
public final class g implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MainActivity f5056a;

    public g(MainActivity mainActivity) {
        this.f5056a = mainActivity;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        USBGateService uSBGateService = ((s) iBinder).f5094a;
        MainActivity mainActivity = this.f5056a;
        mainActivity.f4552g = uSBGateService;
        Uri uri = mainActivity.f4556k;
        x4.c cVar = mainActivity.f4555j;
        List list = mainActivity.f4554i;
        if (uri != null) {
            new n(list, mainActivity.f4552g, mainActivity.f4556k, mainActivity.f4557l).b(null, cVar);
            mainActivity.f4556k = null;
        } else if (mainActivity.f4558m != null) {
            new m(list, mainActivity.f4552g, mainActivity.f4558m).b(null, cVar);
            mainActivity.f4558m = null;
        }
        mainActivity.j();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f5056a.f4552g = null;
    }
}

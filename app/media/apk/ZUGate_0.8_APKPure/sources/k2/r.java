package k2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.widget.d0;
/* loaded from: classes.dex */
public final class r extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public Context f3611a;

    /* renamed from: b  reason: collision with root package name */
    public final d0 f3612b;

    public r(d0 d0Var) {
        this.f3612b = d0Var;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f3612b.o();
            synchronized (this) {
                Context context2 = this.f3611a;
                if (context2 != null) {
                    context2.unregisterReceiver(this);
                }
                this.f3611a = null;
            }
        }
    }
}

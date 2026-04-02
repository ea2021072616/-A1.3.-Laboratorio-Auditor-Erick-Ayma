package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import com.google.android.gms.internal.play_billing.i0;
import d.u0;
import i.a;
import java.io.File;
import z0.d;
/* loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
            i0.U(context, new a(2), new u0(26, this), true);
        } else if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                if (!"WRITE_SKIP_FILE".equals(string)) {
                    if ("DELETE_SKIP_FILE".equals(string)) {
                        u0 u0Var = new u0(26, this);
                        new File(context.getFilesDir(), "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
                        new z0.a(11, 1, u0Var, null).run();
                        return;
                    }
                    return;
                }
                u0 u0Var2 = new u0(26, this);
                try {
                    i0.I(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
                    new z0.a(10, 1, u0Var2, null).run();
                } catch (PackageManager.NameNotFoundException e5) {
                    new z0.a(7, 1, u0Var2, e5).run();
                }
            }
        } else {
            boolean equals = "androidx.profileinstaller.action.SAVE_PROFILE".equals(action);
            d dVar = i0.f1894k;
            if (equals) {
                Process.sendSignal(Process.myPid(), 10);
                dVar.n(12, null);
                setResultCode(12);
            } else if (!"androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) || (extras = intent.getExtras()) == null) {
            } else {
                if (!"DROP_SHADER_CACHE".equals(extras.getString("EXTRA_BENCHMARK_OPERATION"))) {
                    dVar.n(16, null);
                    setResultCode(16);
                } else if (i0.t(context.createDeviceProtectedStorageContext().getCodeCacheDir())) {
                    dVar.n(14, null);
                    setResultCode(14);
                } else {
                    dVar.n(15, null);
                    setResultCode(15);
                }
            }
        }
    }
}

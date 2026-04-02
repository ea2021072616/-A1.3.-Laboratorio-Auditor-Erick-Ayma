package pub.devrel.easypermissions.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
/* compiled from: ActivityPermissionHelper.java */
/* loaded from: classes2.dex */
class a extends b<Activity> {
    public a(Activity activity) {
        super(activity);
    }

    @Override // pub.devrel.easypermissions.a.b
    @SuppressLint({"NewApi"})
    public FragmentManager a() {
        return c().getFragmentManager();
    }

    @Override // pub.devrel.easypermissions.a.f
    public void a(int i, @NonNull String... strArr) {
        ActivityCompat.requestPermissions(c(), strArr, i);
    }

    @Override // pub.devrel.easypermissions.a.f
    public boolean a(@NonNull String str) {
        return ActivityCompat.shouldShowRequestPermissionRationale(c(), str);
    }

    @Override // pub.devrel.easypermissions.a.f
    public Context b() {
        return c();
    }
}

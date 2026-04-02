package pub.devrel.easypermissions.a;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
/* compiled from: FrameworkFragmentPermissionHelper.java */
/* loaded from: classes2.dex */
class d extends b<Fragment> {
    public d(@NonNull Fragment fragment) {
        super(fragment);
    }

    @Override // pub.devrel.easypermissions.a.b
    @RequiresApi(api = 17)
    public FragmentManager a() {
        return c().getChildFragmentManager();
    }

    @Override // pub.devrel.easypermissions.a.f
    @SuppressLint({"NewApi"})
    public void a(int i, @NonNull String... strArr) {
        c().requestPermissions(strArr, i);
    }

    @Override // pub.devrel.easypermissions.a.f
    @SuppressLint({"NewApi"})
    public boolean a(@NonNull String str) {
        return c().shouldShowRequestPermissionRationale(str);
    }

    @Override // pub.devrel.easypermissions.a.f
    @SuppressLint({"NewApi"})
    public Context b() {
        return c().getActivity();
    }
}

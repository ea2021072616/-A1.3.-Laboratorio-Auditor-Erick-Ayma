package pub.devrel.easypermissions.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
/* compiled from: SupportFragmentPermissionHelper.java */
/* loaded from: classes2.dex */
class g extends c<Fragment> {
    public g(@NonNull Fragment fragment) {
        super(fragment);
    }

    @Override // pub.devrel.easypermissions.a.c
    public FragmentManager a() {
        return c().getChildFragmentManager();
    }

    @Override // pub.devrel.easypermissions.a.f
    public void a(int i, @NonNull String... strArr) {
        c().requestPermissions(strArr, i);
    }

    @Override // pub.devrel.easypermissions.a.f
    public boolean a(@NonNull String str) {
        return c().shouldShowRequestPermissionRationale(str);
    }

    @Override // pub.devrel.easypermissions.a.f
    public Context b() {
        return c().getActivity();
    }
}

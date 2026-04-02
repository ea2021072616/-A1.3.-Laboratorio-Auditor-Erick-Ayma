package pub.devrel.easypermissions.a;

import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
/* compiled from: BaseFrameworkPermissionsHelper.java */
/* loaded from: classes2.dex */
public abstract class b<T> extends f<T> {
    public abstract FragmentManager a();

    public b(@NonNull T t) {
        super(t);
    }

    @Override // pub.devrel.easypermissions.a.f
    @RequiresApi(api = 11)
    public void a(@NonNull String str, int i, int i2, int i3, @NonNull String... strArr) {
        pub.devrel.easypermissions.e.a(i, i2, str, i3, strArr).show(a(), "RationaleDialogFragment");
    }
}

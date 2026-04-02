package pub.devrel.easypermissions.a;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
/* compiled from: BaseSupportPermissionsHelper.java */
/* loaded from: classes2.dex */
public abstract class c<T> extends f<T> {
    public abstract FragmentManager a();

    public c(@NonNull T t) {
        super(t);
    }

    @Override // pub.devrel.easypermissions.a.f
    @SuppressLint({"NewApi"})
    public void a(@NonNull String str, int i, int i2, int i3, @NonNull String... strArr) {
        pub.devrel.easypermissions.f.a(i, i2, str, i3, strArr).show(a(), "RationaleDialogFragmentCompat");
    }
}

package pub.devrel.easypermissions.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
/* compiled from: LowApiPermissionsHelper.java */
/* loaded from: classes2.dex */
class e extends f<Object> {
    public e(@NonNull Object obj) {
        super(obj);
    }

    @Override // pub.devrel.easypermissions.a.f
    public void a(int i, @NonNull String... strArr) {
        throw new IllegalStateException("Should never be requesting permissions on API < 23!");
    }

    @Override // pub.devrel.easypermissions.a.f
    public boolean a(@NonNull String str) {
        return false;
    }

    @Override // pub.devrel.easypermissions.a.f
    @SuppressLint({"NewApi"})
    public void a(@NonNull String str, int i, int i2, int i3, @NonNull String... strArr) {
        throw new IllegalStateException("Should never be requesting permissions on API < 23!");
    }

    @Override // pub.devrel.easypermissions.a.f
    public Context b() {
        return null;
    }
}

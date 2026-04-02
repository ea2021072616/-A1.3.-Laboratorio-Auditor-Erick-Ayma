package pub.devrel.easypermissions.a;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import java.util.List;
/* compiled from: PermissionHelper.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public abstract class f<T> {

    /* renamed from: a  reason: collision with root package name */
    private T f5206a;

    public abstract void a(int i, @NonNull String... strArr);

    public abstract void a(@NonNull String str, @StringRes int i, @StringRes int i2, int i3, @NonNull String... strArr);

    public abstract boolean a(@NonNull String str);

    public abstract Context b();

    @NonNull
    public static f a(Activity activity) {
        return Build.VERSION.SDK_INT < 23 ? new e(activity) : new a(activity);
    }

    @NonNull
    public static f a(Fragment fragment) {
        return Build.VERSION.SDK_INT < 23 ? new e(fragment) : new g(fragment);
    }

    @NonNull
    public static f a(android.app.Fragment fragment) {
        return Build.VERSION.SDK_INT < 23 ? new e(fragment) : new d(fragment);
    }

    public f(@NonNull T t) {
        this.f5206a = t;
    }

    public boolean a(@NonNull String... strArr) {
        for (String str : strArr) {
            if (a(str)) {
                return true;
            }
        }
        return false;
    }

    public void b(@NonNull String str, @StringRes int i, @StringRes int i2, int i3, @NonNull String... strArr) {
        if (a(strArr)) {
            a(str, i, i2, i3, strArr);
        } else {
            a(i3, strArr);
        }
    }

    public boolean a(@NonNull List<String> list) {
        for (String str : list) {
            if (b(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean b(@NonNull String str) {
        return !a(str);
    }

    @NonNull
    public T c() {
        return this.f5206a;
    }
}

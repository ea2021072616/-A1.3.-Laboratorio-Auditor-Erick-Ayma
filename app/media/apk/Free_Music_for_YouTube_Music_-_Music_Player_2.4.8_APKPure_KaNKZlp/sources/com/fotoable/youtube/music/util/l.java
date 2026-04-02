package com.fotoable.youtube.music.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import com.fotoable.youtube.music.MusicApplication;
/* compiled from: PermissionUtils.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static l f4883a;

    /* renamed from: b  reason: collision with root package name */
    private String[] f4884b;

    /* renamed from: c  reason: collision with root package name */
    private a f4885c;

    /* compiled from: PermissionUtils.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();

        void c();

        void d();
    }

    public static l a() {
        if (f4883a == null) {
            synchronized (l.class) {
                if (f4883a == null) {
                    f4883a = new l();
                }
            }
        }
        return f4883a;
    }

    public boolean a(@NonNull String str) {
        return Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(MusicApplication.c(), str) == 0;
    }

    public void a(@NonNull Activity activity, @NonNull String[] strArr, @IntRange(from = 0) int i, a aVar) {
        this.f4885c = aVar;
        this.f4884b = strArr;
        ActivityCompat.requestPermissions(activity, strArr, i);
    }

    public void a(@NonNull Fragment fragment, @NonNull String[] strArr, @IntRange(from = 0) int i, a aVar) {
        this.f4885c = aVar;
        this.f4884b = strArr;
        fragment.requestPermissions(strArr, i);
    }

    public void a(@NonNull Activity activity, int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.f4885c != null) {
            if (i == 0 && iArr.length > 0 && iArr.length > 0 && iArr[0] == 0) {
                this.f4885c.a();
            } else if (strArr.length > 0) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity, strArr[0])) {
                    this.f4885c.b();
                } else {
                    this.f4885c.c();
                }
            }
        }
    }

    public void a(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (this.f4885c != null) {
                    if (this.f4884b != null && this.f4884b.length > 0) {
                        for (String str : this.f4884b) {
                            if (a(str)) {
                                this.f4885c.a();
                            } else {
                                this.f4885c.d();
                            }
                        }
                        return;
                    }
                    this.f4885c.d();
                    return;
                }
                return;
            default:
                return;
        }
    }
}

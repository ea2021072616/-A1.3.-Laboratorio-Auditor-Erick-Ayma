package com.yanzhenjie.durban;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
/* compiled from: Durban.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static b f5135a;

    /* renamed from: b  reason: collision with root package name */
    private Object f5136b;

    /* renamed from: c  reason: collision with root package name */
    private Intent f5137c;

    public static void a(b bVar) {
        f5135a = bVar;
    }

    public static b a() {
        if (f5135a == null) {
            a(b.a(null).a(Locale.getDefault()).a());
        }
        return f5135a;
    }

    public static a a(Activity activity) {
        return new a(activity);
    }

    private a(Object obj) {
        this.f5136b = obj;
        this.f5137c = new Intent(a(obj), DurbanActivity.class);
    }

    public a a(@ColorInt int i) {
        this.f5137c.putExtra("AlbumCrop.KEY_INPUT_STATUS_COLOR", i);
        return this;
    }

    public a b(@ColorInt int i) {
        this.f5137c.putExtra("AlbumCrop.KEY_INPUT_TOOLBAR_COLOR", i);
        return this;
    }

    public a c(@ColorInt int i) {
        this.f5137c.putExtra("AlbumCrop.KEY_INPUT_NAVIGATION_COLOR", i);
        return this;
    }

    public a a(String str) {
        this.f5137c.putExtra("AlbumCrop.KEY_INPUT_TITLE", str);
        return this;
    }

    public a d(int i) {
        this.f5137c.putExtra("AlbumCrop.KEY_INPUT_GESTURE", i);
        return this;
    }

    public a a(float f, float f2) {
        this.f5137c.putExtra("AlbumCrop.KEY_INPUT_ASPECT_RATIO", new float[]{f, f2});
        return this;
    }

    public a a(@IntRange(from = 100) int i, @IntRange(from = 100) int i2) {
        this.f5137c.putExtra("AlbumCrop.KEY_INPUT_MAX_WIDTH_HEIGHT", new int[]{i, i2});
        return this;
    }

    public a e(int i) {
        this.f5137c.putExtra("AlbumCrop.KEY_INPUT_COMPRESS_FORMAT", i);
        return this;
    }

    public a f(int i) {
        this.f5137c.putExtra("AlbumCrop.KEY_INPUT_COMPRESS_QUALITY", i);
        return this;
    }

    public a b(String str) {
        this.f5137c.putExtra("AlbumCrop.KEY_INPUT_DIRECTORY", str);
        return this;
    }

    public a a(String... strArr) {
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, strArr);
        this.f5137c.putStringArrayListExtra("AlbumCrop.KEY_INPUT_PATH_ARRAY", arrayList);
        return this;
    }

    public a a(Controller controller) {
        this.f5137c.putExtra("AlbumCrop.KEY_INPUT_CONTROLLER", controller);
        return this;
    }

    public a g(int i) {
        this.f5137c.putExtra("requestCode", i);
        return this;
    }

    public void b() {
        try {
            Method method = this.f5136b.getClass().getMethod("startActivityForResult", Intent.class, Integer.TYPE);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(this.f5136b, this.f5137c, Integer.valueOf(this.f5137c.getIntExtra("requestCode", 1)));
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public static ArrayList<String> a(@NonNull Intent intent) {
        return intent.getStringArrayListExtra("AlbumCrop.KEY_OUTPUT_IMAGE_LIST");
    }

    @NonNull
    protected static Context a(Object obj) {
        if (obj instanceof Activity) {
            return (Context) obj;
        }
        if (obj instanceof Fragment) {
            return ((Fragment) obj).getContext();
        }
        if (obj instanceof android.app.Fragment) {
            ((android.app.Fragment) obj).getActivity();
        }
        throw new IllegalArgumentException(obj.getClass() + " is not supported.");
    }
}

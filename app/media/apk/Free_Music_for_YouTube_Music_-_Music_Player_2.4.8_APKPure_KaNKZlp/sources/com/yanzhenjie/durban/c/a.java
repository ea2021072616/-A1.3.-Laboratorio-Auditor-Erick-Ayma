package com.yanzhenjie.durban.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yanzhenjie.durban.d.f;
import com.yanzhenjie.durban.d.g;
import com.yanzhenjie.durban.model.c;
import com.yanzhenjie.loading.dialog.LoadingDialog;
import java.io.File;
import java.io.FileOutputStream;
/* compiled from: BitmapCropTask.java */
/* loaded from: classes2.dex */
public class a extends AsyncTask<Void, Void, C0102a> {

    /* renamed from: a  reason: collision with root package name */
    private LoadingDialog f5140a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f5141b;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f5142c;
    private final RectF d;
    private float e;
    private float f;
    private final int g;
    private final int h;
    private final Bitmap.CompressFormat i;
    private final int j;
    private final String k;
    private final String l;
    private final com.yanzhenjie.durban.a.a m;
    private int n;
    private int o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BitmapCropTask.java */
    /* renamed from: com.yanzhenjie.durban.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0102a {

        /* renamed from: a  reason: collision with root package name */
        final String f5143a;

        /* renamed from: b  reason: collision with root package name */
        final Exception f5144b;

        C0102a(String str, Exception exc) {
            this.f5143a = str;
            this.f5144b = exc;
        }
    }

    public a(@NonNull Context context, @Nullable Bitmap bitmap, @NonNull c cVar, @NonNull com.yanzhenjie.durban.model.a aVar, @Nullable com.yanzhenjie.durban.a.a aVar2) {
        this.f5140a = new LoadingDialog(context);
        this.f5141b = bitmap;
        this.f5142c = cVar.a();
        this.d = cVar.b();
        this.e = cVar.c();
        this.f = cVar.d();
        this.g = aVar.a();
        this.h = aVar.b();
        this.i = aVar.c();
        this.j = aVar.d();
        this.k = aVar.e();
        this.l = aVar.f();
        this.m = aVar2;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        if (!this.f5140a.isShowing()) {
            this.f5140a.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(C0102a c0102a) {
        if (this.f5140a.isShowing()) {
            this.f5140a.dismiss();
        }
        if (this.m != null) {
            if (c0102a.f5144b == null) {
                this.m.a(c0102a.f5143a, this.n, this.o);
            } else {
                this.m.a(c0102a.f5144b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public C0102a doInBackground(Void... voidArr) {
        try {
            return new C0102a(a(), null);
        } catch (Exception e) {
            return new C0102a(null, e);
        }
    }

    private String a() throws Exception {
        FileOutputStream fileOutputStream;
        f.a(this.l);
        String absolutePath = new File(this.l, f.a(this.i)).getAbsolutePath();
        if (this.g > 0 && this.h > 0) {
            float width = this.f5142c.width() / this.e;
            float height = this.f5142c.height() / this.e;
            if (width > this.g || height > this.h) {
                float min = Math.min(this.g / width, this.h / height);
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(this.f5141b, Math.round(this.f5141b.getWidth() * min), Math.round(this.f5141b.getHeight() * min), false);
                if (this.f5141b != createScaledBitmap) {
                    this.f5141b.recycle();
                }
                this.f5141b = createScaledBitmap;
                this.e /= min;
            }
        }
        if (this.f != 0.0f) {
            Matrix matrix = new Matrix();
            matrix.setRotate(this.f, this.f5141b.getWidth() / 2, this.f5141b.getHeight() / 2);
            Bitmap createBitmap = Bitmap.createBitmap(this.f5141b, 0, 0, this.f5141b.getWidth(), this.f5141b.getHeight(), matrix, true);
            if (this.f5141b != createBitmap) {
                this.f5141b.recycle();
            }
            this.f5141b = createBitmap;
        }
        int round = Math.round((this.f5142c.left - this.d.left) / this.e);
        int round2 = Math.round((this.f5142c.top - this.d.top) / this.e);
        this.n = Math.round(this.f5142c.width() / this.e);
        this.o = Math.round(this.f5142c.height() / this.e);
        if (a(this.n, this.o)) {
            Bitmap createBitmap2 = Bitmap.createBitmap(this.f5141b, round, round2, this.n, this.o);
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(absolutePath);
                try {
                    try {
                        createBitmap2.compress(this.i, this.j, fileOutputStream);
                        createBitmap2.recycle();
                        f.a(fileOutputStream);
                        if (this.i.equals(Bitmap.CompressFormat.JPEG)) {
                            g.a(new ExifInterface(this.k), this.n, this.o, absolutePath);
                        }
                    } catch (Exception e) {
                        throw new com.yanzhenjie.durban.b.a("");
                    }
                } catch (Throwable th) {
                    fileOutputStream2 = fileOutputStream;
                    th = th;
                    createBitmap2.recycle();
                    f.a(fileOutputStream2);
                    throw th;
                }
            } catch (Exception e2) {
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                createBitmap2.recycle();
                f.a(fileOutputStream2);
                throw th;
            }
        } else {
            f.a(this.k, absolutePath);
        }
        if (this.f5141b != null && !this.f5141b.isRecycled()) {
            this.f5141b.recycle();
        }
        return absolutePath;
    }

    private boolean a(int i, int i2) {
        int round = Math.round(Math.max(i, i2) / 1000.0f) + 1;
        return (this.g > 0 && this.h > 0) || Math.abs(this.f5142c.left - this.d.left) > ((float) round) || Math.abs(this.f5142c.top - this.d.top) > ((float) round) || Math.abs(this.f5142c.bottom - this.d.bottom) > ((float) round) || Math.abs(this.f5142c.right - this.d.right) > ((float) round);
    }
}

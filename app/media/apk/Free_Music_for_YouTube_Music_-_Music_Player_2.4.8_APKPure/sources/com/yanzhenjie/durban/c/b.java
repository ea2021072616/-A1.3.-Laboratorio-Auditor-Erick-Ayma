package com.yanzhenjie.durban.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import com.yanzhenjie.loading.dialog.LoadingDialog;
/* compiled from: BitmapLoadTask.java */
/* loaded from: classes2.dex */
public class b extends AsyncTask<String, Void, a> {

    /* renamed from: a  reason: collision with root package name */
    private final LoadingDialog f5145a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5146b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5147c;
    private final com.yanzhenjie.durban.a.b d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BitmapLoadTask.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Bitmap f5148a;

        /* renamed from: b  reason: collision with root package name */
        final com.yanzhenjie.durban.model.b f5149b;

        a(Bitmap bitmap, com.yanzhenjie.durban.model.b bVar) {
            this.f5148a = bitmap;
            this.f5149b = bVar;
        }
    }

    public b(Context context, int i, int i2, com.yanzhenjie.durban.a.b bVar) {
        this.f5145a = new LoadingDialog(context);
        this.f5146b = i;
        this.f5147c = i2;
        this.d = bVar;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        if (!this.f5145a.isShowing()) {
            this.f5145a.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(@NonNull a aVar) {
        if (this.f5145a.isShowing()) {
            this.f5145a.dismiss();
        }
        if (aVar.f5148a == null) {
            this.d.a();
        } else {
            this.d.a(aVar.f5148a, aVar.f5149b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public a doInBackground(String... strArr) {
        Bitmap bitmap = null;
        boolean z = false;
        String str = strArr[0];
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            return new a(null, null);
        }
        options.inSampleSize = com.yanzhenjie.durban.d.a.a(options, this.f5146b, this.f5147c);
        options.inJustDecodeBounds = false;
        while (!z) {
            try {
                bitmap = BitmapFactory.decodeFile(str, options);
                z = true;
            } catch (Throwable th) {
                options.inSampleSize *= 2;
            }
        }
        int a2 = com.yanzhenjie.durban.d.a.a(str);
        int a3 = com.yanzhenjie.durban.d.a.a(a2);
        int b2 = com.yanzhenjie.durban.d.a.b(a2);
        com.yanzhenjie.durban.model.b bVar = new com.yanzhenjie.durban.model.b(a2, a3, b2);
        Matrix matrix = new Matrix();
        if (a3 != 0) {
            matrix.preRotate(a3);
        }
        if (b2 != 1) {
            matrix.postScale(b2, 1.0f);
        }
        if (!matrix.isIdentity()) {
            return new a(com.yanzhenjie.durban.d.a.a(bitmap, matrix), bVar);
        }
        return new a(bitmap, bVar);
    }
}

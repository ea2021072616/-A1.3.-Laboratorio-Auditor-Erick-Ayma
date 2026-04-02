package com.facebook.ads.internal.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class p extends AsyncTask<String, Void, Bitmap[]> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1553a = p.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f1554b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<ImageView> f1555c;
    private final WeakReference<com.facebook.ads.internal.view.e> d;
    private q e;

    public p(ImageView imageView) {
        this.f1554b = new WeakReference<>(imageView.getContext());
        this.d = null;
        this.f1555c = new WeakReference<>(imageView);
    }

    public p(com.facebook.ads.internal.view.e eVar) {
        this.f1554b = new WeakReference<>(eVar.getContext());
        this.d = new WeakReference<>(eVar);
        this.f1555c = null;
    }

    public p a(q qVar) {
        this.e = qVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap[] bitmapArr) {
        com.facebook.ads.internal.view.e eVar;
        ImageView imageView;
        if (this.f1555c != null && (imageView = this.f1555c.get()) != null) {
            imageView.setImageBitmap(bitmapArr[0]);
        }
        if (this.d != null && (eVar = this.d.get()) != null) {
            eVar.a(bitmapArr[0], bitmapArr[1]);
        }
        if (this.e != null) {
            this.e.a();
        }
    }

    public void a(String... strArr) {
        executeOnExecutor(THREAD_POOL_EXECUTOR, strArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b */
    public Bitmap[] doInBackground(String... strArr) {
        Throwable th;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        String str = strArr[0];
        Context context = this.f1554b.get();
        if (context == null) {
            return new Bitmap[]{null, null};
        }
        try {
            bitmap = com.facebook.ads.internal.c.c.a(context).a(str);
            try {
            } catch (Throwable th2) {
                th = th2;
                bitmap2 = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bitmap = null;
            bitmap2 = null;
        }
        if (this.d != null) {
            if (this.d.get() != null && bitmap != null) {
                try {
                    ac acVar = new ac(bitmap);
                    acVar.a(Math.round(bitmap.getWidth() / 40.0f));
                    bitmap2 = acVar.a();
                    bitmap3 = bitmap;
                } catch (Throwable th4) {
                    th = th4;
                    bitmap2 = bitmap;
                    Log.e(f1553a, "Error downloading image: " + str, th);
                    c.a(b.a(th, null));
                    bitmap3 = bitmap;
                    return new Bitmap[]{bitmap3, bitmap2};
                }
                return new Bitmap[]{bitmap3, bitmap2};
            }
        }
        bitmap2 = null;
        bitmap3 = bitmap;
        return new Bitmap[]{bitmap3, bitmap2};
    }
}

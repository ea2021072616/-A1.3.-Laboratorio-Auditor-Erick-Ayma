package com.airbnb.lottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import junit.framework.Assert;
/* compiled from: ImageAssetBitmapManager.java */
/* loaded from: classes.dex */
class an {

    /* renamed from: a  reason: collision with root package name */
    private final Context f401a;

    /* renamed from: b  reason: collision with root package name */
    private String f402b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private ao f403c;
    private final Map<String, ay> d;
    private final Map<String, Bitmap> e = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(Drawable.Callback callback, String str, ao aoVar, Map<String, ay> map) {
        Assert.assertNotNull(callback);
        this.f402b = str;
        if (!TextUtils.isEmpty(str) && this.f402b.charAt(this.f402b.length() - 1) != '/') {
            this.f402b += '/';
        }
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.d = new HashMap();
            this.f401a = null;
            return;
        }
        this.f401a = ((View) callback).getContext();
        this.d = map;
        a(aoVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@Nullable ao aoVar) {
        this.f403c = aoVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Bitmap a(String str) {
        Bitmap bitmap = this.e.get(str);
        if (bitmap == null) {
            ay ayVar = this.d.get(str);
            if (ayVar == null) {
                return null;
            }
            if (this.f403c != null) {
                Bitmap a2 = this.f403c.a(ayVar);
                this.e.put(str, a2);
                return a2;
            }
            try {
                if (TextUtils.isEmpty(this.f402b)) {
                    throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
                }
                InputStream open = this.f401a.getAssets().open(this.f402b + ayVar.b());
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inDensity = 160;
                Bitmap decodeStream = BitmapFactory.decodeStream(open, null, options);
                this.e.put(str, decodeStream);
                return decodeStream;
            } catch (IOException e) {
                Log.w("LOTTIE", "Unable to open asset.", e);
                return null;
            }
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        Iterator<Map.Entry<String, Bitmap>> it = this.e.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().recycle();
            it.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Context context) {
        return (context == null && this.f401a == null) || (context != null && this.f401a.equals(context));
    }
}

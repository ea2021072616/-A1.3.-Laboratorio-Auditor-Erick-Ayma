package com.facebook.ads.internal.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
/* loaded from: classes.dex */
public class t {
    public static Bitmap a(Context context, r rVar) {
        byte[] decode = Base64.decode(rVar.a(context.getResources().getDisplayMetrics().density), 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static Drawable b(Context context, r rVar) {
        return new BitmapDrawable(context.getResources(), a(context, rVar));
    }
}

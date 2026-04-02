package com.fotoable.youtube.music.helper;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;
import com.bumptech.glide.i;
import com.fotoable.free.music.R;
/* compiled from: ImageLoader.java */
/* loaded from: classes.dex */
public class d {
    public static void a(Context context, String str, ImageView imageView) {
        i.c(context).a(str).b(com.bumptech.glide.load.b.b.ALL).a(imageView);
    }

    public static void a(Context context, int i, ImageView imageView) {
        i.c(context).a(Integer.valueOf(i)).b(com.bumptech.glide.load.b.b.ALL).a(imageView);
    }

    public static void a(Context context, String str, ImageView imageView, @DrawableRes int i) {
        i.c(context).a(str).b(com.bumptech.glide.load.b.b.ALL).d(i).a(imageView);
    }

    public static void b(Context context, String str, ImageView imageView) {
        i.c(context).a(str).b(com.bumptech.glide.load.b.b.ALL).d((int) R.mipmap.loadingbg).a(new b(context, 25, 5)).a(imageView);
    }
}

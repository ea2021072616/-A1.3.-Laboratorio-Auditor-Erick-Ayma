package com.fotoable.youtube.music.ui.adapter.holder;

import android.support.annotation.LayoutRes;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes.dex */
public @interface HolderItem {
    @LayoutRes
    int value();
}

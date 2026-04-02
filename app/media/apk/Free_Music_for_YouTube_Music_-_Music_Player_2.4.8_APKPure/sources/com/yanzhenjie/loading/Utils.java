package com.yanzhenjie.loading;

import android.content.Context;
/* loaded from: classes2.dex */
public class Utils {
    public static float dip2px(Context context, float f) {
        return (float) ((context.getResources().getDisplayMetrics().density + 0.5d) * f);
    }

    public static float px2dip(Context context, int i) {
        return (float) (i / (context.getResources().getDisplayMetrics().density + 0.5d));
    }
}

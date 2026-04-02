package com.fotoable.youtube.music.util;

import android.view.View;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* compiled from: PopupWindowUtil.java */
/* loaded from: classes.dex */
public class n {
    public static int[] a(View view, View view2) {
        int[] iArr = new int[2];
        try {
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr2);
            int height = view.getHeight();
            int a2 = t.a(view.getContext());
            int b2 = t.b(view.getContext());
            view2.measure(0, 0);
            int measuredHeight = view2.getMeasuredHeight();
            int measuredWidth = view2.getMeasuredWidth();
            if ((a2 - iArr2[1]) - height < measuredHeight) {
                iArr[0] = b2 - measuredWidth;
                iArr[1] = iArr2[1] - measuredHeight;
            } else {
                iArr[0] = b2 - measuredWidth;
                iArr[1] = iArr2[1] + height;
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        return iArr;
    }
}

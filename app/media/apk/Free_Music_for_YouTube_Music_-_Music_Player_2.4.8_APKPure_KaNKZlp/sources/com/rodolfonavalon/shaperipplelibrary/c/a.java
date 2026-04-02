package com.rodolfonavalon.shaperipplelibrary.c;

import android.content.Context;
import android.graphics.Color;
import java.util.ArrayList;
/* compiled from: ShapePulseUtil.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f5122a = {Color.parseColor("#673AB7"), Color.parseColor("#3F51B5"), Color.parseColor("#2196F3"), Color.parseColor("#03A9F4"), Color.parseColor("#00BCD4"), Color.parseColor("#009688"), Color.parseColor("#8BC34A"), Color.parseColor("#4CAF50"), Color.parseColor("#FF5722"), Color.parseColor("#F44336")};

    public static int a(float f, int i, int i2) {
        int i3 = (i >> 24) & 255;
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = i & 255;
        return ((i3 + ((int) ((((i2 >> 24) & 255) - i3) * f))) << 24) | ((i4 + ((int) ((((i2 >> 16) & 255) - i4) * f))) << 16) | ((((int) ((((i2 >> 8) & 255) - i5) * f)) + i5) << 8) | (((int) (((i2 & 255) - i6) * f)) + i6);
    }

    public static ArrayList<Integer> a(Context context) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : f5122a) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }
}

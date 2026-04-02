package com.yanzhenjie.album.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PermissionUtils {
    public static String[] getDeniedPermissions(Context context, @NonNull String... strArr) {
        ArrayList arrayList = new ArrayList(2);
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean isGrantedResult(int... iArr) {
        for (int i : iArr) {
            if (i == -1) {
                return false;
            }
        }
        return true;
    }
}

package w;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashSet;
/* loaded from: classes.dex */
public abstract class h extends p2.a {
    public static void c0(Activity activity, String[] strArr, int i5) {
        HashSet hashSet = new HashSet();
        for (int i6 = 0; i6 < strArr.length; i6++) {
            if (TextUtils.isEmpty(strArr[i6])) {
                throw new IllegalArgumentException(androidx.appcompat.widget.b0.i(new StringBuilder("Permission request for permissions "), Arrays.toString(strArr), " must not contain null or empty values"));
            }
            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i6], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i6));
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < strArr.length; i8++) {
                if (!hashSet.contains(Integer.valueOf(i8))) {
                    strArr2[i7] = strArr[i8];
                    i7++;
                }
            }
        }
        if (activity instanceof f) {
            ((f) activity).validateRequestPermissionsRequestCode(i5);
        }
        b.b(activity, strArr, i5);
    }

    public static boolean d0(Activity activity, String str) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return i5 >= 32 ? d.a(activity, str) : i5 == 31 ? c.b(activity, str) : b.c(activity, str);
        }
        return false;
    }
}

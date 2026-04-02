package b;

import android.content.Intent;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.activity.ComponentActivity;
import androidx.recyclerview.widget.b0;
import b4.g;
import b4.i;
import e4.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import w.c0;
import w.d0;
/* loaded from: classes.dex */
public final class b extends a {
    @Override // b.a
    public final Intent a(ComponentActivity componentActivity, Object obj) {
        String[] strArr = (String[]) obj;
        e.f(componentActivity, "context");
        e.f(strArr, "input");
        Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
        e.e(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
        return putExtra;
    }

    @Override // b.a
    public final b0 b(ComponentActivity componentActivity, Object obj) {
        String[] strArr = (String[]) obj;
        e.f(componentActivity, "context");
        e.f(strArr, "input");
        boolean z4 = true;
        if (strArr.length == 0) {
            return new b0(g.f1660b);
        }
        int length = strArr.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                break;
            }
            String str = strArr[i5];
            if (str == null) {
                throw new NullPointerException("permission must be non-null");
            }
            if (!(((Build.VERSION.SDK_INT >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) ? componentActivity.checkPermission(str, Process.myPid(), Process.myUid()) : c0.a(new d0(componentActivity).f5247a) ? 0 : -1) == 0)) {
                z4 = false;
                break;
            }
            i5++;
        }
        if (z4) {
            int H = p2.a.H(strArr.length);
            if (H < 16) {
                H = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(H);
            for (String str2 : strArr) {
                linkedHashMap.put(str2, Boolean.TRUE);
            }
            return new b0(linkedHashMap);
        }
        return null;
    }

    @Override // b.a
    public final Object c(Intent intent, int i5) {
        g gVar = g.f1660b;
        if (i5 == -1 && intent != null) {
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra == null || stringArrayExtra == null) {
                return gVar;
            }
            ArrayList arrayList = new ArrayList(intArrayExtra.length);
            for (int i6 : intArrayExtra) {
                arrayList.add(Boolean.valueOf(i6 == 0));
            }
            ArrayList arrayList2 = new ArrayList();
            for (String str : stringArrayExtra) {
                if (str != null) {
                    arrayList2.add(str);
                }
            }
            Iterator it = arrayList2.iterator();
            Iterator it2 = arrayList.iterator();
            ArrayList arrayList3 = new ArrayList(Math.min(arrayList2.size(), arrayList.size()));
            while (it.hasNext() && it2.hasNext()) {
                arrayList3.add(new a4.a(it.next(), it2.next()));
            }
            return i.c0(arrayList3);
        }
        return gVar;
    }
}

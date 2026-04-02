package i2;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3392a;

    static {
        AtomicBoolean atomicBoolean = g.f3394a;
        f3392a = 12451000;
    }

    public Intent a(int i5, Context context, String str) {
        if (i5 != 1 && i5 != 2) {
            if (i5 != 3) {
                return null;
            }
            Uri fromParts = Uri.fromParts("package", "com.google.android.gms", null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(fromParts);
            return intent;
        } else if (context != null && b4.j.C(context)) {
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        } else {
            StringBuilder sb = new StringBuilder("gcore_");
            sb.append(f3392a);
            sb.append("-");
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
            }
            sb.append("-");
            if (context != null) {
                sb.append(context.getPackageName());
            }
            sb.append("-");
            if (context != null) {
                try {
                    h a5 = p2.b.a(context);
                    sb.append(a5.f3397a.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            String sb2 = sb.toString();
            Intent intent3 = new Intent("android.intent.action.VIEW");
            Uri.Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
            if (!TextUtils.isEmpty(sb2)) {
                appendQueryParameter.appendQueryParameter("pcampaignid", sb2);
            }
            intent3.setData(appendQueryParameter.build());
            intent3.setPackage("com.android.vending");
            intent3.addFlags(524288);
            return intent3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01e9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01ea A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int b(android.content.Context r12, int r13) {
        /*
            Method dump skipped, instructions count: 497
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.e.b(android.content.Context, int):int");
    }
}

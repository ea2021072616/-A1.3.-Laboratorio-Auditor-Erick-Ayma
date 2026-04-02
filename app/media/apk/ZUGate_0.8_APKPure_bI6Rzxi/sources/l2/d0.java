package l2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: d  reason: collision with root package name */
    public static final Uri f3780d = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* renamed from: a  reason: collision with root package name */
    public final String f3781a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3782b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f3783c;

    public d0(String str, String str2, boolean z4) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        this.f3781a = str;
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        this.f3782b = str2;
        this.f3783c = z4;
    }

    public final Intent a(Context context) {
        Bundle bundle;
        String str = this.f3781a;
        if (str != null) {
            if (this.f3783c) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("serviceActionBundleKey", str);
                try {
                    bundle = context.getContentResolver().call(f3780d, "serviceIntentCall", (String) null, bundle2);
                } catch (IllegalArgumentException e5) {
                    Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e5.toString()));
                    bundle = null;
                }
                r1 = bundle != null ? (Intent) bundle.getParcelable("serviceResponseIntentKey") : null;
                if (r1 == null) {
                    Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(str)));
                }
            }
            return r1 == null ? new Intent(str).setPackage(this.f3782b) : r1;
        }
        return new Intent().setComponent(null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d0) {
            d0 d0Var = (d0) obj;
            return b4.j.p(this.f3781a, d0Var.f3781a) && b4.j.p(this.f3782b, d0Var.f3782b) && b4.j.p(null, null) && this.f3783c == d0Var.f3783c;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3781a, this.f3782b, null, 4225, Boolean.valueOf(this.f3783c)});
    }

    public final String toString() {
        String str = this.f3781a;
        if (str != null) {
            return str;
        }
        com.google.android.gms.internal.play_billing.i0.j(null);
        throw null;
    }
}

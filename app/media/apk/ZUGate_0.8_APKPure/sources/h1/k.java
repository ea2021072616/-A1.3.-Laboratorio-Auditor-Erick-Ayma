package h1;

import android.text.TextUtils;
import androidx.appcompat.widget.r3;
import com.github.appintro.AppIntroBaseFragmentKt;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final String f3288a;

    /* renamed from: b  reason: collision with root package name */
    public final JSONObject f3289b;

    /* renamed from: c  reason: collision with root package name */
    public final String f3290c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3291d;

    /* renamed from: e  reason: collision with root package name */
    public final String f3292e;

    /* renamed from: f  reason: collision with root package name */
    public final String f3293f;

    /* renamed from: g  reason: collision with root package name */
    public final String f3294g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f3295h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList f3296i;

    public k(String str) {
        this.f3288a = str;
        JSONObject jSONObject = new JSONObject(str);
        this.f3289b = jSONObject;
        String optString = jSONObject.optString("productId");
        this.f3290c = optString;
        String optString2 = jSONObject.optString("type");
        this.f3291d = optString2;
        if (TextUtils.isEmpty(optString)) {
            throw new IllegalArgumentException("Product id cannot be empty.");
        }
        if (TextUtils.isEmpty(optString2)) {
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
        this.f3292e = jSONObject.optString(AppIntroBaseFragmentKt.ARG_TITLE);
        jSONObject.optString("name");
        jSONObject.optString("description");
        jSONObject.optString("packageDisplayName");
        jSONObject.optString("iconUrl");
        this.f3293f = jSONObject.optString("skuDetailsToken");
        this.f3294g = jSONObject.optString("serializedDocid");
        JSONArray optJSONArray = jSONObject.optJSONArray("subscriptionOfferDetails");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                arrayList.add(new r3(optJSONArray.getJSONObject(i5)));
            }
            this.f3295h = arrayList;
        } else {
            this.f3295h = (optString2.equals("subs") || optString2.equals("play_pass_subs")) ? new ArrayList() : null;
        }
        JSONObject optJSONObject = this.f3289b.optJSONObject("oneTimePurchaseOfferDetails");
        JSONArray optJSONArray2 = this.f3289b.optJSONArray("oneTimePurchaseOfferDetailsList");
        ArrayList arrayList2 = new ArrayList();
        if (optJSONArray2 != null) {
            for (int i6 = 0; i6 < optJSONArray2.length(); i6++) {
                arrayList2.add(new i(optJSONArray2.getJSONObject(i6)));
            }
            this.f3296i = arrayList2;
        } else if (optJSONObject == null) {
            this.f3296i = null;
        } else {
            arrayList2.add(new i(optJSONObject));
            this.f3296i = arrayList2;
        }
    }

    public final i a() {
        ArrayList arrayList = this.f3296i;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return (i) arrayList.get(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            return TextUtils.equals(this.f3288a, ((k) obj).f3288a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3288a.hashCode();
    }

    public final String toString() {
        String obj = this.f3289b.toString();
        String valueOf = String.valueOf(this.f3295h);
        return "ProductDetails{jsonString='" + this.f3288a + "', parsedJson=" + obj + ", productId='" + this.f3290c + "', productType='" + this.f3291d + "', title='" + this.f3292e + "', productDetailsToken='" + this.f3293f + "', subscriptionOfferDetails=" + valueOf + "}";
    }
}

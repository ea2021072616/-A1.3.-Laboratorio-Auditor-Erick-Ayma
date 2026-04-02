package com.android.billingclient.api;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class Purchase {

    /* renamed from: a  reason: collision with root package name */
    public final String f1799a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1800b;

    /* renamed from: c  reason: collision with root package name */
    public final JSONObject f1801c;

    public Purchase(String str, String str2) {
        this.f1799a = str;
        this.f1800b = str2;
        this.f1801c = new JSONObject(str);
    }

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = this.f1801c;
        if (jSONObject.has("productIds")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("productIds");
            if (optJSONArray != null) {
                for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                    arrayList.add(optJSONArray.optString(i5));
                }
            }
        } else if (jSONObject.has("productId")) {
            arrayList.add(jSONObject.optString("productId"));
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Purchase) {
            Purchase purchase = (Purchase) obj;
            return TextUtils.equals(this.f1799a, purchase.f1799a) && TextUtils.equals(this.f1800b, purchase.f1800b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1799a.hashCode();
    }

    public final String toString() {
        return "Purchase. Json: ".concat(String.valueOf(this.f1799a));
    }
}

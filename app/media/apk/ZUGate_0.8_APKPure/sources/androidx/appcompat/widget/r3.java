package androidx.appcompat.widget;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class r3 {

    /* renamed from: a  reason: collision with root package name */
    public Object f508a;

    /* renamed from: b  reason: collision with root package name */
    public Object f509b;

    /* renamed from: c  reason: collision with root package name */
    public Object f510c;

    /* renamed from: d  reason: collision with root package name */
    public Object f511d;

    /* renamed from: e  reason: collision with root package name */
    public Object f512e;

    /* renamed from: f  reason: collision with root package name */
    public Object f513f;

    /* renamed from: g  reason: collision with root package name */
    public Object f514g;

    public r3(JSONObject jSONObject) {
        this.f508a = jSONObject.optString("basePlanId");
        String optString = jSONObject.optString("offerId");
        this.f509b = true == optString.isEmpty() ? null : optString;
        this.f510c = jSONObject.getString("offerIdToken");
        this.f511d = new w0.d(jSONObject.getJSONArray("pricingPhases"));
        JSONObject optJSONObject = jSONObject.optJSONObject("installmentPlanDetails");
        this.f513f = optJSONObject == null ? null : new h0.w(optJSONObject);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("transitionPlanDetails");
        this.f514g = optJSONObject2 != null ? new x(optJSONObject2) : null;
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("offerTags");
        if (optJSONArray != null) {
            for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                arrayList.add(optJSONArray.getString(i5));
            }
        }
        this.f512e = arrayList;
    }
}

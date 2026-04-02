package h1;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class j {
    public j(JSONObject jSONObject) {
        jSONObject.optString("billingPeriod");
        jSONObject.optString("priceCurrencyCode");
        jSONObject.optString("formattedPrice");
        jSONObject.optLong("priceAmountMicros");
        jSONObject.optInt("recurrenceMode");
        jSONObject.optInt("billingCycleCount");
    }
}

package h1;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final String f3287a;

    public i(JSONObject jSONObject) {
        jSONObject.optString("formattedPrice");
        jSONObject.optLong("priceAmountMicros");
        jSONObject.optString("priceCurrencyCode");
        String optString = jSONObject.optString("offerIdToken");
        this.f3287a = true == optString.isEmpty() ? null : optString;
        jSONObject.optString("offerId").getClass();
        jSONObject.optString("purchaseOptionId").getClass();
        jSONObject.optInt("offerType");
        JSONArray optJSONArray = jSONObject.optJSONArray("offerTags");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                arrayList.add(optJSONArray.getString(i5));
            }
        }
        com.google.android.gms.internal.play_billing.f.l(arrayList);
        if (jSONObject.has("fullPriceMicros")) {
            jSONObject.optLong("fullPriceMicros");
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("discountDisplayInfo");
        if (optJSONObject != null) {
            optJSONObject.getInt("percentageDiscount");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("validTimeWindow");
        if (optJSONObject2 != null) {
            optJSONObject2.getLong("startTimeMillis");
            optJSONObject2.getLong("endTimeMillis");
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("limitedQuantityInfo");
        if (optJSONObject3 != null) {
            optJSONObject3.getInt("maximumQuantity");
            optJSONObject3.getInt("remainingQuantity");
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("preorderDetails");
        if (optJSONObject4 != null) {
            optJSONObject4.getLong("preorderReleaseTimeMillis");
            optJSONObject4.getLong("preorderPresaleEndTimeMillis");
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("rentalDetails");
        if (optJSONObject5 == null) {
            return;
        }
        optJSONObject5.getString("rentalPeriod");
        optJSONObject5.optString("rentalExpirationPeriod").getClass();
    }
}

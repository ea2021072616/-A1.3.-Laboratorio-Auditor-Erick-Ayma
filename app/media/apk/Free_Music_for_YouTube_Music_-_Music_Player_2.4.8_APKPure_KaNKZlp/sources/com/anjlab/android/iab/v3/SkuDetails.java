package com.anjlab.android.iab.v3;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SkuDetails implements Parcelable {
    public static final Parcelable.Creator<SkuDetails> CREATOR = new Parcelable.Creator<SkuDetails>() { // from class: com.anjlab.android.iab.v3.SkuDetails.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SkuDetails createFromParcel(Parcel parcel) {
            return new SkuDetails(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SkuDetails[] newArray(int i) {
            return new SkuDetails[i];
        }
    };
    public final String currency;
    public final String description;
    public final boolean haveIntroductoryPeriod;
    public final boolean haveTrialPeriod;
    public final int introductoryPriceCycles;
    public final long introductoryPriceLong;
    public final String introductoryPricePeriod;
    public final String introductoryPriceText;
    public final double introductoryPriceValue;
    public final boolean isSubscription;
    public final long priceLong;
    public final String priceText;
    public final Double priceValue;
    public final String productId;
    public final String subscriptionFreeTrialPeriod;
    public final String subscriptionPeriod;
    public final String title;

    public SkuDetails(JSONObject jSONObject) throws JSONException {
        String optString = jSONObject.optString("type");
        optString = optString == null ? "inapp" : optString;
        this.productId = jSONObject.optString("productId");
        this.title = jSONObject.optString("title");
        this.description = jSONObject.optString("description");
        this.isSubscription = optString.equalsIgnoreCase("subs");
        this.currency = jSONObject.optString("price_currency_code");
        this.priceLong = jSONObject.optLong("price_amount_micros");
        this.priceValue = Double.valueOf(this.priceLong / 1000000.0d);
        this.priceText = jSONObject.optString("price");
        this.subscriptionPeriod = jSONObject.optString("subscriptionPeriod");
        this.subscriptionFreeTrialPeriod = jSONObject.optString("freeTrialPeriod");
        this.haveTrialPeriod = !TextUtils.isEmpty(this.subscriptionFreeTrialPeriod);
        this.introductoryPriceLong = jSONObject.optLong("introductoryPriceAmountMicros");
        this.introductoryPriceValue = this.introductoryPriceLong / 1000000.0d;
        this.introductoryPriceText = jSONObject.optString("introductoryPrice");
        this.introductoryPricePeriod = jSONObject.optString("introductoryPricePeriod");
        this.haveIntroductoryPeriod = TextUtils.isEmpty(this.introductoryPricePeriod) ? false : true;
        this.introductoryPriceCycles = jSONObject.optInt("introductoryPriceCycles");
    }

    public String toString() {
        return String.format(Locale.US, "%s: %s(%s) %f in %s (%s)", this.productId, this.title, this.description, this.priceValue, this.currency, this.priceText);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SkuDetails skuDetails = (SkuDetails) obj;
        if (this.isSubscription != skuDetails.isSubscription) {
            return false;
        }
        if (this.productId != null) {
            if (this.productId.equals(skuDetails.productId)) {
                return true;
            }
        } else if (skuDetails.productId == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.productId != null ? this.productId.hashCode() : 0) * 31) + (this.isSubscription ? 1 : 0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.productId);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeByte(this.isSubscription ? (byte) 1 : (byte) 0);
        parcel.writeString(this.currency);
        parcel.writeDouble(this.priceValue.doubleValue());
        parcel.writeLong(this.priceLong);
        parcel.writeString(this.priceText);
        parcel.writeString(this.subscriptionPeriod);
        parcel.writeString(this.subscriptionFreeTrialPeriod);
        parcel.writeByte(this.haveTrialPeriod ? (byte) 1 : (byte) 0);
        parcel.writeDouble(this.introductoryPriceValue);
        parcel.writeLong(this.introductoryPriceLong);
        parcel.writeString(this.introductoryPriceText);
        parcel.writeString(this.introductoryPricePeriod);
        parcel.writeByte(this.haveIntroductoryPeriod ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.introductoryPriceCycles);
    }

    protected SkuDetails(Parcel parcel) {
        this.productId = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.isSubscription = parcel.readByte() != 0;
        this.currency = parcel.readString();
        this.priceValue = Double.valueOf(parcel.readDouble());
        this.priceLong = parcel.readLong();
        this.priceText = parcel.readString();
        this.subscriptionPeriod = parcel.readString();
        this.subscriptionFreeTrialPeriod = parcel.readString();
        this.haveTrialPeriod = parcel.readByte() != 0;
        this.introductoryPriceValue = parcel.readDouble();
        this.introductoryPriceLong = parcel.readLong();
        this.introductoryPriceText = parcel.readString();
        this.introductoryPricePeriod = parcel.readString();
        this.haveIntroductoryPeriod = parcel.readByte() != 0;
        this.introductoryPriceCycles = parcel.readInt();
    }
}

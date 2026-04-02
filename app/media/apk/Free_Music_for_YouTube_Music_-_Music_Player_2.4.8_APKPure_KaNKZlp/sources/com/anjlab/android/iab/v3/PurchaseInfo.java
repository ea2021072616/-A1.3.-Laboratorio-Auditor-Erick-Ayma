package com.anjlab.android.iab.v3;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PurchaseInfo implements Parcelable {
    public static final Parcelable.Creator<PurchaseInfo> CREATOR = new Parcelable.Creator<PurchaseInfo>() { // from class: com.anjlab.android.iab.v3.PurchaseInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PurchaseInfo createFromParcel(Parcel parcel) {
            return new PurchaseInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PurchaseInfo[] newArray(int i) {
            return new PurchaseInfo[i];
        }
    };
    private static final String LOG_TAG = "iabv3.purchaseInfo";
    public final PurchaseData purchaseData = parseResponseData();
    public final String responseData;
    public final String signature;

    public PurchaseInfo(String str, String str2) {
        this.responseData = str;
        this.signature = str2;
    }

    @Deprecated
    public PurchaseData parseResponseData() {
        try {
            JSONObject jSONObject = new JSONObject(this.responseData);
            PurchaseData purchaseData = new PurchaseData();
            purchaseData.orderId = jSONObject.optString("orderId");
            purchaseData.packageName = jSONObject.optString("packageName");
            purchaseData.productId = jSONObject.optString("productId");
            long optLong = jSONObject.optLong("purchaseTime", 0L);
            purchaseData.purchaseTime = optLong != 0 ? new Date(optLong) : null;
            purchaseData.purchaseState = d.values()[jSONObject.optInt("purchaseState", 1)];
            purchaseData.developerPayload = jSONObject.optString("developerPayload");
            purchaseData.purchaseToken = jSONObject.getString("purchaseToken");
            purchaseData.autoRenewing = jSONObject.optBoolean("autoRenewing");
            return purchaseData;
        } catch (JSONException e) {
            Log.e(LOG_TAG, "Failed to parse response data", e);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.responseData);
        parcel.writeString(this.signature);
    }

    protected PurchaseInfo(Parcel parcel) {
        this.responseData = parcel.readString();
        this.signature = parcel.readString();
    }
}

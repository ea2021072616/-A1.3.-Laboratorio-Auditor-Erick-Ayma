package com.anjlab.android.iab.v3;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
/* loaded from: classes.dex */
public class TransactionDetails implements Parcelable {
    public static final Parcelable.Creator<TransactionDetails> CREATOR = new Parcelable.Creator<TransactionDetails>() { // from class: com.anjlab.android.iab.v3.TransactionDetails.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TransactionDetails createFromParcel(Parcel parcel) {
            return new TransactionDetails(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TransactionDetails[] newArray(int i) {
            return new TransactionDetails[i];
        }
    };
    @Deprecated
    public final String orderId;
    @Deprecated
    public final String productId;
    public final PurchaseInfo purchaseInfo;
    @Deprecated
    public final Date purchaseTime;
    @Deprecated
    public final String purchaseToken;

    public TransactionDetails(PurchaseInfo purchaseInfo) throws JSONException {
        this.purchaseInfo = purchaseInfo;
        this.productId = this.purchaseInfo.purchaseData.productId;
        this.orderId = this.purchaseInfo.purchaseData.orderId;
        this.purchaseToken = this.purchaseInfo.purchaseData.purchaseToken;
        this.purchaseTime = this.purchaseInfo.purchaseData.purchaseTime;
    }

    public String toString() {
        return String.format(Locale.US, "%s purchased at %s(%s). Token: %s, Signature: %s", this.productId, this.purchaseTime, this.orderId, this.purchaseToken, this.purchaseInfo.signature);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TransactionDetails transactionDetails = (TransactionDetails) obj;
        if (this.orderId != null) {
            if (this.orderId.equals(transactionDetails.orderId)) {
                return true;
            }
        } else if (transactionDetails.orderId == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.orderId != null) {
            return this.orderId.hashCode();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.purchaseInfo, i);
    }

    protected TransactionDetails(Parcel parcel) {
        this.purchaseInfo = (PurchaseInfo) parcel.readParcelable(PurchaseInfo.class.getClassLoader());
        this.productId = this.purchaseInfo.purchaseData.productId;
        this.orderId = this.purchaseInfo.purchaseData.orderId;
        this.purchaseToken = this.purchaseInfo.purchaseData.purchaseToken;
        this.purchaseTime = this.purchaseInfo.purchaseData.purchaseTime;
    }
}

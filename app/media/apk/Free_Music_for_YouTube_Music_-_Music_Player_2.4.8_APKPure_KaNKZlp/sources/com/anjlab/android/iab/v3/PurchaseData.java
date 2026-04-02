package com.anjlab.android.iab.v3;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
/* loaded from: classes.dex */
public class PurchaseData implements Parcelable {
    public static final Parcelable.Creator<PurchaseData> CREATOR = new Parcelable.Creator<PurchaseData>() { // from class: com.anjlab.android.iab.v3.PurchaseData.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PurchaseData createFromParcel(Parcel parcel) {
            return new PurchaseData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PurchaseData[] newArray(int i) {
            return new PurchaseData[i];
        }
    };
    public boolean autoRenewing;
    public String developerPayload;
    public String orderId;
    public String packageName;
    public String productId;
    public d purchaseState;
    public Date purchaseTime;
    public String purchaseToken;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.orderId);
        parcel.writeString(this.packageName);
        parcel.writeString(this.productId);
        parcel.writeLong(this.purchaseTime != null ? this.purchaseTime.getTime() : -1L);
        parcel.writeInt(this.purchaseState == null ? -1 : this.purchaseState.ordinal());
        parcel.writeString(this.developerPayload);
        parcel.writeString(this.purchaseToken);
        parcel.writeByte(this.autoRenewing ? (byte) 1 : (byte) 0);
    }

    public PurchaseData() {
    }

    protected PurchaseData(Parcel parcel) {
        this.orderId = parcel.readString();
        this.packageName = parcel.readString();
        this.productId = parcel.readString();
        long readLong = parcel.readLong();
        this.purchaseTime = readLong == -1 ? null : new Date(readLong);
        int readInt = parcel.readInt();
        this.purchaseState = readInt != -1 ? d.values()[readInt] : null;
        this.developerPayload = parcel.readString();
        this.purchaseToken = parcel.readString();
        this.autoRenewing = parcel.readByte() != 0;
    }
}

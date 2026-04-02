package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
/* loaded from: classes.dex */
public final class DrmInitData implements Parcelable, Comparator<SchemeData> {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new Parcelable.Creator<DrmInitData>() { // from class: com.google.android.exoplayer2.drm.DrmInitData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DrmInitData createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DrmInitData[] newArray(int i) {
            return new DrmInitData[i];
        }
    };
    private int hashCode;
    public final int schemeDataCount;
    private final SchemeData[] schemeDatas;

    public DrmInitData(List<SchemeData> list) {
        this(false, (SchemeData[]) list.toArray(new SchemeData[list.size()]));
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this(true, schemeDataArr);
    }

    private DrmInitData(boolean z, SchemeData... schemeDataArr) {
        SchemeData[] schemeDataArr2 = z ? (SchemeData[]) schemeDataArr.clone() : schemeDataArr;
        Arrays.sort(schemeDataArr2, this);
        for (int i = 1; i < schemeDataArr2.length; i++) {
            if (schemeDataArr2[i - 1].uuid.equals(schemeDataArr2[i].uuid)) {
                throw new IllegalArgumentException("Duplicate data for uuid: " + schemeDataArr2[i].uuid);
            }
        }
        this.schemeDatas = schemeDataArr2;
        this.schemeDataCount = schemeDataArr2.length;
    }

    DrmInitData(Parcel parcel) {
        this.schemeDatas = (SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR);
        this.schemeDataCount = this.schemeDatas.length;
    }

    public SchemeData get(UUID uuid) {
        SchemeData[] schemeDataArr;
        for (SchemeData schemeData : this.schemeDatas) {
            if (schemeData.matches(uuid)) {
                return schemeData;
            }
        }
        return null;
    }

    public SchemeData get(int i) {
        return this.schemeDatas[i];
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.schemeDatas);
        }
        return this.hashCode;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.schemeDatas, ((DrmInitData) obj).schemeDatas);
    }

    @Override // java.util.Comparator
    public int compare(SchemeData schemeData, SchemeData schemeData2) {
        if (C.UUID_NIL.equals(schemeData.uuid)) {
            return C.UUID_NIL.equals(schemeData2.uuid) ? 0 : 1;
        }
        return schemeData.uuid.compareTo(schemeData2.uuid);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.schemeDatas, 0);
    }

    /* loaded from: classes.dex */
    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new Parcelable.Creator<SchemeData>() { // from class: com.google.android.exoplayer2.drm.DrmInitData.SchemeData.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SchemeData createFromParcel(Parcel parcel) {
                return new SchemeData(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SchemeData[] newArray(int i) {
                return new SchemeData[i];
            }
        };
        public final byte[] data;
        private int hashCode;
        public final String mimeType;
        public final boolean requiresSecureDecryption;
        private final UUID uuid;

        public SchemeData(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, false);
        }

        public SchemeData(UUID uuid, String str, byte[] bArr, boolean z) {
            this.uuid = (UUID) Assertions.checkNotNull(uuid);
            this.mimeType = (String) Assertions.checkNotNull(str);
            this.data = (byte[]) Assertions.checkNotNull(bArr);
            this.requiresSecureDecryption = z;
        }

        SchemeData(Parcel parcel) {
            this.uuid = new UUID(parcel.readLong(), parcel.readLong());
            this.mimeType = parcel.readString();
            this.data = parcel.createByteArray();
            this.requiresSecureDecryption = parcel.readByte() != 0;
        }

        public boolean matches(UUID uuid) {
            return C.UUID_NIL.equals(this.uuid) || uuid.equals(this.uuid);
        }

        public boolean equals(Object obj) {
            if (obj instanceof SchemeData) {
                if (obj != this) {
                    SchemeData schemeData = (SchemeData) obj;
                    return this.mimeType.equals(schemeData.mimeType) && Util.areEqual(this.uuid, schemeData.uuid) && Arrays.equals(this.data, schemeData.data);
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            if (this.hashCode == 0) {
                this.hashCode = (((this.uuid.hashCode() * 31) + this.mimeType.hashCode()) * 31) + Arrays.hashCode(this.data);
            }
            return this.hashCode;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.uuid.getMostSignificantBits());
            parcel.writeLong(this.uuid.getLeastSignificantBits());
            parcel.writeString(this.mimeType);
            parcel.writeByteArray(this.data);
            parcel.writeByte((byte) (this.requiresSecureDecryption ? 1 : 0));
        }
    }
}

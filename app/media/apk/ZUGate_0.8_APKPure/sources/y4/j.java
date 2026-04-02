package y4;

import android.os.Parcel;
import android.os.Parcelable;
import l2.c0;
/* loaded from: classes.dex */
public final class j implements Parcelable {

    /* renamed from: b  reason: collision with root package name */
    public int f5740b;

    /* renamed from: c  reason: collision with root package name */
    public int f5741c;

    /* renamed from: d  reason: collision with root package name */
    public int f5742d;

    /* renamed from: e  reason: collision with root package name */
    public String f5743e;

    /* renamed from: f  reason: collision with root package name */
    public int f5744f;

    /* renamed from: g  reason: collision with root package name */
    public int f5745g;

    /* renamed from: h  reason: collision with root package name */
    public final String f5746h;

    /* renamed from: i  reason: collision with root package name */
    public static final String[] f5738i = {null, "aes", "serpent", "twofish", "camallia", "kuznyechik", "twofish-aes", "serpent-twofish-aes", "kuznyechik-camellia", "serpent-camellia", "aes-kuznyechik", "camellia-serpent-kuznyechik", "twofish-kuznyechik", "aes-serpent", "aes-twofish-serpent", "serpent-twofish"};

    /* renamed from: j  reason: collision with root package name */
    public static final String[] f5739j = {null, "sha256", "sha512", "whirlpool", "ripemd160"};
    public static final Parcelable.Creator<j> CREATOR = new c0(15);

    public j(int i5, String str, int i6, int i7, String str2, int i8, int i9) {
        this.f5740b = i5;
        this.f5743e = str;
        this.f5744f = i6 % 3;
        this.f5745g = i7;
        this.f5746h = str2;
        this.f5741c = i8;
        this.f5742d = i9;
    }

    public final String a() {
        if (this.f5740b == 0) {
            return null;
        }
        String d5 = new d.e("zugPwd" + this.f5744f, this.f5746h).d(this.f5743e);
        if (d5 != null) {
            int length = d5.length();
            int i5 = this.f5745g;
            if (length > i5) {
                return d5.substring(i5);
            }
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f5740b);
        parcel.writeString(this.f5743e);
        parcel.writeInt(this.f5744f);
        parcel.writeString(this.f5746h);
        parcel.writeInt(this.f5741c);
        parcel.writeInt(this.f5742d);
    }

    public j(Parcel parcel) {
        this.f5740b = parcel.readInt();
        this.f5743e = parcel.readString();
        this.f5744f = parcel.readInt();
        this.f5745g = parcel.readInt();
        this.f5746h = parcel.readString();
        this.f5741c = parcel.readInt();
        this.f5742d = parcel.readInt();
    }
}

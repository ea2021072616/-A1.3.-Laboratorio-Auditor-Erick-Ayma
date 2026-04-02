package y2;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.n3;
/* loaded from: classes.dex */
public final class a extends p0.b {
    public static final Parcelable.Creator<a> CREATOR = new n3(6);

    /* renamed from: d  reason: collision with root package name */
    public boolean f5675d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5676e;

    /* renamed from: f  reason: collision with root package name */
    public int f5677f;

    /* renamed from: g  reason: collision with root package name */
    public float f5678g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5679h;

    public a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f5675d = parcel.readByte() != 0;
        this.f5676e = parcel.readByte() != 0;
        this.f5677f = parcel.readInt();
        this.f5678g = parcel.readFloat();
        this.f5679h = parcel.readByte() != 0;
    }

    @Override // p0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeParcelable(this.f4245b, i5);
        parcel.writeByte(this.f5675d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f5676e ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f5677f);
        parcel.writeFloat(this.f5678g);
        parcel.writeByte(this.f5679h ? (byte) 1 : (byte) 0);
    }
}

package com.yanzhenjie.durban;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class Controller implements Parcelable {
    public static final Parcelable.Creator<Controller> CREATOR = new Parcelable.Creator<Controller>() { // from class: com.yanzhenjie.durban.Controller.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Controller createFromParcel(Parcel parcel) {
            return new Controller(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Controller[] newArray(int i) {
            return new Controller[i];
        }
    };
    private boolean enable;
    private boolean rotation;
    private boolean rotationTitle;
    private boolean scale;
    private boolean scaleTitle;

    private Controller(Parcel parcel) {
        this.enable = parcel.readByte() != 0;
        this.rotation = parcel.readByte() != 0;
        this.rotationTitle = parcel.readByte() != 0;
        this.scale = parcel.readByte() != 0;
        this.scaleTitle = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (this.enable ? 1 : 0));
        parcel.writeByte((byte) (this.rotation ? 1 : 0));
        parcel.writeByte((byte) (this.rotationTitle ? 1 : 0));
        parcel.writeByte((byte) (this.scale ? 1 : 0));
        parcel.writeByte((byte) (this.scaleTitle ? 1 : 0));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static a newBuilder() {
        return new a();
    }

    private Controller(a aVar) {
        this.enable = aVar.f5126a;
        this.rotation = aVar.f5127b;
        this.rotationTitle = aVar.f5128c;
        this.scale = aVar.d;
        this.scaleTitle = aVar.e;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public boolean isRotation() {
        return this.rotation;
    }

    public boolean isRotationTitle() {
        return this.rotationTitle;
    }

    public boolean isScale() {
        return this.scale;
    }

    public boolean isScaleTitle() {
        return this.scaleTitle;
    }

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f5126a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f5127b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f5128c;
        private boolean d;
        private boolean e;

        private a() {
            this.f5126a = true;
            this.f5127b = true;
            this.f5128c = true;
            this.d = true;
            this.e = true;
        }

        public a a(boolean z) {
            this.f5126a = z;
            return this;
        }

        public a b(boolean z) {
            this.f5127b = z;
            return this;
        }

        public a c(boolean z) {
            this.f5128c = z;
            return this;
        }

        public a d(boolean z) {
            this.d = z;
            return this;
        }

        public a e(boolean z) {
            this.e = z;
            return this;
        }

        public Controller a() {
            return new Controller(this);
        }
    }
}

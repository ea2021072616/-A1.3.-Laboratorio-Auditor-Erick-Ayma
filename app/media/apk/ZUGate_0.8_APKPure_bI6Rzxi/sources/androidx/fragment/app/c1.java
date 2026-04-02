package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class c1 implements Parcelable {
    public static final Parcelable.Creator<c1> CREATOR = new androidx.activity.result.a(8);

    /* renamed from: b  reason: collision with root package name */
    public final String f840b;

    /* renamed from: c  reason: collision with root package name */
    public final String f841c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f842d;

    /* renamed from: e  reason: collision with root package name */
    public final int f843e;

    /* renamed from: f  reason: collision with root package name */
    public final int f844f;

    /* renamed from: g  reason: collision with root package name */
    public final String f845g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f846h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f847i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f848j;

    /* renamed from: k  reason: collision with root package name */
    public final Bundle f849k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f850l;

    /* renamed from: m  reason: collision with root package name */
    public final int f851m;

    /* renamed from: n  reason: collision with root package name */
    public Bundle f852n;

    public c1(Fragment fragment) {
        this.f840b = fragment.getClass().getName();
        this.f841c = fragment.mWho;
        this.f842d = fragment.mFromLayout;
        this.f843e = fragment.mFragmentId;
        this.f844f = fragment.mContainerId;
        this.f845g = fragment.mTag;
        this.f846h = fragment.mRetainInstance;
        this.f847i = fragment.mRemoving;
        this.f848j = fragment.mDetached;
        this.f849k = fragment.mArguments;
        this.f850l = fragment.mHidden;
        this.f851m = fragment.mMaxState.ordinal();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f840b);
        sb.append(" (");
        sb.append(this.f841c);
        sb.append(")}:");
        if (this.f842d) {
            sb.append(" fromLayout");
        }
        int i5 = this.f844f;
        if (i5 != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(i5));
        }
        String str = this.f845g;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (this.f846h) {
            sb.append(" retainInstance");
        }
        if (this.f847i) {
            sb.append(" removing");
        }
        if (this.f848j) {
            sb.append(" detached");
        }
        if (this.f850l) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.f840b);
        parcel.writeString(this.f841c);
        parcel.writeInt(this.f842d ? 1 : 0);
        parcel.writeInt(this.f843e);
        parcel.writeInt(this.f844f);
        parcel.writeString(this.f845g);
        parcel.writeInt(this.f846h ? 1 : 0);
        parcel.writeInt(this.f847i ? 1 : 0);
        parcel.writeInt(this.f848j ? 1 : 0);
        parcel.writeBundle(this.f849k);
        parcel.writeInt(this.f850l ? 1 : 0);
        parcel.writeBundle(this.f852n);
        parcel.writeInt(this.f851m);
    }

    public c1(Parcel parcel) {
        this.f840b = parcel.readString();
        this.f841c = parcel.readString();
        this.f842d = parcel.readInt() != 0;
        this.f843e = parcel.readInt();
        this.f844f = parcel.readInt();
        this.f845g = parcel.readString();
        this.f846h = parcel.readInt() != 0;
        this.f847i = parcel.readInt() != 0;
        this.f848j = parcel.readInt() != 0;
        this.f849k = parcel.readBundle();
        this.f850l = parcel.readInt() != 0;
        this.f852n = parcel.readBundle();
        this.f851m = parcel.readInt();
    }
}

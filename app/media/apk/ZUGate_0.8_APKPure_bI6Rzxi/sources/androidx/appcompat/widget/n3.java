package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class n3 implements Parcelable.ClassLoaderCreator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f435a;

    public /* synthetic */ n3(int i5) {
        this.f435a = i5;
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.f435a) {
            case 0:
                return new o3(parcel, classLoader);
            case 1:
                return new u.f(parcel, classLoader);
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                if (parcel.readParcelable(classLoader) == null) {
                    return p0.b.f4244c;
                }
                throw new IllegalStateException("superState must be null");
            case 3:
                return new androidx.fragment.app.a0(parcel, classLoader);
            case 4:
                return new androidx.recyclerview.widget.b1(parcel, classLoader);
            case 5:
                return new androidx.viewpager.widget.j(parcel, classLoader);
            case 6:
                return new y2.a(parcel, classLoader);
            case 7:
                return new b3.d(parcel, classLoader);
            case 8:
                return new c3.b(parcel, classLoader);
            case 9:
                return new j3.a(parcel, classLoader);
            case 10:
                return new q3.e(parcel, classLoader);
            default:
                return new s3.a0(parcel, classLoader);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i5) {
        switch (this.f435a) {
            case 0:
                return new o3[i5];
            case 1:
                return new u.f[i5];
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                return new p0.b[i5];
            case 3:
                return new androidx.fragment.app.a0[i5];
            case 4:
                return new androidx.recyclerview.widget.b1[i5];
            case 5:
                return new androidx.viewpager.widget.j[i5];
            case 6:
                return new y2.a[i5];
            case 7:
                return new b3.d[i5];
            case 8:
                return new c3.b[i5];
            case 9:
                return new j3.a[i5];
            case 10:
                return new q3.e[i5];
            default:
                return new s3.a0[i5];
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f435a) {
            case 0:
                return new o3(parcel, null);
            case 1:
                return new u.f(parcel, null);
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                if (parcel.readParcelable(null) == null) {
                    return p0.b.f4244c;
                }
                throw new IllegalStateException("superState must be null");
            case 3:
                return new androidx.fragment.app.a0(parcel, null);
            case 4:
                return new androidx.recyclerview.widget.b1(parcel, null);
            case 5:
                return new androidx.viewpager.widget.j(parcel, null);
            case 6:
                return new y2.a(parcel, null);
            case 7:
                return new b3.d(parcel, (ClassLoader) null);
            case 8:
                return new c3.b(parcel, null);
            case 9:
                return new j3.a(parcel, null);
            case 10:
                return new q3.e(parcel, (ClassLoader) null);
            default:
                return new s3.a0(parcel, null);
        }
    }
}

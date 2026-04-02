package i2;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.d0;
import java.util.Arrays;
import l2.c0;
/* loaded from: classes.dex */
public final class c extends m2.a {
    public static final Parcelable.Creator<c> CREATOR = new c0(4);

    /* renamed from: b  reason: collision with root package name */
    public final String f3387b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3388c;

    /* renamed from: d  reason: collision with root package name */
    public final long f3389d;

    public c() {
        this.f3387b = "CLIENT_TELEMETRY";
        this.f3389d = 1L;
        this.f3388c = -1;
    }

    public final long a() {
        long j5 = this.f3389d;
        return j5 == -1 ? this.f3388c : j5;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            String str = this.f3387b;
            if (((str != null && str.equals(cVar.f3387b)) || (str == null && cVar.f3387b == null)) && a() == cVar.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3387b, Long.valueOf(a())});
    }

    public final String toString() {
        d0 d0Var = new d0(this);
        d0Var.f(this.f3387b, "name");
        d0Var.f(Long.valueOf(a()), "version");
        return d0Var.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int o02 = b4.j.o0(parcel, 20293);
        b4.j.j0(parcel, 1, this.f3387b);
        b4.j.h0(parcel, 2, this.f3388c);
        long a5 = a();
        parcel.writeInt(524291);
        parcel.writeLong(a5);
        b4.j.t0(parcel, o02);
    }

    public c(long j5, String str, int i5) {
        this.f3387b = str;
        this.f3388c = i5;
        this.f3389d = j5;
    }
}

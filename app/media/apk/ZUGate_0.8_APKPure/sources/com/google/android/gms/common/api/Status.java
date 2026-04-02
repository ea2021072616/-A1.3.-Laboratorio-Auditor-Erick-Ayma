package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.d0;
import androidx.viewpager.widget.l;
import b4.j;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;
import m2.a;
/* loaded from: classes.dex */
public final class Status extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new androidx.activity.result.a(24);

    /* renamed from: b  reason: collision with root package name */
    public final int f1825b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1826c;

    /* renamed from: d  reason: collision with root package name */
    public final PendingIntent f1827d;

    /* renamed from: e  reason: collision with root package name */
    public final i2.a f1828e;

    public Status(int i5, String str, PendingIntent pendingIntent, i2.a aVar) {
        this.f1825b = i5;
        this.f1826c = str;
        this.f1827d = pendingIntent;
        this.f1828e = aVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Status) {
            Status status = (Status) obj;
            return this.f1825b == status.f1825b && j.p(this.f1826c, status.f1826c) && j.p(this.f1827d, status.f1827d) && j.p(this.f1828e, status.f1828e);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1825b), this.f1826c, this.f1827d, this.f1828e});
    }

    public final String toString() {
        d0 d0Var = new d0(this);
        String str = this.f1826c;
        if (str == null) {
            int i5 = this.f1825b;
            switch (i5) {
                case androidx.viewpager.widget.a.POSITION_UNCHANGED /* -1 */:
                    str = "SUCCESS_CACHE";
                    break;
                case 0:
                    str = "SUCCESS";
                    break;
                case 1:
                case 9:
                case 11:
                case 12:
                default:
                    str = b0.f("unknown status code: ", i5);
                    break;
                case l.SCROLL_STATE_SETTLING /* 2 */:
                    str = "SERVICE_VERSION_UPDATE_REQUIRED";
                    break;
                case 3:
                    str = "SERVICE_DISABLED";
                    break;
                case 4:
                    str = "SIGN_IN_REQUIRED";
                    break;
                case 5:
                    str = "INVALID_ACCOUNT";
                    break;
                case 6:
                    str = "RESOLUTION_REQUIRED";
                    break;
                case 7:
                    str = "NETWORK_ERROR";
                    break;
                case 8:
                    str = "INTERNAL_ERROR";
                    break;
                case 10:
                    str = "DEVELOPER_ERROR";
                    break;
                case 13:
                    str = "ERROR";
                    break;
                case 14:
                    str = "INTERRUPTED";
                    break;
                case 15:
                    str = "TIMEOUT";
                    break;
                case 16:
                    str = "CANCELED";
                    break;
                case 17:
                    str = "API_NOT_CONNECTED";
                    break;
                case 18:
                    str = "DEAD_CLIENT";
                    break;
                case 19:
                    str = "REMOTE_EXCEPTION";
                    break;
                case 20:
                    str = "CONNECTION_SUSPENDED_DURING_CALL";
                    break;
                case 21:
                    str = "RECONNECTION_TIMED_OUT_DURING_UPDATE";
                    break;
                case 22:
                    str = "RECONNECTION_TIMED_OUT";
                    break;
            }
        }
        d0Var.f(str, "statusCode");
        d0Var.f(this.f1827d, "resolution");
        return d0Var.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int o02 = j.o0(parcel, 20293);
        j.h0(parcel, 1, this.f1825b);
        j.j0(parcel, 2, this.f1826c);
        j.i0(parcel, 3, this.f1827d, i5);
        j.i0(parcel, 4, this.f1828e, i5);
        j.t0(parcel, o02);
    }
}

package i2;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.d0;
import java.util.Arrays;
import l2.c0;
/* loaded from: classes.dex */
public final class a extends m2.a {

    /* renamed from: b  reason: collision with root package name */
    public final int f3380b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3381c;

    /* renamed from: d  reason: collision with root package name */
    public final PendingIntent f3382d;

    /* renamed from: e  reason: collision with root package name */
    public final String f3383e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f3379f = new a(0);
    public static final Parcelable.Creator<a> CREATOR = new c0(3);

    public a(int i5, int i6, PendingIntent pendingIntent, String str) {
        this.f3380b = i5;
        this.f3381c = i6;
        this.f3382d = pendingIntent;
        this.f3383e = str;
    }

    public static String a(int i5) {
        if (i5 != 99) {
            if (i5 != 1500) {
                switch (i5) {
                    case androidx.viewpager.widget.a.POSITION_UNCHANGED /* -1 */:
                        return "UNKNOWN";
                    case 0:
                        return "SUCCESS";
                    case 1:
                        return "SERVICE_MISSING";
                    case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                        return "SERVICE_VERSION_UPDATE_REQUIRED";
                    case 3:
                        return "SERVICE_DISABLED";
                    case 4:
                        return "SIGN_IN_REQUIRED";
                    case 5:
                        return "INVALID_ACCOUNT";
                    case 6:
                        return "RESOLUTION_REQUIRED";
                    case 7:
                        return "NETWORK_ERROR";
                    case 8:
                        return "INTERNAL_ERROR";
                    case 9:
                        return "SERVICE_INVALID";
                    case 10:
                        return "DEVELOPER_ERROR";
                    case 11:
                        return "LICENSE_CHECK_FAILED";
                    default:
                        switch (i5) {
                            case 13:
                                return "CANCELED";
                            case 14:
                                return "TIMEOUT";
                            case 15:
                                return "INTERRUPTED";
                            case 16:
                                return "API_UNAVAILABLE";
                            case 17:
                                return "SIGN_IN_FAILED";
                            case 18:
                                return "SERVICE_UPDATING";
                            case 19:
                                return "SERVICE_MISSING_PERMISSION";
                            case 20:
                                return "RESTRICTED_PROFILE";
                            case 21:
                                return "API_VERSION_UPDATE_REQUIRED";
                            case 22:
                                return "RESOLUTION_ACTIVITY_NOT_FOUND";
                            case 23:
                                return "API_DISABLED";
                            case 24:
                                return "API_DISABLED_FOR_CONNECTION";
                            default:
                                return "UNKNOWN_ERROR_CODE(" + i5 + ")";
                        }
                }
            }
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        return "UNFINISHED";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f3381c == aVar.f3381c && b4.j.p(this.f3382d, aVar.f3382d) && b4.j.p(this.f3383e, aVar.f3383e);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3381c), this.f3382d, this.f3383e});
    }

    public final String toString() {
        d0 d0Var = new d0(this);
        d0Var.f(a(this.f3381c), "statusCode");
        d0Var.f(this.f3382d, "resolution");
        d0Var.f(this.f3383e, "message");
        return d0Var.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int o02 = b4.j.o0(parcel, 20293);
        b4.j.h0(parcel, 1, this.f3380b);
        b4.j.h0(parcel, 2, this.f3381c);
        b4.j.i0(parcel, 3, this.f3382d, i5);
        b4.j.j0(parcel, 4, this.f3383e);
        b4.j.t0(parcel, o02);
    }

    public a(int i5) {
        this(1, i5, null, null);
    }

    public a(int i5, PendingIntent pendingIntent) {
        this(1, i5, pendingIntent, null);
    }
}

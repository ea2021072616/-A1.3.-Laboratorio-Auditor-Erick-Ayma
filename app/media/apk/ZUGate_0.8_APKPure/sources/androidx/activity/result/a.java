package androidx.activity.result;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.v0;
import androidx.fragment.app.c1;
import androidx.fragment.app.t0;
import androidx.fragment.app.y0;
import androidx.recyclerview.widget.o1;
import androidx.recyclerview.widget.p1;
import androidx.recyclerview.widget.z;
import androidx.versionedparcelable.ParcelImpl;
import androidx.viewpager.widget.l;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import l2.q;
import l2.r;
import y0.h0;
import y0.i0;
import y0.t;
/* loaded from: classes.dex */
public final class a implements Parcelable.Creator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f81a;

    public /* synthetic */ a(int i5) {
        this.f81a = i5;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        String str = null;
        Account account = null;
        String str2 = null;
        int i5 = 0;
        switch (this.f81a) {
            case 0:
                return new b(parcel);
            case 1:
                e4.e.f(parcel, "inParcel");
                Parcelable readParcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
                e4.e.c(readParcelable);
                return new k((IntentSender) readParcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
            case l.SCROLL_STATE_SETTLING /* 2 */:
                return new v0(parcel);
            case 3:
                return new n0.k(parcel);
            case 4:
                return new androidx.fragment.app.b(parcel);
            case 5:
                return new androidx.fragment.app.c(parcel);
            case 6:
                return new t0(parcel);
            case 7:
                return new y0(parcel);
            case 8:
                return new c1(parcel);
            case 9:
                return new y0.c(parcel);
            case 10:
                return new y0.f(parcel);
            case 11:
                return new y0.h(parcel);
            case 12:
                return new y0.k(parcel);
            case 13:
                return new t(parcel);
            case 14:
                return new h0(parcel);
            case 15:
                return new i0(parcel);
            case 16:
                return new z(parcel);
            case 17:
                return new o1(parcel);
            case 18:
                return new p1(parcel);
            case 19:
                return new ParcelImpl(parcel);
            case 20:
                return new m1.h(parcel);
            case 21:
            default:
                int T = com.google.android.gms.internal.play_billing.i0.T(parcel);
                int i6 = 0;
                boolean z4 = false;
                boolean z5 = false;
                int i7 = 0;
                int i8 = 0;
                while (parcel.dataPosition() < T) {
                    int readInt = parcel.readInt();
                    char c5 = (char) readInt;
                    if (c5 == 1) {
                        i6 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt);
                    } else if (c5 == 2) {
                        z4 = com.google.android.gms.internal.play_billing.i0.N(parcel, readInt);
                    } else if (c5 == 3) {
                        z5 = com.google.android.gms.internal.play_billing.i0.N(parcel, readInt);
                    } else if (c5 == 4) {
                        i7 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt);
                    } else if (c5 != 5) {
                        com.google.android.gms.internal.play_billing.i0.R(parcel, readInt);
                    } else {
                        i8 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt);
                    }
                }
                com.google.android.gms.internal.play_billing.i0.w(parcel, T);
                return new l2.j(i6, z4, z5, i7, i8);
            case 22:
                int T2 = com.google.android.gms.internal.play_billing.i0.T(parcel);
                long j5 = 0;
                String str3 = null;
                String str4 = null;
                String str5 = null;
                String str6 = null;
                Uri uri = null;
                String str7 = null;
                String str8 = null;
                ArrayList arrayList = null;
                String str9 = null;
                String str10 = null;
                int i9 = 0;
                while (parcel.dataPosition() < T2) {
                    int readInt2 = parcel.readInt();
                    switch ((char) readInt2) {
                        case 1:
                            i9 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt2);
                            break;
                        case l.SCROLL_STATE_SETTLING /* 2 */:
                            str3 = com.google.android.gms.internal.play_billing.i0.q(parcel, readInt2);
                            break;
                        case 3:
                            str4 = com.google.android.gms.internal.play_billing.i0.q(parcel, readInt2);
                            break;
                        case 4:
                            str5 = com.google.android.gms.internal.play_billing.i0.q(parcel, readInt2);
                            break;
                        case 5:
                            str6 = com.google.android.gms.internal.play_billing.i0.q(parcel, readInt2);
                            break;
                        case 6:
                            uri = (Uri) com.google.android.gms.internal.play_billing.i0.p(parcel, readInt2, Uri.CREATOR);
                            break;
                        case 7:
                            str7 = com.google.android.gms.internal.play_billing.i0.q(parcel, readInt2);
                            break;
                        case '\b':
                            com.google.android.gms.internal.play_billing.i0.b0(parcel, readInt2, 8);
                            j5 = parcel.readLong();
                            break;
                        case '\t':
                            str8 = com.google.android.gms.internal.play_billing.i0.q(parcel, readInt2);
                            break;
                        case '\n':
                            Parcelable.Creator<Scope> creator = Scope.CREATOR;
                            int P = com.google.android.gms.internal.play_billing.i0.P(parcel, readInt2);
                            int dataPosition = parcel.dataPosition();
                            if (P != 0) {
                                ArrayList createTypedArrayList = parcel.createTypedArrayList(creator);
                                parcel.setDataPosition(dataPosition + P);
                                arrayList = createTypedArrayList;
                                break;
                            } else {
                                arrayList = null;
                                break;
                            }
                        case 11:
                            str9 = com.google.android.gms.internal.play_billing.i0.q(parcel, readInt2);
                            break;
                        case '\f':
                            str10 = com.google.android.gms.internal.play_billing.i0.q(parcel, readInt2);
                            break;
                        default:
                            com.google.android.gms.internal.play_billing.i0.R(parcel, readInt2);
                            break;
                    }
                }
                com.google.android.gms.internal.play_billing.i0.w(parcel, T2);
                return new GoogleSignInAccount(i9, str3, str4, str5, str6, uri, str7, j5, str8, arrayList, str9, str10);
            case 23:
                int T3 = com.google.android.gms.internal.play_billing.i0.T(parcel);
                while (parcel.dataPosition() < T3) {
                    int readInt3 = parcel.readInt();
                    char c6 = (char) readInt3;
                    if (c6 == 1) {
                        i5 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt3);
                    } else if (c6 != 2) {
                        com.google.android.gms.internal.play_billing.i0.R(parcel, readInt3);
                    } else {
                        str = com.google.android.gms.internal.play_billing.i0.q(parcel, readInt3);
                    }
                }
                com.google.android.gms.internal.play_billing.i0.w(parcel, T3);
                return new Scope(i5, str);
            case 24:
                int T4 = com.google.android.gms.internal.play_billing.i0.T(parcel);
                PendingIntent pendingIntent = null;
                i2.a aVar = null;
                while (parcel.dataPosition() < T4) {
                    int readInt4 = parcel.readInt();
                    char c7 = (char) readInt4;
                    if (c7 == 1) {
                        i5 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt4);
                    } else if (c7 == 2) {
                        str2 = com.google.android.gms.internal.play_billing.i0.q(parcel, readInt4);
                    } else if (c7 == 3) {
                        pendingIntent = (PendingIntent) com.google.android.gms.internal.play_billing.i0.p(parcel, readInt4, PendingIntent.CREATOR);
                    } else if (c7 != 4) {
                        com.google.android.gms.internal.play_billing.i0.R(parcel, readInt4);
                    } else {
                        aVar = (i2.a) com.google.android.gms.internal.play_billing.i0.p(parcel, readInt4, i2.a.CREATOR);
                    }
                }
                com.google.android.gms.internal.play_billing.i0.w(parcel, T4);
                return new Status(i5, str2, pendingIntent, aVar);
            case 25:
                int T5 = com.google.android.gms.internal.play_billing.i0.T(parcel);
                while (true) {
                    ArrayList arrayList2 = null;
                    while (parcel.dataPosition() < T5) {
                        int readInt5 = parcel.readInt();
                        char c8 = (char) readInt5;
                        if (c8 == 1) {
                            i5 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt5);
                        } else if (c8 != 2) {
                            com.google.android.gms.internal.play_billing.i0.R(parcel, readInt5);
                        } else {
                            Parcelable.Creator<l2.h> creator2 = l2.h.CREATOR;
                            int P2 = com.google.android.gms.internal.play_billing.i0.P(parcel, readInt5);
                            int dataPosition2 = parcel.dataPosition();
                            if (P2 == 0) {
                                break;
                            }
                            arrayList2 = parcel.createTypedArrayList(creator2);
                            parcel.setDataPosition(dataPosition2 + P2);
                        }
                    }
                    com.google.android.gms.internal.play_billing.i0.w(parcel, T5);
                    return new l2.k(i5, arrayList2);
                    break;
                }
            case 26:
                int T6 = com.google.android.gms.internal.play_billing.i0.T(parcel);
                int i10 = -1;
                long j6 = 0;
                long j7 = 0;
                String str11 = null;
                String str12 = null;
                int i11 = 0;
                int i12 = 0;
                int i13 = 0;
                int i14 = 0;
                while (parcel.dataPosition() < T6) {
                    int readInt6 = parcel.readInt();
                    switch ((char) readInt6) {
                        case 1:
                            i11 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt6);
                            break;
                        case l.SCROLL_STATE_SETTLING /* 2 */:
                            i12 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt6);
                            break;
                        case 3:
                            i13 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt6);
                            break;
                        case 4:
                            com.google.android.gms.internal.play_billing.i0.b0(parcel, readInt6, 8);
                            j6 = parcel.readLong();
                            break;
                        case 5:
                            com.google.android.gms.internal.play_billing.i0.b0(parcel, readInt6, 8);
                            j7 = parcel.readLong();
                            break;
                        case 6:
                            str11 = com.google.android.gms.internal.play_billing.i0.q(parcel, readInt6);
                            break;
                        case 7:
                            str12 = com.google.android.gms.internal.play_billing.i0.q(parcel, readInt6);
                            break;
                        case '\b':
                            i14 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt6);
                            break;
                        case '\t':
                            i10 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt6);
                            break;
                        default:
                            com.google.android.gms.internal.play_billing.i0.R(parcel, readInt6);
                            break;
                    }
                }
                com.google.android.gms.internal.play_billing.i0.w(parcel, T6);
                return new l2.h(i11, i12, i13, j6, j7, str11, str12, i14, i10);
            case 27:
                int T7 = com.google.android.gms.internal.play_billing.i0.T(parcel);
                GoogleSignInAccount googleSignInAccount = null;
                int i15 = 0;
                while (parcel.dataPosition() < T7) {
                    int readInt7 = parcel.readInt();
                    char c9 = (char) readInt7;
                    if (c9 == 1) {
                        i5 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt7);
                    } else if (c9 == 2) {
                        account = (Account) com.google.android.gms.internal.play_billing.i0.p(parcel, readInt7, Account.CREATOR);
                    } else if (c9 == 3) {
                        i15 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt7);
                    } else if (c9 != 4) {
                        com.google.android.gms.internal.play_billing.i0.R(parcel, readInt7);
                    } else {
                        googleSignInAccount = (GoogleSignInAccount) com.google.android.gms.internal.play_billing.i0.p(parcel, readInt7, GoogleSignInAccount.CREATOR);
                    }
                }
                com.google.android.gms.internal.play_billing.i0.w(parcel, T7);
                return new q(i5, account, i15, googleSignInAccount);
            case 28:
                int T8 = com.google.android.gms.internal.play_billing.i0.T(parcel);
                IBinder iBinder = null;
                i2.a aVar2 = null;
                int i16 = 0;
                boolean z6 = false;
                boolean z7 = false;
                while (parcel.dataPosition() < T8) {
                    int readInt8 = parcel.readInt();
                    char c10 = (char) readInt8;
                    if (c10 == 1) {
                        i16 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt8);
                    } else if (c10 == 2) {
                        int P3 = com.google.android.gms.internal.play_billing.i0.P(parcel, readInt8);
                        int dataPosition3 = parcel.dataPosition();
                        if (P3 == 0) {
                            iBinder = null;
                        } else {
                            IBinder readStrongBinder = parcel.readStrongBinder();
                            parcel.setDataPosition(dataPosition3 + P3);
                            iBinder = readStrongBinder;
                        }
                    } else if (c10 == 3) {
                        aVar2 = (i2.a) com.google.android.gms.internal.play_billing.i0.p(parcel, readInt8, i2.a.CREATOR);
                    } else if (c10 == 4) {
                        z6 = com.google.android.gms.internal.play_billing.i0.N(parcel, readInt8);
                    } else if (c10 != 5) {
                        com.google.android.gms.internal.play_billing.i0.R(parcel, readInt8);
                    } else {
                        z7 = com.google.android.gms.internal.play_billing.i0.N(parcel, readInt8);
                    }
                }
                com.google.android.gms.internal.play_billing.i0.w(parcel, T8);
                return new r(i16, iBinder, aVar2, z6, z7);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i5) {
        switch (this.f81a) {
            case 0:
                return new b[i5];
            case 1:
                return new k[i5];
            case l.SCROLL_STATE_SETTLING /* 2 */:
                return new v0[i5];
            case 3:
                return new n0.k[i5];
            case 4:
                return new androidx.fragment.app.b[i5];
            case 5:
                return new androidx.fragment.app.c[i5];
            case 6:
                return new t0[i5];
            case 7:
                return new y0[i5];
            case 8:
                return new c1[i5];
            case 9:
                return new y0.c[i5];
            case 10:
                return new y0.f[i5];
            case 11:
                return new y0.h[i5];
            case 12:
                return new y0.k[i5];
            case 13:
                return new t[i5];
            case 14:
                return new h0[i5];
            case 15:
                return new i0[i5];
            case 16:
                return new z[i5];
            case 17:
                return new o1[i5];
            case 18:
                return new p1[i5];
            case 19:
                return new ParcelImpl[i5];
            case 20:
                return new m1.h[i5];
            case 21:
            default:
                return new l2.j[i5];
            case 22:
                return new GoogleSignInAccount[i5];
            case 23:
                return new Scope[i5];
            case 24:
                return new Status[i5];
            case 25:
                return new l2.k[i5];
            case 26:
                return new l2.h[i5];
            case 27:
                return new q[i5];
            case 28:
                return new r[i5];
        }
    }
}

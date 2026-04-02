package l2;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class c0 implements Parcelable.Creator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3773a;

    public /* synthetic */ c0(int i5) {
        this.f3773a = i5;
    }

    public static void a(e eVar, Parcel parcel, int i5) {
        int o02 = b4.j.o0(parcel, 20293);
        b4.j.h0(parcel, 1, eVar.f3786b);
        b4.j.h0(parcel, 2, eVar.f3787c);
        b4.j.h0(parcel, 3, eVar.f3788d);
        b4.j.j0(parcel, 4, eVar.f3789e);
        IBinder iBinder = eVar.f3790f;
        if (iBinder != null) {
            int o03 = b4.j.o0(parcel, 5);
            parcel.writeStrongBinder(iBinder);
            b4.j.t0(parcel, o03);
        }
        b4.j.k0(parcel, 6, eVar.f3791g, i5);
        Bundle bundle = eVar.f3792h;
        if (bundle != null) {
            int o04 = b4.j.o0(parcel, 7);
            parcel.writeBundle(bundle);
            b4.j.t0(parcel, o04);
        }
        b4.j.i0(parcel, 8, eVar.f3793i, i5);
        b4.j.k0(parcel, 10, eVar.f3794j, i5);
        b4.j.k0(parcel, 11, eVar.f3795k, i5);
        b4.j.g0(parcel, 12, eVar.f3796l);
        b4.j.h0(parcel, 13, eVar.f3797m);
        b4.j.g0(parcel, 14, eVar.f3798n);
        b4.j.j0(parcel, 15, eVar.o);
        b4.j.t0(parcel, o02);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int i5 = 0;
        String str = null;
        i2.a aVar = null;
        q qVar = null;
        Intent intent = null;
        switch (this.f3773a) {
            case 0:
                int T = com.google.android.gms.internal.play_billing.i0.T(parcel);
                Bundle bundle = null;
                i2.c[] cVarArr = null;
                d dVar = null;
                while (parcel.dataPosition() < T) {
                    int readInt = parcel.readInt();
                    char c5 = (char) readInt;
                    if (c5 == 1) {
                        int P = com.google.android.gms.internal.play_billing.i0.P(parcel, readInt);
                        int dataPosition = parcel.dataPosition();
                        if (P == 0) {
                            bundle = null;
                        } else {
                            Bundle readBundle = parcel.readBundle();
                            parcel.setDataPosition(dataPosition + P);
                            bundle = readBundle;
                        }
                    } else if (c5 == 2) {
                        cVarArr = (i2.c[]) com.google.android.gms.internal.play_billing.i0.r(parcel, readInt, i2.c.CREATOR);
                    } else if (c5 == 3) {
                        i5 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt);
                    } else if (c5 != 4) {
                        com.google.android.gms.internal.play_billing.i0.R(parcel, readInt);
                    } else {
                        dVar = (d) com.google.android.gms.internal.play_billing.i0.p(parcel, readInt, d.CREATOR);
                    }
                }
                com.google.android.gms.internal.play_billing.i0.w(parcel, T);
                return new b0(bundle, cVarArr, i5, dVar);
            case 1:
                int T2 = com.google.android.gms.internal.play_billing.i0.T(parcel);
                boolean z4 = false;
                boolean z5 = false;
                int i6 = 0;
                j jVar = null;
                int[] iArr = null;
                int[] iArr2 = null;
                while (parcel.dataPosition() < T2) {
                    int readInt2 = parcel.readInt();
                    switch ((char) readInt2) {
                        case 1:
                            jVar = (j) com.google.android.gms.internal.play_billing.i0.p(parcel, readInt2, j.CREATOR);
                            break;
                        case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                            z4 = com.google.android.gms.internal.play_billing.i0.N(parcel, readInt2);
                            break;
                        case 3:
                            z5 = com.google.android.gms.internal.play_billing.i0.N(parcel, readInt2);
                            break;
                        case 4:
                            int P2 = com.google.android.gms.internal.play_billing.i0.P(parcel, readInt2);
                            int dataPosition2 = parcel.dataPosition();
                            if (P2 != 0) {
                                int[] createIntArray = parcel.createIntArray();
                                parcel.setDataPosition(dataPosition2 + P2);
                                iArr = createIntArray;
                                break;
                            } else {
                                iArr = null;
                                break;
                            }
                        case 5:
                            i6 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt2);
                            break;
                        case 6:
                            int P3 = com.google.android.gms.internal.play_billing.i0.P(parcel, readInt2);
                            int dataPosition3 = parcel.dataPosition();
                            if (P3 != 0) {
                                int[] createIntArray2 = parcel.createIntArray();
                                parcel.setDataPosition(dataPosition3 + P3);
                                iArr2 = createIntArray2;
                                break;
                            } else {
                                iArr2 = null;
                                break;
                            }
                        default:
                            com.google.android.gms.internal.play_billing.i0.R(parcel, readInt2);
                            break;
                    }
                }
                com.google.android.gms.internal.play_billing.i0.w(parcel, T2);
                return new d(jVar, z4, z5, iArr, i6, iArr2);
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                int T3 = com.google.android.gms.internal.play_billing.i0.T(parcel);
                Scope[] scopeArr = e.f3784p;
                Bundle bundle2 = new Bundle();
                i2.c[] cVarArr2 = e.f3785q;
                i2.c[] cVarArr3 = cVarArr2;
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                boolean z6 = false;
                int i10 = 0;
                boolean z7 = false;
                String str2 = null;
                IBinder iBinder = null;
                Account account = null;
                String str3 = null;
                while (parcel.dataPosition() < T3) {
                    int readInt3 = parcel.readInt();
                    switch ((char) readInt3) {
                        case 1:
                            i7 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt3);
                            break;
                        case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                            i8 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt3);
                            break;
                        case 3:
                            i9 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt3);
                            break;
                        case 4:
                            str2 = com.google.android.gms.internal.play_billing.i0.q(parcel, readInt3);
                            break;
                        case 5:
                            int P4 = com.google.android.gms.internal.play_billing.i0.P(parcel, readInt3);
                            int dataPosition4 = parcel.dataPosition();
                            if (P4 != 0) {
                                IBinder readStrongBinder = parcel.readStrongBinder();
                                parcel.setDataPosition(dataPosition4 + P4);
                                iBinder = readStrongBinder;
                                break;
                            } else {
                                iBinder = null;
                                break;
                            }
                        case 6:
                            scopeArr = (Scope[]) com.google.android.gms.internal.play_billing.i0.r(parcel, readInt3, Scope.CREATOR);
                            break;
                        case 7:
                            int P5 = com.google.android.gms.internal.play_billing.i0.P(parcel, readInt3);
                            int dataPosition5 = parcel.dataPosition();
                            if (P5 != 0) {
                                Bundle readBundle2 = parcel.readBundle();
                                parcel.setDataPosition(dataPosition5 + P5);
                                bundle2 = readBundle2;
                                break;
                            } else {
                                bundle2 = null;
                                break;
                            }
                        case '\b':
                            account = (Account) com.google.android.gms.internal.play_billing.i0.p(parcel, readInt3, Account.CREATOR);
                            break;
                        case '\t':
                        default:
                            com.google.android.gms.internal.play_billing.i0.R(parcel, readInt3);
                            break;
                        case '\n':
                            cVarArr2 = (i2.c[]) com.google.android.gms.internal.play_billing.i0.r(parcel, readInt3, i2.c.CREATOR);
                            break;
                        case 11:
                            cVarArr3 = (i2.c[]) com.google.android.gms.internal.play_billing.i0.r(parcel, readInt3, i2.c.CREATOR);
                            break;
                        case '\f':
                            z6 = com.google.android.gms.internal.play_billing.i0.N(parcel, readInt3);
                            break;
                        case '\r':
                            i10 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt3);
                            break;
                        case 14:
                            z7 = com.google.android.gms.internal.play_billing.i0.N(parcel, readInt3);
                            break;
                        case 15:
                            str3 = com.google.android.gms.internal.play_billing.i0.q(parcel, readInt3);
                            break;
                    }
                }
                com.google.android.gms.internal.play_billing.i0.w(parcel, T3);
                return new e(i7, i8, i9, str2, iBinder, scopeArr, bundle2, account, cVarArr2, cVarArr3, z6, i10, z7, str3);
            case 3:
                int T4 = com.google.android.gms.internal.play_billing.i0.T(parcel);
                PendingIntent pendingIntent = null;
                String str4 = null;
                int i11 = 0;
                while (parcel.dataPosition() < T4) {
                    int readInt4 = parcel.readInt();
                    char c6 = (char) readInt4;
                    if (c6 == 1) {
                        i5 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt4);
                    } else if (c6 == 2) {
                        i11 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt4);
                    } else if (c6 == 3) {
                        pendingIntent = (PendingIntent) com.google.android.gms.internal.play_billing.i0.p(parcel, readInt4, PendingIntent.CREATOR);
                    } else if (c6 != 4) {
                        com.google.android.gms.internal.play_billing.i0.R(parcel, readInt4);
                    } else {
                        str4 = com.google.android.gms.internal.play_billing.i0.q(parcel, readInt4);
                    }
                }
                com.google.android.gms.internal.play_billing.i0.w(parcel, T4);
                return new i2.a(i5, i11, pendingIntent, str4);
            case 4:
                int T5 = com.google.android.gms.internal.play_billing.i0.T(parcel);
                long j5 = -1;
                while (parcel.dataPosition() < T5) {
                    int readInt5 = parcel.readInt();
                    char c7 = (char) readInt5;
                    if (c7 == 1) {
                        str = com.google.android.gms.internal.play_billing.i0.q(parcel, readInt5);
                    } else if (c7 == 2) {
                        i5 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt5);
                    } else if (c7 != 3) {
                        com.google.android.gms.internal.play_billing.i0.R(parcel, readInt5);
                    } else {
                        com.google.android.gms.internal.play_billing.i0.b0(parcel, readInt5, 8);
                        j5 = parcel.readLong();
                    }
                }
                com.google.android.gms.internal.play_billing.i0.w(parcel, T5);
                return new i2.c(j5, str, i5);
            case 5:
                int T6 = com.google.android.gms.internal.play_billing.i0.T(parcel);
                int i12 = 0;
                while (parcel.dataPosition() < T6) {
                    int readInt6 = parcel.readInt();
                    char c8 = (char) readInt6;
                    if (c8 == 1) {
                        i5 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt6);
                    } else if (c8 == 2) {
                        i12 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt6);
                    } else if (c8 != 3) {
                        com.google.android.gms.internal.play_billing.i0.R(parcel, readInt6);
                    } else {
                        intent = (Intent) com.google.android.gms.internal.play_billing.i0.p(parcel, readInt6, Intent.CREATOR);
                    }
                }
                com.google.android.gms.internal.play_billing.i0.w(parcel, T6);
                return new u2.b(i5, i12, intent);
            case 6:
                int T7 = com.google.android.gms.internal.play_billing.i0.T(parcel);
                String str5 = null;
                ArrayList<String> arrayList = null;
                while (parcel.dataPosition() < T7) {
                    int readInt7 = parcel.readInt();
                    char c9 = (char) readInt7;
                    if (c9 == 1) {
                        int P6 = com.google.android.gms.internal.play_billing.i0.P(parcel, readInt7);
                        int dataPosition6 = parcel.dataPosition();
                        if (P6 == 0) {
                            arrayList = null;
                        } else {
                            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                            parcel.setDataPosition(dataPosition6 + P6);
                            arrayList = createStringArrayList;
                        }
                    } else if (c9 != 2) {
                        com.google.android.gms.internal.play_billing.i0.R(parcel, readInt7);
                    } else {
                        str5 = com.google.android.gms.internal.play_billing.i0.q(parcel, readInt7);
                    }
                }
                com.google.android.gms.internal.play_billing.i0.w(parcel, T7);
                return new u2.g(str5, arrayList);
            case 7:
                int T8 = com.google.android.gms.internal.play_billing.i0.T(parcel);
                while (parcel.dataPosition() < T8) {
                    int readInt8 = parcel.readInt();
                    char c10 = (char) readInt8;
                    if (c10 == 1) {
                        i5 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt8);
                    } else if (c10 != 2) {
                        com.google.android.gms.internal.play_billing.i0.R(parcel, readInt8);
                    } else {
                        qVar = (q) com.google.android.gms.internal.play_billing.i0.p(parcel, readInt8, q.CREATOR);
                    }
                }
                com.google.android.gms.internal.play_billing.i0.w(parcel, T8);
                return new u2.h(i5, qVar);
            case 8:
                int T9 = com.google.android.gms.internal.play_billing.i0.T(parcel);
                r rVar = null;
                while (parcel.dataPosition() < T9) {
                    int readInt9 = parcel.readInt();
                    char c11 = (char) readInt9;
                    if (c11 == 1) {
                        i5 = com.google.android.gms.internal.play_billing.i0.O(parcel, readInt9);
                    } else if (c11 == 2) {
                        aVar = (i2.a) com.google.android.gms.internal.play_billing.i0.p(parcel, readInt9, i2.a.CREATOR);
                    } else if (c11 != 3) {
                        com.google.android.gms.internal.play_billing.i0.R(parcel, readInt9);
                    } else {
                        rVar = (r) com.google.android.gms.internal.play_billing.i0.p(parcel, readInt9, r.CREATOR);
                    }
                }
                com.google.android.gms.internal.play_billing.i0.w(parcel, T9);
                return new u2.i(i5, aVar, rVar);
            case 9:
                return new e3.b(parcel);
            case 10:
                return new com.google.android.material.datepicker.c((com.google.android.material.datepicker.p) parcel.readParcelable(com.google.android.material.datepicker.p.class.getClassLoader()), (com.google.android.material.datepicker.p) parcel.readParcelable(com.google.android.material.datepicker.p.class.getClassLoader()), (com.google.android.material.datepicker.b) parcel.readParcelable(com.google.android.material.datepicker.b.class.getClassLoader()), (com.google.android.material.datepicker.p) parcel.readParcelable(com.google.android.material.datepicker.p.class.getClassLoader()), parcel.readInt());
            case 11:
                return new com.google.android.material.datepicker.e(parcel.readLong());
            case 12:
                return com.google.android.material.datepicker.p.a(parcel.readInt(), parcel.readInt());
            case 13:
                return new com.google.android.material.timepicker.g(parcel);
            case 14:
                return new t4.a(parcel);
            default:
                return new y4.j(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i5) {
        switch (this.f3773a) {
            case 0:
                return new b0[i5];
            case 1:
                return new d[i5];
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                return new e[i5];
            case 3:
                return new i2.a[i5];
            case 4:
                return new i2.c[i5];
            case 5:
                return new u2.b[i5];
            case 6:
                return new u2.g[i5];
            case 7:
                return new u2.h[i5];
            case 8:
                return new u2.i[i5];
            case 9:
                return new e3.b[i5];
            case 10:
                return new com.google.android.material.datepicker.c[i5];
            case 11:
                return new com.google.android.material.datepicker.e[i5];
            case 12:
                return new com.google.android.material.datepicker.p[i5];
            case 13:
                return new com.google.android.material.timepicker.g[i5];
            case 14:
                return new t4.a[i5];
            default:
                return new y4.j[i5];
        }
    }
}

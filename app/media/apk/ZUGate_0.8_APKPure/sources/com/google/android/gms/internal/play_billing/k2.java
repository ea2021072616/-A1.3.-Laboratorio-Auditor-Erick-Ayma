package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class k2 implements o0 {

    /* renamed from: a  reason: collision with root package name */
    public static final k2 f1905a = new k2();

    @Override // com.google.android.gms.internal.play_billing.o0
    public final boolean a(int i5) {
        switch (i5) {
            case 0:
            case 1:
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return true;
            default:
                switch (i5) {
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                        return true;
                    default:
                        return false;
                }
        }
    }
}

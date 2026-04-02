package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class a3 implements o0 {

    /* renamed from: a  reason: collision with root package name */
    public static final a3 f1837a = new a3();

    @Override // com.google.android.gms.internal.play_billing.o0
    public final boolean a(int i5) {
        if (i5 != 17) {
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
                    return true;
                default:
                    return false;
            }
        }
        return true;
    }
}

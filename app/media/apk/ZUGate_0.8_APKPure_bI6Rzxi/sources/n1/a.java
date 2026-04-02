package n1;

import java.text.DecimalFormat;
/* loaded from: classes.dex */
public final class a extends d {

    /* renamed from: a  reason: collision with root package name */
    public final DecimalFormat f4078a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4079b;

    public a(int i5) {
        this.f4079b = i5;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.f4078a = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    @Override // n1.d
    public final String a(float f5) {
        return this.f4078a.format(f5);
    }
}

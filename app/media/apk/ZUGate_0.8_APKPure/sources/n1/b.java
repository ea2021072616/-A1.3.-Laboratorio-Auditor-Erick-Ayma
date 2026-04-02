package n1;

import java.text.DecimalFormat;
/* loaded from: classes.dex */
public final class b extends d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4080a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f4081b;

    /* renamed from: c  reason: collision with root package name */
    public Object f4082c;

    public b(String[] strArr) {
        this.f4082c = strArr;
        this.f4081b = strArr.length;
    }

    @Override // n1.d
    public final String a(float f5) {
        switch (this.f4080a) {
            case 0:
                return ((DecimalFormat) this.f4082c).format(f5);
            default:
                int round = Math.round(f5);
                return (round < 0 || round >= this.f4081b || round != ((int) f5)) ? "" : ((String[]) this.f4082c)[round];
        }
    }

    public final void b(int i5) {
        this.f4081b = i5;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.f4082c = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    public b(int i5) {
        b(i5);
    }
}

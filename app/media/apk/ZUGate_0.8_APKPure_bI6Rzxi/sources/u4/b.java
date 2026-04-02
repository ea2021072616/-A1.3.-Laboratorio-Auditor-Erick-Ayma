package u4;

import androidx.appcompat.widget.b0;
import java.util.Arrays;
import ru.zdevs.zugate.activity.BenchmarkActivity;
import ru.zdevs.zugate.jni.BlockDevice;
import ru.zdevs.zugate.jni.MbedTLS;
/* loaded from: classes.dex */
public final class b extends x4.l {
    @Override // x4.l
    public final x4.a a() {
        int cBenchmarkCryptSetup;
        int cBenchmarkCryptSetup2;
        Thread.currentThread().setPriority(10);
        g(new t4.l(1));
        int i5 = MbedTLS.f4615b;
        int i6 = 0;
        while (true) {
            String[] strArr = BenchmarkActivity.f4574k;
            if (i6 >= 6 || d()) {
                break;
            }
            String str = strArr[i6];
            int[] iArr = BenchmarkActivity.f4575l;
            int i7 = iArr[i6];
            d dVar = new d(i6);
            g(new f(i6, str));
            MbedTLS.b(0);
            dVar.f5152b = BlockDevice.cBenchmarkCryptSetup(null, strArr[i6], iArr[i6]);
            if (!Arrays.asList(BenchmarkActivity.f4581s).contains(strArr[i6])) {
                dVar.f5153c = dVar.f5152b;
            } else if (d()) {
                break;
            } else {
                MbedTLS.b(MbedTLS.a());
                dVar.f5153c = BlockDevice.cBenchmarkCryptSetup(null, strArr[i6], iArr[i6]);
            }
            if (d()) {
                break;
            }
            g(dVar);
            i6++;
        }
        int i8 = 0;
        while (true) {
            String[] strArr2 = BenchmarkActivity.o;
            if (i8 >= 6 || d()) {
                break;
            }
            String str2 = strArr2[i8];
            int[] iArr2 = BenchmarkActivity.f4578p;
            int i9 = iArr2[i8];
            c cVar = new c(i8);
            g(new f(6 + i8, str2));
            MbedTLS.b(0);
            if (BlockDevice.cBenchmarkCryptSetup(b0.i(new StringBuilder(), strArr2[i8], "-cbc"), null, iArr2[i8]) != -1) {
                cVar.f5149b = (((cBenchmarkCryptSetup & 65535) / 8.0f) + (((cBenchmarkCryptSetup >> 16) & 65535) / 8.0f)) / 2.0f;
                if (d()) {
                    break;
                }
                MbedTLS.b(MbedTLS.a());
                if (BlockDevice.cBenchmarkCryptSetup(b0.i(new StringBuilder(), strArr2[i8], "-cbc"), null, iArr2[i8]) == -1) {
                    cVar.f5150c = 0.0f;
                } else {
                    cVar.f5150c = (((cBenchmarkCryptSetup2 & 65535) / 8.0f) + (((cBenchmarkCryptSetup2 >> 16) & 65535) / 8.0f)) / 2.0f;
                }
                if (d()) {
                    break;
                }
                g(cVar);
            }
            i8++;
        }
        MbedTLS.b(i5);
        return new e(true ^ d());
    }
}

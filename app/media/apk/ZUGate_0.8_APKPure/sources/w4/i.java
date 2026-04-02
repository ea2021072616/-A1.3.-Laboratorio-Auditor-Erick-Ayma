package w4;

import java.io.Closeable;
import java.util.ArrayList;
import ru.zdevs.zugate.jni.IFS$FFile;
import ru.zdevs.zugate.jni.IFS$FStatFs;
/* loaded from: classes.dex */
public interface i extends Closeable {
    IFS$FStatFs B();

    boolean C();

    String D(String str, String str2, String str3, h hVar);

    String c(String str);

    IFS$FFile d(String str);

    String f();

    int i(String str);

    long k(long j5, int i5);

    String n(String str, String str2, h hVar);

    String p(String str, String str2);

    ArrayList t(String str);

    String v(String str, String str2, h hVar);

    g x(int i5, String str);
}

package w4;

import android.os.Build;
import androidx.appcompat.widget.b0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ru.zdevs.zugate.ZApp;
/* loaded from: classes.dex */
public final class c implements f {

    /* renamed from: d  reason: collision with root package name */
    public static String f5418d;

    /* renamed from: e  reason: collision with root package name */
    public static String f5419e;

    /* renamed from: b  reason: collision with root package name */
    public final List f5420b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5421c;

    public c(String str, ArrayList arrayList) {
        this.f5420b = arrayList;
        this.f5421c = str;
    }

    public static x4.h G(boolean z4) {
        if (f5418d == null) {
            ZApp zApp = ZApp.f4571h;
            if (zApp == null) {
                return null;
            }
            f5418d = zApp.getApplicationInfo().nativeLibraryDir;
        }
        int i5 = (z4 ? 2 : 0) | 1;
        x4.h j5 = x4.h.j(i5);
        if (j5 == null) {
            if ((i5 & 3) == 3) {
                j5 = x4.h.j(i5 & (-3));
            }
        }
        if (j5 != null) {
            j5.G(b0.i(new StringBuilder("export LD_LIBRARY_PATH="), f5418d, ":$LD_LIBRARY_PATH"), null, null);
            if (f5419e == null) {
                StringBuilder sb = new StringBuilder();
                if (j5.G("cat /proc/mounts | grep \"0/emulated \"", null, new w.g(11, sb)) == 0 && sb.length() != 0) {
                    f5419e = sb.toString().trim();
                } else if (Build.VERSION.SDK_INT < 30) {
                    f5419e = "/mnt/runtime/write/emulated/0";
                } else {
                    f5419e = "/mnt/pass_through/0/emulated/0";
                }
            }
        }
        return j5;
    }

    public static c j(String str, int i5, StringBuilder sb) {
        x4.h G = G(false);
        if (G == null) {
            return null;
        }
        if (str.startsWith("/mnt/user/0/emulated/0/")) {
            if (sb != null) {
                sb.append("Fix the /mnt/user/0/emulated/0 to /storage/emulated/0\n");
            }
            str = str.replace("/mnt/user/0/emulated/0/", "/storage/emulated/0/");
        }
        try {
            String str2 = f5418d + "/libdtool.so";
            StringBuilder sb2 = new StringBuilder();
            if (G.G(str2 + " loop-get \"" + str + "\"", sb2, null) != 0) {
                if (sb != null) {
                    sb.append((CharSequence) sb2);
                }
                return null;
            }
            String trim = sb2.toString().trim();
            ArrayList arrayList = new ArrayList();
            if (G.G(str2 + " parts " + trim, null, new q3.b(i5, arrayList)) != 0) {
                return null;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ru.zdevs.zugate.jni.b bVar = (ru.zdevs.zugate.jni.b) it.next();
                String j5 = bVar.f4623f ? bVar.j() : bVar.f4626i;
                G.G("cat /proc/mounts | grep \"" + j5 + " \"", null, new a(bVar, j5, 0));
            }
            return new c(trim, arrayList);
        } finally {
            G.close();
        }
    }

    @Override // w4.f
    public final ru.zdevs.zugate.jni.d F(int i5) {
        if (i5 < 0 || i5 >= w()) {
            return null;
        }
        return (ru.zdevs.zugate.jni.d) this.f5420b.get(i5);
    }

    @Override // w4.f
    public final void a() {
        x4.h G;
        for (ru.zdevs.zugate.jni.b bVar : this.f5420b) {
            try {
                bVar.close();
            } catch (Exception unused) {
            }
        }
        String str = this.f5421c;
        if (str == null || (G = G(false)) == null) {
            return;
        }
        String i5 = b0.i(new StringBuilder(), f5418d, "/libdtool.so");
        G.G(i5 + " loop-free " + str, null, null);
        G.close();
    }

    @Override // w4.f
    public final int b(int i5) {
        if (i5 < 0 || i5 >= w()) {
            return -1;
        }
        return ((ru.zdevs.zugate.jni.b) this.f5420b.get(i5)).f4622e;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // w4.f
    public final long e(int i5) {
        if (i5 < 0 || i5 >= w()) {
            return -1L;
        }
        return ((ru.zdevs.zugate.jni.b) this.f5420b.get(i5)).f4620c;
    }

    @Override // w4.f
    public final String g(int i5) {
        if (i5 < 0 || i5 >= w()) {
            return null;
        }
        return ((ru.zdevs.zugate.jni.b) this.f5420b.get(i5)).f4627j;
    }

    @Override // w4.f
    public final boolean l() {
        return false;
    }

    @Override // w4.f
    public final boolean m() {
        return this.f5421c != null;
    }

    @Override // w4.f
    public final long u(int i5) {
        if (i5 < 0 || i5 >= w()) {
            return 0L;
        }
        return ((ru.zdevs.zugate.jni.b) this.f5420b.get(i5)).f4621d;
    }

    @Override // w4.f
    public final int w() {
        return this.f5420b.size();
    }
}

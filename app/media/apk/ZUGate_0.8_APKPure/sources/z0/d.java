package z0;

import android.graphics.Path;
import android.util.Log;
import d2.n;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public final class d implements e, z1.b {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f5791g;

    public /* synthetic */ d(int i5, Object obj) {
        this.f5791g = i5;
    }

    public static void a(int i5, int i6) {
        if (i5 < 0 || i5 >= i6) {
            throw new IndexOutOfBoundsException("index: " + i5 + ", size: " + i6);
        }
    }

    public static void b(int i5, int i6) {
        if (i5 < 0 || i5 > i6) {
            throw new IndexOutOfBoundsException("index: " + i5 + ", size: " + i6);
        }
    }

    public static b1.e c(b1.f fVar) {
        e4.e.f(fVar, "owner");
        return new b1.e(fVar);
    }

    public static Path d(float f5, float f6, float f7, float f8) {
        Path path = new Path();
        path.moveTo(f5, f6);
        path.lineTo(f7, f8);
        return path;
    }

    @Override // z3.a
    public final Object get() {
        int i5 = this.f5791g;
        switch (i5) {
            case 11:
                return new androidx.biometric.m(Executors.newSingleThreadExecutor());
            case 12:
                return "com.google.android.datatransport.events";
            case 13:
                return Integer.valueOf(n.f2536e);
            case 14:
                d2.a aVar = d2.a.f2507f;
                if (aVar != null) {
                    return aVar;
                }
                throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
            case 15:
                switch (i5) {
                    case 15:
                        return new f2.b(1);
                    default:
                        return new f2.b(0);
                }
            default:
                switch (i5) {
                    case 15:
                        return new f2.b(1);
                    default:
                        return new f2.b(0);
                }
        }
    }

    @Override // z0.e
    public final void k() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // z0.e
    public final void n(int i5, Object obj) {
        String str;
        switch (i5) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i5 == 6 || i5 == 7 || i5 == 8) {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        } else {
            Log.d("ProfileInstaller", str);
        }
    }

    public d(int i5) {
        this.f5791g = i5;
    }
}

package q3;

import android.view.View;
import com.google.android.material.sidesheet.SideSheetBehavior;
import i0.t;
import java.util.List;
import x4.g;
/* loaded from: classes.dex */
public final /* synthetic */ class b implements t, g {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f4457g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f4458h;

    public /* synthetic */ b(int i5, Object obj) {
        this.f4458h = obj;
        this.f4457g = i5;
    }

    @Override // i0.t
    public final boolean c(View view) {
        ((SideSheetBehavior) this.f4458h).w(this.f4457g);
        return true;
    }

    @Override // x4.g
    public final void d(String str) {
        long j5;
        int i5;
        List list = (List) this.f4458h;
        int i6 = this.f4457g;
        int indexOf = str.indexOf(32);
        try {
            j5 = Long.parseLong(str.substring(0, indexOf));
        } catch (Exception unused) {
            j5 = 0;
        }
        int i7 = indexOf + 1;
        int indexOf2 = str.indexOf(32, i7);
        int i8 = 100;
        try {
            i5 = Integer.parseInt(str.substring(i7, indexOf2));
        } catch (Exception unused2) {
            i5 = 100;
        }
        int i9 = indexOf2 + 1;
        int indexOf3 = str.indexOf(32, i9);
        try {
            i8 = Integer.parseInt(str.substring(i9, indexOf3));
        } catch (Exception unused3) {
        }
        int i10 = indexOf3 + 1;
        int indexOf4 = str.indexOf(32, i10);
        String substring = str.substring(i10, indexOf4);
        int i11 = indexOf4 + 1;
        list.add(new ru.zdevs.zugate.jni.b(j5, i5, i8 != 0, substring, str.length() > i11 ? str.substring(i11) : null, -1L, i6));
    }
}

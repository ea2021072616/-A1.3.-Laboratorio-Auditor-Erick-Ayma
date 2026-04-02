package h0;

import android.view.ContentInfo;
import android.view.View;
import java.util.Objects;
/* loaded from: classes.dex */
public abstract class v0 {
    public static String[] a(View view) {
        return view.getReceiveContentMimeTypes();
    }

    public static g b(View view, g gVar) {
        ContentInfo m5 = gVar.f3131a.m();
        Objects.requireNonNull(m5);
        ContentInfo h5 = b3.a.h(m5);
        ContentInfo performReceiveContent = view.performReceiveContent(h5);
        if (performReceiveContent == null) {
            return null;
        }
        return performReceiveContent == h5 ? gVar : new g(new d.u0(performReceiveContent));
    }

    public static void c(View view, String[] strArr, y yVar) {
        if (yVar == null) {
            view.setOnReceiveContentListener(strArr, null);
        } else {
            view.setOnReceiveContentListener(strArr, new w0(yVar));
        }
    }
}

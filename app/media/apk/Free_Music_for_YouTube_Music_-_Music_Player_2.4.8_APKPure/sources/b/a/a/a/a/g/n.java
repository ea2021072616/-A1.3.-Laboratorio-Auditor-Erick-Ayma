package b.a.a.a.a.g;

import android.content.Context;
import android.graphics.BitmapFactory;
/* compiled from: IconRequest.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public final String f233a;

    /* renamed from: b  reason: collision with root package name */
    public final int f234b;

    /* renamed from: c  reason: collision with root package name */
    public final int f235c;
    public final int d;

    public n(String str, int i, int i2, int i3) {
        this.f233a = str;
        this.f234b = i;
        this.f235c = i2;
        this.d = i3;
    }

    public static n a(Context context, String str) {
        if (str != null) {
            try {
                int l = b.a.a.a.a.b.i.l(context);
                b.a.a.a.c.h().a("Fabric", "App icon resource ID is " + l);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(context.getResources(), l, options);
                return new n(str, l, options.outWidth, options.outHeight);
            } catch (Exception e) {
                b.a.a.a.c.h().e("Fabric", "Failed to load icon", e);
            }
        }
        return null;
    }
}

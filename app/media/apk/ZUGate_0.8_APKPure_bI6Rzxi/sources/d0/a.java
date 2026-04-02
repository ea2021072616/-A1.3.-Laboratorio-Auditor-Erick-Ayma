package d0;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;
/* loaded from: classes.dex */
public abstract class a {
    public static final void a(Bundle bundle, String str, Size size) {
        bundle.putSize(str, size);
    }

    public static final void b(Bundle bundle, String str, SizeF sizeF) {
        bundle.putSizeF(str, sizeF);
    }
}

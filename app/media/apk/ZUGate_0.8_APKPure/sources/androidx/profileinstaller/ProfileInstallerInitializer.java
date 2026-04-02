package androidx.profileinstaller;

import android.content.Context;
import c1.b;
import d.v;
import java.util.Collections;
import java.util.List;
import z0.d;
import z0.h;
/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements b {
    @Override // c1.b
    public final List a() {
        return Collections.emptyList();
    }

    @Override // c1.b
    public final Object b(Context context) {
        h.a(new v(this, 4, context.getApplicationContext()));
        return new d(1, null);
    }
}

package com.facebook.ads.internal.i.a;

import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public abstract class b {
    public abstract void a(n nVar);

    public void a(Exception exc) {
        ThrowableExtension.printStackTrace(exc);
    }
}

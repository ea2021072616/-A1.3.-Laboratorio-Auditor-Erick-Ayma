package com.facebook.ads.internal.util;

import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.PrintWriter;
import java.io.StringWriter;
/* loaded from: classes.dex */
public class ae {
    public static final String a(Throwable th) {
        if (th == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ThrowableExtension.printStackTrace(th, printWriter);
        printWriter.close();
        return stringWriter.toString();
    }
}

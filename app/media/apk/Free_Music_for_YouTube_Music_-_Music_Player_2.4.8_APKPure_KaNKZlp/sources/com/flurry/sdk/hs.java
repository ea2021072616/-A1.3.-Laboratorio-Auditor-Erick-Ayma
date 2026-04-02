package com.flurry.sdk;

import android.content.Context;
import java.io.File;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class hs {

    /* renamed from: b  reason: collision with root package name */
    private static final String f1804b = hs.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    boolean f1805a;

    /* renamed from: c  reason: collision with root package name */
    private final ht f1806c;
    private final File d;
    private String e;

    public hs() {
        this(jy.a().f2022a);
    }

    public hs(Context context) {
        this.f1806c = new ht();
        this.d = context.getFileStreamPath(".flurryinstallreceiver.");
        km.a(3, f1804b, "Referrer file name if it exists:  " + this.d);
    }

    public final synchronized Map<String, List<String>> a() {
        c();
        return ht.a(this.e);
    }

    private void c() {
        if (!this.f1805a) {
            this.f1805a = true;
            km.a(4, f1804b, "Loading referrer info from file: " + this.d.getAbsolutePath());
            String c2 = lx.c(this.d);
            km.a(f1804b, "Referrer file contents: " + c2);
            b(c2);
        }
    }

    private void b(String str) {
        if (str != null) {
            this.e = str;
        }
    }

    public final synchronized String b() {
        c();
        return this.e;
    }

    public final synchronized void a(String str) {
        this.f1805a = true;
        b(str);
        lx.a(this.d, this.e);
    }
}

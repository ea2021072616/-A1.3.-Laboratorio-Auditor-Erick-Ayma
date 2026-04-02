package com.flurry.sdk;

import java.io.File;
/* loaded from: classes.dex */
public class kf<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2041a = kf.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final File f2042b;

    /* renamed from: c  reason: collision with root package name */
    private final lg<T> f2043c;

    public kf(File file, String str, int i, lj<T> ljVar) {
        this.f2042b = file;
        this.f2043c = new le(new li(str, i, ljVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final T a() {
        /*
            r8 = this;
            r7 = 3
            r0 = 0
            java.io.File r1 = r8.f2042b
            if (r1 != 0) goto L7
        L6:
            return r0
        L7:
            java.io.File r1 = r8.f2042b
            boolean r1 = r1.exists()
            if (r1 != 0) goto L2b
            r1 = 5
            java.lang.String r2 = com.flurry.sdk.kf.f2041a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "No data to read for file:"
            r3.<init>(r4)
            java.io.File r4 = r8.f2042b
            java.lang.String r4 = r4.getName()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.flurry.sdk.km.a(r1, r2, r3)
            goto L6
        L2b:
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L80
            java.io.File r3 = r8.f2042b     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L80
            r2.<init>(r3)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L80
            com.flurry.sdk.lg<T> r3 = r8.f2043c     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L89
            java.lang.Object r0 = r3.a(r2)     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L89
            com.flurry.sdk.ly.a(r2)
        L3c:
            if (r1 == 0) goto L6
            java.lang.String r1 = com.flurry.sdk.kf.f2041a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Deleting data file:"
            r2.<init>(r3)
            java.io.File r3 = r8.f2042b
            java.lang.String r3 = r3.getName()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.flurry.sdk.km.a(r7, r1, r2)
            java.io.File r1 = r8.f2042b
            r1.delete()
            goto L6
        L5e:
            r1 = move-exception
            r2 = r0
        L60:
            r3 = 3
            java.lang.String r4 = com.flurry.sdk.kf.f2041a     // Catch: java.lang.Throwable -> L87
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L87
            java.lang.String r6 = "Error reading data file:"
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L87
            java.io.File r6 = r8.f2042b     // Catch: java.lang.Throwable -> L87
            java.lang.String r6 = r6.getName()     // Catch: java.lang.Throwable -> L87
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L87
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L87
            com.flurry.sdk.km.a(r3, r4, r5, r1)     // Catch: java.lang.Throwable -> L87
            r1 = 1
            com.flurry.sdk.ly.a(r2)
            goto L3c
        L80:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L83:
            com.flurry.sdk.ly.a(r2)
            throw r0
        L87:
            r0 = move-exception
            goto L83
        L89:
            r1 = move-exception
            goto L60
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.kf.a():java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(T r9) {
        /*
            r8 = this;
            r3 = 1
            r7 = 3
            r0 = 0
            r1 = 0
            if (r9 != 0) goto L43
            java.lang.String r0 = com.flurry.sdk.kf.f2041a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "No data to write for file:"
            r1.<init>(r2)
            java.io.File r2 = r8.f2042b
            java.lang.String r2 = r2.getName()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.flurry.sdk.km.a(r7, r0, r1)
            r0 = r3
        L21:
            if (r0 == 0) goto L42
            java.lang.String r0 = com.flurry.sdk.kf.f2041a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Deleting data file:"
            r1.<init>(r2)
            java.io.File r2 = r8.f2042b
            java.lang.String r2 = r2.getName()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.flurry.sdk.km.a(r7, r0, r1)
            java.io.File r0 = r8.f2042b
            r0.delete()
        L42:
            return
        L43:
            java.io.File r2 = r8.f2042b     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L84
            boolean r2 = com.flurry.sdk.lx.a(r2)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L84
            if (r2 != 0) goto L74
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L84
            java.lang.String r2 = "Cannot create parent directory!"
            r0.<init>(r2)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L84
            throw r0     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L84
        L53:
            r0 = move-exception
        L54:
            r2 = 3
            java.lang.String r4 = com.flurry.sdk.kf.f2041a     // Catch: java.lang.Throwable -> L84
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L84
            java.lang.String r6 = "Error writing data file:"
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L84
            java.io.File r6 = r8.f2042b     // Catch: java.lang.Throwable -> L84
            java.lang.String r6 = r6.getName()     // Catch: java.lang.Throwable -> L84
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L84
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L84
            com.flurry.sdk.km.a(r2, r4, r5, r0)     // Catch: java.lang.Throwable -> L84
            com.flurry.sdk.ly.a(r1)
            r0 = r3
            goto L21
        L74:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L84
            java.io.File r4 = r8.f2042b     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L84
            r2.<init>(r4)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L84
            com.flurry.sdk.lg<T> r1 = r8.f2043c     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8c
            r1.a(r2, r9)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8c
            com.flurry.sdk.ly.a(r2)
            goto L21
        L84:
            r0 = move-exception
        L85:
            com.flurry.sdk.ly.a(r1)
            throw r0
        L89:
            r0 = move-exception
            r1 = r2
            goto L85
        L8c:
            r0 = move-exception
            r1 = r2
            goto L54
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.kf.a(java.lang.Object):void");
    }

    public final boolean b() {
        if (this.f2042b == null) {
            return false;
        }
        return this.f2042b.delete();
    }
}

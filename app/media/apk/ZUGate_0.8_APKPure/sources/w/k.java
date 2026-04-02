package w;
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f5266a = new Object();

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
        if (r5 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
        if (r5 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r5, java.lang.String r6) {
        /*
            java.lang.Object r0 = w.k.f5266a
            monitor-enter(r0)
            java.lang.String r1 = ""
            boolean r1 = r6.equals(r1)     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L12
            java.lang.String r6 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            r5.deleteFile(r6)     // Catch: java.lang.Throwable -> L69
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L69
            return
        L12:
            r1 = 0
            java.lang.String r2 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.io.FileOutputStream r5 = r5.openFileOutput(r2, r1)     // Catch: java.io.FileNotFoundException -> L55 java.lang.Throwable -> L69
            org.xmlpull.v1.XmlSerializer r1 = android.util.Xml.newSerializer()     // Catch: java.lang.Throwable -> L69
            r2 = 0
            r1.setOutput(r5, r2)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            java.lang.String r3 = "UTF-8"
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r1.startDocument(r3, r4)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            java.lang.String r3 = "locales"
            r1.startTag(r2, r3)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            java.lang.String r3 = "application_locales"
            r1.attribute(r2, r3, r6)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            java.lang.String r6 = "locales"
            r1.endTag(r2, r6)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r1.endDocument()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            if (r5 == 0) goto L4d
        L3c:
            r5.close()     // Catch: java.io.IOException -> L4d java.lang.Throwable -> L69
            goto L4d
        L40:
            r6 = move-exception
            goto L4f
        L42:
            r6 = move-exception
            java.lang.String r1 = "AppLocalesStorageHelper"
            java.lang.String r2 = "Storing App Locales : Failed to persist app-locales in storage "
            android.util.Log.w(r1, r2, r6)     // Catch: java.lang.Throwable -> L40
            if (r5 == 0) goto L4d
            goto L3c
        L4d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L69
            return
        L4f:
            if (r5 == 0) goto L54
            r5.close()     // Catch: java.io.IOException -> L54 java.lang.Throwable -> L69
        L54:
            throw r6     // Catch: java.lang.Throwable -> L69
        L55:
            java.lang.String r5 = "AppLocalesStorageHelper"
            java.lang.String r6 = "Storing App Locales : FileNotFoundException: Cannot open file %s for writing "
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            r2[r1] = r3     // Catch: java.lang.Throwable -> L69
            java.lang.String r6 = java.lang.String.format(r6, r2)     // Catch: java.lang.Throwable -> L69
            android.util.Log.w(r5, r6)     // Catch: java.lang.Throwable -> L69
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L69
            return
        L69:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L69
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: w.k.a(android.content.Context, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        r1 = r3.getAttributeValue(null, "application_locales");
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
        if (r2 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
        if (r2 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
        if (r1.isEmpty() == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
        r8.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(android.content.Context r8) {
        /*
            java.lang.Object r0 = w.k.f5266a
            monitor-enter(r0)
            java.lang.String r1 = ""
            java.lang.String r2 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.io.FileInputStream r2 = r8.openFileInput(r2)     // Catch: java.io.FileNotFoundException -> L67 java.lang.Throwable -> L69
            org.xmlpull.v1.XmlPullParser r3 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49
            java.lang.String r4 = "UTF-8"
            r3.setInput(r2, r4)     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49
            int r4 = r3.getDepth()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49
        L18:
            int r5 = r3.next()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49
            r6 = 1
            if (r5 == r6) goto L41
            r6 = 3
            if (r5 != r6) goto L28
            int r7 = r3.getDepth()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49
            if (r7 <= r4) goto L41
        L28:
            if (r5 == r6) goto L18
            r6 = 4
            if (r5 != r6) goto L2e
            goto L18
        L2e:
            java.lang.String r5 = r3.getName()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49
            java.lang.String r6 = "locales"
            boolean r5 = r5.equals(r6)     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49
            if (r5 == 0) goto L18
            java.lang.String r4 = "application_locales"
            r5 = 0
            java.lang.String r1 = r3.getAttributeValue(r5, r4)     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49
        L41:
            if (r2 == 0) goto L53
        L43:
            r2.close()     // Catch: java.io.IOException -> L53 java.lang.Throwable -> L69
            goto L53
        L47:
            r8 = move-exception
            goto L61
        L49:
            java.lang.String r3 = "AppLocalesStorageHelper"
            java.lang.String r4 = "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r3, r4)     // Catch: java.lang.Throwable -> L47
            if (r2 == 0) goto L53
            goto L43
        L53:
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Throwable -> L69
            if (r2 != 0) goto L5a
            goto L5f
        L5a:
            java.lang.String r2 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            r8.deleteFile(r2)     // Catch: java.lang.Throwable -> L69
        L5f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L69
            return r1
        L61:
            if (r2 == 0) goto L66
            r2.close()     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L69
        L66:
            throw r8     // Catch: java.lang.Throwable -> L69
        L67:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L69
            return r1
        L69:
            r8 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L69
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: w.k.b(android.content.Context):java.lang.String");
    }
}

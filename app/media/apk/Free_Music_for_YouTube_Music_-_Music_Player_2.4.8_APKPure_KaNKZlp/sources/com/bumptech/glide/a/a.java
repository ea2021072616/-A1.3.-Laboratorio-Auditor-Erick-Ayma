package com.bumptech.glide.a;

import com.facebook.appevents.AppEventsConstants;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: DiskLruCache.java */
/* loaded from: classes.dex */
public final class a implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    private final File f605b;

    /* renamed from: c  reason: collision with root package name */
    private final File f606c;
    private final File d;
    private final File e;
    private final int f;
    private long g;
    private final int h;
    private Writer j;
    private int l;
    private long i = 0;
    private final LinkedHashMap<String, b> k = new LinkedHashMap<>(0, 0.75f, true);
    private long m = 0;

    /* renamed from: a  reason: collision with root package name */
    final ThreadPoolExecutor f604a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> n = new Callable<Void>() { // from class: com.bumptech.glide.a.a.1
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.j != null) {
                    a.this.g();
                    if (a.this.e()) {
                        a.this.d();
                        a.this.l = 0;
                    }
                }
            }
            return null;
        }
    };

    private a(File file, int i, int i2, long j) {
        this.f605b = file;
        this.f = i;
        this.f606c = new File(file, "journal");
        this.d = new File(file, "journal.tmp");
        this.e = new File(file, "journal.bkp");
        this.h = i2;
        this.g = j;
    }

    public static a a(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                a(file2, file3, false);
            }
        }
        a aVar = new a(file, i, i2, j);
        if (aVar.f606c.exists()) {
            try {
                aVar.b();
                aVar.c();
                return aVar;
            } catch (IOException e) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                aVar.a();
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, i, i2, j);
        aVar2.d();
        return aVar2;
    }

    private void b() throws IOException {
        com.bumptech.glide.a.b bVar = new com.bumptech.glide.a.b(new FileInputStream(this.f606c), com.bumptech.glide.a.c.f621a);
        try {
            String a2 = bVar.a();
            String a3 = bVar.a();
            String a4 = bVar.a();
            String a5 = bVar.a();
            String a6 = bVar.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(a3) || !Integer.toString(this.f).equals(a4) || !Integer.toString(this.h).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + ", " + a3 + ", " + a5 + ", " + a6 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    d(bVar.a());
                    i++;
                } catch (EOFException e) {
                    this.l = i - this.k.size();
                    if (bVar.b()) {
                        d();
                    } else {
                        this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f606c, true), com.bumptech.glide.a.c.f621a));
                    }
                    com.bumptech.glide.a.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bumptech.glide.a.c.a(bVar);
            throw th;
        }
    }

    private void d(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            String substring2 = str.substring(i);
            if (indexOf == "REMOVE".length() && str.startsWith("REMOVE")) {
                this.k.remove(substring2);
                return;
            }
            substring = substring2;
        } else {
            substring = str.substring(i, indexOf2);
        }
        b bVar = this.k.get(substring);
        if (bVar == null) {
            bVar = new b(substring);
            this.k.put(substring, bVar);
        }
        if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            bVar.f = true;
            bVar.g = null;
            bVar.a(split);
        } else if (indexOf2 != -1 || indexOf != "DIRTY".length() || !str.startsWith("DIRTY")) {
            if (indexOf2 != -1 || indexOf != "READ".length() || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            bVar.g = new C0019a(bVar);
        }
    }

    private void c() throws IOException {
        a(this.d);
        Iterator<b> it = this.k.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.g == null) {
                for (int i = 0; i < this.h; i++) {
                    this.i += next.e[i];
                }
            } else {
                next.g = null;
                for (int i2 = 0; i2 < this.h; i2++) {
                    a(next.a(i2));
                    a(next.b(i2));
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() throws IOException {
        if (this.j != null) {
            this.j.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d), com.bumptech.glide.a.c.f621a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.h));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (b bVar : this.k.values()) {
            if (bVar.g != null) {
                bufferedWriter.write("DIRTY " + bVar.d + '\n');
            } else {
                bufferedWriter.write("CLEAN " + bVar.d + bVar.a() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.f606c.exists()) {
            a(this.f606c, this.e, true);
        }
        a(this.d, this.f606c, false);
        this.e.delete();
        this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f606c, true), com.bumptech.glide.a.c.f621a));
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
        r9.l++;
        r9.j.append((java.lang.CharSequence) "READ");
        r9.j.append(' ');
        r9.j.append((java.lang.CharSequence) r10);
        r9.j.append('\n');
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
        if (e() == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
        r9.f604a.submit(r9.n);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0055, code lost:
        r1 = new com.bumptech.glide.a.a.c(r9, r10, r0.h, r0.f611a, r0.e, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.bumptech.glide.a.a.c a(java.lang.String r10) throws java.io.IOException {
        /*
            r9 = this;
            r1 = 0
            monitor-enter(r9)
            r9.f()     // Catch: java.lang.Throwable -> L68
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.a.a$b> r0 = r9.k     // Catch: java.lang.Throwable -> L68
            java.lang.Object r0 = r0.get(r10)     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.a.a$b r0 = (com.bumptech.glide.a.a.b) r0     // Catch: java.lang.Throwable -> L68
            if (r0 != 0) goto L11
        Lf:
            monitor-exit(r9)
            return r1
        L11:
            boolean r2 = com.bumptech.glide.a.a.b.d(r0)     // Catch: java.lang.Throwable -> L68
            if (r2 == 0) goto Lf
            java.io.File[] r3 = r0.f611a     // Catch: java.lang.Throwable -> L68
            int r4 = r3.length     // Catch: java.lang.Throwable -> L68
            r2 = 0
        L1b:
            if (r2 >= r4) goto L28
            r5 = r3[r2]     // Catch: java.lang.Throwable -> L68
            boolean r5 = r5.exists()     // Catch: java.lang.Throwable -> L68
            if (r5 == 0) goto Lf
            int r2 = r2 + 1
            goto L1b
        L28:
            int r1 = r9.l     // Catch: java.lang.Throwable -> L68
            int r1 = r1 + 1
            r9.l = r1     // Catch: java.lang.Throwable -> L68
            java.io.Writer r1 = r9.j     // Catch: java.lang.Throwable -> L68
            java.lang.String r2 = "READ"
            r1.append(r2)     // Catch: java.lang.Throwable -> L68
            java.io.Writer r1 = r9.j     // Catch: java.lang.Throwable -> L68
            r2 = 32
            r1.append(r2)     // Catch: java.lang.Throwable -> L68
            java.io.Writer r1 = r9.j     // Catch: java.lang.Throwable -> L68
            r1.append(r10)     // Catch: java.lang.Throwable -> L68
            java.io.Writer r1 = r9.j     // Catch: java.lang.Throwable -> L68
            r2 = 10
            r1.append(r2)     // Catch: java.lang.Throwable -> L68
            boolean r1 = r9.e()     // Catch: java.lang.Throwable -> L68
            if (r1 == 0) goto L55
            java.util.concurrent.ThreadPoolExecutor r1 = r9.f604a     // Catch: java.lang.Throwable -> L68
            java.util.concurrent.Callable<java.lang.Void> r2 = r9.n     // Catch: java.lang.Throwable -> L68
            r1.submit(r2)     // Catch: java.lang.Throwable -> L68
        L55:
            com.bumptech.glide.a.a$c r1 = new com.bumptech.glide.a.a$c     // Catch: java.lang.Throwable -> L68
            long r4 = com.bumptech.glide.a.a.b.e(r0)     // Catch: java.lang.Throwable -> L68
            java.io.File[] r6 = r0.f611a     // Catch: java.lang.Throwable -> L68
            long[] r7 = com.bumptech.glide.a.a.b.b(r0)     // Catch: java.lang.Throwable -> L68
            r8 = 0
            r2 = r9
            r3 = r10
            r1.<init>(r3, r4, r6, r7)     // Catch: java.lang.Throwable -> L68
            goto Lf
        L68:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.a.a.a(java.lang.String):com.bumptech.glide.a.a$c");
    }

    public C0019a b(String str) throws IOException {
        return a(str, -1L);
    }

    private synchronized C0019a a(String str, long j) throws IOException {
        b bVar;
        C0019a c0019a;
        f();
        b bVar2 = this.k.get(str);
        if (j == -1 || (bVar2 != null && bVar2.h == j)) {
            if (bVar2 == null) {
                b bVar3 = new b(str);
                this.k.put(str, bVar3);
                bVar = bVar3;
            } else if (bVar2.g != null) {
                c0019a = null;
            } else {
                bVar = bVar2;
            }
            c0019a = new C0019a(bVar);
            bVar.g = c0019a;
            this.j.append((CharSequence) "DIRTY");
            this.j.append(' ');
            this.j.append((CharSequence) str);
            this.j.append('\n');
            this.j.flush();
        } else {
            c0019a = null;
        }
        return c0019a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C0019a c0019a, boolean z) throws IOException {
        synchronized (this) {
            b bVar = c0019a.f609b;
            if (bVar.g != c0019a) {
                throw new IllegalStateException();
            }
            if (z && !bVar.f) {
                for (int i = 0; i < this.h; i++) {
                    if (!c0019a.f610c[i]) {
                        c0019a.b();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    } else if (!bVar.b(i).exists()) {
                        c0019a.b();
                        break;
                    }
                }
            }
            for (int i2 = 0; i2 < this.h; i2++) {
                File b2 = bVar.b(i2);
                if (z) {
                    if (b2.exists()) {
                        File a2 = bVar.a(i2);
                        b2.renameTo(a2);
                        long j = bVar.e[i2];
                        long length = a2.length();
                        bVar.e[i2] = length;
                        this.i = (this.i - j) + length;
                    }
                } else {
                    a(b2);
                }
            }
            this.l++;
            bVar.g = null;
            if (bVar.f | z) {
                bVar.f = true;
                this.j.append((CharSequence) "CLEAN");
                this.j.append(' ');
                this.j.append((CharSequence) bVar.d);
                this.j.append((CharSequence) bVar.a());
                this.j.append('\n');
                if (z) {
                    long j2 = this.m;
                    this.m = 1 + j2;
                    bVar.h = j2;
                }
            } else {
                this.k.remove(bVar.d);
                this.j.append((CharSequence) "REMOVE");
                this.j.append(' ');
                this.j.append((CharSequence) bVar.d);
                this.j.append('\n');
            }
            this.j.flush();
            if (this.i > this.g || e()) {
                this.f604a.submit(this.n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        return this.l >= 2000 && this.l >= this.k.size();
    }

    public synchronized boolean c(String str) throws IOException {
        boolean z;
        synchronized (this) {
            f();
            b bVar = this.k.get(str);
            if (bVar == null || bVar.g != null) {
                z = false;
            } else {
                for (int i = 0; i < this.h; i++) {
                    File a2 = bVar.a(i);
                    if (a2.exists() && !a2.delete()) {
                        throw new IOException("failed to delete " + a2);
                    }
                    this.i -= bVar.e[i];
                    bVar.e[i] = 0;
                }
                this.l++;
                this.j.append((CharSequence) "REMOVE");
                this.j.append(' ');
                this.j.append((CharSequence) str);
                this.j.append('\n');
                this.k.remove(str);
                if (e()) {
                    this.f604a.submit(this.n);
                }
                z = true;
            }
        }
        return z;
    }

    private void f() {
        if (this.j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.j != null) {
            Iterator it = new ArrayList(this.k.values()).iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar.g != null) {
                    bVar.g.b();
                }
            }
            g();
            this.j.close();
            this.j = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() throws IOException {
        while (this.i > this.g) {
            c(this.k.entrySet().iterator().next().getKey());
        }
    }

    public void a() throws IOException {
        close();
        com.bumptech.glide.a.c.a(this.f605b);
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class c {

        /* renamed from: b  reason: collision with root package name */
        private final String f615b;

        /* renamed from: c  reason: collision with root package name */
        private final long f616c;
        private final long[] d;
        private final File[] e;

        private c(String str, long j, File[] fileArr, long[] jArr) {
            this.f615b = str;
            this.f616c = j;
            this.e = fileArr;
            this.d = jArr;
        }

        public File a(int i) {
            return this.e[i];
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.bumptech.glide.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0019a {

        /* renamed from: b  reason: collision with root package name */
        private final b f609b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean[] f610c;
        private boolean d;

        private C0019a(b bVar) {
            this.f609b = bVar;
            this.f610c = bVar.f ? null : new boolean[a.this.h];
        }

        public File a(int i) throws IOException {
            File b2;
            synchronized (a.this) {
                if (this.f609b.g != this) {
                    throw new IllegalStateException();
                }
                if (!this.f609b.f) {
                    this.f610c[i] = true;
                }
                b2 = this.f609b.b(i);
                if (!a.this.f605b.exists()) {
                    a.this.f605b.mkdirs();
                }
            }
            return b2;
        }

        public void a() throws IOException {
            a.this.a(this, true);
            this.d = true;
        }

        public void b() throws IOException {
            a.this.a(this, false);
        }

        public void c() {
            if (!this.d) {
                try {
                    b();
                } catch (IOException e) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class b {

        /* renamed from: a  reason: collision with root package name */
        File[] f611a;

        /* renamed from: b  reason: collision with root package name */
        File[] f612b;
        private final String d;
        private final long[] e;
        private boolean f;
        private C0019a g;
        private long h;

        private b(String str) {
            this.d = str;
            this.e = new long[a.this.h];
            this.f611a = new File[a.this.h];
            this.f612b = new File[a.this.h];
            StringBuilder append = new StringBuilder(str).append('.');
            int length = append.length();
            for (int i = 0; i < a.this.h; i++) {
                append.append(i);
                this.f611a[i] = new File(a.this.f605b, append.toString());
                append.append(".tmp");
                this.f612b[i] = new File(a.this.f605b, append.toString());
                append.setLength(length);
            }
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.e) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) throws IOException {
            if (strArr.length != a.this.h) {
                throw b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.e[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException e) {
                    throw b(strArr);
                }
            }
        }

        private IOException b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i) {
            return this.f611a[i];
        }

        public File b(int i) {
            return this.f612b[i];
        }
    }
}

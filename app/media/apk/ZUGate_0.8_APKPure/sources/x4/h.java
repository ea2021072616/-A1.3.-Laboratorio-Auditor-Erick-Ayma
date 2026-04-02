package x4;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
/* loaded from: classes.dex */
public final class h implements Closeable {

    /* renamed from: f  reason: collision with root package name */
    public static int f5522f;

    /* renamed from: b  reason: collision with root package name */
    public final Process f5523b;

    /* renamed from: c  reason: collision with root package name */
    public final BufferedOutputStream f5524c;

    /* renamed from: d  reason: collision with root package name */
    public final f f5525d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5526e = false;

    public h(Process process, BufferedOutputStream bufferedOutputStream, f fVar) {
        this.f5523b = process;
        this.f5524c = bufferedOutputStream;
        this.f5525d = fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00bc A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static x4.h j(int r7) {
        /*
            r0 = 0
            java.lang.ProcessBuilder r1 = new java.lang.ProcessBuilder     // Catch: java.io.IOException -> Lc2
            r2 = 0
            java.lang.String[] r3 = new java.lang.String[r2]     // Catch: java.io.IOException -> Lc2
            r1.<init>(r3)     // Catch: java.io.IOException -> Lc2
            r3 = r7 & 1
            r4 = 1
            if (r3 != r4) goto L10
            r5 = r4
            goto L11
        L10:
            r5 = r2
        L11:
            if (r5 == 0) goto L32
            r5 = 2
            r7 = r7 & r5
            if (r7 != r5) goto L19
            r7 = r4
            goto L1a
        L19:
            r7 = r2
        L1a:
            java.lang.String r6 = "su"
            if (r7 == 0) goto L2a
            java.lang.String[] r7 = new java.lang.String[r5]     // Catch: java.io.IOException -> Lc2
            r7[r2] = r6     // Catch: java.io.IOException -> Lc2
            java.lang.String r5 = "--mount-master"
            r7[r4] = r5     // Catch: java.io.IOException -> Lc2
            r1.command(r7)     // Catch: java.io.IOException -> Lc2
            goto L3b
        L2a:
            java.lang.String[] r7 = new java.lang.String[]{r6}     // Catch: java.io.IOException -> Lc2
            r1.command(r7)     // Catch: java.io.IOException -> Lc2
            goto L3b
        L32:
            java.lang.String[] r7 = new java.lang.String[r4]     // Catch: java.io.IOException -> Lc2
            java.lang.String r5 = "sh"
            r7[r2] = r5     // Catch: java.io.IOException -> Lc2
            r1.command(r7)     // Catch: java.io.IOException -> Lc2
        L3b:
            java.lang.ProcessBuilder r7 = r1.redirectErrorStream(r4)     // Catch: java.io.IOException -> Lc2
            java.lang.Process r7 = r7.start()     // Catch: java.io.IOException -> Lc2
            x4.f r1 = new x4.f
            java.io.InputStream r5 = r7.getInputStream()
            r1.<init>(r5)
            java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream
            java.io.OutputStream r6 = r7.getOutputStream()
            r5.<init>(r6)
            if (r3 != r4) goto L59
            r3 = r4
            goto L5a
        L59:
            r3 = r2
        L5a:
            if (r3 == 0) goto Lbd
            r7.exitValue()     // Catch: java.lang.IllegalThreadStateException -> L60
            goto L61
        L60:
            r4 = r2
        L61:
            if (r4 == 0) goto L64
            goto Lb9
        L64:
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.io.IOException -> Lb9
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.io.IOException -> Lb9
            r4.<init>(r1)     // Catch: java.io.IOException -> Lb9
            r3.<init>(r4)     // Catch: java.io.IOException -> Lb9
            java.lang.String r4 = "echo TE_ST\n"
            java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> Laf
            byte[] r4 = r4.getBytes(r6)     // Catch: java.lang.Throwable -> Laf
            r5.write(r4)     // Catch: java.lang.Throwable -> Laf
            r5.flush()     // Catch: java.lang.Throwable -> Laf
            java.lang.String r4 = r3.readLine()     // Catch: java.lang.Throwable -> Laf
            if (r4 == 0) goto Lab
            java.lang.String r6 = "TE_ST"
            boolean r4 = r4.contains(r6)     // Catch: java.lang.Throwable -> Laf
            if (r4 != 0) goto L8b
            goto Lab
        L8b:
            java.lang.String r4 = "id\n"
            java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> Laf
            byte[] r4 = r4.getBytes(r6)     // Catch: java.lang.Throwable -> Laf
            r5.write(r4)     // Catch: java.lang.Throwable -> Laf
            r5.flush()     // Catch: java.lang.Throwable -> Laf
            java.lang.String r4 = r3.readLine()     // Catch: java.lang.Throwable -> Laf
            if (r4 == 0) goto Lab
            java.lang.String r6 = "uid=0"
            boolean r4 = r4.contains(r6)     // Catch: java.lang.Throwable -> Laf
            if (r4 == 0) goto Lab
            r3.close()     // Catch: java.io.IOException -> Lb9
            goto Lba
        Lab:
            r3.close()     // Catch: java.io.IOException -> Lb9
            goto Lb9
        Laf:
            r2 = move-exception
            r3.close()     // Catch: java.lang.Throwable -> Lb4
            goto Lb8
        Lb4:
            r3 = move-exception
            r2.addSuppressed(r3)     // Catch: java.io.IOException -> Lb9
        Lb8:
            throw r2     // Catch: java.io.IOException -> Lb9
        Lb9:
            r2 = -1
        Lba:
            if (r2 == 0) goto Lbd
            return r0
        Lbd:
            x4.h r0 = new x4.h
            r0.<init>(r7, r5, r1)
        Lc2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.h.j(int):x4.h");
    }

    public final int G(String str, StringBuilder sb, g gVar) {
        boolean z4;
        BufferedOutputStream bufferedOutputStream = this.f5524c;
        f fVar = this.f5525d;
        try {
            this.f5523b.exitValue();
            z4 = true;
        } catch (IllegalThreadStateException unused) {
            z4 = false;
        }
        int i5 = -1;
        if (z4) {
            return -1;
        }
        try {
            if (fVar.available() > 0) {
                fVar.skip(fVar.available());
            }
        } catch (IOException unused2) {
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fVar));
            bufferedOutputStream.write((str + " ; echo -e \"\\n##>$?\\n\" \r\n").getBytes(StandardCharsets.UTF_8));
            bufferedOutputStream.flush();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (!readLine.isEmpty()) {
                    if (readLine.startsWith("##>")) {
                        try {
                            i5 = Integer.parseInt(readLine.substring(3));
                            break;
                        } catch (NumberFormatException unused3) {
                        }
                    } else if (readLine.contains("Permission denied")) {
                        break;
                    } else {
                        if (gVar != null) {
                            gVar.d(readLine);
                        }
                        if (sb != null) {
                            sb.append(readLine);
                            sb.append("\n");
                        }
                    }
                }
            }
            bufferedReader.close();
        } catch (IOException unused4) {
        }
        return i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f5526e) {
            return;
        }
        this.f5526e = true;
        try {
            this.f5525d.j();
        } catch (Exception unused) {
        }
        try {
            this.f5524c.close();
        } catch (Exception unused2) {
        }
        try {
            this.f5523b.destroy();
        } catch (Exception unused3) {
        }
    }

    public final void finalize() {
        try {
            close();
        } catch (Exception unused) {
        }
    }
}

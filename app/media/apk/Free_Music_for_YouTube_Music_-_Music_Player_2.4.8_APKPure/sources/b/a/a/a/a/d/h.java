package b.a.a.a.a.d;

import android.content.Context;
import b.a.a.a.a.b.q;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* compiled from: QueueFileEventStorage.java */
/* loaded from: classes.dex */
public class h implements c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f179a;

    /* renamed from: b  reason: collision with root package name */
    private final File f180b;

    /* renamed from: c  reason: collision with root package name */
    private final String f181c;
    private final File d;
    private q e;
    private File f;

    public h(Context context, File file, String str, String str2) throws IOException {
        this.f179a = context;
        this.f180b = file;
        this.f181c = str2;
        this.d = new File(this.f180b, str);
        this.e = new q(this.d);
        e();
    }

    private void e() {
        this.f = new File(this.f180b, this.f181c);
        if (!this.f.exists()) {
            this.f.mkdirs();
        }
    }

    @Override // b.a.a.a.a.d.c
    public void a(byte[] bArr) throws IOException {
        this.e.a(bArr);
    }

    @Override // b.a.a.a.a.d.c
    public int a() {
        return this.e.a();
    }

    @Override // b.a.a.a.a.d.c
    public void a(String str) throws IOException {
        this.e.close();
        a(this.d, new File(this.f, str));
        this.e = new q(this.d);
    }

    private void a(File file, File file2) throws IOException {
        FileInputStream fileInputStream;
        OutputStream outputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                outputStream = a(file2);
                b.a.a.a.a.b.i.a(fileInputStream, outputStream, new byte[1024]);
                b.a.a.a.a.b.i.a((Closeable) fileInputStream, "Failed to close file input stream");
                b.a.a.a.a.b.i.a((Closeable) outputStream, "Failed to close output stream");
                file.delete();
            } catch (Throwable th) {
                th = th;
                b.a.a.a.a.b.i.a((Closeable) fileInputStream, "Failed to close file input stream");
                b.a.a.a.a.b.i.a((Closeable) outputStream, "Failed to close output stream");
                file.delete();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public OutputStream a(File file) throws IOException {
        return new FileOutputStream(file);
    }

    @Override // b.a.a.a.a.d.c
    public List<File> a(int i) {
        ArrayList arrayList = new ArrayList();
        for (File file : this.f.listFiles()) {
            arrayList.add(file);
            if (arrayList.size() >= i) {
                break;
            }
        }
        return arrayList;
    }

    @Override // b.a.a.a.a.d.c
    public void a(List<File> list) {
        for (File file : list) {
            b.a.a.a.a.b.i.a(this.f179a, String.format("deleting sent analytics file %s", file.getName()));
            file.delete();
        }
    }

    @Override // b.a.a.a.a.d.c
    public List<File> c() {
        return Arrays.asList(this.f.listFiles());
    }

    @Override // b.a.a.a.a.d.c
    public void d() {
        try {
            this.e.close();
        } catch (IOException e) {
        }
        this.d.delete();
    }

    @Override // b.a.a.a.a.d.c
    public boolean b() {
        return this.e.b();
    }

    @Override // b.a.a.a.a.d.c
    public boolean a(int i, int i2) {
        return this.e.a(i, i2);
    }
}

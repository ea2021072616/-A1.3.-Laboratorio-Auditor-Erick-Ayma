package com.bumptech.glide.load.resource.b;

import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: FileToStreamDecoder.java */
/* loaded from: classes.dex */
public class c<T> implements e<File, T> {

    /* renamed from: a  reason: collision with root package name */
    private static final a f905a = new a();

    /* renamed from: b  reason: collision with root package name */
    private e<InputStream, T> f906b;

    /* renamed from: c  reason: collision with root package name */
    private final a f907c;

    public c(e<InputStream, T> eVar) {
        this(eVar, f905a);
    }

    c(e<InputStream, T> eVar, a aVar) {
        this.f906b = eVar;
        this.f907c = aVar;
    }

    @Override // com.bumptech.glide.load.e
    public k<T> a(File file, int i, int i2) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = this.f907c.a(file);
            return this.f906b.a(inputStream, i, i2);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        }
    }

    @Override // com.bumptech.glide.load.e
    public String a() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FileToStreamDecoder.java */
    /* loaded from: classes.dex */
    public static class a {
        a() {
        }

        public InputStream a(File file) throws FileNotFoundException {
            return new FileInputStream(file);
        }
    }
}

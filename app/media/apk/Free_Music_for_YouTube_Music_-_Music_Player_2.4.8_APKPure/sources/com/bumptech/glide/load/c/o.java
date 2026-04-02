package com.bumptech.glide.load.c;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* compiled from: StreamEncoder.java */
/* loaded from: classes.dex */
public class o implements com.bumptech.glide.load.b<InputStream> {
    @Override // com.bumptech.glide.load.b
    public boolean a(InputStream inputStream, OutputStream outputStream) {
        byte[] b2 = com.bumptech.glide.i.a.a().b();
        while (true) {
            try {
                int read = inputStream.read(b2);
                if (read != -1) {
                    outputStream.write(b2, 0, read);
                } else {
                    return true;
                }
            } catch (IOException e) {
                if (Log.isLoggable("StreamEncoder", 3)) {
                    Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                }
                return false;
            } finally {
                com.bumptech.glide.i.a.a().a(b2);
            }
        }
    }

    @Override // com.bumptech.glide.load.b
    public String a() {
        return "";
    }
}

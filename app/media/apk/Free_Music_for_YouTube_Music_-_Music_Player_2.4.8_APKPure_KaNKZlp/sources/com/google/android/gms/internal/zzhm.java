package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes2.dex */
final class zzhm {
    private ByteArrayOutputStream zzazr = new ByteArrayOutputStream(4096);
    private Base64OutputStream zzazs = new Base64OutputStream(this.zzazr, 10);

    /* JADX WARN: Type inference failed for: r2v0, types: [java.io.ByteArrayOutputStream, android.util.Base64OutputStream] */
    public final String toString() {
        String str;
        try {
            this.zzazs.close();
        } catch (IOException e) {
            zzafx.zzb("HashManager: Unable to convert to Base64.", e);
        }
        try {
            this.zzazr.close();
            str = this.zzazr.toString();
        } catch (IOException e2) {
            zzafx.zzb("HashManager: Unable to convert to Base64.", e2);
            str = "";
        } finally {
            this.zzazr = null;
            this.zzazs = null;
        }
        return str;
    }

    public final void write(byte[] bArr) throws IOException {
        this.zzazs.write(bArr);
    }
}

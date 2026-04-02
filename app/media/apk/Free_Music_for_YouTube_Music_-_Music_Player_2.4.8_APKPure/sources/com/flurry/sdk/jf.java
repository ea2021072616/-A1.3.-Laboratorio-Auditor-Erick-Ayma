package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class jf {

    /* renamed from: b  reason: collision with root package name */
    private static final String f1937b = jf.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    byte[] f1938a;

    /* synthetic */ jf(byte b2) {
        this();
    }

    private jf() {
    }

    public jf(byte[] bArr) {
        this.f1938a = bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x009d A[Catch: IOException -> 0x0107, all -> 0x0111, TryCatch #0 {all -> 0x0111, blocks: (B:5:0x0013, B:7:0x003a, B:8:0x0043, B:10:0x004b, B:11:0x0054, B:13:0x0058, B:14:0x005c, B:16:0x0060, B:17:0x0064, B:21:0x0084, B:23:0x009d, B:24:0x00a1, B:26:0x00a5, B:27:0x00a9, B:29:0x00b2, B:30:0x00b6, B:32:0x00bf, B:33:0x00c5, B:35:0x00cb, B:37:0x00dc, B:38:0x00e5, B:40:0x00f0, B:77:0x0259, B:78:0x0274, B:80:0x027a, B:81:0x0288, B:76:0x0254, B:68:0x01f0, B:69:0x01fb, B:71:0x0201, B:74:0x021f, B:75:0x024c, B:64:0x01be, B:65:0x01cd, B:67:0x01d3, B:63:0x01af, B:60:0x017e, B:56:0x014a, B:57:0x0159, B:59:0x015f, B:52:0x011c, B:53:0x012b, B:55:0x0131, B:51:0x0117, B:41:0x0101, B:45:0x0109, B:46:0x0110), top: B:91:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a5 A[Catch: IOException -> 0x0107, all -> 0x0111, TryCatch #0 {all -> 0x0111, blocks: (B:5:0x0013, B:7:0x003a, B:8:0x0043, B:10:0x004b, B:11:0x0054, B:13:0x0058, B:14:0x005c, B:16:0x0060, B:17:0x0064, B:21:0x0084, B:23:0x009d, B:24:0x00a1, B:26:0x00a5, B:27:0x00a9, B:29:0x00b2, B:30:0x00b6, B:32:0x00bf, B:33:0x00c5, B:35:0x00cb, B:37:0x00dc, B:38:0x00e5, B:40:0x00f0, B:77:0x0259, B:78:0x0274, B:80:0x027a, B:81:0x0288, B:76:0x0254, B:68:0x01f0, B:69:0x01fb, B:71:0x0201, B:74:0x021f, B:75:0x024c, B:64:0x01be, B:65:0x01cd, B:67:0x01d3, B:63:0x01af, B:60:0x017e, B:56:0x014a, B:57:0x0159, B:59:0x015f, B:52:0x011c, B:53:0x012b, B:55:0x0131, B:51:0x0117, B:41:0x0101, B:45:0x0109, B:46:0x0110), top: B:91:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b2 A[Catch: IOException -> 0x0107, all -> 0x0111, TryCatch #0 {all -> 0x0111, blocks: (B:5:0x0013, B:7:0x003a, B:8:0x0043, B:10:0x004b, B:11:0x0054, B:13:0x0058, B:14:0x005c, B:16:0x0060, B:17:0x0064, B:21:0x0084, B:23:0x009d, B:24:0x00a1, B:26:0x00a5, B:27:0x00a9, B:29:0x00b2, B:30:0x00b6, B:32:0x00bf, B:33:0x00c5, B:35:0x00cb, B:37:0x00dc, B:38:0x00e5, B:40:0x00f0, B:77:0x0259, B:78:0x0274, B:80:0x027a, B:81:0x0288, B:76:0x0254, B:68:0x01f0, B:69:0x01fb, B:71:0x0201, B:74:0x021f, B:75:0x024c, B:64:0x01be, B:65:0x01cd, B:67:0x01d3, B:63:0x01af, B:60:0x017e, B:56:0x014a, B:57:0x0159, B:59:0x015f, B:52:0x011c, B:53:0x012b, B:55:0x0131, B:51:0x0117, B:41:0x0101, B:45:0x0109, B:46:0x0110), top: B:91:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf A[Catch: IOException -> 0x0107, all -> 0x0111, TryCatch #0 {all -> 0x0111, blocks: (B:5:0x0013, B:7:0x003a, B:8:0x0043, B:10:0x004b, B:11:0x0054, B:13:0x0058, B:14:0x005c, B:16:0x0060, B:17:0x0064, B:21:0x0084, B:23:0x009d, B:24:0x00a1, B:26:0x00a5, B:27:0x00a9, B:29:0x00b2, B:30:0x00b6, B:32:0x00bf, B:33:0x00c5, B:35:0x00cb, B:37:0x00dc, B:38:0x00e5, B:40:0x00f0, B:77:0x0259, B:78:0x0274, B:80:0x027a, B:81:0x0288, B:76:0x0254, B:68:0x01f0, B:69:0x01fb, B:71:0x0201, B:74:0x021f, B:75:0x024c, B:64:0x01be, B:65:0x01cd, B:67:0x01d3, B:63:0x01af, B:60:0x017e, B:56:0x014a, B:57:0x0159, B:59:0x015f, B:52:0x011c, B:53:0x012b, B:55:0x0131, B:51:0x0117, B:41:0x0101, B:45:0x0109, B:46:0x0110), top: B:91:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f0 A[Catch: IOException -> 0x0107, all -> 0x0111, LOOP:1: B:39:0x00ee->B:40:0x00f0, LOOP_END, TryCatch #0 {all -> 0x0111, blocks: (B:5:0x0013, B:7:0x003a, B:8:0x0043, B:10:0x004b, B:11:0x0054, B:13:0x0058, B:14:0x005c, B:16:0x0060, B:17:0x0064, B:21:0x0084, B:23:0x009d, B:24:0x00a1, B:26:0x00a5, B:27:0x00a9, B:29:0x00b2, B:30:0x00b6, B:32:0x00bf, B:33:0x00c5, B:35:0x00cb, B:37:0x00dc, B:38:0x00e5, B:40:0x00f0, B:77:0x0259, B:78:0x0274, B:80:0x027a, B:81:0x0288, B:76:0x0254, B:68:0x01f0, B:69:0x01fb, B:71:0x0201, B:74:0x021f, B:75:0x024c, B:64:0x01be, B:65:0x01cd, B:67:0x01d3, B:63:0x01af, B:60:0x017e, B:56:0x014a, B:57:0x0159, B:59:0x015f, B:52:0x011c, B:53:0x012b, B:55:0x0131, B:51:0x0117, B:41:0x0101, B:45:0x0109, B:46:0x0110), top: B:91:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01af A[Catch: IOException -> 0x0107, all -> 0x0111, TryCatch #0 {all -> 0x0111, blocks: (B:5:0x0013, B:7:0x003a, B:8:0x0043, B:10:0x004b, B:11:0x0054, B:13:0x0058, B:14:0x005c, B:16:0x0060, B:17:0x0064, B:21:0x0084, B:23:0x009d, B:24:0x00a1, B:26:0x00a5, B:27:0x00a9, B:29:0x00b2, B:30:0x00b6, B:32:0x00bf, B:33:0x00c5, B:35:0x00cb, B:37:0x00dc, B:38:0x00e5, B:40:0x00f0, B:77:0x0259, B:78:0x0274, B:80:0x027a, B:81:0x0288, B:76:0x0254, B:68:0x01f0, B:69:0x01fb, B:71:0x0201, B:74:0x021f, B:75:0x024c, B:64:0x01be, B:65:0x01cd, B:67:0x01d3, B:63:0x01af, B:60:0x017e, B:56:0x014a, B:57:0x0159, B:59:0x015f, B:52:0x011c, B:53:0x012b, B:55:0x0131, B:51:0x0117, B:41:0x0101, B:45:0x0109, B:46:0x0110), top: B:91:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01be A[Catch: IOException -> 0x0107, all -> 0x0111, TryCatch #0 {all -> 0x0111, blocks: (B:5:0x0013, B:7:0x003a, B:8:0x0043, B:10:0x004b, B:11:0x0054, B:13:0x0058, B:14:0x005c, B:16:0x0060, B:17:0x0064, B:21:0x0084, B:23:0x009d, B:24:0x00a1, B:26:0x00a5, B:27:0x00a9, B:29:0x00b2, B:30:0x00b6, B:32:0x00bf, B:33:0x00c5, B:35:0x00cb, B:37:0x00dc, B:38:0x00e5, B:40:0x00f0, B:77:0x0259, B:78:0x0274, B:80:0x027a, B:81:0x0288, B:76:0x0254, B:68:0x01f0, B:69:0x01fb, B:71:0x0201, B:74:0x021f, B:75:0x024c, B:64:0x01be, B:65:0x01cd, B:67:0x01d3, B:63:0x01af, B:60:0x017e, B:56:0x014a, B:57:0x0159, B:59:0x015f, B:52:0x011c, B:53:0x012b, B:55:0x0131, B:51:0x0117, B:41:0x0101, B:45:0x0109, B:46:0x0110), top: B:91:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01f0 A[Catch: IOException -> 0x0107, all -> 0x0111, TryCatch #0 {all -> 0x0111, blocks: (B:5:0x0013, B:7:0x003a, B:8:0x0043, B:10:0x004b, B:11:0x0054, B:13:0x0058, B:14:0x005c, B:16:0x0060, B:17:0x0064, B:21:0x0084, B:23:0x009d, B:24:0x00a1, B:26:0x00a5, B:27:0x00a9, B:29:0x00b2, B:30:0x00b6, B:32:0x00bf, B:33:0x00c5, B:35:0x00cb, B:37:0x00dc, B:38:0x00e5, B:40:0x00f0, B:77:0x0259, B:78:0x0274, B:80:0x027a, B:81:0x0288, B:76:0x0254, B:68:0x01f0, B:69:0x01fb, B:71:0x0201, B:74:0x021f, B:75:0x024c, B:64:0x01be, B:65:0x01cd, B:67:0x01d3, B:63:0x01af, B:60:0x017e, B:56:0x014a, B:57:0x0159, B:59:0x015f, B:52:0x011c, B:53:0x012b, B:55:0x0131, B:51:0x0117, B:41:0x0101, B:45:0x0109, B:46:0x0110), top: B:91:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x027a A[Catch: IOException -> 0x0107, all -> 0x0111, LOOP:2: B:78:0x0274->B:80:0x027a, LOOP_END, TryCatch #0 {all -> 0x0111, blocks: (B:5:0x0013, B:7:0x003a, B:8:0x0043, B:10:0x004b, B:11:0x0054, B:13:0x0058, B:14:0x005c, B:16:0x0060, B:17:0x0064, B:21:0x0084, B:23:0x009d, B:24:0x00a1, B:26:0x00a5, B:27:0x00a9, B:29:0x00b2, B:30:0x00b6, B:32:0x00bf, B:33:0x00c5, B:35:0x00cb, B:37:0x00dc, B:38:0x00e5, B:40:0x00f0, B:77:0x0259, B:78:0x0274, B:80:0x027a, B:81:0x0288, B:76:0x0254, B:68:0x01f0, B:69:0x01fb, B:71:0x0201, B:74:0x021f, B:75:0x024c, B:64:0x01be, B:65:0x01cd, B:67:0x01d3, B:63:0x01af, B:60:0x017e, B:56:0x014a, B:57:0x0159, B:59:0x015f, B:52:0x011c, B:53:0x012b, B:55:0x0131, B:51:0x0117, B:41:0x0101, B:45:0x0109, B:46:0x0110), top: B:91:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x029d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public jf(com.flurry.sdk.jg r13) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 675
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.jf.<init>(com.flurry.sdk.jg):void");
    }

    /* loaded from: classes.dex */
    public static class a implements lg<jf> {
        @Override // com.flurry.sdk.lg
        public final /* synthetic */ void a(OutputStream outputStream, jf jfVar) throws IOException {
            jf jfVar2 = jfVar;
            if (outputStream == null || jfVar2 == null) {
                return;
            }
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream) { // from class: com.flurry.sdk.jf.a.1
                @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public final void close() {
                }
            };
            int i = 0;
            if (jfVar2.f1938a != null) {
                i = jfVar2.f1938a.length;
            }
            dataOutputStream.writeShort(i);
            if (i > 0) {
                dataOutputStream.write(jfVar2.f1938a);
            }
            dataOutputStream.flush();
        }

        @Override // com.flurry.sdk.lg
        public final /* synthetic */ jf a(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(inputStream) { // from class: com.flurry.sdk.jf.a.2
                @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public final void close() {
                }
            };
            jf jfVar = new jf((byte) 0);
            int readUnsignedShort = dataInputStream.readUnsignedShort();
            if (readUnsignedShort > 0) {
                byte[] bArr = new byte[readUnsignedShort];
                dataInputStream.readFully(bArr);
                jfVar.f1938a = bArr;
                return jfVar;
            }
            return jfVar;
        }
    }
}

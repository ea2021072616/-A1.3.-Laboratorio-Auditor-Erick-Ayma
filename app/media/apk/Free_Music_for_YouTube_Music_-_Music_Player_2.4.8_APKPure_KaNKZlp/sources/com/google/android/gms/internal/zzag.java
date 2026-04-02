package com.google.android.gms.internal;

import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class zzag implements zzb {
    private final Map<String, zzai> zzbv;
    private long zzbw;
    private final File zzbx;
    private final int zzby;

    public zzag(File file) {
        this(file, 5242880);
    }

    private zzag(File file, int i) {
        this.zzbv = new LinkedHashMap(16, 0.75f, true);
        this.zzbw = 0L;
        this.zzbx = file;
        this.zzby = 5242880;
    }

    private final synchronized void remove(String str) {
        boolean delete = zze(str).delete();
        zzai zzaiVar = this.zzbv.get(str);
        if (zzaiVar != null) {
            this.zzbw -= zzaiVar.size;
            this.zzbv.remove(str);
        }
        if (!delete) {
            zzab.zzb("Could not delete cache entry for key=%s, filename=%s", str, zzd(str));
        }
    }

    private static int zza(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read == -1) {
            throw new EOFException();
        }
        return read;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write(i >>> 24);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) j);
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes(C.UTF8_NAME);
        zza(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private final void zza(String str, zzai zzaiVar) {
        if (this.zzbv.containsKey(str)) {
            this.zzbw = (zzaiVar.size - this.zzbv.get(str).size) + this.zzbw;
        } else {
            this.zzbw += zzaiVar.size;
        }
        this.zzbv.put(str, zzaiVar);
    }

    private static byte[] zza(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 != i) {
            throw new IOException(new StringBuilder(50).append("Expected ").append(i).append(" bytes, read ").append(i2).append(" bytes").toString());
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(InputStream inputStream) throws IOException {
        return zza(inputStream) | 0 | (zza(inputStream) << 8) | (zza(inputStream) << 16) | (zza(inputStream) << 24);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzc(InputStream inputStream) throws IOException {
        return 0 | (zza(inputStream) & 255) | ((zza(inputStream) & 255) << 8) | ((zza(inputStream) & 255) << 16) | ((zza(inputStream) & 255) << 24) | ((zza(inputStream) & 255) << 32) | ((zza(inputStream) & 255) << 40) | ((zza(inputStream) & 255) << 48) | ((zza(inputStream) & 255) << 56);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzd(InputStream inputStream) throws IOException {
        return new String(zza(inputStream, (int) zzc(inputStream)), C.UTF8_NAME);
    }

    private static String zzd(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private final File zze(String str) {
        return new File(this.zzbx, zzd(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> zze(InputStream inputStream) throws IOException {
        int zzb = zzb(inputStream);
        Map<String, String> emptyMap = zzb == 0 ? Collections.emptyMap() : new HashMap<>(zzb);
        for (int i = 0; i < zzb; i++) {
            emptyMap.put(zzd(inputStream).intern(), zzd(inputStream).intern());
        }
        return emptyMap;
    }

    @Override // com.google.android.gms.internal.zzb
    public final synchronized void initialize() {
        BufferedInputStream bufferedInputStream;
        if (this.zzbx.exists()) {
            File[] listFiles = this.zzbx.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    BufferedInputStream bufferedInputStream2 = null;
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        try {
                            try {
                                zzai zzf = zzai.zzf(bufferedInputStream);
                                zzf.size = file.length();
                                zza(zzf.key, zzf);
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e) {
                                }
                            } catch (Throwable th) {
                                bufferedInputStream2 = bufferedInputStream;
                                th = th;
                                if (bufferedInputStream2 != null) {
                                    try {
                                        bufferedInputStream2.close();
                                    } catch (IOException e2) {
                                    }
                                }
                                throw th;
                            }
                        } catch (IOException e3) {
                            if (file != null) {
                                file.delete();
                            }
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e4) {
                                }
                            }
                        }
                    } catch (IOException e5) {
                        bufferedInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        } else if (!this.zzbx.mkdirs()) {
            zzab.zzc("Unable to create cache dir %s", this.zzbx.getAbsolutePath());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.zzb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized com.google.android.gms.internal.zzc zza(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 193
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzag.zza(java.lang.String):com.google.android.gms.internal.zzc");
    }

    @Override // com.google.android.gms.internal.zzb
    public final synchronized void zza(String str, zzc zzcVar) {
        BufferedOutputStream bufferedOutputStream;
        zzai zzaiVar;
        int i;
        int i2 = 0;
        synchronized (this) {
            int length = zzcVar.data.length;
            if (this.zzbw + length >= this.zzby) {
                if (zzab.DEBUG) {
                    zzab.zza("Pruning old cache entries.", new Object[0]);
                }
                long j = this.zzbw;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Iterator<Map.Entry<String, zzai>> it = this.zzbv.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        i = i2;
                        break;
                    }
                    zzai value = it.next().getValue();
                    if (zze(value.key).delete()) {
                        this.zzbw -= value.size;
                    } else {
                        zzab.zzb("Could not delete cache entry for key=%s, filename=%s", value.key, zzd(value.key));
                    }
                    it.remove();
                    i = i2 + 1;
                    if (((float) (this.zzbw + length)) < this.zzby * 0.9f) {
                        break;
                    }
                    i2 = i;
                }
                if (zzab.DEBUG) {
                    zzab.zza("pruned %d files, %d bytes, %d ms", Integer.valueOf(i), Long.valueOf(this.zzbw - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                }
            }
            File zze = zze(str);
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(zze));
                zzaiVar = new zzai(str, zzcVar);
            } catch (IOException e) {
                if (!zze.delete()) {
                    zzab.zzb("Could not clean up file %s", zze.getAbsolutePath());
                }
            }
            if (!zzaiVar.zza(bufferedOutputStream)) {
                bufferedOutputStream.close();
                zzab.zzb("Failed to write header for %s", zze.getAbsolutePath());
                throw new IOException();
            }
            bufferedOutputStream.write(zzcVar.data);
            bufferedOutputStream.close();
            zza(str, zzaiVar);
        }
    }
}

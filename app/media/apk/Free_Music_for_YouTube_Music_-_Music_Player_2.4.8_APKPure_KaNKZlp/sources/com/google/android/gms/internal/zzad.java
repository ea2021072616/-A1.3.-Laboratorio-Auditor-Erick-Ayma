package com.google.android.gms.internal;

import android.os.SystemClock;
import android.support.graphics.drawable.PathInterpolatorCompat;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.cookie.DateUtils;
/* loaded from: classes.dex */
public final class zzad implements zzk {
    private static boolean DEBUG = zzab.DEBUG;
    private static int zzbm = PathInterpolatorCompat.MAX_NUM_POINTS;
    private static int zzbn = 4096;
    private zzan zzbo;
    private zzae zzbp;

    public zzad(zzan zzanVar) {
        this(zzanVar, new zzae(zzbn));
    }

    private zzad(zzan zzanVar, zzae zzaeVar) {
        this.zzbo = zzanVar;
        this.zzbp = zzaeVar;
    }

    private static Map<String, String> zza(Header[] headerArr) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }

    private static void zza(String str, zzp<?> zzpVar, zzaa zzaaVar) throws zzaa {
        zzx zzj = zzpVar.zzj();
        int zzi = zzpVar.zzi();
        try {
            zzj.zza(zzaaVar);
            zzpVar.zzb(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(zzi)));
        } catch (zzaa e) {
            zzpVar.zzb(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(zzi)));
            throw e;
        }
    }

    private final byte[] zza(HttpEntity httpEntity) throws IOException, zzy {
        zzaq zzaqVar = new zzaq(this.zzbp, (int) httpEntity.getContentLength());
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new zzy();
            }
            byte[] zzb = this.zzbp.zzb(1024);
            while (true) {
                int read = content.read(zzb);
                if (read == -1) {
                    break;
                }
                zzaqVar.write(zzb, 0, read);
            }
            byte[] byteArray = zzaqVar.toByteArray();
            try {
                httpEntity.consumeContent();
            } catch (IOException e) {
                zzab.zza("Error occured when calling consumingContent", new Object[0]);
            }
            this.zzbp.zza(zzb);
            zzaqVar.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                httpEntity.consumeContent();
            } catch (IOException e2) {
                zzab.zza("Error occured when calling consumingContent", new Object[0]);
            }
            this.zzbp.zza(null);
            zzaqVar.close();
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.zzk
    public final zzn zza(zzp<?> zzpVar) throws zzaa {
        byte[] bArr;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            HttpResponse httpResponse = null;
            Map<String, String> emptyMap = Collections.emptyMap();
            try {
                try {
                    HashMap hashMap = new HashMap();
                    zzc zze = zzpVar.zze();
                    if (zze != null) {
                        if (zze.zza != null) {
                            hashMap.put("If-None-Match", zze.zza);
                        }
                        if (zze.zzc > 0) {
                            hashMap.put("If-Modified-Since", DateUtils.formatDate(new Date(zze.zzc)));
                        }
                    }
                    HttpResponse zza = this.zzbo.zza(zzpVar, hashMap);
                    try {
                        StatusLine statusLine = zza.getStatusLine();
                        int statusCode = statusLine.getStatusCode();
                        emptyMap = zza(zza.getAllHeaders());
                        if (statusCode == 304) {
                            zzc zze2 = zzpVar.zze();
                            if (zze2 == null) {
                                return new zzn(304, null, emptyMap, true, SystemClock.elapsedRealtime() - elapsedRealtime);
                            }
                            zze2.zzf.putAll(emptyMap);
                            return new zzn(304, zze2.data, zze2.zzf, true, SystemClock.elapsedRealtime() - elapsedRealtime);
                        }
                        bArr = zza.getEntity() != null ? zza(zza.getEntity()) : new byte[0];
                        try {
                            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                            if (DEBUG || elapsedRealtime2 > zzbm) {
                                Object[] objArr = new Object[5];
                                objArr[0] = zzpVar;
                                objArr[1] = Long.valueOf(elapsedRealtime2);
                                objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
                                objArr[3] = Integer.valueOf(statusLine.getStatusCode());
                                objArr[4] = Integer.valueOf(zzpVar.zzj().zzb());
                                zzab.zzb("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
                            }
                            if (statusCode < 200 || statusCode > 299) {
                                throw new IOException();
                            }
                            return new zzn(statusCode, bArr, emptyMap, false, SystemClock.elapsedRealtime() - elapsedRealtime);
                        } catch (IOException e) {
                            e = e;
                            httpResponse = zza;
                            if (httpResponse == null) {
                                throw new zzo(e);
                            }
                            int statusCode2 = httpResponse.getStatusLine().getStatusCode();
                            zzab.zzc("Unexpected response code %d for %s", Integer.valueOf(statusCode2), zzpVar.getUrl());
                            if (bArr != null) {
                                zzn zznVar = new zzn(statusCode2, bArr, emptyMap, false, SystemClock.elapsedRealtime() - elapsedRealtime);
                                if (statusCode2 != 401 && statusCode2 != 403) {
                                    if (statusCode2 < 400 || statusCode2 > 499) {
                                        if (statusCode2 < 500 || statusCode2 > 599) {
                                            throw new zzy(zznVar);
                                        }
                                        throw new zzy(zznVar);
                                    }
                                    throw new zzf(zznVar);
                                }
                                zza("auth", zzpVar, new zza(zznVar));
                            } else {
                                zza("network", zzpVar, new zzm());
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        bArr = null;
                        httpResponse = zza;
                    }
                } catch (IOException e3) {
                    e = e3;
                    bArr = null;
                }
            } catch (MalformedURLException e4) {
                String valueOf = String.valueOf(zzpVar.getUrl());
                throw new RuntimeException(valueOf.length() != 0 ? "Bad URL ".concat(valueOf) : new String("Bad URL "), e4);
            } catch (SocketTimeoutException e5) {
                zza("socket", zzpVar, new zzz());
            } catch (ConnectTimeoutException e6) {
                zza("connection", zzpVar, new zzz());
            }
        }
    }
}

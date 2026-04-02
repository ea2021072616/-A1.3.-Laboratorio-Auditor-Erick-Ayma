package com.acrcloud.rec.b.a;

import com.acrcloud.rec.b.b;
import com.acrcloud.rec.b.b.e;
import com.acrcloud.rec.b.b.h;
import com.acrcloud.rec.b.b.i;
import com.acrcloud.rec.engine.ACRCloudRecognizeEngine;
import com.facebook.internal.NativeProtocol;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
/* compiled from: ACRCloudRecognizerRemoteImpl.java */
/* loaded from: classes.dex */
public class c implements d {

    /* renamed from: a  reason: collision with root package name */
    public static String f332a = null;

    /* renamed from: c  reason: collision with root package name */
    private static int f333c = 5;

    /* renamed from: b  reason: collision with root package name */
    private com.acrcloud.rec.b.b f334b;
    private int d = 3;
    private String e = "/rec?access_key=";
    private Map<String, Object> f = null;
    private String g;

    public c(com.acrcloud.rec.b.b bVar, String str) {
        this.f334b = null;
        this.g = "";
        this.f334b = bVar;
        this.g = str;
    }

    private String a(String str) {
        String str2 = this.f334b.f337c;
        String str3 = "http";
        if (this.f334b.g == b.a.PROTOCOL_HTTPS) {
            str3 = "https";
        } else if (f332a != null && !"".equals(f332a)) {
            str2 = f332a;
        } else {
            h.b("ACRCloudRecognizerRemoteImpl", "ACRCloudGetIPAddressAsyncTask");
            if (f333c > 0) {
                new com.acrcloud.rec.b.b.b().execute(str2);
            }
            f333c--;
        }
        return str3 + "://" + str2 + str;
    }

    private Map<String, Object> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("rec_type", "recording");
        hashMap.put("timestamp", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis())));
        hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, "rec_init");
        hashMap.put("dk", this.g);
        return hashMap;
    }

    private Map<String, Object> a(byte[] bArr, int i, Map<String, Object> map, int i2) {
        String str = (String) map.get("ekey");
        int intValue = ((Integer) map.get("fp_time")).intValue();
        int intValue2 = ((Integer) map.get("service_type")).intValue();
        Map<String, Object> c2 = c();
        switch (i2) {
            case 0:
            case 1:
                byte[] a2 = ACRCloudRecognizeEngine.a(bArr, i, str, this.f334b.f);
                if (a2 != null) {
                    c2.put("sample", a2);
                    c2.put("sample_bytes", a2.length + "");
                    break;
                } else {
                    return null;
                }
            case 2:
                byte[] d = ACRCloudRecognizeEngine.d(bArr, i);
                if (d != null) {
                    c2.put("sample_hum", d);
                    c2.put("sample_hum_bytes", d.length + "");
                    break;
                } else {
                    return null;
                }
            case 3:
                byte[] a3 = ACRCloudRecognizeEngine.a(bArr, i, str, this.f334b.f);
                byte[] d2 = ACRCloudRecognizeEngine.d(bArr, i);
                if (a3 != null || d2 != null) {
                    if (a3 != null) {
                        c2.put("sample", a3);
                        c2.put("sample_bytes", a3.length + "");
                    }
                    if (d2 != null) {
                        c2.put("sample_hum", d2);
                        c2.put("sample_hum_bytes", d2.length + "");
                        break;
                    }
                } else {
                    return null;
                }
                break;
            default:
                h.a("ACRCloudRecognizerRemoteImpl", "engine type error " + i2);
                return null;
        }
        c2.put("pcm_bytes", i + "");
        c2.put("fp_time", intValue + "");
        c2.put("rec_type", intValue2 + "");
        c2.put(NativeProtocol.WEB_DIALOG_ACTION, "rec");
        c2.put("dk", this.g);
        return c2;
    }

    private Map<String, Object> b(Map<String, Object> map) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof String) {
                String a2 = ACRCloudRecognizeEngine.a((String) obj, this.f334b.f);
                h.b("ACRCloudRecognizerRemoteImpl", str + " : " + obj + " : " + a2);
                if (a2 != null) {
                    map.put(str, a2);
                }
            }
        }
        return map;
    }

    @Override // com.acrcloud.rec.b.a.d
    public void a() throws com.acrcloud.rec.b.b.a {
    }

    @Override // com.acrcloud.rec.b.a.d
    public void b() {
    }

    @Override // com.acrcloud.rec.b.a.d
    public i a(Map<String, String> map) {
        Map<String, Object> c2 = c();
        if (map != null) {
            for (String str : map.keySet()) {
                c2.put(str, map.get(str));
            }
        }
        b(c2);
        com.acrcloud.rec.b.b.a e = null;
        for (int i = 0; i < this.d; i++) {
            try {
                return e.a(com.acrcloud.rec.b.b.c.a(a(this.e + this.f334b.e), c2, this.f334b.f336b), 0L);
            } catch (com.acrcloud.rec.b.b.a e2) {
                e = e2;
            }
        }
        i iVar = new i();
        iVar.a(e.a());
        iVar.a(e.b());
        iVar.d(e.toString());
        return iVar;
    }

    @Override // com.acrcloud.rec.b.a.d
    public i a(byte[] bArr, int i, Map<String, Object> map, Map<String, String> map2, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (i2 < 0 || i2 > 3) {
            i iVar = new i();
            iVar.d(com.acrcloud.rec.b.b.a.b(2006));
            return iVar;
        }
        Map<String, Object> a2 = a(bArr, i, map, i2);
        if (a2 == null) {
            i iVar2 = new i();
            iVar2.d(com.acrcloud.rec.b.b.a.b(2004));
            return iVar2;
        }
        if (map2 != null) {
            for (String str : map2.keySet()) {
                a2.put(str, map2.get(str));
            }
        }
        b(a2);
        com.acrcloud.rec.b.b.a aVar = null;
        int i3 = 0;
        while (i3 < this.d) {
            try {
                String a3 = com.acrcloud.rec.b.b.c.a(a(this.e + this.f334b.e), a2, this.f334b.f336b);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                h.b("ACRCloudRecognizerRemoteImpl", "offsetCorrValue=" + currentTimeMillis2);
                i a4 = e.a(a3, currentTimeMillis2);
                a4.a((byte[]) a2.get("sample"));
                return a4;
            } catch (com.acrcloud.rec.b.b.a e) {
                i3++;
                aVar = e;
            }
        }
        i iVar3 = new i();
        iVar3.a(aVar.a());
        iVar3.a(aVar.b());
        iVar3.d(aVar.toString());
        return iVar3;
    }
}

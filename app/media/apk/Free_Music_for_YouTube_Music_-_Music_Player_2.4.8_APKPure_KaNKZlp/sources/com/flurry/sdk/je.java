package com.flurry.sdk;

import android.widget.Toast;
import com.flurry.sdk.ks;
import com.flurry.sdk.ku;
import com.flurry.sdk.lq;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
import java.util.Arrays;
/* loaded from: classes.dex */
public class je extends ky implements lq.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1929a = je.class.getSimpleName();
    private String f;
    private boolean g;

    public je() {
        this((byte) 0);
    }

    private je(byte b2) {
        super("Analytics", je.class.getSimpleName());
        this.f2107c = "AnalyticsData_";
        lp a2 = lp.a();
        this.g = ((Boolean) a2.a("UseHttps")).booleanValue();
        a2.a("UseHttps", (lq.a) this);
        km.a(4, f1929a, "initSettings, UseHttps = " + this.g);
        String str = (String) a2.a("ReportUrl");
        a2.a("ReportUrl", (lq.a) this);
        b(str);
        km.a(4, f1929a, "initSettings, ReportUrl = " + str);
        b();
    }

    private void b(String str) {
        if (str != null && !str.endsWith(".do")) {
            km.a(5, f1929a, "overriding analytics agent report URL without an endpoint, are you sure?");
        }
        this.f = str;
    }

    @Override // com.flurry.sdk.lq.a
    public final void a(String str, Object obj) {
        char c2 = 65535;
        switch (str.hashCode()) {
            case -239660092:
                if (str.equals("UseHttps")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1650629499:
                if (str.equals("ReportUrl")) {
                    c2 = 1;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.g = ((Boolean) obj).booleanValue();
                km.a(4, f1929a, "onSettingUpdate, UseHttps = " + this.g);
                return;
            case 1:
                String str2 = (String) obj;
                b(str2);
                km.a(4, f1929a, "onSettingUpdate, ReportUrl = " + str2);
                return;
            default:
                km.a(6, f1929a, "onSettingUpdate internal error!");
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.flurry.sdk.ky
    public final void a(String str, String str2, final int i) {
        jy.a().b(new ma() { // from class: com.flurry.sdk.je.2
            @Override // com.flurry.sdk.ma
            public final void a() {
                if (i == 200) {
                    hr.a();
                    jh b2 = hr.b();
                    if (b2 == null) {
                        return;
                    }
                    b2.j = true;
                }
            }
        });
        super.a(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flurry.sdk.ky
    public final void a(byte[] bArr, final String str, final String str2) {
        String str3;
        if (this.f != null) {
            str3 = this.f;
        } else if (this.g) {
            str3 = "https://data.flurry.com/aap.do";
        } else {
            str3 = "http://data.flurry.com/aap.do";
        }
        km.a(4, f1929a, "FlurryDataSender: start upload data " + Arrays.toString(bArr) + " with id = " + str + " to " + str3);
        ks ksVar = new ks();
        ksVar.g = str3;
        ksVar.u = DefaultOggSeeker.MATCH_BYTE_RANGE;
        ksVar.h = ku.a.kPost;
        ksVar.a("Content-Type", "application/octet-stream");
        ksVar.f2080c = new lc();
        ksVar.f2079b = bArr;
        ksVar.f2078a = new ks.a<byte[], Void>() { // from class: com.flurry.sdk.je.1
            @Override // com.flurry.sdk.ks.a
            public final /* synthetic */ void a(ks<byte[], Void> ksVar2, Void r7) {
                final int i = ksVar2.q;
                if (i > 0) {
                    km.e(je.f1929a, "Analytics report sent.");
                    km.a(3, je.f1929a, "FlurryDataSender: report " + str + " sent. HTTP response: " + i);
                    if (km.c() <= 3 && km.d()) {
                        jy.a().a(new Runnable() { // from class: com.flurry.sdk.je.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                Toast.makeText(jy.a().f2022a, "SD HTTP Response Code: " + i, 0).show();
                            }
                        });
                    }
                    je.this.a(str, str2, i);
                    je.this.b();
                    return;
                }
                je.this.a(str);
            }
        };
        jw.a().a((Object) this, (je) ksVar);
    }
}

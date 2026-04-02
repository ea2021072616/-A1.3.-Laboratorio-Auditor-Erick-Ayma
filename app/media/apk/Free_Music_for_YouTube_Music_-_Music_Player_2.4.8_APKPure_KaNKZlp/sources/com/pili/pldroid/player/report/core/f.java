package com.pili.pldroid.player.report.core;

import android.content.Context;
import android.content.Intent;
import com.pili.pldroid.player.common.Config;
import com.pili.pldroid.player.report.common.a;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: QosStatusRecorder.java */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static Context f5075a;

    /* renamed from: b  reason: collision with root package name */
    private static String f5076b = null;
    private c f;
    private ArrayList<Float> g;
    private ArrayList<Float> h;
    private ArrayList<Float> i;
    private ArrayList<Float> j;
    private e k = new e();

    /* renamed from: c  reason: collision with root package name */
    private a f5077c = new a();
    private b d = new b();
    private d e = new d();

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        if (str == null || "".equals(str)) {
            return "-";
        }
        return str;
    }

    public void a(Context context) {
        f5075a = context.getApplicationContext();
        this.k.a(f5075a);
        f5076b = com.pili.pldroid.player.report.common.a.a(f5075a);
    }

    public void a() {
        this.k.b();
    }

    public b b() {
        return this.d;
    }

    public c c() {
        if (this.f == null) {
            this.f = new c();
        }
        return this.f;
    }

    public void d() {
        j();
    }

    private String i() {
        String[] i;
        int i2;
        String str;
        String str2 = null;
        int i3 = 0;
        String c2 = com.pili.pldroid.player.report.common.a.c(f5075a);
        String a2 = com.pili.pldroid.player.report.common.a.a();
        String b2 = com.pili.pldroid.player.report.common.a.b();
        boolean equals = c2.equals("WIFI");
        boolean equals2 = c2.equals("None");
        if (equals) {
            String[] h = com.pili.pldroid.player.report.common.a.h(f5075a);
            if (h != null && h.length >= 2) {
                str = h[0];
                i2 = com.pili.pldroid.player.report.common.a.b(h[1]) ? Integer.parseInt(h[1]) : 0;
            }
            i2 = 0;
            str = null;
        } else {
            if (!equals2 && (i = com.pili.pldroid.player.report.common.a.i(f5075a)) != null && i.length >= 2) {
                String str3 = i[0];
                if (com.pili.pldroid.player.report.common.a.b(i[1])) {
                    int parseInt = Integer.parseInt(i[1]);
                    i2 = 0;
                    i3 = parseInt;
                    str = null;
                    str2 = str3;
                } else {
                    i2 = 0;
                    str = null;
                    str2 = str3;
                }
            }
            i2 = 0;
            str = null;
        }
        return b(c2) + "\t" + b(a2) + "\t" + b(b2) + "\t" + b(str) + "\t" + b(str2) + "\t" + i2 + "\t" + i3;
    }

    private void j() {
        this.f5077c.a("network_change", "v5");
        c(this.f5077c.toString() + "\t" + this.e.toString() + "\t" + i() + "\n");
    }

    public void e() {
        k();
    }

    private void k() {
        float f;
        float f2 = 0.0f;
        a.C0099a f3 = com.pili.pldroid.player.report.common.a.f();
        a.b b2 = com.pili.pldroid.player.report.common.a.b(f5075a);
        float f4 = f3.f5050a / 100.0f;
        float f5 = f3.f5051b / 100.0f;
        if (b2.f5052a != 0) {
            f = ((float) b2.f5053b) / ((float) b2.f5052a);
            f2 = ((float) b2.f5054c) / ((float) b2.f5052a);
        } else {
            f = 0.0f;
        }
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        if (this.h == null) {
            this.h = new ArrayList<>();
        }
        if (this.i == null) {
            this.i = new ArrayList<>();
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.g.add(Float.valueOf(f4));
        this.h.add(Float.valueOf(f5));
        this.i.add(Float.valueOf(f));
        this.j.add(Float.valueOf(f2));
    }

    private float a(ArrayList<Float> arrayList) {
        float f = 0.0f;
        if (arrayList == null || arrayList.isEmpty()) {
            return 0.0f;
        }
        Iterator<Float> it = arrayList.iterator();
        while (true) {
            float f2 = f;
            if (it.hasNext()) {
                f = it.next().floatValue() + f2;
            } else {
                return f2 / arrayList.size();
            }
        }
    }

    private String a(int i, int i2, Intent intent) {
        float a2 = a(this.g);
        float a3 = a(this.h);
        float a4 = a(this.i);
        float a5 = a(this.j);
        int i3 = com.pili.pldroid.player.report.common.a.i();
        int intExtra = intent.getIntExtra("tcpConnectTime", 0);
        return this.e.toString() + "\t" + String.format("%.3f", Float.valueOf(a2)) + "\t" + String.format("%.3f", Float.valueOf(a3)) + "\t" + String.format("%.3f", Float.valueOf(a4)) + "\t" + String.format("%.3f", Float.valueOf(a5)) + "\t" + Config.COMPONENTS_VERSION + "\t" + i3 + "\t" + i() + "\t" + intExtra + "\t" + intent.getIntExtra("rtmpConnectTime", 0) + "\t" + intent.getIntExtra("firstByteTime", 0) + "\t" + b((String) null) + "\t" + i + "\t" + i2;
    }

    private void c(String str) {
        this.k.b(str);
    }

    private void d(String str) {
        this.k.a(str);
    }

    /* compiled from: QosStatusRecorder.java */
    /* loaded from: classes2.dex */
    public final class a {

        /* renamed from: b  reason: collision with root package name */
        private String f5079b;

        /* renamed from: c  reason: collision with root package name */
        private long f5080c;

        public a() {
        }

        public void a(String str, String str2) {
            this.f5079b = str + "." + str2;
        }

        private void a() {
            this.f5080c = System.currentTimeMillis();
        }

        public String toString() {
            a();
            return f.b(this.f5079b) + "\t" + this.f5080c + "\t" + f.b(f.f5076b) + "\t" + f.b(Config.VERSION);
        }
    }

    /* compiled from: QosStatusRecorder.java */
    /* loaded from: classes2.dex */
    public final class b {

        /* renamed from: b  reason: collision with root package name */
        private String f5082b;

        /* renamed from: c  reason: collision with root package name */
        private String f5083c;
        private String d;
        private String e;
        private String f;

        public b() {
        }

        public void a(String str, String str2, String str3, String str4, String str5) {
            this.f5082b = str;
            this.f5083c = str2;
            this.f = str3;
            this.d = str4;
            this.e = str5;
        }

        public String toString() {
            return f.this.f5077c.toString() + "\t" + f.b(this.f5082b) + "\t" + f.b(this.f5083c) + "\t" + f.b(this.d) + "\t" + f.b(this.e) + "\t" + f.b(this.f);
        }
    }

    /* compiled from: QosStatusRecorder.java */
    /* loaded from: classes2.dex */
    public final class d {

        /* renamed from: b  reason: collision with root package name */
        private String f5088b;

        /* renamed from: c  reason: collision with root package name */
        private String f5089c;
        private String d;
        private String e;
        private String f;

        public d() {
        }

        private void a() {
            this.f5088b = com.pili.pldroid.player.report.common.a.e();
            this.f5089c = "Android";
            this.d = com.pili.pldroid.player.report.common.a.d();
            this.e = com.pili.pldroid.player.report.common.a.d(f.f5075a);
            this.f = com.pili.pldroid.player.report.common.a.e(f.f5075a);
        }

        public String toString() {
            a();
            return f.b(this.f5088b) + "\t" + f.b(this.f5089c) + "\t" + f.b(this.d) + "\t" + f.b(this.e) + "\t" + f.b(this.f);
        }
    }

    public void a(Intent intent) {
        long longExtra = intent.getLongExtra("firstVideoTime", 0L);
        long longExtra2 = intent.getLongExtra("firstAudioTime", 0L);
        long longExtra3 = intent.getLongExtra("gopTime", -1L);
        String stringExtra = intent.getStringExtra("videoDecoderType");
        String stringExtra2 = intent.getStringExtra("audioDecoderType");
        int intExtra = intent.getIntExtra("tcpConnectTime", 0);
        int intExtra2 = intent.getIntExtra("firstByteTime", 0);
        this.f5077c.a("play_start", "v5");
        String str = this.d.toString() + "\t" + longExtra + "\t" + longExtra2 + "\t" + longExtra3 + "\t" + b(stringExtra) + "\t" + b(stringExtra2) + "\t" + intExtra + "\t" + intExtra2 + "\n";
        d(str);
        c(str);
    }

    public void b(Intent intent) {
        long longExtra = intent.getLongExtra("beginAt", 0L);
        long longExtra2 = intent.getLongExtra("endAt", 0L);
        long longExtra3 = intent.getLongExtra("bufferingTotalCount", -1L);
        long longExtra4 = intent.getLongExtra("bufferingTotalTimes", -1L);
        long longExtra5 = intent.getLongExtra("totalRecvBytes", -1L);
        int intExtra = intent.getIntExtra("endBufferingTime", -1);
        long longExtra6 = intent.getLongExtra("gopTime", -1L);
        int intExtra2 = intent.getIntExtra("errorCode", 0);
        int intExtra3 = intent.getIntExtra("errorOSCode", 0);
        this.f5077c.a("play_end", "v5");
        String str = this.d.toString() + "\t" + longExtra + "\t" + longExtra2 + "\t" + longExtra3 + "\t" + longExtra4 + "\t" + longExtra5 + "\t" + intExtra + "\t" + longExtra6 + "\t" + a(intExtra2, intExtra3, intent) + "\n";
        d(str);
        c(str);
        com.pili.pldroid.player.report.b.a();
    }

    public void f() {
        this.f5077c.a("play", "v5");
        d(this.d.toString() + "\t" + this.f.toString() + "\n");
    }

    /* compiled from: QosStatusRecorder.java */
    /* loaded from: classes2.dex */
    public final class c {

        /* renamed from: b  reason: collision with root package name */
        private long f5085b = 0;

        /* renamed from: c  reason: collision with root package name */
        private long f5086c = 0;
        private long d = 0;
        private int e = 0;
        private int f = 0;
        private int g = 0;
        private int h = 0;
        private int i = 0;
        private int j = 0;
        private int k = 0;
        private int l = 0;
        private long m = 0;
        private long n = 0;

        public c() {
        }

        public boolean a(long j, long j2, long j3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j4, long j5) {
            this.f5085b = j;
            this.f5086c = j2;
            this.e = i;
            this.f = i2;
            this.g = i3;
            this.d = j3;
            this.h = i4;
            this.i = i5;
            this.j = i6;
            this.k = i7;
            this.l = i8;
            this.m = j4;
            this.n = j5;
            return true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f5085b + "\t");
            sb.append(this.f5086c + "\t");
            sb.append(this.d + "\t");
            sb.append(this.e + "\t");
            sb.append(this.f + "\t");
            sb.append(this.g + "\t");
            sb.append(this.h + "\t");
            sb.append(this.i + "\t");
            sb.append(this.j + "\t");
            sb.append(this.k + "\t");
            sb.append(this.l + "\t");
            sb.append(this.m + "\t");
            sb.append(this.n);
            return sb.toString();
        }
    }
}

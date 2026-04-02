package com.acrcloud.rec.b.c;

import android.support.graphics.drawable.PathInterpolatorCompat;
import com.acrcloud.rec.b.a.d;
import com.acrcloud.rec.b.b.e;
import com.acrcloud.rec.b.b.h;
import com.acrcloud.rec.b.b.i;
import com.acrcloud.rec.b.c;
import com.acrcloud.rec.engine.ACRCloudRecognizeEngine;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
/* compiled from: ACRCloudWorker.java */
/* loaded from: classes.dex */
public class a extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private d f360a;

    /* renamed from: b  reason: collision with root package name */
    private com.acrcloud.rec.b.a f361b;
    private volatile boolean d = false;
    private volatile boolean e = false;
    private Map<String, Object> f = null;
    private Map<String, Object> g = null;
    private Map<String, String> h = null;
    private int i = 0;
    private int j = 0;
    private final int k = 1;
    private final int l = 2;
    private final int m = 3;
    private String n = "";

    /* renamed from: c  reason: collision with root package name */
    private ByteArrayOutputStream f362c = new ByteArrayOutputStream();

    public a(d dVar, com.acrcloud.rec.b.a aVar) {
        this.f360a = dVar;
        this.f361b = aVar;
        setDaemon(true);
    }

    public void a() {
        this.d = true;
    }

    public void b() {
        this.e = true;
    }

    private void c() {
        try {
            this.d = false;
            this.e = false;
            if (this.f362c != null) {
                this.f362c.close();
                this.f362c = null;
            }
            this.f360a = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.f361b = null;
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    private boolean d() {
        boolean z = true;
        h.b("ACRCloudWorker", "startRecognize");
        try {
            i a2 = this.f360a.a(this.h);
            if (a2.c() == 0) {
                this.f = new HashMap();
                this.g = new HashMap();
                this.f.put("ekey", a2.h());
                this.g.put("ekey", a2.h());
                this.f.put("fp_time", Integer.valueOf(a2.g()));
                this.g.put("fp_time", Integer.valueOf(a2.g()));
                this.f.put("service_type", Integer.valueOf(a2.k()));
                this.g.put("service_type", Integer.valueOf(a2.k()));
                this.f.put("engine_type", Integer.valueOf(a2.d()));
                this.g.put("engine_type", Integer.valueOf(a2.d()));
                this.i = a2.d();
                this.j = a2.g() * 16;
            } else if (a2.c() == 3000) {
                this.n = a2.i();
            } else {
                c cVar = new c();
                cVar.a(a2.i());
                a(cVar);
                z = false;
            }
        } catch (Exception e) {
            this.n = com.acrcloud.rec.b.b.a.a(2010, e.getMessage());
        }
        return z;
    }

    private void e() {
        int i;
        int i2 = 0;
        while (!this.d) {
            try {
                byte[] b2 = com.acrcloud.rec.a.a.a().b();
                if (!this.e && b2 == null) {
                    if (i2 < 10) {
                        i2++;
                    } else {
                        c cVar = new c();
                        cVar.a(com.acrcloud.rec.b.b.a.b(2000));
                        a(cVar);
                        com.acrcloud.rec.a.a.a().f();
                        return;
                    }
                } else {
                    if (b2 != null) {
                        this.f362c.write(b2);
                    }
                    if (com.acrcloud.rec.a.a.a().c()) {
                        i2 = 0;
                    } else if (!this.d) {
                        int size = this.f362c.size();
                        if (this.f != null) {
                            if ((size >= this.j && !this.d) || this.e) {
                                byte[] byteArray = this.f362c.toByteArray();
                                int length = byteArray.length;
                                if (length > 240000) {
                                    length = 240000;
                                }
                                if (this.e && this.i != 2) {
                                    this.i = 3;
                                }
                                i a2 = this.f360a.a(byteArray, length, this.g, this.h, this.i);
                                if (this.e && this.i != 1) {
                                    c cVar2 = new c();
                                    cVar2.b(a2.a());
                                    cVar2.a(byteArray);
                                    cVar2.a(e.a(a2));
                                    a(cVar2);
                                    return;
                                }
                                this.i = a2.d();
                                int g = a2.g();
                                this.g.put("fp_time", Integer.valueOf(g));
                                if (a2.c() == 0) {
                                    int intValue = ((Integer) this.g.get("service_type")).intValue() - a2.l();
                                    if (intValue == 0) {
                                        intValue = ((Integer) this.f.get("service_type")).intValue();
                                    }
                                    this.g.put("service_type", Integer.valueOf(intValue));
                                    c cVar3 = new c();
                                    cVar3.b(a2.a());
                                    cVar3.a(byteArray);
                                    cVar3.a(e.a(a2));
                                    a(cVar3);
                                }
                                if (g == 0) {
                                    if (a2.c() == 3000 || a2.c() == 2005) {
                                        if (length >= 240000) {
                                            c cVar4 = new c();
                                            cVar4.b(a2.a());
                                            cVar4.a(byteArray);
                                            cVar4.a(a2.i());
                                            a(cVar4);
                                        } else {
                                            this.j = 240000;
                                            this.g.put("fp_time", 12000);
                                            h.b("ACRCloudWorker", "http error, next rec len MAX_RECOGNIZE_BUFFER_LEN");
                                            i2 = 0;
                                        }
                                    } else if (a2.c() != 0) {
                                        c cVar5 = new c();
                                        cVar5.b(a2.a());
                                        cVar5.a(byteArray);
                                        cVar5.a(a2.i());
                                        a(cVar5);
                                    }
                                    i = ((Integer) this.f.get("fp_time")).intValue();
                                    this.g.put("fp_time", Integer.valueOf(i));
                                    this.g.put("service_type", this.f.get("service_type"));
                                    this.i = ((Integer) this.f.get("engine_type")).intValue();
                                    this.f362c.reset();
                                } else {
                                    i = g;
                                }
                                h.b("ACRCloudWorker", "curBufferLen=" + size + "  nextRecginzeLen=" + this.j + " curFpTime=" + i + " service_type=" + ((Integer) this.g.get("service_type")));
                                this.j = i * 16;
                            }
                        } else if (size >= 240000) {
                            c cVar6 = new c();
                            if (this.n == null || "".equals(this.n)) {
                                this.n = com.acrcloud.rec.b.b.a.b(PathInterpolatorCompat.MAX_NUM_POINTS);
                            }
                            cVar6.a(this.n);
                            byte[] byteArray2 = this.f362c.toByteArray();
                            cVar6.a(byteArray2);
                            cVar6.b(ACRCloudRecognizeEngine.c(byteArray2, byteArray2.length));
                            a(cVar6);
                            if (!this.d) {
                                d();
                            }
                            this.f362c.reset();
                        }
                        i2 = 0;
                    } else {
                        return;
                    }
                }
            } catch (Exception e) {
                c cVar7 = new c();
                cVar7.a(com.acrcloud.rec.b.b.a.a(2000, e.getMessage()));
                a(cVar7);
                com.acrcloud.rec.a.a.a().f();
                return;
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (!com.acrcloud.rec.a.a.a().a(this.f361b)) {
            c cVar = new c();
            cVar.a(com.acrcloud.rec.b.b.a.b(2000));
            a(cVar);
            com.acrcloud.rec.a.a.a().f();
            return;
        }
        if (d()) {
            e();
        }
        c();
    }

    private void a(c cVar) {
        if (!this.d) {
            if (this.e) {
                this.d = true;
            }
            if (cVar.a() == null || "".equals(cVar.a())) {
                cVar.a(com.acrcloud.rec.b.b.a.b(1001));
            }
            h.b("ACRCloudWorker", "onResult:" + cVar.a());
            this.f361b.a(cVar);
        }
    }
}

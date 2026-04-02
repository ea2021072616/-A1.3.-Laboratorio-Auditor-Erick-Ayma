package com.flurry.sdk;

import b.a.a.a.a.d.b;
import com.flurry.sdk.kz;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class ky {

    /* renamed from: b  reason: collision with root package name */
    public final String f2106b;
    public la e;

    /* renamed from: c  reason: collision with root package name */
    public String f2107c = "defaultDataKey_";
    public Set<String> d = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    private kh<jq> f2105a = new kh<jq>() { // from class: com.flurry.sdk.ky.1
        @Override // com.flurry.sdk.kh
        public final /* synthetic */ void a(jq jqVar) {
            jq jqVar2 = jqVar;
            km.a(4, ky.this.f2106b, "onNetworkStateChanged : isNetworkEnable = " + jqVar2.f1996a);
            if (!jqVar2.f1996a) {
                return;
            }
            ky.this.b();
        }
    };

    /* loaded from: classes.dex */
    public interface a {
    }

    public abstract void a(byte[] bArr, String str, String str2);

    public ky(final String str, String str2) {
        this.f2106b = str2;
        ki.a().a("com.flurry.android.sdk.NetworkStateEvent", this.f2105a);
        jy.a().b(new ma() { // from class: com.flurry.sdk.ky.2
            @Override // com.flurry.sdk.ma
            public final void a() {
                ky.this.e = new la(str);
            }
        });
    }

    public final void b() {
        jy.a().b(new ma() { // from class: com.flurry.sdk.ky.4

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f2114a = null;

            @Override // com.flurry.sdk.ma
            public final void a() {
                final ky kyVar = ky.this;
                if (!jr.a().f2000b) {
                    km.a(5, kyVar.f2106b, "Reports were not sent! No Internet connection!");
                    return;
                }
                ArrayList<String> arrayList = new ArrayList(kyVar.e.f2129c.keySet());
                if (arrayList.isEmpty()) {
                    km.a(4, kyVar.f2106b, "No more reports to send.");
                    return;
                }
                for (String str : arrayList) {
                    if (!kyVar.c()) {
                        return;
                    }
                    List<String> a2 = kyVar.e.a(str);
                    km.a(4, kyVar.f2106b, "Number of not sent blocks = " + a2.size());
                    for (String str2 : a2) {
                        if (!kyVar.d.contains(str2)) {
                            if (kyVar.c()) {
                                kz kzVar = (kz) new kf(jy.a().f2022a.getFileStreamPath(kz.a(str2)), ".yflurrydatasenderblock.", 1, new lj<kz>() { // from class: com.flurry.sdk.ky.6
                                    @Override // com.flurry.sdk.lj
                                    public final lg<kz> a(int i) {
                                        return new kz.a();
                                    }
                                }).a();
                                if (kzVar == null) {
                                    km.a(6, kyVar.f2106b, "Internal ERROR! Cannot read!");
                                    kyVar.e.a(str2, str);
                                } else {
                                    byte[] bArr = kzVar.f2124b;
                                    if (bArr == null || bArr.length == 0) {
                                        km.a(6, kyVar.f2106b, "Internal ERROR! Report is empty!");
                                        kyVar.e.a(str2, str);
                                    } else {
                                        km.a(5, kyVar.f2106b, "Reading block info " + str2);
                                        kyVar.d.add(str2);
                                        kyVar.a(bArr, str2, str);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    public void a(final String str, final String str2, int i) {
        jy.a().b(new ma() { // from class: com.flurry.sdk.ky.7
            @Override // com.flurry.sdk.ma
            public final void a() {
                if (!ky.this.e.a(str, str2)) {
                    km.a(6, ky.this.f2106b, "Internal error. Block wasn't deleted with id = " + str);
                }
                if (!ky.this.d.remove(str)) {
                    km.a(6, ky.this.f2106b, "Internal error. Block with id = " + str + " was not in progress state");
                }
            }
        });
    }

    public final void a(final String str) {
        jy.a().b(new ma() { // from class: com.flurry.sdk.ky.8
            @Override // com.flurry.sdk.ma
            public final void a() {
                if (!ky.this.d.remove(str)) {
                    km.a(6, ky.this.f2106b, "Internal error. Block with id = " + str + " was not in progress state");
                }
            }
        });
    }

    public final void b(final byte[] bArr, final String str, final String str2) {
        if (bArr == null || bArr.length == 0) {
            km.a(6, this.f2106b, "Report that has to be sent is EMPTY or NULL");
            return;
        }
        jy.a().b(new ma() { // from class: com.flurry.sdk.ky.3
            @Override // com.flurry.sdk.ma
            public final void a() {
                final ky kyVar = ky.this;
                byte[] bArr2 = bArr;
                kz kzVar = new kz(bArr2);
                String str3 = kzVar.f2123a;
                new kf(jy.a().f2022a.getFileStreamPath(kz.a(str3)), ".yflurrydatasenderblock.", 1, new lj<kz>() { // from class: com.flurry.sdk.ky.5
                    @Override // com.flurry.sdk.lj
                    public final lg<kz> a(int i) {
                        return new kz.a();
                    }
                }).a(kzVar);
                km.a(5, kyVar.f2106b, "Saving Block File " + str3 + " at " + jy.a().f2022a.getFileStreamPath(kz.a(str3)));
                kyVar.e.a(kzVar, kyVar.f2107c + str + b.ROLL_OVER_FILE_NAME_SEPARATOR + str2);
            }
        });
        b();
    }

    final boolean c() {
        return this.d.size() <= 5;
    }
}

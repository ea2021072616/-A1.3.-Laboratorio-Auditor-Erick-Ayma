package com.flurry.sdk;

import com.flurry.sdk.ku;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public final class ks<RequestObjectType, ResponseObjectType> extends ku {

    /* renamed from: a  reason: collision with root package name */
    public a<RequestObjectType, ResponseObjectType> f2078a;

    /* renamed from: b  reason: collision with root package name */
    public RequestObjectType f2079b;

    /* renamed from: c  reason: collision with root package name */
    public lg<RequestObjectType> f2080c;
    public lg<ResponseObjectType> d;
    private ResponseObjectType v;

    /* loaded from: classes.dex */
    public interface a<RequestObjectType, ResponseObjectType> {
        void a(ks<RequestObjectType, ResponseObjectType> ksVar, ResponseObjectType responseobjecttype);
    }

    @Override // com.flurry.sdk.ku, com.flurry.sdk.ma
    public final void a() {
        this.l = new ku.c() { // from class: com.flurry.sdk.ks.1
            @Override // com.flurry.sdk.ku.c
            public final void a(OutputStream outputStream) throws Exception {
                if (ks.this.f2079b != null && ks.this.f2080c != null) {
                    ks.this.f2080c.a(outputStream, ks.this.f2079b);
                }
            }

            @Override // com.flurry.sdk.ku.c
            public final void a(ku kuVar, InputStream inputStream) throws Exception {
                if (kuVar.d() && ks.this.d != null) {
                    ks.this.v = ks.this.d.a(inputStream);
                }
            }

            @Override // com.flurry.sdk.ku.c
            public final void a(ku kuVar) {
                ks.d(ks.this);
            }
        };
        super.a();
    }

    static /* synthetic */ void d(ks ksVar) {
        if (ksVar.f2078a == null || ksVar.g()) {
            return;
        }
        ksVar.f2078a.a(ksVar, ksVar.v);
    }
}

package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class ld<ObjectType> implements lg<ObjectType> {

    /* renamed from: a  reason: collision with root package name */
    protected final lg<ObjectType> f2140a;

    public ld(lg<ObjectType> lgVar) {
        this.f2140a = lgVar;
    }

    @Override // com.flurry.sdk.lg
    public void a(OutputStream outputStream, ObjectType objecttype) throws IOException {
        if (this.f2140a != null && outputStream != null && objecttype != null) {
            this.f2140a.a(outputStream, objecttype);
        }
    }

    @Override // com.flurry.sdk.lg
    public ObjectType a(InputStream inputStream) throws IOException {
        if (this.f2140a == null || inputStream == null) {
            return null;
        }
        return this.f2140a.a(inputStream);
    }
}

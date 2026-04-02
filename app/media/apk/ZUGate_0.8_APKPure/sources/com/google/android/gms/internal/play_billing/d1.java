package com.google.android.gms.internal.play_billing;

import java.nio.charset.Charset;
/* loaded from: classes.dex */
public final class d1 {

    /* renamed from: b  reason: collision with root package name */
    public static final b1 f1850b = new b1();

    /* renamed from: a  reason: collision with root package name */
    public final c1 f1851a;

    public d1() {
        i1 i1Var;
        i1[] i1VarArr = new i1[2];
        i1VarArr[0] = j0.f1899a;
        try {
            i1Var = (i1) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            i1Var = f1850b;
        }
        i1VarArr[1] = i1Var;
        c1 c1Var = new c1(i1VarArr);
        Charset charset = s0.f1953a;
        this.f1851a = c1Var;
    }
}

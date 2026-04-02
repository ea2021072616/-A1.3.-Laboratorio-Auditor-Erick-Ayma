package com.google.android.gms.internal.play_billing;

import java.io.IOException;
/* loaded from: classes.dex */
public abstract class r implements j1 {
    protected int zza = 0;

    public abstract int a(t1 t1Var);

    public final byte[] b() {
        try {
            l0 l0Var = (l0) this;
            int d5 = l0Var.d();
            byte[] bArr = new byte[d5];
            b0 b0Var = new b0(bArr, d5);
            l0Var.c(b0Var);
            if (d5 - b0Var.f1845x == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e5) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a byte array threw an IOException (should never happen).", e5);
        }
    }
}

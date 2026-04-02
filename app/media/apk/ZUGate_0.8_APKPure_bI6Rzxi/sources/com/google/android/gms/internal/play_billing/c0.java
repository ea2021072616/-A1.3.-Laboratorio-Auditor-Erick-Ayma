package com.google.android.gms.internal.play_billing;

import java.io.IOException;
/* loaded from: classes.dex */
public final class c0 extends IOException {
    public c0(String str, IndexOutOfBoundsException indexOutOfBoundsException) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), indexOutOfBoundsException);
    }

    public c0(IndexOutOfBoundsException indexOutOfBoundsException) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", indexOutOfBoundsException);
    }
}

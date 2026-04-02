package com.google.android.gms.internal.play_billing;

import java.io.IOException;
/* loaded from: classes.dex */
public class u0 extends IOException {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int f1961b = 0;

    public u0(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public static u0 a() {
        return new u0("Protocol message had invalid UTF-8.");
    }

    public static u0 b() {
        return new u0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static u0 c() {
        return new u0("Failed to parse the message.");
    }

    public static u0 d() {
        return new u0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}

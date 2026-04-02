package com.flurry.sdk;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class jw extends kl<ku> {

    /* renamed from: a  reason: collision with root package name */
    private static jw f2014a = null;

    protected jw() {
        super(jw.class.getName(), TimeUnit.MILLISECONDS, new PriorityBlockingQueue(11, new kj()));
    }

    public static synchronized jw a() {
        jw jwVar;
        synchronized (jw.class) {
            if (f2014a == null) {
                f2014a = new jw();
            }
            jwVar = f2014a;
        }
        return jwVar;
    }
}

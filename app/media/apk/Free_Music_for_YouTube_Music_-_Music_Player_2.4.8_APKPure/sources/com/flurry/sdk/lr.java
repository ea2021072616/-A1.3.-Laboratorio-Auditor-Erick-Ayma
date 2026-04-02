package com.flurry.sdk;

import android.support.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes.dex */
public final class lr implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadGroup f2175a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2176b = 1;

    public lr(String str) {
        this.f2175a = new ThreadGroup(str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(@NonNull Runnable runnable) {
        Thread thread = new Thread(this.f2175a, runnable);
        thread.setName(this.f2175a.getName() + ":" + thread.getId());
        thread.setPriority(this.f2176b);
        return thread;
    }
}

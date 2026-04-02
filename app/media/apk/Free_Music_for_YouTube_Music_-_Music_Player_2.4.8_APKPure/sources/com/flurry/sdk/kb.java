package com.flurry.sdk;

import android.app.Activity;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class kb extends kg {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Activity> f2029a;

    /* renamed from: b  reason: collision with root package name */
    public a f2030b;

    /* loaded from: classes.dex */
    public enum a {
        kCreated,
        kDestroyed,
        kPaused,
        kResumed,
        kStarted,
        kStopped,
        kSaveState
    }

    public kb() {
        super("com.flurry.android.sdk.ActivityLifecycleEvent");
        this.f2029a = new WeakReference<>(null);
    }
}

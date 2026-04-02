package com.flurry.android;
/* loaded from: classes.dex */
public enum FlurrySyndicationEventName {
    REBLOG("Reblog"),
    FAST_REBLOG("FastReblog"),
    SOURCE_LINK("SourceClick"),
    LIKE("Like");
    

    /* renamed from: a  reason: collision with root package name */
    private String f1800a;

    FlurrySyndicationEventName(String str) {
        this.f1800a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f1800a;
    }
}

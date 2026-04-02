package com.flurry.sdk;

import android.text.TextUtils;
/* loaded from: classes.dex */
public abstract class kg {
    protected String f;

    public kg(String str) {
        this.f = "com.flurry.android.sdk.ReplaceMeWithAProperEventName";
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Event must have a name!");
        }
        this.f = str;
    }

    public final String a() {
        return this.f;
    }

    public final void b() {
        ki.a().a(this);
    }
}

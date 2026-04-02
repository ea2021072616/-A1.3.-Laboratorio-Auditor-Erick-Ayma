package com.fotoable.youtube.music.c.b;

import com.fotoable.youtube.music.base.BaseActivity;
import dagger.Module;
import dagger.Provides;
/* compiled from: ActivityModule.java */
@Module
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final BaseActivity f2385a;

    public a(BaseActivity baseActivity) {
        this.f2385a = baseActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public BaseActivity a() {
        return this.f2385a;
    }
}

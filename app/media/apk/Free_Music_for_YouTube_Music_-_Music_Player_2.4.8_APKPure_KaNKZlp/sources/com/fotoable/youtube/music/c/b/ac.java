package com.fotoable.youtube.music.c.b;

import android.app.Service;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
/* compiled from: ServiceModule.java */
@Module
/* loaded from: classes.dex */
public class ac {

    /* renamed from: a  reason: collision with root package name */
    private Service f2390a;

    public ac(Service service) {
        this.f2390a = service;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public Service a() {
        return this.f2390a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public Context b() {
        return this.f2390a.getApplication();
    }
}

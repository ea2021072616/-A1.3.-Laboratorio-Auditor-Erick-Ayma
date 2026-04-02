package com.fotoable.youtube.music.c.b;

import android.content.Context;
import com.fotoable.youtube.music.MusicApplication;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
/* compiled from: ApplicationModule.java */
@Module
/* loaded from: classes.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    private final MusicApplication f2444a;

    public t(MusicApplication musicApplication) {
        this.f2444a = musicApplication;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public MusicApplication a() {
        return this.f2444a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("AppContext")
    public Context b() {
        return this.f2444a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public com.fotoable.youtube.music.db.a c() {
        return new com.fotoable.youtube.music.db.a(this.f2444a);
    }
}

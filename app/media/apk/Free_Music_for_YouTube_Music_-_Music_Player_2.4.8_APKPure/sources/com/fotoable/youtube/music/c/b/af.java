package com.fotoable.youtube.music.c.b;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
/* compiled from: ViewModule.java */
@Module
/* loaded from: classes.dex */
public class af {

    /* renamed from: a  reason: collision with root package name */
    private Context f2395a;

    public af(Context context) {
        this.f2395a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public Context a() {
        return this.f2395a;
    }
}

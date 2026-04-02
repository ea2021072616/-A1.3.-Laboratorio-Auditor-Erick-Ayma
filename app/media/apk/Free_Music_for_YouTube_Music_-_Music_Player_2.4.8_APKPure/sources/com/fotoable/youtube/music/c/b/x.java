package com.fotoable.youtube.music.c.b;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
/* compiled from: DialogModule.java */
@Module
/* loaded from: classes.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    private com.fotoable.youtube.music.ui.dialog.a f2451a;

    public x(com.fotoable.youtube.music.ui.dialog.a aVar) {
        this.f2451a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public Context a() {
        return this.f2451a.getActivity();
    }
}

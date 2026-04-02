package com.fotoable.youtube.music.c.b;

import com.fotoable.youtube.music.base.BaseActivity;
import dagger.Module;
import dagger.Provides;
/* compiled from: FragmentModule.java */
@Module
/* loaded from: classes.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    private com.fotoable.youtube.music.base.i f2454a;

    public z(com.fotoable.youtube.music.base.i iVar) {
        this.f2454a = iVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public BaseActivity a() {
        return (BaseActivity) this.f2454a.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public com.fotoable.youtube.music.base.i b() {
        return this.f2454a;
    }
}

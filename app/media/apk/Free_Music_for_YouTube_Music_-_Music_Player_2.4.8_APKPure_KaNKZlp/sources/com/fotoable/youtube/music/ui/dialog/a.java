package com.fotoable.youtube.music.ui.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import com.fotoable.youtube.music.MusicApplication;
/* compiled from: BaseDialogFragment.java */
/* loaded from: classes.dex */
public abstract class a extends DialogFragment {
    protected abstract void a();

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        a();
    }

    protected com.fotoable.youtube.music.c.a.b b() {
        return MusicApplication.c().e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.fotoable.youtube.music.c.a.i c() {
        return com.fotoable.youtube.music.c.a.e.a().a(b()).a(d()).a();
    }

    protected com.fotoable.youtube.music.c.b.x d() {
        return new com.fotoable.youtube.music.c.b.x(this);
    }
}

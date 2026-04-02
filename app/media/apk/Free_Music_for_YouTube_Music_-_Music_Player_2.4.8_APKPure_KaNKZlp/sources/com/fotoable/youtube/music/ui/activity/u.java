package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: EditorChoicePlayListActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class u implements MembersInjector<EditorChoicePlayListActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4016a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f4017b;

    static {
        f4016a = !u.class.desiredAssertionStatus();
    }

    public u(Provider<com.fotoable.youtube.music.b.c> provider) {
        if (!f4016a && provider == null) {
            throw new AssertionError();
        }
        this.f4017b = provider;
    }

    public static MembersInjector<EditorChoicePlayListActivity> a(Provider<com.fotoable.youtube.music.b.c> provider) {
        return new u(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(EditorChoicePlayListActivity editorChoicePlayListActivity) {
        if (editorChoicePlayListActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        editorChoicePlayListActivity.f3291a = this.f4017b.get();
    }
}

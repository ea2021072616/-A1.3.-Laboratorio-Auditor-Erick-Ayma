package com.fotoable.youtube.music.c.a;

import android.content.Context;
import com.fotoable.youtube.music.c.b.x;
import com.fotoable.youtube.music.c.b.y;
import com.fotoable.youtube.music.ui.dialog.LocalMusicMenuDialog;
import com.fotoable.youtube.music.ui.dialog.MusicMenuDialog;
import com.fotoable.youtube.music.ui.dialog.r;
import com.fotoable.youtube.music.ui.dialog.s;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
/* compiled from: DaggerDialogComponent.java */
/* loaded from: classes.dex */
public final class e implements i {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2347a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<Context> f2348b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<com.fotoable.youtube.music.db.a> f2349c;
    private MembersInjector<MusicMenuDialog> d;
    private MembersInjector<LocalMusicMenuDialog> e;

    static {
        f2347a = !e.class.desiredAssertionStatus();
    }

    private e(a aVar) {
        if (!f2347a && aVar == null) {
            throw new AssertionError();
        }
        a(aVar);
    }

    public static a a() {
        return new a();
    }

    private void a(final a aVar) {
        this.f2348b = DoubleCheck.provider(y.a(aVar.f2353a));
        this.f2349c = new Factory<com.fotoable.youtube.music.db.a>() { // from class: com.fotoable.youtube.music.c.a.e.1

            /* renamed from: c  reason: collision with root package name */
            private final b f2352c;

            {
                this.f2352c = aVar.f2354b;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public com.fotoable.youtube.music.db.a get() {
                return (com.fotoable.youtube.music.db.a) Preconditions.checkNotNull(this.f2352c.d(), "Cannot return null from a non-@Nullable component method");
            }
        };
        this.d = s.a(this.f2349c);
        this.e = r.a(this.f2349c);
    }

    @Override // com.fotoable.youtube.music.c.a.i
    public void a(MusicMenuDialog musicMenuDialog) {
        this.d.injectMembers(musicMenuDialog);
    }

    @Override // com.fotoable.youtube.music.c.a.i
    public void a(LocalMusicMenuDialog localMusicMenuDialog) {
        this.e.injectMembers(localMusicMenuDialog);
    }

    /* compiled from: DaggerDialogComponent.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private x f2353a;

        /* renamed from: b  reason: collision with root package name */
        private b f2354b;

        private a() {
        }

        public i a() {
            if (this.f2353a == null) {
                throw new IllegalStateException(x.class.getCanonicalName() + " must be set");
            }
            if (this.f2354b == null) {
                throw new IllegalStateException(b.class.getCanonicalName() + " must be set");
            }
            return new e(this);
        }

        public a a(x xVar) {
            this.f2353a = (x) Preconditions.checkNotNull(xVar);
            return this;
        }

        public a a(b bVar) {
            this.f2354b = (b) Preconditions.checkNotNull(bVar);
            return this;
        }
    }
}

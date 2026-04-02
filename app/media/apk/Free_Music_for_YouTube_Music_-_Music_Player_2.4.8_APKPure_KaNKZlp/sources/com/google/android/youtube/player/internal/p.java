package com.google.android.youtube.player.internal;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.google.android.youtube.player.internal.j;
/* loaded from: classes2.dex */
public final class p extends com.google.android.youtube.player.internal.a {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f4957a;

    /* renamed from: b  reason: collision with root package name */
    private b f4958b;

    /* renamed from: c  reason: collision with root package name */
    private k f4959c;
    private boolean d;
    private boolean e;

    /* loaded from: classes2.dex */
    private final class a extends j.a {
        private a() {
        }

        /* synthetic */ a(p pVar, byte b2) {
            this();
        }

        @Override // com.google.android.youtube.player.internal.j
        public final void a(final Bitmap bitmap, final String str, final boolean z, final boolean z2) {
            p.this.f4957a.post(new Runnable() { // from class: com.google.android.youtube.player.internal.p.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    p.this.d = z;
                    p.this.e = z2;
                    p.this.a(bitmap, str);
                }
            });
        }

        @Override // com.google.android.youtube.player.internal.j
        public final void a(final String str, final boolean z, final boolean z2) {
            p.this.f4957a.post(new Runnable() { // from class: com.google.android.youtube.player.internal.p.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    p.this.d = z;
                    p.this.e = z2;
                    p.this.b(str);
                }
            });
        }
    }

    public p(b bVar, YouTubeThumbnailView youTubeThumbnailView) {
        super(youTubeThumbnailView);
        this.f4958b = (b) ab.a(bVar, "connectionClient cannot be null");
        this.f4959c = bVar.a(new a(this, (byte) 0));
        this.f4957a = new Handler(Looper.getMainLooper());
    }

    @Override // com.google.android.youtube.player.internal.a
    public final void a(String str) {
        try {
            this.f4959c.a(str);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.android.youtube.player.internal.a
    public final void a(String str, int i) {
        try {
            this.f4959c.a(str, i);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.youtube.player.internal.a
    public final boolean a() {
        return super.a() && this.f4959c != null;
    }

    @Override // com.google.android.youtube.player.internal.a
    public final void c() {
        try {
            this.f4959c.a();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.android.youtube.player.internal.a
    public final void d() {
        try {
            this.f4959c.b();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.android.youtube.player.internal.a
    public final void e() {
        try {
            this.f4959c.c();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.android.youtube.player.internal.a
    public final boolean f() {
        return this.e;
    }

    @Override // com.google.android.youtube.player.internal.a
    public final boolean g() {
        return this.d;
    }

    @Override // com.google.android.youtube.player.internal.a
    public final void h() {
        try {
            this.f4959c.d();
        } catch (RemoteException e) {
        }
        this.f4958b.d();
        this.f4959c = null;
        this.f4958b = null;
    }
}

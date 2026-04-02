package com.google.android.youtube.player.internal;

import android.graphics.Bitmap;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public abstract class a implements YouTubeThumbnailLoader {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<YouTubeThumbnailView> f4936a;

    /* renamed from: b  reason: collision with root package name */
    private YouTubeThumbnailLoader.OnThumbnailLoadedListener f4937b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4938c;
    private boolean d;

    public a(YouTubeThumbnailView youTubeThumbnailView) {
        this.f4936a = new WeakReference<>(ab.a(youTubeThumbnailView));
    }

    private void i() {
        if (!a()) {
            throw new IllegalStateException("This YouTubeThumbnailLoader has been released");
        }
    }

    public final void a(Bitmap bitmap, String str) {
        YouTubeThumbnailView youTubeThumbnailView = this.f4936a.get();
        if (!a() || youTubeThumbnailView == null) {
            return;
        }
        youTubeThumbnailView.setImageBitmap(bitmap);
        if (this.f4937b != null) {
            this.f4937b.onThumbnailLoaded(youTubeThumbnailView, str);
        }
    }

    public abstract void a(String str);

    public abstract void a(String str, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a() {
        return !this.d;
    }

    public final void b() {
        if (a()) {
            y.a("The finalize() method for a YouTubeThumbnailLoader has work to do. You should have called release().", new Object[0]);
            release();
        }
    }

    public final void b(String str) {
        YouTubeThumbnailLoader.ErrorReason errorReason;
        YouTubeThumbnailView youTubeThumbnailView = this.f4936a.get();
        if (!a() || this.f4937b == null || youTubeThumbnailView == null) {
            return;
        }
        try {
            errorReason = YouTubeThumbnailLoader.ErrorReason.valueOf(str);
        } catch (IllegalArgumentException e) {
            errorReason = YouTubeThumbnailLoader.ErrorReason.UNKNOWN;
        } catch (NullPointerException e2) {
            errorReason = YouTubeThumbnailLoader.ErrorReason.UNKNOWN;
        }
        this.f4937b.onThumbnailError(youTubeThumbnailView, errorReason);
    }

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract boolean f();

    @Override // com.google.android.youtube.player.YouTubeThumbnailLoader
    public final void first() {
        i();
        if (!this.f4938c) {
            throw new IllegalStateException("Must call setPlaylist first");
        }
        e();
    }

    public abstract boolean g();

    public abstract void h();

    @Override // com.google.android.youtube.player.YouTubeThumbnailLoader
    public final boolean hasNext() {
        i();
        return f();
    }

    @Override // com.google.android.youtube.player.YouTubeThumbnailLoader
    public final boolean hasPrevious() {
        i();
        return g();
    }

    @Override // com.google.android.youtube.player.YouTubeThumbnailLoader
    public final void next() {
        i();
        if (!this.f4938c) {
            throw new IllegalStateException("Must call setPlaylist first");
        }
        if (!f()) {
            throw new NoSuchElementException("Called next at end of playlist");
        }
        c();
    }

    @Override // com.google.android.youtube.player.YouTubeThumbnailLoader
    public final void previous() {
        i();
        if (!this.f4938c) {
            throw new IllegalStateException("Must call setPlaylist first");
        }
        if (!g()) {
            throw new NoSuchElementException("Called previous at start of playlist");
        }
        d();
    }

    @Override // com.google.android.youtube.player.YouTubeThumbnailLoader
    public final void release() {
        if (a()) {
            this.d = true;
            this.f4937b = null;
            h();
        }
    }

    @Override // com.google.android.youtube.player.YouTubeThumbnailLoader
    public final void setOnThumbnailLoadedListener(YouTubeThumbnailLoader.OnThumbnailLoadedListener onThumbnailLoadedListener) {
        i();
        this.f4937b = onThumbnailLoadedListener;
    }

    @Override // com.google.android.youtube.player.YouTubeThumbnailLoader
    public final void setPlaylist(String str) {
        setPlaylist(str, 0);
    }

    @Override // com.google.android.youtube.player.YouTubeThumbnailLoader
    public final void setPlaylist(String str, int i) {
        i();
        this.f4938c = true;
        a(str, i);
    }

    @Override // com.google.android.youtube.player.YouTubeThumbnailLoader
    public final void setVideo(String str) {
        i();
        this.f4938c = false;
        a(str);
    }
}

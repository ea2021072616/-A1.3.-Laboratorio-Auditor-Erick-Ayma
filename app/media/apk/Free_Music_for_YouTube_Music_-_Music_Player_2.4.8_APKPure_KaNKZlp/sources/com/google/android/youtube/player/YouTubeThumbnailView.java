package com.google.android.youtube.player;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.google.android.youtube.player.internal.aa;
import com.google.android.youtube.player.internal.ab;
import com.google.android.youtube.player.internal.b;
import com.google.android.youtube.player.internal.t;
/* loaded from: classes2.dex */
public final class YouTubeThumbnailView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private b f4932a;

    /* renamed from: b  reason: collision with root package name */
    private com.google.android.youtube.player.internal.a f4933b;

    /* loaded from: classes2.dex */
    public interface OnInitializedListener {
        void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult);

        void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader);
    }

    /* loaded from: classes2.dex */
    private static final class a implements t.a, t.b {

        /* renamed from: a  reason: collision with root package name */
        private YouTubeThumbnailView f4934a;

        /* renamed from: b  reason: collision with root package name */
        private OnInitializedListener f4935b;

        public a(YouTubeThumbnailView youTubeThumbnailView, OnInitializedListener onInitializedListener) {
            this.f4934a = (YouTubeThumbnailView) ab.a(youTubeThumbnailView, "thumbnailView cannot be null");
            this.f4935b = (OnInitializedListener) ab.a(onInitializedListener, "onInitializedlistener cannot be null");
        }

        private void c() {
            if (this.f4934a != null) {
                YouTubeThumbnailView.c(this.f4934a);
                this.f4934a = null;
                this.f4935b = null;
            }
        }

        @Override // com.google.android.youtube.player.internal.t.a
        public final void a() {
            if (this.f4934a == null || this.f4934a.f4932a == null) {
                return;
            }
            this.f4934a.f4933b = aa.a().a(this.f4934a.f4932a, this.f4934a);
            this.f4935b.onInitializationSuccess(this.f4934a, this.f4934a.f4933b);
            c();
        }

        @Override // com.google.android.youtube.player.internal.t.b
        public final void a(YouTubeInitializationResult youTubeInitializationResult) {
            this.f4935b.onInitializationFailure(this.f4934a, youTubeInitializationResult);
            c();
        }

        @Override // com.google.android.youtube.player.internal.t.a
        public final void b() {
            c();
        }
    }

    public YouTubeThumbnailView(Context context) {
        this(context, null);
    }

    public YouTubeThumbnailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YouTubeThumbnailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    static /* synthetic */ b c(YouTubeThumbnailView youTubeThumbnailView) {
        youTubeThumbnailView.f4932a = null;
        return null;
    }

    protected final void finalize() throws Throwable {
        if (this.f4933b != null) {
            this.f4933b.b();
            this.f4933b = null;
        }
        super.finalize();
    }

    public final void initialize(String str, OnInitializedListener onInitializedListener) {
        a aVar = new a(this, onInitializedListener);
        this.f4932a = aa.a().a(getContext(), str, aVar, aVar);
        this.f4932a.e();
    }
}

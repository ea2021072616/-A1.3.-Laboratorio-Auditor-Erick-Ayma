package com.google.android.youtube.player;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
/* loaded from: classes2.dex */
public class YouTubeBaseActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private a f4905a;

    /* renamed from: b  reason: collision with root package name */
    private YouTubePlayerView f4906b;

    /* renamed from: c  reason: collision with root package name */
    private int f4907c;
    private Bundle d;

    /* loaded from: classes2.dex */
    private final class a implements YouTubePlayerView.b {
        private a() {
        }

        /* synthetic */ a(YouTubeBaseActivity youTubeBaseActivity, byte b2) {
            this();
        }

        @Override // com.google.android.youtube.player.YouTubePlayerView.b
        public final void a(YouTubePlayerView youTubePlayerView) {
            if (YouTubeBaseActivity.this.f4906b != null && YouTubeBaseActivity.this.f4906b != youTubePlayerView) {
                YouTubeBaseActivity.this.f4906b.c(true);
            }
            YouTubeBaseActivity.this.f4906b = youTubePlayerView;
            if (YouTubeBaseActivity.this.f4907c > 0) {
                youTubePlayerView.a();
            }
            if (YouTubeBaseActivity.this.f4907c >= 2) {
                youTubePlayerView.b();
            }
        }

        @Override // com.google.android.youtube.player.YouTubePlayerView.b
        public final void a(YouTubePlayerView youTubePlayerView, String str, YouTubePlayer.OnInitializedListener onInitializedListener) {
            youTubePlayerView.a(YouTubeBaseActivity.this, youTubePlayerView, str, onInitializedListener, YouTubeBaseActivity.this.d);
            YouTubeBaseActivity.b(YouTubeBaseActivity.this);
        }
    }

    static /* synthetic */ Bundle b(YouTubeBaseActivity youTubeBaseActivity) {
        youTubeBaseActivity.d = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final YouTubePlayerView.b a() {
        return this.f4905a;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4905a = new a(this, (byte) 0);
        this.d = bundle != null ? bundle.getBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE") : null;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.f4906b != null) {
            this.f4906b.b(isFinishing());
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        this.f4907c = 1;
        if (this.f4906b != null) {
            this.f4906b.c();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f4907c = 2;
        if (this.f4906b != null) {
            this.f4906b.b();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE", this.f4906b != null ? this.f4906b.e() : this.d);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f4907c = 1;
        if (this.f4906b != null) {
            this.f4906b.a();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        this.f4907c = 0;
        if (this.f4906b != null) {
            this.f4906b.d();
        }
        super.onStop();
    }
}

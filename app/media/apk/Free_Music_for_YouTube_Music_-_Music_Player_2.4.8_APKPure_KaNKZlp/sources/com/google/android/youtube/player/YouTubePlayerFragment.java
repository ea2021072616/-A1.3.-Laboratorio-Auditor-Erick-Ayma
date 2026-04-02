package com.google.android.youtube.player;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.internal.ab;
/* loaded from: classes2.dex */
public class YouTubePlayerFragment extends Fragment implements YouTubePlayer.Provider {

    /* renamed from: a  reason: collision with root package name */
    private final a f4916a = new a(this, (byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private Bundle f4917b;

    /* renamed from: c  reason: collision with root package name */
    private YouTubePlayerView f4918c;
    private String d;
    private YouTubePlayer.OnInitializedListener e;
    private boolean f;

    /* loaded from: classes2.dex */
    private final class a implements YouTubePlayerView.b {
        private a() {
        }

        /* synthetic */ a(YouTubePlayerFragment youTubePlayerFragment, byte b2) {
            this();
        }

        @Override // com.google.android.youtube.player.YouTubePlayerView.b
        public final void a(YouTubePlayerView youTubePlayerView) {
        }

        @Override // com.google.android.youtube.player.YouTubePlayerView.b
        public final void a(YouTubePlayerView youTubePlayerView, String str, YouTubePlayer.OnInitializedListener onInitializedListener) {
            YouTubePlayerFragment.this.initialize(str, YouTubePlayerFragment.this.e);
        }
    }

    private void a() {
        if (this.f4918c == null || this.e == null) {
            return;
        }
        this.f4918c.a(this.f);
        this.f4918c.a(getActivity(), this, this.d, this.e, this.f4917b);
        this.f4917b = null;
        this.e = null;
    }

    public static YouTubePlayerFragment newInstance() {
        return new YouTubePlayerFragment();
    }

    @Override // com.google.android.youtube.player.YouTubePlayer.Provider
    public void initialize(String str, YouTubePlayer.OnInitializedListener onInitializedListener) {
        this.d = ab.a(str, (Object) "Developer key cannot be null or empty");
        this.e = onInitializedListener;
        a();
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4917b = bundle != null ? bundle.getBundle("YouTubePlayerFragment.KEY_PLAYER_VIEW_STATE") : null;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f4918c = new YouTubePlayerView(getActivity(), null, 0, this.f4916a);
        a();
        return this.f4918c;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        if (this.f4918c != null) {
            Activity activity = getActivity();
            this.f4918c.b(activity == null || activity.isFinishing());
        }
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.f4918c.c(getActivity().isFinishing());
        this.f4918c = null;
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onPause() {
        this.f4918c.c();
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.f4918c.b();
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBundle("YouTubePlayerFragment.KEY_PLAYER_VIEW_STATE", this.f4918c != null ? this.f4918c.e() : this.f4917b);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f4918c.a();
    }

    @Override // android.app.Fragment
    public void onStop() {
        this.f4918c.d();
        super.onStop();
    }
}

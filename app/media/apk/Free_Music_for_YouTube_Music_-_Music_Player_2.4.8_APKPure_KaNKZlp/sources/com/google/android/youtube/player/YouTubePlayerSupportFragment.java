package com.google.android.youtube.player;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.internal.ab;
/* loaded from: classes2.dex */
public class YouTubePlayerSupportFragment extends Fragment implements YouTubePlayer.Provider {

    /* renamed from: a  reason: collision with root package name */
    private final a f4920a = new a(this, (byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private Bundle f4921b;

    /* renamed from: c  reason: collision with root package name */
    private YouTubePlayerView f4922c;
    private String d;
    private YouTubePlayer.OnInitializedListener e;
    private boolean f;

    /* loaded from: classes2.dex */
    private final class a implements YouTubePlayerView.b {
        private a() {
        }

        /* synthetic */ a(YouTubePlayerSupportFragment youTubePlayerSupportFragment, byte b2) {
            this();
        }

        @Override // com.google.android.youtube.player.YouTubePlayerView.b
        public final void a(YouTubePlayerView youTubePlayerView) {
        }

        @Override // com.google.android.youtube.player.YouTubePlayerView.b
        public final void a(YouTubePlayerView youTubePlayerView, String str, YouTubePlayer.OnInitializedListener onInitializedListener) {
            YouTubePlayerSupportFragment.this.initialize(str, YouTubePlayerSupportFragment.this.e);
        }
    }

    private void a() {
        if (this.f4922c == null || this.e == null) {
            return;
        }
        this.f4922c.a(this.f);
        this.f4922c.a(getActivity(), this, this.d, this.e, this.f4921b);
        this.f4921b = null;
        this.e = null;
    }

    public static YouTubePlayerSupportFragment newInstance() {
        return new YouTubePlayerSupportFragment();
    }

    @Override // com.google.android.youtube.player.YouTubePlayer.Provider
    public void initialize(String str, YouTubePlayer.OnInitializedListener onInitializedListener) {
        this.d = ab.a(str, (Object) "Developer key cannot be null or empty");
        this.e = onInitializedListener;
        a();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4921b = bundle != null ? bundle.getBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE") : null;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f4922c = new YouTubePlayerView(getActivity(), null, 0, this.f4920a);
        a();
        return this.f4922c;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.f4922c != null) {
            FragmentActivity activity = getActivity();
            this.f4922c.b(activity == null || activity.isFinishing());
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        this.f4922c.c(getActivity().isFinishing());
        this.f4922c = null;
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        this.f4922c.c();
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f4922c.b();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE", this.f4922c != null ? this.f4922c.e() : this.f4921b);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.f4922c.a();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        this.f4922c.d();
        super.onStop();
    }
}

package com.fotoable.youtube.music.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.andexert.expandablelayout.library.ExpandableLayout;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.LaToTextView;
/* loaded from: classes.dex */
public class MyMusicFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private MyMusicFragment f4665a;

    /* renamed from: b  reason: collision with root package name */
    private View f4666b;

    /* renamed from: c  reason: collision with root package name */
    private View f4667c;
    private View d;
    private View e;

    @UiThread
    public MyMusicFragment_ViewBinding(final MyMusicFragment myMusicFragment, View view) {
        this.f4665a = myMusicFragment;
        myMusicFragment.recentlySize = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.recently_size, "field 'recentlySize'", LaToTextView.class);
        myMusicFragment.createdSize = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.created_playlist_size, "field 'createdSize'", LaToTextView.class);
        myMusicFragment.collectedSize = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.collected_playlist_size, "field 'collectedSize'", LaToTextView.class);
        myMusicFragment.expandCreated = (ExpandableLayout) Utils.findRequiredViewAsType(view, R.id.expand_created, "field 'expandCreated'", ExpandableLayout.class);
        myMusicFragment.expandCollected = (ExpandableLayout) Utils.findRequiredViewAsType(view, R.id.expand_collected, "field 'expandCollected'", ExpandableLayout.class);
        myMusicFragment.radioSizeTextView = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.radio_size, "field 'radioSizeTextView'", LaToTextView.class);
        myMusicFragment.refreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", SwipeRefreshLayout.class);
        View findViewById = view.findViewById(R.id.ll_recently);
        if (findViewById != null) {
            this.f4666b = findViewById;
            findViewById.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.MyMusicFragment_ViewBinding.1
                @Override // butterknife.internal.DebouncingOnClickListener
                public void doClick(View view2) {
                    myMusicFragment.onClick(view2);
                }
            });
        }
        View findViewById2 = view.findViewById(R.id.rl_create);
        if (findViewById2 != null) {
            this.f4667c = findViewById2;
            findViewById2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.MyMusicFragment_ViewBinding.2
                @Override // butterknife.internal.DebouncingOnClickListener
                public void doClick(View view2) {
                    myMusicFragment.onClick(view2);
                }
            });
        }
        View findViewById3 = view.findViewById(R.id.rl_collected);
        if (findViewById3 != null) {
            this.d = findViewById3;
            findViewById3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.MyMusicFragment_ViewBinding.3
                @Override // butterknife.internal.DebouncingOnClickListener
                public void doClick(View view2) {
                    myMusicFragment.onClick(view2);
                }
            });
        }
        View findViewById4 = view.findViewById(R.id.ll_radio);
        if (findViewById4 != null) {
            this.e = findViewById4;
            findViewById4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.MyMusicFragment_ViewBinding.4
                @Override // butterknife.internal.DebouncingOnClickListener
                public void doClick(View view2) {
                    myMusicFragment.onClick(view2);
                }
            });
        }
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MyMusicFragment myMusicFragment = this.f4665a;
        if (myMusicFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4665a = null;
        myMusicFragment.recentlySize = null;
        myMusicFragment.createdSize = null;
        myMusicFragment.collectedSize = null;
        myMusicFragment.expandCreated = null;
        myMusicFragment.expandCollected = null;
        myMusicFragment.radioSizeTextView = null;
        myMusicFragment.refreshLayout = null;
        if (this.f4666b != null) {
            this.f4666b.setOnClickListener(null);
            this.f4666b = null;
        }
        if (this.f4667c != null) {
            this.f4667c.setOnClickListener(null);
            this.f4667c = null;
        }
        if (this.d != null) {
            this.d.setOnClickListener(null);
            this.d = null;
        }
        if (this.e != null) {
            this.e.setOnClickListener(null);
            this.e = null;
        }
    }
}

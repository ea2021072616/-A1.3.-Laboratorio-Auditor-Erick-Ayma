package com.fotoable.youtube.music.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aspsine.irecyclerview.IRecyclerView;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class CommunityFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private CommunityFragment f4523a;

    /* renamed from: b  reason: collision with root package name */
    private View f4524b;

    /* renamed from: c  reason: collision with root package name */
    private View f4525c;

    @UiThread
    public CommunityFragment_ViewBinding(final CommunityFragment communityFragment, View view) {
        this.f4523a = communityFragment;
        communityFragment.mRvPostList = (IRecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_post_list, "field 'mRvPostList'", IRecyclerView.class);
        communityFragment.refreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", SwipeRefreshLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.iv_post_add, "field 'iv_post_add' and method 'onViewClicked'");
        communityFragment.iv_post_add = (ImageView) Utils.castView(findRequiredView, R.id.iv_post_add, "field 'iv_post_add'", ImageView.class);
        this.f4524b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.CommunityFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                communityFragment.onViewClicked(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.rl_error_page, "field 'rl_error_page' and method 'onViewClicked'");
        communityFragment.rl_error_page = (RelativeLayout) Utils.castView(findRequiredView2, R.id.rl_error_page, "field 'rl_error_page'", RelativeLayout.class);
        this.f4525c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.CommunityFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                communityFragment.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CommunityFragment communityFragment = this.f4523a;
        if (communityFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4523a = null;
        communityFragment.mRvPostList = null;
        communityFragment.refreshLayout = null;
        communityFragment.iv_post_add = null;
        communityFragment.rl_error_page = null;
        this.f4524b.setOnClickListener(null);
        this.f4524b = null;
        this.f4525c.setOnClickListener(null);
        this.f4525c = null;
    }
}

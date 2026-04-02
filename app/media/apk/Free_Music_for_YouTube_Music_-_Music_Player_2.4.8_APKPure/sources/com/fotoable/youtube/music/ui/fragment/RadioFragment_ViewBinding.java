package com.fotoable.youtube.music.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.LaToTextView;
/* loaded from: classes.dex */
public class RadioFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private RadioFragment f4702a;

    /* renamed from: b  reason: collision with root package name */
    private View f4703b;

    /* renamed from: c  reason: collision with root package name */
    private View f4704c;
    private View d;

    @UiThread
    public RadioFragment_ViewBinding(final RadioFragment radioFragment, View view) {
        this.f4702a = radioFragment;
        View findRequiredView = Utils.findRequiredView(view, R.id.hot_radio_view_all_tx, "field 'hotRadioViewAllTx' and method 'onViewClicked'");
        radioFragment.hotRadioViewAllTx = (LaToTextView) Utils.castView(findRequiredView, R.id.hot_radio_view_all_tx, "field 'hotRadioViewAllTx'", LaToTextView.class);
        this.f4703b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.RadioFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                radioFragment.onViewClicked(view2);
            }
        });
        radioFragment.hotRadioRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.hot_radio_recyclerView, "field 'hotRadioRecyclerView'", RecyclerView.class);
        radioFragment.hotCountryRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.hot_country_recyclerView, "field 'hotCountryRecyclerView'", RecyclerView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.all_radio_view, "field 'allRadioView' and method 'onViewClicked'");
        radioFragment.allRadioView = (RelativeLayout) Utils.castView(findRequiredView2, R.id.all_radio_view, "field 'allRadioView'", RelativeLayout.class);
        this.f4704c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.RadioFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                radioFragment.onViewClicked(view2);
            }
        });
        radioFragment.refreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", SwipeRefreshLayout.class);
        radioFragment.rootView = Utils.findRequiredView(view, R.id.root_view, "field 'rootView'");
        View findRequiredView3 = Utils.findRequiredView(view, R.id.hot_radio_view_all, "method 'onViewClicked'");
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.RadioFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                radioFragment.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RadioFragment radioFragment = this.f4702a;
        if (radioFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4702a = null;
        radioFragment.hotRadioViewAllTx = null;
        radioFragment.hotRadioRecyclerView = null;
        radioFragment.hotCountryRecyclerView = null;
        radioFragment.allRadioView = null;
        radioFragment.refreshLayout = null;
        radioFragment.rootView = null;
        this.f4703b.setOnClickListener(null);
        this.f4703b = null;
        this.f4704c.setOnClickListener(null);
        this.f4704c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}

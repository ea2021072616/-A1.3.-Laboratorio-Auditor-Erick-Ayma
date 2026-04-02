package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aspsine.irecyclerview.IRecyclerView;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.ISwipeRefreshLayout;
import com.fotoable.youtube.music.ui.view.LaToTextView;
/* loaded from: classes.dex */
public class RadioListActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private RadioListActivity f3753a;

    /* renamed from: b  reason: collision with root package name */
    private View f3754b;

    /* renamed from: c  reason: collision with root package name */
    private View f3755c;

    @UiThread
    public RadioListActivity_ViewBinding(final RadioListActivity radioListActivity, View view) {
        this.f3753a = radioListActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.img_back, "field 'imgBack' and method 'onViewClicked'");
        radioListActivity.imgBack = (ImageView) Utils.castView(findRequiredView, R.id.img_back, "field 'imgBack'", ImageView.class);
        this.f3754b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.RadioListActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                radioListActivity.onViewClicked(view2);
            }
        });
        radioListActivity.titleTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.title_tx, "field 'titleTx'", LaToTextView.class);
        radioListActivity.recycleView = (IRecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recycleView'", IRecyclerView.class);
        radioListActivity.refreshLayout = (ISwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", ISwipeRefreshLayout.class);
        radioListActivity.countryImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.country_img, "field 'countryImg'", ImageView.class);
        radioListActivity.countryNameTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.country_name_tx, "field 'countryNameTx'", LaToTextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.country_select_view, "field 'countrySelectView' and method 'onViewClicked'");
        radioListActivity.countrySelectView = (LinearLayout) Utils.castView(findRequiredView2, R.id.country_select_view, "field 'countrySelectView'", LinearLayout.class);
        this.f3755c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.RadioListActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                radioListActivity.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RadioListActivity radioListActivity = this.f3753a;
        if (radioListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3753a = null;
        radioListActivity.imgBack = null;
        radioListActivity.titleTx = null;
        radioListActivity.recycleView = null;
        radioListActivity.refreshLayout = null;
        radioListActivity.countryImg = null;
        radioListActivity.countryNameTx = null;
        radioListActivity.countrySelectView = null;
        this.f3754b.setOnClickListener(null);
        this.f3754b = null;
        this.f3755c.setOnClickListener(null);
        this.f3755c = null;
    }
}

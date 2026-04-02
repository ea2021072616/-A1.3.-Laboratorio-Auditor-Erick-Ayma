package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aspsine.irecyclerview.IRecyclerView;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.ISwipeRefreshLayout;
import com.fotoable.youtube.music.ui.view.LaToTextView;
/* loaded from: classes.dex */
public class EditorChoicePlayListActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private EditorChoicePlayListActivity f3297a;

    /* renamed from: b  reason: collision with root package name */
    private View f3298b;

    /* renamed from: c  reason: collision with root package name */
    private View f3299c;

    @UiThread
    public EditorChoicePlayListActivity_ViewBinding(final EditorChoicePlayListActivity editorChoicePlayListActivity, View view) {
        this.f3297a = editorChoicePlayListActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.img_back, "field 'imgBack'");
        editorChoicePlayListActivity.imgBack = (ImageView) Utils.castView(findRequiredView, R.id.img_back, "field 'imgBack'", ImageView.class);
        this.f3298b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.EditorChoicePlayListActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                editorChoicePlayListActivity.OnClick(view2);
            }
        });
        editorChoicePlayListActivity.toolbar = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'toolbar'", RelativeLayout.class);
        editorChoicePlayListActivity.recycleView = (IRecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recycleView'", IRecyclerView.class);
        editorChoicePlayListActivity.refreshLayout = (ISwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", ISwipeRefreshLayout.class);
        editorChoicePlayListActivity.tvError = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_error, "field 'tvError'", LaToTextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.ll_error, "field 'llError'");
        editorChoicePlayListActivity.llError = (LinearLayout) Utils.castView(findRequiredView2, R.id.ll_error, "field 'llError'", LinearLayout.class);
        this.f3299c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.EditorChoicePlayListActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                editorChoicePlayListActivity.OnClick(view2);
            }
        });
        editorChoicePlayListActivity.tvTitle = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", LaToTextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        EditorChoicePlayListActivity editorChoicePlayListActivity = this.f3297a;
        if (editorChoicePlayListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3297a = null;
        editorChoicePlayListActivity.imgBack = null;
        editorChoicePlayListActivity.toolbar = null;
        editorChoicePlayListActivity.recycleView = null;
        editorChoicePlayListActivity.refreshLayout = null;
        editorChoicePlayListActivity.tvError = null;
        editorChoicePlayListActivity.llError = null;
        editorChoicePlayListActivity.tvTitle = null;
        this.f3298b.setOnClickListener(null);
        this.f3298b = null;
        this.f3299c.setOnClickListener(null);
        this.f3299c = null;
    }
}

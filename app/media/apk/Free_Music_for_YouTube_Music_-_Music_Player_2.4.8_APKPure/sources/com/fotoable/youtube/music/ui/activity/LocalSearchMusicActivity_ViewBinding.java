package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.LaToTextView;
/* loaded from: classes.dex */
public class LocalSearchMusicActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private LocalSearchMusicActivity f3461a;

    /* renamed from: b  reason: collision with root package name */
    private View f3462b;

    /* renamed from: c  reason: collision with root package name */
    private View f3463c;

    @UiThread
    public LocalSearchMusicActivity_ViewBinding(final LocalSearchMusicActivity localSearchMusicActivity, View view) {
        this.f3461a = localSearchMusicActivity;
        localSearchMusicActivity.searchEdit = (EditText) Utils.findRequiredViewAsType(view, R.id.search_edit, "field 'searchEdit'", EditText.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.search_delete_img, "field 'searchDeleteImg'");
        localSearchMusicActivity.searchDeleteImg = (ImageView) Utils.castView(findRequiredView, R.id.search_delete_img, "field 'searchDeleteImg'", ImageView.class);
        this.f3462b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.LocalSearchMusicActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localSearchMusicActivity.Click(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.search_cancel_tx, "field 'searchCancelTx'");
        localSearchMusicActivity.searchCancelTx = (LaToTextView) Utils.castView(findRequiredView2, R.id.search_cancel_tx, "field 'searchCancelTx'", LaToTextView.class);
        this.f3463c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.LocalSearchMusicActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                localSearchMusicActivity.Click(view2);
            }
        });
        localSearchMusicActivity.recycle_view = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycleview, "field 'recycle_view'", RecyclerView.class);
        localSearchMusicActivity.shadowView = Utils.findRequiredView(view, R.id.search_history_title_shadow_view, "field 'shadowView'");
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LocalSearchMusicActivity localSearchMusicActivity = this.f3461a;
        if (localSearchMusicActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3461a = null;
        localSearchMusicActivity.searchEdit = null;
        localSearchMusicActivity.searchDeleteImg = null;
        localSearchMusicActivity.searchCancelTx = null;
        localSearchMusicActivity.recycle_view = null;
        localSearchMusicActivity.shadowView = null;
        this.f3462b.setOnClickListener(null);
        this.f3462b = null;
        this.f3463c.setOnClickListener(null);
        this.f3463c = null;
    }
}

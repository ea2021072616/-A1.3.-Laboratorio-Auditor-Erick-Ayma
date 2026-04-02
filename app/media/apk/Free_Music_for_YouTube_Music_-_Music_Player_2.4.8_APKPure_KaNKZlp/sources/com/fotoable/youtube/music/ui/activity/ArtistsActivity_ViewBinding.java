package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class ArtistsActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private ArtistsActivity f3180a;

    /* renamed from: b  reason: collision with root package name */
    private View f3181b;

    @UiThread
    public ArtistsActivity_ViewBinding(final ArtistsActivity artistsActivity, View view) {
        this.f3180a = artistsActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.back_view, "method 'onViewClicked'");
        this.f3181b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.ArtistsActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                artistsActivity.onViewClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        if (this.f3180a == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3180a = null;
        this.f3181b.setOnClickListener(null);
        this.f3181b = null;
    }
}

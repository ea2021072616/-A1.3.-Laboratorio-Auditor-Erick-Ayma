package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class GenresActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private GenresActivity f3331a;

    /* renamed from: b  reason: collision with root package name */
    private View f3332b;

    @UiThread
    public GenresActivity_ViewBinding(final GenresActivity genresActivity, View view) {
        this.f3331a = genresActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.back_view, "method 'onViewClicked'");
        this.f3332b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.GenresActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                genresActivity.onViewClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        if (this.f3331a == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3331a = null;
        this.f3332b.setOnClickListener(null);
        this.f3332b = null;
    }
}

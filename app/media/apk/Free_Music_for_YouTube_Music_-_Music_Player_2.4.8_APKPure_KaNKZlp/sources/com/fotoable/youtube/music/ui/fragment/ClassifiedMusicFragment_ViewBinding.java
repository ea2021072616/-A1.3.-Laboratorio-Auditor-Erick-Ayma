package com.fotoable.youtube.music.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aspsine.irecyclerview.IRecyclerView;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.ISwipeRefreshLayout;
/* loaded from: classes.dex */
public class ClassifiedMusicFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private ClassifiedMusicFragment f4502a;

    /* renamed from: b  reason: collision with root package name */
    private View f4503b;

    @UiThread
    public ClassifiedMusicFragment_ViewBinding(final ClassifiedMusicFragment classifiedMusicFragment, View view) {
        this.f4502a = classifiedMusicFragment;
        classifiedMusicFragment.recyclerView = (IRecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recyclerView'", IRecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.ll_error, "field 'tvError' and method 'onClick'");
        classifiedMusicFragment.tvError = (LinearLayout) Utils.castView(findRequiredView, R.id.ll_error, "field 'tvError'", LinearLayout.class);
        this.f4503b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.ClassifiedMusicFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classifiedMusicFragment.onClick();
            }
        });
        classifiedMusicFragment.refreshLayout = (ISwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", ISwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ClassifiedMusicFragment classifiedMusicFragment = this.f4502a;
        if (classifiedMusicFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4502a = null;
        classifiedMusicFragment.recyclerView = null;
        classifiedMusicFragment.tvError = null;
        classifiedMusicFragment.refreshLayout = null;
        this.f4503b.setOnClickListener(null);
        this.f4503b = null;
    }
}

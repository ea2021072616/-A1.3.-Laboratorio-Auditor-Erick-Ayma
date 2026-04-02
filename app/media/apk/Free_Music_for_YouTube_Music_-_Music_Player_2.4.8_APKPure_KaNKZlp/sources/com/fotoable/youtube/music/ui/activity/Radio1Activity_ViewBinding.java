package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class Radio1Activity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private Radio1Activity f3733a;

    /* renamed from: b  reason: collision with root package name */
    private View f3734b;

    /* renamed from: c  reason: collision with root package name */
    private View f3735c;

    @UiThread
    public Radio1Activity_ViewBinding(final Radio1Activity radio1Activity, View view) {
        this.f3733a = radio1Activity;
        View findRequiredView = Utils.findRequiredView(view, R.id.back_view, "field 'backView' and method 'onViewClicked'");
        radio1Activity.backView = (ImageView) Utils.castView(findRequiredView, R.id.back_view, "field 'backView'", ImageView.class);
        this.f3734b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.Radio1Activity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                radio1Activity.onViewClicked(view2);
            }
        });
        radio1Activity.webView = (WebView) Utils.findRequiredViewAsType(view, R.id.webView, "field 'webView'", WebView.class);
        radio1Activity.loadView = Utils.findRequiredView(view, R.id.loading_view, "field 'loadView'");
        View findRequiredView2 = Utils.findRequiredView(view, R.id.refresh_img, "method 'onViewClicked'");
        this.f3735c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.Radio1Activity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                radio1Activity.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        Radio1Activity radio1Activity = this.f3733a;
        if (radio1Activity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3733a = null;
        radio1Activity.backView = null;
        radio1Activity.webView = null;
        radio1Activity.loadView = null;
        this.f3734b.setOnClickListener(null);
        this.f3734b = null;
        this.f3735c.setOnClickListener(null);
        this.f3735c = null;
    }
}

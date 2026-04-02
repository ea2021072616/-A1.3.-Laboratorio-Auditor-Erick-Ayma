package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class CommentReportDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private CommentReportDialog f4069a;

    /* renamed from: b  reason: collision with root package name */
    private View f4070b;

    /* renamed from: c  reason: collision with root package name */
    private View f4071c;
    private View d;
    private View e;
    private View f;

    @UiThread
    public CommentReportDialog_ViewBinding(final CommentReportDialog commentReportDialog, View view) {
        this.f4069a = commentReportDialog;
        View findRequiredView = Utils.findRequiredView(view, R.id.report_reason_1, "method 'onViewClicked'");
        this.f4070b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.CommentReportDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                commentReportDialog.onViewClicked(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.report_reason_2, "method 'onViewClicked'");
        this.f4071c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.CommentReportDialog_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                commentReportDialog.onViewClicked(view2);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.report_reason_3, "method 'onViewClicked'");
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.CommentReportDialog_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                commentReportDialog.onViewClicked(view2);
            }
        });
        View findRequiredView4 = Utils.findRequiredView(view, R.id.report_reason_4, "method 'onViewClicked'");
        this.e = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.CommentReportDialog_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                commentReportDialog.onViewClicked(view2);
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.report_reason_5, "method 'onViewClicked'");
        this.f = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.CommentReportDialog_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                commentReportDialog.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        if (this.f4069a == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4069a = null;
        this.f4070b.setOnClickListener(null);
        this.f4070b = null;
        this.f4071c.setOnClickListener(null);
        this.f4071c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
        this.f.setOnClickListener(null);
        this.f = null;
    }
}

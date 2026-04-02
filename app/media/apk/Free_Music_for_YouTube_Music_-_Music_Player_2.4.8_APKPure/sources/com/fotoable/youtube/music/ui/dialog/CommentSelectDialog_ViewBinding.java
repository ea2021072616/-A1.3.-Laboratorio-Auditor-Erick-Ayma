package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class CommentSelectDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private CommentSelectDialog f4085a;

    /* renamed from: b  reason: collision with root package name */
    private View f4086b;

    /* renamed from: c  reason: collision with root package name */
    private View f4087c;
    private View d;
    private View e;

    @UiThread
    public CommentSelectDialog_ViewBinding(final CommentSelectDialog commentSelectDialog, View view) {
        this.f4085a = commentSelectDialog;
        View findRequiredView = Utils.findRequiredView(view, R.id.delete_comment, "field 'delete_comment' and method 'onViewClicked'");
        commentSelectDialog.delete_comment = (TextView) Utils.castView(findRequiredView, R.id.delete_comment, "field 'delete_comment'", TextView.class);
        this.f4086b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.CommentSelectDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                commentSelectDialog.onViewClicked(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.report_comment, "field 'report_comment' and method 'onViewClicked'");
        commentSelectDialog.report_comment = (TextView) Utils.castView(findRequiredView2, R.id.report_comment, "field 'report_comment'", TextView.class);
        this.f4087c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.CommentSelectDialog_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                commentSelectDialog.onViewClicked(view2);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.copy_comment, "field 'copy_comment' and method 'onViewClicked'");
        commentSelectDialog.copy_comment = (TextView) Utils.castView(findRequiredView3, R.id.copy_comment, "field 'copy_comment'", TextView.class);
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.CommentSelectDialog_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                commentSelectDialog.onViewClicked(view2);
            }
        });
        View findRequiredView4 = Utils.findRequiredView(view, R.id.reply_comment, "field 'reply_comment' and method 'onViewClicked'");
        commentSelectDialog.reply_comment = (TextView) Utils.castView(findRequiredView4, R.id.reply_comment, "field 'reply_comment'", TextView.class);
        this.e = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.CommentSelectDialog_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                commentSelectDialog.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CommentSelectDialog commentSelectDialog = this.f4085a;
        if (commentSelectDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4085a = null;
        commentSelectDialog.delete_comment = null;
        commentSelectDialog.report_comment = null;
        commentSelectDialog.copy_comment = null;
        commentSelectDialog.reply_comment = null;
        this.f4086b.setOnClickListener(null);
        this.f4086b = null;
        this.f4087c.setOnClickListener(null);
        this.f4087c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
    }
}

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
public class DeleteDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private DeleteDialog f4100a;

    /* renamed from: b  reason: collision with root package name */
    private View f4101b;

    /* renamed from: c  reason: collision with root package name */
    private View f4102c;

    @UiThread
    public DeleteDialog_ViewBinding(final DeleteDialog deleteDialog, View view) {
        this.f4100a = deleteDialog;
        deleteDialog.txtTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_title, "field 'txtTitle'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.txt_cancel, "method 'onClick'");
        this.f4101b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.DeleteDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                deleteDialog.onClick(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.txt_ok, "method 'onClick'");
        this.f4102c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.DeleteDialog_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                deleteDialog.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DeleteDialog deleteDialog = this.f4100a;
        if (deleteDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4100a = null;
        deleteDialog.txtTitle = null;
        this.f4101b.setOnClickListener(null);
        this.f4101b = null;
        this.f4102c.setOnClickListener(null);
        this.f4102c = null;
    }
}

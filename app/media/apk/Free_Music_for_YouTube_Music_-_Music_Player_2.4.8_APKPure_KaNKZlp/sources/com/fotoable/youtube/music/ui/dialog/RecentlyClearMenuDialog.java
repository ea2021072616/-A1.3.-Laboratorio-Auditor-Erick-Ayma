package com.fotoable.youtube.music.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.fotoable.free.music.R;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public class RecentlyClearMenuDialog extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    private static final String f4353b = RecentlyClearMenuDialog.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    Unbinder f4354a;

    /* renamed from: c  reason: collision with root package name */
    private FragmentManager f4355c;
    private a d;
    private DialogInterface.OnKeyListener e = new DialogInterface.OnKeyListener() { // from class: com.fotoable.youtube.music.ui.dialog.RecentlyClearMenuDialog.1
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 1) {
                RecentlyClearMenuDialog.this.dismissAllowingStateLoss();
                RecentlyClearMenuDialog.this.onCancel(dialogInterface);
                return true;
            }
            return false;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dialog_recently_clear_menu, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f4354a = ButterKnife.bind(this, view);
        b();
        c();
        a();
    }

    private void a() {
    }

    private void b() {
        getDialog().requestWindowFeature(1);
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        getDialog().getWindow().setGravity(53);
        Window window = getDialog().getWindow();
        window.getDecorView().setPadding(0, 16, 22, 0);
        attributes.width = -2;
        attributes.height = -2;
        window.setAttributes(attributes);
        getDialog().setCancelable(true);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    private void c() {
        getDialog().setOnKeyListener(this.e);
    }

    @OnClick({R.id.ll_clear})
    public void onClick(View view) {
        dismiss();
        switch (view.getId()) {
            case R.id.ll_clear /* 2131821088 */:
                try {
                    dismissAllowingStateLoss();
                    if (this.d != null) {
                        this.d.a();
                        return;
                    }
                    return;
                } catch (Exception e) {
                    ThrowableExtension.printStackTrace(e);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.support.v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog == null) {
            super.setShowsDialog(false);
        }
        return onCreateDialog;
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            if (this.f4355c != null) {
                this.f4355c.beginTransaction().remove(this).commitAllowingStateLoss();
            }
            super.dismiss();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f4354a.unbind();
    }
}

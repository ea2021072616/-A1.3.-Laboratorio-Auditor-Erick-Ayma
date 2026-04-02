package com.fotoable.youtube.music.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.facebook.ads.AdError;
import com.fotoable.free.music.R;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public class LocalMenuDialog extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    private static final String f4134b = LocalMenuDialog.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    Unbinder f4135a;

    /* renamed from: c  reason: collision with root package name */
    private FragmentManager f4136c;
    private DialogInterface.OnKeyListener d = new DialogInterface.OnKeyListener() { // from class: com.fotoable.youtube.music.ui.dialog.LocalMenuDialog.1
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 1) {
                LocalMenuDialog.this.dismissAllowingStateLoss();
                LocalMenuDialog.this.onCancel(dialogInterface);
                return true;
            }
            return false;
        }
    };

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f4135a = ButterKnife.bind(this, view);
        b();
        c();
        a();
        com.fotoable.youtube.music.util.h.a(f4134b, com.fotoable.youtube.music.util.w.a());
    }

    private void a() {
    }

    private void b() {
        getDialog().requestWindowFeature(1);
        getDialog().getWindow().setGravity(53);
        getDialog().setCancelable(true);
    }

    private void c() {
        getDialog().setOnKeyListener(this.d);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dialog_menu_local, viewGroup, false);
    }

    @OnClick({R.id.ll_scan, R.id.ll_sort})
    public void onClick(View view) {
        dismiss();
        switch (view.getId()) {
            case R.id.ll_scan /* 2131821029 */:
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(AdError.MEDIATION_ERROR_CODE));
                return;
            case R.id.ll_sort /* 2131821030 */:
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(3002));
                return;
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
            if (this.f4136c != null) {
                this.f4136c.beginTransaction().remove(this).commitAllowingStateLoss();
            }
            super.dismiss();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f4135a.unbind();
    }
}

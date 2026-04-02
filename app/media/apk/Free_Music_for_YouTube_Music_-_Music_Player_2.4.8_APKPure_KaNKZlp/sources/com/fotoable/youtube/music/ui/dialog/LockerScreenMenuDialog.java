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
public class LockerScreenMenuDialog extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4190a = LockerScreenMenuDialog.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private Unbinder f4191b;

    /* renamed from: c  reason: collision with root package name */
    private FragmentManager f4192c;
    private a d;
    private DialogInterface.OnKeyListener e = new DialogInterface.OnKeyListener() { // from class: com.fotoable.youtube.music.ui.dialog.LockerScreenMenuDialog.1
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 1) {
                LockerScreenMenuDialog.this.dismissAllowingStateLoss();
                LockerScreenMenuDialog.this.onCancel(dialogInterface);
                return true;
            }
            return false;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LockerScreenMenuDialog b(b bVar) {
        LockerScreenMenuDialog lockerScreenMenuDialog = new LockerScreenMenuDialog();
        lockerScreenMenuDialog.f4192c = bVar.f4194a;
        lockerScreenMenuDialog.d = bVar.f4195b;
        return lockerScreenMenuDialog;
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dialog_menu_locker_screen, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f4191b = ButterKnife.bind(this, view);
        b();
        c();
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

    @OnClick({R.id.turn_off_panel})
    public void onClick(View view) {
        dismiss();
        switch (view.getId()) {
            case R.id.turn_off_panel /* 2131821059 */:
                if (this.d != null) {
                    this.d.a();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void a() {
        try {
            this.f4192c.beginTransaction().add(this, "LockerScreenMenuDialog").commitAllowingStateLoss();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            if (this.f4192c != null) {
                this.f4192c.beginTransaction().remove(this).commitAllowingStateLoss();
            }
            super.dismiss();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        try {
            if (this.f4191b != null) {
                this.f4191b.unbind();
                this.f4191b = null;
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private FragmentManager f4194a;

        /* renamed from: b  reason: collision with root package name */
        private a f4195b;

        public b(FragmentManager fragmentManager) {
            this.f4194a = fragmentManager;
        }

        public b a(a aVar) {
            this.f4195b = aVar;
            return this;
        }

        public LockerScreenMenuDialog a() {
            return LockerScreenMenuDialog.b(this);
        }
    }
}

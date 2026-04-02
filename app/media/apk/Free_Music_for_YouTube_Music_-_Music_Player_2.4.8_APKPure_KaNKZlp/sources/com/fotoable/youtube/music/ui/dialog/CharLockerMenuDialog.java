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
public class CharLockerMenuDialog extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4038a = CharLockerMenuDialog.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private Unbinder f4039b;

    /* renamed from: c  reason: collision with root package name */
    private FragmentManager f4040c;
    private a d;
    private DialogInterface.OnKeyListener e = new DialogInterface.OnKeyListener() { // from class: com.fotoable.youtube.music.ui.dialog.CharLockerMenuDialog.1
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 1) {
                CharLockerMenuDialog.this.dismissAllowingStateLoss();
                CharLockerMenuDialog.this.onCancel(dialogInterface);
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
    public static CharLockerMenuDialog b(b bVar) {
        CharLockerMenuDialog charLockerMenuDialog = new CharLockerMenuDialog();
        charLockerMenuDialog.f4040c = bVar.f4042a;
        charLockerMenuDialog.d = bVar.f4043b;
        return charLockerMenuDialog;
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dialog_menu_locker_char, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f4039b = ButterKnife.bind(this, view);
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
            this.f4040c.beginTransaction().add(this, "CharLockerMenuDialog").commitAllowingStateLoss();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            if (this.f4040c != null) {
                this.f4040c.beginTransaction().remove(this).commitAllowingStateLoss();
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
            if (this.f4039b != null) {
                this.f4039b.unbind();
                this.f4039b = null;
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private FragmentManager f4042a;

        /* renamed from: b  reason: collision with root package name */
        private a f4043b;

        public b(FragmentManager fragmentManager) {
            this.f4042a = fragmentManager;
        }

        public b a(a aVar) {
            this.f4043b = aVar;
            return this;
        }

        public CharLockerMenuDialog a() {
            return CharLockerMenuDialog.b(this);
        }
    }
}

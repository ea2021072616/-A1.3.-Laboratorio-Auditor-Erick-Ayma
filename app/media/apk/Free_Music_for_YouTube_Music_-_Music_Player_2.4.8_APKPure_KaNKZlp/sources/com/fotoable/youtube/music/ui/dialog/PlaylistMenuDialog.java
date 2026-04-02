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
public class PlaylistMenuDialog extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    private static final String f4307b = PlaylistMenuDialog.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    Unbinder f4308a;

    /* renamed from: c  reason: collision with root package name */
    private FragmentManager f4309c;
    private a d;
    private DialogInterface.OnKeyListener e = new DialogInterface.OnKeyListener() { // from class: com.fotoable.youtube.music.ui.dialog.PlaylistMenuDialog.1
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 1) {
                PlaylistMenuDialog.this.dismissAllowingStateLoss();
                PlaylistMenuDialog.this.onCancel(dialogInterface);
                return true;
            }
            return false;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PlaylistMenuDialog b(b bVar) {
        PlaylistMenuDialog playlistMenuDialog = new PlaylistMenuDialog();
        playlistMenuDialog.f4309c = bVar.f4311a;
        playlistMenuDialog.d = bVar.f4312b;
        return playlistMenuDialog;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f4308a = ButterKnife.bind(this, view);
        c();
        d();
        b();
    }

    private void b() {
    }

    private void c() {
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

    private void d() {
        getDialog().setOnKeyListener(this.e);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dialog_menu_playlist, viewGroup, false);
    }

    @OnClick({R.id.ll_delete, R.id.ll_rename})
    public void onClick(View view) {
        dismiss();
        switch (view.getId()) {
            case R.id.ll_delete /* 2131821060 */:
                if (this.d != null) {
                    this.d.a();
                    return;
                }
                return;
            case R.id.ll_rename /* 2131821061 */:
                if (this.d != null) {
                    this.d.b();
                    return;
                }
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

    public void a() {
        try {
            this.f4309c.beginTransaction().add(this, "PlaylistMenuDialog").commitAllowingStateLoss();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            if (this.f4309c != null) {
                this.f4309c.beginTransaction().remove(this).commitAllowingStateLoss();
            }
            super.dismiss();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f4308a.unbind();
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private FragmentManager f4311a;

        /* renamed from: b  reason: collision with root package name */
        private a f4312b;

        public b(FragmentManager fragmentManager) {
            this.f4311a = fragmentManager;
        }

        public b a(a aVar) {
            this.f4312b = aVar;
            return this;
        }

        public PlaylistMenuDialog a() {
            return PlaylistMenuDialog.b(this);
        }
    }
}

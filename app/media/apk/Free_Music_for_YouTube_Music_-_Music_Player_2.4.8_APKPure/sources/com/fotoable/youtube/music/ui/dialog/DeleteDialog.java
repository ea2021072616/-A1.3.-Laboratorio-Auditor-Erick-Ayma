package com.fotoable.youtube.music.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.LocalSongBean;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public class DeleteDialog extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    private static final String f4096b = DeleteDialog.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    Unbinder f4097a;

    /* renamed from: c  reason: collision with root package name */
    private FragmentManager f4098c;
    private b d;
    private String e;
    private a f;
    private LocalSongBean g;
    private DialogInterface.OnKeyListener h = new DialogInterface.OnKeyListener() { // from class: com.fotoable.youtube.music.ui.dialog.DeleteDialog.1
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 1) {
                DeleteDialog.this.dismissAllowingStateLoss();
                DeleteDialog.this.onCancel(dialogInterface);
                return true;
            }
            return false;
        }
    };
    @BindView(R.id.txt_title)
    TextView txtTitle;

    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(Long l);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f4097a = ButterKnife.bind(this, view);
        b();
        c();
        a();
        com.fotoable.youtube.music.util.h.a(f4096b, com.fotoable.youtube.music.util.w.a());
    }

    private void a() {
        if (!TextUtils.isEmpty(this.e)) {
            this.txtTitle.setText(this.e);
        }
    }

    private void b() {
        getDialog().requestWindowFeature(1);
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        getDialog().getWindow().setGravity(17);
        Window window = getDialog().getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        attributes.width = -2;
        attributes.height = -2;
        window.setAttributes(attributes);
        getDialog().setCancelable(true);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    private void c() {
        getDialog().setOnKeyListener(this.h);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dialog_delete, viewGroup, false);
    }

    @OnClick({R.id.txt_cancel, R.id.txt_ok})
    public void onClick(View view) {
        dismiss();
        if (this.g != null) {
            switch (view.getId()) {
                case R.id.txt_cancel /* 2131821020 */:
                    if (this.f != null) {
                        this.f.a();
                        return;
                    }
                    return;
                case R.id.txt_ok /* 2131821021 */:
                    if (this.d != null) {
                        this.d.a(this.g.songId);
                        return;
                    }
                    return;
                default:
                    return;
            }
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
            if (this.f4098c != null) {
                this.f4098c.beginTransaction().remove(this).commitAllowingStateLoss();
            }
            super.dismiss();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f4097a.unbind();
    }
}

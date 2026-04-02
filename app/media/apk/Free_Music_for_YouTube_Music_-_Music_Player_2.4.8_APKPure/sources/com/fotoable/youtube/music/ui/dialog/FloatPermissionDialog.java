package com.fotoable.youtube.music.ui.dialog;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.fotoable.free.music.R;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public class FloatPermissionDialog extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public a f4107a;

    /* renamed from: b  reason: collision with root package name */
    private Unbinder f4108b;

    /* renamed from: c  reason: collision with root package name */
    private FragmentManager f4109c;
    @BindView(R.id.cancel)
    TextView cancelTv;
    @BindView(R.id.enable)
    TextView enableTv;
    @BindView(R.id.float_permission_tip_img)
    ImageView float_permission_tip_img;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().requestWindowFeature(1);
        return layoutInflater.inflate(R.layout.dialog_float_permission, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f4108b = ButterKnife.bind(this, view);
        com.bumptech.glide.i.c(getContext()).a(Integer.valueOf((int) R.drawable.float_permission_tip_img_permit)).m().b(com.bumptech.glide.load.b.b.SOURCE).a(this.float_permission_tip_img);
        setCancelable(false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setWindowAnimations(R.style.dialogWindowAnim);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.fotoable.youtube.music.ui.dialog.i

            /* renamed from: a  reason: collision with root package name */
            private final FloatPermissionDialog f4454a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4454a = this;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return this.f4454a.a(dialogInterface, i, keyEvent);
            }
        });
        this.enableTv.setOnClickListener(new View.OnClickListener(this) { // from class: com.fotoable.youtube.music.ui.dialog.j

            /* renamed from: a  reason: collision with root package name */
            private final FloatPermissionDialog f4455a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4455a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                this.f4455a.b(view2);
            }
        });
        this.cancelTv.setOnClickListener(new View.OnClickListener(this) { // from class: com.fotoable.youtube.music.ui.dialog.k

            /* renamed from: a  reason: collision with root package name */
            private final FloatPermissionDialog f4456a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4456a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                this.f4456a.a(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            try {
                if (this.f4107a != null) {
                    this.f4107a.a();
                }
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
            dismissAllowingStateLoss();
            onCancel(dialogInterface);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b(View view) {
        if (this.f4107a != null) {
            this.f4107a.b();
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(View view) {
        if (this.f4107a != null) {
            this.f4107a.c();
        }
        dismiss();
    }

    public void a(a aVar) {
        this.f4107a = aVar;
    }

    public static FloatPermissionDialog a(FragmentManager fragmentManager, a aVar) {
        FloatPermissionDialog floatPermissionDialog;
        Exception e;
        try {
            floatPermissionDialog = new FloatPermissionDialog();
        } catch (Exception e2) {
            floatPermissionDialog = null;
            e = e2;
        }
        try {
            floatPermissionDialog.f4109c = fragmentManager;
            floatPermissionDialog.a(aVar);
            fragmentManager.beginTransaction().add(floatPermissionDialog, "FloatPermissionDialog").commitAllowingStateLoss();
        } catch (Exception e3) {
            e = e3;
            ThrowableExtension.printStackTrace(e);
            return floatPermissionDialog;
        }
        return floatPermissionDialog;
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            if (this.f4109c != null) {
                this.f4109c.beginTransaction().remove(this).commitAllowingStateLoss();
            }
            super.dismiss();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f4108b != null) {
            this.f4108b.unbind();
            this.f4108b = null;
        }
    }
}

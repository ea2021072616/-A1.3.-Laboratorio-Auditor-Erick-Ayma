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
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.fotoable.free.music.R;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public class SimpleMusicDialog extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public a f4382a;

    /* renamed from: b  reason: collision with root package name */
    private FragmentManager f4383b;

    /* renamed from: c  reason: collision with root package name */
    private Unbinder f4384c;
    @BindView(R.id.cancel)
    TextView cancelTv;
    @BindView(R.id.clear)
    TextView clearTv;
    @BindView(R.id.content)
    TextView contentTv;
    private int d;
    private int e;
    private int f;

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
        return layoutInflater.inflate(R.layout.dialog_simple, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f4384c = ButterKnife.bind(this, view);
        if (this.d != 0) {
            this.contentTv.setText(this.d);
        }
        if (this.e != 0) {
            this.cancelTv.setText(this.e);
        }
        if (this.f != 0) {
            this.clearTv.setText(this.f);
        }
        setCancelable(false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setWindowAnimations(R.style.dialogWindowAnim);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.fotoable.youtube.music.ui.dialog.ae

            /* renamed from: a  reason: collision with root package name */
            private final SimpleMusicDialog f4427a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4427a = this;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return this.f4427a.a(dialogInterface, i, keyEvent);
            }
        });
        this.cancelTv.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SimpleMusicDialog.this.f4382a != null) {
                    SimpleMusicDialog.this.f4382a.b();
                }
                SimpleMusicDialog.this.dismiss();
            }
        });
        this.clearTv.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SimpleMusicDialog.this.f4382a != null) {
                    SimpleMusicDialog.this.f4382a.c();
                }
                SimpleMusicDialog.this.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            try {
                if (this.f4382a != null) {
                    this.f4382a.a();
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

    public void a(a aVar) {
        this.f4382a = aVar;
    }

    public static SimpleMusicDialog a(FragmentManager fragmentManager, a aVar, int i, int i2, int i3) {
        SimpleMusicDialog simpleMusicDialog;
        Exception e;
        try {
            simpleMusicDialog = new SimpleMusicDialog();
        } catch (Exception e2) {
            simpleMusicDialog = null;
            e = e2;
        }
        try {
            simpleMusicDialog.f4383b = fragmentManager;
            simpleMusicDialog.d = i;
            simpleMusicDialog.e = i2;
            simpleMusicDialog.f = i3;
            simpleMusicDialog.a(aVar);
            fragmentManager.beginTransaction().add(simpleMusicDialog, "SimpleMusicDialog").commitAllowingStateLoss();
        } catch (Exception e3) {
            e = e3;
            ThrowableExtension.printStackTrace(e);
            return simpleMusicDialog;
        }
        return simpleMusicDialog;
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            if (this.f4383b != null) {
                this.f4383b.beginTransaction().remove(this).commitAllowingStateLoss();
            }
            super.dismiss();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f4384c != null) {
            this.f4384c.unbind();
            this.f4384c = null;
        }
    }
}

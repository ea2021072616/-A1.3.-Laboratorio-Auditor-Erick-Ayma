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
public class QuickToolTipDialog extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public a f4334a;

    /* renamed from: b  reason: collision with root package name */
    private Unbinder f4335b;

    /* renamed from: c  reason: collision with root package name */
    private FragmentManager f4336c;
    @BindView(R.id.cancel)
    TextView cancelTv;
    @BindView(R.id.enable)
    TextView enableTv;

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
        return layoutInflater.inflate(R.layout.dialog_quick_tool_tip, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f4335b = ButterKnife.bind(this, view);
        setCancelable(false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setWindowAnimations(R.style.dialogWindowAnim);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.fotoable.youtube.music.ui.dialog.w

            /* renamed from: a  reason: collision with root package name */
            private final QuickToolTipDialog f4477a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4477a = this;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return this.f4477a.a(dialogInterface, i, keyEvent);
            }
        });
        this.enableTv.setOnClickListener(new View.OnClickListener(this) { // from class: com.fotoable.youtube.music.ui.dialog.x

            /* renamed from: a  reason: collision with root package name */
            private final QuickToolTipDialog f4478a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4478a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                this.f4478a.b(view2);
            }
        });
        this.cancelTv.setOnClickListener(new View.OnClickListener(this) { // from class: com.fotoable.youtube.music.ui.dialog.y

            /* renamed from: a  reason: collision with root package name */
            private final QuickToolTipDialog f4479a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4479a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                this.f4479a.a(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            try {
                if (this.f4334a != null) {
                    this.f4334a.a();
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
        if (this.f4334a != null) {
            this.f4334a.b();
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(View view) {
        if (this.f4334a != null) {
            this.f4334a.c();
        }
        dismiss();
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            if (this.f4336c != null) {
                this.f4336c.beginTransaction().remove(this).commitAllowingStateLoss();
            }
            super.dismiss();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f4335b != null) {
            this.f4335b.unbind();
            this.f4335b = null;
        }
    }
}

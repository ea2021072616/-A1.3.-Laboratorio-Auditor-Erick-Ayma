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
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.ProgressWheel;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* compiled from: LoadingDialog.java */
/* loaded from: classes.dex */
public class n extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public a f4464a;

    /* renamed from: b  reason: collision with root package name */
    private FragmentManager f4465b;

    /* renamed from: c  reason: collision with root package name */
    private ProgressWheel f4466c;
    private TextView d;
    private int e;

    /* compiled from: LoadingDialog.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().requestWindowFeature(1);
        return layoutInflater.inflate(R.layout.dialog_loading, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f4466c = (ProgressWheel) view.findViewById(R.id.loading);
        this.d = (TextView) view.findViewById(R.id.loading_label);
        if (this.e != 0) {
            this.d.setText(this.e);
        } else if (this.e == -1) {
            this.d.setText("");
        }
        setCancelable(false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.fotoable.youtube.music.ui.dialog.o

            /* renamed from: a  reason: collision with root package name */
            private final n f4467a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4467a = this;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return this.f4467a.a(dialogInterface, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            try {
                if (this.f4464a != null) {
                    this.f4464a.a();
                }
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
            onCancel(dialogInterface);
            return true;
        }
        return false;
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.0f;
        window.setAttributes(attributes);
    }

    public void a(a aVar) {
        this.f4464a = aVar;
    }

    public static n a(FragmentManager fragmentManager, int i, a aVar) {
        n nVar;
        Exception e;
        try {
            nVar = new n();
        } catch (Exception e2) {
            nVar = null;
            e = e2;
        }
        try {
            nVar.f4465b = fragmentManager;
            nVar.e = i;
            nVar.a(aVar);
            fragmentManager.beginTransaction().add(nVar, "LoadingDialog").commitAllowingStateLoss();
        } catch (Exception e3) {
            e = e3;
            ThrowableExtension.printStackTrace(e);
            return nVar;
        }
        return nVar;
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            if (this.f4465b != null) {
                this.f4465b.beginTransaction().remove(this).commitAllowingStateLoss();
            }
            super.dismiss();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }
}

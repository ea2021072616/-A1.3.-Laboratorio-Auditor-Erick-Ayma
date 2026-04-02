package com.fotoable.youtube.music.ui.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.Unbinder;
/* compiled from: BaseTipDialogFragment.java */
/* loaded from: classes.dex */
public abstract class b extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    protected a f4429a;

    /* renamed from: b  reason: collision with root package name */
    protected Object f4430b;

    /* renamed from: c  reason: collision with root package name */
    private Unbinder f4431c;

    /* compiled from: BaseTipDialogFragment.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();
    }

    @Override // android.support.v4.app.Fragment
    @CallSuper
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f4431c = ButterKnife.bind(this, view);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.fotoable.youtube.music.ui.dialog.c

            /* renamed from: a  reason: collision with root package name */
            private final b f4432a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4432a = this;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return this.f4432a.a(dialogInterface, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            a();
            dismissAllowingStateLoss();
            onCancel(dialogInterface);
            return true;
        }
        return false;
    }

    public void a() {
    }

    public void a(a aVar) {
        this.f4429a = aVar;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f4431c != null) {
            this.f4431c.unbind();
        }
        this.f4429a = null;
        this.f4430b = null;
    }

    @Override // android.support.v4.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        if (this.f4429a != null) {
            this.f4429a.a();
        }
    }
}

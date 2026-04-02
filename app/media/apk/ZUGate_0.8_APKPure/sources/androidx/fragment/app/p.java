package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;
/* loaded from: classes.dex */
public final class p implements DialogInterface.OnDismissListener {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ r f965g;

    public p(r rVar) {
        this.f965g = rVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        r rVar = this.f965g;
        Dialog dialog = rVar.f988r;
        if (dialog != null) {
            rVar.onDismiss(dialog);
        }
    }
}

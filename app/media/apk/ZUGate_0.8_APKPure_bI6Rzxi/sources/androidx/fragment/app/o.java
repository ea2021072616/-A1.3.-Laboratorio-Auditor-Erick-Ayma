package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;
/* loaded from: classes.dex */
public final class o implements DialogInterface.OnCancelListener {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ r f960g;

    public o(r rVar) {
        this.f960g = rVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        r rVar = this.f960g;
        Dialog dialog = rVar.f988r;
        if (dialog != null) {
            rVar.onCancel(dialog);
        }
    }
}

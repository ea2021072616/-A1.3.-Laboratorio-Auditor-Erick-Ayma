package i2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.r;
import androidx.fragment.app.w0;
import com.google.android.gms.internal.play_billing.i0;
/* loaded from: classes.dex */
public class i extends r {

    /* renamed from: w  reason: collision with root package name */
    public Dialog f3398w;

    /* renamed from: x  reason: collision with root package name */
    public DialogInterface.OnCancelListener f3399x;

    /* renamed from: y  reason: collision with root package name */
    public AlertDialog f3400y;

    @Override // androidx.fragment.app.r
    public final Dialog h(Bundle bundle) {
        Dialog dialog = this.f3398w;
        if (dialog == null) {
            this.f985n = false;
            if (this.f3400y == null) {
                Context context = getContext();
                i0.j(context);
                this.f3400y = new AlertDialog.Builder(context).create();
            }
            return this.f3400y;
        }
        return dialog;
    }

    @Override // androidx.fragment.app.r
    public final void j(w0 w0Var, String str) {
        super.j(w0Var, str);
    }

    @Override // androidx.fragment.app.r, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f3399x;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}

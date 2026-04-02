package i2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.i0;
/* loaded from: classes.dex */
public final class b extends DialogFragment {

    /* renamed from: g  reason: collision with root package name */
    public Dialog f3384g;

    /* renamed from: h  reason: collision with root package name */
    public DialogInterface.OnCancelListener f3385h;

    /* renamed from: i  reason: collision with root package name */
    public AlertDialog f3386i;

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f3385h;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f3384g;
        if (dialog == null) {
            setShowsDialog(false);
            if (this.f3386i == null) {
                Activity activity = getActivity();
                i0.j(activity);
                this.f3386i = new AlertDialog.Builder(activity).create();
            }
            return this.f3386i;
        }
        return dialog;
    }

    @Override // android.app.DialogFragment
    public final void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}

package pub.devrel.easypermissions;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.StringRes;
import pub.devrel.easypermissions.b;
/* compiled from: RationaleDialogFragment.java */
@RequiresApi(11)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class e extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private b.a f5213a;

    public static e a(@StringRes int i, @StringRes int i2, @NonNull String str, int i3, @NonNull String[] strArr) {
        e eVar = new e();
        eVar.setArguments(new d(i, i2, str, i3, strArr).a());
        return eVar;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    @SuppressLint({"NewApi"})
    public void onAttach(Context context) {
        super.onAttach(context);
        if ((Build.VERSION.SDK_INT >= 17) && getParentFragment() != null && (getParentFragment() instanceof b.a)) {
            this.f5213a = (b.a) getParentFragment();
        } else if (context instanceof b.a) {
            this.f5213a = (b.a) context;
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f5213a = null;
    }

    @Override // android.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        setCancelable(false);
        d dVar = new d(getArguments());
        return dVar.a(getActivity(), new c(this, dVar, this.f5213a));
    }
}

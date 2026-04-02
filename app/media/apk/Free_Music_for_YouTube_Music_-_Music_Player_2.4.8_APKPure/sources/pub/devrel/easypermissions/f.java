package pub.devrel.easypermissions;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatDialogFragment;
import pub.devrel.easypermissions.b;
/* compiled from: RationaleDialogFragmentCompat.java */
@RequiresApi(17)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class f extends AppCompatDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private b.a f5214a;

    public static f a(@StringRes int i, @StringRes int i2, @NonNull String str, int i3, @NonNull String[] strArr) {
        f fVar = new f();
        fVar.setArguments(new d(i, i2, str, i3, strArr).a());
        return fVar;
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getParentFragment() != null && (getParentFragment() instanceof b.a)) {
            this.f5214a = (b.a) getParentFragment();
        } else if (context instanceof b.a) {
            this.f5214a = (b.a) context;
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f5214a = null;
    }

    @Override // android.support.v7.app.AppCompatDialogFragment, android.support.v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        setCancelable(false);
        d dVar = new d(getArguments());
        return dVar.a(getContext(), new c(this, dVar, this.f5214a));
    }
}

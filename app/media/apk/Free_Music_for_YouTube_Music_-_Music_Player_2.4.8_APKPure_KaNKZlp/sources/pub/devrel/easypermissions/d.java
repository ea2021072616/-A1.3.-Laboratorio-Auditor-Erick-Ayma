package pub.devrel.easypermissions;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;
import com.facebook.internal.NativeProtocol;
/* compiled from: RationaleDialogConfig.java */
/* loaded from: classes2.dex */
class d {

    /* renamed from: a  reason: collision with root package name */
    int f5210a;

    /* renamed from: b  reason: collision with root package name */
    int f5211b;

    /* renamed from: c  reason: collision with root package name */
    int f5212c;
    String d;
    String[] e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(@StringRes int i, @StringRes int i2, @NonNull String str, int i3, @NonNull String[] strArr) {
        this.f5210a = i;
        this.f5211b = i2;
        this.d = str;
        this.f5212c = i3;
        this.e = strArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Bundle bundle) {
        this.f5210a = bundle.getInt("positiveButton");
        this.f5211b = bundle.getInt("negativeButton");
        this.d = bundle.getString("rationaleMsg");
        this.f5212c = bundle.getInt("requestCode");
        this.e = bundle.getStringArray(NativeProtocol.RESULT_ARGS_PERMISSIONS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt("positiveButton", this.f5210a);
        bundle.putInt("negativeButton", this.f5211b);
        bundle.putString("rationaleMsg", this.d);
        bundle.putInt("requestCode", this.f5212c);
        bundle.putStringArray(NativeProtocol.RESULT_ARGS_PERMISSIONS, this.e);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener) {
        return new AlertDialog.Builder(context).setCancelable(false).setPositiveButton(this.f5210a, onClickListener).setNegativeButton(this.f5211b, onClickListener).setMessage(this.d).create();
    }
}

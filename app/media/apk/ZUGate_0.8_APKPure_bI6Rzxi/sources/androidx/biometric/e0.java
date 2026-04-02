package androidx.biometric;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.appintro.R;
/* loaded from: classes.dex */
public class e0 extends androidx.fragment.app.r {
    public int A;
    public ImageView B;
    public TextView C;

    /* renamed from: w  reason: collision with root package name */
    public final Handler f613w = new Handler(Looper.getMainLooper());

    /* renamed from: x  reason: collision with root package name */
    public final androidx.activity.j f614x = new androidx.activity.j(6, this);

    /* renamed from: y  reason: collision with root package name */
    public x f615y;

    /* renamed from: z  reason: collision with root package name */
    public int f616z;

    @Override // androidx.fragment.app.r
    public final Dialog h(Bundle bundle) {
        d.m mVar = new d.m(requireContext());
        t tVar = this.f615y.f647e;
        CharSequence charSequence = tVar != null ? tVar.f636a : null;
        Object obj = mVar.f2398h;
        ((d.i) obj).f2342d = charSequence;
        View inflate = LayoutInflater.from(((d.i) obj).f2339a).inflate(R.layout.fingerprint_dialog_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.fingerprint_subtitle);
        if (textView != null) {
            t tVar2 = this.f615y.f647e;
            CharSequence charSequence2 = tVar2 != null ? tVar2.f637b : null;
            if (TextUtils.isEmpty(charSequence2)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(charSequence2);
            }
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.fingerprint_description);
        if (textView2 != null) {
            t tVar3 = this.f615y.f647e;
            CharSequence charSequence3 = tVar3 != null ? tVar3.f638c : null;
            if (TextUtils.isEmpty(charSequence3)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(charSequence3);
            }
        }
        this.B = (ImageView) inflate.findViewById(R.id.fingerprint_icon);
        this.C = (TextView) inflate.findViewById(R.id.fingerprint_error);
        CharSequence string = m0.a.q(this.f615y.c()) ? getString(R.string.confirm_device_credential_password) : this.f615y.d();
        w wVar = new w(this, 1);
        d.i iVar = (d.i) obj;
        iVar.f2347i = string;
        iVar.f2348j = wVar;
        mVar.f(inflate);
        d.n a5 = mVar.a();
        a5.setCanceledOnTouchOutside(false);
        return a5;
    }

    public final int k(int i5) {
        Context context = getContext();
        androidx.fragment.app.d0 a5 = a();
        if (context == null || a5 == null) {
            Log.w("FingerprintFragment", "Unable to get themed color. Context or activity is null.");
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i5, typedValue, true);
        TypedArray obtainStyledAttributes = a5.obtainStyledAttributes(typedValue.data, new int[]{i5});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        return color;
    }

    @Override // androidx.fragment.app.r, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        x xVar = this.f615y;
        if (xVar.f664w == null) {
            xVar.f664w = new androidx.lifecycle.a0();
        }
        x.i(xVar.f664w, Boolean.TRUE);
    }

    @Override // androidx.fragment.app.r, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        androidx.fragment.app.d0 a5 = a();
        if (a5 != null) {
            x xVar = (x) new d.e(a5).j(x.class);
            this.f615y = xVar;
            if (xVar.f666y == null) {
                xVar.f666y = new androidx.lifecycle.a0();
            }
            xVar.f666y.d(this, new b0(this, 0));
            x xVar2 = this.f615y;
            if (xVar2.f667z == null) {
                xVar2.f667z = new androidx.lifecycle.a0();
            }
            xVar2.f667z.d(this, new b0(this, 1));
        }
        this.f616z = k(d0.a());
        this.A = k(16842808);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        this.f613w.removeCallbacksAndMessages(null);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        x xVar = this.f615y;
        xVar.f665x = 0;
        xVar.g(1);
        this.f615y.f(getString(R.string.fingerprint_dialog_touch_sensor));
    }
}

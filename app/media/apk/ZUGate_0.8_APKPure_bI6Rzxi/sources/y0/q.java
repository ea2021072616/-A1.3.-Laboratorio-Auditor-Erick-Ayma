package y0;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.preference.DialogPreference;
/* loaded from: classes.dex */
public abstract class q extends androidx.fragment.app.r implements DialogInterface.OnClickListener {
    public CharSequence A;
    public int B;
    public BitmapDrawable C;
    public int D;

    /* renamed from: w  reason: collision with root package name */
    public DialogPreference f5628w;

    /* renamed from: x  reason: collision with root package name */
    public CharSequence f5629x;

    /* renamed from: y  reason: collision with root package name */
    public CharSequence f5630y;

    /* renamed from: z  reason: collision with root package name */
    public CharSequence f5631z;

    @Override // androidx.fragment.app.r
    public final Dialog h(Bundle bundle) {
        this.D = -2;
        d.m mVar = new d.m(requireContext());
        CharSequence charSequence = this.f5629x;
        Object obj = mVar.f2398h;
        ((d.i) obj).f2342d = charSequence;
        ((d.i) obj).f2341c = this.C;
        d.i iVar = (d.i) obj;
        iVar.f2345g = this.f5630y;
        iVar.f2346h = this;
        d.i iVar2 = (d.i) obj;
        iVar2.f2347i = this.f5631z;
        iVar2.f2348j = this;
        requireContext();
        int i5 = this.B;
        View inflate = i5 != 0 ? getLayoutInflater().inflate(i5, (ViewGroup) null) : null;
        if (inflate != null) {
            l(inflate);
            mVar.f(inflate);
        } else {
            ((d.i) obj).f2344f = this.A;
        }
        n(mVar);
        d.n a5 = mVar.a();
        if (this instanceof d) {
            Window window = a5.getWindow();
            if (Build.VERSION.SDK_INT >= 30) {
                p.a(window);
            } else {
                o();
            }
        }
        return a5;
    }

    public final DialogPreference k() {
        if (this.f5628w == null) {
            this.f5628w = (DialogPreference) ((s) ((b) getTargetFragment())).g(requireArguments().getString("key"));
        }
        return this.f5628w;
    }

    public void l(View view) {
        int i5;
        View findViewById = view.findViewById(16908299);
        if (findViewById != null) {
            CharSequence charSequence = this.A;
            if (TextUtils.isEmpty(charSequence)) {
                i5 = 8;
            } else {
                if (findViewById instanceof TextView) {
                    ((TextView) findViewById).setText(charSequence);
                }
                i5 = 0;
            }
            if (findViewById.getVisibility() != i5) {
                findViewById.setVisibility(i5);
            }
        }
    }

    public abstract void m(boolean z4);

    public void n(d.m mVar) {
    }

    public void o() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i5) {
        this.D = i5;
    }

    @Override // androidx.fragment.app.r, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fragment targetFragment = getTargetFragment();
        if (!(targetFragment instanceof b)) {
            throw new IllegalStateException("Target fragment must implement TargetFragment interface");
        }
        b bVar = (b) targetFragment;
        String string = requireArguments().getString("key");
        if (bundle != null) {
            this.f5629x = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.f5630y = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.f5631z = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.A = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.B = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.C = new BitmapDrawable(getResources(), bitmap);
                return;
            }
            return;
        }
        DialogPreference dialogPreference = (DialogPreference) ((s) bVar).g(string);
        this.f5628w = dialogPreference;
        this.f5629x = dialogPreference.O;
        this.f5630y = dialogPreference.R;
        this.f5631z = dialogPreference.S;
        this.A = dialogPreference.P;
        this.B = dialogPreference.T;
        Drawable drawable = dialogPreference.Q;
        if (drawable == null || (drawable instanceof BitmapDrawable)) {
            this.C = (BitmapDrawable) drawable;
            return;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        this.C = new BitmapDrawable(getResources(), createBitmap);
    }

    @Override // androidx.fragment.app.r, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        m(this.D == -1);
    }

    @Override // androidx.fragment.app.r, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.f5629x);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.f5630y);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.f5631z);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.A);
        bundle.putInt("PreferenceDialogFragment.layout", this.B);
        BitmapDrawable bitmapDrawable = this.C;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }
}

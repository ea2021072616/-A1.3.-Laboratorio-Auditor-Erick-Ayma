package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.b0;
import com.github.appintro.R;
import com.google.android.material.internal.CheckableImageButton;
import d.u0;
import h0.k2;
import h0.m2;
import h0.o0;
import h0.z0;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class n<S> extends androidx.fragment.app.r {
    public static final /* synthetic */ int U = 0;
    public c A;
    public l B;
    public int C;
    public CharSequence D;
    public boolean E;
    public int F;
    public int G;
    public CharSequence H;
    public int I;
    public CharSequence J;
    public int K;
    public CharSequence L;
    public int M;
    public CharSequence N;
    public TextView O;
    public CheckableImageButton P;
    public p3.g Q;
    public boolean R;
    public CharSequence S;
    public CharSequence T;

    /* renamed from: w  reason: collision with root package name */
    public final LinkedHashSet f2137w;

    /* renamed from: x  reason: collision with root package name */
    public final LinkedHashSet f2138x;

    /* renamed from: y  reason: collision with root package name */
    public int f2139y;

    /* renamed from: z  reason: collision with root package name */
    public u f2140z;

    public n() {
        new LinkedHashSet();
        new LinkedHashSet();
        this.f2137w = new LinkedHashSet();
        this.f2138x = new LinkedHashSet();
    }

    public static int l(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        Calendar c5 = w.c();
        c5.set(5, 1);
        Calendar b5 = w.b(c5);
        b5.get(2);
        b5.get(1);
        int maximum = b5.getMaximum(7);
        b5.getActualMaximum(5);
        b5.getTimeInMillis();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * maximum;
        return ((maximum - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding)) + dimensionPixelSize + (dimensionPixelOffset * 2);
    }

    public static boolean m(Context context) {
        return n(context, 16843277);
    }

    public static boolean n(Context context, int i5) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(e4.e.P(R.attr.materialCalendarStyle, context, l.class.getCanonicalName()).data, new int[]{i5});
        boolean z4 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z4;
    }

    @Override // androidx.fragment.app.r
    public final Dialog h(Bundle bundle) {
        Context requireContext = requireContext();
        requireContext();
        int i5 = this.f2139y;
        if (i5 == 0) {
            k();
            throw null;
        }
        Dialog dialog = new Dialog(requireContext, i5);
        Context context = dialog.getContext();
        this.E = m(context);
        this.Q = new p3.g(context, null, R.attr.materialCalendarStyle, 2131952713);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, w2.a.f5397l, R.attr.materialCalendarStyle, 2131952713);
        int color = obtainStyledAttributes.getColor(1, 0);
        obtainStyledAttributes.recycle();
        this.Q.h(context);
        this.Q.j(ColorStateList.valueOf(color));
        p3.g gVar = this.Q;
        View decorView = dialog.getWindow().getDecorView();
        WeakHashMap weakHashMap = z0.f3233a;
        gVar.i(o0.i(decorView));
        return dialog;
    }

    public final void k() {
        b0.j(getArguments().getParcelable("DATE_SELECTOR_KEY"));
    }

    @Override // androidx.fragment.app.r, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.f2137w.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.r, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f2139y = bundle.getInt("OVERRIDE_THEME_RES_ID");
        b0.j(bundle.getParcelable("DATE_SELECTOR_KEY"));
        this.A = (c) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        b0.j(bundle.getParcelable("DAY_VIEW_DECORATOR_KEY"));
        this.C = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.D = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.F = bundle.getInt("INPUT_MODE_KEY");
        this.G = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.H = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.I = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.J = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.K = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.L = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.M = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.N = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence charSequence = this.D;
        if (charSequence == null) {
            charSequence = requireContext().getResources().getText(this.C);
        }
        this.S = charSequence;
        if (charSequence != null) {
            CharSequence[] split = TextUtils.split(String.valueOf(charSequence), "\n");
            if (split.length > 1) {
                charSequence = split[0];
            }
        } else {
            charSequence = null;
        }
        this.T = charSequence;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(this.E ? R.layout.mtrl_picker_fullscreen : R.layout.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        if (this.E) {
            inflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(l(context), -2));
        } else {
            inflate.findViewById(R.id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(l(context), -1));
        }
        WeakHashMap weakHashMap = z0.f3233a;
        ((TextView) inflate.findViewById(R.id.mtrl_picker_header_selection_text)).setAccessibilityLiveRegion(1);
        this.P = (CheckableImageButton) inflate.findViewById(R.id.mtrl_picker_header_toggle);
        this.O = (TextView) inflate.findViewById(R.id.mtrl_picker_title_text);
        this.P.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.P;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, p2.a.x(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], p2.a.x(context, R.drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.P.setChecked(this.F != 0);
        z0.n(this.P, null);
        CheckableImageButton checkableImageButton2 = this.P;
        this.P.setContentDescription(this.F == 1 ? checkableImageButton2.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton2.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode));
        this.P.setOnClickListener(new m(0, this));
        Button button = (Button) inflate.findViewById(R.id.confirm_button);
        k();
        throw null;
    }

    @Override // androidx.fragment.app.r, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.f2138x.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.r, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f2139y);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        a aVar = new a(this.A);
        l lVar = this.B;
        p pVar = lVar == null ? null : lVar.f2127j;
        if (pVar != null) {
            aVar.f2099c = Long.valueOf(pVar.f2148g);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", aVar.f2101e);
        p b5 = p.b(aVar.f2097a);
        p b6 = p.b(aVar.f2098b);
        b bVar = (b) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l5 = aVar.f2099c;
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new c(b5, b6, bVar, l5 == null ? null : p.b(l5.longValue()), aVar.f2100d));
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.C);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.D);
        bundle.putInt("INPUT_MODE_KEY", this.F);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.G);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.H);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.I);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.J);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.K);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.L);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.M);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.N);
    }

    @Override // androidx.fragment.app.r, androidx.fragment.app.Fragment
    public final void onStart() {
        CharSequence charSequence;
        super.onStart();
        Window window = i().getWindow();
        if (this.E) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.Q);
            if (!this.R) {
                View findViewById = requireView().findViewById(R.id.fullscreen_header);
                ColorStateList n5 = e4.e.n(findViewById.getBackground());
                Integer valueOf = n5 != null ? Integer.valueOf(n5.getDefaultColor()) : null;
                int i5 = Build.VERSION.SDK_INT;
                boolean z4 = valueOf == null || valueOf.intValue() == 0;
                int k5 = e4.e.k(window.getContext(), 16842801, -16777216);
                if (z4) {
                    valueOf = Integer.valueOf(k5);
                }
                Integer valueOf2 = Integer.valueOf(k5);
                b4.j.W(window, false);
                window.getContext();
                int c5 = i5 < 27 ? z.a.c(e4.e.k(window.getContext(), 16843858, -16777216), 128) : 0;
                window.setStatusBarColor(0);
                window.setNavigationBarColor(c5);
                boolean z5 = e4.e.A(0) || e4.e.A(valueOf.intValue());
                u0 u0Var = new u0(window.getDecorView());
                (Build.VERSION.SDK_INT >= 30 ? new m2(window, u0Var) : new k2(window, u0Var)).v(z5);
                boolean z6 = e4.e.A(c5) || (c5 == 0 && e4.e.A(valueOf2.intValue()));
                u0 u0Var2 = new u0(window.getDecorView());
                (Build.VERSION.SDK_INT >= 30 ? new m2(window, u0Var2) : new k2(window, u0Var2)).u(z6);
                androidx.activity.result.j jVar = new androidx.activity.result.j(this, findViewById.getLayoutParams().height, findViewById, findViewById.getPaddingTop());
                WeakHashMap weakHashMap = z0.f3233a;
                o0.u(findViewById, jVar);
                this.R = true;
            }
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.Q, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new g3.a(i(), rect));
        }
        requireContext();
        int i6 = this.f2139y;
        if (i6 == 0) {
            k();
            throw null;
        }
        k();
        c cVar = this.A;
        l lVar = new l();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i6);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", cVar);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putParcelable("CURRENT_MONTH_KEY", cVar.f2105e);
        lVar.setArguments(bundle);
        this.B = lVar;
        u uVar = lVar;
        if (this.F == 1) {
            k();
            c cVar2 = this.A;
            u oVar = new o();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", i6);
            bundle2.putParcelable("DATE_SELECTOR_KEY", null);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", cVar2);
            oVar.setArguments(bundle2);
            uVar = oVar;
        }
        this.f2140z = uVar;
        TextView textView = this.O;
        if (this.F == 1) {
            if (getResources().getConfiguration().orientation == 2) {
                charSequence = this.T;
                textView.setText(charSequence);
                k();
                getContext();
                throw null;
            }
        }
        charSequence = this.S;
        textView.setText(charSequence);
        k();
        getContext();
        throw null;
    }

    @Override // androidx.fragment.app.r, androidx.fragment.app.Fragment
    public final void onStop() {
        this.f2140z.f2162g.clear();
        super.onStop();
    }
}

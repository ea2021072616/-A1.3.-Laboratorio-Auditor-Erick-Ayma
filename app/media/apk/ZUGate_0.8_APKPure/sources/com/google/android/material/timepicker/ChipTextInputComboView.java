package com.google.android.material.timepicker;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.github.appintro.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;
import h0.n2;
import h0.u0;
import h0.z0;
import java.util.WeakHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: g  reason: collision with root package name */
    public final Chip f2246g;

    /* renamed from: h  reason: collision with root package name */
    public final EditText f2247h;

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(R.layout.material_time_chip, (ViewGroup) this, false);
        this.f2246g = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(R.layout.material_time_input, (ViewGroup) this, false);
        EditText editText = textInputLayout.getEditText();
        this.f2247h = editText;
        editText.setVisibility(4);
        editText.addTextChangedListener(new a(this));
        editText.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        addView(chip);
        addView(textInputLayout);
        WeakHashMap weakHashMap = z0.f3233a;
        editText.setId(View.generateViewId());
        ((TextView) findViewById(R.id.material_label)).setLabelFor(editText.getId());
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }

    public static String a(ChipTextInputComboView chipTextInputComboView, CharSequence charSequence) {
        try {
            return String.format(chipTextInputComboView.getResources().getConfiguration().locale, "%02d", Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f2246g.isChecked();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f2247h.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
    }

    @Override // android.widget.Checkable
    public final void setChecked(boolean z4) {
        Chip chip = this.f2246g;
        chip.setChecked(z4);
        int i5 = z4 ? 0 : 4;
        final EditText editText = this.f2247h;
        editText.setVisibility(i5);
        chip.setVisibility(z4 ? 8 : 0);
        if (isChecked()) {
            editText.requestFocus();
            editText.post(new Runnable() { // from class: j3.k

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f3509c = false;

                @Override // java.lang.Runnable
                public final void run() {
                    n2 n2Var;
                    boolean z5 = this.f3509c;
                    View view = editText;
                    if (z5) {
                        WeakHashMap weakHashMap = z0.f3233a;
                        if (Build.VERSION.SDK_INT >= 30) {
                            n2Var = u0.c(view);
                        } else {
                            Context context = view.getContext();
                            while (true) {
                                if (!(context instanceof ContextWrapper)) {
                                    break;
                                } else if (context instanceof Activity) {
                                    Window window = ((Activity) context).getWindow();
                                    if (window != null) {
                                        n2Var = new n2(window, view);
                                    }
                                } else {
                                    context = ((ContextWrapper) context).getBaseContext();
                                }
                            }
                            n2Var = null;
                        }
                        if (n2Var != null) {
                            n2Var.f3183a.y();
                            return;
                        }
                    }
                    ((InputMethodManager) x.b.b(view.getContext(), InputMethodManager.class)).showSoftInput(view, 1);
                }
            });
        }
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f2246g.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public final void setTag(int i5, Object obj) {
        this.f2246g.setTag(i5, obj);
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        this.f2246g.toggle();
    }
}

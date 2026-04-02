package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import com.google.android.material.chip.Chip;
/* loaded from: classes.dex */
public final class a extends j3.j {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ChipTextInputComboView f2263g;

    public a(ChipTextInputComboView chipTextInputComboView) {
        this.f2263g = chipTextInputComboView;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        boolean isEmpty = TextUtils.isEmpty(editable);
        ChipTextInputComboView chipTextInputComboView = this.f2263g;
        if (isEmpty) {
            chipTextInputComboView.f2246g.setText(ChipTextInputComboView.a(chipTextInputComboView, "00"));
            return;
        }
        String a5 = ChipTextInputComboView.a(chipTextInputComboView, editable);
        Chip chip = chipTextInputComboView.f2246g;
        if (TextUtils.isEmpty(a5)) {
            a5 = ChipTextInputComboView.a(chipTextInputComboView, "00");
        }
        chip.setText(a5);
    }
}

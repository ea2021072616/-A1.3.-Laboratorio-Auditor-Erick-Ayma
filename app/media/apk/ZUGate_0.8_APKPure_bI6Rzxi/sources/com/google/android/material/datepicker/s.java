package com.google.android.material.datepicker;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.i1;
import com.github.appintro.R;
import h0.j0;
import h0.z0;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class s extends i1 {

    /* renamed from: u  reason: collision with root package name */
    public final TextView f2157u;

    /* renamed from: v  reason: collision with root package name */
    public final MaterialCalendarGridView f2158v;

    public s(LinearLayout linearLayout, boolean z4) {
        super(linearLayout);
        TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
        this.f2157u = textView;
        WeakHashMap weakHashMap = z0.f3233a;
        new j0(R.id.tag_accessibility_heading, 3).c(textView, Boolean.TRUE);
        this.f2158v = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
        if (z4) {
            return;
        }
        textView.setVisibility(8);
    }
}

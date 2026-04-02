package com.github.appintro.indicator;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
public interface IndicatorController {
    int getSelectedIndicatorColor();

    int getUnselectedIndicatorColor();

    void initialize(int i5);

    View newInstance(Context context);

    void selectPosition(int i5);

    void setSelectedIndicatorColor(int i5);

    void setUnselectedIndicatorColor(int i5);
}

package com.github.appintro;

import android.view.View;
/* loaded from: classes.dex */
public final class AppIntroBaseKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isVisible(View view) {
        return view.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setVisible(View view, boolean z4) {
        view.setVisibility(z4 ? 0 : 4);
    }
}

package androidx.appcompat.widget;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
public final class h extends View {
    public h(Context context) {
        super(context);
        setWillNotDraw(true);
    }

    @Override // android.view.View
    public final int getWindowSystemUiVisibility() {
        return 0;
    }
}

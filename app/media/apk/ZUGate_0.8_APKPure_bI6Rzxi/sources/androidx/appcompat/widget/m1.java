package androidx.appcompat.widget;

import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.widget.TextView;
/* loaded from: classes.dex */
public final class m1 extends k1 {
    @Override // androidx.appcompat.widget.k1, androidx.appcompat.widget.n1
    public void a(StaticLayout.Builder builder, TextView textView) {
        TextDirectionHeuristic textDirectionHeuristic;
        textDirectionHeuristic = textView.getTextDirectionHeuristic();
        builder.setTextDirection(textDirectionHeuristic);
    }

    @Override // androidx.appcompat.widget.n1
    public boolean b(TextView textView) {
        boolean isHorizontallyScrollable;
        isHorizontallyScrollable = textView.isHorizontallyScrollable();
        return isHorizontallyScrollable;
    }
}

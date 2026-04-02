package d;

import android.content.Context;
import android.widget.ArrayAdapter;
/* loaded from: classes.dex */
public final class k extends ArrayAdapter {
    public k(Context context, int i5, CharSequence[] charSequenceArr) {
        super(context, i5, 16908308, charSequenceArr);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final long getItemId(int i5) {
        return i5;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}

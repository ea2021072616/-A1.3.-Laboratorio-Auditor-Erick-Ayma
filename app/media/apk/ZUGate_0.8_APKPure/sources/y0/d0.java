package y0;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.i1;
import com.github.appintro.R;
/* loaded from: classes.dex */
public final class d0 extends i1 {

    /* renamed from: u  reason: collision with root package name */
    public final Drawable f5600u;

    /* renamed from: v  reason: collision with root package name */
    public final ColorStateList f5601v;

    /* renamed from: w  reason: collision with root package name */
    public final SparseArray f5602w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f5603x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f5604y;

    public d0(View view) {
        super(view);
        SparseArray sparseArray = new SparseArray(4);
        this.f5602w = sparseArray;
        TextView textView = (TextView) view.findViewById(16908310);
        sparseArray.put(16908310, textView);
        sparseArray.put(16908304, view.findViewById(16908304));
        sparseArray.put(16908294, view.findViewById(16908294));
        sparseArray.put(R.id.icon_frame, view.findViewById(R.id.icon_frame));
        sparseArray.put(16908350, view.findViewById(16908350));
        this.f5600u = view.getBackground();
        if (textView != null) {
            this.f5601v = textView.getTextColors();
        }
    }

    public final View q(int i5) {
        SparseArray sparseArray = this.f5602w;
        View view = (View) sparseArray.get(i5);
        if (view != null) {
            return view;
        }
        View findViewById = this.f1376a.findViewById(i5);
        if (findViewById != null) {
            sparseArray.put(i5, findViewById);
        }
        return findViewById;
    }
}

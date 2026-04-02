package v4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.i1;
import com.github.appintro.R;
/* loaded from: classes.dex */
public final class c extends i1 {

    /* renamed from: u  reason: collision with root package name */
    public final View f5224u;

    /* renamed from: v  reason: collision with root package name */
    public final ImageView f5225v;

    /* renamed from: w  reason: collision with root package name */
    public final TextView f5226w;

    /* renamed from: x  reason: collision with root package name */
    public final TextView f5227x;

    /* renamed from: y  reason: collision with root package name */
    public final TextView f5228y;

    public c(View view) {
        super(view);
        this.f5224u = view;
        this.f5225v = (ImageView) view.findViewById(R.id.image);
        this.f5226w = (TextView) view.findViewById(R.id.text);
        this.f5227x = (TextView) view.findViewById(R.id.text2);
        this.f5228y = (TextView) view.findViewById(R.id.buttonConnect);
    }
}

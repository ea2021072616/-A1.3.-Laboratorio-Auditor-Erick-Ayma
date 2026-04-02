package v4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.i1;
import com.github.appintro.R;
import ru.zdevs.zugate.widget.StateView;
import ru.zdevs.zugate.widget.SwitchRW;
/* loaded from: classes.dex */
public final class d extends i1 {
    public final SwitchRW A;
    public final StateView B;

    /* renamed from: u  reason: collision with root package name */
    public final View f5229u;

    /* renamed from: v  reason: collision with root package name */
    public final ImageView f5230v;

    /* renamed from: w  reason: collision with root package name */
    public final TextView f5231w;

    /* renamed from: x  reason: collision with root package name */
    public final TextView f5232x;

    /* renamed from: y  reason: collision with root package name */
    public final TextView f5233y;

    /* renamed from: z  reason: collision with root package name */
    public final TextView f5234z;

    public d(View view) {
        super(view);
        this.f5229u = view;
        this.f5230v = (ImageView) view.findViewById(R.id.image);
        this.f5231w = (TextView) view.findViewById(R.id.text);
        this.f5232x = (TextView) view.findViewById(R.id.text2);
        this.f5233y = (TextView) view.findViewById(R.id.text3);
        this.f5234z = (TextView) view.findViewById(R.id.buttonMount);
        this.A = (SwitchRW) view.findViewById(R.id.switchRW);
        this.B = (StateView) view.findViewById(R.id.stateRW);
    }
}

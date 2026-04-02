package v4;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.i1;
import com.github.appintro.R;
import ru.zdevs.zugate.widget.StateView;
import ru.zdevs.zugate.widget.SwitchRW;
/* loaded from: classes.dex */
public final class g extends i1 {
    public final SwitchRW A;
    public final StateView B;

    /* renamed from: u  reason: collision with root package name */
    public final View f5235u;

    /* renamed from: v  reason: collision with root package name */
    public final View f5236v;

    /* renamed from: w  reason: collision with root package name */
    public final TextView f5237w;

    /* renamed from: x  reason: collision with root package name */
    public final TextView f5238x;

    /* renamed from: y  reason: collision with root package name */
    public final TextView f5239y;

    /* renamed from: z  reason: collision with root package name */
    public final TextView f5240z;

    public g(View view) {
        super(view);
        this.f5235u = view;
        this.f5236v = view.findViewById(R.id.header);
        this.f5237w = (TextView) view.findViewById(R.id.text);
        this.f5238x = (TextView) view.findViewById(R.id.text2);
        this.f5239y = (TextView) view.findViewById(R.id.text3);
        this.f5240z = (TextView) view.findViewById(R.id.buttonMount);
        this.A = (SwitchRW) view.findViewById(R.id.switchRW);
        this.B = (StateView) view.findViewById(R.id.stateRW);
    }
}

package f3;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.google.android.material.chip.Chip;
import ru.zdevs.zugate.MainActivity;
/* loaded from: classes.dex */
public final /* synthetic */ class a implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2818a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckBox f2819b;

    public /* synthetic */ a(CheckBox checkBox, int i5) {
        this.f2818a = i5;
        this.f2819b = checkBox;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        int i5 = this.f2818a;
        CheckBox checkBox = this.f2819b;
        switch (i5) {
            case 0:
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener = ((Chip) checkBox).o;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(compoundButton, z4);
                    return;
                }
                return;
            default:
                int i6 = MainActivity.f4551q;
                checkBox.setEnabled(z4);
                return;
        }
    }
}

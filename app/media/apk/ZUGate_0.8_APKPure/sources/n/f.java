package n;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import java.util.Comparator;
/* loaded from: classes.dex */
public final class f implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4027a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f4028b;

    public /* synthetic */ f(int i5, Object obj) {
        this.f4027a = i5;
        this.f4028b = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f4027a) {
            case 0:
                return ((i) obj).f4034c - ((i) obj2).f4034c;
            default:
                MaterialButton materialButton = (MaterialButton) obj;
                MaterialButton materialButton2 = (MaterialButton) obj2;
                int compareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
                if (compareTo != 0) {
                    return compareTo;
                }
                int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.f4028b;
                return Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton)).compareTo(Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton2)));
        }
    }
}

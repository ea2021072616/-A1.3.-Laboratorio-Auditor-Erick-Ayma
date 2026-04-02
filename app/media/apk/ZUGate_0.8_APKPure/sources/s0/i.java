package s0;

import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.widget.TextView;
import androidx.emoji2.text.m;
/* loaded from: classes.dex */
public final class i extends p3.e {

    /* renamed from: k  reason: collision with root package name */
    public final h f4821k;

    public i(TextView textView) {
        super(19);
        this.f4821k = new h(textView);
    }

    @Override // p3.e
    public final InputFilter[] f(InputFilter[] inputFilterArr) {
        return (m.f769k != null) ^ true ? inputFilterArr : this.f4821k.f(inputFilterArr);
    }

    @Override // p3.e
    public final boolean p() {
        return this.f4821k.f4820m;
    }

    @Override // p3.e
    public final void t(boolean z4) {
        if (!(m.f769k != null)) {
            return;
        }
        this.f4821k.t(z4);
    }

    @Override // p3.e
    public final void w(boolean z4) {
        boolean z5 = !(m.f769k != null);
        h hVar = this.f4821k;
        if (z5) {
            hVar.f4820m = z4;
        } else {
            hVar.w(z4);
        }
    }

    @Override // p3.e
    public final TransformationMethod z(TransformationMethod transformationMethod) {
        return (m.f769k != null) ^ true ? transformationMethod : this.f4821k.z(transformationMethod);
    }
}

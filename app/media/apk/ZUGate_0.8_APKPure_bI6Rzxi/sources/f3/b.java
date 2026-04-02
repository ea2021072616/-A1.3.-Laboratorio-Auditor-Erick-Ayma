package f3;

import android.graphics.Typeface;
import com.google.android.material.chip.Chip;
import j3.h;
import j3.i;
/* loaded from: classes.dex */
public final class b extends p2.a {

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f2820u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ Object f2821v;

    public /* synthetic */ b(int i5, Object obj) {
        this.f2820u = i5;
        this.f2821v = obj;
    }

    @Override // p2.a
    public final void M(int i5) {
        switch (this.f2820u) {
            case 0:
                return;
            default:
                i iVar = (i) this.f2821v;
                iVar.f3505d = true;
                h hVar = (h) iVar.f3506e.get();
                if (hVar != null) {
                    f fVar = (f) hVar;
                    fVar.u();
                    fVar.invalidateSelf();
                    return;
                }
                return;
        }
    }

    @Override // p2.a
    public final void N(Typeface typeface, boolean z4) {
        int i5 = this.f2820u;
        Object obj = this.f2821v;
        switch (i5) {
            case 0:
                Chip chip = (Chip) obj;
                f fVar = chip.f2079k;
                chip.setText(fVar.J0 ? fVar.K : chip.getText());
                chip.requestLayout();
                chip.invalidate();
                return;
            default:
                if (z4) {
                    return;
                }
                i iVar = (i) obj;
                iVar.f3505d = true;
                h hVar = (h) iVar.f3506e.get();
                if (hVar != null) {
                    f fVar2 = (f) hVar;
                    fVar2.u();
                    fVar2.invalidateSelf();
                    return;
                }
                return;
        }
    }
}

package f3;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.chip.Chip;
/* loaded from: classes.dex */
public final class c extends ViewOutlineProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Chip f2822a;

    public c(Chip chip) {
        this.f2822a = chip;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        f fVar = this.f2822a.f2079k;
        if (fVar != null) {
            fVar.getOutline(outline);
        } else {
            outline.setAlpha(0.0f);
        }
    }
}

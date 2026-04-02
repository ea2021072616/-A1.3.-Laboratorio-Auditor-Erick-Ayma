package y0;

import android.content.DialogInterface;
/* loaded from: classes.dex */
public final class i implements DialogInterface.OnMultiChoiceClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f5625a;

    public i(j jVar) {
        this.f5625a = jVar;
    }

    @Override // android.content.DialogInterface.OnMultiChoiceClickListener
    public final void onClick(DialogInterface dialogInterface, int i5, boolean z4) {
        j jVar = this.f5625a;
        if (z4) {
            jVar.F = jVar.E.add(jVar.H[i5].toString()) | jVar.F;
            return;
        }
        jVar.F = jVar.E.remove(jVar.H[i5].toString()) | jVar.F;
    }
}

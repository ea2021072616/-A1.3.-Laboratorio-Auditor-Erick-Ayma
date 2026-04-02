package y4;

import android.content.DialogInterface;
/* loaded from: classes.dex */
public final class f implements DialogInterface.OnCancelListener {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ i f5730g;

    public f(i iVar) {
        this.f5730g = iVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.f5730g.f5734a.a();
    }
}

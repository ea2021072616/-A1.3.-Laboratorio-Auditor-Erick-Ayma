package androidx.biometric;

import android.content.DialogInterface;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class w implements DialogInterface.OnClickListener {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f644g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f645h;

    public /* synthetic */ w(androidx.fragment.app.r rVar, int i5) {
        this.f644g = i5;
        this.f645h = rVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i5) {
        int i6 = this.f644g;
        Object obj = this.f645h;
        switch (i6) {
            case 0:
                WeakReference weakReference = (WeakReference) obj;
                if (weakReference.get() != null) {
                    ((x) weakReference.get()).h(true);
                    return;
                }
                return;
            case 1:
                ((e0) obj).f615y.h(true);
                return;
            default:
                y0.g gVar = (y0.g) obj;
                gVar.E = i5;
                gVar.onClick(dialogInterface, -1);
                dialogInterface.dismiss();
                return;
        }
    }

    public w(x xVar) {
        this.f644g = 0;
        this.f645h = new WeakReference(xVar);
    }
}

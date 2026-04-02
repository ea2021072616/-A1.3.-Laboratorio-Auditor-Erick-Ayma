package s3;

import com.google.android.material.internal.CheckableImageButton;
/* loaded from: classes.dex */
public final class e extends o {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f4877e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(n nVar, int i5) {
        super(nVar);
        this.f4877e = i5;
    }

    @Override // s3.o
    public final void r() {
        switch (this.f4877e) {
            case 0:
                n nVar = this.f4916b;
                nVar.f4909u = null;
                CheckableImageButton checkableImageButton = nVar.f4902m;
                checkableImageButton.setOnLongClickListener(null);
                p2.a.T(checkableImageButton, null);
                return;
            default:
                return;
        }
    }
}

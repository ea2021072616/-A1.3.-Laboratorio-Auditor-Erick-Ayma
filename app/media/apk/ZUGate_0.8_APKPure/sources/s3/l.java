package s3;

import android.text.Editable;
/* loaded from: classes.dex */
public final class l extends j3.j {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ n f4894g;

    public l(n nVar) {
        this.f4894g = nVar;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f4894g.b().a();
    }

    @Override // j3.j, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        this.f4894g.b().b();
    }
}

package androidx.appcompat.widget;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;
/* loaded from: classes.dex */
public final class r0 implements w0, DialogInterface.OnClickListener {

    /* renamed from: g  reason: collision with root package name */
    public d.n f504g;

    /* renamed from: h  reason: collision with root package name */
    public ListAdapter f505h;

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f506i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ x0 f507j;

    public r0(x0 x0Var) {
        this.f507j = x0Var;
    }

    @Override // androidx.appcompat.widget.w0
    public final boolean a() {
        d.n nVar = this.f504g;
        if (nVar != null) {
            return nVar.isShowing();
        }
        return false;
    }

    @Override // androidx.appcompat.widget.w0
    public final void b(int i5) {
        Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    @Override // androidx.appcompat.widget.w0
    public final int c() {
        return 0;
    }

    @Override // androidx.appcompat.widget.w0
    public final void d(int i5, int i6) {
        if (this.f505h == null) {
            return;
        }
        x0 x0Var = this.f507j;
        d.m mVar = new d.m(x0Var.getPopupContext());
        CharSequence charSequence = this.f506i;
        Object obj = mVar.f2398h;
        if (charSequence != null) {
            ((d.i) obj).f2342d = charSequence;
        }
        ListAdapter listAdapter = this.f505h;
        int selectedItemPosition = x0Var.getSelectedItemPosition();
        d.i iVar = (d.i) obj;
        iVar.f2354q = listAdapter;
        iVar.f2355r = this;
        iVar.f2361x = selectedItemPosition;
        iVar.f2360w = true;
        d.n a5 = mVar.a();
        this.f504g = a5;
        AlertController$RecycleListView alertController$RecycleListView = a5.f2414l.f2378g;
        alertController$RecycleListView.setTextDirection(i5);
        alertController$RecycleListView.setTextAlignment(i6);
        this.f504g.show();
    }

    @Override // androidx.appcompat.widget.w0
    public final void dismiss() {
        d.n nVar = this.f504g;
        if (nVar != null) {
            nVar.dismiss();
            this.f504g = null;
        }
    }

    @Override // androidx.appcompat.widget.w0
    public final int e() {
        return 0;
    }

    @Override // androidx.appcompat.widget.w0
    public final Drawable h() {
        return null;
    }

    @Override // androidx.appcompat.widget.w0
    public final CharSequence i() {
        return this.f506i;
    }

    @Override // androidx.appcompat.widget.w0
    public final void k(CharSequence charSequence) {
        this.f506i = charSequence;
    }

    @Override // androidx.appcompat.widget.w0
    public final void m(Drawable drawable) {
        Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }

    @Override // androidx.appcompat.widget.w0
    public final void n(int i5) {
        Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    @Override // androidx.appcompat.widget.w0
    public final void o(ListAdapter listAdapter) {
        this.f505h = listAdapter;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i5) {
        x0 x0Var = this.f507j;
        x0Var.setSelection(i5);
        if (x0Var.getOnItemClickListener() != null) {
            x0Var.performItemClick(null, i5, this.f505h.getItemId(i5));
        }
        dismiss();
    }

    @Override // androidx.appcompat.widget.w0
    public final void p(int i5) {
        Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }
}

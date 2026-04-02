package h;

import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.e2;
/* loaded from: classes.dex */
public final class b extends e2 {

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ ActionMenuItemView f2959p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ActionMenuItemView actionMenuItemView) {
        super(actionMenuItemView);
        this.f2959p = actionMenuItemView;
    }

    @Override // androidx.appcompat.widget.e2
    public final e0 b() {
        androidx.appcompat.widget.i iVar;
        c cVar = this.f2959p.f133s;
        if (cVar == null || (iVar = ((androidx.appcompat.widget.j) cVar).f392a.f432z) == null) {
            return null;
        }
        return iVar.a();
    }

    @Override // androidx.appcompat.widget.e2
    public final boolean c() {
        e0 b5;
        ActionMenuItemView actionMenuItemView = this.f2959p;
        n nVar = actionMenuItemView.f131q;
        return nVar != null && nVar.b(actionMenuItemView.f129n) && (b5 = b()) != null && b5.a();
    }
}

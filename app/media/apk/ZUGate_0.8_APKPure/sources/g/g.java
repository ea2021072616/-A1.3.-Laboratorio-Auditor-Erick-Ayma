package g;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import h.d0;
/* loaded from: classes.dex */
public final class g extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2881a;

    /* renamed from: b  reason: collision with root package name */
    public final b f2882b;

    public g(Context context, b bVar) {
        this.f2881a = context;
        this.f2882b = bVar;
    }

    @Override // android.view.ActionMode
    public final void finish() {
        this.f2882b.a();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f2882b.b();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return new d0(this.f2881a, this.f2882b.e());
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f2882b.f();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f2882b.g();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.f2882b.f2863g;
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f2882b.h();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.f2882b.f2864h;
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f2882b.i();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.f2882b.j();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View view) {
        this.f2882b.k(view);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.f2882b.m(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object obj) {
        this.f2882b.f2863g = obj;
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.f2882b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z4) {
        this.f2882b.p(z4);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int i5) {
        this.f2882b.l(i5);
    }

    @Override // android.view.ActionMode
    public final void setTitle(int i5) {
        this.f2882b.n(i5);
    }
}

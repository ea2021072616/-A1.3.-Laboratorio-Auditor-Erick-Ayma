package androidx.appcompat.widget;
/* loaded from: classes.dex */
public final class a implements h0.l1 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f272a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f273b;

    /* renamed from: c  reason: collision with root package name */
    public Object f274c;

    public a(ActionBarContextView actionBarContextView) {
        this.f274c = actionBarContextView;
    }

    @Override // h0.l1
    public final void a() {
        if (this.f272a) {
            return;
        }
        ActionBarContextView actionBarContextView = (ActionBarContextView) this.f274c;
        actionBarContextView.f170l = null;
        super/*android.view.View*/.setVisibility(this.f273b);
    }

    @Override // h0.l1
    public final void b() {
        this.f272a = true;
    }

    @Override // h0.l1
    public final void c() {
        super/*android.view.View*/.setVisibility(0);
        this.f272a = false;
    }
}

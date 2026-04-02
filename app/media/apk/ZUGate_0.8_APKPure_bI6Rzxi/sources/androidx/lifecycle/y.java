package androidx.lifecycle;
/* loaded from: classes.dex */
public abstract class y {

    /* renamed from: a  reason: collision with root package name */
    public final b0 f1160a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1161b;

    /* renamed from: c  reason: collision with root package name */
    public int f1162c = -1;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ z f1163d;

    public y(z zVar, b0 b0Var) {
        this.f1163d = zVar;
        this.f1160a = b0Var;
    }

    public final void c(boolean z4) {
        if (z4 == this.f1161b) {
            return;
        }
        this.f1161b = z4;
        int i5 = z4 ? 1 : -1;
        z zVar = this.f1163d;
        int i6 = zVar.f1167c;
        zVar.f1167c = i5 + i6;
        if (!zVar.f1168d) {
            zVar.f1168d = true;
            while (true) {
                try {
                    int i7 = zVar.f1167c;
                    if (i6 == i7) {
                        break;
                    }
                    i6 = i7;
                } finally {
                    zVar.f1168d = false;
                }
            }
        }
        if (this.f1161b) {
            zVar.c(this);
        }
    }

    public void d() {
    }

    public boolean e(t tVar) {
        return false;
    }

    public abstract boolean f();
}

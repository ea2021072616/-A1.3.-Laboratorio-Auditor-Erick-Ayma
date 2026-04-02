package androidx.appcompat.widget;
/* loaded from: classes.dex */
public final class x2 {

    /* renamed from: a  reason: collision with root package name */
    public int f588a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f589b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f590c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public int f591d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public int f592e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f593f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f594g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f595h = false;

    public final void a(int i5, int i6) {
        this.f590c = i5;
        this.f591d = i6;
        this.f595h = true;
        if (this.f594g) {
            if (i6 != Integer.MIN_VALUE) {
                this.f588a = i6;
            }
            if (i5 != Integer.MIN_VALUE) {
                this.f589b = i5;
                return;
            }
            return;
        }
        if (i5 != Integer.MIN_VALUE) {
            this.f588a = i5;
        }
        if (i6 != Integer.MIN_VALUE) {
            this.f589b = i6;
        }
    }
}

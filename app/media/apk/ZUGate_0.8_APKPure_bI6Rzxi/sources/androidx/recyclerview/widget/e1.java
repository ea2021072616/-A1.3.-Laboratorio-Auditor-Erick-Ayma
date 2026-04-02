package androidx.recyclerview.widget;
/* loaded from: classes.dex */
public final class e1 {

    /* renamed from: a  reason: collision with root package name */
    public int f1322a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f1323b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f1324c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f1325d = 1;

    /* renamed from: e  reason: collision with root package name */
    public int f1326e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1327f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1328g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1329h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1330i = false;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1331j = false;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1332k = false;

    /* renamed from: l  reason: collision with root package name */
    public int f1333l;

    /* renamed from: m  reason: collision with root package name */
    public long f1334m;

    /* renamed from: n  reason: collision with root package name */
    public int f1335n;

    public final void a(int i5) {
        if ((this.f1325d & i5) != 0) {
            return;
        }
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i5) + " but it is " + Integer.toBinaryString(this.f1325d));
    }

    public final int b() {
        return this.f1328g ? this.f1323b - this.f1324c : this.f1326e;
    }

    public final String toString() {
        return "State{mTargetPosition=" + this.f1322a + ", mData=null, mItemCount=" + this.f1326e + ", mIsMeasuring=" + this.f1330i + ", mPreviousLayoutItemCount=" + this.f1323b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f1324c + ", mStructureChanged=" + this.f1327f + ", mInPreLayout=" + this.f1328g + ", mRunSimpleAnimations=" + this.f1331j + ", mRunPredictiveAnimations=" + this.f1332k + '}';
    }
}

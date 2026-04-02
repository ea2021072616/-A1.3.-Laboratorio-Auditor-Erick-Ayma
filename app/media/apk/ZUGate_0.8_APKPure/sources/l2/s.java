package l2;

import android.app.PendingIntent;
import android.os.Bundle;
/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a  reason: collision with root package name */
    public Object f3886a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3887b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ f f3888c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3889d;

    /* renamed from: e  reason: collision with root package name */
    public final Bundle f3890e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ f f3891f;

    public s(f fVar, int i5, Bundle bundle) {
        this.f3891f = fVar;
        Boolean bool = Boolean.TRUE;
        this.f3888c = fVar;
        this.f3886a = bool;
        this.f3887b = false;
        this.f3889d = i5;
        this.f3890e = bundle;
    }

    public final /* bridge */ void a() {
        f fVar = this.f3891f;
        int i5 = this.f3889d;
        if (i5 != 0) {
            fVar.s(1, null);
            Bundle bundle = this.f3890e;
            b(new i2.a(i5, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        } else if (c()) {
        } else {
            fVar.s(1, null);
            b(new i2.a(8, null));
        }
    }

    public abstract void b(i2.a aVar);

    public abstract boolean c();
}

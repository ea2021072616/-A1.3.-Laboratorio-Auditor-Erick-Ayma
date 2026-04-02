package l2;

import android.app.Activity;
import android.content.Intent;
/* loaded from: classes.dex */
public final class n extends p {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Intent f3872g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Activity f3873h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f3874i = 2;

    public n(Activity activity, Intent intent) {
        this.f3872g = intent;
        this.f3873h = activity;
    }

    @Override // l2.p
    public final void a() {
        Intent intent = this.f3872g;
        if (intent != null) {
            this.f3873h.startActivityForResult(intent, this.f3874i);
        }
    }
}

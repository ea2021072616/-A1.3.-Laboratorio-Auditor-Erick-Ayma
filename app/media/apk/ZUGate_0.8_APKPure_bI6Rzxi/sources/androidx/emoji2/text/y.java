package androidx.emoji2.text;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import ru.zdevs.zugate.MainActivity;
/* loaded from: classes.dex */
public final class y extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f802a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f803b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y(Object obj, Handler handler, int i5) {
        super(handler);
        this.f802a = i5;
        this.f803b = obj;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z4) {
        switch (this.f802a) {
            case 1:
                int i5 = MainActivity.f4551q;
                ((MainActivity) this.f803b).j();
                return;
            default:
                super.onChange(z4);
                return;
        }
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z4, Uri uri) {
        switch (this.f802a) {
            case 0:
                ((z) this.f803b).c();
                return;
            default:
                super.onChange(z4, uri);
                return;
        }
    }
}

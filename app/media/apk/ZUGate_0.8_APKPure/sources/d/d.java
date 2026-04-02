package d;

import android.content.res.TypedArray;
import android.os.Message;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.k3;
import androidx.preference.Preference;
/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f2317g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f2318h;

    public /* synthetic */ d(int i5, Object obj) {
        this.f2317g = i5;
        this.f2318h = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Message message;
        Message message2;
        Message message3;
        Message message4 = null;
        message4 = null;
        int i5 = this.f2317g;
        Object obj = this.f2318h;
        switch (i5) {
            case 0:
                l lVar = (l) obj;
                if (view == lVar.f2382k && (message3 = lVar.f2384m) != null) {
                    message4 = Message.obtain(message3);
                } else if (view == lVar.o && (message2 = lVar.f2387q) != null) {
                    message4 = Message.obtain(message2);
                } else if (view == lVar.f2389s && (message = lVar.f2391u) != null) {
                    message4 = Message.obtain(message);
                }
                if (message4 != null) {
                    message4.sendToTarget();
                }
                lVar.L.obtainMessage(1, lVar.f2373b).sendToTarget();
                return;
            case 1:
                k3 k3Var = ((Toolbar) obj).S;
                h.q qVar = k3Var != null ? k3Var.f400h : null;
                if (qVar != null) {
                    qVar.collapseActionView();
                    return;
                }
                return;
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                ((Preference) obj).t(view);
                return;
            case 3:
                y4.a aVar = (y4.a) obj;
                if (aVar.f5712p && aVar.isShowing()) {
                    if (!aVar.f5714r) {
                        TypedArray obtainStyledAttributes = aVar.getContext().obtainStyledAttributes(new int[]{16843611});
                        aVar.f5713q = obtainStyledAttributes.getBoolean(0, true);
                        obtainStyledAttributes.recycle();
                        aVar.f5714r = true;
                    }
                    if (aVar.f5713q) {
                        aVar.cancel();
                        return;
                    }
                    return;
                }
                return;
            default:
                com.google.android.material.datepicker.l lVar2 = (com.google.android.material.datepicker.l) obj;
                int i6 = lVar2.f2128k;
                if (i6 == 2) {
                    lVar2.h(1);
                    return;
                } else if (i6 == 1) {
                    lVar2.h(2);
                    return;
                } else {
                    return;
                }
        }
    }
}

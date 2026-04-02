package d;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.preference.PreferenceScreen;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class j extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2366a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final Object f2367b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(y0.s sVar, Looper looper) {
        super(looper);
        this.f2367b = sVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i5 = this.f2366a;
        Object obj = this.f2367b;
        switch (i5) {
            case 0:
                int i6 = message.what;
                if (i6 == -3 || i6 == -2 || i6 == -1) {
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) ((WeakReference) obj).get(), message.what);
                    return;
                } else if (i6 != 1) {
                    return;
                } else {
                    ((DialogInterface) message.obj).dismiss();
                    return;
                }
            default:
                if (message.what != 1) {
                    return;
                }
                y0.s sVar = (y0.s) obj;
                PreferenceScreen preferenceScreen = sVar.f5637h.f5590g;
                if (preferenceScreen != null) {
                    sVar.f5638i.setAdapter(new y0.v(preferenceScreen));
                    preferenceScreen.k();
                    return;
                }
                return;
        }
    }

    public j(DialogInterface dialogInterface) {
        this.f2367b = new WeakReference(dialogInterface);
    }
}

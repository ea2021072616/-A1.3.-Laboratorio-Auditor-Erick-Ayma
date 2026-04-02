package n2;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import androidx.appcompat.widget.b0;
import androidx.viewpager.widget.l;
import j2.g;
import l2.f;
/* loaded from: classes.dex */
public final class c extends p2.a {

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f4086u;

    @Override // p2.a
    public final f f(Context context, Looper looper, l2.c cVar, j2.a aVar, j2.f fVar, g gVar) {
        int i5 = this.f4086u;
        switch (i5) {
            case 1:
                t2.a aVar2 = (t2.a) aVar;
                Integer num = cVar.f3772g;
                Bundle bundle = new Bundle();
                bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", cVar.f3766a);
                if (num != null) {
                    bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
                }
                bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
                bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
                bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
                bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
                bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
                bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
                return new u2.a(context, looper, cVar, bundle, fVar, gVar);
            case l.SCROLL_STATE_SETTLING /* 2 */:
                b0.l(aVar);
                throw null;
            default:
                switch (i5) {
                    case 0:
                        return new e(context, looper, cVar, (l2.l) aVar, fVar, gVar);
                    default:
                        throw new UnsupportedOperationException("buildClient must be implemented");
                }
        }
    }
}

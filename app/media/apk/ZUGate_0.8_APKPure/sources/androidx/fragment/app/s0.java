package androidx.fragment.app;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.ComponentActivity;
/* loaded from: classes.dex */
public final class s0 extends b.a {
    @Override // b.a
    public final Intent a(ComponentActivity componentActivity, Object obj) {
        Bundle bundleExtra;
        androidx.activity.result.k kVar = (androidx.activity.result.k) obj;
        Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
        Intent intent2 = kVar.f104c;
        if (intent2 != null && (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
            intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                IntentSender intentSender = kVar.f103b;
                e4.e.f(intentSender, "intentSender");
                kVar = new androidx.activity.result.k(intentSender, null, kVar.f105d, kVar.f106e);
            }
        }
        intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", kVar);
        if (w0.I(2)) {
            Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
        }
        return intent;
    }

    @Override // b.a
    public final Object c(Intent intent, int i5) {
        return new androidx.activity.result.b(intent, i5);
    }
}

package b;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.activity.result.k;
import e4.e;
/* loaded from: classes.dex */
public final class d extends a {
    @Override // b.a
    public final Intent a(ComponentActivity componentActivity, Object obj) {
        k kVar = (k) obj;
        e.f(componentActivity, "context");
        e.f(kVar, "input");
        Intent putExtra = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", kVar);
        e.e(putExtra, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
        return putExtra;
    }

    @Override // b.a
    public final Object c(Intent intent, int i5) {
        return new androidx.activity.result.b(intent, i5);
    }
}

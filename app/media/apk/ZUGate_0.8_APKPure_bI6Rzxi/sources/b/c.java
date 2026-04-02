package b;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import e4.e;
/* loaded from: classes.dex */
public final class c extends a {
    @Override // b.a
    public final Intent a(ComponentActivity componentActivity, Object obj) {
        Intent intent = (Intent) obj;
        e.f(componentActivity, "context");
        e.f(intent, "input");
        return intent;
    }

    @Override // b.a
    public final Object c(Intent intent, int i5) {
        return new androidx.activity.result.b(intent, i5);
    }
}

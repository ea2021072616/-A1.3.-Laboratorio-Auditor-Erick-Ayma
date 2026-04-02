package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.b0;
/* loaded from: classes.dex */
public final class i extends androidx.activity.result.h {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f60h;

    public i(ComponentActivity componentActivity) {
        this.f60h = componentActivity;
    }

    @Override // androidx.activity.result.h
    public final void b(int i5, b.a aVar, Object obj) {
        Bundle bundle;
        ComponentActivity componentActivity = this.f60h;
        b0 b5 = aVar.b(componentActivity, obj);
        if (b5 != null) {
            new Handler(Looper.getMainLooper()).post(new h(this, i5, b5, 0));
            return;
        }
        Intent a5 = aVar.a(componentActivity, obj);
        if (a5.getExtras() != null && a5.getExtras().getClassLoader() == null) {
            a5.setExtrasClassLoader(componentActivity.getClassLoader());
        }
        if (a5.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            Bundle bundleExtra = a5.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            a5.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            bundle = bundleExtra;
        } else {
            bundle = null;
        }
        if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a5.getAction())) {
            String[] stringArrayExtra = a5.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            w.h.c0(componentActivity, stringArrayExtra, i5);
        } else if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a5.getAction())) {
            componentActivity.startActivityForResult(a5, i5, bundle);
        } else {
            androidx.activity.result.k kVar = (androidx.activity.result.k) a5.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                componentActivity.startIntentSenderForResult(kVar.f103b, i5, kVar.f104c, kVar.f105d, kVar.f106e, 0, bundle);
            } catch (IntentSender.SendIntentException e5) {
                new Handler(Looper.getMainLooper()).post(new h(this, i5, e5, 1));
            }
        }
    }
}

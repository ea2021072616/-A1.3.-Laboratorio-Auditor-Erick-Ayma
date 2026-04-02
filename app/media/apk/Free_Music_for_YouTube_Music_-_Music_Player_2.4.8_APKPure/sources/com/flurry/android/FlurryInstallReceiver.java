package com.flurry.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.flurry.sdk.hs;
import com.flurry.sdk.km;
import com.flurry.sdk.ly;
/* loaded from: classes.dex */
public final class FlurryInstallReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1798a = FlurryInstallReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        km.a(4, f1798a, "Received an Install notification of " + intent.getAction());
        String string = intent.getExtras().getString("referrer");
        km.a(4, f1798a, "Received an Install referrer of " + string);
        if (string == null || !"com.android.vending.INSTALL_REFERRER".equals(intent.getAction())) {
            km.a(5, f1798a, "referrer is null");
            return;
        }
        if (!string.contains("=")) {
            km.a(4, f1798a, "referrer is before decoding: " + string);
            string = ly.h(string);
            km.a(4, f1798a, "referrer is: " + string);
        }
        new hs(context).a(string);
    }
}

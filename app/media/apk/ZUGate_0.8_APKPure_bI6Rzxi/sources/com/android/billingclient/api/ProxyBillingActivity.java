package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.internal.play_billing.s;
@UsedByReflection("PlatformActivityProxy")
/* loaded from: classes.dex */
public class ProxyBillingActivity extends Activity {

    /* renamed from: g  reason: collision with root package name */
    public ResultReceiver f1791g;

    /* renamed from: h  reason: collision with root package name */
    public ResultReceiver f1792h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1793i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1794j;

    public final Intent a() {
        Intent intent = new Intent("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0091  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onActivityResult(int r8, int r9, android.content.Intent r10) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.ProxyBillingActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        int i5;
        PendingIntent pendingIntent;
        int i6;
        super.onCreate(bundle);
        if (bundle != null) {
            s.d("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
            this.f1793i = bundle.getBoolean("send_cancelled_broadcast_if_finished", false);
            if (bundle.containsKey("result_receiver")) {
                this.f1791g = (ResultReceiver) bundle.getParcelable("result_receiver");
            } else if (bundle.containsKey("in_app_message_result_receiver")) {
                this.f1792h = (ResultReceiver) bundle.getParcelable("in_app_message_result_receiver");
            }
            this.f1794j = bundle.getBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false);
            return;
        }
        s.d("ProxyBillingActivity", "Launching Play Store billing flow");
        if (getIntent().hasExtra("BUY_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
            if (getIntent().hasExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT") && getIntent().getBooleanExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false)) {
                this.f1794j = true;
                i6 = 110;
                i5 = i6;
            }
            i5 = 100;
        } else if (getIntent().hasExtra("SUBS_MANAGEMENT_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT");
            this.f1791g = (ResultReceiver) getIntent().getParcelableExtra("result_receiver");
            i5 = 100;
        } else if (getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
            this.f1792h = (ResultReceiver) getIntent().getParcelableExtra("in_app_message_result_receiver");
            i6 = 101;
            i5 = i6;
        } else {
            i5 = 100;
            pendingIntent = null;
        }
        try {
            this.f1793i = true;
            startIntentSenderForResult(pendingIntent.getIntentSender(), i5, new Intent(), 0, 0, 0);
        } catch (IntentSender.SendIntentException e5) {
            s.f("ProxyBillingActivity", "Got exception while trying to start a purchase flow.", e5);
            ResultReceiver resultReceiver = this.f1791g;
            if (resultReceiver != null) {
                resultReceiver.send(6, null);
            } else {
                ResultReceiver resultReceiver2 = this.f1792h;
                if (resultReceiver2 != null) {
                    resultReceiver2.send(0, null);
                } else {
                    Intent a5 = a();
                    if (this.f1794j) {
                        a5.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                    }
                    a5.putExtra("RESPONSE_CODE", 6);
                    a5.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                    sendBroadcast(a5);
                }
            }
            this.f1793i = false;
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        if (isFinishing() && this.f1793i) {
            Intent a5 = a();
            a5.putExtra("RESPONSE_CODE", 1);
            a5.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            sendBroadcast(a5);
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.f1791g;
        if (resultReceiver != null) {
            bundle.putParcelable("result_receiver", resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.f1792h;
        if (resultReceiver2 != null) {
            bundle.putParcelable("in_app_message_result_receiver", resultReceiver2);
        }
        bundle.putBoolean("send_cancelled_broadcast_if_finished", this.f1793i);
        bundle.putBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", this.f1794j);
    }
}

package com.android.billingclient.api;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.activity.ComponentActivity;
import androidx.activity.result.c;
import androidx.activity.result.d;
import androidx.activity.result.k;
import com.android.billingclient.api.ProxyBillingActivityV2;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.internal.play_billing.s;
import e4.e;
@UsedByReflection("PlatformActivityProxy")
/* loaded from: classes.dex */
public class ProxyBillingActivityV2 extends ComponentActivity {

    /* renamed from: g  reason: collision with root package name */
    public d f1795g;

    /* renamed from: h  reason: collision with root package name */
    public d f1796h;

    /* renamed from: i  reason: collision with root package name */
    public ResultReceiver f1797i;

    /* renamed from: j  reason: collision with root package name */
    public ResultReceiver f1798j;

    @Override // androidx.activity.ComponentActivity, w.o, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1795g = registerForActivityResult(new b.d(), new c(this) { // from class: h1.v

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ ProxyBillingActivityV2 f3335b;

            {
                this.f3335b = this;
            }

            @Override // androidx.activity.result.c
            public final void a(Object obj) {
                int i5 = r2;
                ProxyBillingActivityV2 proxyBillingActivityV2 = this.f3335b;
                switch (i5) {
                    case 0:
                        androidx.activity.result.b bVar = (androidx.activity.result.b) obj;
                        proxyBillingActivityV2.getClass();
                        Intent intent = bVar.f83c;
                        int i6 = com.google.android.gms.internal.play_billing.s.b(intent, "ProxyBillingActivityV2").f3283b;
                        ResultReceiver resultReceiver = proxyBillingActivityV2.f1797i;
                        if (resultReceiver != null) {
                            resultReceiver.send(i6, intent != null ? intent.getExtras() : null);
                        }
                        int i7 = bVar.f82b;
                        if (i7 != -1 || i6 != 0) {
                            com.google.android.gms.internal.play_billing.s.e("ProxyBillingActivityV2", "Alternative billing only dialog finished with resultCode " + i7 + " and billing's responseCode: " + i6);
                        }
                        proxyBillingActivityV2.finish();
                        return;
                    default:
                        androidx.activity.result.b bVar2 = (androidx.activity.result.b) obj;
                        proxyBillingActivityV2.getClass();
                        Intent intent2 = bVar2.f83c;
                        int i8 = com.google.android.gms.internal.play_billing.s.b(intent2, "ProxyBillingActivityV2").f3283b;
                        ResultReceiver resultReceiver2 = proxyBillingActivityV2.f1798j;
                        if (resultReceiver2 != null) {
                            resultReceiver2.send(i8, intent2 != null ? intent2.getExtras() : null);
                        }
                        int i9 = bVar2.f82b;
                        if (i9 != -1 || i8 != 0) {
                            com.google.android.gms.internal.play_billing.s.e("ProxyBillingActivityV2", String.format("External offer dialog finished with resultCode: %s and billing's responseCode: %s", Integer.valueOf(i9), Integer.valueOf(i8)));
                        }
                        proxyBillingActivityV2.finish();
                        return;
                }
            }
        });
        this.f1796h = registerForActivityResult(new b.d(), new c(this) { // from class: h1.v

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ ProxyBillingActivityV2 f3335b;

            {
                this.f3335b = this;
            }

            @Override // androidx.activity.result.c
            public final void a(Object obj) {
                int i5 = r2;
                ProxyBillingActivityV2 proxyBillingActivityV2 = this.f3335b;
                switch (i5) {
                    case 0:
                        androidx.activity.result.b bVar = (androidx.activity.result.b) obj;
                        proxyBillingActivityV2.getClass();
                        Intent intent = bVar.f83c;
                        int i6 = com.google.android.gms.internal.play_billing.s.b(intent, "ProxyBillingActivityV2").f3283b;
                        ResultReceiver resultReceiver = proxyBillingActivityV2.f1797i;
                        if (resultReceiver != null) {
                            resultReceiver.send(i6, intent != null ? intent.getExtras() : null);
                        }
                        int i7 = bVar.f82b;
                        if (i7 != -1 || i6 != 0) {
                            com.google.android.gms.internal.play_billing.s.e("ProxyBillingActivityV2", "Alternative billing only dialog finished with resultCode " + i7 + " and billing's responseCode: " + i6);
                        }
                        proxyBillingActivityV2.finish();
                        return;
                    default:
                        androidx.activity.result.b bVar2 = (androidx.activity.result.b) obj;
                        proxyBillingActivityV2.getClass();
                        Intent intent2 = bVar2.f83c;
                        int i8 = com.google.android.gms.internal.play_billing.s.b(intent2, "ProxyBillingActivityV2").f3283b;
                        ResultReceiver resultReceiver2 = proxyBillingActivityV2.f1798j;
                        if (resultReceiver2 != null) {
                            resultReceiver2.send(i8, intent2 != null ? intent2.getExtras() : null);
                        }
                        int i9 = bVar2.f82b;
                        if (i9 != -1 || i8 != 0) {
                            com.google.android.gms.internal.play_billing.s.e("ProxyBillingActivityV2", String.format("External offer dialog finished with resultCode: %s and billing's responseCode: %s", Integer.valueOf(i9), Integer.valueOf(i8)));
                        }
                        proxyBillingActivityV2.finish();
                        return;
                }
            }
        });
        if (bundle != null) {
            if (bundle.containsKey("alternative_billing_only_dialog_result_receiver")) {
                this.f1797i = (ResultReceiver) bundle.getParcelable("alternative_billing_only_dialog_result_receiver");
                return;
            } else if (bundle.containsKey("external_payment_dialog_result_receiver")) {
                this.f1798j = (ResultReceiver) bundle.getParcelable("external_payment_dialog_result_receiver");
                return;
            } else {
                return;
            }
        }
        s.d("ProxyBillingActivityV2", "Launching Play Store billing dialog");
        if (getIntent().hasExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT")) {
            PendingIntent pendingIntent = (PendingIntent) getIntent().getParcelableExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT");
            this.f1797i = (ResultReceiver) getIntent().getParcelableExtra("alternative_billing_only_dialog_result_receiver");
            d dVar = this.f1795g;
            e.f(pendingIntent, "pendingIntent");
            IntentSender intentSender = pendingIntent.getIntentSender();
            e.e(intentSender, "pendingIntent.intentSender");
            dVar.a(new k(intentSender, null, 0, 0));
        } else if (getIntent().hasExtra("external_payment_dialog_pending_intent")) {
            PendingIntent pendingIntent2 = (PendingIntent) getIntent().getParcelableExtra("external_payment_dialog_pending_intent");
            this.f1798j = (ResultReceiver) getIntent().getParcelableExtra("external_payment_dialog_result_receiver");
            d dVar2 = this.f1796h;
            e.f(pendingIntent2, "pendingIntent");
            IntentSender intentSender2 = pendingIntent2.getIntentSender();
            e.e(intentSender2, "pendingIntent.intentSender");
            dVar2.a(new k(intentSender2, null, 0, 0));
        }
    }

    @Override // androidx.activity.ComponentActivity, w.o, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.f1797i;
        if (resultReceiver != null) {
            bundle.putParcelable("alternative_billing_only_dialog_result_receiver", resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.f1798j;
        if (resultReceiver2 != null) {
            bundle.putParcelable("external_payment_dialog_result_receiver", resultReceiver2);
        }
    }
}

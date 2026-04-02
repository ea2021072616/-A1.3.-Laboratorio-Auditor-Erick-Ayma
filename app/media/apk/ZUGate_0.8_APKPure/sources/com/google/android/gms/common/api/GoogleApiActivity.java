package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.play_billing.i0;
import i2.a;
import k2.d;
@KeepName
/* loaded from: classes.dex */
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ int f1821h = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f1822g = 0;

    @Override // android.app.Activity
    public final void onActivityResult(int i5, int i6, Intent intent) {
        super.onActivityResult(i5, i6, intent);
        if (i5 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f1822g = 0;
            setResult(i6, intent);
            if (booleanExtra) {
                d e5 = d.e(this);
                if (i6 == -1) {
                    r2.d dVar = e5.f3589m;
                    dVar.sendMessage(dVar.obtainMessage(3));
                } else if (i6 == 0) {
                    e5.f(new a(13, null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i5 == 2) {
            this.f1822g = 0;
            setResult(i6, intent);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.f1822g = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f1822g = bundle.getInt("resolution");
        }
        if (this.f1822g != 1) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                Log.e("GoogleApiActivity", "Activity started without extras");
                finish();
                return;
            }
            PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
            Integer num = (Integer) extras.get("error_code");
            if (pendingIntent == null && num == null) {
                Log.e("GoogleApiActivity", "Activity started without resolution");
                finish();
            } else if (pendingIntent == null) {
                i0.j(num);
                i2.d.f3391c.d(this, num.intValue(), this);
                this.f1822g = 1;
            } else {
                try {
                    startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                    this.f1822g = 1;
                } catch (ActivityNotFoundException e5) {
                    if (extras.getBoolean("notify_manager", true)) {
                        d.e(this).f(new a(22, null), getIntent().getIntExtra("failing_client_id", -1));
                    } else {
                        String str = "Activity not found while launching " + pendingIntent.toString() + ".";
                        if (Build.FINGERPRINT.contains("generic")) {
                            str = str.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                        }
                        Log.e("GoogleApiActivity", str, e5);
                    }
                    this.f1822g = 1;
                    finish();
                } catch (IntentSender.SendIntentException e6) {
                    Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e6);
                    finish();
                }
            }
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f1822g);
        super.onSaveInstanceState(bundle);
    }
}

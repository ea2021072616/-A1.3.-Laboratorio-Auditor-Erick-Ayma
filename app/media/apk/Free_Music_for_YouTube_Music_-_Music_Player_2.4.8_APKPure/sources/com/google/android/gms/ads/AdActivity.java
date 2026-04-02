package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzaji;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzxg;
@KeepForSdkWithMembers
/* loaded from: classes.dex */
public class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private zzxg zzako;

    private final void zzay() {
        if (this.zzako != null) {
            try {
                this.zzako.zzay();
            } catch (RemoteException e) {
                zzaji.zzc("Could not forward setContentViewSet to ad overlay:", e);
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.zzako.onActivityResult(i, i2, intent);
        } catch (Exception e) {
            zzaji.zzc("Could not forward onActivityResult to ad overlay:", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        boolean z = true;
        try {
            if (this.zzako != null) {
                z = this.zzako.zzmn();
            }
        } catch (RemoteException e) {
            zzaji.zzc("Could not forward onBackPressed to ad overlay:", e);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.zzako.zzo(zzn.zzw(configuration));
        } catch (RemoteException e) {
            zzaji.zzc("Failed to wrap configuration.", e);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzako = zzjo.zzhv().zzb(this);
        if (this.zzako == null) {
            zzaji.zzcs("Could not create ad overlay.");
            finish();
            return;
        }
        try {
            this.zzako.onCreate(bundle);
        } catch (RemoteException e) {
            zzaji.zzc("Could not forward onCreate to ad overlay:", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            if (this.zzako != null) {
                this.zzako.onDestroy();
            }
        } catch (RemoteException e) {
            zzaji.zzc("Could not forward onDestroy to ad overlay:", e);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        try {
            if (this.zzako != null) {
                this.zzako.onPause();
            }
        } catch (RemoteException e) {
            zzaji.zzc("Could not forward onPause to ad overlay:", e);
            finish();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        try {
            if (this.zzako != null) {
                this.zzako.onRestart();
            }
        } catch (RemoteException e) {
            zzaji.zzc("Could not forward onRestart to ad overlay:", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        try {
            if (this.zzako != null) {
                this.zzako.onResume();
            }
        } catch (RemoteException e) {
            zzaji.zzc("Could not forward onResume to ad overlay:", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.zzako != null) {
                this.zzako.onSaveInstanceState(bundle);
            }
        } catch (RemoteException e) {
            zzaji.zzc("Could not forward onSaveInstanceState to ad overlay:", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        try {
            if (this.zzako != null) {
                this.zzako.onStart();
            }
        } catch (RemoteException e) {
            zzaji.zzc("Could not forward onStart to ad overlay:", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        try {
            if (this.zzako != null) {
                this.zzako.onStop();
            }
        } catch (RemoteException e) {
            zzaji.zzc("Could not forward onStop to ad overlay:", e);
            finish();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        super.setContentView(i);
        zzay();
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        super.setContentView(view);
        zzay();
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zzay();
    }
}

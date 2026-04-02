package pub.devrel.easypermissions;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.RestrictTo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class AppSettingsDialogHolderActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private AlertDialog f5205a;

    public static Intent a(Context context, AppSettingsDialog appSettingsDialog) {
        return new Intent(context, AppSettingsDialogHolderActivity.class).putExtra("extra_app_settings", appSettingsDialog);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AppSettingsDialog appSettingsDialog = (AppSettingsDialog) getIntent().getParcelableExtra("extra_app_settings");
        appSettingsDialog.setContext(this);
        appSettingsDialog.setActivityOrFragment(this);
        appSettingsDialog.setNegativeListener(this);
        this.f5205a = appSettingsDialog.showDialog();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f5205a != null && this.f5205a.isShowing()) {
            this.f5205a.dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        setResult(i2, intent);
        finish();
    }
}

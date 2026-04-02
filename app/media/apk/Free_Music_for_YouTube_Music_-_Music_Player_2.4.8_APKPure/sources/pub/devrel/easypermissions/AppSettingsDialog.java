package pub.devrel.easypermissions;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class AppSettingsDialog implements DialogInterface.OnClickListener, Parcelable {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<AppSettingsDialog> CREATOR = new Parcelable.Creator<AppSettingsDialog>() { // from class: pub.devrel.easypermissions.AppSettingsDialog.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppSettingsDialog createFromParcel(Parcel parcel) {
            return new AppSettingsDialog(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppSettingsDialog[] newArray(int i) {
            return new AppSettingsDialog[i];
        }
    };
    public static final int DEFAULT_SETTINGS_REQ_CODE = 16061;
    static final String EXTRA_APP_SETTINGS = "extra_app_settings";
    private Object mActivityOrFragment;
    private Context mContext;
    private final String mNegativeButtonText;
    private DialogInterface.OnClickListener mNegativeListener;
    private final String mPositiveButtonText;
    private final String mRationale;
    private final int mRequestCode;
    private final String mTitle;

    private AppSettingsDialog(Parcel parcel) {
        this.mRationale = parcel.readString();
        this.mTitle = parcel.readString();
        this.mPositiveButtonText = parcel.readString();
        this.mNegativeButtonText = parcel.readString();
        this.mRequestCode = parcel.readInt();
    }

    private AppSettingsDialog(@NonNull Object obj, @NonNull Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable DialogInterface.OnClickListener onClickListener, int i) {
        this.mActivityOrFragment = obj;
        this.mContext = context;
        this.mRationale = str;
        this.mTitle = str2;
        this.mPositiveButtonText = str3;
        this.mNegativeButtonText = str4;
        this.mNegativeListener = onClickListener;
        this.mRequestCode = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setActivityOrFragment(Object obj) {
        this.mActivityOrFragment = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setContext(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNegativeListener(DialogInterface.OnClickListener onClickListener) {
        this.mNegativeListener = onClickListener;
    }

    @RequiresApi(api = 11)
    private void startForResult(Intent intent) {
        if (this.mActivityOrFragment instanceof Activity) {
            ((Activity) this.mActivityOrFragment).startActivityForResult(intent, this.mRequestCode);
        } else if (this.mActivityOrFragment instanceof Fragment) {
            ((Fragment) this.mActivityOrFragment).startActivityForResult(intent, this.mRequestCode);
        } else if (this.mActivityOrFragment instanceof android.app.Fragment) {
            ((android.app.Fragment) this.mActivityOrFragment).startActivityForResult(intent, this.mRequestCode);
        }
    }

    public void show() {
        if (this.mNegativeListener == null) {
            startForResult(AppSettingsDialogHolderActivity.a(this.mContext, this));
        } else {
            showDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlertDialog showDialog() {
        return new AlertDialog.Builder(this.mContext).setCancelable(false).setTitle(this.mTitle).setMessage(this.mRationale).setPositiveButton(this.mPositiveButtonText, this).setNegativeButton(this.mNegativeButtonText, this.mNegativeListener).show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.mContext.getPackageName(), null));
        startForResult(intent);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.mRationale);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mPositiveButtonText);
        parcel.writeString(this.mNegativeButtonText);
        parcel.writeInt(this.mRequestCode);
    }

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Object f5202a;

        /* renamed from: b  reason: collision with root package name */
        private Context f5203b;

        /* renamed from: c  reason: collision with root package name */
        private String f5204c;
        private String d;
        private String e;
        private String f;
        private DialogInterface.OnClickListener g;
        private int h = -1;

        public a(@NonNull Activity activity) {
            this.f5202a = activity;
            this.f5203b = activity;
        }

        public AppSettingsDialog a() {
            this.f5204c = TextUtils.isEmpty(this.f5204c) ? this.f5203b.getString(R.string.rationale_ask_again) : this.f5204c;
            this.d = TextUtils.isEmpty(this.d) ? this.f5203b.getString(R.string.title_settings_dialog) : this.d;
            this.e = TextUtils.isEmpty(this.e) ? this.f5203b.getString(17039370) : this.e;
            this.f = TextUtils.isEmpty(this.f) ? this.f5203b.getString(17039360) : this.f;
            this.h = this.h > 0 ? this.h : AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE;
            return new AppSettingsDialog(this.f5202a, this.f5203b, this.f5204c, this.d, this.e, this.f, this.g, this.h);
        }
    }
}

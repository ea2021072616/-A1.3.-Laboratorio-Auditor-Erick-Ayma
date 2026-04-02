package com.yanzhenjie.album.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.R;
import com.yanzhenjie.album.util.AlbumUtils;
import com.yanzhenjie.album.util.PermissionUtils;
import com.yanzhenjie.statusview.a;
import java.io.File;
/* loaded from: classes2.dex */
public class CameraActivity extends Activity {
    private static final String INSTANCE_CAMERA_BYTES = "INSTANCE_CAMERA_BYTES";
    private static final String INSTANCE_CAMERA_DURATION = "INSTANCE_CAMERA_DURATION";
    private static final String INSTANCE_CAMERA_FILE_PATH = "INSTANCE_CAMERA_FILE_PATH";
    private static final String INSTANCE_CAMERA_FUNCTION = "INSTANCE_CAMERA_FUNCTION";
    private static final String INSTANCE_CAMERA_QUALITY = "INSTANCE_CAMERA_QUALITY";
    private static final String INSTANCE_CAMERA_REQUEST_CODE = "INSTANCE_CAMERA_REQUEST_CODE";
    private static final int PERMISSION_IMAGE = 1;
    private static final int PERMISSION_VIDEO = 2;
    private static final int REQUEST_CODE_CAMERA_IMAGE = 1;
    private static final int REQUEST_CODE_CAMERA_VIDEO = 2;
    public static Action<String> sCancel;
    public static Action<String> sResult;
    private String mCameraFilePath;
    private int mFunction;
    @IntRange(from = 1, to = Long.MAX_VALUE)
    private long mLimitBytes;
    @IntRange(from = 1, to = Long.MAX_VALUE)
    private long mLimitDuration;
    @IntRange(from = MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED, to = 1)
    private int mQuality = 1;
    private int mRequestCode;

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        a.a(this, 0);
        AlbumUtils.applyLanguageForContext(this, Album.getAlbumConfig().getLocale());
        if (bundle != null && bundle.containsKey(INSTANCE_CAMERA_FUNCTION) && bundle.containsKey(INSTANCE_CAMERA_REQUEST_CODE) && bundle.containsKey(INSTANCE_CAMERA_FILE_PATH)) {
            this.mFunction = bundle.getInt(INSTANCE_CAMERA_FUNCTION);
            this.mRequestCode = bundle.getInt(INSTANCE_CAMERA_REQUEST_CODE);
            this.mCameraFilePath = bundle.getString(INSTANCE_CAMERA_FILE_PATH);
            this.mQuality = bundle.getInt(INSTANCE_CAMERA_QUALITY, 1);
            this.mLimitDuration = bundle.getLong(INSTANCE_CAMERA_DURATION, Long.MAX_VALUE);
            this.mLimitBytes = bundle.getLong(INSTANCE_CAMERA_BYTES, Long.MAX_VALUE);
            return;
        }
        Intent intent = getIntent();
        this.mFunction = intent.getIntExtra(Album.KEY_INPUT_FUNCTION, 0);
        this.mRequestCode = intent.getIntExtra(Album.KEY_INPUT_REQUEST_CODE, 0);
        this.mCameraFilePath = intent.getStringExtra(Album.KEY_INPUT_FILE_PATH);
        this.mQuality = intent.getIntExtra(Album.KEY_INPUT_CAMERA_QUALITY, 1);
        this.mLimitDuration = intent.getLongExtra(Album.KEY_INPUT_CAMERA_DURATION, Long.MAX_VALUE);
        this.mLimitBytes = intent.getLongExtra(Album.KEY_INPUT_CAMERA_BYTES, Long.MAX_VALUE);
        switch (this.mFunction) {
            case 0:
                if (TextUtils.isEmpty(this.mCameraFilePath)) {
                    this.mCameraFilePath = AlbumUtils.randomJPGPath();
                }
                requestPermission(1);
                return;
            case 1:
                if (TextUtils.isEmpty(this.mCameraFilePath)) {
                    this.mCameraFilePath = AlbumUtils.randomMP4Path();
                }
                requestPermission(2);
                return;
            default:
                onCameraCancel();
                return;
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(INSTANCE_CAMERA_FUNCTION, this.mFunction);
        bundle.putInt(INSTANCE_CAMERA_REQUEST_CODE, this.mRequestCode);
        bundle.putString(INSTANCE_CAMERA_FILE_PATH, this.mCameraFilePath);
        bundle.putInt(INSTANCE_CAMERA_QUALITY, this.mQuality);
        bundle.putLong(INSTANCE_CAMERA_DURATION, this.mLimitDuration);
        bundle.putLong(INSTANCE_CAMERA_BYTES, this.mLimitBytes);
        super.onSaveInstanceState(bundle);
    }

    private void requestPermission(int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            String[] deniedPermissions = PermissionUtils.getDeniedPermissions(this, this.mFunction == 0 ? new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA"} : new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA", "android.permission.RECORD_AUDIO"});
            if (deniedPermissions.length == 0) {
                dispatchGrantedPermission(i);
                return;
            } else {
                ActivityCompat.requestPermissions(this, deniedPermissions, i);
                return;
            }
        }
        dispatchGrantedPermission(i);
    }

    private void dispatchGrantedPermission(int i) {
        switch (i) {
            case 1:
                AlbumUtils.imageCapture(this, 1, new File(this.mCameraFilePath));
                return;
            case 2:
                AlbumUtils.videoCapture(this, 2, new File(this.mCameraFilePath), this.mQuality, this.mLimitDuration, this.mLimitBytes);
                return;
            default:
                onCameraCancel();
                return;
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 1:
            case 2:
                if (!PermissionUtils.isGrantedResult(iArr)) {
                    albumPermissionDenied();
                    return;
                } else {
                    dispatchGrantedPermission(i);
                    return;
                }
            default:
                onCameraCancel();
                return;
        }
    }

    private void albumPermissionDenied() {
        int i;
        switch (this.mFunction) {
            case 0:
                i = R.string.album_permission_camera_image_failed_hint;
                break;
            case 1:
                i = R.string.album_permission_camera_video_failed_hint;
                break;
            default:
                onCameraCancel();
                return;
        }
        new AlertDialog.Builder(this).setCancelable(false).setTitle(R.string.album_title_permission_failed).setMessage(i).setPositiveButton(R.string.album_dialog_sure, new DialogInterface.OnClickListener() { // from class: com.yanzhenjie.album.ui.CameraActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                CameraActivity.this.onCameraCancel();
            }
        }).show();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
            case 2:
                if (i2 == -1) {
                    onCameraResult();
                    return;
                } else {
                    onCameraCancel();
                    return;
                }
            default:
                onCameraCancel();
                return;
        }
    }

    private void onCameraResult() {
        if (sResult != null) {
            sResult.onAction(this.mRequestCode, this.mCameraFilePath);
        }
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCameraCancel() {
        if (sCancel != null) {
            sCancel.onAction(this.mRequestCode, "User canceled.");
        }
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        sResult = null;
        sCancel = null;
        super.onDestroy();
    }
}

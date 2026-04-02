package com.yanzhenjie.album.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.Filter;
import com.yanzhenjie.album.R;
import com.yanzhenjie.album.api.widget.Widget;
import com.yanzhenjie.album.impl.AlbumCallback;
import com.yanzhenjie.album.task.ThumbnailBuildTask;
import com.yanzhenjie.album.util.AlbumUtils;
import com.yanzhenjie.album.util.DisplayUtils;
import com.yanzhenjie.album.util.PermissionUtils;
import com.yanzhenjie.fragment.CompatActivity;
import com.yanzhenjie.statusview.a;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AlbumActivity extends CompatActivity implements AlbumCallback {
    private static final int PERMISSION_STORAGE_ALBUM = 1;
    private static final int PERMISSION_STORAGE_IMAGE = 2;
    private static final int PERMISSION_STORAGE_VIDEO = 3;
    public static Filter<Long> mDurationFilter;
    public static Filter<String> mMimeFilter;
    public static Filter<Long> mSizeFilter;
    public static Action<String> sCancel;
    public static Action<ArrayList<AlbumFile>> sResult;
    private boolean isSucceedLightStatus = false;
    private Bundle mArgument;
    private int mRequestCode;

    @Override // com.yanzhenjie.fragment.CompatActivity
    protected int fragmentLayoutId() {
        return R.id.album_root_frame_layout;
    }

    @Override // com.yanzhenjie.fragment.CompatActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.a(this);
        a.b(this);
        DisplayUtils.initScreen(this);
        AlbumUtils.applyLanguageForContext(this, Album.getAlbumConfig().getLocale());
        setContentView(R.layout.album_activity_main);
        Intent intent = getIntent();
        initializeWidget();
        this.mArgument = intent.getExtras();
        this.mRequestCode = intent.getIntExtra(Album.KEY_INPUT_REQUEST_CODE, 0);
        switch (intent.getIntExtra(Album.KEY_INPUT_FUNCTION, 2)) {
            case 0:
            case 1:
            case 2:
                requestPermission(3);
                return;
            default:
                onAlbumCancel();
                return;
        }
    }

    private void initializeWidget() {
        Widget widget = (Widget) getIntent().getParcelableExtra(Album.KEY_INPUT_WIDGET);
        int navigationBarColor = widget.getNavigationBarColor();
        if (widget.getStyle() == 1 && a.a((Activity) this, true)) {
            this.isSucceedLightStatus = true;
        }
        a.b(this, navigationBarColor);
    }

    public boolean isSucceedLightStatus() {
        return this.isSucceedLightStatus;
    }

    private void requestPermission(int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            String[] deniedPermissions = PermissionUtils.getDeniedPermissions(this, "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE");
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
            case 2:
            case 3:
                AlbumFragment albumFragment = (AlbumFragment) fragment(AlbumFragment.class, this.mArgument);
                albumFragment.setSizeFilter(mSizeFilter);
                albumFragment.setMimeFilter(mMimeFilter);
                albumFragment.setDurationFilter(mDurationFilter);
                startFragment((AlbumActivity) albumFragment);
                return;
            default:
                return;
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 1:
            case 2:
            case 3:
                if (!PermissionUtils.isGrantedResult(iArr)) {
                    albumPermissionDenied();
                    return;
                } else {
                    dispatchGrantedPermission(i);
                    return;
                }
            default:
                return;
        }
    }

    private void albumPermissionDenied() {
        new AlertDialog.Builder(this).setCancelable(false).setTitle(R.string.album_title_permission_failed).setMessage(R.string.album_permission_storage_failed_hint).setPositiveButton(R.string.album_dialog_sure, new DialogInterface.OnClickListener() { // from class: com.yanzhenjie.album.ui.AlbumActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AlbumActivity.this.onAlbumCancel();
            }
        }).show();
    }

    @Override // com.yanzhenjie.fragment.CompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (!onBackStackFragment()) {
            onAlbumCancel();
        }
    }

    @Override // com.yanzhenjie.album.impl.AlbumCallback
    public void onAlbumResult(ArrayList<AlbumFile> arrayList) {
        new ThumbnailBuildTask(this, arrayList, new ThumbnailBuildTask.Callback() { // from class: com.yanzhenjie.album.ui.AlbumActivity.2
            @Override // com.yanzhenjie.album.task.ThumbnailBuildTask.Callback
            public void onThumbnailCallback(ArrayList<AlbumFile> arrayList2) {
                if (AlbumActivity.sResult != null) {
                    AlbumActivity.sResult.onAction(AlbumActivity.this.mRequestCode, arrayList2);
                }
                AlbumActivity.this.setResult(-1);
                AlbumActivity.this.finish();
            }
        }).execute(new Void[0]);
    }

    @Override // com.yanzhenjie.album.impl.AlbumCallback
    public void onAlbumCancel() {
        if (sCancel != null) {
            sCancel.onAction(this.mRequestCode, "User canceled.");
        }
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        mSizeFilter = null;
        mMimeFilter = null;
        mDurationFilter = null;
        sResult = null;
        sCancel = null;
        super.onDestroy();
    }
}

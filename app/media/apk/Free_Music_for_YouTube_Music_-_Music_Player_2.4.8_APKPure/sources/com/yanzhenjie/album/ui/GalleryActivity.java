package com.yanzhenjie.album.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.R;
import com.yanzhenjie.album.api.widget.Widget;
import com.yanzhenjie.album.ui.adapter.PathPreviewAdapter;
import com.yanzhenjie.album.util.AlbumUtils;
import com.yanzhenjie.album.util.PermissionUtils;
import com.yanzhenjie.statusview.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class GalleryActivity extends AppCompatActivity {
    private static final int PERMISSION_STORAGE = 1;
    private static final String TAG = "AlbumGallery";
    public static Action<String> sCancel;
    public static Action<ArrayList<String>> sResult;
    private AppCompatCheckBox mCheckBox;
    private boolean mCheckable;
    private Map<String, Boolean> mCheckedMap;
    private int mCurrentItemPosition;
    private MenuItem mFinishMenuItem;
    private int mNavigationAlpha;
    private ViewPager.OnPageChangeListener mPageChangeListener = new ViewPager.SimpleOnPageChangeListener() { // from class: com.yanzhenjie.album.ui.GalleryActivity.2
        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            GalleryActivity.this.mCurrentItemPosition = i;
            GalleryActivity.this.mCheckBox.setChecked(((Boolean) GalleryActivity.this.mCheckedMap.get(GalleryActivity.this.mPathList.get(GalleryActivity.this.mCurrentItemPosition))).booleanValue());
            GalleryActivity.this.mToolbar.setSubtitle((GalleryActivity.this.mCurrentItemPosition + 1) + " / " + GalleryActivity.this.mPathList.size());
        }
    };
    private List<String> mPathList;
    private int mRequestCode;
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    @NonNull
    private Widget mWidget;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        a.a(this);
        AlbumUtils.applyLanguageForContext(this, Album.getAlbumConfig().getLocale());
        setContentView(R.layout.album_activity_preview);
        this.mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.mToolbar);
        this.mViewPager = (ViewPager) findViewById(R.id.view_pager);
        this.mCheckBox = (AppCompatCheckBox) findViewById(R.id.cb_album_check);
        Intent intent = getIntent();
        this.mRequestCode = intent.getIntExtra(Album.KEY_INPUT_REQUEST_CODE, 0);
        this.mWidget = (Widget) intent.getParcelableExtra(Album.KEY_INPUT_WIDGET);
        this.mPathList = intent.getStringArrayListExtra(Album.KEY_INPUT_CHECKED_LIST);
        this.mCurrentItemPosition = intent.getIntExtra(Album.KEY_INPUT_CURRENT_POSITION, 0);
        this.mCheckable = intent.getBooleanExtra(Album.KEY_INPUT_GALLERY_CHECKABLE, true);
        this.mNavigationAlpha = intent.getIntExtra(Album.KEY_INPUT_NAVIGATION_ALPHA, 80);
        if (this.mPathList == null) {
            Log.e(TAG, "Parameter error.", new IllegalArgumentException("The checkedList can be null."));
            onGalleryCancel();
        } else if (this.mPathList.size() == 0 || this.mCurrentItemPosition == this.mPathList.size()) {
            Log.e(TAG, "Parameter error.", new IllegalArgumentException("The currentPosition is " + this.mCurrentItemPosition + ", the checkedList.size() is " + this.mPathList.size()));
            onGalleryCancel();
        } else {
            this.mCheckedMap = new HashMap();
            for (String str : this.mPathList) {
                this.mCheckedMap.put(str, true);
            }
            initializeWidget();
            initializePager();
            requestPermission(1);
        }
    }

    private void initializeWidget() {
        int alphaColor = AlbumUtils.getAlphaColor(this.mWidget.getNavigationBarColor(), this.mNavigationAlpha);
        a.b(this);
        a.b(this, alphaColor);
        setTitle(this.mWidget.getTitle());
        if (!this.mCheckable) {
            findViewById(R.id.bottom_root).setVisibility(8);
            return;
        }
        this.mCheckBox.setSupportButtonTintList(this.mWidget.getMediaItemCheckSelector());
        this.mCheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.yanzhenjie.album.ui.GalleryActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GalleryActivity.this.mCheckedMap.put(GalleryActivity.this.mPathList.get(GalleryActivity.this.mCurrentItemPosition), Boolean.valueOf(GalleryActivity.this.mCheckBox.isChecked()));
                GalleryActivity.this.setCheckedCountUI(GalleryActivity.this.getCheckCount());
            }
        });
    }

    private void initializePager() {
        if (this.mPathList != null) {
            if (this.mPathList.size() > 3) {
                this.mViewPager.setOffscreenPageLimit(3);
            } else if (this.mPathList.size() > 2) {
                this.mViewPager.setOffscreenPageLimit(2);
            }
        }
        this.mViewPager.addOnPageChangeListener(this.mPageChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCheckCount() {
        int i = 0;
        Iterator<Map.Entry<String, Boolean>> it = this.mCheckedMap.entrySet().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().getValue().booleanValue() ? i2 + 1 : i2;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedCountUI(int i) {
        this.mFinishMenuItem.setTitle(getString(R.string.album_menu_finish) + "(" + i + " / " + this.mPathList.size() + ")");
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.album_menu_preview, menu);
        this.mFinishMenuItem = menu.findItem(R.id.album_menu_finish);
        if (!this.mCheckable) {
            this.mFinishMenuItem.setVisible(false);
            return true;
        }
        setCheckedCountUI(getCheckCount());
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.album_menu_finish) {
            onGalleryResult();
            return true;
        } else if (itemId == 16908332) {
            onGalleryCancel();
            return true;
        } else {
            return true;
        }
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
                this.mViewPager.setAdapter(new PathPreviewAdapter(this, this.mPathList));
                this.mViewPager.setCurrentItem(this.mCurrentItemPosition);
                this.mPageChangeListener.onPageSelected(this.mCurrentItemPosition);
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
        new AlertDialog.Builder(this).setCancelable(false).setTitle(R.string.album_title_permission_failed).setMessage(R.string.album_permission_storage_failed_hint).setPositiveButton(R.string.album_dialog_sure, new DialogInterface.OnClickListener() { // from class: com.yanzhenjie.album.ui.GalleryActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                GalleryActivity.this.onGalleryCancel();
            }
        }).show();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        onGalleryCancel();
    }

    private void onGalleryResult() {
        if (sResult != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (Map.Entry<String, Boolean> entry : this.mCheckedMap.entrySet()) {
                if (entry.getValue().booleanValue()) {
                    arrayList.add(entry.getKey());
                }
            }
            sResult.onAction(this.mRequestCode, arrayList);
        }
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGalleryCancel() {
        if (sCancel != null) {
            sCancel.onAction(this.mRequestCode, "User canceled.");
        }
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        sResult = null;
        sCancel = null;
        super.onDestroy();
    }
}

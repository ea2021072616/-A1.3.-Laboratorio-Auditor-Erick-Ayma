package com.yanzhenjie.durban;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import com.yanzhenjie.durban.d.c;
import com.yanzhenjie.durban.view.CropView;
import com.yanzhenjie.durban.view.GestureCropImageView;
import com.yanzhenjie.durban.view.OverlayView;
import com.yanzhenjie.durban.view.TransformImageView;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class DurbanActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f5129a;

    /* renamed from: b  reason: collision with root package name */
    private int f5130b;

    /* renamed from: c  reason: collision with root package name */
    private int f5131c;
    private int d;
    private String e;
    private int f;
    private float[] g;
    private int[] h;
    private Bitmap.CompressFormat i;
    private int j;
    private String k;
    private ArrayList<String> l;
    private Controller m;
    private CropView n;
    private GestureCropImageView o;
    private ArrayList<String> p;
    private TransformImageView.a q = new TransformImageView.a() { // from class: com.yanzhenjie.durban.DurbanActivity.1
        @Override // com.yanzhenjie.durban.view.TransformImageView.a
        public void a(float f) {
        }

        @Override // com.yanzhenjie.durban.view.TransformImageView.a
        public void b(float f) {
        }

        @Override // com.yanzhenjie.durban.view.TransformImageView.a
        public void a() {
            ViewCompat.animate(DurbanActivity.this.n).alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
        }

        @Override // com.yanzhenjie.durban.view.TransformImageView.a
        public void b() {
            DurbanActivity.this.d();
        }
    };
    private View.OnClickListener r = new View.OnClickListener() { // from class: com.yanzhenjie.durban.DurbanActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.layout_controller_rotation_left) {
                DurbanActivity.this.o.c(-90.0f);
                DurbanActivity.this.o.b();
            } else if (id == R.id.layout_controller_rotation_right) {
                DurbanActivity.this.o.c(90.0f);
                DurbanActivity.this.o.b();
            } else if (id == R.id.layout_controller_scale_big) {
                DurbanActivity.this.o.a(DurbanActivity.this.o.getCurrentScale() + ((DurbanActivity.this.o.getMaxScale() - DurbanActivity.this.o.getMinScale()) / 10.0f));
                DurbanActivity.this.o.b();
            } else if (id == R.id.layout_controller_scale_small) {
                DurbanActivity.this.o.b(DurbanActivity.this.o.getCurrentScale() - ((DurbanActivity.this.o.getMaxScale() - DurbanActivity.this.o.getMinScale()) / 10.0f));
                DurbanActivity.this.o.b();
            }
        }
    };
    private com.yanzhenjie.durban.a.a s = new com.yanzhenjie.durban.a.a() { // from class: com.yanzhenjie.durban.DurbanActivity.3
        @Override // com.yanzhenjie.durban.a.a
        public void a(@NonNull String str, int i, int i2) {
            DurbanActivity.this.p.add(str);
            DurbanActivity.this.d();
        }

        @Override // com.yanzhenjie.durban.a.a
        public void a(@NonNull Throwable th) {
            DurbanActivity.this.d();
        }
    };

    static {
        f5129a = !DurbanActivity.class.desiredAssertionStatus();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c.a(this, a.a().a());
        setContentView(R.layout.durban_activity_photobox);
        a(getIntent());
        a();
        b();
        c();
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.o != null) {
            this.o.a();
        }
    }

    private void a(Intent intent) {
        this.f5130b = ContextCompat.getColor(this, R.color.durban_ColorPrimaryDark);
        this.d = ContextCompat.getColor(this, R.color.durban_ColorPrimary);
        this.f5131c = ContextCompat.getColor(this, R.color.durban_ColorPrimaryBlack);
        this.f5130b = intent.getIntExtra("AlbumCrop.KEY_INPUT_STATUS_COLOR", this.f5130b);
        this.d = intent.getIntExtra("AlbumCrop.KEY_INPUT_TOOLBAR_COLOR", this.d);
        this.f5131c = intent.getIntExtra("AlbumCrop.KEY_INPUT_NAVIGATION_COLOR", this.f5131c);
        this.e = intent.getStringExtra("AlbumCrop.KEY_INPUT_TITLE");
        if (TextUtils.isEmpty(this.e)) {
            this.e = getString(R.string.durban_title_crop);
        }
        this.f = intent.getIntExtra("AlbumCrop.KEY_INPUT_GESTURE", 3);
        this.g = intent.getFloatArrayExtra("AlbumCrop.KEY_INPUT_ASPECT_RATIO");
        if (this.g == null) {
            this.g = new float[]{0.0f, 0.0f};
        }
        this.h = intent.getIntArrayExtra("AlbumCrop.KEY_INPUT_MAX_WIDTH_HEIGHT");
        if (this.h == null) {
            this.h = new int[]{500, 500};
        }
        this.i = intent.getIntExtra("AlbumCrop.KEY_INPUT_COMPRESS_FORMAT", 0) == 1 ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
        this.j = intent.getIntExtra("AlbumCrop.KEY_INPUT_COMPRESS_QUALITY", 90);
        this.k = intent.getStringExtra("AlbumCrop.KEY_INPUT_DIRECTORY");
        if (TextUtils.isEmpty(this.k)) {
            this.k = getFilesDir().getAbsolutePath();
        }
        this.l = intent.getStringArrayListExtra("AlbumCrop.KEY_INPUT_PATH_ARRAY");
        this.m = (Controller) intent.getParcelableExtra("AlbumCrop.KEY_INPUT_CONTROLLER");
        if (this.m == null) {
            this.m = Controller.newBuilder().a();
        }
        this.p = new ArrayList<>();
    }

    private void a() {
        Window window;
        if (Build.VERSION.SDK_INT >= 21 && (window = getWindow()) != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(this.f5130b);
            window.setNavigationBarColor(this.f5131c);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(this.d);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (!f5129a && supportActionBar == null) {
            throw new AssertionError();
        }
        supportActionBar.setDefaultDisplayHomeAsUpEnabled(true);
        supportActionBar.setTitle(this.e);
    }

    private void b() {
        this.n = (CropView) findViewById(R.id.crop_view);
        this.o = this.n.getCropImageView();
        this.o.setOutputDirectory(this.k);
        this.o.setTransformImageListener(this.q);
        this.o.setScaleEnabled(this.f == 3 || this.f == 1);
        this.o.setRotateEnabled(this.f == 3 || this.f == 2);
        this.o.setMaxBitmapSize(0);
        this.o.setMaxScaleMultiplier(10.0f);
        this.o.setImageToWrapCropBoundsAnimDuration(500L);
        OverlayView overlayView = this.n.getOverlayView();
        overlayView.setFreestyleCropMode(0);
        overlayView.setDimmedColor(ContextCompat.getColor(this, R.color.durban_CropDimmed));
        overlayView.setCircleDimmedLayer(false);
        overlayView.setShowCropFrame(true);
        overlayView.setCropFrameColor(ContextCompat.getColor(this, R.color.durban_CropFrameLine));
        overlayView.setCropFrameStrokeWidth(getResources().getDimensionPixelSize(R.dimen.durban_dp_1));
        overlayView.setShowCropGrid(true);
        overlayView.setCropGridRowCount(2);
        overlayView.setCropGridColumnCount(2);
        overlayView.setCropGridColor(ContextCompat.getColor(this, R.color.durban_CropGridLine));
        overlayView.setCropGridStrokeWidth(getResources().getDimensionPixelSize(R.dimen.durban_dp_1));
        if (this.g[0] <= 0.0f || this.g[1] <= 0.0f) {
            this.o.setTargetAspectRatio(0.0f);
        } else {
            this.o.setTargetAspectRatio(this.g[0] / this.g[1]);
        }
        if (this.h[0] > 0 && this.h[1] > 0) {
            this.o.setMaxResultImageSizeX(this.h[0]);
            this.o.setMaxResultImageSizeY(this.h[1]);
        }
    }

    private void c() {
        View findViewById = findViewById(R.id.iv_controller_root);
        View findViewById2 = findViewById(R.id.tv_controller_title_rotation);
        View findViewById3 = findViewById(R.id.layout_controller_rotation_left);
        View findViewById4 = findViewById(R.id.layout_controller_rotation_right);
        View findViewById5 = findViewById(R.id.tv_controller_title_scale);
        View findViewById6 = findViewById(R.id.layout_controller_scale_big);
        View findViewById7 = findViewById(R.id.layout_controller_scale_small);
        findViewById.setVisibility(this.m.isEnable() ? 0 : 8);
        findViewById2.setVisibility(this.m.isRotationTitle() ? 0 : 4);
        findViewById3.setVisibility(this.m.isRotation() ? 0 : 8);
        findViewById4.setVisibility(this.m.isRotation() ? 0 : 8);
        findViewById5.setVisibility(this.m.isScaleTitle() ? 0 : 4);
        findViewById6.setVisibility(this.m.isScale() ? 0 : 8);
        findViewById7.setVisibility(this.m.isScale() ? 0 : 8);
        if (!this.m.isRotationTitle() && !this.m.isScaleTitle()) {
            findViewById(R.id.layout_controller_title_root).setVisibility(8);
        }
        if (!this.m.isRotation()) {
            findViewById2.setVisibility(8);
        }
        if (!this.m.isScale()) {
            findViewById5.setVisibility(8);
        }
        findViewById3.setOnClickListener(this.r);
        findViewById4.setOnClickListener(this.r);
        findViewById6.setOnClickListener(this.r);
        findViewById7.setOnClickListener(this.r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        e();
        a(1);
    }

    private void e() {
        this.o.c(-this.o.getCurrentAngle());
        this.o.b();
    }

    private void a(int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                onRequestPermissionsResult(i, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, new int[]{0});
                return;
            } else {
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, i);
                return;
            }
        }
        onRequestPermissionsResult(i, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, new int[]{0});
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        switch (i) {
            case 1:
                if (iArr[0] == 0) {
                    f();
                    return;
                }
                Log.e("Durban", "Storage device permission is denied.");
                i();
                return;
            default:
                return;
        }
    }

    private void f() {
        if (this.l != null) {
            if (this.l.size() > 0) {
                try {
                    this.o.setImagePath(this.l.remove(0));
                    return;
                } catch (Exception e) {
                    d();
                    return;
                }
            } else if (this.p.size() <= 0) {
                i();
                return;
            } else {
                h();
                return;
            }
        }
        Log.e("Durban", "The file list is empty.");
        i();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.durban_menu_activity, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_action_ok) {
            g();
            return true;
        } else if (menuItem.getItemId() == 16908332) {
            i();
            return true;
        } else {
            return true;
        }
    }

    private void g() {
        this.o.a(this.i, this.j, this.s);
    }

    private void h() {
        Intent intent = new Intent();
        intent.putStringArrayListExtra("AlbumCrop.KEY_OUTPUT_IMAGE_LIST", this.p);
        setResult(-1, intent);
        finish();
    }

    private void i() {
        Intent intent = new Intent();
        intent.putStringArrayListExtra("AlbumCrop.KEY_OUTPUT_IMAGE_LIST", this.p);
        setResult(0, intent);
        finish();
    }
}

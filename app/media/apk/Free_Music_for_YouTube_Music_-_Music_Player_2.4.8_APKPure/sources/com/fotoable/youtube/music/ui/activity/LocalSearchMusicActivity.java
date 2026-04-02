package com.fotoable.youtube.music.ui.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Optional;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.bean.LocalSongBean;
import com.fotoable.youtube.music.d.a.j;
import com.fotoable.youtube.music.ui.adapter.LocalSongAdapter;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.util.l;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class LocalSearchMusicActivity extends BaseActivity implements j.a {

    /* renamed from: a  reason: collision with root package name */
    private com.fotoable.youtube.music.d.aa f3453a;

    /* renamed from: b  reason: collision with root package name */
    private LocalSongAdapter f3454b;

    /* renamed from: c  reason: collision with root package name */
    private TextView.OnEditorActionListener f3455c = new TextView.OnEditorActionListener() { // from class: com.fotoable.youtube.music.ui.activity.LocalSearchMusicActivity.4
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 3) {
                String obj = LocalSearchMusicActivity.this.searchEdit.getText().toString();
                if (LocalSearchMusicActivity.this.f3453a != null && !TextUtils.isEmpty(obj.trim())) {
                    LocalSearchMusicActivity.this.hideSoft(LocalSearchMusicActivity.this.searchEdit);
                    LocalSearchMusicActivity.this.f3453a.b(obj.trim());
                    return false;
                }
                return false;
            }
            return false;
        }
    };
    @BindView(R.id.recycleview)
    RecyclerView recycle_view;
    @BindView(R.id.search_cancel_tx)
    LaToTextView searchCancelTx;
    @BindView(R.id.search_delete_img)
    ImageView searchDeleteImg;
    @BindView(R.id.search_edit)
    EditText searchEdit;
    @BindView(R.id.search_history_title_shadow_view)
    View shadowView;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.local_search;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        d();
        r();
        t();
        u();
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void c() {
        com.fotoable.youtube.music.newplayer.e.a().a(this, 2404);
    }

    private void r() {
        if (Build.VERSION.SDK_INT >= 23 && !com.fotoable.youtube.music.util.l.a().a("android.permission.READ_EXTERNAL_STORAGE")) {
            com.fotoable.youtube.music.util.v.b((Context) this, com.fotoable.youtube.music.b.j, true);
            if (!com.fotoable.youtube.music.util.v.c(this, com.fotoable.youtube.music.b.i, true) && !shouldShowRequestPermissionRationale("android.permission.READ_EXTERNAL_STORAGE")) {
                try {
                    new AlertDialog.Builder(this).setTitle(getString(R.string.read_local_permission)).setMessage(getString(R.string.request_external_storage)).setCancelable(true).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.fotoable.youtube.music.ui.activity.LocalSearchMusicActivity.1
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            LocalSearchMusicActivity.this.finish();
                        }
                    }).setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener(this) { // from class: com.fotoable.youtube.music.ui.activity.al

                        /* renamed from: a  reason: collision with root package name */
                        private final LocalSearchMusicActivity f3932a;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f3932a = this;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            this.f3932a.a(dialogInterface, i);
                        }
                    }).show();
                    return;
                } catch (Exception e) {
                    ThrowableExtension.printStackTrace(e);
                    return;
                }
            }
            com.fotoable.youtube.music.util.l.a().a(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0, new l.a() { // from class: com.fotoable.youtube.music.ui.activity.LocalSearchMusicActivity.2
                @Override // com.fotoable.youtube.music.util.l.a
                public void a() {
                    com.fotoable.youtube.music.util.b.b("本地音乐-权限申请成功次数");
                }

                @Override // com.fotoable.youtube.music.util.l.a
                public void b() {
                    if (!LocalSearchMusicActivity.this.p()) {
                        LocalSearchMusicActivity.this.finish();
                    }
                }

                @Override // com.fotoable.youtube.music.util.l.a
                public void c() {
                    if (!LocalSearchMusicActivity.this.p()) {
                        LocalSearchMusicActivity.this.finish();
                        com.fotoable.youtube.music.util.v.b((Context) LocalSearchMusicActivity.this, com.fotoable.youtube.music.b.i, false);
                    }
                }

                @Override // com.fotoable.youtube.music.util.l.a
                public void d() {
                    LocalSearchMusicActivity.this.finish();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        s();
    }

    private void s() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + MusicApplication.c().getPackageName()));
        intent.addCategory("android.intent.category.DEFAULT");
        startActivityForResult(intent, 1);
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && !com.fotoable.youtube.music.util.l.a().a("android.permission.READ_EXTERNAL_STORAGE")) {
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        com.fotoable.youtube.music.util.l.a().a(this, i, strArr, iArr);
    }

    private void t() {
        this.f3453a = new com.fotoable.youtube.music.d.aa(this);
    }

    private void u() {
        this.f3454b = new LocalSongAdapter(this, getSupportFragmentManager());
        this.recycle_view.setLayoutManager(new LinearLayoutManager(this));
        this.recycle_view.setAdapter(this.f3454b);
        this.searchEdit.setOnEditorActionListener(this.f3455c);
        this.searchEdit.addTextChangedListener(new TextWatcher() { // from class: com.fotoable.youtube.music.ui.activity.LocalSearchMusicActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence != null && !TextUtils.isEmpty(charSequence.toString().trim())) {
                    LocalSearchMusicActivity.this.a(rx.f.a(charSequence.toString().trim()).b(300L, TimeUnit.MILLISECONDS, rx.a.b.a.a()).b(new rx.l<String>() { // from class: com.fotoable.youtube.music.ui.activity.LocalSearchMusicActivity.3.1
                        @Override // rx.g
                        public void onCompleted() {
                        }

                        @Override // rx.g
                        public void onError(Throwable th) {
                        }

                        @Override // rx.g
                        /* renamed from: a */
                        public void onNext(String str) {
                            LocalSearchMusicActivity.this.f3453a.a(str);
                        }
                    }));
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(editable)) {
                    LocalSearchMusicActivity.this.f3454b.setData(null);
                    LocalSearchMusicActivity.this.searchDeleteImg.setVisibility(8);
                    return;
                }
                LocalSearchMusicActivity.this.searchDeleteImg.setVisibility(0);
            }
        });
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return false;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.search_cancel_tx, R.id.search_delete_img})
    @Optional
    public void Click(View view) {
        switch (view.getId()) {
            case R.id.search_delete_img /* 2131820903 */:
                this.searchEdit.setText("");
                return;
            case R.id.search_cancel_tx /* 2131820904 */:
                finish();
                return;
            default:
                return;
        }
    }

    @Override // com.fotoable.youtube.music.d.a.j.a
    public void a(List<LocalSongBean> list) {
        if (list != null && list.size() > 0 && this.f3454b != null) {
            this.f3454b.setData(list);
        }
    }

    @Override // com.fotoable.youtube.music.d.a.j.a
    public void g_() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.f3453a != null) {
                this.f3453a.b();
                this.f3453a = null;
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }
}

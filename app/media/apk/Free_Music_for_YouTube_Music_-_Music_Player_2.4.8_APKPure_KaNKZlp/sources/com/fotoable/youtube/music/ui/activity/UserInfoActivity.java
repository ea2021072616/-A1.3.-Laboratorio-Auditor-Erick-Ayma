package com.fotoable.youtube.music.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.bean.UserInfoModel;
import com.fotoable.youtube.music.ui.dialog.InputTextDialog;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.api.ImageSingleWrapper;
import com.yanzhenjie.album.api.widget.Widget;
import com.yanzhenjie.durban.Controller;
import java.io.File;
import java.util.ArrayList;
import javax.inject.Inject;
import rx.f;
/* loaded from: classes.dex */
public class UserInfoActivity extends BaseActivity {

    /* renamed from: b  reason: collision with root package name */
    private static final String f3859b = UserInfoActivity.class.getSimpleName();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f3860a;

    /* renamed from: c  reason: collision with root package name */
    private com.fotoable.youtube.music.ui.dialog.n f3861c;
    @BindView(R.id.user_avatar)
    ImageView user_avatar;
    @BindView(R.id.user_name)
    TextView user_nick;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return false;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_user_info;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        if (MusicApplication.c().h() != null) {
            com.bumptech.glide.i.a((FragmentActivity) this).a(MusicApplication.c().h().getAvatar()).d((int) R.drawable.user_avatar_def).c((int) R.drawable.user_avatar_def).b(com.bumptech.glide.load.b.b.ALL).i().a(this.user_avatar);
            this.user_nick.setText(MusicApplication.c().h().getName() + "");
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void c() {
        com.fotoable.youtube.music.newplayer.e.a().a(this, 2404);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.back_view, R.id.user_avatar_panel, R.id.user_name_panel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_view /* 2131820733 */:
                finish();
                return;
            case R.id.user_avatar_panel /* 2131820946 */:
                u();
                return;
            case R.id.user_name_panel /* 2131820948 */:
                String str = "";
                if (MusicApplication.c().h() != null) {
                    str = MusicApplication.c().h().getName();
                }
                InputTextDialog.a(getSupportFragmentManager(), R.string.enter_user_name, R.string.rename, str, 1, 40, new InputTextDialog.a() { // from class: com.fotoable.youtube.music.ui.activity.UserInfoActivity.1
                    @Override // com.fotoable.youtube.music.ui.dialog.InputTextDialog.a
                    public void a() {
                    }

                    @Override // com.fotoable.youtube.music.ui.dialog.InputTextDialog.a
                    public void a(String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            UserInfoActivity.this.b(str2);
                        }
                    }
                });
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1002:
                com.fotoable.youtube.music.util.h.a(f3859b, "剪切," + i2);
                if (i2 == -1 && intent != null && intent.hasExtra("AlbumCrop.KEY_OUTPUT_IMAGE_LIST")) {
                    ArrayList<String> a2 = com.yanzhenjie.durban.a.a(intent);
                    if (a2 != null && a2.size() > 0 && !TextUtils.isEmpty(a2.get(0))) {
                        com.fotoable.youtube.music.util.h.a(f3859b, "剪切成功," + a2.toString());
                        com.bumptech.glide.i.a((FragmentActivity) this).a(a2.get(0)).b(com.bumptech.glide.load.b.b.ALL).i().a(this.user_avatar);
                        com.fotoable.youtube.music.util.h.a(f3859b, "剪切成功," + i2);
                        a(a2.get(0));
                        return;
                    }
                    return;
                }
                com.fotoable.youtube.music.util.h.a(f3859b, "剪切失败，" + i2);
                return;
            default:
                return;
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f3861c != null) {
            this.f3861c.dismiss();
            this.f3861c = null;
            return;
        }
        super.onBackPressed();
    }

    private void a(String str) {
        this.f3861c = com.fotoable.youtube.music.ui.dialog.n.a(getSupportFragmentManager(), (int) R.string.uploading, bk.f3981a);
        a(this.f3860a.b(str).a(com.fotoable.youtube.music.util.s.a()).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.b()).b(new rx.l<UserInfoModel>() { // from class: com.fotoable.youtube.music.ui.activity.UserInfoActivity.2
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                if (UserInfoActivity.this.f3861c != null) {
                    UserInfoActivity.this.f3861c.dismiss();
                    UserInfoActivity.this.f3861c = null;
                }
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(UserInfoModel userInfoModel) {
                if (UserInfoActivity.this.f3861c != null) {
                    UserInfoActivity.this.f3861c.dismiss();
                    UserInfoActivity.this.f3861c = null;
                }
                if (userInfoModel == null) {
                    com.fotoable.youtube.music.util.h.a(UserInfoActivity.f3859b, "userInfoModel is null.");
                } else if (MusicApplication.c().h() == null) {
                    com.fotoable.youtube.music.util.h.a(UserInfoActivity.f3859b, "getUserInfoModel is null.");
                } else {
                    MusicApplication.c().h().setAvatar(userInfoModel.getAvatar());
                    UserInfoActivity.this.f3860a.a(MusicApplication.c().h());
                    Toast.makeText(UserInfoActivity.this, (int) R.string.modify_avatar_success_msg, 0).show();
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2020));
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void s() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        this.f3861c = com.fotoable.youtube.music.ui.dialog.n.a(getSupportFragmentManager(), (int) R.string.editing, bl.f3982a);
        if (MusicApplication.c().h() != null) {
            MusicApplication.c().h().setName(str + "");
            com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2020));
        }
        a(this.f3860a.c(str).a(com.fotoable.youtube.music.util.s.a()).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.b()).b(new rx.l<UserInfoModel>() { // from class: com.fotoable.youtube.music.ui.activity.UserInfoActivity.3
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                if (UserInfoActivity.this.f3861c != null) {
                    UserInfoActivity.this.f3861c.dismiss();
                    UserInfoActivity.this.f3861c = null;
                }
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(UserInfoModel userInfoModel) {
                if (UserInfoActivity.this.f3861c != null) {
                    UserInfoActivity.this.f3861c.dismiss();
                    UserInfoActivity.this.f3861c = null;
                }
                if (userInfoModel == null) {
                    com.fotoable.youtube.music.util.h.a(UserInfoActivity.f3859b, "userInfoModel is null.");
                } else if (MusicApplication.c().h() == null) {
                    com.fotoable.youtube.music.util.h.a(UserInfoActivity.f3859b, "getUserInfoModel is null.");
                } else {
                    MusicApplication.c().h().setName(userInfoModel.getName());
                    UserInfoActivity.this.f3860a.a(MusicApplication.c().h());
                    UserInfoActivity.this.user_nick.setText(MusicApplication.c().h().getName() + "");
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2020));
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void r() {
    }

    private void u() {
        try {
            ((ImageSingleWrapper) ((ImageSingleWrapper) ((ImageSingleWrapper) ((ImageSingleWrapper) Album.image((Activity) this).singleChoice().requestCode(1001)).camera(true).columnCount(2).widget(Widget.newDarkBuilder(MusicApplication.c()).title(R.string.choose_avatar).statusBarColor(ContextCompat.getColor(MusicApplication.c(), R.color.colorPrimaryDark)).toolBarColor(ContextCompat.getColor(MusicApplication.c(), R.color.colorPrimary)).navigationBarColor(ContextCompat.getColor(MusicApplication.c(), R.color.colorPrimary)).build())).onResult(new Action<ArrayList<AlbumFile>>() { // from class: com.fotoable.youtube.music.ui.activity.UserInfoActivity.5
                @Override // com.yanzhenjie.album.Action
                /* renamed from: a */
                public void onAction(int i, @NonNull ArrayList<AlbumFile> arrayList) {
                    if (arrayList != null && arrayList.size() > 0 && !TextUtils.isEmpty(arrayList.get(0).getPath())) {
                        UserInfoActivity.this.a(arrayList.get(0).getPath());
                    }
                }
            })).onCancel(new Action<String>() { // from class: com.fotoable.youtube.music.ui.activity.UserInfoActivity.4
                @Override // com.yanzhenjie.album.Action
                /* renamed from: a */
                public void onAction(int i, @NonNull String str) {
                }
            })).start();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
            com.fotoable.youtube.music.util.b.a(e);
        }
    }

    private String v() {
        File file = new File(Environment.getExternalStorageDirectory(), "/Free Music/avatar/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String... strArr) {
        com.yanzhenjie.durban.a.a((Activity) this).a(getString(R.string.choose_avatar)).a(ContextCompat.getColor(this, R.color.colorPrimaryDark)).b(ContextCompat.getColor(this, R.color.colorPrimary)).c(ContextCompat.getColor(this, R.color.colorPrimary)).a(strArr).b(v()).a(200, 200).a(1.0f, 1.0f).e(0).f(90).d(3).a(Controller.newBuilder().a(true).b(true).c(false).d(true).e(false).a()).g(1002).b();
    }
}

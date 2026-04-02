package com.fotoable.youtube.music.ui.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Optional;
import com.facebook.ads.AdError;
import com.flyco.tablayout.SlidingTabLayout;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.ui.adapter.HomeAdapter;
import com.fotoable.youtube.music.ui.dialog.ScanLocalMusicDialog;
import com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog;
import com.fotoable.youtube.music.util.l;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class LocalMusicFragment extends com.fotoable.youtube.music.base.i {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f4628c = {R.string.songs2, R.string.playlists, R.string.album, R.string.artists};
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f4629b;
    private List<com.fotoable.youtube.music.base.i> d;
    private boolean e = false;
    @BindView(R.id.no_permission_content)
    LinearLayout no_permission_content;
    @BindView(R.id.no_permission_panel)
    RelativeLayout no_permission_panel;
    @BindView(R.id.tab_layout)
    SlidingTabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @Override // com.fotoable.youtube.music.base.i
    public int a() {
        return R.layout.activity_local_music;
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        com.fotoable.youtube.music.util.b.b("本地音乐-进入次数");
        com.fotoable.youtube.music.util.b.b("本地音乐-展示");
        if (Build.VERSION.SDK_INT >= 23 && !com.fotoable.youtube.music.util.l.a().a("android.permission.READ_EXTERNAL_STORAGE") && com.fotoable.youtube.music.util.v.a(getContext(), com.fotoable.youtube.music.b.j, false)) {
            this.no_permission_panel.setVisibility(0);
            this.no_permission_content.setVisibility(0);
        } else {
            i();
        }
        h();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.viewPager != null) {
            this.viewPager.setCurrentItem(com.fotoable.youtube.music.util.v.a(getContext(), com.fotoable.youtube.music.b.g, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (Build.VERSION.SDK_INT >= 23 && !com.fotoable.youtube.music.util.l.a().a("android.permission.READ_EXTERNAL_STORAGE")) {
            com.fotoable.youtube.music.util.b.b("本地音乐-申请权限次数");
            com.fotoable.youtube.music.util.v.b(getContext(), com.fotoable.youtube.music.b.j, true);
            if (!com.fotoable.youtube.music.util.v.c(getContext(), com.fotoable.youtube.music.b.i, true) && !shouldShowRequestPermissionRationale("android.permission.READ_EXTERNAL_STORAGE")) {
                try {
                    AlertDialog.Builder positiveButton = new AlertDialog.Builder(getContext()).setTitle(getString(R.string.read_local_permission)).setMessage(getString(R.string.cancel_permission_tip)).setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener(this) { // from class: com.fotoable.youtube.music.ui.fragment.ag

                        /* renamed from: a  reason: collision with root package name */
                        private final LocalMusicFragment f4770a;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f4770a = this;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            this.f4770a.a(dialogInterface, i);
                        }
                    });
                    positiveButton.setCancelable(true).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.fotoable.youtube.music.ui.fragment.LocalMusicFragment.1
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            LocalMusicFragment.this.no_permission_panel.setVisibility(0);
                            LocalMusicFragment.this.no_permission_content.setVisibility(0);
                        }
                    });
                    positiveButton.show();
                    return;
                } catch (Exception e) {
                    ThrowableExtension.printStackTrace(e);
                    return;
                }
            }
            com.fotoable.youtube.music.util.l.a().a(getActivity(), new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0, new l.a() { // from class: com.fotoable.youtube.music.ui.fragment.LocalMusicFragment.2
                @Override // com.fotoable.youtube.music.util.l.a
                public void a() {
                    com.fotoable.youtube.music.util.b.b("本地音乐-权限申请成功次数");
                    LocalMusicFragment.this.k();
                }

                @Override // com.fotoable.youtube.music.util.l.a
                public void b() {
                    if (!LocalMusicFragment.this.d() && !LocalMusicFragment.this.e) {
                        LocalMusicFragment.this.e = true;
                        SimpleMusicDialog.a(LocalMusicFragment.this.getChildFragmentManager(), new SimpleMusicDialog.a() { // from class: com.fotoable.youtube.music.ui.fragment.LocalMusicFragment.2.1
                            @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                            public void a() {
                                LocalMusicFragment.this.no_permission_panel.setVisibility(0);
                                LocalMusicFragment.this.no_permission_content.setVisibility(0);
                            }

                            @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                            public void b() {
                                LocalMusicFragment.this.no_permission_panel.setVisibility(0);
                                LocalMusicFragment.this.no_permission_content.setVisibility(0);
                            }

                            @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                            public void c() {
                                LocalMusicFragment.this.e = false;
                                LocalMusicFragment.this.i();
                            }
                        }, R.string.cancel_permission_tip, R.string.deny, R.string.enable);
                    }
                }

                @Override // com.fotoable.youtube.music.util.l.a
                public void c() {
                    if (!LocalMusicFragment.this.d()) {
                        com.fotoable.youtube.music.util.v.b(LocalMusicFragment.this.getContext(), com.fotoable.youtube.music.b.i, false);
                        LocalMusicFragment.this.no_permission_panel.setVisibility(0);
                        LocalMusicFragment.this.no_permission_content.setVisibility(0);
                    }
                }

                @Override // com.fotoable.youtube.music.util.l.a
                public void d() {
                    LocalMusicFragment.this.no_permission_panel.setVisibility(0);
                    LocalMusicFragment.this.no_permission_content.setVisibility(0);
                }
            });
            return;
        }
        k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        j();
    }

    private void j() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + MusicApplication.c().getPackageName()));
        intent.addCategory("android.intent.category.DEFAULT");
        startActivityForResult(intent, 1);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && com.fotoable.youtube.music.util.l.a().a("android.permission.READ_EXTERNAL_STORAGE")) {
            k();
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
        e().a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (!d()) {
            this.no_permission_panel.setVisibility(8);
            this.no_permission_content.setVisibility(8);
            this.d = new ArrayList();
            this.d.add(new LocalSongsFragment());
            this.d.add(new LocalPlayListFragment());
            this.d.add(new LocalAlbumFragment());
            this.d.add(new LocalArtistsFragment());
            HomeAdapter homeAdapter = new HomeAdapter(getChildFragmentManager(), this.d, f4628c, getContext());
            if (this.viewPager != null) {
                this.viewPager.setAdapter(homeAdapter);
                this.viewPager.setOffscreenPageLimit(3);
                this.tabLayout.setViewPager(this.viewPager);
            }
            int a2 = com.fotoable.youtube.music.util.v.a(getContext(), com.fotoable.youtube.music.b.g, 0);
            if (a2 >= 4 || a2 < 0) {
                com.fotoable.youtube.music.util.v.b(getContext(), com.fotoable.youtube.music.b.g, 0);
                a2 = 0;
            }
            this.viewPager.setCurrentItem(a2);
            this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.fotoable.youtube.music.ui.fragment.LocalMusicFragment.3
                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                    switch (i) {
                        case 0:
                        case 1:
                        case 2:
                        default:
                            com.fotoable.youtube.music.util.v.b(LocalMusicFragment.this.getContext(), com.fotoable.youtube.music.b.g, i);
                            return;
                    }
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                }
            });
        }
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(com.fotoable.youtube.music.e.a aVar) {
        super.a(aVar);
        switch (aVar.f2726a) {
            case AdError.MEDIATION_ERROR_CODE /* 3001 */:
                com.fotoable.youtube.music.util.b.b("本地音乐--扫描本地音乐");
                ScanLocalMusicDialog.a(getChildFragmentManager());
                return;
            case 3002:
                com.fotoable.youtube.music.util.b.b("本地音乐--选择排序方式");
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.open_permission_bt})
    @Optional
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.open_permission_bt /* 2131820804 */:
                this.e = false;
                i();
                return;
            default:
                return;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.viewPager != null) {
            this.viewPager.removeAllViews();
        }
        super.onDestroy();
    }
}

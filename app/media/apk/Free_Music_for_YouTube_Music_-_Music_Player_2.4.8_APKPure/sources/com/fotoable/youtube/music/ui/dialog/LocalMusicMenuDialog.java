package com.fotoable.youtube.music.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.bean.LocalSongBean;
import com.fotoable.youtube.music.ui.activity.LocalAlbumDetailActivity;
import com.fotoable.youtube.music.ui.activity.LocalArtistsDetailActivity;
import com.fotoable.youtube.music.ui.activity.TimerActivity;
import com.fotoable.youtube.music.ui.dialog.LocalMusicMenuDialog;
import com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class LocalMusicMenuDialog extends com.fotoable.youtube.music.ui.dialog.a {
    private static final String d = LocalMusicMenuDialog.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    Unbinder f4145a;
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f4146b;

    /* renamed from: c  reason: collision with root package name */
    rx.g.b f4147c;
    @BindView(R.id.btn_favorite)
    CheckBox ckFavorite;
    private LocalSongBean e;
    private FragmentManager f;
    @BindView(R.id.favorite_label)
    TextView favorite_label;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private b l;
    @BindView(R.id.lin_artist)
    LinearLayout linArtist;
    @BindView(R.id.lin_delete)
    LinearLayout linDelete;
    @BindView(R.id.lin_album)
    LinearLayout llAlbum;
    @BindView(R.id.ll_favorite)
    LinearLayout llFavorite;
    @BindView(R.id.ll_ring)
    LinearLayout llRing;
    @BindView(R.id.ll_sleep_timer)
    LinearLayout ll_sleep_timer;
    private boolean m = false;
    private DialogInterface.OnKeyListener n = new DialogInterface.OnKeyListener() { // from class: com.fotoable.youtube.music.ui.dialog.LocalMusicMenuDialog.3
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 1) {
                LocalMusicMenuDialog.this.dismissAllowingStateLoss();
                LocalMusicMenuDialog.this.onCancel(dialogInterface);
                return true;
            }
            return false;
        }
    };
    @BindView(R.id.sleep_timer_real_time)
    TextView sleep_timer_real_time;
    @BindView(R.id.tv_album)
    TextView tvAlbum;
    @BindView(R.id.txt_artists)
    TextView txtArtists;

    /* loaded from: classes.dex */
    public interface b {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LocalMusicMenuDialog b(a aVar) {
        LocalMusicMenuDialog localMusicMenuDialog = new LocalMusicMenuDialog();
        localMusicMenuDialog.e = aVar.f4152a;
        localMusicMenuDialog.f = aVar.f4153b;
        localMusicMenuDialog.g = aVar.f4154c;
        localMusicMenuDialog.l = aVar.h;
        localMusicMenuDialog.k = aVar.g;
        localMusicMenuDialog.h = aVar.d;
        localMusicMenuDialog.i = aVar.e;
        localMusicMenuDialog.j = aVar.f;
        return localMusicMenuDialog;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f4145a = ButterKnife.bind(this, view);
        i();
        j();
        h();
        com.fotoable.youtube.music.util.h.a(d, com.fotoable.youtube.music.util.w.a());
        f();
    }

    private void h() {
        if (this.e != null) {
            if (this.g) {
                if (this.e != null && !TextUtils.isEmpty(this.e.artistName)) {
                    this.linArtist.setVisibility(0);
                    this.txtArtists.setText(getResources().getString(R.string.artist) + " " + this.e.getArtistName());
                }
            } else {
                this.linArtist.setVisibility(8);
            }
            if (this.h) {
                this.linDelete.setVisibility(0);
            } else {
                this.linDelete.setVisibility(8);
            }
            if (this.j) {
                this.llFavorite.setVisibility(0);
            } else {
                this.llFavorite.setVisibility(8);
            }
            if (this.k) {
                this.ll_sleep_timer.setVisibility(0);
            }
            if (this.i) {
                if (this.e != null && !TextUtils.isEmpty(this.e.albumName)) {
                    this.llAlbum.setVisibility(0);
                    String albumName = this.e.getAlbumName();
                    if (albumName.contains("/")) {
                        albumName = albumName.substring(0, albumName.indexOf("/"));
                    }
                    this.tvAlbum.setText(getResources().getString(R.string.menu_album, albumName));
                }
            } else {
                this.llAlbum.setVisibility(8);
            }
            if (this.ckFavorite != null) {
                a(this.f4146b.f(this.e.songId).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.ui.dialog.LocalMusicMenuDialog.1
                    @Override // rx.g
                    public void onCompleted() {
                    }

                    @Override // rx.g
                    public void onError(Throwable th) {
                        ThrowableExtension.printStackTrace(th);
                    }

                    @Override // rx.g
                    /* renamed from: a */
                    public void onNext(Boolean bool) {
                        LocalMusicMenuDialog.this.ckFavorite.setChecked(bool.booleanValue());
                        LocalMusicMenuDialog.this.m = bool.booleanValue();
                        if (bool.booleanValue()) {
                            LocalMusicMenuDialog.this.favorite_label.setText(R.string.remove_fav);
                        } else {
                            LocalMusicMenuDialog.this.favorite_label.setText(R.string.add_to_favorite);
                        }
                    }
                }));
            }
            if (Build.VERSION.SDK_INT >= 23 && !Settings.System.canWrite(MusicApplication.c())) {
                this.llRing.setVisibility(8);
            } else {
                this.llRing.setVisibility(0);
            }
        }
    }

    private void i() {
        getDialog().requestWindowFeature(1);
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        getDialog().getWindow().setGravity(80);
        Window window = getDialog().getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
        getDialog().setCancelable(true);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.down_fragment_alpha)));
        getDialog().getWindow().setWindowAnimations(R.style.download_popup_animation);
    }

    private void j() {
        getDialog().setOnKeyListener(this.n);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dialog_menu_localmusi, viewGroup, false);
    }

    @OnClick({R.id.ll_favorite, R.id.lin_find_lyric, R.id.lin_album, R.id.btn_favorite, R.id.ll_share, R.id.ll_ring, R.id.lin_artist, R.id.lin_delete, R.id.ll_sleep_timer, R.id.add_to_playlist})
    public void onClick(View view) {
        dismiss();
        if (this.e == null || this.f4146b == null) {
            com.fotoable.youtube.music.util.h.a(d, "localSongbean:" + this.e + ",greenDAOHelper:" + this.f4146b);
            return;
        }
        switch (view.getId()) {
            case R.id.ll_favorite /* 2131821043 */:
            case R.id.btn_favorite /* 2131821044 */:
                if (this.m) {
                    com.fotoable.youtube.music.util.b.b("单曲页面--取消收藏单曲");
                    Toast.makeText(getContext(), (int) R.string.removed, 0).show();
                } else {
                    com.fotoable.youtube.music.util.b.b("单曲页面--收藏单曲");
                    Toast.makeText(getContext(), (int) R.string.added, 0).show();
                }
                this.f4146b.a(this.m, this.e).a(com.fotoable.youtube.music.util.s.a()).b(p.f4468a);
                return;
            case R.id.favorite_label /* 2131821045 */:
            case R.id.dialog_add_playlist_tx /* 2131821047 */:
            case R.id.dialog_add_playlist_tips_img /* 2131821048 */:
            case R.id.txt_artists /* 2131821052 */:
            case R.id.tv_album /* 2131821054 */:
            case R.id.sleep_timer_real_time /* 2131821057 */:
            default:
                return;
            case R.id.add_to_playlist /* 2131821046 */:
                LocalCreatedPlayListDialog.a(getFragmentManager(), this.e);
                return;
            case R.id.ll_share /* 2131821049 */:
                com.fotoable.youtube.music.util.b.b("单曲页面--分享本地歌曲");
                if (this.e.data != null) {
                    com.fotoable.youtube.music.helper.f.a(getContext(), this.e.data);
                    return;
                }
                return;
            case R.id.lin_find_lyric /* 2131821050 */:
                if (TextUtils.isEmpty(this.e.artistName)) {
                    com.fotoable.youtube.music.util.i.a(getActivity()).b(this.e.songName, null);
                    return;
                } else {
                    com.fotoable.youtube.music.util.i.a(getActivity()).b(this.e.artistName + "  " + this.e.songName, null);
                    return;
                }
            case R.id.lin_artist /* 2131821051 */:
                com.fotoable.youtube.music.util.b.b("单曲页面--进入歌手详情页");
                Intent intent = new Intent(getActivity(), LocalArtistsDetailActivity.class);
                intent.putExtra(ShareConstants.WEB_DIALOG_PARAM_DATA, this.e.artistId);
                intent.putExtra("name", this.e.artistName);
                startActivity(intent);
                return;
            case R.id.lin_album /* 2131821053 */:
                com.fotoable.youtube.music.util.b.b("单曲页面--进入专辑详情页");
                Intent intent2 = new Intent(getActivity(), LocalAlbumDetailActivity.class);
                intent2.putExtra("data_id", this.e.albumId);
                intent2.putExtra("name", this.e.albumName);
                intent2.putExtra("artists", this.e.artistName);
                startActivity(intent2);
                return;
            case R.id.ll_ring /* 2131821055 */:
                com.fotoable.youtube.music.util.b.b("单曲页面--设置铃声");
                if (this.e.data != null) {
                    com.fotoable.youtube.music.util.q.a(getContext(), this.e.data);
                    return;
                }
                return;
            case R.id.ll_sleep_timer /* 2131821056 */:
                startActivity(new Intent(getContext(), TimerActivity.class));
                return;
            case R.id.lin_delete /* 2131821058 */:
                com.fotoable.youtube.music.util.b.b("单曲页面--删除本地歌曲");
                SimpleMusicDialog.a(getFragmentManager(), new AnonymousClass2(), R.string.delete_song_description, R.string.cancel, R.string.delete);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(Boolean bool) {
        if (bool.booleanValue()) {
            com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(3009));
        }
    }

    /* renamed from: com.fotoable.youtube.music.ui.dialog.LocalMusicMenuDialog$2  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements SimpleMusicDialog.a {
        AnonymousClass2() {
        }

        @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
        public void a() {
        }

        @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
        public void b() {
        }

        @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
        public void c() {
            com.fotoable.youtube.music.helper.localmusic.d.a(LocalMusicMenuDialog.this.e.songId);
            com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(3010));
            LocalMusicMenuDialog.this.f4146b.e(LocalMusicMenuDialog.this.e.songId).a(com.fotoable.youtube.music.util.s.a()).b(new rx.c.b(this) { // from class: com.fotoable.youtube.music.ui.dialog.q

                /* renamed from: a  reason: collision with root package name */
                private final LocalMusicMenuDialog.AnonymousClass2 f4469a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f4469a = this;
                }

                @Override // rx.c.b
                public void call(Object obj) {
                    this.f4469a.a((Boolean) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void a(Boolean bool) {
            if (bool.booleanValue()) {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(3009));
                com.fotoable.youtube.music.newplayer.e.a().a(LocalMusicMenuDialog.this.e.getSongId().longValue());
            }
        }
    }

    @Override // android.support.v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog == null) {
            super.setShowsDialog(false);
        }
        return onCreateDialog;
    }

    public void e() {
        try {
            this.f.beginTransaction().add(this, "localMusic").commitAllowingStateLoss();
            com.fotoable.youtube.music.newplayer.e.a().d(PointerIconCompat.TYPE_HELP);
            com.fotoable.youtube.music.newplayer.e.a().a(0);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            if (this.f != null) {
                this.f.beginTransaction().remove(this).commitAllowingStateLoss();
            }
            super.dismiss();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        try {
            g();
            if (this.f4145a != null) {
                this.f4145a.unbind();
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.fotoable.youtube.music.newplayer.e.a().a(1);
    }

    @Override // com.fotoable.youtube.music.ui.dialog.a
    protected void a() {
        c().a(this);
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private LocalSongBean f4152a;

        /* renamed from: b  reason: collision with root package name */
        private FragmentManager f4153b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f4154c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private b h;

        public a(FragmentManager fragmentManager) {
            this.f4153b = fragmentManager;
        }

        public a a(LocalSongBean localSongBean) {
            this.f4152a = localSongBean;
            return this;
        }

        public a a(boolean z) {
            this.f = z;
            return this;
        }

        public a b(boolean z) {
            this.f4154c = z;
            return this;
        }

        public a c(boolean z) {
            this.e = z;
            return this;
        }

        public a d(boolean z) {
            this.d = z;
            return this;
        }

        public LocalMusicMenuDialog a() {
            return LocalMusicMenuDialog.b(this);
        }

        public a e(boolean z) {
            this.g = z;
            return this;
        }
    }

    public void f() {
        a(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<com.fotoable.youtube.music.e.a>() { // from class: com.fotoable.youtube.music.ui.dialog.LocalMusicMenuDialog.4
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                if (th != null) {
                    ThrowableExtension.printStackTrace(th);
                }
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(com.fotoable.youtube.music.e.a aVar) {
                LocalMusicMenuDialog.this.a(aVar);
            }
        }));
    }

    protected void a(rx.m mVar) {
        if (this.f4147c == null) {
            this.f4147c = new rx.g.b();
        }
        this.f4147c.a(mVar);
    }

    protected void g() {
        if (this.f4147c != null) {
            this.f4147c.unsubscribe();
            this.f4147c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.fotoable.youtube.music.e.a aVar) {
        switch (aVar.f2726a) {
            case 8004:
                if (aVar.d > 0) {
                    StringBuilder sb = new StringBuilder();
                    int i = aVar.d / 216000;
                    int i2 = (aVar.d % 216000) / 60;
                    int i3 = (aVar.d % 216000) % 60;
                    if (i > 0) {
                        sb.append(i + ":");
                    }
                    if (i2 > 0) {
                        if (i2 < 10) {
                            sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        }
                        sb.append(i2 + ":");
                    } else {
                        sb.append("00:");
                    }
                    if (i3 > 0) {
                        if (i3 < 10) {
                            sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        }
                        sb.append(i3 + "");
                    } else {
                        sb.append("00");
                    }
                    this.sleep_timer_real_time.setText(sb.toString() + "");
                    this.sleep_timer_real_time.setVisibility(0);
                    return;
                }
                this.sleep_timer_real_time.setVisibility(8);
                return;
            default:
                return;
        }
    }
}

package com.fotoable.youtube.music.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.facebook.ads.AdError;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.FavBean;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.ui.activity.ArtistsDetailActivity;
import com.fotoable.youtube.music.ui.activity.CommunityPostActivity;
import com.fotoable.youtube.music.ui.activity.TimerActivity;
import com.fotoable.youtube.music.ui.activity.YoutubeCommentActivity;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import rx.schedulers.Schedulers;
/* loaded from: classes.dex */
public class MusicMenuDialog extends com.fotoable.youtube.music.ui.dialog.a {
    private static final String d = MusicMenuDialog.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    Unbinder f4200a;
    @BindView(R.id.dialog_add_playlist_tips_img)
    ImageView addPlaylistTipsImageView;
    @BindView(R.id.add_to_queue)
    LinearLayout add_to_queue;
    @BindView(R.id.lin_admin_delete)
    LinearLayout adminDeleteView;
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f4201b;
    @BindView(R.id.btn_favorite)
    CheckBox btn_favorite;

    /* renamed from: c  reason: collision with root package name */
    rx.g.b f4202c;
    @BindView(R.id.comment_count)
    TextView comment_count;
    @BindView(R.id.dialog_comment_tips_img)
    ImageView dialog_comment_tips_img;
    @BindView(R.id.dialog_post_tips_img)
    ImageView dialog_post_tips_img;
    private PlayMusicModel e;
    private ArrayList<PlayMusicModel> f;
    @BindView(R.id.favorite_label)
    TextView favorite_label;
    private int g;
    private FragmentManager h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    @BindView(R.id.lin_artist)
    LinearLayout linArtist;
    @BindView(R.id.lin_delete)
    LinearLayout linDelete;
    @BindView(R.id.lin_comment)
    RelativeLayout lin_comment;
    @BindView(R.id.ll_sleep_time)
    LinearLayout ll_sleep_time;
    private c m;
    private a n;
    private int o;
    private DialogInterface.OnKeyListener p = new DialogInterface.OnKeyListener() { // from class: com.fotoable.youtube.music.ui.dialog.MusicMenuDialog.4
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 1) {
                MusicMenuDialog.this.dismissAllowingStateLoss();
                MusicMenuDialog.this.onCancel(dialogInterface);
                return true;
            }
            return false;
        }
    };
    @BindView(R.id.play_next)
    LinearLayout play_next;
    @BindView(R.id.play_now)
    LinearLayout play_now;
    @BindView(R.id.sleep_timer_real_time)
    TextView sleep_timer_real_time;
    @BindView(R.id.txt_artists)
    TextView txtArtists;

    /* loaded from: classes.dex */
    public interface a {
        void onDelete(PlayMusicModel playMusicModel);
    }

    /* loaded from: classes.dex */
    public interface c {
        void onDelete(PlayMusicModel playMusicModel);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dialog_menu_popup, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MusicMenuDialog b(b bVar) {
        MusicMenuDialog musicMenuDialog = new MusicMenuDialog();
        musicMenuDialog.e = bVar.f4208a;
        musicMenuDialog.f = bVar.f4209b;
        musicMenuDialog.g = bVar.j;
        musicMenuDialog.h = bVar.f4210c;
        musicMenuDialog.i = bVar.d;
        musicMenuDialog.l = bVar.k;
        musicMenuDialog.j = bVar.e;
        musicMenuDialog.m = bVar.g;
        musicMenuDialog.k = bVar.f;
        musicMenuDialog.n = bVar.h;
        musicMenuDialog.o = bVar.i;
        return musicMenuDialog;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f4200a = ButterKnife.bind(this, view);
        l();
        m();
        h();
        com.fotoable.youtube.music.util.h.a(d, com.fotoable.youtube.music.util.w.a());
        f();
    }

    private void h() {
        if (this.i && this.e != null && !TextUtils.isEmpty(this.e.getArtists())) {
            this.linArtist.setVisibility(0);
            this.txtArtists.setText(getResources().getString(R.string.artist) + " " + this.e.getArtists());
        }
        if (!this.j) {
            this.play_now.setVisibility(8);
            this.play_next.setVisibility(8);
            this.add_to_queue.setVisibility(8);
        }
        if (this.l) {
            this.ll_sleep_time.setVisibility(0);
        }
        this.lin_comment.setVisibility(8);
        if (this.k) {
            this.linDelete.setVisibility(0);
        } else {
            this.linDelete.setVisibility(8);
        }
        if (com.fotoable.youtube.music.util.v.a((Context) getActivity(), "add_playlist_dialog_tips", true)) {
            this.addPlaylistTipsImageView.setVisibility(0);
        } else {
            this.addPlaylistTipsImageView.setVisibility(8);
        }
        if (com.fotoable.youtube.music.util.a.a() && this.n != null) {
            this.adminDeleteView.setVisibility(0);
        } else {
            this.adminDeleteView.setVisibility(8);
        }
        i();
    }

    private void i() {
        if (this.e != null && !TextUtils.isEmpty(this.e.getVideoId())) {
            a(this.f4201b.d(this.e.getVideoId()).b(Schedulers.io()).a(rx.a.b.a.a()).b(new rx.l<List<FavBean>>() { // from class: com.fotoable.youtube.music.ui.dialog.MusicMenuDialog.1
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                }

                @Override // rx.l
                public void onStart() {
                    super.onStart();
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(List<FavBean> list) {
                    if (list != null && list.size() > 0) {
                        MusicMenuDialog.this.btn_favorite.setChecked(true);
                        MusicMenuDialog.this.e.setIsFav(true);
                        MusicMenuDialog.this.favorite_label.setText(R.string.remove_fav);
                        return;
                    }
                    MusicMenuDialog.this.favorite_label.setText(R.string.add_to_favorite);
                    MusicMenuDialog.this.btn_favorite.setChecked(false);
                    MusicMenuDialog.this.e.setIsFav(false);
                }
            }));
        }
    }

    private void j() {
        if (this.e != null) {
            FavBean favBean = new FavBean();
            favBean.setVideoid(this.e.getVideoId());
            favBean.setTitle(this.e.getTitle());
            favBean.setDesc(this.e.getDescription());
            favBean.setImgUrl(this.e.getCoverImg());
            favBean.setArtists(this.e.getArtists());
            this.f4201b.a(favBean);
            a(this.f4201b.a(favBean).b(Schedulers.io()).a(rx.a.b.a.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.ui.dialog.MusicMenuDialog.2
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
                    MusicMenuDialog.this.e.setFav(true);
                }
            }));
        }
    }

    private void k() {
        if (this.e != null) {
            this.f4201b.c(this.e.getVideoId()).b(Schedulers.io()).a(rx.a.b.a.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.ui.dialog.MusicMenuDialog.3
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
                    MusicMenuDialog.this.e.setFav(false);
                }
            });
        }
    }

    private void l() {
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

    private void m() {
        getDialog().setOnKeyListener(this.p);
    }

    @OnClick({R.id.play_now, R.id.play_next, R.id.add_to_queue, R.id.lin_find_mp3, R.id.lin_copy_url, R.id.lin_share, R.id.lin_find_lyric, R.id.lin_artist, R.id.add_to_playlist, R.id.lin_delete, R.id.lin_admin_delete, R.id.ll_sleep_time, R.id.ll_favorite, R.id.lin_comment, R.id.lin_share_to_community})
    public void onClick(View view) {
        dismiss();
        if (this.e != null) {
            switch (view.getId()) {
                case R.id.play_next /* 2131820878 */:
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2002, this.e));
                    return;
                case R.id.ll_favorite /* 2131821043 */:
                    dismissAllowingStateLoss();
                    if (this.e != null) {
                        if (this.e.isFav()) {
                            k();
                            Toast.makeText(getContext(), (int) R.string.removed, 0).show();
                            return;
                        }
                        j();
                        Toast.makeText(getContext(), (int) R.string.added, 0).show();
                        return;
                    }
                    return;
                case R.id.add_to_playlist /* 2131821046 */:
                    AddPlayListDialog.a(getFragmentManager(), this.e);
                    this.addPlaylistTipsImageView.setVisibility(8);
                    com.fotoable.youtube.music.util.v.b((Context) getActivity(), "add_playlist_dialog_tips", false);
                    return;
                case R.id.lin_find_lyric /* 2131821050 */:
                    if (TextUtils.isEmpty(this.e.getArtists())) {
                        com.fotoable.youtube.music.util.i.a(getActivity()).b(this.e.getTitle(), this.e.getVideoId());
                        return;
                    } else {
                        com.fotoable.youtube.music.util.i.a(getActivity()).b(this.e.getArtists() + "  " + this.e.getTitle(), this.e.getVideoId());
                        return;
                    }
                case R.id.lin_artist /* 2131821051 */:
                    Intent intent = new Intent(getActivity(), ArtistsDetailActivity.class);
                    intent.putExtra(ShareConstants.TITLE, this.e.getArtists());
                    startActivity(intent);
                    com.fotoable.youtube.music.util.b.b("在线音乐-底部菜单-点击歌手", "歌手名", "" + this.e.getArtists());
                    return;
                case R.id.lin_delete /* 2131821058 */:
                    if (this.m != null) {
                        this.m.onDelete(this.e);
                        return;
                    }
                    return;
                case R.id.play_now /* 2131821062 */:
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a((int) AdError.INTERNAL_ERROR_CODE, this.f, this.g));
                    return;
                case R.id.add_to_queue /* 2131821063 */:
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2003, this.e));
                    return;
                case R.id.lin_share_to_community /* 2131821064 */:
                    Intent intent2 = new Intent(getContext(), CommunityPostActivity.class);
                    intent2.putExtra("music", this.e);
                    startActivity(intent2);
                    com.fotoable.youtube.music.a.e(false);
                    com.fotoable.youtube.music.util.b.b("在线音乐-底部菜单-点击发布入口");
                    return;
                case R.id.lin_comment /* 2131821066 */:
                    Intent intent3 = new Intent(getContext(), YoutubeCommentActivity.class);
                    intent3.putParcelableArrayListExtra("modelList", this.f);
                    intent3.putExtra("VideoId", this.e.getVideoId() + "");
                    intent3.putExtra("model", this.e);
                    intent3.putExtra(ShareConstants.FEED_SOURCE_PARAM, 2);
                    intent3.putExtra("position", this.g);
                    startActivity(intent3);
                    dismissAllowingStateLoss();
                    com.fotoable.youtube.music.util.b.b("在线音乐-底部菜单-点击评论");
                    com.fotoable.youtube.music.a.f(false);
                    return;
                case R.id.lin_share /* 2131821068 */:
                    com.fotoable.youtube.music.helper.f.a(getActivity(), this.e.getArtists(), this.e.getTitle(), this.e.getVideoId());
                    return;
                case R.id.lin_copy_url /* 2131821069 */:
                    com.fotoable.youtube.music.util.i.a(getActivity()).a(this.e.getVideoId());
                    return;
                case R.id.ll_sleep_time /* 2131821070 */:
                    startActivity(new Intent(getContext(), TimerActivity.class));
                    return;
                case R.id.lin_find_mp3 /* 2131821071 */:
                    if (TextUtils.isEmpty(this.e.getArtists())) {
                        com.fotoable.youtube.music.util.i.a(getActivity()).a(this.e.getTitle(), this.e.getVideoId());
                        return;
                    } else {
                        com.fotoable.youtube.music.util.i.a(getActivity()).a(this.e.getArtists() + "  " + this.e.getTitle(), this.e.getVideoId());
                        return;
                    }
                case R.id.lin_admin_delete /* 2131821072 */:
                    if (this.n != null) {
                        this.n.onDelete(this.e);
                        return;
                    }
                    return;
                default:
                    return;
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
            this.h.beginTransaction().add(this, "MusicMenu").commitAllowingStateLoss();
            com.fotoable.youtube.music.newplayer.e.a().d(PointerIconCompat.TYPE_HELP);
            if (this.j) {
                com.fotoable.youtube.music.newplayer.e.a().a(0);
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            if (this.h != null) {
                this.h.beginTransaction().remove(this).commitAllowingStateLoss();
            }
            super.dismiss();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f4200a.unbind();
    }

    @Override // com.fotoable.youtube.music.ui.dialog.a
    protected void a() {
        c().a(this);
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private PlayMusicModel f4208a;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<PlayMusicModel> f4209b;

        /* renamed from: c  reason: collision with root package name */
        private FragmentManager f4210c;
        private boolean d;
        private boolean e = true;
        private boolean f;
        private c g;
        private a h;
        private int i;
        private int j;
        private boolean k;

        public b(FragmentManager fragmentManager) {
            this.f4210c = fragmentManager;
        }

        public b a(PlayMusicModel playMusicModel) {
            this.f4208a = playMusicModel;
            return this;
        }

        public b a(ArrayList<PlayMusicModel> arrayList) {
            this.f4209b = arrayList;
            return this;
        }

        public b a(int i) {
            this.i = i;
            return this;
        }

        public b a(boolean z) {
            this.d = z;
            return this;
        }

        public b b(boolean z) {
            this.e = z;
            return this;
        }

        public b c(boolean z) {
            this.f = z;
            return this;
        }

        public b a(c cVar) {
            this.g = cVar;
            return this;
        }

        public b a(a aVar) {
            this.h = aVar;
            return this;
        }

        public MusicMenuDialog a() {
            return MusicMenuDialog.b(this);
        }

        public b b(int i) {
            this.j = i;
            return this;
        }

        public b d(boolean z) {
            this.k = z;
            return this;
        }
    }

    public void f() {
        a(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<com.fotoable.youtube.music.e.a>() { // from class: com.fotoable.youtube.music.ui.dialog.MusicMenuDialog.5
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
                MusicMenuDialog.this.a(aVar);
            }
        }));
    }

    protected void a(rx.m mVar) {
        if (this.f4202c == null) {
            this.f4202c = new rx.g.b();
        }
        this.f4202c.a(mVar);
    }

    protected void g() {
        if (this.f4202c != null) {
            this.f4202c.unsubscribe();
            this.f4202c = null;
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

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            g();
            if (this.j) {
                com.fotoable.youtube.music.newplayer.e.a().a(1);
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }
}

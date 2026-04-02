package com.fotoable.youtube.music.ui.dialog;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.newplayer.model.LocalMusicModel;
import com.fotoable.youtube.music.ui.adapter.PlayQueueAdapter;
import com.fotoable.youtube.music.ui.dialog.b;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.List;
/* loaded from: classes.dex */
public class PlayerMusicListDialog extends b {
    private static final String g = PlayerMusicListDialog.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public int f4291c;
    public long d;
    public String e;
    protected a f;
    private List<PlayMusicModel> h;
    private List<LocalMusicModel> i;
    private PlayQueueAdapter j;
    @BindView(R.id.play_queue_count)
    TextView play_queue_count;
    @BindView(R.id.recycle_view)
    RecyclerView recycle_view;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.dialog_player_music_list, viewGroup, false);
    }

    @Override // com.fotoable.youtube.music.ui.dialog.b, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        int i;
        super.onViewCreated(view, bundle);
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.recycle_view.getLayoutParams();
        layoutParams.height = (int) (getResources().getDisplayMetrics().heightPixels * 0.6f);
        int i2 = (int) (layoutParams.height / (61.0f * getResources().getDisplayMetrics().density));
        layoutParams.width = -1;
        this.recycle_view.setLayoutParams(layoutParams);
        this.recycle_view.setLayoutManager(new LinearLayoutManager(getContext()));
        if (this.f4291c == 2) {
            this.h = com.fotoable.youtube.music.newplayer.e.a().b();
            if (this.h != null && this.h.size() > 0) {
                this.play_queue_count.setText(getResources().getString(R.string.now_playing) + "(" + this.h.size() + ")");
            } else {
                this.play_queue_count.setText(getResources().getString(R.string.now_playing) + "(0)");
            }
            this.j = new PlayQueueAdapter(getContext());
            this.j.setVideoId(this.e);
            this.j.setYoutubeAll(this.h);
            this.recycle_view.setAdapter(this.j);
            if (this.h != null) {
                com.fotoable.youtube.music.util.h.a(g, "qxs:position0:" + i2);
                if (this.h.size() > i2) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= this.h.size()) {
                            i3 = -1;
                            break;
                        } else if (TextUtils.equals(this.h.get(i3).getVideoId(), this.e)) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (i3 != -1) {
                        int i4 = i3 - (i2 / 2);
                        i = i4 >= 0 ? i4 : 0;
                        if (i != -1 && i >= 0 && i < this.h.size()) {
                            this.recycle_view.scrollToPosition(i);
                            com.fotoable.youtube.music.util.h.a(g, "滑动到指定的位置:" + i);
                        }
                    }
                }
            }
            com.fotoable.youtube.music.util.h.a(g, "获取到Youtube播放列表：" + this.h);
        } else if (this.f4291c == 3) {
            this.i = com.fotoable.youtube.music.newplayer.e.a().c();
            if (this.i != null && this.i.size() > 0) {
                this.play_queue_count.setText(getResources().getString(R.string.now_playing) + "(" + this.i.size() + ")");
            } else {
                this.play_queue_count.setText(getResources().getString(R.string.now_playing) + "(0)");
            }
            this.j = new PlayQueueAdapter(getContext());
            this.j.setSongId(this.d);
            this.j.setLocalMusicAll(this.i);
            this.recycle_view.setAdapter(this.j);
            if (this.i != null) {
                com.fotoable.youtube.music.util.h.a(g, "qxs:position0:" + i2);
                if (this.i.size() > i2) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= this.i.size()) {
                            i5 = -1;
                            break;
                        } else if (this.i.get(i5).getSongId() == this.d) {
                            break;
                        } else {
                            i5++;
                        }
                    }
                    if (i5 != -1) {
                        int i6 = i5 - (i2 / 2);
                        i = i6 >= 0 ? i6 : 0;
                        if (i != -1 && i >= 0 && i < this.i.size()) {
                            this.recycle_view.scrollToPosition(i);
                            com.fotoable.youtube.music.util.h.a(g, "滑动到指定的位置:" + i);
                        }
                    }
                }
            }
        }
        if (this.j != null) {
            this.j.setOnDeleteMusicListener(new PlayQueueAdapter.OnDeleteMusicListener(this) { // from class: com.fotoable.youtube.music.ui.dialog.u

                /* renamed from: a  reason: collision with root package name */
                private final PlayerMusicListDialog f4475a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f4475a = this;
                }

                @Override // com.fotoable.youtube.music.ui.adapter.PlayQueueAdapter.OnDeleteMusicListener
                public void delete(List list, int i7) {
                    this.f4475a.a(list, i7);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(List list, int i) {
        if (list != null && list.size() > 0) {
            this.play_queue_count.setText(getResources().getString(R.string.now_playing) + "(" + list.size() + ")");
        } else {
            this.play_queue_count.setText(getResources().getString(R.string.now_playing) + "(0)");
        }
        if (this.f != null) {
            this.f.a(list, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.clear_all})
    public void onApplyClick(View view) {
        switch (view.getId()) {
            case R.id.clear_all /* 2131821074 */:
                if (this.f != null) {
                    this.f.a();
                }
                com.fotoable.youtube.music.newplayer.e.a().h();
                dismissAllowingStateLoss();
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2006));
                return;
            default:
                return;
        }
    }

    public void a(long j) {
        if (this.d == j) {
            com.fotoable.youtube.music.util.h.a(g, "playerMusicListDialog return");
            return;
        }
        this.d = j;
        if (this.j != null) {
            this.j.setSongId(j);
            com.fotoable.youtube.music.util.h.a(g, "playerMusicListDialog playQueueAdapter," + j);
            this.j.notifyDataSetChanged();
        }
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        super.dismiss();
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismissAllowingStateLoss() {
        super.dismissAllowingStateLoss();
    }

    @Override // com.fotoable.youtube.music.ui.dialog.b, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.fotoable.youtube.music.util.h.a(g, "onDestroy");
        if (this.f != null) {
            this.f.a();
        }
    }

    public void a(String str) {
        if (TextUtils.equals(str, this.e)) {
            com.fotoable.youtube.music.util.h.a(g, "playerMusicListDialog return");
            return;
        }
        this.e = str;
        if (this.j != null) {
            this.j.setVideoId(str);
            com.fotoable.youtube.music.util.h.a(g, "playerMusicListDialog playQueueAdapter");
            this.j.notifyDataSetChanged();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class a implements b.a {
        public abstract void a(List list, int i);

        @Override // com.fotoable.youtube.music.ui.dialog.b.a
        public void b() {
        }

        @Override // com.fotoable.youtube.music.ui.dialog.b.a
        public void a() {
        }
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    public static PlayerMusicListDialog a(FragmentManager fragmentManager, int i, String str, long j, a aVar) {
        try {
            PlayerMusicListDialog playerMusicListDialog = new PlayerMusicListDialog();
            playerMusicListDialog.f4291c = i;
            playerMusicListDialog.a(aVar);
            playerMusicListDialog.e = str;
            playerMusicListDialog.d = j;
            playerMusicListDialog.show(fragmentManager, "PlayerMusicListDialog");
            return playerMusicListDialog;
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
            return null;
        }
    }
}

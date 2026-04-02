package com.fotoable.youtube.music.ui.adapter.holder;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bumptech.glide.i;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.bean.LocalSongBean;
import com.fotoable.youtube.music.e.a;
import com.fotoable.youtube.music.ui.dialog.LocalMusicMenuDialog;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.util.b;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.List;
/* loaded from: classes.dex */
public class LocalArtistsSongAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_DEFAULT = 2;
    private static final int TYPE_FOOT = 3;
    private onFootClickListener clickListener;
    private Context context;
    private FootHolder footHolder;
    private FragmentManager fragmentManager;
    private List<LocalSongBean> localSongBeen;
    private String name;
    private RecyclerView recyclerView;

    /* loaded from: classes.dex */
    public interface onFootClickListener {
        void onClickFoot();
    }

    /* loaded from: classes.dex */
    public class DefaultHolder_ViewBinding implements Unbinder {
        private DefaultHolder target;

        @UiThread
        public DefaultHolder_ViewBinding(DefaultHolder defaultHolder, View view) {
            this.target = defaultHolder;
            defaultHolder.ivImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_img, "field 'ivImg'", ImageView.class);
            defaultHolder.songTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.song_title, "field 'songTitle'", TextView.class);
            defaultHolder.songArtists = (TextView) Utils.findRequiredViewAsType(view, R.id.song_artists, "field 'songArtists'", TextView.class);
            defaultHolder.ivMenu = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_menu, "field 'ivMenu'", ImageView.class);
            defaultHolder.view = Utils.findRequiredView(view, R.id.view, "field 'view'");
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            DefaultHolder defaultHolder = this.target;
            if (defaultHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            defaultHolder.ivImg = null;
            defaultHolder.songTitle = null;
            defaultHolder.songArtists = null;
            defaultHolder.ivMenu = null;
            defaultHolder.view = null;
        }
    }

    /* loaded from: classes.dex */
    public class FootHolder_ViewBinding implements Unbinder {
        private FootHolder target;

        @UiThread
        public FootHolder_ViewBinding(FootHolder footHolder, View view) {
            this.target = footHolder;
            footHolder.llMore = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.ll_more, "field 'llMore'", RelativeLayout.class);
            footHolder.tvArtist = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_artists, "field 'tvArtist'", LaToTextView.class);
            footHolder.tvArtist2 = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_artists2, "field 'tvArtist2'", LaToTextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            FootHolder footHolder = this.target;
            if (footHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            footHolder.llMore = null;
            footHolder.tvArtist = null;
            footHolder.tvArtist2 = null;
        }
    }

    /* loaded from: classes.dex */
    public class PlayAllHolder_ViewBinding implements Unbinder {
        private PlayAllHolder target;

        @UiThread
        public PlayAllHolder_ViewBinding(PlayAllHolder playAllHolder, View view) {
            this.target = playAllHolder;
            playAllHolder.tvCount = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_count, "field 'tvCount'", TextView.class);
            playAllHolder.rlPlay = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_play, "field 'rlPlay'", RelativeLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            PlayAllHolder playAllHolder = this.target;
            if (playAllHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            playAllHolder.tvCount = null;
            playAllHolder.rlPlay = null;
        }
    }

    public LocalArtistsSongAdapter(Context context, FragmentManager fragmentManager) {
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == getItemCount() + (-1) ? 3 : 2;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 3) {
            this.footHolder = new FootHolder(LayoutInflater.from(this.context).inflate(R.layout.local_song_artists, viewGroup, false));
            return this.footHolder;
        }
        return new DefaultHolder(LayoutInflater.from(this.context).inflate(R.layout.local_song_list, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (this.localSongBeen != null && this.localSongBeen.size() > 0) {
            switch (getItemViewType(i)) {
                case 2:
                    bindHolder((DefaultHolder) viewHolder, i);
                    return;
                case 3:
                    bindFootHolder(this.name);
                    return;
                default:
                    return;
            }
        }
    }

    private void bindHolder(DefaultHolder defaultHolder, final int i) {
        defaultHolder.songTitle.setText(this.localSongBeen.get(i).songName);
        defaultHolder.songArtists.setText(this.localSongBeen.get(i).artistName);
        i.c(MusicApplication.c()).a(this.localSongBeen.get(i).albumData).d((int) R.mipmap.icon_playlist_default).a(defaultHolder.ivImg);
        defaultHolder.ivMenu.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.holder.LocalArtistsSongAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.b("本地音乐-歌手详情页--打开菜单列表");
                new LocalMusicMenuDialog.a(LocalArtistsSongAdapter.this.fragmentManager).b(true).d(true).c(true).a(true).a((LocalSongBean) LocalArtistsSongAdapter.this.localSongBeen.get(i)).a().e();
            }
        });
        defaultHolder.itemView.setOnClickListener(new View.OnClickListener(this, i) { // from class: com.fotoable.youtube.music.ui.adapter.holder.LocalArtistsSongAdapter$$Lambda$0
            private final LocalArtistsSongAdapter arg$1;
            private final int arg$2;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
                this.arg$2 = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.arg$1.lambda$bindHolder$0$LocalArtistsSongAdapter(this.arg$2, view);
            }
        });
        if (this.localSongBeen.size() - 1 == i) {
            defaultHolder.view.setVisibility(8);
        } else {
            defaultHolder.view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$bindHolder$0$LocalArtistsSongAdapter(int i, View view) {
        if (this.localSongBeen != null && this.localSongBeen.size() > 0) {
            b.b("歌手详情页--播放单曲");
            com.fotoable.youtube.music.e.b.a().a(new a(2101, com.fotoable.youtube.music.newplayer.a.a.a(this.localSongBeen), i));
        }
    }

    private void bindHolder(PlayAllHolder playAllHolder) {
        playAllHolder.rlPlay.setVisibility(8);
    }

    public void bindFootHolder(String str) {
        if (this.footHolder != null) {
            if (!TextUtils.isEmpty(str)) {
                this.footHolder.llMore.setVisibility(0);
            } else {
                this.footHolder.llMore.setVisibility(8);
            }
            this.footHolder.itemView.setOnClickListener(new View.OnClickListener(this) { // from class: com.fotoable.youtube.music.ui.adapter.holder.LocalArtistsSongAdapter$$Lambda$1
                private final LocalArtistsSongAdapter arg$1;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.arg$1 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.arg$1.lambda$bindFootHolder$1$LocalArtistsSongAdapter(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$bindFootHolder$1$LocalArtistsSongAdapter(View view) {
        if (this.clickListener != null) {
            this.clickListener.onClickFoot();
        }
    }

    public void setOnFootClickListener(onFootClickListener onfootclicklistener) {
        this.clickListener = onfootclicklistener;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.localSongBeen != null && this.localSongBeen.size() > 0) {
            return this.localSongBeen.size() + 1;
        }
        return 0;
    }

    public void setData(List<LocalSongBean> list) {
        this.localSongBeen = list;
        notifyDataSetChanged();
    }

    /* loaded from: classes.dex */
    public class DefaultHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_img)
        ImageView ivImg;
        @BindView(R.id.iv_menu)
        ImageView ivMenu;
        @BindView(R.id.song_artists)
        TextView songArtists;
        @BindView(R.id.song_title)
        TextView songTitle;
        @BindView(R.id.view)
        View view;

        public DefaultHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /* loaded from: classes.dex */
    public class FootHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ll_more)
        RelativeLayout llMore;
        @BindView(R.id.tv_artists)
        LaToTextView tvArtist;
        @BindView(R.id.tv_artists2)
        LaToTextView tvArtist2;

        public FootHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /* loaded from: classes.dex */
    public class PlayAllHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rl_play)
        RelativeLayout rlPlay;
        @BindView(R.id.tv_count)
        TextView tvCount;

        public PlayAllHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    public void destory() {
        if (this.recyclerView != null) {
            try {
                this.recyclerView.removeAllViews();
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
        if (this.localSongBeen != null) {
            this.localSongBeen.clear();
            this.localSongBeen = null;
        }
    }

    public void setName(String str) {
        this.name = str;
    }
}

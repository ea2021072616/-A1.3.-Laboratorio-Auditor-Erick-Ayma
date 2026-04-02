package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.fotoable.youtube.music.newplayer.e;
import com.fotoable.youtube.music.ui.dialog.LocalMusicMenuDialog;
import com.fotoable.youtube.music.util.b;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.List;
/* loaded from: classes.dex */
public class LocalSongAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_DEFAULT = 2;
    private static final int TYPE_PALY_ALL = 1;
    private Context context;
    private FragmentManager fragmentManager;
    boolean isShowShuffle;
    private List<LocalSongBean> localSongBeen;
    private RecyclerView recyclerView;

    /* loaded from: classes.dex */
    public class PlayAllHolder_ViewBinding implements Unbinder {
        private PlayAllHolder target;

        @UiThread
        public PlayAllHolder_ViewBinding(PlayAllHolder playAllHolder, View view) {
            this.target = playAllHolder;
            playAllHolder.tvCount = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_count, "field 'tvCount'", TextView.class);
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
        }
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

    public LocalSongAdapter(Context context, FragmentManager fragmentManager) {
        this.isShowShuffle = false;
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.isShowShuffle = false;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (i == 0 && this.isShowShuffle) ? 1 : 2;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return (i == 1 && this.isShowShuffle) ? new PlayAllHolder(LayoutInflater.from(this.context).inflate(R.layout.local_song_playall, viewGroup, false)) : new DefaultHolder(LayoutInflater.from(this.context).inflate(R.layout.local_song_list, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (this.localSongBeen != null && this.localSongBeen.size() > 0) {
            if (i == 0 && this.isShowShuffle) {
                bindHolder((PlayAllHolder) viewHolder);
                return;
            }
            DefaultHolder defaultHolder = (DefaultHolder) viewHolder;
            if (this.isShowShuffle) {
                i--;
            }
            bindHolder(defaultHolder, i);
        }
    }

    private void bindHolder(DefaultHolder defaultHolder, final int i) {
        defaultHolder.songTitle.setText(this.localSongBeen.get(i).songName);
        defaultHolder.songArtists.setText(this.localSongBeen.get(i).artistName);
        i.c(MusicApplication.c()).a(this.localSongBeen.get(i).albumData).d((int) R.drawable.local_song_def_cover).c((int) R.drawable.local_song_def_cover).a(defaultHolder.ivImg);
        defaultHolder.ivMenu.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.LocalSongAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.b("单曲页面--打开菜单列表");
                new LocalMusicMenuDialog.a(LocalSongAdapter.this.fragmentManager).b(true).d(true).c(true).a(true).a((LocalSongBean) LocalSongAdapter.this.localSongBeen.get(i)).a().e();
            }
        });
        defaultHolder.itemView.setOnClickListener(new View.OnClickListener(this, i) { // from class: com.fotoable.youtube.music.ui.adapter.LocalSongAdapter$$Lambda$0
            private final LocalSongAdapter arg$1;
            private final int arg$2;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
                this.arg$2 = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.arg$1.lambda$bindHolder$0$LocalSongAdapter(this.arg$2, view);
            }
        });
        if (i == this.localSongBeen.size() - 1) {
            defaultHolder.view.setVisibility(8);
        } else {
            defaultHolder.view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$bindHolder$0$LocalSongAdapter(int i, View view) {
        b.b("单曲页面--播放单曲");
        if (this.localSongBeen != null && this.localSongBeen.size() > 0) {
            com.fotoable.youtube.music.e.b.a().a(new a(2101, com.fotoable.youtube.music.newplayer.a.a.a(this.localSongBeen), i));
        }
    }

    private void bindHolder(PlayAllHolder playAllHolder) {
        playAllHolder.tvCount.setText("(" + this.localSongBeen.size() + ")");
        playAllHolder.itemView.setOnClickListener(new View.OnClickListener(this) { // from class: com.fotoable.youtube.music.ui.adapter.LocalSongAdapter$$Lambda$1
            private final LocalSongAdapter arg$1;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.arg$1.lambda$bindHolder$1$LocalSongAdapter(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$bindHolder$1$LocalSongAdapter(View view) {
        if (this.localSongBeen != null && this.localSongBeen.size() > 0) {
            b.b("单曲页面--随机播放全部单曲");
            com.fotoable.youtube.music.a.b(2);
            e.a().f(2);
            com.fotoable.youtube.music.e.b.a().a(new a(2104, com.fotoable.youtube.music.newplayer.a.a.a(this.localSongBeen)));
        }
    }

    public List<LocalSongBean> getData() {
        return this.localSongBeen;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.localSongBeen != null && this.localSongBeen.size() > 0) {
            return this.isShowShuffle ? this.localSongBeen.size() + 1 : this.localSongBeen.size();
        }
        return 0;
    }

    public void setData(List<LocalSongBean> list) {
        this.localSongBeen = list;
        notifyDataSetChanged();
    }

    public void setShowShuffle(boolean z) {
        this.isShowShuffle = z;
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
    public class PlayAllHolder extends RecyclerView.ViewHolder {
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

    public void destroy() {
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
}

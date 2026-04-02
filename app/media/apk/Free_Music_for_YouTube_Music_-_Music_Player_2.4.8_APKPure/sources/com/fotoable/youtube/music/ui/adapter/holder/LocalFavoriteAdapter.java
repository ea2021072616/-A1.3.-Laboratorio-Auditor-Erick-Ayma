package com.fotoable.youtube.music.ui.adapter.holder;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
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
import com.fotoable.youtube.music.util.b;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.List;
/* loaded from: classes.dex */
public class LocalFavoriteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_DEFAULT = 2;
    private static final int TYPE_PALY_ALL = 1;
    private Context context;
    private OnDeleteListener deleteListener;
    private List<LocalSongBean> localSongBeen;
    private RecyclerView recyclerView;

    /* loaded from: classes.dex */
    public interface OnDeleteListener {
        void OnClick(View view, Long l);
    }

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

    public LocalFavoriteAdapter(Context context) {
        this.context = context;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? 1 : 2;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new PlayAllHolder(LayoutInflater.from(this.context).inflate(R.layout.local_song_playall, viewGroup, false)) : new DefaultHolder(LayoutInflater.from(this.context).inflate(R.layout.local_song_favorite, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (this.localSongBeen != null && this.localSongBeen.size() > 0) {
            switch (getItemViewType(i)) {
                case 1:
                    bindHolder((PlayAllHolder) viewHolder);
                    return;
                case 2:
                    bindHolder((DefaultHolder) viewHolder, i - 1);
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
        defaultHolder.ivMenu.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.holder.LocalFavoriteAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (((LocalSongBean) LocalFavoriteAdapter.this.localSongBeen.get(i)).songId != null) {
                    LocalFavoriteAdapter.this.deleteListener.OnClick(view, ((LocalSongBean) LocalFavoriteAdapter.this.localSongBeen.get(i)).songId);
                }
            }
        });
        defaultHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.holder.LocalFavoriteAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.b("本地收藏页面--播放收藏");
                com.fotoable.youtube.music.e.b.a().a(new a(2101, com.fotoable.youtube.music.newplayer.a.a.a(LocalFavoriteAdapter.this.localSongBeen), i));
            }
        });
        if (this.localSongBeen.size() - 1 == i) {
            defaultHolder.view.setVisibility(8);
        } else {
            defaultHolder.view.setVisibility(0);
        }
    }

    public void SetOnDeleteListener(OnDeleteListener onDeleteListener) {
        this.deleteListener = onDeleteListener;
    }

    private void bindHolder(PlayAllHolder playAllHolder) {
        playAllHolder.tvCount.setText(this.context.getResources().getString(R.string.local_music_count, Integer.valueOf(this.localSongBeen.size())));
        playAllHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.holder.LocalFavoriteAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.b("本地收藏页面--播放全部收藏");
                com.fotoable.youtube.music.e.b.a().a(new a(2101, com.fotoable.youtube.music.newplayer.a.a.a(LocalFavoriteAdapter.this.localSongBeen), 0));
            }
        });
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
}

package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bumptech.glide.i;
import com.bumptech.glide.load.b.b;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.LocalArtistsBean;
import com.fotoable.youtube.music.ui.activity.LocalArtistsDetailActivity;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.util.h;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.List;
/* loaded from: classes.dex */
public class LocalArtistsAdapter extends RecyclerView.Adapter<DefaultHolder> {
    private static final String TAG = LocalArtistsAdapter.class.getSimpleName();
    private Context context;
    private List<LocalArtistsBean> localArtistsBean;
    private RecyclerView recyclerView;

    /* loaded from: classes.dex */
    public class DefaultHolder_ViewBinding implements Unbinder {
        private DefaultHolder target;

        @UiThread
        public DefaultHolder_ViewBinding(DefaultHolder defaultHolder, View view) {
            this.target = defaultHolder;
            defaultHolder.ivImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.iv_img, "field 'ivImg'", RoundedImageView.class);
            defaultHolder.songTitle = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.song_title, "field 'songTitle'", LaToTextView.class);
            defaultHolder.songArtists = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.song_artists, "field 'songArtists'", LaToTextView.class);
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
            defaultHolder.view = null;
        }
    }

    public LocalArtistsAdapter(Context context) {
        this.context = context;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public DefaultHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new DefaultHolder(LayoutInflater.from(this.context).inflate(R.layout.local_artists_list, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(DefaultHolder defaultHolder, int i) {
        if (this.localArtistsBean != null && this.localArtistsBean.size() > 0) {
            bindHolder(defaultHolder, i);
        }
    }

    private void bindHolder(DefaultHolder defaultHolder, final int i) {
        defaultHolder.songTitle.setText(this.localArtistsBean.get(i).artist_name);
        defaultHolder.songArtists.setText(this.context.getString(R.string.local_music_count, Integer.valueOf(this.localArtistsBean.get(i).number_of_tracks)));
        i.c(this.context).a(this.localArtistsBean.get(i).artists_art).b(b.ALL).d((int) R.mipmap.artist_listdefault).c((int) R.mipmap.artist_listdefault).i().a().a(defaultHolder.ivImg);
        h.a(TAG, "作者名称:" + this.localArtistsBean.get(i).artist_name + "\n头像地址:" + this.localArtistsBean.get(i).artists_art);
        if (this.localArtistsBean.size() - 1 == i) {
            defaultHolder.view.setVisibility(8);
        } else {
            defaultHolder.view.setVisibility(0);
        }
        defaultHolder.itemView.setOnClickListener(new View.OnClickListener(this, i) { // from class: com.fotoable.youtube.music.ui.adapter.LocalArtistsAdapter$$Lambda$0
            private final LocalArtistsAdapter arg$1;
            private final int arg$2;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
                this.arg$2 = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.arg$1.lambda$bindHolder$0$LocalArtistsAdapter(this.arg$2, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$bindHolder$0$LocalArtistsAdapter(int i, View view) {
        com.fotoable.youtube.music.util.b.b("歌手页面--进入歌手详情页");
        Intent intent = new Intent(this.context, LocalArtistsDetailActivity.class);
        intent.putExtra(ShareConstants.WEB_DIALOG_PARAM_DATA, this.localArtistsBean.get(i).artist_id);
        intent.putExtra("name", this.localArtistsBean.get(i).artist_name);
        intent.putExtra("url", this.localArtistsBean.get(i).artists_art);
        this.context.startActivity(intent);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.localArtistsBean != null && this.localArtistsBean.size() > 0) {
            return this.localArtistsBean.size();
        }
        return 0;
    }

    public void setData(List<LocalArtistsBean> list) {
        if (this.localArtistsBean != null) {
            this.localArtistsBean.clear();
            this.localArtistsBean.addAll(list);
        } else {
            this.localArtistsBean = list;
        }
        notifyDataSetChanged();
    }

    public void notifyCover(long j, String str) {
        boolean z = false;
        if (this.localArtistsBean != null) {
            int i = 0;
            while (true) {
                if (i >= this.localArtistsBean.size()) {
                    break;
                } else if (this.localArtistsBean.get(i).artist_id != j) {
                    i++;
                } else {
                    this.localArtistsBean.get(i).artists_art = str;
                    z = true;
                    break;
                }
            }
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes.dex */
    public class DefaultHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_img)
        RoundedImageView ivImg;
        @BindView(R.id.song_artists)
        LaToTextView songArtists;
        @BindView(R.id.song_title)
        LaToTextView songTitle;
        @BindView(R.id.view)
        View view;

        public DefaultHolder(View view) {
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
        if (this.localArtistsBean != null) {
            this.localArtistsBean.clear();
            this.localArtistsBean = null;
        }
    }
}

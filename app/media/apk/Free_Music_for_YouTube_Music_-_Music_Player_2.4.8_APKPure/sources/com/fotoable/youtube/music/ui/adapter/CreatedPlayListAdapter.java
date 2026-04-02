package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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
import com.bumptech.glide.load.resource.bitmap.e;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.PlayListModel;
import com.fotoable.youtube.music.db.a;
import com.fotoable.youtube.music.ui.activity.MyPlaylistDetailActivity;
import com.fotoable.youtube.music.ui.view.GlideRoundTransform;
import com.fotoable.youtube.music.util.h;
import com.fotoable.youtube.music.util.v;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class CreatedPlayListAdapter extends BaseAdapter<ViewHolder> {
    private Context context;
    private Map<Long, Long> countMap = new HashMap();
    private List<PlayListModel> data;
    private a helper;
    private Long id;
    private String title;

    /* loaded from: classes.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.ivPlaylist = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_playlist, "field 'ivPlaylist'", ImageView.class);
            viewHolder.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
            viewHolder.tvSize = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_size, "field 'tvSize'", TextView.class);
            viewHolder.view = Utils.findRequiredView(view, R.id.view, "field 'view'");
            viewHolder.ivCoverImageView = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_playlist_cover, "field 'ivCoverImageView'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            viewHolder.ivPlaylist = null;
            viewHolder.tvTitle = null;
            viewHolder.tvSize = null;
            viewHolder.view = null;
            viewHolder.ivCoverImageView = null;
        }
    }

    public CreatedPlayListAdapter(Context context, List<PlayListModel> list, a aVar) {
        this.context = context;
        this.data = list;
        this.helper = aVar;
        setHasStableIds(true);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.item_created_list, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if (i == 0) {
            viewHolder.tvTitle.setText(R.string.my_favorite);
            if (TextUtils.isEmpty(getFavoriteImage())) {
                viewHolder.ivCoverImageView.setVisibility(8);
                i.c(this.context).a(Integer.valueOf((int) R.mipmap.icon_myfavoriteplaylist)).d((int) R.mipmap.icon_myfavoriteplaylist).a(viewHolder.ivPlaylist);
            } else {
                viewHolder.ivCoverImageView.setVisibility(0);
                i.c(this.context).a(getFavoriteImage()).a(new e(this.context), new GlideRoundTransform(this.context, 5)).c().a(viewHolder.ivPlaylist);
            }
            getFavoriteCount(viewHolder.tvSize);
        } else {
            viewHolder.ivCoverImageView.setVisibility(8);
            PlayListModel playListModel = this.data.get(i - 1);
            if (this.id == playListModel.getId()) {
                playListModel.setName(this.title);
            }
            viewHolder.tvTitle.setText(playListModel.getName());
            if (this.context != null) {
                i.c(this.context).a(playListModel.getCover()).a(new e(this.context), new GlideRoundTransform(this.context, 5)).c().d((int) R.mipmap.icon_playlist_default).a(viewHolder.ivPlaylist);
            } else {
                viewHolder.ivPlaylist.setImageResource(R.mipmap.icon_playlist_default);
            }
            h.a(playListModel.getId() + "");
            getPlaylistSongsCount(viewHolder.tvSize, i);
        }
        if (getItemCount() - 1 == i) {
            viewHolder.view.setVisibility(8);
        }
        setOnclickEvent(i, viewHolder.itemView);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.data != null && this.data.size() > 0) {
            return this.data.size() + 1;
        }
        return 1;
    }

    private String getFavoriteImage() {
        return v.a(this.context, "last_favorite_cover", "");
    }

    private void getPlaylistSongsCount(TextView textView, int i) {
        if (this.data != null) {
            Long id = this.data.get(i - 1).getId();
            if (this.countMap.keySet().contains(id)) {
                textView.setText(this.countMap.get(id) + " " + this.context.getResources().getString(R.string.songs));
                return;
            }
            this.countMap.put(id, Long.valueOf(this.helper.c(this.data.get(i - 1).getId())));
            textView.setText(this.countMap.get(id) + " " + this.context.getResources().getString(R.string.songs));
        }
    }

    private void setOnclickEvent(final int i, View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.CreatedPlayListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Intent intent = new Intent(CreatedPlayListAdapter.this.context, MyPlaylistDetailActivity.class);
                if (i != 0) {
                    if (CreatedPlayListAdapter.this.data != null) {
                        intent.putExtra("EXTRA_TYPE_KEY", "EXTRA_PLAYLIST_TYPE");
                        intent.putExtra("EXTRA_ID_KEY", ((PlayListModel) CreatedPlayListAdapter.this.data.get(i - 1)).getId());
                    } else {
                        return;
                    }
                } else {
                    intent.putExtra("EXTRA_TYPE_KEY", "EXTRA_FAVORITE_TYPE");
                }
                CreatedPlayListAdapter.this.context.startActivity(intent);
            }
        });
    }

    private void getFavoriteCount(TextView textView) {
        if (this.countMap.keySet().contains(-1L)) {
            textView.setText(this.countMap.get(-1L) + " " + this.context.getResources().getString(R.string.songs));
            return;
        }
        this.countMap.put(-1L, Long.valueOf(this.helper.d()));
        textView.setText(this.countMap.get(-1L) + " " + this.context.getResources().getString(R.string.songs));
    }

    /* loaded from: classes.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_playlist_cover)
        ImageView ivCoverImageView;
        @BindView(R.id.iv_playlist)
        ImageView ivPlaylist;
        @BindView(R.id.tv_size)
        TextView tvSize;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.view)
        View view;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void updateName(Long l, String str) {
        this.id = l;
        this.title = str;
        notifyDataSetChanged();
    }

    public void updateCount(Long l) {
        if (this.countMap.keySet().contains(l)) {
            long longValue = this.countMap.get(l).longValue();
            this.countMap.remove(l);
            this.countMap.put(l, Long.valueOf(longValue - 1));
        }
        notifyDataSetChanged();
    }

    public void delete(Long l) {
        for (PlayListModel playListModel : this.data) {
            if (playListModel.getId() == l) {
                if (this.data != null) {
                    this.data.remove(playListModel);
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void add(PlayListModel playListModel) {
        if (this.data != null) {
            this.data.add(playListModel);
            notifyDataSetChanged();
        }
    }

    @Override // com.fotoable.youtube.music.ui.adapter.BaseAdapter
    public void onDestroy() {
        if (this.data != null) {
            this.data = null;
        }
        if (this.context != null) {
            this.context = null;
        }
        if (this.helper != null) {
            this.helper = null;
        }
    }
}

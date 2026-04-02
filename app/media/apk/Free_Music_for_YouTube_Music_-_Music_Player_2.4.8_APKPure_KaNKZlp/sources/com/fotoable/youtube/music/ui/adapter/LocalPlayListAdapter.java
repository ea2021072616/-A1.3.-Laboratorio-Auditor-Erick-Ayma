package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.i;
import com.bumptech.glide.load.resource.bitmap.e;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.LocalPlayListBean;
import com.fotoable.youtube.music.bean.LocalPlayListModel;
import com.fotoable.youtube.music.bean.LocalPlayListParentBean;
import com.fotoable.youtube.music.ui.activity.LocalCreatedPlaylistDetailActivity;
import com.fotoable.youtube.music.ui.view.GlideRoundTransform;
/* loaded from: classes.dex */
public class LocalPlayListAdapter extends BaseAdapter<LocalPlayListHolder> {
    private Context context;
    private LayoutInflater inflater;
    private LocalPlayListParentBean localPlayListParentBean;

    public LocalPlayListAdapter(Context context, LocalPlayListParentBean localPlayListParentBean) {
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);
        this.localPlayListParentBean = localPlayListParentBean;
    }

    @Override // com.fotoable.youtube.music.ui.adapter.BaseAdapter
    public void onDestroy() {
        this.context = null;
        this.inflater = null;
        this.localPlayListParentBean = null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public LocalPlayListHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new LocalPlayListHolder(this.inflater.inflate(R.layout.item_local_play_list, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(LocalPlayListHolder localPlayListHolder, final int i) {
        final LocalPlayListModel localPlayListModel;
        final LocalPlayListBean localPlayListBean;
        if (i < this.localPlayListParentBean.getLocalPlayListBeanList().size()) {
            LocalPlayListBean localPlayListBean2 = this.localPlayListParentBean.getLocalPlayListBeanList().get(i);
            if (localPlayListBean2 != null) {
                if (localPlayListBean2.getCount() > 0) {
                    i.c(this.context).a(localPlayListBean2.getCoverUrl()).d(localPlayListBean2.getCoverDefId()).a(new e(this.context), new GlideRoundTransform(this.context, 3)).i().c(localPlayListBean2.getCoverDefId()).a(localPlayListHolder.playlist_cover);
                    i.c(this.context).a(Integer.valueOf(localPlayListBean2.getCoverHintId())).a(localPlayListHolder.playlist_hint);
                    localPlayListHolder.playlist_hint.setVisibility(0);
                } else {
                    localPlayListHolder.playlist_hint.setVisibility(8);
                    i.c(this.context).a(Integer.valueOf(localPlayListBean2.getCoverDefId())).a(localPlayListHolder.playlist_cover);
                }
                localPlayListHolder.playlist_title.setText(localPlayListBean2.getTitle());
                localPlayListHolder.playlist_size.setText(this.context.getString(R.string.create_playlist_size, Integer.valueOf(localPlayListBean2.getCount())));
                localPlayListBean = localPlayListBean2;
                localPlayListModel = null;
            } else {
                return;
            }
        } else if (i - this.localPlayListParentBean.getLocalPlayListBeanList().size() >= this.localPlayListParentBean.getLocalPlayListModelList().size()) {
            localPlayListModel = null;
            localPlayListBean = null;
        } else {
            localPlayListModel = this.localPlayListParentBean.getLocalPlayListModelList().get(i - this.localPlayListParentBean.getLocalPlayListBeanList().size());
            if (localPlayListModel.getMusicCount() > 0) {
                i.c(this.context).a(localPlayListModel.getCover()).d((int) R.mipmap.play_lists_default).i().a(new e(this.context), new GlideRoundTransform(this.context, 3)).c((int) R.mipmap.play_lists_default).a(localPlayListHolder.playlist_cover);
                localPlayListHolder.playlist_hint.setVisibility(8);
            } else {
                localPlayListHolder.playlist_hint.setVisibility(8);
                i.c(this.context).a(Integer.valueOf((int) R.mipmap.icon_bigplaylistdefault)).a(localPlayListHolder.playlist_cover);
            }
            localPlayListHolder.playlist_title.setText(localPlayListModel.getName());
            localPlayListHolder.playlist_size.setText(this.context.getString(R.string.create_playlist_size, Integer.valueOf(localPlayListModel.getMusicCount())));
            localPlayListBean = null;
        }
        if (i == getItemCount() - 1) {
            localPlayListHolder.line_view.setVisibility(8);
        } else {
            localPlayListHolder.line_view.setVisibility(0);
        }
        localPlayListHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.LocalPlayListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i != 0 && i != 1 && i == 2) {
                }
                Intent intent = new Intent(LocalPlayListAdapter.this.context, LocalCreatedPlaylistDetailActivity.class);
                intent.putExtra("position", i);
                intent.putExtra("model", localPlayListBean != null ? localPlayListBean : localPlayListModel);
                LocalPlayListAdapter.this.context.startActivity(intent);
            }
        });
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.localPlayListParentBean != null) {
            int size = this.localPlayListParentBean.getLocalPlayListBeanList() != null ? 0 + this.localPlayListParentBean.getLocalPlayListBeanList().size() : 0;
            if (this.localPlayListParentBean.getLocalPlayListModelList() != null) {
                return size + this.localPlayListParentBean.getLocalPlayListModelList().size();
            }
            return size;
        }
        return 0;
    }

    public void notifyData(LocalPlayListParentBean localPlayListParentBean) {
        this.localPlayListParentBean = localPlayListParentBean;
        notifyDataSetChanged();
    }

    /* loaded from: classes.dex */
    public static class LocalPlayListHolder extends RecyclerView.ViewHolder {
        public View line_view;
        public ImageView playlist_cover;
        public ImageView playlist_hint;
        public TextView playlist_size;
        public TextView playlist_title;

        public LocalPlayListHolder(View view) {
            super(view);
            this.playlist_cover = (ImageView) view.findViewById(R.id.playlist_cover);
            this.playlist_hint = (ImageView) view.findViewById(R.id.playlist_hint);
            this.playlist_title = (TextView) view.findViewById(R.id.playlist_title);
            this.playlist_size = (TextView) view.findViewById(R.id.playlist_size);
            this.line_view = view.findViewById(R.id.line_view);
        }
    }
}

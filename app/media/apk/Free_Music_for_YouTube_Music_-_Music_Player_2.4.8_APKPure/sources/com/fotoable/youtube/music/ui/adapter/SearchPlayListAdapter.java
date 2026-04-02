package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.bumptech.glide.load.resource.bitmap.e;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.SearchItemBean;
import com.fotoable.youtube.music.ui.activity.PlayListDetailsActivity;
import com.fotoable.youtube.music.ui.view.GlideRoundTransform;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SearchPlayListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<SearchItemBean> allData = new ArrayList();
    private Context mContext;
    private LayoutInflater mInflater;
    private int source;

    /* loaded from: classes.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.mPlaylistCoverImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.adapter_search_playlist_cover_img, "field 'mPlaylistCoverImg'", ImageView.class);
            viewHolder.mPlaylistNameTx = (TextView) Utils.findRequiredViewAsType(view, R.id.adapter_search_playlist_name_tx, "field 'mPlaylistNameTx'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            viewHolder.mPlaylistCoverImg = null;
            viewHolder.mPlaylistNameTx = null;
        }
    }

    public SearchPlayListAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void refresh(List<SearchItemBean> list) {
        if (list != null) {
            clearData();
            addData(list);
        }
    }

    public void addData(List<SearchItemBean> list) {
        if (list != null) {
            int size = this.allData.size();
            int size2 = list.size();
            this.allData.addAll(list);
            if (size > 0 && size2 > 0) {
                notifyItemRangeInserted(size, size2);
            } else {
                notifyDataSetChanged();
            }
        }
    }

    public void clearData() {
        int size = this.allData.size();
        this.allData.clear();
        notifyItemRangeRemoved(0, size);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this.mInflater.inflate(R.layout.view_holder_search_playlist, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        SearchItemBean searchItemBean = this.allData.get(i);
        viewHolder.mPlaylistNameTx.setText(searchItemBean.getSnippet().getTitle());
        if (searchItemBean.getSnippet().getThumbnails() != null && searchItemBean.getSnippet().getThumbnails().getMedium() != null) {
            i.c(this.mContext).a(searchItemBean.getSnippet().getThumbnails().getMedium().getUrl()).a(new e(this.mContext), new GlideRoundTransform(this.mContext, 5)).c().d((int) R.mipmap.icon_bigplaylistdefault).c((int) R.mipmap.icon_bigplaylistdefault).a(viewHolder.mPlaylistCoverImg);
        }
        gotoPlayList(viewHolder.itemView, searchItemBean);
    }

    private void gotoPlayList(View view, final SearchItemBean searchItemBean) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.SearchPlayListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Intent intent = new Intent(SearchPlayListAdapter.this.mContext, PlayListDetailsActivity.class);
                if (SearchPlayListAdapter.this.source != 0) {
                    intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, SearchPlayListAdapter.this.source);
                }
                intent.putExtra("PlaylistId", searchItemBean.getId().getPlaylistId());
                if (searchItemBean.getSnippet().getThumbnails() != null && searchItemBean.getSnippet().getThumbnails().getMedium() != null) {
                    intent.putExtra("ImgUrl", searchItemBean.getSnippet().getThumbnails().getMedium().getUrl());
                }
                intent.putExtra("Describe", searchItemBean.getSnippet().getDescription());
                intent.putExtra("Title", searchItemBean.getSnippet().getTitle());
                SearchPlayListAdapter.this.mContext.startActivity(intent);
            }
        });
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.allData.size();
    }

    public void setSource(int i) {
        this.source = i;
    }

    /* loaded from: classes.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.adapter_search_playlist_cover_img)
        ImageView mPlaylistCoverImg;
        @BindView(R.id.adapter_search_playlist_name_tx)
        TextView mPlaylistNameTx;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

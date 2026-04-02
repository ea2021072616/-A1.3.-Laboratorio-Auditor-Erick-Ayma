package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.app.FragmentManager;
import android.support.v4.internal.view.SupportMenu;
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
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.FavBean;
import com.fotoable.youtube.music.bean.SearchItemBean;
import com.fotoable.youtube.music.bean.SnippetBean;
import com.fotoable.youtube.music.db.a;
import com.fotoable.youtube.music.newplayer.a.b;
import com.fotoable.youtube.music.ui.activity.ArtistsDetailActivity;
import com.fotoable.youtube.music.ui.dialog.MusicMenuDialog;
import com.fotoable.youtube.music.util.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class SearchSongsAdapter extends RecyclerView.Adapter<ViewHolder> {
    private FragmentManager fragmentManager;
    private a helper;
    boolean isSelectedMusic;
    private Context mContext;
    private LayoutInflater mInflater;
    private OnItemClickListener onItemClickListener;
    private String playingId;
    private List<SearchItemBean> allData = new ArrayList();
    private HashMap<String, String> map = new HashMap<>();

    /* loaded from: classes.dex */
    public interface OnItemClickListener {
        void onAddToPlayQueue(SearchItemBean searchItemBean);

        void onPlayNext(SearchItemBean searchItemBean);

        void onPlayNow(SearchItemBean searchItemBean);
    }

    /* loaded from: classes.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.mSongNameTx = (TextView) Utils.findRequiredViewAsType(view, R.id.adapter_search_song_name_tx, "field 'mSongNameTx'", TextView.class);
            viewHolder.mSongMenuImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.adapter_search_song_menu_img, "field 'mSongMenuImg'", ImageView.class);
            viewHolder.mCoverImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.adapter_search_song_cover_img, "field 'mCoverImg'", ImageView.class);
            viewHolder.durationTextView = (TextView) Utils.findRequiredViewAsType(view, R.id.adapter_search_song_duration_tx, "field 'durationTextView'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            viewHolder.mSongNameTx = null;
            viewHolder.mSongMenuImg = null;
            viewHolder.mCoverImg = null;
            viewHolder.durationTextView = null;
        }
    }

    public SearchSongsAdapter(Context context, a aVar, FragmentManager fragmentManager) {
        this.mContext = context;
        this.helper = aVar;
        this.fragmentManager = fragmentManager;
        this.mInflater = LayoutInflater.from(context);
        setHasStableIds(true);
    }

    public void setSelectedMusic(boolean z) {
        this.isSelectedMusic = z;
    }

    public void refresh(List<SearchItemBean> list) {
        if (list != null) {
            clearData();
            addData(list);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public List<SearchItemBean> getAllData() {
        return this.allData;
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
            m.a().a(getIds(list), this.map, new m.a() { // from class: com.fotoable.youtube.music.ui.adapter.SearchSongsAdapter.1
                @Override // com.fotoable.youtube.music.util.m.a
                public void onDuration(HashMap<String, String> hashMap) {
                    SearchSongsAdapter.this.notifyDataSetChanged();
                }
            });
        }
    }

    private List<String> getIds(List<SearchItemBean> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                arrayList.add(list.get(i2).getId().getVideoId());
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    public void clearData() {
        this.allData.clear();
        notifyDataSetChanged();
    }

    public void setPlayingId(String str) {
        this.playingId = str;
        notifyDataSetChanged();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this.mInflater.inflate(R.layout.view_holder_search_songs, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        SearchItemBean searchItemBean = this.allData.get(i);
        viewHolder.mSongNameTx.setText(searchItemBean.getSnippet().getTitle());
        if (!TextUtils.isEmpty(this.map.get(searchItemBean.getId().getVideoId()))) {
            searchItemBean.getSnippet().setDuration(this.map.get(searchItemBean.getId().getVideoId()));
            viewHolder.durationTextView.setText(this.map.get(searchItemBean.getId().getVideoId()));
            viewHolder.durationTextView.setVisibility(0);
        } else {
            viewHolder.durationTextView.setVisibility(8);
        }
        if (searchItemBean.getSnippet().getThumbnails() != null && searchItemBean.getSnippet().getThumbnails().getMedium() != null) {
            i.c(this.mContext).a(searchItemBean.getSnippet().getThumbnails().getMedium().getUrl()).a().d((int) R.mipmap.icon_playlist_default).a(viewHolder.mCoverImg);
        } else {
            viewHolder.mCoverImg.setImageResource(R.mipmap.icon_playlist_default);
        }
        if (searchItemBean.getId() != null && searchItemBean.getId().getVideoId() != null && searchItemBean.getId().getVideoId().equals(this.playingId)) {
            viewHolder.mSongNameTx.setTextColor(SupportMenu.CATEGORY_MASK);
        } else {
            viewHolder.mSongNameTx.setTextColor(this.mContext.getResources().getColor(R.color.color_2b2525));
        }
        if (this.isSelectedMusic) {
            viewHolder.mSongMenuImg.setVisibility(8);
        } else {
            viewHolder.mSongMenuImg.setVisibility(0);
            setMoreActionListener(viewHolder.mSongMenuImg, searchItemBean, i);
        }
        setPlayAction(viewHolder.itemView, searchItemBean);
    }

    private FavBean getFavBean(SearchItemBean searchItemBean) {
        SnippetBean snippet = searchItemBean.getSnippet();
        FavBean favBean = new FavBean();
        if (snippet != null) {
            favBean.setTitle(snippet.getTitle());
            favBean.setVideoid(searchItemBean.getId().getVideoId());
            favBean.setDesc(snippet.getDescription());
            favBean.setDuration(this.map.get(searchItemBean.getId().getVideoId()));
            if (snippet.getThumbnails() != null && snippet.getThumbnails().getMedium() != null) {
                favBean.setImgUrl(snippet.getThumbnails().getMedium().getUrl());
            }
        }
        return favBean;
    }

    private void setMoreActionListener(View view, final SearchItemBean searchItemBean, final int i) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.SearchSongsAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                boolean z = true;
                if (SearchSongsAdapter.this.mContext instanceof ArtistsDetailActivity) {
                    z = false;
                }
                new MusicMenuDialog.b(SearchSongsAdapter.this.fragmentManager).a(b.a(searchItemBean)).a(b.a(SearchSongsAdapter.this.allData)).b(i).a(z).a().e();
            }
        });
    }

    private void setPlayAction(View view, final SearchItemBean searchItemBean) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.SearchSongsAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SearchSongsAdapter.this.onItemClickListener != null) {
                    SearchSongsAdapter.this.onItemClickListener.onPlayNow(searchItemBean);
                }
            }
        });
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.allData.size();
    }

    /* loaded from: classes.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.adapter_search_song_duration_tx)
        TextView durationTextView;
        @BindView(R.id.adapter_search_song_cover_img)
        ImageView mCoverImg;
        @BindView(R.id.adapter_search_song_menu_img)
        ImageView mSongMenuImg;
        @BindView(R.id.adapter_search_song_name_tx)
        TextView mSongNameTx;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

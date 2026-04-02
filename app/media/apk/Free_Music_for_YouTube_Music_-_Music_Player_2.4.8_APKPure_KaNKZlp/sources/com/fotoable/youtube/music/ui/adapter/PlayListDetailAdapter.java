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
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.PlayListDetailBean;
import com.fotoable.youtube.music.helper.d;
import com.fotoable.youtube.music.ui.dialog.MusicMenuDialog;
import com.fotoable.youtube.music.util.b;
import com.fotoable.youtube.music.util.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class PlayListDetailAdapter extends BaseAdapter<ViewHolder> {
    private Context context;
    private String editorChoiceTitle;
    private FragmentManager fragmentManager;
    private LayoutInflater inflater;
    private String isPlayingID = "";
    public List<PlayListDetailBean.ItemsEntity> mItemsEntity;
    private HashMap<String, String> map;
    private OnItemClickListener onItemClickListener;
    private String playListTitle;
    private int source;

    /* loaded from: classes.dex */
    public interface OnItemClickListener {
        void onAddToPlayQueue(PlayListDetailBean.ItemsEntity.SnippetEntity snippetEntity);

        void onPlayNext(PlayListDetailBean.ItemsEntity.SnippetEntity snippetEntity);

        void onPlayNow(PlayListDetailBean.ItemsEntity.SnippetEntity snippetEntity, int i);
    }

    /* loaded from: classes.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.txtTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_title, "field 'txtTitle'", TextView.class);
            viewHolder.txtContent = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_content, "field 'txtContent'", TextView.class);
            viewHolder.textTime = (TextView) Utils.findRequiredViewAsType(view, R.id.text_time, "field 'textTime'", TextView.class);
            viewHolder.btnMenu = (ImageView) Utils.findRequiredViewAsType(view, R.id.btn_menu, "field 'btnMenu'", ImageView.class);
            viewHolder.ivIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_icon, "field 'ivIcon'", ImageView.class);
            viewHolder.rlDetails = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_details, "field 'rlDetails'", RelativeLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            viewHolder.txtTitle = null;
            viewHolder.txtContent = null;
            viewHolder.textTime = null;
            viewHolder.btnMenu = null;
            viewHolder.ivIcon = null;
            viewHolder.rlDetails = null;
        }
    }

    public PlayListDetailAdapter(Context context, FragmentManager fragmentManager) {
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);
        setHasStableIds(true);
        this.fragmentManager = fragmentManager;
        this.map = new HashMap<>();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this.inflater.inflate(R.layout.view_playlist_details_item, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mItemsEntity == null) {
            return 0;
        }
        return this.mItemsEntity.size();
    }

    @Override // com.fotoable.youtube.music.ui.adapter.BaseAdapter
    public void onDestroy() {
        this.context = null;
        this.inflater = null;
        this.mItemsEntity = null;
    }

    public List<PlayListDetailBean.ItemsEntity> getmItemsEntity() {
        return this.mItemsEntity;
    }

    public void setAddDatas(List<PlayListDetailBean.ItemsEntity> list) {
        if (this.mItemsEntity == null) {
            this.mItemsEntity = list;
            notifyDataSetChanged();
        } else {
            int size = this.mItemsEntity.size();
            this.mItemsEntity.addAll(list);
            notifyItemRangeInserted(size, this.mItemsEntity.size() - size);
        }
        m.a().a(getIds(list), this.map, new m.a() { // from class: com.fotoable.youtube.music.ui.adapter.PlayListDetailAdapter.1
            @Override // com.fotoable.youtube.music.util.m.a
            public void onDuration(HashMap<String, String> hashMap) {
                PlayListDetailAdapter.this.notifyDataSetChanged();
            }
        });
    }

    private List<String> getIds(List<PlayListDetailBean.ItemsEntity> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                arrayList.add(list.get(i2).getSnippet().getResourceId().getVideoId());
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    public void cleanDatas() {
        if (this.mItemsEntity != null) {
            this.mItemsEntity.clear();
        }
        if (this.map != null) {
            this.map.clear();
        }
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void changeFavState(String str, boolean z) {
        boolean z2 = true;
        if (this.mItemsEntity != null && this.mItemsEntity.size() > 0) {
            int i = 0;
            while (true) {
                if (i >= this.mItemsEntity.size()) {
                    z2 = false;
                    break;
                }
                PlayListDetailBean.ItemsEntity itemsEntity = this.mItemsEntity.get(i);
                if (itemsEntity == null || itemsEntity.getSnippet() == null || itemsEntity.getSnippet().getResourceId() == null || !TextUtils.equals(itemsEntity.getSnippet().getResourceId().getVideoId(), str)) {
                    i++;
                } else {
                    itemsEntity.getSnippet().setIsFav(z ? 1 : 0);
                }
            }
            if (z2) {
                notifyDataSetChanged();
            }
        }
    }

    public void setSource(int i) {
        this.source = i;
    }

    public void setEditorChoiceTitle(String str) {
        this.editorChoiceTitle = str;
    }

    public void setTitle(String str) {
        this.playListTitle = str;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        viewHolder.setIsRecyclable(false);
        final PlayListDetailBean.ItemsEntity.SnippetEntity snippet = this.mItemsEntity.get(i).getSnippet();
        if (snippet.getResourceId().getVideoId().equalsIgnoreCase(this.isPlayingID)) {
            viewHolder.txtTitle.setTextColor(SupportMenu.CATEGORY_MASK);
        } else {
            viewHolder.txtTitle.setTextColor(this.context.getResources().getColor(R.color.favorite_title));
        }
        viewHolder.txtTitle.setText(snippet.getTitle());
        String str = "";
        if (snippet.getThumbnails() != null) {
            if (snippet.getThumbnails().getMedium() != null) {
                str = snippet.getThumbnails().getMedium().getUrl();
            } else if (snippet.getThumbnails().getDefaultX() != null) {
                str = snippet.getThumbnails().getDefaultX().getUrl();
            } else {
                b.b("TY_getThumbnails.getIV==null", "VideoId", snippet.getResourceId().getVideoId());
            }
        } else {
            b.b("TY_getThumbnails==null", "VideoId", snippet.getResourceId().getVideoId());
        }
        d.a(this.context, str, viewHolder.ivIcon);
        viewHolder.rlDetails.setOnClickListener(new View.OnClickListener(this, snippet, i) { // from class: com.fotoable.youtube.music.ui.adapter.PlayListDetailAdapter$$Lambda$0
            private final PlayListDetailAdapter arg$1;
            private final PlayListDetailBean.ItemsEntity.SnippetEntity arg$2;
            private final int arg$3;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
                this.arg$2 = snippet;
                this.arg$3 = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.arg$1.lambda$onBindViewHolder$0$PlayListDetailAdapter(this.arg$2, this.arg$3, view);
            }
        });
        String str2 = this.map.get(snippet.getResourceId().getVideoId());
        if (!TextUtils.isEmpty(str2)) {
            viewHolder.textTime.setText(str2);
            snippet.setDuration(str2);
            viewHolder.textTime.setVisibility(0);
        } else {
            viewHolder.textTime.setVisibility(8);
        }
        viewHolder.btnMenu.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.PlayListDetailAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new MusicMenuDialog.b(PlayListDetailAdapter.this.fragmentManager).a(com.fotoable.youtube.music.newplayer.a.b.a(snippet)).a(com.fotoable.youtube.music.newplayer.a.b.d(PlayListDetailAdapter.this.mItemsEntity)).b(i).a(true).a().e();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$onBindViewHolder$0$PlayListDetailAdapter(PlayListDetailBean.ItemsEntity.SnippetEntity snippetEntity, int i, View view) {
        b.b("PlayList-歌单点击播放单曲");
        b.a("PlayList-歌单点击播放单曲");
        if (this.onItemClickListener != null) {
            this.onItemClickListener.onPlayNow(snippetEntity, i);
        }
        if (this.source == 2001) {
            b.b("Artists歌手页-歌单列表点击播放单曲");
            b.a("Artists歌手页-歌单列表点击播放单曲");
        } else if (this.source == 2201) {
            b.b("推荐页-编辑推荐-" + this.editorChoiceTitle + "某歌单点击播放", "歌单名称", "" + this.playListTitle);
            b.a("推荐页-编辑推荐-" + this.editorChoiceTitle + "某歌单点击播放", "歌单名称", "" + this.playListTitle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.btn_menu)
        ImageView btnMenu;
        @BindView(R.id.iv_icon)
        ImageView ivIcon;
        @BindView(R.id.rl_details)
        RelativeLayout rlDetails;
        @BindView(R.id.text_time)
        TextView textTime;
        @BindView(R.id.txt_content)
        TextView txtContent;
        @BindView(R.id.txt_title)
        TextView txtTitle;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setIsPlayingID(String str) {
        this.isPlayingID = str;
        notifyDataSetChanged();
    }
}

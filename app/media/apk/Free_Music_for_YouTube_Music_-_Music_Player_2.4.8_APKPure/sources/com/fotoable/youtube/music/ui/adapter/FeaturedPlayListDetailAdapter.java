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
import com.fotoable.youtube.music.bean.FeaturedDetailBean;
import com.fotoable.youtube.music.helper.d;
import com.fotoable.youtube.music.newplayer.a.b;
import com.fotoable.youtube.music.ui.dialog.MusicMenuDialog;
import com.fotoable.youtube.music.util.h;
import com.fotoable.youtube.music.util.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class FeaturedPlayListDetailAdapter extends BaseAdapter<ViewHolder> {
    private Context context;
    public List<FeaturedDetailBean> detailBean;
    private String editorChoiceTitle;
    private FragmentManager fragmentManager;
    private LayoutInflater inflater;
    private String isPlayingID = "";
    private HashMap<String, String> map;
    private OnItemClickListener onItemClickListener;
    private String playListTitle;
    private int source;

    /* loaded from: classes.dex */
    public interface OnItemClickListener {
        void onAddToPlayQueue(FeaturedDetailBean featuredDetailBean);

        void onPlayNext(FeaturedDetailBean featuredDetailBean);

        void onPlayNow(FeaturedDetailBean featuredDetailBean);
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

    public FeaturedPlayListDetailAdapter(Context context, FragmentManager fragmentManager) {
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
        if (this.detailBean == null) {
            return 0;
        }
        return this.detailBean.size();
    }

    @Override // com.fotoable.youtube.music.ui.adapter.BaseAdapter
    public void onDestroy() {
        this.context = null;
        this.inflater = null;
        this.detailBean = null;
    }

    public List<FeaturedDetailBean> getmItemsEntity() {
        return this.detailBean;
    }

    public void setAddDatas(List<FeaturedDetailBean> list) {
        if (this.detailBean == null) {
            this.detailBean = list;
            notifyDataSetChanged();
        } else {
            int size = this.detailBean.size();
            this.detailBean.addAll(list);
            notifyItemRangeInserted(size, this.detailBean.size() - size);
        }
        m.a().a(getIds(this.detailBean), this.map, new m.a(this) { // from class: com.fotoable.youtube.music.ui.adapter.FeaturedPlayListDetailAdapter$$Lambda$0
            private final FeaturedPlayListDetailAdapter arg$1;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
            }

            @Override // com.fotoable.youtube.music.util.m.a
            public void onDuration(HashMap hashMap) {
                this.arg$1.lambda$setAddDatas$0$FeaturedPlayListDetailAdapter(hashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$setAddDatas$0$FeaturedPlayListDetailAdapter(HashMap hashMap) {
        notifyDataSetChanged();
    }

    private List<String> getIds(List<FeaturedDetailBean> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                arrayList.add(list.get(i2).getVideoid());
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    public void cleanDatas() {
        if (this.detailBean != null) {
            this.detailBean.clear();
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
        h.a("changeFavState", str + ":isCollect:" + z);
        if (this.detailBean != null && this.detailBean.size() > 0) {
            int i = 0;
            while (true) {
                if (i >= this.detailBean.size()) {
                    z2 = false;
                    break;
                }
                FeaturedDetailBean featuredDetailBean = this.detailBean.get(i);
                if (featuredDetailBean == null || !TextUtils.equals(featuredDetailBean.getVideoid(), str)) {
                    i++;
                } else {
                    featuredDetailBean.setIsFav(z ? 1 : 0);
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
        final FeaturedDetailBean featuredDetailBean = this.detailBean.get(i);
        if (featuredDetailBean.getVideoid().equalsIgnoreCase(this.isPlayingID)) {
            viewHolder.txtTitle.setTextColor(SupportMenu.CATEGORY_MASK);
        } else {
            viewHolder.txtTitle.setTextColor(this.context.getResources().getColor(R.color.favorite_title));
        }
        viewHolder.txtTitle.setText(featuredDetailBean.getTitle());
        d.a(this.context, featuredDetailBean.getImgUrl(), viewHolder.ivIcon);
        viewHolder.rlDetails.setOnClickListener(new View.OnClickListener(this, featuredDetailBean) { // from class: com.fotoable.youtube.music.ui.adapter.FeaturedPlayListDetailAdapter$$Lambda$1
            private final FeaturedPlayListDetailAdapter arg$1;
            private final FeaturedDetailBean arg$2;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
                this.arg$2 = featuredDetailBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.arg$1.lambda$onBindViewHolder$1$FeaturedPlayListDetailAdapter(this.arg$2, view);
            }
        });
        String str = this.map.get(featuredDetailBean.getVideoid());
        if (!TextUtils.isEmpty(str)) {
            viewHolder.textTime.setText(str);
            featuredDetailBean.setDuration(str);
            viewHolder.textTime.setVisibility(0);
        } else {
            viewHolder.textTime.setVisibility(8);
        }
        viewHolder.btnMenu.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.FeaturedPlayListDetailAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new MusicMenuDialog.b(FeaturedPlayListDetailAdapter.this.fragmentManager).a(b.a(featuredDetailBean)).a(b.g(FeaturedPlayListDetailAdapter.this.detailBean)).b(i).a(true).a().e();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$onBindViewHolder$1$FeaturedPlayListDetailAdapter(FeaturedDetailBean featuredDetailBean, View view) {
        com.fotoable.youtube.music.util.b.b("PlayList-歌单点击播放单曲");
        com.fotoable.youtube.music.util.b.a("PlayList-歌单点击播放单曲");
        if (this.onItemClickListener != null) {
            this.onItemClickListener.onPlayNow(featuredDetailBean);
        }
        if (this.source == 2201) {
            com.fotoable.youtube.music.util.b.b("推荐页-编辑推荐-" + this.editorChoiceTitle + "某歌单点击播放", "歌单名称", "" + this.playListTitle);
            com.fotoable.youtube.music.util.b.a("推荐页-编辑推荐-" + this.editorChoiceTitle + "某歌单点击播放", "歌单名称", "" + this.playListTitle);
        } else if (this.source == 2202) {
            com.fotoable.youtube.music.util.b.b("推荐页-推荐歌单-某歌单点击播放", "歌单名称", "" + this.playListTitle);
            com.fotoable.youtube.music.util.b.a("推荐页-推荐歌单-某歌单点击播放", "歌单名称", "" + this.playListTitle);
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

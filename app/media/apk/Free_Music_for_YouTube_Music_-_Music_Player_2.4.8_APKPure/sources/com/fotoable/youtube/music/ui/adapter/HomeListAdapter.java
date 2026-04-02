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
import com.facebook.ads.AdError;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.HomeListNewBean;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.db.a;
import com.fotoable.youtube.music.helper.d;
import com.fotoable.youtube.music.ui.dialog.MusicMenuDialog;
import com.fotoable.youtube.music.util.b;
import com.fotoable.youtube.music.util.h;
import java.util.List;
/* loaded from: classes.dex */
public class HomeListAdapter extends BaseAdapter<ViewHolder> {
    private Context context;
    private FragmentManager fragmentManager;
    private a greenDAOHelper;
    private LayoutInflater inflater;
    public List<HomeListNewBean> mItemsEntity;
    private OnAdminDeleteLister onAdminDeleteLister;
    private int type;
    private String isPlayingID = "";
    private boolean showBottomLine = true;

    /* loaded from: classes.dex */
    public interface OnAdminDeleteLister {
        void onDelete(HomeListNewBean homeListNewBean, int i);
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
            viewHolder.lineView = Utils.findRequiredView(view, R.id.line, "field 'lineView'");
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
            viewHolder.lineView = null;
        }
    }

    public HomeListAdapter(Context context, FragmentManager fragmentManager, a aVar) {
        this.context = context;
        this.greenDAOHelper = aVar;
        this.inflater = LayoutInflater.from(this.context);
        setHasStableIds(true);
        this.fragmentManager = fragmentManager;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this.inflater.inflate(R.layout.view_playlist_details_item, viewGroup, false));
    }

    public void setOnAdminDeleteLister(OnAdminDeleteLister onAdminDeleteLister) {
        this.onAdminDeleteLister = onAdminDeleteLister;
    }

    public void setType(int i) {
        this.type = i;
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

    public void setAddData(List<HomeListNewBean> list) {
        if (this.mItemsEntity == null) {
            this.mItemsEntity = list;
            notifyDataSetChanged();
            return;
        }
        int size = this.mItemsEntity.size();
        this.mItemsEntity.addAll(list);
        notifyItemRangeInserted(size, this.mItemsEntity.size() - size);
    }

    public void setAllAddData(List<HomeListNewBean> list) {
        this.mItemsEntity = list;
        notifyDataSetChanged();
    }

    public void cleanData() {
        if (this.mItemsEntity != null) {
            this.mItemsEntity.clear();
        }
        notifyDataSetChanged();
    }

    public void delete(HomeListNewBean homeListNewBean) {
        if (this.mItemsEntity != null) {
            this.mItemsEntity.remove(homeListNewBean);
        }
        notifyDataSetChanged();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        viewHolder.setIsRecyclable(false);
        final HomeListNewBean homeListNewBean = this.mItemsEntity.get(i);
        if (homeListNewBean.getVideoid().equalsIgnoreCase(this.isPlayingID)) {
            viewHolder.txtTitle.setTextColor(SupportMenu.CATEGORY_MASK);
            viewHolder.txtContent.setTextColor(SupportMenu.CATEGORY_MASK);
        } else {
            viewHolder.txtTitle.setTextColor(this.context.getResources().getColor(R.color.favorite_title));
            viewHolder.txtContent.setTextColor(this.context.getResources().getColor(R.color.favorite_desc));
        }
        viewHolder.txtTitle.setText(homeListNewBean.getTitle());
        viewHolder.textTime.setText(homeListNewBean.getDuration());
        if (TextUtils.isEmpty(homeListNewBean.getArtists())) {
            viewHolder.txtContent.setVisibility(8);
        } else {
            viewHolder.txtContent.setVisibility(0);
            viewHolder.txtContent.setText(homeListNewBean.getArtists());
        }
        d.a(this.context, homeListNewBean.getImgUrl(), viewHolder.ivIcon);
        viewHolder.rlDetails.setOnClickListener(new View.OnClickListener(this, homeListNewBean, i) { // from class: com.fotoable.youtube.music.ui.adapter.HomeListAdapter$$Lambda$0
            private final HomeListAdapter arg$1;
            private final HomeListNewBean arg$2;
            private final int arg$3;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
                this.arg$2 = homeListNewBean;
                this.arg$3 = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.arg$1.lambda$onBindViewHolder$0$HomeListAdapter(this.arg$2, this.arg$3, view);
            }
        });
        setMenuEvent(viewHolder, homeListNewBean, i);
        if (!this.showBottomLine) {
            if (i == this.mItemsEntity.size() - 1) {
                viewHolder.lineView.setVisibility(8);
            } else {
                viewHolder.lineView.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$onBindViewHolder$0$HomeListAdapter(HomeListNewBean homeListNewBean, int i, View view) {
        if (this.type == 1) {
            b.b("FreshSongs-Click ", "value", homeListNewBean.getVideoid());
            b.a("抢先试听-点击单曲", "视频ID", homeListNewBean.getVideoid());
        } else {
            b.b("HitSingle-Click", "value", homeListNewBean.getVideoid());
            b.a("热门单曲-点击单曲", "视频ID", homeListNewBean.getVideoid());
        }
        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a((int) AdError.INTERNAL_ERROR_CODE, com.fotoable.youtube.music.newplayer.a.b.b(this.mItemsEntity), i));
        h.a("发送播放事件");
    }

    public void setShowBottomLine(boolean z) {
        this.showBottomLine = z;
    }

    private void setMenuEvent(ViewHolder viewHolder, final HomeListNewBean homeListNewBean, final int i) {
        viewHolder.btnMenu.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.HomeListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new MusicMenuDialog.b(HomeListAdapter.this.fragmentManager).a(com.fotoable.youtube.music.newplayer.a.b.a(homeListNewBean)).a(com.fotoable.youtube.music.newplayer.a.b.b(HomeListAdapter.this.mItemsEntity)).b(i).a(true).a(new MusicMenuDialog.a() { // from class: com.fotoable.youtube.music.ui.adapter.HomeListAdapter.1.1
                    @Override // com.fotoable.youtube.music.ui.dialog.MusicMenuDialog.a
                    public void onDelete(PlayMusicModel playMusicModel) {
                        if (HomeListAdapter.this.onAdminDeleteLister != null) {
                            HomeListAdapter.this.onAdminDeleteLister.onDelete(homeListNewBean, HomeListAdapter.this.type);
                        }
                    }
                }).a().e();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.btn_menu)
        ImageView btnMenu;
        @BindView(R.id.iv_icon)
        ImageView ivIcon;
        @BindView(R.id.line)
        View lineView;
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

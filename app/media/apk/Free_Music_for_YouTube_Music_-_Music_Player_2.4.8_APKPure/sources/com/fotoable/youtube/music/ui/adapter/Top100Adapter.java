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
import com.fotoable.youtube.music.bean.GlobalRankVideoBean;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.helper.d;
import com.fotoable.youtube.music.newplayer.a.b;
import com.fotoable.youtube.music.ui.dialog.MusicMenuDialog;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Top100Adapter extends BaseAdapter<ViewHolder> {
    private Context context;
    private FragmentManager fragmentManager;
    private ArrayList<GlobalRankVideoBean> globalRankVideoBeenList;
    private LayoutInflater inflater;
    private String isPlayingID = "";
    private OnAdminDeleteLister onAdminDeleteLister;
    private OnItemClickListener onItemClickListener;

    /* loaded from: classes.dex */
    public interface OnAdminDeleteLister {
        void onDelete(GlobalRankVideoBean globalRankVideoBean, int i);
    }

    /* loaded from: classes.dex */
    public interface OnItemClickListener {
        void onAddToPlayQueue(GlobalRankVideoBean globalRankVideoBean);

        void onPlayNext(GlobalRankVideoBean globalRankVideoBean);

        void onPlayNow(GlobalRankVideoBean globalRankVideoBean);
    }

    /* loaded from: classes.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.txtTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_title, "field 'txtTitle'", TextView.class);
            viewHolder.textTime = (TextView) Utils.findRequiredViewAsType(view, R.id.text_time, "field 'textTime'", TextView.class);
            viewHolder.btnMenu = (ImageView) Utils.findRequiredViewAsType(view, R.id.btn_menu, "field 'btnMenu'", ImageView.class);
            viewHolder.ivIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_icon, "field 'ivIcon'", ImageView.class);
            viewHolder.rlDetails = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_details, "field 'rlDetails'", RelativeLayout.class);
            viewHolder.txtNum = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.txt_num, "field 'txtNum'", LaToTextView.class);
            viewHolder.txtNew = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_new, "field 'txtNew'", TextView.class);
            viewHolder.imgUp = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_up, "field 'imgUp'", ImageView.class);
            viewHolder.imgDown = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_down, "field 'imgDown'", ImageView.class);
            viewHolder.txtChangeNum = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.txt_change_num, "field 'txtChangeNum'", LaToTextView.class);
            viewHolder.txtSingerName = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.txt_singer_name, "field 'txtSingerName'", LaToTextView.class);
            viewHolder.txtNoChange = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.txt_no_change, "field 'txtNoChange'", LaToTextView.class);
            viewHolder.commentView = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.comment, "field 'commentView'", RelativeLayout.class);
            viewHolder.comment_icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.comment_icon, "field 'comment_icon'", ImageView.class);
            viewHolder.comment_count = (TextView) Utils.findRequiredViewAsType(view, R.id.comment_count, "field 'comment_count'", TextView.class);
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
            viewHolder.textTime = null;
            viewHolder.btnMenu = null;
            viewHolder.ivIcon = null;
            viewHolder.rlDetails = null;
            viewHolder.txtNum = null;
            viewHolder.txtNew = null;
            viewHolder.imgUp = null;
            viewHolder.imgDown = null;
            viewHolder.txtChangeNum = null;
            viewHolder.txtSingerName = null;
            viewHolder.txtNoChange = null;
            viewHolder.commentView = null;
            viewHolder.comment_icon = null;
            viewHolder.comment_count = null;
        }
    }

    public Top100Adapter(Context context, FragmentManager fragmentManager) {
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);
        setHasStableIds(true);
        this.fragmentManager = fragmentManager;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new ViewHolder(this.inflater.inflate(R.layout.view_top100_header, viewGroup, false)) : new ViewHolder(this.inflater.inflate(R.layout.view_globalmusic_details_item, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return 2;
    }

    public void setOnAdminDeleteLister(OnAdminDeleteLister onAdminDeleteLister) {
        this.onAdminDeleteLister = onAdminDeleteLister;
    }

    public int getItemCount2() {
        if (this.globalRankVideoBeenList == null) {
            return 0;
        }
        return this.globalRankVideoBeenList.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.globalRankVideoBeenList == null) {
            return 0;
        }
        return this.globalRankVideoBeenList.size() + 0;
    }

    @Override // com.fotoable.youtube.music.ui.adapter.BaseAdapter
    public void onDestroy() {
        this.context = null;
        this.inflater = null;
        this.globalRankVideoBeenList = null;
    }

    public void setAddDatas(ArrayList<GlobalRankVideoBean> arrayList) {
        if (this.globalRankVideoBeenList == null) {
            this.globalRankVideoBeenList = arrayList;
            notifyDataSetChanged();
            return;
        }
        int size = this.globalRankVideoBeenList.size();
        this.globalRankVideoBeenList.addAll(arrayList);
        notifyItemRangeInserted(size, this.globalRankVideoBeenList.size() - size);
    }

    public void cleanDatas() {
        if (this.globalRankVideoBeenList != null) {
            this.globalRankVideoBeenList.clear();
        }
        notifyDataSetChanged();
    }

    public void delete(GlobalRankVideoBean globalRankVideoBean) {
        if (this.globalRankVideoBeenList != null) {
            this.globalRankVideoBeenList.remove(globalRankVideoBean);
        }
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        if (getItemViewType(i) != 1) {
            try {
                if (getItemViewType(0) == 1) {
                    i--;
                }
                if (this.globalRankVideoBeenList.get(i).getVideoid().equalsIgnoreCase(this.isPlayingID)) {
                    viewHolder.txtTitle.setTextColor(SupportMenu.CATEGORY_MASK);
                    viewHolder.txtSingerName.setTextColor(SupportMenu.CATEGORY_MASK);
                } else {
                    viewHolder.txtTitle.setTextColor(this.context.getResources().getColor(R.color.favorite_title));
                    viewHolder.txtSingerName.setTextColor(this.context.getResources().getColor(R.color.favorite_desc));
                }
                viewHolder.txtTitle.setText(this.globalRankVideoBeenList.get(i).getTitle() == null ? "" : this.globalRankVideoBeenList.get(i).getTitle());
                if (!TextUtils.isEmpty(this.globalRankVideoBeenList.get(i).getArtists())) {
                    viewHolder.txtSingerName.setText(this.globalRankVideoBeenList.get(i).getArtists() == null ? "" : this.globalRankVideoBeenList.get(i).getArtists());
                    viewHolder.txtSingerName.setVisibility(0);
                } else {
                    viewHolder.txtSingerName.setVisibility(8);
                }
                viewHolder.textTime.setText(this.globalRankVideoBeenList.get(i).getDuration() + "");
                viewHolder.txtNum.setText(String.valueOf(i + 1));
                switch (this.globalRankVideoBeenList.get(i).getType()) {
                    case 1:
                        viewHolder.txtNew.setVisibility(0);
                        viewHolder.imgUp.setVisibility(8);
                        viewHolder.imgDown.setVisibility(8);
                        viewHolder.txtChangeNum.setVisibility(8);
                        viewHolder.txtNoChange.setVisibility(8);
                        break;
                    case 2:
                        viewHolder.txtNew.setVisibility(8);
                        viewHolder.imgUp.setVisibility(8);
                        viewHolder.imgDown.setVisibility(8);
                        viewHolder.txtChangeNum.setVisibility(8);
                        viewHolder.txtNoChange.setVisibility(8);
                        break;
                    case 3:
                        viewHolder.txtNew.setVisibility(8);
                        viewHolder.imgUp.setVisibility(0);
                        viewHolder.imgDown.setVisibility(8);
                        viewHolder.txtChangeNum.setVisibility(0);
                        viewHolder.txtChangeNum.setText(String.valueOf(this.globalRankVideoBeenList.get(i).getNumber()));
                        viewHolder.txtNoChange.setVisibility(8);
                        break;
                    case 4:
                        viewHolder.txtNew.setVisibility(8);
                        viewHolder.imgUp.setVisibility(8);
                        viewHolder.imgDown.setVisibility(0);
                        viewHolder.txtChangeNum.setVisibility(0);
                        viewHolder.txtChangeNum.setText(String.valueOf(this.globalRankVideoBeenList.get(i).getNumber()));
                        viewHolder.txtNoChange.setVisibility(8);
                        break;
                }
                d.a(this.context, this.globalRankVideoBeenList.get(i).getImgUrl(), viewHolder.ivIcon);
                viewHolder.rlDetails.setOnClickListener(new View.OnClickListener(this, i) { // from class: com.fotoable.youtube.music.ui.adapter.Top100Adapter$$Lambda$0
                    private final Top100Adapter arg$1;
                    private final int arg$2;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.arg$1 = this;
                        this.arg$2 = i;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        this.arg$1.lambda$onBindViewHolder$0$Top100Adapter(this.arg$2, view);
                    }
                });
                viewHolder.btnMenu.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.Top100Adapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new MusicMenuDialog.b(Top100Adapter.this.fragmentManager).a(b.a((GlobalRankVideoBean) Top100Adapter.this.globalRankVideoBeenList.get(i))).a(b.e(Top100Adapter.this.globalRankVideoBeenList)).b(i).a(true).a(((GlobalRankVideoBean) Top100Adapter.this.globalRankVideoBeenList.get(i)).getCommentsCount()).a(new MusicMenuDialog.a() { // from class: com.fotoable.youtube.music.ui.adapter.Top100Adapter.1.1
                            @Override // com.fotoable.youtube.music.ui.dialog.MusicMenuDialog.a
                            public void onDelete(PlayMusicModel playMusicModel) {
                                if (Top100Adapter.this.onAdminDeleteLister != null) {
                                    Top100Adapter.this.onAdminDeleteLister.onDelete((GlobalRankVideoBean) Top100Adapter.this.globalRankVideoBeenList.get(i), 4);
                                }
                            }
                        }).a().e();
                    }
                });
            } catch (Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$onBindViewHolder$0$Top100Adapter(int i, View view) {
        if (this.onItemClickListener != null) {
            this.onItemClickListener.onPlayNow(this.globalRankVideoBeenList.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.btn_menu)
        ImageView btnMenu;
        @BindView(R.id.comment)
        RelativeLayout commentView;
        @BindView(R.id.comment_count)
        TextView comment_count;
        @BindView(R.id.comment_icon)
        ImageView comment_icon;
        RelativeLayout featured_artists_view;
        RelativeLayout featured_charts_view;
        RelativeLayout featured_genres_view;
        @BindView(R.id.img_down)
        ImageView imgDown;
        @BindView(R.id.img_up)
        ImageView imgUp;
        @BindView(R.id.iv_icon)
        ImageView ivIcon;
        @BindView(R.id.rl_details)
        RelativeLayout rlDetails;
        @BindView(R.id.text_time)
        TextView textTime;
        @BindView(R.id.txt_change_num)
        LaToTextView txtChangeNum;
        @BindView(R.id.txt_new)
        TextView txtNew;
        @BindView(R.id.txt_no_change)
        LaToTextView txtNoChange;
        @BindView(R.id.txt_num)
        LaToTextView txtNum;
        @BindView(R.id.txt_singer_name)
        LaToTextView txtSingerName;
        @BindView(R.id.txt_title)
        TextView txtTitle;

        ViewHolder(View view) {
            super(view);
            if (view.findViewById(R.id.txt_title) != null) {
                ButterKnife.bind(this, view);
                return;
            }
            this.featured_charts_view = (RelativeLayout) view.findViewById(R.id.featured_charts_view);
            this.featured_artists_view = (RelativeLayout) view.findViewById(R.id.featured_artists_view);
            this.featured_genres_view = (RelativeLayout) view.findViewById(R.id.featured_genres_view);
        }
    }

    public void setIsPlayingID(String str) {
        this.isPlayingID = str;
        notifyDataSetChanged();
    }

    public ArrayList<GlobalRankVideoBean> getGlobalRankVideoBeens() {
        return this.globalRankVideoBeenList;
    }

    public void changeFavState(String str, boolean z) {
        boolean z2 = true;
        if (this.globalRankVideoBeenList != null && this.globalRankVideoBeenList.size() > 0) {
            int i = 0;
            while (true) {
                if (i >= this.globalRankVideoBeenList.size()) {
                    i = -1;
                    z2 = false;
                    break;
                }
                GlobalRankVideoBean globalRankVideoBean = this.globalRankVideoBeenList.get(i);
                if (globalRankVideoBean == null || !TextUtils.equals(str, globalRankVideoBean.getVideoid())) {
                    i++;
                } else {
                    globalRankVideoBean.setIsFav(z ? 1 : 0);
                }
            }
            if (z2 && i != -1) {
                notifyDataSetChanged();
            }
        }
    }
}

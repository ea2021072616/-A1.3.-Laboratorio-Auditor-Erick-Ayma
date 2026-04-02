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
public class GlobalMusicDetailAdapter extends BaseAdapter<ViewHolder> {
    private Context context;
    private FragmentManager fragmentManager;
    private ArrayList<GlobalRankVideoBean> globalRankVideoBeens;
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
        }
    }

    public GlobalMusicDetailAdapter(Context context, FragmentManager fragmentManager) {
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);
        setHasStableIds(true);
        this.fragmentManager = fragmentManager;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this.inflater.inflate(R.layout.view_globalmusic_details_item, viewGroup, false));
    }

    public void setOnAdminDeleteLister(OnAdminDeleteLister onAdminDeleteLister) {
        this.onAdminDeleteLister = onAdminDeleteLister;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.globalRankVideoBeens == null) {
            return 0;
        }
        return this.globalRankVideoBeens.size();
    }

    @Override // com.fotoable.youtube.music.ui.adapter.BaseAdapter
    public void onDestroy() {
        this.context = null;
        this.inflater = null;
        this.globalRankVideoBeens = null;
    }

    public void setAddDatas(ArrayList<GlobalRankVideoBean> arrayList) {
        if (this.globalRankVideoBeens == null) {
            this.globalRankVideoBeens = arrayList;
            notifyDataSetChanged();
            return;
        }
        int size = this.globalRankVideoBeens.size();
        this.globalRankVideoBeens.addAll(arrayList);
        notifyItemRangeInserted(size, this.globalRankVideoBeens.size() - size);
    }

    public void cleanDatas() {
        if (this.globalRankVideoBeens != null) {
            this.globalRankVideoBeens.clear();
        }
        notifyDataSetChanged();
    }

    public void delete(GlobalRankVideoBean globalRankVideoBean) {
        if (this.globalRankVideoBeens != null) {
            this.globalRankVideoBeens.remove(globalRankVideoBean);
        }
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        try {
            if (this.globalRankVideoBeens.get(i).getVideoid().equalsIgnoreCase(this.isPlayingID)) {
                viewHolder.txtTitle.setTextColor(SupportMenu.CATEGORY_MASK);
                viewHolder.txtSingerName.setTextColor(SupportMenu.CATEGORY_MASK);
            } else {
                viewHolder.txtTitle.setTextColor(this.context.getResources().getColor(R.color.favorite_title));
                viewHolder.txtSingerName.setTextColor(this.context.getResources().getColor(R.color.favorite_desc));
            }
            viewHolder.txtTitle.setText(this.globalRankVideoBeens.get(i).getTitle() == null ? "" : this.globalRankVideoBeens.get(i).getTitle());
            viewHolder.txtSingerName.setText(this.globalRankVideoBeens.get(i).getArtists() == null ? "" : this.globalRankVideoBeens.get(i).getArtists());
            viewHolder.txtNum.setText(String.valueOf(i + 1));
            switch (this.globalRankVideoBeens.get(i).getType()) {
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
                    viewHolder.txtNoChange.setVisibility(0);
                    break;
                case 3:
                    viewHolder.txtNew.setVisibility(8);
                    viewHolder.imgUp.setVisibility(0);
                    viewHolder.imgDown.setVisibility(8);
                    viewHolder.txtChangeNum.setVisibility(0);
                    viewHolder.txtChangeNum.setText(String.valueOf(this.globalRankVideoBeens.get(i).getNumber()));
                    viewHolder.txtNoChange.setVisibility(8);
                    break;
                case 4:
                    viewHolder.txtNew.setVisibility(8);
                    viewHolder.imgUp.setVisibility(8);
                    viewHolder.imgDown.setVisibility(0);
                    viewHolder.txtChangeNum.setVisibility(0);
                    viewHolder.txtChangeNum.setText(String.valueOf(this.globalRankVideoBeens.get(i).getNumber()));
                    viewHolder.txtNoChange.setVisibility(8);
                    break;
            }
            d.a(this.context, this.globalRankVideoBeens.get(i).getImgUrl(), viewHolder.ivIcon);
            viewHolder.rlDetails.setOnClickListener(new View.OnClickListener(this, i) { // from class: com.fotoable.youtube.music.ui.adapter.GlobalMusicDetailAdapter$$Lambda$0
                private final GlobalMusicDetailAdapter arg$1;
                private final int arg$2;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.arg$1 = this;
                    this.arg$2 = i;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.arg$1.lambda$onBindViewHolder$0$GlobalMusicDetailAdapter(this.arg$2, view);
                }
            });
            viewHolder.btnMenu.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.GlobalMusicDetailAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    new MusicMenuDialog.b(GlobalMusicDetailAdapter.this.fragmentManager).a(b.a((GlobalRankVideoBean) GlobalMusicDetailAdapter.this.globalRankVideoBeens.get(i))).a(b.e(GlobalMusicDetailAdapter.this.globalRankVideoBeens)).b(i).a(true).a(new MusicMenuDialog.a() { // from class: com.fotoable.youtube.music.ui.adapter.GlobalMusicDetailAdapter.1.1
                        @Override // com.fotoable.youtube.music.ui.dialog.MusicMenuDialog.a
                        public void onDelete(PlayMusicModel playMusicModel) {
                            if (GlobalMusicDetailAdapter.this.onAdminDeleteLister != null) {
                                GlobalMusicDetailAdapter.this.onAdminDeleteLister.onDelete((GlobalRankVideoBean) GlobalMusicDetailAdapter.this.globalRankVideoBeens.get(i), 4);
                            }
                        }
                    }).a().e();
                }
            });
        } catch (Throwable th) {
            ThrowableExtension.printStackTrace(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$onBindViewHolder$0$GlobalMusicDetailAdapter(int i, View view) {
        if (this.onItemClickListener != null) {
            this.onItemClickListener.onPlayNow(this.globalRankVideoBeens.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.btn_menu)
        ImageView btnMenu;
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
            ButterKnife.bind(this, view);
        }
    }

    public void setIsPlayingID(String str) {
        this.isPlayingID = str;
        notifyDataSetChanged();
    }

    public ArrayList<GlobalRankVideoBean> getGlobalRankVideoBeens() {
        return this.globalRankVideoBeens;
    }

    public void changeFavState(String str, boolean z) {
        boolean z2 = true;
        if (this.globalRankVideoBeens != null && this.globalRankVideoBeens.size() > 0) {
            int i = 0;
            while (true) {
                if (i >= this.globalRankVideoBeens.size()) {
                    i = -1;
                    z2 = false;
                    break;
                }
                GlobalRankVideoBean globalRankVideoBean = this.globalRankVideoBeens.get(i);
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

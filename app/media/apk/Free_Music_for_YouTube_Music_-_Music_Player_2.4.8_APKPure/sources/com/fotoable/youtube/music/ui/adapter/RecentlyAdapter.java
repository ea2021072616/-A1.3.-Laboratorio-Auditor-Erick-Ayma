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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.RecentlyWatchBean;
import com.fotoable.youtube.music.helper.d;
import com.fotoable.youtube.music.newplayer.a.b;
import com.fotoable.youtube.music.ui.dialog.MusicMenuDialog;
import com.fotoable.youtube.music.ui.dialog.h;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RecentlyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = RecentlyAdapter.class.getSimpleName();
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    private Context context;
    private h customDialog;
    private FragmentManager fragmentManager;
    private LayoutInflater inflater;
    private String isPlayingID = "";
    private View mHeaderView;
    private OnItemClickListener onItemClickListener;
    private ArrayList<RecentlyWatchBean> recentlyWatchBeen;

    /* loaded from: classes.dex */
    public interface OnItemClickListener {
        void onAddToPlayQueue(RecentlyWatchBean recentlyWatchBean);

        void onPlayNext(RecentlyWatchBean recentlyWatchBean);

        void onPlayNow(RecentlyWatchBean recentlyWatchBean);
    }

    /* loaded from: classes.dex */
    public class DiscoverHolder_ViewBinding implements Unbinder {
        private DiscoverHolder target;

        @UiThread
        public DiscoverHolder_ViewBinding(DiscoverHolder discoverHolder, View view) {
            this.target = discoverHolder;
            discoverHolder.imgLogo = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_logo, "field 'imgLogo'", ImageView.class);
            discoverHolder.txtTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_title, "field 'txtTitle'", TextView.class);
            discoverHolder.txtContent = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.txt_content, "field 'txtContent'", LaToTextView.class);
            discoverHolder.btnMuen = (ImageView) Utils.findRequiredViewAsType(view, R.id.btn_menu, "field 'btnMuen'", ImageView.class);
            discoverHolder.linDesc = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lin_desc, "field 'linDesc'", LinearLayout.class);
            discoverHolder.relRoot = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rel_root, "field 'relRoot'", RelativeLayout.class);
            discoverHolder.textTime = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.text_time, "field 'textTime'", LaToTextView.class);
            discoverHolder.viewLine = Utils.findRequiredView(view, R.id.view_line, "field 'viewLine'");
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            DiscoverHolder discoverHolder = this.target;
            if (discoverHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            discoverHolder.imgLogo = null;
            discoverHolder.txtTitle = null;
            discoverHolder.txtContent = null;
            discoverHolder.btnMuen = null;
            discoverHolder.linDesc = null;
            discoverHolder.relRoot = null;
            discoverHolder.textTime = null;
            discoverHolder.viewLine = null;
        }
    }

    public RecentlyAdapter(Context context, FragmentManager fragmentManager) {
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);
        this.fragmentManager = fragmentManager;
        setHasStableIds(true);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.mHeaderView != null && i == 0) {
            return new HeardHolder(this.mHeaderView);
        }
        return new DiscoverHolder(LayoutInflater.from(this.context).inflate(R.layout.view_holder_recently, viewGroup, false));
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void changeFavState(String str, boolean z) {
        boolean z2 = true;
        if (this.recentlyWatchBeen != null && this.recentlyWatchBeen.size() > 0) {
            int i = 0;
            while (true) {
                if (i >= this.recentlyWatchBeen.size()) {
                    i = -1;
                    z2 = false;
                    break;
                }
                RecentlyWatchBean recentlyWatchBean = this.recentlyWatchBeen.get(i);
                if (recentlyWatchBean == null || !TextUtils.equals(str, recentlyWatchBean.getVideoid())) {
                    i++;
                } else {
                    recentlyWatchBean.setIsFav(z ? 1 : 0);
                }
            }
            if (z2 && i != -1) {
                notifyDataSetChanged();
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        try {
            if (getItemViewType(i) != 0) {
                final int realPosition = getRealPosition(i);
                d.a(this.context, this.recentlyWatchBeen.get(realPosition).getImgUrl(), ((DiscoverHolder) viewHolder).imgLogo, R.mipmap.pic_recently);
                ((DiscoverHolder) viewHolder).txtTitle.setText(this.recentlyWatchBeen.get(realPosition).getTitle() == null ? "" : this.recentlyWatchBeen.get(realPosition).getTitle());
                if (TextUtils.isEmpty(this.recentlyWatchBeen.get(realPosition).getArtists())) {
                    ((DiscoverHolder) viewHolder).txtContent.setVisibility(8);
                } else {
                    ((DiscoverHolder) viewHolder).txtContent.setText(this.recentlyWatchBeen.get(realPosition).getArtists());
                    ((DiscoverHolder) viewHolder).txtContent.setVisibility(0);
                }
                ((DiscoverHolder) viewHolder).textTime.setText(this.recentlyWatchBeen.get(realPosition).getDuration() == null ? "" : this.recentlyWatchBeen.get(realPosition).getDuration());
                if (TextUtils.isEmpty(this.recentlyWatchBeen.get(realPosition).getDuration())) {
                    ((DiscoverHolder) viewHolder).textTime.setVisibility(8);
                }
                if (this.recentlyWatchBeen.get(realPosition).getVideoid().equalsIgnoreCase(this.isPlayingID)) {
                    ((DiscoverHolder) viewHolder).txtTitle.setTextColor(SupportMenu.CATEGORY_MASK);
                    ((DiscoverHolder) viewHolder).txtContent.setTextColor(SupportMenu.CATEGORY_MASK);
                } else {
                    ((DiscoverHolder) viewHolder).txtTitle.setTextColor(this.context.getResources().getColor(R.color.favorite_title));
                    ((DiscoverHolder) viewHolder).txtContent.setTextColor(this.context.getResources().getColor(R.color.favorite_desc));
                }
                if (realPosition == this.recentlyWatchBeen.size() - 1) {
                    ((DiscoverHolder) viewHolder).viewLine.setVisibility(8);
                }
                ((DiscoverHolder) viewHolder).btnMuen.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.RecentlyAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (realPosition < 0 || realPosition >= RecentlyAdapter.this.recentlyWatchBeen.size()) {
                            com.fotoable.youtube.music.util.h.a(RecentlyAdapter.TAG, "数据异常，数组下表越界...");
                        } else {
                            new MusicMenuDialog.b(RecentlyAdapter.this.fragmentManager).a(b.a((RecentlyWatchBean) RecentlyAdapter.this.recentlyWatchBeen.get(realPosition))).a(b.c(RecentlyAdapter.this.recentlyWatchBeen)).b(i).a(true).a().e();
                        }
                    }
                });
                ((DiscoverHolder) viewHolder).relRoot.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.RecentlyAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RecentlyAdapter.this.onItemClickListener != null && realPosition < RecentlyAdapter.this.recentlyWatchBeen.size()) {
                            RecentlyAdapter.this.onItemClickListener.onPlayNow((RecentlyWatchBean) RecentlyAdapter.this.recentlyWatchBeen.get(realPosition));
                        }
                    }
                });
            }
        } catch (Throwable th) {
            ThrowableExtension.printStackTrace(th);
        }
    }

    public int getRealPosition(int i) {
        return this.mHeaderView == null ? i : i - 1;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.recentlyWatchBeen == null ? this.mHeaderView == null ? 0 : 1 : this.mHeaderView == null ? this.recentlyWatchBeen.size() : this.recentlyWatchBeen.size() + 1;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (this.mHeaderView != null && i == 0) ? 0 : 1;
    }

    /* loaded from: classes.dex */
    public class DiscoverHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.btn_menu)
        ImageView btnMuen;
        @BindView(R.id.img_logo)
        ImageView imgLogo;
        @BindView(R.id.lin_desc)
        LinearLayout linDesc;
        @BindView(R.id.rel_root)
        RelativeLayout relRoot;
        @BindView(R.id.text_time)
        LaToTextView textTime;
        @BindView(R.id.txt_content)
        LaToTextView txtContent;
        @BindView(R.id.txt_title)
        TextView txtTitle;
        @BindView(R.id.view_line)
        View viewLine;

        public DiscoverHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /* loaded from: classes.dex */
    public class HeardHolder extends RecyclerView.ViewHolder {
        public HeardHolder(View view) {
            super(view);
        }
    }

    public void setAddDatas(List<RecentlyWatchBean> list) {
        if (this.recentlyWatchBeen == null) {
            this.recentlyWatchBeen = new ArrayList<>();
        }
        this.recentlyWatchBeen.clear();
        this.recentlyWatchBeen.addAll(list);
        notifyDataSetChanged();
    }

    public ArrayList<RecentlyWatchBean> getRecentlyWatchBeen() {
        return this.recentlyWatchBeen;
    }

    public void setRecentlyWatchBeen(ArrayList<RecentlyWatchBean> arrayList) {
        this.recentlyWatchBeen = arrayList;
    }

    public void clearDatas() {
        if (this.recentlyWatchBeen == null) {
            this.recentlyWatchBeen = new ArrayList<>();
        }
        this.recentlyWatchBeen.clear();
        setHeadViewVisable(false);
        notifyDataSetChanged();
    }

    public boolean setIsPlayingID(String str) {
        boolean z = false;
        this.isPlayingID = str;
        if (this.recentlyWatchBeen != null) {
            int i = 0;
            while (true) {
                if (i < this.recentlyWatchBeen.size()) {
                    RecentlyWatchBean recentlyWatchBean = this.recentlyWatchBeen.get(i);
                    if (recentlyWatchBean == null || !TextUtils.equals(str, recentlyWatchBean.getVideoid())) {
                        i++;
                    } else {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        notifyDataSetChanged();
        return z;
    }

    public void setHeaderView(View view) {
        this.mHeaderView = view;
        notifyItemInserted(0);
    }

    public View getHeaderView() {
        return this.mHeaderView;
    }

    public void setHeadViewVisable(boolean z) {
        if (this.mHeaderView != null) {
            if (z) {
                this.mHeaderView.setVisibility(0);
            } else {
                this.mHeaderView.setVisibility(8);
            }
        }
    }
}

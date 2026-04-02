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
import com.fotoable.youtube.music.bean.FavBean;
import com.fotoable.youtube.music.e.a;
import com.fotoable.youtube.music.e.b;
import com.fotoable.youtube.music.helper.d;
import com.fotoable.youtube.music.ui.dialog.h;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MyFavoriteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = MyFavoriteAdapter.class.getSimpleName();
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    private Context context;
    private h customDialog;
    private ArrayList<FavBean> favBeanArrayList;
    private FragmentManager fragmentManager;
    private LayoutInflater inflater;
    private String isPlayingID = "";
    private View mHeaderView;
    private OnItemClickListener onItemClickListener;

    /* loaded from: classes.dex */
    public interface OnItemClickListener {
        void onAddToPlayQueue(FavBean favBean);

        void onPlayNext(FavBean favBean);

        void onPlayNow(FavBean favBean);
    }

    /* loaded from: classes.dex */
    public class DiscoverHolder_ViewBinding implements Unbinder {
        private DiscoverHolder target;

        @UiThread
        public DiscoverHolder_ViewBinding(DiscoverHolder discoverHolder, View view) {
            this.target = discoverHolder;
            discoverHolder.imgDel = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_del, "field 'imgDel'", ImageView.class);
            discoverHolder.txtDesc = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.txt_desc, "field 'txtDesc'", LaToTextView.class);
            discoverHolder.textTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_title, "field 'textTitle'", TextView.class);
            discoverHolder.linDesc = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lin_desc, "field 'linDesc'", LinearLayout.class);
            discoverHolder.imgIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_icon, "field 'imgIcon'", ImageView.class);
            discoverHolder.relRoot = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rel_root, "field 'relRoot'", RelativeLayout.class);
            discoverHolder.textTime = (TextView) Utils.findRequiredViewAsType(view, R.id.text_time, "field 'textTime'", TextView.class);
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
            discoverHolder.imgDel = null;
            discoverHolder.txtDesc = null;
            discoverHolder.textTitle = null;
            discoverHolder.linDesc = null;
            discoverHolder.imgIcon = null;
            discoverHolder.relRoot = null;
            discoverHolder.textTime = null;
            discoverHolder.viewLine = null;
        }
    }

    public MyFavoriteAdapter(Context context, FragmentManager fragmentManager) {
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
        return new DiscoverHolder(LayoutInflater.from(this.context).inflate(R.layout.view_holder_my_favority, viewGroup, false));
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void delFavoriteWatch(String str) {
        boolean z = false;
        if (this.favBeanArrayList != null && this.favBeanArrayList.size() > 0) {
            int i = 0;
            while (true) {
                if (i < this.favBeanArrayList.size()) {
                    FavBean favBean = this.favBeanArrayList.get(i);
                    if (favBean == null || !TextUtils.equals(favBean.getVideoid(), str)) {
                        i++;
                    } else {
                        z = true;
                        this.favBeanArrayList.remove(i);
                        break;
                    }
                } else {
                    break;
                }
            }
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        try {
            if (getItemViewType(i) != 0) {
                final int realPosition = getRealPosition(i);
                d.a(this.context, this.favBeanArrayList.get(realPosition).getImgUrl() == null ? "" : this.favBeanArrayList.get(realPosition).getImgUrl(), ((DiscoverHolder) viewHolder).imgIcon, R.mipmap.pic_recently);
                ((DiscoverHolder) viewHolder).textTitle.setText(this.favBeanArrayList.get(realPosition).getTitle() == null ? "" : this.favBeanArrayList.get(realPosition).getTitle());
                if (TextUtils.isEmpty(this.favBeanArrayList.get(realPosition).getArtists())) {
                    ((DiscoverHolder) viewHolder).txtDesc.setVisibility(8);
                } else {
                    ((DiscoverHolder) viewHolder).txtDesc.setText(this.favBeanArrayList.get(realPosition).getArtists());
                    ((DiscoverHolder) viewHolder).txtDesc.setVisibility(0);
                }
                ((DiscoverHolder) viewHolder).textTime.setText(this.favBeanArrayList.get(realPosition).getDuration() == null ? "" : this.favBeanArrayList.get(realPosition).getDuration());
                if (TextUtils.isEmpty(this.favBeanArrayList.get(realPosition).getDuration())) {
                    ((DiscoverHolder) viewHolder).textTime.setVisibility(8);
                }
                if (this.favBeanArrayList.get(realPosition).getVideoid().equalsIgnoreCase(this.isPlayingID)) {
                    ((DiscoverHolder) viewHolder).textTitle.setTextColor(SupportMenu.CATEGORY_MASK);
                    ((DiscoverHolder) viewHolder).txtDesc.setTextColor(SupportMenu.CATEGORY_MASK);
                } else {
                    ((DiscoverHolder) viewHolder).textTitle.setTextColor(this.context.getResources().getColor(R.color.favorite_title));
                    ((DiscoverHolder) viewHolder).txtDesc.setTextColor(this.context.getResources().getColor(R.color.favorite_desc));
                }
                if (realPosition == this.favBeanArrayList.size() - 1) {
                    ((DiscoverHolder) viewHolder).viewLine.setVisibility(8);
                }
                ((DiscoverHolder) viewHolder).imgDel.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.MyFavoriteAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        try {
                            ((FavBean) MyFavoriteAdapter.this.favBeanArrayList.get(realPosition)).setIsFav(0);
                            b.a().a(new a(1005, MyFavoriteAdapter.this.favBeanArrayList.get(realPosition)));
                            MyFavoriteAdapter.this.favBeanArrayList.remove(realPosition);
                            MyFavoriteAdapter.this.notifyDataSetChanged();
                        } catch (Throwable th) {
                            ThrowableExtension.printStackTrace(th);
                            com.fotoable.youtube.music.util.b.b("Dev-MyFavoriteOutPosition");
                        }
                    }
                });
                ((DiscoverHolder) viewHolder).relRoot.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.MyFavoriteAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        try {
                            if (MyFavoriteAdapter.this.onItemClickListener != null) {
                                MyFavoriteAdapter.this.onItemClickListener.onPlayNow((FavBean) MyFavoriteAdapter.this.favBeanArrayList.get(realPosition));
                            }
                        } catch (Throwable th) {
                            ThrowableExtension.printStackTrace(th);
                            com.fotoable.youtube.music.util.b.b("Dev-MyFavoriteOutPosition");
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
        return this.favBeanArrayList == null ? this.mHeaderView == null ? 0 : 1 : this.mHeaderView == null ? this.favBeanArrayList.size() : this.favBeanArrayList.size() + 1;
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
        @BindView(R.id.img_del)
        ImageView imgDel;
        @BindView(R.id.img_icon)
        ImageView imgIcon;
        @BindView(R.id.lin_desc)
        LinearLayout linDesc;
        @BindView(R.id.rel_root)
        RelativeLayout relRoot;
        @BindView(R.id.text_time)
        TextView textTime;
        @BindView(R.id.txt_title)
        TextView textTitle;
        @BindView(R.id.txt_desc)
        LaToTextView txtDesc;
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

    public void setAddDatas(List<FavBean> list) {
        if (this.favBeanArrayList == null) {
            this.favBeanArrayList = new ArrayList<>();
        }
        this.favBeanArrayList.clear();
        this.favBeanArrayList.addAll(list);
        notifyDataSetChanged();
    }

    public void cleanDatas() {
        if (this.favBeanArrayList == null) {
            this.favBeanArrayList = new ArrayList<>();
        }
        this.favBeanArrayList.clear();
        setHeadViewVisable(false);
        notifyDataSetChanged();
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

    public ArrayList<FavBean> getFavBeanArrayList() {
        return this.favBeanArrayList;
    }

    public void setIsPlayingID(String str) {
        this.isPlayingID = str;
        notifyDataSetChanged();
    }

    public void setHeaderView(View view) {
        this.mHeaderView = view;
        notifyItemInserted(0);
    }

    public View getHeaderView() {
        return this.mHeaderView;
    }
}

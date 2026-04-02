package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
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
import com.bumptech.glide.i;
import com.bumptech.glide.load.resource.bitmap.e;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.SubBean;
import com.fotoable.youtube.music.ui.activity.FeaturedPlayListDetailsActivity;
import com.fotoable.youtube.music.ui.activity.PlayListDetailsActivity;
import com.fotoable.youtube.music.ui.view.GlideRoundTransform;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.util.c;
import com.fotoable.youtube.music.util.h;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MySubscriptionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = MySubscriptionAdapter.class.getSimpleName();
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<SubBean> subBeanArrayList;

    /* loaded from: classes.dex */
    public class DiscoverHolder_ViewBinding implements Unbinder {
        private DiscoverHolder target;

        @UiThread
        public DiscoverHolder_ViewBinding(DiscoverHolder discoverHolder, View view) {
            this.target = discoverHolder;
            discoverHolder.imgIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_icon, "field 'imgIcon'", ImageView.class);
            discoverHolder.txtDesc = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.txt_desc, "field 'txtDesc'", LaToTextView.class);
            discoverHolder.textTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_title, "field 'textTitle'", TextView.class);
            discoverHolder.textUpdate = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.txt_update, "field 'textUpdate'", LaToTextView.class);
            discoverHolder.linDesc = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lin_desc, "field 'linDesc'", LinearLayout.class);
            discoverHolder.relRoot = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rel_root, "field 'relRoot'", RelativeLayout.class);
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
            discoverHolder.imgIcon = null;
            discoverHolder.txtDesc = null;
            discoverHolder.textTitle = null;
            discoverHolder.textUpdate = null;
            discoverHolder.linDesc = null;
            discoverHolder.relRoot = null;
            discoverHolder.viewLine = null;
        }
    }

    public MySubscriptionAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new DiscoverHolder(LayoutInflater.from(this.context).inflate(R.layout.view_holder_my_subscription2, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        try {
            i.c(this.context).a(this.subBeanArrayList.get(i).getImgUrl() == null ? "" : this.subBeanArrayList.get(i).getImgUrl()).a(new e(this.context), new GlideRoundTransform(this.context, 5)).c().d((int) R.mipmap.icon_playlist_default).a(((DiscoverHolder) viewHolder).imgIcon);
            ((DiscoverHolder) viewHolder).textTitle.setText(this.subBeanArrayList.get(i).getTitle() == null ? "" : this.subBeanArrayList.get(i).getTitle());
            ((DiscoverHolder) viewHolder).txtDesc.setText(this.subBeanArrayList.get(i).getDesc() == null ? "" : this.subBeanArrayList.get(i).getDesc());
            ((DiscoverHolder) viewHolder).textUpdate.setText(this.context.getResources().getString(R.string.updated) + " " + c.a(this.subBeanArrayList.get(i).getUpdateTime(), "yyyy-MM"));
            ((DiscoverHolder) viewHolder).relRoot.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.MySubscriptionAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i < MySubscriptionAdapter.this.subBeanArrayList.size()) {
                        MySubscriptionAdapter.this.openPlayDetails((SubBean) MySubscriptionAdapter.this.subBeanArrayList.get(i));
                    } else {
                        h.a(MySubscriptionAdapter.TAG, "数据错误...请解决");
                    }
                }
            });
        } catch (Throwable th) {
            ThrowableExtension.printStackTrace(th);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.subBeanArrayList == null) {
            return 0;
        }
        return this.subBeanArrayList.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* loaded from: classes.dex */
    public class DiscoverHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_icon)
        ImageView imgIcon;
        @BindView(R.id.lin_desc)
        LinearLayout linDesc;
        @BindView(R.id.rel_root)
        RelativeLayout relRoot;
        @BindView(R.id.txt_title)
        TextView textTitle;
        @BindView(R.id.txt_update)
        LaToTextView textUpdate;
        @BindView(R.id.txt_desc)
        LaToTextView txtDesc;
        @BindView(R.id.view_line)
        View viewLine;

        public DiscoverHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openPlayDetails(SubBean subBean) {
        Intent intent;
        try {
            if (!TextUtils.isEmpty(subBean.getType()) && Integer.valueOf(subBean.getType()).intValue() > 0) {
                intent = new Intent(this.context, FeaturedPlayListDetailsActivity.class);
                intent.putExtra("type", Integer.valueOf(subBean.getType()));
            } else {
                intent = new Intent(this.context, PlayListDetailsActivity.class);
            }
            intent.putExtra("PlaylistId", subBean.getPlaylistid());
            intent.putExtra("ImgUrl", subBean.getImgUrl());
            intent.putExtra("Title", subBean.getTitle());
            intent.putExtra("UpdateTime", subBean.getUpdateTime());
            intent.putExtra("Describe", subBean.getDesc());
            this.context.startActivity(intent);
        } catch (NumberFormatException e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public void setAddDatas(List<SubBean> list) {
        if (this.subBeanArrayList == null) {
            this.subBeanArrayList = new ArrayList<>();
        }
        this.subBeanArrayList.clear();
        this.subBeanArrayList.size();
        this.subBeanArrayList.addAll(list);
        notifyDataSetChanged();
    }

    public void cleanDatas() {
        if (this.subBeanArrayList != null) {
            this.subBeanArrayList.clear();
            notifyDataSetChanged();
        }
    }
}

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
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.GlobalRankBean;
import com.fotoable.youtube.music.helper.d;
import com.fotoable.youtube.music.ui.activity.GlobalMusicDetailsActivity;
import com.fotoable.youtube.music.util.b;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GlobalMusicAdapter extends BaseAdapter<ViewHolder> {
    private Context context;
    private ArrayList<GlobalRankBean> globalRankBeanArrayList;
    private LayoutInflater inflater;

    /* loaded from: classes.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.relRoot = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.ll_hit, "field 'relRoot'", RelativeLayout.class);
            viewHolder.imgIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.cover_iv, "field 'imgIcon'", ImageView.class);
            viewHolder.txtUpdateTime = (TextView) Utils.findRequiredViewAsType(view, R.id.text_update_time, "field 'txtUpdateTime'", TextView.class);
            viewHolder.txtTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.text_title, "field 'txtTitle'", TextView.class);
            viewHolder.txtSong1 = (TextView) Utils.findRequiredViewAsType(view, R.id.text_song1, "field 'txtSong1'", TextView.class);
            viewHolder.txtSong2 = (TextView) Utils.findRequiredViewAsType(view, R.id.text_song2, "field 'txtSong2'", TextView.class);
            viewHolder.txtSong3 = (TextView) Utils.findRequiredViewAsType(view, R.id.text_song3, "field 'txtSong3'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            viewHolder.relRoot = null;
            viewHolder.imgIcon = null;
            viewHolder.txtUpdateTime = null;
            viewHolder.txtTitle = null;
            viewHolder.txtSong1 = null;
            viewHolder.txtSong2 = null;
            viewHolder.txtSong3 = null;
        }
    }

    public GlobalMusicAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);
        setHasStableIds(true);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this.inflater.inflate(R.layout.view_holder_global_item, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        try {
            d.a(this.context, this.globalRankBeanArrayList.get(i).getImgUrl(), viewHolder.imgIcon);
            viewHolder.txtTitle.setText(this.globalRankBeanArrayList.get(i).getTitle() == null ? "" : this.globalRankBeanArrayList.get(i).getTitle());
            viewHolder.txtUpdateTime.setText(this.globalRankBeanArrayList.get(i).getUpdateDesc());
            List<GlobalRankBean.VideosBean> videos = this.globalRankBeanArrayList.get(i).getVideos();
            viewHolder.txtSong1.setVisibility(8);
            viewHolder.txtSong2.setVisibility(8);
            viewHolder.txtSong3.setVisibility(8);
            if (videos != null) {
                if (videos.size() >= 1) {
                    viewHolder.txtSong1.setVisibility(0);
                    viewHolder.txtSong1.setText(videos.get(0).getTitle() == null ? "" : "1. " + videos.get(0).getTitle());
                }
                if (videos.size() >= 2) {
                    viewHolder.txtSong2.setVisibility(0);
                    viewHolder.txtSong2.setText(videos.get(1).getTitle() == null ? "" : "2. " + videos.get(1).getTitle());
                }
                if (videos.size() >= 3) {
                    viewHolder.txtSong3.setVisibility(0);
                    viewHolder.txtSong3.setText(videos.get(2).getTitle() == null ? "" : "3. " + videos.get(2).getTitle());
                }
            }
            viewHolder.relRoot.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.GlobalMusicAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent(GlobalMusicAdapter.this.context, GlobalMusicDetailsActivity.class);
                    intent.putExtra("LastUpdateTime", ((GlobalRankBean) GlobalMusicAdapter.this.globalRankBeanArrayList.get(i)).getLastUpdateTime());
                    intent.putExtra("ImgURL", ((GlobalRankBean) GlobalMusicAdapter.this.globalRankBeanArrayList.get(i)).getImgUrl());
                    intent.putExtra(ShareConstants.TITLE, ((GlobalRankBean) GlobalMusicAdapter.this.globalRankBeanArrayList.get(i)).getTitle());
                    intent.putExtra("ChartsId", ((GlobalRankBean) GlobalMusicAdapter.this.globalRankBeanArrayList.get(i)).getChartsid());
                    GlobalMusicAdapter.this.context.startActivity(intent);
                    b.b("Charts-Global-Click-某个主流榜单点击", "榜单ID", Integer.valueOf(((GlobalRankBean) GlobalMusicAdapter.this.globalRankBeanArrayList.get(i)).getChartsid()));
                    b.a("Charts-Global-Click-某个主流榜单点击", "榜单ID", Integer.valueOf(((GlobalRankBean) GlobalMusicAdapter.this.globalRankBeanArrayList.get(i)).getChartsid()));
                }
            });
        } catch (Throwable th) {
            ThrowableExtension.printStackTrace(th);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.globalRankBeanArrayList == null) {
            return 0;
        }
        return this.globalRankBeanArrayList.size();
    }

    @Override // com.fotoable.youtube.music.ui.adapter.BaseAdapter
    public void onDestroy() {
        this.context = null;
        this.inflater = null;
    }

    /* loaded from: classes.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cover_iv)
        public ImageView imgIcon;
        @BindView(R.id.ll_hit)
        public RelativeLayout relRoot;
        @BindView(R.id.text_song1)
        public TextView txtSong1;
        @BindView(R.id.text_song2)
        public TextView txtSong2;
        @BindView(R.id.text_song3)
        public TextView txtSong3;
        @BindView(R.id.text_title)
        public TextView txtTitle;
        @BindView(R.id.text_update_time)
        public TextView txtUpdateTime;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setAddDatas(ArrayList<GlobalRankBean> arrayList) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (this.globalRankBeanArrayList == null) {
            this.globalRankBeanArrayList = new ArrayList<>();
        }
        this.globalRankBeanArrayList.clear();
        this.globalRankBeanArrayList.addAll(arrayList);
        notifyDataSetChanged();
    }
}

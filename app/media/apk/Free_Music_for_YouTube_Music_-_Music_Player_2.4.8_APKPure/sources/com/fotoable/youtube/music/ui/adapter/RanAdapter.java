package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.RanBean;
import com.fotoable.youtube.music.helper.d;
import com.fotoable.youtube.music.ui.activity.PlayListDetailsActivity;
import com.fotoable.youtube.music.util.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RanAdapter extends BaseAdapter<ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<RanBean> playBeanArrayList;

    public RanAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);
        setHasStableIds(true);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this.inflater.inflate(R.layout.view_holder_ran_item, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final RanBean ranBean = this.playBeanArrayList.get(i);
        viewHolder.cover_iv.setOnClickListener(new View.OnClickListener(this, ranBean) { // from class: com.fotoable.youtube.music.ui.adapter.RanAdapter$$Lambda$0
            private final RanAdapter arg$1;
            private final RanBean arg$2;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
                this.arg$2 = ranBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.arg$1.lambda$onBindViewHolder$0$RanAdapter(this.arg$2, view);
            }
        });
        viewHolder.text_title.setText(ranBean.getTitle());
        d.a(this.context, ranBean.getImgUrl(), viewHolder.cover_iv);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$onBindViewHolder$0$RanAdapter(RanBean ranBean, View view) {
        b.b("Charts-Click", "value", ranBean.getPlaylistid());
        b.a("榜单点击", "榜单ID", ranBean.getPlaylistid());
        Intent intent = new Intent(this.context, PlayListDetailsActivity.class);
        intent.putExtra("PlaylistId", ranBean.getPlaylistid());
        intent.putExtra("ImgUrl", ranBean.getImgUrl());
        intent.putExtra("Title", ranBean.getTitle());
        intent.putExtra("SongsCount", ranBean.getSongs_play_count());
        intent.putExtra("MusicCount", ranBean.getMusic_play_count());
        intent.putExtra("UpdateTime", ranBean.getUpdateTime());
        intent.putExtra("Describe", ranBean.getDescription());
        this.context.startActivity(intent);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.playBeanArrayList == null) {
            return 0;
        }
        return this.playBeanArrayList.size();
    }

    @Override // com.fotoable.youtube.music.ui.adapter.BaseAdapter
    public void onDestroy() {
        this.context = null;
        this.inflater = null;
    }

    /* loaded from: classes.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView cover_iv;
        public LinearLayout ll_hit;
        public TextView text_title;

        public ViewHolder(View view) {
            super(view);
            this.ll_hit = (LinearLayout) view.findViewById(R.id.ll_hit);
            this.cover_iv = (ImageView) view.findViewById(R.id.cover_iv);
            this.text_title = (TextView) view.findViewById(R.id.text_title);
        }
    }

    public void setAddDatas(ArrayList<RanBean> arrayList) {
        if (this.playBeanArrayList == null) {
            this.playBeanArrayList = arrayList;
            notifyDataSetChanged();
            return;
        }
        int size = this.playBeanArrayList.size();
        this.playBeanArrayList.addAll(arrayList);
        notifyItemRangeInserted(size, this.playBeanArrayList.size() - size);
    }

    public void cleanDatas() {
        if (this.playBeanArrayList != null) {
            this.playBeanArrayList.clear();
            this.playBeanArrayList = null;
        }
    }
}

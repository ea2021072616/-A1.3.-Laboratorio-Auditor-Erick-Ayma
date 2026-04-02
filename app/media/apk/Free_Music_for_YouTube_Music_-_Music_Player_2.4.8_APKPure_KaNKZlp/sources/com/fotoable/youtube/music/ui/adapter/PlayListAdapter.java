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
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bumptech.glide.i;
import com.bumptech.glide.load.b.b;
import com.bumptech.glide.load.resource.bitmap.e;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.PlayBean;
import com.fotoable.youtube.music.ui.activity.FeaturedPlayListDetailsActivity;
import com.fotoable.youtube.music.ui.activity.PlayListDetailsActivity;
import com.fotoable.youtube.music.ui.view.GlideRoundTransform;
import com.fotoable.youtube.music.util.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class PlayListAdapter extends BaseAdapter<ViewHolder> {
    private Context context;
    private float density;
    private String editorChoiceTitle;
    private LayoutInflater inflater;
    private ArrayList<PlayBean> playBeanArrayList;
    private int source;
    private int type = 1;

    /* loaded from: classes.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.ll_hit = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_hit, "field 'll_hit'", LinearLayout.class);
            viewHolder.cover_iv = (ImageView) Utils.findRequiredViewAsType(view, R.id.cover_iv, "field 'cover_iv'", ImageView.class);
            viewHolder.text_number = (TextView) Utils.findRequiredViewAsType(view, R.id.text_number, "field 'text_number'", TextView.class);
            viewHolder.text_title = (TextView) Utils.findRequiredViewAsType(view, R.id.text_title, "field 'text_title'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            viewHolder.ll_hit = null;
            viewHolder.cover_iv = null;
            viewHolder.text_number = null;
            viewHolder.text_title = null;
        }
    }

    public PlayListAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);
        setHasStableIds(true);
        this.density = context.getResources().getDisplayMetrics().density;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this.inflater.inflate(R.layout.view_holder_play_list_item, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.setIsRecyclable(false);
        final PlayBean playBean = this.playBeanArrayList.get(i);
        viewHolder.cover_iv.setOnClickListener(new View.OnClickListener(this, playBean) { // from class: com.fotoable.youtube.music.ui.adapter.PlayListAdapter$$Lambda$0
            private final PlayListAdapter arg$1;
            private final PlayBean arg$2;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
                this.arg$2 = playBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.arg$1.lambda$onBindViewHolder$0$PlayListAdapter(this.arg$2, view);
            }
        });
        viewHolder.text_title.setText(playBean.getTitle());
        if (playBean.getCounter() != null && playBean.getCounter().getData() != null) {
            viewHolder.text_number.setText(String.valueOf(playBean.getCounter().getData().getSongs_play_count()));
        } else if (playBean.getPlaylistViewCount() > 0) {
            viewHolder.text_number.setText(String.valueOf(playBean.getPlaylistViewCount()));
        }
        i.c(this.context).a(playBean.getImgUrl()).d((int) R.mipmap.icon_bigplaylistdefault).a(new e(this.context), new GlideRoundTransform(this.context, 5)).b(b.ALL).c((int) R.mipmap.icon_bigplaylistdefault).a(viewHolder.cover_iv);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$onBindViewHolder$0$PlayListAdapter(PlayBean playBean, View view) {
        if (this.source == 1001 || this.source == 1002 || this.source == 2201) {
            com.fotoable.youtube.music.util.b.b("PlayList-歌单点击", "视频ID", playBean.getPlaylistid());
            com.fotoable.youtube.music.util.b.a("PlayList-歌单点击", "视频ID", playBean.getPlaylistid());
        }
        Intent intent = new Intent();
        if (this.type == 1) {
            intent.setClass(this.context, PlayListDetailsActivity.class);
        } else {
            intent.setClass(this.context, FeaturedPlayListDetailsActivity.class);
            intent.putExtra("type", this.type);
        }
        intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, this.source);
        if (this.source == 2201) {
            intent.putExtra("editorChoiceTitle", this.editorChoiceTitle);
        }
        intent.putExtra("PlaylistId", playBean.getPlaylistid());
        intent.putExtra("ImgUrl", playBean.getImgUrl());
        intent.putExtra("Title", playBean.getTitle());
        intent.putExtra("UpdateTime", playBean.getUpdateTime());
        intent.putExtra("Describe", playBean.getDescription());
        this.context.startActivity(intent);
        h.a("PlayListAdapter", "cover:" + playBean.getImgUrl());
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
        this.playBeanArrayList = null;
    }

    public void setSource(int i) {
        this.source = i;
    }

    public void setEditorChoiceTitle(String str) {
        this.editorChoiceTitle = str;
    }

    /* loaded from: classes.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cover_iv)
        public ImageView cover_iv;
        @BindView(R.id.ll_hit)
        public LinearLayout ll_hit;
        @BindView(R.id.text_number)
        public TextView text_number;
        @BindView(R.id.text_title)
        public TextView text_title;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void cleanData() {
        if (this.playBeanArrayList != null) {
            this.playBeanArrayList.clear();
            this.playBeanArrayList = null;
        }
    }

    public void setAddData(List<PlayBean> list) {
        if (this.playBeanArrayList == null) {
            this.playBeanArrayList = new ArrayList<>();
            this.playBeanArrayList.addAll(list);
            notifyDataSetChanged();
            return;
        }
        int size = this.playBeanArrayList.size();
        this.playBeanArrayList.addAll(list);
        notifyItemRangeInserted(size, this.playBeanArrayList.size() - size);
    }

    public void setType(int i) {
        this.type = i;
    }
}

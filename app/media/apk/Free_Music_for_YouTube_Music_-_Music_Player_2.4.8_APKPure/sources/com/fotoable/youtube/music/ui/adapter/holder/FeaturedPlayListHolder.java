package com.fotoable.youtube.music.ui.adapter.holder;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bumptech.glide.i;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.FeaturedPlaylistBean;
import com.fotoable.youtube.music.ui.activity.FeaturedPlayListDetailsActivity;
import com.fotoable.youtube.music.ui.adapter.holder.FeaturedPlayListHolder;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.util.b;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.List;
/* loaded from: classes.dex */
public class FeaturedPlayListHolder extends AbsHomeItemHolder {
    private Context context;
    private List<FeaturedPlaylistBean> featuredPlaylistBeen;
    private boolean isShow;
    @BindView(R.id.recycle_view)
    RecyclerView recyclerView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class TopAdapter extends RecyclerView.Adapter<ViewHolder> {
        private Context context;
        List<FeaturedPlaylistBean> featuredPlaylistBeen;
        private LayoutInflater inflater;

        /* loaded from: classes.dex */
        public class ViewHolder_ViewBinding implements Unbinder {
            private ViewHolder target;

            @UiThread
            public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
                this.target = viewHolder;
                viewHolder.ivImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.iv_img, "field 'ivImg'", RoundedImageView.class);
                viewHolder.textNumber = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.text_number, "field 'textNumber'", LaToTextView.class);
                viewHolder.tvName = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'tvName'", LaToTextView.class);
            }

            @Override // butterknife.Unbinder
            @CallSuper
            public void unbind() {
                ViewHolder viewHolder = this.target;
                if (viewHolder == null) {
                    throw new IllegalStateException("Bindings already cleared.");
                }
                this.target = null;
                viewHolder.ivImg = null;
                viewHolder.textNumber = null;
                viewHolder.tvName = null;
            }
        }

        public TopAdapter(Context context, List<FeaturedPlaylistBean> list) {
            this.context = context;
            this.featuredPlaylistBeen = list;
            this.inflater = LayoutInflater.from(this.context);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(this.inflater.inflate(R.layout.view_holder_featured_item, viewGroup, false));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            final FeaturedPlaylistBean featuredPlaylistBean;
            b.b("推荐页-推荐歌单列表-展示次数");
            if (this.featuredPlaylistBeen != null && (featuredPlaylistBean = this.featuredPlaylistBeen.get(i)) != null) {
                viewHolder.ivImg.setOnClickListener(new View.OnClickListener(this, featuredPlaylistBean) { // from class: com.fotoable.youtube.music.ui.adapter.holder.FeaturedPlayListHolder$TopAdapter$$Lambda$0
                    private final FeaturedPlayListHolder.TopAdapter arg$1;
                    private final FeaturedPlaylistBean arg$2;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.arg$1 = this;
                        this.arg$2 = featuredPlaylistBean;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        this.arg$1.lambda$onBindViewHolder$0$FeaturedPlayListHolder$TopAdapter(this.arg$2, view);
                    }
                });
                viewHolder.tvName.setText(featuredPlaylistBean.getTitle());
                viewHolder.textNumber.setText(String.valueOf(featuredPlaylistBean.getPlaylistViewCount()));
                i.c(this.context).a(featuredPlaylistBean.getImgUrl()).l().b(this.context.getResources().getDrawable(R.mipmap.icon_playlist_default)).a(viewHolder.ivImg);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void lambda$onBindViewHolder$0$FeaturedPlayListHolder$TopAdapter(FeaturedPlaylistBean featuredPlaylistBean, View view) {
            b.b("推荐页-推荐歌单列表-点击歌单", "歌单ID", featuredPlaylistBean.getPlaylistid());
            b.a("推荐页-推荐歌单列表-点击歌单", "歌单ID", featuredPlaylistBean.getPlaylistid());
            Intent intent = new Intent(this.context, FeaturedPlayListDetailsActivity.class);
            intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, 2202);
            intent.putExtra("PlaylistId", featuredPlaylistBean.getPlaylistid());
            intent.putExtra("type", 1);
            intent.putExtra("ImgUrl", featuredPlaylistBean.getImgUrl());
            intent.putExtra("Title", featuredPlaylistBean.getTitle());
            intent.putExtra("UpdateTime", featuredPlaylistBean.getUpdateTime());
            intent.putExtra("Describe", featuredPlaylistBean.getDescription());
            this.context.startActivity(intent);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.featuredPlaylistBeen == null) {
                return 0;
            }
            return this.featuredPlaylistBeen.size();
        }

        /* loaded from: classes.dex */
        public class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.iv_img)
            RoundedImageView ivImg;
            @BindView(R.id.text_number)
            LaToTextView textNumber;
            @BindView(R.id.tv_name)
            LaToTextView tvName;

            public ViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }
    }

    public FeaturedPlayListHolder(View view) {
        super(view);
        this.isShow = false;
        this.context = view.getContext();
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this.context, 0, false));
        this.recyclerView.setNestedScrollingEnabled(false);
    }

    private void initRecycleView() {
        if (this.featuredPlaylistBeen != null) {
            showViews();
            this.recyclerView.setAdapter(new TopAdapter(this.context, this.featuredPlaylistBeen));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.ui.adapter.holder.AbsHomeItemHolder
    public void onAttached() {
        super.onAttached();
        if (this.isShow) {
            initRecycleView();
        }
    }

    public void setData(List<FeaturedPlaylistBean> list) {
        this.featuredPlaylistBeen = list;
        if (isAttached()) {
            initRecycleView();
        } else {
            this.isShow = true;
        }
    }
}

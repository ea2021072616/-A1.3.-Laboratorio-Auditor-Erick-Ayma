package com.fotoable.youtube.music.ui.adapter.holder;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.GridLayoutManager;
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
import com.facebook.GraphResponse;
import com.facebook.ads.AdError;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.bean.HomeListNewBean;
import com.fotoable.youtube.music.e.a;
import com.fotoable.youtube.music.ui.activity.HomeListActivity;
import com.fotoable.youtube.music.ui.adapter.holder.FreshSongsHolder;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.util.b;
import com.fotoable.youtube.music.util.d;
import com.fotoable.youtube.music.util.h;
import com.fotoable.youtube.music.util.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FreshSongsHolder extends AbsHomeItemHolder {
    private Context context;
    private ArrayList<HomeListNewBean> homeListNewBeen;
    private boolean isShow;
    @BindView(R.id.recycle_view)
    RecyclerView recyclerView;
    @BindView(R.id.tv_all)
    TextView tv_all;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class TopAdapter extends RecyclerView.Adapter<ViewHolder> {
        private Context context;
        private ArrayList<HomeListNewBean> homeListNewBeen;
        private LayoutInflater inflater;

        /* loaded from: classes.dex */
        public class ViewHolder_ViewBinding implements Unbinder {
            private ViewHolder target;

            @UiThread
            public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
                this.target = viewHolder;
                viewHolder.ivIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_icon, "field 'ivIcon'", ImageView.class);
                viewHolder.textTime = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.text_time, "field 'textTime'", LaToTextView.class);
                viewHolder.txtTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_title, "field 'txtTitle'", TextView.class);
                viewHolder.txtContent = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_content, "field 'txtContent'", TextView.class);
                viewHolder.linDesc = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lin_desc, "field 'linDesc'", LinearLayout.class);
                viewHolder.line = Utils.findRequiredView(view, R.id.line, "field 'line'");
                viewHolder.rlDetails = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_details, "field 'rlDetails'", RelativeLayout.class);
            }

            @Override // butterknife.Unbinder
            @CallSuper
            public void unbind() {
                ViewHolder viewHolder = this.target;
                if (viewHolder == null) {
                    throw new IllegalStateException("Bindings already cleared.");
                }
                this.target = null;
                viewHolder.ivIcon = null;
                viewHolder.textTime = null;
                viewHolder.txtTitle = null;
                viewHolder.txtContent = null;
                viewHolder.linDesc = null;
                viewHolder.line = null;
                viewHolder.rlDetails = null;
            }
        }

        public TopAdapter(Context context, ArrayList<HomeListNewBean> arrayList) {
            h.a("freshsong", GraphResponse.SUCCESS_KEY);
            this.context = context;
            this.homeListNewBeen = arrayList;
            this.inflater = LayoutInflater.from(this.context);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(this.inflater.inflate(R.layout.view_fresh_songs, viewGroup, false));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder viewHolder, final int i) {
            if (this.homeListNewBeen != null) {
                final HomeListNewBean homeListNewBean = this.homeListNewBeen.get(i);
                viewHolder.txtTitle.setTextColor(this.context.getResources().getColor(R.color.favorite_title));
                viewHolder.txtContent.setTextColor(this.context.getResources().getColor(R.color.favorite_desc));
                viewHolder.txtTitle.setText(homeListNewBean.getTitle());
                viewHolder.textTime.setText(homeListNewBean.getDuration());
                if (TextUtils.isEmpty(homeListNewBean.getArtists())) {
                    viewHolder.txtContent.setVisibility(8);
                } else {
                    viewHolder.txtContent.setVisibility(0);
                    viewHolder.txtContent.setText(homeListNewBean.getArtists());
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, d.a(86.0f));
                int b2 = w.b(MusicApplication.c());
                if (i <= 3) {
                    layoutParams.width = b2 - d.a(32.0f);
                } else {
                    layoutParams.width = b2;
                }
                viewHolder.rlDetails.setLayoutParams(layoutParams);
                com.fotoable.youtube.music.helper.d.a(this.context, homeListNewBean.getImgUrl(), viewHolder.ivIcon);
                viewHolder.rlDetails.setOnClickListener(new View.OnClickListener(this, homeListNewBean, i) { // from class: com.fotoable.youtube.music.ui.adapter.holder.FreshSongsHolder$TopAdapter$$Lambda$0
                    private final FreshSongsHolder.TopAdapter arg$1;
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
                        this.arg$1.lambda$onBindViewHolder$0$FreshSongsHolder$TopAdapter(this.arg$2, this.arg$3, view);
                    }
                });
                if (i % 4 == 3) {
                    viewHolder.line.setVisibility(8);
                } else {
                    viewHolder.line.setVisibility(0);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void lambda$onBindViewHolder$0$FreshSongsHolder$TopAdapter(HomeListNewBean homeListNewBean, int i, View view) {
            b.b("FreshSongs-抢先试听-点击单曲", "视频ID", homeListNewBean.getVideoid());
            b.a("FreshSongs-抢先试听-点击单曲", "视频ID", homeListNewBean.getVideoid());
            com.fotoable.youtube.music.e.b.a().a(new a((int) AdError.INTERNAL_ERROR_CODE, com.fotoable.youtube.music.newplayer.a.b.b(this.homeListNewBeen), i));
            h.a("发送播放事件");
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.homeListNewBeen == null) {
                return 0;
            }
            if (this.homeListNewBeen.size() < 8) {
                return this.homeListNewBeen.size();
            }
            return 8;
        }

        /* loaded from: classes.dex */
        public class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.iv_icon)
            ImageView ivIcon;
            @BindView(R.id.lin_desc)
            LinearLayout linDesc;
            @BindView(R.id.line)
            View line;
            @BindView(R.id.rl_details)
            RelativeLayout rlDetails;
            @BindView(R.id.text_time)
            LaToTextView textTime;
            @BindView(R.id.txt_content)
            TextView txtContent;
            @BindView(R.id.txt_title)
            TextView txtTitle;

            public ViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }
    }

    public FreshSongsHolder(View view) {
        super(view);
        this.context = view.getContext();
        this.tv_all.setText(this.context.getString(R.string.fresh_songs));
        this.tv_all.setOnClickListener(new View.OnClickListener(this) { // from class: com.fotoable.youtube.music.ui.adapter.holder.FreshSongsHolder$$Lambda$0
            private final FreshSongsHolder arg$1;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                this.arg$1.lambda$new$0$FreshSongsHolder(view2);
            }
        });
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setNestedScrollingEnabled(false);
        this.recyclerView.setLayoutManager(new GridLayoutManager(this.context, 4, 0, false));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$new$0$FreshSongsHolder(View view) {
        Intent intent = new Intent(this.context, HomeListActivity.class);
        intent.putExtra("EXTRA_TYPE_KEY", 1);
        this.context.startActivity(intent);
        b.b("FreshSongs-抢先试听-更多");
        b.a("FreshSongs-抢先试听-更多");
    }

    private void initRecycleView() {
        if (this.homeListNewBeen != null) {
            this.recyclerView.setAdapter(new TopAdapter(this.context, this.homeListNewBeen));
        }
    }

    @Override // com.fotoable.youtube.music.ui.adapter.holder.AbsHomeItemHolder
    public void onDestory() {
        super.onDestory();
        this.context = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.ui.adapter.holder.AbsHomeItemHolder
    public void onAttached() {
        super.onAttached();
        if (this.isShow) {
            initRecycleView();
        }
    }

    public void setData(ArrayList<HomeListNewBean> arrayList) {
        this.homeListNewBeen = arrayList;
        if (isAttached()) {
            initRecycleView();
        } else {
            this.isShow = true;
        }
    }
}

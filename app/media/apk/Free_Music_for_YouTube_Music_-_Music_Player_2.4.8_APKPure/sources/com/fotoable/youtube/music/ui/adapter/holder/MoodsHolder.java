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
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bumptech.glide.i;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.CategoryListBean;
import com.fotoable.youtube.music.ui.activity.EditorChoicePlayListActivity;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.util.b;
import java.util.List;
/* loaded from: classes.dex */
public class MoodsHolder extends AbsHomeItemHolder {
    private List<CategoryListBean.CategoryBean> data;
    private boolean isShow;
    private Context mContext;
    @BindView(R.id.moods_recycler_view)
    RecyclerView moodsRecyclerView;
    @BindView(R.id.moods_title_tx)
    LaToTextView moodsTitleTx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class MoodAdapter extends RecyclerView.Adapter<ViewHolder> {
        private List<CategoryListBean.CategoryBean> data;
        private Context mContext;
        private LayoutInflater mInflater;

        /* loaded from: classes.dex */
        public class ViewHolder_ViewBinding implements Unbinder {
            private ViewHolder target;

            @UiThread
            public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
                this.target = viewHolder;
                viewHolder.moodItemCoverImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.mood_item_cover_img, "field 'moodItemCoverImg'", ImageView.class);
                viewHolder.titleTextView = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.mood_item_title_tx, "field 'titleTextView'", LaToTextView.class);
            }

            @Override // butterknife.Unbinder
            @CallSuper
            public void unbind() {
                ViewHolder viewHolder = this.target;
                if (viewHolder == null) {
                    throw new IllegalStateException("Bindings already cleared.");
                }
                this.target = null;
                viewHolder.moodItemCoverImg = null;
                viewHolder.titleTextView = null;
            }
        }

        public MoodAdapter(Context context, List<CategoryListBean.CategoryBean> list) {
            this.mContext = context;
            this.data = list;
            this.mInflater = LayoutInflater.from(context);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(this.mInflater.inflate(R.layout.view_holder_mood_item, viewGroup, false));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            final CategoryListBean.CategoryBean categoryBean = this.data.get(i);
            if (categoryBean != null) {
                viewHolder.titleTextView.setText(categoryBean.getTitle());
                i.c(this.mContext).a(categoryBean.getImgUrl()).i().d((int) R.mipmap.icon_mood_default).a(viewHolder.moodItemCoverImg);
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.holder.MoodsHolder.MoodAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Intent intent = new Intent(MoodAdapter.this.mContext, EditorChoicePlayListActivity.class);
                        intent.putExtra("extra_id", categoryBean.getCategoryid());
                        intent.putExtra("extra_title", categoryBean.getTitle());
                        intent.putExtra("extra_type", 2);
                        MoodAdapter.this.mContext.startActivity(intent);
                        b.b("分类歌单-Mood-点击次数", "名称", categoryBean.getTitle());
                    }
                });
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.data.size();
        }

        /* loaded from: classes.dex */
        public class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.mood_item_cover_img)
            ImageView moodItemCoverImg;
            @BindView(R.id.mood_item_title_tx)
            LaToTextView titleTextView;

            ViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }
    }

    public MoodsHolder(View view) {
        super(view);
        this.isShow = false;
        this.mContext = view.getContext();
        this.moodsRecyclerView.setHasFixedSize(true);
        this.moodsRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.moodsRecyclerView.setNestedScrollingEnabled(false);
    }

    private void initRecyclerView() {
        if (this.data != null) {
            showViews();
            this.moodsRecyclerView.setAdapter(new MoodAdapter(this.mContext, this.data));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.ui.adapter.holder.AbsHomeItemHolder
    public void onAttached() {
        super.onAttached();
        if (this.isShow) {
            initRecyclerView();
        }
    }

    public void setData(List<CategoryListBean.CategoryBean> list) {
        this.data = list;
        if (isAttached()) {
            initRecyclerView();
        } else {
            this.isShow = true;
        }
    }

    @Override // com.fotoable.youtube.music.ui.adapter.holder.AbsHomeItemHolder
    public void onDestory() {
        super.onDestory();
        this.mContext = null;
    }
}

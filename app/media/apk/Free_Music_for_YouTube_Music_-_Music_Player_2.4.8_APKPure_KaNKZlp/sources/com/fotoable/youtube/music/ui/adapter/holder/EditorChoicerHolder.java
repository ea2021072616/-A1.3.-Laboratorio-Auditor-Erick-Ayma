package com.fotoable.youtube.music.ui.adapter.holder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.EditorChoiceBean;
import com.fotoable.youtube.music.helper.d;
import com.fotoable.youtube.music.ui.activity.EditorChoicePlayListActivity;
import com.fotoable.youtube.music.ui.adapter.holder.EditorChoicerHolder;
import com.fotoable.youtube.music.util.b;
import com.fotoable.youtube.music.util.f;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.List;
/* loaded from: classes.dex */
public class EditorChoicerHolder extends AbsHomeItemHolder {
    private Context context;
    private List<EditorChoiceBean> editorChoiceBeen;
    private boolean isShow;
    @BindView(R.id.recycle_view)
    RecyclerView recyclerView;

    public EditorChoicerHolder(View view) {
        super(view);
        this.isShow = false;
        this.context = view.getContext();
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this.context, 0, false));
        this.recyclerView.setNestedScrollingEnabled(false);
    }

    private void initRecycleView() {
        if (this.editorChoiceBeen != null) {
            showViews();
            this.recyclerView.setAdapter(new TopAdapter(this.context, this.editorChoiceBeen));
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
            b.b("推荐页-编辑推荐-展示次数");
        }
    }

    public void setData(List<EditorChoiceBean> list) {
        this.editorChoiceBeen = list;
        if (isAttached()) {
            initRecycleView();
        } else {
            this.isShow = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class TopAdapter extends RecyclerView.Adapter<ViewHolder> {
        private Context context;
        private List<EditorChoiceBean> editorChoiceBeen;
        private LayoutInflater inflater;

        public TopAdapter(Context context, List<EditorChoiceBean> list) {
            this.context = context;
            this.editorChoiceBeen = list;
            this.inflater = LayoutInflater.from(this.context);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(this.inflater.inflate(R.layout.view_home_editor_choices_item, viewGroup, false));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            final EditorChoiceBean editorChoiceBean;
            if (this.editorChoiceBeen != null && (editorChoiceBean = this.editorChoiceBeen.get(i)) != null) {
                viewHolder.cover_iv.setOnClickListener(new View.OnClickListener(this, editorChoiceBean) { // from class: com.fotoable.youtube.music.ui.adapter.holder.EditorChoicerHolder$TopAdapter$$Lambda$0
                    private final EditorChoicerHolder.TopAdapter arg$1;
                    private final EditorChoiceBean arg$2;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.arg$1 = this;
                        this.arg$2 = editorChoiceBean;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        this.arg$1.lambda$onBindViewHolder$0$EditorChoicerHolder$TopAdapter(this.arg$2, view);
                    }
                });
                viewHolder.text_title.setText(editorChoiceBean.getTitle());
                d.a(this.context, editorChoiceBean.getImgUrl(), viewHolder.cover_iv, R.drawable.icon_editordefault);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void lambda$onBindViewHolder$0$EditorChoicerHolder$TopAdapter(EditorChoiceBean editorChoiceBean, View view) {
            b.b("推荐页-编辑推荐-进入新版歌单页");
            b.b("推荐页-编辑推荐-" + editorChoiceBean.getTitle() + "点击进入");
            b.a("推荐页-编辑推荐-" + editorChoiceBean.getTitle() + "点击进入");
            Intent intent = new Intent(this.context, EditorChoicePlayListActivity.class);
            intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, 2201);
            intent.putExtra("extra_id", editorChoiceBean.getChoiceid());
            intent.putExtra("extra_title", editorChoiceBean.getTitle());
            intent.putExtra("extra_type", 1);
            this.context.startActivity(intent);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.editorChoiceBeen == null) {
                return 0;
            }
            return this.editorChoiceBeen.size();
        }

        /* loaded from: classes.dex */
        public static class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView cover_iv;
            public TextView text_title;

            public ViewHolder(View view) {
                super(view);
                this.cover_iv = (RoundedImageView) view.findViewById(R.id.cover_iv);
                this.text_title = (TextView) view.findViewById(R.id.text_title);
                this.text_title.setTypeface(f.g());
            }
        }
    }
}

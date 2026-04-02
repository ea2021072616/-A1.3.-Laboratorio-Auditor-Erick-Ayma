package com.fotoable.youtube.music.ui.adapter.holder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class MySubscriptionHolder extends AbsHomeItemHolder {
    private Context context;
    @BindView(R.id.recycle_view)
    RecyclerView recyclerView;

    public MySubscriptionHolder(View view) {
        super(view);
        this.context = view.getContext();
        initRecycleView();
    }

    private void initRecycleView() {
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setNestedScrollingEnabled(false);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this.context));
        this.recyclerView.setAdapter(new SubscriptionAdapter(this.context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SubscriptionAdapter extends RecyclerView.Adapter<ViewHolder> {
        private Context context;
        private LayoutInflater inflater;

        public SubscriptionAdapter(Context context) {
            this.context = context;
            this.inflater = LayoutInflater.from(this.context);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(this.inflater.inflate(R.layout.view_holder_my_subscription_item, viewGroup, false));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 3;
        }

        /* loaded from: classes.dex */
        public static class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView coverIv;

            public ViewHolder(View view) {
                super(view);
                this.coverIv = (ImageView) view.findViewById(R.id.sub_cover);
            }
        }
    }
}

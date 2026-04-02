package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
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
import com.fotoable.youtube.music.bean.RadioBean;
import com.fotoable.youtube.music.e.a;
import com.fotoable.youtube.music.e.b;
import com.fotoable.youtube.music.newplayer.a.c;
import com.fotoable.youtube.music.ui.view.GlideRoundTransform;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class HotRadioAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<RadioBean> allData = new ArrayList();
    private Context mContext;
    private LayoutInflater mInflater;

    /* loaded from: classes.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.radioCoverImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.radio_cover_img, "field 'radioCoverImg'", ImageView.class);
            viewHolder.radioTitleTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.radio_title_tx, "field 'radioTitleTx'", LaToTextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            viewHolder.radioCoverImg = null;
            viewHolder.radioTitleTx = null;
        }
    }

    public HotRadioAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this.mInflater.inflate(R.layout.view_holder_hot_radio, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final RadioBean radioBean = this.allData.get(i);
        viewHolder.radioTitleTx.setText(radioBean.getTitle());
        i.c(this.mContext).a(radioBean.getImgUrl()).a(new GlideRoundTransform(this.mContext, 5)).d((int) R.mipmap.icon_radio_default).i().c((int) R.mipmap.icon_radio_default).a(viewHolder.radioCoverImg);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.HotRadioAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.a().a(new a(2201, c.a(radioBean)));
                com.fotoable.youtube.music.util.b.b("电台-热门电台-点击播放");
                com.fotoable.youtube.music.util.b.a("电台-热门电台-点击播放");
            }
        });
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.allData.size() > 12) {
            return 12;
        }
        return this.allData.size();
    }

    public void refresh(List<RadioBean> list) {
        if (list != null) {
            clearData();
            addData(list);
        }
    }

    public void addData(List<RadioBean> list) {
        if (list != null) {
            int size = this.allData.size();
            int size2 = list.size();
            this.allData.addAll(list);
            if (size > 0 && size2 > 0) {
                notifyItemRangeInserted(size, size2);
            } else {
                notifyDataSetChanged();
            }
        }
    }

    public void clearData() {
        int size = this.allData.size();
        this.allData.clear();
        notifyItemRangeRemoved(0, size);
    }

    /* loaded from: classes.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.radio_cover_img)
        ImageView radioCoverImg;
        @BindView(R.id.radio_title_tx)
        LaToTextView radioTitleTx;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

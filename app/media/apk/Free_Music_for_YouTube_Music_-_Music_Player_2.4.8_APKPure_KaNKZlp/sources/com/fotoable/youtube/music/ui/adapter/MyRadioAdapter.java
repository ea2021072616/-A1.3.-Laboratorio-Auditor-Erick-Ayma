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
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MyRadioAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<RadioBean> allData = new ArrayList();
    private DeleteListener deleteListener;
    private Context mContext;
    private LayoutInflater mInflater;

    /* loaded from: classes.dex */
    public interface DeleteListener {
        void delete(RadioBean radioBean);
    }

    /* loaded from: classes.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.radioCoverImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.radio_cover_img, "field 'radioCoverImg'", RoundedImageView.class);
            viewHolder.radioTitleTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.radio_title_tx, "field 'radioTitleTx'", LaToTextView.class);
            viewHolder.radioDeleteImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.radio_delete_img, "field 'radioDeleteImg'", ImageView.class);
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
            viewHolder.radioDeleteImg = null;
        }
    }

    public MyRadioAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void setDeleteListener(DeleteListener deleteListener) {
        this.deleteListener = deleteListener;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this.mInflater.inflate(R.layout.view_holder_my_radio, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        RadioBean radioBean = this.allData.get(i);
        viewHolder.radioTitleTx.setText(radioBean.getTitle());
        i.c(this.mContext).a(radioBean.getImgUrl()).a(viewHolder.radioCoverImg);
        setOnclickEvent(viewHolder.radioDeleteImg, radioBean);
        gotoPlay(viewHolder.itemView, radioBean);
    }

    private void setOnclickEvent(View view, final RadioBean radioBean) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.MyRadioAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (MyRadioAdapter.this.deleteListener != null) {
                    MyRadioAdapter.this.deleteListener.delete(radioBean);
                    MyRadioAdapter.this.allData.remove(radioBean);
                    MyRadioAdapter.this.notifyDataSetChanged();
                }
            }
        });
    }

    private void gotoPlay(View view, final RadioBean radioBean) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.MyRadioAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.a().a(new a(2201, c.a(radioBean)));
            }
        });
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
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
        RoundedImageView radioCoverImg;
        @BindView(R.id.radio_delete_img)
        ImageView radioDeleteImg;
        @BindView(R.id.radio_title_tx)
        LaToTextView radioTitleTx;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

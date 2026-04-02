package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bumptech.glide.i;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.RadioCountryBean;
import com.fotoable.youtube.music.ui.activity.RadioListActivity;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.util.b;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class HotCountryAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<RadioCountryBean> allData = new ArrayList();
    private Context mContext;
    private LayoutInflater mInflater;

    /* loaded from: classes.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.countryImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.country_img, "field 'countryImg'", RoundedImageView.class);
            viewHolder.countryNameTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.country_name_tx, "field 'countryNameTx'", LaToTextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            viewHolder.countryImg = null;
            viewHolder.countryNameTx = null;
        }
    }

    public HotCountryAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this.mInflater.inflate(R.layout.view_holder_hot_country, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        RadioCountryBean radioCountryBean = this.allData.get(i);
        viewHolder.countryNameTx.setText(radioCountryBean.getCountry());
        i.c(this.mContext).a(radioCountryBean.getFlagUrl()).d((int) R.mipmap.icon_hot_country_default).i().a(viewHolder.countryImg);
        setClickEvent(viewHolder.itemView, radioCountryBean);
    }

    private void setClickEvent(View view, final RadioCountryBean radioCountryBean) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.HotCountryAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Intent intent = new Intent(HotCountryAdapter.this.mContext, RadioListActivity.class);
                intent.putExtra("extra_type_key", 0);
                intent.putExtra("extra_country_code_key", radioCountryBean.getCountryCode());
                HotCountryAdapter.this.mContext.startActivity(intent);
                b.b("电台-热门国家-单条", "国家", radioCountryBean.getCountryCode());
            }
        });
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.allData.size() > 4) {
            return 4;
        }
        return this.allData.size();
    }

    public void refresh(List<RadioCountryBean> list) {
        if (list != null) {
            clearData();
            addData(list);
        }
    }

    public void addData(List<RadioCountryBean> list) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.country_img)
        RoundedImageView countryImg;
        @BindView(R.id.country_name_tx)
        LaToTextView countryNameTx;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

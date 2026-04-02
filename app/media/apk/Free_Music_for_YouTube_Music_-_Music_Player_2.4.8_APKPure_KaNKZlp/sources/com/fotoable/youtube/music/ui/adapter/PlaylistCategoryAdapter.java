package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.fotoable.youtube.music.bean.CategoryListBean;
import com.fotoable.youtube.music.ui.adapter.holder.AbsHomeItemHolder;
import com.fotoable.youtube.music.ui.adapter.holder.DecadesHolder;
import com.fotoable.youtube.music.ui.adapter.holder.FeaturedBottomHolder;
import com.fotoable.youtube.music.ui.adapter.holder.GenresHolder;
import com.fotoable.youtube.music.ui.adapter.holder.MoodsHolder;
/* loaded from: classes.dex */
public class PlaylistCategoryAdapter extends RecyclerView.Adapter<AbsHomeItemHolder> {
    private CategoryListBean bean;
    private FeaturedBottomHolder bottomHolder;
    private DecadesHolder decadesHolder;
    private GenresHolder genresHolder;
    private CategoryListManager listManager;
    private Context mContext;
    private MoodsHolder moodsHolder;

    public PlaylistCategoryAdapter(Context context, CategoryListManager categoryListManager) {
        this.mContext = context;
        this.listManager = categoryListManager;
    }

    public void setBean(CategoryListBean categoryListBean) {
        this.bean = categoryListBean;
        notifyDataSetChanged();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public AbsHomeItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.listManager == null) {
            return null;
        }
        AbsHomeItemHolder factoryHolder = this.listManager.factoryHolder(LayoutInflater.from(this.mContext), viewGroup, i);
        switch (i) {
            case 0:
                this.moodsHolder = (MoodsHolder) factoryHolder;
                return factoryHolder;
            case 1:
                this.decadesHolder = (DecadesHolder) factoryHolder;
                return factoryHolder;
            case 2:
                this.genresHolder = (GenresHolder) factoryHolder;
                return factoryHolder;
            case 3:
                this.bottomHolder = (FeaturedBottomHolder) factoryHolder;
                return factoryHolder;
            default:
                return factoryHolder;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(AbsHomeItemHolder absHomeItemHolder, int i) {
        if (this.bean != null) {
            switch (getItemViewType(i)) {
                case 0:
                    this.moodsHolder.setData(this.bean.getMoods());
                    return;
                case 1:
                    this.decadesHolder.setData(this.bean.getDecades());
                    return;
                case 2:
                    this.genresHolder.setData(this.bean.getGenres());
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.listManager.getViewTypeByPosition(i);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.bean == null || this.listManager == null) {
            return 0;
        }
        return this.listManager.getItemCount();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(AbsHomeItemHolder absHomeItemHolder) {
        super.onViewDetachedFromWindow((PlaylistCategoryAdapter) absHomeItemHolder);
        absHomeItemHolder.setAttached(false);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(AbsHomeItemHolder absHomeItemHolder) {
        super.onViewAttachedToWindow((PlaylistCategoryAdapter) absHomeItemHolder);
        absHomeItemHolder.setAttached(true);
    }
}

package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.fotoable.youtube.music.bean.EditorChoiceBean;
import com.fotoable.youtube.music.bean.FeaturedPlaylistBean;
import com.fotoable.youtube.music.bean.GlobalRankBean;
import com.fotoable.youtube.music.bean.HomeListNewBean;
import com.fotoable.youtube.music.ui.adapter.holder.AbsHomeItemHolder;
import com.fotoable.youtube.music.ui.adapter.holder.EditorChoicerHolder;
import com.fotoable.youtube.music.ui.adapter.holder.FeaturedBottomHolder;
import com.fotoable.youtube.music.ui.adapter.holder.FeaturedPlayListHolder;
import com.fotoable.youtube.music.ui.adapter.holder.FreshSongsHolder;
import com.fotoable.youtube.music.ui.adapter.holder.HitSinglesHolder;
import com.fotoable.youtube.music.ui.adapter.holder.HotChartsHolder;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FeaturedAdapter extends RecyclerView.Adapter<AbsHomeItemHolder> {
    private FeaturedBottomHolder bottomHolder;
    private Context context;
    private List<EditorChoiceBean> editorChoiceBeen;
    private EditorChoicerHolder editorChoicerHolder;
    private FeaturedPlayListHolder featuredPlayListHolder;
    private List<FeaturedPlaylistBean> featuredPlaylistBeen;
    private FreshSongsHolder freshSongsHolder;
    private ArrayList<HomeListNewBean> freshSongsNewBeen;
    private ArrayList<GlobalRankBean> globalRankBeen;
    private HitSinglesHolder hitSinglesHolder;
    private ArrayList<HomeListNewBean> homeListNewBeen;
    private HotChartsHolder hotChartsHolder;
    private FeatureListManager listManager;
    private RecyclerView recyclerView;

    public FeaturedAdapter(Context context, FeatureListManager featureListManager) {
        this.context = context;
        this.listManager = featureListManager;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public AbsHomeItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.listManager == null) {
            return null;
        }
        AbsHomeItemHolder facotryHolder = this.listManager.facotryHolder(LayoutInflater.from(this.context), viewGroup, i);
        switch (i) {
            case 0:
                this.hitSinglesHolder = (HitSinglesHolder) facotryHolder;
                return facotryHolder;
            case 1:
                this.editorChoicerHolder = (EditorChoicerHolder) facotryHolder;
                return facotryHolder;
            case 2:
                this.featuredPlayListHolder = (FeaturedPlayListHolder) facotryHolder;
                return facotryHolder;
            case 3:
                this.freshSongsHolder = (FreshSongsHolder) facotryHolder;
                return facotryHolder;
            case 4:
                this.hotChartsHolder = (HotChartsHolder) facotryHolder;
                return facotryHolder;
            case 5:
                this.bottomHolder = (FeaturedBottomHolder) facotryHolder;
                return facotryHolder;
            default:
                return facotryHolder;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(AbsHomeItemHolder absHomeItemHolder, int i) {
        switch (getItemViewType(i)) {
            case 0:
                this.hitSinglesHolder = (HitSinglesHolder) absHomeItemHolder;
                if (this.homeListNewBeen != null) {
                    this.hitSinglesHolder.setData(this.homeListNewBeen);
                    return;
                }
                return;
            case 1:
                this.editorChoicerHolder = (EditorChoicerHolder) absHomeItemHolder;
                if (this.editorChoicerHolder != null) {
                    this.editorChoicerHolder.setData(this.editorChoiceBeen);
                    return;
                }
                return;
            case 2:
                this.featuredPlayListHolder = (FeaturedPlayListHolder) absHomeItemHolder;
                if (this.featuredPlayListHolder != null) {
                    this.featuredPlayListHolder.setData(this.featuredPlaylistBeen);
                    return;
                }
                return;
            case 3:
                this.freshSongsHolder = (FreshSongsHolder) absHomeItemHolder;
                if (this.freshSongsNewBeen != null) {
                    this.freshSongsHolder.setData(this.freshSongsNewBeen);
                    return;
                }
                return;
            case 4:
                this.hotChartsHolder = (HotChartsHolder) absHomeItemHolder;
                if (this.globalRankBeen != null) {
                    this.hotChartsHolder.setData(this.globalRankBeen);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.listManager == null) {
            return -1;
        }
        return this.listManager.getViewTypeByPosition(i);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.listManager == null) {
            return -1;
        }
        return this.listManager.getItemCount();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(AbsHomeItemHolder absHomeItemHolder) {
        super.onViewDetachedFromWindow((FeaturedAdapter) absHomeItemHolder);
        absHomeItemHolder.setAttached(false);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(AbsHomeItemHolder absHomeItemHolder) {
        super.onViewAttachedToWindow((FeaturedAdapter) absHomeItemHolder);
        absHomeItemHolder.setAttached(true);
    }

    public void setEditorChoice(List<EditorChoiceBean> list) {
        this.editorChoiceBeen = list;
        if (this.editorChoicerHolder != null && this.editorChoicerHolder.isAttached()) {
            notifyItemChanged(this.editorChoicerHolder.getAdapterPosition());
        }
    }

    public void setFeaturedPlaylist(List<FeaturedPlaylistBean> list) {
        this.featuredPlaylistBeen = list;
        if (this.featuredPlayListHolder != null && this.featuredPlayListHolder.isAttached()) {
            notifyItemChanged(this.featuredPlayListHolder.getAdapterPosition());
        }
    }

    public void setHitSingles(ArrayList<HomeListNewBean> arrayList) {
        this.homeListNewBeen = arrayList;
        if (this.hitSinglesHolder != null && this.hitSinglesHolder.isAttached()) {
            notifyItemChanged(this.hitSinglesHolder.getAdapterPosition());
        }
    }

    public void setFreshSongs(ArrayList<HomeListNewBean> arrayList) {
        this.freshSongsNewBeen = arrayList;
        if (this.freshSongsHolder != null && this.freshSongsHolder.isAttached()) {
            notifyItemChanged(this.freshSongsHolder.getAdapterPosition());
        }
    }

    public void setHotCharts(ArrayList<GlobalRankBean> arrayList) {
        this.globalRankBeen = arrayList;
        if (this.hotChartsHolder != null && this.hotChartsHolder.isAttached()) {
            notifyItemChanged(this.hotChartsHolder.getAdapterPosition());
        }
    }

    public void onDestory() {
        try {
            if (this.recyclerView != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= getItemCount()) {
                        break;
                    }
                    try {
                        ((AbsHomeItemHolder) this.recyclerView.findViewHolderForLayoutPosition(i2)).onDestory();
                    } catch (Exception e) {
                        ThrowableExtension.printStackTrace(e);
                    }
                    i = i2 + 1;
                }
            }
        } catch (Exception e2) {
        }
        this.editorChoicerHolder.onDestory();
        this.editorChoicerHolder = null;
        this.featuredPlayListHolder = null;
        this.hitSinglesHolder = null;
        this.freshSongsHolder = null;
        this.hotChartsHolder = null;
    }
}

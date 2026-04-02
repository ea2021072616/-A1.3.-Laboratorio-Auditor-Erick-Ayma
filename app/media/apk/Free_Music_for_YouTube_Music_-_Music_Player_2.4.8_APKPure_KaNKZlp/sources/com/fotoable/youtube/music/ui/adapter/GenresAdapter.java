package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.GenresBean;
import com.fotoable.youtube.music.helper.d;
import com.fotoable.youtube.music.ui.activity.GenresDetailActivity;
import com.fotoable.youtube.music.util.h;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GenresAdapter extends BaseAdapter<RecyclerView.ViewHolder> {
    public static final int COMMONVIEW = 0;
    public static final int EMPTYVIEW = 2;
    public static final int HEADVIEW = 1;
    private Context context;
    private ArrayList<GenresBean> genresBeanArrayList;
    private LayoutInflater inflater;

    /* loaded from: classes.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.relRoot = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.ll_hit, "field 'relRoot'", RelativeLayout.class);
            viewHolder.textName = (TextView) Utils.findRequiredViewAsType(view, R.id.text_name, "field 'textName'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            viewHolder.relRoot = null;
            viewHolder.textName = null;
        }
    }

    /* loaded from: classes.dex */
    public class ViewHeadHolder_ViewBinding implements Unbinder {
        private ViewHeadHolder target;

        @UiThread
        public ViewHeadHolder_ViewBinding(ViewHeadHolder viewHeadHolder, View view) {
            this.target = viewHeadHolder;
            viewHeadHolder.relRoot = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.ll_hit, "field 'relRoot'", RelativeLayout.class);
            viewHeadHolder.textName = (TextView) Utils.findRequiredViewAsType(view, R.id.text_name, "field 'textName'", TextView.class);
            viewHeadHolder.imgIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_icon, "field 'imgIcon'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHeadHolder viewHeadHolder = this.target;
            if (viewHeadHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            viewHeadHolder.relRoot = null;
            viewHeadHolder.textName = null;
            viewHeadHolder.imgIcon = null;
        }
    }

    public GenresAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);
        setHasStableIds(true);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new ViewHolder(this.inflater.inflate(R.layout.view_holder_genres_item, viewGroup, false));
        }
        if (i == 1) {
            return new ViewHeadHolder(this.inflater.inflate(R.layout.view_holder_genres_item2, viewGroup, false));
        }
        return new ViewEmptyHolder(this.inflater.inflate(R.layout.view_holder_genres_item3, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        try {
            viewHolder.setIsRecyclable(false);
            if (viewHolder instanceof ViewHolder) {
                ((ViewHolder) viewHolder).textName.setText(this.genresBeanArrayList.get(i).getName() == null ? "" : this.genresBeanArrayList.get(i).getName());
                ((ViewHolder) viewHolder).relRoot.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.GenresAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Intent intent = new Intent(GenresAdapter.this.context, GenresDetailActivity.class);
                        intent.putExtra("SeachKey", ((GenresBean) GenresAdapter.this.genresBeanArrayList.get(i)).getKeywords());
                        intent.putExtra("genres", ((GenresBean) GenresAdapter.this.genresBeanArrayList.get(i)).getNameEs());
                        intent.putExtra(ShareConstants.TITLE, ((GenresBean) GenresAdapter.this.genresBeanArrayList.get(i)).getName());
                        GenresAdapter.this.context.startActivity(intent);
                        h.a(((GenresBean) GenresAdapter.this.genresBeanArrayList.get(i)).getKeywords());
                    }
                });
            } else if (viewHolder instanceof ViewHeadHolder) {
                ((ViewHeadHolder) viewHolder).textName.setText(this.genresBeanArrayList.get(i).getGroup() == null ? "" : this.genresBeanArrayList.get(i).getGroup());
                d.a(this.context, this.genresBeanArrayList.get(i).getGroupImgUrl(), ((ViewHeadHolder) viewHolder).imgIcon);
            }
        } catch (Throwable th) {
            ThrowableExtension.printStackTrace(th);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.genresBeanArrayList != null && this.genresBeanArrayList.get(i).getType() != 0) {
            return this.genresBeanArrayList.get(i).getType() == 1 ? 1 : 2;
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.genresBeanArrayList == null) {
            return 0;
        }
        return this.genresBeanArrayList.size();
    }

    @Override // com.fotoable.youtube.music.ui.adapter.BaseAdapter
    public void onDestroy() {
        this.context = null;
        this.inflater = null;
    }

    /* loaded from: classes.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ll_hit)
        public RelativeLayout relRoot;
        @BindView(R.id.text_name)
        public TextView textName;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /* loaded from: classes.dex */
    public static class ViewHeadHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_icon)
        public ImageView imgIcon;
        @BindView(R.id.ll_hit)
        public RelativeLayout relRoot;
        @BindView(R.id.text_name)
        public TextView textName;

        public ViewHeadHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /* loaded from: classes.dex */
    public static class ViewEmptyHolder extends RecyclerView.ViewHolder {
        public ViewEmptyHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setAddData(ArrayList<GenresBean> arrayList) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (this.genresBeanArrayList == null) {
            this.genresBeanArrayList = new ArrayList<>();
        }
        this.genresBeanArrayList.clear();
        this.genresBeanArrayList.addAll(arrayList);
        notifyDataSetChanged();
    }
}

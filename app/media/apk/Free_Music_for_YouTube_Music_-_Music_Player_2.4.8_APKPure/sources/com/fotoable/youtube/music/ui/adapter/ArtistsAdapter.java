package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.ArtistBean;
import com.fotoable.youtube.music.helper.d;
import com.fotoable.youtube.music.ui.activity.ArtistsDetailActivity;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.ui.view.RoundImageView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ArtistsAdapter extends BaseAdapter<ViewHolder> {
    private ArrayList<ArtistBean> artistBeen;
    private Context context;
    private LayoutInflater inflater;

    /* loaded from: classes.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.relRoot = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.ll_hit, "field 'relRoot'", RelativeLayout.class);
            viewHolder.imgIcon = (RoundImageView) Utils.findRequiredViewAsType(view, R.id.cover_iv, "field 'imgIcon'", RoundImageView.class);
            viewHolder.txtName = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.text_name, "field 'txtName'", LaToTextView.class);
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
            viewHolder.imgIcon = null;
            viewHolder.txtName = null;
        }
    }

    public ArtistsAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);
        setHasStableIds(true);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this.inflater.inflate(R.layout.view_holder_artist, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        try {
            d.a(this.context, this.artistBeen.get(i).getImgUrl(), viewHolder.imgIcon, R.mipmap.artist_listdefault);
            viewHolder.txtName.setText(this.artistBeen.get(i).getName());
            viewHolder.relRoot.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.ArtistsAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent(ArtistsAdapter.this.context, ArtistsDetailActivity.class);
                    intent.putExtra("DESC", ((ArtistBean) ArtistsAdapter.this.artistBeen.get(i)).getDesc());
                    intent.putExtra("ImgURL", ((ArtistBean) ArtistsAdapter.this.artistBeen.get(i)).getImgUrl());
                    intent.putExtra(ShareConstants.TITLE, ((ArtistBean) ArtistsAdapter.this.artistBeen.get(i)).getName());
                    intent.putExtra("ARTISTID", ((ArtistBean) ArtistsAdapter.this.artistBeen.get(i)).getArtistsid());
                    ArtistsAdapter.this.context.startActivity(intent);
                }
            });
        } catch (Throwable th) {
            ThrowableExtension.printStackTrace(th);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.artistBeen == null) {
            return 0;
        }
        return this.artistBeen.size();
    }

    @Override // com.fotoable.youtube.music.ui.adapter.BaseAdapter
    public void onDestroy() {
        this.context = null;
        this.inflater = null;
    }

    /* loaded from: classes.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cover_iv)
        public RoundImageView imgIcon;
        @BindView(R.id.ll_hit)
        public RelativeLayout relRoot;
        @BindView(R.id.text_name)
        public LaToTextView txtName;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setAddDatas(ArrayList<ArtistBean> arrayList) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (this.artistBeen == null) {
            this.artistBeen = new ArrayList<>();
        }
        this.artistBeen.clear();
        this.artistBeen.addAll(arrayList);
        notifyDataSetChanged();
    }
}

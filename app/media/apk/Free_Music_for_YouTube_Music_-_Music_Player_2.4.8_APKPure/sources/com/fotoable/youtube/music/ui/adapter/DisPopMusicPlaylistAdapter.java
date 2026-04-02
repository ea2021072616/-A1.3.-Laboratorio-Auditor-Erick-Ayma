package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.PlayBean;
import com.fotoable.youtube.music.helper.d;
import com.fotoable.youtube.music.ui.activity.PlayListDetailsActivity;
import com.fotoable.youtube.music.ui.view.RoundImageView;
import com.fotoable.youtube.music.util.k;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DisPopMusicPlaylistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = DisPopMusicPlaylistAdapter.class.getSimpleName();
    private Context context;
    private FragmentManager fragmentManager;
    private LayoutInflater inflater;
    private ArrayList<PlayBean> playBeanArrayList;

    /* loaded from: classes.dex */
    public class DiscoverHolder_ViewBinding implements Unbinder {
        private DiscoverHolder target;

        @UiThread
        public DiscoverHolder_ViewBinding(DiscoverHolder discoverHolder, View view) {
            this.target = discoverHolder;
            discoverHolder.linRoot = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_hit, "field 'linRoot'", LinearLayout.class);
            discoverHolder.imgBg = (RoundImageView) Utils.findRequiredViewAsType(view, R.id.cover_iv, "field 'imgBg'", RoundImageView.class);
            discoverHolder.textNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.text_number, "field 'textNumber'", TextView.class);
            discoverHolder.textTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.text_title, "field 'textTitle'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            DiscoverHolder discoverHolder = this.target;
            if (discoverHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            discoverHolder.linRoot = null;
            discoverHolder.imgBg = null;
            discoverHolder.textNumber = null;
            discoverHolder.textTitle = null;
        }
    }

    public DisPopMusicPlaylistAdapter(Context context, FragmentManager fragmentManager) {
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);
        this.fragmentManager = fragmentManager;
        setHasStableIds(true);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new DiscoverHolder(LayoutInflater.from(this.context).inflate(R.layout.view_holder_dis_pop_music_playlist, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        try {
            d.a(this.context, this.playBeanArrayList.get(i).getImgUrl() == null ? "" : this.playBeanArrayList.get(i).getImgUrl(), ((DiscoverHolder) viewHolder).imgBg, R.mipmap.icon_bigplaylistdefault);
            ((DiscoverHolder) viewHolder).textNumber.setText(k.a(this.playBeanArrayList.get(i).getCounter().getData().getSongs_play_count()));
            ((DiscoverHolder) viewHolder).textTitle.setText(this.playBeanArrayList.get(i).getTitle() == null ? "" : this.playBeanArrayList.get(i).getTitle());
            ((DiscoverHolder) viewHolder).linRoot.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.DisPopMusicPlaylistAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent(DisPopMusicPlaylistAdapter.this.context, PlayListDetailsActivity.class);
                    intent.putExtra("PlaylistId", ((PlayBean) DisPopMusicPlaylistAdapter.this.playBeanArrayList.get(i)).getPlaylistid());
                    intent.putExtra("ImgUrl", ((PlayBean) DisPopMusicPlaylistAdapter.this.playBeanArrayList.get(i)).getImgUrl());
                    intent.putExtra("Title", ((PlayBean) DisPopMusicPlaylistAdapter.this.playBeanArrayList.get(i)).getTitle());
                    DisPopMusicPlaylistAdapter.this.context.startActivity(intent);
                }
            });
        } catch (Throwable th) {
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.playBeanArrayList == null) {
            return 0;
        }
        return this.playBeanArrayList.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* loaded from: classes.dex */
    public class DiscoverHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cover_iv)
        RoundImageView imgBg;
        @BindView(R.id.ll_hit)
        LinearLayout linRoot;
        @BindView(R.id.text_number)
        TextView textNumber;
        @BindView(R.id.text_title)
        TextView textTitle;

        public DiscoverHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setAddDatas(ArrayList<PlayBean> arrayList) {
        if (this.playBeanArrayList == null) {
            this.playBeanArrayList = new ArrayList<>();
        }
        int size = this.playBeanArrayList.size();
        this.playBeanArrayList.addAll(arrayList);
        notifyItemRangeInserted(size, this.playBeanArrayList.size());
    }

    public void cleanDatas() {
        if (this.playBeanArrayList != null) {
            this.playBeanArrayList.clear();
            notifyDataSetChanged();
        }
    }
}

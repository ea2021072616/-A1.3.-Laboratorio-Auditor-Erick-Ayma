package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.MusicBean;
import com.fotoable.youtube.music.helper.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DisPopMusicAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = DisPopMusicAdapter.class.getSimpleName();
    private Context context;
    private FragmentManager fragmentManager;
    private LayoutInflater inflater;
    private ArrayList<MusicBean> musicBeanArrayList;

    /* loaded from: classes.dex */
    public class DiscoverHolder_ViewBinding implements Unbinder {
        private DiscoverHolder target;

        @UiThread
        public DiscoverHolder_ViewBinding(DiscoverHolder discoverHolder, View view) {
            this.target = discoverHolder;
            discoverHolder.imgLogo = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_logo, "field 'imgLogo'", ImageView.class);
            discoverHolder.txtTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_title, "field 'txtTitle'", TextView.class);
            discoverHolder.txtContent = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_content, "field 'txtContent'", TextView.class);
            discoverHolder.btnMuen = (ImageView) Utils.findRequiredViewAsType(view, R.id.btn_menu, "field 'btnMuen'", ImageView.class);
            discoverHolder.txtTime = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_time, "field 'txtTime'", TextView.class);
            discoverHolder.txtNum = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_num, "field 'txtNum'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            DiscoverHolder discoverHolder = this.target;
            if (discoverHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            discoverHolder.imgLogo = null;
            discoverHolder.txtTitle = null;
            discoverHolder.txtContent = null;
            discoverHolder.btnMuen = null;
            discoverHolder.txtTime = null;
            discoverHolder.txtNum = null;
        }
    }

    public DisPopMusicAdapter(Context context, FragmentManager fragmentManager) {
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);
        this.fragmentManager = fragmentManager;
        setHasStableIds(true);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new DiscoverHolder(LayoutInflater.from(this.context).inflate(R.layout.view_holder_dis_pop_music, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        d.a(this.context, this.musicBeanArrayList.get(i).getImgUrl(), ((DiscoverHolder) viewHolder).imgLogo);
        ((DiscoverHolder) viewHolder).txtTime.setText(this.musicBeanArrayList.get(i).getDuration());
        ((DiscoverHolder) viewHolder).txtContent.setText(this.musicBeanArrayList.get(i).getTitle());
        ((DiscoverHolder) viewHolder).txtTitle.setText(this.musicBeanArrayList.get(i).getTitle());
        ((DiscoverHolder) viewHolder).txtNum.setText(this.musicBeanArrayList.get(i).getCounter().getData().getMusic_play_count() + this.context.getResources().getString(R.string.views));
        ((DiscoverHolder) viewHolder).btnMuen.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.DisPopMusicAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.musicBeanArrayList == null) {
            return 0;
        }
        return this.musicBeanArrayList.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* loaded from: classes.dex */
    public class DiscoverHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.btn_menu)
        ImageView btnMuen;
        @BindView(R.id.img_logo)
        ImageView imgLogo;
        @BindView(R.id.txt_content)
        TextView txtContent;
        @BindView(R.id.txt_num)
        TextView txtNum;
        @BindView(R.id.txt_time)
        TextView txtTime;
        @BindView(R.id.txt_title)
        TextView txtTitle;

        public DiscoverHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setAddDatas(ArrayList<MusicBean> arrayList) {
        if (this.musicBeanArrayList == null) {
            this.musicBeanArrayList = new ArrayList<>();
        }
        this.musicBeanArrayList.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void cleanDatas() {
        this.musicBeanArrayList.clear();
        notifyDataSetChanged();
    }
}

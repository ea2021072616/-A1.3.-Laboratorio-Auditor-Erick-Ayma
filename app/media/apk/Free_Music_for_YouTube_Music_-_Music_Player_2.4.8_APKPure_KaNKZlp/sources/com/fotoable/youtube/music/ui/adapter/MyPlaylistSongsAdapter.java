package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.app.FragmentManager;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.PointerIconCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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
import com.facebook.ads.AdError;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.FavBean;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.db.a;
import com.fotoable.youtube.music.e.b;
import com.fotoable.youtube.music.helper.d;
import com.fotoable.youtube.music.ui.dialog.MusicMenuDialog;
import com.fotoable.youtube.music.util.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MyPlaylistSongsAdapter extends BaseAdapter<ViewHolder> {
    private Context context;
    private FragmentManager fragmentManager;
    private a greenDAOHelper;
    private LayoutInflater inflater;
    private String type;
    private String isPlayingID = "";
    private Long playListId = -1L;
    public ArrayList<PlayMusicModel> data = new ArrayList<>();

    /* loaded from: classes.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.txtTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_title, "field 'txtTitle'", TextView.class);
            viewHolder.txtContent = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_content, "field 'txtContent'", TextView.class);
            viewHolder.textTime = (TextView) Utils.findRequiredViewAsType(view, R.id.text_time, "field 'textTime'", TextView.class);
            viewHolder.btnMenu = (ImageView) Utils.findRequiredViewAsType(view, R.id.btn_menu, "field 'btnMenu'", ImageView.class);
            viewHolder.ivIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_icon, "field 'ivIcon'", ImageView.class);
            viewHolder.rlDetails = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_details, "field 'rlDetails'", RelativeLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            viewHolder.txtTitle = null;
            viewHolder.txtContent = null;
            viewHolder.textTime = null;
            viewHolder.btnMenu = null;
            viewHolder.ivIcon = null;
            viewHolder.rlDetails = null;
        }
    }

    public MyPlaylistSongsAdapter(Context context, FragmentManager fragmentManager, a aVar) {
        this.context = context;
        this.greenDAOHelper = aVar;
        this.inflater = LayoutInflater.from(this.context);
        this.fragmentManager = fragmentManager;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this.inflater.inflate(R.layout.view_playlist_details_item, viewGroup, false));
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setPlayListId(Long l) {
        this.playListId = l;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.data == null) {
            return 0;
        }
        return this.data.size();
    }

    @Override // com.fotoable.youtube.music.ui.adapter.BaseAdapter
    public void onDestroy() {
        this.context = null;
        this.inflater = null;
        this.data = null;
    }

    public void setAddData(List<PlayMusicModel> list) {
        int size = this.data.size();
        this.data.clear();
        this.data.addAll(list);
        notifyItemRangeInserted(size, this.data.size() - size);
    }

    public void setAllAddData(List<PlayMusicModel> list) {
        this.data.clear();
        this.data.addAll(list);
        notifyDataSetChanged();
    }

    public void cleanData() {
        if (this.data != null) {
            this.data.clear();
        }
        notifyDataSetChanged();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        viewHolder.setIsRecyclable(false);
        PlayMusicModel playMusicModel = this.data.get(i);
        if (playMusicModel.getVideoId().equalsIgnoreCase(this.isPlayingID)) {
            viewHolder.txtTitle.setTextColor(SupportMenu.CATEGORY_MASK);
            viewHolder.txtContent.setTextColor(SupportMenu.CATEGORY_MASK);
        } else {
            viewHolder.txtTitle.setTextColor(this.context.getResources().getColor(R.color.favorite_title));
            viewHolder.txtContent.setTextColor(this.context.getResources().getColor(R.color.favorite_desc));
        }
        viewHolder.txtTitle.setText(playMusicModel.getTitle());
        viewHolder.textTime.setText(playMusicModel.getDuration());
        if (TextUtils.isEmpty(playMusicModel.getArtists())) {
            viewHolder.txtContent.setVisibility(8);
        } else {
            viewHolder.txtContent.setVisibility(0);
            viewHolder.txtContent.setText(playMusicModel.getArtists());
        }
        d.a(this.context, playMusicModel.getCoverImg(), viewHolder.ivIcon);
        viewHolder.rlDetails.setOnClickListener(new View.OnClickListener(this, i) { // from class: com.fotoable.youtube.music.ui.adapter.MyPlaylistSongsAdapter$$Lambda$0
            private final MyPlaylistSongsAdapter arg$1;
            private final int arg$2;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
                this.arg$2 = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.arg$1.lambda$onBindViewHolder$0$MyPlaylistSongsAdapter(this.arg$2, view);
            }
        });
        setMenuEvent(viewHolder, playMusicModel, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$onBindViewHolder$0$MyPlaylistSongsAdapter(int i, View view) {
        b.a().a(new com.fotoable.youtube.music.e.a((int) AdError.INTERNAL_ERROR_CODE, this.data, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FavBean getFavBean(PlayMusicModel playMusicModel) {
        FavBean favBean = new FavBean();
        favBean.setVideoid(playMusicModel.getVideoId());
        favBean.setTitle(playMusicModel.getTitle());
        favBean.setDesc(playMusicModel.getDescription());
        favBean.setImgUrl(playMusicModel.getCoverImg());
        favBean.setDuration(playMusicModel.getDuration());
        favBean.setArtists(playMusicModel.getArtists());
        return favBean;
    }

    private void setMenuEvent(ViewHolder viewHolder, final PlayMusicModel playMusicModel, final int i) {
        viewHolder.btnMenu.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.MyPlaylistSongsAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new MusicMenuDialog.b(MyPlaylistSongsAdapter.this.fragmentManager).a(playMusicModel).a(MyPlaylistSongsAdapter.this.data).b(i).a(true).c(true).a(new MusicMenuDialog.c() { // from class: com.fotoable.youtube.music.ui.adapter.MyPlaylistSongsAdapter.1.1
                    @Override // com.fotoable.youtube.music.ui.dialog.MusicMenuDialog.c
                    public void onDelete(PlayMusicModel playMusicModel2) {
                        if (TextUtils.equals(MyPlaylistSongsAdapter.this.type, "EXTRA_FAVORITE_TYPE")) {
                            b.a().a(new com.fotoable.youtube.music.e.a((int) PointerIconCompat.TYPE_WAIT, MyPlaylistSongsAdapter.this.getFavBean(playMusicModel)));
                            if (TextUtils.equals(MyPlaylistSongsAdapter.this.type, "EXTRA_FAVORITE_TYPE")) {
                                MyPlaylistSongsAdapter.this.data.remove(playMusicModel);
                                MyPlaylistSongsAdapter.this.notifyDataSetChanged();
                                b.a().a(new com.fotoable.youtube.music.e.a(1041, (Object) (-1L)));
                            }
                        }
                        if (TextUtils.equals(MyPlaylistSongsAdapter.this.type, "EXTRA_PLAYLIST_TYPE")) {
                            h.a("删除歌单下的一首歌曲" + i);
                            MyPlaylistSongsAdapter.this.greenDAOHelper.c(MyPlaylistSongsAdapter.this.playListId, playMusicModel.getVideoId());
                            MyPlaylistSongsAdapter.this.data.remove(playMusicModel);
                            MyPlaylistSongsAdapter.this.notifyDataSetChanged();
                            b.a().a(new com.fotoable.youtube.music.e.a(1041, MyPlaylistSongsAdapter.this.playListId));
                        }
                    }
                }).a().e();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.btn_menu)
        ImageView btnMenu;
        @BindView(R.id.iv_icon)
        ImageView ivIcon;
        @BindView(R.id.rl_details)
        RelativeLayout rlDetails;
        @BindView(R.id.text_time)
        TextView textTime;
        @BindView(R.id.txt_content)
        TextView txtContent;
        @BindView(R.id.txt_title)
        TextView txtTitle;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setIsPlayingID(String str) {
        this.isPlayingID = str;
        notifyDataSetChanged();
    }
}

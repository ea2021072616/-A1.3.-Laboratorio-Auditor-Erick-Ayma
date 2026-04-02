package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bumptech.glide.i;
import com.bumptech.glide.load.resource.bitmap.e;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.PlayListModel;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.ui.view.GlideRoundTransform;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.util.h;
import java.util.List;
/* loaded from: classes.dex */
public class PlayListSelectAdapter extends android.widget.BaseAdapter {
    private Context context;
    private List<PlayListModel> data;
    private LayoutInflater mInflater;
    private PlayMusicModel musicModel;

    /* loaded from: classes.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.coverImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.cover_img, "field 'coverImg'", ImageView.class);
            viewHolder.playlistNameTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.playlist_name_tx, "field 'playlistNameTx'", LaToTextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            viewHolder.coverImg = null;
            viewHolder.playlistNameTx = null;
        }
    }

    public PlayListSelectAdapter(Context context, List<PlayListModel> list, PlayMusicModel playMusicModel) {
        this.context = context;
        this.data = list;
        this.musicModel = playMusicModel;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.data == null) {
            return 2;
        }
        return this.data.size() + 2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > 1) {
            return this.data.get(i - 2);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.mInflater.inflate(R.layout.view_holder_select_playlist, viewGroup, false);
            ViewHolder viewHolder2 = new ViewHolder(view);
            view.setTag(viewHolder2);
            viewHolder = viewHolder2;
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if (i == 0) {
            viewHolder.playlistNameTx.setText(R.string.new_playlist);
            i.c(this.context).a(Integer.valueOf((int) R.mipmap.icon_createplaylist)).a(viewHolder.coverImg);
        }
        if (i == 1) {
            viewHolder.playlistNameTx.setText(R.string.my_favorite);
            i.c(this.context).a(Integer.valueOf((int) R.mipmap.icon_myfavoriteplaylist)).a(viewHolder.coverImg);
        }
        if (i > 1) {
            PlayListModel playListModel = this.data.get(i - 2);
            viewHolder.playlistNameTx.setText(playListModel.getName());
            i.c(this.context).a(playListModel.getCover()).a(new e(this.context), new GlideRoundTransform(this.context, 5)).c().d((int) R.mipmap.icon_playlist_default).a(viewHolder.coverImg);
            h.a(playListModel.getId() + "");
        }
        return view;
    }

    /* loaded from: classes.dex */
    static class ViewHolder {
        @BindView(R.id.cover_img)
        ImageView coverImg;
        @BindView(R.id.playlist_name_tx)
        LaToTextView playlistNameTx;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

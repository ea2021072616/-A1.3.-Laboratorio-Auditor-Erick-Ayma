package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.fotoable.youtube.music.db.a;
import com.fotoable.youtube.music.ui.activity.MyPlaylistDetailActivity;
import com.fotoable.youtube.music.ui.view.GlideRoundTransform;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.util.h;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class MyPlayListAdapter extends android.widget.BaseAdapter {
    private Context context;
    private Map<Long, Long> countMap = new HashMap();
    private List<PlayListModel> data;
    private a helper;
    private Long id;
    private LayoutInflater mInflater;
    private String title;

    /* loaded from: classes.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.coverImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.cover_img, "field 'coverImg'", ImageView.class);
            viewHolder.titleTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.title_tx, "field 'titleTx'", LaToTextView.class);
            viewHolder.countTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.count_tx, "field 'countTx'", LaToTextView.class);
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
            viewHolder.titleTx = null;
            viewHolder.countTx = null;
        }
    }

    public MyPlayListAdapter(Context context, List<PlayListModel> list, a aVar) {
        this.context = context;
        this.data = list;
        this.helper = aVar;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.data.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > 0) {
            return this.data.get(i - 1);
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
            view = this.mInflater.inflate(R.layout.view_holder_my_playlist, viewGroup, false);
            ViewHolder viewHolder2 = new ViewHolder(view);
            view.setTag(viewHolder2);
            viewHolder = viewHolder2;
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if (i == 0) {
            viewHolder.titleTx.setText(R.string.my_favorite);
            i.c(this.context).a(Integer.valueOf((int) R.mipmap.icon_myfavoriteplaylist)).d((int) R.mipmap.icon_myfavoriteplaylist).a(viewHolder.coverImg);
            getFavoriteCount(viewHolder.countTx);
        } else {
            PlayListModel playListModel = this.data.get(i - 1);
            if (this.id == playListModel.getId()) {
                playListModel.setName(this.title);
            }
            viewHolder.titleTx.setText(playListModel.getName());
            i.c(this.context).a(playListModel.getCover()).a(new e(this.context), new GlideRoundTransform(this.context, 5)).c().d((int) R.mipmap.icon_playlist_default).a(viewHolder.coverImg);
            h.a(playListModel.getId() + "");
            getPlaylistSongsCount(viewHolder.countTx, i);
        }
        setOnclickEvent(i, view);
        return view;
    }

    private void getFavoriteCount(LaToTextView laToTextView) {
        if (this.countMap.keySet().contains(-1L)) {
            laToTextView.setText(this.countMap.get(-1L) + " " + this.context.getResources().getString(R.string.songs));
            return;
        }
        this.countMap.put(-1L, Long.valueOf(this.helper.d()));
        laToTextView.setText(this.countMap.get(-1L) + " " + this.context.getResources().getString(R.string.songs));
    }

    private void getPlaylistSongsCount(LaToTextView laToTextView, int i) {
        Long id = this.data.get(i - 1).getId();
        if (this.countMap.keySet().contains(id)) {
            laToTextView.setText(this.countMap.get(id) + " " + this.context.getResources().getString(R.string.songs));
            return;
        }
        this.countMap.put(id, Long.valueOf(this.helper.c(this.data.get(i - 1).getId())));
        laToTextView.setText(this.countMap.get(id) + " " + this.context.getResources().getString(R.string.songs));
    }

    private void setOnclickEvent(final int i, View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.MyPlayListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Intent intent = new Intent(MyPlayListAdapter.this.context, MyPlaylistDetailActivity.class);
                if (i == 0) {
                    intent.putExtra("EXTRA_TYPE_KEY", "EXTRA_FAVORITE_TYPE");
                } else {
                    intent.putExtra("EXTRA_TYPE_KEY", "EXTRA_PLAYLIST_TYPE");
                    intent.putExtra("EXTRA_ID_KEY", ((PlayListModel) MyPlayListAdapter.this.data.get(i - 1)).getId());
                }
                MyPlayListAdapter.this.context.startActivity(intent);
            }
        });
    }

    public void updateName(Long l, String str) {
        this.id = l;
        this.title = str;
        notifyDataSetChanged();
    }

    public void updateCount(Long l) {
        if (this.countMap.keySet().contains(l)) {
            long longValue = this.countMap.get(l).longValue();
            this.countMap.remove(l);
            this.countMap.put(l, Long.valueOf(longValue - 1));
        }
        notifyDataSetChanged();
    }

    public void delete(Long l) {
        for (PlayListModel playListModel : this.data) {
            if (playListModel.getId() == l) {
                this.data.remove(playListModel);
                notifyDataSetChanged();
                return;
            }
        }
    }

    public void add(PlayListModel playListModel) {
        this.data.add(playListModel);
        notifyDataSetChanged();
    }

    /* loaded from: classes.dex */
    static class ViewHolder {
        @BindView(R.id.count_tx)
        LaToTextView countTx;
        @BindView(R.id.cover_img)
        ImageView coverImg;
        @BindView(R.id.title_tx)
        LaToTextView titleTx;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

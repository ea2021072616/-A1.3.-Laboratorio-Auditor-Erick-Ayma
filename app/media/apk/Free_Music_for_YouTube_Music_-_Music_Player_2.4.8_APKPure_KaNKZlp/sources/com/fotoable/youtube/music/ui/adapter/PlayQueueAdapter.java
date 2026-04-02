package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.e.a;
import com.fotoable.youtube.music.e.b;
import com.fotoable.youtube.music.newplayer.e;
import com.fotoable.youtube.music.newplayer.model.LocalMusicModel;
import com.fotoable.youtube.music.ui.view.MarqueeTextView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class PlayQueueAdapter extends BaseAdapter<ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<LocalMusicModel> localMusicAll;
    private List<PlayMusicModel> musicBeanList = new ArrayList();
    private OnDeleteMusicListener onDeleteMusicListener;
    private long songId;
    private String videoId;
    private List<PlayMusicModel> youtubeAll;

    /* loaded from: classes.dex */
    public interface OnDeleteMusicListener {
        void delete(List list, int i);
    }

    public PlayQueueAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);
    }

    public void setMusicBeanList(List<PlayMusicModel> list) {
        this.musicBeanList.clear();
        this.musicBeanList.addAll(list);
    }

    @Override // com.fotoable.youtube.music.ui.adapter.BaseAdapter
    public void onDestroy() {
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this.inflater.inflate(R.layout.view_holder_play_queue_item, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        final LocalMusicModel localMusicModel;
        if (this.youtubeAll != null) {
            final PlayMusicModel playMusicModel = this.youtubeAll.get(i);
            if (playMusicModel != null) {
                if (TextUtils.equals(playMusicModel.getVideoId(), this.videoId)) {
                    viewHolder.video_play_state.setVisibility(0);
                    viewHolder.video_seq.setVisibility(8);
                    viewHolder.video_title.setTextColor(SupportMenu.CATEGORY_MASK);
                    viewHolder.video_title.setAutoScroll(true);
                    viewHolder.video_title.setText(playMusicModel.getTitle() + "");
                } else {
                    viewHolder.video_title.setTextColor(this.context.getResources().getColor(R.color.top_50_title));
                    viewHolder.video_play_state.setVisibility(8);
                    viewHolder.video_seq.setVisibility(0);
                    viewHolder.video_seq.setText((i + 1) + "");
                    viewHolder.video_title.setAutoScroll(false);
                    viewHolder.video_title.setText(playMusicModel.getTitle() + "");
                }
                if (!TextUtils.isEmpty(playMusicModel.getArtists())) {
                    viewHolder.video_description.setText(playMusicModel.getArtists());
                    viewHolder.video_description.setVisibility(0);
                } else {
                    viewHolder.video_description.setVisibility(8);
                }
                viewHolder.video_delete.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.PlayQueueAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.a().b(i);
                        if (i >= 0 && i < PlayQueueAdapter.this.youtubeAll.size()) {
                            PlayQueueAdapter.this.youtubeAll.remove(i);
                        }
                        PlayQueueAdapter.this.notifyDataSetChanged();
                        if (PlayQueueAdapter.this.onDeleteMusicListener != null) {
                            PlayQueueAdapter.this.onDeleteMusicListener.delete(PlayQueueAdapter.this.musicBeanList, i);
                        }
                    }
                });
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.PlayQueueAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!TextUtils.equals(PlayQueueAdapter.this.videoId, playMusicModel.getVideoId())) {
                            b.a().a(new a(2012));
                            e.a().a(i, false);
                            PlayQueueAdapter.this.notifyDataSetChanged();
                            com.fotoable.youtube.music.util.b.b("播放列表-点击切换歌曲");
                        }
                    }
                });
            }
        } else if (this.localMusicAll != null && (localMusicModel = this.localMusicAll.get(i)) != null) {
            if (localMusicModel.getSongId() == this.songId) {
                viewHolder.video_play_state.setVisibility(0);
                viewHolder.video_seq.setVisibility(8);
                viewHolder.video_title.setTextColor(SupportMenu.CATEGORY_MASK);
                viewHolder.video_title.setAutoScroll(true);
                viewHolder.video_description.setTextColor(SupportMenu.CATEGORY_MASK);
                viewHolder.video_title.setText(localMusicModel.getSongName() + "");
            } else {
                viewHolder.video_title.setTextColor(this.context.getResources().getColor(R.color.top_50_title));
                viewHolder.video_description.setTextColor(this.context.getResources().getColor(R.color.color_676767));
                viewHolder.video_play_state.setVisibility(8);
                viewHolder.video_seq.setVisibility(0);
                viewHolder.video_seq.setText((i + 1) + "");
                viewHolder.video_title.setAutoScroll(false);
                viewHolder.video_title.setText(localMusicModel.getSongName() + "");
            }
            if (!TextUtils.isEmpty(localMusicModel.getArtistName())) {
                viewHolder.video_description.setText(localMusicModel.getArtistName());
                viewHolder.video_description.setVisibility(0);
            } else {
                viewHolder.video_description.setVisibility(8);
            }
            viewHolder.video_delete.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.PlayQueueAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.a().b(i);
                    if (i >= 0 && i < PlayQueueAdapter.this.localMusicAll.size()) {
                        PlayQueueAdapter.this.localMusicAll.remove(i);
                    }
                    PlayQueueAdapter.this.notifyDataSetChanged();
                    if (PlayQueueAdapter.this.onDeleteMusicListener != null) {
                        PlayQueueAdapter.this.onDeleteMusicListener.delete(PlayQueueAdapter.this.localMusicAll, i);
                    }
                }
            });
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.PlayQueueAdapter.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PlayQueueAdapter.this.songId != localMusicModel.getSongId()) {
                        b.a().a(new a(2012));
                        e.a().a(i, false);
                        PlayQueueAdapter.this.notifyDataSetChanged();
                        com.fotoable.youtube.music.util.b.b("播放列表-点击切换歌曲");
                    }
                }
            });
        }
    }

    public void setOnDeleteMusicListener(OnDeleteMusicListener onDeleteMusicListener) {
        this.onDeleteMusicListener = onDeleteMusicListener;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.youtubeAll != null) {
            return this.youtubeAll.size();
        }
        if (this.localMusicAll != null) {
            return this.localMusicAll.size();
        }
        return 0;
    }

    public void setYoutubeAll(List<PlayMusicModel> list) {
        this.youtubeAll = list;
    }

    public void setLocalMusicAll(List<LocalMusicModel> list) {
        this.localMusicAll = list;
    }

    public void setVideoId(String str) {
        this.videoId = str;
    }

    public void setSongId(long j) {
        this.songId = j;
    }

    /* loaded from: classes.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView video_delete;
        private TextView video_description;
        private ImageView video_play_state;
        private TextView video_seq;
        private MarqueeTextView video_title;

        public ViewHolder(View view) {
            super(view);
            this.video_seq = (TextView) view.findViewById(R.id.video_seq);
            this.video_play_state = (ImageView) view.findViewById(R.id.video_play_state);
            this.video_title = (MarqueeTextView) view.findViewById(R.id.video_title);
            this.video_description = (TextView) view.findViewById(R.id.video_description);
            this.video_delete = (ImageView) view.findViewById(R.id.video_delete);
        }
    }
}

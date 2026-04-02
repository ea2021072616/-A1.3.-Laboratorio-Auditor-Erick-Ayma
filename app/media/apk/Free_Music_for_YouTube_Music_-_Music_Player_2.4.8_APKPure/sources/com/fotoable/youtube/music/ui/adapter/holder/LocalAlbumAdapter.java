package com.fotoable.youtube.music.ui.adapter.holder;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bumptech.glide.a;
import com.bumptech.glide.g.a.c;
import com.bumptech.glide.g.b.g;
import com.bumptech.glide.i;
import com.bumptech.glide.load.b.b;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.bean.LocalAlbumBean;
import com.fotoable.youtube.music.ui.activity.LocalAlbumDetailActivity;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.util.h;
import com.fotoable.youtube.music.util.w;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class LocalAlbumAdapter extends RecyclerView.Adapter<DefaultHolder> {
    public static final String TAG = LocalAlbumAdapter.class.getSimpleName();
    private Context context;
    private List<LocalAlbumBean> localSongBeen;
    private RecyclerView recyclerView;
    private HashMap<String, Integer> backColorMap = new HashMap<>();
    private HashMap<String, Integer> textColorMap = new HashMap<>();

    /* loaded from: classes.dex */
    public class DefaultHolder_ViewBinding implements Unbinder {
        private DefaultHolder target;

        @UiThread
        public DefaultHolder_ViewBinding(DefaultHolder defaultHolder, View view) {
            this.target = defaultHolder;
            defaultHolder.album_cover = (ImageView) Utils.findRequiredViewAsType(view, R.id.album_cover, "field 'album_cover'", ImageView.class);
            defaultHolder.album_title = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.album_title, "field 'album_title'", LaToTextView.class);
            defaultHolder.songArtists = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.song_artists, "field 'songArtists'", LaToTextView.class);
            defaultHolder.album_footer = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.album_footer, "field 'album_footer'", RelativeLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            DefaultHolder defaultHolder = this.target;
            if (defaultHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            defaultHolder.album_cover = null;
            defaultHolder.album_title = null;
            defaultHolder.songArtists = null;
            defaultHolder.album_footer = null;
        }
    }

    public LocalAlbumAdapter(Context context) {
        this.context = context;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public DefaultHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new DefaultHolder(LayoutInflater.from(this.context).inflate(R.layout.local_album_list, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(DefaultHolder defaultHolder, int i) {
        if (this.localSongBeen != null && this.localSongBeen.size() > 0) {
            bindHolder(defaultHolder, i);
        }
    }

    private void bindHolder(final DefaultHolder defaultHolder, final int i) {
        defaultHolder.album_title.setText(this.localSongBeen.get(i).album_name);
        defaultHolder.songArtists.setText(this.localSongBeen.get(i).album_artist);
        h.a(TAG, "封面地址：" + this.localSongBeen.get(i).album_art);
        String str = this.localSongBeen.get(i).album_art;
        if (this.backColorMap.get(str) != null && this.textColorMap.get(str) != null) {
            defaultHolder.album_footer.setBackgroundColor(this.backColorMap.get(str).intValue());
            defaultHolder.album_title.setTextColor(this.textColorMap.get(str).intValue());
            defaultHolder.songArtists.setTextColor(this.textColorMap.get(str).intValue());
            i.c(MusicApplication.c()).a(Uri.parse(this.localSongBeen.get(i).album_art)).d((int) R.mipmap.album_cover_def).c((int) R.mipmap.album_cover_def).b(b.ALL).i().a(defaultHolder.album_cover);
        } else {
            i.c(MusicApplication.c()).a(Uri.parse(this.localSongBeen.get(i).album_art)).l().d((int) R.mipmap.album_cover_def).c((int) R.mipmap.album_cover_def).b(b.ALL).i().a((a<Uri, Bitmap>) new g<Bitmap>() { // from class: com.fotoable.youtube.music.ui.adapter.holder.LocalAlbumAdapter.1
                @Override // com.bumptech.glide.g.b.j
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, c cVar) {
                    onResourceReady((Bitmap) obj, (c<? super Bitmap>) cVar);
                }

                public void onResourceReady(Bitmap bitmap, c<? super Bitmap> cVar) {
                    defaultHolder.album_cover.setImageBitmap(bitmap);
                    h.a(LocalAlbumAdapter.TAG, "封面：" + bitmap);
                    try {
                        new Palette.Builder(bitmap).generate(new Palette.PaletteAsyncListener() { // from class: com.fotoable.youtube.music.ui.adapter.holder.LocalAlbumAdapter.1.1
                            @Override // android.support.v7.graphics.Palette.PaletteAsyncListener
                            public void onGenerated(Palette palette) {
                                if (defaultHolder != null) {
                                    Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
                                    if (vibrantSwatch != null) {
                                        int rgb = vibrantSwatch.getRgb();
                                        defaultHolder.album_footer.setBackgroundColor(rgb);
                                        int a2 = w.a(vibrantSwatch.getTitleTextColor());
                                        defaultHolder.album_title.setTextColor(a2);
                                        defaultHolder.songArtists.setTextColor(a2);
                                        if (LocalAlbumAdapter.this.localSongBeen != null && i >= 0 && i < LocalAlbumAdapter.this.localSongBeen.size() && LocalAlbumAdapter.this.localSongBeen.get(i) != null) {
                                            if (LocalAlbumAdapter.this.backColorMap != null) {
                                                LocalAlbumAdapter.this.backColorMap.put(((LocalAlbumBean) LocalAlbumAdapter.this.localSongBeen.get(i)).album_art, Integer.valueOf(rgb));
                                            }
                                            if (LocalAlbumAdapter.this.textColorMap != null) {
                                                LocalAlbumAdapter.this.textColorMap.put(((LocalAlbumBean) LocalAlbumAdapter.this.localSongBeen.get(i)).album_art, Integer.valueOf(a2));
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    Palette.Swatch mutedSwatch = palette.getMutedSwatch();
                                    if (mutedSwatch != null) {
                                        int rgb2 = mutedSwatch.getRgb();
                                        defaultHolder.album_footer.setBackgroundColor(rgb2);
                                        int a3 = w.a(mutedSwatch.getTitleTextColor());
                                        defaultHolder.album_title.setTextColor(a3);
                                        defaultHolder.songArtists.setTextColor(a3);
                                        if (LocalAlbumAdapter.this.localSongBeen != null && i >= 0 && i < LocalAlbumAdapter.this.localSongBeen.size() && LocalAlbumAdapter.this.localSongBeen.get(i) != null) {
                                            if (LocalAlbumAdapter.this.backColorMap != null) {
                                                LocalAlbumAdapter.this.backColorMap.put(((LocalAlbumBean) LocalAlbumAdapter.this.localSongBeen.get(i)).album_art, Integer.valueOf(rgb2));
                                            }
                                            if (LocalAlbumAdapter.this.textColorMap != null) {
                                                LocalAlbumAdapter.this.textColorMap.put(((LocalAlbumBean) LocalAlbumAdapter.this.localSongBeen.get(i)).album_art, Integer.valueOf(a3));
                                            }
                                        }
                                    }
                                }
                            }
                        });
                    } catch (Exception e) {
                        ThrowableExtension.printStackTrace(e);
                        com.fotoable.youtube.music.util.b.a(e);
                    } catch (NoSuchFieldError e2) {
                        ThrowableExtension.printStackTrace(e2);
                        com.fotoable.youtube.music.util.b.a(e2);
                    }
                }

                @Override // com.bumptech.glide.g.b.a, com.bumptech.glide.g.b.j
                public void onLoadFailed(Exception exc, Drawable drawable) {
                    super.onLoadFailed(exc, drawable);
                    if (exc != null) {
                        h.a(LocalAlbumAdapter.TAG, "加载图片失败" + exc.getMessage());
                        ThrowableExtension.printStackTrace(exc);
                    }
                    if (defaultHolder != null) {
                        if (exc != null && (exc instanceof FileNotFoundException) && LocalAlbumAdapter.this.localSongBeen != null && i >= 0 && i < LocalAlbumAdapter.this.localSongBeen.size() && LocalAlbumAdapter.this.localSongBeen.get(i) != null) {
                            if (LocalAlbumAdapter.this.backColorMap != null) {
                                LocalAlbumAdapter.this.backColorMap.put(((LocalAlbumBean) LocalAlbumAdapter.this.localSongBeen.get(i)).album_art, -1);
                            }
                            if (LocalAlbumAdapter.this.textColorMap != null) {
                                LocalAlbumAdapter.this.textColorMap.put(((LocalAlbumBean) LocalAlbumAdapter.this.localSongBeen.get(i)).album_art, Integer.valueOf(MusicApplication.c().getResources().getColor(R.color.color_2b2525)));
                            }
                        }
                        defaultHolder.album_footer.setBackgroundColor(-1);
                        defaultHolder.album_title.setTextColor(MusicApplication.c().getResources().getColor(R.color.color_2b2525));
                        defaultHolder.songArtists.setTextColor(MusicApplication.c().getResources().getColor(R.color.color_676767));
                    }
                }
            });
        }
        defaultHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.holder.LocalAlbumAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.fotoable.youtube.music.util.b.b("专辑页面--进入专辑详情页");
                Intent intent = new Intent(LocalAlbumAdapter.this.context, LocalAlbumDetailActivity.class);
                intent.putExtra("data_id", ((LocalAlbumBean) LocalAlbumAdapter.this.localSongBeen.get(i)).album_id);
                intent.putExtra("name", ((LocalAlbumBean) LocalAlbumAdapter.this.localSongBeen.get(i)).album_name);
                intent.putExtra("artists", ((LocalAlbumBean) LocalAlbumAdapter.this.localSongBeen.get(i)).album_artist);
                LocalAlbumAdapter.this.context.startActivity(intent);
            }
        });
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.localSongBeen != null && this.localSongBeen.size() > 0) {
            return this.localSongBeen.size();
        }
        return 0;
    }

    public void setData(List<LocalAlbumBean> list) {
        this.localSongBeen = list;
        notifyDataSetChanged();
    }

    /* loaded from: classes.dex */
    public class DefaultHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.album_cover)
        ImageView album_cover;
        @BindView(R.id.album_footer)
        RelativeLayout album_footer;
        @BindView(R.id.album_title)
        LaToTextView album_title;
        @BindView(R.id.song_artists)
        LaToTextView songArtists;

        public DefaultHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    public void destroy() {
        if (this.recyclerView != null) {
            try {
                this.recyclerView.removeAllViews();
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
        if (this.localSongBeen != null) {
            this.localSongBeen.clear();
            this.localSongBeen = null;
        }
    }
}

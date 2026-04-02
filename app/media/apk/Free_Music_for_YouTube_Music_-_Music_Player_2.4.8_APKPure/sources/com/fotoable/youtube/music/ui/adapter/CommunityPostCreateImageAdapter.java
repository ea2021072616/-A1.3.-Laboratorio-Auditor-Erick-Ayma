package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bumptech.glide.i;
import com.bumptech.glide.load.b.b;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.util.h;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.api.GalleryWrapper;
import com.yanzhenjie.album.api.ImageMultipleWrapper;
import com.yanzhenjie.album.api.widget.Widget;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class CommunityPostCreateImageAdapter extends BaseAdapter<ImageViewHolder> {
    private Context context;
    private List<String> imageList;
    private LayoutInflater inflater;
    private boolean isChecked = true;
    private ArrayList<AlbumFile> mAlbumFiles;

    /* loaded from: classes.dex */
    public class ImageViewHolder_ViewBinding implements Unbinder {
        private ImageViewHolder target;

        @UiThread
        public ImageViewHolder_ViewBinding(ImageViewHolder imageViewHolder, View view) {
            this.target = imageViewHolder;
            imageViewHolder.iv_post_img = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_post_img, "field 'iv_post_img'", ImageView.class);
            imageViewHolder.iv_post_img_del = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_post_img_del, "field 'iv_post_img_del'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ImageViewHolder imageViewHolder = this.target;
            if (imageViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            imageViewHolder.iv_post_img = null;
            imageViewHolder.iv_post_img_del = null;
        }
    }

    public CommunityPostCreateImageAdapter(Context context, List<String> list) {
        this.context = context;
        this.imageList = list;
        this.inflater = LayoutInflater.from(this.context);
    }

    @Override // com.fotoable.youtube.music.ui.adapter.BaseAdapter
    public void onDestroy() {
        this.context = null;
        this.inflater = null;
        this.imageList = null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public ImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ImageViewHolder(this.inflater.inflate(R.layout.view_holder_community_post_create_img, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(ImageViewHolder imageViewHolder, final int i) {
        String str = this.imageList.get(i);
        if (!TextUtils.equals(str, "+")) {
            i.c(this.context).a(str).b(b.ALL).a(imageViewHolder.iv_post_img);
            imageViewHolder.iv_post_img.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.CommunityPostCreateImageAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (CommunityPostCreateImageAdapter.this.isChecked) {
                        h.a(CommunityPostCreateImageAdapter.this.imageList.toString());
                        final ArrayList arrayList = new ArrayList(CommunityPostCreateImageAdapter.this.imageList);
                        if (arrayList.size() > 0 && TextUtils.equals((CharSequence) arrayList.get(arrayList.size() - 1), "+")) {
                            arrayList.remove(arrayList.size() - 1);
                        }
                        ((GalleryWrapper) ((GalleryWrapper) ((GalleryWrapper) Album.gallery(CommunityPostCreateImageAdapter.this.context).requestCode(2)).checkedList(arrayList).navigationAlpha(80).checkable(CommunityPostCreateImageAdapter.this.isChecked).onResult(new Action<ArrayList<String>>() { // from class: com.fotoable.youtube.music.ui.adapter.CommunityPostCreateImageAdapter.1.2
                            @Override // com.yanzhenjie.album.Action
                            public void onAction(int i2, @NonNull ArrayList<String> arrayList2) {
                                if (CommunityPostCreateImageAdapter.this.isChecked && arrayList2.size() != arrayList.size()) {
                                    CommunityPostCreateImageAdapter.this.imageList.clear();
                                    CommunityPostCreateImageAdapter.this.imageList.addAll(arrayList2);
                                    if (CommunityPostCreateImageAdapter.this.imageList.size() < 9) {
                                        CommunityPostCreateImageAdapter.this.imageList.add("+");
                                    }
                                    ArrayList arrayList3 = new ArrayList();
                                    int i3 = 0;
                                    while (true) {
                                        int i4 = i3;
                                        if (i4 < CommunityPostCreateImageAdapter.this.mAlbumFiles.size()) {
                                            if (!CommunityPostCreateImageAdapter.this.imageList.contains(((AlbumFile) CommunityPostCreateImageAdapter.this.mAlbumFiles.get(i4)).getPath())) {
                                                arrayList3.add(CommunityPostCreateImageAdapter.this.mAlbumFiles.get(i4));
                                            }
                                            i3 = i4 + 1;
                                        } else {
                                            CommunityPostCreateImageAdapter.this.mAlbumFiles.removeAll(arrayList3);
                                            CommunityPostCreateImageAdapter.this.notifyDataSetChanged();
                                            return;
                                        }
                                    }
                                }
                            }
                        })).onCancel(new Action<String>() { // from class: com.fotoable.youtube.music.ui.adapter.CommunityPostCreateImageAdapter.1.1
                            @Override // com.yanzhenjie.album.Action
                            public void onAction(int i2, @NonNull String str2) {
                            }
                        })).start();
                    }
                }
            });
            imageViewHolder.iv_post_img_del.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.CommunityPostCreateImageAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CommunityPostCreateImageAdapter.this.imageList.remove(i);
                    CommunityPostCreateImageAdapter.this.mAlbumFiles.remove(i);
                    CommunityPostCreateImageAdapter.this.notifyDataSetChanged();
                }
            });
            if (!this.isChecked) {
                imageViewHolder.iv_post_img_del.setVisibility(8);
                return;
            } else {
                imageViewHolder.iv_post_img_del.setVisibility(0);
                return;
            }
        }
        i.c(this.context).a(Integer.valueOf((int) R.drawable.post_defalut_add_picture)).b(b.ALL).a(imageViewHolder.iv_post_img);
        imageViewHolder.iv_post_img.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.CommunityPostCreateImageAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommunityPostCreateImageAdapter.this.selectAlbum();
            }
        });
        imageViewHolder.iv_post_img_del.setVisibility(8);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.imageList.size();
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_post_img)
        ImageView iv_post_img;
        @BindView(R.id.iv_post_img_del)
        ImageView iv_post_img_del;

        public ImageViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public ArrayList<AlbumFile> getAlbumFiles() {
        return this.mAlbumFiles;
    }

    public void setmAlbumFiles(ArrayList<AlbumFile> arrayList) {
        this.mAlbumFiles = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectAlbum() {
        try {
            ((ImageMultipleWrapper) ((ImageMultipleWrapper) ((ImageMultipleWrapper) ((ImageMultipleWrapper) Album.image(this.context).multipleChoice().selectCount(9).requestCode(1001)).camera(true).columnCount(2).checkedList(this.mAlbumFiles).widget(Widget.newDarkBuilder(MusicApplication.c()).title(R.string.album).statusBarColor(ContextCompat.getColor(MusicApplication.c(), R.color.color_ff2d55)).toolBarColor(ContextCompat.getColor(MusicApplication.c(), R.color.color_ff2d55)).navigationBarColor(ContextCompat.getColor(MusicApplication.c(), R.color.color_ff2d55)).build())).onResult(new Action<ArrayList<AlbumFile>>() { // from class: com.fotoable.youtube.music.ui.adapter.CommunityPostCreateImageAdapter.5
                @Override // com.yanzhenjie.album.Action
                public void onAction(int i, @NonNull ArrayList<AlbumFile> arrayList) {
                    CommunityPostCreateImageAdapter.this.mAlbumFiles = arrayList;
                    if (arrayList == null || arrayList.size() <= 0) {
                        CommunityPostCreateImageAdapter.this.imageList.clear();
                        CommunityPostCreateImageAdapter.this.imageList.add("+");
                        CommunityPostCreateImageAdapter.this.notifyDataSetChanged();
                        return;
                    }
                    CommunityPostCreateImageAdapter.this.imageList.clear();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < CommunityPostCreateImageAdapter.this.mAlbumFiles.size()) {
                            CommunityPostCreateImageAdapter.this.imageList.add(((AlbumFile) CommunityPostCreateImageAdapter.this.mAlbumFiles.get(i3)).getPath());
                            i2 = i3 + 1;
                        } else {
                            CommunityPostCreateImageAdapter.this.imageList.add("+");
                            CommunityPostCreateImageAdapter.this.notifyDataSetChanged();
                            return;
                        }
                    }
                }
            })).onCancel(new Action<String>() { // from class: com.fotoable.youtube.music.ui.adapter.CommunityPostCreateImageAdapter.4
                @Override // com.yanzhenjie.album.Action
                public void onAction(int i, @NonNull String str) {
                }
            })).start();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
            com.fotoable.youtube.music.util.b.a(e);
        }
    }
}

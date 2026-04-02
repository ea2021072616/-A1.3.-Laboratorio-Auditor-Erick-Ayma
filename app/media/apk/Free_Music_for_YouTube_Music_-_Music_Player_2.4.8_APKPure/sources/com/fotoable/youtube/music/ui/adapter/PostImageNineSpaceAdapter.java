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
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bumptech.glide.i;
import com.bumptech.glide.load.b.b;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.activity.CommunityPostImagePreviewActivity;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PostImageNineSpaceAdapter extends BaseAdapter<ImageViewHolder> {
    private Context context;
    private ArrayList<String> imageList;
    private LayoutInflater inflater;
    private ArrayList<String> thumbImageList;

    /* loaded from: classes.dex */
    public class ImageViewHolder_ViewBinding implements Unbinder {
        private ImageViewHolder target;

        @UiThread
        public ImageViewHolder_ViewBinding(ImageViewHolder imageViewHolder, View view) {
            this.target = imageViewHolder;
            imageViewHolder.iv_post_img = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_post_img, "field 'iv_post_img'", ImageView.class);
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
        }
    }

    public PostImageNineSpaceAdapter(Context context, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.context = context;
        this.thumbImageList = arrayList;
        this.imageList = arrayList2;
        this.inflater = LayoutInflater.from(this.context);
    }

    @Override // com.fotoable.youtube.music.ui.adapter.BaseAdapter
    public void onDestroy() {
        this.context = null;
        this.inflater = null;
        this.thumbImageList = null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public ImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ImageViewHolder(this.inflater.inflate(R.layout.view_holder_community_post_browse_img, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(ImageViewHolder imageViewHolder, final int i) {
        i.c(this.context).a(this.thumbImageList.get(i)).b(b.ALL).a(imageViewHolder.iv_post_img);
        imageViewHolder.iv_post_img.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.PostImageNineSpaceAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(PostImageNineSpaceAdapter.this.context, CommunityPostImagePreviewActivity.class);
                intent.putStringArrayListExtra("imageList", PostImageNineSpaceAdapter.this.imageList);
                intent.putExtra("position", i);
                PostImageNineSpaceAdapter.this.context.startActivity(intent);
            }
        });
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.thumbImageList.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_post_img)
        ImageView iv_post_img;

        public ImageViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

package com.yanzhenjie.album.ui.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.AlbumFolder;
import com.yanzhenjie.album.R;
import com.yanzhenjie.album.impl.OnItemClickListener;
import com.yanzhenjie.album.util.DisplayUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AlbumFolderAdapter extends RecyclerView.Adapter<FolderViewHolder> {
    private List<AlbumFolder> mAlbumFolders;
    private int mImageSize = DisplayUtils.dip2px(80.0f);
    private LayoutInflater mInflater;
    private OnItemClickListener mItemClickListener;
    private ColorStateList mSelector;

    public AlbumFolderAdapter(Context context, List<AlbumFolder> list, ColorStateList colorStateList) {
        this.mInflater = LayoutInflater.from(context);
        this.mSelector = colorStateList;
        this.mAlbumFolders = list;
    }

    public void setItemClickListener(OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public FolderViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new FolderViewHolder(this.mInflater.inflate(R.layout.album_item_dialog_folder, viewGroup, false), this.mImageSize, this.mSelector, new OnItemClickListener() { // from class: com.yanzhenjie.album.ui.adapter.AlbumFolderAdapter.1
            private int oldPosition = 0;

            @Override // com.yanzhenjie.album.impl.OnItemClickListener
            public void onItemClick(View view, int i2) {
                if (AlbumFolderAdapter.this.mItemClickListener != null) {
                    AlbumFolderAdapter.this.mItemClickListener.onItemClick(view, i2);
                }
                AlbumFolder albumFolder = (AlbumFolder) AlbumFolderAdapter.this.mAlbumFolders.get(i2);
                if (!albumFolder.isChecked()) {
                    albumFolder.setChecked(true);
                    ((AlbumFolder) AlbumFolderAdapter.this.mAlbumFolders.get(this.oldPosition)).setChecked(false);
                    AlbumFolderAdapter.this.notifyItemChanged(this.oldPosition);
                    AlbumFolderAdapter.this.notifyItemChanged(i2);
                    this.oldPosition = i2;
                }
            }
        });
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(FolderViewHolder folderViewHolder, int i) {
        folderViewHolder.setData(this.mAlbumFolders.get(folderViewHolder.getAdapterPosition()));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mAlbumFolders == null) {
            return 0;
        }
        return this.mAlbumFolders.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class FolderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private AppCompatRadioButton mCheckBox;
        private int mImageSize;
        private OnItemClickListener mItemClickListener;
        private ImageView mIvImage;
        private TextView mTvTitle;

        private FolderViewHolder(View view, int i, ColorStateList colorStateList, OnItemClickListener onItemClickListener) {
            super(view);
            this.mImageSize = i;
            this.mItemClickListener = onItemClickListener;
            this.mIvImage = (ImageView) view.findViewById(R.id.iv_gallery_preview_image);
            this.mTvTitle = (TextView) view.findViewById(R.id.tv_gallery_preview_title);
            this.mCheckBox = (AppCompatRadioButton) view.findViewById(R.id.rb_gallery_preview_check);
            view.setOnClickListener(this);
            this.mCheckBox.setSupportButtonTintList(colorStateList);
        }

        public void setData(AlbumFolder albumFolder) {
            ArrayList<AlbumFile> albumFiles = albumFolder.getAlbumFiles();
            this.mTvTitle.setText("(" + albumFiles.size() + ") " + albumFolder.getName());
            this.mCheckBox.setChecked(albumFolder.isChecked());
            Album.getAlbumConfig().getAlbumLoader().loadAlbumFile(this.mIvImage, albumFiles.get(0), this.mImageSize, this.mImageSize);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.mItemClickListener != null) {
                this.mItemClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }
}

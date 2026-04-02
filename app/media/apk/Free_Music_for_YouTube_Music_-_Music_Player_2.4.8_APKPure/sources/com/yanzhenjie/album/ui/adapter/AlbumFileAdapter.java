package com.yanzhenjie.album.ui.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.R;
import com.yanzhenjie.album.impl.OnItemCheckedListener;
import com.yanzhenjie.album.impl.OnItemClickListener;
import com.yanzhenjie.album.util.AlbumUtils;
import java.util.List;
/* loaded from: classes2.dex */
public class AlbumFileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_BUTTON = 1;
    private static final int TYPE_IMAGE = 2;
    private static final int TYPE_VIDEO = 3;
    private final boolean hasCamera;
    private final int itemSize;
    private OnItemClickListener mAddPhotoClickListener;
    private List<AlbumFile> mAlbumFiles;
    private final int mChoiceMode;
    private final LayoutInflater mInflater;
    private OnItemCheckedListener mItemCheckedListener;
    private OnItemClickListener mItemClickListener;
    private final ColorStateList mSelector;

    public AlbumFileAdapter(Context context, int i, boolean z, int i2, ColorStateList colorStateList) {
        this.mInflater = LayoutInflater.from(context);
        this.hasCamera = z;
        this.itemSize = i;
        this.mChoiceMode = i2;
        this.mSelector = colorStateList;
    }

    public void notifyDataSetChanged(List<AlbumFile> list) {
        this.mAlbumFiles = list;
        super.notifyDataSetChanged();
    }

    public void setAddClickListener(OnItemClickListener onItemClickListener) {
        this.mAddPhotoClickListener = onItemClickListener;
    }

    public void setItemClickListener(OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }

    public void setItemCheckedListener(OnItemCheckedListener onItemCheckedListener) {
        this.mItemCheckedListener = onItemCheckedListener;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i = this.hasCamera ? 1 : 0;
        return this.mAlbumFiles == null ? i : i + this.mAlbumFiles.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        switch (i) {
            case 0:
                return this.hasCamera ? 1 : 2;
            default:
                if (this.hasCamera) {
                    i--;
                }
                return this.mAlbumFiles.get(i).getMediaType() == 2 ? 3 : 2;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (i) {
            case 1:
                return new ButtonViewHolder(this.mInflater.inflate(R.layout.album_item_content_button, viewGroup, false), this.itemSize, this.hasCamera, this.mAddPhotoClickListener);
            case 2:
                return new ImageHolder(this.mInflater.inflate(R.layout.album_item_content_image, viewGroup, false), this.itemSize, this.hasCamera, this.mChoiceMode, this.mSelector, this.mItemClickListener, this.mItemCheckedListener);
            default:
                return new VideoHolder(this.mInflater.inflate(R.layout.album_item_content_video, viewGroup, false), this.itemSize, this.hasCamera, this.mChoiceMode, this.mSelector, this.mItemClickListener, this.mItemCheckedListener);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        switch (getItemViewType(i)) {
            case 1:
                return;
            case 2:
                ((ImageHolder) viewHolder).setData(this.mAlbumFiles.get(viewHolder.getAdapterPosition() - (this.hasCamera ? 1 : 0)));
                return;
            default:
                ((VideoHolder) viewHolder).setData(this.mAlbumFiles.get(viewHolder.getAdapterPosition() - (this.hasCamera ? 1 : 0)));
                return;
        }
    }

    /* loaded from: classes2.dex */
    private static class ButtonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final boolean hasCamera;
        private final OnItemClickListener mItemClickListener;

        ButtonViewHolder(View view, int i, boolean z, OnItemClickListener onItemClickListener) {
            super(view);
            view.getLayoutParams().height = i;
            this.hasCamera = z;
            this.mItemClickListener = onItemClickListener;
            view.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.mItemClickListener != null && view == this.itemView) {
                this.mItemClickListener.onItemClick(view, getAdapterPosition() - (this.hasCamera ? 1 : 0));
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class ImageHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final boolean hasCamera;
        private final int itemSize;
        private AppCompatCheckBox mCheckBox;
        private final int mChoiceMode;
        private final OnItemCheckedListener mItemCheckedListener;
        private final OnItemClickListener mItemClickListener;
        private ImageView mIvImage;
        private FrameLayout mLayoutCheck;
        private FrameLayout mLayoutLayer;

        ImageHolder(View view, int i, boolean z, int i2, ColorStateList colorStateList, OnItemClickListener onItemClickListener, OnItemCheckedListener onItemCheckedListener) {
            super(view);
            view.getLayoutParams().height = i;
            this.itemSize = i;
            this.hasCamera = z;
            this.mChoiceMode = i2;
            this.mItemClickListener = onItemClickListener;
            this.mItemCheckedListener = onItemCheckedListener;
            this.mIvImage = (ImageView) view.findViewById(R.id.iv_album_content_image);
            this.mLayoutCheck = (FrameLayout) view.findViewById(R.id.layout_album_check);
            this.mCheckBox = (AppCompatCheckBox) view.findViewById(R.id.cb_album_check);
            this.mLayoutLayer = (FrameLayout) view.findViewById(R.id.layout_layer);
            view.setOnClickListener(this);
            this.mLayoutCheck.setOnClickListener(this);
            this.mLayoutLayer.setOnClickListener(this);
            if (this.mChoiceMode == 1) {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setSupportButtonTintList(colorStateList);
                return;
            }
            this.mCheckBox.setVisibility(8);
        }

        void setData(AlbumFile albumFile) {
            this.mCheckBox.setChecked(albumFile.isChecked());
            Album.getAlbumConfig().getAlbumLoader().loadAlbumFile(this.mIvImage, albumFile, this.itemSize, this.itemSize);
            this.mLayoutLayer.setVisibility(albumFile.isEnable() ? 8 : 0);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.itemView) {
                switch (this.mChoiceMode) {
                    case 1:
                        if (this.mItemClickListener != null) {
                            this.mItemClickListener.onItemClick(view, getAdapterPosition() - (this.hasCamera ? 1 : 0));
                            return;
                        }
                        return;
                    case 2:
                        if (this.mItemCheckedListener != null) {
                            this.mCheckBox.toggle();
                            this.mItemCheckedListener.onCheckedChanged(this.mCheckBox, getAdapterPosition() - (this.hasCamera ? 1 : 0), this.mCheckBox.isChecked());
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else if (view == this.mLayoutCheck) {
                this.mCheckBox.toggle();
                if (this.mItemCheckedListener != null) {
                    this.mItemCheckedListener.onCheckedChanged(this.mCheckBox, getAdapterPosition() - (this.hasCamera ? 1 : 0), this.mCheckBox.isChecked());
                }
            } else if (view == this.mLayoutLayer && this.mItemClickListener != null) {
                this.mItemClickListener.onItemClick(view, getAdapterPosition() - (this.hasCamera ? 1 : 0));
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class VideoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final boolean hasCamera;
        private final int itemSize;
        private AppCompatCheckBox mCheckBox;
        private final int mChoiceMode;
        private final OnItemCheckedListener mItemCheckedListener;
        private final OnItemClickListener mItemClickListener;
        private ImageView mIvImage;
        private FrameLayout mLayoutCheck;
        private FrameLayout mLayoutLayer;
        private TextView mTvDuration;

        VideoHolder(View view, int i, boolean z, int i2, ColorStateList colorStateList, OnItemClickListener onItemClickListener, OnItemCheckedListener onItemCheckedListener) {
            super(view);
            view.getLayoutParams().height = i;
            this.itemSize = i;
            this.hasCamera = z;
            this.mChoiceMode = i2;
            this.mItemClickListener = onItemClickListener;
            this.mItemCheckedListener = onItemCheckedListener;
            this.mIvImage = (ImageView) view.findViewById(R.id.iv_album_content_image);
            this.mLayoutCheck = (FrameLayout) view.findViewById(R.id.layout_album_check);
            this.mCheckBox = (AppCompatCheckBox) view.findViewById(R.id.cb_album_check);
            this.mTvDuration = (TextView) view.findViewById(R.id.tv_duration);
            this.mLayoutLayer = (FrameLayout) view.findViewById(R.id.layout_layer);
            view.setOnClickListener(this);
            this.mLayoutCheck.setOnClickListener(this);
            this.mLayoutLayer.setOnClickListener(this);
            if (this.mChoiceMode == 1) {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setSupportButtonTintList(colorStateList);
                return;
            }
            this.mCheckBox.setVisibility(8);
        }

        void setData(AlbumFile albumFile) {
            Album.getAlbumConfig().getAlbumLoader().loadAlbumFile(this.mIvImage, albumFile, this.itemSize, this.itemSize);
            this.mCheckBox.setChecked(albumFile.isChecked());
            this.mTvDuration.setText(AlbumUtils.convertDuration(albumFile.getDuration()));
            this.mLayoutLayer.setVisibility(albumFile.isEnable() ? 8 : 0);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.itemView) {
                switch (this.mChoiceMode) {
                    case 1:
                        if (this.mItemClickListener != null) {
                            this.mItemClickListener.onItemClick(view, getAdapterPosition() - (this.hasCamera ? 1 : 0));
                            return;
                        }
                        return;
                    case 2:
                        if (this.mItemCheckedListener != null) {
                            this.mCheckBox.toggle();
                            this.mItemCheckedListener.onCheckedChanged(this.mCheckBox, getAdapterPosition() - (this.hasCamera ? 1 : 0), this.mCheckBox.isChecked());
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else if (view == this.mLayoutCheck) {
                this.mCheckBox.toggle();
                if (this.mItemCheckedListener != null) {
                    this.mItemCheckedListener.onCheckedChanged(this.mCheckBox, getAdapterPosition() - (this.hasCamera ? 1 : 0), this.mCheckBox.isChecked());
                }
            } else if (view == this.mLayoutLayer && this.mItemClickListener != null) {
                this.mItemClickListener.onItemClick(view, getAdapterPosition() - (this.hasCamera ? 1 : 0));
            }
        }
    }
}

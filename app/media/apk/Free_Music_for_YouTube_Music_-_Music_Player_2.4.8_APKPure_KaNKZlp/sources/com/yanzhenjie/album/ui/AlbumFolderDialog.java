package com.yanzhenjie.album.ui;

import android.content.Context;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import com.yanzhenjie.album.AlbumFolder;
import com.yanzhenjie.album.R;
import com.yanzhenjie.album.api.widget.Widget;
import com.yanzhenjie.album.impl.OnItemClickListener;
import com.yanzhenjie.album.ui.adapter.AlbumFolderAdapter;
import java.util.List;
/* loaded from: classes2.dex */
public class AlbumFolderDialog extends BottomSheetDialog {
    static final /* synthetic */ boolean $assertionsDisabled;
    private BottomSheetBehavior bottomSheetBehavior;
    private List<AlbumFolder> mAlbumFolders;
    private int mCurrentPosition;
    private AlbumFolderAdapter mFolderAdapter;
    private OnItemClickListener mItemClickListener;

    static {
        $assertionsDisabled = !AlbumFolderDialog.class.desiredAssertionStatus();
    }

    public AlbumFolderDialog(@NonNull Context context, Widget widget, @Nullable List<AlbumFolder> list, @Nullable OnItemClickListener onItemClickListener) {
        super(context, R.style.album_DialogStyle_Folder);
        this.mCurrentPosition = 0;
        setContentView(R.layout.album_dialog_floder);
        setWindowBarColor(widget.getStatusBarColor(), widget.getNavigationBarColor());
        fixRestart();
        this.mAlbumFolders = list;
        this.mItemClickListener = onItemClickListener;
        RecyclerView recyclerView = (RecyclerView) getDelegate().findViewById(R.id.rv_content_list);
        if (!$assertionsDisabled && recyclerView == null) {
            throw new AssertionError();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mFolderAdapter = new AlbumFolderAdapter(context, this.mAlbumFolders, widget.getBucketItemCheckSelector());
        this.mFolderAdapter.setItemClickListener(new OnItemClickListener() { // from class: com.yanzhenjie.album.ui.AlbumFolderDialog.1
            @Override // com.yanzhenjie.album.impl.OnItemClickListener
            public void onItemClick(View view, int i) {
                AlbumFolderDialog.this.behaviorHide();
                if (AlbumFolderDialog.this.mCurrentPosition != i) {
                    ((AlbumFolder) AlbumFolderDialog.this.mAlbumFolders.get(AlbumFolderDialog.this.mCurrentPosition)).setChecked(false);
                    AlbumFolderDialog.this.mFolderAdapter.notifyItemChanged(AlbumFolderDialog.this.mCurrentPosition);
                    AlbumFolderDialog.this.mCurrentPosition = i;
                    ((AlbumFolder) AlbumFolderDialog.this.mAlbumFolders.get(AlbumFolderDialog.this.mCurrentPosition)).setChecked(true);
                    AlbumFolderDialog.this.mFolderAdapter.notifyItemChanged(AlbumFolderDialog.this.mCurrentPosition);
                    if (AlbumFolderDialog.this.mItemClickListener != null) {
                        AlbumFolderDialog.this.mItemClickListener.onItemClick(view, i);
                    }
                }
            }
        });
        recyclerView.setAdapter(this.mFolderAdapter);
    }

    private void setWindowBarColor(@ColorInt int i, @ColorInt int i2) {
        Window window;
        if (Build.VERSION.SDK_INT >= 21 && (window = getWindow()) != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i);
            window.setNavigationBarColor(i2);
        }
    }

    private void fixRestart() {
        View findViewById = findViewById(android.support.design.R.id.design_bottom_sheet);
        if (findViewById != null) {
            this.bottomSheetBehavior = BottomSheetBehavior.from(findViewById);
            this.bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: com.yanzhenjie.album.ui.AlbumFolderDialog.2
                @Override // android.support.design.widget.BottomSheetBehavior.BottomSheetCallback
                public void onStateChanged(@NonNull View view, int i) {
                    if (i == 5) {
                        AlbumFolderDialog.this.dismiss();
                        AlbumFolderDialog.this.bottomSheetBehavior.setState(4);
                    }
                }

                @Override // android.support.design.widget.BottomSheetBehavior.BottomSheetCallback
                public void onSlide(@NonNull View view, float f) {
                }
            });
        }
    }

    public void behaviorHide() {
        this.bottomSheetBehavior.setState(5);
    }
}

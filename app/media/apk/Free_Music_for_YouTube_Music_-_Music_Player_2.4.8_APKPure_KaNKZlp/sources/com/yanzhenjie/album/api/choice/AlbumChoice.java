package com.yanzhenjie.album.api.choice;

import android.content.Context;
import com.yanzhenjie.album.api.AlbumMultipleWrapper;
import com.yanzhenjie.album.api.AlbumSingleWrapper;
/* loaded from: classes.dex */
public final class AlbumChoice implements Choice<AlbumMultipleWrapper, AlbumSingleWrapper> {
    private Context mContext;

    public AlbumChoice(Context context) {
        this.mContext = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yanzhenjie.album.api.choice.Choice
    public AlbumMultipleWrapper multipleChoice() {
        return new AlbumMultipleWrapper(this.mContext);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yanzhenjie.album.api.choice.Choice
    public AlbumSingleWrapper singleChoice() {
        return new AlbumSingleWrapper(this.mContext);
    }
}

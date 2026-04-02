package com.yanzhenjie.album.api.choice;

import android.content.Context;
import com.yanzhenjie.album.api.ImageMultipleWrapper;
import com.yanzhenjie.album.api.ImageSingleWrapper;
/* loaded from: classes.dex */
public final class ImageChoice implements Choice<ImageMultipleWrapper, ImageSingleWrapper> {
    private Context mContext;

    public ImageChoice(Context context) {
        this.mContext = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yanzhenjie.album.api.choice.Choice
    public ImageMultipleWrapper multipleChoice() {
        return new ImageMultipleWrapper(this.mContext);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yanzhenjie.album.api.choice.Choice
    public ImageSingleWrapper singleChoice() {
        return new ImageSingleWrapper(this.mContext);
    }
}

package com.yanzhenjie.album.api;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.v4.media.MediaDescriptionCompat;
import com.yanzhenjie.album.api.BasicGalleryWrapper;
import java.util.ArrayList;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public abstract class BasicGalleryWrapper<Returner extends BasicGalleryWrapper, Result, Cancel, Checked> extends BasicAlbumWrapper<Returner, ArrayList<Result>, Cancel, ArrayList<Checked>> {
    boolean mCheckable;
    @IntRange(from = 1, to = 2147483647L)
    int mCurrentPosition;
    @IntRange(from = MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED, to = IjkMediaMeta.AV_CH_LAYOUT_7POINT1_WIDE_BACK)
    int mNavigationAlpha;

    public BasicGalleryWrapper(Context context) {
        super(context);
        this.mCurrentPosition = 0;
        this.mCheckable = true;
        this.mNavigationAlpha = 80;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Returner checkedList(ArrayList<Checked> arrayList) {
        this.mChecked = arrayList;
        return this;
    }

    public Returner currentPosition(@IntRange(from = 1, to = 2147483647L) int i) {
        this.mCurrentPosition = i;
        return this;
    }

    public Returner checkable(boolean z) {
        this.mCheckable = z;
        return this;
    }

    public Returner navigationAlpha(@IntRange(from = 0, to = 255) int i) {
        this.mNavigationAlpha = i;
        return this;
    }
}

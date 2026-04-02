package com.yanzhenjie.album.api;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import com.yanzhenjie.album.Filter;
import com.yanzhenjie.album.api.BasicChoiceWrapper;
/* loaded from: classes2.dex */
public abstract class BasicChoiceWrapper<Returner extends BasicChoiceWrapper, Result, Cancel, Checked> extends BasicAlbumWrapper<Returner, Result, Cancel, Checked> {
    @IntRange(from = 1, to = 4)
    int mColumnCount;
    boolean mFilterVisibility;
    boolean mHasCamera;
    Filter<String> mMimeTypeFilter;
    Filter<Long> mSizeFilter;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BasicChoiceWrapper(@NonNull Context context) {
        super(context);
        this.mHasCamera = true;
        this.mColumnCount = 2;
        this.mFilterVisibility = true;
    }

    public Returner camera(boolean z) {
        this.mHasCamera = z;
        return this;
    }

    public Returner columnCount(@IntRange(from = 1, to = 4) int i) {
        this.mColumnCount = i;
        return this;
    }

    public Returner filterSize(Filter<Long> filter) {
        this.mSizeFilter = filter;
        return this;
    }

    public Returner filterMimeType(Filter<String> filter) {
        this.mMimeTypeFilter = filter;
        return this;
    }

    public Returner afterFilterVisibility(boolean z) {
        this.mFilterVisibility = z;
        return this;
    }
}

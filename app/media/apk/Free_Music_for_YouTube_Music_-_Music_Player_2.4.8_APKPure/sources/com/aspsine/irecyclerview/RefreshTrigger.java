package com.aspsine.irecyclerview;
/* loaded from: classes.dex */
public interface RefreshTrigger {
    void onComplete();

    void onMove(boolean z, boolean z2, int i);

    void onRefresh();

    void onRelease();

    void onReset();

    void onStart(boolean z, int i, int i2);
}

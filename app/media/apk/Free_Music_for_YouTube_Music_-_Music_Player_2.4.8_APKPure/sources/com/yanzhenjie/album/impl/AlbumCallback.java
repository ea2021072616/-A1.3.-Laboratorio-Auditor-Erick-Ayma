package com.yanzhenjie.album.impl;

import com.yanzhenjie.album.AlbumFile;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public interface AlbumCallback {
    void onAlbumCancel();

    void onAlbumResult(ArrayList<AlbumFile> arrayList);
}

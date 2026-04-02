package com.fotoable.youtube.music.helper.localmusic;

import com.fotoable.youtube.music.bean.LocalAlbumBean;
import java.util.Comparator;
/* compiled from: AlbumComparator.java */
/* loaded from: classes.dex */
public class a implements Comparator<LocalAlbumBean> {
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(LocalAlbumBean localAlbumBean, LocalAlbumBean localAlbumBean2) {
        String str = localAlbumBean.album_sort;
        String str2 = localAlbumBean2.album_sort;
        if (a(str) && a(str2)) {
            return 0;
        }
        if (a(str)) {
            return -1;
        }
        if (a(str2)) {
            return 1;
        }
        return str.compareTo(str2);
    }

    private boolean a(String str) {
        return "".equals(str.trim());
    }
}

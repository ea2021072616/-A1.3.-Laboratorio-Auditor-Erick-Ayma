package com.fotoable.youtube.music.helper.localmusic;

import com.fotoable.youtube.music.bean.LocalSongBean;
import java.util.Comparator;
/* compiled from: MusicComparator.java */
/* loaded from: classes.dex */
public class k implements Comparator<LocalSongBean> {
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(LocalSongBean localSongBean, LocalSongBean localSongBean2) {
        String str = localSongBean.sort;
        String str2 = localSongBean2.sort;
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

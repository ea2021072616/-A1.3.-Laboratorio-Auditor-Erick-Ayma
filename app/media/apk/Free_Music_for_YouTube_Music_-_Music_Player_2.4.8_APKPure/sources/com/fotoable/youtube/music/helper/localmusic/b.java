package com.fotoable.youtube.music.helper.localmusic;

import android.text.TextUtils;
import com.fotoable.youtube.music.bean.LocalArtistsBean;
import java.util.Comparator;
/* compiled from: ArtistsComparator.java */
/* loaded from: classes.dex */
public class b implements Comparator<LocalArtistsBean> {
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(LocalArtistsBean localArtistsBean, LocalArtistsBean localArtistsBean2) {
        String str = localArtistsBean.artist_sort;
        String str2 = localArtistsBean2.artist_sort;
        if (TextUtils.equals("<unknown>", localArtistsBean.artist_name != null ? localArtistsBean.artist_name.toLowerCase() : localArtistsBean.artist_name)) {
            return 1;
        }
        if (TextUtils.equals("<unknown>", localArtistsBean2.artist_name != null ? localArtistsBean2.artist_name.toLowerCase() : localArtistsBean2.artist_name)) {
            return -1;
        }
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

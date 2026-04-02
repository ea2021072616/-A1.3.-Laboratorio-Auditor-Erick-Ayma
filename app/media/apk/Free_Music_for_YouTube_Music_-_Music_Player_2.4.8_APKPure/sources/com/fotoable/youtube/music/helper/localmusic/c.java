package com.fotoable.youtube.music.helper.localmusic;

import com.fotoable.youtube.music.bean.LocalArtistsBean;
import java.util.Comparator;
/* compiled from: ArtistsCountComparator.java */
/* loaded from: classes.dex */
public class c implements Comparator<LocalArtistsBean> {
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(LocalArtistsBean localArtistsBean, LocalArtistsBean localArtistsBean2) {
        int i = localArtistsBean.number_of_tracks;
        int i2 = localArtistsBean2.number_of_tracks;
        if (i >= 0 || i2 >= 0) {
            return i2 - i;
        }
        return 0;
    }
}

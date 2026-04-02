package com.fotoable.youtube.music.newplayer.a;

import com.fotoable.youtube.music.bean.LocalSongBean;
import com.fotoable.youtube.music.newplayer.model.LocalMusicModel;
import java.util.ArrayList;
import java.util.List;
/* compiled from: LocalMusicConvert.java */
/* loaded from: classes.dex */
public class a {
    public static List<LocalMusicModel> a(List<LocalSongBean> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return arrayList;
            }
            LocalMusicModel a2 = a(list.get(i2));
            if (a2 != null) {
                arrayList.add(a2);
            }
            i = i2 + 1;
        }
    }

    public static LocalMusicModel a(LocalSongBean localSongBean) {
        if (localSongBean == null) {
            return null;
        }
        LocalMusicModel localMusicModel = new LocalMusicModel();
        localMusicModel.setAlbumData(localSongBean.getAlbumData());
        localMusicModel.setAlbumId(localSongBean.getAlbumId());
        localMusicModel.setAlbumName(localSongBean.getAlbumName());
        localMusicModel.setArtistId(localSongBean.getArtistId());
        localMusicModel.setArtistName(localSongBean.getArtistName());
        localMusicModel.setData(localSongBean.getData());
        localMusicModel.setDuration(localSongBean.getDuration());
        localMusicModel.setFolder(localSongBean.getFolder());
        localMusicModel.setLrc(localSongBean.getLrc());
        localMusicModel.setIslocal(localSongBean.getIslocal().booleanValue());
        localMusicModel.setSongId(localSongBean.getSongId().longValue());
        localMusicModel.setSongName(localSongBean.getSongName());
        localMusicModel.setSize(localSongBean.getSize());
        return localMusicModel;
    }

    public static LocalSongBean a(LocalMusicModel localMusicModel) {
        if (localMusicModel == null) {
            return null;
        }
        LocalSongBean localSongBean = new LocalSongBean();
        localSongBean.setAlbumData(localMusicModel.getAlbumData());
        localSongBean.setAlbumId(localMusicModel.getAlbumId());
        localSongBean.setAlbumName(localMusicModel.getAlbumName());
        localSongBean.setArtistId(localMusicModel.getArtistId());
        localSongBean.setArtistName(localMusicModel.getArtistName());
        localSongBean.setData(localMusicModel.getData());
        localSongBean.setDuration(localMusicModel.getDuration());
        localSongBean.setFolder(localMusicModel.getFolder());
        localSongBean.setLrc(localMusicModel.getLrc());
        localSongBean.setIslocal(Boolean.valueOf(localMusicModel.islocal()));
        localSongBean.setSongId(Long.valueOf(localMusicModel.getSongId()));
        localSongBean.setSongName(localMusicModel.getSongName());
        localSongBean.setSize(localMusicModel.getSize());
        return localSongBean;
    }
}

package com.fotoable.youtube.music.newplayer.a;

import android.text.TextUtils;
import com.fotoable.youtube.music.bean.ClassifiedRankVideoBean;
import com.fotoable.youtube.music.bean.FavBean;
import com.fotoable.youtube.music.bean.FeaturedDetailBean;
import com.fotoable.youtube.music.bean.GlobalRankVideoBean;
import com.fotoable.youtube.music.bean.HomeListNewBean;
import com.fotoable.youtube.music.bean.PlayListDetailBean;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.bean.RecentlyWatchBean;
import com.fotoable.youtube.music.bean.SearchItemBean;
import com.fotoable.youtube.music.util.h;
import java.util.ArrayList;
import java.util.List;
/* compiled from: PlayModelConverter.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2847a = b.class.getSimpleName();

    public static List<PlayMusicModel> a(ArrayList<FavBean> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return arrayList2;
            }
            FavBean favBean = arrayList.get(i2);
            if (favBean != null && !TextUtils.isEmpty(favBean.getVideoid())) {
                PlayMusicModel playMusicModel = new PlayMusicModel();
                playMusicModel.setTitle(favBean.getTitle());
                playMusicModel.setVideoId(favBean.getVideoid());
                playMusicModel.setDescription(favBean.getDesc());
                playMusicModel.setCoverImg(favBean.getImgUrl());
                playMusicModel.setDuration(favBean.getDuration());
                playMusicModel.setArtists(favBean.getArtists());
                arrayList2.add(playMusicModel);
            }
            i = i2 + 1;
        }
    }

    public static PlayMusicModel a(FavBean favBean) {
        if (favBean == null || TextUtils.isEmpty(favBean.getVideoid())) {
            return null;
        }
        PlayMusicModel playMusicModel = new PlayMusicModel();
        playMusicModel.setTitle(favBean.getTitle());
        playMusicModel.setVideoId(favBean.getVideoid());
        playMusicModel.setDescription(favBean.getDesc());
        playMusicModel.setCoverImg(favBean.getImgUrl());
        playMusicModel.setDuration(favBean.getDuration());
        playMusicModel.setArtists(favBean.getArtists());
        return playMusicModel;
    }

    public static ArrayList<PlayMusicModel> a(List<SearchItemBean> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList<PlayMusicModel> arrayList = new ArrayList<>(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return arrayList;
            }
            PlayMusicModel a2 = a(list.get(i2));
            if (a2 != null) {
                arrayList.add(a2);
            }
            i = i2 + 1;
        }
    }

    public static PlayMusicModel a(SearchItemBean searchItemBean) {
        if (searchItemBean == null) {
            return null;
        }
        PlayMusicModel playMusicModel = new PlayMusicModel();
        if (searchItemBean.getSnippet().getThumbnails() != null && searchItemBean.getSnippet().getThumbnails().getMedium() != null) {
            playMusicModel.setCoverImg(searchItemBean.getSnippet().getThumbnails().getMedium().getUrl());
        }
        playMusicModel.setVideoId(searchItemBean.getId().getVideoId());
        playMusicModel.setTitle(searchItemBean.getSnippet().getTitle());
        playMusicModel.setDescription(searchItemBean.getSnippet().getDescription());
        playMusicModel.setDuration(searchItemBean.getSnippet().getDuration());
        return playMusicModel;
    }

    public static ArrayList<PlayMusicModel> b(List<HomeListNewBean> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList<PlayMusicModel> arrayList = new ArrayList<>(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return arrayList;
            }
            PlayMusicModel a2 = a(list.get(i2));
            if (a2 != null) {
                arrayList.add(a2);
            }
            i = i2 + 1;
        }
    }

    public static PlayMusicModel a(HomeListNewBean homeListNewBean) {
        if (homeListNewBean == null || TextUtils.isEmpty(homeListNewBean.getVideoid())) {
            return null;
        }
        PlayMusicModel playMusicModel = new PlayMusicModel();
        playMusicModel.setCoverImg(homeListNewBean.getImgUrl());
        playMusicModel.setVideoId(homeListNewBean.getVideoid());
        playMusicModel.setTitle(homeListNewBean.getTitle());
        playMusicModel.setDescription(homeListNewBean.getDescription());
        playMusicModel.setDuration(homeListNewBean.getDuration());
        playMusicModel.setArtists(homeListNewBean.getArtists());
        return playMusicModel;
    }

    public static ArrayList<PlayMusicModel> c(List<RecentlyWatchBean> list) {
        if (list == null || list.size() == 0 || list == null || list.size() == 0) {
            return null;
        }
        ArrayList<PlayMusicModel> arrayList = new ArrayList<>(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return arrayList;
            }
            PlayMusicModel a2 = a(list.get(i2));
            if (a2 != null) {
                arrayList.add(a2);
            }
            i = i2 + 1;
        }
    }

    public static PlayMusicModel a(RecentlyWatchBean recentlyWatchBean) {
        if (recentlyWatchBean == null || TextUtils.isEmpty(recentlyWatchBean.getVideoid())) {
            return null;
        }
        PlayMusicModel playMusicModel = new PlayMusicModel();
        playMusicModel.setTitle(recentlyWatchBean.getTitle());
        playMusicModel.setVideoId(recentlyWatchBean.getVideoid());
        playMusicModel.setDescription(recentlyWatchBean.getDesc());
        playMusicModel.setCoverImg(recentlyWatchBean.getImgUrl());
        playMusicModel.setDuration(recentlyWatchBean.getDuration());
        playMusicModel.setArtists(recentlyWatchBean.getArtists());
        return playMusicModel;
    }

    public static PlayMusicModel a(PlayListDetailBean.ItemsEntity.SnippetEntity snippetEntity) {
        if (snippetEntity == null || snippetEntity.getResourceId() == null || TextUtils.isEmpty(snippetEntity.getResourceId().getVideoId())) {
            h.a(f2847a, "SnippetEntity VideoId 为空");
            return null;
        }
        PlayMusicModel playMusicModel = new PlayMusicModel();
        String str = "";
        if (snippetEntity.getThumbnails() != null) {
            if (snippetEntity.getThumbnails().getMedium() != null) {
                str = snippetEntity.getThumbnails().getMedium().getUrl();
            } else if (snippetEntity.getThumbnails().getDefaultX() != null) {
                str = snippetEntity.getThumbnails().getDefaultX().getUrl();
            }
        }
        playMusicModel.setCoverImg(str + "");
        playMusicModel.setVideoId(snippetEntity.getResourceId().getVideoId());
        playMusicModel.setTitle(snippetEntity.getTitle() + "");
        playMusicModel.setDescription(snippetEntity.getDescription() + "");
        playMusicModel.setDuration(snippetEntity.getDuration() + "");
        return playMusicModel;
    }

    public static ArrayList<PlayMusicModel> d(List<PlayListDetailBean.ItemsEntity> list) {
        ArrayList<PlayMusicModel> arrayList = new ArrayList<>();
        for (PlayListDetailBean.ItemsEntity itemsEntity : list) {
            PlayMusicModel playMusicModel = new PlayMusicModel();
            String str = "";
            if (itemsEntity.getSnippet().getThumbnails() != null) {
                if (itemsEntity.getSnippet().getThumbnails().getMedium() != null) {
                    str = itemsEntity.getSnippet().getThumbnails().getMedium().getUrl();
                } else if (itemsEntity.getSnippet().getThumbnails().getDefaultX() != null) {
                    str = itemsEntity.getSnippet().getThumbnails().getDefaultX().getUrl();
                }
            }
            playMusicModel.setCoverImg(str);
            playMusicModel.setVideoId(itemsEntity.getContentDetails().getVideoId());
            playMusicModel.setTitle(itemsEntity.getSnippet().getTitle());
            playMusicModel.setDescription(itemsEntity.getSnippet().getDescription());
            arrayList.add(playMusicModel);
        }
        return arrayList;
    }

    public static PlayMusicModel a(GlobalRankVideoBean globalRankVideoBean) {
        if (globalRankVideoBean == null || TextUtils.isEmpty(globalRankVideoBean.getVideoid())) {
            return null;
        }
        PlayMusicModel playMusicModel = new PlayMusicModel();
        playMusicModel.setCoverImg(globalRankVideoBean.getImgUrl());
        playMusicModel.setVideoId(globalRankVideoBean.getVideoid());
        playMusicModel.setTitle(globalRankVideoBean.getTitle());
        playMusicModel.setDescription(globalRankVideoBean.getDesc());
        playMusicModel.setDuration(globalRankVideoBean.getDuration());
        playMusicModel.setArtists(globalRankVideoBean.getArtists());
        return playMusicModel;
    }

    public static ArrayList<PlayMusicModel> e(List<GlobalRankVideoBean> list) {
        ArrayList<PlayMusicModel> arrayList = new ArrayList<>();
        for (GlobalRankVideoBean globalRankVideoBean : list) {
            PlayMusicModel playMusicModel = new PlayMusicModel();
            playMusicModel.setCoverImg(globalRankVideoBean.getImgUrl());
            playMusicModel.setVideoId(globalRankVideoBean.getVideoid());
            playMusicModel.setTitle(globalRankVideoBean.getTitle());
            playMusicModel.setDescription(globalRankVideoBean.getDesc());
            playMusicModel.setDuration(globalRankVideoBean.getDuration());
            playMusicModel.setFav(globalRankVideoBean.getIsFav() == 1);
            playMusicModel.setArtists(globalRankVideoBean.getArtists());
            arrayList.add(playMusicModel);
        }
        return arrayList;
    }

    public static PlayMusicModel a(ClassifiedRankVideoBean classifiedRankVideoBean) {
        if (classifiedRankVideoBean == null || TextUtils.isEmpty(classifiedRankVideoBean.getVideoid())) {
            return null;
        }
        PlayMusicModel playMusicModel = new PlayMusicModel();
        playMusicModel.setCoverImg(classifiedRankVideoBean.getImgUrl());
        playMusicModel.setVideoId(classifiedRankVideoBean.getVideoid());
        playMusicModel.setTitle(classifiedRankVideoBean.getTitle());
        playMusicModel.setDescription(classifiedRankVideoBean.getDesc());
        playMusicModel.setDuration(classifiedRankVideoBean.getDuration());
        playMusicModel.setArtists(classifiedRankVideoBean.getArtists());
        return playMusicModel;
    }

    public static ArrayList<PlayMusicModel> f(List<ClassifiedRankVideoBean> list) {
        ArrayList<PlayMusicModel> arrayList = new ArrayList<>();
        for (ClassifiedRankVideoBean classifiedRankVideoBean : list) {
            PlayMusicModel playMusicModel = new PlayMusicModel();
            playMusicModel.setCoverImg(classifiedRankVideoBean.getImgUrl());
            playMusicModel.setVideoId(classifiedRankVideoBean.getVideoid());
            playMusicModel.setTitle(classifiedRankVideoBean.getTitle());
            playMusicModel.setDescription(classifiedRankVideoBean.getDesc());
            playMusicModel.setDuration(classifiedRankVideoBean.getDuration());
            playMusicModel.setFav(classifiedRankVideoBean.getIsFav() == 1);
            playMusicModel.setArtists(classifiedRankVideoBean.getArtists());
            arrayList.add(playMusicModel);
        }
        return arrayList;
    }

    public static ArrayList<PlayMusicModel> g(List<FeaturedDetailBean> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList<PlayMusicModel> arrayList = new ArrayList<>();
        for (FeaturedDetailBean featuredDetailBean : list) {
            PlayMusicModel playMusicModel = new PlayMusicModel();
            playMusicModel.setCoverImg(featuredDetailBean.getImgUrl());
            playMusicModel.setVideoId(featuredDetailBean.getVideoid());
            playMusicModel.setTitle(featuredDetailBean.getTitle());
            playMusicModel.setDescription(featuredDetailBean.getDescription());
            playMusicModel.setFav(featuredDetailBean.getIsFav() == 1);
            arrayList.add(playMusicModel);
        }
        return arrayList;
    }

    public static PlayMusicModel a(FeaturedDetailBean featuredDetailBean) {
        if (featuredDetailBean == null || featuredDetailBean.getVideoid() == null) {
            return null;
        }
        PlayMusicModel playMusicModel = new PlayMusicModel();
        playMusicModel.setCoverImg(featuredDetailBean.getImgUrl());
        playMusicModel.setVideoId(featuredDetailBean.getVideoid());
        playMusicModel.setTitle(featuredDetailBean.getTitle());
        playMusicModel.setDescription(featuredDetailBean.getDescription());
        playMusicModel.setFav(featuredDetailBean.getIsFav() == 1);
        return playMusicModel;
    }
}

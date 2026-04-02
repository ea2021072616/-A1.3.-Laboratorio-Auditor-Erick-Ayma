package com.fotoable.youtube.music.c.a;

import com.fotoable.youtube.music.c.b.z;
import com.fotoable.youtube.music.ui.fragment.ArtistsFragment;
import com.fotoable.youtube.music.ui.fragment.CategoryPlaylistFragment;
import com.fotoable.youtube.music.ui.fragment.ChartsFragment;
import com.fotoable.youtube.music.ui.fragment.ClassifiedMusicFragment;
import com.fotoable.youtube.music.ui.fragment.CommunityFragment;
import com.fotoable.youtube.music.ui.fragment.DiscoverFragment;
import com.fotoable.youtube.music.ui.fragment.FeaturedFragment;
import com.fotoable.youtube.music.ui.fragment.GenresFragment;
import com.fotoable.youtube.music.ui.fragment.GlobalMusicFragment;
import com.fotoable.youtube.music.ui.fragment.LocalArtistsFragment;
import com.fotoable.youtube.music.ui.fragment.LocalFavoriteFragment;
import com.fotoable.youtube.music.ui.fragment.LocalMusicFragment;
import com.fotoable.youtube.music.ui.fragment.LocalPlayListFragment;
import com.fotoable.youtube.music.ui.fragment.LocalSongsFragment;
import com.fotoable.youtube.music.ui.fragment.MyMusicFragment;
import com.fotoable.youtube.music.ui.fragment.PlayListFragment;
import com.fotoable.youtube.music.ui.fragment.RadioFavoriteFragment;
import com.fotoable.youtube.music.ui.fragment.RadioFragment;
import com.fotoable.youtube.music.ui.fragment.RadioHistoryFragment;
import com.fotoable.youtube.music.ui.fragment.RankFragment;
import com.fotoable.youtube.music.ui.fragment.SearchAlbumsFragment;
import com.fotoable.youtube.music.ui.fragment.SearchArtistsFragment;
import com.fotoable.youtube.music.ui.fragment.SearchPlayListFragment;
import com.fotoable.youtube.music.ui.fragment.SearchSongsFragment;
import com.fotoable.youtube.music.ui.fragment.Top100Fragment;
import dagger.Component;
/* compiled from: FragmentComponent.java */
@Component(dependencies = {b.class}, modules = {z.class})
/* loaded from: classes.dex */
public interface j {
    void a(ArtistsFragment artistsFragment);

    void a(CategoryPlaylistFragment categoryPlaylistFragment);

    void a(ChartsFragment chartsFragment);

    void a(ClassifiedMusicFragment classifiedMusicFragment);

    void a(CommunityFragment communityFragment);

    void a(DiscoverFragment discoverFragment);

    void a(FeaturedFragment featuredFragment);

    void a(GenresFragment genresFragment);

    void a(GlobalMusicFragment globalMusicFragment);

    void a(LocalArtistsFragment localArtistsFragment);

    void a(LocalFavoriteFragment localFavoriteFragment);

    void a(LocalMusicFragment localMusicFragment);

    void a(LocalPlayListFragment localPlayListFragment);

    void a(LocalSongsFragment localSongsFragment);

    void a(MyMusicFragment myMusicFragment);

    void a(PlayListFragment playListFragment);

    void a(RadioFavoriteFragment radioFavoriteFragment);

    void a(RadioFragment radioFragment);

    void a(RadioHistoryFragment radioHistoryFragment);

    void a(RankFragment rankFragment);

    void a(SearchAlbumsFragment searchAlbumsFragment);

    void a(SearchArtistsFragment searchArtistsFragment);

    void a(SearchPlayListFragment searchPlayListFragment);

    void a(SearchSongsFragment searchSongsFragment);

    void a(Top100Fragment top100Fragment);
}

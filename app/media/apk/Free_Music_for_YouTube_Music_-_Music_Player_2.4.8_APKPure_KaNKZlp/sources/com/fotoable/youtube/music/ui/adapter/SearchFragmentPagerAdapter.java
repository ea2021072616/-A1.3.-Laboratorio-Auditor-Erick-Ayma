package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.fragment.SearchPlayListFragment;
import com.fotoable.youtube.music.ui.fragment.SearchSongsFragment;
/* loaded from: classes.dex */
public class SearchFragmentPagerAdapter extends FragmentPagerAdapter {
    private boolean isSelectedMusic;
    private String keyWord;
    private Context mContext;
    private int[] titles;

    public SearchFragmentPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        this.titles = new int[]{R.string.songs2, R.string.playlists};
        this.isSelectedMusic = false;
        this.mContext = context;
        this.keyWord = this.keyWord;
    }

    public void setSelectedMusic(boolean z) {
        this.isSelectedMusic = z;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return SearchSongsFragment.a(1, this.isSelectedMusic);
            case 1:
                return SearchPlayListFragment.a(1);
            default:
                return SearchSongsFragment.a(1, this.isSelectedMusic);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.isSelectedMusic ? 1 : 2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.mContext.getResources().getString(this.titles[i]);
    }
}

package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.fragment.SearchPlayListFragment;
import com.fotoable.youtube.music.ui.fragment.SearchSongsFragment;
/* loaded from: classes.dex */
public class ArtistDetailFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private int source;

    public ArtistDetailFragmentPagerAdapter(FragmentManager fragmentManager, Context context, int i) {
        super(fragmentManager);
        this.mContext = context;
        this.source = i;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return SearchSongsFragment.a(this.source, false);
            case 1:
                return SearchPlayListFragment.a(this.source);
            default:
                return SearchSongsFragment.a(this.source, false);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return i == 0 ? this.mContext.getResources().getString(R.string.songs2) : this.mContext.getResources().getString(R.string.playlists);
    }
}

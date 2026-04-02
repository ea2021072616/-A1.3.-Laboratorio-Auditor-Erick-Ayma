package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.fragment.RadioFavoriteFragment;
import com.fotoable.youtube.music.ui.fragment.RadioHistoryFragment;
/* loaded from: classes.dex */
public class RadioFragmentPagerAdapter extends FragmentPagerAdapter {
    private String keyWord;
    private Context mContext;
    private int[] titles;

    public RadioFragmentPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        this.titles = new int[]{R.string.favorites, R.string.history};
        this.mContext = context;
        this.keyWord = this.keyWord;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return RadioFavoriteFragment.i();
            case 1:
                return RadioHistoryFragment.i();
            default:
                return RadioFavoriteFragment.i();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.mContext.getResources().getString(this.titles[i]);
    }
}

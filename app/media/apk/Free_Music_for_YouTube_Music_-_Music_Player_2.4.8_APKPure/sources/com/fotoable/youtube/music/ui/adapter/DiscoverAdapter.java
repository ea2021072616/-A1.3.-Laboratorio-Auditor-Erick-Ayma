package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.i;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.List;
/* loaded from: classes.dex */
public class DiscoverAdapter extends FragmentPagerAdapter {
    private Context context;
    private List<i> fragmentList;

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (i == 0) {
            return this.context.getResources().getString(R.string.artists);
        }
        if (i == 1) {
            return this.context.getResources().getString(R.string.genres);
        }
        return super.getPageTitle(i);
    }

    public DiscoverAdapter(FragmentManager fragmentManager, List<i> list, Context context) {
        super(fragmentManager);
        this.fragmentList = list;
        this.context = context;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.fragmentList != null) {
            return this.fragmentList.get(i);
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.fragmentList != null) {
            return this.fragmentList.size();
        }
        return 0;
    }

    public void destroy() {
        try {
            if (this.fragmentList != null) {
                this.fragmentList.clear();
                this.fragmentList = null;
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }
}

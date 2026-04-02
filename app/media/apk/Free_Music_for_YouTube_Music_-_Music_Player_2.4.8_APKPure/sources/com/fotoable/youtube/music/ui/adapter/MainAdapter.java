package com.fotoable.youtube.music.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.fotoable.youtube.music.base.i;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.List;
/* loaded from: classes.dex */
public class MainAdapter extends FragmentPagerAdapter {
    private List<i> fragmentList;

    public MainAdapter(FragmentManager fragmentManager, List<i> list) {
        super(fragmentManager);
        this.fragmentList = list;
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

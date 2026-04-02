package com.flyco.tablayout.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FragmentChangeManager {
    private int mContainerViewId;
    private int mCurrentTab;
    private FragmentManager mFragmentManager;
    private ArrayList<Fragment> mFragments;

    public FragmentChangeManager(FragmentManager fragmentManager, int i, ArrayList<Fragment> arrayList) {
        this.mFragmentManager = fragmentManager;
        this.mContainerViewId = i;
        this.mFragments = arrayList;
        initFragments();
    }

    private void initFragments() {
        Iterator<Fragment> it = this.mFragments.iterator();
        while (it.hasNext()) {
            Fragment next = it.next();
            this.mFragmentManager.beginTransaction().add(this.mContainerViewId, next).hide(next).commit();
        }
        setFragments(0);
    }

    public void setFragments(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mFragments.size()) {
                FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
                Fragment fragment = this.mFragments.get(i3);
                if (i3 == i) {
                    beginTransaction.show(fragment);
                } else {
                    beginTransaction.hide(fragment);
                }
                beginTransaction.commit();
                i2 = i3 + 1;
            } else {
                this.mCurrentTab = i;
                return;
            }
        }
    }

    public int getCurrentTab() {
        return this.mCurrentTab;
    }

    public Fragment getCurrentFragment() {
        return this.mFragments.get(this.mCurrentTab);
    }
}

package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public abstract class b1 extends androidx.viewpager.widget.a {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentPagerAdapter";
    private boolean mExecutingFinishUpdate;
    private final w0 mFragmentManager;
    private g1 mCurTransaction = null;
    private Fragment mCurrentPrimaryItem = null;
    private final int mBehavior = 1;

    public b1(w0 w0Var) {
        this.mFragmentManager = w0Var;
    }

    @Override // androidx.viewpager.widget.a
    public void destroyItem(ViewGroup viewGroup, int i5, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.mCurTransaction == null) {
            w0 w0Var = this.mFragmentManager;
            w0Var.getClass();
            this.mCurTransaction = new a(w0Var);
        }
        a aVar = (a) this.mCurTransaction;
        aVar.getClass();
        w0 w0Var2 = fragment.mFragmentManager;
        if (w0Var2 != null && w0Var2 != aVar.f818q) {
            throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        aVar.b(new f1(fragment, 6));
        if (fragment.equals(this.mCurrentPrimaryItem)) {
            this.mCurrentPrimaryItem = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void finishUpdate(ViewGroup viewGroup) {
        g1 g1Var = this.mCurTransaction;
        if (g1Var != null) {
            if (!this.mExecutingFinishUpdate) {
                try {
                    this.mExecutingFinishUpdate = true;
                    a aVar = (a) g1Var;
                    if (aVar.f900g) {
                        throw new IllegalStateException("This transaction is already being added to the back stack");
                    }
                    aVar.f901h = false;
                    aVar.f818q.y(aVar, true);
                } finally {
                    this.mExecutingFinishUpdate = false;
                }
            }
            this.mCurTransaction = null;
        }
    }

    public abstract Fragment getItem(int i5);

    public long getItemId(int i5) {
        return i5;
    }

    @Override // androidx.viewpager.widget.a
    public Object instantiateItem(ViewGroup viewGroup, int i5) {
        if (this.mCurTransaction == null) {
            w0 w0Var = this.mFragmentManager;
            w0Var.getClass();
            this.mCurTransaction = new a(w0Var);
        }
        long itemId = getItemId(i5);
        int id = viewGroup.getId();
        Fragment C = this.mFragmentManager.C("android:switcher:" + id + ":" + itemId);
        if (C != null) {
            g1 g1Var = this.mCurTransaction;
            g1Var.getClass();
            g1Var.b(new f1(C, 7));
        } else {
            C = getItem(i5);
            g1 g1Var2 = this.mCurTransaction;
            int id2 = viewGroup.getId();
            int id3 = viewGroup.getId();
            g1Var2.c(id2, C, "android:switcher:" + id3 + ":" + itemId, 1);
        }
        if (C != this.mCurrentPrimaryItem) {
            C.setMenuVisibility(false);
            if (this.mBehavior == 1) {
                this.mCurTransaction.d(C, androidx.lifecycle.n.STARTED);
            } else {
                C.setUserVisibleHint(false);
            }
        }
        return C;
    }

    @Override // androidx.viewpager.widget.a
    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.a
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // androidx.viewpager.widget.a
    public Parcelable saveState() {
        return null;
    }

    @Override // androidx.viewpager.widget.a
    public void setPrimaryItem(ViewGroup viewGroup, int i5, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.mCurrentPrimaryItem;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.mBehavior == 1) {
                    if (this.mCurTransaction == null) {
                        w0 w0Var = this.mFragmentManager;
                        w0Var.getClass();
                        this.mCurTransaction = new a(w0Var);
                    }
                    this.mCurTransaction.d(this.mCurrentPrimaryItem, androidx.lifecycle.n.STARTED);
                } else {
                    this.mCurrentPrimaryItem.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.mBehavior == 1) {
                if (this.mCurTransaction == null) {
                    w0 w0Var2 = this.mFragmentManager;
                    w0Var2.getClass();
                    this.mCurTransaction = new a(w0Var2);
                }
                this.mCurTransaction.d(fragment, androidx.lifecycle.n.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.mCurrentPrimaryItem = fragment;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }
}

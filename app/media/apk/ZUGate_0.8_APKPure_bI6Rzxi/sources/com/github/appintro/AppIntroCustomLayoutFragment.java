package com.github.appintro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import e4.e;
import j4.d;
/* loaded from: classes.dex */
public final class AppIntroCustomLayoutFragment extends Fragment {
    private static final String ARG_LAYOUT_RES_ID = "layoutResId";
    public static final Companion Companion = new Companion(null);
    private int layoutResId;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(d dVar) {
            this();
        }

        public final AppIntroCustomLayoutFragment newInstance(int i5) {
            AppIntroCustomLayoutFragment appIntroCustomLayoutFragment = new AppIntroCustomLayoutFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(AppIntroCustomLayoutFragment.ARG_LAYOUT_RES_ID, i5);
            appIntroCustomLayoutFragment.setArguments(bundle);
            return appIntroCustomLayoutFragment;
        }
    }

    public static final AppIntroCustomLayoutFragment newInstance(int i5) {
        return Companion.newInstance(i5);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.layoutResId = arguments != null ? arguments.getInt(ARG_LAYOUT_RES_ID) : 0;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        e.f(layoutInflater, "inflater");
        return layoutInflater.inflate(this.layoutResId, viewGroup, false);
    }
}

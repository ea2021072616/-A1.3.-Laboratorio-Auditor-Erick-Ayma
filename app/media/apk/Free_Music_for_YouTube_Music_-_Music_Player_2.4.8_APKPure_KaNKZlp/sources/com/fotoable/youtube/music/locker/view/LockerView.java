package com.fotoable.youtube.music.locker.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.service.MainService;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class LockerView extends RelativeLayout {
    @BindView(R.id.locker_vertical_view_pager)
    VerticalViewPager verticalViewPager;

    public LockerView(Context context) {
        super(context);
        a(context);
    }

    public LockerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LockerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void a(Context context) {
        inflate(context, R.layout.view_locker, this);
        ButterKnife.bind(this);
        this.verticalViewPager.setOverScrollMode(2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MusicLockerView(context));
        arrayList.add(new EmptyView(context));
        a aVar = new a(arrayList);
        this.verticalViewPager.setAdapter(aVar);
        this.verticalViewPager.setOnPageChangeListener(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends PagerAdapter implements ViewPager.OnPageChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private List<View> f2778b;

        public a(List<View> list) {
            this.f2778b = list;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (this.f2778b == null) {
                return 0;
            }
            return this.f2778b.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.f2778b.get(i);
            viewGroup.addView(view);
            return view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.f2778b.get(i));
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            switch (i) {
                case 0:
                default:
                    return;
                case 1:
                    MainService.a(LockerView.this.getContext(), "open_app", ShareConstants.FEED_SOURCE_PARAM, "music_locker");
                    LockerView.this.postDelayed(new Runnable() { // from class: com.fotoable.youtube.music.locker.view.LockerView.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.fotoable.youtube.music.locker.a.a().a(LockerView.this.getContext());
                        }
                    }, 500L);
                    return;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    }
}

package com.fotoable.youtube.music.ui.adapter.holder;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.ActivityChooserView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import com.fotoable.free.music.R;
import java.util.List;
/* loaded from: classes.dex */
public class BannersHolder extends AbsHomeItemHolder {
    Context context;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    public BannersHolder(View view) {
        super(view);
        this.context = view.getContext();
    }

    public void bindData(List<Integer> list) {
        this.viewPager.setAdapter(new BannerPageAdapter(this.context, list));
        this.viewPager.setCurrentItem(1000, false);
    }

    @Override // com.fotoable.youtube.music.ui.adapter.holder.AbsHomeItemHolder
    public void onDestory() {
        super.onDestory();
        this.context = null;
    }

    /* loaded from: classes.dex */
    private static class BannerPageAdapter extends PagerAdapter {
        private List<Integer> bannerList;
        private Context context;

        public BannerPageAdapter(Context context, List<Integer> list) {
            this.context = context;
            this.bannerList = list;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View inflate = View.inflate(this.context, R.layout.view_home_banner_item, null);
            ((ImageView) inflate.findViewById(R.id.cover_iv)).setImageResource(this.bannerList.get(i % this.bannerList.size()).intValue());
            viewGroup.addView(inflate);
            return inflate;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }
    }
}

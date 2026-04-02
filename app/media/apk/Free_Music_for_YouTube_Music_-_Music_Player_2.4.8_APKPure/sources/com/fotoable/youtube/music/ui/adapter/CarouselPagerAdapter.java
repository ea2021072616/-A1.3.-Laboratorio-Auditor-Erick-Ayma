package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.ActivityChooserView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.i;
import com.facebook.ads.AdError;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.CarouselBean;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.e.a;
import com.fotoable.youtube.music.e.b;
import com.fotoable.youtube.music.ui.activity.ArtistsDetailActivity;
import com.fotoable.youtube.music.ui.activity.PlayListDetailsActivity;
import com.fotoable.youtube.music.util.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class CarouselPagerAdapter extends PagerAdapter {
    private static final String TAG = CarouselPagerAdapter.class.getSimpleName();
    private List<CarouselBean> data;
    private Context mContext;
    private LayoutInflater mInflater;
    private int[] tagViews = {R.drawable.icon_banner_songs, R.drawable.icon_banner_playlists, R.drawable.icon_banner_artists};

    public CarouselPagerAdapter(Context context, List<CarouselBean> list) {
        this.mContext = context;
        this.data = list;
        this.mInflater = LayoutInflater.from(context);
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
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        CarouselBean carouselBean = this.data.get(i % this.data.size());
        View inflate = this.mInflater.inflate(R.layout.view_holder_carousel, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.adapter_carousel_cover_img);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.iv_tag);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = (int) (w.b(this.mContext) * 0.4167d);
        imageView.setLayoutParams(layoutParams);
        i.c(this.mContext).a(carouselBean.getImgUrl()).a(imageView);
        if (carouselBean.getType() > 0 && carouselBean.getType() <= 3) {
            i.c(this.mContext).a(Integer.valueOf(this.tagViews[carouselBean.getType() - 1])).a(imageView2);
        }
        viewGroup.addView(inflate);
        checkType(inflate, carouselBean);
        return inflate;
    }

    private void checkType(View view, final CarouselBean carouselBean) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.CarouselPagerAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Intent intent = new Intent();
                switch (carouselBean.getType()) {
                    case 1:
                        PlayMusicModel playMusicModel = new PlayMusicModel();
                        playMusicModel.setVideoId(carouselBean.getPublicFields());
                        playMusicModel.setTitle(carouselBean.getTitle());
                        playMusicModel.setDuration(carouselBean.getDuration());
                        playMusicModel.setDescription(carouselBean.getDesc());
                        playMusicModel.setCoverImg(carouselBean.getVideoImgUrl());
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(playMusicModel);
                        b.a().a(new a((int) AdError.INTERNAL_ERROR_CODE, arrayList, 0));
                        com.fotoable.youtube.music.util.b.b("焦点图-点击", "焦点图描述", carouselBean.getDesc() + "");
                        com.fotoable.youtube.music.util.b.a("焦点图-点击", "焦点图描述", "" + carouselBean.getDesc() + "");
                        return;
                    case 2:
                        intent.setClass(CarouselPagerAdapter.this.mContext, PlayListDetailsActivity.class);
                        intent.putExtra("PlaylistId", carouselBean.getPublicFields());
                        intent.putExtra("ImgUrl", carouselBean.getThumbUrl());
                        intent.putExtra("Title", carouselBean.getTitle());
                        CarouselPagerAdapter.this.mContext.startActivity(intent);
                        com.fotoable.youtube.music.util.b.b("焦点图-点击", "焦点图描述", carouselBean.getDesc() + "");
                        com.fotoable.youtube.music.util.b.a("焦点图-点击", "焦点图描述", "" + carouselBean.getDesc() + "");
                        return;
                    case 3:
                        intent.setClass(CarouselPagerAdapter.this.mContext, ArtistsDetailActivity.class);
                        intent.putExtra(ShareConstants.TITLE, carouselBean.getPublicFields());
                        intent.putExtra("ImgURL", carouselBean.getThumbUrl());
                        CarouselPagerAdapter.this.mContext.startActivity(intent);
                        com.fotoable.youtube.music.util.b.b("焦点图-点击", "焦点图描述", carouselBean.getDesc() + "");
                        com.fotoable.youtube.music.util.b.a("焦点图-点击", "焦点图描述", "" + carouselBean.getDesc() + "");
                        return;
                    default:
                        return;
                }
            }
        });
    }
}

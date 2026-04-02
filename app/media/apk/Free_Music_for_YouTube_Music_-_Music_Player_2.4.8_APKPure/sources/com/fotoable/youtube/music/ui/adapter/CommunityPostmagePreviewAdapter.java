package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.i;
import com.bumptech.glide.load.b.b;
import com.yanzhenjie.album.widget.photoview.AttacherImageView;
import com.yanzhenjie.album.widget.photoview.PhotoViewAttacher;
import java.util.List;
/* loaded from: classes.dex */
public class CommunityPostmagePreviewAdapter extends PagerAdapter {
    private Context context;
    private List<String> imageList;

    public CommunityPostmagePreviewAdapter(Context context, List<String> list) {
        this.context = context;
        this.imageList = list;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.imageList == null) {
            return 0;
        }
        return this.imageList.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        AttacherImageView attacherImageView = new AttacherImageView(this.context);
        attacherImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        attacherImageView.setAttacher(new PhotoViewAttacher(attacherImageView));
        i.c(this.context).a(this.imageList.get(i)).b(b.ALL).a(attacherImageView);
        viewGroup.addView(attacherImageView);
        return attacherImageView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }
}

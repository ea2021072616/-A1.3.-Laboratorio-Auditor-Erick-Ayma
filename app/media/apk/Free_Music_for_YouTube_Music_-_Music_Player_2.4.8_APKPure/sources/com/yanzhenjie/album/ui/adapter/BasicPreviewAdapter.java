package com.yanzhenjie.album.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.yanzhenjie.album.widget.photoview.AttacherImageView;
import com.yanzhenjie.album.widget.photoview.PhotoViewAttacher;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class BasicPreviewAdapter<T> extends PagerAdapter {
    private Context mContext;
    private List<T> mPreviewList;

    protected abstract boolean loadPreview(ImageView imageView, T t, int i);

    public BasicPreviewAdapter(Context context, List<T> list) {
        this.mContext = context;
        this.mPreviewList = list;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.mPreviewList == null) {
            return 0;
        }
        return this.mPreviewList.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        AttacherImageView attacherImageView = new AttacherImageView(this.mContext);
        attacherImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        attacherImageView.setAttacher(new PhotoViewAttacher(attacherImageView));
        loadPreview(attacherImageView, this.mPreviewList.get(i), i);
        viewGroup.addView(attacherImageView);
        return attacherImageView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }
}

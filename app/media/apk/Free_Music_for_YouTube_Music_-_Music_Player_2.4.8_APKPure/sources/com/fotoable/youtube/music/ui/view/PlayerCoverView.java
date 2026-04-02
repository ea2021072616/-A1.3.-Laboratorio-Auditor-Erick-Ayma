package com.fotoable.youtube.music.ui.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bumptech.glide.i;
import com.bumptech.glide.load.b.b;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class PlayerCoverView extends RelativeLayout {
    private ObjectAnimator coverAnimator;
    private String imgUrl;
    private ImageView origin_cover;
    private int position;

    public PlayerCoverView(Context context) {
        super(context);
        init(context);
    }

    public PlayerCoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public PlayerCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_player_cover, this);
        this.origin_cover = (ImageView) findViewById(R.id.origin_cover);
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void reload() {
        i.c(getContext()).a(this.imgUrl).d((int) R.mipmap.music_player_default_cover).c((int) R.mipmap.music_player_default_cover).b(b.ALL).i().a(this.origin_cover);
    }

    public void stopRotation() {
        stopCoverRotation();
    }

    public void startRotation() {
        showCoverRotation();
    }

    private void stopCoverRotation() {
        if (this.coverAnimator != null) {
            this.coverAnimator.cancel();
            this.coverAnimator = null;
        }
    }

    private void showCoverRotation() {
        if (this.coverAnimator == null || !this.coverAnimator.isRunning()) {
            stopCoverRotation();
            this.coverAnimator = ObjectAnimator.ofFloat(this.origin_cover, "rotation", this.origin_cover.getRotation(), this.origin_cover.getRotation() + 360.0f);
            this.coverAnimator.setDuration(10000L);
            this.coverAnimator.setRepeatCount(-1);
            this.coverAnimator.setInterpolator(new LinearInterpolator());
            this.coverAnimator.start();
        }
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public int getPosition() {
        return this.position;
    }
}

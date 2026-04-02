package com.fotoable.youtube.music.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.BaseActivity;
/* loaded from: classes.dex */
public class YoutubeGuideTipActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3905a = YoutubeGuideTipActivity.class.getSimpleName();
    @BindView(R.id.content_panel)
    LinearLayout content_panel;
    @BindView(R.id.max_view)
    RelativeLayout max_view;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return false;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_youtube_guide_tip;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.content_panel.getLayoutParams();
        layoutParams.topMargin = 150;
        this.content_panel.setLayoutParams(layoutParams);
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
    }

    @OnClick({R.id.ok_ltv})
    public void onClick(View view) {
        if (view != null) {
            switch (view.getId()) {
                case R.id.ok_ltv /* 2131820956 */:
                    r();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        r();
    }

    private void r() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.max_view, "alpha", 1.0f, 0.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.fotoable.youtube.music.ui.activity.YoutubeGuideTipActivity.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                YoutubeGuideTipActivity.this.finish();
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}

package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rodolfonavalon.shaperipplelibrary.ShapeRipple;
/* loaded from: classes.dex */
public class MusicRecognitionActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private MusicRecognitionActivity f3532a;

    /* renamed from: b  reason: collision with root package name */
    private View f3533b;

    /* renamed from: c  reason: collision with root package name */
    private View f3534c;
    private View d;
    private View e;
    private View f;
    private View g;
    private View h;
    private View i;
    private View j;

    @UiThread
    public MusicRecognitionActivity_ViewBinding(final MusicRecognitionActivity musicRecognitionActivity, View view) {
        this.f3532a = musicRecognitionActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.music_recognition_back_view, "field 'mBackView' and method 'onViewClicked'");
        musicRecognitionActivity.mBackView = (ImageView) Utils.castView(findRequiredView, R.id.music_recognition_back_view, "field 'mBackView'", ImageView.class);
        this.f3533b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MusicRecognitionActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicRecognitionActivity.onViewClicked(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.music_recognition_history_img, "field 'mHistoryImg' and method 'onViewClicked'");
        musicRecognitionActivity.mHistoryImg = (ImageView) Utils.castView(findRequiredView2, R.id.music_recognition_history_img, "field 'mHistoryImg'", ImageView.class);
        this.f3534c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MusicRecognitionActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicRecognitionActivity.onViewClicked(view2);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.music_recognition_bg_img, "field 'mBgImg' and method 'onViewClicked'");
        musicRecognitionActivity.mBgImg = (ImageView) Utils.castView(findRequiredView3, R.id.music_recognition_bg_img, "field 'mBgImg'", ImageView.class);
        this.d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MusicRecognitionActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicRecognitionActivity.onViewClicked(view2);
            }
        });
        musicRecognitionActivity.mAnimationView = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.music_recognition_animation_view, "field 'mAnimationView'", LottieAnimationView.class);
        musicRecognitionActivity.mRippleView = (ShapeRipple) Utils.findRequiredViewAsType(view, R.id.music_recognition_ripple_view, "field 'mRippleView'", ShapeRipple.class);
        musicRecognitionActivity.mStateTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.music_recognition_state_tx, "field 'mStateTx'", LaToTextView.class);
        musicRecognitionActivity.mDescTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.music_recognition_desc_tx, "field 'mDescTx'", LaToTextView.class);
        musicRecognitionActivity.mLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.music_recognition_layout, "field 'mLayout'", RelativeLayout.class);
        musicRecognitionActivity.mResultTitleTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.music_recognition_result_title_tx, "field 'mResultTitleTx'", LaToTextView.class);
        musicRecognitionActivity.mResultAuthorTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.music_recognition_result_author_tx, "field 'mResultAuthorTx'", LaToTextView.class);
        musicRecognitionActivity.mResultInfoLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.music_recognition_result_info_layout, "field 'mResultInfoLayout'", LinearLayout.class);
        musicRecognitionActivity.mResultLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.music_recognition_result_layout, "field 'mResultLayout'", LinearLayout.class);
        musicRecognitionActivity.mCoverImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.music_recognition_cover_img, "field 'mCoverImg'", RoundedImageView.class);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.music_recognition_play_img, "field 'mPlayImg' and method 'onViewClicked'");
        musicRecognitionActivity.mPlayImg = (ImageView) Utils.castView(findRequiredView4, R.id.music_recognition_play_img, "field 'mPlayImg'", ImageView.class);
        this.e = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MusicRecognitionActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicRecognitionActivity.onViewClicked(view2);
            }
        });
        musicRecognitionActivity.mNoResultTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.music_recognition_no_result_tx, "field 'mNoResultTx'", LaToTextView.class);
        musicRecognitionActivity.mFeedbackTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.music_recognition_feedback_tx, "field 'mFeedbackTx'", LaToTextView.class);
        View findRequiredView5 = Utils.findRequiredView(view, R.id.music_recognition_feedback_view, "field 'mFeedbackView' and method 'onViewClicked'");
        musicRecognitionActivity.mFeedbackView = (LinearLayout) Utils.castView(findRequiredView5, R.id.music_recognition_feedback_view, "field 'mFeedbackView'", LinearLayout.class);
        this.f = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MusicRecognitionActivity_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicRecognitionActivity.onViewClicked(view2);
            }
        });
        View findRequiredView6 = Utils.findRequiredView(view, R.id.music_recognition_share_img, "field 'mShareImg' and method 'onViewClicked'");
        musicRecognitionActivity.mShareImg = (ImageView) Utils.castView(findRequiredView6, R.id.music_recognition_share_img, "field 'mShareImg'", ImageView.class);
        this.g = findRequiredView6;
        findRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MusicRecognitionActivity_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicRecognitionActivity.onViewClicked(view2);
            }
        });
        musicRecognitionActivity.mLikeCheckbox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.music_recognition_like_checkbox, "field 'mLikeCheckbox'", CheckBox.class);
        View findRequiredView7 = Utils.findRequiredView(view, R.id.music_recognition_find_artists_img, "field 'musicRecognitionFindArtistsImg' and method 'onViewClicked'");
        musicRecognitionActivity.musicRecognitionFindArtistsImg = (ImageView) Utils.castView(findRequiredView7, R.id.music_recognition_find_artists_img, "field 'musicRecognitionFindArtistsImg'", ImageView.class);
        this.h = findRequiredView7;
        findRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MusicRecognitionActivity_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicRecognitionActivity.onViewClicked(view2);
            }
        });
        View findRequiredView8 = Utils.findRequiredView(view, R.id.music_recognition_find_lyric_img, "field 'musicRecognitionFindLyricImg' and method 'onViewClicked'");
        musicRecognitionActivity.musicRecognitionFindLyricImg = (ImageView) Utils.castView(findRequiredView8, R.id.music_recognition_find_lyric_img, "field 'musicRecognitionFindLyricImg'", ImageView.class);
        this.i = findRequiredView8;
        findRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MusicRecognitionActivity_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicRecognitionActivity.onViewClicked(view2);
            }
        });
        View findRequiredView9 = Utils.findRequiredView(view, R.id.music_recognition_find_mp3_img, "field 'musicRecognitionFindMp3Img' and method 'onViewClicked'");
        musicRecognitionActivity.musicRecognitionFindMp3Img = (ImageView) Utils.castView(findRequiredView9, R.id.music_recognition_find_mp3_img, "field 'musicRecognitionFindMp3Img'", ImageView.class);
        this.j = findRequiredView9;
        findRequiredView9.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MusicRecognitionActivity_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicRecognitionActivity.onViewClicked(view2);
            }
        });
        musicRecognitionActivity.mSearchAnimationView = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.music_recognition_search_animation_view, "field 'mSearchAnimationView'", LottieAnimationView.class);
        musicRecognitionActivity.mNoResultImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.music_recognition_no_result_img, "field 'mNoResultImg'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MusicRecognitionActivity musicRecognitionActivity = this.f3532a;
        if (musicRecognitionActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3532a = null;
        musicRecognitionActivity.mBackView = null;
        musicRecognitionActivity.mHistoryImg = null;
        musicRecognitionActivity.mBgImg = null;
        musicRecognitionActivity.mAnimationView = null;
        musicRecognitionActivity.mRippleView = null;
        musicRecognitionActivity.mStateTx = null;
        musicRecognitionActivity.mDescTx = null;
        musicRecognitionActivity.mLayout = null;
        musicRecognitionActivity.mResultTitleTx = null;
        musicRecognitionActivity.mResultAuthorTx = null;
        musicRecognitionActivity.mResultInfoLayout = null;
        musicRecognitionActivity.mResultLayout = null;
        musicRecognitionActivity.mCoverImg = null;
        musicRecognitionActivity.mPlayImg = null;
        musicRecognitionActivity.mNoResultTx = null;
        musicRecognitionActivity.mFeedbackTx = null;
        musicRecognitionActivity.mFeedbackView = null;
        musicRecognitionActivity.mShareImg = null;
        musicRecognitionActivity.mLikeCheckbox = null;
        musicRecognitionActivity.musicRecognitionFindArtistsImg = null;
        musicRecognitionActivity.musicRecognitionFindLyricImg = null;
        musicRecognitionActivity.musicRecognitionFindMp3Img = null;
        musicRecognitionActivity.mSearchAnimationView = null;
        musicRecognitionActivity.mNoResultImg = null;
        this.f3533b.setOnClickListener(null);
        this.f3533b = null;
        this.f3534c.setOnClickListener(null);
        this.f3534c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
        this.f.setOnClickListener(null);
        this.f = null;
        this.g.setOnClickListener(null);
        this.g = null;
        this.h.setOnClickListener(null);
        this.h = null;
        this.i.setOnClickListener(null);
        this.i = null;
        this.j.setOnClickListener(null);
        this.j = null;
    }
}

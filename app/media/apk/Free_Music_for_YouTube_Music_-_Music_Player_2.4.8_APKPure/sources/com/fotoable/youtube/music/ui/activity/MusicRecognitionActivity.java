package com.fotoable.youtube.music.ui.activity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.PathInterpolatorCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PointerIconCompat;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.aw;
import com.facebook.ads.AdError;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.bean.ACRBean;
import com.fotoable.youtube.music.bean.FavBean;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.d.a.o;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.google.gson.Gson;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rodolfonavalon.shaperipplelibrary.ShapeRipple;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.b;
/* loaded from: classes.dex */
public class MusicRecognitionActivity extends BaseActivity implements o.a, b.a {

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.d.ap f3518a;
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.b.e f3519b;
    @Inject

    /* renamed from: c  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f3520c;
    private AnimationSet d;
    private a e;
    private boolean f;
    private com.acrcloud.rec.b.a g;
    private com.acrcloud.rec.b.b h;
    private boolean i;
    private boolean j;
    private PlayMusicModel k;
    private ACRBean.MetadataBean.MusicBean l;
    @BindView(R.id.music_recognition_animation_view)
    LottieAnimationView mAnimationView;
    @BindView(R.id.music_recognition_back_view)
    ImageView mBackView;
    @BindView(R.id.music_recognition_bg_img)
    ImageView mBgImg;
    @BindView(R.id.music_recognition_cover_img)
    RoundedImageView mCoverImg;
    @BindView(R.id.music_recognition_desc_tx)
    LaToTextView mDescTx;
    @BindView(R.id.music_recognition_feedback_tx)
    LaToTextView mFeedbackTx;
    @BindView(R.id.music_recognition_feedback_view)
    LinearLayout mFeedbackView;
    @BindView(R.id.music_recognition_history_img)
    ImageView mHistoryImg;
    @BindView(R.id.music_recognition_layout)
    RelativeLayout mLayout;
    @BindView(R.id.music_recognition_like_checkbox)
    CheckBox mLikeCheckbox;
    @BindView(R.id.music_recognition_no_result_img)
    ImageView mNoResultImg;
    @BindView(R.id.music_recognition_no_result_tx)
    LaToTextView mNoResultTx;
    @BindView(R.id.music_recognition_play_img)
    ImageView mPlayImg;
    @BindView(R.id.music_recognition_result_author_tx)
    LaToTextView mResultAuthorTx;
    @BindView(R.id.music_recognition_result_info_layout)
    LinearLayout mResultInfoLayout;
    @BindView(R.id.music_recognition_result_layout)
    LinearLayout mResultLayout;
    @BindView(R.id.music_recognition_result_title_tx)
    LaToTextView mResultTitleTx;
    @BindView(R.id.music_recognition_ripple_view)
    ShapeRipple mRippleView;
    @BindView(R.id.music_recognition_search_animation_view)
    LottieAnimationView mSearchAnimationView;
    @BindView(R.id.music_recognition_share_img)
    ImageView mShareImg;
    @BindView(R.id.music_recognition_state_tx)
    LaToTextView mStateTx;
    @BindView(R.id.music_recognition_find_artists_img)
    ImageView musicRecognitionFindArtistsImg;
    @BindView(R.id.music_recognition_find_lyric_img)
    ImageView musicRecognitionFindLyricImg;
    @BindView(R.id.music_recognition_find_mp3_img)
    ImageView musicRecognitionFindMp3Img;
    private Animator.AnimatorListener m = new Animator.AnimatorListener() { // from class: com.fotoable.youtube.music.ui.activity.MusicRecognitionActivity.5
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (MusicRecognitionActivity.this.mAnimationView != null) {
                com.fotoable.youtube.music.util.h.a(MusicRecognitionActivity.this.e + "");
                if (MusicRecognitionActivity.this.e == a.START) {
                    MusicRecognitionActivity.this.x();
                }
                if (MusicRecognitionActivity.this.e == a.RETRY) {
                    MusicRecognitionActivity.this.v();
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    };
    private com.acrcloud.rec.b.d n = new com.acrcloud.rec.b.d() { // from class: com.fotoable.youtube.music.ui.activity.MusicRecognitionActivity.6
        @Override // com.acrcloud.rec.b.d
        public void a(String str) {
            if (MusicRecognitionActivity.this.g != null) {
                MusicRecognitionActivity.this.g.d();
                MusicRecognitionActivity.this.j = false;
            }
            MusicRecognitionActivity.this.a((ACRBean) new Gson().fromJson(str, (Class<Object>) ACRBean.class));
            MusicRecognitionActivity.this.A();
        }

        @Override // com.acrcloud.rec.b.d
        public void a(double d) {
        }
    };

    /* loaded from: classes.dex */
    public enum a {
        START,
        STOP,
        FAIL,
        RETRY
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_music_recognition;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        this.f3518a = new com.fotoable.youtube.music.d.ap(this.f3519b, this);
        d();
        t();
        r();
        checkPermission();
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void c() {
        com.fotoable.youtube.music.newplayer.e.a().a(this, 2404);
    }

    @OnClick({R.id.music_recognition_back_view, R.id.music_recognition_history_img, R.id.music_recognition_bg_img, R.id.music_recognition_play_img, R.id.music_recognition_feedback_view, R.id.music_recognition_find_artists_img, R.id.music_recognition_find_mp3_img, R.id.music_recognition_find_lyric_img, R.id.music_recognition_share_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.music_recognition_back_view /* 2131820811 */:
                finish();
                return;
            case R.id.music_recognition_history_img /* 2131820812 */:
                startActivity(new Intent(this, MusicRecognitionHistoryActivity.class));
                return;
            case R.id.music_recognition_layout /* 2131820813 */:
            case R.id.music_recognition_ripple_view /* 2131820814 */:
            case R.id.music_recognition_animation_view /* 2131820816 */:
            case R.id.music_recognition_state_tx /* 2131820817 */:
            case R.id.music_recognition_desc_tx /* 2131820818 */:
            case R.id.music_recognition_result_layout /* 2131820819 */:
            case R.id.music_recognition_search_animation_view /* 2131820820 */:
            case R.id.music_recognition_no_result_img /* 2131820821 */:
            case R.id.music_recognition_no_result_tx /* 2131820822 */:
            case R.id.music_recognition_cover_img /* 2131820823 */:
            case R.id.music_recognition_result_info_layout /* 2131820827 */:
            case R.id.music_recognition_result_title_tx /* 2131820828 */:
            case R.id.music_recognition_result_author_tx /* 2131820829 */:
            default:
                return;
            case R.id.music_recognition_bg_img /* 2131820815 */:
                u();
                return;
            case R.id.music_recognition_share_img /* 2131820824 */:
                if (this.l != null && this.k != null) {
                    com.fotoable.youtube.music.helper.f.a(this, this.l.getArtists().get(0).getName(), this.k.getTitle(), this.k.getVideoId());
                    com.fotoable.youtube.music.util.b.b("Recognition-Share", "VideoId", "" + this.k.getVideoId());
                    return;
                }
                return;
            case R.id.music_recognition_like_checkbox /* 2131820825 */:
                if (this.l != null && this.k != null) {
                    boolean g = this.f3520c.g(this.k.getVideoId());
                    FavBean b2 = b(this.k);
                    if (g) {
                        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a((int) PointerIconCompat.TYPE_WAIT, b2));
                        return;
                    } else {
                        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a((int) PointerIconCompat.TYPE_HELP, b2));
                        return;
                    }
                }
                return;
            case R.id.music_recognition_play_img /* 2131820826 */:
                if (this.k != null) {
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(this.k);
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a((int) AdError.INTERNAL_ERROR_CODE, arrayList, 0));
                    com.fotoable.youtube.music.util.b.b("Recognition-PlaySingle", "videoId", this.k.getVideoId());
                    return;
                }
                return;
            case R.id.music_recognition_find_artists_img /* 2131820830 */:
                if (this.l != null && this.k != null) {
                    Intent intent = new Intent(this, ArtistsDetailActivity.class);
                    intent.putExtra(ShareConstants.TITLE, this.l.getArtists().get(0).getName());
                    startActivity(intent);
                    com.fotoable.youtube.music.util.b.b("Recognition-Artist", "歌手名", "" + this.l.getArtists().get(0).getName());
                    return;
                }
                return;
            case R.id.music_recognition_find_lyric_img /* 2131820831 */:
                if (this.l != null && this.k != null) {
                    com.fotoable.youtube.music.util.i.a(this).b(this.l.getArtists().get(0).getName() + "  " + this.l.getTitle(), this.k.getVideoId());
                    com.fotoable.youtube.music.util.b.b("Recognition-FindLyric");
                    return;
                }
                return;
            case R.id.music_recognition_find_mp3_img /* 2131820832 */:
                if (this.l != null && this.k != null) {
                    com.fotoable.youtube.music.util.i.a(this).a(this.l.getArtists().get(0).getName() + "  " + this.l.getTitle(), this.k.getVideoId());
                    com.fotoable.youtube.music.util.b.b("Recognition-FindMp3");
                    return;
                }
                return;
            case R.id.music_recognition_feedback_view /* 2131820833 */:
                com.fotoable.youtube.music.util.b.b("Recognition-Feedback");
                Toast.makeText(this, (int) R.string.thanks_feedback, 0).show();
                return;
        }
    }

    private void r() {
        this.mAnimationView.a(this.m);
    }

    private void s() {
        com.fotoable.youtube.music.helper.a aVar = new com.fotoable.youtube.music.helper.a(this);
        this.g = aVar.a();
        this.h = aVar.b();
        this.h.h = this.n;
        this.i = this.g.a(this.h);
        if (this.i) {
            this.g.a(PathInterpolatorCompat.MAX_NUM_POINTS);
        }
    }

    private void t() {
        this.mFeedbackTx.getPaint().setFlags(8);
        this.mRippleView.c();
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.d = new AnimationSet(true);
        this.d.addAnimation(translateAnimation);
        this.d.addAnimation(alphaAnimation);
        this.d.setDuration(500L);
        this.d.setAnimationListener(new Animation.AnimationListener() { // from class: com.fotoable.youtube.music.ui.activity.MusicRecognitionActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void u() {
        try {
            if (this.mAnimationView != null && this.mRippleView != null) {
                switch (this.e) {
                    case START:
                        if (this.f) {
                            this.mAnimationView.b(false);
                            this.f = false;
                            break;
                        } else {
                            w();
                            B();
                            break;
                        }
                    case STOP:
                        v();
                        z();
                        break;
                    case FAIL:
                        y();
                        break;
                }
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.mAnimationView != null && this.mRippleView != null) {
            this.e = a.START;
            this.mAnimationView.b(true);
            this.mRippleView.b();
            a("Recognizing.json", this.mAnimationView);
            this.mDescTx.setText(R.string.tap_to_cancel);
            this.mStateTx.setText(R.string.recognizing);
        }
    }

    private void w() {
        if (this.mAnimationView != null && this.mRippleView != null) {
            this.e = a.STOP;
            this.mAnimationView.setProgress(1.0f);
            this.mAnimationView.d();
            this.mRippleView.c();
            this.mDescTx.setText(R.string.tap_to_start);
            this.mStateTx.setText(R.string.start_to_recognize);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.mAnimationView != null && this.mRippleView != null) {
            this.mAnimationView.b(false);
            this.mRippleView.c();
            a("RecognizeFail.json", this.mAnimationView);
            this.e = a.FAIL;
            a(rx.f.b(1L, TimeUnit.SECONDS).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<Long>() { // from class: com.fotoable.youtube.music.ui.activity.MusicRecognitionActivity.2
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(Long l) {
                    MusicRecognitionActivity.this.mStateTx.setText(R.string.recognize_failed);
                    MusicRecognitionActivity.this.mDescTx.setText(R.string.tap_to_try);
                }
            }));
        }
    }

    private void y() {
        if (this.mAnimationView != null) {
            this.e = a.RETRY;
            this.mAnimationView.b(false);
            a("RecognizeRetry.json", this.mAnimationView);
            z();
        }
    }

    private void a(String str, final LottieAnimationView lottieAnimationView) {
        aw.a.a(this, str, new com.airbnb.lottie.bf() { // from class: com.fotoable.youtube.music.ui.activity.MusicRecognitionActivity.3
            @Override // com.airbnb.lottie.bf
            public void onCompositionLoaded(com.airbnb.lottie.aw awVar) {
                if (lottieAnimationView != null) {
                    lottieAnimationView.setComposition(awVar);
                    lottieAnimationView.c();
                }
            }
        });
    }

    private void z() {
        if (this.i && !this.j) {
            this.j = true;
            if (this.g == null || !this.g.a()) {
                this.j = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        if (this.j && this.g != null) {
            this.g.b();
        }
        this.j = false;
    }

    private void B() {
        if (this.j && this.g != null) {
            this.j = false;
            this.g.d();
        }
    }

    private void C() {
        try {
            if (this.mResultLayout != null && this.mLayout != null) {
                w();
                this.mLayout.setVisibility(8);
                this.mResultLayout.setVisibility(0);
                this.mResultLayout.startAnimation(this.d);
                a(rx.f.b(500L, TimeUnit.MILLISECONDS).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<Long>() { // from class: com.fotoable.youtube.music.ui.activity.MusicRecognitionActivity.4
                    @Override // rx.g
                    public void onCompleted() {
                        if (MusicRecognitionActivity.this.mResultLayout != null) {
                            MusicRecognitionActivity.this.mResultLayout.clearAnimation();
                            MusicRecognitionActivity.this.mFeedbackView.setVisibility(0);
                            MusicRecognitionActivity.this.mResultInfoLayout.setVisibility(0);
                            MusicRecognitionActivity.this.mResultInfoLayout.startAnimation(MusicRecognitionActivity.this.d);
                        }
                    }

                    @Override // rx.g
                    public void onError(Throwable th) {
                        ThrowableExtension.printStackTrace(th);
                    }

                    @Override // rx.g
                    /* renamed from: a */
                    public void onNext(Long l) {
                    }
                }));
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // com.fotoable.youtube.music.d.a.o.a
    public void a(PlayMusicModel playMusicModel) {
        com.fotoable.youtube.music.util.b.b("Recognition-FindMusic-Success");
        this.k = playMusicModel;
        this.mPlayImg.setVisibility(0);
        this.mShareImg.setVisibility(0);
        this.mLikeCheckbox.setVisibility(0);
        this.mNoResultTx.setText(R.string.enjoy_your_music);
        this.mNoResultTx.setVisibility(4);
        this.mSearchAnimationView.d();
        this.mSearchAnimationView.setVisibility(8);
        com.bumptech.glide.i.a((FragmentActivity) this).a(playMusicModel.getCoverImg()).i().j().d((int) R.mipmap.icon_recongize_cover).a(this.mCoverImg);
    }

    @Override // com.fotoable.youtube.music.d.a.o.a
    public void h_() {
        this.mSearchAnimationView.d();
        this.mSearchAnimationView.setVisibility(8);
        this.mNoResultImg.setVisibility(0);
        this.mNoResultTx.setText(R.string.no_youtube_resource);
        com.fotoable.youtube.music.util.b.b("Recognition-FindMusic-Failed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ACRBean aCRBean) {
        try {
            if (aCRBean.getStatus().getCode() == 0) {
                com.fotoable.youtube.music.util.b.b("Recognition-Success");
                if (aCRBean.getMetadata() != null && aCRBean.getMetadata().getMusic() != null && aCRBean.getMetadata().getMusic().size() > 0) {
                    ACRBean.MetadataBean.MusicBean musicBean = aCRBean.getMetadata().getMusic().get(0);
                    if (musicBean != null && this.mResultTitleTx != null && this.mResultAuthorTx != null) {
                        this.mResultTitleTx.setText(musicBean.getTitle());
                        this.mResultAuthorTx.setText(musicBean.getArtists().get(0).getName());
                        if (this.k == null) {
                            this.k = new PlayMusicModel();
                        }
                        this.l = musicBean;
                        this.k.setTitle(musicBean.getTitle());
                        this.k.setArtists(musicBean.getArtists().get(0).getName());
                        this.mNoResultTx.setText(R.string.recognize_searching);
                        this.mSearchAnimationView.setVisibility(0);
                        this.mSearchAnimationView.b(true);
                        a("Searching.json", this.mSearchAnimationView);
                        if (musicBean.getExternal_metadata() != null && musicBean.getExternal_metadata().getYoutube() != null) {
                            this.f3518a.a(musicBean.getExternal_metadata().getYoutube().getVid());
                            this.k.setVideoId(musicBean.getExternal_metadata().getYoutube().getVid());
                        } else {
                            this.f3518a.b(musicBean.getTitle() + " " + musicBean.getArtists().get(0).getName());
                            this.k.setVideoId("");
                        }
                        C();
                        return;
                    }
                    this.f = true;
                    u();
                    com.fotoable.youtube.music.util.b.b("Recognition-Failed");
                    return;
                }
                return;
            }
            this.f = true;
            u();
            com.fotoable.youtube.music.util.b.b("Recognition-Failed");
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    private FavBean b(PlayMusicModel playMusicModel) {
        FavBean favBean = new FavBean();
        favBean.setVideoid(playMusicModel.getVideoId());
        favBean.setTitle(playMusicModel.getTitle());
        favBean.setDesc(playMusicModel.getDescription());
        favBean.setImgUrl(playMusicModel.getCoverImg());
        favBean.setDuration(playMusicModel.getDuration());
        favBean.setArtists(playMusicModel.getArtists());
        return favBean;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return false;
    }

    @pub.devrel.easypermissions.a(a = 123)
    private void checkPermission() {
        String[] strArr = {"android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE"};
        if (pub.devrel.easypermissions.b.a(this, strArr)) {
            s();
            z();
            v();
            return;
        }
        pub.devrel.easypermissions.b.a(this, getString(R.string.need_recording_permission), 123, strArr);
    }

    @Override // pub.devrel.easypermissions.b.a
    public void a(int i, List<String> list) {
        s();
        z();
        v();
    }

    @Override // pub.devrel.easypermissions.b.a
    public void b(int i, List<String> list) {
        if (pub.devrel.easypermissions.b.a(this, list)) {
            new AppSettingsDialog.a(this).a().show();
        } else {
            finish();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        pub.devrel.easypermissions.b.a(i, strArr, iArr, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            B();
            if (this.g != null) {
                this.g.f();
                this.i = false;
                this.g = null;
            }
            if (this.mAnimationView != null) {
                this.mAnimationView.b(this.m);
                this.mAnimationView.d();
                this.m = null;
            }
            if (this.mRippleView != null) {
                this.mRippleView.c();
            }
            this.f3518a.b_();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }
}

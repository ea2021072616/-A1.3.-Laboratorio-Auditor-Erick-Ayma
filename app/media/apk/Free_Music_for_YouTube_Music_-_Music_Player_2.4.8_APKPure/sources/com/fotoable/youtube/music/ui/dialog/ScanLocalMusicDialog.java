package com.fotoable.youtube.music.ui.dialog;

import android.animation.Animator;
import android.animation.FloatEvaluator;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.LocalSongBean;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class ScanLocalMusicDialog extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private FragmentManager f4373a;

    /* renamed from: b  reason: collision with root package name */
    private ValueAnimator f4374b;

    /* renamed from: c  reason: collision with root package name */
    private rx.m f4375c;
    @BindView(R.id.ck_scan)
    CheckBox ckScan;
    private rx.m d;
    private rx.m e;
    private Unbinder f;
    @BindView(R.id.iv_close)
    ImageView ivClose;
    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    @BindView(R.id.iv_scan)
    ImageView ivScan;
    @BindView(R.id.tv_progress)
    LaToTextView tvProgress;
    @BindView(R.id.tv_scan)
    LaToTextView tvScan;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().requestWindowFeature(1);
        return layoutInflater.inflate(R.layout.dialog_scan_localmusic, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f = ButterKnife.bind(this, view);
        c();
        setCancelable(false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setWindowAnimations(R.style.dialogWindowAnim);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.fotoable.youtube.music.ui.dialog.z

            /* renamed from: a  reason: collision with root package name */
            private final ScanLocalMusicDialog f4480a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4480a = this;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return this.f4480a.a(dialogInterface, i, keyEvent);
            }
        });
        a();
        this.ivClose.setOnClickListener(new View.OnClickListener(this) { // from class: com.fotoable.youtube.music.ui.dialog.aa

            /* renamed from: a  reason: collision with root package name */
            private final ScanLocalMusicDialog f4423a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4423a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                this.f4423a.b(view2);
            }
        });
        this.ckScan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: com.fotoable.youtube.music.ui.dialog.ab

            /* renamed from: a  reason: collision with root package name */
            private final ScanLocalMusicDialog f4424a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4424a = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f4424a.a(compoundButton, z);
            }
        });
        this.ckScan.setOnClickListener(new View.OnClickListener(this) { // from class: com.fotoable.youtube.music.ui.dialog.ac

            /* renamed from: a  reason: collision with root package name */
            private final ScanLocalMusicDialog f4425a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4425a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                this.f4425a.a(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            try {
                b();
                d();
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
            dismissAllowingStateLoss();
            onCancel(dialogInterface);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b(View view) {
        d();
        b();
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        this.ckScan.setText(z ? getString(R.string.ok) : getString(R.string.stop_scanning_music));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(View view) {
        d();
        b();
        dismissAllowingStateLoss();
    }

    private void a() {
        this.d = com.fotoable.youtube.music.helper.localmusic.d.b(1).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<List<LocalSongBean>>() { // from class: com.fotoable.youtube.music.ui.dialog.ScanLocalMusicDialog.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(final List<LocalSongBean> list) {
                if (list != null && list.size() > 0) {
                    ScanLocalMusicDialog.this.f4375c = rx.f.a(100L, 100L, TimeUnit.MILLISECONDS).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Long>() { // from class: com.fotoable.youtube.music.ui.dialog.ScanLocalMusicDialog.1.1
                        @Override // rx.g
                        public void onCompleted() {
                            if (ScanLocalMusicDialog.this.tvScan != null) {
                                ScanLocalMusicDialog.this.tvScan.setText(ScanLocalMusicDialog.this.getString(R.string.music_scan_size, Integer.valueOf(list.size())));
                            }
                            if (ScanLocalMusicDialog.this.ckScan != null) {
                                ScanLocalMusicDialog.this.ckScan.setChecked(true);
                            }
                            ScanLocalMusicDialog.this.d();
                        }

                        @Override // rx.g
                        public void onError(Throwable th) {
                            ThrowableExtension.printStackTrace(th);
                        }

                        @Override // rx.g
                        /* renamed from: a */
                        public void onNext(Long l) {
                            int intValue = l.intValue();
                            if (ScanLocalMusicDialog.this.tvProgress != null) {
                                ScanLocalMusicDialog.this.tvProgress.setText(ScanLocalMusicDialog.this.getString(R.string.music_scaning, Integer.valueOf((intValue * 100) / list.size()), "%"));
                            }
                            if (intValue == list.size()) {
                                unsubscribe();
                                onCompleted();
                                ScanLocalMusicDialog.this.tvProgress.setText(ScanLocalMusicDialog.this.getString(R.string.music_scan_finish));
                            }
                            if (ScanLocalMusicDialog.this.tvScan != null) {
                                ScanLocalMusicDialog.this.tvScan.setText(((LocalSongBean) list.get(intValue)).songName);
                            }
                        }
                    });
                    return;
                }
                ScanLocalMusicDialog.this.tvProgress.setText(ScanLocalMusicDialog.this.getString(R.string.music_scaning, 50, "%"));
                if (ScanLocalMusicDialog.this.tvScan != null) {
                    ScanLocalMusicDialog.this.tvScan.setText(ScanLocalMusicDialog.this.getString(R.string.music_scan_size, 0));
                }
                ScanLocalMusicDialog.this.e = rx.f.b(2000L, TimeUnit.MILLISECONDS).a(rx.a.b.a.a()).b(new rx.l<Long>() { // from class: com.fotoable.youtube.music.ui.dialog.ScanLocalMusicDialog.1.2
                    @Override // rx.g
                    public void onCompleted() {
                    }

                    @Override // rx.g
                    public void onError(Throwable th) {
                        ScanLocalMusicDialog.this.d();
                        if (ScanLocalMusicDialog.this.ckScan != null) {
                            ScanLocalMusicDialog.this.ckScan.setChecked(true);
                        }
                        ScanLocalMusicDialog.this.tvProgress.setText(ScanLocalMusicDialog.this.getString(R.string.music_scan_finish));
                        if (ScanLocalMusicDialog.this.tvScan != null) {
                            ScanLocalMusicDialog.this.tvScan.setText(ScanLocalMusicDialog.this.getString(R.string.music_scan_size, 0));
                        }
                    }

                    @Override // rx.g
                    /* renamed from: a */
                    public void onNext(Long l) {
                        ScanLocalMusicDialog.this.d();
                        if (ScanLocalMusicDialog.this.ckScan != null) {
                            ScanLocalMusicDialog.this.ckScan.setChecked(true);
                        }
                        ScanLocalMusicDialog.this.tvProgress.setText(ScanLocalMusicDialog.this.getString(R.string.music_scan_finish));
                        if (ScanLocalMusicDialog.this.tvScan != null) {
                            ScanLocalMusicDialog.this.tvScan.setText(ScanLocalMusicDialog.this.getString(R.string.music_scan_size, 0));
                        }
                    }
                });
            }
        });
    }

    private void b() {
        if (this.f4375c != null && !this.f4375c.isUnsubscribed()) {
            this.f4375c.unsubscribe();
        }
        if (this.d != null && !this.d.isUnsubscribed()) {
            this.d.unsubscribe();
        }
        if (this.e != null && !this.e.isUnsubscribed()) {
            this.e.unsubscribe();
        }
    }

    private void c() {
        if (this.ivScan != null) {
            this.f4374b = ValueAnimator.ofFloat(360.0f, 0.0f);
            this.f4374b.setDuration(80000L);
            this.f4374b.setEvaluator(new FloatEvaluator());
            this.f4374b.setRepeatCount(-1);
            this.f4374b.setInterpolator(new LinearInterpolator());
            this.f4374b.setRepeatMode(1);
            this.f4374b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.fotoable.youtube.music.ui.dialog.ad

                /* renamed from: a  reason: collision with root package name */
                private final ScanLocalMusicDialog f4426a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f4426a = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f4426a.a(valueAnimator);
                }
            });
            this.f4374b.addListener(new Animator.AnimatorListener() { // from class: com.fotoable.youtube.music.ui.dialog.ScanLocalMusicDialog.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (ScanLocalMusicDialog.this.ivScan != null) {
                        ScanLocalMusicDialog.this.ivScan.setTranslationX(0.0f);
                        ScanLocalMusicDialog.this.ivScan.setTranslationY(0.0f);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.f4374b.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float cos = (float) (Math.cos(floatValue) * 30.0d);
        this.ivScan.setTranslationX((float) (Math.sin(floatValue) * 30.0d));
        this.ivScan.setTranslationY(cos);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f4374b != null && this.f4374b.isRunning()) {
            this.f4374b.cancel();
            this.f4374b = null;
        }
    }

    public static ScanLocalMusicDialog a(FragmentManager fragmentManager) {
        ScanLocalMusicDialog scanLocalMusicDialog;
        Exception e;
        try {
            scanLocalMusicDialog = new ScanLocalMusicDialog();
            try {
                scanLocalMusicDialog.f4373a = fragmentManager;
                fragmentManager.beginTransaction().add(scanLocalMusicDialog, "SimpleMusicDialog").commitAllowingStateLoss();
            } catch (Exception e2) {
                e = e2;
                ThrowableExtension.printStackTrace(e);
                return scanLocalMusicDialog;
            }
        } catch (Exception e3) {
            scanLocalMusicDialog = null;
            e = e3;
        }
        return scanLocalMusicDialog;
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            if (this.f4373a != null) {
                this.f4373a.beginTransaction().remove(this).commitAllowingStateLoss();
            }
            super.dismiss();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        try {
            b();
            d();
            super.onDestroyView();
            if (this.f != null) {
                this.f.unbind();
                this.f = null;
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }
}

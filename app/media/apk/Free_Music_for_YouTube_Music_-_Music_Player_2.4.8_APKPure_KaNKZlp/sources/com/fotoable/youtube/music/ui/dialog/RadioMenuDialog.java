package com.fotoable.youtube.music.ui.dialog;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.facebook.appevents.AppEventsConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.bean.RadioBean;
import com.fotoable.youtube.music.ui.activity.TimerActivity;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public class RadioMenuDialog extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    Unbinder f4338a;
    @BindView(R.id.add_to_favorite)
    LinearLayout addToFavorite;

    /* renamed from: b  reason: collision with root package name */
    private RadioBean f4339b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4340c;
    private boolean d;
    private FragmentManager e;
    @BindView(R.id.error_report)
    LinearLayout errorReport;
    private rx.g.b f;
    @BindView(R.id.ll_sleep_timer)
    LinearLayout ll_sleep_timer;
    @BindView(R.id.sleep_timer_real_time)
    TextView sleep_timer_real_time;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_radio_menu, viewGroup, false);
        this.f4338a = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        c();
        a();
        if (!this.f4340c) {
            this.addToFavorite.setVisibility(8);
        }
        if (this.d) {
            this.ll_sleep_timer.setVisibility(0);
        }
    }

    private void c() {
        getDialog().requestWindowFeature(1);
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        getDialog().getWindow().setGravity(80);
        Window window = getDialog().getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
        getDialog().setCancelable(true);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.down_fragment_alpha)));
        getDialog().getWindow().setWindowAnimations(R.style.download_popup_animation);
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f4338a.unbind();
    }

    @OnClick({R.id.add_to_favorite, R.id.error_report, R.id.ll_sleep_timer})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_sleep_timer /* 2131821056 */:
                startActivity(new Intent(getContext(), TimerActivity.class));
                dismiss();
                return;
            case R.id.add_to_favorite /* 2131821086 */:
                d();
                Toast.makeText(getActivity(), (int) R.string.success, 0).show();
                dismiss();
                return;
            case R.id.error_report /* 2131821087 */:
                e();
                dismiss();
                return;
            default:
                return;
        }
    }

    public static RadioMenuDialog a(FragmentManager fragmentManager, RadioBean radioBean, boolean z, boolean z2) {
        RadioMenuDialog radioMenuDialog;
        Exception e;
        try {
            radioMenuDialog = new RadioMenuDialog();
        } catch (Exception e2) {
            radioMenuDialog = null;
            e = e2;
        }
        try {
            radioMenuDialog.f4339b = radioBean;
            radioMenuDialog.f4340c = z;
            radioMenuDialog.d = z2;
            radioMenuDialog.e = fragmentManager;
            fragmentManager.beginTransaction().add(radioMenuDialog, "RadioMenuDialog").commitAllowingStateLoss();
        } catch (Exception e3) {
            e = e3;
            ThrowableExtension.printStackTrace(e);
            return radioMenuDialog;
        }
        return radioMenuDialog;
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            if (this.e != null) {
                this.e.beginTransaction().remove(this).commitAllowingStateLoss();
            }
            b();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        super.dismiss();
    }

    private void d() {
        if (this.f4339b != null) {
            a(MusicApplication.c().e().d().a(this.f4339b).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<Boolean>() { // from class: com.fotoable.youtube.music.ui.dialog.RadioMenuDialog.1
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(Boolean bool) {
                }
            }));
        }
    }

    private void e() {
        if (this.f4339b != null) {
            a(MusicApplication.c().e().a().a(this.f4339b.getId() + "", this.f4339b.getCountryCode()).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<MyHttpResponse>() { // from class: com.fotoable.youtube.music.ui.dialog.RadioMenuDialog.2
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(MyHttpResponse myHttpResponse) {
                }
            }));
            com.fotoable.youtube.music.util.b.b("电台-反馈", "id", Integer.valueOf(this.f4339b.getId()));
            Toast.makeText(getActivity(), (int) R.string.thanks_feedback, 0).show();
        }
    }

    public void a() {
        a(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<com.fotoable.youtube.music.e.a>() { // from class: com.fotoable.youtube.music.ui.dialog.RadioMenuDialog.3
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                if (th != null) {
                    ThrowableExtension.printStackTrace(th);
                }
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(com.fotoable.youtube.music.e.a aVar) {
                RadioMenuDialog.this.a(aVar);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.fotoable.youtube.music.e.a aVar) {
        switch (aVar.f2726a) {
            case 8004:
                if (aVar.d > 0) {
                    StringBuilder sb = new StringBuilder();
                    int i = aVar.d / 216000;
                    int i2 = (aVar.d % 216000) / 60;
                    int i3 = (aVar.d % 216000) % 60;
                    if (i > 0) {
                        sb.append(i + ":");
                    }
                    if (i2 > 0) {
                        if (i2 < 10) {
                            sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        }
                        sb.append(i2 + ":");
                    } else {
                        sb.append("00:");
                    }
                    if (i3 > 0) {
                        if (i3 < 10) {
                            sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        }
                        sb.append(i3 + "");
                    } else {
                        sb.append("00");
                    }
                    this.sleep_timer_real_time.setText(sb.toString() + "");
                    this.sleep_timer_real_time.setVisibility(0);
                    return;
                }
                this.sleep_timer_real_time.setVisibility(8);
                return;
            default:
                return;
        }
    }

    protected void a(rx.m mVar) {
        if (this.f == null) {
            this.f = new rx.g.b();
        }
        this.f.a(mVar);
    }

    protected void b() {
        if (this.f != null) {
            this.f.unsubscribe();
            this.f = null;
        }
    }
}

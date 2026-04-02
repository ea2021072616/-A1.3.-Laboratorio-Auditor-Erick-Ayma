package com.fotoable.youtube.music.ui.dialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.activity.AboutSubscriptionActivity;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public class SubscriptionDialog extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4394a = SubscriptionDialog.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private Unbinder f4395b;

    /* renamed from: c  reason: collision with root package name */
    private FragmentManager f4396c;
    private rx.g.b d;
    @BindView(R.id.tv_about_subscription)
    TextView tv_about_subscription;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().requestWindowFeature(1);
        return layoutInflater.inflate(R.layout.activity_subscription, viewGroup, false);
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        getDialog().getWindow().setLayout(displayMetrics.widthPixels, getDialog().getWindow().getAttributes().height);
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f4395b = ButterKnife.bind(this, view);
        setCancelable(false);
        String string = getResources().getString(R.string.about_subscription);
        try {
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(new UnderlineSpan(), 41, 53, 33);
            spannableString.setSpan(new UnderlineSpan(), 55, 74, 33);
            spannableString.setSpan(new UnderlineSpan(), 79, 93, 33);
            this.tv_about_subscription.setText(spannableString);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
            this.tv_about_subscription.setText(string);
        }
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.fotoable.youtube.music.ui.dialog.SubscriptionDialog.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == 4 && keyEvent.getAction() == 1) {
                    SubscriptionDialog.this.dismissAllowingStateLoss();
                    return true;
                }
                return false;
            }
        });
        com.fotoable.youtube.music.util.b.b("订阅界面-展示次数");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.iv_close, R.id.tv_subscription_submit, R.id.tv_about_subscription})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_close /* 2131820744 */:
                dismiss();
                return;
            case R.id.tv_subscription_submit /* 2131820942 */:
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2022));
                dismiss();
                return;
            case R.id.tv_about_subscription /* 2131820943 */:
                startActivity(new Intent(getContext(), AboutSubscriptionActivity.class));
                return;
            default:
                return;
        }
    }

    public static SubscriptionDialog a(FragmentManager fragmentManager) {
        SubscriptionDialog subscriptionDialog;
        Exception e;
        try {
            subscriptionDialog = new SubscriptionDialog();
            try {
                subscriptionDialog.f4396c = fragmentManager;
                fragmentManager.beginTransaction().add(subscriptionDialog, "SubscriptionDialog").commitAllowingStateLoss();
            } catch (Exception e2) {
                e = e2;
                ThrowableExtension.printStackTrace(e);
                return subscriptionDialog;
            }
        } catch (Exception e3) {
            subscriptionDialog = null;
            e = e3;
        }
        return subscriptionDialog;
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            if (this.f4396c != null) {
                this.f4396c.beginTransaction().remove(this).commitAllowingStateLoss();
            }
            super.dismiss();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f4395b != null) {
            this.f4395b.unbind();
            this.f4395b = null;
        }
        a();
    }

    protected void a() {
        if (this.d != null && !this.d.isUnsubscribed()) {
            this.d.unsubscribe();
            this.d = null;
        }
    }
}

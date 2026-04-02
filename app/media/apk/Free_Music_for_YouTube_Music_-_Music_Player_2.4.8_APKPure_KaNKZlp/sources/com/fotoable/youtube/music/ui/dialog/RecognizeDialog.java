package com.fotoable.youtube.music.ui.dialog;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public class RecognizeDialog extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private Unbinder f4361a;

    /* renamed from: b  reason: collision with root package name */
    private FragmentManager f4362b;

    /* renamed from: c  reason: collision with root package name */
    private int f4363c;
    @BindView(R.id.cancel_tx)
    LaToTextView cancelTx;
    @BindView(R.id.close_img)
    ImageView closeImg;
    @BindView(R.id.cover_img)
    ImageView coverImg;
    private int d;
    @BindView(R.id.desc_tx)
    LaToTextView descTx;
    private int e;
    private int f;
    private int g;
    private a h;
    @BindView(R.id.ok_tx)
    LaToTextView okTx;
    @BindView(R.id.title_tx)
    LaToTextView titleTx;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().requestWindowFeature(1);
        View inflate = layoutInflater.inflate(R.layout.dialog_recongize, viewGroup, false);
        this.f4361a = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        setCancelable(false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        a();
    }

    private void a() {
        if (this.f4363c != 0) {
            this.okTx.setText(this.f4363c);
        }
        if (this.d != 0) {
            this.cancelTx.setText(this.d);
        }
        if (this.e != 0) {
            this.coverImg.setImageResource(this.e);
        }
        if (this.f != 0) {
            this.titleTx.setText(this.f);
        }
        if (this.g != 0) {
            this.descTx.setText(this.g);
        }
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            if (this.f4362b != null) {
                this.f4362b.beginTransaction().remove(this).commitAllowingStateLoss();
            }
            super.dismiss();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f4361a.unbind();
    }

    @OnClick({R.id.close_img, R.id.ok_tx, R.id.cancel_tx})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.close_img /* 2131821092 */:
                if (this.h != null) {
                    this.h.b();
                }
                dismiss();
                return;
            case R.id.cover_img /* 2131821093 */:
            case R.id.desc_tx /* 2131821094 */:
            default:
                return;
            case R.id.ok_tx /* 2131821095 */:
                if (this.h != null) {
                    this.h.a();
                }
                dismiss();
                return;
            case R.id.cancel_tx /* 2131821096 */:
                if (this.h != null) {
                    this.h.b();
                }
                dismiss();
                return;
        }
    }
}

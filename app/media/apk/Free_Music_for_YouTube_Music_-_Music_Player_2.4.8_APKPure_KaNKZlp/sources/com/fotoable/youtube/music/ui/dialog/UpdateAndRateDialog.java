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
public class UpdateAndRateDialog extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    Unbinder f4407a;

    /* renamed from: b  reason: collision with root package name */
    private FragmentManager f4408b;

    /* renamed from: c  reason: collision with root package name */
    private int f4409c;
    @BindView(R.id.cancel_tx)
    LaToTextView cancelTx;
    @BindView(R.id.close_img)
    ImageView closeImg;
    @BindView(R.id.cover_img)
    ImageView coverImg;
    private int d;
    private int e;
    private a f;
    @BindView(R.id.ok_tx)
    LaToTextView okTx;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().requestWindowFeature(1);
        View inflate = layoutInflater.inflate(R.layout.dialog_update_and_rate, viewGroup, false);
        this.f4407a = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        setCancelable(false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        a();
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    private void a() {
        if (this.f4409c != 0) {
            this.okTx.setText(this.f4409c);
        }
        if (this.d != 0) {
            this.cancelTx.setText(this.d);
        }
        if (this.e != 0) {
            this.coverImg.setImageResource(this.e);
        }
    }

    public static UpdateAndRateDialog a(FragmentManager fragmentManager, int i, int i2, int i3, a aVar) {
        UpdateAndRateDialog updateAndRateDialog;
        Exception e;
        try {
            updateAndRateDialog = new UpdateAndRateDialog();
        } catch (Exception e2) {
            updateAndRateDialog = null;
            e = e2;
        }
        try {
            updateAndRateDialog.f4408b = fragmentManager;
            updateAndRateDialog.f4409c = i;
            updateAndRateDialog.d = i2;
            updateAndRateDialog.e = i3;
            updateAndRateDialog.a(aVar);
            if (i3 == R.mipmap.icon_app_update) {
                fragmentManager.beginTransaction().add(updateAndRateDialog, "UpdateDialog").commitAllowingStateLoss();
            } else {
                fragmentManager.beginTransaction().add(updateAndRateDialog, "RateDialog").commitAllowingStateLoss();
            }
        } catch (Exception e3) {
            e = e3;
            ThrowableExtension.printStackTrace(e);
            return updateAndRateDialog;
        }
        return updateAndRateDialog;
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            if (this.f4408b != null) {
                this.f4408b.beginTransaction().remove(this).commitAllowingStateLoss();
            }
            super.dismiss();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f4407a.unbind();
    }

    @OnClick({R.id.close_img, R.id.ok_tx, R.id.cancel_tx})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.close_img /* 2131821092 */:
                if (this.f != null) {
                    this.f.b();
                }
                dismiss();
                return;
            case R.id.cover_img /* 2131821093 */:
            case R.id.desc_tx /* 2131821094 */:
            default:
                return;
            case R.id.ok_tx /* 2131821095 */:
                if (this.f != null) {
                    this.f.a();
                }
                dismiss();
                return;
            case R.id.cancel_tx /* 2131821096 */:
                if (this.f != null) {
                    this.f.b();
                }
                dismiss();
                return;
        }
    }
}

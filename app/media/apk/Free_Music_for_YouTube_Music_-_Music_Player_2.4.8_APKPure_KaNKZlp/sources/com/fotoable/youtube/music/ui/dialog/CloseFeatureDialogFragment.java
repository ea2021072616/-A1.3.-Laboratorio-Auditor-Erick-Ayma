package com.fotoable.youtube.music.ui.dialog;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import butterknife.Unbinder;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class CloseFeatureDialogFragment extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    Unbinder f4056a;

    /* renamed from: b  reason: collision with root package name */
    private a f4057b;

    /* renamed from: c  reason: collision with root package name */
    private String f4058c;
    @BindView(R.id.tv_desc)
    TextView tvDesc;

    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public static CloseFeatureDialogFragment a(FragmentManager fragmentManager, String str, a aVar) {
        try {
            CloseFeatureDialogFragment closeFeatureDialogFragment = new CloseFeatureDialogFragment();
            try {
                closeFeatureDialogFragment.f4057b = aVar;
                closeFeatureDialogFragment.f4058c = str;
                closeFeatureDialogFragment.show(fragmentManager, (String) null);
                return closeFeatureDialogFragment;
            } catch (Exception e) {
                return closeFeatureDialogFragment;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().requestWindowFeature(1);
        View inflate = layoutInflater.inflate(R.layout.dialog_close_feature, viewGroup, false);
        this.f4056a = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        setCancelable(true);
        this.tvDesc.setText(this.f4058c);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // android.support.v4.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f4056a != null) {
            this.f4056a.unbind();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.btn_keep_it})
    @Optional
    public void onCancleClick() {
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.btn_turn_off})
    @Optional
    public void onApplyClick() {
        if (this.f4057b != null) {
            this.f4057b.a();
        }
        dismissAllowingStateLoss();
    }
}

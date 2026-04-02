package com.fotoable.youtube.music.ui.dialog;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import butterknife.OnClick;
import butterknife.Optional;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.dialog.b;
/* loaded from: classes.dex */
public class ChargingTipDialogFragment extends b {

    /* renamed from: c  reason: collision with root package name */
    private a f4048c;

    /* loaded from: classes.dex */
    public interface a {
    }

    public static ChargingTipDialogFragment a(FragmentManager fragmentManager, b.a aVar, a aVar2) {
        try {
            ChargingTipDialogFragment chargingTipDialogFragment = new ChargingTipDialogFragment();
            try {
                chargingTipDialogFragment.f4429a = aVar;
                chargingTipDialogFragment.f4048c = aVar2;
                chargingTipDialogFragment.show(fragmentManager, "ChargingTipDialogFragment");
                return chargingTipDialogFragment;
            } catch (Exception e) {
                return chargingTipDialogFragment;
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
        com.fotoable.youtube.music.util.b.b("充电锁屏提示弹出次数");
        return layoutInflater.inflate(R.layout.dialog_tip_charging_lockscreen, viewGroup, false);
    }

    @Override // com.fotoable.youtube.music.ui.dialog.b, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        setCancelable(false);
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        attributes.width = com.fotoable.youtube.music.util.w.a(getContext(), 320.0f);
        getDialog().getWindow().setAttributes(attributes);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setWindowAnimations(R.style.dialogWindowAnim);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.fotoable.youtube.music.ui.dialog.d

            /* renamed from: a  reason: collision with root package name */
            private final ChargingTipDialogFragment f4433a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4433a = this;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return this.f4433a.b(dialogInterface, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean b(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            dismissAllowingStateLoss();
            return true;
        }
        return false;
    }

    @Override // com.fotoable.youtube.music.ui.dialog.b, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.fotoable.youtube.music.ui.dialog.b, android.support.v4.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        if (this.f4429a != null) {
            this.f4429a.a();
        }
    }

    @Override // com.fotoable.youtube.music.ui.dialog.b
    public void a() {
        super.a();
        com.fotoable.youtube.music.util.b.b("充电锁屏", "提示dialog", "返回键取消");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.iv_charging_lockscreen_activity_back})
    @Optional
    public void onCancleClick() {
        if (this.f4429a != null) {
            this.f4429a.a();
        }
        com.fotoable.youtube.music.util.b.b("充电锁屏", "提示dialog", "取消");
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.bt_open_charge_lockscreen})
    @Optional
    public void onApplyClick() {
        com.fotoable.youtube.music.util.b.b("充电锁屏", "提示dialog", "应用");
        if (this.f4429a != null) {
            this.f4429a.b();
        }
        dismissAllowingStateLoss();
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f4048c = null;
    }
}

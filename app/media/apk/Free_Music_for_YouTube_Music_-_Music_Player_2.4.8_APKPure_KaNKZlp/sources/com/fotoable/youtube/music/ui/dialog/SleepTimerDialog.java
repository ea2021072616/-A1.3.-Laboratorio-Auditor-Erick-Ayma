package com.fotoable.youtube.music.ui.dialog;

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
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.NumberPickerView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public class SleepTimerDialog extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    private static final String f4388b = SleepTimerDialog.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public a f4389a;

    /* renamed from: c  reason: collision with root package name */
    private FragmentManager f4390c;
    @BindView(R.id.cancel)
    TextView cancelTv;
    @BindView(R.id.clear)
    TextView clearTv;
    private Unbinder d;
    @BindView(R.id.picker_hour)
    NumberPickerView picker_hour;
    @BindView(R.id.picker_minute)
    NumberPickerView picker_minute;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void a(long j, int i, int i2);

        void b();
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().requestWindowFeature(1);
        return layoutInflater.inflate(R.layout.dialog_timer, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.d = ButterKnife.bind(this, view);
        a(this.picker_hour, 0, 12, 0);
        a(this.picker_minute, 0, 59, 30);
        setCancelable(false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setWindowAnimations(R.style.dialogWindowAnim);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.fotoable.youtube.music.ui.dialog.af

            /* renamed from: a  reason: collision with root package name */
            private final SleepTimerDialog f4428a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4428a = this;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return this.f4428a.a(dialogInterface, i, keyEvent);
            }
        });
        this.cancelTv.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.SleepTimerDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SleepTimerDialog.this.f4389a != null) {
                    SleepTimerDialog.this.f4389a.b();
                }
                SleepTimerDialog.this.dismiss();
            }
        });
        this.clearTv.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.SleepTimerDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SleepTimerDialog.this.f4389a != null) {
                    int parseInt = Integer.parseInt(SleepTimerDialog.this.picker_hour.getContentByCurrValue());
                    int parseInt2 = Integer.parseInt(SleepTimerDialog.this.picker_minute.getContentByCurrValue());
                    com.fotoable.youtube.music.util.h.a(SleepTimerDialog.f4388b, "hour:" + parseInt + ",min:" + parseInt2);
                    SleepTimerDialog.this.f4389a.a((parseInt * 60 * 60) + (parseInt2 * 60), parseInt, parseInt2);
                }
                SleepTimerDialog.this.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            try {
                if (this.f4389a != null) {
                    this.f4389a.a();
                }
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
            dismissAllowingStateLoss();
            onCancel(dialogInterface);
            return true;
        }
        return false;
    }

    private void a(NumberPickerView numberPickerView, int i, int i2, int i3) {
        numberPickerView.setMinValue(i);
        numberPickerView.setMaxValue(i2);
        numberPickerView.setValue(i3);
    }

    public void a(a aVar) {
        this.f4389a = aVar;
    }

    public static SleepTimerDialog a(FragmentManager fragmentManager, a aVar) {
        SleepTimerDialog sleepTimerDialog;
        Exception e;
        try {
            sleepTimerDialog = new SleepTimerDialog();
        } catch (Exception e2) {
            sleepTimerDialog = null;
            e = e2;
        }
        try {
            sleepTimerDialog.f4390c = fragmentManager;
            sleepTimerDialog.a(aVar);
            fragmentManager.beginTransaction().add(sleepTimerDialog, "SleepTimerDialog").commitAllowingStateLoss();
        } catch (Exception e3) {
            e = e3;
            ThrowableExtension.printStackTrace(e);
            return sleepTimerDialog;
        }
        return sleepTimerDialog;
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            if (this.f4390c != null) {
                this.f4390c.beginTransaction().remove(this).commitAllowingStateLoss();
            }
            super.dismiss();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.d != null) {
            this.d.unbind();
            this.d = null;
        }
    }
}

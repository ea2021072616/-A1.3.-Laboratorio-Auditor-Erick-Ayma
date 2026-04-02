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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.fotoable.free.music.R;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public class PopUpSizeSelectDialog extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public a f4320a;

    /* renamed from: b  reason: collision with root package name */
    private FragmentManager f4321b;

    /* renamed from: c  reason: collision with root package name */
    private Unbinder f4322c;
    @BindView(R.id.cancel)
    TextView cancelTv;
    @BindView(R.id.ck_big)
    CheckBox ck_big;
    @BindView(R.id.ck_max)
    CheckBox ck_max;
    @BindView(R.id.ck_medium)
    CheckBox ck_medium;
    @BindView(R.id.ck_small)
    CheckBox ck_small;
    @BindView(R.id.clear)
    TextView clearTv;
    private int d;
    private int e;
    @BindView(R.id.rl_big)
    RelativeLayout rl_big;
    @BindView(R.id.rl_max)
    RelativeLayout rl_max;
    @BindView(R.id.rl_medium)
    RelativeLayout rl_medium;
    @BindView(R.id.rl_small)
    RelativeLayout rl_small;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().requestWindowFeature(1);
        return layoutInflater.inflate(R.layout.dialog_pop_up_size_select, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f4322c = ButterKnife.bind(this, view);
        setCancelable(false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setWindowAnimations(R.style.dialogWindowAnim);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.fotoable.youtube.music.ui.dialog.v

            /* renamed from: a  reason: collision with root package name */
            private final PopUpSizeSelectDialog f4476a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4476a = this;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return this.f4476a.a(dialogInterface, i, keyEvent);
            }
        });
        this.d = com.fotoable.youtube.music.a.s();
        com.fotoable.youtube.music.util.h.a("Dialog", "" + this.d);
        if (this.d == 1) {
            this.ck_small.setChecked(true);
        } else if (this.d == 2) {
            this.ck_medium.setChecked(true);
        } else if (this.d == 3) {
            this.ck_big.setChecked(true);
        } else if (this.d == 4) {
            this.ck_max.setChecked(true);
        }
        this.ck_small.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.fotoable.youtube.music.ui.dialog.PopUpSizeSelectDialog.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    PopUpSizeSelectDialog.this.e = 1;
                }
            }
        });
        this.ck_medium.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.fotoable.youtube.music.ui.dialog.PopUpSizeSelectDialog.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    PopUpSizeSelectDialog.this.e = 2;
                }
            }
        });
        this.ck_big.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.fotoable.youtube.music.ui.dialog.PopUpSizeSelectDialog.4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    PopUpSizeSelectDialog.this.e = 3;
                }
            }
        });
        this.ck_max.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.fotoable.youtube.music.ui.dialog.PopUpSizeSelectDialog.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    PopUpSizeSelectDialog.this.e = 4;
                }
            }
        });
        this.rl_small.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.PopUpSizeSelectDialog.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PopUpSizeSelectDialog.this.ck_small.setChecked(true);
                PopUpSizeSelectDialog.this.ck_medium.setChecked(false);
                PopUpSizeSelectDialog.this.ck_big.setChecked(false);
                PopUpSizeSelectDialog.this.ck_max.setChecked(false);
            }
        });
        this.rl_medium.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.PopUpSizeSelectDialog.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PopUpSizeSelectDialog.this.ck_small.setChecked(false);
                PopUpSizeSelectDialog.this.ck_medium.setChecked(true);
                PopUpSizeSelectDialog.this.ck_big.setChecked(false);
                PopUpSizeSelectDialog.this.ck_max.setChecked(false);
            }
        });
        this.rl_big.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.PopUpSizeSelectDialog.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PopUpSizeSelectDialog.this.ck_small.setChecked(false);
                PopUpSizeSelectDialog.this.ck_medium.setChecked(false);
                PopUpSizeSelectDialog.this.ck_big.setChecked(true);
                PopUpSizeSelectDialog.this.ck_max.setChecked(false);
            }
        });
        this.rl_max.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.PopUpSizeSelectDialog.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PopUpSizeSelectDialog.this.ck_small.setChecked(false);
                PopUpSizeSelectDialog.this.ck_medium.setChecked(false);
                PopUpSizeSelectDialog.this.ck_big.setChecked(false);
                PopUpSizeSelectDialog.this.ck_max.setChecked(true);
            }
        });
        this.cancelTv.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.PopUpSizeSelectDialog.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.fotoable.youtube.music.a.a(PopUpSizeSelectDialog.this.d);
                if (PopUpSizeSelectDialog.this.f4320a != null) {
                    PopUpSizeSelectDialog.this.f4320a.b();
                }
                PopUpSizeSelectDialog.this.dismiss();
            }
        });
        this.clearTv.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.PopUpSizeSelectDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.fotoable.youtube.music.a.a(PopUpSizeSelectDialog.this.e);
                if (PopUpSizeSelectDialog.this.f4320a != null) {
                    PopUpSizeSelectDialog.this.f4320a.c();
                }
                PopUpSizeSelectDialog.this.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            com.fotoable.youtube.music.a.a(this.d);
            try {
                if (this.f4320a != null) {
                    this.f4320a.a();
                }
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
            dismissAllowingStateLoss();
            dismiss();
            return true;
        }
        return false;
    }

    public void a(a aVar) {
        this.f4320a = aVar;
    }

    public static PopUpSizeSelectDialog a(FragmentManager fragmentManager, a aVar) {
        PopUpSizeSelectDialog popUpSizeSelectDialog;
        Exception e;
        try {
            popUpSizeSelectDialog = new PopUpSizeSelectDialog();
        } catch (Exception e2) {
            popUpSizeSelectDialog = null;
            e = e2;
        }
        try {
            popUpSizeSelectDialog.f4321b = fragmentManager;
            popUpSizeSelectDialog.a(aVar);
            fragmentManager.beginTransaction().add(popUpSizeSelectDialog, "SimpleMusicDialog").commitAllowingStateLoss();
        } catch (Exception e3) {
            e = e3;
            ThrowableExtension.printStackTrace(e);
            return popUpSizeSelectDialog;
        }
        return popUpSizeSelectDialog;
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            if (this.f4321b != null) {
                this.f4321b.beginTransaction().remove(this).commitAllowingStateLoss();
            }
            super.dismiss();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f4322c != null) {
            this.f4322c.unbind();
            this.f4322c = null;
        }
    }
}

package com.fotoable.youtube.music.ui.dialog;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class InputTextDialog extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    private static final String f4111b = InputTextDialog.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    Unbinder f4112a;

    /* renamed from: c  reason: collision with root package name */
    private FragmentManager f4113c;
    @BindView(R.id.cancel_tx)
    LaToTextView cancelTx;
    private int d;
    private String e;
    private int f;
    private int g;
    private int h;
    private TextWatcher i = new TextWatcher() { // from class: com.fotoable.youtube.music.ui.dialog.InputTextDialog.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            InputTextDialog.this.mCountTx.setText(editable.toString().trim().length() + "/" + InputTextDialog.this.f);
            if (editable.toString().trim().length() <= InputTextDialog.this.f && editable.toString().trim().length() >= InputTextDialog.this.h) {
                InputTextDialog.this.mCountTx.setTextColor(InputTextDialog.this.getResources().getColor(R.color.color_2b2525));
                InputTextDialog.this.okTx.setEnabled(true);
                return;
            }
            InputTextDialog.this.mCountTx.setTextColor(InputTextDialog.this.getResources().getColor(R.color.color_c8c7cc));
            InputTextDialog.this.okTx.setEnabled(false);
        }
    };
    private a j;
    @BindView(R.id.playlist_edit_count_tx)
    LaToTextView mCountTx;
    @BindView(R.id.playlist_edit)
    EditText mEdit;
    @BindView(R.id.playlist_title_tx)
    LaToTextView mTitleTx;
    @BindView(R.id.ok_tx)
    LaToTextView okTx;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void a(String str);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().requestWindowFeature(1);
        View inflate = layoutInflater.inflate(R.layout.dialog_input_text, viewGroup, false);
        this.f4112a = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        setCancelable(false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.fotoable.youtube.music.ui.dialog.m

            /* renamed from: a  reason: collision with root package name */
            private final InputTextDialog f4463a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4463a = this;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return this.f4463a.a(dialogInterface, i, keyEvent);
            }
        });
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.j != null) {
                this.j.a();
            }
            dismissAllowingStateLoss();
            onCancel(dialogInterface);
            return true;
        }
        return false;
    }

    private void a() {
        if (!TextUtils.isEmpty(this.e)) {
            this.mEdit.setText(this.e);
            this.mEdit.setSelection(this.e.length());
        }
        this.mEdit.setHint(this.g);
        this.mEdit.setFocusable(true);
        this.mEdit.setFocusableInTouchMode(true);
        this.mEdit.requestFocus();
        this.mEdit.addTextChangedListener(this.i);
        if (this.d != 0) {
            this.mTitleTx.setText(this.d);
        }
        rx.f.b(300L, TimeUnit.MILLISECONDS).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<Long>() { // from class: com.fotoable.youtube.music.ui.dialog.InputTextDialog.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(Long l) {
                ((InputMethodManager) InputTextDialog.this.mEdit.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
            }
        });
    }

    @OnClick({R.id.cancel_tx, R.id.ok_tx})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ok_tx /* 2131821095 */:
                if (this.j != null) {
                    this.j.a(this.mEdit.getText().toString().trim());
                }
                dismiss();
                return;
            case R.id.cancel_tx /* 2131821096 */:
                dismiss();
                if (this.j != null) {
                    this.j.a();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void a(a aVar) {
        this.j = aVar;
    }

    public static InputTextDialog a(FragmentManager fragmentManager, int i, int i2, String str, int i3, int i4, a aVar) {
        InputTextDialog inputTextDialog;
        Exception e;
        try {
            inputTextDialog = new InputTextDialog();
            try {
                inputTextDialog.g = i;
                inputTextDialog.d = i2;
                inputTextDialog.e = str;
                inputTextDialog.h = i3;
                inputTextDialog.f = i4;
                inputTextDialog.f4113c = fragmentManager;
                inputTextDialog.a(aVar);
                fragmentManager.beginTransaction().add(inputTextDialog, "InputTextDialog").commitAllowingStateLoss();
            } catch (Exception e2) {
                e = e2;
                ThrowableExtension.printStackTrace(e);
                return inputTextDialog;
            }
        } catch (Exception e3) {
            inputTextDialog = null;
            e = e3;
        }
        return inputTextDialog;
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            if (this.f4113c != null) {
                this.f4113c.beginTransaction().remove(this).commitAllowingStateLoss();
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        super.dismiss();
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        try {
            if (this.f4112a != null) {
                this.f4112a.unbind();
            }
            com.fotoable.youtube.music.newplayer.e.a().a(1);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }
}

package com.fotoable.youtube.music.ui.dialog;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.bean.PlayListModel;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class PlayListEditDialog extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    private static final String f4279b = PlayListEditDialog.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    Unbinder f4280a;

    /* renamed from: c  reason: collision with root package name */
    private int f4281c;
    @BindView(R.id.cancel_tx)
    LaToTextView cancelTx;
    private FragmentManager d;
    private PlayMusicModel e;
    private com.fotoable.youtube.music.db.a g;
    private String h;
    @BindView(R.id.playlist_edit_count_tx)
    LaToTextView mCountTx;
    @BindView(R.id.playlist_edit)
    EditText mEdit;
    @BindView(R.id.playlist_title_tx)
    LaToTextView mTitleTx;
    @BindView(R.id.ok_tx)
    LaToTextView okTx;
    private long f = -1;
    private TextWatcher i = new TextWatcher() { // from class: com.fotoable.youtube.music.ui.dialog.PlayListEditDialog.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            PlayListEditDialog.this.mCountTx.setText(editable.toString().trim().length() + "/40");
            if (editable.toString().trim().length() <= 40 && editable.toString().trim().length() > 0) {
                PlayListEditDialog.this.mCountTx.setTextColor(PlayListEditDialog.this.getResources().getColor(R.color.color_2b2525));
                PlayListEditDialog.this.okTx.setEnabled(true);
                return;
            }
            PlayListEditDialog.this.mCountTx.setTextColor(PlayListEditDialog.this.getResources().getColor(R.color.color_c8c7cc));
            PlayListEditDialog.this.okTx.setEnabled(false);
        }
    };

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().requestWindowFeature(1);
        View inflate = layoutInflater.inflate(R.layout.dialog_playlist_edit, viewGroup, false);
        this.f4280a = ButterKnife.bind(this, inflate);
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
        this.g = MusicApplication.c().e().d();
        if (!TextUtils.isEmpty(this.h)) {
            this.mEdit.setText(this.h);
            this.mEdit.setSelection(this.h.length());
        }
        this.mEdit.setFocusable(true);
        this.mEdit.setFocusableInTouchMode(true);
        this.mEdit.requestFocus();
        this.mEdit.addTextChangedListener(this.i);
        if (this.f4281c != 0) {
            this.mTitleTx.setText(this.f4281c);
        }
        rx.f.b(300L, TimeUnit.MILLISECONDS).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<Long>() { // from class: com.fotoable.youtube.music.ui.dialog.PlayListEditDialog.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(Long l) {
                ((InputMethodManager) PlayListEditDialog.this.mEdit.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
            }
        });
    }

    public static PlayListEditDialog a(FragmentManager fragmentManager, PlayMusicModel playMusicModel) {
        PlayListEditDialog playListEditDialog;
        Exception e;
        try {
            playListEditDialog = new PlayListEditDialog();
        } catch (Exception e2) {
            playListEditDialog = null;
            e = e2;
        }
        try {
            playListEditDialog.f4281c = R.string.new_playlist;
            playListEditDialog.e = playMusicModel;
            playListEditDialog.d = fragmentManager;
            fragmentManager.beginTransaction().add(playListEditDialog, "PlayListCreateDialog").commitAllowingStateLoss();
        } catch (Exception e3) {
            e = e3;
            ThrowableExtension.printStackTrace(e);
            return playListEditDialog;
        }
        return playListEditDialog;
    }

    public static PlayListEditDialog a(FragmentManager fragmentManager, long j, String str) {
        PlayListEditDialog playListEditDialog;
        Exception e;
        try {
            playListEditDialog = new PlayListEditDialog();
        } catch (Exception e2) {
            playListEditDialog = null;
            e = e2;
        }
        try {
            playListEditDialog.f4281c = R.string.rename_playlist;
            playListEditDialog.f = j;
            playListEditDialog.h = str;
            playListEditDialog.d = fragmentManager;
            fragmentManager.beginTransaction().add(playListEditDialog, "PlayListEditDialog").commitAllowingStateLoss();
        } catch (Exception e3) {
            e = e3;
            ThrowableExtension.printStackTrace(e);
            return playListEditDialog;
        }
        return playListEditDialog;
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            if (this.d != null) {
                this.d.beginTransaction().remove(this).commitAllowingStateLoss();
            }
            super.dismiss();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        try {
            if (this.f4280a != null) {
                this.f4280a.unbind();
            }
            com.fotoable.youtube.music.newplayer.e.a().a(1);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @OnClick({R.id.cancel_tx, R.id.ok_tx})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ok_tx /* 2131821095 */:
                b();
                return;
            case R.id.cancel_tx /* 2131821096 */:
                dismiss();
                return;
            default:
                return;
        }
    }

    private void b() {
        if (!TextUtils.isEmpty(this.mEdit.getText().toString()) && this.mEdit.getText().toString().trim().length() <= 40) {
            if (this.e == null) {
                if (this.f >= 0) {
                    this.g.a(Long.valueOf(this.f), this.mEdit.getText().toString().trim());
                    Toast.makeText(getActivity(), (int) R.string.success, 0).show();
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(1040, Long.valueOf(this.f), this.mEdit.getText().toString().trim()));
                } else {
                    PlayListModel playListModel = new PlayListModel();
                    playListModel.setDate(System.currentTimeMillis() + "");
                    playListModel.setId(null);
                    playListModel.setName(this.mEdit.getText().toString().trim());
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(1039, Long.valueOf(this.g.a(playListModel))));
                    com.fotoable.youtube.music.util.b.b("dev_playlist_create");
                }
            } else {
                PlayListModel playListModel2 = new PlayListModel();
                playListModel2.setDate(System.currentTimeMillis() + "");
                playListModel2.setId(null);
                playListModel2.setName(this.mEdit.getText().toString().trim());
                Long valueOf = Long.valueOf(this.g.a(playListModel2));
                this.e.setPlaylistId(valueOf);
                this.g.a(this.e);
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(1039, valueOf));
                com.fotoable.youtube.music.util.b.b("dev_playlist_create");
            }
            dismiss();
        }
    }
}

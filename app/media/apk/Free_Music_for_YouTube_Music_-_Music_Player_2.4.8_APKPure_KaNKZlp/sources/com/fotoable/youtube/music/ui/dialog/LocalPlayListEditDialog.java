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
import com.fotoable.youtube.music.bean.LocalPlayListModel;
import com.fotoable.youtube.music.bean.LocalPlayListMusicModel;
import com.fotoable.youtube.music.bean.LocalSongBean;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class LocalPlayListEditDialog extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    private static final String f4178b = LocalPlayListEditDialog.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    Unbinder f4179a;

    /* renamed from: c  reason: collision with root package name */
    private int f4180c;
    @BindView(R.id.cancel_tx)
    LaToTextView cancelTx;
    private FragmentManager d;
    private LocalPlayListMusicModel e;
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
    private TextWatcher i = new TextWatcher() { // from class: com.fotoable.youtube.music.ui.dialog.LocalPlayListEditDialog.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            LocalPlayListEditDialog.this.mCountTx.setText(editable.toString().trim().length() + "/40");
            if (editable.toString().trim().length() <= 40 && editable.toString().trim().length() > 0) {
                LocalPlayListEditDialog.this.mCountTx.setTextColor(LocalPlayListEditDialog.this.getResources().getColor(R.color.color_2b2525));
                LocalPlayListEditDialog.this.okTx.setEnabled(true);
                return;
            }
            LocalPlayListEditDialog.this.mCountTx.setTextColor(LocalPlayListEditDialog.this.getResources().getColor(R.color.color_c8c7cc));
            LocalPlayListEditDialog.this.okTx.setEnabled(false);
        }
    };

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().requestWindowFeature(1);
        View inflate = layoutInflater.inflate(R.layout.dialog_playlist_edit, viewGroup, false);
        this.f4179a = ButterKnife.bind(this, inflate);
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
        if (this.f4180c != 0) {
            this.mTitleTx.setText(this.f4180c);
        }
        rx.f.b(300L, TimeUnit.MILLISECONDS).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<Long>() { // from class: com.fotoable.youtube.music.ui.dialog.LocalPlayListEditDialog.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(Long l) {
                ((InputMethodManager) LocalPlayListEditDialog.this.mEdit.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
            }
        });
    }

    public static LocalPlayListEditDialog a(FragmentManager fragmentManager, LocalSongBean localSongBean) {
        LocalPlayListMusicModel localPlayListMusicModel = new LocalPlayListMusicModel();
        localPlayListMusicModel.setSongId(localSongBean.getSongId());
        return a(fragmentManager, localPlayListMusicModel);
    }

    public static LocalPlayListEditDialog a(FragmentManager fragmentManager, LocalPlayListMusicModel localPlayListMusicModel) {
        LocalPlayListEditDialog localPlayListEditDialog;
        Exception e;
        try {
            localPlayListEditDialog = new LocalPlayListEditDialog();
        } catch (Exception e2) {
            localPlayListEditDialog = null;
            e = e2;
        }
        try {
            localPlayListEditDialog.f4180c = R.string.new_playlist;
            localPlayListEditDialog.e = localPlayListMusicModel;
            localPlayListEditDialog.d = fragmentManager;
            fragmentManager.beginTransaction().add(localPlayListEditDialog, "LocalPlayListEditDialog").commitAllowingStateLoss();
        } catch (Exception e3) {
            e = e3;
            ThrowableExtension.printStackTrace(e);
            return localPlayListEditDialog;
        }
        return localPlayListEditDialog;
    }

    public static LocalPlayListEditDialog a(FragmentManager fragmentManager, long j, String str) {
        LocalPlayListEditDialog localPlayListEditDialog;
        Exception e;
        try {
            localPlayListEditDialog = new LocalPlayListEditDialog();
        } catch (Exception e2) {
            localPlayListEditDialog = null;
            e = e2;
        }
        try {
            localPlayListEditDialog.f4180c = R.string.rename_playlist;
            localPlayListEditDialog.f = j;
            localPlayListEditDialog.h = str;
            localPlayListEditDialog.d = fragmentManager;
            fragmentManager.beginTransaction().add(localPlayListEditDialog, "LocalPlayListEditDialog").commitAllowingStateLoss();
        } catch (Exception e3) {
            e = e3;
            ThrowableExtension.printStackTrace(e);
            return localPlayListEditDialog;
        }
        return localPlayListEditDialog;
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            if (this.d != null) {
                this.d.beginTransaction().remove(this).commitAllowingStateLoss();
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
            if (this.f4179a != null) {
                this.f4179a.unbind();
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
                    this.g.d(Long.valueOf(this.f), this.mEdit.getText().toString().trim());
                    Toast.makeText(getContext(), (int) R.string.success, 0).show();
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2015));
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2016));
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2017, Long.valueOf(this.f), this.mEdit.getText().toString().trim()));
                } else {
                    LocalPlayListModel localPlayListModel = new LocalPlayListModel();
                    localPlayListModel.setCreateTime(Long.valueOf(System.currentTimeMillis()));
                    localPlayListModel.setModifyTime(Long.valueOf(System.currentTimeMillis()));
                    localPlayListModel.setName(this.mEdit.getText().toString().trim());
                    this.g.a(localPlayListModel);
                    Toast.makeText(MusicApplication.c(), (int) R.string.added, 0).show();
                    com.fotoable.youtube.music.util.h.a(f4178b, "创建歌单成功 1");
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2015));
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2016));
                }
            } else {
                LocalPlayListModel localPlayListModel2 = new LocalPlayListModel();
                localPlayListModel2.setCreateTime(Long.valueOf(System.currentTimeMillis()));
                localPlayListModel2.setModifyTime(Long.valueOf(System.currentTimeMillis()));
                localPlayListModel2.setName(this.mEdit.getText().toString().trim());
                this.g.a(localPlayListModel2);
                this.e.setPlayListId(localPlayListModel2.getId());
                this.e.setCreateTime(Long.valueOf(System.currentTimeMillis()));
                this.g.a(this.e);
                com.fotoable.youtube.music.util.h.a(f4178b, "创建歌单成功 2");
                Toast.makeText(MusicApplication.c(), (int) R.string.added, 0).show();
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2015));
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2016));
            }
            dismiss();
        }
    }
}

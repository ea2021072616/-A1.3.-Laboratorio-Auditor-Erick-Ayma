package com.fotoable.youtube.music.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class MyRecentyWatchMenuDialog extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    private static final String f4255b = MyRecentyWatchMenuDialog.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    Unbinder f4256a;

    /* renamed from: c  reason: collision with root package name */
    private String f4257c;
    private a d;
    @BindView(R.id.lin_artist)
    LinearLayout linArtist;
    @BindView(R.id.txt_artists)
    TextView txtArtists;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();

        void h();

        void i();
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f4256a = ButterKnife.bind(this, view);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.fotoable.youtube.music.ui.dialog.t

            /* renamed from: a  reason: collision with root package name */
            private final MyRecentyWatchMenuDialog f4474a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4474a = this;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return this.f4474a.a(dialogInterface, i, keyEvent);
            }
        });
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        getDialog().getWindow().setGravity(80);
        Window window = getDialog().getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
        getDialog().setCancelable(true);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.down_fragment_alpha)));
        getDialog().getWindow().setWindowAnimations(R.style.download_popup_animation);
        if (TextUtils.isEmpty(this.f4257c)) {
            this.linArtist.setVisibility(8);
            return;
        }
        this.linArtist.setVisibility(0);
        this.txtArtists.setText(getResources().getString(R.string.artist) + " " + this.f4257c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            dismissAllowingStateLoss();
            onCancel(dialogInterface);
            return true;
        }
        return false;
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        getDialog().requestWindowFeature(1);
        setCancelable(true);
        return layoutInflater.inflate(R.layout.dialog_recently_watched_menu, viewGroup, false);
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog == null) {
            super.setShowsDialog(false);
        }
        return onCreateDialog;
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f4256a.unbind();
    }

    @OnClick({R.id.lin_add, R.id.lin_play_now, R.id.lin_play_next, R.id.lin_delete, R.id.lin_find_mp3, R.id.lin_copy_url, R.id.lin_share, R.id.lin_find_lyric, R.id.lin_artist})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lin_find_lyric /* 2131821050 */:
                if (this.d != null) {
                    this.d.g();
                    return;
                }
                return;
            case R.id.lin_artist /* 2131821051 */:
                if (this.d != null) {
                    this.d.i();
                    return;
                }
                return;
            case R.id.lin_delete /* 2131821058 */:
                if (this.d != null) {
                    this.d.d();
                    return;
                }
                return;
            case R.id.lin_share /* 2131821068 */:
                if (this.d != null) {
                    this.d.h();
                    return;
                }
                return;
            case R.id.lin_copy_url /* 2131821069 */:
                if (this.d != null) {
                    this.d.f();
                    return;
                }
                return;
            case R.id.lin_find_mp3 /* 2131821071 */:
                if (this.d != null) {
                    this.d.e();
                    return;
                }
                return;
            case R.id.lin_play_now /* 2131821089 */:
                if (this.d != null) {
                    this.d.a();
                    return;
                }
                return;
            case R.id.lin_play_next /* 2131821090 */:
                if (this.d != null) {
                    this.d.b();
                    return;
                }
                return;
            case R.id.lin_add /* 2131821091 */:
                if (this.d != null) {
                    this.d.c();
                    return;
                }
                return;
            default:
                return;
        }
    }
}

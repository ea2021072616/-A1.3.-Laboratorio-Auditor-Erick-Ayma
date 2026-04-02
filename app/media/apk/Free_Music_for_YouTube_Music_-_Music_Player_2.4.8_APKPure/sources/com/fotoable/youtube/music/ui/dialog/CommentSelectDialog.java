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
import butterknife.OnClick;
import butterknife.Unbinder;
import com.fotoable.free.music.R;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public class CommentSelectDialog extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    private static final String f4082b = CommentSelectDialog.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    Unbinder f4083a;

    /* renamed from: c  reason: collision with root package name */
    private FragmentManager f4084c;
    @BindView(R.id.copy_comment)
    TextView copy_comment;
    private boolean d;
    @BindView(R.id.delete_comment)
    TextView delete_comment;
    private a e;
    @BindView(R.id.reply_comment)
    TextView reply_comment;
    @BindView(R.id.report_comment)
    TextView report_comment;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();

        void c();

        void d();
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().requestWindowFeature(1);
        View inflate = layoutInflater.inflate(R.layout.dialog_comment_select, viewGroup, false);
        this.f4083a = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        setCancelable(true);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.fotoable.youtube.music.ui.dialog.f

            /* renamed from: a  reason: collision with root package name */
            private final CommentSelectDialog f4435a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4435a = this;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return this.f4435a.a(dialogInterface, i, keyEvent);
            }
        });
        a();
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

    private void a() {
        if (this.d) {
            this.report_comment.setVisibility(8);
            this.delete_comment.setVisibility(0);
        }
    }

    @OnClick({R.id.reply_comment, R.id.copy_comment, R.id.report_comment, R.id.delete_comment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.reply_comment /* 2131821011 */:
                if (this.e != null) {
                    this.e.a();
                    break;
                }
                break;
            case R.id.copy_comment /* 2131821017 */:
                if (this.e != null) {
                    this.e.b();
                    break;
                }
                break;
            case R.id.report_comment /* 2131821018 */:
                if (this.e != null) {
                    this.e.c();
                    break;
                }
                break;
            case R.id.delete_comment /* 2131821019 */:
                if (this.e != null) {
                    this.e.d();
                    break;
                }
                break;
        }
        dismiss();
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    public static CommentSelectDialog a(FragmentManager fragmentManager, boolean z, a aVar) {
        CommentSelectDialog commentSelectDialog;
        Exception e;
        try {
            commentSelectDialog = new CommentSelectDialog();
        } catch (Exception e2) {
            commentSelectDialog = null;
            e = e2;
        }
        try {
            commentSelectDialog.f4084c = fragmentManager;
            commentSelectDialog.d = z;
            commentSelectDialog.a(aVar);
            fragmentManager.beginTransaction().add(commentSelectDialog, "CommentSelectDialog").commitAllowingStateLoss();
        } catch (Exception e3) {
            e = e3;
            ThrowableExtension.printStackTrace(e);
            return commentSelectDialog;
        }
        return commentSelectDialog;
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            if (this.f4084c != null) {
                this.f4084c.beginTransaction().remove(this).commitAllowingStateLoss();
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
            if (this.f4083a != null) {
                this.f4083a.unbind();
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }
}

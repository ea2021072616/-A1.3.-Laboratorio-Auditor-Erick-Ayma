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
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.fotoable.free.music.R;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public class CommentReportDialog extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    private static final String f4066b = CommentReportDialog.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    Unbinder f4067a;

    /* renamed from: c  reason: collision with root package name */
    private FragmentManager f4068c;
    private a d;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().requestWindowFeature(1);
        View inflate = layoutInflater.inflate(R.layout.dialog_comment_report, viewGroup, false);
        this.f4067a = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        setCancelable(true);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.fotoable.youtube.music.ui.dialog.e

            /* renamed from: a  reason: collision with root package name */
            private final CommentReportDialog f4434a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4434a = this;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return this.f4434a.a(dialogInterface, i, keyEvent);
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
    }

    @OnClick({R.id.report_reason_1, R.id.report_reason_2, R.id.report_reason_3, R.id.report_reason_4, R.id.report_reason_5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.report_reason_1 /* 2131821012 */:
                if (this.d != null) {
                    this.d.a("骚扰或欺凌");
                    break;
                }
                break;
            case R.id.report_reason_2 /* 2131821013 */:
                if (this.d != null) {
                    this.d.a("过度宣传");
                    break;
                }
                break;
            case R.id.report_reason_3 /* 2131821014 */:
                if (this.d != null) {
                    this.d.a("仇恨言论或其他政治原因");
                    break;
                }
                break;
            case R.id.report_reason_4 /* 2131821015 */:
                if (this.d != null) {
                    this.d.a("色情和色情内容");
                    break;
                }
                break;
            case R.id.report_reason_5 /* 2131821016 */:
                if (this.d != null) {
                    this.d.a("其它原因");
                    break;
                }
                break;
        }
        dismiss();
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    public static CommentReportDialog a(FragmentManager fragmentManager, a aVar) {
        CommentReportDialog commentReportDialog;
        Exception e;
        try {
            commentReportDialog = new CommentReportDialog();
        } catch (Exception e2) {
            commentReportDialog = null;
            e = e2;
        }
        try {
            commentReportDialog.f4068c = fragmentManager;
            commentReportDialog.a(aVar);
            fragmentManager.beginTransaction().add(commentReportDialog, "CommentReportDialog").commitAllowingStateLoss();
        } catch (Exception e3) {
            e = e3;
            ThrowableExtension.printStackTrace(e);
            return commentReportDialog;
        }
        return commentReportDialog;
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            if (this.f4068c != null) {
                this.f4068c.beginTransaction().remove(this).commitAllowingStateLoss();
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
            if (this.f4067a != null) {
                this.f4067a.unbind();
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }
}

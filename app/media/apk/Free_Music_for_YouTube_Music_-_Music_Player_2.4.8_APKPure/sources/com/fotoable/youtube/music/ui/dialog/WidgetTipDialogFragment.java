package com.fotoable.youtube.music.ui.dialog;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Optional;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.TextureVideoView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.IOException;
/* loaded from: classes.dex */
public class WidgetTipDialogFragment extends b {
    @BindView(R.id.widget_video)
    TextureVideoView videoView;

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        com.fotoable.youtube.music.util.v.b(getContext(), "WIDGET_TIP_DIALOG_SHOW", true);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().requestWindowFeature(1);
        return layoutInflater.inflate(R.layout.dialog_weiget_tips, viewGroup, false);
    }

    @Override // com.fotoable.youtube.music.ui.dialog.b, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        setCancelable(false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setWindowAnimations(R.style.dialogWindowAnim);
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        try {
            this.videoView.setRawData(R.raw.widgettips);
            this.videoView.start();
        } catch (IOException e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.videoView.stop();
    }

    @Override // com.fotoable.youtube.music.ui.dialog.b, android.support.v4.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        try {
            this.videoView.stop();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.btn_ok})
    @Optional
    public void onApplyClick() {
        try {
            this.videoView.stop();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        if (this.f4429a != null) {
            this.f4429a.b();
        }
        dismissAllowingStateLoss();
    }
}

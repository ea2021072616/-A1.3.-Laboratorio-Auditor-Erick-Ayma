package com.fotoable.youtube.music.ui.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.LaToTextView;
/* loaded from: classes.dex */
public class ScanLocalMusicDialog_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private ScanLocalMusicDialog f4381a;

    @UiThread
    public ScanLocalMusicDialog_ViewBinding(ScanLocalMusicDialog scanLocalMusicDialog, View view) {
        this.f4381a = scanLocalMusicDialog;
        scanLocalMusicDialog.ivFinish = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_finish, "field 'ivFinish'", ImageView.class);
        scanLocalMusicDialog.ivScan = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_scan, "field 'ivScan'", ImageView.class);
        scanLocalMusicDialog.tvProgress = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_progress, "field 'tvProgress'", LaToTextView.class);
        scanLocalMusicDialog.tvScan = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_scan, "field 'tvScan'", LaToTextView.class);
        scanLocalMusicDialog.ivClose = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_close, "field 'ivClose'", ImageView.class);
        scanLocalMusicDialog.ckScan = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ck_scan, "field 'ckScan'", CheckBox.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ScanLocalMusicDialog scanLocalMusicDialog = this.f4381a;
        if (scanLocalMusicDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4381a = null;
        scanLocalMusicDialog.ivFinish = null;
        scanLocalMusicDialog.ivScan = null;
        scanLocalMusicDialog.tvProgress = null;
        scanLocalMusicDialog.tvScan = null;
        scanLocalMusicDialog.ivClose = null;
        scanLocalMusicDialog.ckScan = null;
    }
}

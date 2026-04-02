package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
@zzzt
@TargetApi(19)
/* loaded from: classes.dex */
public final class zzyh extends zzye {
    private Object zzcks;
    private PopupWindow zzckt;
    private boolean zzcku;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyh(Context context, zzafj zzafjVar, zzakk zzakkVar, zzyd zzydVar) {
        super(context, zzafjVar, zzakkVar, zzydVar);
        this.zzcks = new Object();
        this.zzcku = false;
    }

    private final void zznu() {
        synchronized (this.zzcks) {
            this.zzcku = true;
            if ((this.mContext instanceof Activity) && ((Activity) this.mContext).isDestroyed()) {
                this.zzckt = null;
            }
            if (this.zzckt != null) {
                if (this.zzckt.isShowing()) {
                    this.zzckt.dismiss();
                }
                this.zzckt = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzxw, com.google.android.gms.internal.zzahv
    public final void cancel() {
        zznu();
        super.cancel();
    }

    @Override // com.google.android.gms.internal.zzye
    protected final void zznt() {
        Window window = this.mContext instanceof Activity ? ((Activity) this.mContext).getWindow() : null;
        if (window == null || window.getDecorView() == null || ((Activity) this.mContext).isDestroyed()) {
            return;
        }
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        zzakk zzakkVar = this.zzbvz;
        if (zzakkVar == null) {
            throw null;
        }
        frameLayout.addView((View) zzakkVar, -1, -1);
        synchronized (this.zzcks) {
            if (this.zzcku) {
                return;
            }
            this.zzckt = new PopupWindow((View) frameLayout, 1, 1, false);
            this.zzckt.setOutsideTouchable(true);
            this.zzckt.setClippingEnabled(false);
            zzafx.zzcb("Displaying the 1x1 popup off the screen.");
            try {
                this.zzckt.showAtLocation(window.getDecorView(), 0, -1, -1);
            } catch (Exception e) {
                this.zzckt = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzxw
    public final void zzw(int i) {
        zznu();
        super.zzw(i);
    }
}

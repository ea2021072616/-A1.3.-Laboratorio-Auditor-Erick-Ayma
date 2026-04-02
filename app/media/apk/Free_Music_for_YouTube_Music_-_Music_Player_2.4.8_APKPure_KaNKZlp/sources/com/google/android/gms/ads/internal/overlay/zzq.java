package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.internal.zzahw;
import com.google.android.gms.internal.zzzt;
/* JADX INFO: Access modifiers changed from: package-private */
@zzzt
/* loaded from: classes.dex */
public final class zzq extends RelativeLayout {
    private zzahw zzaur;
    boolean zzcgs;

    public zzq(Context context, String str, String str2) {
        super(context);
        this.zzaur = new zzahw(context, str);
        this.zzaur.zzcn(str2);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zzcgs) {
            return false;
        }
        this.zzaur.zzf(motionEvent);
        return false;
    }
}

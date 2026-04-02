package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ViewSwitcher;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzahw;
import com.google.android.gms.internal.zzajd;
import com.google.android.gms.internal.zzakk;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class zzbx extends ViewSwitcher {
    private final zzahw zzaur;
    @Nullable
    private final zzajd zzaus;
    private boolean zzaut;

    public zzbx(Context context, String str, String str2, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        super(context);
        this.zzaur = new zzahw(context);
        this.zzaur.setAdUnitId(str);
        this.zzaur.zzcn(str2);
        this.zzaut = true;
        if (context instanceof Activity) {
            this.zzaus = new zzajd((Activity) context, this, onGlobalLayoutListener, onScrollChangedListener);
        } else {
            this.zzaus = new zzajd(null, this, onGlobalLayoutListener, onScrollChangedListener);
        }
        this.zzaus.zzrl();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.zzaus != null) {
            this.zzaus.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.zzaus != null) {
            this.zzaus.onDetachedFromWindow();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zzaut) {
            this.zzaur.zzf(motionEvent);
            return false;
        }
        return false;
    }

    @Override // android.widget.ViewAnimator, android.view.ViewGroup
    public final void removeAllViews() {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && (childAt instanceof zzakk)) {
                arrayList.add((zzakk) childAt);
            }
        }
        super.removeAllViews();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            ((zzakk) obj).destroy();
        }
    }

    public final zzahw zzfg() {
        return this.zzaur;
    }

    public final void zzfh() {
        zzafx.v("Disable position monitoring on adFrame.");
        if (this.zzaus != null) {
            this.zzaus.zzrm();
        }
    }

    public final void zzfi() {
        zzafx.v("Enable debug gesture detector on adFrame.");
        this.zzaut = true;
    }

    public final void zzfj() {
        zzafx.v("Disable debug gesture detector on adFrame.");
        this.zzaut = false;
    }
}

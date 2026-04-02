package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.formats.AdChoicesView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
@zzzt
/* loaded from: classes.dex */
public final class zzov extends zzph implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static String[] zzbth = {NativeAppInstallAd.ASSET_MEDIA_VIDEO, "1009"};
    @Nullable
    FrameLayout zzalr;
    @Nullable
    private zzoe zzbsb;
    private final FrameLayout zzbti;
    @Nullable
    private View zzbtk;
    private final Object mLock = new Object();
    private Map<String, WeakReference<View>> zzbtj = new HashMap();
    private boolean zzbtl = false;
    private Point zzbtm = new Point();
    private Point zzbtn = new Point();
    private WeakReference<zzgi> zzbto = new WeakReference<>(null);

    @TargetApi(21)
    public zzov(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.zzbti = frameLayout;
        this.zzalr = frameLayout2;
        com.google.android.gms.ads.internal.zzbv.zzey();
        zzakf.zza((View) this.zzbti, (ViewTreeObserver.OnGlobalLayoutListener) this);
        com.google.android.gms.ads.internal.zzbv.zzey();
        zzakf.zza((View) this.zzbti, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzbti.setOnTouchListener(this);
        this.zzbti.setOnClickListener(this);
        if (frameLayout2 != null && com.google.android.gms.common.util.zzp.zzalj()) {
            frameLayout2.setElevation(Float.MAX_VALUE);
        }
        zzmu.initialize(this.zzbti.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzoi zzoiVar) {
        View view;
        synchronized (this.mLock) {
            zzoiVar.zze(this.zzbtj);
            if (this.zzbtj != null) {
                for (String str : zzbth) {
                    WeakReference<View> weakReference = this.zzbtj.get(str);
                    if (weakReference != null) {
                        view = weakReference.get();
                        break;
                    }
                }
            }
            view = null;
            if (view instanceof FrameLayout) {
                zzoiVar.zza(view, new zzox(this, view));
            } else {
                zzoiVar.zzjx();
            }
        }
    }

    private final void zzg(@Nullable View view) {
        if (this.zzbsb != null) {
            zzoe zzjt = this.zzbsb instanceof zzod ? ((zzod) this.zzbsb).zzjt() : this.zzbsb;
            if (zzjt != null) {
                zzjt.zzg(view);
            }
        }
    }

    private final int zzr(int i) {
        zzjo.zzhu();
        return zzaje.zzd(this.zzbsb.getContext(), i);
    }

    @Override // com.google.android.gms.internal.zzpg
    public final void destroy() {
        synchronized (this.mLock) {
            if (this.zzalr != null) {
                this.zzalr.removeAllViews();
            }
            this.zzalr = null;
            this.zzbtj = null;
            this.zzbtk = null;
            this.zzbsb = null;
            this.zzbtm = null;
            this.zzbtn = null;
            this.zzbto = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        synchronized (this.mLock) {
            if (this.zzbsb == null) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("x", zzr(this.zzbtm.x));
            bundle.putFloat("y", zzr(this.zzbtm.y));
            bundle.putFloat("start_x", zzr(this.zzbtn.x));
            bundle.putFloat("start_y", zzr(this.zzbtn.y));
            if (this.zzbtk == null || !this.zzbtk.equals(view)) {
                this.zzbsb.zza(view, this.zzbtj, bundle, this.zzbti);
            } else if (!(this.zzbsb instanceof zzod)) {
                this.zzbsb.zza(view, NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE, bundle, this.zzbtj, this.zzbti);
            } else if (((zzod) this.zzbsb).zzjt() != null) {
                ((zzod) this.zzbsb).zzjt().zza(view, NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE, bundle, this.zzbtj, this.zzbti);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        synchronized (this.mLock) {
            if (this.zzbtl) {
                int measuredWidth = this.zzbti.getMeasuredWidth();
                int measuredHeight = this.zzbti.getMeasuredHeight();
                if (measuredWidth != 0 && measuredHeight != 0 && this.zzalr != null) {
                    this.zzalr.setLayoutParams(new FrameLayout.LayoutParams(measuredWidth, measuredHeight));
                    this.zzbtl = false;
                }
            }
            if (this.zzbsb != null) {
                this.zzbsb.zzc(this.zzbti, this.zzbtj);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        synchronized (this.mLock) {
            if (this.zzbsb != null) {
                this.zzbsb.zzc(this.zzbti, this.zzbtj);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.mLock) {
            if (this.zzbsb != null) {
                int[] iArr = new int[2];
                this.zzbti.getLocationOnScreen(iArr);
                Point point = new Point((int) (motionEvent.getRawX() - iArr[0]), (int) (motionEvent.getRawY() - iArr[1]));
                this.zzbtm = point;
                if (motionEvent.getAction() == 0) {
                    this.zzbtn = point;
                }
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setLocation(point.x, point.y);
                this.zzbsb.zzd(obtain);
                obtain.recycle();
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.zzpg
    public final IObjectWrapper zzak(String str) {
        synchronized (this.mLock) {
            if (this.zzbtj == null) {
                return null;
            }
            WeakReference<View> weakReference = this.zzbtj.get(str);
            return com.google.android.gms.dynamic.zzn.zzw(weakReference != null ? weakReference.get() : null);
        }
    }

    @Override // com.google.android.gms.internal.zzpg
    public final void zzb(IObjectWrapper iObjectWrapper, int i) {
        zzgi zzgiVar;
        if (com.google.android.gms.ads.internal.zzbv.zzez().zzt(this.zzbti.getContext()) && this.zzbto != null && (zzgiVar = this.zzbto.get()) != null) {
            zzgiVar.zzgc();
        }
        int measuredWidth = this.zzbti.getMeasuredWidth();
        int measuredHeight = this.zzbti.getMeasuredHeight();
        if (measuredWidth == 0 || measuredHeight == 0 || this.zzalr == null) {
            return;
        }
        this.zzalr.setLayoutParams(new FrameLayout.LayoutParams(measuredWidth, measuredHeight));
    }

    @Override // com.google.android.gms.internal.zzpg
    public final void zzd(String str, IObjectWrapper iObjectWrapper) {
        View view = (View) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper);
        synchronized (this.mLock) {
            if (this.zzbtj == null) {
                return;
            }
            if (view == null) {
                this.zzbtj.remove(str);
            } else {
                this.zzbtj.put(str, new WeakReference<>(view));
                if ("1098".equals(str)) {
                    return;
                }
                view.setOnTouchListener(this);
                view.setClickable(true);
                view.setOnClickListener(this);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzpg
    public final void zze(IObjectWrapper iObjectWrapper) {
        zzoi zzoiVar;
        zzoi zzoiVar2;
        ViewGroup viewGroup = null;
        synchronized (this.mLock) {
            zzg(null);
            Object zzab = com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper);
            if (!(zzab instanceof zzoi)) {
                zzafx.zzcs("Not an instance of native engine. This is most likely a transient error");
                return;
            }
            if (this.zzalr != null) {
                this.zzalr.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
                this.zzbti.requestLayout();
            }
            this.zzbtl = true;
            zzoi zzoiVar3 = (zzoi) zzab;
            if (this.zzbsb != null) {
                if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbmx)).booleanValue()) {
                    this.zzbsb.zzb(this.zzbti, this.zzbtj);
                }
            }
            if ((this.zzbsb instanceof zzoi) && (zzoiVar2 = (zzoi) this.zzbsb) != null && zzoiVar2.getContext() != null && com.google.android.gms.ads.internal.zzbv.zzez().zzt(this.zzbti.getContext())) {
                zzaey zzjy = zzoiVar2.zzjy();
                if (zzjy != null) {
                    zzjy.zzv(false);
                }
                zzgi zzgiVar = this.zzbto.get();
                if (zzgiVar != null && zzjy != null) {
                    zzgiVar.zzb(zzjy);
                }
            }
            if ((this.zzbsb instanceof zzod) && ((zzod) this.zzbsb).zzjs()) {
                ((zzod) this.zzbsb).zzc(zzoiVar3);
            } else {
                this.zzbsb = zzoiVar3;
                if (zzoiVar3 instanceof zzod) {
                    ((zzod) zzoiVar3).zzc(null);
                }
            }
            if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbmx)).booleanValue()) {
                this.zzalr.setClickable(false);
            }
            this.zzalr.removeAllViews();
            boolean zzjr = zzoiVar3.zzjr();
            if (zzjr && this.zzbtj != null) {
                WeakReference<View> weakReference = this.zzbtj.get("1098");
                View view = weakReference != null ? weakReference.get() : null;
                if (view instanceof ViewGroup) {
                    viewGroup = (ViewGroup) view;
                }
            }
            boolean z = zzjr && viewGroup != null;
            this.zzbtk = zzoiVar3.zza(this, z);
            if (this.zzbtk != null) {
                if (this.zzbtj != null) {
                    this.zzbtj.put(NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE, new WeakReference<>(this.zzbtk));
                }
                if (z) {
                    viewGroup.removeAllViews();
                    viewGroup.addView(this.zzbtk);
                } else {
                    AdChoicesView adChoicesView = new AdChoicesView(zzoiVar3.getContext());
                    adChoicesView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    adChoicesView.addView(this.zzbtk);
                    if (this.zzalr != null) {
                        this.zzalr.addView(adChoicesView);
                    }
                }
            }
            zzoiVar3.zza(this.zzbti, this.zzbtj, this, this);
            zzahf.zzdbo.post(new zzow(this, zzoiVar3));
            zzg(this.zzbti);
            if ((this.zzbsb instanceof zzoi) && (zzoiVar = (zzoi) this.zzbsb) != null && zzoiVar.getContext() != null && com.google.android.gms.ads.internal.zzbv.zzez().zzt(this.zzbti.getContext())) {
                zzgi zzgiVar2 = this.zzbto.get();
                if (zzgiVar2 == null) {
                    zzgiVar2 = new zzgi(this.zzbti.getContext(), this.zzbti);
                    this.zzbto = new WeakReference<>(zzgiVar2);
                }
                zzgiVar2.zza(zzoiVar.zzjy());
            }
        }
    }
}

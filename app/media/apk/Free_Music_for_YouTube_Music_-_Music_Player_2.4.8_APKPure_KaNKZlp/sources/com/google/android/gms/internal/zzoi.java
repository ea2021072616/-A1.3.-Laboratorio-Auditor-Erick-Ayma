package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public class zzoi implements zzoe {
    private final Context mContext;
    @Nullable
    private final zzajk zzapc;
    @Nullable
    private zzaey zzapr;
    @Nullable
    private zzym zzaqz;
    private final zzof zzbsm;
    @Nullable
    private final JSONObject zzbsp;
    @Nullable
    private final zzog zzbsq;
    private final zzcv zzbsr;
    boolean zzbss;
    @Nullable
    private String zzbst;
    private final Object mLock = new Object();
    private WeakReference<View> zzbsu = null;

    public zzoi(Context context, zzof zzofVar, @Nullable zzym zzymVar, zzcv zzcvVar, @Nullable JSONObject jSONObject, @Nullable zzog zzogVar, @Nullable zzajk zzajkVar, @Nullable String str) {
        this.mContext = context;
        this.zzbsm = zzofVar;
        this.zzaqz = zzymVar;
        this.zzbsr = zzcvVar;
        this.zzbsp = jSONObject;
        this.zzbsq = zzogVar;
        this.zzapc = zzajkVar;
        this.zzbst = str;
    }

    private final JSONObject zza(Map<String, WeakReference<View>> map, View view) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (map == null || view == null) {
            return jSONObject2;
        }
        int[] zzh = zzh(view);
        for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
            View view2 = entry.getValue().get();
            if (view2 != null) {
                int[] zzh2 = zzh(view2);
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put("width", zzr(view2.getMeasuredWidth()));
                    jSONObject4.put("height", zzr(view2.getMeasuredHeight()));
                    jSONObject4.put("x", zzr(zzh2[0] - zzh[0]));
                    jSONObject4.put("y", zzr(zzh2[1] - zzh[1]));
                    jSONObject4.put("relative_to", "ad_view");
                    jSONObject3.put("frame", jSONObject4);
                    Rect rect = new Rect();
                    if (view2.getLocalVisibleRect(rect)) {
                        jSONObject = zzb(rect);
                    } else {
                        jSONObject = new JSONObject();
                        jSONObject.put("width", 0);
                        jSONObject.put("height", 0);
                        jSONObject.put("x", zzr(zzh2[0] - zzh[0]));
                        jSONObject.put("y", zzr(zzh2[1] - zzh[1]));
                        jSONObject.put("relative_to", "ad_view");
                    }
                    jSONObject3.put("visible_bounds", jSONObject);
                    if (view2 instanceof TextView) {
                        TextView textView = (TextView) view2;
                        jSONObject3.put("text_color", textView.getCurrentTextColor());
                        jSONObject3.put("font_size", textView.getTextSize());
                        jSONObject3.put(MimeTypes.BASE_TYPE_TEXT, textView.getText());
                    }
                    jSONObject2.put(entry.getKey(), jSONObject3);
                } catch (JSONException e) {
                    zzafx.zzcs("Unable to get asset views information");
                }
            }
        }
        return jSONObject2;
    }

    private final void zza(View view, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, String str, JSONObject jSONObject4, JSONObject jSONObject5) {
        zzbp.zzfx("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.zzbsp);
            if (jSONObject2 != null) {
                jSONObject6.put("asset_view_signal", jSONObject2);
            }
            if (jSONObject != null) {
                jSONObject6.put("ad_view_signal", jSONObject);
            }
            if (jSONObject4 != null) {
                jSONObject6.put("click_signal", jSONObject4);
            }
            if (jSONObject3 != null) {
                jSONObject6.put("scroll_view_signal", jSONObject3);
            }
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("asset_id", str);
            jSONObject7.put(MessengerShareContentUtility.ATTACHMENT_TEMPLATE_TYPE, this.zzbsq.zzjk());
            jSONObject7.put("has_custom_click_handler", this.zzbsm.zzr(this.zzbsq.getCustomTemplateId()) != null);
            jSONObject6.put("has_custom_click_handler", this.zzbsm.zzr(this.zzbsq.getCustomTemplateId()) != null);
            try {
                JSONObject optJSONObject = this.zzbsp.optJSONObject("tracking_urls_and_actions");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                jSONObject7.put("click_signals", this.zzbsr.zzac().zza(this.mContext, optJSONObject.optString("click_string"), view));
            } catch (Exception e) {
                zzafx.zzb("Exception obtaining click signals", e);
            }
            jSONObject6.put("click", jSONObject7);
            if (jSONObject5 != null) {
                jSONObject6.put("provided_signals", jSONObject5);
            }
            jSONObject6.put("ads_id", this.zzbst);
            this.zzaqz.zza(new zzoj(this, jSONObject6));
        } catch (JSONException e2) {
            zzafx.zzb("Unable to create click JSON.", e2);
        }
    }

    private final boolean zza(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        zzbp.zzfx("recordImpression must be called on the main UI thread.");
        this.zzbss = true;
        try {
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("ad", this.zzbsp);
            jSONObject5.put("ads_id", this.zzbst);
            if (jSONObject2 != null) {
                jSONObject5.put("asset_view_signal", jSONObject2);
            }
            if (jSONObject != null) {
                jSONObject5.put("ad_view_signal", jSONObject);
            }
            if (jSONObject3 != null) {
                jSONObject5.put("scroll_view_signal", jSONObject3);
            }
            if (jSONObject4 != null) {
                jSONObject5.put("provided_signals", jSONObject4);
            }
            this.zzaqz.zza(new zzok(this, jSONObject5));
            this.zzaqz.zza(new zzol(this.zzbsm, this.zzbst));
            this.zzbsm.zza(this);
            this.zzbsm.zzbv();
            return true;
        } catch (JSONException e) {
            zzafx.zzb("Unable to create impression JSON.", e);
            return false;
        }
    }

    private final boolean zzaq(String str) {
        JSONObject optJSONObject = this.zzbsp.optJSONObject("allow_pub_event_reporting");
        if (optJSONObject == null) {
            return false;
        }
        return optJSONObject.optBoolean(str, false);
    }

    private final JSONObject zzb(Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", zzr(rect.right - rect.left));
        jSONObject.put("height", zzr(rect.bottom - rect.top));
        jSONObject.put("x", zzr(rect.left));
        jSONObject.put("y", zzr(rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    private static int[] zzh(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    private final JSONObject zzi(View view) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (view != null) {
            try {
                int[] zzh = zzh(view);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("width", zzr(view.getMeasuredWidth()));
                jSONObject3.put("height", zzr(view.getMeasuredHeight()));
                jSONObject3.put("x", zzr(zzh[0]));
                jSONObject3.put("y", zzr(zzh[1]));
                jSONObject3.put("relative_to", "window");
                jSONObject2.put("frame", jSONObject3);
                Rect rect = new Rect();
                if (view.getGlobalVisibleRect(rect)) {
                    jSONObject = zzb(rect);
                } else {
                    jSONObject = new JSONObject();
                    jSONObject.put("width", 0);
                    jSONObject.put("height", 0);
                    jSONObject.put("x", zzr(zzh[0]));
                    jSONObject.put("y", zzr(zzh[1]));
                    jSONObject.put("relative_to", "window");
                }
                jSONObject2.put("visible_bounds", jSONObject);
            } catch (Exception e) {
                zzafx.zzcs("Unable to get native ad view bounding box");
            }
        }
        return jSONObject2;
    }

    private static JSONObject zzj(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                com.google.android.gms.ads.internal.zzbv.zzea();
                jSONObject.put("contained_in_scroll_view", zzahf.zzp(view) != -1);
            } catch (Exception e) {
            }
        }
        return jSONObject;
    }

    private final int zzr(int i) {
        zzjo.zzhu();
        return zzaje.zzd(this.mContext, i);
    }

    @Override // com.google.android.gms.internal.zzoe
    public final Context getContext() {
        return this.mContext;
    }

    @Override // com.google.android.gms.internal.zzoe
    public final void performClick(Bundle bundle) {
        if (bundle == null) {
            zzafx.zzcb("Click data is null. No click is reported.");
        } else if (zzaq("click_reporting")) {
            zza(null, null, null, null, bundle.getBundle("click_signal").getString("asset_id"), null, com.google.android.gms.ads.internal.zzbv.zzea().zza(bundle, (JSONObject) null));
        } else {
            zzafx.e("The ad slot cannot handle external click events. You must be whitelisted to be able to report your click events.");
        }
    }

    @Override // com.google.android.gms.internal.zzoe
    public final boolean recordImpression(Bundle bundle) {
        if (zzaq("impression_reporting")) {
            return zza((JSONObject) null, (JSONObject) null, (JSONObject) null, com.google.android.gms.ads.internal.zzbv.zzea().zza(bundle, (JSONObject) null));
        }
        zzafx.e("The ad slot cannot handle external impression events. You must be whitelisted to whitelisted to be able to report your impression events.");
        return false;
    }

    @Override // com.google.android.gms.internal.zzoe
    public final void reportTouchEvent(Bundle bundle) {
        if (bundle == null) {
            zzafx.zzcb("Touch event data is null. No touch event is reported.");
        } else if (!zzaq("touch_reporting")) {
            zzafx.e("The ad slot cannot handle external touch events. You must be whitelisted to be able to report your touch events.");
        } else {
            int i = bundle.getInt("duration_ms");
            this.zzbsr.zzac().zza((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), i);
        }
    }

    @Override // com.google.android.gms.internal.zzoe
    @Nullable
    public View zza(View.OnClickListener onClickListener, boolean z) {
        zznt zzjl = this.zzbsq.zzjl();
        if (zzjl == null) {
            return null;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (!z) {
            switch (zzjl.zzjf()) {
                case 0:
                    layoutParams.addRule(10);
                    layoutParams.addRule(9);
                    break;
                case 1:
                default:
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    break;
                case 2:
                    layoutParams.addRule(12);
                    layoutParams.addRule(11);
                    break;
                case 3:
                    layoutParams.addRule(12);
                    layoutParams.addRule(9);
                    break;
            }
        }
        zznu zznuVar = new zznu(this.mContext, zzjl, layoutParams);
        zznuVar.setOnClickListener(onClickListener);
        zznuVar.setContentDescription((CharSequence) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbnb));
        return zznuVar;
    }

    @Override // com.google.android.gms.internal.zzoe
    public final void zza(View view, zzoc zzocVar) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View zzjm = this.zzbsq.zzjm();
        if (zzjm != null) {
            ViewParent parent = zzjm.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(zzjm);
            }
            ((FrameLayout) view).addView(zzjm, layoutParams);
            this.zzbsm.zza(zzocVar);
        } else if (this.zzbsq instanceof zzoh) {
            zzoh zzohVar = (zzoh) this.zzbsq;
            if (zzohVar.getImages() == null || zzohVar.getImages().size() <= 0) {
                return;
            }
            Object obj = zzohVar.getImages().get(0);
            zzpc zzk = obj instanceof IBinder ? zzpd.zzk((IBinder) obj) : null;
            if (zzk != null) {
                try {
                    IObjectWrapper zzjh = zzk.zzjh();
                    if (zzjh != null) {
                        ImageView imageView = new ImageView(this.mContext);
                        imageView.setImageDrawable((Drawable) com.google.android.gms.dynamic.zzn.zzab(zzjh));
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ((FrameLayout) view).addView(imageView, layoutParams);
                    }
                } catch (RemoteException e) {
                    zzafx.zzcs("Could not get drawable from image");
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzoe
    public final void zza(View view, String str, @Nullable Bundle bundle, Map<String, WeakReference<View>> map, View view2) {
        JSONObject jSONObject;
        JSONObject zza;
        JSONObject zza2 = zza(map, view2);
        JSONObject zzi = zzi(view2);
        JSONObject zzj = zzj(view2);
        try {
            zza = com.google.android.gms.ads.internal.zzbv.zzea().zza(bundle, (JSONObject) null);
            jSONObject = new JSONObject();
        } catch (Exception e) {
            e = e;
            jSONObject = null;
        }
        try {
            jSONObject.put("click_point", zza);
            jSONObject.put("asset_id", str);
        } catch (Exception e2) {
            e = e2;
            zzafx.zzb("Error occured while grabbing click signals.", e);
            zza(view, zzi, zza2, zzj, str, jSONObject, null);
        }
        zza(view, zzi, zza2, zzj, str, jSONObject, null);
    }

    @Override // com.google.android.gms.internal.zzoe
    public void zza(View view, Map<String, WeakReference<View>> map) {
        zza(zzi(view), zza(map, view), zzj(view), (JSONObject) null);
    }

    @Override // com.google.android.gms.internal.zzoe
    public void zza(View view, Map<String, WeakReference<View>> map, Bundle bundle, View view2) {
        zzbp.zzfx("performClick must be called on the main UI thread.");
        if (map != null) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                if (view.equals(entry.getValue().get())) {
                    zza(view, entry.getKey(), bundle, map, view2);
                    return;
                }
            }
        }
        if ("2".equals(this.zzbsq.zzjk())) {
            zza(view, "2099", bundle, map, view2);
        } else if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(this.zzbsq.zzjk())) {
            zza(view, "1099", bundle, map, view2);
        }
    }

    public void zza(View view, Map<String, WeakReference<View>> map, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbmz)).booleanValue()) {
            view.setOnTouchListener(onTouchListener);
            view.setClickable(true);
            view.setOnClickListener(onClickListener);
            if (map != null) {
                for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                    View view2 = entry.getValue().get();
                    if (view2 != null) {
                        view2.setOnTouchListener(onTouchListener);
                        view2.setClickable(true);
                        view2.setOnClickListener(onClickListener);
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzoe
    public void zzb(View view, Map<String, WeakReference<View>> map) {
        if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbmy)).booleanValue()) {
            return;
        }
        view.setOnTouchListener(null);
        view.setClickable(false);
        view.setOnClickListener(null);
        if (map != null) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                View view2 = entry.getValue().get();
                if (view2 != null) {
                    view2.setOnTouchListener(null);
                    view2.setClickable(false);
                    view2.setOnClickListener(null);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzoe
    public final void zzc(View view, Map<String, WeakReference<View>> map) {
        synchronized (this.mLock) {
            if (this.zzbss) {
                return;
            }
            if (view.isShown()) {
                if (view.getGlobalVisibleRect(new Rect(), null)) {
                    zza(view, map);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzoe
    public final void zzd(MotionEvent motionEvent) {
        this.zzbsr.zza(motionEvent);
    }

    public final void zze(Map<String, WeakReference<View>> map) {
        if (this.zzbsq.zzjm() != null) {
            if ("2".equals(this.zzbsq.zzjk())) {
                com.google.android.gms.ads.internal.zzbv.zzee().zzb(this.mContext, this.zzbsm.getAdUnitId(), this.zzbsq.zzjk(), map.containsKey(NativeAppInstallAd.ASSET_MEDIA_VIDEO));
            } else if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(this.zzbsq.zzjk())) {
                com.google.android.gms.ads.internal.zzbv.zzee().zzb(this.mContext, this.zzbsm.getAdUnitId(), this.zzbsq.zzjk(), map.containsKey("1009"));
            }
        }
    }

    @Override // com.google.android.gms.internal.zzoe
    public final void zzg(View view) {
        this.zzbsu = new WeakReference<>(view);
    }

    @Override // com.google.android.gms.internal.zzoe
    public boolean zzjr() {
        zznt zzjl = this.zzbsq.zzjl();
        return zzjl != null && zzjl.zzjg();
    }

    public zzakk zzju() throws zzakw {
        if (this.zzbsp == null || this.zzbsp.optJSONObject("overlay") == null) {
            return null;
        }
        zzakk zza = com.google.android.gms.ads.internal.zzbv.zzeb().zza(this.mContext, zzjb.zzi(this.mContext), false, false, this.zzbsr, this.zzapc, null, null, null, zzil.zzhf());
        if (zza == null) {
            throw null;
        }
        ((View) zza).setVisibility(8);
        this.zzaqz.zza(new zzos(new zzom(zza)));
        return zza;
    }

    @Override // com.google.android.gms.internal.zzoe
    public void zzjv() {
        this.zzaqz.zzlf();
    }

    @Override // com.google.android.gms.internal.zzoe
    public final View zzjw() {
        if (this.zzbsu != null) {
            return this.zzbsu.get();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzoe
    public final void zzjx() {
        this.zzbsm.zzcn();
    }

    @Nullable
    public final zzaey zzjy() {
        if (com.google.android.gms.ads.internal.zzbv.zzez().zzt(this.mContext)) {
            if (this.zzapr == null) {
                this.zzapr = new zzaey(this.mContext, this.zzbsm.getAdUnitId());
            }
            return this.zzapr;
        }
        return null;
    }
}

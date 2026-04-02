package com.google.android.gms.internal;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public class zzxd {
    private final zzakk zzbvz;
    private final String zzcey;

    public zzxd(zzakk zzakkVar) {
        this(zzakkVar, "");
    }

    public zzxd(zzakk zzakkVar, String str) {
        this.zzbvz = zzakkVar;
        this.zzcey = str;
    }

    public final void zza(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.zzbvz.zzb("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", f).put("rotation", i5));
        } catch (JSONException e) {
            zzafx.zzb("Error occured while obtaining screen information.", e);
        }
    }

    public final void zzb(int i, int i2, int i3, int i4) {
        try {
            this.zzbvz.zzb("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzafx.zzb("Error occured while dispatching size change.", e);
        }
    }

    public final void zzbn(String str) {
        try {
            this.zzbvz.zzb("onError", new JSONObject().put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str).put(NativeProtocol.WEB_DIALOG_ACTION, this.zzcey));
        } catch (JSONException e) {
            zzafx.zzb("Error occurred while dispatching error event.", e);
        }
    }

    public final void zzbo(String str) {
        try {
            this.zzbvz.zzb("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            zzafx.zzb("Error occured while dispatching ready Event.", e);
        }
    }

    public final void zzbp(String str) {
        try {
            this.zzbvz.zzb("onStateChanged", new JSONObject().put(ServerProtocol.DIALOG_PARAM_STATE, str));
        } catch (JSONException e) {
            zzafx.zzb("Error occured while dispatching state change.", e);
        }
    }

    public final void zzc(int i, int i2, int i3, int i4) {
        try {
            this.zzbvz.zzb("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzafx.zzb("Error occured while dispatching default position.", e);
        }
    }
}

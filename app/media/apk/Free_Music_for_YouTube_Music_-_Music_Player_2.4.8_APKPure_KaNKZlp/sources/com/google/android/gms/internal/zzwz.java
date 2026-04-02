package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzwz {
    private final boolean zzcek;
    private final boolean zzcel;
    private final boolean zzcem;
    private final boolean zzcen;
    private final boolean zzceo;

    private zzwz(zzxb zzxbVar) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        z = zzxbVar.zzcek;
        this.zzcek = z;
        z2 = zzxbVar.zzcel;
        this.zzcel = z2;
        z3 = zzxbVar.zzcem;
        this.zzcem = z3;
        z4 = zzxbVar.zzcen;
        this.zzcen = z4;
        z5 = zzxbVar.zzceo;
        this.zzceo = z5;
    }

    public final JSONObject toJson() {
        try {
            return new JSONObject().put("sms", this.zzcek).put("tel", this.zzcel).put("calendar", this.zzcem).put("storePicture", this.zzcen).put("inlineVideo", this.zzceo);
        } catch (JSONException e) {
            zzafx.zzb("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}

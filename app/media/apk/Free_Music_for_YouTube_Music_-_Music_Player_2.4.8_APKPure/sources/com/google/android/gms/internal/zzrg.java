package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
final class zzrg implements zzrn {
    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        PackageManager packageManager = zzakkVar.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject(map.get(ShareConstants.WEB_DIALOG_PARAM_DATA)).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("id");
                        String optString2 = jSONObject2.optString("u");
                        String optString3 = jSONObject2.optString("i");
                        String optString4 = jSONObject2.optString("m");
                        String optString5 = jSONObject2.optString(TtmlNode.TAG_P);
                        String optString6 = jSONObject2.optString("c");
                        jSONObject2.optString("f");
                        jSONObject2.optString("e");
                        Intent intent = new Intent();
                        if (!TextUtils.isEmpty(optString2)) {
                            intent.setData(Uri.parse(optString2));
                        }
                        if (!TextUtils.isEmpty(optString3)) {
                            intent.setAction(optString3);
                        }
                        if (!TextUtils.isEmpty(optString4)) {
                            intent.setType(optString4);
                        }
                        if (!TextUtils.isEmpty(optString5)) {
                            intent.setPackage(optString5);
                        }
                        if (!TextUtils.isEmpty(optString6)) {
                            String[] split = optString6.split("/", 2);
                            if (split.length == 2) {
                                intent.setComponent(new ComponentName(split[0], split[1]));
                            }
                        }
                        try {
                            jSONObject.put(optString, packageManager.resolveActivity(intent, 65536) != null);
                        } catch (JSONException e) {
                            zzafx.zzb("Error constructing openable urls response.", e);
                        }
                    } catch (JSONException e2) {
                        zzafx.zzb("Error parsing the intent data.", e2);
                    }
                }
                zzakkVar.zzb("openableIntents", jSONObject);
            } catch (JSONException e3) {
                zzakkVar.zzb("openableIntents", new JSONObject());
            }
        } catch (JSONException e4) {
            zzakkVar.zzb("openableIntents", new JSONObject());
        }
    }
}

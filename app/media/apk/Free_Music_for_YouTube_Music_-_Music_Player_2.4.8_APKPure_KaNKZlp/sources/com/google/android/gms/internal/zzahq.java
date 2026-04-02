package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.io.File;
@TargetApi(17)
/* loaded from: classes.dex */
public class zzahq extends zzahs {
    @Override // com.google.android.gms.internal.zzahk
    public final String getDefaultUserAgent(Context context) {
        zzaja zzrk = zzaja.zzrk();
        if (TextUtils.isEmpty(zzrk.zzbwh)) {
            zzrk.zzbwh = (String) zzaiz.zza(new zzajb(zzrk, com.google.android.gms.common.zzo.getRemoteContext(context), context));
        }
        return zzrk.zzbwh;
    }

    @Override // com.google.android.gms.internal.zzahk
    public final Drawable zza(Context context, Bitmap bitmap, boolean z, float f) {
        if (!z || f <= 0.0f || f > 25.0f) {
            return new BitmapDrawable(context.getResources(), bitmap);
        }
        try {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
            Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
            RenderScript create = RenderScript.create(context);
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
            Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
            create2.setRadius(f);
            create2.setInput(createFromBitmap);
            create2.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(createBitmap);
            return new BitmapDrawable(context.getResources(), createBitmap);
        } catch (RuntimeException e) {
            return new BitmapDrawable(context.getResources(), bitmap);
        }
    }

    @Override // com.google.android.gms.internal.zzahs, com.google.android.gms.internal.zzahn, com.google.android.gms.internal.zzahk
    public final boolean zza(Context context, WebSettings webSettings) {
        super.zza(context, webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        return true;
    }

    @Override // com.google.android.gms.internal.zzahk
    public final void zzau(Context context) {
        zzaja zzrk = zzaja.zzrk();
        zzafx.v("Updating user agent.");
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        if (!defaultUserAgent.equals(zzrk.zzbwh)) {
            Context remoteContext = com.google.android.gms.common.zzo.getRemoteContext(context);
            if (remoteContext == null) {
                SharedPreferences.Editor putString = context.getSharedPreferences("admob_user_agent", 0).edit().putString("user_agent", WebSettings.getDefaultUserAgent(context));
                if (remoteContext == null) {
                    putString.apply();
                } else {
                    File file = new File(context.getApplicationInfo().dataDir, "shared_prefs");
                    File parentFile = file.getParentFile();
                    if (parentFile != null) {
                        parentFile.setExecutable(true, false);
                    }
                    file.setExecutable(true, false);
                    putString.commit();
                    new File(file, String.valueOf("admob_user_agent").concat(".xml")).setReadable(true, false);
                }
            }
            zzrk.zzbwh = defaultUserAgent;
        }
        zzafx.v("User agent is updated.");
        com.google.android.gms.ads.internal.zzbv.zzee().zzql();
    }
}

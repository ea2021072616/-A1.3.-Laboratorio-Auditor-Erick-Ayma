package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.exoplayer2.C;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzafi;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzakk;
import com.google.android.gms.internal.zznw;
import com.google.android.gms.internal.zzny;
import com.google.android.gms.internal.zzpc;
import com.google.android.gms.internal.zzpd;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzur;
import com.google.android.gms.internal.zzvm;
import com.google.android.gms.internal.zzvp;
import com.google.android.gms.internal.zzzt;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzas {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzrn zza(@Nullable zzvm zzvmVar, @Nullable zzvp zzvpVar, zzab zzabVar) {
        return new zzax(zzvmVar, zzabVar, zzvpVar);
    }

    private static String zza(@Nullable Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap == null) {
            zzafx.zzcs("Bitmap is null. Returning empty string");
            return "";
        }
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        String valueOf = String.valueOf("data:image/png;base64,");
        String valueOf2 = String.valueOf(encodeToString);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(@Nullable zzpc zzpcVar) {
        if (zzpcVar == null) {
            zzafx.zzcs("Image is null. Returning empty string");
            return "";
        }
        try {
            Uri uri = zzpcVar.getUri();
            if (uri != null) {
                return uri.toString();
            }
        } catch (RemoteException e) {
            zzafx.zzcs("Unable to get image uri. Trying data uri next");
        }
        return zzb(zzpcVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject zza(@Nullable Bundle bundle, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (bundle == null || TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject(str);
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (bundle.containsKey(next)) {
                if (MessengerShareContentUtility.MEDIA_IMAGE.equals(jSONObject2.getString(next))) {
                    Object obj = bundle.get(next);
                    if (obj instanceof Bitmap) {
                        jSONObject.put(next, zza((Bitmap) obj));
                    } else {
                        zzafx.zzcs("Invalid type. An image type extra should return a bitmap");
                    }
                } else if (bundle.get(next) instanceof Bitmap) {
                    zzafx.zzcs("Invalid asset type. Bitmap should be returned only for image type");
                } else {
                    jSONObject.put(next, String.valueOf(bundle.get(next)));
                }
            }
        }
        return jSONObject;
    }

    public static boolean zza(zzakk zzakkVar, zzur zzurVar, CountDownLatch countDownLatch) {
        boolean z;
        try {
        } catch (RemoteException e) {
            zzafx.zzc("Unable to invoke load assets", e);
            z = false;
        } catch (RuntimeException e2) {
            countDownLatch.countDown();
            throw e2;
        }
        if (zzakkVar == null) {
            throw null;
        }
        View view = (View) zzakkVar;
        if (view == null) {
            zzafx.zzcs("AdWebView is null");
            z = false;
        } else {
            view.setVisibility(4);
            List<String> list = zzurVar.zzcca.zzcap;
            if (list == null || list.isEmpty()) {
                zzafx.zzcs("No template ids present in mediation response");
                z = false;
            } else {
                zzakkVar.zzsb().zza("/nativeExpressAssetsLoaded", new zzav(countDownLatch));
                zzakkVar.zzsb().zza("/nativeExpressAssetsLoadingFailed", new zzaw(countDownLatch));
                zzvm zzls = zzurVar.zzccb.zzls();
                zzvp zzlt = zzurVar.zzccb.zzlt();
                if (list.contains("2") && zzls != null) {
                    zzakkVar.zzsb().zza(new zzat(new zznw(zzls.getHeadline(), zzls.getImages(), zzls.getBody(), zzls.zzji(), zzls.getCallToAction(), zzls.getStarRating(), zzls.getStore(), zzls.getPrice(), null, zzls.getExtras(), null, zzls.zzlz() != null ? (View) com.google.android.gms.dynamic.zzn.zzab(zzls.zzlz()) : null), zzurVar.zzcca.zzcao, zzakkVar));
                } else if (!list.contains(AppEventsConstants.EVENT_PARAM_VALUE_YES) || zzlt == null) {
                    zzafx.zzcs("No matching template id and mapper");
                    z = false;
                } else {
                    zzakkVar.zzsb().zza(new zzau(new zzny(zzlt.getHeadline(), zzlt.getImages(), zzlt.getBody(), zzlt.zzjo(), zzlt.getCallToAction(), zzlt.getAdvertiser(), null, zzlt.getExtras(), null, zzlt.zzlz() != null ? (View) com.google.android.gms.dynamic.zzn.zzab(zzlt.zzlz()) : null), zzurVar.zzcca.zzcao, zzakkVar));
                }
                String str = zzurVar.zzcca.zzcam;
                String str2 = zzurVar.zzcca.zzcan;
                if (str2 != null) {
                    zzakkVar.loadDataWithBaseURL(str2, str, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, C.UTF8_NAME, null);
                } else {
                    zzakkVar.loadData(str, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, C.UTF8_NAME);
                }
                z = true;
            }
        }
        if (!z) {
            countDownLatch.countDown();
        }
        return z;
    }

    private static String zzb(zzpc zzpcVar) {
        String zza;
        try {
            IObjectWrapper zzjh = zzpcVar.zzjh();
            if (zzjh == null) {
                zzafx.zzcs("Drawable is null. Returning empty string");
                zza = "";
            } else {
                Drawable drawable = (Drawable) com.google.android.gms.dynamic.zzn.zzab(zzjh);
                if (drawable instanceof BitmapDrawable) {
                    zza = zza(((BitmapDrawable) drawable).getBitmap());
                } else {
                    zzafx.zzcs("Drawable is not an instance of BitmapDrawable. Returning empty string");
                    zza = "";
                }
            }
            return zza;
        } catch (RemoteException e) {
            zzafx.zzcs("Unable to get drawable. Returning empty string");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(zzakk zzakkVar) {
        View.OnClickListener zzsq = zzakkVar.zzsq();
        if (zzsq != null) {
            if (zzakkVar == null) {
                throw null;
            }
            zzsq.onClick((View) zzakkVar);
        }
    }

    @Nullable
    public static View zzd(@Nullable zzafi zzafiVar) {
        if (zzafiVar == null) {
            zzafx.e("AdState is null");
            return null;
        } else if (zze(zzafiVar) && zzafiVar.zzcgz != null) {
            zzakk zzakkVar = zzafiVar.zzcgz;
            if (zzakkVar == null) {
                throw null;
            }
            return (View) zzakkVar;
        } else {
            try {
                IObjectWrapper view = zzafiVar.zzccb != null ? zzafiVar.zzccb.getView() : null;
                if (view == null) {
                    zzafx.zzcs("View in mediation adapter is null.");
                    return null;
                }
                return (View) com.google.android.gms.dynamic.zzn.zzab(view);
            } catch (RemoteException e) {
                zzafx.zzc("Could not get View from mediation adapter.", e);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static zzpc zzd(Object obj) {
        if (obj instanceof IBinder) {
            return zzpd.zzk((IBinder) obj);
        }
        return null;
    }

    public static boolean zze(@Nullable zzafi zzafiVar) {
        return (zzafiVar == null || !zzafiVar.zzcpo || zzafiVar.zzcca == null || zzafiVar.zzcca.zzcam == null) ? false : true;
    }
}

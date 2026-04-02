package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes2.dex */
public final class zzcv {
    private static final String[] zzaht = {"/aclk", "/pcs/click"};
    private String zzahp = "googleads.g.doubleclick.net";
    private String zzahq = "/pagead/ads";
    private String zzahr = "ad.doubleclick.net";
    private String[] zzahs = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private zzcq zzahu;

    public zzcv(zzcq zzcqVar) {
        this.zzahu = zzcqVar;
    }

    private final Uri zza(Uri uri, Context context, String str, boolean z, View view) throws zzcw {
        try {
            boolean zzb = zzb(uri);
            if (zzb) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzcw("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new zzcw("Query parameter already exists: ms");
            }
            String zza = z ? this.zzahu.zza(context, str, view) : this.zzahu.zza(context);
            if (!zzb) {
                String uri2 = uri.toString();
                int indexOf = uri2.indexOf("&adurl");
                if (indexOf == -1) {
                    indexOf = uri2.indexOf("?adurl");
                }
                return indexOf != -1 ? Uri.parse(uri2.substring(0, indexOf + 1) + "ms=" + zza + "&" + uri2.substring(indexOf + 1)) : uri.buildUpon().appendQueryParameter("ms", zza).build();
            }
            String uri3 = uri.toString();
            int indexOf2 = uri3.indexOf(";adurl");
            if (indexOf2 != -1) {
                return Uri.parse(uri3.substring(0, indexOf2 + 1) + "dc_ms=" + zza + ";" + uri3.substring(indexOf2 + 1));
            }
            String encodedPath = uri.getEncodedPath();
            int indexOf3 = uri3.indexOf(encodedPath);
            return Uri.parse(uri3.substring(0, encodedPath.length() + indexOf3) + ";dc_ms=" + zza + ";" + uri3.substring(encodedPath.length() + indexOf3));
        } catch (UnsupportedOperationException e) {
            throw new zzcw("Provided Uri is not in a valid state");
        }
    }

    private final boolean zzb(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.zzahr);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public final Uri zza(Uri uri, Context context) throws zzcw {
        return zza(uri, context, null, false, null);
    }

    public final Uri zza(Uri uri, Context context, View view) throws zzcw {
        try {
            return zza(uri, context, uri.getQueryParameter("ai"), true, view);
        } catch (UnsupportedOperationException e) {
            throw new zzcw("Provided Uri is not in a valid state");
        }
    }

    public final void zza(MotionEvent motionEvent) {
        this.zzahu.zza(motionEvent);
    }

    public final boolean zza(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            if (uri.getHost().equals(this.zzahp)) {
                return uri.getPath().equals(this.zzahq);
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public final zzcq zzac() {
        return this.zzahu;
    }

    public final void zzb(String str, String str2) {
        this.zzahp = str;
        this.zzahq = str2;
    }

    public final boolean zzc(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String str : this.zzahs) {
                if (host.endsWith(str)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public final boolean zzd(Uri uri) {
        if (zzc(uri)) {
            for (String str : zzaht) {
                if (uri.getPath().endsWith(str)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final void zzk(String str) {
        this.zzahs = str.split(",");
    }
}

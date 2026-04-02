package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzadj;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzagz;
import com.google.android.gms.internal.zzaje;
import com.google.android.gms.internal.zzajk;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzix;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzjr;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkk;
import com.google.android.gms.internal.zzkq;
import com.google.android.gms.internal.zzky;
import com.google.android.gms.internal.zzle;
import com.google.android.gms.internal.zzmd;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zznn;
import com.google.android.gms.internal.zzxn;
import com.google.android.gms.internal.zzxt;
import com.google.android.gms.internal.zzzt;
import java.util.Map;
import java.util.concurrent.Future;
@zzzt
/* loaded from: classes.dex */
public final class zzbp extends zzkg {
    private final Context mContext;
    @Nullable
    private zzju zzaoq;
    private final zzajk zzapc;
    private final zzjb zzaro;
    private final Future<zzev> zzarp = zzagz.zza(zzagz.zzdbh, new zzbs(this));
    private final zzbu zzarq;
    @Nullable
    private WebView zzarr;
    @Nullable
    private zzev zzars;
    private AsyncTask<Void, Void, String> zzart;

    public zzbp(Context context, zzjb zzjbVar, String str, zzajk zzajkVar) {
        this.mContext = context;
        this.zzapc = zzajkVar;
        this.zzaro = zzjbVar;
        this.zzarr = new WebView(this.mContext);
        this.zzarq = new zzbu(str);
        zzi(0);
        this.zzarr.setVerticalScrollBarEnabled(false);
        this.zzarr.getSettings().setJavaScriptEnabled(true);
        this.zzarr.setWebViewClient(new zzbq(this));
        this.zzarr.setOnTouchListener(new zzbr(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String zzv(String str) {
        if (this.zzars == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = this.zzars.zzc(parse, this.mContext);
        } catch (RemoteException e) {
            zzafx.zzc("Unable to process ad data", e);
        } catch (zzew e2) {
            zzafx.zzc("Unable to parse ad click url", e2);
        }
        return parse.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzw(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.mContext.startActivity(intent);
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void destroy() throws RemoteException {
        com.google.android.gms.common.internal.zzbp.zzfx("destroy must be called on the main UI thread.");
        this.zzart.cancel(true);
        this.zzarp.cancel(true);
        this.zzarr.destroy();
        this.zzarr = null;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final String getAdUnitId() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Override // com.google.android.gms.internal.zzkf
    @Nullable
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.zzkf
    @Nullable
    public final zzky getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final boolean isLoading() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final boolean isReady() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void pause() throws RemoteException {
        com.google.android.gms.common.internal.zzbp.zzfx("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void resume() throws RemoteException {
        com.google.android.gms.common.internal.zzbp.zzfx("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void setImmersiveMode(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void setUserId(String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void showInterstitial() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void stopLoading() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzadj zzadjVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzjb zzjbVar) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzjr zzjrVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzju zzjuVar) throws RemoteException {
        this.zzaoq = zzjuVar;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzkk zzkkVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzkq zzkqVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzle zzleVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzmd zzmdVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zznn zznnVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzxn zzxnVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzxt zzxtVar, String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final boolean zzb(zzix zzixVar) throws RemoteException {
        com.google.android.gms.common.internal.zzbp.zzb(this.zzarr, "This Search Ad has already been torn down");
        this.zzarq.zza(zzixVar, this.zzapc);
        this.zzart = new zzbt(this, null).execute(new Void[0]);
        return true;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final IObjectWrapper zzbk() throws RemoteException {
        com.google.android.gms.common.internal.zzbp.zzfx("getAdFrame must be called on the main UI thread.");
        return com.google.android.gms.dynamic.zzn.zzw(this.zzarr);
    }

    @Override // com.google.android.gms.internal.zzkf
    public final zzjb zzbl() throws RemoteException {
        return this.zzaro;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zzbn() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final zzkk zzbw() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final zzju zzbx() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @Override // com.google.android.gms.internal.zzkf
    @Nullable
    public final String zzch() throws RemoteException {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzdq() {
        Uri zzb;
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath((String) zzbv.zzen().zzd(zzmu.zzbnx));
        builder.appendQueryParameter(SearchIntents.EXTRA_QUERY, this.zzarq.getQuery());
        builder.appendQueryParameter("pubId", this.zzarq.zzdt());
        Map<String, String> zzdu = this.zzarq.zzdu();
        for (String str : zzdu.keySet()) {
            builder.appendQueryParameter(str, zzdu.get(str));
        }
        Uri build = builder.build();
        if (this.zzars != null) {
            try {
                zzb = this.zzars.zzb(build, this.mContext);
            } catch (RemoteException | zzew e) {
                zzafx.zzc("Unable to process ad data", e);
            }
            String zzdr = zzdr();
            String encodedQuery = zzb.getEncodedQuery();
            return new StringBuilder(String.valueOf(zzdr).length() + 1 + String.valueOf(encodedQuery).length()).append(zzdr).append("#").append(encodedQuery).toString();
        }
        zzb = build;
        String zzdr2 = zzdr();
        String encodedQuery2 = zzb.getEncodedQuery();
        return new StringBuilder(String.valueOf(zzdr2).length() + 1 + String.valueOf(encodedQuery2).length()).append(zzdr2).append("#").append(encodedQuery2).toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzdr() {
        String zzds = this.zzarq.zzds();
        String str = TextUtils.isEmpty(zzds) ? "www.google.com" : zzds;
        String str2 = (String) zzbv.zzen().zzd(zzmu.zzbnx);
        return new StringBuilder(String.valueOf("https://").length() + String.valueOf(str).length() + String.valueOf(str2).length()).append("https://").append(str).append(str2).toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzi(int i) {
        if (this.zzarr == null) {
            return;
        }
        this.zzarr.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzu(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("height");
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            zzjo.zzhu();
            return zzaje.zzc(this.mContext, Integer.parseInt(queryParameter));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}

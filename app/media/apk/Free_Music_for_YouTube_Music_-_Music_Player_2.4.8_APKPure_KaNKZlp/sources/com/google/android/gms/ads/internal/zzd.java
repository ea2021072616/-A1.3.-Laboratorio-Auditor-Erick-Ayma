package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import com.google.android.gms.internal.zzaal;
import com.google.android.gms.internal.zzabf;
import com.google.android.gms.internal.zzafi;
import com.google.android.gms.internal.zzafk;
import com.google.android.gms.internal.zzafm;
import com.google.android.gms.internal.zzafv;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzagz;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzahk;
import com.google.android.gms.internal.zzajk;
import com.google.android.gms.internal.zzajr;
import com.google.android.gms.internal.zzakk;
import com.google.android.gms.internal.zzbdp;
import com.google.android.gms.internal.zzhd;
import com.google.android.gms.internal.zzio;
import com.google.android.gms.internal.zzix;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzle;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzot;
import com.google.android.gms.internal.zzpt;
import com.google.android.gms.internal.zzqd;
import com.google.android.gms.internal.zztz;
import com.google.android.gms.internal.zzum;
import com.google.android.gms.internal.zzut;
import com.google.android.gms.internal.zzva;
import com.google.android.gms.internal.zzzt;
import com.google.android.gms.internal.zzzw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public abstract class zzd extends zza implements com.google.android.gms.ads.internal.overlay.zzw, zzbo, zzum {
    protected final zzva zzana;
    private transient boolean zzanb;

    public zzd(Context context, zzjb zzjbVar, String str, zzva zzvaVar, zzajk zzajkVar, zzv zzvVar) {
        this(new zzbw(context, zzjbVar, str, zzajkVar), zzvaVar, null, zzvVar);
    }

    private zzd(zzbw zzbwVar, zzva zzvaVar, @Nullable zzbl zzblVar, zzv zzvVar) {
        super(zzbwVar, null, zzvVar);
        this.zzana = zzvaVar;
        this.zzanb = false;
    }

    private final zzaal zza(zzix zzixVar, Bundle bundle, zzafm zzafmVar, int i) {
        PackageInfo packageInfo;
        JSONArray optJSONArray;
        ApplicationInfo applicationInfo = this.zzams.zzaie.getApplicationInfo();
        try {
            packageInfo = zzbdp.zzcs(this.zzams.zzaie).getPackageInfo(applicationInfo.packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        DisplayMetrics displayMetrics = this.zzams.zzaie.getResources().getDisplayMetrics();
        Bundle bundle2 = null;
        if (this.zzams.zzatk != null && this.zzams.zzatk.getParent() != null) {
            int[] iArr = new int[2];
            this.zzams.zzatk.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            int width = this.zzams.zzatk.getWidth();
            int height = this.zzams.zzatk.getHeight();
            int i4 = 0;
            if (this.zzams.zzatk.isShown() && i2 + width > 0 && i3 + height > 0 && i2 <= displayMetrics.widthPixels && i3 <= displayMetrics.heightPixels) {
                i4 = 1;
            }
            bundle2 = new Bundle(5);
            bundle2.putInt("x", i2);
            bundle2.putInt("y", i3);
            bundle2.putInt("width", width);
            bundle2.putInt("height", height);
            bundle2.putInt("visible", i4);
        }
        String zzpr = zzbv.zzee().zzpr();
        this.zzams.zzatq = new zzafk(zzpr, this.zzams.zzath);
        this.zzams.zzatq.zzo(zzixVar);
        zzbv.zzea();
        String zza = zzahf.zza(this.zzams.zzaie, this.zzams.zzatk, this.zzams.zzatn);
        long j = 0;
        if (this.zzams.zzatu != null) {
            try {
                j = this.zzams.zzatu.getValue();
            } catch (RemoteException e2) {
                zzafx.zzcs("Cannot get correlation id, default to 0.");
            }
        }
        String uuid = UUID.randomUUID().toString();
        Bundle zza2 = zzbv.zzee().zza(this.zzams.zzaie, this, zzpr);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= this.zzams.zzaty.size()) {
                break;
            }
            String keyAt = this.zzams.zzaty.keyAt(i6);
            arrayList.add(keyAt);
            if (this.zzams.zzatx.containsKey(keyAt) && this.zzams.zzatx.get(keyAt) != null) {
                arrayList2.add(keyAt);
            }
            i5 = i6 + 1;
        }
        zzajr zza3 = zzagz.zza(zzagz.zzdbh, new zze(this));
        zzajr zza4 = zzagz.zza(zzagz.zzdbh, new zzf(this));
        String zzpn = zzafmVar != null ? zzafmVar.zzpn() : null;
        String str = null;
        if (this.zzams.zzaug != null && this.zzams.zzaug.size() > 0) {
            int i7 = packageInfo != null ? packageInfo.versionCode : 0;
            if (i7 > zzbv.zzee().zzqc()) {
                zzbv.zzee().zzqj();
                zzbv.zzee().zzab(i7);
            } else {
                JSONObject zzqi = zzbv.zzee().zzqi();
                if (zzqi != null && (optJSONArray = zzqi.optJSONArray(this.zzams.zzath)) != null) {
                    str = optJSONArray.toString();
                }
            }
        }
        zzjb zzjbVar = this.zzams.zzatn;
        String str2 = this.zzams.zzath;
        String sessionId = zzbv.zzee().getSessionId();
        zzajk zzajkVar = this.zzams.zzatj;
        List<String> list = this.zzams.zzaug;
        boolean zzpu = zzbv.zzee().zzpu();
        int i8 = displayMetrics.widthPixels;
        int i9 = displayMetrics.heightPixels;
        float f = displayMetrics.density;
        List<String> zzil = zzmu.zzil();
        String str3 = this.zzams.zzatg;
        zzot zzotVar = this.zzams.zzatz;
        String zzff = this.zzams.zzff();
        zzbv.zzea();
        float zzde = zzahf.zzde();
        zzbv.zzea();
        boolean zzdg = zzahf.zzdg();
        zzbv.zzea();
        int zzaq = zzahf.zzaq(this.zzams.zzaie);
        zzbv.zzea();
        int zzp = zzahf.zzp(this.zzams.zzatk);
        boolean z = this.zzams.zzaie instanceof Activity;
        boolean zzpz = zzbv.zzee().zzpz();
        boolean zzqe = zzbv.zzee().zzqe();
        int zzkg = zzbv.zzex().zzkg();
        zzbv.zzea();
        Bundle zzqx = zzahf.zzqx();
        String zzrg = zzbv.zzej().zzrg();
        zzle zzleVar = this.zzams.zzaub;
        boolean zzrh = zzbv.zzej().zzrh();
        Bundle asBundle = zztz.zzkp().asBundle();
        zzbv.zzee();
        return new zzaal(bundle2, zzixVar, zzjbVar, str2, applicationInfo, packageInfo, zzpr, sessionId, zzajkVar, zza2, list, arrayList, bundle, zzpu, i8, i9, f, zza, j, uuid, zzil, str3, zzotVar, zzff, zzde, zzdg, zzaq, zzp, z, zzpz, zza3, zzpn, zzqe, zzkg, zzqx, zzrg, zzleVar, zzrh, asBundle, this.zzams.zzaie.getSharedPreferences("admob", 0).getStringSet("never_pool_slots", Collections.emptySet()).contains(this.zzams.zzath), zza4, this.zzams.zzaud, str, arrayList2, i, zzbdp.zzcs(this.zzams.zzaie).zzalq(), zzbv.zzee().zzqf());
    }

    @Override // com.google.android.gms.internal.zzkf
    public final String getMediationAdapterClassName() {
        if (this.zzams.zzato == null) {
            return null;
        }
        return this.zzams.zzato.zzccc;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzis
    public void onAdClicked() {
        if (this.zzams.zzato == null) {
            zzafx.zzcs("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (this.zzams.zzato.zzcye != null && this.zzams.zzato.zzcye.zzcau != null) {
            zzbv.zzeu();
            zzut.zza(this.zzams.zzaie, this.zzams.zzatj.zzcp, this.zzams.zzato, this.zzams.zzath, false, zzb(this.zzams.zzato.zzcye.zzcau));
        }
        if (this.zzams.zzato.zzcca != null && this.zzams.zzato.zzcca.zzcaf != null) {
            zzbv.zzeu();
            zzut.zza(this.zzams.zzaie, this.zzams.zzatj.zzcp, this.zzams.zzato, this.zzams.zzath, false, this.zzams.zzato.zzcca.zzcaf);
        }
        super.onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzw
    public final void onPause() {
        this.zzamu.zzi(this.zzams.zzato);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzw
    public final void onResume() {
        this.zzamu.zzj(this.zzams.zzato);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzkf
    public void pause() {
        com.google.android.gms.common.internal.zzbp.zzfx("pause must be called on the main UI thread.");
        if (this.zzams.zzato != null && this.zzams.zzato.zzcgz != null && this.zzams.zzfd()) {
            zzbv.zzec();
            zzahk.zzk(this.zzams.zzato.zzcgz);
        }
        if (this.zzams.zzato != null && this.zzams.zzato.zzccb != null) {
            try {
                this.zzams.zzato.zzccb.pause();
            } catch (RemoteException e) {
                zzafx.zzcs("Could not pause mediation adapter.");
            }
        }
        this.zzamu.zzi(this.zzams.zzato);
        this.zzamr.pause();
    }

    public final void recordImpression() {
        zza(this.zzams.zzato, false);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzkf
    public void resume() {
        com.google.android.gms.common.internal.zzbp.zzfx("resume must be called on the main UI thread.");
        zzakk zzakkVar = null;
        if (this.zzams.zzato != null && this.zzams.zzato.zzcgz != null) {
            zzakkVar = this.zzams.zzato.zzcgz;
        }
        if (zzakkVar != null && this.zzams.zzfd()) {
            zzbv.zzec();
            zzahk.zzl(this.zzams.zzato.zzcgz);
        }
        if (this.zzams.zzato != null && this.zzams.zzato.zzccb != null) {
            try {
                this.zzams.zzato.zzccb.resume();
            } catch (RemoteException e) {
                zzafx.zzcs("Could not resume mediation adapter.");
            }
        }
        if (zzakkVar == null || !zzakkVar.zzsi()) {
            this.zzamr.resume();
        }
        this.zzamu.zzj(this.zzams.zzato);
    }

    public void showInterstitial() {
        throw new IllegalStateException("showInterstitial is not supported for current ad type");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zza(@Nullable zzafi zzafiVar, boolean z) {
        if (zzafiVar == null) {
            zzafx.zzcs("Ad state was null when trying to ping impression URLs.");
            return;
        }
        if (zzafiVar == null) {
            zzafx.zzcs("Ad state was null when trying to ping impression URLs.");
        } else {
            zzafx.zzcb("Pinging Impression URLs.");
            if (this.zzams.zzatq != null) {
                this.zzams.zzatq.zzpf();
            }
            if (zzafiVar.zzcav != null && !zzafiVar.zzcyl) {
                zzbv.zzea();
                zzahf.zza(this.zzams.zzaie, this.zzams.zzatj.zzcp, zzb(zzafiVar.zzcav));
                zzafiVar.zzcyl = true;
            }
        }
        if (zzafiVar.zzcye != null && zzafiVar.zzcye.zzcav != null) {
            zzbv.zzeu();
            zzut.zza(this.zzams.zzaie, this.zzams.zzatj.zzcp, zzafiVar, this.zzams.zzath, z, zzb(zzafiVar.zzcye.zzcav));
        }
        if (zzafiVar.zzcca == null || zzafiVar.zzcca.zzcag == null) {
            return;
        }
        zzbv.zzeu();
        zzut.zza(this.zzams.zzaie, this.zzams.zzatj.zzcp, zzafiVar, this.zzams.zzath, z, zzafiVar.zzcca.zzcag);
    }

    @Override // com.google.android.gms.internal.zzum
    public final void zza(zzpt zzptVar, String str) {
        String customTemplateId;
        zzqd zzqdVar = null;
        if (zzptVar != null) {
            try {
                customTemplateId = zzptVar.getCustomTemplateId();
            } catch (RemoteException e) {
                zzafx.zzc("Unable to call onCustomClick.", e);
                return;
            }
        } else {
            customTemplateId = null;
        }
        if (this.zzams.zzatx != null && customTemplateId != null) {
            zzqdVar = this.zzams.zzatx.get(customTemplateId);
        }
        if (zzqdVar == null) {
            zzafx.zzcs("Mediation adapter invoked onCustomClick but no listeners were set.");
        } else {
            zzqdVar.zzb(zzptVar, str);
        }
    }

    public final boolean zza(zzaal zzaalVar, zznh zznhVar) {
        this.zzamn = zznhVar;
        zznhVar.zzh("seq_num", zzaalVar.zzcnz);
        zznhVar.zzh("request_id", zzaalVar.zzcoj);
        zznhVar.zzh("session_id", zzaalVar.zzcoa);
        if (zzaalVar.zzcnx != null) {
            zznhVar.zzh("app_version", String.valueOf(zzaalVar.zzcnx.versionCode));
        }
        zzbw zzbwVar = this.zzams;
        zzbv.zzdw();
        Context context = this.zzams.zzaie;
        zzio zzioVar = this.zzamv.zzans;
        zzafv zzabfVar = zzaalVar.zzcnw.extras.getBundle("sdk_less_server_data") != null ? new zzabf(context, zzaalVar, this, zzioVar) : new zzzw(context, zzaalVar, this, zzioVar);
        zzabfVar.zzqq();
        zzbwVar.zzatl = zzabfVar;
        return true;
    }

    @Override // com.google.android.gms.ads.internal.zza
    final boolean zza(zzafi zzafiVar) {
        zzix zzixVar;
        boolean z = false;
        if (this.zzamt != null) {
            zzixVar = this.zzamt;
            this.zzamt = null;
        } else {
            zzixVar = zzafiVar.zzcnw;
            if (zzixVar.extras != null) {
                z = zzixVar.extras.getBoolean("_noRefresh", false);
            }
        }
        return zza(zzixVar, zzafiVar, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public boolean zza(@Nullable zzafi zzafiVar, zzafi zzafiVar2) {
        int i;
        int i2 = 0;
        if (zzafiVar != null && zzafiVar.zzccd != null) {
            zzafiVar.zzccd.zza((zzum) null);
        }
        if (zzafiVar2.zzccd != null) {
            zzafiVar2.zzccd.zza(this);
        }
        if (zzafiVar2.zzcye != null) {
            i = zzafiVar2.zzcye.zzcbh;
            i2 = zzafiVar2.zzcye.zzcbi;
        } else {
            i = 0;
        }
        this.zzams.zzauh.zzh(i, i2);
        return true;
    }

    protected boolean zza(zzix zzixVar, zzafi zzafiVar, boolean z) {
        if (!z && this.zzams.zzfd()) {
            if (zzafiVar.zzcba > 0) {
                this.zzamr.zza(zzixVar, zzafiVar.zzcba);
            } else if (zzafiVar.zzcye != null && zzafiVar.zzcye.zzcba > 0) {
                this.zzamr.zza(zzixVar, zzafiVar.zzcye.zzcba);
            } else if (!zzafiVar.zzcpo && zzafiVar.errorCode == 2) {
                this.zzamr.zzg(zzixVar);
            }
        }
        return this.zzamr.zzdp();
    }

    @Override // com.google.android.gms.ads.internal.zza
    public boolean zza(zzix zzixVar, zznh zznhVar) {
        return zza(zzixVar, zznhVar, 1);
    }

    public final boolean zza(zzix zzixVar, zznh zznhVar, int i) {
        zzafm zzafmVar;
        if (zzby()) {
            zzbv.zzea();
            zzhd zzad = zzbv.zzee().zzad(this.zzams.zzaie);
            Bundle zza = zzad == null ? null : zzahf.zza(zzad);
            this.zzamr.cancel();
            this.zzams.zzauj = 0;
            if (((Boolean) zzbv.zzen().zzd(zzmu.zzbnq)).booleanValue()) {
                zzafmVar = zzbv.zzee().zzqh();
                zzbv.zzeh().zza(this.zzams.zzaie, this.zzams.zzatj, false, zzafmVar, zzafmVar != null ? zzafmVar.getAppId() : null, this.zzams.zzath, null);
            } else {
                zzafmVar = null;
            }
            return zza(zza(zzixVar, zza, zzafmVar, i), zznhVar);
        }
        return false;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzyd
    public final void zzb(zzafi zzafiVar) {
        super.zzb(zzafiVar);
        if (zzafiVar.zzcca != null) {
            zzafx.zzcb("Disable the debug gesture detector on the mediation ad frame.");
            if (this.zzams.zzatk != null) {
                this.zzams.zzatk.zzfj();
            }
            zzafx.zzcb("Pinging network fill URLs.");
            zzbv.zzeu();
            zzut.zza(this.zzams.zzaie, this.zzams.zzatj.zzcp, zzafiVar, this.zzams.zzath, false, zzafiVar.zzcca.zzcai);
            if (zzafiVar.zzcye != null && zzafiVar.zzcye.zzcax != null && zzafiVar.zzcye.zzcax.size() > 0) {
                zzafx.zzcb("Pinging urls remotely");
                zzbv.zzea().zza(this.zzams.zzaie, zzafiVar.zzcye.zzcax);
            }
        } else {
            zzafx.zzcb("Enable the debug gesture detector on the admob ad frame.");
            if (this.zzams.zzatk != null) {
                this.zzams.zzatk.zzfi();
            }
        }
        if (zzafiVar.errorCode != 3 || zzafiVar.zzcye == null || zzafiVar.zzcye.zzcaw == null) {
            return;
        }
        zzafx.zzcb("Pinging no fill URLs.");
        zzbv.zzeu();
        zzut.zza(this.zzams.zzaie, this.zzams.zzatj.zzcp, zzafiVar, this.zzams.zzath, false, zzafiVar.zzcye.zzcaw);
    }

    protected boolean zzby() {
        zzbv.zzea();
        if (zzahf.zzc(this.zzams.zzaie, this.zzams.zzaie.getPackageName(), "android.permission.INTERNET")) {
            zzbv.zzea();
            if (zzahf.zzag(this.zzams.zzaie)) {
                return true;
            }
        }
        return false;
    }

    public void zzbz() {
        this.zzanb = false;
        zzbo();
        this.zzams.zzatq.zzph();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final boolean zzc(zzix zzixVar) {
        return super.zzc(zzixVar) && !this.zzanb;
    }

    public void zzca() {
        this.zzanb = true;
        zzbq();
    }

    public void zzcb() {
        onAdClicked();
    }

    @Override // com.google.android.gms.internal.zzum
    public final void zzcc() {
        zzbz();
    }

    @Override // com.google.android.gms.internal.zzum
    public final void zzcd() {
        zzbp();
    }

    @Override // com.google.android.gms.internal.zzum
    public final void zzce() {
        zzca();
    }

    @Override // com.google.android.gms.internal.zzum
    public final void zzcf() {
        if (this.zzams.zzato != null) {
            String str = this.zzams.zzato.zzccc;
            zzafx.zzcs(new StringBuilder(String.valueOf(str).length() + 74).append("Mediation adapter ").append(str).append(" refreshed, but mediation adapters should never refresh.").toString());
        }
        zza(this.zzams.zzato, true);
        zzbr();
    }

    public void zzcg() {
        recordImpression();
    }

    @Override // com.google.android.gms.internal.zzkf
    public final String zzch() {
        if (this.zzams.zzato == null) {
            return null;
        }
        String str = this.zzams.zzato.zzccc;
        if (!("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) || this.zzams.zzato.zzcca == null) {
            return str;
        }
        try {
            return new JSONObject(this.zzams.zzato.zzcca.zzcaj).getString("class_name");
        } catch (NullPointerException e) {
            return str;
        } catch (JSONException e2) {
            return str;
        }
    }

    @Override // com.google.android.gms.ads.internal.zzbo
    public final void zzci() {
        zzbv.zzea();
        zzahf.runOnUiThread(new zzg(this));
    }

    @Override // com.google.android.gms.ads.internal.zzbo
    public final void zzcj() {
        zzbv.zzea();
        zzahf.runOnUiThread(new zzh(this));
    }

    @Override // com.google.android.gms.internal.zzum
    public final void zze(String str, String str2) {
        onAppEvent(str, str2);
    }
}

package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
@zzzt
/* loaded from: classes.dex */
public final class zzmx {
    private Context mContext;
    private String zzaux;
    private String zzbpx;
    private BlockingQueue<zznh> zzbpz;
    private ExecutorService zzbqa;
    private LinkedHashMap<String, String> zzbqb = new LinkedHashMap<>();
    private Map<String, zznb> zzbqc = new HashMap();
    private AtomicBoolean zzbqd = new AtomicBoolean(false);
    private File zzbqe;

    public zzmx(Context context, String str, String str2, Map<String, String> map) {
        File externalStorageDirectory;
        this.mContext = context;
        this.zzaux = str;
        this.zzbpx = str2;
        this.zzbqd.set(((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbht)).booleanValue());
        if (this.zzbqd.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.zzbqe = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.zzbqb.put(entry.getKey(), entry.getValue());
        }
        this.zzbpz = new ArrayBlockingQueue(30);
        this.zzbqa = Executors.newSingleThreadExecutor();
        this.zzbqa.execute(new zzmy(this));
        this.zzbqc.put(NativeProtocol.WEB_DIALOG_ACTION, zznb.zzbqh);
        this.zzbqc.put("ad_format", zznb.zzbqh);
        this.zzbqc.put("e", zznb.zzbqi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zziq() {
        FileOutputStream fileOutputStream;
        while (true) {
            try {
                zznh take = this.zzbpz.take();
                String zziw = take.zziw();
                if (!TextUtils.isEmpty(zziw)) {
                    Map<String, String> zza = zza(this.zzbqb, take.zzix());
                    Uri.Builder buildUpon = Uri.parse(this.zzbpx).buildUpon();
                    for (Map.Entry<String, String> entry : zza.entrySet()) {
                        buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
                    }
                    StringBuilder sb = new StringBuilder(buildUpon.build().toString());
                    sb.append("&it=").append(zziw);
                    String sb2 = sb.toString();
                    if (this.zzbqd.get()) {
                        File file = this.zzbqe;
                        if (file != null) {
                            try {
                                fileOutputStream = new FileOutputStream(file, true);
                                try {
                                    try {
                                        fileOutputStream.write(sb2.getBytes());
                                        fileOutputStream.write(10);
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e) {
                                            zzafx.zzc("CsiReporter: Cannot close file: sdk_csi_data.txt.", e);
                                        }
                                    } catch (IOException e2) {
                                        e = e2;
                                        zzafx.zzc("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e);
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e3) {
                                                zzafx.zzc("CsiReporter: Cannot close file: sdk_csi_data.txt.", e3);
                                            }
                                        }
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e4) {
                                            zzafx.zzc("CsiReporter: Cannot close file: sdk_csi_data.txt.", e4);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (IOException e5) {
                                e = e5;
                                fileOutputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = null;
                            }
                        } else {
                            zzafx.zzcs("CsiReporter: File doesn't exists. Cannot write CSI data to file.");
                        }
                    } else {
                        com.google.android.gms.ads.internal.zzbv.zzea();
                        zzahf.zzd(this.mContext, this.zzaux, sb2);
                    }
                }
            } catch (InterruptedException e6) {
                zzafx.zzc("CsiReporter:reporter interrupted", e6);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, String> zza(Map<String, String> map, @Nullable Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String key = entry.getKey();
            String str = (String) linkedHashMap.get(key);
            linkedHashMap.put(key, zzal(key).zzg(str, entry.getValue()));
        }
        return linkedHashMap;
    }

    public final boolean zza(zznh zznhVar) {
        return this.zzbpz.offer(zznhVar);
    }

    public final zznb zzal(String str) {
        zznb zznbVar = this.zzbqc.get(str);
        return zznbVar != null ? zznbVar : zznb.zzbqg;
    }

    public final void zzf(@Nullable List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.zzbqb.put("e", TextUtils.join(",", list));
    }
}

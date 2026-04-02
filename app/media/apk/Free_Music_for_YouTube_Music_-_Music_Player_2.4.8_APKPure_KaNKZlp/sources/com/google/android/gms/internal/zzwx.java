package com.google.android.gms.internal;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzwx implements DialogInterface.OnClickListener {
    private /* synthetic */ String zzceh;
    private /* synthetic */ String zzcei;
    private /* synthetic */ zzww zzcej;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwx(zzww zzwwVar, String str, String str2) {
        this.zzcej = zzwwVar;
        this.zzceh = str;
        this.zzcei = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Context context;
        context = this.zzcej.mContext;
        DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        try {
            String str = this.zzceh;
            String str2 = this.zzcei;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            com.google.android.gms.ads.internal.zzbv.zzec().zza(request);
            downloadManager.enqueue(request);
        } catch (IllegalStateException e) {
            this.zzcej.zzbn("Could not store picture.");
        }
    }
}

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zzpb extends NativeAd.AdChoicesInfo {
    private final List<NativeAd.Image> zzbrf = new ArrayList();
    private final zzoy zzbts;
    private String zzbtt;

    public zzpb(zzoy zzoyVar) {
        zzpe zzpeVar;
        IBinder iBinder;
        this.zzbts = zzoyVar;
        try {
            this.zzbtt = this.zzbts.getText();
        } catch (RemoteException e) {
            zzaji.zzb("Error while obtaining attribution text.", e);
            this.zzbtt = "";
        }
        try {
            for (zzpc zzpcVar : zzoyVar.zzjc()) {
                if (!(zzpcVar instanceof IBinder) || (iBinder = (IBinder) zzpcVar) == null) {
                    zzpeVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    zzpeVar = queryLocalInterface instanceof zzpc ? (zzpc) queryLocalInterface : new zzpe(iBinder);
                }
                if (zzpeVar != null) {
                    this.zzbrf.add(new zzpf(zzpeVar));
                }
            }
        } catch (RemoteException e2) {
            zzaji.zzb("Error while obtaining image.", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final List<NativeAd.Image> getImages() {
        return this.zzbrf;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final CharSequence getText() {
        return this.zzbtt;
    }
}

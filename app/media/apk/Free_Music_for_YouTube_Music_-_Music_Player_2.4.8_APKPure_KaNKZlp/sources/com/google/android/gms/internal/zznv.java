package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
@zzzt
/* loaded from: classes.dex */
public final class zznv extends zzpd {
    private final Uri mUri;
    private final Drawable zzbro;
    private final double zzbrp;

    public zznv(Drawable drawable, Uri uri, double d) {
        this.zzbro = drawable;
        this.mUri = uri;
        this.zzbrp = d;
    }

    @Override // com.google.android.gms.internal.zzpc
    public final double getScale() {
        return this.zzbrp;
    }

    @Override // com.google.android.gms.internal.zzpc
    public final Uri getUri() throws RemoteException {
        return this.mUri;
    }

    @Override // com.google.android.gms.internal.zzpc
    public final IObjectWrapper zzjh() throws RemoteException {
        return com.google.android.gms.dynamic.zzn.zzw(this.zzbro);
    }
}

package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzbp;
/* loaded from: classes.dex */
public abstract class zzp<T> {
    private final String zzgow;
    private T zzgox;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzp(String str) {
        this.zzgow = str;
    }

    protected abstract T zzb(IBinder iBinder);

    /* JADX INFO: Access modifiers changed from: protected */
    public final T zzcv(Context context) throws zzq {
        if (this.zzgox == null) {
            zzbp.zzu(context);
            Context remoteContext = com.google.android.gms.common.zzo.getRemoteContext(context);
            if (remoteContext == null) {
                throw new zzq("Could not get remote context.");
            }
            try {
                this.zzgox = zzb((IBinder) remoteContext.getClassLoader().loadClass(this.zzgow).newInstance());
            } catch (ClassNotFoundException e) {
                throw new zzq("Could not load creator class.", e);
            } catch (IllegalAccessException e2) {
                throw new zzq("Could not access creator.", e2);
            } catch (InstantiationException e3) {
                throw new zzq("Could not instantiate creator.", e3);
            }
        }
        return this.zzgox;
    }
}

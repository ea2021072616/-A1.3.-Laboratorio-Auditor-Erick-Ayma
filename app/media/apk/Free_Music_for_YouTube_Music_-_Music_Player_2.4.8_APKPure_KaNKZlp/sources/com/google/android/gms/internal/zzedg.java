package com.google.android.gms.internal;

import com.google.android.gms.internal.zzedf;
import com.google.android.gms.internal.zzedg;
/* loaded from: classes2.dex */
public abstract class zzedg<MessageType extends zzedf<MessageType, BuilderType>, BuilderType extends zzedg<MessageType, BuilderType>> implements zzeez {
    protected abstract BuilderType zza(MessageType messagetype);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzeez
    public final /* synthetic */ zzeez zzc(zzeey zzeeyVar) {
        if (zzcco().getClass().isInstance(zzeeyVar)) {
            return zza((zzedf) zzeeyVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    @Override // 
    /* renamed from: zzcbj */
    public abstract BuilderType clone();
}

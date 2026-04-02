package com.google.android.gms.internal;

import com.google.android.gms.internal.zzedf;
import com.google.android.gms.internal.zzedg;
import java.io.IOException;
/* loaded from: classes2.dex */
public abstract class zzedf<MessageType extends zzedf<MessageType, BuilderType>, BuilderType extends zzedg<MessageType, BuilderType>> implements zzeey {
    private static boolean zzmxo = false;
    protected int zzmxn = 0;

    @Override // com.google.android.gms.internal.zzeey
    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzbjo()];
            zzedw zzat = zzedw.zzat(bArr);
            zza(zzat);
            zzat.zzccd();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("byte array").length()).append("Serializing ").append(name).append(" to a ").append("byte array").append(" threw an IOException (should never happen).").toString(), e);
        }
    }

    @Override // com.google.android.gms.internal.zzeey
    public final zzedk zzcbi() {
        try {
            zzedp zzgj = zzedk.zzgj(zzbjo());
            zza(zzgj.zzcbq());
            return zzgj.zzcbp();
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("ByteString").length()).append("Serializing ").append(name).append(" to a ").append("ByteString").append(" threw an IOException (should never happen).").toString(), e);
        }
    }
}

package com.google.android.gms.internal;

import com.google.android.exoplayer2.C;
import com.google.android.gms.internal.zzdgq;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes2.dex */
public final class zzdgn<P> {
    private static final Charset UTF_8 = Charset.forName(C.UTF8_NAME);
    private ConcurrentMap<String, List<zzdgo<P>>> zzlah = new ConcurrentHashMap();
    private zzdgo<P> zzlai;

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzdgo<P> zza(P p, zzdgq.zzc.zzb zzbVar) throws GeneralSecurityException {
        byte[] bArr;
        switch (zzbVar.zzbmu()) {
            case LEGACY:
                bArr = ByteBuffer.allocate(5).put((byte) 0).putInt(zzbVar.zzbmt()).array();
                break;
            case TINK:
                bArr = ByteBuffer.allocate(5).put((byte) 1).putInt(zzbVar.zzbmt()).array();
                break;
            case RAW:
                bArr = zzdga.zzkzd;
                break;
            default:
                throw new GeneralSecurityException("unknown output prefix type");
        }
        zzdgo<P> zzdgoVar = new zzdgo<>(this, p, bArr, zzbVar.zzbms());
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzdgoVar);
        String str = new String(zzdgoVar.zzbmd(), UTF_8);
        List<zzdgo<P>> put = this.zzlah.put(str, Collections.unmodifiableList(arrayList));
        if (put != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(put);
            arrayList2.add(zzdgoVar);
            this.zzlah.put(str, Collections.unmodifiableList(arrayList2));
        }
        return zzdgoVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(zzdgo<P> zzdgoVar) {
        this.zzlai = zzdgoVar;
    }

    public final zzdgo<P> zzbmb() {
        return this.zzlai;
    }
}

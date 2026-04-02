package com.google.android.gms.internal;

import com.google.android.gms.internal.zzeed;
import com.google.android.gms.internal.zzeee;
/* loaded from: classes2.dex */
public class zzeee<MessageType extends zzeed<MessageType, BuilderType>, BuilderType extends zzeee<MessageType, BuilderType>> extends zzedg<MessageType, BuilderType> {
    private final MessageType zzmyt;
    protected MessageType zzmyu;
    private boolean zzmyv = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzeee(MessageType messagetype) {
        this.zzmyt = messagetype;
        this.zzmyu = (MessageType) messagetype.zza(zzeel.zzmze, null, null);
    }

    private static void zza(MessageType messagetype, MessageType messagetype2) {
        zzeek zzeekVar = zzeek.zzmyz;
        messagetype.zza(zzeel.zzmzb, zzeekVar, messagetype2);
        messagetype.zzmyr = zzeekVar.zza(messagetype.zzmyr, messagetype2.zzmyr);
    }

    @Override // com.google.android.gms.internal.zzedg
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        MessageType messagetype;
        zzeee zzeeeVar = (zzeee) this.zzmyt.zza(zzeel.zzmzf, null, null);
        if (this.zzmyv) {
            messagetype = this.zzmyu;
        } else {
            MessageType messagetype2 = this.zzmyu;
            messagetype2.zza(zzeel.zzmzd, null, null);
            messagetype2.zzmyr.zzbhq();
            this.zzmyv = true;
            messagetype = this.zzmyu;
        }
        zzeeeVar.zza((zzeee) messagetype);
        return zzeeeVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzedg
    protected final /* synthetic */ zzedg zza(zzedf zzedfVar) {
        return zza((zzeee<MessageType, BuilderType>) ((zzeed) zzedfVar));
    }

    public final BuilderType zza(MessageType messagetype) {
        zzccp();
        zza(this.zzmyu, messagetype);
        return this;
    }

    @Override // com.google.android.gms.internal.zzedg
    public final /* synthetic */ zzedg zzcbj() {
        return (zzeee) clone();
    }

    @Override // com.google.android.gms.internal.zzefa
    public final /* synthetic */ zzeey zzcco() {
        return this.zzmyt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzccp() {
        if (this.zzmyv) {
            MessageType messagetype = (MessageType) this.zzmyu.zza(zzeel.zzmze, null, null);
            zza(messagetype, this.zzmyu);
            this.zzmyu = messagetype;
            this.zzmyv = false;
        }
    }

    public final MessageType zzccq() {
        if (this.zzmyv) {
            return this.zzmyu;
        }
        MessageType messagetype = this.zzmyu;
        messagetype.zza(zzeel.zzmzd, null, null);
        messagetype.zzmyr.zzbhq();
        this.zzmyv = true;
        return this.zzmyu;
    }

    public final MessageType zzccr() {
        MessageType messagetype;
        if (this.zzmyv) {
            messagetype = this.zzmyu;
        } else {
            MessageType messagetype2 = this.zzmyu;
            messagetype2.zza(zzeel.zzmzd, null, null);
            messagetype2.zzmyr.zzbhq();
            this.zzmyv = true;
            messagetype = this.zzmyu;
        }
        MessageType messagetype3 = messagetype;
        if (messagetype3.zza(zzeel.zzmza, Boolean.TRUE, null) != null) {
            return messagetype3;
        }
        throw new zzefp(messagetype3);
    }

    @Override // com.google.android.gms.internal.zzeez
    public final /* synthetic */ zzeey zzccs() {
        MessageType messagetype;
        if (this.zzmyv) {
            messagetype = this.zzmyu;
        } else {
            MessageType messagetype2 = this.zzmyu;
            messagetype2.zza(zzeel.zzmzd, null, null);
            messagetype2.zzmyr.zzbhq();
            this.zzmyv = true;
            messagetype = this.zzmyu;
        }
        MessageType messagetype3 = messagetype;
        if (messagetype3.zza(zzeel.zzmza, Boolean.TRUE, null) != null) {
            return messagetype3;
        }
        throw new zzefp(messagetype3);
    }
}

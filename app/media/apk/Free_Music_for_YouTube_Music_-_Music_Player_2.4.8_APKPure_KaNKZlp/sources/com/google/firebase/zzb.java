package com.google.firebase;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzcz;
/* loaded from: classes2.dex */
public final class zzb implements zzcz {
    @Override // com.google.android.gms.common.api.internal.zzcz
    public final Exception zzr(Status status) {
        return status.getStatusCode() == 8 ? new FirebaseException(status.zzaft()) : new FirebaseApiNotAvailableException(status.zzaft());
    }
}

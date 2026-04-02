package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* loaded from: classes2.dex */
public final class zzeff<FieldDescriptorType> extends zzefe<FieldDescriptorType, Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeff(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.zzefe
    public final void zzbhq() {
        if (!isImmutable()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= zzccz()) {
                    break;
                }
                Map.Entry<FieldDescriptorType, Object> zzgw = zzgw(i2);
                if (((zzeec) zzgw.getKey()).zzccl()) {
                    zzgw.setValue(Collections.unmodifiableList((List) zzgw.getValue()));
                }
                i = i2 + 1;
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : zzcda()) {
                if (((zzeec) entry.getKey()).zzccl()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzbhq();
    }
}

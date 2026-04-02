package com.google.android.gms.internal;

import java.util.List;
/* loaded from: classes2.dex */
public final class zzefp extends RuntimeException {
    private final List<String> zznah;

    public zzefp(zzeey zzeeyVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.zznah = null;
    }

    public final zzeer zzcdg() {
        return new zzeer(getMessage());
    }
}

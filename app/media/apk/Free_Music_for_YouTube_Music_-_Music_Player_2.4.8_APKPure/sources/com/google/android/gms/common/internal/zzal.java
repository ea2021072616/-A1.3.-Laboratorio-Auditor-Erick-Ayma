package com.google.android.gms.common.internal;

import android.support.annotation.NonNull;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
/* loaded from: classes.dex */
public final class zzal {
    @NonNull
    private final String mPackageName;
    @NonNull
    private final String zzfvg;
    private final boolean zzfvh = false;
    private final int zzfur = TsExtractor.TS_STREAM_TYPE_AC3;

    public zzal(@NonNull String str, @NonNull String str2, boolean z, int i) {
        this.mPackageName = str;
        this.zzfvg = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public final String getPackageName() {
        return this.mPackageName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzakg() {
        return this.zzfur;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public final String zzakk() {
        return this.zzfvg;
    }
}

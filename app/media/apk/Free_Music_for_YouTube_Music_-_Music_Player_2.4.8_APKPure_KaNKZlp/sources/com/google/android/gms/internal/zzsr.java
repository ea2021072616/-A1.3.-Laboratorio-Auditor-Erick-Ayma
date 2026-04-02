package com.google.android.gms.internal;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
@zzzt
/* loaded from: classes.dex */
public final class zzsr extends zzsl {
    private static final Set<String> zzbwq = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzbwr = new DecimalFormat("#,###");
    private File zzbws;
    private boolean zzbwt;

    public zzsr(zzakk zzakkVar) {
        super(zzakkVar);
        File cacheDir = this.mContext.getCacheDir();
        if (cacheDir == null) {
            zzafx.zzcs("Context.getCacheDir() returned null");
            return;
        }
        this.zzbws = new File(cacheDir, "admobVideoStreams");
        if (!this.zzbws.isDirectory() && !this.zzbws.mkdirs()) {
            String valueOf = String.valueOf(this.zzbws.getAbsolutePath());
            zzafx.zzcs(valueOf.length() != 0 ? "Could not create preload cache directory at ".concat(valueOf) : new String("Could not create preload cache directory at "));
            this.zzbws = null;
        } else if (this.zzbws.setReadable(true, false) && this.zzbws.setExecutable(true, false)) {
        } else {
            String valueOf2 = String.valueOf(this.zzbws.getAbsolutePath());
            zzafx.zzcs(valueOf2.length() != 0 ? "Could not set cache file permissions at ".concat(valueOf2) : new String("Could not set cache file permissions at "));
            this.zzbws = null;
        }
    }

    private final File zzb(File file) {
        return new File(this.zzbws, String.valueOf(file.getName()).concat(".done"));
    }

    @Override // com.google.android.gms.internal.zzsl
    public final void abort() {
        this.zzbwt = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:156:0x0452, code lost:
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x045a, code lost:
        if (com.google.android.gms.internal.zzafx.zzad(3) == false) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x045c, code lost:
        r2 = com.google.android.gms.internal.zzsr.zzbwr.format(r6);
        com.google.android.gms.internal.zzafx.zzcb(new java.lang.StringBuilder((java.lang.String.valueOf(r2).length() + 22) + java.lang.String.valueOf(r28).length()).append("Preloaded ").append(r2).append(" bytes from ").append(r28).toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0498, code lost:
        r13.setReadable(true, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x04a1, code lost:
        if (r14.isFile() == false) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x04a3, code lost:
        r14.setLastModified(java.lang.System.currentTimeMillis());
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x04bd, code lost:
        r14.createNewFile();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v42, types: [com.google.android.gms.internal.zzsl] */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r3v64 */
    /* JADX WARN: Type inference failed for: r3v65 */
    /* JADX WARN: Type inference failed for: r4v17, types: [long] */
    /* JADX WARN: Type inference failed for: r4v21, types: [java.lang.String] */
    @Override // com.google.android.gms.internal.zzsl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzau(java.lang.String r28) {
        /*
            Method dump skipped, instructions count: 1291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsr.zzau(java.lang.String):boolean");
    }
}

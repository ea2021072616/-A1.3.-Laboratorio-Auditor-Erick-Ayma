package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
@zzzt
/* loaded from: classes.dex */
final class zzajs {
    private final Object zzdev = new Object();
    private final List<Runnable> zzdew = new ArrayList();
    private boolean zzdex = false;

    public final void zza(final Runnable runnable, final Executor executor) {
        synchronized (this.zzdev) {
            if (this.zzdex) {
                executor.execute(runnable);
            } else {
                this.zzdew.add(new Runnable(executor, runnable) { // from class: com.google.android.gms.internal.zzajt
                    private final Executor zzdey;
                    private final Runnable zzdez;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzdey = executor;
                        this.zzdez = runnable;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzdey.execute(this.zzdez);
                    }
                });
            }
        }
    }

    public final void zzrr() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.zzdev) {
            if (this.zzdex) {
                return;
            }
            arrayList.addAll(this.zzdew);
            this.zzdew.clear();
            this.zzdex = true;
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                ((Runnable) obj).run();
            }
        }
    }
}

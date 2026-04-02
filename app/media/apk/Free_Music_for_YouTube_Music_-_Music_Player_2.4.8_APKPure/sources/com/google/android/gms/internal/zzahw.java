package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zzahw {
    private final Context mContext;
    private int mState;
    private String zzapb;
    private String zzaux;
    private final float zzceq;
    private String zzdby;
    private float zzdbz;
    private float zzdca;
    private float zzdcb;

    public zzahw(Context context) {
        this.mState = 0;
        this.mContext = context;
        this.zzceq = context.getResources().getDisplayMetrics().density;
    }

    public zzahw(Context context, String str) {
        this(context);
        this.zzdby = str;
    }

    private static int zza(List<String> list, String str, boolean z) {
        if (z) {
            list.add(str);
            return list.size() - 1;
        }
        return -1;
    }

    private final void zza(int i, float f, float f2) {
        if (i == 0) {
            this.mState = 0;
            this.zzdbz = f;
            this.zzdca = f2;
            this.zzdcb = f2;
        } else if (this.mState != -1) {
            if (i != 2) {
                if (i == 1 && this.mState == 4) {
                    showDialog();
                    return;
                }
                return;
            }
            if (f2 > this.zzdca) {
                this.zzdca = f2;
            } else if (f2 < this.zzdcb) {
                this.zzdcb = f2;
            }
            if (this.zzdca - this.zzdcb > 30.0f * this.zzceq) {
                this.mState = -1;
                return;
            }
            if (this.mState == 0 || this.mState == 2) {
                if (f - this.zzdbz >= 50.0f * this.zzceq) {
                    this.zzdbz = f;
                    this.mState++;
                }
            } else if ((this.mState == 1 || this.mState == 3) && f - this.zzdbz <= (-50.0f) * this.zzceq) {
                this.zzdbz = f;
                this.mState++;
            }
            if (this.mState == 1 || this.mState == 3) {
                if (f > this.zzdbz) {
                    this.zzdbz = f;
                }
            } else if (this.mState != 2 || f >= this.zzdbz) {
            } else {
                this.zzdbz = f;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x006f, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzrd() {
        /*
            r6 = this;
            android.content.Context r0 = r6.mContext
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 != 0) goto Lc
            java.lang.String r0 = "Can not create dialog without Activity Context"
            com.google.android.gms.internal.zzafx.zzcr(r0)
        Lb:
            return
        Lc:
            java.lang.String r0 = r6.zzdby
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L9d
            java.lang.String r1 = "\\+"
            java.lang.String r2 = "%20"
            java.lang.String r0 = r0.replaceAll(r1, r2)
            android.net.Uri$Builder r1 = new android.net.Uri$Builder
            r1.<init>()
            android.net.Uri$Builder r0 = r1.encodedQuery(r0)
            android.net.Uri r0 = r0.build()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.google.android.gms.ads.internal.zzbv.zzea()
            java.util.Map r2 = com.google.android.gms.internal.zzahf.zzg(r0)
            java.util.Set r0 = r2.keySet()
            java.util.Iterator r3 = r0.iterator()
        L3d:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L63
            java.lang.Object r0 = r3.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.StringBuilder r4 = r1.append(r0)
            java.lang.String r5 = " = "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.Object r0 = r2.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.String r4 = "\n\n"
            r0.append(r4)
            goto L3d
        L63:
            java.lang.String r0 = r1.toString()
            java.lang.String r0 = r0.trim()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L9d
        L71:
            android.app.AlertDialog$Builder r1 = new android.app.AlertDialog$Builder
            android.content.Context r2 = r6.mContext
            r1.<init>(r2)
            r1.setMessage(r0)
            java.lang.String r2 = "Ad Information"
            r1.setTitle(r2)
            java.lang.String r2 = "Share"
            com.google.android.gms.internal.zzahy r3 = new com.google.android.gms.internal.zzahy
            r3.<init>(r6, r0)
            r1.setPositiveButton(r2, r3)
            java.lang.String r0 = "Close"
            com.google.android.gms.internal.zzahz r2 = new com.google.android.gms.internal.zzahz
            r2.<init>(r6)
            r1.setNegativeButton(r0, r2)
            android.app.AlertDialog r0 = r1.create()
            r0.show()
            goto Lb
        L9d:
            java.lang.String r0 = "No debug information"
            goto L71
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzahw.zzrd():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzre() {
        zzafx.zzcb("Debug mode [Creative Preview] selected.");
        zzagz.zza(new zzaia(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzrf() {
        zzafx.zzcb("Debug mode [Troubleshooting] selected.");
        zzagz.zza(new zzaib(this));
    }

    public final void setAdUnitId(String str) {
        this.zzapb = str;
    }

    public final void showDialog() {
        if (!((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbox)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbow)).booleanValue()) {
                zzrd();
                return;
            }
        }
        if (!(this.mContext instanceof Activity)) {
            zzafx.zzcr("Can not create dialog without Activity Context");
            return;
        }
        ArrayList arrayList = new ArrayList();
        int zza = zza((List<String>) arrayList, "Ad Information", true);
        int zza2 = zza(arrayList, "Creative Preview", ((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbow)).booleanValue());
        int zza3 = zza(arrayList, "Troubleshooting", ((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbox)).booleanValue());
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext, com.google.android.gms.ads.internal.zzbv.zzec().zzrc());
        builder.setTitle("Select a Debug Mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new zzahx(this, zza, zza2, zza3));
        builder.create().show();
    }

    public final void zzcn(String str) {
        this.zzaux = str;
    }

    public final void zzco(String str) {
        this.zzdby = str;
    }

    public final void zzf(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            zza(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        zza(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }
}

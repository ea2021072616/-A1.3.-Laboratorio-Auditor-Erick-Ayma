package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import b.a.a.a.a.b.a;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.R;
import java.util.Map;
@zzzt
/* loaded from: classes.dex */
public final class zzwq extends zzxd {
    private final Context mContext;
    private final Map<String, String> zzbqo;
    private String zzcdl;
    private long zzcdm;
    private long zzcdn;
    private String zzcdo;
    private String zzcdp;

    public zzwq(zzakk zzakkVar, Map<String, String> map) {
        super(zzakkVar, "createCalendarEvent");
        this.zzbqo = map;
        this.mContext = zzakkVar.zzrx();
        this.zzcdl = zzbl("description");
        this.zzcdo = zzbl("summary");
        this.zzcdm = zzbm("start_ticks");
        this.zzcdn = zzbm("end_ticks");
        this.zzcdp = zzbl(PlaceFields.LOCATION);
    }

    private final String zzbl(String str) {
        return TextUtils.isEmpty(this.zzbqo.get(str)) ? "" : this.zzbqo.get(str);
    }

    private final long zzbm(String str) {
        String str2 = this.zzbqo.get(str);
        if (str2 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(14)
    public final Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzcdl);
        data.putExtra("eventLocation", this.zzcdp);
        data.putExtra("description", this.zzcdo);
        if (this.zzcdm > -1) {
            data.putExtra("beginTime", this.zzcdm);
        }
        if (this.zzcdn > -1) {
            data.putExtra("endTime", this.zzcdn);
        }
        data.setFlags(268435456);
        return data;
    }

    public final void execute() {
        if (this.mContext == null) {
            zzbn("Activity context is not available.");
            return;
        }
        com.google.android.gms.ads.internal.zzbv.zzea();
        if (!zzahf.zzak(this.mContext).zzij()) {
            zzbn("This feature is not available on the device.");
            return;
        }
        com.google.android.gms.ads.internal.zzbv.zzea();
        AlertDialog.Builder zzaj = zzahf.zzaj(this.mContext);
        Resources resources = com.google.android.gms.ads.internal.zzbv.zzee().getResources();
        zzaj.setTitle(resources != null ? resources.getString(R.string.s5) : "Create calendar event");
        zzaj.setMessage(resources != null ? resources.getString(R.string.s6) : "Allow Ad to create a calendar event?");
        zzaj.setPositiveButton(resources != null ? resources.getString(R.string.s3) : a.HEADER_ACCEPT, new zzwr(this));
        zzaj.setNegativeButton(resources != null ? resources.getString(R.string.s4) : "Decline", new zzws(this));
        zzaj.create().show();
    }
}

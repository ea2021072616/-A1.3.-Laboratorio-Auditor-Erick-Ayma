package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import b.a.a.a.a.b.a;
import com.google.android.gms.R;
import java.util.Map;
@zzzt
/* loaded from: classes.dex */
public final class zzww extends zzxd {
    private final Context mContext;
    private final Map<String, String> zzbqo;

    public zzww(zzakk zzakkVar, Map<String, String> map) {
        super(zzakkVar, "storePicture");
        this.zzbqo = map;
        this.mContext = zzakkVar.zzrx();
    }

    public final void execute() {
        if (this.mContext == null) {
            zzbn("Activity context is not available");
            return;
        }
        com.google.android.gms.ads.internal.zzbv.zzea();
        if (!zzahf.zzak(this.mContext).zzii()) {
            zzbn("Feature is not supported by the device.");
            return;
        }
        String str = this.zzbqo.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzbn("Image url cannot be empty.");
        } else if (!URLUtil.isValidUrl(str)) {
            String valueOf = String.valueOf(str);
            zzbn(valueOf.length() != 0 ? "Invalid image url: ".concat(valueOf) : new String("Invalid image url: "));
        } else {
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            com.google.android.gms.ads.internal.zzbv.zzea();
            if (!zzahf.zzcj(lastPathSegment)) {
                String valueOf2 = String.valueOf(lastPathSegment);
                zzbn(valueOf2.length() != 0 ? "Image type not recognized: ".concat(valueOf2) : new String("Image type not recognized: "));
                return;
            }
            Resources resources = com.google.android.gms.ads.internal.zzbv.zzee().getResources();
            com.google.android.gms.ads.internal.zzbv.zzea();
            AlertDialog.Builder zzaj = zzahf.zzaj(this.mContext);
            zzaj.setTitle(resources != null ? resources.getString(R.string.s1) : "Save image");
            zzaj.setMessage(resources != null ? resources.getString(R.string.s2) : "Allow Ad to store image in Picture gallery?");
            zzaj.setPositiveButton(resources != null ? resources.getString(R.string.s3) : a.HEADER_ACCEPT, new zzwx(this, str, lastPathSegment));
            zzaj.setNegativeButton(resources != null ? resources.getString(R.string.s4) : "Decline", new zzwy(this));
            zzaj.create().show();
        }
    }
}

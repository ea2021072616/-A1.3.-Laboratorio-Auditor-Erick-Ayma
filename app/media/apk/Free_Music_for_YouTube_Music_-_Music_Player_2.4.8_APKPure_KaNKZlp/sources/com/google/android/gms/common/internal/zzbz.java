package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.R;
/* loaded from: classes.dex */
public final class zzbz {
    private final Resources zzfvz;
    private final String zzfwa;

    public zzbz(Context context) {
        zzbp.zzu(context);
        this.zzfvz = context.getResources();
        this.zzfwa = this.zzfvz.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
    }

    public final String getString(String str) {
        int identifier = this.zzfvz.getIdentifier(str, "string", this.zzfwa);
        if (identifier == 0) {
            return null;
        }
        return this.zzfvz.getString(identifier);
    }
}

package androidx.emoji2.text;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
/* loaded from: classes.dex */
public final class e extends d {
    @Override // p3.e
    public final Signature[] j(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }
}

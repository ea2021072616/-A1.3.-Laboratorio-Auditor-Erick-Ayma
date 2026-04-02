package b.a.a.a.a.b;

import android.content.Context;
/* compiled from: InstallerPackageNameProvider.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private final b.a.a.a.a.a.d<String> f121a = new b.a.a.a.a.a.d<String>() { // from class: b.a.a.a.a.b.p.1
        @Override // b.a.a.a.a.a.d
        /* renamed from: a */
        public String load(Context context) throws Exception {
            String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            return installerPackageName == null ? "" : installerPackageName;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final b.a.a.a.a.a.b<String> f122b = new b.a.a.a.a.a.b<>();

    public String a(Context context) {
        try {
            String a2 = this.f122b.a(context, this.f121a);
            if ("".equals(a2)) {
                return null;
            }
            return a2;
        } catch (Exception e) {
            b.a.a.a.c.h().e("Fabric", "Failed to determine installer package name", e);
            return null;
        }
    }
}

package b.a.a.a.a.g;

import android.content.res.Resources;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractAppSpiCall.java */
/* loaded from: classes.dex */
public abstract class a extends b.a.a.a.a.b.a {
    public a(b.a.a.a.i iVar, String str, String str2, b.a.a.a.a.e.e eVar, b.a.a.a.a.e.c cVar) {
        super(iVar, str, str2, eVar, cVar);
    }

    public boolean a(d dVar) {
        b.a.a.a.a.e.d b2 = b(a(getHttpRequest(), dVar), dVar);
        b.a.a.a.c.h().a("Fabric", "Sending app info to " + getUrl());
        if (dVar.j != null) {
            b.a.a.a.c.h().a("Fabric", "App icon hash is " + dVar.j.f233a);
            b.a.a.a.c.h().a("Fabric", "App icon size is " + dVar.j.f235c + "x" + dVar.j.d);
        }
        int b3 = b2.b();
        b.a.a.a.c.h().a("Fabric", ("POST".equals(b2.p()) ? "Create" : "Update") + " app request ID: " + b2.b(b.a.a.a.a.b.a.HEADER_REQUEST_ID));
        b.a.a.a.c.h().a("Fabric", "Result was " + b3);
        return b.a.a.a.a.b.r.a(b3) == 0;
    }

    private b.a.a.a.a.e.d a(b.a.a.a.a.e.d dVar, d dVar2) {
        return dVar.a(b.a.a.a.a.b.a.HEADER_API_KEY, dVar2.f218a).a(b.a.a.a.a.b.a.HEADER_CLIENT_TYPE, "android").a(b.a.a.a.a.b.a.HEADER_CLIENT_VERSION, this.kit.getVersion());
    }

    private b.a.a.a.a.e.d b(b.a.a.a.a.e.d dVar, d dVar2) {
        b.a.a.a.a.e.d e = dVar.e("app[identifier]", dVar2.f219b).e("app[name]", dVar2.f).e("app[display_version]", dVar2.f220c).e("app[build_version]", dVar2.d).a("app[source]", Integer.valueOf(dVar2.g)).e("app[minimum_sdk_version]", dVar2.h).e("app[built_sdk_version]", dVar2.i);
        if (!b.a.a.a.a.b.i.c(dVar2.e)) {
            e.e("app[instance_identifier]", dVar2.e);
        }
        if (dVar2.j != null) {
            InputStream inputStream = null;
            try {
                inputStream = this.kit.getContext().getResources().openRawResource(dVar2.j.f234b);
                e.e("app[icon][hash]", dVar2.j.f233a).a("app[icon][data]", "icon.png", "application/octet-stream", inputStream).a("app[icon][width]", Integer.valueOf(dVar2.j.f235c)).a("app[icon][height]", Integer.valueOf(dVar2.j.d));
            } catch (Resources.NotFoundException e2) {
                b.a.a.a.c.h().e("Fabric", "Failed to find app icon with resource ID: " + dVar2.j.f234b, e2);
            } finally {
                b.a.a.a.a.b.i.a((Closeable) inputStream, "Failed to close app icon InputStream.");
            }
        }
        if (dVar2.k != null) {
            for (b.a.a.a.k kVar : dVar2.k) {
                e.e(a(kVar), kVar.b());
                e.e(b(kVar), kVar.c());
            }
        }
        return e;
    }

    String a(b.a.a.a.k kVar) {
        return String.format(Locale.US, "app[build][libraries][%s][version]", kVar.a());
    }

    String b(b.a.a.a.k kVar) {
        return String.format(Locale.US, "app[build][libraries][%s][type]", kVar.a());
    }
}

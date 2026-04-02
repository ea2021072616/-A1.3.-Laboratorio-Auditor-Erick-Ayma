package z0;

import android.content.res.AssetManager;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final AssetManager f5773a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f5774b;

    /* renamed from: c  reason: collision with root package name */
    public final e f5775c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f5776d;

    /* renamed from: e  reason: collision with root package name */
    public final File f5777e;

    /* renamed from: f  reason: collision with root package name */
    public final String f5778f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5779g = false;

    /* renamed from: h  reason: collision with root package name */
    public c[] f5780h;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f5781i;

    public b(AssetManager assetManager, i.a aVar, e eVar, String str, File file) {
        byte[] bArr;
        this.f5773a = assetManager;
        this.f5774b = aVar;
        this.f5775c = eVar;
        this.f5778f = str;
        this.f5777e = file;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 <= 34) {
            switch (i5) {
                case 26:
                    bArr = p2.a.f4261q;
                    break;
                case 27:
                    bArr = p2.a.f4260p;
                    break;
                case 28:
                case 29:
                case 30:
                    bArr = p2.a.o;
                    break;
                case 31:
                case 32:
                case 33:
                case 34:
                    bArr = p2.a.f4259n;
                    break;
            }
            this.f5776d = bArr;
        }
        bArr = null;
        this.f5776d = bArr;
    }

    public final FileInputStream a(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e5) {
            String message = e5.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f5775c.k();
            }
            return null;
        }
    }

    public final void b(int i5, Serializable serializable) {
        this.f5774b.execute(new a(i5, 0, this, serializable));
    }
}

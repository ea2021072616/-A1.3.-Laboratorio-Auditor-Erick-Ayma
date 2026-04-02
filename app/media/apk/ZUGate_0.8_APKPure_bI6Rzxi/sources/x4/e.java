package x4;

import android.os.ParcelFileDescriptor;
import android.system.OsConstants;
import android.util.Log;
import t4.r;
/* loaded from: classes.dex */
public final class e extends Thread {

    /* renamed from: b  reason: collision with root package name */
    public final ParcelFileDescriptor f5519b;

    /* renamed from: c  reason: collision with root package name */
    public final r f5520c;

    /* renamed from: d  reason: collision with root package name */
    public final w4.g f5521d;

    public e(w4.g gVar, r rVar, ParcelFileDescriptor parcelFileDescriptor) {
        this.f5519b = parcelFileDescriptor;
        this.f5520c = rVar;
        this.f5521d = gVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String str;
        w4.g gVar = this.f5521d;
        r rVar = this.f5520c;
        ParcelFileDescriptor parcelFileDescriptor = this.f5519b;
        try {
            rVar.f5093i = gVar.h(parcelFileDescriptor.getFd());
            int i5 = rVar.f5093i;
            str = i5 < 0 ? OsConstants.errnoName(-i5) : null;
        } catch (Exception e5) {
            String message = e5.getMessage();
            Log.e(e.class.getSimpleName(), "Exception write file", e5);
            str = message;
        }
        try {
            gVar.close();
        } catch (Exception unused) {
        }
        try {
            if (str != null) {
                parcelFileDescriptor.closeWithError(str);
            } else {
                parcelFileDescriptor.close();
            }
        } catch (Exception unused2) {
        }
    }
}

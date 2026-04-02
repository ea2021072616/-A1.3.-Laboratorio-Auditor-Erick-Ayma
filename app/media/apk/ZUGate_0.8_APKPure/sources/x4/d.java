package x4;

import android.os.HandlerThread;
import android.os.ProxyFileDescriptorCallback;
import android.system.ErrnoException;
import android.system.OsConstants;
import t4.r;
/* loaded from: classes.dex */
public final class d extends ProxyFileDescriptorCallback {

    /* renamed from: a  reason: collision with root package name */
    public final r f5515a;

    /* renamed from: b  reason: collision with root package name */
    public final w4.g f5516b;

    /* renamed from: c  reason: collision with root package name */
    public long f5517c = 0;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f5518d = null;

    public d(r rVar, w4.g gVar) {
        this.f5515a = rVar;
        this.f5516b = gVar;
    }

    public final void finalize() {
        HandlerThread handlerThread = this.f5518d;
        this.f5518d = null;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
    }

    @Override // android.os.ProxyFileDescriptorCallback
    public final void onFsync() {
    }

    @Override // android.os.ProxyFileDescriptorCallback
    public final long onGetSize() {
        w4.g gVar = this.f5516b;
        long y5 = gVar.y();
        if (y5 >= 0) {
            return y5;
        }
        long r5 = gVar.r(0L, 2);
        if (r5 >= 0) {
            gVar.r(this.f5517c, 0);
            return r5;
        }
        throw new ErrnoException("Seek", OsConstants.EINVAL);
    }

    @Override // android.os.ProxyFileDescriptorCallback
    public final int onRead(long j5, int i5, byte[] bArr) {
        int i6 = (this.f5517c > j5 ? 1 : (this.f5517c == j5 ? 0 : -1));
        w4.g gVar = this.f5516b;
        if (i6 != 0) {
            long r5 = gVar.r(j5, 0);
            if (r5 < 0) {
                throw new ErrnoException("Seek", OsConstants.EINVAL);
            }
            this.f5517c = r5;
        }
        int s5 = gVar.s(bArr, i5);
        if (s5 >= 0) {
            this.f5517c += s5;
            return s5;
        }
        this.f5515a.f5093i = s5;
        throw new ErrnoException("Read", s5);
    }

    @Override // android.os.ProxyFileDescriptorCallback
    public final void onRelease() {
        this.f5516b.close();
        HandlerThread handlerThread = this.f5518d;
        this.f5518d = null;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
    }

    @Override // android.os.ProxyFileDescriptorCallback
    public final int onWrite(long j5, int i5, byte[] bArr) {
        int i6 = (this.f5517c > j5 ? 1 : (this.f5517c == j5 ? 0 : -1));
        w4.g gVar = this.f5516b;
        if (i6 != 0) {
            long r5 = gVar.r(j5, 0);
            if (r5 < 0) {
                throw new ErrnoException("Seek", OsConstants.EINVAL);
            }
            this.f5517c = r5;
        }
        int o = gVar.o(bArr, i5);
        if (o >= 0) {
            this.f5517c += o;
            return o;
        }
        this.f5515a.f5093i = o;
        throw new ErrnoException("Write", o);
    }
}

package r0;

import java.nio.ByteBuffer;
import p3.e;
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public int f4466a;

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f4467b;

    /* renamed from: c  reason: collision with root package name */
    public int f4468c;

    /* renamed from: d  reason: collision with root package name */
    public int f4469d;

    public c() {
        if (e.f4270h == null) {
            e.f4270h = new e();
        }
    }

    public final int a(int i5) {
        if (i5 < this.f4469d) {
            return this.f4467b.getShort(this.f4468c + i5);
        }
        return 0;
    }

    public final void b(int i5, ByteBuffer byteBuffer) {
        this.f4467b = byteBuffer;
        if (byteBuffer == null) {
            this.f4466a = 0;
            this.f4468c = 0;
            this.f4469d = 0;
            return;
        }
        this.f4466a = i5;
        int i6 = i5 - byteBuffer.getInt(i5);
        this.f4468c = i6;
        this.f4469d = this.f4467b.getShort(i6);
    }
}

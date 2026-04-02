package androidx.emoji2.text;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadLocal f749d = new ThreadLocal();

    /* renamed from: a  reason: collision with root package name */
    public final int f750a;

    /* renamed from: b  reason: collision with root package name */
    public final g.f f751b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f752c = 0;

    public d0(g.f fVar, int i5) {
        this.f751b = fVar;
        this.f750a = i5;
    }

    public final int a(int i5) {
        r0.a c5 = c();
        int a5 = c5.a(16);
        if (a5 != 0) {
            ByteBuffer byteBuffer = c5.f4467b;
            int i6 = a5 + c5.f4466a;
            return byteBuffer.getInt((i5 * 4) + byteBuffer.getInt(i6) + i6 + 4);
        }
        return 0;
    }

    public final int b() {
        r0.a c5 = c();
        int a5 = c5.a(16);
        if (a5 != 0) {
            int i5 = a5 + c5.f4466a;
            return c5.f4467b.getInt(c5.f4467b.getInt(i5) + i5);
        }
        return 0;
    }

    public final r0.a c() {
        ThreadLocal threadLocal = f749d;
        r0.a aVar = (r0.a) threadLocal.get();
        if (aVar == null) {
            aVar = new r0.a();
            threadLocal.set(aVar);
        }
        r0.b bVar = (r0.b) this.f751b.f2877a;
        int a5 = bVar.a(6);
        if (a5 != 0) {
            int i5 = a5 + bVar.f4466a;
            int i6 = (this.f750a * 4) + bVar.f4467b.getInt(i5) + i5 + 4;
            aVar.b(bVar.f4467b.getInt(i6) + i6, bVar.f4467b);
        }
        return aVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        r0.a c5 = c();
        int a5 = c5.a(4);
        sb.append(Integer.toHexString(a5 != 0 ? c5.f4467b.getInt(a5 + c5.f4466a) : 0));
        sb.append(", codepoints:");
        int b5 = b();
        for (int i5 = 0; i5 < b5; i5++) {
            sb.append(Integer.toHexString(a(i5)));
            sb.append(" ");
        }
        return sb.toString();
    }
}

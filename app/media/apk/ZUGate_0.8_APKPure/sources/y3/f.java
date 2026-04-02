package y3;

import androidx.appcompat.widget.d0;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes.dex */
public final class f implements v3.e {

    /* renamed from: f  reason: collision with root package name */
    public static final Charset f5696f = Charset.forName("UTF-8");

    /* renamed from: g  reason: collision with root package name */
    public static final v3.c f5697g;

    /* renamed from: h  reason: collision with root package name */
    public static final v3.c f5698h;

    /* renamed from: i  reason: collision with root package name */
    public static final x3.a f5699i;

    /* renamed from: a  reason: collision with root package name */
    public OutputStream f5700a;

    /* renamed from: b  reason: collision with root package name */
    public final Map f5701b;

    /* renamed from: c  reason: collision with root package name */
    public final Map f5702c;

    /* renamed from: d  reason: collision with root package name */
    public final v3.d f5703d;

    /* renamed from: e  reason: collision with root package name */
    public final g f5704e = new g(this);

    static {
        d0 a5 = v3.c.a("key");
        d dVar = d.DEFAULT;
        a5.n(new a(1, dVar));
        f5697g = a5.g();
        d0 a6 = v3.c.a("value");
        a6.n(new a(2, dVar));
        f5698h = a6.g();
        f5699i = new x3.a(1);
    }

    public f(ByteArrayOutputStream byteArrayOutputStream, Map map, Map map2, v3.d dVar) {
        this.f5700a = byteArrayOutputStream;
        this.f5701b = map;
        this.f5702c = map2;
        this.f5703d = dVar;
    }

    public static int g(v3.c cVar) {
        e eVar = (e) ((Annotation) cVar.f5216b.get(e.class));
        if (eVar != null) {
            return ((a) eVar).f5691a;
        }
        throw new v3.b("Field has no @Protobuf config");
    }

    public final f a(v3.c cVar, Object obj, boolean z4) {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z4 && charSequence.length() == 0) {
                return this;
            }
            h((g(cVar) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f5696f);
            h(bytes.length);
            this.f5700a.write(bytes);
            return this;
        } else if (obj instanceof Collection) {
            for (Object obj2 : (Collection) obj) {
                a(cVar, obj2, false);
            }
            return this;
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                f(f5699i, cVar, entry, false);
            }
            return this;
        } else if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (!z4 || doubleValue != 0.0d) {
                h((g(cVar) << 3) | 1);
                this.f5700a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(doubleValue).array());
            }
            return this;
        } else if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            if (!z4 || floatValue != 0.0f) {
                h((g(cVar) << 3) | 5);
                this.f5700a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(floatValue).array());
            }
            return this;
        } else if (obj instanceof Number) {
            e(cVar, ((Number) obj).longValue(), z4);
            return this;
        } else if (obj instanceof Boolean) {
            b(cVar, ((Boolean) obj).booleanValue() ? 1 : 0, z4);
            return this;
        } else if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z4 && bArr.length == 0) {
                return this;
            }
            h((g(cVar) << 3) | 2);
            h(bArr.length);
            this.f5700a.write(bArr);
            return this;
        } else {
            v3.d dVar = (v3.d) this.f5701b.get(obj.getClass());
            if (dVar != null) {
                f(dVar, cVar, obj, z4);
                return this;
            }
            v3.f fVar = (v3.f) this.f5702c.get(obj.getClass());
            if (fVar != null) {
                g gVar = this.f5704e;
                gVar.f5705a = false;
                gVar.f5707c = cVar;
                gVar.f5706b = z4;
                fVar.a(obj, gVar);
                return this;
            } else if (obj instanceof c) {
                b(cVar, ((a2.c) ((c) obj)).f17b, true);
                return this;
            } else if (obj instanceof Enum) {
                b(cVar, ((Enum) obj).ordinal(), true);
                return this;
            } else {
                f(this.f5703d, cVar, obj, z4);
                return this;
            }
        }
    }

    public final void b(v3.c cVar, int i5, boolean z4) {
        if (z4 && i5 == 0) {
            return;
        }
        e eVar = (e) ((Annotation) cVar.f5216b.get(e.class));
        if (eVar == null) {
            throw new v3.b("Field has no @Protobuf config");
        }
        a aVar = (a) eVar;
        int ordinal = aVar.f5692b.ordinal();
        int i6 = aVar.f5691a;
        if (ordinal == 0) {
            h(i6 << 3);
            h(i5);
        } else if (ordinal == 1) {
            h(i6 << 3);
            h((i5 << 1) ^ (i5 >> 31));
        } else if (ordinal != 2) {
        } else {
            h((i6 << 3) | 5);
            this.f5700a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i5).array());
        }
    }

    @Override // v3.e
    public final v3.e c(v3.c cVar, long j5) {
        e(cVar, j5, true);
        return this;
    }

    @Override // v3.e
    public final v3.e d(v3.c cVar, Object obj) {
        a(cVar, obj, true);
        return this;
    }

    public final void e(v3.c cVar, long j5, boolean z4) {
        if (z4 && j5 == 0) {
            return;
        }
        e eVar = (e) ((Annotation) cVar.f5216b.get(e.class));
        if (eVar == null) {
            throw new v3.b("Field has no @Protobuf config");
        }
        a aVar = (a) eVar;
        int ordinal = aVar.f5692b.ordinal();
        int i5 = aVar.f5691a;
        if (ordinal == 0) {
            h(i5 << 3);
            i(j5);
        } else if (ordinal == 1) {
            h(i5 << 3);
            i((j5 >> 63) ^ (j5 << 1));
        } else if (ordinal != 2) {
        } else {
            h((i5 << 3) | 1);
            this.f5700a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(j5).array());
        }
    }

    public final void f(v3.d dVar, v3.c cVar, Object obj, boolean z4) {
        b bVar = new b();
        try {
            OutputStream outputStream = this.f5700a;
            this.f5700a = bVar;
            dVar.a(obj, this);
            this.f5700a = outputStream;
            long j5 = bVar.f5693b;
            bVar.close();
            if (z4 && j5 == 0) {
                return;
            }
            h((g(cVar) << 3) | 2);
            i(j5);
            dVar.a(obj, this);
        } catch (Throwable th) {
            try {
                bVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void h(int i5) {
        while ((i5 & (-128)) != 0) {
            this.f5700a.write((i5 & 127) | 128);
            i5 >>>= 7;
        }
        this.f5700a.write(i5 & 127);
    }

    public final void i(long j5) {
        while (((-128) & j5) != 0) {
            this.f5700a.write((((int) j5) & 127) | 128);
            j5 >>>= 7;
        }
        this.f5700a.write(((int) j5) & 127);
    }
}

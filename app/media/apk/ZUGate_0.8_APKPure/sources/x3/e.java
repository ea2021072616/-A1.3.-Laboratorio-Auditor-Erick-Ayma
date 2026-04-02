package x3;

import android.util.Base64;
import android.util.JsonWriter;
import java.io.BufferedWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import v3.f;
import v3.g;
/* loaded from: classes.dex */
public final class e implements v3.e, g {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5506a = true;

    /* renamed from: b  reason: collision with root package name */
    public final JsonWriter f5507b;

    /* renamed from: c  reason: collision with root package name */
    public final Map f5508c;

    /* renamed from: d  reason: collision with root package name */
    public final Map f5509d;

    /* renamed from: e  reason: collision with root package name */
    public final v3.d f5510e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f5511f;

    public e(BufferedWriter bufferedWriter, HashMap hashMap, HashMap hashMap2, a aVar, boolean z4) {
        this.f5507b = new JsonWriter(bufferedWriter);
        this.f5508c = hashMap;
        this.f5509d = hashMap2;
        this.f5510e = aVar;
        this.f5511f = z4;
    }

    @Override // v3.g
    public final g a(String str) {
        g();
        this.f5507b.value(str);
        return this;
    }

    @Override // v3.g
    public final g b(boolean z4) {
        g();
        this.f5507b.value(z4);
        return this;
    }

    @Override // v3.e
    public final v3.e c(v3.c cVar, long j5) {
        String str = cVar.f5215a;
        g();
        JsonWriter jsonWriter = this.f5507b;
        jsonWriter.name(str);
        g();
        jsonWriter.value(j5);
        return this;
    }

    @Override // v3.e
    public final v3.e d(v3.c cVar, Object obj) {
        return f(obj, cVar.f5215a);
    }

    public final e e(Object obj) {
        JsonWriter jsonWriter = this.f5507b;
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        } else if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
            return this;
        } else if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                jsonWriter.beginArray();
                for (Object obj2 : (Collection) obj) {
                    e(obj2);
                }
                jsonWriter.endArray();
                return this;
            } else if (obj instanceof Map) {
                jsonWriter.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        f(entry.getValue(), (String) key);
                    } catch (ClassCastException e5) {
                        throw new v3.b(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e5);
                    }
                }
                jsonWriter.endObject();
                return this;
            } else {
                v3.d dVar = (v3.d) this.f5508c.get(obj.getClass());
                if (dVar != null) {
                    jsonWriter.beginObject();
                    dVar.a(obj, this);
                    jsonWriter.endObject();
                    return this;
                }
                f fVar = (f) this.f5509d.get(obj.getClass());
                if (fVar != null) {
                    fVar.a(obj, this);
                    return this;
                } else if (obj instanceof Enum) {
                    String name = ((Enum) obj).name();
                    g();
                    jsonWriter.value(name);
                    return this;
                } else {
                    jsonWriter.beginObject();
                    this.f5510e.a(obj, this);
                    jsonWriter.endObject();
                    return this;
                }
            }
        } else if (obj instanceof byte[]) {
            g();
            jsonWriter.value(Base64.encodeToString((byte[]) obj, 2));
            return this;
        } else {
            jsonWriter.beginArray();
            int i5 = 0;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                int length = iArr.length;
                while (i5 < length) {
                    jsonWriter.value(iArr[i5]);
                    i5++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length2 = jArr.length;
                while (i5 < length2) {
                    long j5 = jArr[i5];
                    g();
                    jsonWriter.value(j5);
                    i5++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length3 = dArr.length;
                while (i5 < length3) {
                    jsonWriter.value(dArr[i5]);
                    i5++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length4 = zArr.length;
                while (i5 < length4) {
                    jsonWriter.value(zArr[i5]);
                    i5++;
                }
            } else if (obj instanceof Number[]) {
                Number[] numberArr = (Number[]) obj;
                int length5 = numberArr.length;
                while (i5 < length5) {
                    e(numberArr[i5]);
                    i5++;
                }
            } else {
                Object[] objArr = (Object[]) obj;
                int length6 = objArr.length;
                while (i5 < length6) {
                    e(objArr[i5]);
                    i5++;
                }
            }
            jsonWriter.endArray();
            return this;
        }
    }

    public final e f(Object obj, String str) {
        boolean z4 = this.f5511f;
        JsonWriter jsonWriter = this.f5507b;
        if (z4) {
            if (obj == null) {
                return this;
            }
            g();
            jsonWriter.name(str);
            return e(obj);
        }
        g();
        jsonWriter.name(str);
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        return e(obj);
    }

    public final void g() {
        if (!this.f5506a) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
    }
}

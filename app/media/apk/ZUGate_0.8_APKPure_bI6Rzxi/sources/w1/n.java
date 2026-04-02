package w1;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.BufferedReader;
import java.io.IOException;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final long f5375a;

    public n(long j5) {
        this.f5375a = j5;
    }

    public static n a(BufferedReader bufferedReader) {
        JsonReader jsonReader = new JsonReader(bufferedReader);
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.nextName().equals("nextRequestWaitMillis")) {
                    return jsonReader.peek() == JsonToken.STRING ? new n(Long.parseLong(jsonReader.nextString())) : new n(jsonReader.nextLong());
                }
                jsonReader.skipValue();
            }
            throw new IOException("Response is missing nextRequestWaitMillis field.");
        } finally {
            jsonReader.close();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            return this.f5375a == ((n) obj).f5375a;
        }
        return false;
    }

    public final int hashCode() {
        long j5 = this.f5375a;
        return ((int) ((j5 >>> 32) ^ j5)) ^ 1000003;
    }

    public final String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f5375a + "}";
    }
}

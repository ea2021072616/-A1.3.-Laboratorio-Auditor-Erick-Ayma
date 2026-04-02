package okhttp3;

import c.c;
import c.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.Util;
/* loaded from: classes2.dex */
public final class FormBody extends RequestBody {
    private static final MediaType CONTENT_TYPE = MediaType.parse("application/x-www-form-urlencoded");
    private final List<String> encodedNames;
    private final List<String> encodedValues;

    FormBody(List<String> list, List<String> list2) {
        this.encodedNames = Util.immutableList(list);
        this.encodedValues = Util.immutableList(list2);
    }

    public int size() {
        return this.encodedNames.size();
    }

    public String encodedName(int i) {
        return this.encodedNames.get(i);
    }

    public String name(int i) {
        return HttpUrl.percentDecode(encodedName(i), true);
    }

    public String encodedValue(int i) {
        return this.encodedValues.get(i);
    }

    public String value(int i) {
        return HttpUrl.percentDecode(encodedValue(i), true);
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return writeOrCountBytes(null, true);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(d dVar) throws IOException {
        writeOrCountBytes(dVar, false);
    }

    private long writeOrCountBytes(d dVar, boolean z) {
        c b2;
        long j = 0;
        if (z) {
            b2 = new c();
        } else {
            b2 = dVar.b();
        }
        int size = this.encodedNames.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                b2.i(38);
            }
            b2.b(this.encodedNames.get(i));
            b2.i(61);
            b2.b(this.encodedValues.get(i));
        }
        if (z) {
            j = b2.a();
            b2.v();
        }
        return j;
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private final List<String> names = new ArrayList();
        private final List<String> values = new ArrayList();

        public Builder add(String str, String str2) {
            this.names.add(HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            this.values.add(HttpUrl.canonicalize(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            return this;
        }

        public Builder addEncoded(String str, String str2) {
            this.names.add(HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            this.values.add(HttpUrl.canonicalize(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            return this;
        }

        public FormBody build() {
            return new FormBody(this.names, this.values);
        }
    }
}

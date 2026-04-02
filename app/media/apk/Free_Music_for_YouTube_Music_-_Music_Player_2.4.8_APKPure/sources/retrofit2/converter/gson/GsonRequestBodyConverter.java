package retrofit2.converter.gson;

import c.c;
import com.google.android.exoplayer2.C;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;
/* loaded from: classes2.dex */
final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName(C.UTF8_NAME);
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // retrofit2.Converter
    public /* bridge */ /* synthetic */ RequestBody convert(Object obj) throws IOException {
        return convert2((GsonRequestBodyConverter<T>) obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GsonRequestBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.gson = gson;
        this.adapter = typeAdapter;
    }

    @Override // retrofit2.Converter
    /* renamed from: convert  reason: avoid collision after fix types in other method */
    public RequestBody convert2(T t) throws IOException {
        c cVar = new c();
        JsonWriter newJsonWriter = this.gson.newJsonWriter(new OutputStreamWriter(cVar.c(), UTF_8));
        this.adapter.write(newJsonWriter, t);
        newJsonWriter.close();
        return RequestBody.create(MEDIA_TYPE, cVar.q());
    }
}

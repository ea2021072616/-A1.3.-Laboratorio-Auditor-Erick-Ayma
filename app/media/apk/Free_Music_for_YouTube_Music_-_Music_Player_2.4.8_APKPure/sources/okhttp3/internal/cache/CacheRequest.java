package okhttp3.internal.cache;

import c.r;
import java.io.IOException;
/* loaded from: classes2.dex */
public interface CacheRequest {
    void abort();

    r body() throws IOException;
}

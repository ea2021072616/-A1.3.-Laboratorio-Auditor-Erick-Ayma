package com.google.android.exoplayer2.upstream;

import java.io.IOException;
/* loaded from: classes.dex */
public interface LoaderErrorThrower {
    void maybeThrowError() throws IOException;

    void maybeThrowError(int i) throws IOException;
}

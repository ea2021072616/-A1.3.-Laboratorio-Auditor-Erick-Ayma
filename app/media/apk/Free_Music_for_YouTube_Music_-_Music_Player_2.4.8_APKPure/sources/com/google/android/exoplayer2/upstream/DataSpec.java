package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class DataSpec {
    public static final int FLAG_ALLOW_GZIP = 1;
    public final long absoluteStreamPosition;
    public final int flags;
    public final String key;
    public final long length;
    public final long position;
    public final byte[] postBody;
    public final Uri uri;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Flags {
    }

    public DataSpec(Uri uri) {
        this(uri, 0);
    }

    public DataSpec(Uri uri, int i) {
        this(uri, 0L, -1L, null, i);
    }

    public DataSpec(Uri uri, long j, long j2, String str) {
        this(uri, j, j, j2, str, 0);
    }

    public DataSpec(Uri uri, long j, long j2, String str, int i) {
        this(uri, j, j, j2, str, i);
    }

    public DataSpec(Uri uri, long j, long j2, long j3, String str, int i) {
        this(uri, null, j, j2, j3, str, i);
    }

    public DataSpec(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        Assertions.checkArgument(j >= 0);
        Assertions.checkArgument(j2 >= 0);
        Assertions.checkArgument(j3 > 0 || j3 == -1);
        this.uri = uri;
        this.postBody = bArr;
        this.absoluteStreamPosition = j;
        this.position = j2;
        this.length = j3;
        this.key = str;
        this.flags = i;
    }

    public String toString() {
        return "DataSpec[" + this.uri + ", " + Arrays.toString(this.postBody) + ", " + this.absoluteStreamPosition + ", " + this.position + ", " + this.length + ", " + this.key + ", " + this.flags + "]";
    }
}

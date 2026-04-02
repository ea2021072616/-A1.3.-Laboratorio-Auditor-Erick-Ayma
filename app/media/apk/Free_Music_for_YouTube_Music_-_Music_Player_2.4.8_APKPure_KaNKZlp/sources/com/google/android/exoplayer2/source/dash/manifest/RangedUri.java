package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.UriUtil;
/* loaded from: classes.dex */
public final class RangedUri {
    private final String baseUri;
    private int hashCode;
    public final long length;
    private final String referenceUri;
    public final long start;

    public RangedUri(String str, String str2, long j, long j2) {
        Assertions.checkArgument((str == null && str2 == null) ? false : true);
        this.baseUri = str;
        this.referenceUri = str2;
        this.start = j;
        this.length = j2;
    }

    public Uri getUri() {
        return UriUtil.resolveToUri(this.baseUri, this.referenceUri);
    }

    public String getUriString() {
        return UriUtil.resolve(this.baseUri, this.referenceUri);
    }

    public RangedUri attemptMerge(RangedUri rangedUri) {
        RangedUri rangedUri2 = null;
        if (rangedUri != null && getUriString().equals(rangedUri.getUriString())) {
            if (this.length != -1 && this.start + this.length == rangedUri.start) {
                rangedUri2 = new RangedUri(this.baseUri, this.referenceUri, this.start, rangedUri.length != -1 ? this.length + rangedUri.length : -1L);
            } else if (rangedUri.length != -1 && rangedUri.start + rangedUri.length == this.start) {
                rangedUri2 = new RangedUri(this.baseUri, this.referenceUri, rangedUri.start, this.length != -1 ? rangedUri.length + this.length : -1L);
            }
        }
        return rangedUri2;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = ((((((int) this.start) + 527) * 31) + ((int) this.length)) * 31) + getUriString().hashCode();
        }
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RangedUri rangedUri = (RangedUri) obj;
        return this.start == rangedUri.start && this.length == rangedUri.length && getUriString().equals(rangedUri.getUriString());
    }
}

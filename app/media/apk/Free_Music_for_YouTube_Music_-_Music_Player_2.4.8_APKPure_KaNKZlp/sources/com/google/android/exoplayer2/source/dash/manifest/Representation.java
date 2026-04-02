package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;
/* loaded from: classes.dex */
public abstract class Representation {
    public static final long REVISION_ID_DEFAULT = -1;
    private final String cacheKey;
    public final String contentId;
    public final Format format;
    private final RangedUri initializationUri;
    public final long presentationTimeOffsetUs;
    public final long revisionId;

    public abstract DashSegmentIndex getIndex();

    public abstract RangedUri getIndexUri();

    public static Representation newInstance(String str, long j, Format format, SegmentBase segmentBase) {
        return newInstance(str, j, format, segmentBase, null);
    }

    public static Representation newInstance(String str, long j, Format format, SegmentBase segmentBase, String str2) {
        if (segmentBase instanceof SegmentBase.SingleSegmentBase) {
            return new SingleSegmentRepresentation(str, j, format, (SegmentBase.SingleSegmentBase) segmentBase, str2, -1L);
        }
        if (segmentBase instanceof SegmentBase.MultiSegmentBase) {
            return new MultiSegmentRepresentation(str, j, format, (SegmentBase.MultiSegmentBase) segmentBase, str2);
        }
        throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
    }

    private Representation(String str, long j, Format format, SegmentBase segmentBase, String str2) {
        this.contentId = str;
        this.revisionId = j;
        this.format = format;
        this.cacheKey = str2 == null ? str + "." + format.id + "." + j : str2;
        this.initializationUri = segmentBase.getInitialization(this);
        this.presentationTimeOffsetUs = segmentBase.getPresentationTimeOffsetUs();
    }

    public RangedUri getInitializationUri() {
        return this.initializationUri;
    }

    public String getCacheKey() {
        return this.cacheKey;
    }

    /* loaded from: classes.dex */
    public static class SingleSegmentRepresentation extends Representation {
        public final long contentLength;
        private final RangedUri indexUri;
        private final SingleSegmentIndex segmentIndex;
        public final Uri uri;

        public static SingleSegmentRepresentation newInstance(String str, long j, Format format, String str2, long j2, long j3, long j4, long j5, String str3, long j6) {
            return new SingleSegmentRepresentation(str, j, format, new SegmentBase.SingleSegmentBase(new RangedUri(str2, null, j2, 1 + (j3 - j2)), 1L, 0L, str2, j4, (j5 - j4) + 1), str3, j6);
        }

        public SingleSegmentRepresentation(String str, long j, Format format, SegmentBase.SingleSegmentBase singleSegmentBase, String str2, long j2) {
            super(str, j, format, singleSegmentBase, str2);
            this.uri = Uri.parse(singleSegmentBase.uri);
            this.indexUri = singleSegmentBase.getIndex();
            this.contentLength = j2;
            this.segmentIndex = this.indexUri != null ? null : new SingleSegmentIndex(new RangedUri(singleSegmentBase.uri, null, 0L, j2));
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        public RangedUri getIndexUri() {
            return this.indexUri;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        public DashSegmentIndex getIndex() {
            return this.segmentIndex;
        }
    }

    /* loaded from: classes.dex */
    public static class MultiSegmentRepresentation extends Representation implements DashSegmentIndex {
        private final SegmentBase.MultiSegmentBase segmentBase;

        public MultiSegmentRepresentation(String str, long j, Format format, SegmentBase.MultiSegmentBase multiSegmentBase, String str2) {
            super(str, j, format, multiSegmentBase, str2);
            this.segmentBase = multiSegmentBase;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        public RangedUri getIndexUri() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        public DashSegmentIndex getIndex() {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public RangedUri getSegmentUrl(int i) {
            return this.segmentBase.getSegmentUrl(this, i);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public int getSegmentNum(long j, long j2) {
            return this.segmentBase.getSegmentNum(j, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getTimeUs(int i) {
            return this.segmentBase.getSegmentTimeUs(i);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getDurationUs(int i, long j) {
            return this.segmentBase.getSegmentDurationUs(i, j);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public int getFirstSegmentNum() {
            return this.segmentBase.getFirstSegmentNum();
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public int getLastSegmentNum(long j) {
            return this.segmentBase.getLastSegmentNum(j);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public boolean isExplicit() {
            return this.segmentBase.isExplicit();
        }
    }
}

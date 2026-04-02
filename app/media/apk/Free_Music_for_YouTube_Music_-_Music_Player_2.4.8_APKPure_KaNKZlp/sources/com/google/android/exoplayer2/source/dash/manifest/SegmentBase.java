package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
/* loaded from: classes.dex */
public abstract class SegmentBase {
    final RangedUri initialization;
    final long presentationTimeOffset;
    final long timescale;

    public SegmentBase(RangedUri rangedUri, long j, long j2) {
        this.initialization = rangedUri;
        this.timescale = j;
        this.presentationTimeOffset = j2;
    }

    public RangedUri getInitialization(Representation representation) {
        return this.initialization;
    }

    public long getPresentationTimeOffsetUs() {
        return Util.scaleLargeTimestamp(this.presentationTimeOffset, C.MICROS_PER_SECOND, this.timescale);
    }

    /* loaded from: classes.dex */
    public static class SingleSegmentBase extends SegmentBase {
        final long indexLength;
        final long indexStart;
        public final String uri;

        public SingleSegmentBase(RangedUri rangedUri, long j, long j2, String str, long j3, long j4) {
            super(rangedUri, j, j2);
            this.uri = str;
            this.indexStart = j3;
            this.indexLength = j4;
        }

        public SingleSegmentBase(String str) {
            this(null, 1L, 0L, str, 0L, 0L);
        }

        public RangedUri getIndex() {
            if (this.indexLength <= 0) {
                return null;
            }
            return new RangedUri(this.uri, null, this.indexStart, this.indexLength);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class MultiSegmentBase extends SegmentBase {
        final long duration;
        final List<SegmentTimelineElement> segmentTimeline;
        final int startNumber;

        public abstract int getLastSegmentNum(long j);

        public abstract RangedUri getSegmentUrl(Representation representation, int i);

        public MultiSegmentBase(RangedUri rangedUri, long j, long j2, int i, long j3, List<SegmentTimelineElement> list) {
            super(rangedUri, j, j2);
            this.startNumber = i;
            this.duration = j3;
            this.segmentTimeline = list;
        }

        public int getSegmentNum(long j, long j2) {
            int firstSegmentNum = getFirstSegmentNum();
            int lastSegmentNum = getLastSegmentNum(j2);
            if (this.segmentTimeline == null) {
                int i = ((int) (j / ((this.duration * C.MICROS_PER_SECOND) / this.timescale))) + this.startNumber;
                if (i < firstSegmentNum) {
                    return firstSegmentNum;
                }
                return (lastSegmentNum == -1 || i <= lastSegmentNum) ? i : lastSegmentNum;
            }
            int i2 = firstSegmentNum;
            while (i2 <= lastSegmentNum) {
                int i3 = (i2 + lastSegmentNum) / 2;
                long segmentTimeUs = getSegmentTimeUs(i3);
                if (segmentTimeUs < j) {
                    i2 = i3 + 1;
                } else if (segmentTimeUs <= j) {
                    return i3;
                } else {
                    lastSegmentNum = i3 - 1;
                }
            }
            if (i2 != firstSegmentNum) {
                i2 = lastSegmentNum;
            }
            return i2;
        }

        public final long getSegmentDurationUs(int i, long j) {
            if (this.segmentTimeline != null) {
                return (this.segmentTimeline.get(i - this.startNumber).duration * C.MICROS_PER_SECOND) / this.timescale;
            }
            return i == getLastSegmentNum(j) ? j - getSegmentTimeUs(i) : (this.duration * C.MICROS_PER_SECOND) / this.timescale;
        }

        public final long getSegmentTimeUs(int i) {
            long j;
            if (this.segmentTimeline != null) {
                j = this.segmentTimeline.get(i - this.startNumber).startTime - this.presentationTimeOffset;
            } else {
                j = (i - this.startNumber) * this.duration;
            }
            return Util.scaleLargeTimestamp(j, C.MICROS_PER_SECOND, this.timescale);
        }

        public int getFirstSegmentNum() {
            return this.startNumber;
        }

        public boolean isExplicit() {
            return this.segmentTimeline != null;
        }
    }

    /* loaded from: classes.dex */
    public static class SegmentList extends MultiSegmentBase {
        final List<RangedUri> mediaSegments;

        public SegmentList(RangedUri rangedUri, long j, long j2, int i, long j3, List<SegmentTimelineElement> list, List<RangedUri> list2) {
            super(rangedUri, j, j2, i, j3, list);
            this.mediaSegments = list2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public RangedUri getSegmentUrl(Representation representation, int i) {
            return this.mediaSegments.get(i - this.startNumber);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public int getLastSegmentNum(long j) {
            return (this.startNumber + this.mediaSegments.size()) - 1;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public boolean isExplicit() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class SegmentTemplate extends MultiSegmentBase {
        private final String baseUrl;
        final UrlTemplate initializationTemplate;
        final UrlTemplate mediaTemplate;

        public SegmentTemplate(RangedUri rangedUri, long j, long j2, int i, long j3, List<SegmentTimelineElement> list, UrlTemplate urlTemplate, UrlTemplate urlTemplate2, String str) {
            super(rangedUri, j, j2, i, j3, list);
            this.initializationTemplate = urlTemplate;
            this.mediaTemplate = urlTemplate2;
            this.baseUrl = str;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase
        public RangedUri getInitialization(Representation representation) {
            if (this.initializationTemplate != null) {
                return new RangedUri(this.baseUrl, this.initializationTemplate.buildUri(representation.format.id, 0, representation.format.bitrate, 0L), 0L, -1L);
            }
            return super.getInitialization(representation);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public RangedUri getSegmentUrl(Representation representation, int i) {
            long j;
            if (this.segmentTimeline != null) {
                j = this.segmentTimeline.get(i - this.startNumber).startTime;
            } else {
                j = (i - this.startNumber) * this.duration;
            }
            return new RangedUri(this.baseUrl, this.mediaTemplate.buildUri(representation.format.id, i, representation.format.bitrate, j), 0L, -1L);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public int getLastSegmentNum(long j) {
            if (this.segmentTimeline != null) {
                return (this.segmentTimeline.size() + this.startNumber) - 1;
            }
            if (j == C.TIME_UNSET) {
                return -1;
            }
            long j2 = (this.duration * C.MICROS_PER_SECOND) / this.timescale;
            return (((int) Util.ceilDivide(j, j2)) + this.startNumber) - 1;
        }
    }

    /* loaded from: classes.dex */
    public static class SegmentTimelineElement {
        final long duration;
        final long startTime;

        public SegmentTimelineElement(long j, long j2) {
            this.startTime = j;
            this.duration = j2;
        }
    }
}

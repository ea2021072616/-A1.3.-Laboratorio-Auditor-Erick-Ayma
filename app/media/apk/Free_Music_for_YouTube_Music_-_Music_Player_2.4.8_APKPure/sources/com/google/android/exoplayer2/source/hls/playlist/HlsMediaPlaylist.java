package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.C;
import java.util.List;
/* loaded from: classes.dex */
public final class HlsMediaPlaylist extends HlsPlaylist {
    public static final String ENCRYPTION_METHOD_AES_128 = "AES-128";
    public static final String ENCRYPTION_METHOD_NONE = "NONE";
    public final long durationUs;
    public final Segment initializationSegment;
    public final boolean live;
    public final int mediaSequence;
    public final List<Segment> segments;
    public final int targetDurationSecs;
    public final int version;

    /* loaded from: classes.dex */
    public static final class Segment implements Comparable<Long> {
        public final long byterangeLength;
        public final long byterangeOffset;
        public final int discontinuitySequenceNumber;
        public final double durationSecs;
        public final String encryptionIV;
        public final String encryptionKeyUri;
        public final boolean isEncrypted;
        public final long startTimeUs;
        public final String url;

        public Segment(String str, long j, long j2) {
            this(str, 0.0d, -1, C.TIME_UNSET, false, null, null, j, j2);
        }

        public Segment(String str, double d, int i, long j, boolean z, String str2, String str3, long j2, long j3) {
            this.url = str;
            this.durationSecs = d;
            this.discontinuitySequenceNumber = i;
            this.startTimeUs = j;
            this.isEncrypted = z;
            this.encryptionKeyUri = str2;
            this.encryptionIV = str3;
            this.byterangeOffset = j2;
            this.byterangeLength = j3;
        }

        @Override // java.lang.Comparable
        public int compareTo(Long l) {
            if (this.startTimeUs > l.longValue()) {
                return 1;
            }
            return this.startTimeUs < l.longValue() ? -1 : 0;
        }
    }

    public HlsMediaPlaylist(String str, int i, int i2, int i3, boolean z, Segment segment, List<Segment> list) {
        super(str, 1);
        this.mediaSequence = i;
        this.targetDurationSecs = i2;
        this.version = i3;
        this.live = z;
        this.initializationSegment = segment;
        this.segments = list;
        if (!list.isEmpty()) {
            Segment segment2 = list.get(list.size() - 1);
            this.durationUs = ((long) (segment2.durationSecs * 1000000.0d)) + segment2.startTimeUs;
            return;
        }
        this.durationUs = 0L;
    }
}

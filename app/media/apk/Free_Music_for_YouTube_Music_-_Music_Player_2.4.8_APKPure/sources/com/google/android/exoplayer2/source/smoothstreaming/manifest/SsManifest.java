package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
import java.util.UUID;
/* loaded from: classes.dex */
public class SsManifest {
    public static final int UNSET_LOOKAHEAD = -1;
    public final long durationUs;
    public final long dvrWindowLengthUs;
    public final boolean isLive;
    public final int lookAheadCount;
    public final int majorVersion;
    public final int minorVersion;
    public final ProtectionElement protectionElement;
    public final StreamElement[] streamElements;

    public SsManifest(int i, int i2, long j, long j2, long j3, int i3, boolean z, ProtectionElement protectionElement, StreamElement[] streamElementArr) {
        this.majorVersion = i;
        this.minorVersion = i2;
        this.lookAheadCount = i3;
        this.isLive = z;
        this.protectionElement = protectionElement;
        this.streamElements = streamElementArr;
        this.dvrWindowLengthUs = j3 == 0 ? C.TIME_UNSET : Util.scaleLargeTimestamp(j3, C.MICROS_PER_SECOND, j);
        this.durationUs = j2 == 0 ? C.TIME_UNSET : Util.scaleLargeTimestamp(j2, C.MICROS_PER_SECOND, j);
    }

    /* loaded from: classes.dex */
    public static class ProtectionElement {
        public final byte[] data;
        public final UUID uuid;

        public ProtectionElement(UUID uuid, byte[] bArr) {
            this.uuid = uuid;
            this.data = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class StreamElement {
        private static final String URL_PLACEHOLDER_BITRATE = "{bitrate}";
        private static final String URL_PLACEHOLDER_START_TIME = "{start time}";
        private final String baseUri;
        public final int chunkCount;
        private final List<Long> chunkStartTimes;
        private final long[] chunkStartTimesUs;
        private final String chunkTemplate;
        public final int displayHeight;
        public final int displayWidth;
        public final Format[] formats;
        public final String language;
        private final long lastChunkDurationUs;
        public final int maxHeight;
        public final int maxWidth;
        public final String name;
        public final String subType;
        public final long timescale;
        public final int type;

        public StreamElement(String str, String str2, int i, String str3, long j, String str4, int i2, int i3, int i4, int i5, String str5, Format[] formatArr, List<Long> list, long j2) {
            this.baseUri = str;
            this.chunkTemplate = str2;
            this.type = i;
            this.subType = str3;
            this.timescale = j;
            this.name = str4;
            this.maxWidth = i2;
            this.maxHeight = i3;
            this.displayWidth = i4;
            this.displayHeight = i5;
            this.language = str5;
            this.formats = formatArr;
            this.chunkCount = list.size();
            this.chunkStartTimes = list;
            this.lastChunkDurationUs = Util.scaleLargeTimestamp(j2, C.MICROS_PER_SECOND, j);
            this.chunkStartTimesUs = Util.scaleLargeTimestamps(list, C.MICROS_PER_SECOND, j);
        }

        public int getChunkIndex(long j) {
            return Util.binarySearchFloor(this.chunkStartTimesUs, j, true, true);
        }

        public long getStartTimeUs(int i) {
            return this.chunkStartTimesUs[i];
        }

        public long getChunkDurationUs(int i) {
            return i == this.chunkCount + (-1) ? this.lastChunkDurationUs : this.chunkStartTimesUs[i + 1] - this.chunkStartTimesUs[i];
        }

        public Uri buildRequestUri(int i, int i2) {
            Assertions.checkState(this.formats != null);
            Assertions.checkState(this.chunkStartTimes != null);
            Assertions.checkState(i2 < this.chunkStartTimes.size());
            return UriUtil.resolveToUri(this.baseUri, this.chunkTemplate.replace(URL_PLACEHOLDER_BITRATE, Integer.toString(this.formats[i].bitrate)).replace(URL_PLACEHOLDER_START_TIME, this.chunkStartTimes.get(i2).toString()));
        }
    }
}

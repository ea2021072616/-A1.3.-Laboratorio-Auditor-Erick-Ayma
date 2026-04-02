package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
/* loaded from: classes.dex */
final class XingSeeker implements Mp3Extractor.Seeker {
    private final long durationUs;
    private final long firstFramePosition;
    private final int headerSize;
    private final long inputLength;
    private final long sizeBytes;
    private final long[] tableOfContents;

    public static XingSeeker create(MpegAudioHeader mpegAudioHeader, ParsableByteArray parsableByteArray, long j, long j2) {
        int readUnsignedIntToInt;
        int i = mpegAudioHeader.samplesPerFrame;
        int i2 = mpegAudioHeader.sampleRate;
        long j3 = j + mpegAudioHeader.frameSize;
        int readInt = parsableByteArray.readInt();
        if ((readInt & 1) != 1 || (readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt()) == 0) {
            return null;
        }
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(readUnsignedIntToInt, i * C.MICROS_PER_SECOND, i2);
        if ((readInt & 6) != 6) {
            return new XingSeeker(j3, scaleLargeTimestamp, j2);
        }
        long readUnsignedIntToInt2 = parsableByteArray.readUnsignedIntToInt();
        parsableByteArray.skipBytes(1);
        long[] jArr = new long[99];
        for (int i3 = 0; i3 < 99; i3++) {
            jArr[i3] = parsableByteArray.readUnsignedByte();
        }
        return new XingSeeker(j3, scaleLargeTimestamp, j2, jArr, readUnsignedIntToInt2, mpegAudioHeader.frameSize);
    }

    private XingSeeker(long j, long j2, long j3) {
        this(j, j2, j3, null, 0L, 0);
    }

    private XingSeeker(long j, long j2, long j3, long[] jArr, long j4, int i) {
        this.firstFramePosition = j;
        this.durationUs = j2;
        this.inputLength = j3;
        this.tableOfContents = jArr;
        this.sizeBytes = j4;
        this.headerSize = i;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return this.tableOfContents != null;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getPosition(long j) {
        if (!isSeekable()) {
            return this.firstFramePosition;
        }
        float f = (((float) j) * 100.0f) / ((float) this.durationUs);
        if (f <= 0.0f) {
            r0 = 0.0f;
        } else if (f < 100.0f) {
            int i = (int) f;
            float f2 = i != 0 ? (float) this.tableOfContents[i - 1] : 0.0f;
            r0 = (((i < 99 ? (float) this.tableOfContents[i] : 256.0f) - f2) * (f - i)) + f2;
        }
        return Math.min(this.firstFramePosition + Math.round(r0 * 0.00390625d * this.sizeBytes), this.inputLength != -1 ? this.inputLength - 1 : ((this.firstFramePosition - this.headerSize) + this.sizeBytes) - 1);
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getTimeUs(long j) {
        if (!isSeekable() || j < this.firstFramePosition) {
            return 0L;
        }
        double d = (256.0d * (j - this.firstFramePosition)) / this.sizeBytes;
        int binarySearchFloor = Util.binarySearchFloor(this.tableOfContents, (long) d, true, false) + 1;
        long timeUsForTocPosition = getTimeUsForTocPosition(binarySearchFloor);
        long j2 = binarySearchFloor == 0 ? 0L : this.tableOfContents[binarySearchFloor - 1];
        long j3 = binarySearchFloor == 99 ? 256L : this.tableOfContents[binarySearchFloor];
        return timeUsForTocPosition + (j3 == j2 ? 0L : (long) (((getTimeUsForTocPosition(binarySearchFloor + 1) - timeUsForTocPosition) * (d - j2)) / (j3 - j2)));
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    private long getTimeUsForTocPosition(int i) {
        return (this.durationUs * i) / 100;
    }
}

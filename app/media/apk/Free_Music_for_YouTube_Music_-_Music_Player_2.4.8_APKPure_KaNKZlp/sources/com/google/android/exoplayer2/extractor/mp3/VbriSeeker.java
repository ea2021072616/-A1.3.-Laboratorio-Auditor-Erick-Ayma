package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
/* loaded from: classes.dex */
final class VbriSeeker implements Mp3Extractor.Seeker {
    private final long durationUs;
    private final long[] positions;
    private final long[] timesUs;

    public static VbriSeeker create(MpegAudioHeader mpegAudioHeader, ParsableByteArray parsableByteArray, long j, long j2) {
        int readUnsignedIntToInt;
        parsableByteArray.skipBytes(10);
        int readInt = parsableByteArray.readInt();
        if (readInt <= 0) {
            return null;
        }
        int i = mpegAudioHeader.sampleRate;
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(readInt, (i >= 32000 ? 1152 : 576) * C.MICROS_PER_SECOND, i);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
        int readUnsignedShort3 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(2);
        long j3 = j + mpegAudioHeader.frameSize;
        long[] jArr = new long[readUnsignedShort + 1];
        long[] jArr2 = new long[readUnsignedShort + 1];
        jArr[0] = 0;
        jArr2[0] = j3;
        for (int i2 = 1; i2 < jArr.length; i2++) {
            switch (readUnsignedShort3) {
                case 1:
                    readUnsignedIntToInt = parsableByteArray.readUnsignedByte();
                    break;
                case 2:
                    readUnsignedIntToInt = parsableByteArray.readUnsignedShort();
                    break;
                case 3:
                    readUnsignedIntToInt = parsableByteArray.readUnsignedInt24();
                    break;
                case 4:
                    readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
                    break;
                default:
                    return null;
            }
            j3 += readUnsignedIntToInt * readUnsignedShort2;
            jArr[i2] = (i2 * scaleLargeTimestamp) / readUnsignedShort;
            jArr2[i2] = j2 == -1 ? j3 : Math.min(j2, j3);
        }
        return new VbriSeeker(jArr, jArr2, scaleLargeTimestamp);
    }

    private VbriSeeker(long[] jArr, long[] jArr2, long j) {
        this.timesUs = jArr;
        this.positions = jArr2;
        this.durationUs = j;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getPosition(long j) {
        return this.positions[Util.binarySearchFloor(this.timesUs, j, true, true)];
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getTimeUs(long j) {
        return this.timesUs[Util.binarySearchFloor(this.positions, j, true, true)];
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }
}

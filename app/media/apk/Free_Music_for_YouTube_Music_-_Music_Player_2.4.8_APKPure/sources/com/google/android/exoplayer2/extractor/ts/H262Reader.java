package com.google.android.exoplayer2.extractor.ts;

import android.util.Pair;
import com.flurry.android.Constants;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: classes.dex */
final class H262Reader extends ElementaryStreamReader {
    private static final double[] FRAME_RATE_VALUES = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private static final int START_EXTENSION = 181;
    private static final int START_GROUP = 184;
    private static final int START_PICTURE = 0;
    private static final int START_SEQUENCE_HEADER = 179;
    private boolean foundFirstFrameInGroup;
    private long frameDurationUs;
    private long framePosition;
    private long frameTimeUs;
    private boolean hasOutputFormat;
    private boolean isKeyframe;
    private TrackOutput output;
    private boolean pesPtsUsAvailable;
    private long pesTimeUs;
    private long totalBytesWritten;
    private final boolean[] prefixFlags = new boolean[4];
    private final CsdBuffer csdBuffer = new CsdBuffer(128);

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.csdBuffer.reset();
        this.pesPtsUsAvailable = false;
        this.foundFirstFrameInGroup = false;
        this.totalBytesWritten = 0L;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void init(ExtractorOutput extractorOutput, ElementaryStreamReader.TrackIdGenerator trackIdGenerator) {
        this.output = extractorOutput.track(trackIdGenerator.getNextId());
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, boolean z) {
        this.pesPtsUsAvailable = j != C.TIME_UNSET;
        if (this.pesPtsUsAvailable) {
            this.pesTimeUs = j;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        byte[] bArr = parsableByteArray.data;
        this.totalBytesWritten += parsableByteArray.bytesLeft();
        this.output.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
        int i = position;
        while (true) {
            int findNalUnit = NalUnitUtil.findNalUnit(bArr, position, limit, this.prefixFlags);
            if (findNalUnit == limit) {
                break;
            }
            int i2 = parsableByteArray.data[findNalUnit + 3] & Constants.UNKNOWN;
            if (!this.hasOutputFormat) {
                int i3 = findNalUnit - i;
                if (i3 > 0) {
                    this.csdBuffer.onData(bArr, i, findNalUnit);
                }
                if (this.csdBuffer.onStartCode(i2, i3 < 0 ? -i3 : 0)) {
                    Pair<Format, Long> parseCsdBuffer = parseCsdBuffer(this.csdBuffer);
                    this.output.format((Format) parseCsdBuffer.first);
                    this.frameDurationUs = ((Long) parseCsdBuffer.second).longValue();
                    this.hasOutputFormat = true;
                }
            }
            if (this.hasOutputFormat && (i2 == START_GROUP || i2 == 0)) {
                int i4 = limit - findNalUnit;
                if (this.foundFirstFrameInGroup) {
                    this.output.sampleMetadata(this.frameTimeUs, this.isKeyframe ? 1 : 0, ((int) (this.totalBytesWritten - this.framePosition)) - i4, i4, null);
                    this.isKeyframe = false;
                }
                if (i2 == START_GROUP) {
                    this.foundFirstFrameInGroup = false;
                    this.isKeyframe = true;
                } else {
                    this.frameTimeUs = this.pesPtsUsAvailable ? this.pesTimeUs : this.frameTimeUs + this.frameDurationUs;
                    this.framePosition = this.totalBytesWritten - i4;
                    this.pesPtsUsAvailable = false;
                    this.foundFirstFrameInGroup = true;
                }
            }
            position = findNalUnit + 3;
            i = findNalUnit;
        }
        if (!this.hasOutputFormat) {
            this.csdBuffer.onData(bArr, i, limit);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    private static Pair<Format, Long> parseCsdBuffer(CsdBuffer csdBuffer) {
        int i;
        byte[] copyOf = Arrays.copyOf(csdBuffer.data, csdBuffer.length);
        int i2 = copyOf[4] & Constants.UNKNOWN;
        int i3 = copyOf[5] & Constants.UNKNOWN;
        int i4 = (i3 >> 4) | (i2 << 4);
        int i5 = ((i3 & 15) << 8) | (copyOf[6] & Constants.UNKNOWN);
        float f = 1.0f;
        switch ((copyOf[7] & 240) >> 4) {
            case 2:
                f = (i5 * 4) / (i4 * 3);
                break;
            case 3:
                f = (i5 * 16) / (i4 * 9);
                break;
            case 4:
                f = (i5 * 121) / (i4 * 100);
                break;
        }
        Format createVideoSampleFormat = Format.createVideoSampleFormat(null, MimeTypes.VIDEO_MPEG2, null, -1, -1, i4, i5, -1.0f, Collections.singletonList(copyOf), -1, f, null);
        long j = 0;
        int i6 = (copyOf[7] & 15) - 1;
        if (i6 >= 0 && i6 < FRAME_RATE_VALUES.length) {
            double d = FRAME_RATE_VALUES[i6];
            int i7 = csdBuffer.sequenceExtensionPosition;
            int i8 = (copyOf[i7 + 9] & 96) >> 5;
            if (i8 != (copyOf[i7 + 9] & 31)) {
                d *= (i8 + 1.0d) / (i + 1);
            }
            j = (long) (1000000.0d / d);
        }
        return Pair.create(createVideoSampleFormat, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class CsdBuffer {
        public byte[] data;
        private boolean isFilling;
        public int length;
        public int sequenceExtensionPosition;

        public CsdBuffer(int i) {
            this.data = new byte[i];
        }

        public void reset() {
            this.isFilling = false;
            this.length = 0;
            this.sequenceExtensionPosition = 0;
        }

        public boolean onStartCode(int i, int i2) {
            if (this.isFilling) {
                if (this.sequenceExtensionPosition == 0 && i == H262Reader.START_EXTENSION) {
                    this.sequenceExtensionPosition = this.length;
                } else {
                    this.length -= i2;
                    this.isFilling = false;
                    return true;
                }
            } else if (i == H262Reader.START_SEQUENCE_HEADER) {
                this.isFilling = true;
            }
            return false;
        }

        public void onData(byte[] bArr, int i, int i2) {
            if (this.isFilling) {
                int i3 = i2 - i;
                if (this.data.length < this.length + i3) {
                    this.data = Arrays.copyOf(this.data, (this.length + i3) * 2);
                }
                System.arraycopy(bArr, i, this.data, this.length, i3);
                this.length = i3 + this.length;
            }
        }
    }
}

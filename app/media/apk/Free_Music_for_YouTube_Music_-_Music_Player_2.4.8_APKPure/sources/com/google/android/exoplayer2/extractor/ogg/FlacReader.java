package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.util.FlacStreamInfo;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class FlacReader extends StreamReader {
    private static final byte AUDIO_PACKET_TYPE = -1;
    private static final int FRAME_HEADER_SAMPLE_NUMBER_OFFSET = 4;
    private static final byte SEEKTABLE_PACKET_TYPE = 3;
    private FlacOggSeeker flacOggSeeker;
    private FlacStreamInfo streamInfo;

    public static boolean verifyBitstreamType(ParsableByteArray parsableByteArray) {
        return parsableByteArray.bytesLeft() >= 5 && parsableByteArray.readUnsignedByte() == 127 && parsableByteArray.readUnsignedInt() == 1179402563;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void reset(boolean z) {
        super.reset(z);
        if (z) {
            this.streamInfo = null;
            this.flacOggSeeker = null;
        }
    }

    private static boolean isAudioPacket(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected long preparePayload(ParsableByteArray parsableByteArray) {
        if (isAudioPacket(parsableByteArray.data)) {
            return getFlacFrameBlockSize(parsableByteArray);
        }
        return -1L;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected boolean readHeaders(ParsableByteArray parsableByteArray, long j, StreamReader.SetupData setupData) throws IOException, InterruptedException {
        byte[] bArr = parsableByteArray.data;
        if (this.streamInfo == null) {
            this.streamInfo = new FlacStreamInfo(bArr, 17);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 9, parsableByteArray.limit());
            copyOfRange[4] = Byte.MIN_VALUE;
            setupData.format = Format.createAudioSampleFormat(null, MimeTypes.AUDIO_FLAC, null, -1, this.streamInfo.bitRate(), this.streamInfo.channels, this.streamInfo.sampleRate, Collections.singletonList(copyOfRange), null, 0, null);
        } else if ((bArr[0] & Byte.MAX_VALUE) == 3) {
            this.flacOggSeeker = new FlacOggSeeker();
            this.flacOggSeeker.parseSeekTable(parsableByteArray);
        } else if (isAudioPacket(bArr)) {
            if (this.flacOggSeeker != null) {
                this.flacOggSeeker.setFirstFrameOffset(j);
                setupData.oggSeeker = this.flacOggSeeker;
                return false;
            }
            return false;
        }
        return true;
    }

    private int getFlacFrameBlockSize(ParsableByteArray parsableByteArray) {
        int i = (parsableByteArray.data[2] & 255) >> 4;
        switch (i) {
            case 1:
                return PsExtractor.AUDIO_STREAM;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
            case 7:
                parsableByteArray.skipBytes(4);
                parsableByteArray.readUtf8EncodedLong();
                int readUnsignedByte = i == 6 ? parsableByteArray.readUnsignedByte() : parsableByteArray.readUnsignedShort();
                parsableByteArray.setPosition(0);
                return readUnsignedByte + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }

    /* loaded from: classes.dex */
    private class FlacOggSeeker implements SeekMap, OggSeeker {
        private static final int METADATA_LENGTH_OFFSET = 1;
        private static final int SEEK_POINT_SIZE = 18;
        private long currentGranule;
        private long firstFrameOffset;
        private long[] offsets;
        private volatile long queriedGranule;
        private long[] sampleNumbers;
        private volatile long seekedGranule;

        private FlacOggSeeker() {
            this.firstFrameOffset = -1L;
            this.currentGranule = -1L;
        }

        public void setFirstFrameOffset(long j) {
            this.firstFrameOffset = j;
        }

        public void parseSeekTable(ParsableByteArray parsableByteArray) {
            parsableByteArray.skipBytes(1);
            int readUnsignedInt24 = parsableByteArray.readUnsignedInt24() / 18;
            this.sampleNumbers = new long[readUnsignedInt24];
            this.offsets = new long[readUnsignedInt24];
            for (int i = 0; i < readUnsignedInt24; i++) {
                this.sampleNumbers[i] = parsableByteArray.readLong();
                this.offsets[i] = parsableByteArray.readLong();
                parsableByteArray.skipBytes(2);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public long read(ExtractorInput extractorInput) throws IOException, InterruptedException {
            if (this.currentGranule >= 0) {
                this.currentGranule = (-this.currentGranule) - 2;
                return this.currentGranule;
            }
            return -1L;
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public synchronized long startSeek() {
            this.currentGranule = this.seekedGranule;
            return this.queriedGranule;
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public SeekMap createSeekMap() {
            return this;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return true;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public synchronized long getPosition(long j) {
            int binarySearchFloor;
            this.queriedGranule = FlacReader.this.convertTimeToGranule(j);
            binarySearchFloor = Util.binarySearchFloor(this.sampleNumbers, this.queriedGranule, true, true);
            this.seekedGranule = this.sampleNumbers[binarySearchFloor];
            return this.offsets[binarySearchFloor] + this.firstFrameOffset;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return FlacReader.this.streamInfo.durationUs();
        }
    }
}

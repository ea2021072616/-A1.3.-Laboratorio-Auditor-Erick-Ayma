package com.google.android.exoplayer2.extractor.ts;

import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TimestampAdjuster;
import com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class TsExtractor implements Extractor {
    private static final int BUFFER_PACKET_COUNT = 5;
    private static final int BUFFER_SIZE = 940;
    private static final int MAX_PID_PLUS_ONE = 8192;
    private static final String TAG = "TsExtractor";
    private static final int TS_PACKET_SIZE = 188;
    private static final int TS_PAT_PID = 0;
    public static final int TS_STREAM_TYPE_AAC = 15;
    public static final int TS_STREAM_TYPE_AC3 = 129;
    public static final int TS_STREAM_TYPE_DTS = 138;
    public static final int TS_STREAM_TYPE_E_AC3 = 135;
    public static final int TS_STREAM_TYPE_H262 = 2;
    public static final int TS_STREAM_TYPE_H264 = 27;
    public static final int TS_STREAM_TYPE_H265 = 36;
    public static final int TS_STREAM_TYPE_HDMV_DTS = 130;
    public static final int TS_STREAM_TYPE_ID3 = 21;
    public static final int TS_STREAM_TYPE_MPA = 3;
    public static final int TS_STREAM_TYPE_MPA_LSF = 4;
    private static final int TS_SYNC_BYTE = 71;
    private final SparseIntArray continuityCounters;
    private ElementaryStreamReader id3Reader;
    private final boolean mapByType;
    private ExtractorOutput output;
    private final ElementaryStreamReader.Factory streamReaderFactory;
    private final TimestampAdjuster timestampAdjuster;
    private final SparseBooleanArray trackIds;
    private boolean tracksEnded;
    private final ParsableByteArray tsPacketBuffer;
    private final SparseArray<TsPayloadReader> tsPayloadReaders;
    private final ParsableBitArray tsScratch;
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.ts.TsExtractor.1
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public Extractor[] createExtractors() {
            return new Extractor[]{new TsExtractor()};
        }
    };
    private static final long AC3_FORMAT_IDENTIFIER = Util.getIntegerCodeForString("AC-3");
    private static final long E_AC3_FORMAT_IDENTIFIER = Util.getIntegerCodeForString("EAC3");
    private static final long HEVC_FORMAT_IDENTIFIER = Util.getIntegerCodeForString("HEVC");

    public TsExtractor() {
        this(new TimestampAdjuster(0L));
    }

    public TsExtractor(TimestampAdjuster timestampAdjuster) {
        this(timestampAdjuster, new DefaultStreamReaderFactory(), false);
    }

    public TsExtractor(TimestampAdjuster timestampAdjuster, ElementaryStreamReader.Factory factory, boolean z) {
        this.timestampAdjuster = timestampAdjuster;
        this.streamReaderFactory = (ElementaryStreamReader.Factory) Assertions.checkNotNull(factory);
        this.mapByType = z;
        this.tsPacketBuffer = new ParsableByteArray((int) BUFFER_SIZE);
        this.tsScratch = new ParsableBitArray(new byte[3]);
        this.trackIds = new SparseBooleanArray();
        this.tsPayloadReaders = new SparseArray<>();
        this.continuityCounters = new SparseIntArray();
        resetPayloadReaders();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        r2 = r2 + 1;
     */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput r7) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r6 = this;
            r0 = 0
            com.google.android.exoplayer2.util.ParsableByteArray r1 = r6.tsPacketBuffer
            byte[] r3 = r1.data
            r1 = 940(0x3ac, float:1.317E-42)
            r7.peekFully(r3, r0, r1)
            r2 = r0
        Lb:
            r1 = 188(0xbc, float:2.63E-43)
            if (r2 >= r1) goto L17
            r1 = r0
        L10:
            r4 = 5
            if (r1 != r4) goto L18
            r7.skipFully(r2)
            r0 = 1
        L17:
            return r0
        L18:
            int r4 = r1 * 188
            int r4 = r4 + r2
            r4 = r3[r4]
            r5 = 71
            if (r4 == r5) goto L25
            int r1 = r2 + 1
            r2 = r1
            goto Lb
        L25:
            int r1 = r1 + 1
            goto L10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.TsExtractor.sniff(com.google.android.exoplayer2.extractor.ExtractorInput):boolean");
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.output = extractorOutput;
        extractorOutput.seekMap(new SeekMap.Unseekable(C.TIME_UNSET));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j) {
        this.timestampAdjuster.reset();
        this.tsPacketBuffer.reset();
        this.continuityCounters.clear();
        resetPayloadReaders();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        TsPayloadReader tsPayloadReader;
        byte[] bArr = this.tsPacketBuffer.data;
        if (940 - this.tsPacketBuffer.getPosition() < TS_PACKET_SIZE) {
            int bytesLeft = this.tsPacketBuffer.bytesLeft();
            if (bytesLeft > 0) {
                System.arraycopy(bArr, this.tsPacketBuffer.getPosition(), bArr, 0, bytesLeft);
            }
            this.tsPacketBuffer.reset(bArr, bytesLeft);
        }
        while (this.tsPacketBuffer.bytesLeft() < TS_PACKET_SIZE) {
            int limit = this.tsPacketBuffer.limit();
            int read = extractorInput.read(bArr, limit, 940 - limit);
            if (read == -1) {
                return -1;
            }
            this.tsPacketBuffer.setLimit(limit + read);
        }
        int limit2 = this.tsPacketBuffer.limit();
        int position = this.tsPacketBuffer.getPosition();
        while (position < limit2 && bArr[position] != 71) {
            position++;
        }
        this.tsPacketBuffer.setPosition(position);
        int i = position + TS_PACKET_SIZE;
        if (i <= limit2) {
            this.tsPacketBuffer.skipBytes(1);
            this.tsPacketBuffer.readBytes(this.tsScratch, 3);
            if (this.tsScratch.readBit()) {
                this.tsPacketBuffer.setPosition(i);
                return 0;
            }
            boolean readBit = this.tsScratch.readBit();
            this.tsScratch.skipBits(1);
            int readBits = this.tsScratch.readBits(13);
            this.tsScratch.skipBits(2);
            boolean readBit2 = this.tsScratch.readBit();
            boolean readBit3 = this.tsScratch.readBit();
            int readBits2 = this.tsScratch.readBits(4);
            int i2 = this.continuityCounters.get(readBits, readBits2 - 1);
            this.continuityCounters.put(readBits, readBits2);
            if (i2 == readBits2) {
                this.tsPacketBuffer.setPosition(i);
                return 0;
            }
            boolean z = readBits2 != (i2 + 1) % 16;
            if (readBit2) {
                this.tsPacketBuffer.skipBytes(this.tsPacketBuffer.readUnsignedByte());
            }
            if (readBit3 && (tsPayloadReader = this.tsPayloadReaders.get(readBits)) != null) {
                if (z) {
                    tsPayloadReader.seek();
                }
                this.tsPacketBuffer.setLimit(i);
                tsPayloadReader.consume(this.tsPacketBuffer, readBit, this.output);
                Assertions.checkState(this.tsPacketBuffer.getPosition() <= i);
                this.tsPacketBuffer.setLimit(limit2);
            }
            this.tsPacketBuffer.setPosition(i);
            return 0;
        }
        return 0;
    }

    private void resetPayloadReaders() {
        this.trackIds.clear();
        this.tsPayloadReaders.clear();
        this.tsPayloadReaders.put(0, new PatReader());
        this.id3Reader = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class TsPayloadReader {
        public abstract void consume(ParsableByteArray parsableByteArray, boolean z, ExtractorOutput extractorOutput);

        public abstract void seek();

        private TsPayloadReader() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PatReader extends TsPayloadReader {
        private int crc;
        private final ParsableBitArray patScratch;
        private int sectionBytesRead;
        private final ParsableByteArray sectionData;
        private int sectionLength;

        public PatReader() {
            super();
            this.sectionData = new ParsableByteArray();
            this.patScratch = new ParsableBitArray(new byte[4]);
        }

        @Override // com.google.android.exoplayer2.extractor.ts.TsExtractor.TsPayloadReader
        public void seek() {
        }

        @Override // com.google.android.exoplayer2.extractor.ts.TsExtractor.TsPayloadReader
        public void consume(ParsableByteArray parsableByteArray, boolean z, ExtractorOutput extractorOutput) {
            if (z) {
                parsableByteArray.skipBytes(parsableByteArray.readUnsignedByte());
                parsableByteArray.readBytes(this.patScratch, 3);
                this.patScratch.skipBits(12);
                this.sectionLength = this.patScratch.readBits(12);
                this.sectionBytesRead = 0;
                this.crc = Util.crc(this.patScratch.data, 0, 3, -1);
                this.sectionData.reset(this.sectionLength);
            }
            int min = Math.min(parsableByteArray.bytesLeft(), this.sectionLength - this.sectionBytesRead);
            parsableByteArray.readBytes(this.sectionData.data, this.sectionBytesRead, min);
            this.sectionBytesRead = min + this.sectionBytesRead;
            if (this.sectionBytesRead >= this.sectionLength && Util.crc(this.sectionData.data, 0, this.sectionLength, this.crc) == 0) {
                this.sectionData.skipBytes(5);
                int i = (this.sectionLength - 9) / 4;
                for (int i2 = 0; i2 < i; i2++) {
                    this.sectionData.readBytes(this.patScratch, 4);
                    int readBits = this.patScratch.readBits(16);
                    this.patScratch.skipBits(3);
                    if (readBits == 0) {
                        this.patScratch.skipBits(13);
                    } else {
                        int readBits2 = this.patScratch.readBits(13);
                        TsExtractor.this.tsPayloadReaders.put(readBits2, new PmtReader(readBits2));
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private class PmtReader extends TsPayloadReader {
        private static final int TS_PMT_DESC_AC3 = 106;
        private static final int TS_PMT_DESC_DTS = 123;
        private static final int TS_PMT_DESC_EAC3 = 122;
        private static final int TS_PMT_DESC_ISO639_LANG = 10;
        private static final int TS_PMT_DESC_REGISTRATION = 5;
        private int crc;
        private final int pid;
        private final ParsableBitArray pmtScratch;
        private int sectionBytesRead;
        private final ParsableByteArray sectionData;
        private int sectionLength;

        public PmtReader(int i) {
            super();
            this.pmtScratch = new ParsableBitArray(new byte[5]);
            this.sectionData = new ParsableByteArray();
            this.pid = i;
        }

        @Override // com.google.android.exoplayer2.extractor.ts.TsExtractor.TsPayloadReader
        public void seek() {
        }

        @Override // com.google.android.exoplayer2.extractor.ts.TsExtractor.TsPayloadReader
        public void consume(ParsableByteArray parsableByteArray, boolean z, ExtractorOutput extractorOutput) {
            ElementaryStreamReader createStreamReader;
            if (z) {
                parsableByteArray.skipBytes(parsableByteArray.readUnsignedByte());
                parsableByteArray.readBytes(this.pmtScratch, 3);
                this.pmtScratch.skipBits(12);
                this.sectionLength = this.pmtScratch.readBits(12);
                this.sectionBytesRead = 0;
                this.crc = Util.crc(this.pmtScratch.data, 0, 3, -1);
                this.sectionData.reset(this.sectionLength);
            }
            int min = Math.min(parsableByteArray.bytesLeft(), this.sectionLength - this.sectionBytesRead);
            parsableByteArray.readBytes(this.sectionData.data, this.sectionBytesRead, min);
            this.sectionBytesRead = min + this.sectionBytesRead;
            if (this.sectionBytesRead >= this.sectionLength && Util.crc(this.sectionData.data, 0, this.sectionLength, this.crc) == 0) {
                this.sectionData.skipBytes(7);
                this.sectionData.readBytes(this.pmtScratch, 2);
                this.pmtScratch.skipBits(4);
                int readBits = this.pmtScratch.readBits(12);
                this.sectionData.skipBytes(readBits);
                if (TsExtractor.this.mapByType && TsExtractor.this.id3Reader == null) {
                    TsExtractor.this.id3Reader = TsExtractor.this.streamReaderFactory.createStreamReader(21, new ElementaryStreamReader.EsInfo(21, null, new byte[0]));
                    TsExtractor.this.id3Reader.init(extractorOutput, new ElementaryStreamReader.TrackIdGenerator(21, 8192));
                }
                int i = ((this.sectionLength - 9) - readBits) - 4;
                while (i > 0) {
                    this.sectionData.readBytes(this.pmtScratch, 5);
                    int readBits2 = this.pmtScratch.readBits(8);
                    this.pmtScratch.skipBits(3);
                    int readBits3 = this.pmtScratch.readBits(13);
                    this.pmtScratch.skipBits(4);
                    int readBits4 = this.pmtScratch.readBits(12);
                    ElementaryStreamReader.EsInfo readEsInfo = readEsInfo(this.sectionData, readBits4);
                    if (readBits2 == 6) {
                        readBits2 = readEsInfo.streamType;
                    }
                    int i2 = i - (readBits4 + 5);
                    int i3 = TsExtractor.this.mapByType ? readBits2 : readBits3;
                    if (TsExtractor.this.trackIds.get(i3)) {
                        i = i2;
                    } else {
                        TsExtractor.this.trackIds.put(i3, true);
                        if (!TsExtractor.this.mapByType || readBits2 != 21) {
                            createStreamReader = TsExtractor.this.streamReaderFactory.createStreamReader(readBits2, readEsInfo);
                            createStreamReader.init(extractorOutput, new ElementaryStreamReader.TrackIdGenerator(i3, 8192));
                        } else {
                            createStreamReader = TsExtractor.this.id3Reader;
                        }
                        if (createStreamReader != null) {
                            TsExtractor.this.tsPayloadReaders.put(readBits3, new PesReader(createStreamReader, TsExtractor.this.timestampAdjuster));
                        }
                        i = i2;
                    }
                }
                if (TsExtractor.this.mapByType) {
                    if (!TsExtractor.this.tracksEnded) {
                        extractorOutput.endTracks();
                    }
                } else {
                    TsExtractor.this.tsPayloadReaders.remove(0);
                    TsExtractor.this.tsPayloadReaders.remove(this.pid);
                    extractorOutput.endTracks();
                }
                TsExtractor.this.tracksEnded = true;
            }
        }

        private ElementaryStreamReader.EsInfo readEsInfo(ParsableByteArray parsableByteArray, int i) {
            int position = parsableByteArray.getPosition();
            int i2 = position + i;
            int i3 = -1;
            String str = null;
            while (parsableByteArray.getPosition() < i2) {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte() + parsableByteArray.getPosition();
                if (readUnsignedByte == 5) {
                    long readUnsignedInt = parsableByteArray.readUnsignedInt();
                    if (readUnsignedInt == TsExtractor.AC3_FORMAT_IDENTIFIER) {
                        i3 = 129;
                    } else if (readUnsignedInt == TsExtractor.E_AC3_FORMAT_IDENTIFIER) {
                        i3 = 135;
                    } else if (readUnsignedInt == TsExtractor.HEVC_FORMAT_IDENTIFIER) {
                        i3 = 36;
                    }
                } else if (readUnsignedByte == 106) {
                    i3 = 129;
                } else if (readUnsignedByte == 122) {
                    i3 = 135;
                } else if (readUnsignedByte == TS_PMT_DESC_DTS) {
                    i3 = TsExtractor.TS_STREAM_TYPE_DTS;
                } else if (readUnsignedByte == 10) {
                    str = new String(parsableByteArray.data, parsableByteArray.getPosition(), 3).trim();
                }
                parsableByteArray.skipBytes(readUnsignedByte2 - parsableByteArray.getPosition());
            }
            parsableByteArray.setPosition(i2);
            return new ElementaryStreamReader.EsInfo(i3, str, Arrays.copyOfRange(this.sectionData.data, position, i2));
        }
    }

    /* loaded from: classes.dex */
    private static final class PesReader extends TsPayloadReader {
        private static final int HEADER_SIZE = 9;
        private static final int MAX_HEADER_EXTENSION_SIZE = 10;
        private static final int PES_SCRATCH_SIZE = 10;
        private static final int STATE_FINDING_HEADER = 0;
        private static final int STATE_READING_BODY = 3;
        private static final int STATE_READING_HEADER = 1;
        private static final int STATE_READING_HEADER_EXTENSION = 2;
        private int bytesRead;
        private boolean dataAlignmentIndicator;
        private boolean dtsFlag;
        private int extendedHeaderLength;
        private int payloadSize;
        private final ElementaryStreamReader pesPayloadReader;
        private final ParsableBitArray pesScratch;
        private boolean ptsFlag;
        private boolean seenFirstDts;
        private int state;
        private long timeUs;
        private final TimestampAdjuster timestampAdjuster;

        public PesReader(ElementaryStreamReader elementaryStreamReader, TimestampAdjuster timestampAdjuster) {
            super();
            this.pesPayloadReader = elementaryStreamReader;
            this.timestampAdjuster = timestampAdjuster;
            this.pesScratch = new ParsableBitArray(new byte[10]);
            this.state = 0;
        }

        @Override // com.google.android.exoplayer2.extractor.ts.TsExtractor.TsPayloadReader
        public void seek() {
            this.state = 0;
            this.bytesRead = 0;
            this.seenFirstDts = false;
            this.pesPayloadReader.seek();
        }

        @Override // com.google.android.exoplayer2.extractor.ts.TsExtractor.TsPayloadReader
        public void consume(ParsableByteArray parsableByteArray, boolean z, ExtractorOutput extractorOutput) {
            if (z) {
                switch (this.state) {
                    case 2:
                        Log.w(TsExtractor.TAG, "Unexpected start indicator reading extended header");
                        break;
                    case 3:
                        if (this.payloadSize != -1) {
                            Log.w(TsExtractor.TAG, "Unexpected start indicator: expected " + this.payloadSize + " more bytes");
                        }
                        this.pesPayloadReader.packetFinished();
                        break;
                }
                setState(1);
            }
            while (parsableByteArray.bytesLeft() > 0) {
                switch (this.state) {
                    case 0:
                        parsableByteArray.skipBytes(parsableByteArray.bytesLeft());
                        break;
                    case 1:
                        if (!continueRead(parsableByteArray, this.pesScratch.data, 9)) {
                            break;
                        } else {
                            setState(parseHeader() ? 2 : 0);
                            break;
                        }
                    case 2:
                        if (continueRead(parsableByteArray, this.pesScratch.data, Math.min(10, this.extendedHeaderLength)) && continueRead(parsableByteArray, null, this.extendedHeaderLength)) {
                            parseHeaderExtension();
                            this.pesPayloadReader.packetStarted(this.timeUs, this.dataAlignmentIndicator);
                            setState(3);
                            break;
                        }
                        break;
                    case 3:
                        int bytesLeft = parsableByteArray.bytesLeft();
                        int i = this.payloadSize == -1 ? 0 : bytesLeft - this.payloadSize;
                        if (i > 0) {
                            bytesLeft -= i;
                            parsableByteArray.setLimit(parsableByteArray.getPosition() + bytesLeft);
                        }
                        this.pesPayloadReader.consume(parsableByteArray);
                        if (this.payloadSize == -1) {
                            break;
                        } else {
                            this.payloadSize -= bytesLeft;
                            if (this.payloadSize != 0) {
                                break;
                            } else {
                                this.pesPayloadReader.packetFinished();
                                setState(1);
                                break;
                            }
                        }
                }
            }
        }

        private void setState(int i) {
            this.state = i;
            this.bytesRead = 0;
        }

        private boolean continueRead(ParsableByteArray parsableByteArray, byte[] bArr, int i) {
            int min = Math.min(parsableByteArray.bytesLeft(), i - this.bytesRead);
            if (min <= 0) {
                return true;
            }
            if (bArr == null) {
                parsableByteArray.skipBytes(min);
            } else {
                parsableByteArray.readBytes(bArr, this.bytesRead, min);
            }
            this.bytesRead = min + this.bytesRead;
            return this.bytesRead == i;
        }

        private boolean parseHeader() {
            this.pesScratch.setPosition(0);
            int readBits = this.pesScratch.readBits(24);
            if (readBits != 1) {
                Log.w(TsExtractor.TAG, "Unexpected start code prefix: " + readBits);
                this.payloadSize = -1;
                return false;
            }
            this.pesScratch.skipBits(8);
            int readBits2 = this.pesScratch.readBits(16);
            this.pesScratch.skipBits(5);
            this.dataAlignmentIndicator = this.pesScratch.readBit();
            this.pesScratch.skipBits(2);
            this.ptsFlag = this.pesScratch.readBit();
            this.dtsFlag = this.pesScratch.readBit();
            this.pesScratch.skipBits(6);
            this.extendedHeaderLength = this.pesScratch.readBits(8);
            if (readBits2 == 0) {
                this.payloadSize = -1;
            } else {
                this.payloadSize = ((readBits2 + 6) - 9) - this.extendedHeaderLength;
            }
            return true;
        }

        private void parseHeaderExtension() {
            this.pesScratch.setPosition(0);
            this.timeUs = C.TIME_UNSET;
            if (this.ptsFlag) {
                this.pesScratch.skipBits(4);
                this.pesScratch.skipBits(1);
                long readBits = (this.pesScratch.readBits(3) << 30) | (this.pesScratch.readBits(15) << 15);
                this.pesScratch.skipBits(1);
                long readBits2 = readBits | this.pesScratch.readBits(15);
                this.pesScratch.skipBits(1);
                if (!this.seenFirstDts && this.dtsFlag) {
                    this.pesScratch.skipBits(4);
                    this.pesScratch.skipBits(1);
                    long readBits3 = (this.pesScratch.readBits(3) << 30) | (this.pesScratch.readBits(15) << 15);
                    this.pesScratch.skipBits(1);
                    long readBits4 = readBits3 | this.pesScratch.readBits(15);
                    this.pesScratch.skipBits(1);
                    this.timestampAdjuster.adjustTsTimestamp(readBits4);
                    this.seenFirstDts = true;
                }
                this.timeUs = this.timestampAdjuster.adjustTsTimestamp(readBits2);
            }
        }
    }
}

package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
/* loaded from: classes.dex */
public final class Mp3Extractor implements Extractor {
    private static final int HEADER_MASK = -128000;
    private static final int MAX_SNIFF_BYTES = 4096;
    private static final int MAX_SYNC_BYTES = 131072;
    private long basisTimeUs;
    private ExtractorOutput extractorOutput;
    private final long forcedFirstSampleTimestampUs;
    private final GaplessInfoHolder gaplessInfoHolder;
    private int sampleBytesRemaining;
    private long samplesRead;
    private final ParsableByteArray scratch;
    private Seeker seeker;
    private final MpegAudioHeader synchronizedHeader;
    private int synchronizedHeaderData;
    private TrackOutput trackOutput;
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.1
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public Extractor[] createExtractors() {
            return new Extractor[]{new Mp3Extractor()};
        }
    };
    private static final int XING_HEADER = Util.getIntegerCodeForString("Xing");
    private static final int INFO_HEADER = Util.getIntegerCodeForString("Info");
    private static final int VBRI_HEADER = Util.getIntegerCodeForString("VBRI");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface Seeker extends SeekMap {
        long getTimeUs(long j);
    }

    public Mp3Extractor() {
        this(C.TIME_UNSET);
    }

    public Mp3Extractor(long j) {
        this.forcedFirstSampleTimestampUs = j;
        this.scratch = new ParsableByteArray(4);
        this.synchronizedHeader = new MpegAudioHeader();
        this.gaplessInfoHolder = new GaplessInfoHolder();
        this.basisTimeUs = C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return synchronize(extractorInput, true);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
        this.trackOutput = this.extractorOutput.track(0);
        this.extractorOutput.endTracks();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j) {
        this.synchronizedHeaderData = 0;
        this.basisTimeUs = C.TIME_UNSET;
        this.samplesRead = 0L;
        this.sampleBytesRemaining = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        if (this.synchronizedHeaderData == 0) {
            try {
                synchronize(extractorInput, false);
            } catch (EOFException e) {
                return -1;
            }
        }
        if (this.seeker == null) {
            this.seeker = setupSeeker(extractorInput);
            this.extractorOutput.seekMap(this.seeker);
            this.trackOutput.format(Format.createAudioSampleFormat(null, this.synchronizedHeader.mimeType, null, -1, 4096, this.synchronizedHeader.channels, this.synchronizedHeader.sampleRate, -1, this.gaplessInfoHolder.encoderDelay, this.gaplessInfoHolder.encoderPadding, null, null, 0, null));
        }
        return readSample(extractorInput);
    }

    private int readSample(ExtractorInput extractorInput) throws IOException, InterruptedException {
        if (this.sampleBytesRemaining == 0) {
            extractorInput.resetPeekPosition();
            if (!extractorInput.peekFully(this.scratch.data, 0, 4, true)) {
                return -1;
            }
            this.scratch.setPosition(0);
            int readInt = this.scratch.readInt();
            if ((readInt & HEADER_MASK) != (this.synchronizedHeaderData & HEADER_MASK) || MpegAudioHeader.getFrameSize(readInt) == -1) {
                extractorInput.skipFully(1);
                this.synchronizedHeaderData = 0;
                return 0;
            }
            MpegAudioHeader.populateHeader(readInt, this.synchronizedHeader);
            if (this.basisTimeUs == C.TIME_UNSET) {
                this.basisTimeUs = this.seeker.getTimeUs(extractorInput.getPosition());
                if (this.forcedFirstSampleTimestampUs != C.TIME_UNSET) {
                    this.basisTimeUs = (this.forcedFirstSampleTimestampUs - this.seeker.getTimeUs(0L)) + this.basisTimeUs;
                }
            }
            this.sampleBytesRemaining = this.synchronizedHeader.frameSize;
        }
        int sampleData = this.trackOutput.sampleData(extractorInput, this.sampleBytesRemaining, true);
        if (sampleData == -1) {
            return -1;
        }
        this.sampleBytesRemaining -= sampleData;
        if (this.sampleBytesRemaining <= 0) {
            this.trackOutput.sampleMetadata(((this.samplesRead * C.MICROS_PER_SECOND) / this.synchronizedHeader.sampleRate) + this.basisTimeUs, 1, this.synchronizedHeader.frameSize, 0, null);
            this.samplesRead += this.synchronizedHeader.samplesPerFrame;
            this.sampleBytesRemaining = 0;
            return 0;
        }
        return 0;
    }

    private boolean synchronize(ExtractorInput extractorInput, boolean z) throws IOException, InterruptedException {
        int i;
        int i2;
        int i3;
        int i4;
        int frameSize;
        int i5 = z ? 4096 : 131072;
        extractorInput.resetPeekPosition();
        if (extractorInput.getPosition() == 0) {
            Id3Util.parseId3(extractorInput, this.gaplessInfoHolder);
            int peekPosition = (int) extractorInput.getPeekPosition();
            if (!z) {
                extractorInput.skipFully(peekPosition);
            }
            i2 = peekPosition;
            i3 = 0;
            i4 = 0;
            i = 0;
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        while (true) {
            if (!extractorInput.peekFully(this.scratch.data, 0, 4, i4 > 0)) {
                break;
            }
            this.scratch.setPosition(0);
            int readInt = this.scratch.readInt();
            if ((i3 != 0 && (readInt & HEADER_MASK) != (i3 & HEADER_MASK)) || (frameSize = MpegAudioHeader.getFrameSize(readInt)) == -1) {
                int i6 = i + 1;
                if (i == i5) {
                    if (z) {
                        return false;
                    }
                    throw new ParserException("Searched too many bytes.");
                } else if (z) {
                    extractorInput.resetPeekPosition();
                    extractorInput.advancePeekPosition(i2 + i6);
                    i = i6;
                    i4 = 0;
                    i3 = 0;
                } else {
                    extractorInput.skipFully(1);
                    i = i6;
                    i4 = 0;
                    i3 = 0;
                }
            } else {
                i4++;
                if (i4 == 1) {
                    MpegAudioHeader.populateHeader(readInt, this.synchronizedHeader);
                    i3 = readInt;
                } else if (i4 == 4) {
                    break;
                }
                extractorInput.advancePeekPosition(frameSize - 4);
            }
        }
        if (z) {
            extractorInput.skipFully(i2 + i);
        } else {
            extractorInput.resetPeekPosition();
        }
        this.synchronizedHeaderData = i3;
        return true;
    }

    private Seeker setupSeeker(ExtractorInput extractorInput) throws IOException, InterruptedException {
        int i;
        Seeker create;
        int i2 = 21;
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.synchronizedHeader.frameSize);
        extractorInput.peekFully(parsableByteArray.data, 0, this.synchronizedHeader.frameSize);
        long position = extractorInput.getPosition();
        long length = extractorInput.getLength();
        if ((this.synchronizedHeader.version & 1) != 0) {
            if (this.synchronizedHeader.channels != 1) {
                i2 = 36;
            }
        } else if (this.synchronizedHeader.channels == 1) {
            i2 = 13;
        }
        if (parsableByteArray.limit() >= i2 + 4) {
            parsableByteArray.setPosition(i2);
            i = parsableByteArray.readInt();
        } else {
            i = 0;
        }
        if (i == XING_HEADER || i == INFO_HEADER) {
            create = XingSeeker.create(this.synchronizedHeader, parsableByteArray, position, length);
            if (create != null && !this.gaplessInfoHolder.hasGaplessInfo()) {
                extractorInput.resetPeekPosition();
                extractorInput.advancePeekPosition(i2 + 141);
                extractorInput.peekFully(this.scratch.data, 0, 3);
                this.scratch.setPosition(0);
                this.gaplessInfoHolder.setFromXingHeaderValue(this.scratch.readUnsignedInt24());
            }
            extractorInput.skipFully(this.synchronizedHeader.frameSize);
        } else {
            if (parsableByteArray.limit() >= 40) {
                parsableByteArray.setPosition(36);
                if (parsableByteArray.readInt() == VBRI_HEADER) {
                    create = VbriSeeker.create(this.synchronizedHeader, parsableByteArray, position, length);
                    extractorInput.skipFully(this.synchronizedHeader.frameSize);
                }
            }
            create = null;
        }
        if (create == null) {
            extractorInput.resetPeekPosition();
            extractorInput.peekFully(this.scratch.data, 0, 4);
            this.scratch.setPosition(0);
            MpegAudioHeader.populateHeader(this.scratch.readInt(), this.synchronizedHeader);
            return new ConstantBitrateSeeker(extractorInput.getPosition(), this.synchronizedHeader.bitrate, length);
        }
        return create;
    }
}

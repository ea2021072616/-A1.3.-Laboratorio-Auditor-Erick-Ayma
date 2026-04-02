package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
/* loaded from: classes.dex */
public final class Mp4Extractor implements Extractor, SeekMap {
    private static final long RELOAD_MINIMUM_SEEK_DISTANCE = 262144;
    private static final int STATE_AFTER_SEEK = 0;
    private static final int STATE_READING_ATOM_HEADER = 1;
    private static final int STATE_READING_ATOM_PAYLOAD = 2;
    private static final int STATE_READING_SAMPLE = 3;
    private ParsableByteArray atomData;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private long durationUs;
    private ExtractorOutput extractorOutput;
    private boolean isQuickTime;
    private int parserState;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private Mp4Track[] tracks;
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.1
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public Extractor[] createExtractors() {
            return new Extractor[]{new Mp4Extractor()};
        }
    };
    private static final int BRAND_QUICKTIME = Util.getIntegerCodeForString("qt  ");
    private final ParsableByteArray atomHeader = new ParsableByteArray(16);
    private final Stack<Atom.ContainerAtom> containerAtoms = new Stack<>();
    private final ParsableByteArray nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
    private final ParsableByteArray nalLength = new ParsableByteArray(4);

    public Mp4Extractor() {
        enterReadingAtomHeaderState();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return Sniffer.sniffUnfragmented(extractorInput);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j) {
        this.containerAtoms.clear();
        this.atomHeaderBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        this.parserState = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        while (true) {
            switch (this.parserState) {
                case 0:
                    if (extractorInput.getPosition() == 0) {
                        enterReadingAtomHeaderState();
                        break;
                    } else {
                        this.parserState = 3;
                        break;
                    }
                case 1:
                    if (readAtomHeader(extractorInput)) {
                        break;
                    } else {
                        return -1;
                    }
                case 2:
                    if (!readAtomPayload(extractorInput, positionHolder)) {
                        break;
                    } else {
                        return 1;
                    }
                default:
                    return readSample(extractorInput, positionHolder);
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getPosition(long j) {
        long j2 = Long.MAX_VALUE;
        Mp4Track[] mp4TrackArr = this.tracks;
        int length = mp4TrackArr.length;
        int i = 0;
        while (i < length) {
            Mp4Track mp4Track = mp4TrackArr[i];
            TrackSampleTable trackSampleTable = mp4Track.sampleTable;
            int indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(j);
            if (indexOfEarlierOrEqualSynchronizationSample == -1) {
                indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j);
            }
            mp4Track.sampleIndex = indexOfEarlierOrEqualSynchronizationSample;
            long j3 = trackSampleTable.offsets[indexOfEarlierOrEqualSynchronizationSample];
            if (j3 >= j2) {
                j3 = j2;
            }
            i++;
            j2 = j3;
        }
        return j2;
    }

    private void enterReadingAtomHeaderState() {
        this.parserState = 1;
        this.atomHeaderBytesRead = 0;
    }

    private boolean readAtomHeader(ExtractorInput extractorInput) throws IOException, InterruptedException {
        if (this.atomHeaderBytesRead == 0) {
            if (!extractorInput.readFully(this.atomHeader.data, 0, 8, true)) {
                return false;
            }
            this.atomHeaderBytesRead = 8;
            this.atomHeader.setPosition(0);
            this.atomSize = this.atomHeader.readUnsignedInt();
            this.atomType = this.atomHeader.readInt();
        }
        if (this.atomSize == 1) {
            extractorInput.readFully(this.atomHeader.data, 8, 8);
            this.atomHeaderBytesRead += 8;
            this.atomSize = this.atomHeader.readUnsignedLongToLong();
        }
        if (shouldParseContainerAtom(this.atomType)) {
            long position = (extractorInput.getPosition() + this.atomSize) - this.atomHeaderBytesRead;
            this.containerAtoms.add(new Atom.ContainerAtom(this.atomType, position));
            if (this.atomSize == this.atomHeaderBytesRead) {
                processAtomEnded(position);
            } else {
                enterReadingAtomHeaderState();
            }
        } else if (shouldParseLeafAtom(this.atomType)) {
            Assertions.checkState(this.atomHeaderBytesRead == 8);
            Assertions.checkState(this.atomSize <= 2147483647L);
            this.atomData = new ParsableByteArray((int) this.atomSize);
            System.arraycopy(this.atomHeader.data, 0, this.atomData.data, 0, 8);
            this.parserState = 2;
        } else {
            this.atomData = null;
            this.parserState = 2;
        }
        return true;
    }

    private boolean readAtomPayload(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        boolean z;
        long j = this.atomSize - this.atomHeaderBytesRead;
        long position = extractorInput.getPosition() + j;
        if (this.atomData != null) {
            extractorInput.readFully(this.atomData.data, this.atomHeaderBytesRead, (int) j);
            if (this.atomType == Atom.TYPE_ftyp) {
                this.isQuickTime = processFtypAtom(this.atomData);
                z = false;
            } else if (this.containerAtoms.isEmpty()) {
                z = false;
            } else {
                this.containerAtoms.peek().add(new Atom.LeafAtom(this.atomType, this.atomData));
                z = false;
            }
        } else if (j < 262144) {
            extractorInput.skipFully((int) j);
            z = false;
        } else {
            positionHolder.position = j + extractorInput.getPosition();
            z = true;
        }
        processAtomEnded(position);
        return z && this.parserState != 3;
    }

    private void processAtomEnded(long j) throws ParserException {
        while (!this.containerAtoms.isEmpty() && this.containerAtoms.peek().endPosition == j) {
            Atom.ContainerAtom pop = this.containerAtoms.pop();
            if (pop.type == Atom.TYPE_moov) {
                processMoovAtom(pop);
                this.containerAtoms.clear();
                this.parserState = 3;
            } else if (!this.containerAtoms.isEmpty()) {
                this.containerAtoms.peek().add(pop);
            }
        }
        if (this.parserState != 3) {
            enterReadingAtomHeaderState();
        }
    }

    private static boolean processFtypAtom(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        if (parsableByteArray.readInt() == BRAND_QUICKTIME) {
            return true;
        }
        parsableByteArray.skipBytes(4);
        while (parsableByteArray.bytesLeft() > 0) {
            if (parsableByteArray.readInt() == BRAND_QUICKTIME) {
                return true;
            }
        }
        return false;
    }

    private void processMoovAtom(Atom.ContainerAtom containerAtom) throws ParserException {
        long j = C.TIME_UNSET;
        ArrayList arrayList = new ArrayList();
        long j2 = Long.MAX_VALUE;
        GaplessInfoHolder gaplessInfoHolder = new GaplessInfoHolder();
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_udta);
        if (leafAtomOfType != null) {
            AtomParsers.parseUdta(leafAtomOfType, this.isQuickTime, gaplessInfoHolder);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            long j3 = j2;
            long j4 = j;
            if (i2 < containerAtom.containerChildren.size()) {
                Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i2);
                if (containerAtom2.type != Atom.TYPE_trak) {
                    j2 = j3;
                } else {
                    Track parseTrak = AtomParsers.parseTrak(containerAtom2, containerAtom.getLeafAtomOfType(Atom.TYPE_mvhd), C.TIME_UNSET, null, this.isQuickTime);
                    if (parseTrak == null) {
                        j2 = j3;
                    } else {
                        TrackSampleTable parseStbl = AtomParsers.parseStbl(parseTrak, containerAtom2.getContainerAtomOfType(Atom.TYPE_mdia).getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl), gaplessInfoHolder);
                        if (parseStbl.sampleCount == 0) {
                            j2 = j3;
                        } else {
                            Mp4Track mp4Track = new Mp4Track(parseTrak, parseStbl, this.extractorOutput.track(i2));
                            Format copyWithMaxInputSize = parseTrak.format.copyWithMaxInputSize(parseStbl.maximumSize + 30);
                            if (parseTrak.type == 1 && gaplessInfoHolder.hasGaplessInfo()) {
                                copyWithMaxInputSize = copyWithMaxInputSize.copyWithGaplessInfo(gaplessInfoHolder.encoderDelay, gaplessInfoHolder.encoderPadding);
                            }
                            mp4Track.trackOutput.format(copyWithMaxInputSize);
                            j4 = Math.max(j4, parseTrak.durationUs);
                            arrayList.add(mp4Track);
                            j2 = parseStbl.offsets[0];
                            if (j2 >= j3) {
                                j2 = j3;
                            }
                        }
                    }
                }
                j = j4;
                i = i2 + 1;
            } else {
                this.durationUs = j4;
                this.tracks = (Mp4Track[]) arrayList.toArray(new Mp4Track[arrayList.size()]);
                this.extractorOutput.endTracks();
                this.extractorOutput.seekMap(this);
                return;
            }
        }
    }

    private int readSample(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        int i;
        int trackIndexOfEarliestCurrentSample = getTrackIndexOfEarliestCurrentSample();
        if (trackIndexOfEarliestCurrentSample == -1) {
            return -1;
        }
        Mp4Track mp4Track = this.tracks[trackIndexOfEarliestCurrentSample];
        TrackOutput trackOutput = mp4Track.trackOutput;
        int i2 = mp4Track.sampleIndex;
        long j = mp4Track.sampleTable.offsets[i2];
        int i3 = mp4Track.sampleTable.sizes[i2];
        if (mp4Track.track.sampleTransformation == 1) {
            j += 8;
            i3 -= 8;
        }
        long position = (j - extractorInput.getPosition()) + this.sampleBytesWritten;
        if (position < 0 || position >= 262144) {
            positionHolder.position = j;
            return 1;
        }
        extractorInput.skipFully((int) position);
        if (mp4Track.track.nalUnitLengthFieldLength != 0) {
            byte[] bArr = this.nalLength.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i4 = mp4Track.track.nalUnitLengthFieldLength;
            int i5 = 4 - mp4Track.track.nalUnitLengthFieldLength;
            while (this.sampleBytesWritten < i3) {
                if (this.sampleCurrentNalBytesRemaining == 0) {
                    extractorInput.readFully(this.nalLength.data, i5, i4);
                    this.nalLength.setPosition(0);
                    this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
                    this.nalStartCode.setPosition(0);
                    trackOutput.sampleData(this.nalStartCode, 4);
                    this.sampleBytesWritten += 4;
                    i3 += i5;
                } else {
                    int sampleData = trackOutput.sampleData(extractorInput, this.sampleCurrentNalBytesRemaining, false);
                    this.sampleBytesWritten += sampleData;
                    this.sampleCurrentNalBytesRemaining -= sampleData;
                }
            }
            i = i3;
        } else {
            while (this.sampleBytesWritten < i3) {
                int sampleData2 = trackOutput.sampleData(extractorInput, i3 - this.sampleBytesWritten, false);
                this.sampleBytesWritten += sampleData2;
                this.sampleCurrentNalBytesRemaining -= sampleData2;
            }
            i = i3;
        }
        trackOutput.sampleMetadata(mp4Track.sampleTable.timestampsUs[i2], mp4Track.sampleTable.flags[i2], i, 0, null);
        mp4Track.sampleIndex++;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        return 0;
    }

    private int getTrackIndexOfEarliestCurrentSample() {
        int i = -1;
        long j = Long.MAX_VALUE;
        for (int i2 = 0; i2 < this.tracks.length; i2++) {
            Mp4Track mp4Track = this.tracks[i2];
            int i3 = mp4Track.sampleIndex;
            if (i3 != mp4Track.sampleTable.sampleCount) {
                long j2 = mp4Track.sampleTable.offsets[i3];
                if (j2 < j) {
                    j = j2;
                    i = i2;
                }
            }
        }
        return i;
    }

    private static boolean shouldParseLeafAtom(int i) {
        return i == Atom.TYPE_mdhd || i == Atom.TYPE_mvhd || i == Atom.TYPE_hdlr || i == Atom.TYPE_stsd || i == Atom.TYPE_stts || i == Atom.TYPE_stss || i == Atom.TYPE_ctts || i == Atom.TYPE_elst || i == Atom.TYPE_stsc || i == Atom.TYPE_stsz || i == Atom.TYPE_stz2 || i == Atom.TYPE_stco || i == Atom.TYPE_co64 || i == Atom.TYPE_tkhd || i == Atom.TYPE_ftyp || i == Atom.TYPE_udta;
    }

    private static boolean shouldParseContainerAtom(int i) {
        return i == Atom.TYPE_moov || i == Atom.TYPE_trak || i == Atom.TYPE_mdia || i == Atom.TYPE_minf || i == Atom.TYPE_stbl || i == Atom.TYPE_edts;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Mp4Track {
        public int sampleIndex;
        public final TrackSampleTable sampleTable;
        public final Track track;
        public final TrackOutput trackOutput;

        public Mp4Track(Track track, TrackSampleTable trackSampleTable, TrackOutput trackOutput) {
            this.track = track;
            this.sampleTable = trackSampleTable;
            this.trackOutput = trackOutput;
        }
    }
}

package com.google.android.exoplayer2.extractor.mp4;

import android.support.v7.widget.ActivityChooserView;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TimestampAdjuster;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.UUID;
/* loaded from: classes.dex */
public final class FragmentedMp4Extractor implements Extractor {
    private static final int FLAG_SIDELOADED = 4;
    public static final int FLAG_WORKAROUND_EVERY_VIDEO_FRAME_IS_SYNC_FRAME = 1;
    public static final int FLAG_WORKAROUND_IGNORE_TFDT_BOX = 2;
    private static final int STATE_READING_ATOM_HEADER = 0;
    private static final int STATE_READING_ATOM_PAYLOAD = 1;
    private static final int STATE_READING_ENCRYPTION_DATA = 2;
    private static final int STATE_READING_SAMPLE_CONTINUE = 4;
    private static final int STATE_READING_SAMPLE_START = 3;
    private static final String TAG = "FragmentedMp4Extractor";
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private final Stack<Atom.ContainerAtom> containerAtoms;
    private TrackBundle currentTrackBundle;
    private long durationUs;
    private final ParsableByteArray encryptionSignalByte;
    private long endOfMdatPosition;
    private final byte[] extendedTypeScratch;
    private ExtractorOutput extractorOutput;
    private final int flags;
    private boolean haveOutputSeekMap;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private int parserState;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleSize;
    private final Track sideloadedTrack;
    private final TimestampAdjuster timestampAdjuster;
    private final SparseArray<TrackBundle> trackBundles;
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.1
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public Extractor[] createExtractors() {
            return new Extractor[]{new FragmentedMp4Extractor()};
        }
    };
    private static final int SAMPLE_GROUP_TYPE_seig = Util.getIntegerCodeForString("seig");
    private static final byte[] PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Flags {
    }

    public FragmentedMp4Extractor() {
        this(0, null);
    }

    public FragmentedMp4Extractor(int i, TimestampAdjuster timestampAdjuster) {
        this(i, null, timestampAdjuster);
    }

    public FragmentedMp4Extractor(int i, Track track, TimestampAdjuster timestampAdjuster) {
        this.sideloadedTrack = track;
        this.flags = (track != null ? 4 : 0) | i;
        this.timestampAdjuster = timestampAdjuster;
        this.atomHeader = new ParsableByteArray(16);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
        this.encryptionSignalByte = new ParsableByteArray(1);
        this.extendedTypeScratch = new byte[16];
        this.containerAtoms = new Stack<>();
        this.trackBundles = new SparseArray<>();
        this.durationUs = C.TIME_UNSET;
        enterReadingAtomHeaderState();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return Sniffer.sniffFragmented(extractorInput);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
        if (this.sideloadedTrack != null) {
            TrackBundle trackBundle = new TrackBundle(extractorOutput.track(0));
            trackBundle.init(this.sideloadedTrack, new DefaultSampleValues(0, 0, 0, 0));
            this.trackBundles.put(0, trackBundle);
            this.extractorOutput.endTracks();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j) {
        int size = this.trackBundles.size();
        for (int i = 0; i < size; i++) {
            this.trackBundles.valueAt(i).reset();
        }
        this.containerAtoms.clear();
        enterReadingAtomHeaderState();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        while (true) {
            switch (this.parserState) {
                case 0:
                    if (readAtomHeader(extractorInput)) {
                        break;
                    } else {
                        return -1;
                    }
                case 1:
                    readAtomPayload(extractorInput);
                    break;
                case 2:
                    readEncryptionData(extractorInput);
                    break;
                default:
                    if (!readSample(extractorInput)) {
                        break;
                    } else {
                        return 0;
                    }
            }
        }
    }

    private void enterReadingAtomHeaderState() {
        this.parserState = 0;
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
        long position = extractorInput.getPosition() - this.atomHeaderBytesRead;
        if (this.atomType == Atom.TYPE_moof) {
            int size = this.trackBundles.size();
            for (int i = 0; i < size; i++) {
                TrackFragment trackFragment = this.trackBundles.valueAt(i).fragment;
                trackFragment.atomPosition = position;
                trackFragment.auxiliaryDataPosition = position;
                trackFragment.dataPosition = position;
            }
        }
        if (this.atomType == Atom.TYPE_mdat) {
            this.currentTrackBundle = null;
            this.endOfMdatPosition = this.atomSize + position;
            if (!this.haveOutputSeekMap) {
                this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs));
                this.haveOutputSeekMap = true;
            }
            this.parserState = 2;
            return true;
        }
        if (shouldParseContainerAtom(this.atomType)) {
            long position2 = (extractorInput.getPosition() + this.atomSize) - 8;
            this.containerAtoms.add(new Atom.ContainerAtom(this.atomType, position2));
            if (this.atomSize == this.atomHeaderBytesRead) {
                processAtomEnded(position2);
            } else {
                enterReadingAtomHeaderState();
            }
        } else if (shouldParseLeafAtom(this.atomType)) {
            if (this.atomHeaderBytesRead != 8) {
                throw new ParserException("Leaf atom defines extended atom size (unsupported).");
            }
            if (this.atomSize > 2147483647L) {
                throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
            }
            this.atomData = new ParsableByteArray((int) this.atomSize);
            System.arraycopy(this.atomHeader.data, 0, this.atomData.data, 0, 8);
            this.parserState = 1;
        } else if (this.atomSize > 2147483647L) {
            throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
        } else {
            this.atomData = null;
            this.parserState = 1;
        }
        return true;
    }

    private void readAtomPayload(ExtractorInput extractorInput) throws IOException, InterruptedException {
        int i = ((int) this.atomSize) - this.atomHeaderBytesRead;
        if (this.atomData != null) {
            extractorInput.readFully(this.atomData.data, 8, i);
            onLeafAtomRead(new Atom.LeafAtom(this.atomType, this.atomData), extractorInput.getPosition());
        } else {
            extractorInput.skipFully(i);
        }
        processAtomEnded(extractorInput.getPosition());
    }

    private void processAtomEnded(long j) throws ParserException {
        while (!this.containerAtoms.isEmpty() && this.containerAtoms.peek().endPosition == j) {
            onContainerAtomRead(this.containerAtoms.pop());
        }
        enterReadingAtomHeaderState();
    }

    private void onLeafAtomRead(Atom.LeafAtom leafAtom, long j) throws ParserException {
        if (!this.containerAtoms.isEmpty()) {
            this.containerAtoms.peek().add(leafAtom);
        } else if (leafAtom.type == Atom.TYPE_sidx) {
            this.extractorOutput.seekMap(parseSidx(leafAtom.data, j));
            this.haveOutputSeekMap = true;
        }
    }

    private void onContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        if (containerAtom.type == Atom.TYPE_moov) {
            onMoovContainerAtomRead(containerAtom);
        } else if (containerAtom.type == Atom.TYPE_moof) {
            onMoofContainerAtomRead(containerAtom);
        } else if (!this.containerAtoms.isEmpty()) {
            this.containerAtoms.peek().add(containerAtom);
        }
    }

    private void onMoovContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        Track parseTrak;
        Assertions.checkState(this.sideloadedTrack == null, "Unexpected moov box.");
        DrmInitData drmInitDataFromAtoms = getDrmInitDataFromAtoms(containerAtom.leafChildren);
        Atom.ContainerAtom containerAtomOfType = containerAtom.getContainerAtomOfType(Atom.TYPE_mvex);
        SparseArray sparseArray = new SparseArray();
        long j = C.TIME_UNSET;
        int size = containerAtomOfType.leafChildren.size();
        for (int i = 0; i < size; i++) {
            Atom.LeafAtom leafAtom = containerAtomOfType.leafChildren.get(i);
            if (leafAtom.type == Atom.TYPE_trex) {
                Pair<Integer, DefaultSampleValues> parseTrex = parseTrex(leafAtom.data);
                sparseArray.put(((Integer) parseTrex.first).intValue(), parseTrex.second);
            } else if (leafAtom.type == Atom.TYPE_mehd) {
                j = parseMehd(leafAtom.data);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = containerAtom.containerChildren.size();
        for (int i2 = 0; i2 < size2; i2++) {
            Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i2);
            if (containerAtom2.type == Atom.TYPE_trak && (parseTrak = AtomParsers.parseTrak(containerAtom2, containerAtom.getLeafAtomOfType(Atom.TYPE_mvhd), j, drmInitDataFromAtoms, false)) != null) {
                sparseArray2.put(parseTrak.id, parseTrak);
            }
        }
        int size3 = sparseArray2.size();
        if (this.trackBundles.size() == 0) {
            for (int i3 = 0; i3 < size3; i3++) {
                Track track = (Track) sparseArray2.valueAt(i3);
                this.trackBundles.put(track.id, new TrackBundle(this.extractorOutput.track(i3)));
                this.durationUs = Math.max(this.durationUs, track.durationUs);
            }
            this.extractorOutput.endTracks();
        } else {
            Assertions.checkState(this.trackBundles.size() == size3);
        }
        for (int i4 = 0; i4 < size3; i4++) {
            Track track2 = (Track) sparseArray2.valueAt(i4);
            this.trackBundles.get(track2.id).init(track2, (DefaultSampleValues) sparseArray.get(track2.id));
        }
    }

    private void onMoofContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        parseMoof(containerAtom, this.trackBundles, this.flags, this.extendedTypeScratch);
        DrmInitData drmInitDataFromAtoms = getDrmInitDataFromAtoms(containerAtom.leafChildren);
        if (drmInitDataFromAtoms != null) {
            int size = this.trackBundles.size();
            for (int i = 0; i < size; i++) {
                this.trackBundles.valueAt(i).updateDrmInitData(drmInitDataFromAtoms);
            }
        }
    }

    private static Pair<Integer, DefaultSampleValues> parseTrex(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(12);
        return Pair.create(Integer.valueOf(parsableByteArray.readInt()), new DefaultSampleValues(parsableByteArray.readUnsignedIntToInt() - 1, parsableByteArray.readUnsignedIntToInt(), parsableByteArray.readUnsignedIntToInt(), parsableByteArray.readInt()));
    }

    private static long parseMehd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        return Atom.parseFullAtomVersion(parsableByteArray.readInt()) == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
    }

    private static void parseMoof(Atom.ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, int i, byte[] bArr) throws ParserException {
        int size = containerAtom.containerChildren.size();
        for (int i2 = 0; i2 < size; i2++) {
            Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i2);
            if (containerAtom2.type == Atom.TYPE_traf) {
                parseTraf(containerAtom2, sparseArray, i, bArr);
            }
        }
    }

    private static void parseTraf(Atom.ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, int i, byte[] bArr) throws ParserException {
        TrackBundle parseTfhd = parseTfhd(containerAtom.getLeafAtomOfType(Atom.TYPE_tfhd).data, sparseArray, i);
        if (parseTfhd != null) {
            TrackFragment trackFragment = parseTfhd.fragment;
            long j = trackFragment.nextFragmentDecodeTime;
            parseTfhd.reset();
            if (containerAtom.getLeafAtomOfType(Atom.TYPE_tfdt) != null && (i & 2) == 0) {
                j = parseTfdt(containerAtom.getLeafAtomOfType(Atom.TYPE_tfdt).data);
            }
            parseTruns(containerAtom, parseTfhd, j, i);
            Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_saiz);
            if (leafAtomOfType != null) {
                parseSaiz(parseTfhd.track.sampleDescriptionEncryptionBoxes[trackFragment.header.sampleDescriptionIndex], leafAtomOfType.data, trackFragment);
            }
            Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_saio);
            if (leafAtomOfType2 != null) {
                parseSaio(leafAtomOfType2.data, trackFragment);
            }
            Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_senc);
            if (leafAtomOfType3 != null) {
                parseSenc(leafAtomOfType3.data, trackFragment);
            }
            Atom.LeafAtom leafAtomOfType4 = containerAtom.getLeafAtomOfType(Atom.TYPE_sbgp);
            Atom.LeafAtom leafAtomOfType5 = containerAtom.getLeafAtomOfType(Atom.TYPE_sgpd);
            if (leafAtomOfType4 != null && leafAtomOfType5 != null) {
                parseSgpd(leafAtomOfType4.data, leafAtomOfType5.data, trackFragment);
            }
            int size = containerAtom.leafChildren.size();
            for (int i2 = 0; i2 < size; i2++) {
                Atom.LeafAtom leafAtom = containerAtom.leafChildren.get(i2);
                if (leafAtom.type == Atom.TYPE_uuid) {
                    parseUuid(leafAtom.data, trackFragment, bArr);
                }
            }
        }
    }

    private static void parseTruns(Atom.ContainerAtom containerAtom, TrackBundle trackBundle, long j, int i) {
        int i2;
        int i3;
        List<Atom.LeafAtom> list = containerAtom.leafChildren;
        int size = list.size();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < size) {
            Atom.LeafAtom leafAtom = list.get(i4);
            if (leafAtom.type == Atom.TYPE_trun) {
                ParsableByteArray parsableByteArray = leafAtom.data;
                parsableByteArray.setPosition(12);
                int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
                if (readUnsignedIntToInt > 0) {
                    i2 = readUnsignedIntToInt + i5;
                    i3 = i6 + 1;
                    i4++;
                    i6 = i3;
                    i5 = i2;
                }
            }
            i2 = i5;
            i3 = i6;
            i4++;
            i6 = i3;
            i5 = i2;
        }
        trackBundle.currentTrackRunIndex = 0;
        trackBundle.currentSampleInTrackRun = 0;
        trackBundle.currentSampleIndex = 0;
        trackBundle.fragment.initTables(i6, i5);
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            Atom.LeafAtom leafAtom2 = list.get(i9);
            if (leafAtom2.type == Atom.TYPE_trun) {
                i7 = parseTrun(trackBundle, i8, j, i, leafAtom2.data, i7);
                i8++;
            }
        }
    }

    private static void parseSaiz(TrackEncryptionBox trackEncryptionBox, ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        int i;
        int i2 = trackEncryptionBox.initializationVectorSize;
        parsableByteArray.setPosition(8);
        if ((Atom.parseFullAtomFlags(parsableByteArray.readInt()) & 1) == 1) {
            parsableByteArray.skipBytes(8);
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (readUnsignedIntToInt != trackFragment.sampleCount) {
            throw new ParserException("Length mismatch: " + readUnsignedIntToInt + ", " + trackFragment.sampleCount);
        }
        if (readUnsignedByte == 0) {
            boolean[] zArr = trackFragment.sampleHasSubsampleEncryptionTable;
            int i3 = 0;
            i = 0;
            while (i3 < readUnsignedIntToInt) {
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                int i4 = i + readUnsignedByte2;
                zArr[i3] = readUnsignedByte2 > i2;
                i3++;
                i = i4;
            }
        } else {
            boolean z = readUnsignedByte > i2;
            i = (readUnsignedByte * readUnsignedIntToInt) + 0;
            Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, readUnsignedIntToInt, z);
        }
        trackFragment.initEncryptionData(i);
    }

    private static void parseSaio(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        parsableByteArray.setPosition(8);
        int readInt = parsableByteArray.readInt();
        if ((Atom.parseFullAtomFlags(readInt) & 1) == 1) {
            parsableByteArray.skipBytes(8);
        }
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (readUnsignedIntToInt != 1) {
            throw new ParserException("Unexpected saio entry count: " + readUnsignedIntToInt);
        }
        int parseFullAtomVersion = Atom.parseFullAtomVersion(readInt);
        trackFragment.auxiliaryDataPosition = (parseFullAtomVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong()) + trackFragment.auxiliaryDataPosition;
    }

    private static TrackBundle parseTfhd(ParsableByteArray parsableByteArray, SparseArray<TrackBundle> sparseArray, int i) {
        parsableByteArray.setPosition(8);
        int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
        int readInt = parsableByteArray.readInt();
        if ((i & 4) != 0) {
            readInt = 0;
        }
        TrackBundle trackBundle = sparseArray.get(readInt);
        if (trackBundle == null) {
            return null;
        }
        if ((parseFullAtomFlags & 1) != 0) {
            long readUnsignedLongToLong = parsableByteArray.readUnsignedLongToLong();
            trackBundle.fragment.dataPosition = readUnsignedLongToLong;
            trackBundle.fragment.auxiliaryDataPosition = readUnsignedLongToLong;
        }
        DefaultSampleValues defaultSampleValues = trackBundle.defaultSampleValues;
        trackBundle.fragment.header = new DefaultSampleValues((parseFullAtomFlags & 2) != 0 ? parsableByteArray.readUnsignedIntToInt() - 1 : defaultSampleValues.sampleDescriptionIndex, (parseFullAtomFlags & 8) != 0 ? parsableByteArray.readUnsignedIntToInt() : defaultSampleValues.duration, (parseFullAtomFlags & 16) != 0 ? parsableByteArray.readUnsignedIntToInt() : defaultSampleValues.size, (parseFullAtomFlags & 32) != 0 ? parsableByteArray.readUnsignedIntToInt() : defaultSampleValues.flags);
        return trackBundle;
    }

    private static long parseTfdt(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        return Atom.parseFullAtomVersion(parsableByteArray.readInt()) == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
    }

    private static int parseTrun(TrackBundle trackBundle, int i, long j, int i2, ParsableByteArray parsableByteArray, int i3) {
        long j2;
        int readInt;
        parsableByteArray.setPosition(8);
        int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
        Track track = trackBundle.track;
        TrackFragment trackFragment = trackBundle.fragment;
        DefaultSampleValues defaultSampleValues = trackFragment.header;
        trackFragment.trunLength[i] = parsableByteArray.readUnsignedIntToInt();
        trackFragment.trunDataPosition[i] = trackFragment.dataPosition;
        if ((parseFullAtomFlags & 1) != 0) {
            long[] jArr = trackFragment.trunDataPosition;
            jArr[i] = jArr[i] + parsableByteArray.readInt();
        }
        boolean z = (parseFullAtomFlags & 4) != 0;
        int i4 = defaultSampleValues.flags;
        if (z) {
            i4 = parsableByteArray.readUnsignedIntToInt();
        }
        boolean z2 = (parseFullAtomFlags & 256) != 0;
        boolean z3 = (parseFullAtomFlags & 512) != 0;
        boolean z4 = (parseFullAtomFlags & 1024) != 0;
        boolean z5 = (parseFullAtomFlags & 2048) != 0;
        if (track.editListDurations == null || track.editListDurations.length != 1 || track.editListDurations[0] != 0) {
            j2 = 0;
        } else {
            j2 = Util.scaleLargeTimestamp(track.editListMediaTimes[0], 1000L, track.timescale);
        }
        int[] iArr = trackFragment.sampleSizeTable;
        int[] iArr2 = trackFragment.sampleCompositionTimeOffsetTable;
        long[] jArr2 = trackFragment.sampleDecodingTimeTable;
        boolean[] zArr = trackFragment.sampleIsSyncFrameTable;
        boolean z6 = track.type == 2 && (i2 & 1) != 0;
        int i5 = i3 + trackFragment.trunLength[i];
        long j3 = track.timescale;
        if (i > 0) {
            j = trackFragment.nextFragmentDecodeTime;
        }
        long j4 = j;
        while (i3 < i5) {
            int readUnsignedIntToInt = z2 ? parsableByteArray.readUnsignedIntToInt() : defaultSampleValues.duration;
            int readUnsignedIntToInt2 = z3 ? parsableByteArray.readUnsignedIntToInt() : defaultSampleValues.size;
            if (i3 == 0 && z) {
                readInt = i4;
            } else {
                readInt = z4 ? parsableByteArray.readInt() : defaultSampleValues.flags;
            }
            if (z5) {
                iArr2[i3] = (int) ((parsableByteArray.readInt() * 1000) / j3);
            } else {
                iArr2[i3] = 0;
            }
            jArr2[i3] = Util.scaleLargeTimestamp(j4, 1000L, j3) - j2;
            iArr[i3] = readUnsignedIntToInt2;
            zArr[i3] = ((readInt >> 16) & 1) == 0 && (!z6 || i3 == 0);
            j4 += readUnsignedIntToInt;
            i3++;
        }
        trackFragment.nextFragmentDecodeTime = j4;
        return i5;
    }

    private static void parseUuid(ParsableByteArray parsableByteArray, TrackFragment trackFragment, byte[] bArr) throws ParserException {
        parsableByteArray.setPosition(8);
        parsableByteArray.readBytes(bArr, 0, 16);
        if (Arrays.equals(bArr, PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE)) {
            parseSenc(parsableByteArray, 16, trackFragment);
        }
    }

    private static void parseSenc(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        parseSenc(parsableByteArray, 0, trackFragment);
    }

    private static void parseSenc(ParsableByteArray parsableByteArray, int i, TrackFragment trackFragment) throws ParserException {
        parsableByteArray.setPosition(i + 8);
        int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
        if ((parseFullAtomFlags & 1) != 0) {
            throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (parseFullAtomFlags & 2) != 0;
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (readUnsignedIntToInt != trackFragment.sampleCount) {
            throw new ParserException("Length mismatch: " + readUnsignedIntToInt + ", " + trackFragment.sampleCount);
        }
        Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, readUnsignedIntToInt, z);
        trackFragment.initEncryptionData(parsableByteArray.bytesLeft());
        trackFragment.fillEncryptionData(parsableByteArray);
    }

    private static void parseSgpd(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, TrackFragment trackFragment) throws ParserException {
        parsableByteArray.setPosition(8);
        int readInt = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == SAMPLE_GROUP_TYPE_seig) {
            if (Atom.parseFullAtomVersion(readInt) == 1) {
                parsableByteArray.skipBytes(4);
            }
            if (parsableByteArray.readInt() != 1) {
                throw new ParserException("Entry count in sbgp != 1 (unsupported).");
            }
            parsableByteArray2.setPosition(8);
            int readInt2 = parsableByteArray2.readInt();
            if (parsableByteArray2.readInt() == SAMPLE_GROUP_TYPE_seig) {
                int parseFullAtomVersion = Atom.parseFullAtomVersion(readInt2);
                if (parseFullAtomVersion == 1) {
                    if (parsableByteArray2.readUnsignedInt() == 0) {
                        throw new ParserException("Variable length decription in sgpd found (unsupported)");
                    }
                } else if (parseFullAtomVersion >= 2) {
                    parsableByteArray2.skipBytes(4);
                }
                if (parsableByteArray2.readUnsignedInt() != 1) {
                    throw new ParserException("Entry count in sgpd != 1 (unsupported).");
                }
                parsableByteArray2.skipBytes(2);
                boolean z = parsableByteArray2.readUnsignedByte() == 1;
                if (z) {
                    int readUnsignedByte = parsableByteArray2.readUnsignedByte();
                    byte[] bArr = new byte[16];
                    parsableByteArray2.readBytes(bArr, 0, bArr.length);
                    trackFragment.definesEncryptionData = true;
                    trackFragment.trackEncryptionBox = new TrackEncryptionBox(z, readUnsignedByte, bArr);
                }
            }
        }
    }

    private static ChunkIndex parseSidx(ParsableByteArray parsableByteArray, long j) throws ParserException {
        long readUnsignedLongToLong;
        long j2;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(4);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if (parseFullAtomVersion == 0) {
            long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
            readUnsignedLongToLong = parsableByteArray.readUnsignedInt() + j;
            j2 = readUnsignedInt2;
        } else {
            long readUnsignedLongToLong2 = parsableByteArray.readUnsignedLongToLong();
            readUnsignedLongToLong = parsableByteArray.readUnsignedLongToLong() + j;
            j2 = readUnsignedLongToLong2;
        }
        parsableByteArray.skipBytes(2);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int[] iArr = new int[readUnsignedShort];
        long[] jArr = new long[readUnsignedShort];
        long[] jArr2 = new long[readUnsignedShort];
        long[] jArr3 = new long[readUnsignedShort];
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(j2, C.MICROS_PER_SECOND, readUnsignedInt);
        int i = 0;
        long j3 = readUnsignedLongToLong;
        while (true) {
            int i2 = i;
            long j4 = j2;
            long j5 = scaleLargeTimestamp;
            if (i2 < readUnsignedShort) {
                int readInt = parsableByteArray.readInt();
                if ((Integer.MIN_VALUE & readInt) != 0) {
                    throw new ParserException("Unhandled indirect reference");
                }
                long readUnsignedInt3 = parsableByteArray.readUnsignedInt();
                iArr[i2] = readInt & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                jArr[i2] = j3;
                jArr3[i2] = j5;
                j2 = j4 + readUnsignedInt3;
                scaleLargeTimestamp = Util.scaleLargeTimestamp(j2, C.MICROS_PER_SECOND, readUnsignedInt);
                jArr2[i2] = scaleLargeTimestamp - jArr3[i2];
                parsableByteArray.skipBytes(4);
                j3 += iArr[i2];
                i = i2 + 1;
            } else {
                return new ChunkIndex(iArr, jArr, jArr2, jArr3);
            }
        }
    }

    private void readEncryptionData(ExtractorInput extractorInput) throws IOException, InterruptedException {
        long j;
        TrackBundle trackBundle;
        TrackBundle trackBundle2 = null;
        long j2 = Long.MAX_VALUE;
        int size = this.trackBundles.size();
        int i = 0;
        while (i < size) {
            TrackFragment trackFragment = this.trackBundles.valueAt(i).fragment;
            if (!trackFragment.sampleEncryptionDataNeedsFill || trackFragment.auxiliaryDataPosition >= j2) {
                j = j2;
                trackBundle = trackBundle2;
            } else {
                j = trackFragment.auxiliaryDataPosition;
                trackBundle = this.trackBundles.valueAt(i);
            }
            i++;
            trackBundle2 = trackBundle;
            j2 = j;
        }
        if (trackBundle2 == null) {
            this.parserState = 3;
            return;
        }
        int position = (int) (j2 - extractorInput.getPosition());
        if (position < 0) {
            throw new ParserException("Offset to encryption data was negative.");
        }
        extractorInput.skipFully(position);
        trackBundle2.fragment.fillEncryptionData(extractorInput);
    }

    private boolean readSample(ExtractorInput extractorInput) throws IOException, InterruptedException {
        byte[] bArr;
        if (this.parserState == 3) {
            if (this.currentTrackBundle == null) {
                TrackBundle nextFragmentRun = getNextFragmentRun(this.trackBundles);
                if (nextFragmentRun == null) {
                    int position = (int) (this.endOfMdatPosition - extractorInput.getPosition());
                    if (position < 0) {
                        throw new ParserException("Offset to end of mdat was negative.");
                    }
                    extractorInput.skipFully(position);
                    enterReadingAtomHeaderState();
                    return false;
                }
                long j = nextFragmentRun.fragment.trunDataPosition[nextFragmentRun.currentTrackRunIndex];
                int position2 = (int) (j - extractorInput.getPosition());
                if (position2 < 0) {
                    if (j == nextFragmentRun.fragment.atomPosition) {
                        Log.w(TAG, "Offset to sample data was missing.");
                        position2 = 0;
                    } else {
                        throw new ParserException("Offset to sample data was negative.");
                    }
                }
                extractorInput.skipFully(position2);
                this.currentTrackBundle = nextFragmentRun;
            }
            this.sampleSize = this.currentTrackBundle.fragment.sampleSizeTable[this.currentTrackBundle.currentSampleIndex];
            if (this.currentTrackBundle.fragment.definesEncryptionData) {
                this.sampleBytesWritten = appendSampleEncryptionData(this.currentTrackBundle);
                this.sampleSize += this.sampleBytesWritten;
            } else {
                this.sampleBytesWritten = 0;
            }
            if (this.currentTrackBundle.track.sampleTransformation == 1) {
                this.sampleSize -= 8;
                extractorInput.skipFully(8);
            }
            this.parserState = 4;
            this.sampleCurrentNalBytesRemaining = 0;
        }
        TrackFragment trackFragment = this.currentTrackBundle.fragment;
        Track track = this.currentTrackBundle.track;
        TrackOutput trackOutput = this.currentTrackBundle.output;
        int i = this.currentTrackBundle.currentSampleIndex;
        if (track.nalUnitLengthFieldLength != 0) {
            byte[] bArr2 = this.nalLength.data;
            bArr2[0] = 0;
            bArr2[1] = 0;
            bArr2[2] = 0;
            int i2 = track.nalUnitLengthFieldLength;
            int i3 = 4 - track.nalUnitLengthFieldLength;
            while (this.sampleBytesWritten < this.sampleSize) {
                if (this.sampleCurrentNalBytesRemaining == 0) {
                    extractorInput.readFully(this.nalLength.data, i3, i2);
                    this.nalLength.setPosition(0);
                    this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
                    this.nalStartCode.setPosition(0);
                    trackOutput.sampleData(this.nalStartCode, 4);
                    this.sampleBytesWritten += 4;
                    this.sampleSize += i3;
                } else {
                    int sampleData = trackOutput.sampleData(extractorInput, this.sampleCurrentNalBytesRemaining, false);
                    this.sampleBytesWritten += sampleData;
                    this.sampleCurrentNalBytesRemaining -= sampleData;
                }
            }
        } else {
            while (this.sampleBytesWritten < this.sampleSize) {
                this.sampleBytesWritten = trackOutput.sampleData(extractorInput, this.sampleSize - this.sampleBytesWritten, false) + this.sampleBytesWritten;
            }
        }
        long samplePresentationTime = 1000 * trackFragment.getSamplePresentationTime(i);
        int i4 = (trackFragment.definesEncryptionData ? 1073741824 : 0) | (trackFragment.sampleIsSyncFrameTable[i] ? 1 : 0);
        int i5 = trackFragment.header.sampleDescriptionIndex;
        if (trackFragment.definesEncryptionData) {
            bArr = trackFragment.trackEncryptionBox != null ? trackFragment.trackEncryptionBox.keyId : track.sampleDescriptionEncryptionBoxes[i5].keyId;
        } else {
            bArr = null;
        }
        trackOutput.sampleMetadata(this.timestampAdjuster != null ? this.timestampAdjuster.adjustSampleTimestamp(samplePresentationTime) : samplePresentationTime, i4, this.sampleSize, 0, bArr);
        this.currentTrackBundle.currentSampleIndex++;
        this.currentTrackBundle.currentSampleInTrackRun++;
        if (this.currentTrackBundle.currentSampleInTrackRun == trackFragment.trunLength[this.currentTrackBundle.currentTrackRunIndex]) {
            this.currentTrackBundle.currentTrackRunIndex++;
            this.currentTrackBundle.currentSampleInTrackRun = 0;
            this.currentTrackBundle = null;
        }
        this.parserState = 3;
        return true;
    }

    private static TrackBundle getNextFragmentRun(SparseArray<TrackBundle> sparseArray) {
        TrackBundle trackBundle;
        long j;
        TrackBundle trackBundle2 = null;
        long j2 = Long.MAX_VALUE;
        int size = sparseArray.size();
        int i = 0;
        while (i < size) {
            TrackBundle valueAt = sparseArray.valueAt(i);
            if (valueAt.currentTrackRunIndex == valueAt.fragment.trunCount) {
                long j3 = j2;
                trackBundle = trackBundle2;
                j = j3;
            } else {
                long j4 = valueAt.fragment.trunDataPosition[valueAt.currentTrackRunIndex];
                if (j4 < j2) {
                    trackBundle = valueAt;
                    j = j4;
                } else {
                    long j5 = j2;
                    trackBundle = trackBundle2;
                    j = j5;
                }
            }
            i++;
            trackBundle2 = trackBundle;
            j2 = j;
        }
        return trackBundle2;
    }

    private int appendSampleEncryptionData(TrackBundle trackBundle) {
        TrackFragment trackFragment = trackBundle.fragment;
        ParsableByteArray parsableByteArray = trackFragment.sampleEncryptionData;
        int i = (trackFragment.trackEncryptionBox != null ? trackFragment.trackEncryptionBox : trackBundle.track.sampleDescriptionEncryptionBoxes[trackFragment.header.sampleDescriptionIndex]).initializationVectorSize;
        boolean z = trackFragment.sampleHasSubsampleEncryptionTable[trackBundle.currentSampleIndex];
        this.encryptionSignalByte.data[0] = (byte) ((z ? 128 : 0) | i);
        this.encryptionSignalByte.setPosition(0);
        TrackOutput trackOutput = trackBundle.output;
        trackOutput.sampleData(this.encryptionSignalByte, 1);
        trackOutput.sampleData(parsableByteArray, i);
        if (!z) {
            return i + 1;
        }
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(-2);
        int i2 = (readUnsignedShort * 6) + 2;
        trackOutput.sampleData(parsableByteArray, i2);
        return i + 1 + i2;
    }

    private static DrmInitData getDrmInitDataFromAtoms(List<Atom.LeafAtom> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            Atom.LeafAtom leafAtom = list.get(i);
            if (leafAtom.type == Atom.TYPE_pssh) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = leafAtom.data.data;
                UUID parseUuid = PsshAtomUtil.parseUuid(bArr);
                if (parseUuid == null) {
                    Log.w(TAG, "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(parseUuid, MimeTypes.VIDEO_MP4, bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private static boolean shouldParseLeafAtom(int i) {
        return i == Atom.TYPE_hdlr || i == Atom.TYPE_mdhd || i == Atom.TYPE_mvhd || i == Atom.TYPE_sidx || i == Atom.TYPE_stsd || i == Atom.TYPE_tfdt || i == Atom.TYPE_tfhd || i == Atom.TYPE_tkhd || i == Atom.TYPE_trex || i == Atom.TYPE_trun || i == Atom.TYPE_pssh || i == Atom.TYPE_saiz || i == Atom.TYPE_saio || i == Atom.TYPE_senc || i == Atom.TYPE_uuid || i == Atom.TYPE_sbgp || i == Atom.TYPE_sgpd || i == Atom.TYPE_elst || i == Atom.TYPE_mehd;
    }

    private static boolean shouldParseContainerAtom(int i) {
        return i == Atom.TYPE_moov || i == Atom.TYPE_trak || i == Atom.TYPE_mdia || i == Atom.TYPE_minf || i == Atom.TYPE_stbl || i == Atom.TYPE_moof || i == Atom.TYPE_traf || i == Atom.TYPE_mvex || i == Atom.TYPE_edts;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class TrackBundle {
        public int currentSampleInTrackRun;
        public int currentSampleIndex;
        public int currentTrackRunIndex;
        public DefaultSampleValues defaultSampleValues;
        public final TrackFragment fragment = new TrackFragment();
        public final TrackOutput output;
        public Track track;

        public TrackBundle(TrackOutput trackOutput) {
            this.output = trackOutput;
        }

        public void init(Track track, DefaultSampleValues defaultSampleValues) {
            this.track = (Track) Assertions.checkNotNull(track);
            this.defaultSampleValues = (DefaultSampleValues) Assertions.checkNotNull(defaultSampleValues);
            this.output.format(track.format);
            reset();
        }

        public void reset() {
            this.fragment.reset();
            this.currentSampleIndex = 0;
            this.currentTrackRunIndex = 0;
            this.currentSampleInTrackRun = 0;
        }

        public void updateDrmInitData(DrmInitData drmInitData) {
            this.output.format(this.track.format.copyWithDrmInitData(drmInitData));
        }
    }
}

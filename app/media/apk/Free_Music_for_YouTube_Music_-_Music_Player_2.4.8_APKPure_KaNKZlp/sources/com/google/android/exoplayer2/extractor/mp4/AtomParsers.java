package com.google.android.exoplayer2.extractor.mp4;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: classes.dex */
final class AtomParsers {
    private static final String TAG = "AtomParsers";
    private static final int TYPE_vide = Util.getIntegerCodeForString("vide");
    private static final int TYPE_soun = Util.getIntegerCodeForString("soun");
    private static final int TYPE_text = Util.getIntegerCodeForString(MimeTypes.BASE_TYPE_TEXT);
    private static final int TYPE_sbtl = Util.getIntegerCodeForString("sbtl");
    private static final int TYPE_subt = Util.getIntegerCodeForString("subt");
    private static final int TYPE_clcp = Util.getIntegerCodeForString("clcp");
    private static final int TYPE_cenc = Util.getIntegerCodeForString("cenc");

    /* loaded from: classes.dex */
    private interface SampleSizeBox {
        int getSampleCount();

        boolean isFixedSampleSize();

        int readNextSampleSize();
    }

    public static Track parseTrak(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j, DrmInitData drmInitData, boolean z) throws ParserException {
        long scaleLargeTimestamp;
        Atom.ContainerAtom containerAtomOfType = containerAtom.getContainerAtomOfType(Atom.TYPE_mdia);
        int parseHdlr = parseHdlr(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_hdlr).data);
        if (parseHdlr == -1) {
            return null;
        }
        TkhdData parseTkhd = parseTkhd(containerAtom.getLeafAtomOfType(Atom.TYPE_tkhd).data);
        long j2 = j == C.TIME_UNSET ? parseTkhd.duration : j;
        long parseMvhd = parseMvhd(leafAtom.data);
        if (j2 == C.TIME_UNSET) {
            scaleLargeTimestamp = C.TIME_UNSET;
        } else {
            scaleLargeTimestamp = Util.scaleLargeTimestamp(j2, C.MICROS_PER_SECOND, parseMvhd);
        }
        Atom.ContainerAtom containerAtomOfType2 = containerAtomOfType.getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl);
        Pair<Long, String> parseMdhd = parseMdhd(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_mdhd).data);
        StsdData parseStsd = parseStsd(containerAtomOfType2.getLeafAtomOfType(Atom.TYPE_stsd).data, parseTkhd.id, parseTkhd.rotationDegrees, (String) parseMdhd.second, drmInitData, z);
        Pair<long[], long[]> parseEdts = parseEdts(containerAtom.getContainerAtomOfType(Atom.TYPE_edts));
        if (parseStsd.format == null) {
            return null;
        }
        return new Track(parseTkhd.id, parseHdlr, ((Long) parseMdhd.first).longValue(), parseMvhd, scaleLargeTimestamp, parseStsd.format, parseStsd.requiredSampleTransformation, parseStsd.trackEncryptionBoxes, parseStsd.nalUnitLengthFieldLength, (long[]) parseEdts.first, (long[]) parseEdts.second);
    }

    public static TrackSampleTable parseStbl(Track track, Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder) throws ParserException {
        SampleSizeBox stz2SampleSizeBox;
        int i;
        ParsableByteArray parsableByteArray;
        int i2;
        long[] jArr;
        int[] iArr;
        int i3;
        long[] jArr2;
        int[] iArr2;
        long j;
        boolean z;
        int i4;
        int i5;
        int i6;
        int i7;
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_stsz);
        if (leafAtomOfType != null) {
            stz2SampleSizeBox = new StszSampleSizeBox(leafAtomOfType);
        } else {
            Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_stz2);
            if (leafAtomOfType2 == null) {
                throw new ParserException("Track has no sample table size information");
            }
            stz2SampleSizeBox = new Stz2SampleSizeBox(leafAtomOfType2);
        }
        int sampleCount = stz2SampleSizeBox.getSampleCount();
        if (sampleCount == 0) {
            return new TrackSampleTable(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        boolean z2 = false;
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_stco);
        if (leafAtomOfType3 == null) {
            z2 = true;
            leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_co64);
        }
        ParsableByteArray parsableByteArray2 = leafAtomOfType3.data;
        ParsableByteArray parsableByteArray3 = containerAtom.getLeafAtomOfType(Atom.TYPE_stsc).data;
        ParsableByteArray parsableByteArray4 = containerAtom.getLeafAtomOfType(Atom.TYPE_stts).data;
        Atom.LeafAtom leafAtomOfType4 = containerAtom.getLeafAtomOfType(Atom.TYPE_stss);
        ParsableByteArray parsableByteArray5 = leafAtomOfType4 != null ? leafAtomOfType4.data : null;
        Atom.LeafAtom leafAtomOfType5 = containerAtom.getLeafAtomOfType(Atom.TYPE_ctts);
        ParsableByteArray parsableByteArray6 = leafAtomOfType5 != null ? leafAtomOfType5.data : null;
        ChunkIterator chunkIterator = new ChunkIterator(parsableByteArray3, parsableByteArray2, z2);
        parsableByteArray4.setPosition(12);
        int readUnsignedIntToInt = parsableByteArray4.readUnsignedIntToInt() - 1;
        int readUnsignedIntToInt2 = parsableByteArray4.readUnsignedIntToInt();
        int readUnsignedIntToInt3 = parsableByteArray4.readUnsignedIntToInt();
        int i8 = 0;
        if (parsableByteArray6 != null) {
            parsableByteArray6.setPosition(12);
            i8 = parsableByteArray6.readUnsignedIntToInt();
        }
        if (parsableByteArray5 == null) {
            i = -1;
            parsableByteArray = parsableByteArray5;
            i2 = 0;
        } else {
            parsableByteArray5.setPosition(12);
            int readUnsignedIntToInt4 = parsableByteArray5.readUnsignedIntToInt();
            if (readUnsignedIntToInt4 <= 0) {
                i = -1;
                parsableByteArray = null;
                i2 = readUnsignedIntToInt4;
            } else {
                i = parsableByteArray5.readUnsignedIntToInt() - 1;
                parsableByteArray = parsableByteArray5;
                i2 = readUnsignedIntToInt4;
            }
        }
        if (!(stz2SampleSizeBox.isFixedSampleSize() && MimeTypes.AUDIO_RAW.equals(track.format.sampleMimeType) && readUnsignedIntToInt == 0 && i8 == 0 && i2 == 0)) {
            long[] jArr3 = new long[sampleCount];
            int[] iArr3 = new int[sampleCount];
            long[] jArr4 = new long[sampleCount];
            int[] iArr4 = new int[sampleCount];
            long j2 = 0;
            int i9 = 0;
            int i10 = readUnsignedIntToInt2;
            int i11 = 0;
            int i12 = i2;
            int i13 = 0;
            int i14 = i;
            int i15 = i8;
            long j3 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = readUnsignedIntToInt3;
            int i19 = readUnsignedIntToInt;
            int i20 = i14;
            while (i9 < sampleCount) {
                long j4 = j2;
                int i21 = i17;
                while (i21 == 0) {
                    Assertions.checkState(chunkIterator.moveNext());
                    j4 = chunkIterator.offset;
                    i21 = chunkIterator.numSamples;
                }
                if (parsableByteArray6 != null) {
                    while (i11 == 0 && i15 > 0) {
                        i11 = parsableByteArray6.readUnsignedIntToInt();
                        i13 = parsableByteArray6.readInt();
                        i15--;
                    }
                    i11--;
                }
                jArr3[i9] = j4;
                iArr3[i9] = stz2SampleSizeBox.readNextSampleSize();
                if (iArr3[i9] > i16) {
                    i16 = iArr3[i9];
                }
                jArr4[i9] = i13 + j3;
                iArr4[i9] = parsableByteArray == null ? 1 : 0;
                if (i9 == i20) {
                    iArr4[i9] = 1;
                    int i22 = i12 - 1;
                    if (i22 > 0) {
                        i20 = parsableByteArray.readUnsignedIntToInt() - 1;
                        i12 = i22;
                    } else {
                        i12 = i22;
                    }
                }
                long j5 = i18 + j3;
                int i23 = i10 - 1;
                if (i23 != 0 || i19 <= 0) {
                    int i24 = i18;
                    i6 = i23;
                    i7 = i24;
                } else {
                    i6 = parsableByteArray4.readUnsignedIntToInt();
                    i7 = parsableByteArray4.readUnsignedIntToInt();
                    i19--;
                }
                long j6 = j4 + iArr3[i9];
                int i25 = i21 - 1;
                i9++;
                j2 = j6;
                i10 = i6;
                i18 = i7;
                i17 = i25;
                j3 = j5;
            }
            Assertions.checkArgument(i11 == 0);
            while (i15 > 0) {
                Assertions.checkArgument(parsableByteArray6.readUnsignedIntToInt() == 0);
                parsableByteArray6.readInt();
                i15--;
            }
            if (i12 != 0 || i10 != 0 || i17 != 0 || i19 != 0) {
                Log.w(TAG, "Inconsistent stbl box for track " + track.id + ": remainingSynchronizationSamples " + i12 + ", remainingSamplesAtTimestampDelta " + i10 + ", remainingSamplesInChunk " + i17 + ", remainingTimestampDeltaChanges " + i19);
            }
            iArr2 = iArr4;
            jArr2 = jArr4;
            i3 = i16;
            iArr = iArr3;
            jArr = jArr3;
            j = j3;
        } else {
            long[] jArr5 = new long[chunkIterator.length];
            int[] iArr5 = new int[chunkIterator.length];
            while (chunkIterator.moveNext()) {
                jArr5[chunkIterator.index] = chunkIterator.offset;
                iArr5[chunkIterator.index] = chunkIterator.numSamples;
            }
            FixedSampleSizeRechunker.Results rechunk = FixedSampleSizeRechunker.rechunk(stz2SampleSizeBox.readNextSampleSize(), jArr5, iArr5, readUnsignedIntToInt3);
            jArr = rechunk.offsets;
            iArr = rechunk.sizes;
            i3 = rechunk.maximumSize;
            jArr2 = rechunk.timestamps;
            iArr2 = rechunk.flags;
            j = 0;
        }
        if (track.editListDurations == null || gaplessInfoHolder.hasGaplessInfo()) {
            Util.scaleLargeTimestampsInPlace(jArr2, C.MICROS_PER_SECOND, track.timescale);
            return new TrackSampleTable(jArr, iArr, i3, jArr2, iArr2);
        }
        if (track.editListDurations.length == 1 && track.type == 1 && jArr2.length >= 2) {
            long j7 = track.editListMediaTimes[0];
            long scaleLargeTimestamp = Util.scaleLargeTimestamp(track.editListDurations[0], track.timescale, track.movieTimescale) + j7;
            if (jArr2[0] <= j7 && j7 < jArr2[1] && jArr2[jArr2.length - 1] < scaleLargeTimestamp && scaleLargeTimestamp <= j) {
                long scaleLargeTimestamp2 = Util.scaleLargeTimestamp(j7 - jArr2[0], track.format.sampleRate, track.timescale);
                long scaleLargeTimestamp3 = Util.scaleLargeTimestamp(j - scaleLargeTimestamp, track.format.sampleRate, track.timescale);
                if ((scaleLargeTimestamp2 != 0 || scaleLargeTimestamp3 != 0) && scaleLargeTimestamp2 <= 2147483647L && scaleLargeTimestamp3 <= 2147483647L) {
                    gaplessInfoHolder.encoderDelay = (int) scaleLargeTimestamp2;
                    gaplessInfoHolder.encoderPadding = (int) scaleLargeTimestamp3;
                    Util.scaleLargeTimestampsInPlace(jArr2, C.MICROS_PER_SECOND, track.timescale);
                    return new TrackSampleTable(jArr, iArr, i3, jArr2, iArr2);
                }
            }
        }
        if (track.editListDurations.length == 1 && track.editListDurations[0] == 0) {
            for (int i26 = 0; i26 < jArr2.length; i26++) {
                jArr2[i26] = Util.scaleLargeTimestamp(jArr2[i26] - track.editListMediaTimes[0], C.MICROS_PER_SECOND, track.timescale);
            }
            return new TrackSampleTable(jArr, iArr, i3, jArr2, iArr2);
        }
        int i27 = 0;
        int i28 = 0;
        boolean z3 = false;
        int i29 = 0;
        while (true) {
            z = z3;
            int i30 = i28;
            i4 = i27;
            if (i29 >= track.editListDurations.length) {
                break;
            }
            long j8 = track.editListMediaTimes[i29];
            if (j8 != -1) {
                long scaleLargeTimestamp4 = Util.scaleLargeTimestamp(track.editListDurations[i29], track.timescale, track.movieTimescale);
                int binarySearchCeil = Util.binarySearchCeil(jArr2, j8, true, true);
                i28 = Util.binarySearchCeil(jArr2, scaleLargeTimestamp4 + j8, true, false);
                i27 = i4 + (i28 - binarySearchCeil);
                z3 = (i30 != binarySearchCeil) | z;
            } else {
                z3 = z;
                i28 = i30;
                i27 = i4;
            }
            i29++;
        }
        boolean z4 = z | (i4 != sampleCount);
        long[] jArr6 = z4 ? new long[i4] : jArr;
        int[] iArr6 = z4 ? new int[i4] : iArr;
        int i31 = z4 ? 0 : i3;
        int[] iArr7 = z4 ? new int[i4] : iArr2;
        long[] jArr7 = new long[i4];
        long j9 = 0;
        int i32 = 0;
        int i33 = 0;
        while (true) {
            int i34 = i32;
            long j10 = j9;
            i5 = i31;
            if (i33 >= track.editListDurations.length) {
                break;
            }
            long j11 = track.editListMediaTimes[i33];
            long j12 = track.editListDurations[i33];
            if (j11 != -1) {
                long scaleLargeTimestamp5 = j11 + Util.scaleLargeTimestamp(j12, track.timescale, track.movieTimescale);
                int binarySearchCeil2 = Util.binarySearchCeil(jArr2, j11, true, true);
                int binarySearchCeil3 = Util.binarySearchCeil(jArr2, scaleLargeTimestamp5, true, false);
                if (z4) {
                    int i35 = binarySearchCeil3 - binarySearchCeil2;
                    System.arraycopy(jArr, binarySearchCeil2, jArr6, i34, i35);
                    System.arraycopy(iArr, binarySearchCeil2, iArr6, i34, i35);
                    System.arraycopy(iArr2, binarySearchCeil2, iArr7, i34, i35);
                }
                int i36 = i34;
                for (int i37 = binarySearchCeil2; i37 < binarySearchCeil3; i37++) {
                    jArr7[i36] = Util.scaleLargeTimestamp(jArr2[i37] - j11, C.MICROS_PER_SECOND, track.timescale) + Util.scaleLargeTimestamp(j10, C.MICROS_PER_SECOND, track.movieTimescale);
                    if (z4 && iArr6[i36] > i5) {
                        i5 = iArr[i37];
                    }
                    i36++;
                }
                i31 = i5;
                i32 = i36;
            } else {
                i31 = i5;
                i32 = i34;
            }
            j9 = j12 + j10;
            i33++;
        }
        boolean z5 = false;
        for (int i38 = 0; i38 < iArr7.length && !z5; i38++) {
            z5 |= (iArr7[i38] & 1) != 0;
        }
        if (!z5) {
            throw new ParserException("The edited sample sequence does not contain a sync sample.");
        }
        return new TrackSampleTable(jArr6, iArr6, i5, jArr7, iArr7);
    }

    public static void parseUdta(Atom.LeafAtom leafAtom, boolean z, GaplessInfoHolder gaplessInfoHolder) {
        if (!z) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            parsableByteArray.setPosition(8);
            while (parsableByteArray.bytesLeft() >= 8) {
                int readInt = parsableByteArray.readInt();
                if (parsableByteArray.readInt() == Atom.TYPE_meta) {
                    parsableByteArray.setPosition(parsableByteArray.getPosition() - 8);
                    parsableByteArray.setLimit(readInt + parsableByteArray.getPosition());
                    parseMetaAtom(parsableByteArray, gaplessInfoHolder);
                    return;
                }
                parsableByteArray.skipBytes(readInt - 8);
            }
        }
    }

    private static void parseMetaAtom(ParsableByteArray parsableByteArray, GaplessInfoHolder gaplessInfoHolder) {
        parsableByteArray.skipBytes(12);
        ParsableByteArray parsableByteArray2 = new ParsableByteArray();
        while (parsableByteArray.bytesLeft() >= 8) {
            int readInt = parsableByteArray.readInt() - 8;
            if (parsableByteArray.readInt() == Atom.TYPE_ilst) {
                parsableByteArray2.reset(parsableByteArray.data, parsableByteArray.getPosition() + readInt);
                parsableByteArray2.setPosition(parsableByteArray.getPosition());
                parseIlst(parsableByteArray2, gaplessInfoHolder);
                if (gaplessInfoHolder.hasGaplessInfo()) {
                    return;
                }
            }
            parsableByteArray.skipBytes(readInt);
        }
    }

    private static void parseIlst(ParsableByteArray parsableByteArray, GaplessInfoHolder gaplessInfoHolder) {
        while (parsableByteArray.bytesLeft() > 0) {
            int position = parsableByteArray.getPosition() + parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_DASHES) {
                String str = null;
                String str2 = null;
                String str3 = null;
                while (parsableByteArray.getPosition() < position) {
                    int readInt = parsableByteArray.readInt() - 12;
                    int readInt2 = parsableByteArray.readInt();
                    parsableByteArray.skipBytes(4);
                    if (readInt2 == Atom.TYPE_mean) {
                        str3 = parsableByteArray.readString(readInt);
                    } else if (readInt2 == Atom.TYPE_name) {
                        str2 = parsableByteArray.readString(readInt);
                    } else if (readInt2 == Atom.TYPE_data) {
                        parsableByteArray.skipBytes(4);
                        str = parsableByteArray.readString(readInt - 4);
                    } else {
                        parsableByteArray.skipBytes(readInt);
                    }
                }
                if (str2 != null && str != null && "com.apple.iTunes".equals(str3)) {
                    gaplessInfoHolder.setFromComment(str2, str);
                    return;
                }
            } else {
                parsableByteArray.setPosition(position);
            }
        }
    }

    private static long parseMvhd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        parsableByteArray.skipBytes(Atom.parseFullAtomVersion(parsableByteArray.readInt()) != 0 ? 16 : 8);
        return parsableByteArray.readUnsignedInt();
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        long readUnsignedInt;
        int i;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
        int readInt = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        boolean z = true;
        int position = parsableByteArray.getPosition();
        int i2 = parseFullAtomVersion == 0 ? 4 : 8;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            } else if (parsableByteArray.data[position + i3] != -1) {
                z = false;
                break;
            } else {
                i3++;
            }
        }
        if (z) {
            parsableByteArray.skipBytes(i2);
            readUnsignedInt = -9223372036854775807L;
        } else {
            readUnsignedInt = parseFullAtomVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
            if (readUnsignedInt == 0) {
                readUnsignedInt = -9223372036854775807L;
            }
        }
        parsableByteArray.skipBytes(16);
        int readInt2 = parsableByteArray.readInt();
        int readInt3 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int readInt4 = parsableByteArray.readInt();
        int readInt5 = parsableByteArray.readInt();
        if (readInt2 == 0 && readInt3 == 65536 && readInt4 == (-65536) && readInt5 == 0) {
            i = 90;
        } else if (readInt2 == 0 && readInt3 == (-65536) && readInt4 == 65536 && readInt5 == 0) {
            i = 270;
        } else {
            i = (readInt2 == (-65536) && readInt3 == 0 && readInt4 == 0 && readInt5 == (-65536)) ? 180 : 0;
        }
        return new TkhdData(readInt, readUnsignedInt, i);
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        int readInt = parsableByteArray.readInt();
        if (readInt == TYPE_soun) {
            return 1;
        }
        if (readInt == TYPE_vide) {
            return 2;
        }
        if (readInt == TYPE_text || readInt == TYPE_sbtl || readInt == TYPE_subt || readInt == TYPE_clcp) {
            return 3;
        }
        return -1;
    }

    private static Pair<Long, String> parseMdhd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 4 : 8);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        return Pair.create(Long.valueOf(readUnsignedInt), "" + ((char) (((readUnsignedShort >> 10) & 31) + 96)) + ((char) (((readUnsignedShort >> 5) & 31) + 96)) + ((char) ((readUnsignedShort & 31) + 96)));
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws ParserException {
        parsableByteArray.setPosition(12);
        int readInt = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            int position = parsableByteArray.getPosition();
            int readInt2 = parsableByteArray.readInt();
            Assertions.checkArgument(readInt2 > 0, "childAtomSize should be positive");
            int readInt3 = parsableByteArray.readInt();
            if (readInt3 == Atom.TYPE_avc1 || readInt3 == Atom.TYPE_avc3 || readInt3 == Atom.TYPE_encv || readInt3 == Atom.TYPE_mp4v || readInt3 == Atom.TYPE_hvc1 || readInt3 == Atom.TYPE_hev1 || readInt3 == Atom.TYPE_s263 || readInt3 == Atom.TYPE_vp08 || readInt3 == Atom.TYPE_vp09) {
                parseVideoSampleEntry(parsableByteArray, readInt3, position, readInt2, i, i2, drmInitData, stsdData, i3);
            } else if (readInt3 == Atom.TYPE_mp4a || readInt3 == Atom.TYPE_enca || readInt3 == Atom.TYPE_ac_3 || readInt3 == Atom.TYPE_ec_3 || readInt3 == Atom.TYPE_dtsc || readInt3 == Atom.TYPE_dtse || readInt3 == Atom.TYPE_dtsh || readInt3 == Atom.TYPE_dtsl || readInt3 == Atom.TYPE_samr || readInt3 == Atom.TYPE_sawb || readInt3 == Atom.TYPE_lpcm || readInt3 == Atom.TYPE_sowt) {
                parseAudioSampleEntry(parsableByteArray, readInt3, position, readInt2, i, str, z, drmInitData, stsdData, i3);
            } else if (readInt3 == Atom.TYPE_TTML) {
                stsdData.format = Format.createTextSampleFormat(Integer.toString(i), MimeTypes.APPLICATION_TTML, null, -1, 0, str, drmInitData);
            } else if (readInt3 == Atom.TYPE_tx3g) {
                stsdData.format = Format.createTextSampleFormat(Integer.toString(i), MimeTypes.APPLICATION_TX3G, null, -1, 0, str, drmInitData);
            } else if (readInt3 == Atom.TYPE_wvtt) {
                stsdData.format = Format.createTextSampleFormat(Integer.toString(i), MimeTypes.APPLICATION_MP4VTT, null, -1, 0, str, drmInitData);
            } else if (readInt3 == Atom.TYPE_stpp) {
                stsdData.format = Format.createTextSampleFormat(Integer.toString(i), MimeTypes.APPLICATION_TTML, null, -1, 0, str, drmInitData, 0L);
            } else if (readInt3 == Atom.TYPE_c608) {
                stsdData.format = Format.createTextSampleFormat(Integer.toString(i), MimeTypes.APPLICATION_CEA608, null, -1, 0, str, drmInitData);
                stsdData.requiredSampleTransformation = 1;
            }
            parsableByteArray.setPosition(position + readInt2);
        }
        return stsdData;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0065 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void parseVideoSampleEntry(com.google.android.exoplayer2.util.ParsableByteArray r19, int r20, int r21, int r22, int r23, int r24, com.google.android.exoplayer2.drm.DrmInitData r25, com.google.android.exoplayer2.extractor.mp4.AtomParsers.StsdData r26, int r27) throws com.google.android.exoplayer2.ParserException {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.AtomParsers.parseVideoSampleEntry(com.google.android.exoplayer2.util.ParsableByteArray, int, int, int, int, int, com.google.android.exoplayer2.drm.DrmInitData, com.google.android.exoplayer2.extractor.mp4.AtomParsers$StsdData, int):void");
    }

    private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType;
        if (containerAtom == null || (leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_elst)) == null) {
            return Pair.create(null, null);
        }
        ParsableByteArray parsableByteArray = leafAtomOfType.data;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[readUnsignedIntToInt];
        long[] jArr2 = new long[readUnsignedIntToInt];
        for (int i = 0; i < readUnsignedIntToInt; i++) {
            jArr[i] = parseFullAtomVersion == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            jArr2[i] = parseFullAtomVersion == 1 ? parsableByteArray.readLong() : parsableByteArray.readInt();
            if (parsableByteArray.readShort() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            parsableByteArray.skipBytes(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8);
        return parsableByteArray.readUnsignedIntToInt() / parsableByteArray.readUnsignedIntToInt();
    }

    private static void parseAudioSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, boolean z, DrmInitData drmInitData, StsdData stsdData, int i5) {
        int i6;
        int readUnsignedShort;
        int readUnsignedFixedPoint1616;
        byte[] bArr;
        parsableByteArray.setPosition(i2 + 8);
        if (z) {
            parsableByteArray.skipBytes(8);
            int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
            i6 = readUnsignedShort2;
        } else {
            parsableByteArray.skipBytes(16);
            i6 = 0;
        }
        if (i6 == 0 || i6 == 1) {
            readUnsignedShort = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
            readUnsignedFixedPoint1616 = parsableByteArray.readUnsignedFixedPoint1616();
            if (i6 == 1) {
                parsableByteArray.skipBytes(16);
            }
        } else if (i6 == 2) {
            parsableByteArray.skipBytes(16);
            readUnsignedFixedPoint1616 = (int) Math.round(parsableByteArray.readDouble());
            readUnsignedShort = parsableByteArray.readUnsignedIntToInt();
            parsableByteArray.skipBytes(20);
        } else {
            return;
        }
        int position = parsableByteArray.getPosition();
        if (i == Atom.TYPE_enca) {
            i = parseSampleEntryEncryptionData(parsableByteArray, i2, i3, stsdData, i5);
            parsableByteArray.setPosition(position);
        }
        String str2 = null;
        if (i == Atom.TYPE_ac_3) {
            str2 = MimeTypes.AUDIO_AC3;
        } else if (i == Atom.TYPE_ec_3) {
            str2 = MimeTypes.AUDIO_E_AC3;
        } else if (i == Atom.TYPE_dtsc) {
            str2 = MimeTypes.AUDIO_DTS;
        } else if (i == Atom.TYPE_dtsh || i == Atom.TYPE_dtsl) {
            str2 = MimeTypes.AUDIO_DTS_HD;
        } else if (i == Atom.TYPE_dtse) {
            str2 = MimeTypes.AUDIO_DTS_EXPRESS;
        } else if (i == Atom.TYPE_samr) {
            str2 = MimeTypes.AUDIO_AMR_NB;
        } else if (i == Atom.TYPE_sawb) {
            str2 = MimeTypes.AUDIO_AMR_WB;
        } else if (i == Atom.TYPE_lpcm || i == Atom.TYPE_sowt) {
            str2 = MimeTypes.AUDIO_RAW;
        }
        byte[] bArr2 = null;
        int i7 = readUnsignedFixedPoint1616;
        int i8 = readUnsignedShort;
        String str3 = str2;
        while (position - i2 < i3) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            Assertions.checkArgument(readInt > 0, "childAtomSize should be positive");
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == Atom.TYPE_esds || (z && readInt2 == Atom.TYPE_wave)) {
                int findEsdsPosition = readInt2 == Atom.TYPE_esds ? position : findEsdsPosition(parsableByteArray, position, readInt);
                if (findEsdsPosition != -1) {
                    Pair<String, byte[]> parseEsdsFromParent = parseEsdsFromParent(parsableByteArray, findEsdsPosition);
                    str3 = (String) parseEsdsFromParent.first;
                    bArr = (byte[]) parseEsdsFromParent.second;
                    if (MimeTypes.AUDIO_AAC.equals(str3)) {
                        Pair<Integer, Integer> parseAacAudioSpecificConfig = CodecSpecificDataUtil.parseAacAudioSpecificConfig(bArr);
                        i7 = ((Integer) parseAacAudioSpecificConfig.first).intValue();
                        i8 = ((Integer) parseAacAudioSpecificConfig.second).intValue();
                    }
                } else {
                    bArr = bArr2;
                }
                bArr2 = bArr;
            } else if (readInt2 == Atom.TYPE_dac3) {
                parsableByteArray.setPosition(position + 8);
                stsdData.format = Ac3Util.parseAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitData);
            } else if (readInt2 == Atom.TYPE_dec3) {
                parsableByteArray.setPosition(position + 8);
                stsdData.format = Ac3Util.parseEAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitData);
            } else if (readInt2 == Atom.TYPE_ddts) {
                stsdData.format = Format.createAudioSampleFormat(Integer.toString(i4), str3, null, -1, -1, i8, i7, null, drmInitData, 0, str);
            }
            position += readInt;
        }
        if (stsdData.format == null && str3 != null) {
            stsdData.format = Format.createAudioSampleFormat(Integer.toString(i4), str3, null, -1, -1, i8, i7, MimeTypes.AUDIO_RAW.equals(str3) ? 2 : -1, bArr2 == null ? null : Collections.singletonList(bArr2), drmInitData, 0, str);
        }
    }

    private static int findEsdsPosition(ParsableByteArray parsableByteArray, int i, int i2) {
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            Assertions.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == Atom.TYPE_esds) {
                return position;
            }
            position += readInt;
        }
        return -1;
    }

    private static Pair<String, byte[]> parseEsdsFromParent(ParsableByteArray parsableByteArray, int i) {
        String str = null;
        parsableByteArray.setPosition(i + 8 + 4);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        switch (parsableByteArray.readUnsignedByte()) {
            case 32:
                str = MimeTypes.VIDEO_MP4V;
                break;
            case 33:
                str = MimeTypes.VIDEO_H264;
                break;
            case 35:
                str = MimeTypes.VIDEO_H265;
                break;
            case 64:
            case 102:
            case 103:
            case 104:
                str = MimeTypes.AUDIO_AAC;
                break;
            case 107:
                return Pair.create(MimeTypes.AUDIO_MPEG, null);
            case 165:
                str = MimeTypes.AUDIO_AC3;
                break;
            case 166:
                str = MimeTypes.AUDIO_E_AC3;
                break;
            case 169:
            case 172:
                return Pair.create(MimeTypes.AUDIO_DTS, null);
            case 170:
            case 171:
                return Pair.create(MimeTypes.AUDIO_DTS_HD, null);
        }
        parsableByteArray.skipBytes(12);
        parsableByteArray.skipBytes(1);
        int parseExpandableClassSize = parseExpandableClassSize(parsableByteArray);
        byte[] bArr = new byte[parseExpandableClassSize];
        parsableByteArray.readBytes(bArr, 0, parseExpandableClassSize);
        return Pair.create(str, bArr);
    }

    private static int parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i, int i2, StsdData stsdData, int i3) {
        Pair<Integer, TrackEncryptionBox> parseSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (true) {
            int i4 = position;
            if (i4 - i >= i2) {
                return 0;
            }
            parsableByteArray.setPosition(i4);
            int readInt = parsableByteArray.readInt();
            Assertions.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == Atom.TYPE_sinf && (parseSinfFromParent = parseSinfFromParent(parsableByteArray, i4, readInt)) != null) {
                stsdData.trackEncryptionBoxes[i3] = (TrackEncryptionBox) parseSinfFromParent.second;
                return ((Integer) parseSinfFromParent.first).intValue();
            }
            position = i4 + readInt;
        }
    }

    private static Pair<Integer, TrackEncryptionBox> parseSinfFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        TrackEncryptionBox trackEncryptionBox = null;
        boolean z = false;
        int i3 = i + 8;
        Integer num = null;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == Atom.TYPE_frma) {
                num = Integer.valueOf(parsableByteArray.readInt());
            } else if (readInt2 == Atom.TYPE_schm) {
                parsableByteArray.skipBytes(4);
                z = parsableByteArray.readInt() == TYPE_cenc;
            } else if (readInt2 == Atom.TYPE_schi) {
                trackEncryptionBox = parseSchiFromParent(parsableByteArray, i3, readInt);
            }
            i3 += readInt;
        }
        if (z) {
            Assertions.checkArgument(num != null, "frma atom is mandatory");
            Assertions.checkArgument(trackEncryptionBox != null, "schi->tenc atom is mandatory");
            return Pair.create(num, trackEncryptionBox);
        }
        return null;
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_tenc) {
                parsableByteArray.skipBytes(6);
                boolean z = parsableByteArray.readUnsignedByte() == 1;
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                byte[] bArr = new byte[16];
                parsableByteArray.readBytes(bArr, 0, bArr.length);
                return new TrackEncryptionBox(z, readUnsignedByte, bArr);
            }
            i3 += readInt;
        }
        return null;
    }

    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_proj) {
                return Arrays.copyOfRange(parsableByteArray.data, i3, readInt + i3);
            }
            i3 += readInt;
        }
        return null;
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = parsableByteArray.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & 127);
        }
        return i;
    }

    private AtomParsers() {
    }

    /* loaded from: classes.dex */
    private static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            Assertions.checkState(parsableByteArray.readInt() == 1, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            int i = this.index + 1;
            this.index = i;
            if (i == this.length) {
                return false;
            }
            this.offset = this.chunkOffsetsAreLongs ? this.chunkOffsets.readUnsignedLongToLong() : this.chunkOffsets.readUnsignedInt();
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int i2 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i2;
                this.nextSamplesPerChunkChangeIndex = i2 > 0 ? this.stsc.readUnsignedIntToInt() - 1 : -1;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class TkhdData {
        private final long duration;
        private final int id;
        private final int rotationDegrees;

        public TkhdData(int i, long j, int i2) {
            this.id = i;
            this.duration = j;
            this.rotationDegrees = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class StsdData {
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i];
        }
    }

    /* loaded from: classes.dex */
    static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize;
        private final int sampleCount;

        public StszSampleSizeBox(Atom.LeafAtom leafAtom) {
            this.data = leafAtom.data;
            this.data.setPosition(12);
            this.fixedSampleSize = this.data.readUnsignedIntToInt();
            this.sampleCount = this.data.readUnsignedIntToInt();
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            return this.fixedSampleSize == 0 ? this.data.readUnsignedIntToInt() : this.fixedSampleSize;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public boolean isFixedSampleSize() {
            return this.fixedSampleSize != 0;
        }
    }

    /* loaded from: classes.dex */
    static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize;
        private final int sampleCount;
        private int sampleIndex;

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            this.data = leafAtom.data;
            this.data.setPosition(12);
            this.fieldSize = this.data.readUnsignedIntToInt() & 255;
            this.sampleCount = this.data.readUnsignedIntToInt();
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            if (this.fieldSize == 8) {
                return this.data.readUnsignedByte();
            }
            if (this.fieldSize == 16) {
                return this.data.readUnsignedShort();
            }
            int i = this.sampleIndex;
            this.sampleIndex = i + 1;
            if (i % 2 == 0) {
                this.currentByte = this.data.readUnsignedByte();
                return (this.currentByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
            }
            return this.currentByte & 15;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public boolean isFixedSampleSize() {
            return false;
        }
    }
}

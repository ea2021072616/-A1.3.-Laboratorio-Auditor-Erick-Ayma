package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import java.io.EOFException;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class DefaultOggSeeker implements OggSeeker {
    private static final int DEFAULT_OFFSET = 30000;
    public static final int MATCH_BYTE_RANGE = 100000;
    public static final int MATCH_RANGE = 72000;
    private static final int STATE_IDLE = 3;
    private static final int STATE_READ_LAST_PAGE = 1;
    private static final int STATE_SEEK = 2;
    private static final int STATE_SEEK_TO_END = 0;
    private long end;
    private long endGranule;
    private final long endPosition;
    private final OggPageHeader pageHeader = new OggPageHeader();
    private long positionBeforeSeekToEnd;
    private volatile long queriedGranule;
    private long start;
    private long startGranule;
    private final long startPosition;
    private int state;
    private final StreamReader streamReader;
    private long targetGranule;
    private long totalGranules;

    public DefaultOggSeeker(long j, long j2, StreamReader streamReader) {
        Assertions.checkArgument(j >= 0 && j2 > j);
        this.streamReader = streamReader;
        this.startPosition = j;
        this.endPosition = j2;
        this.state = 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public long read(ExtractorInput extractorInput) throws IOException, InterruptedException {
        long j = 0;
        switch (this.state) {
            case 0:
                this.positionBeforeSeekToEnd = extractorInput.getPosition();
                this.state = 1;
                long j2 = this.endPosition - 65307;
                if (j2 > this.positionBeforeSeekToEnd) {
                    return j2;
                }
                break;
            case 1:
                break;
            case 2:
                if (this.targetGranule != 0) {
                    long nextSeekPosition = getNextSeekPosition(this.targetGranule, extractorInput);
                    if (nextSeekPosition >= 0) {
                        return nextSeekPosition;
                    }
                    j = skipToPageOfGranule(extractorInput, this.targetGranule, -(nextSeekPosition + 2));
                }
                this.state = 3;
                return -(j + 2);
            case 3:
                return -1L;
            default:
                throw new IllegalStateException();
        }
        this.totalGranules = readGranuleOfLastPage(extractorInput);
        this.state = 3;
        return this.positionBeforeSeekToEnd;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public long startSeek() {
        Assertions.checkArgument(this.state == 3 || this.state == 2);
        this.targetGranule = this.queriedGranule;
        this.state = 2;
        resetSeeking();
        return this.targetGranule;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public OggSeekMap createSeekMap() {
        if (this.totalGranules != 0) {
            return new OggSeekMap();
        }
        return null;
    }

    public void resetSeeking() {
        this.start = this.startPosition;
        this.end = this.endPosition;
        this.startGranule = 0L;
        this.endGranule = this.totalGranules;
    }

    public long getNextSeekPosition(long j, ExtractorInput extractorInput) throws IOException, InterruptedException {
        if (this.start == this.end) {
            return -(this.startGranule + 2);
        }
        long position = extractorInput.getPosition();
        if (!skipToNextPage(extractorInput, this.end)) {
            if (this.start == position) {
                throw new IOException("No ogg page can be found.");
            }
            return this.start;
        }
        this.pageHeader.populate(extractorInput, false);
        extractorInput.resetPeekPosition();
        long j2 = j - this.pageHeader.granulePosition;
        int i = this.pageHeader.headerSize + this.pageHeader.bodySize;
        if (j2 < 0 || j2 > 72000) {
            if (j2 < 0) {
                this.end = position;
                this.endGranule = this.pageHeader.granulePosition;
            } else {
                this.start = extractorInput.getPosition() + i;
                this.startGranule = this.pageHeader.granulePosition;
                if ((this.end - this.start) + i < 100000) {
                    extractorInput.skipFully(i);
                    return -(this.startGranule + 2);
                }
            }
            if (this.end - this.start < 100000) {
                this.end = this.start;
                return this.start;
            }
            return Math.min(Math.max((extractorInput.getPosition() - ((j2 <= 0 ? 2 : 1) * i)) + ((j2 * (this.end - this.start)) / (this.endGranule - this.startGranule)), this.start), this.end - 1);
        }
        extractorInput.skipFully(i);
        return -(this.pageHeader.granulePosition + 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getEstimatedPosition(long j, long j2, long j3) {
        long j4 = ((((this.endPosition - this.startPosition) * j2) / this.totalGranules) - j3) + j;
        if (j4 < this.startPosition) {
            j4 = this.startPosition;
        }
        if (j4 >= this.endPosition) {
            return this.endPosition - 1;
        }
        return j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class OggSeekMap implements SeekMap {
        private OggSeekMap() {
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return true;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getPosition(long j) {
            if (j == 0) {
                DefaultOggSeeker.this.queriedGranule = 0L;
                return DefaultOggSeeker.this.startPosition;
            }
            DefaultOggSeeker.this.queriedGranule = DefaultOggSeeker.this.streamReader.convertTimeToGranule(j);
            return DefaultOggSeeker.this.getEstimatedPosition(DefaultOggSeeker.this.startPosition, DefaultOggSeeker.this.queriedGranule, 30000L);
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return DefaultOggSeeker.this.streamReader.convertGranuleToTime(DefaultOggSeeker.this.totalGranules);
        }
    }

    void skipToNextPage(ExtractorInput extractorInput) throws IOException, InterruptedException {
        if (!skipToNextPage(extractorInput, this.endPosition)) {
            throw new EOFException();
        }
    }

    boolean skipToNextPage(ExtractorInput extractorInput, long j) throws IOException, InterruptedException {
        long min = Math.min(3 + j, this.endPosition);
        byte[] bArr = new byte[2048];
        int length = bArr.length;
        while (true) {
            if (extractorInput.getPosition() + length > min && (length = (int) (min - extractorInput.getPosition())) < 4) {
                return false;
            }
            extractorInput.peekFully(bArr, 0, length, false);
            for (int i = 0; i < length - 3; i++) {
                if (bArr[i] == 79 && bArr[i + 1] == 103 && bArr[i + 2] == 103 && bArr[i + 3] == 83) {
                    extractorInput.skipFully(i);
                    return true;
                }
            }
            extractorInput.skipFully(length - 3);
        }
    }

    long readGranuleOfLastPage(ExtractorInput extractorInput) throws IOException, InterruptedException {
        skipToNextPage(extractorInput);
        this.pageHeader.reset();
        while ((this.pageHeader.type & 4) != 4 && extractorInput.getPosition() < this.endPosition) {
            this.pageHeader.populate(extractorInput, false);
            extractorInput.skipFully(this.pageHeader.headerSize + this.pageHeader.bodySize);
        }
        return this.pageHeader.granulePosition;
    }

    long skipToPageOfGranule(ExtractorInput extractorInput, long j, long j2) throws IOException, InterruptedException {
        this.pageHeader.populate(extractorInput, false);
        while (this.pageHeader.granulePosition < j) {
            extractorInput.skipFully(this.pageHeader.headerSize + this.pageHeader.bodySize);
            j2 = this.pageHeader.granulePosition;
            this.pageHeader.populate(extractorInput, false);
        }
        extractorInput.resetPeekPosition();
        return j2;
    }
}

package com.google.android.exoplayer2.extractor.flv;

import android.support.v7.widget.helper.ItemTouchHelper;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
/* loaded from: classes.dex */
public final class FlvExtractor implements Extractor, SeekMap {
    private static final int FLV_HEADER_SIZE = 9;
    private static final int FLV_TAG_HEADER_SIZE = 11;
    private static final int STATE_READING_FLV_HEADER = 1;
    private static final int STATE_READING_TAG_DATA = 4;
    private static final int STATE_READING_TAG_HEADER = 3;
    private static final int STATE_SKIPPING_TO_TAG_HEADER = 2;
    private static final int TAG_TYPE_AUDIO = 8;
    private static final int TAG_TYPE_SCRIPT_DATA = 18;
    private static final int TAG_TYPE_VIDEO = 9;
    private AudioTagPayloadReader audioReader;
    private int bytesToNextTagHeader;
    private ExtractorOutput extractorOutput;
    private ScriptTagPayloadReader metadataReader;
    public int tagDataSize;
    public long tagTimestampUs;
    public int tagType;
    private VideoTagPayloadReader videoReader;
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.flv.FlvExtractor.1
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public Extractor[] createExtractors() {
            return new Extractor[]{new FlvExtractor()};
        }
    };
    private static final int FLV_TAG = Util.getIntegerCodeForString("FLV");
    private final ParsableByteArray scratch = new ParsableByteArray(4);
    private final ParsableByteArray headerBuffer = new ParsableByteArray(9);
    private final ParsableByteArray tagHeaderBuffer = new ParsableByteArray(11);
    private final ParsableByteArray tagData = new ParsableByteArray();
    private int parserState = 1;

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        extractorInput.peekFully(this.scratch.data, 0, 3);
        this.scratch.setPosition(0);
        if (this.scratch.readUnsignedInt24() != FLV_TAG) {
            return false;
        }
        extractorInput.peekFully(this.scratch.data, 0, 2);
        this.scratch.setPosition(0);
        if ((this.scratch.readUnsignedShort() & ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) == 0) {
            extractorInput.peekFully(this.scratch.data, 0, 4);
            this.scratch.setPosition(0);
            int readInt = this.scratch.readInt();
            extractorInput.resetPeekPosition();
            extractorInput.advancePeekPosition(readInt);
            extractorInput.peekFully(this.scratch.data, 0, 4);
            this.scratch.setPosition(0);
            return this.scratch.readInt() == 0;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j) {
        this.parserState = 1;
        this.bytesToNextTagHeader = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        while (true) {
            switch (this.parserState) {
                case 1:
                    if (readFlvHeader(extractorInput)) {
                        break;
                    } else {
                        return -1;
                    }
                case 2:
                    skipToTagHeader(extractorInput);
                    break;
                case 3:
                    if (readTagHeader(extractorInput)) {
                        break;
                    } else {
                        return -1;
                    }
                case 4:
                    if (!readTagData(extractorInput)) {
                        break;
                    } else {
                        return 0;
                    }
            }
        }
    }

    private boolean readFlvHeader(ExtractorInput extractorInput) throws IOException, InterruptedException {
        if (extractorInput.readFully(this.headerBuffer.data, 0, 9, true)) {
            this.headerBuffer.setPosition(0);
            this.headerBuffer.skipBytes(4);
            int readUnsignedByte = this.headerBuffer.readUnsignedByte();
            boolean z = (readUnsignedByte & 4) != 0;
            boolean z2 = (readUnsignedByte & 1) != 0;
            if (z && this.audioReader == null) {
                this.audioReader = new AudioTagPayloadReader(this.extractorOutput.track(8));
            }
            if (z2 && this.videoReader == null) {
                this.videoReader = new VideoTagPayloadReader(this.extractorOutput.track(9));
            }
            if (this.metadataReader == null) {
                this.metadataReader = new ScriptTagPayloadReader(null);
            }
            this.extractorOutput.endTracks();
            this.extractorOutput.seekMap(this);
            this.bytesToNextTagHeader = (this.headerBuffer.readInt() - 9) + 4;
            this.parserState = 2;
            return true;
        }
        return false;
    }

    private void skipToTagHeader(ExtractorInput extractorInput) throws IOException, InterruptedException {
        extractorInput.skipFully(this.bytesToNextTagHeader);
        this.bytesToNextTagHeader = 0;
        this.parserState = 3;
    }

    private boolean readTagHeader(ExtractorInput extractorInput) throws IOException, InterruptedException {
        if (extractorInput.readFully(this.tagHeaderBuffer.data, 0, 11, true)) {
            this.tagHeaderBuffer.setPosition(0);
            this.tagType = this.tagHeaderBuffer.readUnsignedByte();
            this.tagDataSize = this.tagHeaderBuffer.readUnsignedInt24();
            this.tagTimestampUs = this.tagHeaderBuffer.readUnsignedInt24();
            this.tagTimestampUs = ((this.tagHeaderBuffer.readUnsignedByte() << 24) | this.tagTimestampUs) * 1000;
            this.tagHeaderBuffer.skipBytes(3);
            this.parserState = 4;
            return true;
        }
        return false;
    }

    private boolean readTagData(ExtractorInput extractorInput) throws IOException, InterruptedException {
        boolean z = true;
        if (this.tagType == 8 && this.audioReader != null) {
            this.audioReader.consume(prepareTagData(extractorInput), this.tagTimestampUs);
        } else if (this.tagType == 9 && this.videoReader != null) {
            this.videoReader.consume(prepareTagData(extractorInput), this.tagTimestampUs);
        } else if (this.tagType == 18 && this.metadataReader != null) {
            this.metadataReader.consume(prepareTagData(extractorInput), this.tagTimestampUs);
        } else {
            extractorInput.skipFully(this.tagDataSize);
            z = false;
        }
        this.bytesToNextTagHeader = 4;
        this.parserState = 2;
        return z;
    }

    private ParsableByteArray prepareTagData(ExtractorInput extractorInput) throws IOException, InterruptedException {
        if (this.tagDataSize > this.tagData.capacity()) {
            this.tagData.reset(new byte[Math.max(this.tagData.capacity() * 2, this.tagDataSize)], 0);
        } else {
            this.tagData.setPosition(0);
        }
        this.tagData.setLimit(this.tagDataSize);
        extractorInput.readFully(this.tagData.data, 0, this.tagDataSize);
        return this.tagData;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.metadataReader.getDurationUs();
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getPosition(long j) {
        return 0L;
    }
}

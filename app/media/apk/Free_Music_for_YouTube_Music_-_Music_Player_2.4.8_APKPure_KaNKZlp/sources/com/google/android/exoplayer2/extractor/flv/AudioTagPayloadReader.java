package com.google.android.exoplayer2.extractor.flv;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
/* loaded from: classes.dex */
final class AudioTagPayloadReader extends TagPayloadReader {
    private static final int AAC_PACKET_TYPE_AAC_RAW = 1;
    private static final int AAC_PACKET_TYPE_SEQUENCE_HEADER = 0;
    private static final int AUDIO_FORMAT_AAC = 10;
    private static final int[] AUDIO_SAMPLING_RATE_TABLE = {5500, 11000, 22000, 44000};
    private boolean hasOutputFormat;
    private boolean hasParsedAudioDataHeader;

    public AudioTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void seek() {
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean parseHeader(ParsableByteArray parsableByteArray) throws TagPayloadReader.UnsupportedFormatException {
        if (!this.hasParsedAudioDataHeader) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            int i = (readUnsignedByte >> 4) & 15;
            int i2 = (readUnsignedByte >> 2) & 3;
            if (i2 < 0 || i2 >= AUDIO_SAMPLING_RATE_TABLE.length) {
                throw new TagPayloadReader.UnsupportedFormatException("Invalid sample rate index: " + i2);
            }
            if (i != 10) {
                throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + i);
            }
            this.hasParsedAudioDataHeader = true;
        } else {
            parsableByteArray.skipBytes(1);
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected void parsePayload(ParsableByteArray parsableByteArray, long j) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if (readUnsignedByte == 0 && !this.hasOutputFormat) {
            byte[] bArr = new byte[parsableByteArray.bytesLeft()];
            parsableByteArray.readBytes(bArr, 0, bArr.length);
            Pair<Integer, Integer> parseAacAudioSpecificConfig = CodecSpecificDataUtil.parseAacAudioSpecificConfig(bArr);
            this.output.format(Format.createAudioSampleFormat(null, MimeTypes.AUDIO_AAC, null, -1, -1, ((Integer) parseAacAudioSpecificConfig.second).intValue(), ((Integer) parseAacAudioSpecificConfig.first).intValue(), Collections.singletonList(bArr), null, 0, null));
            this.hasOutputFormat = true;
        } else if (readUnsignedByte == 1) {
            int bytesLeft = parsableByteArray.bytesLeft();
            this.output.sampleData(parsableByteArray, bytesLeft);
            this.output.sampleMetadata(j, 1, bytesLeft, 0, null);
        }
    }
}

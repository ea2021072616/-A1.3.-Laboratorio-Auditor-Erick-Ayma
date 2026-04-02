package com.google.android.exoplayer2.source.hls;

import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TimestampAdjuster;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.webvtt.WebvttParserUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
final class WebvttExtractor implements Extractor {
    private static final Pattern LOCAL_TIMESTAMP = Pattern.compile("LOCAL:([^,]+)");
    private static final Pattern MEDIA_TIMESTAMP = Pattern.compile("MPEGTS:(\\d+)");
    private final String language;
    private ExtractorOutput output;
    private int sampleSize;
    private final TimestampAdjuster timestampAdjuster;
    private final ParsableByteArray sampleDataWrapper = new ParsableByteArray();
    private byte[] sampleData = new byte[1024];

    public WebvttExtractor(String str, TimestampAdjuster timestampAdjuster) {
        this.language = str;
        this.timestampAdjuster = timestampAdjuster;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.output = extractorOutput;
        extractorOutput.seekMap(new SeekMap.Unseekable(C.TIME_UNSET));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        int length = (int) extractorInput.getLength();
        if (this.sampleSize == this.sampleData.length) {
            this.sampleData = Arrays.copyOf(this.sampleData, ((length != -1 ? length : this.sampleData.length) * 3) / 2);
        }
        int read = extractorInput.read(this.sampleData, this.sampleSize, this.sampleData.length - this.sampleSize);
        if (read != -1) {
            this.sampleSize = read + this.sampleSize;
            if (length == -1 || this.sampleSize != length) {
                return 0;
            }
        }
        processSample();
        return -1;
    }

    private void processSample() throws ParserException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.sampleData);
        try {
            WebvttParserUtil.validateWebvttHeaderLine(parsableByteArray);
            long j = 0;
            long j2 = 0;
            while (true) {
                String readLine = parsableByteArray.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    if (readLine.startsWith("X-TIMESTAMP-MAP")) {
                        Matcher matcher = LOCAL_TIMESTAMP.matcher(readLine);
                        if (!matcher.find()) {
                            throw new ParserException("X-TIMESTAMP-MAP doesn't contain local timestamp: " + readLine);
                        }
                        Matcher matcher2 = MEDIA_TIMESTAMP.matcher(readLine);
                        if (!matcher2.find()) {
                            throw new ParserException("X-TIMESTAMP-MAP doesn't contain media timestamp: " + readLine);
                        }
                        j2 = WebvttParserUtil.parseTimestampUs(matcher.group(1));
                        j = TimestampAdjuster.ptsToUs(Long.parseLong(matcher2.group(1)));
                    }
                } else {
                    Matcher findNextCueHeader = WebvttParserUtil.findNextCueHeader(parsableByteArray);
                    if (findNextCueHeader == null) {
                        buildTrackOutput(0L);
                        return;
                    }
                    long parseTimestampUs = WebvttParserUtil.parseTimestampUs(findNextCueHeader.group(1));
                    long adjustSampleTimestamp = this.timestampAdjuster.adjustSampleTimestamp((j + parseTimestampUs) - j2);
                    TrackOutput buildTrackOutput = buildTrackOutput(adjustSampleTimestamp - parseTimestampUs);
                    this.sampleDataWrapper.reset(this.sampleData, this.sampleSize);
                    buildTrackOutput.sampleData(this.sampleDataWrapper, this.sampleSize);
                    buildTrackOutput.sampleMetadata(adjustSampleTimestamp, 1, this.sampleSize, 0, null);
                    return;
                }
            }
        } catch (SubtitleDecoderException e) {
            throw new ParserException(e);
        }
    }

    private TrackOutput buildTrackOutput(long j) {
        TrackOutput track = this.output.track(0);
        track.format(Format.createTextSampleFormat(null, MimeTypes.TEXT_VTT, null, -1, 0, this.language, null, j));
        this.output.endTracks();
        return track;
    }
}

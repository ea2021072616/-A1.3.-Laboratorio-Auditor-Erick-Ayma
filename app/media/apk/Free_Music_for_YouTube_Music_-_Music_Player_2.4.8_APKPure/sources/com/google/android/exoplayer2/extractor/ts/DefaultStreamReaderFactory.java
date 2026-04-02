package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class DefaultStreamReaderFactory implements ElementaryStreamReader.Factory {
    public static final int FLAG_ALLOW_NON_IDR_KEYFRAMES = 1;
    public static final int FLAG_DETECT_ACCESS_UNITS = 8;
    public static final int FLAG_IGNORE_AAC_STREAM = 2;
    public static final int FLAG_IGNORE_H264_STREAM = 4;
    private final int flags;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Flags {
    }

    public DefaultStreamReaderFactory() {
        this(0);
    }

    public DefaultStreamReaderFactory(int i) {
        this.flags = i;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader.Factory
    public ElementaryStreamReader createStreamReader(int i, ElementaryStreamReader.EsInfo esInfo) {
        switch (i) {
            case 2:
                return new H262Reader();
            case 3:
            case 4:
                return new MpegAudioReader(esInfo.language);
            case 15:
                if ((this.flags & 2) == 0) {
                    return new AdtsReader(false, esInfo.language);
                }
                return null;
            case 21:
                return new Id3Reader();
            case 27:
                if ((this.flags & 4) == 0) {
                    return new H264Reader((this.flags & 1) != 0, (this.flags & 8) != 0);
                }
                return null;
            case 36:
                return new H265Reader();
            case TsExtractor.TS_STREAM_TYPE_AC3 /* 129 */:
            case TsExtractor.TS_STREAM_TYPE_E_AC3 /* 135 */:
                return new Ac3Reader(esInfo.language);
            case TsExtractor.TS_STREAM_TYPE_HDMV_DTS /* 130 */:
            case TsExtractor.TS_STREAM_TYPE_DTS /* 138 */:
                return new DtsReader(esInfo.language);
            default:
                return null;
        }
    }
}

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
/* loaded from: classes.dex */
public abstract class ElementaryStreamReader {

    /* loaded from: classes.dex */
    public interface Factory {
        ElementaryStreamReader createStreamReader(int i, EsInfo esInfo);
    }

    public abstract void consume(ParsableByteArray parsableByteArray);

    public abstract void init(ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator);

    public abstract void packetFinished();

    public abstract void packetStarted(long j, boolean z);

    public abstract void seek();

    /* loaded from: classes.dex */
    public static final class EsInfo {
        public byte[] descriptorBytes;
        public String language;
        public final int streamType;

        public EsInfo(int i, String str, byte[] bArr) {
            this.streamType = i;
            this.language = str;
            this.descriptorBytes = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static final class TrackIdGenerator {
        private final int firstId;
        private int generatedIdCount;
        private final int idIncrement;

        public TrackIdGenerator(int i, int i2) {
            this.firstId = i;
            this.idIncrement = i2;
        }

        public int getNextId() {
            int i = this.firstId;
            int i2 = this.idIncrement;
            int i3 = this.generatedIdCount;
            this.generatedIdCount = i3 + 1;
            return i + (i2 * i3);
        }
    }
}

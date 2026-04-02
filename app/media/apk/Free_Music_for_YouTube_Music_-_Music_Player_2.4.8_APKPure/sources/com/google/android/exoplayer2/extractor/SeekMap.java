package com.google.android.exoplayer2.extractor;
/* loaded from: classes.dex */
public interface SeekMap {
    long getDurationUs();

    long getPosition(long j);

    boolean isSeekable();

    /* loaded from: classes.dex */
    public static final class Unseekable implements SeekMap {
        private final long durationUs;

        public Unseekable(long j) {
            this.durationUs = j;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return false;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return this.durationUs;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getPosition(long j) {
            return 0L;
        }
    }
}

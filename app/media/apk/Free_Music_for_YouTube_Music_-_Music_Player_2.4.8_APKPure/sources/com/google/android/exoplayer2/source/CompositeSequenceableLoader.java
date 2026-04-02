package com.google.android.exoplayer2.source;
/* loaded from: classes.dex */
public final class CompositeSequenceableLoader implements SequenceableLoader {
    private final SequenceableLoader[] loaders;

    public CompositeSequenceableLoader(SequenceableLoader[] sequenceableLoaderArr) {
        this.loaders = sequenceableLoaderArr;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        long j = Long.MAX_VALUE;
        for (SequenceableLoader sequenceableLoader : this.loaders) {
            long nextLoadPositionUs = sequenceableLoader.getNextLoadPositionUs();
            if (nextLoadPositionUs != Long.MIN_VALUE) {
                j = Math.min(j, nextLoadPositionUs);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        SequenceableLoader[] sequenceableLoaderArr;
        boolean z;
        boolean z2 = false;
        do {
            long nextLoadPositionUs = getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (SequenceableLoader sequenceableLoader : this.loaders) {
                if (sequenceableLoader.getNextLoadPositionUs() == nextLoadPositionUs) {
                    z |= sequenceableLoader.continueLoading(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}

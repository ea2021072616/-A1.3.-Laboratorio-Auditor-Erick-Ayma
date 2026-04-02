package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.SingleSampleMediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class SingleSampleMediaPeriod implements MediaPeriod, Loader.Callback<SourceLoadable> {
    private static final int INITIAL_SAMPLE_SIZE = 1024;
    private final DataSource.Factory dataSourceFactory;
    private final Handler eventHandler;
    private final SingleSampleMediaSource.EventListener eventListener;
    private final int eventSourceId;
    final Format format;
    boolean loadingFinished;
    private final int minLoadableRetryCount;
    byte[] sampleData;
    int sampleSize;
    private final TrackGroupArray tracks;
    private final Uri uri;
    private final ArrayList<SampleStreamImpl> sampleStreams = new ArrayList<>();
    final Loader loader = new Loader("Loader:SingleSampleMediaPeriod");

    public SingleSampleMediaPeriod(Uri uri, DataSource.Factory factory, Format format, int i, Handler handler, SingleSampleMediaSource.EventListener eventListener, int i2) {
        this.uri = uri;
        this.dataSourceFactory = factory;
        this.format = format;
        this.minLoadableRetryCount = i;
        this.eventHandler = handler;
        this.eventListener = eventListener;
        this.eventSourceId = i2;
        this.tracks = new TrackGroupArray(new TrackGroup(format));
    }

    public void release() {
        this.loader.release();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback) {
        callback.onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        this.loader.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.tracks;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        for (int i = 0; i < trackSelectionArr.length; i++) {
            if (sampleStreamArr[i] != null && (trackSelectionArr[i] == null || !zArr[i])) {
                this.sampleStreams.remove(sampleStreamArr[i]);
                sampleStreamArr[i] = null;
            }
            if (sampleStreamArr[i] == null && trackSelectionArr[i] != null) {
                SampleStreamImpl sampleStreamImpl = new SampleStreamImpl();
                this.sampleStreams.add(sampleStreamImpl);
                sampleStreamArr[i] = sampleStreamImpl;
                zArr2[i] = true;
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        if (this.loadingFinished || this.loader.isLoading()) {
            return false;
        }
        this.loader.startLoading(new SourceLoadable(this.uri, this.dataSourceFactory.createDataSource()), this, this.minLoadableRetryCount);
        return true;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        return C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return (this.loadingFinished || this.loader.isLoading()) ? Long.MIN_VALUE : 0L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getBufferedPositionUs() {
        return this.loadingFinished ? Long.MIN_VALUE : 0L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.sampleStreams.size()) {
                this.sampleStreams.get(i2).seekToUs(j);
                i = i2 + 1;
            } else {
                return j;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(SourceLoadable sourceLoadable, long j, long j2) {
        this.sampleSize = sourceLoadable.sampleSize;
        this.sampleData = sourceLoadable.sampleData;
        this.loadingFinished = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(SourceLoadable sourceLoadable, long j, long j2, boolean z) {
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public int onLoadError(SourceLoadable sourceLoadable, long j, long j2, IOException iOException) {
        notifyLoadError(iOException);
        return 0;
    }

    private void notifyLoadError(final IOException iOException) {
        if (this.eventHandler != null && this.eventListener != null) {
            this.eventHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.SingleSampleMediaPeriod.1
                @Override // java.lang.Runnable
                public void run() {
                    SingleSampleMediaPeriod.this.eventListener.onLoadError(SingleSampleMediaPeriod.this.eventSourceId, iOException);
                }
            });
        }
    }

    /* loaded from: classes.dex */
    private final class SampleStreamImpl implements SampleStream {
        private static final int STREAM_STATE_END_OF_STREAM = 2;
        private static final int STREAM_STATE_SEND_FORMAT = 0;
        private static final int STREAM_STATE_SEND_SAMPLE = 1;
        private int streamState;

        private SampleStreamImpl() {
        }

        public void seekToUs(long j) {
            if (this.streamState == 2) {
                this.streamState = 1;
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return SingleSampleMediaPeriod.this.loadingFinished;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws IOException {
            SingleSampleMediaPeriod.this.loader.maybeThrowError();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer) {
            if (this.streamState == 2) {
                decoderInputBuffer.addFlag(4);
                return -4;
            } else if (this.streamState == 0) {
                formatHolder.format = SingleSampleMediaPeriod.this.format;
                this.streamState = 1;
                return -5;
            } else {
                Assertions.checkState(this.streamState == 1);
                if (!SingleSampleMediaPeriod.this.loadingFinished) {
                    return -3;
                }
                decoderInputBuffer.timeUs = 0L;
                decoderInputBuffer.addFlag(1);
                decoderInputBuffer.ensureSpaceForWrite(SingleSampleMediaPeriod.this.sampleSize);
                decoderInputBuffer.data.put(SingleSampleMediaPeriod.this.sampleData, 0, SingleSampleMediaPeriod.this.sampleSize);
                this.streamState = 2;
                return -4;
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void skipToKeyframeBefore(long j) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class SourceLoadable implements Loader.Loadable {
        private final DataSource dataSource;
        private byte[] sampleData;
        private int sampleSize;
        private final Uri uri;

        public SourceLoadable(Uri uri, DataSource dataSource) {
            this.uri = uri;
            this.dataSource = dataSource;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void cancelLoad() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public boolean isLoadCanceled() {
            return false;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void load() throws IOException, InterruptedException {
            int i = 0;
            this.sampleSize = 0;
            try {
                this.dataSource.open(new DataSpec(this.uri));
                while (i != -1) {
                    this.sampleSize = i + this.sampleSize;
                    if (this.sampleData == null) {
                        this.sampleData = new byte[1024];
                    } else if (this.sampleSize == this.sampleData.length) {
                        this.sampleData = Arrays.copyOf(this.sampleData, this.sampleData.length * 2);
                    }
                    i = this.dataSource.read(this.sampleData, this.sampleSize, this.sampleData.length - this.sampleSize);
                }
            } finally {
                this.dataSource.close();
            }
        }
    }
}

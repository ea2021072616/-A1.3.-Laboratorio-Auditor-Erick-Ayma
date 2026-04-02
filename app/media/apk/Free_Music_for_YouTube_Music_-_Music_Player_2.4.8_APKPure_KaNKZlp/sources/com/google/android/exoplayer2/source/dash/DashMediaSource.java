package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes.dex */
public final class DashMediaSource implements MediaSource {
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS = 30000;
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_PREFER_MANIFEST_MS = -1;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    private static final long MIN_LIVE_DEFAULT_START_POSITION_US = 5000000;
    private static final int NOTIFY_MANIFEST_INTERVAL_MS = 5000;
    private static final String TAG = "DashMediaSource";
    private final DashChunkSource.Factory chunkSourceFactory;
    private DataSource dataSource;
    private long elapsedRealtimeOffsetMs;
    private final AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher;
    private int firstPeriodId;
    private Handler handler;
    private final long livePresentationDelayMs;
    private Loader loader;
    private DashManifest manifest;
    private final ManifestCallback manifestCallback;
    private final DataSource.Factory manifestDataSourceFactory;
    private long manifestLoadEndTimestamp;
    private long manifestLoadStartTimestamp;
    private final DashManifestParser manifestParser;
    private Uri manifestUri;
    private final Object manifestUriLock;
    private final int minLoadableRetryCount;
    private final SparseArray<DashMediaPeriod> periodsById;
    private final Runnable refreshManifestRunnable;
    private final Runnable simulateManifestRefreshRunnable;
    private MediaSource.Listener sourceListener;

    public DashMediaSource(Uri uri, DataSource.Factory factory, DashChunkSource.Factory factory2, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(uri, factory, factory2, 3, -1L, handler, adaptiveMediaSourceEventListener);
    }

    public DashMediaSource(Uri uri, DataSource.Factory factory, DashChunkSource.Factory factory2, int i, long j, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this.manifestUri = uri;
        this.manifestDataSourceFactory = factory;
        this.chunkSourceFactory = factory2;
        this.minLoadableRetryCount = i;
        this.livePresentationDelayMs = j;
        this.eventDispatcher = new AdaptiveMediaSourceEventListener.EventDispatcher(handler, adaptiveMediaSourceEventListener);
        this.manifestParser = new DashManifestParser(generateContentId());
        this.manifestCallback = new ManifestCallback();
        this.manifestUriLock = new Object();
        this.periodsById = new SparseArray<>();
        this.refreshManifestRunnable = new Runnable() { // from class: com.google.android.exoplayer2.source.dash.DashMediaSource.1
            @Override // java.lang.Runnable
            public void run() {
                DashMediaSource.this.startLoadingManifest();
            }
        };
        this.simulateManifestRefreshRunnable = new Runnable() { // from class: com.google.android.exoplayer2.source.dash.DashMediaSource.2
            @Override // java.lang.Runnable
            public void run() {
                DashMediaSource.this.processManifest();
            }
        };
    }

    public void replaceManifestUri(Uri uri) {
        synchronized (this.manifestUriLock) {
            this.manifestUri = uri;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(MediaSource.Listener listener) {
        this.sourceListener = listener;
        this.dataSource = this.manifestDataSourceFactory.createDataSource();
        this.loader = new Loader("Loader:DashMediaSource");
        this.handler = new Handler();
        startLoadingManifest();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.loader.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(int i, Allocator allocator, long j) {
        DashMediaPeriod dashMediaPeriod = new DashMediaPeriod(this.firstPeriodId + i, this.manifest, i, this.chunkSourceFactory, this.minLoadableRetryCount, this.eventDispatcher, this.elapsedRealtimeOffsetMs, this.loader, allocator);
        this.periodsById.put(dashMediaPeriod.id, dashMediaPeriod);
        return dashMediaPeriod;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        DashMediaPeriod dashMediaPeriod = (DashMediaPeriod) mediaPeriod;
        dashMediaPeriod.release();
        this.periodsById.remove(dashMediaPeriod.id);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        this.dataSource = null;
        if (this.loader != null) {
            this.loader.release();
            this.loader = null;
        }
        this.manifestLoadStartTimestamp = 0L;
        this.manifestLoadEndTimestamp = 0L;
        this.manifest = null;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
            this.handler = null;
        }
        this.elapsedRealtimeOffsetMs = 0L;
        this.periodsById.clear();
    }

    void onManifestLoadCompleted(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2) {
        this.eventDispatcher.loadCompleted(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded());
        DashManifest result = parsingLoadable.getResult();
        int periodCount = this.manifest == null ? 0 : this.manifest.getPeriodCount();
        int i = 0;
        long j3 = result.getPeriod(0).startMs;
        while (i < periodCount && this.manifest.getPeriod(i).startMs < j3) {
            i++;
        }
        if (periodCount - i > result.getPeriodCount()) {
            Log.w(TAG, "Out of sync manifest");
            scheduleManifestRefresh();
            return;
        }
        this.manifest = result;
        this.manifestLoadStartTimestamp = j - j2;
        this.manifestLoadEndTimestamp = j;
        if (this.manifest.location != null) {
            synchronized (this.manifestUriLock) {
                if (parsingLoadable.dataSpec.uri == this.manifestUri) {
                    this.manifestUri = this.manifest.location;
                }
            }
        }
        if (periodCount == 0) {
            if (this.manifest.utcTiming != null) {
                resolveUtcTimingElement(this.manifest.utcTiming);
                return;
            } else {
                processManifestAndScheduleRefresh();
                return;
            }
        }
        this.firstPeriodId += i;
        processManifestAndScheduleRefresh();
    }

    int onManifestLoadError(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.eventDispatcher.loadError(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded(), iOException, z);
        return z ? 3 : 0;
    }

    void onUtcTimestampLoadCompleted(ParsingLoadable<Long> parsingLoadable, long j, long j2) {
        this.eventDispatcher.loadCompleted(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded());
        onUtcTimestampResolved(parsingLoadable.getResult().longValue() - j);
    }

    int onUtcTimestampLoadError(ParsingLoadable<Long> parsingLoadable, long j, long j2, IOException iOException) {
        this.eventDispatcher.loadError(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded(), iOException, true);
        onUtcTimestampResolutionError(iOException);
        return 2;
    }

    void onLoadCanceled(ParsingLoadable<?> parsingLoadable, long j, long j2) {
        this.eventDispatcher.loadCanceled(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadingManifest() {
        Uri uri;
        synchronized (this.manifestUriLock) {
            uri = this.manifestUri;
        }
        startLoading(new ParsingLoadable(this.dataSource, uri, 4, this.manifestParser), this.manifestCallback, this.minLoadableRetryCount);
    }

    private void resolveUtcTimingElement(UtcTimingElement utcTimingElement) {
        String str = utcTimingElement.schemeIdUri;
        if (Util.areEqual(str, "urn:mpeg:dash:utc:direct:2012")) {
            resolveUtcTimingElementDirect(utcTimingElement);
        } else if (Util.areEqual(str, "urn:mpeg:dash:utc:http-iso:2014")) {
            resolveUtcTimingElementHttp(utcTimingElement, new Iso8601Parser());
        } else if (Util.areEqual(str, "urn:mpeg:dash:utc:http-xsdate:2012") || Util.areEqual(str, "urn:mpeg:dash:utc:http-xsdate:2014")) {
            resolveUtcTimingElementHttp(utcTimingElement, new XsDateTimeParser());
        } else {
            onUtcTimestampResolutionError(new IOException("Unsupported UTC timing scheme"));
        }
    }

    private void resolveUtcTimingElementDirect(UtcTimingElement utcTimingElement) {
        try {
            onUtcTimestampResolved(Util.parseXsDateTime(utcTimingElement.value) - this.manifestLoadEndTimestamp);
        } catch (ParseException e) {
            onUtcTimestampResolutionError(new ParserException(e));
        }
    }

    private void resolveUtcTimingElementHttp(UtcTimingElement utcTimingElement, ParsingLoadable.Parser<Long> parser) {
        startLoading(new ParsingLoadable(this.dataSource, Uri.parse(utcTimingElement.value), 5, parser), new UtcTimestampCallback(), 1);
    }

    private void onUtcTimestampResolved(long j) {
        this.elapsedRealtimeOffsetMs = j;
        processManifestAndScheduleRefresh();
    }

    private void onUtcTimestampResolutionError(IOException iOException) {
        Log.e(TAG, "Failed to resolve UtcTiming element.", iOException);
        processManifestAndScheduleRefresh();
    }

    private void processManifestAndScheduleRefresh() {
        processManifest();
        scheduleManifestRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processManifest() {
        long j;
        int i;
        long j2;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.periodsById.size()) {
                break;
            }
            int keyAt = this.periodsById.keyAt(i3);
            if (keyAt >= this.firstPeriodId) {
                this.periodsById.valueAt(i3).updateManifest(this.manifest, keyAt - this.firstPeriodId);
            }
            i2 = i3 + 1;
        }
        this.handler.removeCallbacks(this.simulateManifestRefreshRunnable);
        int periodCount = this.manifest.getPeriodCount() - 1;
        PeriodSeekInfo createPeriodSeekInfo = PeriodSeekInfo.createPeriodSeekInfo(this.manifest.getPeriod(0), this.manifest.getPeriodDurationUs(0));
        PeriodSeekInfo createPeriodSeekInfo2 = PeriodSeekInfo.createPeriodSeekInfo(this.manifest.getPeriod(periodCount), this.manifest.getPeriodDurationUs(periodCount));
        long j3 = createPeriodSeekInfo.availableStartTimeUs;
        long j4 = createPeriodSeekInfo2.availableEndTimeUs;
        if (this.manifest.dynamic && !createPeriodSeekInfo2.isIndexExplicit) {
            j4 = Math.min((getNowUnixTimeUs() - C.msToUs(this.manifest.availabilityStartTime)) - C.msToUs(this.manifest.getPeriod(periodCount).startMs), j4);
            if (this.manifest.timeShiftBufferDepth != C.TIME_UNSET) {
                long msToUs = j4 - C.msToUs(this.manifest.timeShiftBufferDepth);
                while (msToUs < 0 && periodCount > 0) {
                    periodCount--;
                    msToUs += this.manifest.getPeriodDurationUs(periodCount);
                }
                if (periodCount == 0) {
                    j3 = Math.max(j3, msToUs);
                } else {
                    j3 = this.manifest.getPeriodDurationUs(0);
                }
            }
            this.handler.postDelayed(this.simulateManifestRefreshRunnable, ExoPlayerFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        }
        long j5 = j3;
        long j6 = j4 - j5;
        for (int i4 = 0; i4 < this.manifest.getPeriodCount() - 1; i4++) {
            j6 += this.manifest.getPeriodDurationUs(i4);
        }
        long j7 = 0;
        if (this.manifest.dynamic) {
            long j8 = this.livePresentationDelayMs;
            if (j8 == -1) {
                j8 = this.manifest.suggestedPresentationDelay != C.TIME_UNSET ? this.manifest.suggestedPresentationDelay : 30000L;
            }
            long msToUs2 = j6 - C.msToUs(j8);
            long min = msToUs2 < MIN_LIVE_DEFAULT_START_POSITION_US ? Math.min((long) MIN_LIVE_DEFAULT_START_POSITION_US, j6 / 2) : msToUs2;
            int i5 = 0;
            long j9 = j5 + min;
            long periodDurationUs = this.manifest.getPeriodDurationUs(0);
            while (true) {
                j = periodDurationUs;
                i = i5;
                j2 = j9;
                if (i >= this.manifest.getPeriodCount() - 1 || j2 < j) {
                    break;
                }
                j9 = j2 - j;
                i5 = i + 1;
                periodDurationUs = this.manifest.getPeriodDurationUs(i5);
            }
            Period period = this.manifest.getPeriod(i);
            int adaptationSetIndex = period.getAdaptationSetIndex(2);
            if (adaptationSetIndex != -1) {
                DashSegmentIndex index = period.adaptationSets.get(adaptationSetIndex).representations.get(0).getIndex();
                j7 = (min - j2) + index.getTimeUs(index.getSegmentNum(j2, j));
            } else {
                j7 = min;
            }
        }
        this.sourceListener.onSourceInfoRefreshed(new DashTimeline(this.manifest.availabilityStartTime, this.manifest.availabilityStartTime + this.manifest.getPeriod(0).startMs + C.usToMs(j5), this.firstPeriodId, j5, j6, j7, this.manifest), this.manifest);
    }

    private void scheduleManifestRefresh() {
        if (this.manifest.dynamic) {
            long j = this.manifest.minUpdatePeriod;
            if (j == 0) {
                j = ExoPlayerFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS;
            }
            this.handler.postDelayed(this.refreshManifestRunnable, Math.max(0L, (j + this.manifestLoadStartTimestamp) - SystemClock.elapsedRealtime()));
        }
    }

    private <T> void startLoading(ParsingLoadable<T> parsingLoadable, Loader.Callback<ParsingLoadable<T>> callback, int i) {
        this.eventDispatcher.loadStarted(parsingLoadable.dataSpec, parsingLoadable.type, this.loader.startLoading(parsingLoadable, callback, i));
    }

    private long getNowUnixTimeUs() {
        return this.elapsedRealtimeOffsetMs != 0 ? C.msToUs(SystemClock.elapsedRealtime() + this.elapsedRealtimeOffsetMs) : C.msToUs(System.currentTimeMillis());
    }

    private String generateContentId() {
        return Util.sha1(this.manifestUri.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class PeriodSeekInfo {
        public final long availableEndTimeUs;
        public final long availableStartTimeUs;
        public final boolean isIndexExplicit;

        public static PeriodSeekInfo createPeriodSeekInfo(Period period, long j) {
            int size = period.adaptationSets.size();
            long j2 = 0;
            long j3 = Long.MAX_VALUE;
            boolean z = false;
            for (int i = 0; i < size; i++) {
                DashSegmentIndex index = period.adaptationSets.get(i).representations.get(0).getIndex();
                if (index == null) {
                    return new PeriodSeekInfo(true, 0L, j);
                }
                int firstSegmentNum = index.getFirstSegmentNum();
                int lastSegmentNum = index.getLastSegmentNum(j);
                z |= index.isExplicit();
                j2 = Math.max(j2, index.getTimeUs(firstSegmentNum));
                if (lastSegmentNum != -1) {
                    j3 = Math.min(j3, index.getDurationUs(lastSegmentNum, j) + index.getTimeUs(lastSegmentNum));
                }
            }
            return new PeriodSeekInfo(z, j2, j3);
        }

        private PeriodSeekInfo(boolean z, long j, long j2) {
            this.isIndexExplicit = z;
            this.availableStartTimeUs = j;
            this.availableEndTimeUs = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class DashTimeline extends Timeline {
        private final int firstPeriodId;
        private final DashManifest manifest;
        private final long offsetInFirstPeriodUs;
        private final long presentationStartTimeMs;
        private final long windowDefaultStartPositionUs;
        private final long windowDurationUs;
        private final long windowStartTimeMs;

        public DashTimeline(long j, long j2, int i, long j3, long j4, long j5, DashManifest dashManifest) {
            this.presentationStartTimeMs = j;
            this.windowStartTimeMs = j2;
            this.firstPeriodId = i;
            this.offsetInFirstPeriodUs = j3;
            this.windowDurationUs = j4;
            this.windowDefaultStartPositionUs = j5;
            this.manifest = dashManifest;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return this.manifest.getPeriodCount();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            Assertions.checkIndex(i, 0, this.manifest.getPeriodCount());
            return period.set(z ? this.manifest.getPeriod(i).id : null, z ? Integer.valueOf(this.firstPeriodId + Assertions.checkIndex(i, 0, this.manifest.getPeriodCount())) : null, 0, this.manifest.getPeriodDurationUs(i), C.msToUs(this.manifest.getPeriod(i).startMs - this.manifest.getPeriod(0).startMs) - this.offsetInFirstPeriodUs);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int i, Timeline.Window window, boolean z) {
            Assertions.checkIndex(i, 0, 1);
            return window.set(null, this.presentationStartTimeMs, this.windowStartTimeMs, true, this.manifest.dynamic, this.windowDefaultStartPositionUs, this.windowDurationUs, 0, this.manifest.getPeriodCount() - 1, this.offsetInFirstPeriodUs);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object obj) {
            int intValue;
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) >= this.firstPeriodId && intValue < this.firstPeriodId + getPeriodCount()) {
                return intValue - this.firstPeriodId;
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class ManifestCallback implements Loader.Callback<ParsingLoadable<DashManifest>> {
        private ManifestCallback() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCompleted(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2) {
            DashMediaSource.this.onManifestLoadCompleted(parsingLoadable, j, j2);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCanceled(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2, boolean z) {
            DashMediaSource.this.onLoadCanceled(parsingLoadable, j, j2);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public int onLoadError(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2, IOException iOException) {
            return DashMediaSource.this.onManifestLoadError(parsingLoadable, j, j2, iOException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class UtcTimestampCallback implements Loader.Callback<ParsingLoadable<Long>> {
        private UtcTimestampCallback() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCompleted(ParsingLoadable<Long> parsingLoadable, long j, long j2) {
            DashMediaSource.this.onUtcTimestampLoadCompleted(parsingLoadable, j, j2);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCanceled(ParsingLoadable<Long> parsingLoadable, long j, long j2, boolean z) {
            DashMediaSource.this.onLoadCanceled(parsingLoadable, j, j2);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public int onLoadError(ParsingLoadable<Long> parsingLoadable, long j, long j2, IOException iOException) {
            return DashMediaSource.this.onUtcTimestampLoadError(parsingLoadable, j, j2, iOException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class XsDateTimeParser implements ParsingLoadable.Parser<Long> {
        private XsDateTimeParser() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
        public Long parse(Uri uri, InputStream inputStream) throws IOException {
            try {
                return Long.valueOf(Util.parseXsDateTime(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
            } catch (ParseException e) {
                throw new ParserException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Iso8601Parser implements ParsingLoadable.Parser<Long> {
        private Iso8601Parser() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
        public Long parse(Uri uri, InputStream inputStream) throws IOException {
            String readLine = new BufferedReader(new InputStreamReader(inputStream)).readLine();
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                return Long.valueOf(simpleDateFormat.parse(readLine).getTime());
            } catch (ParseException e) {
                throw new ParserException(e);
            }
        }
    }
}

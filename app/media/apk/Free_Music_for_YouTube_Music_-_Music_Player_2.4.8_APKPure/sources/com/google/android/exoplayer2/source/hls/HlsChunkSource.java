package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.TimestampAdjuster;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.DefaultStreamReaderFactory;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.google.android.exoplayer2.source.chunk.DataChunk;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
class HlsChunkSource {
    private static final String AAC_FILE_EXTENSION = ".aac";
    private static final String AC3_FILE_EXTENSION = ".ac3";
    public static final long DEFAULT_PLAYLIST_BLACKLIST_MS = 60000;
    private static final String EC3_FILE_EXTENSION = ".ec3";
    private static final double LIVE_VARIANT_SWITCH_SAFETY_EXTRA_SECS = 2.0d;
    private static final String MP3_FILE_EXTENSION = ".mp3";
    private static final String MP4_FILE_EXTENSION = ".mp4";
    private static final String VTT_FILE_EXTENSION = ".vtt";
    private static final String WEBVTT_FILE_EXTENSION = ".webvtt";
    private final String baseUri;
    private final DataSource dataSource;
    private long durationUs;
    private byte[] encryptionIv;
    private String encryptionIvString;
    private byte[] encryptionKey;
    private Uri encryptionKeyUri;
    private IOException fatalError;
    private HlsInitializationChunk lastLoadedInitializationChunk;
    private boolean live;
    private final HlsPlaylistParser playlistParser = new HlsPlaylistParser();
    private byte[] scratchSpace;
    private final TimestampAdjusterProvider timestampAdjusterProvider;
    private final TrackGroup trackGroup;
    private TrackSelection trackSelection;
    private final long[] variantLastPlaylistLoadTimesMs;
    private final HlsMediaPlaylist[] variantPlaylists;
    private final HlsMasterPlaylist.HlsUrl[] variants;

    /* loaded from: classes.dex */
    public static final class HlsChunkHolder {
        public Chunk chunk;
        public boolean endOfStream;
        public long retryInMs;

        public HlsChunkHolder() {
            clear();
        }

        public void clear() {
            this.chunk = null;
            this.endOfStream = false;
            this.retryInMs = C.TIME_UNSET;
        }
    }

    public HlsChunkSource(String str, HlsMasterPlaylist.HlsUrl[] hlsUrlArr, DataSource dataSource, TimestampAdjusterProvider timestampAdjusterProvider) {
        this.baseUri = str;
        this.variants = hlsUrlArr;
        this.dataSource = dataSource;
        this.timestampAdjusterProvider = timestampAdjusterProvider;
        this.variantPlaylists = new HlsMediaPlaylist[hlsUrlArr.length];
        this.variantLastPlaylistLoadTimesMs = new long[hlsUrlArr.length];
        Format[] formatArr = new Format[hlsUrlArr.length];
        int[] iArr = new int[hlsUrlArr.length];
        for (int i = 0; i < hlsUrlArr.length; i++) {
            formatArr[i] = hlsUrlArr[i].format;
            iArr[i] = i;
        }
        this.trackGroup = new TrackGroup(formatArr);
        this.trackSelection = new InitializationTrackSelection(this.trackGroup, iArr);
    }

    public void maybeThrowError() throws IOException {
        if (this.fatalError != null) {
            throw this.fatalError;
        }
    }

    public boolean isLive() {
        return this.live;
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public TrackGroup getTrackGroup() {
        return this.trackGroup;
    }

    public void selectTracks(TrackSelection trackSelection) {
        this.trackSelection = trackSelection;
    }

    public void reset() {
        this.fatalError = null;
    }

    public void getNextChunk(HlsMediaChunk hlsMediaChunk, long j, HlsChunkHolder hlsChunkHolder) {
        int nextChunkIndex;
        HlsMediaPlaylist hlsMediaPlaylist;
        long j2;
        Extractor ac3Extractor;
        int i;
        int indexOf = hlsMediaChunk == null ? -1 : this.trackGroup.indexOf(hlsMediaChunk.trackFormat);
        this.trackSelection.updateSelectedTrack(hlsMediaChunk == null ? 0L : Math.max(0L, hlsMediaChunk.getAdjustedStartTimeUs() - j));
        int selectedIndexInTrackGroup = this.trackSelection.getSelectedIndexInTrackGroup();
        boolean z = indexOf != selectedIndexInTrackGroup;
        HlsMediaPlaylist hlsMediaPlaylist2 = this.variantPlaylists[selectedIndexInTrackGroup];
        if (hlsMediaPlaylist2 == null) {
            hlsChunkHolder.chunk = newMediaPlaylistChunk(selectedIndexInTrackGroup, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData());
            return;
        }
        if (this.live) {
            if (hlsMediaChunk == null) {
                nextChunkIndex = Math.max(0, hlsMediaPlaylist2.segments.size() - 3) + hlsMediaPlaylist2.mediaSequence;
                hlsMediaPlaylist = hlsMediaPlaylist2;
            } else {
                nextChunkIndex = getLiveNextChunkSequenceNumber(hlsMediaChunk.chunkIndex, indexOf, selectedIndexInTrackGroup);
                if (nextChunkIndex < hlsMediaPlaylist2.mediaSequence) {
                    HlsMediaPlaylist hlsMediaPlaylist3 = this.variantPlaylists[indexOf];
                    nextChunkIndex = getLiveNextChunkSequenceNumber(hlsMediaChunk.chunkIndex, indexOf, indexOf);
                    if (nextChunkIndex < hlsMediaPlaylist3.mediaSequence) {
                        this.fatalError = new BehindLiveWindowException();
                        return;
                    } else {
                        selectedIndexInTrackGroup = indexOf;
                        hlsMediaPlaylist = hlsMediaPlaylist3;
                    }
                } else {
                    hlsMediaPlaylist = hlsMediaPlaylist2;
                }
            }
        } else if (hlsMediaChunk == null) {
            nextChunkIndex = Util.binarySearchFloor((List<? extends Comparable<? super Long>>) hlsMediaPlaylist2.segments, Long.valueOf(j), true, true) + hlsMediaPlaylist2.mediaSequence;
            hlsMediaPlaylist = hlsMediaPlaylist2;
        } else if (z) {
            nextChunkIndex = Util.binarySearchFloor((List<? extends Comparable<? super Long>>) hlsMediaPlaylist2.segments, Long.valueOf(hlsMediaChunk.startTimeUs), true, true) + hlsMediaPlaylist2.mediaSequence;
            hlsMediaPlaylist = hlsMediaPlaylist2;
        } else {
            nextChunkIndex = hlsMediaChunk.getNextChunkIndex();
            hlsMediaPlaylist = hlsMediaPlaylist2;
        }
        int i2 = nextChunkIndex - hlsMediaPlaylist.mediaSequence;
        if (i2 >= hlsMediaPlaylist.segments.size()) {
            if (!hlsMediaPlaylist.live) {
                hlsChunkHolder.endOfStream = true;
                return;
            }
            long msToRerequestLiveMediaPlaylist = msToRerequestLiveMediaPlaylist(selectedIndexInTrackGroup);
            if (msToRerequestLiveMediaPlaylist <= 0) {
                hlsChunkHolder.chunk = newMediaPlaylistChunk(selectedIndexInTrackGroup, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData());
                return;
            } else {
                hlsChunkHolder.retryInMs = msToRerequestLiveMediaPlaylist + 10;
                return;
            }
        }
        HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.segments.get(i2);
        if (segment.isEncrypted) {
            Uri resolveToUri = UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, segment.encryptionKeyUri);
            if (!resolveToUri.equals(this.encryptionKeyUri)) {
                hlsChunkHolder.chunk = newEncryptionKeyChunk(resolveToUri, segment.encryptionIV, selectedIndexInTrackGroup, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData());
                return;
            } else if (!Util.areEqual(segment.encryptionIV, this.encryptionIvString)) {
                setEncryptionData(resolveToUri, segment.encryptionIV, this.encryptionKey);
            }
        } else {
            clearEncryptionData();
        }
        if (this.live) {
            if (hlsMediaChunk == null) {
                j2 = 0;
            } else if (z) {
                j2 = hlsMediaChunk.getAdjustedStartTimeUs();
            } else {
                j2 = hlsMediaChunk.getAdjustedEndTimeUs();
            }
        } else {
            j2 = segment.startTimeUs;
        }
        long j3 = j2 + ((long) (segment.durationSecs * 1000000.0d));
        Format format = this.variants[selectedIndexInTrackGroup].format;
        Uri resolveToUri2 = UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, segment.url);
        boolean z2 = this.lastLoadedInitializationChunk != null && this.lastLoadedInitializationChunk.format == format;
        boolean z3 = (hlsMediaChunk != null && hlsMediaChunk.discontinuitySequenceNumber == segment.discontinuitySequenceNumber && format == hlsMediaChunk.trackFormat) ? false : true;
        boolean z4 = true;
        boolean z5 = false;
        TimestampAdjuster timestampAdjuster = null;
        String lastPathSegment = resolveToUri2.getLastPathSegment();
        if (lastPathSegment.endsWith(AAC_FILE_EXTENSION)) {
            ac3Extractor = new AdtsExtractor(j2);
        } else if (lastPathSegment.endsWith(AC3_FILE_EXTENSION) || lastPathSegment.endsWith(EC3_FILE_EXTENSION)) {
            ac3Extractor = new Ac3Extractor(j2);
        } else if (lastPathSegment.endsWith(MP3_FILE_EXTENSION)) {
            ac3Extractor = new Mp3Extractor(j2);
        } else if (lastPathSegment.endsWith(WEBVTT_FILE_EXTENSION) || lastPathSegment.endsWith(VTT_FILE_EXTENSION)) {
            timestampAdjuster = this.timestampAdjusterProvider.getAdjuster(segment.discontinuitySequenceNumber, j2);
            ac3Extractor = new WebvttExtractor(format.language, timestampAdjuster);
        } else if (lastPathSegment.endsWith(MP4_FILE_EXTENSION)) {
            z5 = true;
            if (z3) {
                if (z2) {
                    ac3Extractor = this.lastLoadedInitializationChunk.extractor;
                } else {
                    timestampAdjuster = this.timestampAdjusterProvider.getAdjuster(segment.discontinuitySequenceNumber, j2);
                    ac3Extractor = new FragmentedMp4Extractor(0, timestampAdjuster);
                }
            } else {
                ac3Extractor = hlsMediaChunk.extractor;
            }
        } else if (z3) {
            z5 = true;
            if (z2) {
                ac3Extractor = this.lastLoadedInitializationChunk.extractor;
            } else {
                timestampAdjuster = this.timestampAdjusterProvider.getAdjuster(segment.discontinuitySequenceNumber, j2);
                String str = this.variants[selectedIndexInTrackGroup].format.codecs;
                if (TextUtils.isEmpty(str)) {
                    i = 0;
                } else {
                    if (MimeTypes.AUDIO_AAC.equals(MimeTypes.getAudioMediaMimeType(str))) {
                        i = 0;
                    } else {
                        i = 2;
                    }
                    if (!MimeTypes.VIDEO_H264.equals(MimeTypes.getVideoMediaMimeType(str))) {
                        i |= 4;
                    }
                }
                ac3Extractor = new TsExtractor(timestampAdjuster, new DefaultStreamReaderFactory(i), true);
            }
        } else {
            ac3Extractor = hlsMediaChunk.extractor;
            z4 = false;
        }
        if (z3 && hlsMediaPlaylist.initializationSegment != null && !z2) {
            hlsChunkHolder.chunk = buildInitializationChunk(hlsMediaPlaylist, ac3Extractor, format);
            return;
        }
        this.lastLoadedInitializationChunk = null;
        hlsChunkHolder.chunk = new HlsMediaChunk(this.dataSource, new DataSpec(resolveToUri2, segment.byterangeOffset, segment.byterangeLength, null), format, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), j2, j3, nextChunkIndex, segment.discontinuitySequenceNumber, z5, timestampAdjuster, ac3Extractor, z4, z, this.encryptionKey, this.encryptionIv);
    }

    private int getLiveNextChunkSequenceNumber(int i, int i2, int i3) {
        if (i2 == i3) {
            return i + 1;
        }
        HlsMediaPlaylist hlsMediaPlaylist = this.variantPlaylists[i2];
        HlsMediaPlaylist hlsMediaPlaylist2 = this.variantPlaylists[i3];
        double d = 0.0d;
        for (int i4 = i - hlsMediaPlaylist.mediaSequence; i4 < hlsMediaPlaylist.segments.size(); i4++) {
            d += hlsMediaPlaylist.segments.get(i4).durationSecs;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        double d2 = ((d + ((elapsedRealtime - this.variantLastPlaylistLoadTimesMs[i2]) / 1000.0d)) + LIVE_VARIANT_SWITCH_SAFETY_EXTRA_SECS) - ((elapsedRealtime - this.variantLastPlaylistLoadTimesMs[i3]) / 1000.0d);
        if (d2 < 0.0d) {
            return hlsMediaPlaylist2.mediaSequence + hlsMediaPlaylist2.segments.size() + 1;
        }
        for (int size = hlsMediaPlaylist2.segments.size() - 1; size >= 0; size--) {
            d2 -= hlsMediaPlaylist2.segments.get(size).durationSecs;
            if (d2 < 0.0d) {
                return hlsMediaPlaylist2.mediaSequence + size;
            }
        }
        return hlsMediaPlaylist2.mediaSequence - 1;
    }

    public void onChunkLoadCompleted(Chunk chunk) {
        if (chunk instanceof HlsInitializationChunk) {
            this.lastLoadedInitializationChunk = (HlsInitializationChunk) chunk;
        } else if (chunk instanceof MediaPlaylistChunk) {
            MediaPlaylistChunk mediaPlaylistChunk = (MediaPlaylistChunk) chunk;
            this.scratchSpace = mediaPlaylistChunk.getDataHolder();
            setMediaPlaylist(mediaPlaylistChunk.variantIndex, mediaPlaylistChunk.getResult());
        } else if (chunk instanceof EncryptionKeyChunk) {
            EncryptionKeyChunk encryptionKeyChunk = (EncryptionKeyChunk) chunk;
            this.scratchSpace = encryptionKeyChunk.getDataHolder();
            setEncryptionData(encryptionKeyChunk.dataSpec.uri, encryptionKeyChunk.iv, encryptionKeyChunk.getResult());
        }
    }

    public boolean onChunkLoadError(Chunk chunk, boolean z, IOException iOException) {
        return z && ChunkedTrackBlacklistUtil.maybeBlacklistTrack(this.trackSelection, this.trackSelection.indexOf(this.trackGroup.indexOf(chunk.trackFormat)), iOException);
    }

    private HlsInitializationChunk buildInitializationChunk(HlsMediaPlaylist hlsMediaPlaylist, Extractor extractor, Format format) {
        HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.initializationSegment;
        return new HlsInitializationChunk(this.dataSource, new DataSpec(UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, segment.url), segment.byterangeOffset, segment.byterangeLength, null), this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), extractor, format);
    }

    private long msToRerequestLiveMediaPlaylist(int i) {
        return ((this.variantPlaylists[i].targetDurationSecs * 1000) / 2) - (SystemClock.elapsedRealtime() - this.variantLastPlaylistLoadTimesMs[i]);
    }

    private MediaPlaylistChunk newMediaPlaylistChunk(int i, int i2, Object obj) {
        Uri resolveToUri = UriUtil.resolveToUri(this.baseUri, this.variants[i].url);
        return new MediaPlaylistChunk(this.dataSource, new DataSpec(resolveToUri, 0L, -1L, null, 1), this.variants[i].format, i2, obj, this.scratchSpace, this.playlistParser, i, resolveToUri);
    }

    private EncryptionKeyChunk newEncryptionKeyChunk(Uri uri, String str, int i, int i2, Object obj) {
        return new EncryptionKeyChunk(this.dataSource, new DataSpec(uri, 0L, -1L, null, 1), this.variants[i].format, i2, obj, this.scratchSpace, str);
    }

    private void setEncryptionData(Uri uri, String str, byte[] bArr) {
        byte[] byteArray = new BigInteger(str.toLowerCase(Locale.getDefault()).startsWith("0x") ? str.substring(2) : str, 16).toByteArray();
        byte[] bArr2 = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr2, (bArr2.length - byteArray.length) + length, byteArray.length - length);
        this.encryptionKeyUri = uri;
        this.encryptionKey = bArr;
        this.encryptionIvString = str;
        this.encryptionIv = bArr2;
    }

    private void clearEncryptionData() {
        this.encryptionKeyUri = null;
        this.encryptionKey = null;
        this.encryptionIvString = null;
        this.encryptionIv = null;
    }

    private void setMediaPlaylist(int i, HlsMediaPlaylist hlsMediaPlaylist) {
        this.variantLastPlaylistLoadTimesMs[i] = SystemClock.elapsedRealtime();
        this.variantPlaylists[i] = hlsMediaPlaylist;
        this.live |= hlsMediaPlaylist.live;
        this.durationUs = this.live ? C.TIME_UNSET : hlsMediaPlaylist.durationUs;
    }

    /* loaded from: classes.dex */
    private static final class InitializationTrackSelection extends BaseTrackSelection {
        private int selectedIndex;

        public InitializationTrackSelection(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
            this.selectedIndex = indexOf(trackGroup.getFormat(0));
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public void updateSelectedTrack(long j) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (isBlacklisted(this.selectedIndex, elapsedRealtime)) {
                for (int i = this.length - 1; i >= 0; i--) {
                    if (!isBlacklisted(i, elapsedRealtime)) {
                        this.selectedIndex = i;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectedIndex() {
            return this.selectedIndex;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectionReason() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public Object getSelectionData() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class MediaPlaylistChunk extends DataChunk {
        private final HlsPlaylistParser playlistParser;
        private final Uri playlistUri;
        private HlsMediaPlaylist result;
        public final int variantIndex;

        public MediaPlaylistChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, byte[] bArr, HlsPlaylistParser hlsPlaylistParser, int i2, Uri uri) {
            super(dataSource, dataSpec, 4, format, i, obj, bArr);
            this.variantIndex = i2;
            this.playlistParser = hlsPlaylistParser;
            this.playlistUri = uri;
        }

        @Override // com.google.android.exoplayer2.source.chunk.DataChunk
        protected void consume(byte[] bArr, int i) throws IOException {
            this.result = (HlsMediaPlaylist) this.playlistParser.parse(this.playlistUri, (InputStream) new ByteArrayInputStream(bArr, 0, i));
        }

        public HlsMediaPlaylist getResult() {
            return this.result;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class EncryptionKeyChunk extends DataChunk {
        public final String iv;
        private byte[] result;

        public EncryptionKeyChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, byte[] bArr, String str) {
            super(dataSource, dataSpec, 3, format, i, obj, bArr);
            this.iv = str;
        }

        @Override // com.google.android.exoplayer2.source.chunk.DataChunk
        protected void consume(byte[] bArr, int i) throws IOException {
            this.result = Arrays.copyOf(bArr, i);
        }

        public byte[] getResult() {
            return this.result;
        }
    }
}

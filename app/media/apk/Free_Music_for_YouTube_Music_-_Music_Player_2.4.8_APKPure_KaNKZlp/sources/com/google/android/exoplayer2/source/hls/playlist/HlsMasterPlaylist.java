package com.google.android.exoplayer2.source.hls.playlist;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class HlsMasterPlaylist extends HlsPlaylist {
    public final List<HlsUrl> audios;
    public final Format muxedAudioFormat;
    public final Format muxedCaptionFormat;
    public final List<HlsUrl> subtitles;
    public final List<HlsUrl> variants;

    /* loaded from: classes.dex */
    public static final class HlsUrl {
        public final Format audioFormat;
        public final Format format;
        public final String name;
        public final Format[] textFormats;
        public final String url;
        public final Format videoFormat;

        public static HlsUrl createMediaPlaylistHlsUrl(String str) {
            return new HlsUrl(null, str, Format.createContainerFormat(AppEventsConstants.EVENT_PARAM_VALUE_NO, MimeTypes.APPLICATION_M3U8, null, null, -1), null, null, null);
        }

        public HlsUrl(String str, String str2, Format format, Format format2, Format format3, Format[] formatArr) {
            this.name = str;
            this.url = str2;
            this.format = format;
            this.videoFormat = format2;
            this.audioFormat = format3;
            this.textFormats = formatArr;
        }
    }

    public HlsMasterPlaylist(String str, List<HlsUrl> list, List<HlsUrl> list2, List<HlsUrl> list3, Format format, Format format2) {
        super(str, 0);
        this.variants = Collections.unmodifiableList(list);
        this.audios = Collections.unmodifiableList(list2);
        this.subtitles = Collections.unmodifiableList(list3);
        this.muxedAudioFormat = format;
        this.muxedCaptionFormat = format2;
    }
}

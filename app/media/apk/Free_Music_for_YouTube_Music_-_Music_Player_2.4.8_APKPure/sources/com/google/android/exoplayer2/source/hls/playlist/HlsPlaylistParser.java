package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class HlsPlaylistParser implements ParsingLoadable.Parser<HlsPlaylist> {
    private static final String BOOLEAN_FALSE = "NO";
    private static final String BOOLEAN_TRUE = "YES";
    private static final String METHOD_AES128 = "AES-128";
    private static final String METHOD_NONE = "NONE";
    private static final String TAG_BYTERANGE = "#EXT-X-BYTERANGE";
    private static final String TAG_DISCONTINUITY = "#EXT-X-DISCONTINUITY";
    private static final String TAG_DISCONTINUITY_SEQUENCE = "#EXT-X-DISCONTINUITY-SEQUENCE";
    private static final String TAG_ENDLIST = "#EXT-X-ENDLIST";
    private static final String TAG_INIT_SEGMENT = "#EXT-X-MAP";
    private static final String TAG_KEY = "#EXT-X-KEY";
    private static final String TAG_MEDIA = "#EXT-X-MEDIA";
    private static final String TAG_MEDIA_DURATION = "#EXTINF";
    private static final String TAG_MEDIA_SEQUENCE = "#EXT-X-MEDIA-SEQUENCE";
    private static final String TAG_STREAM_INF = "#EXT-X-STREAM-INF";
    private static final String TAG_TARGET_DURATION = "#EXT-X-TARGETDURATION";
    private static final String TAG_VERSION = "#EXT-X-VERSION";
    private static final String TYPE_AUDIO = "AUDIO";
    private static final String TYPE_CLOSED_CAPTIONS = "CLOSED-CAPTIONS";
    private static final String TYPE_SUBTITLES = "SUBTITLES";
    private static final String TYPE_VIDEO = "VIDEO";
    private static final Pattern REGEX_GROUP_ID = Pattern.compile("GROUP-ID=\"(.+?)\"");
    private static final Pattern REGEX_VIDEO = Pattern.compile("VIDEO=\"(.+?)\"");
    private static final Pattern REGEX_AUDIO = Pattern.compile("AUDIO=\"(.+?)\"");
    private static final Pattern REGEX_CLOSED_CAPTIONS = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");
    private static final Pattern REGEX_SUBTITLES = Pattern.compile("SUBTITLES=\"(.+?)\"");
    private static final Pattern REGEX_BANDWIDTH = Pattern.compile("BANDWIDTH=(\\d+)\\b");
    private static final Pattern REGEX_CODECS = Pattern.compile("CODECS=\"(.+?)\"");
    private static final Pattern REGEX_RESOLUTION = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    private static final Pattern REGEX_VERSION = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    private static final Pattern REGEX_TARGET_DURATION = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    private static final Pattern REGEX_MEDIA_SEQUENCE = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern REGEX_MEDIA_DURATION = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final Pattern REGEX_BYTERANGE = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern REGEX_ATTR_BYTERANGE = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern REGEX_METHOD = Pattern.compile("METHOD=(NONE|AES-128)");
    private static final Pattern REGEX_URI = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern REGEX_IV = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern REGEX_TYPE = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern REGEX_LANGUAGE = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern REGEX_NAME = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern REGEX_INSTREAM_ID = Pattern.compile("INSTREAM-ID=\"(.+?)\"");
    private static final Pattern REGEX_AUTOSELECT = compileBooleanAttrPattern("AUTOSELECT");
    private static final Pattern REGEX_DEFAULT = compileBooleanAttrPattern(MessengerShareContentUtility.PREVIEW_DEFAULT);
    private static final Pattern REGEX_FORCED = compileBooleanAttrPattern("FORCED");

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public HlsPlaylist parse(Uri uri, InputStream inputStream) throws IOException {
        String trim;
        HlsPlaylist parseMasterPlaylist;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        LinkedList linkedList = new LinkedList();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    trim = readLine.trim();
                    if (!trim.isEmpty()) {
                        if (trim.startsWith(TAG_STREAM_INF)) {
                            linkedList.add(trim);
                            parseMasterPlaylist = parseMasterPlaylist(new LineIterator(linkedList, bufferedReader), uri.toString());
                            break;
                        } else if (trim.startsWith(TAG_TARGET_DURATION) || trim.startsWith(TAG_MEDIA_SEQUENCE) || trim.startsWith(TAG_MEDIA_DURATION) || trim.startsWith(TAG_KEY) || trim.startsWith(TAG_BYTERANGE) || trim.equals(TAG_DISCONTINUITY) || trim.equals(TAG_DISCONTINUITY_SEQUENCE) || trim.equals(TAG_ENDLIST)) {
                            break;
                        } else {
                            linkedList.add(trim);
                        }
                    }
                } else {
                    bufferedReader.close();
                    throw new ParserException("Failed to parse the playlist, could not identify any tags.");
                }
            } finally {
                bufferedReader.close();
            }
        }
        linkedList.add(trim);
        parseMasterPlaylist = parseMediaPlaylist(new LineIterator(linkedList, bufferedReader), uri.toString());
        return parseMasterPlaylist;
    }

    private static HlsMasterPlaylist parseMasterPlaylist(LineIterator lineIterator, String str) throws IOException {
        Format createTextContainerFormat;
        Format format;
        int i;
        int i2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Format format2 = null;
        Format format3 = null;
        while (lineIterator.hasNext()) {
            String next = lineIterator.next();
            if (next.startsWith(TAG_MEDIA)) {
                int parseSelectionFlags = parseSelectionFlags(next);
                String parseOptionalStringAttr = parseOptionalStringAttr(next, REGEX_URI);
                String parseStringAttr = parseStringAttr(next, REGEX_NAME);
                String parseOptionalStringAttr2 = parseOptionalStringAttr(next, REGEX_LANGUAGE);
                String parseStringAttr2 = parseStringAttr(next, REGEX_TYPE);
                char c2 = 65535;
                switch (parseStringAttr2.hashCode()) {
                    case -959297733:
                        if (parseStringAttr2.equals(TYPE_SUBTITLES)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -333210994:
                        if (parseStringAttr2.equals(TYPE_CLOSED_CAPTIONS)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 62628790:
                        if (parseStringAttr2.equals(TYPE_AUDIO)) {
                            c2 = 0;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        format = Format.createAudioContainerFormat(parseStringAttr, MimeTypes.APPLICATION_M3U8, null, null, -1, -1, -1, null, parseSelectionFlags, parseOptionalStringAttr2);
                        if (parseOptionalStringAttr != null) {
                            arrayList2.add(new HlsMasterPlaylist.HlsUrl(parseStringAttr, parseOptionalStringAttr, format, null, format, null));
                            createTextContainerFormat = format3;
                            format = format2;
                            break;
                        } else {
                            createTextContainerFormat = format3;
                            break;
                        }
                    case 1:
                        Format createTextContainerFormat2 = Format.createTextContainerFormat(parseStringAttr, MimeTypes.APPLICATION_M3U8, MimeTypes.TEXT_VTT, null, -1, parseSelectionFlags, parseOptionalStringAttr2);
                        arrayList3.add(new HlsMasterPlaylist.HlsUrl(parseStringAttr, parseOptionalStringAttr, createTextContainerFormat2, null, createTextContainerFormat2, null));
                        createTextContainerFormat = format3;
                        format = format2;
                        break;
                    case 2:
                        if ("CC1".equals(parseOptionalStringAttr(next, REGEX_INSTREAM_ID))) {
                            createTextContainerFormat = Format.createTextContainerFormat(parseStringAttr, MimeTypes.APPLICATION_M3U8, MimeTypes.APPLICATION_CEA608, null, -1, parseSelectionFlags, parseOptionalStringAttr2);
                            format = format2;
                            break;
                        }
                    default:
                        createTextContainerFormat = format3;
                        format = format2;
                        break;
                }
                format3 = createTextContainerFormat;
                format2 = format;
            } else if (next.startsWith(TAG_STREAM_INF)) {
                int parseIntAttr = parseIntAttr(next, REGEX_BANDWIDTH);
                String parseOptionalStringAttr3 = parseOptionalStringAttr(next, REGEX_CODECS);
                String parseOptionalStringAttr4 = parseOptionalStringAttr(next, REGEX_RESOLUTION);
                if (parseOptionalStringAttr4 != null) {
                    String[] split = parseOptionalStringAttr4.split("x");
                    int parseInt = Integer.parseInt(split[0]);
                    int parseInt2 = Integer.parseInt(split[1]);
                    if (parseInt <= 0 || parseInt2 <= 0) {
                        parseInt = -1;
                        parseInt2 = -1;
                    }
                    i2 = parseInt2;
                    i = parseInt;
                } else {
                    i = -1;
                    i2 = -1;
                }
                String next2 = lineIterator.next();
                String num = Integer.toString(arrayList.size());
                arrayList.add(new HlsMasterPlaylist.HlsUrl(num, next2, Format.createVideoContainerFormat(num, MimeTypes.APPLICATION_M3U8, null, parseOptionalStringAttr3, parseIntAttr, i, i2, -1.0f, null), null, null, null));
            }
        }
        return new HlsMasterPlaylist(str, arrayList, arrayList2, arrayList3, format2, format3);
    }

    private static int parseSelectionFlags(String str) {
        return (parseBooleanAttribute(str, REGEX_DEFAULT, false) ? 1 : 0) | (parseBooleanAttribute(str, REGEX_FORCED, false) ? 2 : 0) | (parseBooleanAttribute(str, REGEX_AUTOSELECT, false) ? 4 : 0);
    }

    private static HlsMediaPlaylist parseMediaPlaylist(LineIterator lineIterator, String str) throws IOException {
        long j;
        String str2;
        String str3;
        String hexString;
        ArrayList arrayList = new ArrayList();
        long j2 = 0;
        long j3 = -1;
        boolean z = false;
        String str4 = null;
        int i = 0;
        double d = 0.0d;
        HlsMediaPlaylist.Segment segment = null;
        boolean z2 = true;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        long j4 = 0;
        String str5 = null;
        while (lineIterator.hasNext()) {
            String next = lineIterator.next();
            if (next.startsWith(TAG_INIT_SEGMENT)) {
                String parseStringAttr = parseStringAttr(next, REGEX_URI);
                String parseOptionalStringAttr = parseOptionalStringAttr(next, REGEX_ATTR_BYTERANGE);
                if (parseOptionalStringAttr != null) {
                    String[] split = parseOptionalStringAttr.split("@");
                    j = Long.parseLong(split[0]);
                    if (split.length > 1) {
                        j2 = Long.parseLong(split[1]);
                    }
                } else {
                    j = j3;
                }
                HlsMediaPlaylist.Segment segment2 = new HlsMediaPlaylist.Segment(parseStringAttr, j2, j);
                j2 = 0;
                j3 = -1;
                segment = segment2;
            } else if (next.startsWith(TAG_TARGET_DURATION)) {
                i3 = parseIntAttr(next, REGEX_TARGET_DURATION);
            } else if (next.startsWith(TAG_MEDIA_SEQUENCE)) {
                int parseIntAttr = parseIntAttr(next, REGEX_MEDIA_SEQUENCE);
                i5 = parseIntAttr;
                i4 = parseIntAttr;
            } else if (next.startsWith(TAG_VERSION)) {
                i2 = parseIntAttr(next, REGEX_VERSION);
            } else if (next.startsWith(TAG_MEDIA_DURATION)) {
                d = parseDoubleAttr(next, REGEX_MEDIA_DURATION);
            } else if (next.startsWith(TAG_KEY)) {
                z = "AES-128".equals(parseStringAttr(next, REGEX_METHOD));
                if (z) {
                    str2 = parseStringAttr(next, REGEX_URI);
                    str3 = parseOptionalStringAttr(next, REGEX_IV);
                } else {
                    str2 = null;
                    str3 = null;
                }
                str5 = str3;
                str4 = str2;
            } else if (next.startsWith(TAG_BYTERANGE)) {
                String[] split2 = parseStringAttr(next, REGEX_BYTERANGE).split("@");
                j3 = Long.parseLong(split2[0]);
                j2 = split2.length > 1 ? Long.parseLong(split2[1]) : j2;
            } else if (next.startsWith(TAG_DISCONTINUITY_SEQUENCE)) {
                i = Integer.parseInt(next.substring(next.indexOf(58) + 1));
            } else if (next.equals(TAG_DISCONTINUITY)) {
                i++;
            } else if (!next.startsWith("#")) {
                if (!z) {
                    hexString = null;
                } else {
                    hexString = str5 != null ? str5 : Integer.toHexString(i5);
                }
                int i6 = i5 + 1;
                long j5 = j3 == -1 ? 0L : j2;
                arrayList.add(new HlsMediaPlaylist.Segment(next, d, i, j4, z, str4, hexString, j5, j3));
                long j6 = j4 + ((long) (1000000.0d * d));
                long j7 = j3 != -1 ? j5 + j3 : j5;
                j3 = -1;
                i5 = i6;
                j4 = j6;
                d = 0.0d;
                j2 = j7;
            } else if (next.equals(TAG_ENDLIST)) {
                z2 = false;
            }
        }
        return new HlsMediaPlaylist(str, i4, i3, i2, z2, segment, Collections.unmodifiableList(arrayList));
    }

    private static String parseStringAttr(String str, Pattern pattern) throws ParserException {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            return matcher.group(1);
        }
        throw new ParserException("Couldn't match " + pattern.pattern() + " in " + str);
    }

    private static int parseIntAttr(String str, Pattern pattern) throws ParserException {
        return Integer.parseInt(parseStringAttr(str, pattern));
    }

    private static double parseDoubleAttr(String str, Pattern pattern) throws ParserException {
        return Double.parseDouble(parseStringAttr(str, pattern));
    }

    private static String parseOptionalStringAttr(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private static boolean parseBooleanAttribute(String str, Pattern pattern, boolean z) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1).equals(BOOLEAN_TRUE);
        }
        return z;
    }

    private static Pattern compileBooleanAttrPattern(String str) {
        return Pattern.compile(str + "=(" + BOOLEAN_FALSE + "|" + BOOLEAN_TRUE + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class LineIterator {
        private final Queue<String> extraLines;
        private String next;
        private final BufferedReader reader;

        public LineIterator(Queue<String> queue, BufferedReader bufferedReader) {
            this.extraLines = queue;
            this.reader = bufferedReader;
        }

        public boolean hasNext() throws IOException {
            if (this.next != null) {
                return true;
            }
            if (!this.extraLines.isEmpty()) {
                this.next = this.extraLines.poll();
                return true;
            }
            do {
                String readLine = this.reader.readLine();
                this.next = readLine;
                if (readLine != null) {
                    this.next = this.next.trim();
                } else {
                    return false;
                }
            } while (this.next.isEmpty());
            return true;
        }

        public String next() throws IOException {
            if (hasNext()) {
                String str = this.next;
                this.next = null;
                return str;
            }
            return null;
        }
    }
}

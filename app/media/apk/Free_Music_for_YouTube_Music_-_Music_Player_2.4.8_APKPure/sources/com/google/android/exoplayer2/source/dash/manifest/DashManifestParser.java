package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes.dex */
public class DashManifestParser extends DefaultHandler implements ParsingLoadable.Parser<DashManifest> {
    private static final Pattern FRAME_RATE_PATTERN = Pattern.compile("(\\d+)(?:/(\\d+))?");
    private static final String TAG = "MpdParser";
    private final String contentId;
    private final XmlPullParserFactory xmlParserFactory;

    public DashManifestParser() {
        this(null);
    }

    public DashManifestParser(String str) {
        this.contentId = str;
        try {
            this.xmlParserFactory = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public DashManifest parse(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.xmlParserFactory.newPullParser();
            newPullParser.setInput(inputStream, null);
            if (newPullParser.next() != 2 || !"MPD".equals(newPullParser.getName())) {
                throw new ParserException("inputStream does not contain a valid media presentation description");
            }
            return parseMediaPresentationDescription(newPullParser, uri.toString());
        } catch (ParseException | XmlPullParserException e) {
            throw new ParserException(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected com.google.android.exoplayer2.source.dash.manifest.DashManifest parseMediaPresentationDescription(org.xmlpull.v1.XmlPullParser r35, java.lang.String r36) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException, java.text.ParseException {
        /*
            Method dump skipped, instructions count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseMediaPresentationDescription(org.xmlpull.v1.XmlPullParser, java.lang.String):com.google.android.exoplayer2.source.dash.manifest.DashManifest");
    }

    protected DashManifest buildMediaPresentationDescription(long j, long j2, long j3, boolean z, long j4, long j5, long j6, UtcTimingElement utcTimingElement, Uri uri, List<Period> list) {
        return new DashManifest(j, j2, j3, z, j4, j5, j6, utcTimingElement, uri, list);
    }

    protected UtcTimingElement parseUtcTiming(XmlPullParser xmlPullParser) {
        return buildUtcTimingElement(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, "value"));
    }

    protected UtcTimingElement buildUtcTimingElement(String str, String str2) {
        return new UtcTimingElement(str, str2);
    }

    protected Pair<Period, Long> parsePeriod(XmlPullParser xmlPullParser, String str, long j) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        long parseDuration = parseDuration(xmlPullParser, TtmlNode.START, j);
        long parseDuration2 = parseDuration(xmlPullParser, "duration", C.TIME_UNSET);
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        SegmentBase segmentBase = null;
        String str2 = str;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "BaseURL")) {
                if (!z) {
                    str2 = parseBaseUrl(xmlPullParser, str2);
                    z = true;
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "AdaptationSet")) {
                arrayList.add(parseAdaptationSet(xmlPullParser, str2, segmentBase));
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentBase")) {
                segmentBase = parseSegmentBase(xmlPullParser, str2, null);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentList")) {
                segmentBase = parseSegmentList(xmlPullParser, str2, null);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTemplate")) {
                segmentBase = parseSegmentTemplate(xmlPullParser, str2, null);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "Period"));
        return Pair.create(buildPeriod(attributeValue, parseDuration, arrayList), Long.valueOf(parseDuration2));
    }

    protected Period buildPeriod(String str, long j, List<AdaptationSet> list) {
        return new Period(str, j, list);
    }

    protected AdaptationSet parseAdaptationSet(XmlPullParser xmlPullParser, String str, SegmentBase segmentBase) throws XmlPullParserException, IOException {
        boolean z;
        int i;
        int parseInt = parseInt(xmlPullParser, "id", -1);
        int parseContentType = parseContentType(xmlPullParser);
        String attributeValue = xmlPullParser.getAttributeValue(null, "mimeType");
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "codecs");
        int parseInt2 = parseInt(xmlPullParser, "width", -1);
        int parseInt3 = parseInt(xmlPullParser, "height", -1);
        float parseFrameRate = parseFrameRate(xmlPullParser, -1.0f);
        int i2 = -1;
        int parseInt4 = parseInt(xmlPullParser, "audioSamplingRate", -1);
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "lang");
        ArrayList<DrmInitData.SchemeData> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        boolean z2 = false;
        SegmentBase segmentBase2 = segmentBase;
        String str2 = str;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "BaseURL")) {
                if (!z2) {
                    str2 = parseBaseUrl(xmlPullParser, str2);
                    z = true;
                    i = parseContentType;
                }
                z = z2;
                i = parseContentType;
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "ContentProtection")) {
                DrmInitData.SchemeData parseContentProtection = parseContentProtection(xmlPullParser);
                if (parseContentProtection != null) {
                    arrayList.add(parseContentProtection);
                }
                z = z2;
                i = parseContentType;
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "ContentComponent")) {
                attributeValue3 = checkLanguageConsistency(attributeValue3, xmlPullParser.getAttributeValue(null, "lang"));
                i = checkContentTypeConsistency(parseContentType, parseContentType(xmlPullParser));
                z = z2;
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "Representation")) {
                RepresentationInfo parseRepresentation = parseRepresentation(xmlPullParser, str2, attributeValue, attributeValue2, parseInt2, parseInt3, parseFrameRate, i2, parseInt4, attributeValue3, segmentBase2);
                int checkContentTypeConsistency = checkContentTypeConsistency(parseContentType, getContentType(parseRepresentation.format));
                arrayList2.add(parseRepresentation);
                i = checkContentTypeConsistency;
                z = z2;
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "AudioChannelConfiguration")) {
                i2 = parseAudioChannelConfiguration(xmlPullParser);
                z = z2;
                i = parseContentType;
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentBase")) {
                segmentBase2 = parseSegmentBase(xmlPullParser, str2, (SegmentBase.SingleSegmentBase) segmentBase2);
                z = z2;
                i = parseContentType;
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentList")) {
                segmentBase2 = parseSegmentList(xmlPullParser, str2, (SegmentBase.SegmentList) segmentBase2);
                z = z2;
                i = parseContentType;
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTemplate")) {
                segmentBase2 = parseSegmentTemplate(xmlPullParser, str2, (SegmentBase.SegmentTemplate) segmentBase2);
                z = z2;
                i = parseContentType;
            } else {
                if (XmlPullParserUtil.isStartTag(xmlPullParser)) {
                    parseAdaptationSetChild(xmlPullParser);
                }
                z = z2;
                i = parseContentType;
            }
            if (XmlPullParserUtil.isEndTag(xmlPullParser, "AdaptationSet")) {
                break;
            }
            z2 = z;
            parseContentType = i;
        }
        ArrayList arrayList3 = new ArrayList(arrayList2.size());
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < arrayList2.size()) {
                arrayList3.add(buildRepresentation((RepresentationInfo) arrayList2.get(i4), this.contentId, arrayList));
                i3 = i4 + 1;
            } else {
                return buildAdaptationSet(parseInt, i, arrayList3);
            }
        }
    }

    protected AdaptationSet buildAdaptationSet(int i, int i2, List<Representation> list) {
        return new AdaptationSet(i, i2, list);
    }

    protected int parseContentType(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        return MimeTypes.BASE_TYPE_TEXT.equals(attributeValue) ? 3 : -1;
    }

    protected int getContentType(Format format) {
        String str = format.sampleMimeType;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (MimeTypes.isVideo(str)) {
            return 2;
        }
        if (MimeTypes.isAudio(str)) {
            return 1;
        }
        return (mimeTypeIsRawText(str) || MimeTypes.APPLICATION_RAWCC.equals(format.containerMimeType)) ? 3 : -1;
    }

    protected DrmInitData.SchemeData parseContentProtection(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        boolean z = false;
        boolean z2 = false;
        UUID uuid = null;
        byte[] bArr = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "cenc:pssh") && xmlPullParser.next() == 4) {
                byte[] decode = Base64.decode(xmlPullParser.getText(), 0);
                bArr = decode;
                uuid = PsshAtomUtil.parseUuid(decode);
                z2 = true;
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "widevine:license")) {
                String attributeValue = xmlPullParser.getAttributeValue(null, "robustness_level");
                z = attributeValue != null && attributeValue.startsWith("HW");
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "ContentProtection"));
        if (z2) {
            if (uuid != null) {
                return new DrmInitData.SchemeData(uuid, MimeTypes.VIDEO_MP4, bArr, z);
            }
            Log.w(TAG, "Skipped unsupported ContentProtection element");
            return null;
        }
        return null;
    }

    protected void parseAdaptationSetChild(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
    }

    protected RepresentationInfo parseRepresentation(XmlPullParser xmlPullParser, String str, String str2, String str3, int i, int i2, float f, int i3, int i4, String str4, SegmentBase segmentBase) throws XmlPullParserException, IOException {
        DrmInitData.SchemeData parseContentProtection;
        String str5;
        SegmentBase.SingleSegmentBase parseSegmentTemplate;
        boolean z;
        int i5;
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        int parseInt = parseInt(xmlPullParser, "bandwidth", -1);
        String parseString = parseString(xmlPullParser, "mimeType", str2);
        String parseString2 = parseString(xmlPullParser, "codecs", str3);
        int parseInt2 = parseInt(xmlPullParser, "width", i);
        int parseInt3 = parseInt(xmlPullParser, "height", i2);
        float parseFrameRate = parseFrameRate(xmlPullParser, f);
        int parseInt4 = parseInt(xmlPullParser, "audioSamplingRate", i4);
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        int i6 = i3;
        SegmentBase segmentBase2 = segmentBase;
        String str6 = str;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "BaseURL")) {
                if (!z2) {
                    str5 = parseBaseUrl(xmlPullParser, str6);
                    parseSegmentTemplate = segmentBase2;
                    z = true;
                    i5 = i6;
                }
                str5 = str6;
                parseSegmentTemplate = segmentBase2;
                z = z2;
                i5 = i6;
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "AudioChannelConfiguration")) {
                str5 = str6;
                parseSegmentTemplate = segmentBase2;
                z = z2;
                i5 = parseAudioChannelConfiguration(xmlPullParser);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentBase")) {
                str5 = str6;
                parseSegmentTemplate = parseSegmentBase(xmlPullParser, str6, (SegmentBase.SingleSegmentBase) segmentBase2);
                z = z2;
                i5 = i6;
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentList")) {
                str5 = str6;
                parseSegmentTemplate = parseSegmentList(xmlPullParser, str6, (SegmentBase.SegmentList) segmentBase2);
                z = z2;
                i5 = i6;
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTemplate")) {
                str5 = str6;
                parseSegmentTemplate = parseSegmentTemplate(xmlPullParser, str6, (SegmentBase.SegmentTemplate) segmentBase2);
                z = z2;
                i5 = i6;
            } else {
                if (XmlPullParserUtil.isStartTag(xmlPullParser, "ContentProtection") && (parseContentProtection = parseContentProtection(xmlPullParser)) != null) {
                    arrayList.add(parseContentProtection);
                }
                str5 = str6;
                parseSegmentTemplate = segmentBase2;
                z = z2;
                i5 = i6;
            }
            if (XmlPullParserUtil.isEndTag(xmlPullParser, "Representation")) {
                break;
            }
            i6 = i5;
            z2 = z;
            segmentBase2 = parseSegmentTemplate;
            str6 = str5;
        }
        Format buildFormat = buildFormat(attributeValue, parseString, parseInt2, parseInt3, parseFrameRate, i5, parseInt4, parseInt, str4, parseString2);
        if (parseSegmentTemplate == null) {
            parseSegmentTemplate = new SegmentBase.SingleSegmentBase(str5);
        }
        return new RepresentationInfo(buildFormat, parseSegmentTemplate, arrayList);
    }

    protected Format buildFormat(String str, String str2, int i, int i2, float f, int i3, int i4, int i5, String str3, String str4) {
        String sampleMimeType = getSampleMimeType(str2, str4);
        if (sampleMimeType != null) {
            if (MimeTypes.isVideo(sampleMimeType)) {
                return Format.createVideoContainerFormat(str, str2, sampleMimeType, str4, i5, i, i2, f, null);
            }
            if (MimeTypes.isAudio(sampleMimeType)) {
                return Format.createAudioContainerFormat(str, str2, sampleMimeType, str4, i5, i3, i4, null, 0, str3);
            }
            if (mimeTypeIsRawText(sampleMimeType)) {
                return Format.createTextContainerFormat(str, str2, sampleMimeType, str4, i5, 0, str3);
            }
            return Format.createContainerFormat(str, str2, str4, sampleMimeType, i5);
        }
        return Format.createContainerFormat(str, str2, str4, sampleMimeType, i5);
    }

    protected Representation buildRepresentation(RepresentationInfo representationInfo, String str, ArrayList<DrmInitData.SchemeData> arrayList) {
        Format format = representationInfo.format;
        ArrayList<DrmInitData.SchemeData> arrayList2 = representationInfo.drmSchemeDatas;
        arrayList2.addAll(arrayList);
        if (!arrayList2.isEmpty()) {
            format = format.copyWithDrmInitData(new DrmInitData(arrayList2));
        }
        return Representation.newInstance(str, -1L, format, representationInfo.segmentBase);
    }

    protected SegmentBase.SingleSegmentBase parseSegmentBase(XmlPullParser xmlPullParser, String str, SegmentBase.SingleSegmentBase singleSegmentBase) throws XmlPullParserException, IOException {
        long j;
        long parseLong = parseLong(xmlPullParser, "timescale", singleSegmentBase != null ? singleSegmentBase.timescale : 1L);
        long parseLong2 = parseLong(xmlPullParser, "presentationTimeOffset", singleSegmentBase != null ? singleSegmentBase.presentationTimeOffset : 0L);
        long j2 = singleSegmentBase != null ? singleSegmentBase.indexStart : 0L;
        long j3 = singleSegmentBase != null ? singleSegmentBase.indexLength : 0L;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split("-");
            j2 = Long.parseLong(split[0]);
            j = (Long.parseLong(split[1]) - j2) + 1;
        } else {
            j = j3;
        }
        RangedUri rangedUri = singleSegmentBase != null ? singleSegmentBase.initialization : null;
        while (true) {
            xmlPullParser.next();
            RangedUri parseInitialization = XmlPullParserUtil.isStartTag(xmlPullParser, "Initialization") ? parseInitialization(xmlPullParser, str) : rangedUri;
            if (XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentBase")) {
                return buildSingleSegmentBase(parseInitialization, parseLong, parseLong2, str, j2, j);
            }
            rangedUri = parseInitialization;
        }
    }

    protected SegmentBase.SingleSegmentBase buildSingleSegmentBase(RangedUri rangedUri, long j, long j2, String str, long j3, long j4) {
        return new SegmentBase.SingleSegmentBase(rangedUri, j, j2, str, j3, j4);
    }

    protected SegmentBase.SegmentList parseSegmentList(XmlPullParser xmlPullParser, String str, SegmentBase.SegmentList segmentList) throws XmlPullParserException, IOException {
        List<RangedUri> list;
        RangedUri rangedUri;
        List<SegmentBase.SegmentTimelineElement> list2;
        RangedUri rangedUri2 = null;
        long parseLong = parseLong(xmlPullParser, "timescale", segmentList != null ? segmentList.timescale : 1L);
        long parseLong2 = parseLong(xmlPullParser, "presentationTimeOffset", segmentList != null ? segmentList.presentationTimeOffset : 0L);
        long parseLong3 = parseLong(xmlPullParser, "duration", segmentList != null ? segmentList.duration : C.TIME_UNSET);
        int parseInt = parseInt(xmlPullParser, "startNumber", segmentList != null ? segmentList.startNumber : 1);
        List<RangedUri> list3 = null;
        List<SegmentBase.SegmentTimelineElement> list4 = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "Initialization")) {
                rangedUri2 = parseInitialization(xmlPullParser, str);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTimeline")) {
                list4 = parseSegmentTimeline(xmlPullParser);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentURL")) {
                if (list3 == null) {
                    list3 = new ArrayList<>();
                }
                list3.add(parseSegmentUrl(xmlPullParser, str));
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentList"));
        if (segmentList != null) {
            RangedUri rangedUri3 = rangedUri2 != null ? rangedUri2 : segmentList.initialization;
            list2 = list4 != null ? list4 : segmentList.segmentTimeline;
            if (list3 == null) {
                list3 = segmentList.mediaSegments;
            }
            rangedUri = rangedUri3;
            list = list3;
        } else {
            list = list3;
            List<SegmentBase.SegmentTimelineElement> list5 = list4;
            rangedUri = rangedUri2;
            list2 = list5;
        }
        return buildSegmentList(rangedUri, parseLong, parseLong2, parseInt, parseLong3, list2, list);
    }

    protected SegmentBase.SegmentList buildSegmentList(RangedUri rangedUri, long j, long j2, int i, long j3, List<SegmentBase.SegmentTimelineElement> list, List<RangedUri> list2) {
        return new SegmentBase.SegmentList(rangedUri, j, j2, i, j3, list, list2);
    }

    protected SegmentBase.SegmentTemplate parseSegmentTemplate(XmlPullParser xmlPullParser, String str, SegmentBase.SegmentTemplate segmentTemplate) throws XmlPullParserException, IOException {
        List<SegmentBase.SegmentTimelineElement> list;
        long parseLong = parseLong(xmlPullParser, "timescale", segmentTemplate != null ? segmentTemplate.timescale : 1L);
        long parseLong2 = parseLong(xmlPullParser, "presentationTimeOffset", segmentTemplate != null ? segmentTemplate.presentationTimeOffset : 0L);
        long parseLong3 = parseLong(xmlPullParser, "duration", segmentTemplate != null ? segmentTemplate.duration : C.TIME_UNSET);
        int parseInt = parseInt(xmlPullParser, "startNumber", segmentTemplate != null ? segmentTemplate.startNumber : 1);
        UrlTemplate parseUrlTemplate = parseUrlTemplate(xmlPullParser, "media", segmentTemplate != null ? segmentTemplate.mediaTemplate : null);
        UrlTemplate parseUrlTemplate2 = parseUrlTemplate(xmlPullParser, "initialization", segmentTemplate != null ? segmentTemplate.initializationTemplate : null);
        RangedUri rangedUri = null;
        List<SegmentBase.SegmentTimelineElement> list2 = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "Initialization")) {
                rangedUri = parseInitialization(xmlPullParser, str);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTimeline")) {
                list2 = parseSegmentTimeline(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentTemplate"));
        if (segmentTemplate != null) {
            if (rangedUri == null) {
                rangedUri = segmentTemplate.initialization;
            }
            if (list2 == null) {
                list2 = segmentTemplate.segmentTimeline;
            }
            list = list2;
        } else {
            list = list2;
        }
        return buildSegmentTemplate(rangedUri, parseLong, parseLong2, parseInt, parseLong3, list, parseUrlTemplate2, parseUrlTemplate, str);
    }

    protected SegmentBase.SegmentTemplate buildSegmentTemplate(RangedUri rangedUri, long j, long j2, int i, long j3, List<SegmentBase.SegmentTimelineElement> list, UrlTemplate urlTemplate, UrlTemplate urlTemplate2, String str) {
        return new SegmentBase.SegmentTemplate(rangedUri, j, j2, i, j3, list, urlTemplate, urlTemplate2, str);
    }

    protected List<SegmentBase.SegmentTimelineElement> parseSegmentTimeline(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        long j = 0;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "S")) {
                j = parseLong(xmlPullParser, "t", j);
                long parseLong = parseLong(xmlPullParser, "d", C.TIME_UNSET);
                int parseInt = parseInt(xmlPullParser, "r", 0) + 1;
                int i = 0;
                while (i < parseInt) {
                    arrayList.add(buildSegmentTimelineElement(j, parseLong));
                    i++;
                    j += parseLong;
                }
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentTimeline"));
        return arrayList;
    }

    protected SegmentBase.SegmentTimelineElement buildSegmentTimelineElement(long j, long j2) {
        return new SegmentBase.SegmentTimelineElement(j, j2);
    }

    protected UrlTemplate parseUrlTemplate(XmlPullParser xmlPullParser, String str, UrlTemplate urlTemplate) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            return UrlTemplate.compile(attributeValue);
        }
        return urlTemplate;
    }

    protected RangedUri parseInitialization(XmlPullParser xmlPullParser, String str) {
        return parseRangedUrl(xmlPullParser, str, "sourceURL", "range");
    }

    protected RangedUri parseSegmentUrl(XmlPullParser xmlPullParser, String str) {
        return parseRangedUrl(xmlPullParser, str, "media", "mediaRange");
    }

    protected RangedUri parseRangedUrl(XmlPullParser xmlPullParser, String str, String str2, String str3) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str2);
        long j = 0;
        long j2 = -1;
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str3);
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split("-");
            j = Long.parseLong(split[0]);
            if (split.length == 2) {
                j2 = 1 + (Long.parseLong(split[1]) - j);
            }
        }
        return buildRangedUri(str, attributeValue, j, j2);
    }

    protected RangedUri buildRangedUri(String str, String str2, long j, long j2) {
        return new RangedUri(str, str2, j, j2);
    }

    protected int parseAudioChannelConfiguration(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int parseInt = "urn:mpeg:dash:23003:3:audio_channel_configuration:2011".equals(parseString(xmlPullParser, "schemeIdUri", null)) ? parseInt(xmlPullParser, "value", -1) : -1;
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "AudioChannelConfiguration"));
        return parseInt;
    }

    private static String getSampleMimeType(String str, String str2) {
        if (MimeTypes.isAudio(str)) {
            return MimeTypes.getAudioMediaMimeType(str2);
        }
        if (MimeTypes.isVideo(str)) {
            return MimeTypes.getVideoMediaMimeType(str2);
        }
        if (MimeTypes.APPLICATION_RAWCC.equals(str)) {
            if (str2 != null) {
                if (str2.contains("cea708")) {
                    return MimeTypes.APPLICATION_CEA708;
                }
                if (str2.contains("eia608") || str2.contains("cea608")) {
                    return MimeTypes.APPLICATION_CEA608;
                }
            }
            return null;
        } else if (!mimeTypeIsRawText(str)) {
            if (MimeTypes.APPLICATION_MP4.equals(str)) {
                if ("stpp".equals(str2)) {
                    return MimeTypes.APPLICATION_TTML;
                }
                if ("wvtt".equals(str2)) {
                    return MimeTypes.APPLICATION_MP4VTT;
                }
            }
            return null;
        } else {
            return str;
        }
    }

    private static boolean mimeTypeIsRawText(String str) {
        return MimeTypes.isText(str) || MimeTypes.APPLICATION_TTML.equals(str);
    }

    private static String checkLanguageConsistency(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 != null) {
            Assertions.checkState(str.equals(str2));
            return str;
        }
        return str;
    }

    private static int checkContentTypeConsistency(int i, int i2) {
        if (i == -1) {
            return i2;
        }
        if (i2 != -1) {
            Assertions.checkState(i == i2);
            return i;
        }
        return i;
    }

    protected static float parseFrameRate(XmlPullParser xmlPullParser, float f) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue != null) {
            Matcher matcher = FRAME_RATE_PATTERN.matcher(attributeValue);
            if (matcher.matches()) {
                int parseInt = Integer.parseInt(matcher.group(1));
                String group = matcher.group(2);
                if (!TextUtils.isEmpty(group)) {
                    return parseInt / Integer.parseInt(group);
                }
                return parseInt;
            }
            return f;
        }
        return f;
    }

    protected static long parseDuration(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : Util.parseXsDuration(attributeValue);
    }

    protected static long parseDateTime(XmlPullParser xmlPullParser, String str, long j) throws ParseException {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : Util.parseXsDateTime(attributeValue);
    }

    protected static String parseBaseUrl(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        xmlPullParser.next();
        return UriUtil.resolve(str, xmlPullParser.getText());
    }

    protected static int parseInt(XmlPullParser xmlPullParser, String str, int i) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? i : Integer.parseInt(attributeValue);
    }

    protected static long parseLong(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : Long.parseLong(attributeValue);
    }

    protected static String parseString(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class RepresentationInfo {
        public final ArrayList<DrmInitData.SchemeData> drmSchemeDatas;
        public final Format format;
        public final SegmentBase segmentBase;

        public RepresentationInfo(Format format, SegmentBase segmentBase, ArrayList<DrmInitData.SchemeData> arrayList) {
            this.format = format;
            this.segmentBase = segmentBase;
            this.drmSchemeDatas = arrayList;
        }
    }
}

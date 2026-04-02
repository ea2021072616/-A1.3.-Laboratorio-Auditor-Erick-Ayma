package com.google.android.exoplayer2.text.ttml;

import android.text.Layout;
import android.util.Log;
import android.util.Pair;
import com.facebook.appevents.UserDataStore;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes.dex */
public final class TtmlDecoder extends SimpleSubtitleDecoder {
    private static final String ATTR_BEGIN = "begin";
    private static final String ATTR_DURATION = "dur";
    private static final String ATTR_END = "end";
    private static final String ATTR_REGION = "region";
    private static final String ATTR_STYLE = "style";
    private static final int DEFAULT_FRAME_RATE = 30;
    private static final String TAG = "TtmlDecoder";
    private static final String TTP = "http://www.w3.org/ns/ttml#parameter";
    private final XmlPullParserFactory xmlParserFactory;
    private static final Pattern CLOCK_TIME = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern OFFSET_TIME = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern FONT_SIZE = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern PERCENTAGE_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final FrameAndTickRate DEFAULT_FRAME_AND_TICK_RATE = new FrameAndTickRate(30.0f, 1, 1);

    public TtmlDecoder() {
        super(TAG);
        try {
            this.xmlParserFactory = XmlPullParserFactory.newInstance();
            this.xmlParserFactory.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public TtmlSubtitle decode(byte[] bArr, int i) throws SubtitleDecoderException {
        FrameAndTickRate frameAndTickRate;
        int i2;
        TtmlSubtitle ttmlSubtitle;
        TtmlSubtitle ttmlSubtitle2 = null;
        int i3 = 0;
        try {
            XmlPullParser newPullParser = this.xmlParserFactory.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("", new TtmlRegion());
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            LinkedList linkedList = new LinkedList();
            int eventType = newPullParser.getEventType();
            FrameAndTickRate frameAndTickRate2 = DEFAULT_FRAME_AND_TICK_RATE;
            for (int i4 = eventType; i4 != 1; i4 = newPullParser.getEventType()) {
                TtmlNode ttmlNode = (TtmlNode) linkedList.peekLast();
                if (i3 == 0) {
                    String name = newPullParser.getName();
                    if (i4 == 2) {
                        if (TtmlNode.TAG_TT.equals(name)) {
                            frameAndTickRate2 = parseFrameAndTickRates(newPullParser);
                        }
                        if (!isSupportedTag(name)) {
                            Log.i(TAG, "Ignoring unsupported tag: " + newPullParser.getName());
                            int i5 = i3 + 1;
                            ttmlSubtitle = ttmlSubtitle2;
                            frameAndTickRate = frameAndTickRate2;
                            i2 = i5;
                        } else if (TtmlNode.TAG_HEAD.equals(name)) {
                            parseHeader(newPullParser, hashMap, hashMap2);
                            frameAndTickRate = frameAndTickRate2;
                            i2 = i3;
                            ttmlSubtitle = ttmlSubtitle2;
                        } else {
                            try {
                                TtmlNode parseNode = parseNode(newPullParser, ttmlNode, hashMap2, frameAndTickRate2);
                                linkedList.addLast(parseNode);
                                if (ttmlNode != null) {
                                    ttmlNode.addChild(parseNode);
                                }
                                frameAndTickRate = frameAndTickRate2;
                                i2 = i3;
                                ttmlSubtitle = ttmlSubtitle2;
                            } catch (SubtitleDecoderException e) {
                                Log.w(TAG, "Suppressing parser error", e);
                                int i6 = i3 + 1;
                                ttmlSubtitle = ttmlSubtitle2;
                                frameAndTickRate = frameAndTickRate2;
                                i2 = i6;
                            }
                        }
                    } else if (i4 == 4) {
                        ttmlNode.addChild(TtmlNode.buildTextNode(newPullParser.getText()));
                        frameAndTickRate = frameAndTickRate2;
                        i2 = i3;
                        ttmlSubtitle = ttmlSubtitle2;
                    } else if (i4 == 3) {
                        TtmlSubtitle ttmlSubtitle3 = newPullParser.getName().equals(TtmlNode.TAG_TT) ? new TtmlSubtitle((TtmlNode) linkedList.getLast(), hashMap, hashMap2) : ttmlSubtitle2;
                        linkedList.removeLast();
                        FrameAndTickRate frameAndTickRate3 = frameAndTickRate2;
                        i2 = i3;
                        ttmlSubtitle = ttmlSubtitle3;
                        frameAndTickRate = frameAndTickRate3;
                    } else {
                        frameAndTickRate = frameAndTickRate2;
                        i2 = i3;
                        ttmlSubtitle = ttmlSubtitle2;
                    }
                    ttmlSubtitle2 = ttmlSubtitle;
                    i3 = i2;
                    frameAndTickRate2 = frameAndTickRate;
                } else if (i4 == 2) {
                    i3++;
                } else if (i4 == 3) {
                    i3--;
                }
                newPullParser.next();
            }
            return ttmlSubtitle2;
        } catch (IOException e2) {
            throw new IllegalStateException("Unexpected error when reading input.", e2);
        } catch (XmlPullParserException e3) {
            throw new SubtitleDecoderException("Unable to decode source", e3);
        }
    }

    private FrameAndTickRate parseFrameAndTickRates(XmlPullParser xmlPullParser) throws SubtitleDecoderException {
        int i = 30;
        String attributeValue = xmlPullParser.getAttributeValue(TTP, "frameRate");
        if (attributeValue != null) {
            i = Integer.parseInt(attributeValue);
        }
        float f = 1.0f;
        String attributeValue2 = xmlPullParser.getAttributeValue(TTP, "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split(" ");
            if (split.length != 2) {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
            f = Integer.parseInt(split[0]) / Integer.parseInt(split[1]);
        }
        int i2 = DEFAULT_FRAME_AND_TICK_RATE.subFrameRate;
        String attributeValue3 = xmlPullParser.getAttributeValue(TTP, "subFrameRate");
        if (attributeValue3 != null) {
            i2 = Integer.parseInt(attributeValue3);
        }
        int i3 = DEFAULT_FRAME_AND_TICK_RATE.tickRate;
        String attributeValue4 = xmlPullParser.getAttributeValue(TTP, "tickRate");
        if (attributeValue4 != null) {
            i3 = Integer.parseInt(attributeValue4);
        }
        return new FrameAndTickRate(i * f, i2, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Map<String, TtmlStyle> parseHeader(XmlPullParser xmlPullParser, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2) throws IOException, XmlPullParserException {
        Pair<String, TtmlRegion> parseRegionAttributes;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "style")) {
                String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "style");
                TtmlStyle parseStyleAttributes = parseStyleAttributes(xmlPullParser, new TtmlStyle());
                if (attributeValue != null) {
                    for (String str : parseStyleIds(attributeValue)) {
                        parseStyleAttributes.chain(map.get(str));
                    }
                }
                if (parseStyleAttributes.getId() != null) {
                    map.put(parseStyleAttributes.getId(), parseStyleAttributes);
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "region") && (parseRegionAttributes = parseRegionAttributes(xmlPullParser)) != null) {
                map2.put(parseRegionAttributes.first, parseRegionAttributes.second);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, TtmlNode.TAG_HEAD));
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.util.Pair<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlRegion> parseRegionAttributes(org.xmlpull.v1.XmlPullParser r11) {
        /*
            r10 = this;
            r0 = 0
            r9 = 1120403456(0x42c80000, float:100.0)
            r2 = 1
            java.lang.String r1 = "id"
            java.lang.String r5 = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(r11, r1)
            java.lang.String r1 = "origin"
            java.lang.String r4 = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(r11, r1)
            java.lang.String r1 = "extent"
            java.lang.String r6 = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(r11, r1)
            if (r4 == 0) goto L1a
            if (r5 != 0) goto L1b
        L1a:
            return r0
        L1b:
            java.util.regex.Pattern r1 = com.google.android.exoplayer2.text.ttml.TtmlDecoder.PERCENTAGE_COORDINATES
            java.util.regex.Matcher r1 = r1.matcher(r4)
            boolean r3 = r1.matches()
            if (r3 == 0) goto La8
            r3 = 1
            java.lang.String r3 = r1.group(r3)     // Catch: java.lang.NumberFormatException -> L65
            float r3 = java.lang.Float.parseFloat(r3)     // Catch: java.lang.NumberFormatException -> L65
            float r3 = r3 / r9
            r7 = 2
            java.lang.String r1 = r1.group(r7)     // Catch: java.lang.NumberFormatException -> L65
            float r1 = java.lang.Float.parseFloat(r1)     // Catch: java.lang.NumberFormatException -> L65
            float r1 = r1 / r9
            r4 = r3
            r3 = r1
        L3d:
            if (r6 == 0) goto La6
            java.util.regex.Pattern r1 = com.google.android.exoplayer2.text.ttml.TtmlDecoder.PERCENTAGE_COORDINATES
            java.util.regex.Matcher r1 = r1.matcher(r6)
            boolean r7 = r1.matches()
            if (r7 == 0) goto La6
            r7 = 1
            java.lang.String r1 = r1.group(r7)     // Catch: java.lang.NumberFormatException -> L87
            float r1 = java.lang.Float.parseFloat(r1)     // Catch: java.lang.NumberFormatException -> L87
            float r1 = r1 / r9
        L55:
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 == 0) goto L1a
            android.util.Pair r0 = new android.util.Pair
            com.google.android.exoplayer2.text.ttml.TtmlRegion r2 = new com.google.android.exoplayer2.text.ttml.TtmlRegion
            r6 = 0
            r2.<init>(r4, r3, r6, r1)
            r0.<init>(r5, r2)
            goto L1a
        L65:
            r1 = move-exception
            java.lang.String r3 = "TtmlDecoder"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Ignoring region with malformed origin: '"
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.StringBuilder r4 = r7.append(r4)
            java.lang.String r7 = "'"
            java.lang.StringBuilder r4 = r4.append(r7)
            java.lang.String r4 = r4.toString()
            android.util.Log.w(r3, r4, r1)
            r3 = r2
            r4 = r2
            goto L3d
        L87:
            r1 = move-exception
            java.lang.String r7 = "TtmlDecoder"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Ignoring malformed region extent: '"
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.StringBuilder r6 = r8.append(r6)
            java.lang.String r8 = "'"
            java.lang.StringBuilder r6 = r6.append(r8)
            java.lang.String r6 = r6.toString()
            android.util.Log.w(r7, r6, r1)
        La6:
            r1 = r2
            goto L55
        La8:
            r3 = r2
            r4 = r2
            goto L3d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ttml.TtmlDecoder.parseRegionAttributes(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

    private String[] parseStyleIds(String str) {
        return str.split("\\s+");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private TtmlStyle parseStyleAttributes(XmlPullParser xmlPullParser, TtmlStyle ttmlStyle) {
        char c2;
        boolean z;
        char c3;
        int attributeCount = xmlPullParser.getAttributeCount();
        TtmlStyle ttmlStyle2 = ttmlStyle;
        for (int i = 0; i < attributeCount; i++) {
            String attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_FONT_STYLE)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1224696685:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_FONT_FAMILY)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1065511464:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_TEXT_ALIGN)) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -879295043:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_TEXT_DECORATION)) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -734428249:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_FONT_WEIGHT)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 94842723:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_COLOR)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 365601008:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_FONT_SIZE)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1287124693:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    if ("style".equals(xmlPullParser.getName())) {
                        ttmlStyle2 = createIfNull(ttmlStyle2).setId(attributeValue);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    ttmlStyle2 = createIfNull(ttmlStyle2);
                    try {
                        ttmlStyle2.setBackgroundColor(ColorParser.parseTtmlColor(attributeValue));
                        break;
                    } catch (IllegalArgumentException e) {
                        Log.w(TAG, "failed parsing background value: '" + attributeValue + "'");
                        break;
                    }
                case 2:
                    ttmlStyle2 = createIfNull(ttmlStyle2);
                    try {
                        ttmlStyle2.setFontColor(ColorParser.parseTtmlColor(attributeValue));
                        break;
                    } catch (IllegalArgumentException e2) {
                        Log.w(TAG, "failed parsing color value: '" + attributeValue + "'");
                        break;
                    }
                case 3:
                    ttmlStyle2 = createIfNull(ttmlStyle2).setFontFamily(attributeValue);
                    break;
                case 4:
                    try {
                        ttmlStyle2 = createIfNull(ttmlStyle2);
                        parseFontSize(attributeValue, ttmlStyle2);
                        break;
                    } catch (SubtitleDecoderException e3) {
                        Log.w(TAG, "failed parsing fontSize value: '" + attributeValue + "'");
                        break;
                    }
                case 5:
                    ttmlStyle2 = createIfNull(ttmlStyle2).setBold(TtmlNode.BOLD.equalsIgnoreCase(attributeValue));
                    break;
                case 6:
                    ttmlStyle2 = createIfNull(ttmlStyle2).setItalic(TtmlNode.ITALIC.equalsIgnoreCase(attributeValue));
                    break;
                case 7:
                    String lowerInvariant = Util.toLowerInvariant(attributeValue);
                    switch (lowerInvariant.hashCode()) {
                        case -1364013995:
                            if (lowerInvariant.equals(TtmlNode.CENTER)) {
                                c3 = 4;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 100571:
                            if (lowerInvariant.equals("end")) {
                                c3 = 3;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 3317767:
                            if (lowerInvariant.equals(TtmlNode.LEFT)) {
                                c3 = 0;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 108511772:
                            if (lowerInvariant.equals(TtmlNode.RIGHT)) {
                                c3 = 2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 109757538:
                            if (lowerInvariant.equals(TtmlNode.START)) {
                                c3 = 1;
                                break;
                            }
                            c3 = 65535;
                            break;
                        default:
                            c3 = 65535;
                            break;
                    }
                    switch (c3) {
                        case 0:
                            ttmlStyle2 = createIfNull(ttmlStyle2).setTextAlign(Layout.Alignment.ALIGN_NORMAL);
                            continue;
                        case 1:
                            ttmlStyle2 = createIfNull(ttmlStyle2).setTextAlign(Layout.Alignment.ALIGN_NORMAL);
                            continue;
                        case 2:
                            ttmlStyle2 = createIfNull(ttmlStyle2).setTextAlign(Layout.Alignment.ALIGN_OPPOSITE);
                            continue;
                        case 3:
                            ttmlStyle2 = createIfNull(ttmlStyle2).setTextAlign(Layout.Alignment.ALIGN_OPPOSITE);
                            continue;
                        case 4:
                            ttmlStyle2 = createIfNull(ttmlStyle2).setTextAlign(Layout.Alignment.ALIGN_CENTER);
                            continue;
                    }
                case '\b':
                    String lowerInvariant2 = Util.toLowerInvariant(attributeValue);
                    switch (lowerInvariant2.hashCode()) {
                        case -1461280213:
                            if (lowerInvariant2.equals(TtmlNode.NO_UNDERLINE)) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case -1026963764:
                            if (lowerInvariant2.equals(TtmlNode.UNDERLINE)) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 913457136:
                            if (lowerInvariant2.equals(TtmlNode.NO_LINETHROUGH)) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 1679736913:
                            if (lowerInvariant2.equals(TtmlNode.LINETHROUGH)) {
                                z = false;
                                break;
                            }
                            z = true;
                            break;
                        default:
                            z = true;
                            break;
                    }
                    switch (z) {
                        case false:
                            ttmlStyle2 = createIfNull(ttmlStyle2).setLinethrough(true);
                            continue;
                        case true:
                            ttmlStyle2 = createIfNull(ttmlStyle2).setLinethrough(false);
                            continue;
                        case true:
                            ttmlStyle2 = createIfNull(ttmlStyle2).setUnderline(true);
                            continue;
                        case true:
                            ttmlStyle2 = createIfNull(ttmlStyle2).setUnderline(false);
                            continue;
                    }
            }
        }
        return ttmlStyle2;
    }

    private TtmlStyle createIfNull(TtmlStyle ttmlStyle) {
        return ttmlStyle == null ? new TtmlStyle() : ttmlStyle;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.google.android.exoplayer2.text.ttml.TtmlNode parseNode(org.xmlpull.v1.XmlPullParser r20, com.google.android.exoplayer2.text.ttml.TtmlNode r21, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlRegion> r22, com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate r23) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ttml.TtmlDecoder.parseNode(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlNode, java.util.Map, com.google.android.exoplayer2.text.ttml.TtmlDecoder$FrameAndTickRate):com.google.android.exoplayer2.text.ttml.TtmlNode");
    }

    private static boolean isSupportedTag(String str) {
        return str.equals(TtmlNode.TAG_TT) || str.equals(TtmlNode.TAG_HEAD) || str.equals(TtmlNode.TAG_BODY) || str.equals(TtmlNode.TAG_DIV) || str.equals(TtmlNode.TAG_P) || str.equals(TtmlNode.TAG_SPAN) || str.equals(TtmlNode.TAG_BR) || str.equals("style") || str.equals(TtmlNode.TAG_STYLING) || str.equals(TtmlNode.TAG_LAYOUT) || str.equals("region") || str.equals(TtmlNode.TAG_METADATA) || str.equals(TtmlNode.TAG_SMPTE_IMAGE) || str.equals(TtmlNode.TAG_SMPTE_DATA) || str.equals(TtmlNode.TAG_SMPTE_INFORMATION);
    }

    private static void parseFontSize(String str, TtmlStyle ttmlStyle) throws SubtitleDecoderException {
        Matcher matcher;
        String[] split = str.split("\\s+");
        if (split.length == 1) {
            matcher = FONT_SIZE.matcher(str);
        } else if (split.length == 2) {
            matcher = FONT_SIZE.matcher(split[1]);
            Log.w(TAG, "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + split.length + ".");
        }
        if (matcher.matches()) {
            String group = matcher.group(3);
            char c2 = 65535;
            switch (group.hashCode()) {
                case 37:
                    if (group.equals("%")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3240:
                    if (group.equals(UserDataStore.EMAIL)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3592:
                    if (group.equals("px")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    ttmlStyle.setFontSizeUnit(1);
                    break;
                case 1:
                    ttmlStyle.setFontSizeUnit(2);
                    break;
                case 2:
                    ttmlStyle.setFontSizeUnit(3);
                    break;
                default:
                    throw new SubtitleDecoderException("Invalid unit for fontSize: '" + group + "'.");
            }
            ttmlStyle.setFontSize(Float.valueOf(matcher.group(1)).floatValue());
            return;
        }
        throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
    }

    private static long parseTimeExpression(String str, FrameAndTickRate frameAndTickRate) throws SubtitleDecoderException {
        String group;
        String group2;
        Matcher matcher = CLOCK_TIME.matcher(str);
        if (matcher.matches()) {
            double parseLong = Long.parseLong(matcher.group(3)) + (Long.parseLong(matcher.group(1)) * 3600) + (Long.parseLong(matcher.group(2)) * 60);
            String group3 = matcher.group(4);
            return (long) (((matcher.group(5) != null ? ((float) Long.parseLong(group)) / frameAndTickRate.effectiveFrameRate : 0.0d) + parseLong + (group3 != null ? Double.parseDouble(group3) : 0.0d) + (matcher.group(6) != null ? (Long.parseLong(group2) / frameAndTickRate.subFrameRate) / frameAndTickRate.effectiveFrameRate : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = OFFSET_TIME.matcher(str);
        if (matcher2.matches()) {
            double parseDouble = Double.parseDouble(matcher2.group(1));
            String group4 = matcher2.group(2);
            char c2 = 65535;
            switch (group4.hashCode()) {
                case 102:
                    if (group4.equals("f")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 104:
                    if (group4.equals("h")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 109:
                    if (group4.equals("m")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 115:
                    if (group4.equals("s")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 116:
                    if (group4.equals("t")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 3494:
                    if (group4.equals("ms")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    parseDouble *= 3600.0d;
                    break;
                case 1:
                    parseDouble *= 60.0d;
                    break;
                case 3:
                    parseDouble /= 1000.0d;
                    break;
                case 4:
                    parseDouble /= frameAndTickRate.effectiveFrameRate;
                    break;
                case 5:
                    parseDouble /= frameAndTickRate.tickRate;
                    break;
            }
            return (long) (parseDouble * 1000000.0d);
        }
        throw new SubtitleDecoderException("Malformed time expression: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class FrameAndTickRate {
        final float effectiveFrameRate;
        final int subFrameRate;
        final int tickRate;

        FrameAndTickRate(float f, int i, int i2) {
            this.effectiveFrameRate = f;
            this.subFrameRate = i;
            this.tickRate = i2;
        }
    }
}

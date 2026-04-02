package com.google.android.exoplayer2.text.webvtt;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.text.webvtt.WebvttCue;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class WebvttCueParser {
    private static final char CHAR_AMPERSAND = '&';
    private static final char CHAR_GREATER_THAN = '>';
    private static final char CHAR_LESS_THAN = '<';
    private static final char CHAR_SEMI_COLON = ';';
    private static final char CHAR_SLASH = '/';
    private static final char CHAR_SPACE = ' ';
    public static final Pattern CUE_HEADER_PATTERN = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    private static final Pattern CUE_SETTING_PATTERN = Pattern.compile("(\\S+?):(\\S+)");
    private static final String ENTITY_AMPERSAND = "amp";
    private static final String ENTITY_GREATER_THAN = "gt";
    private static final String ENTITY_LESS_THAN = "lt";
    private static final String ENTITY_NON_BREAK_SPACE = "nbsp";
    private static final int STYLE_BOLD = 1;
    private static final int STYLE_ITALIC = 2;
    private static final String TAG = "WebvttCueParser";
    private static final String TAG_BOLD = "b";
    private static final String TAG_CLASS = "c";
    private static final String TAG_ITALIC = "i";
    private static final String TAG_LANG = "lang";
    private static final String TAG_UNDERLINE = "u";
    private static final String TAG_VOICE = "v";
    private final StringBuilder textBuilder = new StringBuilder();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean parseCue(ParsableByteArray parsableByteArray, WebvttCue.Builder builder, List<WebvttCssStyle> list) {
        String readLine = parsableByteArray.readLine();
        Matcher matcher = CUE_HEADER_PATTERN.matcher(readLine);
        if (matcher.matches()) {
            return parseCue(null, matcher, parsableByteArray, builder, this.textBuilder, list);
        }
        Matcher matcher2 = CUE_HEADER_PATTERN.matcher(parsableByteArray.readLine());
        if (matcher2.matches()) {
            return parseCue(readLine.trim(), matcher2, parsableByteArray, builder, this.textBuilder, list);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void parseCueSettingsList(String str, WebvttCue.Builder builder) {
        Matcher matcher = CUE_SETTING_PATTERN.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            try {
                if ("line".equals(group)) {
                    parseLineAttribute(group2, builder);
                } else if ("align".equals(group)) {
                    builder.setTextAlignment(parseTextAlignment(group2));
                } else if ("position".equals(group)) {
                    parsePositionAttribute(group2, builder);
                } else if ("size".equals(group)) {
                    builder.setWidth(WebvttParserUtil.parsePercentage(group2));
                } else {
                    Log.w(TAG, "Unknown cue setting " + group + ":" + group2);
                }
            } catch (NumberFormatException e) {
                Log.w(TAG, "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void parseCueText(String str, String str2, WebvttCue.Builder builder, List<WebvttCssStyle> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Stack stack = new Stack();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < str2.length()) {
            char charAt = str2.charAt(i);
            switch (charAt) {
                case '&':
                    int indexOf = str2.indexOf(59, i + 1);
                    int indexOf2 = str2.indexOf(32, i + 1);
                    if (indexOf == -1) {
                        indexOf = indexOf2;
                    } else if (indexOf2 != -1) {
                        indexOf = Math.min(indexOf, indexOf2);
                    }
                    if (indexOf != -1) {
                        applyEntity(str2.substring(i + 1, indexOf), spannableStringBuilder);
                        if (indexOf == indexOf2) {
                            spannableStringBuilder.append(" ");
                        }
                        i = indexOf + 1;
                        break;
                    } else {
                        spannableStringBuilder.append(charAt);
                        i++;
                        break;
                    }
                case '<':
                    if (i + 1 >= str2.length()) {
                        i++;
                        break;
                    } else {
                        boolean z = str2.charAt(i + 1) == '/';
                        int findEndOfTag = findEndOfTag(str2, i + 1);
                        boolean z2 = str2.charAt(findEndOfTag + (-2)) == '/';
                        String substring = str2.substring((z ? 2 : 1) + i, z2 ? findEndOfTag - 2 : findEndOfTag - 1);
                        String tagName = getTagName(substring);
                        if (tagName != null) {
                            if (!isSupportedTag(tagName)) {
                                i = findEndOfTag;
                                break;
                            } else if (z) {
                                while (!stack.isEmpty()) {
                                    StartTag startTag = (StartTag) stack.pop();
                                    applySpansForTag(str, startTag, spannableStringBuilder, list, arrayList);
                                    if (startTag.name.equals(tagName)) {
                                        i = findEndOfTag;
                                        break;
                                    }
                                }
                                i = findEndOfTag;
                            } else if (!z2) {
                                stack.push(StartTag.buildStartTag(substring, spannableStringBuilder.length()));
                                i = findEndOfTag;
                                break;
                            }
                        }
                        i = findEndOfTag;
                        break;
                    }
                default:
                    spannableStringBuilder.append(charAt);
                    i++;
                    break;
            }
        }
        while (!stack.isEmpty()) {
            applySpansForTag(str, (StartTag) stack.pop(), spannableStringBuilder, list, arrayList);
        }
        applySpansForTag(str, StartTag.buildWholeCueVirtualTag(), spannableStringBuilder, list, arrayList);
        builder.setText(spannableStringBuilder);
    }

    private static boolean parseCue(String str, Matcher matcher, ParsableByteArray parsableByteArray, WebvttCue.Builder builder, StringBuilder sb, List<WebvttCssStyle> list) {
        try {
            builder.setStartTime(WebvttParserUtil.parseTimestampUs(matcher.group(1))).setEndTime(WebvttParserUtil.parseTimestampUs(matcher.group(2)));
            parseCueSettingsList(matcher.group(3), builder);
            sb.setLength(0);
            while (true) {
                String readLine = parsableByteArray.readLine();
                if (readLine == null || readLine.isEmpty()) {
                    break;
                }
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(readLine.trim());
            }
            parseCueText(str, sb.toString(), builder, list);
            return true;
        } catch (NumberFormatException e) {
            Log.w(TAG, "Skipping cue with bad header: " + matcher.group());
            return false;
        }
    }

    private static void parseLineAttribute(String str, WebvttCue.Builder builder) throws NumberFormatException {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            builder.setLineAnchor(parsePositionAnchor(str.substring(indexOf + 1)));
            str = str.substring(0, indexOf);
        } else {
            builder.setLineAnchor(Integer.MIN_VALUE);
        }
        if (str.endsWith("%")) {
            builder.setLine(WebvttParserUtil.parsePercentage(str)).setLineType(0);
        } else {
            builder.setLine(Integer.parseInt(str)).setLineType(1);
        }
    }

    private static void parsePositionAttribute(String str, WebvttCue.Builder builder) throws NumberFormatException {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            builder.setPositionAnchor(parsePositionAnchor(str.substring(indexOf + 1)));
            str = str.substring(0, indexOf);
        } else {
            builder.setPositionAnchor(Integer.MIN_VALUE);
        }
        builder.setPosition(WebvttParserUtil.parsePercentage(str));
    }

    private static int parsePositionAnchor(String str) {
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(TtmlNode.CENTER)) {
                    c2 = 1;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c2 = 2;
                    break;
                }
                break;
            case 100571:
                if (str.equals(TtmlNode.END)) {
                    c2 = 3;
                    break;
                }
                break;
            case 109757538:
                if (str.equals(TtmlNode.START)) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                Log.w(TAG, "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    private static Layout.Alignment parseTextAlignment(String str) {
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(TtmlNode.CENTER)) {
                    c2 = 2;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c2 = 3;
                    break;
                }
                break;
            case 100571:
                if (str.equals(TtmlNode.END)) {
                    c2 = 4;
                    break;
                }
                break;
            case 3317767:
                if (str.equals(TtmlNode.LEFT)) {
                    c2 = 1;
                    break;
                }
                break;
            case 108511772:
                if (str.equals(TtmlNode.RIGHT)) {
                    c2 = 5;
                    break;
                }
                break;
            case 109757538:
                if (str.equals(TtmlNode.START)) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 3:
                return Layout.Alignment.ALIGN_CENTER;
            case 4:
            case 5:
                return Layout.Alignment.ALIGN_OPPOSITE;
            default:
                Log.w(TAG, "Invalid alignment value: " + str);
                return null;
        }
    }

    private static int findEndOfTag(String str, int i) {
        int indexOf = str.indexOf(62, i);
        return indexOf == -1 ? str.length() : indexOf + 1;
    }

    private static void applyEntity(String str, SpannableStringBuilder spannableStringBuilder) {
        char c2 = 65535;
        switch (str.hashCode()) {
            case 3309:
                if (str.equals(ENTITY_GREATER_THAN)) {
                    c2 = 1;
                    break;
                }
                break;
            case 3464:
                if (str.equals(ENTITY_LESS_THAN)) {
                    c2 = 0;
                    break;
                }
                break;
            case 96708:
                if (str.equals(ENTITY_AMPERSAND)) {
                    c2 = 3;
                    break;
                }
                break;
            case 3374865:
                if (str.equals(ENTITY_NON_BREAK_SPACE)) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                spannableStringBuilder.append(CHAR_LESS_THAN);
                return;
            case 1:
                spannableStringBuilder.append(CHAR_GREATER_THAN);
                return;
            case 2:
                spannableStringBuilder.append(CHAR_SPACE);
                return;
            case 3:
                spannableStringBuilder.append(CHAR_AMPERSAND);
                return;
            default:
                Log.w(TAG, "ignoring unsupported entity: '&" + str + ";'");
                return;
        }
    }

    private static boolean isSupportedTag(String str) {
        char c2 = 65535;
        switch (str.hashCode()) {
            case 98:
                if (str.equals(TAG_BOLD)) {
                    c2 = 0;
                    break;
                }
                break;
            case 99:
                if (str.equals(TAG_CLASS)) {
                    c2 = 1;
                    break;
                }
                break;
            case 105:
                if (str.equals(TAG_ITALIC)) {
                    c2 = 2;
                    break;
                }
                break;
            case 117:
                if (str.equals(TAG_UNDERLINE)) {
                    c2 = 4;
                    break;
                }
                break;
            case 118:
                if (str.equals(TAG_VOICE)) {
                    c2 = 5;
                    break;
                }
                break;
            case 3314158:
                if (str.equals(TAG_LANG)) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            default:
                return false;
        }
    }

    private static void applySpansForTag(String str, StartTag startTag, SpannableStringBuilder spannableStringBuilder, List<WebvttCssStyle> list, List<StyleMatch> list2) {
        int i = startTag.position;
        int length = spannableStringBuilder.length();
        String str2 = startTag.name;
        char c2 = 65535;
        switch (str2.hashCode()) {
            case 0:
                if (str2.equals("")) {
                    c2 = 6;
                    break;
                }
                break;
            case 98:
                if (str2.equals(TAG_BOLD)) {
                    c2 = 0;
                    break;
                }
                break;
            case 99:
                if (str2.equals(TAG_CLASS)) {
                    c2 = 3;
                    break;
                }
                break;
            case 105:
                if (str2.equals(TAG_ITALIC)) {
                    c2 = 1;
                    break;
                }
                break;
            case 117:
                if (str2.equals(TAG_UNDERLINE)) {
                    c2 = 2;
                    break;
                }
                break;
            case 118:
                if (str2.equals(TAG_VOICE)) {
                    c2 = 5;
                    break;
                }
                break;
            case 3314158:
                if (str2.equals(TAG_LANG)) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                spannableStringBuilder.setSpan(new StyleSpan(1), i, length, 33);
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(2), i, length, 33);
                break;
            case 2:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                break;
            default:
                return;
        }
        list2.clear();
        getApplicableStyles(list, str, startTag, list2);
        int size = list2.size();
        for (int i2 = 0; i2 < size; i2++) {
            applyStyleToText(spannableStringBuilder, list2.get(i2).style, i, length);
        }
    }

    private static void applyStyleToText(SpannableStringBuilder spannableStringBuilder, WebvttCssStyle webvttCssStyle, int i, int i2) {
        if (webvttCssStyle != null) {
            if (webvttCssStyle.getStyle() != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(webvttCssStyle.getStyle()), i, i2, 33);
            }
            if (webvttCssStyle.isLinethrough()) {
                spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i2, 33);
            }
            if (webvttCssStyle.isUnderline()) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
            }
            if (webvttCssStyle.hasFontColor()) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(webvttCssStyle.getFontColor()), i, i2, 33);
            }
            if (webvttCssStyle.hasBackgroundColor()) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(webvttCssStyle.getBackgroundColor()), i, i2, 33);
            }
            if (webvttCssStyle.getFontFamily() != null) {
                spannableStringBuilder.setSpan(new TypefaceSpan(webvttCssStyle.getFontFamily()), i, i2, 33);
            }
            if (webvttCssStyle.getTextAlign() != null) {
                spannableStringBuilder.setSpan(new AlignmentSpan.Standard(webvttCssStyle.getTextAlign()), i, i2, 33);
            }
            if (webvttCssStyle.getFontSizeUnit() != -1) {
                switch (webvttCssStyle.getFontSizeUnit()) {
                    case 1:
                        spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) webvttCssStyle.getFontSize(), true), i, i2, 33);
                        return;
                    case 2:
                        spannableStringBuilder.setSpan(new RelativeSizeSpan(webvttCssStyle.getFontSize()), i, i2, 33);
                        return;
                    case 3:
                        spannableStringBuilder.setSpan(new RelativeSizeSpan(webvttCssStyle.getFontSize() / 100.0f), i, i2, 33);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private static String getTagName(String str) {
        String trim = str.trim();
        if (trim.isEmpty()) {
            return null;
        }
        return trim.split("[ \\.]")[0];
    }

    private static void getApplicableStyles(List<WebvttCssStyle> list, String str, StartTag startTag, List<StyleMatch> list2) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            WebvttCssStyle webvttCssStyle = list.get(i);
            int specificityScore = webvttCssStyle.getSpecificityScore(str, startTag.name, startTag.classes, startTag.voice);
            if (specificityScore > 0) {
                list2.add(new StyleMatch(specificityScore, webvttCssStyle));
            }
        }
        Collections.sort(list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class StyleMatch implements Comparable<StyleMatch> {
        public final int score;
        public final WebvttCssStyle style;

        public StyleMatch(int i, WebvttCssStyle webvttCssStyle) {
            this.score = i;
            this.style = webvttCssStyle;
        }

        @Override // java.lang.Comparable
        public int compareTo(StyleMatch styleMatch) {
            return this.score - styleMatch.score;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class StartTag {
        private static final String[] NO_CLASSES = new String[0];
        public final String[] classes;
        public final String name;
        public final int position;
        public final String voice;

        private StartTag(String str, int i, String str2, String[] strArr) {
            this.position = i;
            this.name = str;
            this.voice = str2;
            this.classes = strArr;
        }

        public static StartTag buildStartTag(String str, int i) {
            String substring;
            String str2;
            String[] strArr;
            String trim = str.trim();
            if (trim.isEmpty()) {
                return null;
            }
            int indexOf = trim.indexOf(" ");
            if (indexOf == -1) {
                substring = trim;
                str2 = "";
            } else {
                String trim2 = trim.substring(indexOf).trim();
                substring = trim.substring(0, indexOf);
                str2 = trim2;
            }
            String[] split = substring.split("\\.");
            String str3 = split[0];
            if (split.length > 1) {
                strArr = (String[]) Arrays.copyOfRange(split, 1, split.length);
            } else {
                strArr = NO_CLASSES;
            }
            return new StartTag(str3, i, str2, strArr);
        }

        public static StartTag buildWholeCueVirtualTag() {
            return new StartTag("", 0, "", new String[0]);
        }
    }
}

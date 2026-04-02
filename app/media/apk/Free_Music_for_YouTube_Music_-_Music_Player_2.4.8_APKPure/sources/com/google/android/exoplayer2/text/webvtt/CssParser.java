package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
final class CssParser {
    private static final String BLOCK_END = "}";
    private static final String BLOCK_START = "{";
    private static final String PROPERTY_BGCOLOR = "background-color";
    private static final String PROPERTY_FONT_FAMILY = "font-family";
    private static final String PROPERTY_FONT_STYLE = "font-style";
    private static final String PROPERTY_FONT_WEIGHT = "font-weight";
    private static final String PROPERTY_TEXT_DECORATION = "text-decoration";
    private static final String VALUE_BOLD = "bold";
    private static final String VALUE_ITALIC = "italic";
    private static final String VALUE_UNDERLINE = "underline";
    private static final Pattern VOICE_NAME_PATTERN = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private final ParsableByteArray styleInput = new ParsableByteArray();
    private final StringBuilder stringBuilder = new StringBuilder();

    public WebvttCssStyle parseBlock(ParsableByteArray parsableByteArray) {
        this.stringBuilder.setLength(0);
        int position = parsableByteArray.getPosition();
        skipStyleBlock(parsableByteArray);
        this.styleInput.reset(parsableByteArray.data, parsableByteArray.getPosition());
        this.styleInput.setPosition(position);
        String parseSelector = parseSelector(this.styleInput, this.stringBuilder);
        if (parseSelector == null || !BLOCK_START.equals(parseNextToken(this.styleInput, this.stringBuilder))) {
            return null;
        }
        WebvttCssStyle webvttCssStyle = new WebvttCssStyle();
        applySelectorToStyle(webvttCssStyle, parseSelector);
        boolean z = false;
        String str = null;
        while (!z) {
            int position2 = this.styleInput.getPosition();
            str = parseNextToken(this.styleInput, this.stringBuilder);
            z = str == null || BLOCK_END.equals(str);
            if (!z) {
                this.styleInput.setPosition(position2);
                parseStyleDeclaration(this.styleInput, webvttCssStyle, this.stringBuilder);
            }
        }
        if (BLOCK_END.equals(str)) {
            return webvttCssStyle;
        }
        return null;
    }

    private static String parseSelector(ParsableByteArray parsableByteArray, StringBuilder sb) {
        skipWhitespaceAndComments(parsableByteArray);
        if (parsableByteArray.bytesLeft() >= 5 && "::cue".equals(parsableByteArray.readString(5))) {
            int position = parsableByteArray.getPosition();
            String parseNextToken = parseNextToken(parsableByteArray, sb);
            if (parseNextToken != null) {
                if (BLOCK_START.equals(parseNextToken)) {
                    parsableByteArray.setPosition(position);
                    return "";
                }
                String readCueTarget = "(".equals(parseNextToken) ? readCueTarget(parsableByteArray) : null;
                String parseNextToken2 = parseNextToken(parsableByteArray, sb);
                if (!")".equals(parseNextToken2) || parseNextToken2 == null) {
                    return null;
                }
                return readCueTarget;
            }
            return null;
        }
        return null;
    }

    private static String readCueTarget(ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        int i = position;
        boolean z = false;
        while (i < limit && !z) {
            int i2 = i + 1;
            z = ((char) parsableByteArray.data[i]) == ')';
            i = i2;
        }
        return parsableByteArray.readString((i - 1) - parsableByteArray.getPosition()).trim();
    }

    private static void parseStyleDeclaration(ParsableByteArray parsableByteArray, WebvttCssStyle webvttCssStyle, StringBuilder sb) {
        skipWhitespaceAndComments(parsableByteArray);
        String parseIdentifier = parseIdentifier(parsableByteArray, sb);
        if (!"".equals(parseIdentifier) && ":".equals(parseNextToken(parsableByteArray, sb))) {
            skipWhitespaceAndComments(parsableByteArray);
            String parsePropertyValue = parsePropertyValue(parsableByteArray, sb);
            if (parsePropertyValue != null && !"".equals(parsePropertyValue)) {
                int position = parsableByteArray.getPosition();
                String parseNextToken = parseNextToken(parsableByteArray, sb);
                if (!";".equals(parseNextToken)) {
                    if (BLOCK_END.equals(parseNextToken)) {
                        parsableByteArray.setPosition(position);
                    } else {
                        return;
                    }
                }
                if (TtmlNode.ATTR_TTS_COLOR.equals(parseIdentifier)) {
                    webvttCssStyle.setFontColor(ColorParser.parseCssColor(parsePropertyValue));
                } else if (PROPERTY_BGCOLOR.equals(parseIdentifier)) {
                    webvttCssStyle.setBackgroundColor(ColorParser.parseCssColor(parsePropertyValue));
                } else if (PROPERTY_TEXT_DECORATION.equals(parseIdentifier)) {
                    if ("underline".equals(parsePropertyValue)) {
                        webvttCssStyle.setUnderline(true);
                    }
                } else if (PROPERTY_FONT_FAMILY.equals(parseIdentifier)) {
                    webvttCssStyle.setFontFamily(parsePropertyValue);
                } else if (PROPERTY_FONT_WEIGHT.equals(parseIdentifier)) {
                    if ("bold".equals(parsePropertyValue)) {
                        webvttCssStyle.setBold(true);
                    }
                } else if (PROPERTY_FONT_STYLE.equals(parseIdentifier) && "italic".equals(parsePropertyValue)) {
                    webvttCssStyle.setItalic(true);
                }
            }
        }
    }

    static void skipWhitespaceAndComments(ParsableByteArray parsableByteArray) {
        boolean z = true;
        while (parsableByteArray.bytesLeft() > 0 && z) {
            z = maybeSkipWhitespace(parsableByteArray) || maybeSkipComment(parsableByteArray);
        }
    }

    static String parseNextToken(ParsableByteArray parsableByteArray, StringBuilder sb) {
        skipWhitespaceAndComments(parsableByteArray);
        if (parsableByteArray.bytesLeft() == 0) {
            return null;
        }
        String parseIdentifier = parseIdentifier(parsableByteArray, sb);
        return "".equals(parseIdentifier) ? "" + ((char) parsableByteArray.readUnsignedByte()) : parseIdentifier;
    }

    private static boolean maybeSkipWhitespace(ParsableByteArray parsableByteArray) {
        switch (peekCharAtPosition(parsableByteArray, parsableByteArray.getPosition())) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
                parsableByteArray.skipBytes(1);
                return true;
            default:
                return false;
        }
    }

    static void skipStyleBlock(ParsableByteArray parsableByteArray) {
        do {
        } while (!TextUtils.isEmpty(parsableByteArray.readLine()));
    }

    private static char peekCharAtPosition(ParsableByteArray parsableByteArray, int i) {
        return (char) parsableByteArray.data[i];
    }

    private static String parsePropertyValue(ParsableByteArray parsableByteArray, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        while (!z) {
            int position = parsableByteArray.getPosition();
            String parseNextToken = parseNextToken(parsableByteArray, sb);
            if (parseNextToken == null) {
                return null;
            }
            if (BLOCK_END.equals(parseNextToken) || ";".equals(parseNextToken)) {
                parsableByteArray.setPosition(position);
                z = true;
            } else {
                sb2.append(parseNextToken);
            }
        }
        return sb2.toString();
    }

    private static boolean maybeSkipComment(ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        byte[] bArr = parsableByteArray.data;
        if (position + 2 <= limit) {
            int i = position + 1;
            if (bArr[position] == 47) {
                int i2 = i + 1;
                if (bArr[i] == 42) {
                    while (true) {
                        int i3 = i2;
                        if (i3 + 1 < limit) {
                            i2 = i3 + 1;
                            if (((char) bArr[i3]) == '*' && ((char) bArr[i2]) == '/') {
                                limit = i2 + 1;
                                i2 = limit;
                            }
                        } else {
                            parsableByteArray.skipBytes(limit - parsableByteArray.getPosition());
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static String parseIdentifier(ParsableByteArray parsableByteArray, StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        while (position < limit && !z) {
            char c2 = (char) parsableByteArray.data[position];
            if ((c2 >= 'A' && c2 <= 'Z') || ((c2 >= 'a' && c2 <= 'z') || ((c2 >= '0' && c2 <= '9') || c2 == '#' || c2 == '-' || c2 == '.' || c2 == '_'))) {
                position++;
                sb.append(c2);
            } else {
                z = true;
            }
        }
        parsableByteArray.skipBytes(position - parsableByteArray.getPosition());
        return sb.toString();
    }

    private void applySelectorToStyle(WebvttCssStyle webvttCssStyle, String str) {
        if (!"".equals(str)) {
            int indexOf = str.indexOf(91);
            if (indexOf != -1) {
                Matcher matcher = VOICE_NAME_PATTERN.matcher(str.substring(indexOf));
                if (matcher.matches()) {
                    webvttCssStyle.setTargetVoice(matcher.group(1));
                }
                str = str.substring(0, indexOf);
            }
            String[] split = str.split("\\.");
            String str2 = split[0];
            int indexOf2 = str2.indexOf(35);
            if (indexOf2 != -1) {
                webvttCssStyle.setTargetTagName(str2.substring(0, indexOf2));
                webvttCssStyle.setTargetId(str2.substring(indexOf2 + 1));
            } else {
                webvttCssStyle.setTargetTagName(str2);
            }
            if (split.length > 1) {
                webvttCssStyle.setTargetClasses((String[]) Arrays.copyOfRange(split, 1, split.length));
            }
        }
    }
}

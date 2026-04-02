package com.google.zxing.datamatrix.decoder;

import android.support.v7.widget.helper.ItemTouchHelper;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
/* loaded from: classes2.dex */
final class DecodedBitStreamParser {
    private static final char[] C40_BASIC_SET_CHARS = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final char[] C40_SHIFT2_SET_CHARS = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
    private static final char[] TEXT_BASIC_SET_CHARS = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] TEXT_SHIFT2_SET_CHARS = C40_SHIFT2_SET_CHARS;
    private static final char[] TEXT_SHIFT3_SET_CHARS = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum Mode {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    private DecodedBitStreamParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.zxing.common.DecoderResult decode(byte[] r7) throws com.google.zxing.FormatException {
        /*
            r1 = 0
            com.google.zxing.common.BitSource r3 = new com.google.zxing.common.BitSource
            r3.<init>(r7)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r0 = 100
            r4.<init>(r0)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r0 = 0
            r5.<init>(r0)
            java.util.ArrayList r2 = new java.util.ArrayList
            r0 = 1
            r2.<init>(r0)
            com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.ASCII_ENCODE
        L1b:
            com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode r6 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.ASCII_ENCODE
            if (r0 != r6) goto L47
            com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode r0 = decodeAsciiSegment(r3, r4, r5)
        L23:
            com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode r6 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.PAD_ENCODE
            if (r0 == r6) goto L2d
            int r6 = r3.available()
            if (r6 > 0) goto L1b
        L2d:
            int r0 = r5.length()
            if (r0 <= 0) goto L36
            r4.append(r5)
        L36:
            com.google.zxing.common.DecoderResult r3 = new com.google.zxing.common.DecoderResult
            java.lang.String r4 = r4.toString()
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L6d
            r0 = r1
        L43:
            r3.<init>(r7, r4, r0, r1)
            return r3
        L47:
            int[] r6 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.AnonymousClass1.$SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode
            int r0 = r0.ordinal()
            r0 = r6[r0]
            switch(r0) {
                case 1: goto L57;
                case 2: goto L5d;
                case 3: goto L61;
                case 4: goto L65;
                case 5: goto L69;
                default: goto L52;
            }
        L52:
            com.google.zxing.FormatException r0 = com.google.zxing.FormatException.getFormatInstance()
            throw r0
        L57:
            decodeC40Segment(r3, r4)
        L5a:
            com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.ASCII_ENCODE
            goto L23
        L5d:
            decodeTextSegment(r3, r4)
            goto L5a
        L61:
            decodeAnsiX12Segment(r3, r4)
            goto L5a
        L65:
            decodeEdifactSegment(r3, r4)
            goto L5a
        L69:
            decodeBase256Segment(r3, r4, r2)
            goto L5a
        L6d:
            r0 = r2
            goto L43
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.decode(byte[]):com.google.zxing.common.DecoderResult");
    }

    private static Mode decodeAsciiSegment(BitSource bitSource, StringBuilder sb, StringBuilder sb2) throws FormatException {
        boolean z = false;
        do {
            int readBits = bitSource.readBits(8);
            if (readBits == 0) {
                throw FormatException.getFormatInstance();
            }
            if (readBits <= 128) {
                sb.append((char) ((z ? readBits + 128 : readBits) - 1));
                return Mode.ASCII_ENCODE;
            } else if (readBits == 129) {
                return Mode.PAD_ENCODE;
            } else {
                if (readBits <= 229) {
                    int i = readBits - 130;
                    if (i < 10) {
                        sb.append('0');
                    }
                    sb.append(i);
                } else if (readBits == 230) {
                    return Mode.C40_ENCODE;
                } else {
                    if (readBits == 231) {
                        return Mode.BASE256_ENCODE;
                    }
                    if (readBits == 232) {
                        sb.append((char) 29);
                    } else if (readBits != 233 && readBits != 234) {
                        if (readBits == 235) {
                            z = true;
                        } else if (readBits == 236) {
                            sb.append("[)>\u001e05\u001d");
                            sb2.insert(0, "\u001e\u0004");
                        } else if (readBits == 237) {
                            sb.append("[)>\u001e06\u001d");
                            sb2.insert(0, "\u001e\u0004");
                        } else if (readBits == 238) {
                            return Mode.ANSIX12_ENCODE;
                        } else {
                            if (readBits == 239) {
                                return Mode.TEXT_ENCODE;
                            }
                            if (readBits == 240) {
                                return Mode.EDIFACT_ENCODE;
                            }
                            if (readBits != 241 && readBits >= 242 && (readBits != 254 || bitSource.available() != 0)) {
                                throw FormatException.getFormatInstance();
                            }
                        }
                    }
                }
            }
        } while (bitSource.available() > 0);
        return Mode.ASCII_ENCODE;
    }

    private static void decodeC40Segment(BitSource bitSource, StringBuilder sb) throws FormatException {
        int readBits;
        int[] iArr = new int[3];
        int i = 0;
        boolean z = false;
        while (bitSource.available() != 8 && (readBits = bitSource.readBits(8)) != 254) {
            parseTwoBytes(readBits, bitSource.readBits(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                switch (i) {
                    case 0:
                        if (i3 < 3) {
                            i = i3 + 1;
                            break;
                        } else if (i3 < C40_BASIC_SET_CHARS.length) {
                            char c2 = C40_BASIC_SET_CHARS[i3];
                            if (z) {
                                sb.append((char) (c2 + 128));
                                z = false;
                                break;
                            } else {
                                sb.append(c2);
                                break;
                            }
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    case 1:
                        if (z) {
                            sb.append((char) (i3 + 128));
                            z = false;
                        } else {
                            sb.append((char) i3);
                        }
                        i = 0;
                        break;
                    case 2:
                        if (i3 < C40_SHIFT2_SET_CHARS.length) {
                            char c3 = C40_SHIFT2_SET_CHARS[i3];
                            if (z) {
                                sb.append((char) (c3 + 128));
                                z = false;
                            } else {
                                sb.append(c3);
                            }
                        } else if (i3 == 27) {
                            sb.append((char) 29);
                        } else if (i3 == 30) {
                            z = true;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        i = 0;
                        break;
                    case 3:
                        if (z) {
                            sb.append((char) (i3 + 224));
                            z = false;
                        } else {
                            sb.append((char) (i3 + 96));
                        }
                        i = 0;
                        break;
                    default:
                        throw FormatException.getFormatInstance();
                }
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    private static void decodeTextSegment(BitSource bitSource, StringBuilder sb) throws FormatException {
        int readBits;
        int[] iArr = new int[3];
        int i = 0;
        boolean z = false;
        while (bitSource.available() != 8 && (readBits = bitSource.readBits(8)) != 254) {
            parseTwoBytes(readBits, bitSource.readBits(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                switch (i) {
                    case 0:
                        if (i3 < 3) {
                            i = i3 + 1;
                            break;
                        } else if (i3 < TEXT_BASIC_SET_CHARS.length) {
                            char c2 = TEXT_BASIC_SET_CHARS[i3];
                            if (z) {
                                sb.append((char) (c2 + 128));
                                z = false;
                                break;
                            } else {
                                sb.append(c2);
                                break;
                            }
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    case 1:
                        if (z) {
                            sb.append((char) (i3 + 128));
                            z = false;
                        } else {
                            sb.append((char) i3);
                        }
                        i = 0;
                        break;
                    case 2:
                        if (i3 < TEXT_SHIFT2_SET_CHARS.length) {
                            char c3 = TEXT_SHIFT2_SET_CHARS[i3];
                            if (z) {
                                sb.append((char) (c3 + 128));
                                z = false;
                            } else {
                                sb.append(c3);
                            }
                        } else if (i3 == 27) {
                            sb.append((char) 29);
                        } else if (i3 == 30) {
                            z = true;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        i = 0;
                        break;
                    case 3:
                        if (i3 < TEXT_SHIFT3_SET_CHARS.length) {
                            char c4 = TEXT_SHIFT3_SET_CHARS[i3];
                            if (z) {
                                sb.append((char) (c4 + 128));
                                z = false;
                            } else {
                                sb.append(c4);
                            }
                            i = 0;
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    default:
                        throw FormatException.getFormatInstance();
                }
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    private static void decodeAnsiX12Segment(BitSource bitSource, StringBuilder sb) throws FormatException {
        int readBits;
        int[] iArr = new int[3];
        while (bitSource.available() != 8 && (readBits = bitSource.readBits(8)) != 254) {
            parseTwoBytes(readBits, bitSource.readBits(8), iArr);
            for (int i = 0; i < 3; i++) {
                int i2 = iArr[i];
                if (i2 == 0) {
                    sb.append('\r');
                } else if (i2 == 1) {
                    sb.append('*');
                } else if (i2 == 2) {
                    sb.append('>');
                } else if (i2 == 3) {
                    sb.append(' ');
                } else if (i2 < 14) {
                    sb.append((char) (i2 + 44));
                } else if (i2 < 40) {
                    sb.append((char) (i2 + 51));
                } else {
                    throw FormatException.getFormatInstance();
                }
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    private static void parseTwoBytes(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        int i5 = i3 - (i4 * 1600);
        int i6 = i5 / 40;
        iArr[1] = i6;
        iArr[2] = i5 - (i6 * 40);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (r3.available() > 0) goto L1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void decodeEdifactSegment(com.google.zxing.common.BitSource r3, java.lang.StringBuilder r4) {
        /*
        L0:
            int r0 = r3.available()
            r1 = 16
            if (r0 > r1) goto L9
        L8:
            return
        L9:
            r0 = 0
            r1 = r0
        Lb:
            r0 = 4
            if (r1 >= r0) goto L33
            r0 = 6
            int r0 = r3.readBits(r0)
            r2 = 31
            if (r0 != r2) goto L25
            int r0 = r3.getBitOffset()
            int r0 = 8 - r0
            r1 = 8
            if (r0 == r1) goto L8
            r3.readBits(r0)
            goto L8
        L25:
            r2 = r0 & 32
            if (r2 != 0) goto L2b
            r0 = r0 | 64
        L2b:
            char r0 = (char) r0
            r4.append(r0)
            int r0 = r1 + 1
            r1 = r0
            goto Lb
        L33:
            int r0 = r3.available()
            if (r0 > 0) goto L0
            goto L8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.decodeEdifactSegment(com.google.zxing.common.BitSource, java.lang.StringBuilder):void");
    }

    private static void decodeBase256Segment(BitSource bitSource, StringBuilder sb, Collection<byte[]> collection) throws FormatException {
        int unrandomize255State;
        int byteOffset = bitSource.getByteOffset() + 1;
        int i = byteOffset + 1;
        int unrandomize255State2 = unrandomize255State(bitSource.readBits(8), byteOffset);
        if (unrandomize255State2 == 0) {
            unrandomize255State = bitSource.available() / 8;
        } else if (unrandomize255State2 < 250) {
            unrandomize255State = unrandomize255State2;
        } else {
            unrandomize255State = ((unrandomize255State2 - 249) * ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) + unrandomize255State(bitSource.readBits(8), i);
            i++;
        }
        if (unrandomize255State < 0) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[unrandomize255State];
        int i2 = 0;
        while (i2 < unrandomize255State) {
            if (bitSource.available() < 8) {
                throw FormatException.getFormatInstance();
            }
            bArr[i2] = (byte) unrandomize255State(bitSource.readBits(8), i);
            i2++;
            i++;
        }
        collection.add(bArr);
        try {
            sb.append(new String(bArr, "ISO8859_1"));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Platform does not support required encoding: " + e);
        }
    }

    private static int unrandomize255State(int i, int i2) {
        int i3 = i - (((i2 * 149) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + 256;
    }
}

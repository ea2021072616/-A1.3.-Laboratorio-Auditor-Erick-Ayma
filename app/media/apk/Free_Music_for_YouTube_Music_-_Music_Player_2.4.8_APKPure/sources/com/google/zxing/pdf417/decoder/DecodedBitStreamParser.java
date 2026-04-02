package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;
/* loaded from: classes2.dex */
final class DecodedBitStreamParser {
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final BigInteger[] EXP900;
    private static final int LL = 27;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;
    private static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final char[] MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final Charset DEFAULT_ENCODING = Charset.forName("ISO-8859-1");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        EXP900[1] = valueOf;
        for (int i = 2; i < EXP900.length; i++) {
            EXP900[i] = EXP900[i - 1].multiply(valueOf);
        }
    }

    private DecodedBitStreamParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DecoderResult decode(int[] iArr, String str) throws FormatException {
        int decodeMacroBlock;
        StringBuilder sb = new StringBuilder(iArr.length << 1);
        Charset charset = DEFAULT_ENCODING;
        int i = 2;
        int i2 = iArr[1];
        PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
        while (i < iArr[0]) {
            switch (i2) {
                case 900:
                    decodeMacroBlock = textCompaction(iArr, i, sb);
                    break;
                case 901:
                case BYTE_COMPACTION_MODE_LATCH_6 /* 924 */:
                    decodeMacroBlock = byteCompaction(i2, iArr, charset, i, sb);
                    break;
                case 902:
                    decodeMacroBlock = numericCompaction(iArr, i, sb);
                    break;
                case MODE_SHIFT_TO_BYTE_COMPACTION_MODE /* 913 */:
                    decodeMacroBlock = i + 1;
                    sb.append((char) iArr[i]);
                    break;
                case MACRO_PDF417_TERMINATOR /* 922 */:
                case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /* 923 */:
                    throw FormatException.getFormatInstance();
                case ECI_USER_DEFINED /* 925 */:
                    decodeMacroBlock = i + 1;
                    break;
                case ECI_GENERAL_PURPOSE /* 926 */:
                    decodeMacroBlock = i + 2;
                    break;
                case ECI_CHARSET /* 927 */:
                    decodeMacroBlock = i + 1;
                    charset = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(iArr[i]).name());
                    break;
                case 928:
                    decodeMacroBlock = decodeMacroBlock(iArr, i, pDF417ResultMetadata);
                    break;
                default:
                    decodeMacroBlock = textCompaction(iArr, i - 1, sb);
                    break;
            }
            if (decodeMacroBlock < iArr.length) {
                i = decodeMacroBlock + 1;
                i2 = iArr[decodeMacroBlock];
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (sb.length() == 0) {
            throw FormatException.getFormatInstance();
        }
        DecoderResult decoderResult = new DecoderResult(null, sb.toString(), null, str);
        decoderResult.setOther(pDF417ResultMetadata);
        return decoderResult;
    }

    private static int decodeMacroBlock(int[] iArr, int i, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        if (i + 2 > iArr[0]) {
            throw FormatException.getFormatInstance();
        }
        int[] iArr2 = new int[2];
        int i2 = 0;
        while (i2 < 2) {
            iArr2[i2] = iArr[i];
            i2++;
            i++;
        }
        pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
        StringBuilder sb = new StringBuilder();
        int textCompaction = textCompaction(iArr, i, sb);
        pDF417ResultMetadata.setFileId(sb.toString());
        if (iArr[textCompaction] == BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
            int i3 = textCompaction + 1;
            int[] iArr3 = new int[iArr[0] - i3];
            int i4 = 0;
            int i5 = i3;
            boolean z = false;
            while (i5 < iArr[0] && !z) {
                int i6 = i5 + 1;
                int i7 = iArr[i5];
                if (i7 < 900) {
                    iArr3[i4] = i7;
                    i4++;
                    i5 = i6;
                } else {
                    switch (i7) {
                        case MACRO_PDF417_TERMINATOR /* 922 */:
                            pDF417ResultMetadata.setLastSegment(true);
                            i5 = i6 + 1;
                            z = true;
                            break;
                        default:
                            throw FormatException.getFormatInstance();
                    }
                }
            }
            pDF417ResultMetadata.setOptionalData(Arrays.copyOf(iArr3, i4));
            return i5;
        } else if (iArr[textCompaction] == MACRO_PDF417_TERMINATOR) {
            pDF417ResultMetadata.setLastSegment(true);
            return textCompaction + 1;
        } else {
            return textCompaction;
        }
    }

    private static int textCompaction(int[] iArr, int i, StringBuilder sb) {
        int[] iArr2 = new int[(iArr[0] - i) << 1];
        int[] iArr3 = new int[(iArr[0] - i) << 1];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i4 < 900) {
                iArr2[i2] = i4 / 30;
                iArr2[i2 + 1] = i4 % 30;
                i2 += 2;
                i = i3;
            } else {
                switch (i4) {
                    case 900:
                        iArr2[i2] = 900;
                        i2++;
                        i = i3;
                        continue;
                    case 901:
                    case 902:
                    case MACRO_PDF417_TERMINATOR /* 922 */:
                    case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /* 923 */:
                    case BYTE_COMPACTION_MODE_LATCH_6 /* 924 */:
                    case 928:
                        i = i3 - 1;
                        z = true;
                        continue;
                    case MODE_SHIFT_TO_BYTE_COMPACTION_MODE /* 913 */:
                        iArr2[i2] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
                        i = i3 + 1;
                        iArr3[i2] = iArr[i3];
                        i2++;
                        continue;
                    default:
                        i = i3;
                        continue;
                }
            }
        }
        decodeTextCompaction(iArr2, iArr3, i2, sb);
        return i;
    }

    private static void decodeTextCompaction(int[] iArr, int[] iArr2, int i, StringBuilder sb) {
        Mode mode = Mode.ALPHA;
        Mode mode2 = Mode.ALPHA;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            char c2 = 0;
            switch (mode) {
                case ALPHA:
                    if (i3 < 26) {
                        c2 = (char) (i3 + 65);
                        break;
                    } else if (i3 == 26) {
                        c2 = ' ';
                        break;
                    } else if (i3 == 27) {
                        mode = Mode.LOWER;
                        break;
                    } else if (i3 == 28) {
                        mode = Mode.MIXED;
                        break;
                    } else if (i3 == 29) {
                        Mode mode3 = mode;
                        mode = Mode.PUNCT_SHIFT;
                        mode2 = mode3;
                        break;
                    } else if (i3 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                        sb.append((char) iArr2[i2]);
                        break;
                    } else if (i3 == 900) {
                        mode = Mode.ALPHA;
                        break;
                    }
                    break;
                case LOWER:
                    if (i3 < 26) {
                        c2 = (char) (i3 + 97);
                        break;
                    } else if (i3 == 26) {
                        c2 = ' ';
                        break;
                    } else if (i3 == 27) {
                        Mode mode4 = mode;
                        mode = Mode.ALPHA_SHIFT;
                        mode2 = mode4;
                        break;
                    } else if (i3 == 28) {
                        mode = Mode.MIXED;
                        break;
                    } else if (i3 == 29) {
                        Mode mode5 = mode;
                        mode = Mode.PUNCT_SHIFT;
                        mode2 = mode5;
                        break;
                    } else if (i3 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                        sb.append((char) iArr2[i2]);
                        break;
                    } else if (i3 == 900) {
                        mode = Mode.ALPHA;
                        break;
                    }
                    break;
                case MIXED:
                    if (i3 < 25) {
                        c2 = MIXED_CHARS[i3];
                        break;
                    } else if (i3 == 25) {
                        mode = Mode.PUNCT;
                        break;
                    } else if (i3 == 26) {
                        c2 = ' ';
                        break;
                    } else if (i3 == 27) {
                        mode = Mode.LOWER;
                        break;
                    } else if (i3 == 28) {
                        mode = Mode.ALPHA;
                        break;
                    } else if (i3 == 29) {
                        Mode mode6 = mode;
                        mode = Mode.PUNCT_SHIFT;
                        mode2 = mode6;
                        break;
                    } else if (i3 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                        sb.append((char) iArr2[i2]);
                        break;
                    } else if (i3 == 900) {
                        mode = Mode.ALPHA;
                        break;
                    }
                    break;
                case PUNCT:
                    if (i3 < 29) {
                        c2 = PUNCT_CHARS[i3];
                        break;
                    } else if (i3 == 29) {
                        mode = Mode.ALPHA;
                        break;
                    } else if (i3 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                        sb.append((char) iArr2[i2]);
                        break;
                    } else if (i3 == 900) {
                        mode = Mode.ALPHA;
                        break;
                    }
                    break;
                case ALPHA_SHIFT:
                    if (i3 < 26) {
                        c2 = (char) (i3 + 65);
                        mode = mode2;
                        break;
                    } else if (i3 == 26) {
                        c2 = ' ';
                        mode = mode2;
                        break;
                    } else {
                        if (i3 == 900) {
                            mode = Mode.ALPHA;
                            break;
                        }
                        mode = mode2;
                        break;
                    }
                case PUNCT_SHIFT:
                    if (i3 < 29) {
                        c2 = PUNCT_CHARS[i3];
                        mode = mode2;
                        break;
                    } else if (i3 == 29) {
                        mode = Mode.ALPHA;
                        break;
                    } else if (i3 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                        sb.append((char) iArr2[i2]);
                        mode = mode2;
                        break;
                    } else {
                        if (i3 == 900) {
                            mode = Mode.ALPHA;
                            break;
                        }
                        mode = mode2;
                        break;
                    }
            }
            if (c2 != 0) {
                sb.append(c2);
            }
        }
    }

    private static int byteCompaction(int i, int[] iArr, Charset charset, int i2, StringBuilder sb) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (i == 901) {
            int i3 = 0;
            long j = 0;
            int[] iArr2 = new int[6];
            boolean z = false;
            int i4 = iArr[i2];
            int i5 = i2 + 1;
            while (i5 < iArr[0] && !z) {
                int i6 = i3 + 1;
                iArr2[i3] = i4;
                j = (j * 900) + i4;
                int i7 = i5 + 1;
                i4 = iArr[i5];
                if (i4 == 900 || i4 == 901 || i4 == 902 || i4 == BYTE_COMPACTION_MODE_LATCH_6 || i4 == 928 || i4 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i4 == MACRO_PDF417_TERMINATOR) {
                    z = true;
                    i5 = i7 - 1;
                    i3 = i6;
                } else if (i6 % 5 != 0 || i6 <= 0) {
                    i3 = i6;
                    i5 = i7;
                } else {
                    for (int i8 = 0; i8 < 6; i8++) {
                        byteArrayOutputStream.write((byte) (j >> ((5 - i8) * 8)));
                    }
                    j = 0;
                    i3 = 0;
                    i5 = i7;
                }
            }
            if (i5 == iArr[0] && i4 < 900) {
                iArr2[i3] = i4;
                i3++;
            }
            for (int i9 = 0; i9 < i3; i9++) {
                byteArrayOutputStream.write((byte) iArr2[i9]);
            }
            i2 = i5;
        } else if (i == BYTE_COMPACTION_MODE_LATCH_6) {
            int i10 = 0;
            long j2 = 0;
            boolean z2 = false;
            while (i2 < iArr[0] && !z2) {
                int i11 = i2 + 1;
                int i12 = iArr[i2];
                if (i12 < 900) {
                    i10++;
                    j2 = (j2 * 900) + i12;
                    i2 = i11;
                } else if (i12 == 900 || i12 == 901 || i12 == 902 || i12 == BYTE_COMPACTION_MODE_LATCH_6 || i12 == 928 || i12 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i12 == MACRO_PDF417_TERMINATOR) {
                    i2 = i11 - 1;
                    z2 = true;
                } else {
                    i2 = i11;
                }
                if (i10 % 5 == 0 && i10 > 0) {
                    for (int i13 = 0; i13 < 6; i13++) {
                        byteArrayOutputStream.write((byte) (j2 >> ((5 - i13) * 8)));
                    }
                    j2 = 0;
                    i10 = 0;
                }
            }
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
        r11.append(decodeBase900toBase10(r5, r2));
        r2 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int numericCompaction(int[] r9, int r10, java.lang.StringBuilder r11) throws com.google.zxing.FormatException {
        /*
            r8 = 900(0x384, float:1.261E-42)
            r3 = 1
            r1 = 0
            r0 = 15
            int[] r5 = new int[r0]
            r0 = r1
            r2 = r1
        La:
            r4 = r9[r1]
            if (r10 >= r4) goto L4f
            if (r0 != 0) goto L4f
            int r4 = r10 + 1
            r6 = r9[r10]
            r7 = r9[r1]
            if (r4 != r7) goto L19
            r0 = r3
        L19:
            if (r6 >= r8) goto L35
            r5[r2] = r6
            int r2 = r2 + 1
            r10 = r4
        L20:
            int r4 = r2 % 15
            if (r4 == 0) goto L2a
            r4 = 902(0x386, float:1.264E-42)
            if (r6 == r4) goto L2a
            if (r0 == 0) goto La
        L2a:
            if (r2 <= 0) goto La
            java.lang.String r2 = decodeBase900toBase10(r5, r2)
            r11.append(r2)
            r2 = r1
            goto La
        L35:
            if (r6 == r8) goto L4b
            r7 = 901(0x385, float:1.263E-42)
            if (r6 == r7) goto L4b
            r7 = 924(0x39c, float:1.295E-42)
            if (r6 == r7) goto L4b
            r7 = 928(0x3a0, float:1.3E-42)
            if (r6 == r7) goto L4b
            r7 = 923(0x39b, float:1.293E-42)
            if (r6 == r7) goto L4b
            r7 = 922(0x39a, float:1.292E-42)
            if (r6 != r7) goto L50
        L4b:
            int r10 = r4 + (-1)
            r0 = r3
            goto L20
        L4f:
            return r10
        L50:
            r10 = r4
            goto L20
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.numericCompaction(int[], int, java.lang.StringBuilder):int");
    }

    private static String decodeBase900toBase10(int[] iArr, int i) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(EXP900[(i - i2) - 1].multiply(BigInteger.valueOf(iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) != '1') {
            throw FormatException.getFormatInstance();
        }
        return bigInteger2.substring(1);
    }
}

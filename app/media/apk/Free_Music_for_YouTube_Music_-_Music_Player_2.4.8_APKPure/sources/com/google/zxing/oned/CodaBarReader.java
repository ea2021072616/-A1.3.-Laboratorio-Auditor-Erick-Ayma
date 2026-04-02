package com.google.zxing.oned;

import android.support.v7.widget.ActivityChooserView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;
/* loaded from: classes2.dex */
public final class CodaBarReader extends OneDReader {
    private static final float MAX_ACCEPTABLE = 2.0f;
    private static final int MIN_CHARACTER_LENGTH = 3;
    private static final float PADDING = 1.5f;
    private static final String ALPHABET_STRING = "0123456789-$:/.+ABCD";
    static final char[] ALPHABET = ALPHABET_STRING.toCharArray();
    static final int[] CHARACTER_ENCODINGS = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    private static final char[] STARTEND_ENCODING = {'A', 'B', 'C', 'D'};
    private final StringBuilder decodeRowResult = new StringBuilder(20);
    private int[] counters = new int[80];
    private int counterLength = 0;

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        Arrays.fill(this.counters, 0);
        setCounters(bitArray);
        int findStartPattern = findStartPattern();
        this.decodeRowResult.setLength(0);
        int i2 = findStartPattern;
        do {
            int narrowWidePattern = toNarrowWidePattern(i2);
            if (narrowWidePattern == -1) {
                throw NotFoundException.getNotFoundInstance();
            }
            this.decodeRowResult.append((char) narrowWidePattern);
            i2 += 8;
            if (this.decodeRowResult.length() > 1 && arrayContains(STARTEND_ENCODING, ALPHABET[narrowWidePattern])) {
                break;
            }
        } while (i2 < this.counterLength);
        int i3 = this.counters[i2 - 1];
        int i4 = 0;
        for (int i5 = -8; i5 < -1; i5++) {
            i4 += this.counters[i2 + i5];
        }
        if (i2 < this.counterLength && i3 < i4 / 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        validatePattern(findStartPattern);
        for (int i6 = 0; i6 < this.decodeRowResult.length(); i6++) {
            this.decodeRowResult.setCharAt(i6, ALPHABET[this.decodeRowResult.charAt(i6)]);
        }
        if (!arrayContains(STARTEND_ENCODING, this.decodeRowResult.charAt(0))) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (!arrayContains(STARTEND_ENCODING, this.decodeRowResult.charAt(this.decodeRowResult.length() - 1))) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (this.decodeRowResult.length() <= 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (map == null || !map.containsKey(DecodeHintType.RETURN_CODABAR_START_END)) {
            this.decodeRowResult.deleteCharAt(this.decodeRowResult.length() - 1);
            this.decodeRowResult.deleteCharAt(0);
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < findStartPattern) {
            int i9 = this.counters[i7] + i8;
            i7++;
            i8 = i9;
        }
        float f = i8;
        while (findStartPattern < i2 - 1) {
            i8 += this.counters[findStartPattern];
            findStartPattern++;
        }
        return new Result(this.decodeRowResult.toString(), null, new ResultPoint[]{new ResultPoint(f, i), new ResultPoint(i8, i)}, BarcodeFormat.CODABAR);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b9, code lost:
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void validatePattern(int r12) throws com.google.zxing.NotFoundException {
        /*
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.CodaBarReader.validatePattern(int):void");
    }

    private void setCounters(BitArray bitArray) throws NotFoundException {
        this.counterLength = 0;
        int nextUnset = bitArray.getNextUnset(0);
        int size = bitArray.getSize();
        if (nextUnset >= size) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z = true;
        int i = 0;
        for (int i2 = nextUnset; i2 < size; i2++) {
            if (bitArray.get(i2) ^ z) {
                i++;
            } else {
                counterAppend(i);
                z = !z;
                i = 1;
            }
        }
        counterAppend(i);
    }

    private void counterAppend(int i) {
        this.counters[this.counterLength] = i;
        this.counterLength++;
        if (this.counterLength >= this.counters.length) {
            int[] iArr = new int[this.counterLength << 1];
            System.arraycopy(this.counters, 0, iArr, 0, this.counterLength);
            this.counters = iArr;
        }
    }

    private int findStartPattern() throws NotFoundException {
        for (int i = 1; i < this.counterLength; i += 2) {
            int narrowWidePattern = toNarrowWidePattern(i);
            if (narrowWidePattern != -1 && arrayContains(STARTEND_ENCODING, ALPHABET[narrowWidePattern])) {
                int i2 = 0;
                for (int i3 = i; i3 < i + 7; i3++) {
                    i2 += this.counters[i3];
                }
                if (i == 1 || this.counters[i - 1] >= i2 / 2) {
                    return i;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean arrayContains(char[] cArr, char c2) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c3 == c2) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private int toNarrowWidePattern(int i) {
        int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i3 = i + 7;
        if (i3 >= this.counterLength) {
            return -1;
        }
        int[] iArr = this.counters;
        int i4 = i;
        int i5 = Integer.MAX_VALUE;
        int i6 = 0;
        while (i4 < i3) {
            int i7 = iArr[i4];
            if (i7 < i5) {
                i5 = i7;
            }
            if (i7 <= i6) {
                i7 = i6;
            }
            i4 += 2;
            i6 = i7;
        }
        int i8 = (i5 + i6) / 2;
        int i9 = i + 1;
        int i10 = 0;
        while (i9 < i3) {
            int i11 = iArr[i9];
            if (i11 < i2) {
                i2 = i11;
            }
            if (i11 <= i10) {
                i11 = i10;
            }
            i9 += 2;
            i10 = i11;
        }
        int i12 = (i2 + i10) / 2;
        int i13 = 0;
        int i14 = 0;
        int i15 = 128;
        while (i13 < 7) {
            i15 >>= 1;
            int i16 = iArr[i + i13] > ((i13 & 1) == 0 ? i8 : i12) ? i14 | i15 : i14;
            i13++;
            i14 = i16;
        }
        for (int i17 = 0; i17 < CHARACTER_ENCODINGS.length; i17++) {
            if (CHARACTER_ENCODINGS[i17] == i14) {
                return i17;
            }
        }
        return -1;
    }
}

package com.google.zxing.qrcode.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
final class AlignmentPatternFinder {
    private final int height;
    private final BitMatrix image;
    private final float moduleSize;
    private final ResultPointCallback resultPointCallback;
    private final int startX;
    private final int startY;
    private final int width;
    private final List<AlignmentPattern> possibleCenters = new ArrayList(5);
    private final int[] crossCheckStateCount = new int[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlignmentPatternFinder(BitMatrix bitMatrix, int i, int i2, int i3, int i4, float f, ResultPointCallback resultPointCallback) {
        this.image = bitMatrix;
        this.startX = i;
        this.startY = i2;
        this.width = i3;
        this.height = i4;
        this.moduleSize = f;
        this.resultPointCallback = resultPointCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlignmentPattern find() throws NotFoundException {
        AlignmentPattern handlePossibleCenter;
        AlignmentPattern handlePossibleCenter2;
        int i = this.startX;
        int i2 = this.height;
        int i3 = i + this.width;
        int i4 = this.startY + (i2 / 2);
        int[] iArr = new int[3];
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i4 + ((i5 & 1) == 0 ? (i5 + 1) / 2 : -((i5 + 1) / 2));
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i7 = i;
            while (i7 < i3 && !this.image.get(i7, i6)) {
                i7++;
            }
            int i8 = 0;
            for (int i9 = i7; i9 < i3; i9++) {
                if (this.image.get(i9, i6)) {
                    if (i8 == 1) {
                        iArr[1] = iArr[1] + 1;
                    } else if (i8 == 2) {
                        if (!foundPatternCross(iArr) || (handlePossibleCenter2 = handlePossibleCenter(iArr, i6, i9)) == null) {
                            iArr[0] = iArr[2];
                            iArr[1] = 1;
                            iArr[2] = 0;
                            i8 = 1;
                        } else {
                            return handlePossibleCenter2;
                        }
                    } else {
                        i8++;
                        iArr[i8] = iArr[i8] + 1;
                    }
                } else {
                    if (i8 == 1) {
                        i8++;
                    }
                    iArr[i8] = iArr[i8] + 1;
                }
            }
            if (foundPatternCross(iArr) && (handlePossibleCenter = handlePossibleCenter(iArr, i6, i3)) != null) {
                return handlePossibleCenter;
            }
        }
        if (!this.possibleCenters.isEmpty()) {
            return this.possibleCenters.get(0);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static float centerFromEnd(int[] iArr, int i) {
        return (i - iArr[2]) - (iArr[1] / 2.0f);
    }

    private boolean foundPatternCross(int[] iArr) {
        float f = this.moduleSize;
        float f2 = f / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - iArr[i]) >= f2) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
        if (r4[1] <= r12) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
        if (r1 < 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
        if (r2.get(r11, r1) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003a, code lost:
        if (r4[0] > r12) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003c, code lost:
        r4[0] = r4[0] + 1;
        r1 = r1 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
        if (r4[0] > r12) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
        r1 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
        if (r1 >= r3) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
        if (r2.get(r11, r1) == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0055, code lost:
        if (r4[1] > r12) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0057, code lost:
        r4[1] = r4[1] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0060, code lost:
        if (r1 == r3) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0064, code lost:
        if (r4[1] > r12) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
        if (r1 >= r3) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006c, code lost:
        if (r2.get(r11, r1) != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0070, code lost:
        if (r4[2] > r12) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0072, code lost:
        r4[2] = r4[2] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007d, code lost:
        if (r4[2] > r12) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0090, code lost:
        if ((java.lang.Math.abs(((r4[0] + r4[1]) + r4[2]) - r13) * 5) >= (r13 * 2)) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0096, code lost:
        if (foundPatternCross(r4) == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:?, code lost:
        return centerFromEnd(r4, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private float crossCheckVertical(int r10, int r11, int r12, int r13) {
        /*
            r9 = this;
            r8 = 2
            r0 = 2143289344(0x7fc00000, float:NaN)
            r7 = 1
            r6 = 0
            com.google.zxing.common.BitMatrix r2 = r9.image
            int r3 = r2.getHeight()
            int[] r4 = r9.crossCheckStateCount
            r4[r6] = r6
            r4[r7] = r6
            r4[r8] = r6
            r1 = r10
        L14:
            if (r1 < 0) goto L29
            boolean r5 = r2.get(r11, r1)
            if (r5 == 0) goto L29
            r5 = r4[r7]
            if (r5 > r12) goto L29
            r5 = r4[r7]
            int r5 = r5 + 1
            r4[r7] = r5
            int r1 = r1 + (-1)
            goto L14
        L29:
            if (r1 < 0) goto L2f
            r5 = r4[r7]
            if (r5 <= r12) goto L30
        L2f:
            return r0
        L30:
            if (r1 < 0) goto L45
            boolean r5 = r2.get(r11, r1)
            if (r5 != 0) goto L45
            r5 = r4[r6]
            if (r5 > r12) goto L45
            r5 = r4[r6]
            int r5 = r5 + 1
            r4[r6] = r5
            int r1 = r1 + (-1)
            goto L30
        L45:
            r1 = r4[r6]
            if (r1 > r12) goto L2f
            int r1 = r10 + 1
        L4b:
            if (r1 >= r3) goto L60
            boolean r5 = r2.get(r11, r1)
            if (r5 == 0) goto L60
            r5 = r4[r7]
            if (r5 > r12) goto L60
            r5 = r4[r7]
            int r5 = r5 + 1
            r4[r7] = r5
            int r1 = r1 + 1
            goto L4b
        L60:
            if (r1 == r3) goto L2f
            r5 = r4[r7]
            if (r5 > r12) goto L2f
        L66:
            if (r1 >= r3) goto L7b
            boolean r5 = r2.get(r11, r1)
            if (r5 != 0) goto L7b
            r5 = r4[r8]
            if (r5 > r12) goto L7b
            r5 = r4[r8]
            int r5 = r5 + 1
            r4[r8] = r5
            int r1 = r1 + 1
            goto L66
        L7b:
            r2 = r4[r8]
            if (r2 > r12) goto L2f
            r2 = r4[r6]
            r3 = r4[r7]
            int r2 = r2 + r3
            r3 = r4[r8]
            int r2 = r2 + r3
            int r2 = r2 - r13
            int r2 = java.lang.Math.abs(r2)
            int r2 = r2 * 5
            int r3 = r13 * 2
            if (r2 >= r3) goto L2f
            boolean r2 = r9.foundPatternCross(r4)
            if (r2 == 0) goto L2f
            float r0 = centerFromEnd(r4, r1)
            goto L2f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.AlignmentPatternFinder.crossCheckVertical(int, int, int, int):float");
    }

    private AlignmentPattern handlePossibleCenter(int[] iArr, int i, int i2) {
        int i3 = iArr[0] + iArr[1] + iArr[2];
        float centerFromEnd = centerFromEnd(iArr, i2);
        float crossCheckVertical = crossCheckVertical(i, (int) centerFromEnd, iArr[1] * 2, i3);
        if (!Float.isNaN(crossCheckVertical)) {
            float f = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
            for (AlignmentPattern alignmentPattern : this.possibleCenters) {
                if (alignmentPattern.aboutEquals(f, crossCheckVertical, centerFromEnd)) {
                    return alignmentPattern.combineEstimate(crossCheckVertical, centerFromEnd, f);
                }
            }
            AlignmentPattern alignmentPattern2 = new AlignmentPattern(centerFromEnd, crossCheckVertical, f);
            this.possibleCenters.add(alignmentPattern2);
            if (this.resultPointCallback != null) {
                this.resultPointCallback.foundPossibleResultPoint(alignmentPattern2);
            }
        }
        return null;
    }
}

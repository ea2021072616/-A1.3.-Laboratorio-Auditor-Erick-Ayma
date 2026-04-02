package com.google.zxing.aztec;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
/* loaded from: classes2.dex */
public final class AztecReader implements Reader {
    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return decode(binaryBitmap, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044 A[LOOP:0: B:14:0x0042->B:15:0x0044, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    @Override // com.google.zxing.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.zxing.Result decode(com.google.zxing.BinaryBitmap r11, java.util.Map<com.google.zxing.DecodeHintType, ?> r12) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException {
        /*
            r10 = this;
            r3 = 0
            r2 = 0
            com.google.zxing.aztec.detector.Detector r5 = new com.google.zxing.aztec.detector.Detector
            com.google.zxing.common.BitMatrix r0 = r11.getBlackMatrix()
            r5.<init>(r0)
            r0 = 0
            com.google.zxing.aztec.AztecDetectorResult r0 = r5.detect(r0)     // Catch: com.google.zxing.NotFoundException -> L4c com.google.zxing.FormatException -> L52
            com.google.zxing.ResultPoint[] r1 = r0.getPoints()     // Catch: com.google.zxing.NotFoundException -> L4c com.google.zxing.FormatException -> L52
            com.google.zxing.aztec.decoder.Decoder r4 = new com.google.zxing.aztec.decoder.Decoder     // Catch: com.google.zxing.FormatException -> L92 com.google.zxing.NotFoundException -> L94
            r4.<init>()     // Catch: com.google.zxing.FormatException -> L92 com.google.zxing.NotFoundException -> L94
            com.google.zxing.common.DecoderResult r0 = r4.decode(r0)     // Catch: com.google.zxing.FormatException -> L92 com.google.zxing.NotFoundException -> L94
            r4 = r1
            r1 = r2
        L1f:
            if (r0 != 0) goto L96
            r0 = 1
            com.google.zxing.aztec.AztecDetectorResult r0 = r5.detect(r0)     // Catch: com.google.zxing.FormatException -> L5a com.google.zxing.NotFoundException -> L90
            com.google.zxing.ResultPoint[] r4 = r0.getPoints()     // Catch: com.google.zxing.FormatException -> L5a com.google.zxing.NotFoundException -> L90
            com.google.zxing.aztec.decoder.Decoder r5 = new com.google.zxing.aztec.decoder.Decoder     // Catch: com.google.zxing.FormatException -> L5a com.google.zxing.NotFoundException -> L90
            r5.<init>()     // Catch: com.google.zxing.FormatException -> L5a com.google.zxing.NotFoundException -> L90
            com.google.zxing.common.DecoderResult r0 = r5.decode(r0)     // Catch: com.google.zxing.FormatException -> L5a com.google.zxing.NotFoundException -> L90
            r8 = r0
        L34:
            if (r12 == 0) goto L62
            com.google.zxing.DecodeHintType r0 = com.google.zxing.DecodeHintType.NEED_RESULT_POINT_CALLBACK
            java.lang.Object r0 = r12.get(r0)
            com.google.zxing.ResultPointCallback r0 = (com.google.zxing.ResultPointCallback) r0
            if (r0 == 0) goto L62
            int r2 = r4.length
            r1 = r3
        L42:
            if (r1 >= r2) goto L62
            r3 = r4[r1]
            r0.foundPossibleResultPoint(r3)
            int r1 = r1 + 1
            goto L42
        L4c:
            r0 = move-exception
            r1 = r2
        L4e:
            r4 = r1
            r1 = r0
            r0 = r2
            goto L1f
        L52:
            r0 = move-exception
            r1 = r2
        L54:
            r4 = r1
            r1 = r2
            r9 = r0
            r0 = r2
            r2 = r9
            goto L1f
        L5a:
            r0 = move-exception
        L5b:
            if (r1 == 0) goto L5e
            throw r1
        L5e:
            if (r2 == 0) goto L61
            throw r2
        L61:
            throw r0
        L62:
            com.google.zxing.Result r0 = new com.google.zxing.Result
            java.lang.String r1 = r8.getText()
            byte[] r2 = r8.getRawBytes()
            int r3 = r8.getNumBits()
            com.google.zxing.BarcodeFormat r5 = com.google.zxing.BarcodeFormat.AZTEC
            long r6 = java.lang.System.currentTimeMillis()
            r0.<init>(r1, r2, r3, r4, r5, r6)
            java.util.List r1 = r8.getByteSegments()
            if (r1 == 0) goto L84
            com.google.zxing.ResultMetadataType r2 = com.google.zxing.ResultMetadataType.BYTE_SEGMENTS
            r0.putMetadata(r2, r1)
        L84:
            java.lang.String r1 = r8.getECLevel()
            if (r1 == 0) goto L8f
            com.google.zxing.ResultMetadataType r2 = com.google.zxing.ResultMetadataType.ERROR_CORRECTION_LEVEL
            r0.putMetadata(r2, r1)
        L8f:
            return r0
        L90:
            r0 = move-exception
            goto L5b
        L92:
            r0 = move-exception
            goto L54
        L94:
            r0 = move-exception
            goto L4e
        L96:
            r8 = r0
            goto L34
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.AztecReader.decode(com.google.zxing.BinaryBitmap, java.util.Map):com.google.zxing.Result");
    }

    @Override // com.google.zxing.Reader
    public void reset() {
    }
}

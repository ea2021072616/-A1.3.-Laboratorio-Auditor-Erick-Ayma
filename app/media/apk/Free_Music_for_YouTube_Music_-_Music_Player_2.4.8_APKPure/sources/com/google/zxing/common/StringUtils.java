package com.google.zxing.common;

import java.nio.charset.Charset;
/* loaded from: classes2.dex */
public final class StringUtils {
    private static final boolean ASSUME_SHIFT_JIS;
    private static final String EUC_JP = "EUC_JP";
    public static final String GB2312 = "GB2312";
    private static final String ISO88591 = "ISO8859_1";
    private static final String PLATFORM_DEFAULT_ENCODING = Charset.defaultCharset().name();
    public static final String SHIFT_JIS = "SJIS";
    private static final String UTF8 = "UTF8";

    static {
        ASSUME_SHIFT_JIS = SHIFT_JIS.equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING) || EUC_JP.equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING);
    }

    private StringUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String guessEncoding(byte[] r23, java.util.Map<com.google.zxing.DecodeHintType, ?> r24) {
        /*
            Method dump skipped, instructions count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.common.StringUtils.guessEncoding(byte[], java.util.Map):java.lang.String");
    }
}

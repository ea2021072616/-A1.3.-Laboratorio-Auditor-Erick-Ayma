package com.google.gson.internal.bind.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public class ISO8601Utils {
    private static final String UTC_ID = "UTC";
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z) {
        return format(date, z, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder((timeZone.getRawOffset() == 0 ? "Z".length() : "+hh:mm".length()) + "yyyy-MM-ddThh:mm:ss".length() + (z ? ".sss".length() : 0));
        padInt(sb, gregorianCalendar.get(1), "yyyy".length());
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, "MM".length());
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), "dd".length());
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), "hh".length());
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), "mm".length());
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), "ss".length());
        if (z) {
            sb.append('.');
            padInt(sb, gregorianCalendar.get(14), "sss".length());
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int abs = Math.abs((offset / 60000) / 60);
            int abs2 = Math.abs((offset / 60000) % 60);
            sb.append(offset < 0 ? '-' : '+');
            padInt(sb, abs, "hh".length());
            sb.append(':');
            padInt(sb, abs2, "mm".length());
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0221  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Date parse(java.lang.String r13, java.text.ParsePosition r14) throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.util.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static boolean checkOffset(String str, int i, char c2) {
        return i < str.length() && str.charAt(i) == c2;
    }

    private static int parseInt(String str, int i, int i2) throws NumberFormatException {
        int i3;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        int i4 = 0;
        if (i < i2) {
            i3 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i4 = -digit;
        } else {
            i3 = i;
        }
        while (i3 < i2) {
            int i5 = i3 + 1;
            int digit2 = Character.digit(str.charAt(i3), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i4 = (i4 * 10) - digit2;
            i3 = i5;
        }
        return -i4;
    }

    private static void padInt(StringBuilder sb, int i, int i2) {
        String num = Integer.toString(i);
        for (int length = i2 - num.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(num);
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                i++;
            } else {
                return i;
            }
        }
        return str.length();
    }
}

package com.facebook.ads.internal.i.b;

import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
class d {
    private static final Pattern d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern e = Pattern.compile("GET /(.*) HTTP");

    /* renamed from: a  reason: collision with root package name */
    public final String f1409a;

    /* renamed from: b  reason: collision with root package name */
    public final long f1410b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f1411c;

    public d(String str) {
        j.a(str);
        long a2 = a(str);
        this.f1410b = Math.max(0L, a2);
        this.f1411c = a2 >= 0;
        this.f1409a = b(str);
    }

    private long a(String str) {
        Matcher matcher = d.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    public static d a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, C.UTF8_NAME));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new d(sb.toString());
            }
            sb.append(readLine).append('\n');
        }
    }

    private String b(String str) {
        Matcher matcher = e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.f1410b + ", partial=" + this.f1411c + ", uri='" + this.f1409a + "'}";
    }
}

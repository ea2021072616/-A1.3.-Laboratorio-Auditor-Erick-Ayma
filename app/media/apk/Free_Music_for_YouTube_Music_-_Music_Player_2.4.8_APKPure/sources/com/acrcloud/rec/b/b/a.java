package com.acrcloud.rec.b.b;

import android.support.graphics.drawable.PathInterpolatorCompat;
import com.facebook.ads.AdError;
import java.util.HashMap;
import java.util.Map;
/* compiled from: ACRCloudException.java */
/* loaded from: classes.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Integer, String> f341a = new HashMap<Integer, String>() { // from class: com.acrcloud.rec.b.b.a.1
        {
            put(0, "Success");
            put(1001, "No Result");
            put(2006, "Engine type error");
            put(2002, "JSON error");
            put(Integer.valueOf((int) PathInterpolatorCompat.MAX_NUM_POINTS), "HTTP error");
            put(2005, "HTTP timeout error");
            put(2004, "Create none fingerprint: may be mute audio");
            put(2000, "Record error: may be no recording permission");
            put(Integer.valueOf((int) AdError.INTERNAL_ERROR_CODE), "Init error");
            put(2010, "UnKnow error");
            put(2003, "No init error");
            put(2008, "Resample audio error");
        }
    };
    private static final long serialVersionUID = 1;

    /* renamed from: b  reason: collision with root package name */
    private String f342b;

    /* renamed from: c  reason: collision with root package name */
    private int f343c;

    public a(int i, String str) {
        super(str);
        this.f342b = "";
        this.f343c = 0;
        this.f343c = i;
        f341a.get(Integer.valueOf(i));
        this.f342b = str;
    }

    public int a() {
        return this.f343c;
    }

    public String b() {
        return this.f342b;
    }

    public static String a(int i) {
        String str = f341a.get(Integer.valueOf(i));
        return str == null ? "" : str;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return e.a(this);
    }

    public static String a(int i, String str) {
        String str2 = f341a.get(Integer.valueOf(i));
        if (str2 == null) {
            str2 = "";
        }
        return e.a(new a(i, str2 + ":" + str));
    }

    public static String b(int i) {
        String str = f341a.get(Integer.valueOf(i));
        if (str == null) {
            str = "";
        }
        return e.a(new a(i, str));
    }
}

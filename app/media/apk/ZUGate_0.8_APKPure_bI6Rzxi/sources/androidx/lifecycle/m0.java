package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public final class m0 {

    /* renamed from: f  reason: collision with root package name */
    public static final Class[] f1118f = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap f1119a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedHashMap f1120b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedHashMap f1121c;

    /* renamed from: d  reason: collision with root package name */
    public final LinkedHashMap f1122d;

    /* renamed from: e  reason: collision with root package name */
    public final l0 f1123e;

    public m0(HashMap hashMap) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f1119a = linkedHashMap;
        this.f1120b = new LinkedHashMap();
        this.f1121c = new LinkedHashMap();
        this.f1122d = new LinkedHashMap();
        this.f1123e = new l0(this, 0);
        linkedHashMap.putAll(hashMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x008b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.os.Bundle a(androidx.lifecycle.m0 r10) {
        /*
            Method dump skipped, instructions count: 692
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.m0.a(androidx.lifecycle.m0):android.os.Bundle");
    }

    public m0() {
        this.f1119a = new LinkedHashMap();
        this.f1120b = new LinkedHashMap();
        this.f1121c = new LinkedHashMap();
        this.f1122d = new LinkedHashMap();
        this.f1123e = new l0(this, 1);
    }
}

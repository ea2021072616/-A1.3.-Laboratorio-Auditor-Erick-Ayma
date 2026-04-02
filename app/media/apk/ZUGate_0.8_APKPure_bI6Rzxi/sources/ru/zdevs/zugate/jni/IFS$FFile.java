package ru.zdevs.zugate.jni;

import androidx.annotation.Keep;
/* loaded from: classes.dex */
public class IFS$FFile {

    /* renamed from: a  reason: collision with root package name */
    public String f4605a;

    /* renamed from: b  reason: collision with root package name */
    public String f4606b;

    /* renamed from: c  reason: collision with root package name */
    public final long f4607c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4608d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4609e;

    @Keep
    public IFS$FFile(String str, String str2, long j5, int i5, int i6) {
        this.f4605a = str;
        this.f4606b = str2 == null ? "" : str2;
        this.f4607c = j5;
        this.f4608d = i5;
        this.f4609e = i6;
    }

    public final boolean a() {
        return (this.f4609e & 1) != 0;
    }
}

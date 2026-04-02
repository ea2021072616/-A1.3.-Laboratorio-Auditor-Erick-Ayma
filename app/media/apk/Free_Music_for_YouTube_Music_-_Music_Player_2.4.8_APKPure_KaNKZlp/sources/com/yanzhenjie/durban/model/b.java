package com.yanzhenjie.durban.model;
/* compiled from: ExifInfo.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f5165a;

    /* renamed from: b  reason: collision with root package name */
    private int f5166b;

    /* renamed from: c  reason: collision with root package name */
    private int f5167c;

    public b(int i, int i2, int i3) {
        this.f5165a = i;
        this.f5166b = i2;
        this.f5167c = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f5165a == bVar.f5165a && this.f5166b == bVar.f5166b) {
            return this.f5167c == bVar.f5167c;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f5165a * 31) + this.f5166b) * 31) + this.f5167c;
    }
}

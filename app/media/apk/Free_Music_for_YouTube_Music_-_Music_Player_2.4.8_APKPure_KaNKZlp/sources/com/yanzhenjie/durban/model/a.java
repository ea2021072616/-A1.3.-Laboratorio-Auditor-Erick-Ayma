package com.yanzhenjie.durban.model;

import android.graphics.Bitmap;
/* compiled from: CropParameters.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f5162a;

    /* renamed from: b  reason: collision with root package name */
    private int f5163b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap.CompressFormat f5164c;
    private int d;
    private String e;
    private String f;
    private b g;

    public a(int i, int i2, Bitmap.CompressFormat compressFormat, int i3, String str, String str2, b bVar) {
        this.f5162a = i;
        this.f5163b = i2;
        this.f5164c = compressFormat;
        this.d = i3;
        this.e = str;
        this.f = str2;
        this.g = bVar;
    }

    public int a() {
        return this.f5162a;
    }

    public int b() {
        return this.f5163b;
    }

    public Bitmap.CompressFormat c() {
        return this.f5164c;
    }

    public int d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }
}

package com.bumptech.glide.load.c;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
/* compiled from: StringLoader.java */
/* loaded from: classes.dex */
public class p<T> implements l<String, T> {

    /* renamed from: a  reason: collision with root package name */
    private final l<Uri, T> f896a;

    public p(l<Uri, T> lVar) {
        this.f896a = lVar;
    }

    @Override // com.bumptech.glide.load.c.l
    public com.bumptech.glide.load.a.c<T> a(String str, int i, int i2) {
        Uri parse;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("/")) {
            parse = a(str);
        } else {
            parse = Uri.parse(str);
            if (parse.getScheme() == null) {
                parse = a(str);
            }
        }
        return this.f896a.a(parse, i, i2);
    }

    private static Uri a(String str) {
        return Uri.fromFile(new File(str));
    }
}

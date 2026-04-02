package com.yanzhenjie.durban;

import android.content.Context;
import java.util.Locale;
/* compiled from: DurbanConfig.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Locale f5138a;

    public static a a(Context context) {
        return new a(context);
    }

    private b(a aVar) {
        this.f5138a = aVar.f5139a;
    }

    public Locale a() {
        return this.f5138a;
    }

    /* compiled from: DurbanConfig.java */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Locale f5139a;

        private a(Context context) {
        }

        public a a(Locale locale) {
            this.f5139a = locale;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }
}

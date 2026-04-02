package com.facebook.ads.internal.util;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final String f1536a;

    /* renamed from: b  reason: collision with root package name */
    public final long f1537b;

    /* renamed from: c  reason: collision with root package name */
    public final long f1538c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f1539a;

        /* renamed from: b  reason: collision with root package name */
        private long f1540b = -1;

        /* renamed from: c  reason: collision with root package name */
        private long f1541c = -1;
        private long d = -1;
        private long e = -1;
        private long f = -1;
        private long g = -1;
        private long h = -1;

        public a(String str) {
            this.f1539a = str;
        }

        public a a(long j) {
            this.f1540b = j;
            return this;
        }

        public k a() {
            return new k(this.f1539a, this.f1540b, this.f1541c, this.d, this.e, this.f, this.g, this.h);
        }

        public a b(long j) {
            this.f1541c = j;
            return this;
        }

        public a c(long j) {
            this.d = j;
            return this;
        }

        public a d(long j) {
            this.e = j;
            return this;
        }

        public a e(long j) {
            this.f = j;
            return this;
        }

        public a f(long j) {
            this.g = j;
            return this;
        }

        public a g(long j) {
            this.h = j;
            return this;
        }
    }

    private k(String str, long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.f1536a = str;
        this.f1537b = j;
        this.f1538c = j2;
        this.d = j3;
        this.e = j4;
        this.f = j5;
        this.g = j6;
        this.h = j7;
    }

    public Map<String, String> a() {
        HashMap hashMap = new HashMap(7);
        hashMap.put("initial_url", this.f1536a);
        hashMap.put("handler_time_ms", String.valueOf(this.f1537b));
        hashMap.put("load_start_ms", String.valueOf(this.f1538c));
        hashMap.put("response_end_ms", String.valueOf(this.d));
        hashMap.put("dom_content_loaded_ms", String.valueOf(this.e));
        hashMap.put("scroll_ready_ms", String.valueOf(this.f));
        hashMap.put("load_finish_ms", String.valueOf(this.g));
        hashMap.put("session_finish_ms", String.valueOf(this.h));
        return hashMap;
    }
}

package com.bumptech.glide.load.c;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: LazyHeaders.java */
/* loaded from: classes.dex */
public final class j implements e {

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, List<i>> f884c;
    private volatile Map<String, String> d;

    j(Map<String, List<i>> map) {
        this.f884c = Collections.unmodifiableMap(map);
    }

    @Override // com.bumptech.glide.load.c.e
    public Map<String, String> a() {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.d = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.d;
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<i>> entry : this.f884c.entrySet()) {
            StringBuilder sb = new StringBuilder();
            List<i> value = entry.getValue();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < value.size()) {
                    sb.append(value.get(i2).a());
                    if (i2 != value.size() - 1) {
                        sb.append(',');
                    }
                    i = i2 + 1;
                }
            }
            hashMap.put(entry.getKey(), sb.toString());
        }
        return hashMap;
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f884c + '}';
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f884c.equals(((j) obj).f884c);
        }
        return false;
    }

    public int hashCode() {
        return this.f884c.hashCode();
    }

    /* compiled from: LazyHeaders.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final String f885a = System.getProperty("http.agent");

        /* renamed from: b  reason: collision with root package name */
        private static final Map<String, List<i>> f886b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f887c = true;
        private Map<String, List<i>> d = f886b;
        private boolean e = true;
        private boolean f = true;

        static {
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(f885a)) {
                hashMap.put(b.a.a.a.a.b.a.HEADER_USER_AGENT, Collections.singletonList(new b(f885a)));
            }
            hashMap.put("Accept-Encoding", Collections.singletonList(new b("identity")));
            f886b = Collections.unmodifiableMap(hashMap);
        }

        public j a() {
            this.f887c = true;
            return new j(this.d);
        }
    }

    /* compiled from: LazyHeaders.java */
    /* loaded from: classes.dex */
    static final class b implements i {

        /* renamed from: a  reason: collision with root package name */
        private final String f888a;

        b(String str) {
            this.f888a = str;
        }

        @Override // com.bumptech.glide.load.c.i
        public String a() {
            return this.f888a;
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f888a + "'}";
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f888a.equals(((b) obj).f888a);
            }
            return false;
        }

        public int hashCode() {
            return this.f888a.hashCode();
        }
    }
}

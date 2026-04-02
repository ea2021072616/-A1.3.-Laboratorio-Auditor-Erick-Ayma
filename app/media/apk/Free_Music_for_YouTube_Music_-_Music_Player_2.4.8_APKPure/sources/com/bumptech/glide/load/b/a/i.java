package com.bumptech.glide.load.b.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
/* compiled from: SizeConfigStrategy.java */
@TargetApi(19)
/* loaded from: classes.dex */
public class i implements g {

    /* renamed from: a  reason: collision with root package name */
    private static final Bitmap.Config[] f790a = {Bitmap.Config.ARGB_8888, null};

    /* renamed from: b  reason: collision with root package name */
    private static final Bitmap.Config[] f791b = {Bitmap.Config.RGB_565};

    /* renamed from: c  reason: collision with root package name */
    private static final Bitmap.Config[] f792c = {Bitmap.Config.ARGB_4444};
    private static final Bitmap.Config[] d = {Bitmap.Config.ALPHA_8};
    private final b e = new b();
    private final e<a, Bitmap> f = new e<>();
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> g = new HashMap();

    @Override // com.bumptech.glide.load.b.a.g
    public void a(Bitmap bitmap) {
        a a2 = this.e.a(com.bumptech.glide.i.h.a(bitmap), bitmap.getConfig());
        this.f.a(a2, bitmap);
        NavigableMap<Integer, Integer> a3 = a(bitmap.getConfig());
        Integer num = (Integer) a3.get(Integer.valueOf(a2.f795b));
        a3.put(Integer.valueOf(a2.f795b), Integer.valueOf(num == null ? 1 : num.intValue() + 1));
    }

    @Override // com.bumptech.glide.load.b.a.g
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        int a2 = com.bumptech.glide.i.h.a(i, i2, config);
        Bitmap a3 = this.f.a((e<a, Bitmap>) a(this.e.a(a2, config), a2, config));
        if (a3 != null) {
            a(Integer.valueOf(com.bumptech.glide.i.h.a(a3)), a3.getConfig());
            a3.reconfigure(i, i2, a3.getConfig() != null ? a3.getConfig() : Bitmap.Config.ARGB_8888);
        }
        return a3;
    }

    private a a(a aVar, int i, Bitmap.Config config) {
        Bitmap.Config[] b2;
        for (Bitmap.Config config2 : b(config)) {
            Integer ceilingKey = a(config2).ceilingKey(Integer.valueOf(i));
            if (ceilingKey != null && ceilingKey.intValue() <= i * 8) {
                if (ceilingKey.intValue() == i) {
                    if (config2 == null) {
                        if (config == null) {
                            return aVar;
                        }
                    } else if (config2.equals(config)) {
                        return aVar;
                    }
                }
                this.e.a(aVar);
                return this.e.a(ceilingKey.intValue(), config2);
            }
        }
        return aVar;
    }

    @Override // com.bumptech.glide.load.b.a.g
    public Bitmap a() {
        Bitmap a2 = this.f.a();
        if (a2 != null) {
            a(Integer.valueOf(com.bumptech.glide.i.h.a(a2)), a2.getConfig());
        }
        return a2;
    }

    private void a(Integer num, Bitmap.Config config) {
        NavigableMap<Integer, Integer> a2 = a(config);
        Integer num2 = (Integer) a2.get(num);
        if (num2.intValue() == 1) {
            a2.remove(num);
        } else {
            a2.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private NavigableMap<Integer, Integer> a(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.g.get(config);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.g.put(config, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    @Override // com.bumptech.glide.load.b.a.g
    public String b(Bitmap bitmap) {
        return b(com.bumptech.glide.i.h.a(bitmap), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.b.a.g
    public String b(int i, int i2, Bitmap.Config config) {
        return b(com.bumptech.glide.i.h.a(i, i2, config), config);
    }

    @Override // com.bumptech.glide.load.b.a.g
    public int c(Bitmap bitmap) {
        return com.bumptech.glide.i.h.a(bitmap);
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("SizeConfigStrategy{groupedMap=").append(this.f).append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.g.entrySet()) {
            append.append(entry.getKey()).append('[').append(entry.getValue()).append("], ");
        }
        if (!this.g.isEmpty()) {
            append.replace(append.length() - 2, append.length(), "");
        }
        return append.append(")}").toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SizeConfigStrategy.java */
    /* loaded from: classes.dex */
    public static class b extends com.bumptech.glide.load.b.a.b<a> {
        b() {
        }

        public a a(int i, Bitmap.Config config) {
            a c2 = c();
            c2.a(i, config);
            return c2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.b.a.b
        /* renamed from: a */
        public a b() {
            return new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SizeConfigStrategy.java */
    /* loaded from: classes.dex */
    public static final class a implements h {

        /* renamed from: a  reason: collision with root package name */
        private final b f794a;

        /* renamed from: b  reason: collision with root package name */
        private int f795b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap.Config f796c;

        public a(b bVar) {
            this.f794a = bVar;
        }

        public void a(int i, Bitmap.Config config) {
            this.f795b = i;
            this.f796c = config;
        }

        @Override // com.bumptech.glide.load.b.a.h
        public void a() {
            this.f794a.a(this);
        }

        public String toString() {
            return i.b(this.f795b, this.f796c);
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.f795b == aVar.f795b) {
                    if (this.f796c == null) {
                        if (aVar.f796c != null) {
                            return false;
                        }
                    } else if (!this.f796c.equals(aVar.f796c)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            return (this.f796c != null ? this.f796c.hashCode() : 0) + (this.f795b * 31);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SizeConfigStrategy.java */
    /* renamed from: com.bumptech.glide.load.b.a.i$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f793a = new int[Bitmap.Config.values().length];

        static {
            try {
                f793a[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f793a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f793a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f793a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private static Bitmap.Config[] b(Bitmap.Config config) {
        switch (AnonymousClass1.f793a[config.ordinal()]) {
            case 1:
                return f790a;
            case 2:
                return f791b;
            case 3:
                return f792c;
            case 4:
                return d;
            default:
                return new Bitmap.Config[]{config};
        }
    }
}

package com.facebook.ads.internal.adapters;

import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.util.ag;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<f> f1168a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private static final Map<AdPlacementType, String> f1169b = new ConcurrentHashMap();

    static {
        Class cls;
        for (f fVar : f.a()) {
            switch (fVar.l) {
                case BANNER:
                    cls = BannerAdapter.class;
                    break;
                case INTERSTITIAL:
                    cls = InterstitialAdapter.class;
                    break;
                case NATIVE:
                    cls = v.class;
                    break;
                case INSTREAM:
                    cls = r.class;
                    break;
                case REWARDED_VIDEO:
                    cls = x.class;
                    break;
                default:
                    cls = null;
                    break;
            }
            if (cls != null) {
                Class<?> cls2 = fVar.i;
                if (cls2 == null) {
                    try {
                        cls2 = Class.forName(fVar.j);
                    } catch (ClassNotFoundException e) {
                    }
                }
                if (cls2 != null && cls.isAssignableFrom(cls2)) {
                    f1168a.add(fVar);
                }
            }
        }
    }

    public static AdAdapter a(e eVar, AdPlacementType adPlacementType) {
        try {
            f b2 = b(eVar, adPlacementType);
            if (b2 != null && f1168a.contains(b2)) {
                Class<?> cls = b2.i;
                if (cls == null) {
                    cls = Class.forName(b2.j);
                }
                return (AdAdapter) cls.newInstance();
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        return null;
    }

    public static AdAdapter a(String str, AdPlacementType adPlacementType) {
        return a(e.a(str), adPlacementType);
    }

    public static String a(AdPlacementType adPlacementType) {
        if (f1169b.containsKey(adPlacementType)) {
            return f1169b.get(adPlacementType);
        }
        HashSet hashSet = new HashSet();
        for (f fVar : f1168a) {
            if (fVar.l == adPlacementType) {
                hashSet.add(fVar.k.toString());
            }
        }
        String a2 = ag.a(hashSet, ",");
        f1169b.put(adPlacementType, a2);
        return a2;
    }

    private static f b(e eVar, AdPlacementType adPlacementType) {
        for (f fVar : f1168a) {
            if (fVar.k == eVar && fVar.l == adPlacementType) {
                return fVar;
            }
        }
        return null;
    }
}

package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;
/* loaded from: classes.dex */
class ResourcesFlusher {
    private static final String TAG = "ResourcesFlusher";
    private static Field sDrawableCacheField;
    private static boolean sDrawableCacheFieldFetched;
    private static Field sResourcesImplField;
    private static boolean sResourcesImplFieldFetched;
    private static Class sThemedResourceCacheClazz;
    private static boolean sThemedResourceCacheClazzFetched;
    private static Field sThemedResourceCache_mUnthemedEntriesField;
    private static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;

    ResourcesFlusher() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean flush(@NonNull Resources resources) {
        if (Build.VERSION.SDK_INT >= 24) {
            return flushNougats(resources);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return flushMarshmallows(resources);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return flushLollipops(resources);
        }
        return false;
    }

    @RequiresApi(21)
    private static boolean flushLollipops(@NonNull Resources resources) {
        Map map;
        if (!sDrawableCacheFieldFetched) {
            try {
                sDrawableCacheField = Resources.class.getDeclaredField("mDrawableCache");
                sDrawableCacheField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e(TAG, "Could not retrieve Resources#mDrawableCache field", e);
            }
            sDrawableCacheFieldFetched = true;
        }
        if (sDrawableCacheField != null) {
            try {
                map = (Map) sDrawableCacheField.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e(TAG, "Could not retrieve value from Resources#mDrawableCache", e2);
                map = null;
            }
            if (map != null) {
                map.clear();
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    @android.support.annotation.RequiresApi(23)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean flushMarshmallows(@android.support.annotation.NonNull android.content.res.Resources r6) {
        /*
            r1 = 0
            r0 = 1
            boolean r2 = android.support.v7.app.ResourcesFlusher.sDrawableCacheFieldFetched
            if (r2 != 0) goto L18
            java.lang.Class<android.content.res.Resources> r2 = android.content.res.Resources.class
            java.lang.String r3 = "mDrawableCache"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch: java.lang.NoSuchFieldException -> L26
            android.support.v7.app.ResourcesFlusher.sDrawableCacheField = r2     // Catch: java.lang.NoSuchFieldException -> L26
            java.lang.reflect.Field r2 = android.support.v7.app.ResourcesFlusher.sDrawableCacheField     // Catch: java.lang.NoSuchFieldException -> L26
            r3 = 1
            r2.setAccessible(r3)     // Catch: java.lang.NoSuchFieldException -> L26
        L16:
            android.support.v7.app.ResourcesFlusher.sDrawableCacheFieldFetched = r0
        L18:
            r3 = 0
            java.lang.reflect.Field r2 = android.support.v7.app.ResourcesFlusher.sDrawableCacheField
            if (r2 == 0) goto L37
            java.lang.reflect.Field r2 = android.support.v7.app.ResourcesFlusher.sDrawableCacheField     // Catch: java.lang.IllegalAccessException -> L2f
            java.lang.Object r2 = r2.get(r6)     // Catch: java.lang.IllegalAccessException -> L2f
        L23:
            if (r2 != 0) goto L39
        L25:
            return r1
        L26:
            r2 = move-exception
            java.lang.String r3 = "ResourcesFlusher"
            java.lang.String r4 = "Could not retrieve Resources#mDrawableCache field"
            android.util.Log.e(r3, r4, r2)
            goto L16
        L2f:
            r2 = move-exception
            java.lang.String r4 = "ResourcesFlusher"
            java.lang.String r5 = "Could not retrieve value from Resources#mDrawableCache"
            android.util.Log.e(r4, r5, r2)
        L37:
            r2 = r3
            goto L23
        L39:
            if (r2 == 0) goto L43
            boolean r2 = flushThemedResourcesCache(r2)
            if (r2 == 0) goto L43
        L41:
            r1 = r0
            goto L25
        L43:
            r0 = r1
            goto L41
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.ResourcesFlusher.flushMarshmallows(android.content.res.Resources):boolean");
    }

    @RequiresApi(24)
    private static boolean flushNougats(@NonNull Resources resources) {
        Object obj;
        Object obj2;
        boolean z = true;
        if (!sResourcesImplFieldFetched) {
            try {
                sResourcesImplField = Resources.class.getDeclaredField("mResourcesImpl");
                sResourcesImplField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e(TAG, "Could not retrieve Resources#mResourcesImpl field", e);
            }
            sResourcesImplFieldFetched = true;
        }
        if (sResourcesImplField == null) {
            return false;
        }
        try {
            obj = sResourcesImplField.get(resources);
        } catch (IllegalAccessException e2) {
            Log.e(TAG, "Could not retrieve value from Resources#mResourcesImpl", e2);
            obj = null;
        }
        if (obj != null) {
            if (!sDrawableCacheFieldFetched) {
                try {
                    sDrawableCacheField = obj.getClass().getDeclaredField("mDrawableCache");
                    sDrawableCacheField.setAccessible(true);
                } catch (NoSuchFieldException e3) {
                    Log.e(TAG, "Could not retrieve ResourcesImpl#mDrawableCache field", e3);
                }
                sDrawableCacheFieldFetched = true;
            }
            if (sDrawableCacheField != null) {
                try {
                    obj2 = sDrawableCacheField.get(obj);
                } catch (IllegalAccessException e4) {
                    Log.e(TAG, "Could not retrieve value from ResourcesImpl#mDrawableCache", e4);
                }
                if (obj2 != null || !flushThemedResourcesCache(obj2)) {
                    z = false;
                }
                return z;
            }
            obj2 = null;
            if (obj2 != null) {
            }
            z = false;
            return z;
        }
        return false;
    }

    @RequiresApi(16)
    private static boolean flushThemedResourcesCache(@NonNull Object obj) {
        LongSparseArray longSparseArray;
        if (!sThemedResourceCacheClazzFetched) {
            try {
                sThemedResourceCacheClazz = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e) {
                Log.e(TAG, "Could not find ThemedResourceCache class", e);
            }
            sThemedResourceCacheClazzFetched = true;
        }
        if (sThemedResourceCacheClazz == null) {
            return false;
        }
        if (!sThemedResourceCache_mUnthemedEntriesFieldFetched) {
            try {
                sThemedResourceCache_mUnthemedEntriesField = sThemedResourceCacheClazz.getDeclaredField("mUnthemedEntries");
                sThemedResourceCache_mUnthemedEntriesField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e(TAG, "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
            }
            sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
        }
        if (sThemedResourceCache_mUnthemedEntriesField == null) {
            return false;
        }
        try {
            longSparseArray = (LongSparseArray) sThemedResourceCache_mUnthemedEntriesField.get(obj);
        } catch (IllegalAccessException e3) {
            Log.e(TAG, "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
            return true;
        }
        return false;
    }
}

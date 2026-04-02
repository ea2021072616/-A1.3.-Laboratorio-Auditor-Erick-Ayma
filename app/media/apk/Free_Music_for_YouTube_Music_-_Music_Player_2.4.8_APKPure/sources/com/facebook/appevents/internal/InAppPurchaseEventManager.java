package com.facebook.appevents.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import com.facebook.FacebookSdk;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
class InAppPurchaseEventManager {
    private static final String AS_INTERFACE = "asInterface";
    private static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;
    private static final String DETAILS_LIST = "DETAILS_LIST";
    private static final String GET_PURCHASES = "getPurchases";
    private static final String GET_PURCHASE_HISTORY = "getPurchaseHistory";
    private static final String GET_SKU_DETAILS = "getSkuDetails";
    private static final String INAPP = "inapp";
    private static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    private static final String INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    private static final String IN_APP_BILLING_SERVICE = "com.android.vending.billing.IInAppBillingService";
    private static final String IN_APP_BILLING_SERVICE_STUB = "com.android.vending.billing.IInAppBillingService$Stub";
    private static final String IS_BILLING_SUPPORTED = "isBillingSupported";
    private static final String ITEM_ID_LIST = "ITEM_ID_LIST";
    private static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";
    private static final String LAST_LOGGED_TIME_SEC = "LAST_LOGGED_TIME_SEC";
    private static final int MAX_QUERY_PURCHASE_NUM = 30;
    private static final int PURCHASE_EXPIRE_TIME_SEC = 43200;
    private static final int PURCHASE_STOP_QUERY_TIME_SEC = 1200;
    private static final String RESPONSE_CODE = "RESPONSE_CODE";
    private static final int SKU_DETAIL_EXPIRE_TIME_SEC = 43200;
    private static final String SUBSCRIPTION = "subs";
    private static final long SUBSCRIPTION_HARTBEAT_INTERVAL = 86400;
    private static final String TAG = InAppPurchaseEventManager.class.getCanonicalName();
    private static final HashMap<String, Method> methodMap = new HashMap<>();
    private static final HashMap<String, Class<?>> classMap = new HashMap<>();
    private static final String PACKAGE_NAME = FacebookSdk.getApplicationContext().getPackageName();
    private static final String SKU_DETAILS_STORE = "com.facebook.internal.SKU_DETAILS";
    private static final SharedPreferences skuDetailSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(SKU_DETAILS_STORE, 0);
    private static final String PURCHASE_INAPP_STORE = "com.facebook.internal.PURCHASE";
    private static final SharedPreferences purchaseInappSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(PURCHASE_INAPP_STORE, 0);
    private static final String PURCHASE_SUBS_STORE = "com.facebook.internal.PURCHASE_SUBS";
    private static final SharedPreferences purchaseSubsSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(PURCHASE_SUBS_STORE, 0);

    InAppPurchaseEventManager() {
    }

    @Nullable
    public static Object asInterface(Context context, IBinder iBinder) {
        return invokeMethod(context, IN_APP_BILLING_SERVICE_STUB, AS_INTERFACE, null, new Object[]{iBinder});
    }

    public static Map<String, String> getSkuDetails(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        Map<String, String> readSkuDetailsFromCache = readSkuDetailsFromCache(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!readSkuDetailsFromCache.containsKey(next)) {
                arrayList2.add(next);
            }
        }
        readSkuDetailsFromCache.putAll(getSkuDetailsFromGoogle(context, arrayList2, obj, z));
        return readSkuDetailsFromCache;
    }

    private static Map<String, String> getSkuDetailsFromGoogle(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        HashMap hashMap = new HashMap();
        if (obj == null || arrayList.isEmpty()) {
            return hashMap;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(ITEM_ID_LIST, arrayList);
        Object[] objArr = new Object[4];
        objArr[0] = 3;
        objArr[1] = PACKAGE_NAME;
        objArr[2] = z ? SUBSCRIPTION : INAPP;
        objArr[3] = bundle;
        Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_SKU_DETAILS, obj, objArr);
        if (invokeMethod != null) {
            Bundle bundle2 = (Bundle) invokeMethod;
            if (bundle2.getInt(RESPONSE_CODE) == 0) {
                ArrayList<String> stringArrayList = bundle2.getStringArrayList(DETAILS_LIST);
                if (stringArrayList != null && arrayList.size() == stringArrayList.size()) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        hashMap.put(arrayList.get(i), stringArrayList.get(i));
                    }
                }
                writeSkuDetailsToCache(hashMap);
            }
        }
        return hashMap;
    }

    private static Map<String, String> readSkuDetailsFromCache(ArrayList<String> arrayList) {
        HashMap hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            String string = skuDetailSharedPrefs.getString(next, null);
            if (string != null) {
                String[] split = string.split(";", 2);
                if (currentTimeMillis - Long.parseLong(split[0]) < 43200) {
                    hashMap.put(next, split[1]);
                }
            }
        }
        return hashMap;
    }

    private static void writeSkuDetailsToCache(Map<String, String> map) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences.Editor edit = skuDetailSharedPrefs.edit();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            edit.putString(entry.getKey(), currentTimeMillis + ";" + entry.getValue());
        }
        edit.apply();
    }

    private static Boolean isBillingSupported(Context context, Object obj, String str) {
        if (obj == null) {
            return false;
        }
        Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, IS_BILLING_SUPPORTED, obj, new Object[]{3, PACKAGE_NAME, str});
        return Boolean.valueOf(invokeMethod != null && ((Integer) invokeMethod).intValue() == 0);
    }

    public static ArrayList<String> getPurchasesInapp(Context context, Object obj) {
        return filterPurchasesInapp(getPurchases(context, obj, INAPP));
    }

    public static ArrayList<String> getPurchasesSubsExpire(Context context, Object obj) {
        ArrayList<String> arrayList = new ArrayList<>();
        Map<String, ?> all = purchaseSubsSharedPrefs.getAll();
        if (all.isEmpty()) {
            return arrayList;
        }
        ArrayList<String> purchases = getPurchases(context, obj, SUBSCRIPTION);
        HashSet hashSet = new HashSet();
        Iterator<String> it = purchases.iterator();
        while (it.hasNext()) {
            try {
                hashSet.add(new JSONObject(it.next()).getString("productId"));
            } catch (JSONException e) {
                Log.e(TAG, "Error parsing purchase json", e);
            }
        }
        HashSet<String> hashSet2 = new HashSet();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            if (!hashSet.contains(key)) {
                hashSet2.add(key);
            }
        }
        SharedPreferences.Editor edit = purchaseSubsSharedPrefs.edit();
        for (String str : hashSet2) {
            String string = purchaseSubsSharedPrefs.getString(str, "");
            edit.remove(str);
            if (!string.isEmpty()) {
                arrayList.add(purchaseSubsSharedPrefs.getString(str, ""));
            }
        }
        edit.apply();
        return arrayList;
    }

    public static Map<String, SubscriptionType> getPurchasesSubs(Context context, Object obj) {
        HashMap hashMap = new HashMap();
        Iterator<String> it = getPurchases(context, obj, SUBSCRIPTION).iterator();
        while (it.hasNext()) {
            String next = it.next();
            SubscriptionType subsType = getSubsType(next);
            if (subsType != SubscriptionType.DUPLICATED && subsType != SubscriptionType.UNKNOWN) {
                hashMap.put(next, subsType);
            }
        }
        return hashMap;
    }

    private static SubscriptionType getSubsType(String str) {
        SubscriptionType subscriptionType = null;
        try {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("productId");
            String string2 = purchaseSubsSharedPrefs.getString(string, "");
            JSONObject jSONObject2 = string2.isEmpty() ? new JSONObject() : new JSONObject(string2);
            if (!jSONObject2.optString("purchaseToken").equals(jSONObject.get("purchaseToken"))) {
                subscriptionType = currentTimeMillis - (jSONObject.getLong("purchaseTime") / 1000) < 43200 ? SubscriptionType.NEW : SubscriptionType.HEARTBEAT;
            }
            if (subscriptionType == null && !string2.isEmpty()) {
                boolean z = jSONObject2.getBoolean("autoRenewing");
                boolean z2 = jSONObject.getBoolean("autoRenewing");
                if (!z2 && z) {
                    subscriptionType = SubscriptionType.CANCEL;
                } else if (!z && z2) {
                    subscriptionType = SubscriptionType.RESTORE;
                }
            }
            if (subscriptionType == null && !string2.isEmpty()) {
                if (currentTimeMillis - jSONObject2.getLong(LAST_LOGGED_TIME_SEC) > SUBSCRIPTION_HARTBEAT_INTERVAL) {
                    subscriptionType = SubscriptionType.HEARTBEAT;
                } else {
                    subscriptionType = SubscriptionType.DUPLICATED;
                }
            }
            if (subscriptionType != SubscriptionType.DUPLICATED) {
                jSONObject.put(LAST_LOGGED_TIME_SEC, currentTimeMillis);
                purchaseSubsSharedPrefs.edit().putString(string, jSONObject.toString()).apply();
                return subscriptionType;
            }
            return subscriptionType;
        } catch (JSONException e) {
            Log.e(TAG, "parsing purchase failure: ", e);
            return SubscriptionType.UNKNOWN;
        }
    }

    private static ArrayList<String> getPurchases(Context context, Object obj, String str) {
        int i;
        String str2;
        ArrayList<String> arrayList = new ArrayList<>();
        if (obj == null) {
            return arrayList;
        }
        if (isBillingSupported(context, obj, str).booleanValue()) {
            int i2 = 0;
            String str3 = null;
            while (true) {
                Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_PURCHASES, obj, new Object[]{3, PACKAGE_NAME, str, str3});
                if (invokeMethod != null) {
                    Bundle bundle = (Bundle) invokeMethod;
                    if (bundle.getInt(RESPONSE_CODE) == 0) {
                        ArrayList<String> stringArrayList = bundle.getStringArrayList(INAPP_PURCHASE_DATA_LIST);
                        if (stringArrayList == null) {
                            break;
                        }
                        int size = i2 + stringArrayList.size();
                        arrayList.addAll(stringArrayList);
                        str2 = bundle.getString(INAPP_CONTINUATION_TOKEN);
                        i = size;
                        if (i < 30 || str2 == null) {
                            break;
                            break;
                        }
                        int i3 = i;
                        str3 = str2;
                        i2 = i3;
                    }
                }
                i = i2;
                str2 = null;
                if (i < 30) {
                    break;
                }
                int i32 = i;
                str3 = str2;
                i2 = i32;
            }
        }
        return arrayList;
    }

    public static ArrayList<String> getPurchaseHistoryInapp(Context context, Object obj) {
        Class<?> cls;
        ArrayList<String> arrayList = new ArrayList<>();
        return (obj == null || (cls = getClass(context, IN_APP_BILLING_SERVICE)) == null || getMethod(cls, GET_PURCHASE_HISTORY) == null) ? arrayList : filterPurchasesInapp(getPurchaseHistory(context, obj, INAPP));
    }

    private static ArrayList<String> getPurchaseHistory(Context context, Object obj, String str) {
        int i;
        Boolean bool;
        ArrayList<String> arrayList = new ArrayList<>();
        if (isBillingSupported(context, obj, str).booleanValue()) {
            String str2 = null;
            int i2 = 0;
            Boolean bool2 = false;
            do {
                Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_PURCHASE_HISTORY, obj, new Object[]{6, PACKAGE_NAME, str, str2, new Bundle()});
                if (invokeMethod != null) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    Bundle bundle = (Bundle) invokeMethod;
                    if (bundle.getInt(RESPONSE_CODE) == 0) {
                        Iterator<String> it = bundle.getStringArrayList(INAPP_PURCHASE_DATA_LIST).iterator();
                        while (true) {
                            i = i2;
                            if (!it.hasNext()) {
                                bool = bool2;
                                break;
                            }
                            String next = it.next();
                            try {
                            } catch (JSONException e) {
                                Log.e(TAG, "parsing purchase failure: ", e);
                                i2 = i;
                            }
                            if (currentTimeMillis - (new JSONObject(next).getLong("purchaseTime") / 1000) > 1200) {
                                bool = true;
                                break;
                            }
                            arrayList.add(next);
                            i2 = i + 1;
                        }
                        str2 = bundle.getString(INAPP_CONTINUATION_TOKEN);
                        bool2 = bool;
                        i2 = i;
                        if (i2 < 30 || str2 == null) {
                            break;
                            break;
                        }
                    }
                }
                str2 = null;
                if (i2 < 30) {
                    break;
                }
            } while (!bool2.booleanValue());
        }
        return arrayList;
    }

    private static ArrayList<String> filterPurchasesInapp(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        SharedPreferences.Editor edit = purchaseInappSharedPrefs.edit();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            try {
                JSONObject jSONObject = new JSONObject(next);
                String string = jSONObject.getString("productId");
                long j = jSONObject.getLong("purchaseTime");
                String string2 = jSONObject.getString("purchaseToken");
                if (currentTimeMillis - (j / 1000) <= 43200 && !purchaseInappSharedPrefs.getString(string, "").equals(string2)) {
                    edit.putString(string, string2);
                    arrayList2.add(next);
                }
            } catch (JSONException e) {
                Log.e(TAG, "parsing purchase failure: ", e);
            }
        }
        edit.apply();
        return arrayList2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Nullable
    private static Method getMethod(Class<?> cls, String str) {
        boolean z = false;
        Method method = methodMap.get(str);
        if (method == null) {
            Class<?>[] clsArr = null;
            try {
                switch (str.hashCode()) {
                    case -1801122596:
                        if (str.equals(GET_PURCHASES)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1450694211:
                        if (str.equals(IS_BILLING_SUPPORTED)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1123215065:
                        if (str.equals(AS_INTERFACE)) {
                            break;
                        }
                        z = true;
                        break;
                    case -594356707:
                        if (str.equals(GET_PURCHASE_HISTORY)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -573310373:
                        if (str.equals(GET_SKU_DETAILS)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    default:
                        z = true;
                        break;
                }
                switch (z) {
                    case false:
                        clsArr = new Class[]{IBinder.class};
                        break;
                    case true:
                        clsArr = new Class[]{Integer.TYPE, String.class, String.class, Bundle.class};
                        break;
                    case true:
                        clsArr = new Class[]{Integer.TYPE, String.class, String.class};
                        break;
                    case true:
                        clsArr = new Class[]{Integer.TYPE, String.class, String.class, String.class};
                        break;
                    case true:
                        clsArr = new Class[]{Integer.TYPE, String.class, String.class, String.class, Bundle.class};
                        break;
                }
                method = cls.getDeclaredMethod(str, clsArr);
                methodMap.put(str, method);
                return method;
            } catch (NoSuchMethodException e) {
                Log.e(TAG, cls.getName() + "." + str + " method not found", e);
                return method;
            }
        }
        return method;
    }

    @Nullable
    private static Class<?> getClass(Context context, String str) {
        Class<?> cls = classMap.get(str);
        if (cls == null) {
            try {
                cls = context.getClassLoader().loadClass(str);
                classMap.put(str, cls);
                return cls;
            } catch (ClassNotFoundException e) {
                Log.e(TAG, str + " is not available, please add " + str + " to the project.", e);
                return cls;
            }
        }
        return cls;
    }

    @Nullable
    private static Object invokeMethod(Context context, String str, String str2, Object obj, Object[] objArr) {
        Method method;
        Class<?> cls = getClass(context, str);
        if (cls == null || (method = getMethod(cls, str2)) == null) {
            return null;
        }
        if (obj != null) {
            obj = cls.cast(obj);
        }
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            Log.e(TAG, "Illegal access to method " + cls.getName() + "." + method.getName(), e);
            return null;
        } catch (InvocationTargetException e2) {
            Log.e(TAG, "Invocation target exception in " + cls.getName() + "." + method.getName(), e2);
            return null;
        }
    }

    public static void clearSkuDetailsCache() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long j = skuDetailSharedPrefs.getLong(LAST_CLEARED_TIME, 0L);
        if (j == 0) {
            skuDetailSharedPrefs.edit().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
        } else if (currentTimeMillis - j > 604800) {
            skuDetailSharedPrefs.edit().clear().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
        }
    }
}

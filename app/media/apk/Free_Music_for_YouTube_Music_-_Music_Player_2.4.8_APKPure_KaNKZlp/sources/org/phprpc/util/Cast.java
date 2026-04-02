package org.phprpc.util;

import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.appevents.AppEventsConstants;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public final class Cast {
    private static Class enumClass;
    private static Method getEnumConstants;

    static {
        try {
            enumClass = Class.forName("java.lang.Enum");
            getEnumConstants = Class.class.getDeclaredMethod("getEnumConstants", new Class[0]);
            getEnumConstants.setAccessible(true);
        } catch (Exception e) {
            enumClass = null;
            getEnumConstants = null;
        }
    }

    private Cast() {
    }

    public static byte[] getBytes(Object obj, String str) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        try {
            return obj.toString().getBytes(str);
        } catch (Exception e) {
            return obj.toString().getBytes();
        }
    }

    public static byte[] getBytes(Object obj) {
        return getBytes(obj, AudienceNetworkActivity.WEBVIEW_ENCODING);
    }

    public static String toString(Object obj, String str) {
        if (obj instanceof byte[]) {
            try {
                return new String((byte[]) obj, str);
            } catch (Exception e) {
                return new String((byte[]) obj);
            }
        }
        return obj.toString();
    }

    public static String toString(Object obj) {
        return toString(obj, AudienceNetworkActivity.WEBVIEW_ENCODING);
    }

    public static Object cast(Number number, Class cls) {
        if (cls == Byte.class || cls == Byte.TYPE) {
            return new Byte(number.byteValue());
        }
        if (cls == Short.class || cls == Short.TYPE) {
            return new Short(number.shortValue());
        }
        if (cls == Integer.class || cls == Integer.TYPE) {
            return new Integer(number.intValue());
        }
        if (cls == Long.class || cls == Long.TYPE) {
            return new Long(number.longValue());
        }
        if (cls == Float.class || cls == Float.TYPE) {
            return new Float(number.floatValue());
        }
        if (cls == Double.class || cls == Double.TYPE) {
            return new Double(number.doubleValue());
        }
        if (cls == Boolean.class || cls == Boolean.TYPE) {
            return new Boolean(number.byteValue() != 0);
        } else if (enumClass != null && enumClass.isAssignableFrom(cls)) {
            try {
                return Array.get(getEnumConstants.invoke(cls, new Object[0]), number.intValue());
            } catch (Throwable th) {
                return null;
            }
        } else {
            return number;
        }
    }

    public static Object cast(String str, Class cls, String str2) {
        boolean z = true;
        if (cls == char[].class) {
            return str.toCharArray();
        }
        if (cls == byte[].class) {
            return getBytes(str, str2);
        }
        if (cls == StringBuffer.class) {
            return new StringBuffer(str);
        }
        if (cls == Character.class || cls == Character.TYPE) {
            return new Character(str.charAt(0));
        }
        if (cls == Byte.class || cls == Byte.TYPE) {
            return new Byte(str);
        }
        if (cls == Short.class || cls == Short.TYPE) {
            return new Short(str);
        }
        if (cls == Integer.class || cls == Integer.TYPE) {
            return new Integer(str);
        }
        if (cls == Long.class || cls == Long.TYPE) {
            return new Long(str);
        }
        if (cls == Float.class || cls == Float.TYPE) {
            return new Float(str);
        }
        if (cls == Double.class || cls == Double.TYPE) {
            return new Double(str);
        }
        if (cls == Boolean.class || cls == Boolean.TYPE) {
            if (str.equals("") || str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) || str.toLowerCase().equals("false")) {
                z = false;
            }
            return new Boolean(z);
        } else if (cls == BigInteger.class) {
            return new BigInteger(str);
        } else {
            if (cls == BigDecimal.class || cls == Number.class) {
                return new BigDecimal(str);
            }
            if (cls == Boolean.class || cls == Boolean.TYPE) {
                if (str.equals("") || str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) || str.toLowerCase().equals("false")) {
                    z = false;
                }
                return new Boolean(z);
            }
            return str;
        }
    }

    public static Object cast(String str, Class cls) {
        return cast(str, cls, AudienceNetworkActivity.WEBVIEW_ENCODING);
    }

    public static Object cast(AssocArray assocArray, Class cls, String str) {
        if (cls != AssocArray.class) {
            if (cls == ArrayList.class || cls == List.class || cls == Collection.class) {
                return assocArray.toArrayList();
            }
            if (cls == Set.class) {
                return new HashSet(assocArray.toArrayList());
            }
            if (cls == HashMap.class || cls == Map.class) {
                return assocArray.toHashMap();
            }
            if (cls == LinkedHashMap.class) {
                return assocArray.toLinkedHashMap();
            }
            if (cls.isArray()) {
                return toArray(assocArray.toArrayList(), cls.getComponentType(), str);
            }
            if (Collection.class.isAssignableFrom(cls)) {
                try {
                    Method method = cls.getMethod("addAll", Collection.class);
                    Object newInstance = PHPSerializer.newInstance(cls);
                    if (newInstance != null) {
                        method.setAccessible(true);
                        method.invoke(newInstance, assocArray.toArrayList());
                    }
                    return newInstance;
                } catch (Throwable th) {
                    return null;
                }
            } else if (Map.class.isAssignableFrom(cls)) {
                try {
                    Method method2 = cls.getMethod("putAll", Map.class);
                    Object newInstance2 = PHPSerializer.newInstance(cls);
                    if (newInstance2 != null) {
                        method2.setAccessible(true);
                        method2.invoke(newInstance2, assocArray.toHashMap());
                    }
                    return newInstance2;
                } catch (Throwable th2) {
                    return null;
                }
            } else {
                return cast(assocArray.toHashMap(), cls, str);
            }
        }
        return assocArray;
    }

    private static Object cast(HashMap hashMap, Class cls, String str) {
        try {
            PHPSerializer.getClassName(cls);
            Object newInstance = PHPSerializer.newInstance(cls);
            for (Object obj : hashMap.keySet()) {
                String obj2 = obj.toString();
                Object obj3 = hashMap.get(obj);
                Field field = PHPSerializer.getField(newInstance, obj2);
                if (field != null) {
                    field.setAccessible(true);
                    field.set(newInstance, cast(obj3, field.getType(), str));
                }
            }
            return newInstance;
        } catch (Throwable th) {
            return null;
        }
    }

    public static Object cast(Object obj, Class cls, String str) {
        if (obj == null || cls == null || cls == Void.class || cls == Void.TYPE) {
            return null;
        }
        if (!cls.isInstance(obj)) {
            if (obj instanceof byte[]) {
                return cast(toString(obj, str), cls, str);
            }
            if (obj instanceof char[]) {
                return cast(new String((char[]) obj), cls, str);
            }
            if (obj instanceof StringBuffer) {
                return cast(obj.toString(), cls, str);
            }
            if (obj instanceof String) {
                return cast((String) obj, cls, str);
            }
            if (cls == Character.class || cls == Character.TYPE) {
                return new Character(obj.toString().charAt(0));
            }
            if ((obj instanceof Calendar) && Date.class.isAssignableFrom(cls)) {
                return toDate(((Calendar) obj).getTimeInMillis(), cls);
            }
            if (obj instanceof AssocArray) {
                return cast((AssocArray) obj, cls, str);
            }
            if (obj instanceof HashMap) {
                return cast((HashMap) obj, cls, str);
            }
            if ((obj instanceof Boolean) && Number.class.isAssignableFrom(cls)) {
                return cast((Number) new Integer(!((Boolean) obj).booleanValue() ? 0 : 1), cls);
            } else if (cls == String.class) {
                return obj.toString();
            } else {
                if (cls == StringBuffer.class) {
                    return new StringBuffer(obj.toString());
                }
                if (!obj.getClass().isArray() && cls == byte[].class) {
                    return getBytes(obj);
                }
                if (!obj.getClass().isArray() && cls == char[].class) {
                    return obj.toString().toCharArray();
                }
                if (obj instanceof Number) {
                    return cast((Number) obj, cls);
                }
                return obj;
            }
        }
        return obj;
    }

    public static Object cast(Object obj, Class cls) {
        return cast(obj, cls, AudienceNetworkActivity.WEBVIEW_ENCODING);
    }

    public static Object toArray(ArrayList arrayList, Class cls, String str) {
        int size = arrayList.size();
        Object newInstance = Array.newInstance(cls, size);
        for (int i = 0; i < size; i++) {
            Array.set(newInstance, i, cast(arrayList.get(i), cls, str));
        }
        return newInstance;
    }

    public static Date toDate(long j, Class cls) {
        if (cls == Date.class) {
            return new Date(j);
        }
        if (cls == java.sql.Date.class) {
            return new java.sql.Date(j);
        }
        if (cls == Time.class) {
            return new Time(j);
        }
        if (cls == Timestamp.class) {
            return new Timestamp(j);
        }
        try {
            return (Date) cls.getConstructor(Long.TYPE).newInstance(new Long(j));
        } catch (Throwable th) {
            return null;
        }
    }
}

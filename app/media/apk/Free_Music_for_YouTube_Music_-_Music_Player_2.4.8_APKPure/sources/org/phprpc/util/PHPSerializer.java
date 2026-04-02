package org.phprpc.util;

import b.a.a.a.a.d.b;
import com.google.android.exoplayer2.C;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public final class PHPSerializer {
    private static final byte __0 = 48;
    private static final byte __1 = 49;
    private static final byte __C = 67;
    private static final byte __Colon = 58;
    private static final String __INF = "INF";
    private static final byte __LeftB = 123;
    private static final byte __N = 78;
    private static final String __NAN = "NAN";
    private static final String __NINF = "-INF";
    private static final byte __O = 79;
    private static final byte __Quote = 34;
    private static final byte __R = 82;
    private static final byte __RightB = 125;
    private static final byte __S = 83;
    private static final byte __Semicolon = 59;
    private static final byte __Slash = 92;
    private static final byte __U = 85;
    private static final byte __a = 97;
    private static final byte __b = 98;
    private static final byte __d = 100;
    private static final byte __i = 105;
    private static final byte __r = 114;
    private static final byte __s = 115;
    private static Class enumClass;
    private static Field enumOrdinal;
    private String charset = C.UTF8_NAME;
    private static final HashMap clscache = new HashMap();
    private static final HashMap fieldcache = new HashMap();
    private static final HashMap __sleepcache = new HashMap();
    private static final HashMap __wakeupcache = new HashMap();

    static {
        try {
            enumClass = Class.forName("java.lang.Enum");
            enumOrdinal = enumClass.getDeclaredField("ordinal");
            enumOrdinal.setAccessible(true);
        } catch (Exception e) {
            enumClass = null;
            enumOrdinal = null;
        }
    }

    public String getCharset() {
        return this.charset;
    }

    public void setCharset(String str) {
        this.charset = str;
    }

    public byte[] serialize(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        HashMap hashMap = new HashMap();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        serialize(byteArrayOutputStream, obj, hashMap, 1);
        return byteArrayOutputStream.toByteArray();
    }

    private int serialize(ByteArrayOutputStream byteArrayOutputStream, Object obj, HashMap hashMap, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (obj == null) {
            int i2 = i + 1;
            writeNull(byteArrayOutputStream);
            return i2;
        } else if (obj instanceof Boolean) {
            int i3 = i + 1;
            writeBoolean(byteArrayOutputStream, ((Boolean) obj).booleanValue() ? __1 : __0);
            return i3;
        } else if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer)) {
            int i4 = i + 1;
            writeInteger(byteArrayOutputStream, getAsciiBytes(obj));
            return i4;
        } else if (obj instanceof Long) {
            int i5 = i + 1;
            writeDouble(byteArrayOutputStream, getAsciiBytes(obj));
            return i5;
        } else if (obj instanceof Float) {
            int i6 = i + 1;
            Float f = (Float) obj;
            if (f.isNaN()) {
                obj = __NAN;
            } else if (f.isInfinite()) {
                obj = f.floatValue() > 0.0f ? __INF : __NINF;
            }
            writeDouble(byteArrayOutputStream, getAsciiBytes(obj));
            return i6;
        } else if (obj instanceof Double) {
            int i7 = i + 1;
            Double d = (Double) obj;
            if (d.isNaN()) {
                obj = __NAN;
            } else if (d.isInfinite()) {
                obj = d.doubleValue() > 0.0d ? __INF : __NINF;
            }
            writeDouble(byteArrayOutputStream, getAsciiBytes(obj));
            return i7;
        } else if (obj instanceof byte[]) {
            if (hashMap.containsKey(obj)) {
                writeRef(byteArrayOutputStream, getAsciiBytes(hashMap.get(obj)));
            } else {
                hashMap.put(obj, new Integer(i));
                writeString(byteArrayOutputStream, (byte[]) obj);
            }
            return i + 1;
        } else if (obj instanceof char[]) {
            if (hashMap.containsKey(obj)) {
                writeRef(byteArrayOutputStream, getAsciiBytes(hashMap.get(obj)));
            } else {
                hashMap.put(obj, new Integer(i));
                writeString(byteArrayOutputStream, getBytes(new String((char[]) obj)));
            }
            return i + 1;
        } else if ((obj instanceof Character) || (obj instanceof String) || (obj instanceof StringBuffer)) {
            if (hashMap.containsKey(obj)) {
                writeRef(byteArrayOutputStream, getAsciiBytes(hashMap.get(obj)));
            } else {
                hashMap.put(obj, new Integer(i));
                writeString(byteArrayOutputStream, getBytes(obj));
            }
            return i + 1;
        } else if ((obj instanceof BigInteger) || (obj instanceof BigDecimal) || (obj instanceof Number)) {
            if (hashMap.containsKey(obj)) {
                writeRef(byteArrayOutputStream, getAsciiBytes(hashMap.get(obj)));
            } else {
                hashMap.put(obj, new Integer(i));
                writeString(byteArrayOutputStream, getAsciiBytes(obj));
            }
            return i + 1;
        } else if (obj instanceof Date) {
            if (hashMap.containsKey(obj)) {
                int i8 = i + 1;
                writeRef(byteArrayOutputStream, getAsciiBytes(hashMap.get(obj)));
                return i8;
            }
            hashMap.put(obj, new Integer(i));
            int i9 = i + 8;
            writeDate(byteArrayOutputStream, (Date) obj);
            return i9;
        } else if (obj instanceof Calendar) {
            if (hashMap.containsKey(obj)) {
                int i10 = i + 1;
                writeRef(byteArrayOutputStream, getAsciiBytes(hashMap.get(obj)));
                return i10;
            }
            hashMap.put(obj, new Integer(i));
            int i11 = i + 8;
            writeCalendar(byteArrayOutputStream, (Calendar) obj);
            return i11;
        } else if (!(obj instanceof java.io.Serializable)) {
            writeNull(byteArrayOutputStream);
            return i;
        } else if (obj instanceof AssocArray) {
            HashMap hashMap2 = ((AssocArray) obj).toHashMap();
            if (hashMap.containsKey(hashMap2)) {
                writePointRef(byteArrayOutputStream, getAsciiBytes(hashMap.get(hashMap2)));
                return i;
            }
            hashMap.put(hashMap2, new Integer(i));
            return writeMap(byteArrayOutputStream, hashMap2, hashMap, i + 1);
        } else if (obj.getClass().isArray()) {
            if (hashMap.containsKey(obj)) {
                writePointRef(byteArrayOutputStream, getAsciiBytes(hashMap.get(obj)));
                return i;
            }
            hashMap.put(obj, new Integer(i));
            return writeArray(byteArrayOutputStream, obj, hashMap, i + 1);
        } else if (obj instanceof List) {
            if (hashMap.containsKey(obj)) {
                writePointRef(byteArrayOutputStream, getAsciiBytes(hashMap.get(obj)));
                return i;
            }
            hashMap.put(obj, new Integer(i));
            return writeList(byteArrayOutputStream, (List) obj, hashMap, i + 1);
        } else if (obj instanceof Collection) {
            if (hashMap.containsKey(obj)) {
                writePointRef(byteArrayOutputStream, getAsciiBytes(hashMap.get(obj)));
                return i;
            }
            hashMap.put(obj, new Integer(i));
            return writeCollection(byteArrayOutputStream, (Collection) obj, hashMap, i + 1);
        } else if (obj instanceof Map) {
            if (hashMap.containsKey(obj)) {
                writePointRef(byteArrayOutputStream, getAsciiBytes(hashMap.get(obj)));
                return i;
            }
            hashMap.put(obj, new Integer(i));
            return writeMap(byteArrayOutputStream, (Map) obj, hashMap, i + 1);
        } else if (enumClass != null && enumClass.isAssignableFrom(obj.getClass())) {
            int i12 = i + 1;
            writeInteger(byteArrayOutputStream, getAsciiBytes(enumOrdinal.get(obj)));
            return i12;
        } else if (hashMap.containsKey(obj)) {
            int i13 = i + 1;
            writeRef(byteArrayOutputStream, getAsciiBytes(hashMap.get(obj)));
            return i13;
        } else {
            hashMap.put(obj, new Integer(i));
            return writeObject(byteArrayOutputStream, obj, hashMap, i + 1);
        }
    }

    private void writeNull(ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.write(78);
        byteArrayOutputStream.write(59);
    }

    private void writeRef(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr) {
        byteArrayOutputStream.write(114);
        byteArrayOutputStream.write(58);
        byteArrayOutputStream.write(bArr, 0, bArr.length);
        byteArrayOutputStream.write(59);
    }

    private void writePointRef(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr) {
        byteArrayOutputStream.write(82);
        byteArrayOutputStream.write(58);
        byteArrayOutputStream.write(bArr, 0, bArr.length);
        byteArrayOutputStream.write(59);
    }

    private void writeBoolean(ByteArrayOutputStream byteArrayOutputStream, byte b2) {
        byteArrayOutputStream.write(98);
        byteArrayOutputStream.write(58);
        byteArrayOutputStream.write(b2);
        byteArrayOutputStream.write(59);
    }

    private void writeInteger(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr) {
        byteArrayOutputStream.write(105);
        byteArrayOutputStream.write(58);
        byteArrayOutputStream.write(bArr, 0, bArr.length);
        byteArrayOutputStream.write(59);
    }

    private void writeDouble(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr) {
        byteArrayOutputStream.write(100);
        byteArrayOutputStream.write(58);
        byteArrayOutputStream.write(bArr, 0, bArr.length);
        byteArrayOutputStream.write(59);
    }

    private void writeString(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr) {
        byte[] asciiBytes = getAsciiBytes(new Integer(bArr.length));
        byteArrayOutputStream.write(115);
        byteArrayOutputStream.write(58);
        byteArrayOutputStream.write(asciiBytes, 0, asciiBytes.length);
        byteArrayOutputStream.write(58);
        byteArrayOutputStream.write(34);
        byteArrayOutputStream.write(bArr, 0, bArr.length);
        byteArrayOutputStream.write(34);
        byteArrayOutputStream.write(59);
    }

    private void writeCalendar(ByteArrayOutputStream byteArrayOutputStream, Calendar calendar) {
        byte[] bytes = getBytes("PHPRPC_Date");
        byte[] asciiBytes = getAsciiBytes(new Integer(bytes.length));
        byteArrayOutputStream.write(79);
        byteArrayOutputStream.write(58);
        byteArrayOutputStream.write(asciiBytes, 0, asciiBytes.length);
        byteArrayOutputStream.write(58);
        byteArrayOutputStream.write(34);
        byteArrayOutputStream.write(bytes, 0, bytes.length);
        byteArrayOutputStream.write(34);
        byteArrayOutputStream.write(58);
        byteArrayOutputStream.write(55);
        byteArrayOutputStream.write(58);
        byteArrayOutputStream.write(123);
        writeString(byteArrayOutputStream, getBytes("year"));
        writeInteger(byteArrayOutputStream, getAsciiBytes(new Integer(calendar.get(1))));
        writeString(byteArrayOutputStream, getBytes("month"));
        writeInteger(byteArrayOutputStream, getAsciiBytes(new Integer(calendar.get(2) + 1)));
        writeString(byteArrayOutputStream, getBytes("day"));
        writeInteger(byteArrayOutputStream, getAsciiBytes(new Integer(calendar.get(5))));
        writeString(byteArrayOutputStream, getBytes("hour"));
        writeInteger(byteArrayOutputStream, getAsciiBytes(new Integer(calendar.get(11))));
        writeString(byteArrayOutputStream, getBytes("minute"));
        writeInteger(byteArrayOutputStream, getAsciiBytes(new Integer(calendar.get(12))));
        writeString(byteArrayOutputStream, getBytes("second"));
        writeInteger(byteArrayOutputStream, getAsciiBytes(new Integer(calendar.get(13))));
        writeString(byteArrayOutputStream, getBytes("millisecond"));
        writeInteger(byteArrayOutputStream, getAsciiBytes(new Integer(0)));
        byteArrayOutputStream.write(125);
    }

    private void writeDate(ByteArrayOutputStream byteArrayOutputStream, Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        writeCalendar(byteArrayOutputStream, gregorianCalendar);
    }

    private int writeArray(ByteArrayOutputStream byteArrayOutputStream, Object obj, HashMap hashMap, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int length = Array.getLength(obj);
        byte[] asciiBytes = getAsciiBytes(new Integer(length));
        byteArrayOutputStream.write(97);
        byteArrayOutputStream.write(58);
        byteArrayOutputStream.write(asciiBytes, 0, asciiBytes.length);
        byteArrayOutputStream.write(58);
        byteArrayOutputStream.write(123);
        for (int i2 = 0; i2 < length; i2++) {
            writeInteger(byteArrayOutputStream, getAsciiBytes(new Integer(i2)));
            i = serialize(byteArrayOutputStream, Array.get(obj, i2), hashMap, i);
        }
        byteArrayOutputStream.write(125);
        return i;
    }

    private int writeCollection(ByteArrayOutputStream byteArrayOutputStream, Collection collection, HashMap hashMap, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i2 = 0;
        byte[] asciiBytes = getAsciiBytes(new Integer(collection.size()));
        byteArrayOutputStream.write(97);
        byteArrayOutputStream.write(58);
        byteArrayOutputStream.write(asciiBytes, 0, asciiBytes.length);
        byteArrayOutputStream.write(58);
        byteArrayOutputStream.write(123);
        for (Object obj : collection) {
            writeInteger(byteArrayOutputStream, getAsciiBytes(new Integer(i2)));
            i = serialize(byteArrayOutputStream, obj, hashMap, i);
            i2++;
        }
        byteArrayOutputStream.write(125);
        return i;
    }

    private int writeList(ByteArrayOutputStream byteArrayOutputStream, List list, HashMap hashMap, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int size = list.size();
        byte[] asciiBytes = getAsciiBytes(new Integer(size));
        byteArrayOutputStream.write(97);
        byteArrayOutputStream.write(58);
        byteArrayOutputStream.write(asciiBytes, 0, asciiBytes.length);
        byteArrayOutputStream.write(58);
        byteArrayOutputStream.write(123);
        for (int i2 = 0; i2 < size; i2++) {
            writeInteger(byteArrayOutputStream, getAsciiBytes(new Integer(i2)));
            i = serialize(byteArrayOutputStream, list.get(i2), hashMap, i);
        }
        byteArrayOutputStream.write(125);
        return i;
    }

    private int writeMap(ByteArrayOutputStream byteArrayOutputStream, Map map, HashMap hashMap, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        byte[] asciiBytes = getAsciiBytes(new Integer(map.size()));
        byteArrayOutputStream.write(97);
        byteArrayOutputStream.write(58);
        byteArrayOutputStream.write(asciiBytes, 0, asciiBytes.length);
        byteArrayOutputStream.write(58);
        byteArrayOutputStream.write(123);
        for (Object obj : map.keySet()) {
            if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer)) {
                writeInteger(byteArrayOutputStream, getAsciiBytes(obj));
            } else if (obj instanceof Boolean) {
                byte[] bArr = new byte[1];
                bArr[0] = ((Boolean) obj).booleanValue() ? __1 : __0;
                writeInteger(byteArrayOutputStream, bArr);
            } else {
                writeString(byteArrayOutputStream, getBytes(obj));
            }
            i = serialize(byteArrayOutputStream, map.get(obj), hashMap, i);
        }
        byteArrayOutputStream.write(125);
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00c9 A[LOOP:0: B:12:0x00c3->B:14:0x00c9, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int writeObject(java.io.ByteArrayOutputStream r12, java.lang.Object r13, java.util.HashMap r14, int r15) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.phprpc.util.PHPSerializer.writeObject(java.io.ByteArrayOutputStream, java.lang.Object, java.util.HashMap, int):int");
    }

    private byte[] getBytes(Object obj) {
        try {
            return obj.toString().getBytes(this.charset);
        } catch (Exception e) {
            return obj.toString().getBytes();
        }
    }

    private byte[] getAsciiBytes(Object obj) {
        try {
            return obj.toString().getBytes("US-ASCII");
        } catch (Exception e) {
            return null;
        }
    }

    private String getString(byte[] bArr) {
        try {
            return new String(bArr, this.charset);
        } catch (Exception e) {
            return new String(bArr);
        }
    }

    private Class getInnerClass(StringBuffer stringBuffer, int[] iArr, int i, char c2) {
        if (i < iArr.length) {
            stringBuffer.setCharAt(iArr[i], c2);
            Class innerClass = getInnerClass(stringBuffer, iArr, i + 1, '_');
            if (i + 1 < iArr.length && innerClass == null) {
                return getInnerClass(stringBuffer, iArr, i + 1, '$');
            }
            return innerClass;
        }
        try {
            return Class.forName(stringBuffer.toString());
        } catch (Exception e) {
            return null;
        }
    }

    private Class getClass(StringBuffer stringBuffer, int[] iArr, int i, char c2) {
        if (i < iArr.length) {
            stringBuffer.setCharAt(iArr[i], c2);
            Class cls = getClass(stringBuffer, iArr, i + 1, '.');
            if (i + 1 < iArr.length) {
                if (cls == null) {
                    cls = getClass(stringBuffer, iArr, i + 1, '_');
                }
                if (cls == null) {
                    return getInnerClass(stringBuffer, iArr, i + 1, '$');
                }
                return cls;
            }
            return cls;
        }
        try {
            return Class.forName(stringBuffer.toString());
        } catch (Exception e) {
            return null;
        }
    }

    public Class getClass(String str) {
        Class<?> cls;
        if (clscache.containsKey(str)) {
            return (Class) clscache.get(str);
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        ArrayList arrayList = new ArrayList();
        for (int indexOf = stringBuffer.indexOf(b.ROLL_OVER_FILE_NAME_SEPARATOR); indexOf > -1; indexOf = stringBuffer.indexOf(b.ROLL_OVER_FILE_NAME_SEPARATOR, indexOf + 1)) {
            arrayList.add(new Integer(indexOf));
        }
        if (arrayList.size() > 0) {
            try {
                int[] iArr = (int[]) Cast.toArray(arrayList, Integer.TYPE, this.charset);
                Class<?> cls2 = getClass(stringBuffer, iArr, 0, '.');
                if (cls2 == null) {
                    try {
                        cls2 = getClass(stringBuffer, iArr, 0, '_');
                    } catch (Exception e) {
                        cls = cls2;
                    }
                }
                cls = cls2 == null ? getInnerClass(stringBuffer, iArr, 0, '$') : cls2;
            } catch (Exception e2) {
                cls = null;
            }
        } else {
            try {
                cls = Class.forName(str.toString());
            } catch (Exception e3) {
                cls = null;
            }
        }
        clscache.put(str, cls);
        return cls;
    }

    public static String getClassName(Class cls) {
        String replace = cls.getName().replace('.', '_').replace('$', '_');
        if (!clscache.containsKey(replace)) {
            clscache.put(replace, cls);
        }
        return replace;
    }

    public static Field getField(Object obj, String str) {
        for (Class<? super Object> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                int modifiers = declaredField.getModifiers();
                if (Modifier.isTransient(modifiers) || Modifier.isStatic(modifiers)) {
                    return null;
                }
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Exception e) {
            }
        }
        return null;
    }

    private HashMap getFields(Object obj, String[] strArr) {
        if (strArr == null) {
            return getFields(obj);
        }
        int length = strArr.length;
        HashMap hashMap = new HashMap(length);
        for (int i = 0; i < length; i++) {
            Field field = getField(obj, strArr[i]);
            if (field != null) {
                hashMap.put(strArr[i], field);
            }
        }
        return hashMap;
    }

    private HashMap getFields(Object obj) {
        HashMap hashMap = new HashMap();
        for (Class<? super Object> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                Field field = declaredFields[i];
                int modifiers = declaredFields[i].getModifiers();
                if (!Modifier.isTransient(modifiers) && !Modifier.isStatic(modifiers)) {
                    field.setAccessible(true);
                    if (hashMap.get(field.getName()) == null) {
                        hashMap.put(field.getName(), field);
                    }
                }
            }
        }
        return hashMap;
    }

    public static Object newInstance(Class cls) {
        return newInstance(cls, true);
    }

    private static Object newInstance(Class cls, boolean z) {
        Object invoke;
        try {
            if (z) {
                invoke = cls.newInstance();
            } else {
                ObjectStreamClass lookup = ObjectStreamClass.lookup(cls);
                Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[0]);
                declaredMethod.setAccessible(true);
                invoke = declaredMethod.invoke(lookup, new Object[0]);
            }
            return invoke;
        } catch (Exception e) {
            if (z) {
                return newInstance(cls, false);
            }
            return null;
        }
    }

    public Object unserialize(byte[] bArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return unserialize(bArr, Object.class);
    }

    public Object unserialize(byte[] bArr, Class cls) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return Cast.cast(unserialize(new ByteArrayInputStream(bArr), new ArrayList()), cls, this.charset);
    }

    private Object unserialize(ByteArrayInputStream byteArrayInputStream, ArrayList arrayList) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        switch (byteArrayInputStream.read()) {
            case 67:
                return readCustomObject(byteArrayInputStream, arrayList);
            case 78:
                Object readNull = readNull(byteArrayInputStream);
                arrayList.add(readNull);
                return readNull;
            case 79:
                return readObject(byteArrayInputStream, arrayList);
            case 82:
                return readPointRef(byteArrayInputStream, arrayList);
            case 83:
                byte[] readEscapedString = readEscapedString(byteArrayInputStream);
                arrayList.add(readEscapedString);
                return readEscapedString;
            case 85:
                String readUnicodeString = readUnicodeString(byteArrayInputStream);
                arrayList.add(readUnicodeString);
                return readUnicodeString;
            case 97:
                return readAssocArray(byteArrayInputStream, arrayList);
            case 98:
                Boolean readBoolean = readBoolean(byteArrayInputStream);
                arrayList.add(readBoolean);
                return readBoolean;
            case 100:
                Number readDouble = readDouble(byteArrayInputStream);
                arrayList.add(readDouble);
                return readDouble;
            case 105:
                Number readInteger = readInteger(byteArrayInputStream);
                arrayList.add(readInteger);
                return readInteger;
            case 114:
                return readRef(byteArrayInputStream, arrayList);
            case 115:
                byte[] readString = readString(byteArrayInputStream);
                arrayList.add(readString);
                return readString;
            default:
                return null;
        }
    }

    private String readNumber(ByteArrayInputStream byteArrayInputStream) {
        StringBuffer stringBuffer = new StringBuffer();
        int read = byteArrayInputStream.read();
        while (read != 59 && read != 58) {
            stringBuffer.append((char) read);
            read = byteArrayInputStream.read();
        }
        return stringBuffer.toString();
    }

    private Object readNull(ByteArrayInputStream byteArrayInputStream) {
        byteArrayInputStream.skip(1L);
        return null;
    }

    private Boolean readBoolean(ByteArrayInputStream byteArrayInputStream) {
        byteArrayInputStream.skip(1L);
        Boolean bool = new Boolean(byteArrayInputStream.read() == 49);
        byteArrayInputStream.skip(1L);
        return bool;
    }

    private Number readInteger(ByteArrayInputStream byteArrayInputStream) {
        byteArrayInputStream.skip(1L);
        return new Integer(readNumber(byteArrayInputStream));
    }

    private Number readDouble(ByteArrayInputStream byteArrayInputStream) {
        byteArrayInputStream.skip(1L);
        String readNumber = readNumber(byteArrayInputStream);
        if (readNumber.equals(__NAN)) {
            return new Double(Double.NaN);
        }
        if (readNumber.equals(__INF)) {
            return new Double(Double.POSITIVE_INFINITY);
        }
        if (readNumber.equals(__NINF)) {
            return new Double(Double.NEGATIVE_INFINITY);
        }
        if (readNumber.indexOf(46) > 0 || readNumber.indexOf(101) > 0 || readNumber.indexOf(69) > 0) {
            return new Double(readNumber);
        }
        int length = readNumber.length();
        char charAt = readNumber.charAt(0);
        if (length < 19 || (charAt == '-' && length < 20)) {
            return new Long(readNumber);
        }
        if (length > 20 || (charAt != '-' && length > 19)) {
            return new Double(readNumber);
        }
        try {
            return new Long(readNumber);
        } catch (Exception e) {
            return new Double(readNumber);
        }
    }

    private byte[] readString(ByteArrayInputStream byteArrayInputStream) {
        byteArrayInputStream.skip(1L);
        int parseInt = Integer.parseInt(readNumber(byteArrayInputStream));
        byteArrayInputStream.skip(1L);
        byte[] bArr = new byte[parseInt];
        byteArrayInputStream.read(bArr, 0, parseInt);
        byteArrayInputStream.skip(2L);
        return bArr;
    }

    private byte[] readEscapedString(ByteArrayInputStream byteArrayInputStream) {
        byteArrayInputStream.skip(1L);
        int parseInt = Integer.parseInt(readNumber(byteArrayInputStream));
        byteArrayInputStream.skip(1L);
        byte[] bArr = new byte[parseInt];
        for (int i = 0; i < parseInt; i++) {
            int read = byteArrayInputStream.read();
            if (read == 92) {
                bArr[i] = (byte) (Integer.parseInt(new String(new char[]{(char) byteArrayInputStream.read(), (char) byteArrayInputStream.read()}), 16) & 255);
            } else {
                bArr[i] = (byte) (read & 255);
            }
        }
        byteArrayInputStream.skip(2L);
        return bArr;
    }

    private String readUnicodeString(ByteArrayInputStream byteArrayInputStream) {
        byteArrayInputStream.skip(1L);
        int parseInt = Integer.parseInt(readNumber(byteArrayInputStream));
        byteArrayInputStream.skip(1L);
        StringBuffer stringBuffer = new StringBuffer(parseInt);
        for (int i = 0; i < parseInt; i++) {
            int read = byteArrayInputStream.read();
            if (read == 92) {
                stringBuffer.append((char) Integer.parseInt(new String(new char[]{(char) byteArrayInputStream.read(), (char) byteArrayInputStream.read(), (char) byteArrayInputStream.read(), (char) byteArrayInputStream.read()}), 16));
            } else {
                stringBuffer.append((char) read);
            }
        }
        byteArrayInputStream.skip(2L);
        return stringBuffer.toString();
    }

    private Object readRef(ByteArrayInputStream byteArrayInputStream, ArrayList arrayList) {
        byteArrayInputStream.skip(1L);
        Object obj = arrayList.get(Integer.parseInt(readNumber(byteArrayInputStream)) - 1);
        arrayList.add(obj);
        return obj;
    }

    private Object readPointRef(ByteArrayInputStream byteArrayInputStream, ArrayList arrayList) {
        byteArrayInputStream.skip(1L);
        return arrayList.get(Integer.parseInt(readNumber(byteArrayInputStream)) - 1);
    }

    private AssocArray readAssocArray(ByteArrayInputStream byteArrayInputStream, ArrayList arrayList) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object readUnicodeString;
        byteArrayInputStream.skip(1L);
        int parseInt = Integer.parseInt(readNumber(byteArrayInputStream));
        byteArrayInputStream.skip(1L);
        AssocArray assocArray = new AssocArray(parseInt);
        arrayList.add(assocArray);
        for (int i = 0; i < parseInt; i++) {
            switch (byteArrayInputStream.read()) {
                case 83:
                    readUnicodeString = Cast.cast(readEscapedString(byteArrayInputStream), String.class, this.charset);
                    break;
                case 85:
                    readUnicodeString = readUnicodeString(byteArrayInputStream);
                    break;
                case 105:
                    readUnicodeString = new Integer(readInteger(byteArrayInputStream).intValue());
                    break;
                case 115:
                    readUnicodeString = Cast.cast(readString(byteArrayInputStream), String.class, this.charset);
                    break;
                default:
                    return null;
            }
            Object unserialize = unserialize(byteArrayInputStream, arrayList);
            if (readUnicodeString instanceof Integer) {
                assocArray.set((Integer) readUnicodeString, unserialize);
            } else {
                assocArray.set((String) readUnicodeString, unserialize);
            }
        }
        byteArrayInputStream.skip(1L);
        return assocArray;
    }

    private Calendar readCalendar(ByteArrayInputStream byteArrayInputStream, ArrayList arrayList, int i) {
        String readUnicodeString;
        HashMap hashMap = new HashMap(i);
        for (int i2 = 0; i2 < i; i2++) {
            switch (byteArrayInputStream.read()) {
                case 83:
                    readUnicodeString = getString(readEscapedString(byteArrayInputStream));
                    break;
                case 85:
                    readUnicodeString = readUnicodeString(byteArrayInputStream);
                    break;
                case 115:
                    readUnicodeString = getString(readString(byteArrayInputStream));
                    break;
                default:
                    return null;
            }
            if (byteArrayInputStream.read() != 105) {
                return null;
            }
            hashMap.put(readUnicodeString, Cast.cast(readInteger(byteArrayInputStream), Integer.class));
        }
        byteArrayInputStream.skip(1L);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(((Integer) hashMap.get("year")).intValue(), ((Integer) hashMap.get("month")).intValue() - 1, ((Integer) hashMap.get("day")).intValue(), ((Integer) hashMap.get("hour")).intValue(), ((Integer) hashMap.get("minute")).intValue(), ((Integer) hashMap.get("second")).intValue());
        arrayList.add(gregorianCalendar);
        arrayList.add(hashMap.get("year"));
        arrayList.add(hashMap.get("month"));
        arrayList.add(hashMap.get("day"));
        arrayList.add(hashMap.get("hour"));
        arrayList.add(hashMap.get("minute"));
        arrayList.add(hashMap.get("second"));
        arrayList.add(hashMap.get("millisecond"));
        return gregorianCalendar;
    }

    private Object readObject(ByteArrayInputStream byteArrayInputStream, ArrayList arrayList) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object hashMap;
        HashMap hashMap2;
        String readUnicodeString;
        Field field;
        byteArrayInputStream.skip(1L);
        int parseInt = Integer.parseInt(readNumber(byteArrayInputStream));
        byteArrayInputStream.skip(1L);
        byte[] bArr = new byte[parseInt];
        byteArrayInputStream.read(bArr, 0, parseInt);
        String string = getString(bArr);
        byteArrayInputStream.skip(2L);
        int parseInt2 = Integer.parseInt(readNumber(byteArrayInputStream));
        byteArrayInputStream.skip(1L);
        if (string.equals("PHPRPC_Date")) {
            return readCalendar(byteArrayInputStream, arrayList, parseInt2);
        }
        Class cls = getClass(string);
        if (cls != null) {
            hashMap = newInstance(cls);
            if (hashMap == null) {
                hashMap = new HashMap(parseInt2);
                hashMap2 = null;
            } else {
                hashMap2 = (HashMap) fieldcache.get(cls);
            }
        } else {
            hashMap = new HashMap(parseInt2);
            hashMap2 = null;
        }
        arrayList.add(hashMap);
        for (int i = 0; i < parseInt2; i++) {
            switch (byteArrayInputStream.read()) {
                case 83:
                    readUnicodeString = getString(readEscapedString(byteArrayInputStream));
                    break;
                case 85:
                    readUnicodeString = readUnicodeString(byteArrayInputStream);
                    break;
                case 115:
                    readUnicodeString = getString(readString(byteArrayInputStream));
                    break;
                default:
                    return null;
            }
            String substring = readUnicodeString.charAt(0) == 0 ? readUnicodeString.substring(readUnicodeString.indexOf("\u0000", 1) + 1) : readUnicodeString;
            Object unserialize = unserialize(byteArrayInputStream, arrayList);
            if (hashMap instanceof HashMap) {
                ((HashMap) hashMap).put(substring, unserialize);
            } else {
                if (hashMap2 == null) {
                    field = getField(hashMap, substring);
                } else {
                    field = (Field) hashMap2.get(substring);
                }
                if (field != null) {
                    field.set(hashMap, Cast.cast(unserialize, field.getType(), this.charset));
                }
            }
        }
        byteArrayInputStream.skip(1L);
        if (!(hashMap instanceof HashMap)) {
            Method method = null;
            if (__wakeupcache.containsKey(cls)) {
                method = (Method) __wakeupcache.get(cls);
            } else {
                try {
                    method = cls.getMethod("__wakeup", new Class[0]);
                    method.setAccessible(true);
                } catch (Exception e) {
                }
                __wakeupcache.put(cls, method);
            }
            if (method != null) {
                method.invoke(hashMap, new Object[0]);
                return hashMap;
            }
            return hashMap;
        }
        return hashMap;
    }

    private Object readCustomObject(ByteArrayInputStream byteArrayInputStream, ArrayList arrayList) {
        Object obj;
        byteArrayInputStream.skip(1L);
        int parseInt = Integer.parseInt(readNumber(byteArrayInputStream));
        byteArrayInputStream.skip(1L);
        byte[] bArr = new byte[parseInt];
        byteArrayInputStream.read(bArr, 0, parseInt);
        String string = getString(bArr);
        byteArrayInputStream.skip(2L);
        int parseInt2 = Integer.parseInt(readNumber(byteArrayInputStream));
        byteArrayInputStream.skip(1L);
        Class cls = getClass(string);
        if (cls != null) {
            obj = newInstance(cls);
        } else {
            obj = null;
        }
        arrayList.add(obj);
        if (obj == null) {
            byteArrayInputStream.skip(parseInt2);
        } else if (obj instanceof Serializable) {
            byte[] bArr2 = new byte[parseInt2];
            byteArrayInputStream.read(bArr2, 0, parseInt2);
            ((Serializable) obj).unserialize(bArr2);
        } else {
            byteArrayInputStream.skip(parseInt2);
        }
        byteArrayInputStream.skip(1L);
        return obj;
    }
}

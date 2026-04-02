package com.google.android.gms.internal.play_billing;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
public abstract class k1 {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f1904a;

    static {
        char[] cArr = new char[80];
        f1904a = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static void a(StringBuilder sb, int i5, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                a(sb, i5, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                a(sb, i5, str, entry);
            }
        } else {
            sb.append('\n');
            b(i5, sb);
            if (!str.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Character.toLowerCase(str.charAt(0)));
                for (int i6 = 1; i6 < str.length(); i6++) {
                    char charAt = str.charAt(i6);
                    if (Character.isUpperCase(charAt)) {
                        sb2.append("_");
                    }
                    sb2.append(Character.toLowerCase(charAt));
                }
                str = sb2.toString();
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(e4.e.j0(new a0(((String) obj).getBytes(s0.f1953a))));
                sb.append('\"');
            } else if (obj instanceof z) {
                sb.append(": \"");
                sb.append(e4.e.j0((z) obj));
                sb.append('\"');
            } else if (obj instanceof l0) {
                sb.append(" {");
                c((l0) obj, sb, i5 + 2);
                sb.append("\n");
                b(i5, sb);
                sb.append("}");
            } else if (!(obj instanceof Map.Entry)) {
                sb.append(": ");
                sb.append(obj);
            } else {
                int i7 = i5 + 2;
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                a(sb, i7, "key", entry2.getKey());
                a(sb, i7, "value", entry2.getValue());
                sb.append("\n");
                b(i5, sb);
                sb.append("}");
            }
        }
    }

    public static void b(int i5, StringBuilder sb) {
        while (i5 > 0) {
            int i6 = 80;
            if (i5 <= 80) {
                i6 = i5;
            }
            sb.append(f1904a, 0, i6);
            i5 -= i6;
        }
    }

    public static void c(j1 j1Var, StringBuilder sb, int i5) {
        int i6;
        boolean equals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = j1Var.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i7 = 0;
        while (true) {
            i6 = 3;
            if (i7 >= length) {
                break;
            }
            Method method3 = declaredMethods[i7];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i7++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i6);
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                a(sb, i5, substring.substring(0, substring.length() - 4), l0.f(method2, j1Var, new Object[0]));
            } else if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                a(sb, i5, substring.substring(0, substring.length() - 3), l0.f(method, j1Var, new Object[0]));
            } else if (hashSet.contains("set".concat(substring)) && (!substring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) hashMap.get("has".concat(substring));
                if (method4 != null) {
                    Object f5 = l0.f(method4, j1Var, new Object[0]);
                    if (method5 != null) {
                        if (!((Boolean) l0.f(method5, j1Var, new Object[0])).booleanValue()) {
                        }
                        a(sb, i5, substring, f5);
                    } else if (f5 instanceof Boolean) {
                        if (!((Boolean) f5).booleanValue()) {
                        }
                        a(sb, i5, substring, f5);
                    } else if (f5 instanceof Integer) {
                        if (((Integer) f5).intValue() == 0) {
                        }
                        a(sb, i5, substring, f5);
                    } else if (f5 instanceof Float) {
                        if (Float.floatToRawIntBits(((Float) f5).floatValue()) == 0) {
                        }
                        a(sb, i5, substring, f5);
                    } else if (f5 instanceof Double) {
                        if (Double.doubleToRawLongBits(((Double) f5).doubleValue()) == 0) {
                        }
                        a(sb, i5, substring, f5);
                    } else {
                        if (f5 instanceof String) {
                            equals = f5.equals("");
                        } else if (f5 instanceof z) {
                            equals = f5.equals(z.f1994c);
                        } else if (f5 instanceof j1) {
                            if (f5 == ((l0) ((l0) ((j1) f5)).l(6))) {
                            }
                            a(sb, i5, substring, f5);
                        } else {
                            if ((f5 instanceof Enum) && ((Enum) f5).ordinal() == 0) {
                            }
                            a(sb, i5, substring, f5);
                        }
                        if (equals) {
                        }
                        a(sb, i5, substring, f5);
                    }
                }
            }
            i6 = 3;
        }
        w1 w1Var = ((l0) j1Var).zzc;
        if (w1Var != null) {
            for (int i8 = 0; i8 < w1Var.f1986a; i8++) {
                a(sb, i5, String.valueOf(w1Var.f1987b[i8] >>> 3), w1Var.f1988c[i8]);
            }
        }
    }
}

package com.google.android.gms.internal;

import b.a.a.a.a.d.b;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzefb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzeey zzeeyVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ").append(str);
        zza(zzeeyVar, sb, 0);
        return sb.toString();
    }

    private static void zza(zzeey zzeeyVar, StringBuilder sb, int i) {
        Method[] declaredMethods;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : zzeeyVar.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String replaceFirst = str.replaceFirst("get", "");
            if (replaceFirst.endsWith("List") && !replaceFirst.endsWith("OrBuilderList")) {
                String valueOf = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(replaceFirst.substring(1, replaceFirst.length() - 4));
                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                String valueOf3 = String.valueOf(replaceFirst);
                Method method2 = (Method) hashMap.get(valueOf3.length() != 0 ? "get".concat(valueOf3) : new String("get"));
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb, i, zzrd(concat), zzeed.zza(method2, zzeeyVar, new Object[0]));
                }
            }
            String valueOf4 = String.valueOf(replaceFirst);
            if (((Method) hashMap2.get(valueOf4.length() != 0 ? "set".concat(valueOf4) : new String("set"))) != null) {
                if (replaceFirst.endsWith("Bytes")) {
                    String valueOf5 = String.valueOf(replaceFirst.substring(0, replaceFirst.length() - 5));
                    if (!hashMap.containsKey(valueOf5.length() != 0 ? "get".concat(valueOf5) : new String("get"))) {
                    }
                }
                String valueOf6 = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf7 = String.valueOf(replaceFirst.substring(1));
                String concat2 = valueOf7.length() != 0 ? valueOf6.concat(valueOf7) : new String(valueOf6);
                String valueOf8 = String.valueOf(replaceFirst);
                Method method3 = (Method) hashMap.get(valueOf8.length() != 0 ? "get".concat(valueOf8) : new String("get"));
                String valueOf9 = String.valueOf(replaceFirst);
                Method method4 = (Method) hashMap.get(valueOf9.length() != 0 ? "has".concat(valueOf9) : new String("has"));
                if (method3 != null) {
                    Object zza = zzeed.zza(method3, zzeeyVar, new Object[0]);
                    if (method4 == null ? !(zza instanceof Boolean ? !((Boolean) zza).booleanValue() : zza instanceof Integer ? ((Integer) zza).intValue() == 0 : zza instanceof Float ? (((Float) zza).floatValue() > 0.0f ? 1 : (((Float) zza).floatValue() == 0.0f ? 0 : -1)) == 0 : zza instanceof Double ? (((Double) zza).doubleValue() > 0.0d ? 1 : (((Double) zza).doubleValue() == 0.0d ? 0 : -1)) == 0 : zza instanceof String ? zza.equals("") : zza instanceof zzedk ? zza.equals(zzedk.zzmxr) : zza instanceof zzeey ? zza == ((zzeey) zza).zzcco() : zza instanceof Enum ? ((Enum) zza).ordinal() == 0 : false) : ((Boolean) zzeed.zza(method4, zzeeyVar, new Object[0])).booleanValue()) {
                        zzb(sb, i, zzrd(concat2), zza);
                    }
                }
            }
        }
        if (zzeeyVar instanceof zzeei) {
            Iterator<Map.Entry<Object, Object>> it = ((zzeei) zzeeyVar).zzmyy.iterator();
            if (it.hasNext()) {
                it.next().getKey();
                throw new NoSuchMethodError();
            }
        }
        if (((zzeed) zzeeyVar).zzmyr != null) {
            ((zzeed) zzeeyVar).zzmyr.zzd(sb, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                zzb(sb, i, str, obj2);
            }
            return;
        }
        sb.append('\n');
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"").append(zzefm.zzai(zzedk.zzra((String) obj))).append('\"');
        } else if (obj instanceof zzedk) {
            sb.append(": \"").append(zzefm.zzai((zzedk) obj)).append('\"');
        } else if (!(obj instanceof zzeed)) {
            sb.append(": ").append(obj.toString());
        } else {
            sb.append(" {");
            zza((zzeed) obj, sb, i + 2);
            sb.append("\n");
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append("}");
        }
    }

    private static final String zzrd(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append(b.ROLL_OVER_FILE_NAME_SEPARATOR);
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}

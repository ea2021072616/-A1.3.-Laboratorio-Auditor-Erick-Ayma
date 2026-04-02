package com.facebook.ads.internal.util;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final List<b> f1519a = new ArrayList();

    public static String a() {
        synchronized (f1519a) {
            if (f1519a.isEmpty()) {
                return "";
            }
            ArrayList<b> arrayList = new ArrayList(f1519a);
            f1519a.clear();
            JSONArray jSONArray = new JSONArray();
            for (b bVar : arrayList) {
                jSONArray.put(bVar.a());
            }
            return jSONArray.toString();
        }
    }

    public static void a(b bVar) {
        synchronized (f1519a) {
            f1519a.add(bVar);
        }
    }
}

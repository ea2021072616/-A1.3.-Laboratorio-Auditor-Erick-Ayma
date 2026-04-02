package com.flurry.sdk;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class lq {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f2173a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private Map<String, List<a>> f2174b = new HashMap();

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, Object obj);
    }

    public final synchronized void a(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            Object obj2 = this.f2173a.get(str);
            if (!(obj == obj2 || (obj != null && obj.equals(obj2)))) {
                if (obj == null) {
                    this.f2173a.remove(str);
                } else {
                    this.f2173a.put(str, obj);
                }
                if (this.f2174b.get(str) != null) {
                    for (a aVar : this.f2174b.get(str)) {
                        aVar.a(str, obj);
                    }
                }
            }
        }
    }

    public final synchronized Object a(String str) {
        return this.f2173a.get(str);
    }

    public final synchronized void a(String str, a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            List<a> list = this.f2174b.get(str);
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(aVar);
            this.f2174b.put(str, list);
        }
    }

    public final synchronized boolean b(String str, a aVar) {
        boolean remove;
        if (TextUtils.isEmpty(str)) {
            remove = false;
        } else if (aVar == null) {
            remove = false;
        } else {
            List<a> list = this.f2174b.get(str);
            remove = list == null ? false : list.remove(aVar);
        }
        return remove;
    }
}

package com.fotoable.youtube.music.util;

import android.text.TextUtils;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.bean.RadioBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
/* compiled from: RadioHistoryUtil.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4892a = o.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static o f4893b;

    /* renamed from: c  reason: collision with root package name */
    private Gson f4894c = new Gson();

    public static o a() {
        if (f4893b == null) {
            f4893b = new o();
        }
        return f4893b;
    }

    private o() {
    }

    public List<RadioBean> b() {
        String a2 = v.a(MusicApplication.c(), "radio_history", "");
        if (!TextUtils.isEmpty(a2)) {
            return (List) this.f4894c.fromJson(a2, new TypeToken<List<RadioBean>>() { // from class: com.fotoable.youtube.music.util.o.1
            }.getType());
        }
        return new ArrayList();
    }

    public void a(RadioBean radioBean) {
        List<RadioBean> b2 = b();
        if (radioBean != null && a(radioBean, b2) < 0) {
            if (b2.size() > 10) {
                b2.add(0, radioBean);
                b2.remove(b2.size() - 1);
            } else {
                b2.add(0, radioBean);
            }
            v.b(MusicApplication.c(), "radio_history", this.f4894c.toJson(b2));
        }
    }

    public void b(RadioBean radioBean) {
        List<RadioBean> b2 = b();
        int a2 = a(radioBean, b2);
        h.a(f4892a, a2 + "");
        if (a2 >= 0) {
            b2.remove(a2);
        }
        v.b(MusicApplication.c(), "radio_history", this.f4894c.toJson(b2));
    }

    private int a(RadioBean radioBean, List<RadioBean> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (list.get(i2).getId() != radioBean.getId()) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return -1;
            }
        }
    }
}

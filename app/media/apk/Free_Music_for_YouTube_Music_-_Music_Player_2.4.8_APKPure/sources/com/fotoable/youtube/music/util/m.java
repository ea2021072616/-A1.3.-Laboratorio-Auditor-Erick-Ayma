package com.fotoable.youtube.music.util;

import android.text.TextUtils;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.bean.DurationBean;
import com.fotoable.youtube.music.bean.DurationResultBean;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
/* compiled from: PlayDurationUtil.java */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, String> f4886a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static String f4887b = "(?<=[^\\d])(\\d)(?=[^\\d])";

    /* renamed from: c  reason: collision with root package name */
    private static String f4888c = "0$1";
    private static m d;
    private com.fotoable.youtube.music.b.e e;
    private com.fotoable.youtube.music.db.a f;

    /* compiled from: PlayDurationUtil.java */
    /* loaded from: classes.dex */
    public interface a {
        void onDuration(HashMap<String, String> hashMap);
    }

    private void b() {
        this.e = MusicApplication.c().e().b();
        this.f = MusicApplication.c().e().d();
    }

    private m() {
        b();
    }

    public static m a() {
        if (d == null) {
            d = new m();
        }
        return d;
    }

    public void a(List<String> list, HashMap<String, String> hashMap, a aVar) {
        String a2 = a(list, hashMap, "");
        if (!TextUtils.isEmpty(a2)) {
            a(hashMap, aVar, a2);
        } else if (aVar != null) {
            aVar.onDuration(hashMap);
        }
    }

    private void a(final HashMap<String, String> hashMap, final a aVar, String str) {
        this.e.a(str).a(s.a()).a(new rx.g<DurationResultBean>() { // from class: com.fotoable.youtube.music.util.m.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                b.b("dev_youtube_api_error", "errorName", th.getMessage());
                b.a(th);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(DurationResultBean durationResultBean) {
                if (durationResultBean.getItems() != null && durationResultBean.getItems().size() > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= durationResultBean.getItems().size()) {
                            break;
                        }
                        DurationResultBean.ItemsBean itemsBean = durationResultBean.getItems().get(i2);
                        if (!hashMap.keySet().contains(itemsBean.getId())) {
                            hashMap.put(itemsBean.getId(), m.this.a(itemsBean.getContentDetails().getDuration()));
                        }
                        if (!TextUtils.isEmpty(itemsBean.getId())) {
                            DurationBean durationBean = new DurationBean();
                            durationBean.setVideoId(itemsBean.getId());
                            durationBean.setDuration(itemsBean.getContentDetails().getDuration());
                            m.this.f.a(durationBean);
                        }
                        i = i2 + 1;
                    }
                    if (aVar != null) {
                        aVar.onDuration(hashMap);
                    }
                }
            }
        });
    }

    private String a(List<String> list, HashMap<String, String> hashMap, String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (!TextUtils.isEmpty(list.get(i2))) {
                    DurationBean f = this.f.f(list.get(i2));
                    if (f == null) {
                        if (TextUtils.isEmpty(str)) {
                            str = str + list.get(i2);
                        } else {
                            str = str + "," + list.get(i2);
                        }
                    } else {
                        hashMap.put(list.get(i2), a(f.getDuration()));
                    }
                }
                i = i2 + 1;
            } else {
                return str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        f4886a.put("PT(\\d\\d)S", "00:$1");
        f4886a.put("PT(\\d\\d)M", "$1:00");
        f4886a.put("PT(\\d\\d)H", "$1:00:00");
        f4886a.put("PT(\\d\\d)M(\\d\\d)S", "$1:$2");
        f4886a.put("PT(\\d\\d)H(\\d\\d)S", "$1:00:$2");
        f4886a.put("PT(\\d\\d)H(\\d\\d)M", "$1:$2:00");
        f4886a.put("PT(\\d\\d)H(\\d\\d)M(\\d\\d)S", "$1:$2:$3");
        String replaceAll = str.replaceAll(f4887b, f4888c);
        String b2 = b(replaceAll);
        if (b2 == null) {
            System.out.println(replaceAll + ": invalid");
            return "" + str;
        }
        return replaceAll.replaceAll(b2, f4886a.get(b2));
    }

    private static String b(String str) {
        for (String str2 : f4886a.keySet()) {
            if (Pattern.matches(str2, str)) {
                return str2;
            }
        }
        return null;
    }
}

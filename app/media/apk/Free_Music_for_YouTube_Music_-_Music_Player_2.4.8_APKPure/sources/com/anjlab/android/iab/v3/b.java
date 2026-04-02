package com.anjlab.android.iab.v3;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Pattern;
/* compiled from: BillingCache.java */
/* loaded from: classes.dex */
class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, PurchaseInfo> f593a;

    /* renamed from: b  reason: collision with root package name */
    private String f594b;

    /* renamed from: c  reason: collision with root package name */
    private String f595c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, String str) {
        super(context);
        this.f593a = new HashMap<>();
        this.f594b = str;
        f();
    }

    private String d() {
        return b() + this.f594b;
    }

    private String e() {
        return d() + ".version";
    }

    private void f() {
        String[] split;
        for (String str : b(d(), "").split(Pattern.quote("#####"))) {
            if (!TextUtils.isEmpty(str)) {
                String[] split2 = str.split(Pattern.quote(">>>>>"));
                if (split2.length > 2) {
                    this.f593a.put(split2[0], new PurchaseInfo(split2[1], split2[2]));
                } else if (split2.length > 1) {
                    this.f593a.put(split2[0], new PurchaseInfo(split2[1], null));
                }
            }
        }
        this.f595c = h();
    }

    private void g() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.f593a.keySet()) {
            PurchaseInfo purchaseInfo = this.f593a.get(str);
            arrayList.add(str + ">>>>>" + purchaseInfo.responseData + ">>>>>" + purchaseInfo.signature);
        }
        a(d(), TextUtils.join("#####", arrayList));
        this.f595c = Long.toString(new Date().getTime());
        a(e(), this.f595c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str) {
        i();
        return this.f593a.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PurchaseInfo b(String str) {
        i();
        if (this.f593a.containsKey(str)) {
            return this.f593a.get(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, String str3) {
        i();
        if (!this.f593a.containsKey(str)) {
            this.f593a.put(str, new PurchaseInfo(str2, str3));
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        i();
        this.f593a.clear();
        g();
    }

    private String h() {
        return b(e(), AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    private void i() {
        if (!this.f595c.equalsIgnoreCase(h())) {
            this.f593a.clear();
            f();
        }
    }

    public String toString() {
        return TextUtils.join(", ", this.f593a.keySet());
    }
}

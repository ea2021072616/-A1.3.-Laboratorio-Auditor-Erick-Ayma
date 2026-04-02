package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
/* loaded from: classes.dex */
public enum a {
    f1829c("RESPONSE_CODE_UNSPECIFIED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF18("SERVICE_TIMEOUT"),
    /* JADX INFO: Fake field, exist only in values array */
    EF27("FEATURE_NOT_SUPPORTED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF36("SERVICE_DISCONNECTED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF44("OK"),
    /* JADX INFO: Fake field, exist only in values array */
    EF52("USER_CANCELED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF60("SERVICE_UNAVAILABLE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF68("BILLING_UNAVAILABLE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF77("ITEM_UNAVAILABLE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF86("DEVELOPER_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF95("ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF104("ITEM_ALREADY_OWNED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF113("ITEM_NOT_OWNED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF126("EXPIRED_OFFER_TOKEN"),
    /* JADX INFO: Fake field, exist only in values array */
    EF139("NETWORK_ERROR");
    

    /* renamed from: d  reason: collision with root package name */
    public static final o f1830d;

    /* renamed from: b  reason: collision with root package name */
    public final int f1832b;

    static {
        a[] values;
        y.c cVar = new y.c();
        for (a aVar : values()) {
            Integer valueOf = Integer.valueOf(aVar.f1832b);
            int i5 = cVar.f5543a + 1;
            Object[] objArr = (Object[]) cVar.f5544b;
            int length = objArr.length;
            int i6 = i5 + i5;
            if (i6 > length) {
                int i7 = length + (length >> 1) + 1;
                if (i7 < i6) {
                    int highestOneBit = Integer.highestOneBit(i6 - 1);
                    i7 = highestOneBit + highestOneBit;
                }
                cVar.f5544b = Arrays.copyOf(objArr, i7 < 0 ? Integer.MAX_VALUE : i7);
            }
            if (valueOf == null) {
                throw new NullPointerException("null key in entry: null=".concat(String.valueOf(aVar)));
            }
            Object[] objArr2 = (Object[]) cVar.f5544b;
            int i8 = cVar.f5543a;
            int i9 = i8 + i8;
            objArr2[i9] = valueOf;
            objArr2[i9 + 1] = aVar;
            cVar.f5543a = i8 + 1;
        }
        g gVar = (g) cVar.f5545c;
        if (gVar != null) {
            throw gVar.a();
        }
        o a5 = o.a(cVar.f5543a, (Object[]) cVar.f5544b, cVar);
        g gVar2 = (g) cVar.f5545c;
        if (gVar2 != null) {
            throw gVar2.a();
        }
        f1830d = a5;
    }

    a(String str) {
        this.f1832b = r2;
    }
}

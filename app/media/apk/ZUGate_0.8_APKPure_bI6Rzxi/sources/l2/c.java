package l2;

import android.accounts.Account;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Account f3766a;

    /* renamed from: b  reason: collision with root package name */
    public final Set f3767b;

    /* renamed from: c  reason: collision with root package name */
    public final Set f3768c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3769d;

    /* renamed from: e  reason: collision with root package name */
    public final String f3770e;

    /* renamed from: f  reason: collision with root package name */
    public final t2.a f3771f;

    /* renamed from: g  reason: collision with root package name */
    public Integer f3772g;

    public c(Account account, l.c cVar, String str, String str2, t2.a aVar) {
        this.f3766a = account;
        Set emptySet = cVar == null ? Collections.emptySet() : Collections.unmodifiableSet(cVar);
        this.f3767b = emptySet;
        Map emptyMap = Collections.emptyMap();
        this.f3769d = str;
        this.f3770e = str2;
        this.f3771f = aVar == null ? t2.a.f5026a : aVar;
        HashSet hashSet = new HashSet(emptySet);
        Iterator it = emptyMap.values().iterator();
        if (it.hasNext()) {
            androidx.appcompat.widget.b0.n(it.next());
            throw null;
        } else {
            this.f3768c = Collections.unmodifiableSet(hashSet);
        }
    }
}

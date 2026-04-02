package rx.internal.d;

import rx.m;
/* compiled from: Unsubscribed.java */
/* loaded from: classes2.dex */
public enum b implements m {
    INSTANCE;

    @Override // rx.m
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // rx.m
    public void unsubscribe() {
    }
}

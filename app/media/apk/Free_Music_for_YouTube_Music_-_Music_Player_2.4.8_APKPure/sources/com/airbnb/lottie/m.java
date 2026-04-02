package com.airbnb.lottie;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* compiled from: BaseAnimatableValue.java */
/* loaded from: classes.dex */
abstract class m<V, O> implements k<O> {

    /* renamed from: a  reason: collision with root package name */
    final List<at<V>> f535a;

    /* renamed from: b  reason: collision with root package name */
    final V f536b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(V v) {
        this(Collections.emptyList(), v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(List<at<V>> list, V v) {
        this.f535a = list;
        this.f536b = v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    O a(V v) {
        return v;
    }

    public boolean e() {
        return !this.f535a.isEmpty();
    }

    public O d() {
        return a(this.f536b);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("parseInitialValue=").append(this.f536b);
        if (!this.f535a.isEmpty()) {
            sb.append(", values=").append(Arrays.toString(this.f535a.toArray()));
        }
        return sb.toString();
    }
}

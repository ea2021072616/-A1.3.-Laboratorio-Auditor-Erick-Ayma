package com.airbnb.lottie;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MaskKeyframeAnimation.java */
/* loaded from: classes.dex */
public class ba {

    /* renamed from: a  reason: collision with root package name */
    private final List<n<?, Path>> f437a;

    /* renamed from: b  reason: collision with root package name */
    private final List<az> f438b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(List<az> list) {
        this.f438b = list;
        this.f437a = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                this.f437a.add(list.get(i2).b().b());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<az> a() {
        return this.f438b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<n<?, Path>> b() {
        return this.f437a;
    }
}

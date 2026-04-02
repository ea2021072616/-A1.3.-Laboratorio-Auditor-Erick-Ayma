package com.bumptech.glide.load;

import com.bumptech.glide.load.b.k;
import java.util.Arrays;
import java.util.Collection;
/* compiled from: MultiTransformation.java */
/* loaded from: classes.dex */
public class d<T> implements g<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Collection<? extends g<T>> f900a;

    /* renamed from: b  reason: collision with root package name */
    private String f901b;

    @SafeVarargs
    public d(g<T>... gVarArr) {
        if (gVarArr.length < 1) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.f900a = Arrays.asList(gVarArr);
    }

    @Override // com.bumptech.glide.load.g
    public k<T> transform(k<T> kVar, int i, int i2) {
        k<T> kVar2 = kVar;
        for (g<T> gVar : this.f900a) {
            k<T> transform = gVar.transform(kVar2, i, i2);
            if (kVar2 != null && !kVar2.equals(kVar) && !kVar2.equals(transform)) {
                kVar2.d();
            }
            kVar2 = transform;
        }
        return kVar2;
    }

    @Override // com.bumptech.glide.load.g
    public String getId() {
        if (this.f901b == null) {
            StringBuilder sb = new StringBuilder();
            for (g<T> gVar : this.f900a) {
                sb.append(gVar.getId());
            }
            this.f901b = sb.toString();
        }
        return this.f901b;
    }
}

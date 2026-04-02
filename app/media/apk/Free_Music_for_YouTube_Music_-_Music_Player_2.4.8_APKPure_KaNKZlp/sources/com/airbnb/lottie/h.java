package com.airbnb.lottie;

import android.graphics.Path;
import com.airbnb.lottie.bs;
import com.airbnb.lottie.l;
import java.util.List;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimatableShapeValue.java */
/* loaded from: classes.dex */
public class h extends m<bs, Path> {

    /* renamed from: c  reason: collision with root package name */
    private final Path f524c;

    private h(List<at<bs>> list, bs bsVar) {
        super(list, bsVar);
        this.f524c = new Path();
    }

    @Override // com.airbnb.lottie.k
    public n<?, Path> b() {
        return !e() ? new cd(a((bs) this.f536b)) : new bv(this.f535a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.m
    public Path a(bs bsVar) {
        this.f524c.reset();
        bd.a(bsVar, this.f524c);
        return this.f524c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimatableShapeValue.java */
    /* loaded from: classes.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static h a(JSONObject jSONObject, aw awVar) {
            l.a a2 = l.a(jSONObject, awVar.g(), awVar, bs.a.f477a).a();
            return new h(a2.f533a, (bs) a2.f534b);
        }
    }
}

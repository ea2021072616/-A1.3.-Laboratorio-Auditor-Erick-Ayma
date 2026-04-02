package com.airbnb.lottie;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;
/* compiled from: MergePathsContent.java */
@TargetApi(19)
/* loaded from: classes.dex */
class bc implements bg {
    private final String d;
    private final bb f;

    /* renamed from: a  reason: collision with root package name */
    private final Path f444a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Path f445b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f446c = new Path();
    private final List<bg> e = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.d = bbVar.a();
        this.f = bbVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(x xVar) {
        if (xVar instanceof bg) {
            this.e.add((bg) xVar);
        }
    }

    @Override // com.airbnb.lottie.x
    public void a(List<x> list, List<x> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.e.size()) {
                this.e.get(i2).a(list, list2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.bg
    public Path d() {
        this.f446c.reset();
        switch (this.f.b()) {
            case Merge:
                a();
                break;
            case Add:
                a(Path.Op.UNION);
                break;
            case Subtract:
                a(Path.Op.REVERSE_DIFFERENCE);
                break;
            case Intersect:
                a(Path.Op.INTERSECT);
                break;
            case ExcludeIntersections:
                a(Path.Op.XOR);
                break;
        }
        return this.f446c;
    }

    @Override // com.airbnb.lottie.x
    public String e() {
        return this.d;
    }

    private void a() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.e.size()) {
                this.f446c.addPath(this.e.get(i2).d());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.f445b.reset();
        this.f444a.reset();
        int size = this.e.size() - 1;
        while (true) {
            int i = size;
            if (i < 1) {
                break;
            }
            bg bgVar = this.e.get(i);
            if (bgVar instanceof y) {
                List<bg> b2 = ((y) bgVar).b();
                for (int size2 = b2.size() - 1; size2 >= 0; size2--) {
                    Path d = b2.get(size2).d();
                    d.transform(((y) bgVar).c());
                    this.f445b.addPath(d);
                }
            } else {
                this.f445b.addPath(bgVar.d());
            }
            size = i - 1;
        }
        bg bgVar2 = this.e.get(0);
        if (bgVar2 instanceof y) {
            List<bg> b3 = ((y) bgVar2).b();
            for (int i2 = 0; i2 < b3.size(); i2++) {
                Path d2 = b3.get(i2).d();
                d2.transform(((y) bgVar2).c());
                this.f444a.addPath(d2);
            }
        } else {
            this.f444a.set(bgVar2.d());
        }
        this.f446c.op(this.f444a, this.f445b, op);
    }
}

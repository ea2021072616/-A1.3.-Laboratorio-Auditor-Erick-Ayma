package f1;

import android.graphics.Matrix;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class h extends i {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f2765a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f2766b;

    /* renamed from: c  reason: collision with root package name */
    public float f2767c;

    /* renamed from: d  reason: collision with root package name */
    public float f2768d;

    /* renamed from: e  reason: collision with root package name */
    public float f2769e;

    /* renamed from: f  reason: collision with root package name */
    public float f2770f;

    /* renamed from: g  reason: collision with root package name */
    public float f2771g;

    /* renamed from: h  reason: collision with root package name */
    public float f2772h;

    /* renamed from: i  reason: collision with root package name */
    public float f2773i;

    /* renamed from: j  reason: collision with root package name */
    public final Matrix f2774j;

    /* renamed from: k  reason: collision with root package name */
    public final int f2775k;

    /* renamed from: l  reason: collision with root package name */
    public String f2776l;

    public h(h hVar, l.b bVar) {
        j fVar;
        this.f2765a = new Matrix();
        this.f2766b = new ArrayList();
        this.f2767c = 0.0f;
        this.f2768d = 0.0f;
        this.f2769e = 0.0f;
        this.f2770f = 1.0f;
        this.f2771g = 1.0f;
        this.f2772h = 0.0f;
        this.f2773i = 0.0f;
        Matrix matrix = new Matrix();
        this.f2774j = matrix;
        this.f2776l = null;
        this.f2767c = hVar.f2767c;
        this.f2768d = hVar.f2768d;
        this.f2769e = hVar.f2769e;
        this.f2770f = hVar.f2770f;
        this.f2771g = hVar.f2771g;
        this.f2772h = hVar.f2772h;
        this.f2773i = hVar.f2773i;
        String str = hVar.f2776l;
        this.f2776l = str;
        this.f2775k = hVar.f2775k;
        if (str != null) {
            bVar.put(str, this);
        }
        matrix.set(hVar.f2774j);
        ArrayList arrayList = hVar.f2766b;
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            Object obj = arrayList.get(i5);
            if (obj instanceof h) {
                this.f2766b.add(new h((h) obj, bVar));
            } else {
                if (obj instanceof g) {
                    fVar = new g((g) obj);
                } else if (obj instanceof f) {
                    fVar = new f((f) obj);
                } else {
                    throw new IllegalStateException("Unknown object in the tree!");
                }
                this.f2766b.add(fVar);
                Object obj2 = fVar.f2778b;
                if (obj2 != null) {
                    bVar.put(obj2, fVar);
                }
            }
        }
    }

    @Override // f1.i
    public final boolean a() {
        int i5 = 0;
        while (true) {
            ArrayList arrayList = this.f2766b;
            if (i5 >= arrayList.size()) {
                return false;
            }
            if (((i) arrayList.get(i5)).a()) {
                return true;
            }
            i5++;
        }
    }

    @Override // f1.i
    public final boolean b(int[] iArr) {
        int i5 = 0;
        boolean z4 = false;
        while (true) {
            ArrayList arrayList = this.f2766b;
            if (i5 >= arrayList.size()) {
                return z4;
            }
            z4 |= ((i) arrayList.get(i5)).b(iArr);
            i5++;
        }
    }

    public final void c() {
        Matrix matrix = this.f2774j;
        matrix.reset();
        matrix.postTranslate(-this.f2768d, -this.f2769e);
        matrix.postScale(this.f2770f, this.f2771g);
        matrix.postRotate(this.f2767c, 0.0f, 0.0f);
        matrix.postTranslate(this.f2772h + this.f2768d, this.f2773i + this.f2769e);
    }

    public String getGroupName() {
        return this.f2776l;
    }

    public Matrix getLocalMatrix() {
        return this.f2774j;
    }

    public float getPivotX() {
        return this.f2768d;
    }

    public float getPivotY() {
        return this.f2769e;
    }

    public float getRotation() {
        return this.f2767c;
    }

    public float getScaleX() {
        return this.f2770f;
    }

    public float getScaleY() {
        return this.f2771g;
    }

    public float getTranslateX() {
        return this.f2772h;
    }

    public float getTranslateY() {
        return this.f2773i;
    }

    public void setPivotX(float f5) {
        if (f5 != this.f2768d) {
            this.f2768d = f5;
            c();
        }
    }

    public void setPivotY(float f5) {
        if (f5 != this.f2769e) {
            this.f2769e = f5;
            c();
        }
    }

    public void setRotation(float f5) {
        if (f5 != this.f2767c) {
            this.f2767c = f5;
            c();
        }
    }

    public void setScaleX(float f5) {
        if (f5 != this.f2770f) {
            this.f2770f = f5;
            c();
        }
    }

    public void setScaleY(float f5) {
        if (f5 != this.f2771g) {
            this.f2771g = f5;
            c();
        }
    }

    public void setTranslateX(float f5) {
        if (f5 != this.f2772h) {
            this.f2772h = f5;
            c();
        }
    }

    public void setTranslateY(float f5) {
        if (f5 != this.f2773i) {
            this.f2773i = f5;
            c();
        }
    }

    public h() {
        this.f2765a = new Matrix();
        this.f2766b = new ArrayList();
        this.f2767c = 0.0f;
        this.f2768d = 0.0f;
        this.f2769e = 0.0f;
        this.f2770f = 1.0f;
        this.f2771g = 1.0f;
        this.f2772h = 0.0f;
        this.f2773i = 0.0f;
        this.f2774j = new Matrix();
        this.f2776l = null;
    }
}

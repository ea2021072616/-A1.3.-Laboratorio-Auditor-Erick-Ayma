package f1;
/* loaded from: classes.dex */
public abstract class j extends i {

    /* renamed from: a  reason: collision with root package name */
    public z.f[] f2777a;

    /* renamed from: b  reason: collision with root package name */
    public String f2778b;

    /* renamed from: c  reason: collision with root package name */
    public int f2779c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2780d;

    public j() {
        this.f2777a = null;
        this.f2779c = 0;
    }

    public z.f[] getPathData() {
        return this.f2777a;
    }

    public String getPathName() {
        return this.f2778b;
    }

    public void setPathData(z.f[] fVarArr) {
        if (!p2.a.g(this.f2777a, fVarArr)) {
            this.f2777a = p2.a.r(fVarArr);
            return;
        }
        z.f[] fVarArr2 = this.f2777a;
        for (int i5 = 0; i5 < fVarArr.length; i5++) {
            fVarArr2[i5].f5754a = fVarArr[i5].f5754a;
            int i6 = 0;
            while (true) {
                float[] fArr = fVarArr[i5].f5755b;
                if (i6 < fArr.length) {
                    fVarArr2[i5].f5755b[i6] = fArr[i6];
                    i6++;
                }
            }
        }
    }

    public j(j jVar) {
        this.f2777a = null;
        this.f2779c = 0;
        this.f2778b = jVar.f2778b;
        this.f2780d = jVar.f2780d;
        this.f2777a = p2.a.r(jVar.f2777a);
    }
}

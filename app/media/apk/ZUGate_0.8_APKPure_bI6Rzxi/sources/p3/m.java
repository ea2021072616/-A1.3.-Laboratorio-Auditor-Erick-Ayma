package p3;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class m extends s {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f4339c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Matrix f4340d;

    public m(ArrayList arrayList, Matrix matrix) {
        this.f4339c = arrayList;
        this.f4340d = matrix;
    }

    @Override // p3.s
    public final void a(Matrix matrix, o3.a aVar, int i5, Canvas canvas) {
        for (s sVar : this.f4339c) {
            sVar.a(this.f4340d, aVar, i5, canvas);
        }
    }
}

package m1;

import android.graphics.Color;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class b extends g implements q1.a {

    /* renamed from: t  reason: collision with root package name */
    public int f3927t;

    /* renamed from: u  reason: collision with root package name */
    public int f3928u;

    /* renamed from: v  reason: collision with root package name */
    public final int f3929v;

    /* renamed from: w  reason: collision with root package name */
    public final int f3930w;

    /* renamed from: x  reason: collision with root package name */
    public int f3931x;

    /* renamed from: y  reason: collision with root package name */
    public final String[] f3932y;

    public b(String str, ArrayList arrayList) {
        super(str, arrayList);
        this.f3927t = Color.rgb(255, 187, 115);
        this.f3928u = 1;
        this.f3929v = Color.rgb(215, 215, 215);
        this.f3930w = -16777216;
        this.f3931x = 120;
        this.f3932y = new String[]{"Stack"};
        this.f3927t = Color.rgb(0, 0, 0);
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            ((c) arrayList.get(i5)).getClass();
        }
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            ((c) arrayList.get(i6)).getClass();
        }
    }
}

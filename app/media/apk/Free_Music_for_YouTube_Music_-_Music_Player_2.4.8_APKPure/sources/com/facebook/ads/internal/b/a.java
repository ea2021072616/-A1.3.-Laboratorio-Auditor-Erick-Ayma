package com.facebook.ads.internal.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.facebook.ads.internal.util.ad;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class a implements ad<Bundle> {

    /* renamed from: a  reason: collision with root package name */
    private final View f1239a;

    /* renamed from: b  reason: collision with root package name */
    private final List<d> f1240b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f1241c;
    private c d;

    public a(Context context, View view, List<b> list) {
        this.f1241c = context;
        this.f1239a = view;
        this.f1240b = new ArrayList(list.size());
        for (b bVar : list) {
            this.f1240b.add(new d(bVar));
        }
        this.d = new c();
    }

    public a(Context context, View view, List<b> list, Bundle bundle) {
        this.f1241c = context;
        this.f1239a = view;
        this.f1240b = new ArrayList(list.size());
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("TESTS");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.d = (c) bundle.getSerializable("STATISTICS");
                return;
            } else {
                this.f1240b.add(new d(list.get(i2), (Bundle) parcelableArrayList.get(i2)));
                i = i2 + 1;
            }
        }
    }

    public void a() {
        this.d.a();
    }

    public void a(double d, double d2) {
        if (d2 >= 0.0d) {
            this.d.b(d, d2);
        }
        double a2 = e.a(this.f1239a, this.f1241c);
        this.d.a(d, a2);
        for (d dVar : this.f1240b) {
            dVar.a(d, a2);
        }
    }

    public c b() {
        return this.d;
    }

    @Override // com.facebook.ads.internal.util.ad
    public Bundle getSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("STATISTICS", this.d);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.f1240b.size());
        for (d dVar : this.f1240b) {
            arrayList.add(dVar.getSaveInstanceState());
        }
        bundle.putParcelableArrayList("TESTS", arrayList);
        return bundle;
    }
}

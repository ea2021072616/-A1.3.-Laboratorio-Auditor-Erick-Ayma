package ru.zdevs.zugate.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.github.appintro.R;
import com.github.mikephil.charting.charts.BarChart;
import d.i;
import d.m;
import d.n;
import d.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import m1.g;
import m1.h;
import ru.zdevs.zugate.activity.BenchmarkActivity;
import u4.d;
import u4.e;
import u4.f;
import x4.b;
import x4.c;
import x4.k;
import x4.l;
/* loaded from: classes.dex */
public class BenchmarkActivity extends q implements b {

    /* renamed from: k  reason: collision with root package name */
    public static final String[] f4574k = {"sha1", "sha256", "sha512", "ripemd160", "argon2i", "whirlpool"};

    /* renamed from: l  reason: collision with root package name */
    public static final int[] f4575l = {256, 256, 256, 256, 256, 256};

    /* renamed from: m  reason: collision with root package name */
    public static final String[] f4576m = {"SW", "HW"};

    /* renamed from: n  reason: collision with root package name */
    public static final int[] f4577n = {R.attr.colorChartSW, R.attr.colorChartHW};
    public static final String[] o = {"aes", "serpent", "twofish", "camellia", "blowfish", "kuznech"};

    /* renamed from: p  reason: collision with root package name */
    public static final int[] f4578p = {32, 32, 32, 32, 16, 32};

    /* renamed from: q  reason: collision with root package name */
    public static final String[] f4579q = {"SW", "HW"};

    /* renamed from: r  reason: collision with root package name */
    public static final int[] f4580r = {R.attr.colorChartSW, R.attr.colorChartHW};

    /* renamed from: s  reason: collision with root package name */
    public static final String[] f4581s = {"sha1", "sha256", "sha512"};

    /* renamed from: g  reason: collision with root package name */
    public final List f4582g = Collections.synchronizedList(new ArrayList(2));

    /* renamed from: h  reason: collision with root package name */
    public final c f4583h = new c();

    /* renamed from: i  reason: collision with root package name */
    public n f4584i = null;

    /* renamed from: j  reason: collision with root package name */
    public boolean f4585j = false;

    public static void k(Bundle bundle, BarChart barChart, String str) {
        m1.a aVar;
        if (barChart == null || (aVar = (m1.a) barChart.getData()) == null) {
            return;
        }
        int d5 = aVar.d();
        bundle.putInt(str.concat("DSC"), d5);
        for (int i5 = 0; i5 < d5; i5++) {
            m1.b bVar = (m1.b) aVar.c(i5);
            if (bVar != null) {
                List list = bVar.o;
                int size = list.size();
                bundle.putInt(str + "S" + i5 + "VC", size);
                for (int i6 = 0; i6 < size; i6++) {
                    bundle.putFloat(str + "S" + i5 + "V" + i6, ((m1.c) list.get(i6)).f3933b);
                }
            }
        }
    }

    public static void l(Bundle bundle, BarChart barChart, String str) {
        int d5;
        m1.a aVar = (m1.a) barChart.getData();
        if (aVar != null && (d5 = aVar.d()) == bundle.getInt(str.concat("DSC"))) {
            for (int i5 = 0; i5 < d5; i5++) {
                m1.b bVar = (m1.b) aVar.c(i5);
                if (bVar != null) {
                    List list = bVar.o;
                    int size = list.size();
                    if (size == bundle.getInt(str + "S" + i5 + "VC")) {
                        for (int i6 = 0; i6 < size; i6++) {
                            ((m1.c) list.get(i6)).f3933b = bundle.getFloat(str + "S" + i5 + "V" + i6);
                        }
                        bVar.a();
                    }
                }
            }
            aVar.a();
            barChart.d();
            barChart.invalidate();
        }
    }

    @Override // x4.b
    public final void a(x4.a aVar) {
        int a5 = aVar.a();
        if (a5 == 0) {
            i((BarChart) findViewById(R.id.chart), f4576m, f4577n);
            i((BarChart) findViewById(R.id.chart2), f4579q, f4580r);
        } else if (a5 == 1) {
            d dVar = (d) aVar;
            BarChart barChart = (BarChart) findViewById(R.id.chart);
            m1.a aVar2 = (m1.a) barChart.getData();
            if (aVar2 == null) {
                return;
            }
            m1.b bVar = (m1.b) aVar2.c(0);
            m1.b bVar2 = (m1.b) aVar2.c(1);
            List list = bVar.o;
            int i5 = dVar.f5151a;
            ((m1.c) list.get(i5)).f3933b = dVar.f5152b;
            ((m1.c) bVar2.o.get(i5)).f3933b = dVar.f5153c;
            bVar.a();
            bVar2.a();
            aVar2.a();
            barChart.d();
            barChart.invalidate();
        } else if (a5 != 2) {
            if (a5 == 3) {
                f fVar = (f) aVar;
                n nVar = this.f4584i;
                if (nVar == null) {
                    return;
                }
                ((TextView) nVar.findViewById(R.id.text)).setText(fVar.f5156b);
                ((ProgressBar) this.f4584i.findViewById(R.id.progress_horizontal)).setProgress(fVar.f5155a);
            } else if (a5 != 4) {
            } else {
                n nVar2 = this.f4584i;
                if (nVar2 != null) {
                    nVar2.dismiss();
                    this.f4584i = null;
                }
                this.f4585j = ((e) aVar).f5154a;
            }
        } else {
            u4.c cVar = (u4.c) aVar;
            BarChart barChart2 = (BarChart) findViewById(R.id.chart2);
            m1.a aVar3 = (m1.a) barChart2.getData();
            if (aVar3 == null) {
                return;
            }
            m1.b bVar3 = (m1.b) aVar3.c(0);
            m1.b bVar4 = (m1.b) aVar3.c(1);
            List list2 = bVar3.o;
            int i6 = cVar.f5148a;
            ((m1.c) list2.get(i6)).f3933b = cVar.f5149b;
            ((m1.c) bVar4.o.get(i6)).f3933b = cVar.f5150c;
            bVar3.a();
            bVar4.a();
            aVar3.a();
            barChart2.d();
            barChart2.invalidate();
        }
    }

    public final void h() {
        this.f4585j = false;
        m mVar = new m(this);
        mVar.e(R.string.benchmarking);
        Object obj = mVar.f2398h;
        i iVar = (i) obj;
        iVar.f2357t = null;
        iVar.f2356s = R.layout.dlg_progress;
        ((i) obj).f2351m = false;
        mVar.b(R.string.cancel, new DialogInterface.OnClickListener() { // from class: u4.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                x4.l[] lVarArr;
                String[] strArr = BenchmarkActivity.f4574k;
                BenchmarkActivity benchmarkActivity = BenchmarkActivity.this;
                for (x4.l lVar : (x4.l[]) benchmarkActivity.f4582g.toArray(new x4.l[0])) {
                    if (lVar != null) {
                        lVar.f5535d.set(true);
                        x4.k kVar = lVar.f5533b;
                        if (kVar != null) {
                            kVar.cancel(true);
                        }
                        List list = lVar.f5534c;
                        if (list != null) {
                            list.remove(lVar);
                        }
                    }
                }
                n nVar = benchmarkActivity.f4584i;
                if (nVar == null) {
                    return;
                }
                nVar.dismiss();
                benchmarkActivity.f4584i = null;
            }
        });
        n a5 = mVar.a();
        this.f4584i = a5;
        a5.show();
        ((ProgressBar) this.f4584i.findViewById(R.id.progress_horizontal)).setMax(12);
        new u4.b(this.f4582g).b(null, this.f4583h);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [q1.b] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [m1.g] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.github.mikephil.charting.charts.BarChart, k1.a, android.view.View, k1.c] */
    public final void i(BarChart barChart, String[] strArr, int[] iArr) {
        m1.c cVar;
        m1.b bVar = null;
        barChart.f3542h = null;
        barChart.D = false;
        barChart.E = null;
        barChart.f3552s.f4484h = null;
        barChart.invalidate();
        m1.a aVar = new m1.a();
        aVar.f3926j = 0.9f / strArr.length;
        barChart.setData(aVar);
        ArrayList[] arrayListArr = new ArrayList[strArr.length];
        for (int i5 = 0; i5 < strArr.length; i5++) {
            arrayListArr[i5] = new ArrayList(6);
            for (int i6 = 0; i6 < 6; i6++) {
                arrayListArr[i5].add(new m1.c(i6));
            }
        }
        n1.c cVar2 = new n1.c();
        int m5 = e4.e.m(this, 16842806);
        for (int i7 = 0; i7 < strArr.length; i7++) {
            m1.b bVar2 = new m1.b(strArr[i7], arrayListArr[i7]);
            ArrayList arrayList = bVar2.f3945b;
            arrayList.clear();
            arrayList.add(Integer.valueOf(m5));
            bVar2.f3949f = cVar2;
            int m6 = e4.e.m(this, iArr[i7]);
            if (bVar2.f3944a == null) {
                bVar2.f3944a = new ArrayList();
            }
            bVar2.f3944a.clear();
            bVar2.f3944a.add(Integer.valueOf(m6));
            bVar2.f3931x = 0;
            aVar.b(bVar2);
            aVar.f3943i.add(bVar2);
        }
        aVar.a();
        if (barChart.getBarData() == null) {
            throw new RuntimeException("You need to set data for the chart before grouping bars.");
        }
        m1.a barData = barChart.getBarData();
        ArrayList arrayList2 = barData.f3943i;
        if (arrayList2.size() <= 1) {
            throw new RuntimeException("BarData needs to hold at least 2 BarDataSets to allow grouping.");
        }
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            bVar = (q1.b) arrayList2.get(0);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                g gVar = (g) ((q1.b) it.next());
                bVar = (g) bVar;
                if (gVar.c() > bVar.c()) {
                    bVar = gVar;
                }
            }
        }
        int c5 = bVar.c();
        float f5 = barData.f3926j / 2.0f;
        float size = ((barData.f3926j + 0.02f) * arrayList2.size()) + 0.06f;
        float f6 = 0.0f;
        for (int i8 = 0; i8 < c5; i8++) {
            float f7 = f6 + 0.03f;
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                m1.b bVar3 = (m1.b) it2.next();
                float f8 = f7 + 0.01f + f5;
                if (i8 < bVar3.c() && (cVar = (m1.c) ((h) bVar3.o.get(i8))) != null) {
                    cVar.f3962d = f8;
                }
                f7 = f8 + f5 + 0.01f;
            }
            float f9 = f7 + 0.03f;
            float f10 = size - (f9 - f6);
            if (f10 > 0.0f || f10 < 0.0f) {
                f9 += f10;
            }
            f6 = f9;
        }
        barData.a();
        barChart.d();
        barChart.d();
        barChart.invalidate();
    }

    public final void j(BarChart barChart) {
        barChart.setPinchZoom(false);
        barChart.setDrawBarShadow(false);
        barChart.setDrawGridBackground(false);
        barChart.setFitBars(true);
        barChart.setDoubleTapToZoomEnabled(false);
        barChart.getDescription().f3735f = "";
        int m5 = e4.e.m(this, 16842806);
        l1.g xAxis = barChart.getXAxis();
        xAxis.f3719p = 1.0f;
        xAxis.f3720q = true;
        xAxis.f3724u = true;
        xAxis.f3721r = false;
        xAxis.E = 2;
        xAxis.f3734e = m5;
        l1.h axisLeft = barChart.getAxisLeft();
        axisLeft.f3721r = false;
        axisLeft.f3729z = true;
        axisLeft.B = 0.0f;
        axisLeft.C = Math.abs(axisLeft.A - 0.0f);
        axisLeft.f3734e = m5;
        barChart.getAxisRight().f3730a = false;
        l1.e legend = barChart.getLegend();
        legend.f3734e = m5;
        legend.f3739h = 1;
        legend.f3738g = 3;
        legend.f3740i = 2;
        legend.f3741j = true;
    }

    @Override // androidx.fragment.app.d0, androidx.activity.ComponentActivity, w.o, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_benchmark);
        d.b supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.m(true);
        }
        BarChart barChart = (BarChart) findViewById(R.id.chart);
        barChart.getXAxis().f3710f = new n1.b(f4574k);
        barChart.getAxisLeft().f3710f = new n1.c();
        j(barChart);
        BarChart barChart2 = (BarChart) findViewById(R.id.chart2);
        barChart2.getXAxis().f3710f = new n1.b(o);
        j(barChart2);
        if (bundle != null) {
            boolean z4 = bundle.getBoolean("isValid");
            this.f4585j = z4;
            if (z4) {
                BarChart barChart3 = (BarChart) findViewById(R.id.chart);
                i(barChart3, f4576m, f4577n);
                l(bundle, barChart3, "c1");
                BarChart barChart4 = (BarChart) findViewById(R.id.chart2);
                i(barChart4, f4579q, f4580r);
                l(bundle, barChart4, "c2");
            }
        }
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_benchmark, menu);
        return true;
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        } else if (menuItem.getItemId() == R.id.refresh) {
            h();
            return true;
        } else {
            return false;
        }
    }

    @Override // androidx.activity.ComponentActivity, w.o, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("isValid", this.f4585j);
        if (this.f4585j) {
            k(bundle, (BarChart) findViewById(R.id.chart), "c1");
            k(bundle, (BarChart) findViewById(R.id.chart2), "c2");
        }
    }

    @Override // d.q, androidx.fragment.app.d0, android.app.Activity
    public final void onStart() {
        super.onStart();
        this.f4583h.a(this);
        if (this.f4585j) {
            return;
        }
        h();
    }

    @Override // d.q, androidx.fragment.app.d0, android.app.Activity
    public final void onStop() {
        l[] lVarArr;
        super.onStop();
        c cVar = this.f4583h;
        cVar.f5514c.remove(this);
        cVar.f5512a = cVar.f5514c.isEmpty();
        for (l lVar : (l[]) this.f4582g.toArray(new l[0])) {
            if (lVar != null) {
                lVar.f5535d.set(true);
                k kVar = lVar.f5533b;
                if (kVar != null) {
                    kVar.cancel(true);
                }
                List list = lVar.f5534c;
                if (list != null) {
                    list.remove(lVar);
                }
            }
        }
        n nVar = this.f4584i;
        if (nVar == null) {
            return;
        }
        nVar.dismiss();
        this.f4584i = null;
    }
}

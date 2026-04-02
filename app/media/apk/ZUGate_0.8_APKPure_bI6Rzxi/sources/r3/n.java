package r3;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.github.appintro.R;
import ru.zdevs.zugate.MainActivity;
/* loaded from: classes.dex */
public final /* synthetic */ class n implements View.OnClickListener {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f4539g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f4540h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f4541i;

    public /* synthetic */ n(Object obj, int i5, Object obj2) {
        this.f4539g = i5;
        this.f4540h = obj;
        this.f4541i = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i5 = this.f4539g;
        Object obj = this.f4541i;
        Object obj2 = this.f4540h;
        switch (i5) {
            case 0:
                o oVar = (o) obj2;
                oVar.getClass();
                ((View.OnClickListener) obj).onClick(view);
                oVar.a(1);
                return;
            case 1:
                MainActivity mainActivity = (MainActivity) obj2;
                t4.k kVar = (t4.k) obj;
                int i6 = MainActivity.f4551q;
                mainActivity.getClass();
                t4.a aVar = kVar.f5064a;
                d.m mVar = new d.m(mainActivity);
                String str = aVar.f5028b;
                Object obj3 = mVar.f2398h;
                ((d.i) obj3).f2342d = str;
                View inflate = mainActivity.getLayoutInflater().inflate(R.layout.dlg_error_detail, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.text)).setText(kVar.f5065b);
                String str2 = kVar.f5066c;
                ((TextView) inflate.findViewById(R.id.text2)).setText(str2);
                mVar.f(inflate);
                mVar.d(R.string.ok, null);
                t4.b bVar = new t4.b(1);
                d.i iVar = (d.i) obj3;
                iVar.f2349k = iVar.f2339a.getText(R.string.copy);
                iVar.f2350l = bVar;
                d.n a5 = mVar.a();
                a5.setOnShowListener(new t4.c(mainActivity, aVar, str2, 1));
                a5.show();
                return;
            default:
                d.n nVar = (d.n) obj;
                String[] strArr = u4.j.f5164y;
                if (((u4.j) obj2).k()) {
                    nVar.dismiss();
                    return;
                }
                return;
        }
    }
}
